package com.android.server.pm.verify.domain;

import android.content.UriRelativeFilter;
import android.content.UriRelativeFilterGroup;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.SettingsXml;
import com.android.server.pm.verify.domain.models.DomainVerificationInternalUserState;
import com.android.server.pm.verify.domain.models.DomainVerificationPkgState;
import com.android.server.pm.verify.domain.models.DomainVerificationStateMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationPersistence {
    public static final String ATTR_ACTION = "action";
    public static final String ATTR_ALLOW_LINK_HANDLING = "allowLinkHandling";
    public static final String ATTR_FILTER = "filter";
    private static final String ATTR_HAS_AUTO_VERIFY_DOMAINS = "hasAutoVerifyDomains";
    private static final String ATTR_ID = "id";
    public static final String ATTR_NAME = "name";
    private static final String ATTR_PACKAGE_NAME = "packageName";
    public static final String ATTR_PATTERN_TYPE = "pattern-type";
    private static final String ATTR_SIGNATURE = "signature";
    public static final String ATTR_STATE = "state";
    public static final String ATTR_URI_PART = "uri-part";
    public static final String ATTR_USER_ID = "userId";
    private static final String TAG = "DomainVerificationPersistence";
    public static final String TAG_ACTIVE = "active";
    public static final String TAG_DOMAIN = "domain";
    public static final String TAG_DOMAIN_VERIFICATIONS = "domain-verifications";
    public static final String TAG_ENABLED_HOSTS = "enabled-hosts";
    public static final String TAG_HOST = "host";
    public static final String TAG_PACKAGE_STATE = "package-state";
    public static final String TAG_RESTORED = "restored";
    private static final String TAG_STATE = "state";
    public static final String TAG_URI_RELATIVE_FILTER = "uri-relative-filter";
    public static final String TAG_URI_RELATIVE_FILTER_GROUP = "uri-relative-filter-group";
    public static final String TAG_URI_RELATIVE_FILTER_GROUPS = "uri-relative-filter-groups";
    public static final String TAG_USER_STATE = "user-state";
    private static final String TAG_USER_STATES = "user-states";

    public static class ReadResult {
        public final ArrayMap<String, DomainVerificationPkgState> active;
        public final ArrayMap<String, DomainVerificationPkgState> restored;

        public ReadResult(ArrayMap<String, DomainVerificationPkgState> active, ArrayMap<String, DomainVerificationPkgState> restored) {
            this.active = active;
            this.restored = restored;
        }
    }

    public DomainVerificationPersistence() {
    }

    public static void writeToXml(TypedXmlSerializer xmlSerializer, DomainVerificationStateMap<DomainVerificationPkgState> attached, ArrayMap<String, DomainVerificationPkgState> pending, ArrayMap<String, DomainVerificationPkgState> restored, int userId, Function<String, String> pkgNameToSignature) throws IOException {
        SettingsXml.Serializer serializer = SettingsXml.serializer(xmlSerializer);
        SettingsXml.WriteSection ignored = serializer.startSection(TAG_DOMAIN_VERIFICATIONS);     // Catch: Throwable -> L23
        ArraySet<DomainVerificationPkgState> active = new ArraySet();     // Catch: Throwable -> L7
        int attachedSize = attached.size();     // Catch: Throwable -> L7
        int attachedIndex = 0;
    L5:
        if (attachedIndex >= attachedSize) goto L9;
        active.add(attached.valueAt(attachedIndex));     // Catch: Throwable -> L7
        attachedIndex = attachedIndex + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int pendingSize = pending.size();     // Catch: Throwable -> L7
        int pendingIndex = 0;
    L10:
        if (pendingIndex >= pendingSize) goto L12;
        active.add(pending.valueAt(pendingIndex));     // Catch: Throwable -> L7
        pendingIndex = pendingIndex + 1;     // Catch: Throwable -> L7
        goto L10
    L12:
        SettingsXml.WriteSection activeSection = serializer.startSection(TAG_ACTIVE);     // Catch: Throwable -> L7
        writePackageStates(activeSection, active, userId, pkgNameToSignature);     // Catch: Throwable -> L35
        if (activeSection == null) goto L16;
        activeSection.close();     // Catch: Throwable -> L7
    L16:
        SettingsXml.WriteSection restoredSection = serializer.startSection(TAG_RESTORED);     // Catch: Throwable -> L7
        writePackageStates(restoredSection, restored.values(), userId, pkgNameToSignature);     // Catch: Throwable -> L27
        if (restoredSection == null) goto L20;
        restoredSection.close();     // Catch: Throwable -> L7
    L20:
        if (ignored == null) goto L25;
        ignored.close();     // Catch: Throwable -> L23
    L25:
        serializer.close();
        return;
    L27:
        th = move-exception;
        if (restoredSection != null) goto L68;
    L34:
        throw th;     // Catch: Throwable -> L7
    L68:
        restoredSection.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L7
        goto L34
    L35:
        th = move-exception;
        if (activeSection != null) goto L66;
    L42:
        throw th;     // Catch: Throwable -> L7
    L66:
        activeSection.close();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (ignored != null) goto L62;
    L49:
        throw th;     // Catch: Throwable -> L23
    L62:
        ignored.close();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (serializer != null) goto L57;
    L55:
        throw th;
    L57:
        serializer.close();     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        th.addSuppressed(th);
        goto L55
    }

    private static void writePackageStates(SettingsXml.WriteSection section, Collection<DomainVerificationPkgState> states, int userId, Function<String, String> pkgNameToSignature) throws IOException {
        if (states.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<DomainVerificationPkgState> r0 = states.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        DomainVerificationPkgState state = r0.next();
        writePkgStateToXml(section, state, userId, pkgNameToSignature);
        goto L7
    }

    public static ReadResult readFromXml(TypedXmlPullParser parentParser) throws IOException, XmlPullParserException {
        ArrayMap<String, DomainVerificationPkgState> active = new ArrayMap();
        ArrayMap<String, DomainVerificationPkgState> restored = new ArrayMap();
        SettingsXml.ChildSection child = SettingsXml.parser(parentParser).children();
    L4:
        if (child.moveToNext() == false) goto L21;
        String r3 = child.getName();
        switch(r3.hashCode()) {
            case -1422950650: goto L12;
            case -336625770: goto L9;
            default: goto L14;
        };
    L14:
        byte r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L18;
            case 1: goto L17;
            default: goto L4;
        };
    L17:
        readPackageStates(child, restored);
        goto L4
    L18:
        readPackageStates(child, active);
        goto L4
    L9:
        if (r3.equals(TAG_RESTORED) == false) goto L14;
        r4 = 1;
        goto L15
    L12:
        if (r3.equals(TAG_ACTIVE) == false) goto L14;
        r4 = 0;
        goto L15
    L21:
        return new ReadResult(active, restored);
    }

    private static void readPackageStates(SettingsXml.ReadSection section, ArrayMap<String, DomainVerificationPkgState> map) {
        SettingsXml.ChildSection child = section.children();
    L4:
        if (child.moveToNext(TAG_PACKAGE_STATE) == false) goto L9;
        DomainVerificationPkgState pkgState = createPkgStateFromXml(child);
        if (pkgState == null) goto L4;
        map.put(pkgState.getPackageName(), pkgState);
        goto L4
    }

    private static DomainVerificationPkgState createPkgStateFromXml(SettingsXml.ReadSection section) {
        String packageName = section.getString("packageName");
        String idString = section.getString(ATTR_ID);
        boolean hasAutoVerifyDomains = section.getBoolean(ATTR_HAS_AUTO_VERIFY_DOMAINS);
        String signature = section.getString(ATTR_SIGNATURE);
        if (TextUtils.isEmpty(packageName) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(idString) == true) goto L42;
        UUID id = UUID.fromString(idString);
        ArrayMap<String, Integer> stateMap = new ArrayMap();
        SparseArray<DomainVerificationInternalUserState> userStates = new SparseArray();
        ArrayMap<String, List<UriRelativeFilterGroup>> groupMap = new ArrayMap();
        SettingsXml.ChildSection child = section.children();
    L9:
        if (child.moveToNext() == false) goto L30;
        String r1 = child.getName();
        switch(r1.hashCode()) {
            case -1576041916: goto L20;
            case 109757585: goto L17;
            case 1632406025: goto L14;
            default: goto L22;
        };
    L22:
        byte r2 = -1;
    L23:
        switch(r2) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            default: goto L9;
        };
    L25:
        readUriRelativeFilterGroups(child, groupMap);
        goto L9
    L26:
        readUserStates(child, userStates);
        goto L9
    L27:
        readDomainStates(child, stateMap);
        goto L9
    L14:
        if (r1.equals(TAG_URI_RELATIVE_FILTER_GROUPS) == false) goto L22;
        r2 = 2;
        goto L23
    L17:
        if (r1.equals("state") == false) goto L22;
        r2 = 0;
        goto L23
    L20:
        if (r1.equals("user-states") == false) goto L22;
        r2 = 1;
        goto L23
    L30:
        return new DomainVerificationPkgState(packageName, id, hasAutoVerifyDomains, stateMap, userStates, signature, groupMap);
    L42:
        return null;
    }

    private static void readUriRelativeFilterGroups(SettingsXml.ReadSection section, ArrayMap<String, List<UriRelativeFilterGroup>> groupMap) {
        SettingsXml.ChildSection child = section.children();
    L4:
        if (child.moveToNext(TAG_DOMAIN) == false) goto L6;
        String domain = child.getString("name");
        groupMap.put(domain, createUriRelativeFilterGroupsFromXml(child));
        goto L4
    }

    private static ArrayList<UriRelativeFilterGroup> createUriRelativeFilterGroupsFromXml(SettingsXml.ReadSection section) {
        SettingsXml.ChildSection child = section.children();
        ArrayList<UriRelativeFilterGroup> groups = new ArrayList();
    L4:
        if (child.moveToNext(TAG_URI_RELATIVE_FILTER_GROUP) == false) goto L6;
        UriRelativeFilterGroup group = new UriRelativeFilterGroup(section.getInt(ATTR_ACTION));
        readUriRelativeFiltersFromXml(child, group);
        groups.add(group);
        goto L4
    L6:
        return groups;
    }

    private static void readUriRelativeFiltersFromXml(SettingsXml.ReadSection section, UriRelativeFilterGroup group) {
        SettingsXml.ChildSection child = section.children();
    L4:
        if (child.moveToNext(TAG_URI_RELATIVE_FILTER) == false) goto L9;
        String filter = child.getString(ATTR_FILTER);
        if (filter == null) goto L4;
        group.addUriRelativeFilter(new UriRelativeFilter(child.getInt(ATTR_URI_PART), child.getInt(ATTR_PATTERN_TYPE), filter));
        goto L4
    }

    private static void readUserStates(SettingsXml.ReadSection section, SparseArray<DomainVerificationInternalUserState> userStates) {
        SettingsXml.ChildSection child = section.children();
    L4:
        if (child.moveToNext("user-state") == false) goto L9;
        DomainVerificationInternalUserState userState = createUserStateFromXml(child);
        if (userState == null) goto L4;
        userStates.put(userState.getUserId(), userState);
        goto L4
    }

    private static void readDomainStates(SettingsXml.ReadSection stateSection, ArrayMap<String, Integer> stateMap) {
        SettingsXml.ChildSection child = stateSection.children();
    L4:
        if (child.moveToNext(TAG_DOMAIN) == false) goto L6;
        String name = child.getString("name");
        int state = child.getInt("state", 0);
        stateMap.put(name, Integer.valueOf(state));
        goto L4
    }

    private static void writePkgStateToXml(SettingsXml.WriteSection parentSection, DomainVerificationPkgState pkgState, int userId, Function<String, String> pkgNameToSignature) throws IOException {
        String packageName = pkgState.getPackageName();
        if (pkgNameToSignature != null) goto L5;
        String signature = null;
    L6:
        if (signature != null) goto L8;
        signature = pkgState.getBackupSignatureHash();
    L8:
        SettingsXml.WriteSection ignored = parentSection.startSection(TAG_PACKAGE_STATE).attribute("packageName", packageName).attribute(ATTR_ID, pkgState.getId().toString()).attribute(ATTR_HAS_AUTO_VERIFY_DOMAINS, pkgState.isHasAutoVerifyDomains()).attribute(ATTR_SIGNATURE, signature);
        writeStateMap(parentSection, pkgState.getStateMap());     // Catch: Throwable -> L13
        writeUserStates(parentSection, userId, pkgState.getUserStates());     // Catch: Throwable -> L13
        writeUriRelativeFilterGroupMap(parentSection, pkgState.getUriRelativeFilterGroupMap());     // Catch: Throwable -> L13
        if (ignored == null) goto L24;
        ignored.close();
        return;
    L24:
        return;
    L13:
        th = move-exception;
        if (ignored != null) goto L20;
    L19:
        throw th;
    L20:
        ignored.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L5:
        signature = pkgNameToSignature.apply(packageName);
        goto L6
    }

    private static void writeUserStates(SettingsXml.WriteSection parentSection, int userId, SparseArray<DomainVerificationInternalUserState> states) throws IOException {
        int size = states.size();
        if (size != 0) goto L5;
        return;
    L5:
        SettingsXml.WriteSection section = parentSection.startSection("user-states");
        if (userId != (-1)) goto L13;
        int index = 0;
    L8:
        if (index >= size) goto L16;
        writeUserStateToXml(section, states.valueAt(index));     // Catch: Throwable -> L10
        index = index + 1;     // Catch: Throwable -> L10
    L16:
        if (section == null) goto L29;
        section.close();
        return;
    L29:
        return;
    L13:
        DomainVerificationInternalUserState userState = states.get(userId);     // Catch: Throwable -> L10
        if (userState == null) goto L16;
        writeUserStateToXml(section, userState);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (section != null) goto L26;
    L24:
        throw th;
    L26:
        section.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    private static void writeStateMap(SettingsXml.WriteSection parentSection, ArrayMap<String, Integer> stateMap) throws IOException {
        if (stateMap.isEmpty() == false) goto L5;
        return;
    L5:
        SettingsXml.WriteSection stateSection = parentSection.startSection("state");
        int size = stateMap.size();     // Catch: Throwable -> L10
        int index = 0;
    L7:
        if (index >= size) goto L13;
        stateSection.startSection(TAG_DOMAIN).attribute("name", stateMap.keyAt(index)).attribute("state", stateMap.valueAt(index).intValue()).finish();     // Catch: Throwable -> L10
        index = index + 1;
        goto L7
    L13:
        if (stateSection == null) goto L27;
        stateSection.close();
        return;
    L27:
        return;
    L10:
        th = move-exception;
        if (stateSection != null) goto L22;
    L21:
        throw th;
    L22:
        stateSection.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    }

    private static DomainVerificationInternalUserState createUserStateFromXml(SettingsXml.ReadSection section) {
        int userId = section.getInt("userId");
        if (userId != (-1)) goto L6;
        return null;
    L6:
        boolean allowLinkHandling = section.getBoolean(ATTR_ALLOW_LINK_HANDLING, false);
        ArraySet<String> enabledHosts = new ArraySet();
        SettingsXml.ChildSection child = section.children();
    L8:
        if (child.moveToNext(TAG_ENABLED_HOSTS) == false) goto L11;
        readEnabledHosts(child, enabledHosts);
        goto L8
    L11:
        return new DomainVerificationInternalUserState(userId, enabledHosts, allowLinkHandling);
    }

    private static void readEnabledHosts(SettingsXml.ReadSection section, ArraySet<String> enabledHosts) {
        SettingsXml.ChildSection child = section.children();
    L4:
        if (child.moveToNext("host") == false) goto L9;
        String hostName = child.getString("name");
        if (TextUtils.isEmpty(hostName) == true) goto L4;
        enabledHosts.add(hostName);
        goto L4
    }

    private static void writeUserStateToXml(SettingsXml.WriteSection parentSection, DomainVerificationInternalUserState userState) throws IOException {
        SettingsXml.WriteSection section = parentSection.startSection("user-state").attribute("userId", userState.getUserId()).attribute(ATTR_ALLOW_LINK_HANDLING, userState.isLinkHandlingAllowed());
        ArraySet<String> enabledHosts = userState.getEnabledHosts();     // Catch: Throwable -> L16
        if (enabledHosts.isEmpty() == true) goto L25;
        SettingsXml.WriteSection enabledHostsSection = section.startSection(TAG_ENABLED_HOSTS);     // Catch: Throwable -> L16
        int size = enabledHosts.size();     // Catch: Throwable -> L10
        int index = 0;
    L7:
        if (index >= size) goto L13;
        enabledHostsSection.startSection("host").attribute("name", enabledHosts.valueAt(index)).finish();     // Catch: Throwable -> L10
        index = index + 1;
        goto L7
    L13:
        if (enabledHostsSection == null) goto L25;
        enabledHostsSection.close();     // Catch: Throwable -> L16
    L10:
        th = move-exception;
        if (enabledHostsSection != null) goto L39;
    L24:
        throw th;     // Catch: Throwable -> L16
    L39:
        enabledHostsSection.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16
    L25:
        if (section == null) goto L42;
        section.close();
        return;
    L42:
        return;
    L16:
        th = move-exception;
        if (section != null) goto L34;
    L33:
        throw th;
    L34:
        section.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);
        goto L33
    }

    private static void writeUriRelativeFilterGroupMap(SettingsXml.WriteSection parentSection, ArrayMap<String, List<UriRelativeFilterGroup>> groupMap) throws IOException {
        if (groupMap.isEmpty() == false) goto L5;
        return;
    L5:
        SettingsXml.WriteSection section = parentSection.startSection(TAG_URI_RELATIVE_FILTER_GROUPS);
        int i = 0;
    L24:
    L10:
        th = move-exception;
        if (section != null) goto L22;
    L21:
        throw th;
    L22:
        section.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    L7:
        if (i >= groupMap.size()) goto L13;
        writeUriRelativeFilterGroups(section, groupMap.keyAt(i), groupMap.valueAt(i));     // Catch: Throwable -> L10
        i = i + 1;
        goto L24
    L13:
        if (section == null) goto L27;
        section.close();
        return;
    }

    private static void writeUriRelativeFilterGroups(SettingsXml.WriteSection parentSection, String domain, List<UriRelativeFilterGroup> groups) throws IOException {
        if (groups.isEmpty() == false) goto L5;
        return;
    L5:
        SettingsXml.WriteSection section = parentSection.startSection(TAG_DOMAIN).attribute("name", domain);
        int i = 0;
    L24:
    L10:
        th = move-exception;
        if (section != null) goto L22;
    L21:
        throw th;
    L22:
        section.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    L7:
        if (i >= groups.size()) goto L13;
        writeUriRelativeFilterGroup(section, groups.get(i));     // Catch: Throwable -> L10
        i = i + 1;
        goto L24
    L13:
        if (section == null) goto L27;
        section.close();
        return;
    }

    private static void writeUriRelativeFilterGroup(SettingsXml.WriteSection parentSection, UriRelativeFilterGroup group) throws IOException {
        SettingsXml.WriteSection section = parentSection.startSection(TAG_URI_RELATIVE_FILTER_GROUP).attribute(ATTR_ACTION, group.getAction());
        Iterator<UriRelativeFilter> it = group.getUriRelativeFilters().iterator();     // Catch: Throwable -> L8
    L5:
        if (it.hasNext() == false) goto L11;
        UriRelativeFilter filter = it.next();     // Catch: Throwable -> L8
        section.startSection(TAG_URI_RELATIVE_FILTER).attribute(ATTR_URI_PART, filter.getUriPart()).attribute(ATTR_PATTERN_TYPE, filter.getPatternType()).attribute(ATTR_FILTER, filter.getFilter()).finish();     // Catch: Throwable -> L8
        goto L5
    L11:
        if (section == null) goto L26;
        section.close();
        return;
    L26:
        return;
    L8:
        th = move-exception;
        if (section != null) goto L20;
    L19:
        throw th;
    L20:
        section.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }
}
