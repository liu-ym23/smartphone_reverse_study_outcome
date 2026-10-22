package com.obric.autoaction.vdplayer.legacy.components;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.lifecycle.p;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.vdplayer.legacy.d.m;
import com.obric.autoaction.vdplayer.legacy.d.s;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.RobotsScreenshotBlockReason;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;
import d.n;
import kotlinx.coroutines.b.h;

/* JADX INFO: compiled from: SecureComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SecureComponent extends BaseVDPlayerSlotComponent<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autoaction.a.c f25764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f25765c;

    /* JADX INFO: compiled from: SecureComponent.kt */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25766a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f25767b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f25768c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f25769d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f25766a, f25767b};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f25766a = new a("INVISIBLE", 0);
            f25767b = new a("INOPERABLE", 1);
            a[] r0 = a();
            f25768c = r0;
            f25769d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f25768c.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SecureComponent.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25770a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25771b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f25772c = null;

        static {
            int[] r0 = new int[RobotsScreenshotBlockReason.values().length];
            r0[RobotsScreenshotBlockReason.Inoperable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[RobotsScreenshotBlockReason.Invisible.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L6:
            f25770a = r0;
            int[] r1 = new int[m.values().length];
            r1[m.f25919a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            r1[m.f25920b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[m.f25921c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L10:
            f25771b = r1;
            int[] r2 = new int[a.values().length];
            r2[a.f25767b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L30:
            r2[a.f25766a.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L13:
            f25772c = r2;
        }
    }

    public static /* synthetic */ m lambda$j41QvYWpPeev26SACbJ6DNL8Z_M(s r0) {
        return a(r0);
    }

    public SecureComponent() {
        super($$Lambda$SecureComponent$j41QvYWpPeev26SACbJ6DNL8Z_M.INSTANCE);
        this.f25763a = "SecureComponent";
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent
    public /* synthetic */ void a(Object r3) {
        a((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin"));
    }

    private static final m a(s r1) {
        o.e(r1, "it");
        return r1.j();
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent, com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r2) {
        o.e(r2, "componentHost");
        super.a(r2);
        this.f25764b = r2;
    }

    @Override // com.obric.autoaction.vdplayer.legacy.components.BaseVDPlayerComponent
    public h<m> a(h<? extends m> r3) {
        h r2 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        return com.obric.autoaction.vdplayer.legacy.components.a.a(r2, 100);
    }

    @Override // com.obric.autoaction.a.g
    public View a(ViewGroup r5, com.obric.autoaction.a.c r6) {
        o.e(r5, "container");
        o.e(r6, "componentHost");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.vd_component_secure_cover, "layout", "vd_component_secure_cover"), r5, false, "com.obric.aiagent.plugin");
        this.f25765c = r7;
        o.c(r7, "apply(...)");
        return r7;
    }

    public void a(m r9) {
        o.e(r9, "state");
        super.a(r9);
        com.obric.autoaction.a.c r0 = this.f25764b;
        RobotsScreenshotBlockReason r1 = null;
        if (r0 == null) goto L5;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Activity.class) == false) goto L9;
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(r2, Activity.class, "com.obric.aiagent.plugin");
    L74:
        n.a r5 = n.f38560a;     // Catch: Throwable -> L24
        SecureComponent r6 = (SecureComponent) ZeusTransformUtils.preCheckCast(this, SecureComponent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        AOOperatingSpace r7 = OperatingSpaceManager.INSTANCE.getActiveSpace();     // Catch: Throwable -> L24
        if (r7 == null) goto L14;
        r1 = r7.getRobotsScreenshotBlockReason();     // Catch: Throwable -> L24
    L14:
        if (r1 != null) goto L16;
        int r4 = -1;
    L17:
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L20;
        a r8 = a.f25766a;     // Catch: Throwable -> L24
    L22:
        Object r10 = n.f(r8);     // Catch: Throwable -> L24
    L26:
        a r11 = a.f25766a;
        if (n.b(r10) == false) goto L29;
        r10 = r11;
    L29:
        a r12 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        if (r12 != a.f25766a) goto L32;
        boolean r13 = true;
    L33:
        int r14 = b.f25771b[r9.ordinal()];
        if (r14 != 1) goto L36;
        View r15 = this.f25765c;
        if (r15 == null) goto L63;
        r15.setVisibility(0);
    L63:
        a(r12);
        if (r13 == false) goto L69;
        if (r3 == null) goto L85;
        Window r16 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
        if (r16 == null) goto L86;
        r16.addFlags(8192);
        return;
    L86:
        return;
    L85:
        return;
    L69:
        if (r3 == null) goto L88;
        Window r17 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
        if (r17 == null) goto L89;
        r17.clearFlags(8192);
        return;
    L89:
        return;
    L88:
        return;
    L36:
        if (r14 != 2) goto L38;
        View r18 = this.f25765c;
        if (r18 == null) goto L51;
        r18.setVisibility(8);
    L51:
        if (r13 == false) goto L56;
        if (r3 == null) goto L79;
        Window r19 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
        if (r19 == null) goto L80;
        r19.addFlags(8192);
        return;
    L80:
        return;
    L79:
        return;
    L56:
        if (r3 == null) goto L82;
        Window r20 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
        if (r20 == null) goto L83;
        r20.clearFlags(8192);
        return;
    L83:
        return;
    L82:
        return;
    L38:
        if (r14 != 3) goto L47;
        View r21 = this.f25765c;
        if (r21 == null) goto L42;
        r21.setVisibility(8);
    L42:
        if (r3 == null) goto L76;
        Window r22 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
        if (r22 == null) goto L77;
        r22.clearFlags(8192);
        return;
    L77:
        return;
    L76:
        return;
    L47:
        throw new k();
    L32:
        r13 = false;
        goto L33
    L20:
        r8 = a.f25766a;     // Catch: Throwable -> L24
        goto L22
    L21:
        r8 = a.f25767b;     // Catch: Throwable -> L24
        goto L22
    L16:
        r4 = b.f25770a[r1.ordinal()];     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        n.a r23 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L26
    L9:
        r3 = null;
        goto L74
    L5:
        r2 = null;
        goto L7
    }

    @Override // androidx.lifecycle.d
    public void c(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.c(r4);
    }

    private final void a(a r4) {
        int r5 = b.f25772c[r4.ordinal()];
        if (r5 != 1) goto L5;
        int r6 = ZeusTransformUtils.mapRes(R.string.obric_vd_secure_cover_inoperable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_secure_cover_inoperable");
    L10:
        View r3 = this.f25765c;
        if (r3 == null) goto L16;
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.OTextView, DbHelper.COL_ID, "OTextView")), TextView.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        r7.setText(r6);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (r5 != 2) goto L8;
        r6 = ZeusTransformUtils.mapRes(R.string.obric_vd_secure_cover_invisible, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_vd_secure_cover_invisible");
        goto L10
    L8:
        throw new k();
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        o.e(r4, "owner");
        super.e(r4);
    }
}
