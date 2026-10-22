package com.android.server.permission.access.permission;

import android.content.pm.PermissionInfo;
import android.util.Slog;
import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.ExternalState;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableSystemState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.SystemState;
import com.android.server.permission.access.UserState;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.voiceinteraction.DatabaseHelper;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AppIdPermissionPersistence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIdPermissionPersistence {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: AppIdPermissionPersistence.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public AppIdPermissionPersistence() {
    }

    public final void parseSystemState(BinaryXmlPullParser $this$parseSystemState, MutableAccessState state) {
        String r0 = $this$parseSystemState.getName();
        if (Intrinsics.areEqual(r0, "permission-trees") == false) goto L6;
        parsePermissions($this$parseSystemState, state, true);
        return;
    L6:
        if (Intrinsics.areEqual(r0, "permissions") == false) goto L10;
        parsePermissions($this$parseSystemState, state, false);
        return;
    }

    private final void parsePermissions(BinaryXmlPullParser $this$parsePermissions, MutableAccessState state, boolean isPermissionTree) {
        MutableAccessState r1 = state;
        MutableSystemState systemState = r1.mutateSystemState(0);
        if (isPermissionTree == false) goto L5;
        MutableIndexedMap<String, Permission> r2 = systemState.mutatePermissionTrees();
    L6:
        int eventType$iv = $this$parsePermissions.getEventType();
        switch(eventType$iv) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L11;
            default: goto L9;
        };
    L9:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L11:
        int eventType$iv$iv = $this$parsePermissions.next();
        switch(eventType$iv$iv) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L15;
            default: goto L11;
        };
    L15:
        int eventType$iv2 = $this$parsePermissions.getEventType();
        switch(eventType$iv2) {
            case 1: goto L49;
            case 2: goto L19;
            case 3: goto L49;
            default: goto L18;
        };
    L19:
        int childDepth$iv = $this$parsePermissions.getDepth();
        String tagName = $this$parsePermissions.getName();
        if (Intrinsics.areEqual(tagName, "permission") == false) goto L22;
        parsePermission($this$parsePermissions, r2);
    L23:
        int postBlockDepth$iv = $this$parsePermissions.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L48;
    L26:
        int childEventType$iv = $this$parsePermissions.getEventType();
        switch(childEventType$iv) {
            case 2: goto L43;
            case 3: goto L31;
            default: goto L29;
        };
    L29:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L43:
        int eventType$iv$iv2 = $this$parsePermissions.next();
        switch(eventType$iv$iv2) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L26;
            default: goto L43;
        };
    L31:
        if ($this$parsePermissions.getDepth() <= childDepth$iv) goto L38;
    L33:
        int eventType$iv$iv3 = $this$parsePermissions.next();
        switch(eventType$iv$iv3) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L26;
            default: goto L33;
        };
    L38:
        int eventType$iv$iv4 = $this$parsePermissions.next();
        switch(eventType$iv$iv4) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L15;
            default: goto L38;
        };
    L48:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L22:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + tagName + " when parsing permissions");
        goto L23
    L18:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    L49:
        IndexedMap $this$forEachReversedIndexed$iv = r2;
        boolean r9 = true;
        int index$iv = $this$forEachReversedIndexed$iv.getSize() - 1;
    L51:
        if ((-1) >= index$iv) goto L61;
        String r5 = $this$forEachReversedIndexed$iv.keyAt(index$iv);
        Permission permission = $this$forEachReversedIndexed$iv.valueAt(index$iv);
        int permissionIndex = index$iv;
        String packageName = permission.getPermissionInfo().packageName;
        ExternalState externalState = r1.getExternalState();
        if (externalState.getPackageStates().containsKey(packageName) == false) goto L55;
        boolean r3 = r9;
    L59:
        index$iv = index$iv - 1;
        r9 = r3;
        r1 = state;
        goto L51
    L55:
        if (externalState.getDisabledSystemPackageStates().containsKey(packageName) == true) goto L57;
        Slog.w(LOG_TAG, "Dropping permission " + permission.getPermissionInfo().name + " from unknown package " + packageName + " when parsing permissions");
        r2.removeAt(permissionIndex);
        r3 = true;
        systemState.requestWriteMode(1);
        goto L59
    L57:
        r3 = r9;
        goto L59
    L61:
        return;
    L5:
        r2 = systemState.mutatePermissions();
        goto L6
    }

    private final void parsePermission(BinaryXmlPullParser $this$parsePermission, MutableIndexedMap<String, Permission> r17) {
        String name$iv = $this$parsePermission.getAttributeValue($this$parsePermission.getAttributeIndexOrThrow(null, "name"));
        String name = name$iv.intern();
        Intrinsics.checkNotNullExpressionValue(name, "intern(...)");
        PermissionInfo $this$parsePermission_u24lambda_u242 = new PermissionInfo();
        $this$parsePermission_u24lambda_u242.name = name;
        String name$iv2 = $this$parsePermission.getAttributeValue($this$parsePermission.getAttributeIndexOrThrow(null, "packageName"));
        String name$iv3 = name$iv2.intern();
        Intrinsics.checkNotNullExpressionValue(name$iv3, "intern(...)");
        $this$parsePermission_u24lambda_u242.packageName = name$iv3;
        $this$parsePermission_u24lambda_u242.protectionLevel = $this$parsePermission.getAttributeIntHex(null, "protectionLevel");
        int type = $this$parsePermission.getAttributeInt(null, DatabaseHelper.SoundModelContract.KEY_TYPE);
        switch(type) {
            case 0: goto L7;
            case 1: goto L4;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Slog.w(LOG_TAG, "Ignoring permission " + name + " with unknown type " + type);
        return;
    L6:
        $this$parsePermission_u24lambda_u242.icon = $this$parsePermission.getAttributeIntHex(null, "icon", 0);
        String name$iv4 = $this$parsePermission.getAttributeValue(null, "label");
        $this$parsePermission_u24lambda_u242.nonLocalizedLabel = name$iv4;
    L7:
        Permission permission = new Permission($this$parsePermission_u24lambda_u242, false, type, 0, null, false, 48, null);
        r17.put(name, permission);
    }

    public final void serializeSystemState(BinaryXmlSerializer $this$serializeSystemState, AccessState state) {
        SystemState systemState = state.getSystemState();
        serializePermissions($this$serializeSystemState, "permission-trees", systemState.getPermissionTrees());
        serializePermissions($this$serializeSystemState, "permissions", systemState.getPermissions());
    }

    private final void serializePermissions(BinaryXmlSerializer $this$serializePermissions, String tagName, IndexedMap<String, Permission> r14) {
        $this$serializePermissions.startTag(null, tagName);
        int index$iv = 0;
        int r8 = r14.getSize();
    L3:
        if (index$iv >= r8) goto L5;
        String r9 = r14.keyAt(index$iv);
        Permission it = r14.valueAt(index$iv);
        serializePermission($this$serializePermissions, it);
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializePermissions.endTag(null, tagName);
    }

    private final void serializePermission(BinaryXmlSerializer $this$serializePermission, Permission permission) {
        $this$serializePermission.startTag(null, "permission");
        String value$iv = permission.getPermissionInfo().name;
        $this$serializePermission.attributeInterned(null, "name", value$iv);
        String value$iv2 = permission.getPermissionInfo().packageName;
        $this$serializePermission.attributeInterned(null, "packageName", value$iv2);
        int value$iv3 = permission.getPermissionInfo().protectionLevel;
        $this$serializePermission.attributeIntHex(null, "protectionLevel", value$iv3);
        int type = permission.getType();
        $this$serializePermission.attributeInt(null, DatabaseHelper.SoundModelContract.KEY_TYPE, type);
        if (type != 2) goto L12;
        PermissionInfo permissionInfo = permission.getPermissionInfo();
        int value$iv4 = permissionInfo.icon;
        if (value$iv4 == 0) goto L7;
        $this$serializePermission.attributeIntHex(null, "icon", value$iv4);
    L7:
        CharSequence r8 = permissionInfo.nonLocalizedLabel;
        if (r8 == null) goto L12;
        String it = r8.toString();
        if (it == null) goto L12;
        $this$serializePermission.attribute(null, "label", it);
    L12:
        $this$serializePermission.endTag(null, "permission");
    }

    public final void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        if (Intrinsics.areEqual($this$parseUserState.getName(), "app-id-permissions") == false) goto L6;
        parseAppIdPermissions($this$parseUserState, state, userId);
        return;
    }

    private final void parseAppIdPermissions(BinaryXmlPullParser $this$parseAppIdPermissions, MutableAccessState state, int userId) {
        MutableUserState userState = state.mutateUserState(userId, 0);
        Intrinsics.checkNotNull(userState);
        MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r3 = userState.mutateAppIdPermissionFlags();
        int eventType$iv = $this$parseAppIdPermissions.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parseAppIdPermissions.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parseAppIdPermissions.getEventType();
        switch(eventType$iv2) {
            case 1: goto L45;
            case 2: goto L15;
            case 3: goto L45;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parseAppIdPermissions.getDepth();
        if (Intrinsics.areEqual($this$parseAppIdPermissions.getName(), "app-id") == false) goto L18;
        parseAppId($this$parseAppIdPermissions, r3);
    L19:
        int postBlockDepth$iv = $this$parseAppIdPermissions.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parseAppIdPermissions.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parseAppIdPermissions.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parseAppIdPermissions.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parseAppIdPermissions.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parseAppIdPermissions.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseAppIdPermissions.getName() + " when parsing permission state");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    L45:
        int index$iv = r3.getSize() - 1;
    L47:
        if ((-1) >= index$iv) goto L53;
        int appId = r3.keyAt(index$iv);
        IndexedMap<String, Integer> r6 = r3.valueAt(index$iv);
        int appIdIndex = index$iv;
        if (state.getExternalState().getAppIdPackageNames().contains(appId) == true) goto L51;
        Slog.w(LOG_TAG, "Dropping unknown app ID " + appId + " when parsing permission state");
        r3.removeAt(appIdIndex);
        userState.requestWriteMode(1);
    L51:
        index$iv = index$iv - 1;
        goto L47
    }

    private final void parseAppId(BinaryXmlPullParser $this$parseAppId, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r15) {
        int appId = $this$parseAppId.getAttributeInt(null, "id");
        MutableIndexedMap<String, Integer> r1 = new MutableIndexedMap(null, 1, null);
        IntReferenceMapExtensionsKt.set(r15, appId, r1);
        int eventType$iv = $this$parseAppId.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parseAppId.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parseAppId.getEventType();
        switch(eventType$iv2) {
            case 1: goto L46;
            case 2: goto L15;
            case 3: goto L46;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parseAppId.getDepth();
        if (Intrinsics.areEqual($this$parseAppId.getName(), "permission") == false) goto L18;
        parseAppIdPermission($this$parseAppId, r1);
    L19:
        int postBlockDepth$iv = $this$parseAppId.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parseAppId.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parseAppId.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parseAppId.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parseAppId.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parseAppId.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseAppId.getName() + " when parsing permission state");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    }

    private final void parseAppIdPermission(BinaryXmlPullParser $this$parseAppIdPermission, MutableIndexedMap<String, Integer> r8) {
        String name$iv = $this$parseAppIdPermission.getAttributeValue($this$parseAppIdPermission.getAttributeIndexOrThrow(null, "name"));
        String name = name$iv.intern();
        Intrinsics.checkNotNullExpressionValue(name, "intern(...)");
        int flags = $this$parseAppIdPermission.getAttributeInt(null, "flags");
        r8.put(name, Integer.valueOf(flags));
    }

    public final void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        Immutable r0 = state.getUserStates().get(userId);
        Intrinsics.checkNotNull(r0);
        serializeAppIdPermissions($this$serializeUserState, ((UserState) r0).getAppIdPermissionFlags());
    }

    private final void serializeAppIdPermissions(BinaryXmlSerializer $this$serializeAppIdPermissions, IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r15) {
        $this$serializeAppIdPermissions.startTag(null, "app-id-permissions");
        int index$iv = 0;
        int r9 = r15.getSize();
    L3:
        if (index$iv >= r9) goto L5;
        int appId = r15.keyAt(index$iv);
        serializeAppId($this$serializeAppIdPermissions, appId, (IndexedMap) r15.valueAt(index$iv));
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializeAppIdPermissions.endTag(null, "app-id-permissions");
    }

    private final void serializeAppId(BinaryXmlSerializer $this$serializeAppId, int appId, IndexedMap<String, Integer> r17) {
        $this$serializeAppId.startTag(null, "app-id");
        $this$serializeAppId.attributeInt(null, "id", appId);
        int index$iv = 0;
        int r10 = r17.getSize();
    L3:
        if (index$iv >= r10) goto L5;
        String r11 = r17.keyAt(index$iv);
        int flags = r17.valueAt(index$iv).intValue();
        String name = r11;
        serializeAppIdPermission($this$serializeAppId, name, flags);
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializeAppId.endTag(null, "app-id");
    }

    private final void serializeAppIdPermission(BinaryXmlSerializer $this$serializeAppIdPermission, String name, int flags) {
        $this$serializeAppIdPermission.startTag(null, "permission");
        $this$serializeAppIdPermission.attributeInterned(null, "name", name);
        if (IntExtensionsKt.hasBits(flags, 2097152) == false) goto L5;
        int serializedFlags = IntExtensionsKt.andInv(flags, 16);
    L6:
        $this$serializeAppIdPermission.attributeInt(null, "flags", serializedFlags);
        $this$serializeAppIdPermission.endTag(null, "permission");
        return;
    L5:
        serializedFlags = flags;
        goto L6
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AppIdPermissionPersistence.class.getSimpleName();
    }
}
