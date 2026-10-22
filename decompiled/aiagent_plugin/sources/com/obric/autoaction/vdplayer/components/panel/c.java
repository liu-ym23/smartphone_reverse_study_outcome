package com.obric.autoaction.vdplayer.components.panel;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.d.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PanelUIConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f25449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f25450d;

    /* JADX INFO: compiled from: PanelUIConfig.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.autoaction.vdplayer.components.panel.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PanelUIConfig.kt */
        public /* synthetic */ class C0623a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f25451a = null;

            static {
                int[] r0 = new int[l.values().length];
                r0[l.f25511e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[l.f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[l.f25508b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[l.f25509c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[l.f25510d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f25451a = r0;
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a(l r7) {
            o.e(r7, "status");
            int r6 = C0623a.f25451a[r7.ordinal()];
            if (r6 == 1) goto L18;
            if (r6 == 2) goto L23;
            if (r6 == 3) goto L22;
            if (r6 == 4) goto L21;
            if (r6 == 5) goto L20;
            return null;
        L20:
            return new c(ZeusTransformUtils.mapRes(R.string.obric_vd_panel_title_term, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_panel_title_term"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"), ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right, "drawable", "ic_vd_hand_right"));
        L21:
            return new c(ZeusTransformUtils.mapRes(R.string.obric_vd_panel_title_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_panel_title_failed"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6"), ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right, "drawable", "ic_vd_hand_right"));
        L22:
            return new c(ZeusTransformUtils.mapRes(R.string.obric_vd_panel_title_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_panel_title_success"), ZeusTransformUtils.mapRes(R.color.oui_functional_green_6, "color", "oui_functional_green_6"), ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right, "drawable", "ic_vd_hand_right"));
        L23:
            return new c(ZeusTransformUtils.mapRes(R.string.obric_vd_panel_title_clarify, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_panel_title_clarify"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b"), ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_left, "drawable", "ic_vd_hand_left"));
        L18:
            return new c(ZeusTransformUtils.mapRes(R.string.obric_vd_panel_title_calluser, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_panel_title_calluser"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b"), ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_left, "drawable", "ic_vd_hand_left"));
        }
    }

    static {
        f25447a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f25448b == r6.f25448b) goto L12;
        return false;
    L12:
        if (this.f25449c == r6.f25449c) goto L15;
        return false;
    L15:
        if (this.f25450d == r6.f25450d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f25448b) * 31) + Integer.hashCode(this.f25449c)) * 31) + Integer.hashCode(this.f25450d);
    }

    public String toString() {
        return "PanelUIConfig(titleRes=" + this.f25448b + ", colorRes=" + this.f25449c + ", iconRes=" + this.f25450d + ')';
    }

    public c(int r1, int r2, int r3) {
        this.f25448b = r1;
        this.f25449c = r2;
        this.f25450d = r3;
    }

    public final int a() {
        return this.f25448b;
    }

    public final int b() {
        return this.f25449c;
    }

    public final int c() {
        return this.f25450d;
    }
}
