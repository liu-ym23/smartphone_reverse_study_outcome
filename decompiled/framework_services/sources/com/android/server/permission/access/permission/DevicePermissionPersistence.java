package com.android.server.permission.access.permission;

import android.util.Slog;
import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.UserState;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IndexedReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedReferenceMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: DevicePermissionPersistence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DevicePermissionPersistence {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: DevicePermissionPersistence.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public DevicePermissionPersistence() {
    }

    public final void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        if (Intrinsics.areEqual($this$parseUserState.getName(), "app-id-device-permissions") == false) goto L6;
        parseAppIdDevicePermissions($this$parseUserState, state, userId);
        return;
    }

    private final void parseAppIdDevicePermissions(BinaryXmlPullParser $this$parseAppIdDevicePermissions, MutableAccessState state, int userId) {
        MutableUserState userState = state.mutateUserState(userId, 0);
        Intrinsics.checkNotNull(userState);
        MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r3 = userState.mutateAppIdDevicePermissionFlags();
        int eventType$iv = $this$parseAppIdDevicePermissions.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parseAppIdDevicePermissions.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parseAppIdDevicePermissions.getEventType();
        switch(eventType$iv2) {
            case 1: goto L45;
            case 2: goto L15;
            case 3: goto L45;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parseAppIdDevicePermissions.getDepth();
        if (Intrinsics.areEqual($this$parseAppIdDevicePermissions.getName(), "app-id") == false) goto L18;
        parseAppId($this$parseAppIdDevicePermissions, r3);
    L19:
        int postBlockDepth$iv = $this$parseAppIdDevicePermissions.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parseAppIdDevicePermissions.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parseAppIdDevicePermissions.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parseAppIdDevicePermissions.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parseAppIdDevicePermissions.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parseAppIdDevicePermissions.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseAppIdDevicePermissions.getName() + " when parsing permission state");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    L45:
        int index$iv = r3.getSize() - 1;
    L47:
        if ((-1) >= index$iv) goto L53;
        int appId = r3.keyAt(index$iv);
        IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r6 = r3.valueAt(index$iv);
        int appIdIndex = index$iv;
        if (state.getExternalState().getAppIdPackageNames().contains(appId) == true) goto L51;
        Slog.w(LOG_TAG, "Dropping unknown app ID " + appId + " when parsing permission state");
        r3.removeAt(appIdIndex);
        userState.requestWriteMode(1);
    L51:
        index$iv = index$iv - 1;
        goto L47
    }

    private final void parseAppId(BinaryXmlPullParser $this$parseAppId, MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r15) {
        int appId = $this$parseAppId.getAttributeInt(null, "id");
        MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1 = new MutableIndexedReferenceMap(null, 1, null);
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
        if (Intrinsics.areEqual($this$parseAppId.getName(), "device") == false) goto L18;
        parseDevice($this$parseAppId, r1);
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

    private final void parseDevice(BinaryXmlPullParser $this$parseDevice, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r15) {
        String name$iv = $this$parseDevice.getAttributeValue($this$parseDevice.getAttributeIndexOrThrow(null, "id"));
        MutableIndexedMap<String, Integer> r1 = new MutableIndexedMap(null, 1, null);
        r15.put(name$iv, r1);
        int eventType$iv = $this$parseDevice.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parseDevice.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parseDevice.getEventType();
        switch(eventType$iv2) {
            case 1: goto L46;
            case 2: goto L15;
            case 3: goto L46;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parseDevice.getDepth();
        if (Intrinsics.areEqual($this$parseDevice.getName(), "permission") == false) goto L18;
        parsePermission($this$parseDevice, r1);
    L19:
        int postBlockDepth$iv = $this$parseDevice.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parseDevice.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parseDevice.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parseDevice.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parseDevice.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parseDevice.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseDevice.getName() + " when parsing permission state");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    }

    private final void parsePermission(BinaryXmlPullParser $this$parsePermission, MutableIndexedMap<String, Integer> r8) {
        String name$iv = $this$parsePermission.getAttributeValue($this$parsePermission.getAttributeIndexOrThrow(null, "name"));
        String name = name$iv.intern();
        Intrinsics.checkNotNullExpressionValue(name, "intern(...)");
        int flags = $this$parsePermission.getAttributeInt(null, "flags");
        r8.put(name, Integer.valueOf(flags));
    }

    public final void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        Immutable r0 = state.getUserStates().get(userId);
        Intrinsics.checkNotNull(r0);
        IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r1 = ((UserState) r0).getAppIdDevicePermissionFlags();
        $this$serializeUserState.startTag(null, "app-id-device-permissions");
        int index$iv = 0;
        int r11 = r1.getSize();
    L3:
        if (index$iv >= r11) goto L5;
        int appId = r1.keyAt(index$iv);
        serializeAppId($this$serializeUserState, appId, (IndexedReferenceMap) r1.valueAt(index$iv));
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializeUserState.endTag(null, "app-id-device-permissions");
    }

    private final void serializeAppId(BinaryXmlSerializer $this$serializeAppId, int appId, IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r17) {
        $this$serializeAppId.startTag(null, "app-id");
        $this$serializeAppId.attributeInt(null, "id", appId);
        int index$iv = 0;
        int r10 = r17.getSize();
    L3:
        if (index$iv >= r10) goto L5;
        String r11 = r17.keyAt(index$iv);
        String deviceId = r11;
        serializeDevice($this$serializeAppId, deviceId, (IndexedMap) r17.valueAt(index$iv));
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializeAppId.endTag(null, "app-id");
    }

    private final void serializeDevice(BinaryXmlSerializer $this$serializeDevice, String deviceId, IndexedMap<String, Integer> r17) {
        $this$serializeDevice.startTag(null, "device");
        $this$serializeDevice.attributeInterned(null, "id", deviceId);
        int index$iv = 0;
        int r10 = r17.getSize();
    L3:
        if (index$iv >= r10) goto L5;
        String r11 = r17.keyAt(index$iv);
        int flags = r17.valueAt(index$iv).intValue();
        String name = r11;
        serializePermission($this$serializeDevice, name, flags);
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializeDevice.endTag(null, "device");
    }

    private final void serializePermission(BinaryXmlSerializer $this$serializePermission, String name, int flags) {
        $this$serializePermission.startTag(null, "permission");
        $this$serializePermission.attributeInterned(null, "name", name);
        if (IntExtensionsKt.hasBits(flags, 2097152) == false) goto L5;
        int serializedFlags = IntExtensionsKt.andInv(flags, 16);
    L6:
        $this$serializePermission.attributeInt(null, "flags", serializedFlags);
        $this$serializePermission.endTag(null, "permission");
        return;
    L5:
        serializedFlags = flags;
        goto L6
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = DevicePermissionPersistence.class.getSimpleName();
    }
}
