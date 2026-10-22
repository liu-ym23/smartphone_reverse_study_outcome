package com.bytedance.android.livesdkapi.gamestickerv2.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/config/ComponentMode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "UNKNOWN", "H5", "LYNX", "BATTLE", "TEMPLATE_01", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ComponentMode extends Enum<ComponentMode> {
    private static final /* synthetic */ ComponentMode[] $VALUES = null;
    public static final ComponentMode BATTLE = null;
    public static final Companion Companion = null;
    public static final ComponentMode H5 = null;
    public static final ComponentMode LYNX = null;
    public static final ComponentMode TEMPLATE_01 = null;
    public static final ComponentMode UNKNOWN = null;
    private String value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/config/ComponentMode$Companion;", "", "()V", "strToComponentMode", "Lcom/bytedance/android/livesdkapi/gamestickerv2/config/ComponentMode;", "value", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ComponentMode strToComponentMode(String r100) {
            ComponentMode[] r101 = ComponentMode.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ComponentMode r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return ComponentMode.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
        ComponentMode r100 = new ComponentMode("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        ComponentMode r101 = new ComponentMode("H5", 1, "h5");
        H5 = r101;
        ComponentMode r102 = new ComponentMode("LYNX", 2, "lynx");
        LYNX = r102;
        ComponentMode r103 = new ComponentMode("BATTLE", 3, "battle");
        BATTLE = r103;
        ComponentMode r104 = new ComponentMode("TEMPLATE_01", 4, "template_01");
        TEMPLATE_01 = r104;
        $VALUES = new ComponentMode[]{r100, r101, r102, r103, r104};
        Companion = new Companion(null);
    }

    public static ComponentMode valueOf(String r100) {
        return (ComponentMode) a.a(ComponentMode.class, r100);
    }

    public static ComponentMode[] values() {
        return (ComponentMode[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.value = r100;
    }

    private ComponentMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
