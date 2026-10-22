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
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AppIdAppOpPersistence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIdAppOpPersistence extends BaseAppOpPersistence {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: AppIdAppOpPersistence.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public AppIdAppOpPersistence() {
    }

    @Override // com.android.server.permission.access.appop.BaseAppOpPersistence
    public void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        if (Intrinsics.areEqual($this$parseUserState.getName(), "app-id-app-ops") == false) goto L6;
        parseAppIdAppOps($this$parseUserState, state, userId);
        return;
    }

    private final void parseAppIdAppOps(BinaryXmlPullParser $this$parseAppIdAppOps, MutableAccessState state, int userId) {
        MutableUserState userState = state.mutateUserState(userId, 0);
        Intrinsics.checkNotNull(userState);
        MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r3 = userState.mutateAppIdAppOpModes();
        int eventType$iv = $this$parseAppIdAppOps.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parseAppIdAppOps.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parseAppIdAppOps.getEventType();
        switch(eventType$iv2) {
            case 1: goto L45;
            case 2: goto L15;
            case 3: goto L45;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parseAppIdAppOps.getDepth();
        if (Intrinsics.areEqual($this$parseAppIdAppOps.getName(), "app-id") == false) goto L18;
        parseAppId($this$parseAppIdAppOps, r3);
    L19:
        int postBlockDepth$iv = $this$parseAppIdAppOps.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parseAppIdAppOps.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parseAppIdAppOps.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parseAppIdAppOps.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parseAppIdAppOps.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parseAppIdAppOps.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseAppIdAppOps.getName() + " when parsing app-op state");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    L45:
        IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1 = userState.getAppIdAppOpModes();
        int index$iv = r1.getSize() - 1;
    L47:
        if ((-1) >= index$iv) goto L55;
        int appId = r1.keyAt(index$iv);
        IndexedMap r6 = (IndexedMap) r1.valueAt(index$iv);
        int appIdIndex = index$iv;
        if (state.getExternalState().getAppIdPackageNames().contains(appId) == true) goto L53;
        if (appId < 10000) goto L53;
        Slog.w(LOG_TAG, "Dropping unknown app ID " + appId + " when parsing app-op state");
        r3.removeAt(appIdIndex);
        userState.requestWriteMode(1);
    L53:
        index$iv = index$iv - 1;
        goto L47
    }

    private final void parseAppId(BinaryXmlPullParser $this$parseAppId, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r6) {
        int appId = $this$parseAppId.getAttributeInt(null, "id");
        MutableIndexedMap<String, Integer> r1 = new MutableIndexedMap(null, 1, null);
        IntReferenceMapExtensionsKt.set(r6, appId, r1);
        parseAppOps($this$parseAppId, r1);
    }

    @Override // com.android.server.permission.access.appop.BaseAppOpPersistence
    public void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        Immutable r0 = state.getUserStates().get(userId);
        Intrinsics.checkNotNull(r0);
        serializeAppIdAppOps($this$serializeUserState, ((UserState) r0).getAppIdAppOpModes());
    }

    private final void serializeAppIdAppOps(BinaryXmlSerializer $this$serializeAppIdAppOps, IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r15) {
        $this$serializeAppIdAppOps.startTag(null, "app-id-app-ops");
        int index$iv = 0;
        int r9 = r15.getSize();
    L3:
        if (index$iv >= r9) goto L5;
        int appId = r15.keyAt(index$iv);
        serializeAppId($this$serializeAppIdAppOps, appId, (IndexedMap) r15.valueAt(index$iv));
        index$iv = index$iv + 1;
        goto L3
    L5:
        $this$serializeAppIdAppOps.endTag(null, "app-id-app-ops");
    }

    private final void serializeAppId(BinaryXmlSerializer $this$serializeAppId, int appId, IndexedMap<String, Integer> r12) {
        $this$serializeAppId.startTag(null, "app-id");
        $this$serializeAppId.attributeInt(null, "id", appId);
        serializeAppOps($this$serializeAppId, r12);
        $this$serializeAppId.endTag(null, "app-id");
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AppIdAppOpPersistence.class.getSimpleName();
    }
}
