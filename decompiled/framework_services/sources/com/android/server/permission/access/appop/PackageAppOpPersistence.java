package com.android.server.permission.access.appop;

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
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedReferenceMap;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.Settings;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: PackageAppOpPersistence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageAppOpPersistence extends BaseAppOpPersistence {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: PackageAppOpPersistence.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public PackageAppOpPersistence() {
    }

    @Override // com.android.server.permission.access.appop.BaseAppOpPersistence
    public void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        if (Intrinsics.areEqual($this$parseUserState.getName(), "package-app-ops") == false) goto L6;
        parsePackageAppOps($this$parseUserState, state, userId);
        return;
    }

    private final void parsePackageAppOps(BinaryXmlPullParser $this$parsePackageAppOps, MutableAccessState state, int userId) {
        MutableUserState userState = state.mutateUserState(userId, 0);
        Intrinsics.checkNotNull(userState);
        MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r3 = userState.mutatePackageAppOpModes();
        int eventType$iv = $this$parsePackageAppOps.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parsePackageAppOps.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parsePackageAppOps.getEventType();
        switch(eventType$iv2) {
            case 1: goto L45;
            case 2: goto L15;
            case 3: goto L45;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parsePackageAppOps.getDepth();
        if (Intrinsics.areEqual($this$parsePackageAppOps.getName(), Settings.ATTR_PACKAGE) == false) goto L18;
        parsePackage($this$parsePackageAppOps, r3);
    L19:
        int postBlockDepth$iv = $this$parsePackageAppOps.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parsePackageAppOps.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parsePackageAppOps.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parsePackageAppOps.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parsePackageAppOps.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parsePackageAppOps.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parsePackageAppOps.getName() + " when parsing app-op state");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    L45:
        int index$iv = r3.getSize() - 1;
    L47:
        if ((-1) >= index$iv) goto L53;
        String r5 = r3.keyAt(index$iv);
        IndexedMap<String, Integer> r6 = r3.valueAt(index$iv);
        String packageName = r5;
        int packageNameIndex = index$iv;
        if (state.getExternalState().getPackageStates().containsKey(packageName) == true) goto L51;
        Slog.w(LOG_TAG, "Dropping unknown package " + packageName + " when parsing app-op state");
        r3.removeAt(packageNameIndex);
        userState.requestWriteMode(1);
    L51:
        index$iv = index$iv - 1;
        goto L47
    }

    private final void parsePackage(BinaryXmlPullParser $this$parsePackage, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r8) {
        String name$iv = $this$parsePackage.getAttributeValue($this$parsePackage.getAttributeIndexOrThrow(null, "name"));
        String packageName = name$iv.intern();
        Intrinsics.checkNotNullExpressionValue(packageName, "intern(...)");
        MutableIndexedMap<String, Integer> r1 = new MutableIndexedMap(null, 1, null);
        r8.put(packageName, r1);
        parseAppOps($this$parsePackage, r1);
    }

    @Override // com.android.server.permission.access.appop.BaseAppOpPersistence
    public void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        Immutable r0 = state.getUserStates().get(userId);
        Intrinsics.checkNotNull(r0);
        serializePackageAppOps($this$serializeUserState, ((UserState) r0).getPackageAppOpModes());
    }

    private final void serializePackageAppOps(BinaryXmlSerializer $this$serializePackageAppOps, IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r15) {
        $this$serializePackageAppOps.startTag(null, "package-app-ops");
        int index$iv = 0;
        int r9 = r15.getSize();
    L3:
        if (index$iv >= r9) goto L5;
        String r10 = r15.keyAt(index$iv);
        String packageName = r10;
        serializePackage($this$serializePackageAppOps, packageName, (IndexedMap) r15.valueAt(index$iv));
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializePackageAppOps.endTag(null, "package-app-ops");
    }

    private final void serializePackage(BinaryXmlSerializer $this$serializePackage, String packageName, IndexedMap<String, Integer> r12) {
        $this$serializePackage.startTag(null, Settings.ATTR_PACKAGE);
        $this$serializePackage.attributeInterned(null, "name", packageName);
        serializeAppOps($this$serializePackage, r12);
        $this$serializePackage.endTag(null, Settings.ATTR_PACKAGE);
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = PackageAppOpPersistence.class.getSimpleName();
    }
}
