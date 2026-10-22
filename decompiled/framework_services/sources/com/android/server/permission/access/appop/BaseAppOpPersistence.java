package com.android.server.permission.access.appop;

import android.util.Slog;
import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: BaseAppOpPersistence.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAppOpPersistence {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: BaseAppOpPersistence.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public abstract void parseUserState(BinaryXmlPullParser r1, MutableAccessState r2, int r3);

    public abstract void serializeUserState(BinaryXmlSerializer r1, AccessState r2, int r3);

    public BaseAppOpPersistence() {
    }

    protected final void parseAppOps(BinaryXmlPullParser $this$parseAppOps, MutableIndexedMap<String, Integer> r13) {
        int eventType$iv = $this$parseAppOps.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parseAppOps.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parseAppOps.getEventType();
        switch(eventType$iv2) {
            case 1: goto L46;
            case 2: goto L15;
            case 3: goto L46;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parseAppOps.getDepth();
        if (Intrinsics.areEqual($this$parseAppOps.getName(), "app-op") == false) goto L18;
        parseAppOp($this$parseAppOps, r13);
    L19:
        int postBlockDepth$iv = $this$parseAppOps.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parseAppOps.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parseAppOps.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parseAppOps.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parseAppOps.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parseAppOps.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseAppOps.getName() + " when parsing app-op state");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    }

    private final void parseAppOp(BinaryXmlPullParser $this$parseAppOp, MutableIndexedMap<String, Integer> r8) {
        String name$iv = $this$parseAppOp.getAttributeValue($this$parseAppOp.getAttributeIndexOrThrow(null, "name"));
        String name = name$iv.intern();
        Intrinsics.checkNotNullExpressionValue(name, "intern(...)");
        int mode = $this$parseAppOp.getAttributeInt(null, "mode");
        r8.put(name, Integer.valueOf(mode));
    }

    protected final void serializeAppOps(BinaryXmlSerializer $this$serializeAppOps, IndexedMap<String, Integer> r9) {
        int index$iv = 0;
        int r3 = r9.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        String r4 = r9.keyAt(index$iv);
        int mode = r9.valueAt(index$iv).intValue();
        String name = r4;
        serializeAppOp($this$serializeAppOps, name, mode);
        index$iv = index$iv + 1;
        goto L3
    }

    private final void serializeAppOp(BinaryXmlSerializer $this$serializeAppOp, String name, int mode) {
        $this$serializeAppOp.startTag(null, "app-op");
        $this$serializeAppOp.attributeInterned(null, "name", name);
        $this$serializeAppOp.attributeInt(null, "mode", mode);
        $this$serializeAppOp.endTag(null, "app-op");
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = BaseAppOpPersistence.class.getSimpleName();
    }
}
