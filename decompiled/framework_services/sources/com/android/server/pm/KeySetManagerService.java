package com.android.server.pm;

import android.content.pm.parsing.FrameworkParsingPackageUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.Slog;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.utils.WatchedArrayMap;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class KeySetManagerService {
    public static final int CURRENT_VERSION = 1;
    public static final int FIRST_VERSION = 1;
    public static final long KEYSET_NOT_FOUND = -1;
    protected static final long PUBLIC_KEY_NOT_FOUND = -1;
    static final String TAG = "KeySetManagerService";
    private long lastIssuedKeyId;
    private long lastIssuedKeySetId;
    protected final LongSparseArray<ArraySet<Long>> mKeySetMapping;
    private final LongSparseArray<KeySetHandle> mKeySets;
    private final WatchedArrayMap<String, PackageSetting> mPackages;
    private final LongSparseArray<PublicKeyHandle> mPublicKeys;

    class PublicKeyHandle {
        private final long mId;
        private final PublicKey mKey;
        private int mRefCount;

        /* synthetic */ PublicKeyHandle(KeySetManagerService r1, long r2, int r4, PublicKey r5, KeySetManagerServiceIA r6) {
            this(r1, r2, r4, r5);
        }

        public PublicKeyHandle(KeySetManagerService this$0, long id, PublicKey key) {
            this.mId = id;
            this.mRefCount = 1;
            this.mKey = key;
        }

        private PublicKeyHandle(KeySetManagerService this$0, long id, int refCount, PublicKey key) {
            this.mId = id;
            this.mRefCount = refCount;
            this.mKey = key;
        }

        public long getId() {
            return this.mId;
        }

        public PublicKey getKey() {
            return this.mKey;
        }

        public int getRefCountLPr() {
            return this.mRefCount;
        }

        public void incrRefCountLPw() {
            this.mRefCount++;
        }

        public long decrRefCountLPw() {
            this.mRefCount--;
            return this.mRefCount;
        }
    }

    public KeySetManagerService(WatchedArrayMap<String, PackageSetting> packages) {
        this.lastIssuedKeySetId = 0;
        this.lastIssuedKeyId = 0;
        this.mKeySets = new LongSparseArray();
        this.mPublicKeys = new LongSparseArray();
        this.mKeySetMapping = new LongSparseArray();
        this.mPackages = packages;
    }

    public KeySetManagerService(KeySetManagerService other, WatchedArrayMap<String, PackageSetting> packages) {
        this.lastIssuedKeySetId = 0;
        this.lastIssuedKeyId = 0;
        this.mKeySets = other.mKeySets.clone();
        this.mPublicKeys = other.mPublicKeys.clone();
        this.mKeySetMapping = other.mKeySetMapping.clone();
        this.mPackages = packages;
    }

    public boolean packageIsSignedByLPr(String packageName, KeySetHandle ks) {
        PackageSetting pkg = this.mPackages.get(packageName);
        if (pkg == null) goto L15;
        if (pkg.getKeySetData() == null) goto L13;
        long id = getIdByKeySetLPr(ks);
        if (id != (-1)) goto L10;
        return false;
    L10:
        ArraySet<Long> pkgKeys = this.mKeySetMapping.get(pkg.getKeySetData().getProperSigningKeySet());
        ArraySet<Long> testKeys = this.mKeySetMapping.get(id);
        return pkgKeys.containsAll(testKeys);
    L13:
        throw new NullPointerException("Package has no KeySet data");
    L15:
        throw new NullPointerException("Invalid package name");
    }

    public boolean packageIsSignedByExactlyLPr(String packageName, KeySetHandle ks) {
        PackageSetting pkg = this.mPackages.get(packageName);
        if (pkg == null) goto L17;
        if (pkg.getKeySetData() == null) goto L15;
        if (pkg.getKeySetData().getProperSigningKeySet() == (-1)) goto L15;
        long id = getIdByKeySetLPr(ks);
        if (id != (-1)) goto L12;
        return false;
    L12:
        ArraySet<Long> pkgKeys = this.mKeySetMapping.get(pkg.getKeySetData().getProperSigningKeySet());
        ArraySet<Long> testKeys = this.mKeySetMapping.get(id);
        return pkgKeys.equals(testKeys);
    L15:
        throw new NullPointerException("Package has no KeySet data");
    L17:
        throw new NullPointerException("Invalid package name");
    }

    public void assertScannedPackageValid(AndroidPackage pkg) throws PackageManagerException {
        if (pkg == null) goto L42;
        if (pkg.getPackageName() == null) goto L42;
        ArraySet<PublicKey> signingKeys = pkg.getSigningDetails().getPublicKeys();
        if (signingKeys == null) goto L40;
        if (signingKeys.size() <= 0) goto L40;
        if (signingKeys.contains(null) == true) goto L40;
        Map<String, ArraySet<PublicKey>> definedMapping = pkg.getKeySetMapping();
        if (definedMapping != null) goto L15;
    L30:
        Set<String> upgradeAliases = pkg.getUpgradeKeySets();
        if (upgradeAliases == null) goto L38;
        if (definedMapping == null) goto L37;
        if (definedMapping.keySet().containsAll(upgradeAliases) == false) goto L37;
        return;
    L37:
        throw new PackageManagerException(-2, "Package has upgrade-key-sets without corresponding definitions.");
    L38:
        return;
    L15:
        if (definedMapping.containsKey(null) == true) goto L29;
        if (definedMapping.containsValue(null) == true) goto L29;
        Iterator<ArraySet<PublicKey>> r4 = definedMapping.values().iterator();
    L20:
        if (r4.hasNext() == false) goto L30;
        ArraySet<PublicKey> value = r4.next();
        if (value.size() <= 0) goto L27;
        if (value.contains(null) == false) goto L20;
    L27:
        throw new PackageManagerException(-2, "Package has null/no public keys for defined key-sets.");
    L29:
        throw new PackageManagerException(-2, "Package has null defined key set.");
    L40:
        throw new PackageManagerException(-2, "Package has invalid signing-key-set.");
    L42:
        throw new PackageManagerException(-2, "Passed invalid package to keyset validation.");
    }

    public void addScannedPackageLPw(AndroidPackage pkg) {
        pkg.getClass();
        pkg.getPackageName().getClass();
        PackageSetting ps = this.mPackages.get(pkg.getPackageName());
        String r0 = "pkg: " + pkg.getPackageName() + "does not have a corresponding entry in mPackages.";
        ps.getClass();
        addSigningKeySetToPackageLPw(ps, pkg.getSigningDetails().getPublicKeys());
        if (pkg.getKeySetMapping() == null) goto L8;
        addDefinedKeySetsToPackageLPw(ps, pkg.getKeySetMapping());
        if (pkg.getUpgradeKeySets() == null) goto L9;
        addUpgradeKeySetsToPackageLPw(ps, pkg.getUpgradeKeySets());
        return;
    L9:
        return;
    }

    void addSigningKeySetToPackageLPw(PackageSetting pkg, ArraySet<PublicKey> signingKeys) {
        long signingKeySetId = pkg.getKeySetData().getProperSigningKeySet();
        if (signingKeySetId == (-1)) goto L10;
        ArraySet<PublicKey> existingKeys = getPublicKeysFromKeySetLPr(signingKeySetId);
        if (existingKeys != null) goto L7;
    L9:
        decrementKeySetLPw(signingKeySetId);
        goto L10
    L7:
        if (existingKeys.equals(signingKeys) == false) goto L9;
        return;
    L10:
        KeySetHandle ks = addKeySetLPw(signingKeys);
        long id = ks.getId();
        pkg.getKeySetData().setProperSigningKeySet(id);
    }

    private long getIdByKeySetLPr(KeySetHandle ks) {
        int keySetIndex = 0;
    L4:
        if (keySetIndex >= this.mKeySets.size()) goto L10;
        KeySetHandle value = this.mKeySets.valueAt(keySetIndex);
        if (ks.equals(value) == true) goto L8;
        keySetIndex = keySetIndex + 1;
        goto L4
    L8:
        return this.mKeySets.keyAt(keySetIndex);
    L10:
        return -1;
    }

    void addDefinedKeySetsToPackageLPw(PackageSetting pkg, Map<String, ArraySet<PublicKey>> definedMapping) {
        ArrayMap<String, Long> prevDefinedKeySets = pkg.getKeySetData().getAliases();
        Map<String, Long> newKeySetAliases = new ArrayMap();
        Iterator<Map.Entry<String, ArraySet<PublicKey>>> r2 = definedMapping.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, ArraySet<PublicKey>> entry = r2.next();
        String alias = entry.getKey();
        ArraySet<PublicKey> pubKeys = entry.getValue();
        if (alias == null) goto L4;
        if (pubKeys == null) goto L4;
        if (pubKeys.size() <= 0) goto L4;
        KeySetHandle ks = addKeySetLPw(pubKeys);
        newKeySetAliases.put(alias, Long.valueOf(ks.getId()));
        goto L4
    L12:
        int prevDefSize = prevDefinedKeySets.size();
        int i = 0;
    L13:
        if (i >= prevDefSize) goto L15;
        decrementKeySetLPw(prevDefinedKeySets.valueAt(i).longValue());
        i = i + 1;
        goto L13
    L15:
        pkg.getKeySetData().removeAllUpgradeKeySets();
        pkg.getKeySetData().setAliases(newKeySetAliases);
    }

    void addUpgradeKeySetsToPackageLPw(PackageSetting pkg, Set<String> upgradeAliases) {
        Iterator<String> r0 = upgradeAliases.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String upgradeAlias = r0.next();
        pkg.getKeySetData().addUpgradeKeySet(upgradeAlias);
        goto L4
    }

    public KeySetHandle getKeySetByAliasAndPackageNameLPr(String packageName, String alias) {
        PackageSetting p = this.mPackages.get(packageName);
        if (p != null) goto L5;
        return null;
    L5:
        if (p.getKeySetData() == null) goto L15;
        ArrayMap<String, Long> aliases = p.getKeySetData().getAliases();
        Long keySetId = aliases.get(alias);
        if (keySetId == null) goto L12;
        return this.mKeySets.get(keySetId.longValue());
    L12:
        throw new IllegalArgumentException("Unknown KeySet alias: " + alias + ", aliases = " + aliases);
    L15:
        return null;
    }

    public boolean isIdValidKeySetId(long id) {
        if (this.mKeySets.get(id) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean shouldCheckUpgradeKeySetLocked(PackageStateInternal oldPs, SharedUserApi sharedUserSetting, int scanFlags) {
        if (oldPs != null) goto L5;
    L24:
        return false;
    L5:
        if ((scanFlags & 512) != 0) goto L24;
        if (sharedUserSetting != null) goto L24;
        if (oldPs.getKeySetData().isUsingUpgradeKeySets() == false) goto L24;
        long[] upgradeKeySets = oldPs.getKeySetData().getUpgradeKeySets();
        int i = 0;
    L12:
        if (i >= upgradeKeySets.length) goto L22;
        if (isIdValidKeySetId(upgradeKeySets[i]) == false) goto L15;
        i = i + 1;
        goto L12
    L15:
        StringBuilder r3 = new StringBuilder();
        r3.append("Package ");
        if (oldPs.getPackageName() == null) goto L18;
        String r4 = oldPs.getPackageName();
    L19:
        r3.append(r4);
        r3.append(" contains upgrade-key-set reference to unknown key-set: ");
        r3.append(upgradeKeySets[i]);
        r3.append(" reverting to signatures check.");
        Slog.wtf(TAG, r3.toString());
        return false;
    L18:
        r4 = "<null>";
        goto L19
    L22:
        return true;
    }

    public boolean checkUpgradeKeySetLocked(PackageStateInternal oldPS, AndroidPackage pkg) {
        long[] upgradeKeySets = oldPS.getKeySetData().getUpgradeKeySets();
        int i = 0;
    L4:
        if (i >= upgradeKeySets.length) goto L12;
        Set<PublicKey> upgradeSet = getPublicKeysFromKeySetLPr(upgradeKeySets[i]);
        if (upgradeSet == null) goto L11;
        if (pkg.getSigningDetails().getPublicKeys().containsAll(upgradeSet) == false) goto L11;
        return true;
    L11:
        i = i + 1;
        goto L4
    L12:
        return false;
    }

    public ArraySet<PublicKey> getPublicKeysFromKeySetLPr(long id) {
        ArraySet<Long> pkIds = this.mKeySetMapping.get(id);
        if (pkIds != null) goto L6;
        return null;
    L6:
        ArraySet<PublicKey> mPubKeys = new ArraySet();
        int pkSize = pkIds.size();
        int i = 0;
    L7:
        if (i >= pkSize) goto L14;
        long pkId = pkIds.valueAt(i).longValue();
        PublicKeyHandle pkh = this.mPublicKeys.get(pkId);
        if (pkh != null) goto L11;
        Slog.e(TAG, "Dangling public-key reference while reading keyset " + id + ": public-key id " + pkId + " missing from mPublicKeys; skipping.");
    L12:
        i = i + 1;
        goto L7
    L11:
        mPubKeys.add(pkh.getKey());
        goto L12
    L14:
        return mPubKeys;
    }

    public KeySetHandle getSigningKeySetByPackageNameLPr(String packageName) {
        PackageSetting p = this.mPackages.get(packageName);
        if (p != null) goto L5;
        return null;
    L5:
        if (p.getKeySetData() != null) goto L7;
        return null;
    L7:
        if (p.getKeySetData().getProperSigningKeySet() != (-1)) goto L10;
        return null;
    L10:
        return this.mKeySets.get(p.getKeySetData().getProperSigningKeySet());
    }

    private KeySetHandle addKeySetLPw(ArraySet<PublicKey> keys) {
        if (keys == null) goto L18;
        if (keys.size() == 0) goto L18;
        ArraySet<Long> addedKeyIds = new ArraySet(keys.size());
        int kSize = keys.size();
        int i = 0;
    L6:
        if (i >= kSize) goto L8;
        addedKeyIds.add(Long.valueOf(addPublicKeyLPw(keys.valueAt(i))));
        i = i + 1;
        goto L6
    L8:
        long existingKeySetId = getIdFromKeyIdsLPr(addedKeyIds);
        if (existingKeySetId == (-1)) goto L15;
        int i2 = 0;
    L11:
        if (i2 >= kSize) goto L13;
        decrementPublicKeyLPw(addedKeyIds.valueAt(i2).longValue());
        i2 = i2 + 1;
        goto L11
    L13:
        KeySetHandle ks = this.mKeySets.get(existingKeySetId);
        ks.incrRefCountLPw();
        return ks;
    L15:
        long id = getFreeKeySetIDLPw();
        KeySetHandle ks2 = new KeySetHandle(id);
        this.mKeySets.put(id, ks2);
        this.mKeySetMapping.put(id, addedKeyIds);
        return ks2;
    L18:
        throw new IllegalArgumentException("Cannot add an empty set of keys!");
    }

    private void decrementKeySetLPw(long id) {
        KeySetHandle ks = this.mKeySets.get(id);
        if (ks != null) goto L6;
        return;
    L6:
        if (ks.decrRefCountLPw() > 0) goto L13;
        ArraySet<Long> pubKeys = this.mKeySetMapping.get(id);
        int pkSize = pubKeys.size();
        int i = 0;
    L8:
        if (i >= pkSize) goto L10;
        decrementPublicKeyLPw(pubKeys.valueAt(i).longValue());
        i = i + 1;
        goto L8
    L10:
        this.mKeySets.delete(id);
        this.mKeySetMapping.delete(id);
        return;
    }

    private void decrementPublicKeyLPw(long id) {
        PublicKeyHandle pk = this.mPublicKeys.get(id);
        if (pk != null) goto L6;
        return;
    L6:
        if (pk.decrRefCountLPw() > 0) goto L9;
        this.mPublicKeys.delete(id);
        return;
    }

    private long addPublicKeyLPw(PublicKey key) {
        key.getClass();
        long id = getIdForPublicKeyLPr(key);
        if (id == (-1)) goto L6;
        this.mPublicKeys.get(id).incrRefCountLPw();
        return id;
    L6:
        long id2 = getFreePublicKeyIdLPw();
        this.mPublicKeys.put(id2, new PublicKeyHandle(this, id2, key));
        return id2;
    }

    private long getIdFromKeyIdsLPr(Set<Long> publicKeyIds) {
        int keyMapIndex = 0;
    L4:
        if (keyMapIndex >= this.mKeySetMapping.size()) goto L10;
        ArraySet<Long> value = this.mKeySetMapping.valueAt(keyMapIndex);
        if (value.equals(publicKeyIds) == true) goto L8;
        keyMapIndex = keyMapIndex + 1;
        goto L4
    L8:
        return this.mKeySetMapping.keyAt(keyMapIndex);
    L10:
        return -1;
    }

    private long getIdForPublicKeyLPr(PublicKey k) {
        String encodedPublicKey = new String(k.getEncoded());
        int publicKeyIndex = 0;
    L4:
        if (publicKeyIndex >= this.mPublicKeys.size()) goto L10;
        PublicKey value = this.mPublicKeys.valueAt(publicKeyIndex).getKey();
        String encodedExistingKey = new String(value.getEncoded());
        if (encodedPublicKey.equals(encodedExistingKey) == true) goto L8;
        publicKeyIndex = publicKeyIndex + 1;
        goto L4
    L8:
        return this.mPublicKeys.keyAt(publicKeyIndex);
    L10:
        return -1;
    }

    private long getFreeKeySetIDLPw() {
        this.lastIssuedKeySetId++;
        return this.lastIssuedKeySetId;
    }

    private long getFreePublicKeyIdLPw() {
        this.lastIssuedKeyId++;
        return this.lastIssuedKeyId;
    }

    public void removeAppKeySetDataLPw(String packageName) {
        PackageSetting pkg = this.mPackages.get(packageName);
        String r0 = "pkg name: " + packageName + "does not have a corresponding entry in mPackages.";
        pkg.getClass();
        long signingKeySetId = pkg.getKeySetData().getProperSigningKeySet();
        decrementKeySetLPw(signingKeySetId);
        ArrayMap<String, Long> definedKeySets = pkg.getKeySetData().getAliases();
        int i = 0;
    L4:
        if (i >= definedKeySets.size()) goto L6;
        decrementKeySetLPw(definedKeySets.valueAt(i).longValue());
        i = i + 1;
        goto L4
    L6:
        clearPackageKeySetDataLPw(pkg);
    }

    private void clearPackageKeySetDataLPw(PackageSetting pkg) {
        pkg.getKeySetData().setProperSigningKeySet(-1);
        pkg.getKeySetData().removeAllDefinedKeySets();
        pkg.getKeySetData().removeAllUpgradeKeySets();
    }

    @Deprecated
    public String encodePublicKey(PublicKey k) throws IOException {
        return new String(Base64.encode(k.getEncoded(), 2));
    }

    public void dumpLPr(PrintWriter pw, String packageName, DumpState dumpState) {
        String r1 = packageName;
        boolean printedHeader = false;
        Iterator<Map.Entry<String, PackageSetting>> r4 = this.mPackages.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L51;
        Map.Entry<String, PackageSetting> e = r4.next();
        String keySetPackage = e.getKey();
        if (r1 == null) goto L10;
        if (r1.equals(keySetPackage) == false) goto L4;
    L10:
        if (printedHeader == false) goto L12;
    L15:
        PackageSetting pkg = e.getValue();
        pw.print("  [");
        pw.print(keySetPackage);
        pw.println("]");
        if (pkg.getKeySetData() == null) goto L50;
        boolean printedLabel = false;
        Iterator<Map.Entry<String, Long>> r9 = pkg.getKeySetData().getAliases().entrySet().iterator();
    L19:
        if (r9.hasNext() == false) goto L26;
        Map.Entry<String, Long> entry = r9.next();
        if (printedLabel == true) goto L23;
        pw.print("      KeySets Aliases: ");
        printedLabel = true;
    L24:
        pw.print(entry.getKey());
        pw.print('=');
        pw.print(Long.toString(entry.getValue().longValue()));
        goto L19
    L23:
        pw.print(", ");
        goto L24
    L26:
        if (printedLabel == false) goto L28;
        pw.println("");
    L28:
        boolean printedLabel2 = false;
        if (pkg.getKeySetData().isUsingDefinedKeySets() == false) goto L36;
        ArrayMap<String, Long> definedKeySets = pkg.getKeySetData().getAliases();
        int dksSize = definedKeySets.size();
        int i = 0;
    L31:
        if (i >= dksSize) goto L36;
        if (printedLabel2 == true) goto L34;
        pw.print("      Defined KeySets: ");
        printedLabel2 = true;
    L35:
        pw.print(Long.toString(definedKeySets.valueAt(i).longValue()));
        i = i + 1;
        goto L31
    L34:
        pw.print(", ");
    L36:
        if (printedLabel2 == false) goto L38;
        pw.println("");
    L38:
        boolean printedLabel3 = false;
        long signingKeySet = pkg.getKeySetData().getProperSigningKeySet();
        pw.print("      Signing KeySets: ");
        pw.print(Long.toString(signingKeySet));
        pw.println("");
        if (pkg.getKeySetData().isUsingUpgradeKeySets() == false) goto L48;
        long[] r10 = pkg.getKeySetData().getUpgradeKeySets();
        int r14 = r10.length;
        int r15 = 0;
    L42:
        if (r15 >= r14) goto L48;
        long keySetId = r10[r15];
        if (printedLabel3 == true) goto L46;
        pw.print("      Upgrade KeySets: ");
        printedLabel3 = true;
    L47:
        pw.print(Long.toString(keySetId));
        r15 = r15 + 1;
        goto L42
    L46:
        pw.print(", ");
    L48:
        if (printedLabel3 == false) goto L50;
        pw.println("");
    L50:
        r1 = packageName;
        goto L4
    L12:
        if (dumpState.onTitlePrinted() == false) goto L14;
        pw.println();
    L14:
        pw.println("Key Set Manager:");
        printedHeader = true;
        goto L15
    }

    void writeKeySetManagerServiceLPr(TypedXmlSerializer serializer) throws IOException {
        serializer.startTag(null, "keyset-settings");
        serializer.attributeInt(null, "version", 1);
        writePublicKeysLPr(serializer);
        writeKeySetsLPr(serializer);
        serializer.startTag(null, "lastIssuedKeyId");
        serializer.attributeLong(null, "value", this.lastIssuedKeyId);
        serializer.endTag(null, "lastIssuedKeyId");
        serializer.startTag(null, "lastIssuedKeySetId");
        serializer.attributeLong(null, "value", this.lastIssuedKeySetId);
        serializer.endTag(null, "lastIssuedKeySetId");
        serializer.endTag(null, "keyset-settings");
    }

    void writePublicKeysLPr(TypedXmlSerializer serializer) throws IOException {
        serializer.startTag(null, "keys");
        int pKeyIndex = 0;
    L4:
        if (pKeyIndex >= this.mPublicKeys.size()) goto L6;
        long id = this.mPublicKeys.keyAt(pKeyIndex);
        PublicKeyHandle pkh = this.mPublicKeys.valueAt(pKeyIndex);
        serializer.startTag(null, "public-key");
        serializer.attributeLong(null, "identifier", id);
        serializer.attributeBytesBase64(null, "value", pkh.getKey().getEncoded());
        serializer.endTag(null, "public-key");
        pKeyIndex = pKeyIndex + 1;
        goto L4
    L6:
        serializer.endTag(null, "keys");
    }

    void writeKeySetsLPr(TypedXmlSerializer serializer) throws IOException {
        serializer.startTag(null, "keysets");
        int keySetIndex = 0;
    L4:
        if (keySetIndex >= this.mKeySetMapping.size()) goto L10;
        long id = this.mKeySetMapping.keyAt(keySetIndex);
        ArraySet<Long> keys = this.mKeySetMapping.valueAt(keySetIndex);
        serializer.startTag(null, "keyset");
        serializer.attributeLong(null, "identifier", id);
        Iterator<Long> r8 = keys.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        long keyId = r8.next().longValue();
        serializer.startTag(null, "key-id");
        serializer.attributeLong(null, "identifier", keyId);
        serializer.endTag(null, "key-id");
        goto L7
    L9:
        serializer.endTag(null, "keyset");
        keySetIndex = keySetIndex + 1;
        goto L4
    L10:
        serializer.endTag(null, "keysets");
    }

    void readKeySetsLPw(TypedXmlPullParser parser, ArrayMap<Long, Integer> keySetRefCounts) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        String recordedVersionStr = parser.getAttributeValue(null, "version");
        if (recordedVersionStr != null) goto L15;
    L4:
        int type = parser.next();
        if (type == 1) goto L10;
        if (type != 3) goto L4;
        if (parser.getDepth() > outerDepth) goto L4;
    L10:
        Iterator<PackageSetting> r2 = this.mPackages.values().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        PackageSetting p = r2.next();
        clearPackageKeySetDataLPw(p);
        goto L12
    L14:
        return;
    L15:
        int type2 = parser.next();
        if (type2 == 1) goto L38;
        if (type2 == 3) goto L19;
    L21:
        if (type2 == 3) goto L15;
        if (type2 == 4) goto L15;
        String tagName = parser.getName();
        if (tagName.equals("keys") == true) goto L27;
        if (tagName.equals("keysets") == true) goto L30;
        if (tagName.equals("lastIssuedKeyId") == true) goto L33;
        if (tagName.equals("lastIssuedKeySetId") == false) goto L15;
        this.lastIssuedKeySetId = parser.getAttributeLong(null, "value");
        goto L15
    L33:
        this.lastIssuedKeyId = parser.getAttributeLong(null, "value");
        goto L15
    L30:
        readKeySetListLPw(parser);
        goto L15
    L27:
        readKeysLPw(parser);
        goto L15
    L19:
        if (parser.getDepth() > outerDepth) goto L21;
    L38:
        addRefCountsFromSavedPackagesLPw(keySetRefCounts);
    }

    void readKeysLPw(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L18;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("public-key") == false) goto L3;
        readPublicKeyLPw(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    void readKeySetListLPw(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        long currentKeySetId = 0;
    L3:
        int type = parser.next();
        if (type == 1) goto L22;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("keyset") == true) goto L16;
        if (tagName.equals("key-id") == false) goto L3;
        long id = parser.getAttributeLong(null, "identifier");
        this.mKeySetMapping.get(currentKeySetId).add(Long.valueOf(id));
        goto L3
    L16:
        currentKeySetId = parser.getAttributeLong(null, "identifier");
        this.mKeySets.put(currentKeySetId, new KeySetHandle(currentKeySetId, 0));
        this.mKeySetMapping.put(currentKeySetId, new ArraySet());
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    void readPublicKeyLPw(TypedXmlPullParser parser) throws XmlPullParserException {
        long identifier = parser.getAttributeLong(null, "identifier");
        int refCount = 0;
        byte[] publicKey = parser.getAttributeBytesBase64(null, "value", null);
        PublicKey pub = FrameworkParsingPackageUtils.parsePublicKey(publicKey);
        if (pub == null) goto L6;
        PublicKeyHandle pkh = new PublicKeyHandle(this, identifier, refCount, pub, null);
        this.mPublicKeys.put(identifier, pkh);
        return;
    }

    private void addRefCountsFromSavedPackagesLPw(ArrayMap<Long, Integer> keySetRefCounts) {
        int numRefCounts = keySetRefCounts.size();
        int i = 0;
    L4:
        if (i >= numRefCounts) goto L10;
        KeySetHandle ks = this.mKeySets.get(keySetRefCounts.keyAt(i).longValue());
        if (ks != null) goto L8;
        Slog.wtf(TAG, "Encountered non-existent key-set reference when reading settings");
    L9:
        i = i + 1;
        goto L4
    L8:
        ks.setRefCountLPw(keySetRefCounts.valueAt(i).intValue());
        goto L9
    L10:
        ArraySet<Long> orphanedKeySets = new ArraySet();
        int numKeySets = this.mKeySets.size();
        int i2 = 0;
    L11:
        if (i2 >= numKeySets) goto L23;
        if (this.mKeySets.valueAt(i2).getRefCountLPr() != 0) goto L15;
        Slog.wtf(TAG, "Encountered key-set w/out package references when reading settings");
        orphanedKeySets.add(Long.valueOf(this.mKeySets.keyAt(i2)));
    L15:
        ArraySet<Long> pubKeys = this.mKeySetMapping.valueAt(i2);
        int pkSize = pubKeys.size();
        int j = 0;
    L16:
        if (j >= pkSize) goto L22;
        long pkId = pubKeys.valueAt(j).longValue();
        PublicKeyHandle pkh = this.mPublicKeys.get(pkId);
        if (pkh != null) goto L20;
        Slog.e(TAG, "Dangling public-key reference while restoring ref counts for keyset " + this.mKeySets.keyAt(i2) + ": public-key id " + pkId + " missing from mPublicKeys; skipping.");
    L21:
        j = j + 1;
        goto L16
    L20:
        pkh.incrRefCountLPw();
        goto L21
    L22:
        i2 = i2 + 1;
        goto L11
    L23:
        int numOrphans = orphanedKeySets.size();
        int i3 = 0;
    L24:
        if (i3 >= numOrphans) goto L27;
        decrementKeySetLPw(orphanedKeySets.valueAt(i3).longValue());
        i3 = i3 + 1;
        goto L24
    }
}
