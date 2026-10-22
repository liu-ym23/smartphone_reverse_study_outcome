package com.android.server.pm;

import android.app.Person;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.LocusId;
import android.content.pm.PackageInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Binder;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.format.Formatter;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class ShortcutPackage extends ShortcutPackageItem {
    private static final String ATTR_ACTIVITY = "activity";
    private static final String ATTR_BITMAP_PATH = "bitmap-path";
    private static final String ATTR_CALL_COUNT = "call-count";
    private static final String ATTR_DISABLED_MESSAGE = "dmessage";
    private static final String ATTR_DISABLED_MESSAGE_RES_ID = "dmessageid";
    private static final String ATTR_DISABLED_MESSAGE_RES_NAME = "dmessagename";
    private static final String ATTR_DISABLED_REASON = "disabled-reason";
    private static final String ATTR_FLAGS = "flags";
    private static final String ATTR_ICON_RES_ID = "icon-res";
    private static final String ATTR_ICON_RES_NAME = "icon-resname";
    private static final String ATTR_ICON_URI = "icon-uri";
    private static final String ATTR_ID = "id";
    private static final String ATTR_INTENT_LEGACY = "intent";
    private static final String ATTR_INTENT_NO_EXTRA = "intent-base";
    private static final String ATTR_LAST_RESET = "last-reset";
    private static final String ATTR_LOCUS_ID = "locus-id";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_NAME_XMLUTILS = "name";
    private static final String ATTR_PERSON_IS_BOT = "is-bot";
    private static final String ATTR_PERSON_IS_IMPORTANT = "is-important";
    private static final String ATTR_PERSON_KEY = "key";
    private static final String ATTR_PERSON_NAME = "name";
    private static final String ATTR_PERSON_URI = "uri";
    private static final String ATTR_RANK = "rank";
    private static final String ATTR_SCHEMA_VERSON = "schema-version";
    private static final String ATTR_SPLASH_SCREEN_THEME_NAME = "splash-screen-theme-name";
    private static final String ATTR_TEXT = "text";
    private static final String ATTR_TEXT_RES_ID = "textid";
    private static final String ATTR_TEXT_RES_NAME = "textname";
    private static final String ATTR_TIMESTAMP = "timestamp";
    private static final String ATTR_TITLE = "title";
    private static final String ATTR_TITLE_RES_ID = "titleid";
    private static final String ATTR_TITLE_RES_NAME = "titlename";
    private static final String KEY_BITMAPS = "bitmaps";
    private static final String KEY_BITMAP_BYTES = "bitmapBytes";
    private static final String KEY_DYNAMIC = "dynamic";
    private static final String KEY_MANIFEST = "manifest";
    private static final String KEY_PINNED = "pinned";
    private static final String NAME_CAPABILITY = "capability";
    private static final String NAME_CATEGORIES = "categories";
    private static final String TAG = "ShortcutService";
    private static final String TAG_CATEGORIES = "categories";
    private static final String TAG_EXTRAS = "extras";
    private static final String TAG_INTENT = "intent";
    private static final String TAG_INTENT_EXTRAS_LEGACY = "intent-extras";
    private static final String TAG_MAP_XMLUTILS = "map";
    private static final String TAG_PERSON = "person";
    static final String TAG_ROOT = "package";
    private static final String TAG_SHARE_TARGET = "share-target";
    private static final String TAG_SHORTCUT = "shortcut";
    private static final String TAG_STRING_ARRAY_XMLUTILS = "string-array";
    private static final String TAG_VERIFY = "ShortcutService.verify";
    private int mApiCallCount;
    private final Executor mExecutor;
    private long mLastKnownForegroundElapsedTime;
    private long mLastReportedTime;
    private long mLastResetTime;
    private final int mPackageUid;
    private final ArrayList<ShareTargetInfo> mShareTargets;
    final Comparator<ShortcutInfo> mShortcutRankComparator;
    final Comparator<ShortcutInfo> mShortcutTypeAndRankComparator;
    final Comparator<ShortcutInfo> mShortcutTypeRankAndTimeComparator;
    private final ArrayMap<String, ShortcutInfo> mShortcuts;

    /* JADX INFO: renamed from: $r8$lambda$-AUPWmElF6dR8kSMBWmEUAxf0R8, reason: not valid java name */
    public static /* synthetic */ void m6903$r8$lambda$AUPWmElF6dR8kSMBWmEUAxf0R8(ShortcutPackage r0, List r1, Predicate r2, int r3, String r4, ArraySet r5, boolean r6, ShortcutInfo r7) {
        r0.lambda$findAll$10(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Boolean $r8$lambda$0Y6UvLncb3S2JG4mLXD6V2jmW58(ShortcutPackage r0, ArrayList r1, ShortcutService r2, boolean[] r3, ShortcutInfo r4) {
        return r0.lambda$areAllActivitiesStillEnabled$12(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$0uJdycH-nM5B_CZMcGyKrac0s_0, reason: not valid java name */
    public static /* synthetic */ void m6904$r8$lambda$0uJdycHnM5B_CZMcGyKrac0s_0(long r0, int r2, ShortcutInfo r3) {
        lambda$adjustRanks$24(r0, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$3u1Wuw4TqREgufTE5HZrHLXCcFA(ShortcutInfo r0, ShortcutInfo r1) {
        return lambda$verifyStates$29(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$5B-oZcEJ1qtcrQLp4L4Y3ipkGlc, reason: not valid java name */
    public static /* synthetic */ void m6905$r8$lambda$5BoZcEJ1qtcrQLp4L4Y3ipkGlc(ArraySet r0, ShortcutInfo r1) {
        lambda$publishManifestShortcuts$15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$66PlVAvMgAxYITz5nIrQo9lN3v0(ShortcutPackage r0, ArrayMap r1, int r2, ShortcutInfo r3) {
        r0.lambda$enforceShortcutCountsBeforeOperation$20(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$6ZlFLJzZCNNWv9rR74M0nJTaEmk(long r0, ShortcutInfo r2) {
        lambda$adjustRanks$23(r0, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$9ofWuFPpEJXVT17K7PfzoWk9n7Q(ShortcutInfo r0) {
        return lambda$verifyStates$31(r0);
    }

    public static /* synthetic */ void $r8$lambda$AVWoe4CxwuPeMjUDO6hCyOFXdw4(ShortcutPackage r0, ShortcutService r1, Resources r2, ShortcutInfo r3) {
        r0.lambda$rescanPackageIfNeeded$14(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Auy0L2woG8zWEPEBq7Ycp0cH4Jk(ShortcutPackage r0, ArrayMap r1, ShortcutInfo r2) {
        r0.lambda$sortShortcutsToActivities$19(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$BxGNy8mxNpUw0VpM-MdsZvX_Hro, reason: not valid java name */
    public static /* synthetic */ void m6906$r8$lambda$BxGNy8mxNpUw0VpMMdsZvX_Hro(int r0, ShortcutInfo r1) {
        lambda$onRestored$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$EkizdCttco10boCcY-jGkEshiH4, reason: not valid java name */
    public static /* synthetic */ void m6907$r8$lambda$EkizdCttco10boCcYjGkEshiH4(ShortcutInfo r0) {
        lambda$refreshPinnedFlags$8(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Fgwpzd9jZ3WXkz2jdNqLn-cqndw, reason: not valid java name */
    public static /* synthetic */ void m6908$r8$lambda$Fgwpzd9jZ3WXkz2jdNqLncqndw(Resources r0, ShortcutService r1, List r2, ShortcutInfo r3) {
        lambda$resolveResourceStrings$21(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$HACV_ed8nD4c4E1vR7-aHevSPlI, reason: not valid java name */
    public static /* synthetic */ void m6909$r8$lambda$HACV_ed8nD4c4E1vR7aHevSPlI(ShortcutPackage r0, boolean r1, int r2, ShortcutInfo r3) {
        r0.lambda$deleteOrDisableWithId$5(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$NbM-PpTfhw_A5hzKNDuJbAFKOKA, reason: not valid java name */
    public static /* synthetic */ Boolean m6910$r8$lambda$NbMPpTfhw_A5hzKNDuJbAFKOKA(Consumer r0, ShortcutInfo r1) {
        return lambda$forEachShortcut$33(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$NrKE9tXWhDotd2QU4aXFoFTEYFM(ShortcutPackage r0, ShortcutInfo r1) {
        r0.lambda$enableWithId$6(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Odeby4uMEqF82eSlyHGmoC0IK-Q, reason: not valid java name */
    public static /* synthetic */ void m6911$r8$lambda$Odeby4uMEqF82eSlyHGmoC0IKQ(ShortcutPackage r0, boolean[] r1, ShortcutService r2, ShortcutInfo r3) {
        r0.lambda$verifyStates$32(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$PEQM3oYGh7w0ORTbc2H448j9-kY, reason: not valid java name */
    public static /* synthetic */ Boolean m6912$r8$lambda$PEQM3oYGh7w0ORTbc2H448j9kY(boolean[] r0, ShortcutInfo r1) {
        return lambda$hasNonManifestShortcuts$25(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$QLfz_27Z-dymRsjZaX-XL3_Hi2s, reason: not valid java name */
    public static /* synthetic */ void m6913$r8$lambda$QLfz_27ZdymRsjZaXXL3_Hi2s(Set r0, ShortcutInfo r1) {
        lambda$refreshPinnedFlags$9(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Y9SlZjtBUpwTFgSqAT_vL6FH3-U, reason: not valid java name */
    public static /* synthetic */ void m6914$r8$lambda$Y9SlZjtBUpwTFgSqAT_vL6FH3U(ArraySet r0, ShortcutInfo r1) {
        lambda$getUsedBitmapFilesLocked$11(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$_8tfkxxe7-_fUsYgrXxubAXRl2w, reason: not valid java name */
    public static /* synthetic */ void m6915$r8$lambda$_8tfkxxe7_fUsYgrXxubAXRl2w(ShortcutPackage r0, String r1, int r2, ShortcutInfo r3) {
        r0.lambda$disableWithId$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$_k0XfWT0WOi01GQ9sNLZ2q_PsAE(List r0, ShortcutInfo r1) {
        lambda$removeOrphans$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$bJewszB9DqdWC0fk1WvtwLDs_GM(PrintWriter r0, String r1, long[] r2, ShortcutInfo r3) {
        lambda$dump$26(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$iUGJ_-g8cHwBQ7YEl7cXmErsN-4, reason: not valid java name */
    public static /* synthetic */ int m6916$r8$lambda$iUGJ_g8cHwBQ7YEl7cXmErsN4(ShortcutInfo r0, ShortcutInfo r1) {
        return lambda$new$22(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$iuAcmeSGUvZcd_xhqSOM2rb3sGA(ShortcutInfo r0, ShortcutInfo r1) {
        return lambda$new$16(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$l5RBkNBQZmt4qhqJPmZ52QhU1K4(ShortcutInfo r0, ShortcutInfo r1) {
        return lambda$new$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$r_sw7DkGbdkFPKyz4hGGxVWfVGU(ShortcutPackage r0, Set r1, ShortcutLauncher r2) {
        r0.lambda$refreshPinnedFlags$7(r1, r2);
    }

    public static /* synthetic */ ArrayList $r8$lambda$sVr7RxqWqn1LwfyVEySJxNctBRY(ComponentName r0) {
        return lambda$sortShortcutsToActivities$18(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$sc_d-5i4mwcRgLtDVCbELDmtSa0, reason: not valid java name */
    public static /* synthetic */ void m6917$r8$lambda$sc_d5i4mwcRgLtDVCbELDmtSa0(int r0, PrintWriter r1, ShortcutInfo r2) {
        lambda$dumpShortcuts$27(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$t_8-X6UFTHISZJJ1g_U1aJFGedQ, reason: not valid java name */
    public static /* synthetic */ boolean m6918$r8$lambda$t_8X6UFTHISZJJ1g_U1aJFGedQ(ShortcutInfo r0) {
        return lambda$verifyStates$30(r0);
    }

    public static /* synthetic */ void $r8$lambda$uLeuitZ5NTQ5Yb9aO0NhJoYSviw(ShortcutPackage r0, long r1, ShortcutInfo r3) {
        r0.lambda$rescanPackageIfNeeded$13(r1, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$xaLkYQU2f4r4gN3WqmUD3nsUY3c(ShortcutInfo r0) {
        return lambda$ensureShortcutCountBeforePush$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$xslwrGKuNFvEYPAGAExbsgNpM7U(int[] r0, int[] r1, int[] r2, int[] r3, long[] r4, ShortcutInfo r5) {
        lambda$dumpCheckin$28(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$zoz8gJFW0CG0weckIzBrzLziFFs(ShortcutInfo r0) {
        lambda$deleteLongLivedWithId$3(r0);
    }

    private ShortcutPackage(ShortcutUser shortcutUser, int packageUserId, String packageName, ShortcutPackageInfo spi) {
        if (spi == null) goto L4;
        ShortcutPackageInfo r0 = spi;
    L5:
        super(shortcutUser, packageUserId, packageName, r0);
        this.mShortcuts = new ArrayMap();
        this.mShareTargets = new ArrayList(0);
        this.mShortcutTypeAndRankComparator = new ShortcutPackage$$ExternalSyntheticLambda24();
        this.mShortcutTypeRankAndTimeComparator = new ShortcutPackage$$ExternalSyntheticLambda25();
        this.mShortcutRankComparator = new ShortcutPackage$$ExternalSyntheticLambda26();
        this.mPackageUid = shortcutUser.mService.injectGetPackageUid(packageName, packageUserId);
        this.mExecutor = BackgroundThread.getExecutor();
        return;
    L4:
        r0 = ShortcutPackageInfo.newEmpty();
        goto L5
    }

    public ShortcutPackage(ShortcutUser shortcutUser, int packageUserId, String packageName) {
        this(shortcutUser, packageUserId, packageName, null);
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    public int getOwnerUserId() {
        return getPackageUserId();
    }

    public int getPackageUid() {
        return this.mPackageUid;
    }

    public Resources getPackageResources() {
        return this.mShortcutUser.mService.injectGetResourcesForApplicationAsUser(getPackageName(), getPackageUserId());
    }

    public int getShortcutCount() {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        int r1 = this.mShortcuts.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    protected boolean canRestoreAnyVersion() {
        return true;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    protected void onRestored(final int restoreBlockReason) {
        forEachShortcutMutate(new ShortcutPackage$$ExternalSyntheticLambda28(restoreBlockReason));
        refreshPinnedFlags();
    }

    private static /* synthetic */ void lambda$onRestored$0(int restoreBlockReason, ShortcutInfo si) {
        if (restoreBlockReason == 0) goto L5;
    L9:
        si.clearFlags(4096);
        si.setDisabledReason(restoreBlockReason);
        if (restoreBlockReason == 0) goto L13;
        si.addFlags(64);
        return;
    L13:
        return;
    L5:
        if (si.hasFlags(4096) == true) goto L9;
        if (si.getDisabledReason() != restoreBlockReason) goto L9;
    }

    public ShortcutInfo findShortcutById(String id) {
        if (id != null) goto L5;
        return null;
    L5:
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ShortcutInfo r1 = this.mShortcuts.get(id);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isShortcutExistsAndInvisibleToPublisher(String id) {
        ShortcutInfo si = findShortcutById(id);
        if (si != null) goto L5;
    L7:
        return false;
    L5:
        if (si.isVisibleToPublisher() == true) goto L7;
        return true;
    }

    public boolean isShortcutExistsAndVisibleToPublisher(String id) {
        ShortcutInfo si = findShortcutById(id);
        if (si != null) goto L5;
    L7:
        return false;
    L5:
        if (si.isVisibleToPublisher() == false) goto L7;
        return true;
    }

    private void ensureNotImmutable(ShortcutInfo shortcut, boolean ignoreInvisible) {
        if (shortcut != null) goto L4;
        return;
    L4:
        if (shortcut.isImmutable() == false) goto L12;
        if (ignoreInvisible == false) goto L10;
        if (shortcut.isVisibleToPublisher() == true) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Manifest shortcut ID=" + shortcut.getId() + " may not be manipulated via APIs");
    }

    public void ensureNotImmutable(String id, boolean ignoreInvisible) {
        ensureNotImmutable(findShortcutById(id), ignoreInvisible);
    }

    public void ensureImmutableShortcutsNotIncludedWithIds(List<String> shortcutIds, boolean ignoreInvisible) {
        int i = shortcutIds.size() - 1;
    L3:
        if (i < 0) goto L6;
        ensureNotImmutable(shortcutIds.get(i), ignoreInvisible);
        i = i - 1;
        goto L3
    }

    public void ensureImmutableShortcutsNotIncluded(List<ShortcutInfo> shortcuts, boolean ignoreInvisible) {
        int i = shortcuts.size() - 1;
    L3:
        if (i < 0) goto L6;
        ensureNotImmutable(shortcuts.get(i).getId(), ignoreInvisible);
        i = i - 1;
        goto L3
    }

    public void ensureNoBitmapIconIfShortcutIsLongLived(List<ShortcutInfo> shortcuts) {
        int i = shortcuts.size() - 1;
    L3:
        if (i < 0) goto L21;
        ShortcutInfo si = shortcuts.get(i);
        if (si.isLongLived() == false) goto L17;
        Icon icon = si.getIcon();
        if (icon != null) goto L10;
    L14:
        if (icon != null) goto L18;
        if (si.hasIconFile() == false) goto L17;
    L18:
        Slog.e(TAG, "Invalid icon type in shortcut " + si.getId() + ". Bitmaps are not allowed in long-lived shortcuts. Use Resource icons, or Uri-based icons instead.");
        return;
    L10:
        if (icon.getType() == 1) goto L14;
        if (icon.getType() == 5) goto L14;
    L17:
        i = i - 1;
        goto L3
    }

    public void ensureAllShortcutsVisibleToLauncher(List<ShortcutInfo> shortcuts) {
        Iterator<ShortcutInfo> r0 = shortcuts.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ShortcutInfo shortcut = r0.next();
        if (shortcut.isExcludedFromSurfaces(1) == false) goto L4;
        throw new IllegalArgumentException("Shortcut ID=" + shortcut.getId() + " is hidden from launcher and may not be manipulated via APIs");
    }

    private ShortcutInfo forceDeleteShortcutInner(String id) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ShortcutInfo shortcut = this.mShortcuts.remove(id);     // Catch: Throwable -> L7
        if (shortcut == null) goto L9;
        removeIcon(shortcut);     // Catch: Throwable -> L7
        shortcut.clearFlags(1610629155);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return shortcut;
    L7:
        th = move-exception;
        throw th;
    }

    private void forceReplaceShortcutInner(ShortcutInfo newShortcut) {
        ShortcutService s = this.mShortcutUser.mService;
        forceDeleteShortcutInner(newShortcut.getId());
        s.saveIconAndFixUpShortcutLocked(this, newShortcut);
        s.fixUpShortcutResourceNamesAndValues(newShortcut);
        ensureShortcutCountBeforePush();
        saveShortcut(new ShortcutInfo[]{newShortcut});
    }

    public boolean addOrReplaceDynamicShortcut(ShortcutInfo newShortcut) {
        Preconditions.checkArgument(newShortcut.isEnabled(), "add/setDynamicShortcuts() cannot publish disabled shortcuts");
        newShortcut.addFlags(1);
        ShortcutInfo oldShortcut = findShortcutById(newShortcut.getId());
        if (oldShortcut == null) goto L6;
        oldShortcut.ensureUpdatableWith(newShortcut, false);
        newShortcut.addFlags(oldShortcut.getFlags() & 1610629122);
    L6:
        if (newShortcut.isExcludedFromSurfaces(1) == true) goto L8;
        forceReplaceShortcutInner(newShortcut);
    L8:
        if (oldShortcut == null) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean pushDynamicShortcut(ShortcutInfo newShortcut, List<ShortcutInfo> changedShortcuts) {
        Preconditions.checkArgument(newShortcut.isEnabled(), "pushDynamicShortcuts() cannot publish disabled shortcuts");
        newShortcut.addFlags(1);
        changedShortcuts.clear();
        ShortcutInfo oldShortcut = findShortcutById(newShortcut.getId());
        boolean deleted = false;
        if (oldShortcut != null) goto L5;
    L6:
        ShortcutService service = this.mShortcutUser.mService;
        int maxShortcuts = service.getMaxActivityShortcuts();
        ArrayMap<ComponentName, ArrayList<ShortcutInfo>> all = sortShortcutsToActivities();
        ArrayList<ShortcutInfo> activityShortcuts = all.get(newShortcut.getActivity());
        if (activityShortcuts != null) goto L9;
    L11:
        if (activityShortcuts != null) goto L13;
    L23:
        if (oldShortcut == null) goto L26;
        oldShortcut.ensureUpdatableWith(newShortcut, false);
        newShortcut.addFlags(oldShortcut.getFlags() & 1610629122);
    L26:
        if (newShortcut.isExcludedFromSurfaces(1) == true) goto L28;
        forceReplaceShortcutInner(newShortcut);
    L28:
        return deleted;
    L13:
        if (activityShortcuts.size() != maxShortcuts) goto L23;
        Collections.sort(activityShortcuts, this.mShortcutTypeAndRankComparator);
        ShortcutInfo shortcut = activityShortcuts.get(maxShortcuts - 1);
        if (shortcut.isManifestShortcut() == false) goto L18;
        Slog.e(TAG, "Failed to remove manifest shortcut while pushing dynamic shortcut " + newShortcut.getId());
        return true;
    L18:
        changedShortcuts.add(shortcut);
        if (deleteDynamicWithId(shortcut.getId(), true) == null) goto L21;
        boolean r9 = true;
    L22:
        deleted = r9;
        goto L23
    L21:
        r9 = false;
        goto L22
    L9:
        if (activityShortcuts.size() <= maxShortcuts) goto L11;
        service.wtf("Error pushing shortcut. There are already " + activityShortcuts.size() + " shortcuts.");
        goto L11
    L5:
        if (oldShortcut.isDynamic() == true) goto L23;
        goto L6
    }

    private void ensureShortcutCountBeforePush() {
        ShortcutService service = this.mShortcutUser.mService;
        int maxShortcutPerApp = service.getMaxAppShortcuts();
        Object r2 = this.mPackageItemLock;
        monitor-enter(r2);
        List<ShortcutInfo> appShortcuts = (List) this.mShortcuts.values().stream().filter(new ShortcutPackage$$ExternalSyntheticLambda32()).collect(Collectors.toList());     // Catch: Throwable -> L12
        if (appShortcuts.size() < maxShortcutPerApp) goto L16;
        Collections.sort(appShortcuts, this.mShortcutTypeRankAndTimeComparator);     // Catch: Throwable -> L12
    L8:
        if (appShortcuts.size() < maxShortcutPerApp) goto L16;
        ShortcutInfo shortcut = appShortcuts.remove(appShortcuts.size() - 1);     // Catch: Throwable -> L12
        if (shortcut.isDeclaredInManifest() == true) goto L15;
        forceDeleteShortcutInner(shortcut.getId());     // Catch: Throwable -> L12
        goto L8
    L15:
        throw new IllegalArgumentException(getPackageName() + " has published " + appShortcuts.size() + " manifest shortcuts across different activities.");     // Catch: Throwable -> L12
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$ensureShortcutCountBeforePush$1(ShortcutInfo si) {
        return !si.isPinned();
    }

    private List<ShortcutInfo> removeOrphans() {
        final List<ShortcutInfo> removeList = new ArrayList(1);
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda8(removeList));
        if (removeList.isEmpty() == true) goto L7;
        int i = removeList.size() - 1;
    L5:
        if (i < 0) goto L7;
        forceDeleteShortcutInner(removeList.get(i).getId());
        i = i - 1;
    L7:
        return removeList;
    }

    private static /* synthetic */ void lambda$removeOrphans$2(List removeList, ShortcutInfo si) {
        if (si.isAlive() == false) goto L5;
        return;
    L5:
        removeList.add(si);
    }

    public List<ShortcutInfo> deleteAllDynamicShortcuts() {
        long now = this.mShortcutUser.mService.injectCurrentTimeMillis();
        boolean changed = false;
        Object r3 = this.mPackageItemLock;
        monitor-enter(r3);
        int i = this.mShortcuts.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        ShortcutInfo si = this.mShortcuts.valueAt(i);     // Catch: Throwable -> L11
        if (si.isDynamic() == false) goto L13;
        if (si.isVisibleToPublisher() == false) goto L13;
        changed = true;
        si.setTimestamp(now);     // Catch: Throwable -> L11
        si.clearFlags(1);     // Catch: Throwable -> L11
        si.setRank(0);     // Catch: Throwable -> L11
    L13:
        i = i - 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        monitor-exit(r3);     // Catch: Throwable -> L11
        if (changed == true) goto L18;
        return null;
    L18:
        return removeOrphans();
    L11:
        th = move-exception;
        throw th;
    }

    public ShortcutInfo deleteDynamicWithId(String shortcutId, boolean ignoreInvisible) {
        return deleteOrDisableWithId(shortcutId, false, false, ignoreInvisible, 0);
    }

    private ShortcutInfo disableDynamicWithId(String shortcutId, boolean ignoreInvisible, int disabledReason) {
        return deleteOrDisableWithId(shortcutId, true, false, ignoreInvisible, disabledReason);
    }

    public ShortcutInfo deleteLongLivedWithId(String shortcutId, boolean ignoreInvisible) {
        ShortcutInfo shortcut = findShortcutById(shortcutId);
        if (shortcut == null) goto L6;
        mutateShortcut(shortcutId, null, new ShortcutPackage$$ExternalSyntheticLambda31());
    L6:
        return deleteOrDisableWithId(shortcutId, false, false, ignoreInvisible, 0);
    }

    private static /* synthetic */ void lambda$deleteLongLivedWithId$3(ShortcutInfo si) {
        si.clearFlags(1610629120);
    }

    public ShortcutInfo disableWithId(String shortcutId, final String disabledMessage, final int disabledMessageResId, boolean overrideImmutable, boolean ignoreInvisible, int disabledReason) {
        ShortcutInfo deleted = deleteOrDisableWithId(shortcutId, true, overrideImmutable, ignoreInvisible, disabledReason);
        mutateShortcut(shortcutId, null, new ShortcutPackage$$ExternalSyntheticLambda21(this, disabledMessage, disabledMessageResId));
        return deleted;
    }

    private /* synthetic */ void lambda$disableWithId$4(String disabledMessage, int disabledMessageResId, ShortcutInfo disabled) {
        if (disabled == null) goto L8;
        if (disabledMessage == null) goto L5;
        disabled.setDisabledMessage(disabledMessage);
        return;
    L5:
        if (disabledMessageResId == 0) goto L10;
        disabled.setDisabledMessageResId(disabledMessageResId);
        this.mShortcutUser.mService.fixUpShortcutResourceNamesAndValues(disabled);
        return;
    L10:
        return;
    }

    private ShortcutInfo deleteOrDisableWithId(String shortcutId, final boolean disable, boolean overrideImmutable, boolean ignoreInvisible, final int disabledReason) {
        boolean r0 = false;
        if (disabledReason == 0) goto L5;
        boolean r2 = true;
    L6:
        if (disable != r2) goto L8;
        r0 = true;
    L8:
        Preconditions.checkState(r0, "disable and disabledReason disagree: " + disable + " vs " + disabledReason);
        ShortcutInfo oldShortcut = findShortcutById(shortcutId);
        if (oldShortcut != null) goto L11;
    L27:
        return null;
    L11:
        if (oldShortcut.isEnabled() == true) goto L16;
        if (ignoreInvisible == false) goto L16;
        if (oldShortcut.isVisibleToPublisher() == false) goto L27;
    L16:
        if (overrideImmutable == true) goto L19;
        ensureNotImmutable(oldShortcut, true);
    L19:
        if (oldShortcut.isPinned() == false) goto L21;
    L25:
        mutateShortcut(oldShortcut.getId(), oldShortcut, new ShortcutPackage$$ExternalSyntheticLambda7(this, disable, disabledReason));
        return null;
    L21:
        if (oldShortcut.isCached() == true) goto L25;
        forceDeleteShortcutInner(shortcutId);
        return oldShortcut;
    L5:
        r2 = false;
        goto L6
    }

    private /* synthetic */ void lambda$deleteOrDisableWithId$5(boolean disable, int disabledReason, ShortcutInfo si) {
        si.setRank(0);
        si.clearFlags(33);
        if (disable == false) goto L7;
        si.addFlags(64);
        if (si.getDisabledReason() != 0) goto L7;
        si.setDisabledReason(disabledReason);
    L7:
        si.setTimestamp(this.mShortcutUser.mService.injectCurrentTimeMillis());
        if (this.mShortcutUser.mService.isDummyMainActivity(si.getActivity()) == false) goto L11;
        si.setActivity(null);
        return;
    }

    public void enableWithId(String shortcutId) {
        mutateShortcut(shortcutId, null, new ShortcutPackage$$ExternalSyntheticLambda27(this));
    }

    private /* synthetic */ void lambda$enableWithId$6(ShortcutInfo si) {
        ensureNotImmutable(si, true);
        si.clearFlags(64);
        si.setDisabledReason(0);
    }

    public void updateInvisibleShortcutForPinRequestWith(ShortcutInfo shortcut) {
        ShortcutInfo source = findShortcutById(shortcut.getId());
        source.getClass();
        this.mShortcutUser.mService.validateShortcutForPinRequest(shortcut);
        shortcut.addFlags(2);
        forceReplaceShortcutInner(shortcut);
        adjustRanks();
    }

    public void refreshPinnedFlags() {
        final Set<String> pinnedShortcuts = new ArraySet();
        this.mShortcutUser.forAllLaunchers(new ShortcutPackage$$ExternalSyntheticLambda12(this, pinnedShortcuts));
        List<ShortcutInfo> pinned = findAll(pinnedShortcuts);
        if (pinned == null) goto L5;
        pinned.forEach(new ShortcutPackage$$ExternalSyntheticLambda13());
    L5:
        forEachShortcutMutate(new ShortcutPackage$$ExternalSyntheticLambda14(pinnedShortcuts));
        this.mShortcutUser.forAllLaunchers(new ShortcutPackage$$ExternalSyntheticLambda15());
        removeOrphans();
    }

    private /* synthetic */ void lambda$refreshPinnedFlags$7(Set pinnedShortcuts, ShortcutLauncher launcherShortcuts) {
        ArraySet<String> pinned = launcherShortcuts.getPinnedShortcutIds(getPackageName(), getPackageUserId());
        if (pinned != null) goto L5;
        return;
    L5:
        if (pinned.size() == 0) goto L10;
        pinnedShortcuts.addAll(pinned);
        return;
    }

    private static /* synthetic */ void lambda$refreshPinnedFlags$8(ShortcutInfo si) {
        if (si.isPinned() == true) goto L6;
        si.addFlags(2);
        return;
    }

    private static /* synthetic */ void lambda$refreshPinnedFlags$9(Set pinnedShortcuts, ShortcutInfo si) {
        if (pinnedShortcuts.contains(si.getId()) == false) goto L5;
        return;
    L5:
        if (si.isPinned() == false) goto L9;
        si.clearFlags(2);
        return;
    }

    public int getApiCallCount(boolean unlimited) {
        ShortcutService s = this.mShortcutUser.mService;
        if (s.isUidForegroundLocked(this.mPackageUid) == false) goto L5;
    L7:
        this.mLastKnownForegroundElapsedTime = s.injectElapsedRealtime();
        resetRateLimiting();
    L8:
        long last = s.getLastResetTimeLocked();
        long now = s.injectCurrentTimeMillis();
        if (ShortcutService.isClockValid(now) == false) goto L15;
        if (this.mLastResetTime <= now) goto L15;
        Slog.w(TAG, "Clock rewound");
        this.mLastResetTime = now;
        this.mApiCallCount = 0;
        return this.mApiCallCount;
    L15:
        if (this.mLastResetTime >= last) goto L18;
        this.mApiCallCount = 0;
        this.mLastResetTime = last;
    L18:
        return this.mApiCallCount;
    L5:
        if (this.mLastKnownForegroundElapsedTime < s.getUidLastForegroundElapsedTimeLocked(this.mPackageUid)) goto L7;
        if (unlimited == false) goto L8;
        goto L7
    }

    public boolean tryApiCall(boolean unlimited) {
        ShortcutService s = this.mShortcutUser.mService;
        if (getApiCallCount(unlimited) < s.mMaxUpdatesPerInterval) goto L6;
        return false;
    L6:
        this.mApiCallCount++;
        scheduleSave();
        return true;
    }

    public void resetRateLimiting() {
        if (this.mApiCallCount <= 0) goto L6;
        this.mApiCallCount = 0;
        scheduleSave();
        return;
    }

    public void resetRateLimitingForCommandLineNoSaving() {
        this.mApiCallCount = 0;
        this.mLastResetTime = 0;
    }

    public void findAll(List<ShortcutInfo> result, Predicate<ShortcutInfo> filter, int cloneFlag) {
        findAll(result, filter, cloneFlag, null, 0, false);
    }

    public void findAll(final List<ShortcutInfo> result, final Predicate<ShortcutInfo> filter, final int cloneFlag, final String callingLauncher, int launcherUserId, final boolean getPinnedByAnyLauncher) {
        if (getPackageInfo().isShadow() == false) goto L6;
        Log.d(TAG, "findAll() returned empty results because " + getPackageName() + " isn't installed yet");
        return;
    L6:
        ShortcutService s = this.mShortcutUser.mService;
        if (callingLauncher != null) goto L9;
        final ArraySet<String> pinnedByCallerSet = null;
    L10:
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda11(this, result, filter, cloneFlag, callingLauncher, pinnedByCallerSet, getPinnedByAnyLauncher));
        return;
    L9:
        pinnedByCallerSet = s.getLauncherShortcutsLocked(callingLauncher, getPackageUserId(), launcherUserId).getPinnedShortcutIds(getPackageName(), getPackageUserId());
        goto L10
    }

    private /* synthetic */ void lambda$findAll$10(List result, Predicate filter, int cloneFlag, String callingLauncher, ArraySet pinnedByCallerSet, boolean getPinnedByAnyLauncher, ShortcutInfo si) {
        filter(result, filter, cloneFlag, callingLauncher, pinnedByCallerSet, getPinnedByAnyLauncher, si);
    }

    private void filter(List<ShortcutInfo> result, Predicate<ShortcutInfo> query, int cloneFlag, String callingLauncher, ArraySet<String> pinnedByCallerSet, boolean getPinnedByAnyLauncher, ShortcutInfo si) {
        if (callingLauncher == null) goto L8;
        if (pinnedByCallerSet != null) goto L5;
    L7:
        boolean isPinnedByCaller = false;
    L10:
        if (getPinnedByAnyLauncher == false) goto L12;
    L18:
        ShortcutInfo clone = si.clone(cloneFlag);
        if (getPinnedByAnyLauncher == true) goto L22;
        if (isPinnedByCaller == true) goto L22;
        clone.clearFlags(2);
    L22:
        if (query != null) goto L24;
    L25:
        if (isPinnedByCaller == true) goto L27;
        clone.clearFlags(2);
    L27:
        result.add(clone);
        return;
    L24:
        if (query.test(clone) == true) goto L25;
        return;
    L12:
        if (si.isFloating() == false) goto L18;
        if (si.isCached() == true) goto L18;
        if (isPinnedByCaller == true) goto L18;
        Log.d(TAG, si.getId() + " ignored because it isn't pinned by " + callingLauncher);
        return;
    L5:
        if (pinnedByCallerSet.contains(si.getId()) == false) goto L7;
    L8:
        isPinnedByCaller = true;
        goto L10
    }

    public void resetThrottling() {
        this.mApiCallCount = 0;
    }

    public List<ShortcutManager.ShareShortcutInfo> getMatchingShareTargets(IntentFilter filter, int callingUserId) {
        return getMatchingShareTargets(filter, null, callingUserId);
    }

    List<ShortcutManager.ShareShortcutInfo> getMatchingShareTargets(IntentFilter filter, String pkgName, int callingUserId) {
        Object r8 = this.mPackageItemLock;
        monitor-enter(r8);
        List<ShareTargetInfo> matchedTargets = new ArrayList();     // Catch: Throwable -> L17
        int i = 0;
    L6:
        if (i >= this.mShareTargets.size()) goto L22;
        ShareTargetInfo target = this.mShareTargets.get(i);     // Catch: Throwable -> L17
        ShareTargetInfo.TargetData[] r4 = target.mTargetData;     // Catch: Throwable -> L17
        int r5 = r4.length;     // Catch: Throwable -> L17
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L20;
        ShareTargetInfo.TargetData data = r4[r6];     // Catch: Throwable -> L17
    L14:
        th = th;
    L51:
        monitor-exit(r8);     // Catch: Throwable -> L14
        throw th;
    L12:
        if (filter.hasDataType(data.mMimeType) == true) goto L13;
        r6 = r6 + 1;     // Catch: Throwable -> L14
        goto L8
    L13:
        matchedTargets.add(target);     // Catch: Throwable -> L14
    L20:
        i = i + 1;     // Catch: Throwable -> L14
        goto L6
    L22:
        if (matchedTargets.isEmpty() == false) goto L26;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
        return r2;
    L26:
        ArrayList<ShortcutInfo> shortcuts = new ArrayList();     // Catch: Throwable -> L14
        findAll(shortcuts, new ShortcutPackage$$ExternalSyntheticLambda9(), 9, pkgName, callingUserId, false);     // Catch: Throwable -> L14
        List<ShortcutManager.ShareShortcutInfo> result = new ArrayList();     // Catch: Throwable -> L14
        int i2 = 0;
    L28:
        if (i2 >= shortcuts.size()) goto L49;
        Set<String> categories = shortcuts.get(i2).getCategories();     // Catch: Throwable -> L14
        if (categories == null) goto L47;
        if (categories.isEmpty() == true) goto L47;
        int j = 0;
    L36:
        if (j >= matchedTargets.size()) goto L47;
        boolean hasAllCategories = true;
        ShareTargetInfo target2 = matchedTargets.get(j);     // Catch: Throwable -> L14
        int q = 0;
    L39:
        if (q >= target2.mCategories.length) goto L44;
        if (categories.contains(target2.mCategories[q]) == false) goto L42;
        q = q + 1;     // Catch: Throwable -> L14
        goto L39
    L42:
        hasAllCategories = false;
    L44:
        if (hasAllCategories == true) goto L45;
        j = j + 1;     // Catch: Throwable -> L14
        goto L36
    L45:
        result.add(new ShortcutManager.ShareShortcutInfo(shortcuts.get(i2), new ComponentName(getPackageName(), target2.mTargetClass)));     // Catch: Throwable -> L14
    L47:
        i2 = i2 + 1;     // Catch: Throwable -> L14
        goto L28
    L49:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return result;
    L17:
        th = th;
        goto L51
    }

    public boolean hasShareTargets() {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mShareTargets.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    int getSharingShortcutCount() {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mShareTargets.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        ArrayList<ShortcutInfo> shortcuts = new ArrayList();     // Catch: Throwable -> L9
        findAll(shortcuts, new ShortcutPackage$$ExternalSyntheticLambda9(), 27);     // Catch: Throwable -> L9
        int sharingShortcutCount = 0;
        int i = 0;
    L13:
        if (i >= shortcuts.size()) goto L34;
        Set<String> categories = shortcuts.get(i).getCategories();     // Catch: Throwable -> L9
        if (categories == null) goto L32;
        if (categories.isEmpty() == true) goto L32;
        int j = 0;
    L21:
        if (j >= this.mShareTargets.size()) goto L32;
        boolean hasAllCategories = true;
        ShareTargetInfo target = this.mShareTargets.get(j);     // Catch: Throwable -> L9
        int q = 0;
    L24:
        if (q >= target.mCategories.length) goto L29;
        if (categories.contains(target.mCategories[q]) == false) goto L27;
        q = q + 1;     // Catch: Throwable -> L9
        goto L24
    L27:
        hasAllCategories = false;
    L29:
        if (hasAllCategories == true) goto L30;
        j = j + 1;     // Catch: Throwable -> L9
        goto L21
    L30:
        sharingShortcutCount = sharingShortcutCount + 1;     // Catch: Throwable -> L9
    L32:
        i = i + 1;     // Catch: Throwable -> L9
        goto L13
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return sharingShortcutCount;
    }

    private ArraySet<String> getUsedBitmapFilesLocked() {
        final ArraySet<String> usedFiles = new ArraySet(1);
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda38(usedFiles));
        return usedFiles;
    }

    private static /* synthetic */ void lambda$getUsedBitmapFilesLocked$11(ArraySet usedFiles, ShortcutInfo si) {
        if (si.getBitmapPath() == null) goto L6;
        usedFiles.add(getFileName(si.getBitmapPath()));
        return;
    }

    public void cleanupDanglingBitmapFiles(File path) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        this.mShortcutBitmapSaver.waitForAllSavesLocked();     // Catch: Throwable -> L13
        ArraySet<String> usedFiles = getUsedBitmapFilesLocked();     // Catch: Throwable -> L13
        File[] r2 = path.listFiles();     // Catch: Throwable -> L13
        int r3 = r2.length;     // Catch: Throwable -> L13
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L16;
        File child = r2[r4];     // Catch: Throwable -> L13
        if (child.isFile() == false) goto L15;
        String name = child.getName();     // Catch: Throwable -> L13
        if (usedFiles.contains(name) == true) goto L15;
        child.delete();     // Catch: Throwable -> L13
    L15:
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static String getFileName(String path) {
        int sep = path.lastIndexOf(File.separatorChar);
        if (sep != (-1)) goto L6;
        return path;
    L6:
        return path.substring(sep + 1);
    }

    private boolean areAllActivitiesStillEnabled() {
        final ShortcutService s = this.mShortcutUser.mService;
        final ArrayList<ComponentName> checked = new ArrayList(4);
        final boolean[] reject = new boolean[1];
        forEachShortcutStopWhen(new ShortcutPackage$$ExternalSyntheticLambda10(this, checked, s, reject));
        return true ^ reject[0];
    }

    private /* synthetic */ Boolean lambda$areAllActivitiesStillEnabled$12(ArrayList checked, ShortcutService s, boolean[] reject, ShortcutInfo si) {
        ComponentName activity = si.getActivity();
        if (checked.contains(activity) == false) goto L5;
        return false;
    L5:
        checked.add(activity);
        if (activity != null) goto L8;
    L11:
        return false;
    L8:
        if (s.injectIsActivityEnabledAndExported(activity, getOwnerUserId()) == true) goto L11;
        reject[0] = true;
        return true;
    }

    public boolean rescanPackageIfNeeded(boolean isNewApp, boolean forceRescan) {
        final ShortcutService s = this.mShortcutUser.mService;
        long start = s.getStatStartTime();
        PackageInfo pi = this.mShortcutUser.mService.getPackageInfo(getPackageName(), getPackageUserId());     // Catch: Throwable -> L18
        if (pi != null) goto L8;
        s.logDurationStat(14, start);
        return false;
    L8:
        if (isNewApp == true) goto L20;
        if (forceRescan == true) goto L20;
        if (getPackageInfo().getVersionCode() != pi.getLongVersionCode()) goto L20;
        if (getPackageInfo().getLastUpdateTime() != pi.lastUpdateTime) goto L20;
        if (areAllActivitiesStillEnabled() == false) goto L20;
        s.logDurationStat(14, start);
        return false;
    L20:
        s.logDurationStat(14, start);
        List<ShortcutInfo> newManifestShortcutList = null;
        Object r7 = this.mPackageItemLock;
        monitor-enter(r7);
        int r8 = this.mShareTargets.size();     // Catch: Throwable -> L24 Throwable -> L26
        newManifestShortcutList = ShortcutParser.parseShortcuts(this.mShortcutUser.mService, getPackageName(), getPackageUserId(), this.mShareTargets);     // Catch: Throwable -> L24 Throwable -> L26
    L28:
        monitor-exit(r7);     // Catch: Throwable -> L24
        if (newManifestShortcutList != null) goto L31;
        int manifestShortcutSize = 0;
    L33:
        if (isNewApp == false) goto L36;
        if (manifestShortcutSize != 0) goto L36;
        return false;
    L36:
        getPackageInfo().updateFromPackageInfo(pi);
        final long newVersionCode = getPackageInfo().getVersionCode();
        forEachShortcutMutate(new ShortcutPackage$$ExternalSyntheticLambda5(this, newVersionCode));
        if (isNewApp == true) goto L39;
        final Resources publisherRes = getPackageResources();
        forEachShortcutMutate(new ShortcutPackage$$ExternalSyntheticLambda6(this, s, publisherRes));
    L39:
        publishManifestShortcuts(newManifestShortcutList);
        if (newManifestShortcutList == null) goto L42;
        pushOutExcessShortcuts();
    L42:
        s.verifyStates();
        s.packageShortcutsChanged(this, null, null);
        return true;
    L31:
        manifestShortcutSize = newManifestShortcutList.size();
        goto L33
    L24:
        th = move-exception;
        throw th;
    L26:
        e = move-exception;
        Slog.e(TAG, "Failed to load shortcuts from AndroidManifest.xml.", e);     // Catch: Throwable -> L24
    L18:
        th = move-exception;
        s.logDurationStat(14, start);
        throw th;
    }

    private /* synthetic */ void lambda$rescanPackageIfNeeded$13(long newVersionCode, ShortcutInfo si) {
        if (si.getDisabledReason() == 100) goto L6;
        return;
    L6:
        if (getPackageInfo().getBackupSourceVersionCode() <= newVersionCode) goto L8;
        return;
    L8:
        Slog.i(TAG, String.format("Restoring shortcut: %s", new Object[]{si.getId()}));
        si.clearFlags(64);
        si.setDisabledReason(0);
    }

    private /* synthetic */ void lambda$rescanPackageIfNeeded$14(ShortcutService s, Resources publisherRes, ShortcutInfo si) {
        if (si.isDynamic() == false) goto L13;
        if (si.getActivity() != null) goto L8;
        s.wtf("null activity detected.");
        goto L13
    L8:
        if (s.injectIsMainActivity(si.getActivity(), getPackageUserId()) == true) goto L13;
        Slog.w(TAG, String.format("%s is no longer main activity. Disabling shorcut %s.", new Object[]{getPackageName(), si.getId()}));
        if (disableDynamicWithId(si.getId(), false, 2) == null) goto L13;
        return;
    L13:
        if (si.hasAnyResources() == false) goto L21;
        if (publisherRes != null) goto L17;
        return;
    L17:
        if (si.isOriginallyFromManifest() == true) goto L19;
        si.lookupAndFillInResourceIds(publisherRes);
    L19:
        si.setTimestamp(s.injectCurrentTimeMillis());
        return;
    }

    private boolean publishManifestShortcuts(List<ShortcutInfo> newManifestShortcutList) {
        boolean changed = false;
        final ArraySet<String> toDisableList = new ArraySet(1);
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda4(toDisableList));
        if (newManifestShortcutList == null) goto L24;
        int newListSize = newManifestShortcutList.size();
        int i = 0;
    L5:
        if (i >= newListSize) goto L24;
        changed = true;
        ShortcutInfo newShortcut = newManifestShortcutList.get(i);
        boolean newDisabled = !newShortcut.isEnabled();
        String id = newShortcut.getId();
        ShortcutInfo oldShortcut = findShortcutById(id);
        boolean wasPinned = false;
        if (oldShortcut != null) goto L9;
    L14:
        if (newDisabled == false) goto L17;
        if (wasPinned == true) goto L17;
    L22:
        i = i + 1;
    L17:
        forceReplaceShortcutInner(newShortcut);
        if (newDisabled == true) goto L22;
        if (toDisableList.isEmpty() == true) goto L22;
        toDisableList.remove(id);
        goto L22
    L9:
        if (oldShortcut.isOriginallyFromManifest() == true) goto L12;
        Slog.e(TAG, "Shortcut with ID=" + newShortcut.getId() + " exists but is not from AndroidManifest.xml, not updating.");
        goto L22
    L12:
        if (oldShortcut.isPinned() == false) goto L14;
        wasPinned = true;
        newShortcut.addFlags(2);
    L24:
        if (toDisableList.isEmpty() == true) goto L29;
        int i2 = toDisableList.size() - 1;
    L26:
        if (i2 < 0) goto L28;
        changed = true;
        disableWithId(toDisableList.valueAt(i2), null, 0, true, false, 2);
        i2 = i2 - 1;
        goto L26
    L28:
        removeOrphans();
    L29:
        adjustRanks();
        return changed;
    }

    private static /* synthetic */ void lambda$publishManifestShortcuts$15(ArraySet toDisableList, ShortcutInfo si) {
        if (si.isManifestShortcut() == false) goto L6;
        toDisableList.add(si.getId());
        return;
    }

    private boolean pushOutExcessShortcuts() {
        ShortcutService service = this.mShortcutUser.mService;
        int maxShortcuts = service.getMaxActivityShortcuts();
        ArrayMap<ComponentName, ArrayList<ShortcutInfo>> all = sortShortcutsToActivities();
        int outer = all.size() - 1;
    L3:
        if (outer < 0) goto L16;
        ArrayList<ShortcutInfo> list = all.valueAt(outer);
        if (list.size() <= maxShortcuts) goto L14;
        Collections.sort(list, this.mShortcutTypeAndRankComparator);
        int inner = list.size() - 1;
    L8:
        if (inner < maxShortcuts) goto L14;
        ShortcutInfo shortcut = list.get(inner);
        if (shortcut.isManifestShortcut() == false) goto L12;
        service.wtf("Found manifest shortcuts in excess list.");
    L13:
        inner = inner - 1;
        goto L8
    L12:
        deleteDynamicWithId(shortcut.getId(), true);
    L14:
        outer = outer - 1;
        goto L3
    L16:
        return false;
    }

    private static /* synthetic */ int lambda$new$16(ShortcutInfo a, ShortcutInfo b) {
        if (a.isManifestShortcut() == false) goto L9;
        if (b.isManifestShortcut() == true) goto L9;
        return -1;
    L9:
        if (a.isManifestShortcut() == true) goto L15;
        if (b.isManifestShortcut() == false) goto L15;
        return 1;
    L15:
        return Integer.compare(a.getRank(), b.getRank());
    }

    private static /* synthetic */ int lambda$new$17(ShortcutInfo a, ShortcutInfo b) {
        if (a.isDeclaredInManifest() == false) goto L8;
        if (b.isDeclaredInManifest() == true) goto L8;
        return -1;
    L8:
        if (a.isDeclaredInManifest() == true) goto L13;
        if (b.isDeclaredInManifest() == false) goto L13;
        return 1;
    L13:
        if (a.isDynamic() == false) goto L19;
        if (b.isDynamic() == false) goto L19;
        return Integer.compare(a.getRank(), b.getRank());
    L19:
        if (a.isDynamic() == false) goto L22;
        return -1;
    L22:
        if (b.isDynamic() == false) goto L25;
        return 1;
    L25:
        if (a.isCached() == false) goto L49;
        if (b.isCached() == false) goto L49;
        if (a.hasFlags(536870912) == false) goto L34;
        if (b.hasFlags(536870912) == true) goto L34;
        return -1;
    L34:
        if (a.hasFlags(536870912) == true) goto L39;
        if (b.hasFlags(536870912) == false) goto L39;
        return 1;
    L39:
        if (a.hasFlags(1073741824) == false) goto L44;
        if (b.hasFlags(1073741824) == true) goto L44;
        return -1;
    L44:
        if (a.hasFlags(1073741824) == true) goto L49;
        if (b.hasFlags(1073741824) == false) goto L49;
        return 1;
    L49:
        if (a.isCached() == false) goto L52;
        return -1;
    L52:
        if (b.isCached() == false) goto L55;
        return 1;
    L55:
        return Long.compare(b.getLastChangedTimestamp(), a.getLastChangedTimestamp());
    }

    private ArrayMap<ComponentName, ArrayList<ShortcutInfo>> sortShortcutsToActivities() {
        final ArrayMap<ComponentName, ArrayList<ShortcutInfo>> activitiesToShortcuts = new ArrayMap();
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda1(this, activitiesToShortcuts));
        return activitiesToShortcuts;
    }

    private /* synthetic */ void lambda$sortShortcutsToActivities$19(ArrayMap activitiesToShortcuts, ShortcutInfo si) {
        if (si.isFloating() == false) goto L5;
        return;
    L5:
        ComponentName activity = si.getActivity();
        if (activity != null) goto L9;
        this.mShortcutUser.mService.wtf("null activity detected.");
        return;
    L9:
        ArrayList<ShortcutInfo> list = (ArrayList) activitiesToShortcuts.computeIfAbsent(activity, new ShortcutPackage$$ExternalSyntheticLambda20());
        list.add(si);
    }

    private static /* synthetic */ ArrayList lambda$sortShortcutsToActivities$18(ComponentName k) {
        return new ArrayList();
    }

    private void incrementCountForActivity(ArrayMap<ComponentName, Integer> counts, ComponentName cn, int increment) {
        Integer oldValue = counts.get(cn);
        if (oldValue != null) goto L5;
        oldValue = 0;
    L5:
        counts.put(cn, Integer.valueOf(oldValue.intValue() + increment));
    }

    public void enforceShortcutCountsBeforeOperation(List<ShortcutInfo> newList, final int operation) {
        ShortcutService service = this.mShortcutUser.mService;
        final ArrayMap<ComponentName, Integer> counts = new ArrayMap(4);
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda22(this, counts, operation));
        int i = newList.size() - 1;
    L3:
        if (i < 0) goto L23;
        ShortcutInfo newShortcut = newList.get(i);
        ComponentName newActivity = newShortcut.getActivity();
        if (newActivity != null) goto L8;
        if (operation == 2) goto L22;
        service.wtf("Activity must not be null at this point");
    L22:
        i = i - 1;
        goto L3
    L8:
        ShortcutInfo original = findShortcutById(newShortcut.getId());
        if (original != null) goto L14;
        if (operation == 2) goto L22;
        incrementCountForActivity(counts, newActivity, 1);
        goto L22
    L14:
        if (original.isFloating() == false) goto L17;
        if (operation == 2) goto L22;
    L17:
        if (operation == 0) goto L21;
        ComponentName oldActivity = original.getActivity();
        if (original.isFloating() == true) goto L21;
        incrementCountForActivity(counts, oldActivity, -1);
    L21:
        incrementCountForActivity(counts, newActivity, 1);
        goto L22
    L23:
        int i2 = counts.size();
        int i3 = i2 - 1;
    L24:
        if (i3 < 0) goto L27;
        service.enforceMaxActivityShortcuts(counts.valueAt(i3).intValue());
        i3 = i3 - 1;
        goto L24
    }

    private /* synthetic */ void lambda$enforceShortcutCountsBeforeOperation$20(ArrayMap counts, int operation, ShortcutInfo shortcut) {
        if (shortcut.isManifestShortcut() == false) goto L6;
        incrementCountForActivity(counts, shortcut.getActivity(), 1);
        return;
    L6:
        if (shortcut.isDynamic() == false) goto L11;
        if (operation == 0) goto L12;
        incrementCountForActivity(counts, shortcut.getActivity(), 1);
        return;
    L12:
        return;
    }

    public void resolveResourceStrings() {
        final ShortcutService s = this.mShortcutUser.mService;
        final Resources publisherRes = getPackageResources();
        final List<ShortcutInfo> changedShortcuts = new ArrayList(1);
        if (publisherRes == null) goto L6;
        forEachShortcutMutate(new ShortcutPackage$$ExternalSyntheticLambda23(publisherRes, s, changedShortcuts));
    L6:
        if (CollectionUtils.isEmpty(changedShortcuts) == true) goto L9;
        s.packageShortcutsChanged(this, changedShortcuts, null);
        return;
    }

    private static /* synthetic */ void lambda$resolveResourceStrings$21(Resources publisherRes, ShortcutService s, List changedShortcuts, ShortcutInfo si) {
        if (si.hasStringResources() == true) goto L5;
        return;
    L5:
        si.resolveResourceStrings(publisherRes);
        si.setTimestamp(s.injectCurrentTimeMillis());
        changedShortcuts.add(si);
    }

    public void clearAllImplicitRanks() {
        forEachShortcutMutate(new ShortcutPackage$$ExternalSyntheticLambda39());
    }

    private static /* synthetic */ int lambda$new$22(ShortcutInfo a, ShortcutInfo b) {
        int ret = Integer.compare(a.getRank(), b.getRank());
        if (ret == 0) goto L6;
        return ret;
    L6:
        if (a.isRankChanged() != b.isRankChanged()) goto L8;
        int ret2 = Integer.compare(a.getImplicitRank(), b.getImplicitRank());
        if (ret2 == 0) goto L16;
        return ret2;
    L16:
        return a.getId().compareTo(b.getId());
    L8:
        if (a.isRankChanged() == false) goto L10;
        return -1;
    L10:
        return 1;
    }

    public void adjustRanks() {
        ShortcutService s = this.mShortcutUser.mService;
        final long now = s.injectCurrentTimeMillis();
        forEachShortcutMutate(new ShortcutPackage$$ExternalSyntheticLambda35(now));
        ArrayMap<ComponentName, ArrayList<ShortcutInfo>> all = sortShortcutsToActivities();
        int outer = all.size() - 1;
    L3:
        if (outer < 0) goto L19;
        ArrayList<ShortcutInfo> list = all.valueAt(outer);
        Collections.sort(list, this.mShortcutRankComparator);
        final int thisRank = 0;
        int size = list.size();
        int i = 0;
    L5:
        if (i >= size) goto L17;
        ShortcutInfo si = list.get(i);
        if (si.isManifestShortcut() == true) goto L16;
        if (si.isDynamic() == true) goto L12;
        s.wtf("Non-dynamic shortcut found. " + si.toInsecureString());
        goto L16
    L12:
        int rank = thisRank + 1;
        if (si.getRank() == thisRank) goto L15;
        mutateShortcut(si.getId(), si, new ShortcutPackage$$ExternalSyntheticLambda36(now, thisRank));
    L15:
        thisRank = rank;
    L16:
        i = i + 1;
        goto L5
    L17:
        outer = outer - 1;
        goto L3
    }

    private static /* synthetic */ void lambda$adjustRanks$23(long now, ShortcutInfo si) {
        if (si.isFloating() == true) goto L5;
        return;
    L5:
        if (si.getRank() == 0) goto L9;
        si.setTimestamp(now);
        si.setRank(0);
        return;
    }

    private static /* synthetic */ void lambda$adjustRanks$24(long now, int thisRank, ShortcutInfo shortcut) {
        shortcut.setTimestamp(now);
        shortcut.setRank(thisRank);
    }

    public boolean hasNonManifestShortcuts() {
        final boolean[] condition = new boolean[1];
        forEachShortcutStopWhen(new ShortcutPackage$$ExternalSyntheticLambda0(condition));
        return condition[0];
    }

    private static /* synthetic */ Boolean lambda$hasNonManifestShortcuts$25(boolean[] condition, ShortcutInfo si) {
        if (si.isDeclaredInManifest() == true) goto L7;
        condition[0] = true;
        return true;
    L7:
        return false;
    }

    void reportShortcutUsed(UsageStatsManagerInternal usageStatsManagerInternal, String shortcutId) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        long currentTS = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        ShortcutService s = this.mShortcutUser.mService;     // Catch: Throwable -> L11
        if ((currentTS - this.mLastReportedTime) <= s.mSaveDelayMillis) goto L16;
        this.mLastReportedTime = currentTS;     // Catch: Throwable -> L11
        long token = s.injectClearCallingIdentity();     // Catch: Throwable -> L11
        usageStatsManagerInternal.reportShortcutUsage(getPackageName(), shortcutId, getPackageUserId());     // Catch: Throwable -> L13
        s.injectRestoreCallingIdentity(token);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        th = move-exception;
        s.injectRestoreCallingIdentity(token);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void dump(final PrintWriter pw, final String prefix, ShortcutService.DumpFilter filter) {
        pw.println();
        pw.print(prefix);
        pw.print("Package: ");
        pw.print(getPackageName());
        pw.print("  UID: ");
        pw.print(this.mPackageUid);
        pw.println();
        pw.print(prefix);
        pw.print("  ");
        pw.print("Calls: ");
        pw.print(getApiCallCount(false));
        pw.println();
        pw.print(prefix);
        pw.print("  ");
        pw.print("Last known FG: ");
        pw.print(this.mLastKnownForegroundElapsedTime);
        pw.println();
        pw.print(prefix);
        pw.print("  ");
        pw.print("Last reset: [");
        pw.print(this.mLastResetTime);
        pw.print("] ");
        pw.print(ShortcutService.formatTime(this.mLastResetTime));
        pw.println();
        getPackageInfo().dump(pw, prefix + "  ");
        pw.println();
        pw.print(prefix);
        pw.println("  Shortcuts:");
        final long[] totalBitmapSize = new long[1];
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda29(pw, prefix, totalBitmapSize));
        pw.print(prefix);
        pw.print("  ");
        pw.print("Total bitmap size: ");
        pw.print(totalBitmapSize[0]);
        pw.print(" (");
        pw.print(Formatter.formatFileSize(this.mShortcutUser.mService.mContext, totalBitmapSize[0]));
        pw.println(")");
        pw.println();
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        this.mShortcutBitmapSaver.dumpLocked(pw, "  ");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dump$26(PrintWriter pw, String prefix, long[] totalBitmapSize, ShortcutInfo si) {
        pw.println(si.toDumpString(prefix + "    "));
        if (si.getBitmapPath() == null) goto L6;
        long len = new File(si.getBitmapPath()).length();
        pw.print(prefix);
        pw.print("      ");
        pw.print("bitmap size=");
        pw.println(len);
        totalBitmapSize[0] = totalBitmapSize[0] + len;
        return;
    }

    public void dumpShortcuts(final PrintWriter pw, int matchFlags) {
        int r1 = 1;
        int r2 = 0;
        if ((matchFlags & 2) == 0) goto L5;
        boolean matchDynamic = true;
    L7:
        if ((matchFlags & 4) == 0) goto L9;
        boolean matchPinned = true;
    L11:
        if ((matchFlags & 1) == 0) goto L13;
        boolean matchManifest = true;
    L15:
        if ((matchFlags & 8) == 0) goto L17;
        boolean matchCached = true;
    L18:
        if (matchDynamic == true) goto L21;
        r1 = 0;
    L21:
        if (matchPinned == false) goto L23;
        int r6 = 2;
    L24:
        int r3 = r1 | r6;
        if (matchManifest == false) goto L27;
        int r7 = 32;
    L28:
        int r4 = r3 | r7;
        if (matchCached == false) goto L31;
        r2 = 1610629120;
    L31:
        final int shortcutFlags = r4 | r2;
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda33(shortcutFlags, pw));
        return;
    L27:
        r7 = 0;
        goto L28
    L23:
        r6 = 0;
        goto L24
    L17:
        matchCached = false;
        goto L18
    L13:
        matchManifest = false;
        goto L15
    L9:
        matchPinned = false;
        goto L11
    L5:
        matchDynamic = false;
        goto L7
    }

    private static /* synthetic */ void lambda$dumpShortcuts$27(int shortcutFlags, PrintWriter pw, ShortcutInfo si) {
        if ((si.getFlags() & shortcutFlags) == 0) goto L6;
        pw.println(si.toDumpString(""));
        return;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    public JSONObject dumpCheckin(boolean clear) throws JSONException {
        JSONObject result = super.dumpCheckin(clear);
        final int[] numDynamic = new int[1];
        final int[] numPinned = new int[1];
        final int[] numManifest = new int[1];
        final int[] numBitmaps = new int[1];
        final long[] totalBitmapSize = new long[1];
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda37(numDynamic, numManifest, numPinned, numBitmaps, totalBitmapSize));
        result.put(KEY_DYNAMIC, numDynamic[0]);
        result.put(KEY_MANIFEST, numManifest[0]);
        result.put(KEY_PINNED, numPinned[0]);
        result.put(KEY_BITMAPS, numBitmaps[0]);
        result.put(KEY_BITMAP_BYTES, totalBitmapSize[0]);
        return result;
    }

    private static /* synthetic */ void lambda$dumpCheckin$28(int[] numDynamic, int[] numManifest, int[] numPinned, int[] numBitmaps, long[] totalBitmapSize, ShortcutInfo si) {
        if (si.isDynamic() == false) goto L6;
        numDynamic[0] = numDynamic[0] + 1;
    L6:
        if (si.isDeclaredInManifest() == false) goto L9;
        numManifest[0] = numManifest[0] + 1;
    L9:
        if (si.isPinned() == false) goto L12;
        numPinned[0] = numPinned[0] + 1;
    L12:
        if (si.getBitmapPath() == null) goto L15;
        numBitmaps[0] = numBitmaps[0] + 1;
        totalBitmapSize[0] = totalBitmapSize[0] + new File(si.getBitmapPath()).length();
        return;
    }

    private boolean hasNoShortcut() {
        if (getShortcutCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    public void saveToXml(TypedXmlSerializer out, boolean forBackup) throws IOException, XmlPullParserException {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        int size = this.mShortcuts.size();     // Catch: Throwable -> L11
        int shareTargetSize = this.mShareTargets.size();     // Catch: Throwable -> L11
        if (hasNoShortcut() == false) goto L13;
        if (shareTargetSize != 0) goto L13;
        if (this.mApiCallCount != 0) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        out.startTag(null, "package");     // Catch: Throwable -> L11
        ShortcutService.writeAttr(out, "name", getPackageName());     // Catch: Throwable -> L11
        ShortcutService.writeAttr(out, ATTR_CALL_COUNT, this.mApiCallCount);     // Catch: Throwable -> L11
        ShortcutService.writeAttr(out, ATTR_LAST_RESET, this.mLastResetTime);     // Catch: Throwable -> L11
        getPackageInfo().saveToXml(this.mShortcutUser.mService, out, forBackup);     // Catch: Throwable -> L11
        int j = 0;
    L14:
        if (j >= size) goto L17;
        ShortcutInfo si = this.mShortcuts.valueAt(j);     // Catch: Throwable -> L11
        saveShortcut(out, si, forBackup, getPackageInfo().isBackupAllowed());     // Catch: Throwable -> L11
        j = j + 1;     // Catch: Throwable -> L11
        goto L14
    L17:
        if (forBackup == true) goto L21;
        int j2 = 0;
    L19:
        if (j2 >= shareTargetSize) goto L21;
        this.mShareTargets.get(j2).saveToXml(out);     // Catch: Throwable -> L11
        j2 = j2 + 1;     // Catch: Throwable -> L11
    L21:
        out.endTag(null, "package");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void saveShortcut(TypedXmlSerializer out, ShortcutInfo si, boolean forBackup, boolean appSupportsBackup) throws IOException, XmlPullParserException {
        ShortcutService s = this.mShortcutUser.mService;
        if (forBackup == true) goto L5;
    L9:
        if (forBackup == false) goto L13;
        if (appSupportsBackup == true) goto L13;
        boolean shouldBackupDetails = false;
    L15:
        if (si.isIconPendingSave() == false) goto L17;
        ShortcutInfo r4 = si;
        removeIcon(r4);
    L18:
        out.startTag(null, TAG_SHORTCUT);
        ShortcutService.writeAttr(out, ATTR_ID, r4.getId());
        ShortcutService.writeAttr(out, "activity", r4.getActivity());
        ShortcutService.writeAttr(out, ATTR_TITLE, r4.getTitle());
        ShortcutService.writeAttr(out, ATTR_TITLE_RES_ID, r4.getTitleResId());
        ShortcutService.writeAttr(out, ATTR_TITLE_RES_NAME, r4.getTitleResName());
        ShortcutService.writeAttr(out, ATTR_SPLASH_SCREEN_THEME_NAME, r4.getStartingThemeResName());
        ShortcutService.writeAttr(out, ATTR_TEXT, r4.getText());
        ShortcutService.writeAttr(out, ATTR_TEXT_RES_ID, r4.getTextResId());
        ShortcutService.writeAttr(out, ATTR_TEXT_RES_NAME, r4.getTextResName());
        if (shouldBackupDetails == false) goto L21;
        ShortcutService.writeAttr(out, ATTR_DISABLED_MESSAGE, r4.getDisabledMessage());
        ShortcutService.writeAttr(out, ATTR_DISABLED_MESSAGE_RES_ID, r4.getDisabledMessageResourceId());
        ShortcutService.writeAttr(out, ATTR_DISABLED_MESSAGE_RES_NAME, r4.getDisabledMessageResName());
    L21:
        ShortcutService.writeAttr(out, ATTR_DISABLED_REASON, r4.getDisabledReason());
        ShortcutService.writeAttr(out, "timestamp", r4.getLastChangedTimestamp());
        LocusId locusId = r4.getLocusId();
        if (locusId == null) goto L25;
        ShortcutService.writeAttr(out, ATTR_LOCUS_ID, r4.getLocusId().getId());
    L25:
        if (forBackup == false) goto L30;
        int flags = r4.getFlags() & (-35342);
        ShortcutService.writeAttr(out, ATTR_FLAGS, flags);
        long packageVersionCode = getPackageInfo().getVersionCode();
        if (packageVersionCode != 0) goto L31;
        s.wtf("Package version code should be available at this point.");
    L31:
        if (shouldBackupDetails == false) goto L55;
        Set<String> cat = r4.getCategories();
        if (cat != null) goto L35;
    L37:
        if (forBackup == true) goto L44;
        Person[] persons = r4.getPersons();
        if (ArrayUtils.isEmpty(persons) == true) goto L44;
        int i = 0;
    L42:
        if (i >= persons.length) goto L44;
        Person p = persons[i];
        out.startTag(null, TAG_PERSON);
        ShortcutService.writeAttr(out, "name", p.getName());
        ShortcutService.writeAttr(out, ATTR_PERSON_URI, p.getUri());
        ShortcutService.writeAttr(out, ATTR_PERSON_KEY, p.getKey());
        ShortcutService.writeAttr(out, ATTR_PERSON_IS_BOT, p.isBot());
        ShortcutService.writeAttr(out, ATTR_PERSON_IS_IMPORTANT, p.isImportant());
        out.endTag(null, TAG_PERSON);
        i = i + 1;
    L44:
        Intent[] intentsNoExtras = r4.getIntentsNoExtras();
        PersistableBundle[] intentsExtras = r4.getIntentPersistableExtrases();
        if (intentsNoExtras == null) goto L50;
        if (intentsExtras == null) goto L50;
        int numIntents = intentsNoExtras.length;
        int i2 = 0;
    L48:
        if (i2 >= numIntents) goto L50;
        out.startTag(null, "intent");
        ShortcutService.writeAttr(out, ATTR_INTENT_NO_EXTRA, intentsNoExtras[i2]);
        ShortcutService.writeTagExtra(out, TAG_EXTRAS, intentsExtras[i2]);
        out.endTag(null, "intent");
        i2 = i2 + 1;
    L50:
        ShortcutService.writeTagExtra(out, TAG_EXTRAS, r4.getExtras());
        Map<String, Map<String, List<String>>> capabilityBindings = r4.getCapabilityBindingsInternal();
        if (capabilityBindings == null) goto L55;
        if (capabilityBindings.isEmpty() == true) goto L55;
        XmlUtils.writeMapXml(capabilityBindings, NAME_CAPABILITY, out);
        goto L55
    L35:
        if (cat.size() <= 0) goto L37;
        out.startTag(null, "categories");
        XmlUtils.writeStringArrayXml((String[]) cat.toArray(new String[cat.size()]), "categories", XmlUtils.makeTyped(out));
        out.endTag(null, "categories");
    L55:
        out.endTag(null, TAG_SHORTCUT);
        return;
    L30:
        ShortcutService.writeAttr(out, ATTR_RANK, r4.getRank());
        ShortcutService.writeAttr(out, ATTR_FLAGS, r4.getFlags());
        ShortcutService.writeAttr(out, ATTR_ICON_RES_ID, r4.getIconResourceId());
        ShortcutService.writeAttr(out, ATTR_ICON_RES_NAME, r4.getIconResName());
        ShortcutService.writeAttr(out, ATTR_BITMAP_PATH, r4.getBitmapPath());
        ShortcutService.writeAttr(out, ATTR_ICON_URI, r4.getIconUri());
        goto L31
    L17:
        r4 = si;
    L13:
        shouldBackupDetails = true;
        goto L15
    L5:
        if (si.isPinned() == true) goto L7;
        return;
    L7:
        if (si.isEnabled() == true) goto L9;
    }

    public static ShortcutPackage loadFromFile(ShortcutService s, ShortcutUser shortcutUser, File path, boolean fromBackup) {
        ResilientAtomicFile file = ShortcutPackageItem.getResilientFile(path);
        FileInputStream in = file.openRead();     // Catch: Throwable -> L8 Exception -> L10
        if (in != null) goto L12;
        Slog.d(TAG, "Not found " + path);     // Catch: Throwable -> L8 Exception -> L10
        file.close();
        return null;
    L12:
        ShortcutPackage ret = null;
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L8 Exception -> L10
    L14:
        int type = parser.next();     // Catch: Throwable -> L8 Exception -> L10
        if (type == 1) goto L26;
        if (type != 2) goto L14;
        int depth = parser.getDepth();     // Catch: Throwable -> L8 Exception -> L10
        String tag = parser.getName();     // Catch: Throwable -> L8 Exception -> L10
        if (depth != 1) goto L24;
        if ("package".equals(tag) == false) goto L24;
        ret = loadFromXml(s, shortcutUser, parser, fromBackup);     // Catch: Throwable -> L8 Exception -> L10
    L24:
        ShortcutService.throwForInvalidTag(depth, tag);     // Catch: Throwable -> L8 Exception -> L10
        goto L14
    L26:
        file.close();
        return ret;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to read file " + file.getBaseFile(), e);     // Catch: Throwable -> L8
        file.failRead(null, e);     // Catch: Throwable -> L8
        ShortcutPackage r0 = loadFromFile(s, shortcutUser, path, fromBackup);     // Catch: Throwable -> L8
        file.close();
        return r0;
    L8:
        th = move-exception;
        if (file != null) goto L40;
    L37:
        throw th;
    L40:
        file.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);
        goto L37
    }

    public static ShortcutPackage loadFromXml(ShortcutService s, ShortcutUser shortcutUser, TypedXmlPullParser parser, boolean fromBackup) throws IOException, XmlPullParserException {
        String packageName = ShortcutService.parseStringAttribute(parser, "name");
        ShortcutPackage ret = new ShortcutPackage(shortcutUser, shortcutUser.getUserId(), packageName);
        Object r2 = ret.mPackageItemLock;
        monitor-enter(r2);
        ret.mApiCallCount = ShortcutService.parseIntAttribute(parser, ATTR_CALL_COUNT);     // Catch: Throwable -> L12
        ret.mLastResetTime = ShortcutService.parseLongAttribute(parser, ATTR_LAST_RESET);     // Catch: Throwable -> L12
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L12
    L5:
        int type = parser.next();     // Catch: Throwable -> L12
        byte r6 = 1;
        if (type == 1) goto L49;
        if (type != 3) goto L15;
        if (parser.getDepth() <= outerDepth) goto L49;
    L15:
        if (type != 2) goto L5;
        int depth = parser.getDepth();     // Catch: Throwable -> L12
        String tag = parser.getName();     // Catch: Throwable -> L12
        if (depth != (outerDepth + 1)) goto L48;
        switch(tag.hashCode()) {
            case -1923478059: goto L29;
            case -1680817345: goto L26;
            case -342500282: goto L23;
            default: goto L31;
        };     // Catch: Throwable -> L12
    L31:
        r6 = -1;
    L32:
        switch(r6) {
            case 0: goto L47;
            case 1: goto L54;
            case 2: goto L34;
            default: goto L48;
        };     // Catch: Throwable -> L12
    L54:
        ShortcutInfo si = parseShortcut(parser, packageName, shortcutUser.getUserId(), fromBackup);     // Catch: Throwable -> L12 Exception -> L39 IOException -> L41
        ret.mShortcuts.put(si.getId(), si);     // Catch: Throwable -> L12 Exception -> L39 IOException -> L41
    L41:
        e = move-exception;
        throw e;     // Catch: Throwable -> L12
    L39:
        e = move-exception;
        Slog.e(TAG, "Failed parsing shortcut.", e);     // Catch: Throwable -> L12
        goto L5
    L47:
        ret.getPackageInfo().loadFromXml(parser, fromBackup);     // Catch: Throwable -> L12
        goto L5
    L34:
        ret.mShareTargets.add(ShareTargetInfo.loadFromXml(parser));     // Catch: Throwable -> L12
        goto L5
    L23:
        if (tag.equals(TAG_SHORTCUT) == false) goto L31;
    L26:
        if (tag.equals(TAG_SHARE_TARGET) == false) goto L31;
        r6 = 2;
        goto L32
    L29:
        if (tag.equals("package-info") == false) goto L31;
        r6 = 0;
    L48:
        ShortcutService.warnForInvalidTag(depth, tag);     // Catch: Throwable -> L12
    L49:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return ret;
    L12:
        th = move-exception;
        throw th;
    }

    private static ShortcutInfo parseShortcut(TypedXmlPullParser parser, String packageName, int userId, boolean fromBackup) throws IOException, XmlPullParserException {
        PersistableBundle intentPersistableExtrasLegacy = null;
        ArrayList<Intent> intents = new ArrayList();
        ArrayList<Person> persons = new ArrayList();
        String id = ShortcutService.parseStringAttribute(parser, ATTR_ID);
        ComponentName activityComponent = ShortcutService.parseComponentNameAttribute(parser, "activity");
        String title = ShortcutService.parseStringAttribute(parser, ATTR_TITLE);
        int titleResId = ShortcutService.parseIntAttribute(parser, ATTR_TITLE_RES_ID);
        String titleResName = ShortcutService.parseStringAttribute(parser, ATTR_TITLE_RES_NAME);
        String splashScreenThemeResName = ShortcutService.parseStringAttribute(parser, ATTR_SPLASH_SCREEN_THEME_NAME);
        String text = ShortcutService.parseStringAttribute(parser, ATTR_TEXT);
        int textResId = ShortcutService.parseIntAttribute(parser, ATTR_TEXT_RES_ID);
        String textResName = ShortcutService.parseStringAttribute(parser, ATTR_TEXT_RES_NAME);
        String disabledMessage = ShortcutService.parseStringAttribute(parser, ATTR_DISABLED_MESSAGE);
        int disabledMessageResId = ShortcutService.parseIntAttribute(parser, ATTR_DISABLED_MESSAGE_RES_ID);
        String disabledMessageResName = ShortcutService.parseStringAttribute(parser, ATTR_DISABLED_MESSAGE_RES_NAME);
        int disabledReason = ShortcutService.parseIntAttribute(parser, ATTR_DISABLED_REASON);
        String r8 = "intent";
        Intent intentLegacy = ShortcutService.parseIntentAttributeNoDefault(parser, "intent");
        ArraySet<String> categories = null;
        int rank = (int) ShortcutService.parseLongAttribute(parser, ATTR_RANK);
        long lastChangedTimestamp = ShortcutService.parseLongAttribute(parser, "timestamp");
        int flags = (int) ShortcutService.parseLongAttribute(parser, ATTR_FLAGS);
        int iconResId = (int) ShortcutService.parseLongAttribute(parser, ATTR_ICON_RES_ID);
        String iconResName = ShortcutService.parseStringAttribute(parser, ATTR_ICON_RES_NAME);
        String bitmapPath = ShortcutService.parseStringAttribute(parser, ATTR_BITMAP_PATH);
        String iconUri = ShortcutService.parseStringAttribute(parser, ATTR_ICON_URI);
        String locusIdString = ShortcutService.parseStringAttribute(parser, ATTR_LOCUS_ID);
        int outerDepth = parser.getDepth();
        Map<String, Map<String, List<String>>> capabilityBindings = null;
        PersistableBundle extras = null;
    L3:
        int type = parser.next();
        iconResId = iconResId;
        if (type == 1) goto L59;
        if (type != 3) goto L12;
        if (parser.getDepth() > outerDepth) goto L12;
        LocusId r10 = null;
    L60:
        if (intentLegacy == null) goto L62;
        ShortcutInfo.setIntentExtras(intentLegacy, intentPersistableExtrasLegacy);
        intents.clear();
        intents.add(intentLegacy);
    L62:
        if (disabledReason == 0) goto L64;
    L66:
        int disabledReason2 = disabledReason;
    L67:
        if (fromBackup == false) goto L69;
        int flags2 = flags | 4096;
    L70:
        if (locusIdString != null) goto L72;
        LocusId locusId = r10;
    L74:
        return new ShortcutInfo(userId, id, packageName, activityComponent, null, title, titleResId, titleResName, text, textResId, textResName, disabledMessage, disabledMessageResId, disabledMessageResName, categories, (Intent[]) intents.toArray(new Intent[intents.size()]), rank, extras, lastChangedTimestamp, flags2, iconResId, iconResName, bitmapPath, iconUri, disabledReason2, (Person[]) persons.toArray(new Person[persons.size()]), locusId, splashScreenThemeResName, capabilityBindings);
    L72:
        locusId = new LocusId(locusIdString);
        goto L74
    L69:
        flags2 = flags;
        goto L70
    L64:
        if ((flags & 64) == 0) goto L66;
        disabledReason2 = 1;
    L12:
        if (type != 2) goto L13;
        int depth = parser.getDepth();
        String tag = parser.getName();
        int outerDepth2 = outerDepth;
        String id2 = id;
        switch(tag.hashCode()) {
            case -1289032093: goto L35;
            case -1183762788: goto L32;
            case -1044333900: goto L29;
            case -1024600675: goto L26;
            case -991716523: goto L23;
            case 107868: goto L20;
            case 1296516636: goto L18;
            default: goto L16;
        };
    L16:
        ComponentName activityComponent2 = activityComponent;
    L38:
        byte r12 = -1;
    L39:
        String r35 = r8;
        switch(r12) {
            case 0: goto L58;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L57;
            case 4: goto L53;
            case 5: goto L47;
            case 6: goto L44;
            default: goto L42;
        };
    L42:
        throw ShortcutService.throwForInvalidTag(depth, tag);
    L55:
        extras = PersistableBundle.restoreFromXml(parser);
        activityComponent = activityComponent2;
        r8 = r35;
        outerDepth = outerDepth2;
        id = id2;
        goto L3
    L58:
        intentPersistableExtrasLegacy = PersistableBundle.restoreFromXml(parser);
        activityComponent = activityComponent2;
        r8 = r35;
        outerDepth = outerDepth2;
        id = id2;
        goto L3
    L47:
        if ("categories".equals(ShortcutService.parseStringAttribute(parser, "name")) == false) goto L57;
        String[] ar = XmlUtils.readThisStringArrayXml(XmlUtils.makeTyped(parser), TAG_STRING_ARRAY_XMLUTILS, null);
        ArraySet<String> categories2 = new ArraySet(ar.length);
        int i = 0;
    L50:
        if (i >= ar.length) goto L52;
        categories2.add(ar[i]);
        i = i + 1;
        goto L50
    L52:
        categories = categories2;
        activityComponent = activityComponent2;
        r8 = r35;
        outerDepth = outerDepth2;
        id = id2;
        goto L3
    L53:
        persons.add(parsePerson(parser));
        goto L57
    L56:
        intents.add(parseIntent(parser));
    L57:
        activityComponent = activityComponent2;
        r8 = r35;
        outerDepth = outerDepth2;
        id = id2;
        goto L3
    L44:
        if (NAME_CAPABILITY.equals(ShortcutService.parseStringAttribute(parser, "name")) == false) goto L57;
        capabilityBindings = (Map) XmlUtils.readValueXml(parser, new String[1]);
        activityComponent = activityComponent2;
        r8 = r35;
        outerDepth = outerDepth2;
        id = id2;
        goto L3
    L20:
        activityComponent2 = activityComponent;
        if (tag.equals(TAG_MAP_XMLUTILS) == false) goto L38;
        r12 = 6;
        goto L39
    L23:
        activityComponent2 = activityComponent;
        if (tag.equals(TAG_PERSON) == false) goto L38;
        r12 = 4;
        goto L39
    L26:
        activityComponent2 = activityComponent;
        if (tag.equals(TAG_STRING_ARRAY_XMLUTILS) == false) goto L38;
        r12 = 5;
        goto L39
    L29:
        activityComponent2 = activityComponent;
        if (tag.equals(TAG_INTENT_EXTRAS_LEGACY) == false) goto L38;
        r12 = 0;
        goto L39
    L32:
        activityComponent2 = activityComponent;
        if (tag.equals(r8) == false) goto L38;
        r12 = 1;
        goto L39
    L35:
        activityComponent2 = activityComponent;
        if (tag.equals(TAG_EXTRAS) == false) goto L38;
        r12 = 2;
        goto L39
    L18:
        if (tag.equals("categories") == false) goto L16;
        activityComponent2 = activityComponent;
        r12 = 3;
        goto L39
    L13:
        outerDepth2 = outerDepth;
        r35 = r8;
        id2 = id;
        activityComponent2 = activityComponent;
        goto L57
    L59:
        r10 = null;
        goto L60
    }

    private static Intent parseIntent(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        Intent intent = ShortcutService.parseIntentAttribute(parser, ATTR_INTENT_NO_EXTRA);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L23;
        if (type != 3) goto L10;
        if (parser.getDepth() <= outerDepth) goto L23;
    L10:
        if (type != 2) goto L3;
        int depth = parser.getDepth();
        String tag = parser.getName();
        switch(tag.hashCode()) {
            case -1289032093: goto L16;
            default: goto L18;
        };
    L18:
        byte r5 = -1;
    L19:
        switch(r5) {
            case 0: goto L22;
            default: goto L21;
        };
    L22:
        ShortcutInfo.setIntentExtras(intent, PersistableBundle.restoreFromXml(parser));
        goto L3
    L21:
        throw ShortcutService.throwForInvalidTag(depth, tag);
    L16:
        if (tag.equals(TAG_EXTRAS) == false) goto L18;
        r5 = 0;
    L23:
        return intent;
    }

    private static Person parsePerson(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        CharSequence name = ShortcutService.parseStringAttribute(parser, "name");
        String uri = ShortcutService.parseStringAttribute(parser, ATTR_PERSON_URI);
        String key = ShortcutService.parseStringAttribute(parser, ATTR_PERSON_KEY);
        boolean isBot = ShortcutService.parseBooleanAttribute(parser, ATTR_PERSON_IS_BOT);
        boolean isImportant = ShortcutService.parseBooleanAttribute(parser, ATTR_PERSON_IS_IMPORTANT);
        Person.Builder builder = new Person.Builder();
        builder.setName(name).setUri(uri).setKey(key).setBot(isBot).setImportant(isImportant);
        return builder.build();
    }

    List<ShortcutInfo> getAllShortcutsForTest() {
        final List<ShortcutInfo> ret = new ArrayList(1);
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda30(ret));
        return ret;
    }

    List<ShareTargetInfo> getAllShareTargetsForTest() {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mShareTargets);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    public void verifyStates() {
        super.verifyStates();
        final boolean[] failed = new boolean[1];
        final ShortcutService s = this.mShortcutUser.mService;
        ArrayMap<ComponentName, ArrayList<ShortcutInfo>> all = sortShortcutsToActivities();
        int outer = all.size() - 1;
    L4:
        if (outer < 0) goto L9;
        ArrayList<ShortcutInfo> list = all.valueAt(outer);
        if (list.size() <= this.mShortcutUser.mService.getMaxActivityShortcuts()) goto L8;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": activity " + all.keyAt(outer) + " has " + all.valueAt(outer).size() + " shortcuts.");
    L8:
        Collections.sort(list, new ShortcutPackage$$ExternalSyntheticLambda16());
        ArrayList<ShortcutInfo> dynamicList = new ArrayList(list);
        dynamicList.removeIf(new ShortcutPackage$$ExternalSyntheticLambda17());
        ArrayList<ShortcutInfo> manifestList = new ArrayList(list);
        manifestList.removeIf(new ShortcutPackage$$ExternalSyntheticLambda18());
        verifyRanksSequential(dynamicList);
        verifyRanksSequential(manifestList);
        outer = outer - 1;
        goto L4
    L9:
        forEachShortcut(new ShortcutPackage$$ExternalSyntheticLambda19(this, failed, s));
        if (failed[0] == true) goto L13;
        return;
    L13:
        throw new IllegalStateException("See logcat for errors");
    }

    private static /* synthetic */ int lambda$verifyStates$29(ShortcutInfo a, ShortcutInfo b) {
        return Integer.compare(a.getRank(), b.getRank());
    }

    private static /* synthetic */ boolean lambda$verifyStates$30(ShortcutInfo si) {
        return !si.isDynamic();
    }

    private static /* synthetic */ boolean lambda$verifyStates$31(ShortcutInfo si) {
        return !si.isManifestShortcut();
    }

    private /* synthetic */ void lambda$verifyStates$32(boolean[] failed, ShortcutService s, ShortcutInfo si) {
        if (si.isDeclaredInManifest() == true) goto L12;
        if (si.isDynamic() == true) goto L12;
        if (si.isPinned() == true) goto L12;
        if (si.isCached() == true) goto L12;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " is not manifest, dynamic or pinned.");
    L12:
        if (si.isDeclaredInManifest() == false) goto L17;
        if (si.isDynamic() == false) goto L17;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " is both dynamic and manifest at the same time.");
    L17:
        if (si.getActivity() != null) goto L22;
        if (si.isFloating() == true) goto L22;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " has null activity, but not floating.");
    L22:
        if (si.isDynamic() == true) goto L26;
        if (si.isManifestShortcut() == true) goto L26;
    L29:
        if (si.isFloating() == false) goto L34;
        if (si.getRank() == 0) goto L34;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " is floating, but has rank=" + si.getRank());
    L34:
        if (si.getIcon() == null) goto L37;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " still has an icon");
    L37:
        if (si.hasAdaptiveBitmap() == false) goto L44;
        if (si.hasIconFile() == true) goto L44;
        if (si.hasIconUri() == true) goto L44;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " has adaptive bitmap but was not saved to a file nor has icon uri.");
    L44:
        if (si.hasIconFile() == false) goto L49;
        if (si.hasIconResource() == false) goto L49;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " has both resource and bitmap icons");
    L49:
        if (si.hasIconFile() == false) goto L54;
        if (si.hasIconUri() == false) goto L54;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " has both url and bitmap icons");
    L54:
        if (si.hasIconUri() == true) goto L56;
    L58:
        boolean r0 = si.isEnabled();
        if (si.getDisabledReason() != 0) goto L61;
        boolean r6 = true;
    L62:
        if (r0 == r6) goto L65;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " isEnabled() and getDisabledReason() disagree: " + si.isEnabled() + " vs " + si.getDisabledReason());
    L65:
        if (si.getDisabledReason() != 100) goto L70;
        if (getPackageInfo().getBackupSourceVersionCode() != (-1)) goto L70;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " RESTORED_VERSION_LOWER with no backup source version code.");
    L70:
        if (s.isDummyMainActivity(si.getActivity()) == false) goto L73;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " has a dummy target activity");
        return;
    L73:
        return;
    L61:
        r6 = false;
        goto L62
    L56:
        if (si.hasIconResource() == false) goto L58;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " has both url and resource icons");
    L26:
        if (si.isEnabled() == true) goto L29;
        failed[0] = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " is not floating, but is disabled.");
        goto L29
    }

    void mutateShortcut(String id, ShortcutInfo shortcut, Consumer<ShortcutInfo> transform) {
        id.getClass();
        transform.getClass();
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        if (shortcut != null) goto L17;
    L8:
        ShortcutInfo si = findShortcutById(id);     // Catch: Throwable -> L6
        if (si != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L12:
        transform.accept(si);     // Catch: Throwable -> L6
        saveShortcut(new ShortcutInfo[]{si});     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L17:
        transform.accept(shortcut);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void saveShortcut(ShortcutInfo... shortcuts) {
        shortcuts.getClass();
        saveShortcut(Arrays.asList(shortcuts));
    }

    private void saveShortcut(Collection<ShortcutInfo> shortcuts) {
        shortcuts.getClass();
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        Iterator<ShortcutInfo> r1 = shortcuts.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        ShortcutInfo si = r1.next();     // Catch: Throwable -> L8
        this.mShortcuts.put(si.getId(), si);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    List<ShortcutInfo> findAll(Collection<String> ids) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        Stream<String> r1 = ids.stream();     // Catch: Throwable -> L7
        final ArrayMap<String, ShortcutInfo> r2 = this.mShortcuts;     // Catch: Throwable -> L7
        r2.getClass();     // Catch: Throwable -> L7
        List<ShortcutInfo> r3 = (List) r1.map(new ShortcutPackage$$ExternalSyntheticLambda2(r2)).filter(new ShortcutPackage$$ExternalSyntheticLambda3()).collect(Collectors.toList());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    private void forEachShortcut(final Consumer<ShortcutInfo> cb) {
        forEachShortcutStopWhen(new ShortcutPackage$$ExternalSyntheticLambda34(cb));
    }

    private static /* synthetic */ Boolean lambda$forEachShortcut$33(Consumer cb, ShortcutInfo si) {
        cb.accept(si);
        return false;
    }

    private void forEachShortcutMutate(Consumer<ShortcutInfo> cb) {
        int i = this.mShortcuts.size() - 1;
    L3:
        if (i < 0) goto L6;
        ShortcutInfo si = this.mShortcuts.valueAt(i);
        cb.accept(si);
        i = i - 1;
        goto L3
    }

    private void forEachShortcutStopWhen(Function<ShortcutInfo, Boolean> cb) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        int i = this.mShortcuts.size() - 1;     // Catch: Throwable -> L10
    L5:
        if (i < 0) goto L14;
        ShortcutInfo si = this.mShortcuts.valueAt(i);     // Catch: Throwable -> L10
        if (cb.apply(si).booleanValue() == true) goto L8;
        i = i - 1;     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean verifyRanksSequential(List<ShortcutInfo> list) {
        boolean failed = false;
        int i = 0;
    L4:
        if (i >= list.size()) goto L10;
        ShortcutInfo si = list.get(i);
        if (si.getRank() == i) goto L8;
        failed = true;
        Log.e(TAG_VERIFY, "Package " + getPackageName() + ": shortcut " + si.getId() + " rank=" + si.getRank() + " but expected to be " + i);
    L8:
        i = i + 1;
        goto L4
    L10:
        return failed;
    }

    private void runAsSystem(Runnable fn) {
        long callingIdentity = Binder.clearCallingIdentity();
        fn.run();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(callingIdentity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    protected File getShortcutPackageItemFile() {
        File path = new File(this.mShortcutUser.mService.injectUserDataPath(this.mShortcutUser.getUserId()), "packages");
        String fileName = getPackageName() + ".xml";
        return new File(path, fileName);
    }
}
