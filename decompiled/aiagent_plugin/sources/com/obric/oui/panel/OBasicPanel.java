package com.obric.oui.panel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OBasicPanel.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OBasicPanel extends OBasicPanelFragment {
    public static final b Companion = null;
    public static final int TOP_CORNER_RADIUS = 20;
    protected a config;

    /* JADX INFO: compiled from: OBasicPanel.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f35878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f35879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f35880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.oui.panel.header.c f35881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f35882e;
        private boolean f;
        private boolean g;
        private boolean h;
        private Integer i;
        private boolean j;
        private DialogInterface.OnDismissListener k;
        private boolean l;
        private boolean m;
        private DialogInterface.OnCancelListener n;
        private boolean o;
        private boolean p;
        private int q;

        public a() {
            this(0, false, false, null, null, false, false, false, null, false, null, false, false, null, false, 32767, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f35878a == r6.f35878a) goto L12;
            return false;
        L12:
            if (this.f35879b == r6.f35879b) goto L15;
            return false;
        L15:
            if (this.f35880c == r6.f35880c) goto L18;
            return false;
        L18:
            if (o.a(this.f35881d, r6.f35881d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f35882e, r6.f35882e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (o.a(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (o.a(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (o.a(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L53;
            return false;
        L53:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v29, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v25, types: [int] */
        /* JADX WARN: Type inference failed for: r1v27, types: [int] */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v44 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v47 */
        /* JADX WARN: Type inference failed for: r1v48 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r0 = Integer.hashCode(this.f35878a) * 31;
            boolean r1 = this.f35879b;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.f35880c;
            ?? r6 = r5;
            if (r5 == false) goto L8;
            r6 = 1;
        L8:
            int r7 = (r4 + r6) * 31;
            com.obric.oui.panel.header.c r8 = this.f35881d;
            int r9 = 0;
            if (r8 != null) goto L11;
            int r10 = 0;
        L12:
            int r11 = (r7 + r10) * 31;
            View r12 = this.f35882e;
            if (r12 != null) goto L15;
            int r13 = 0;
        L16:
            int r14 = (r11 + r13) * 31;
            boolean r15 = this.f;
            ?? r16 = r15;
            if (r15 == false) goto L19;
            r16 = 1;
        L19:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.g;
            ?? r19 = r18;
            if (r18 == false) goto L22;
            r19 = 1;
        L22:
            int r20 = (r17 + r19) * 31;
            boolean r21 = this.h;
            ?? r22 = r21;
            if (r21 == false) goto L25;
            r22 = 1;
        L25:
            int r23 = (r20 + r22) * 31;
            Integer r24 = this.i;
            if (r24 != null) goto L28;
            int r25 = 0;
        L29:
            int r26 = (r23 + r25) * 31;
            boolean r27 = this.j;
            ?? r28 = r27;
            if (r27 == false) goto L32;
            r28 = 1;
        L32:
            int r29 = (r26 + r28) * 31;
            DialogInterface.OnDismissListener r30 = this.k;
            if (r30 != null) goto L35;
            int r31 = 0;
        L36:
            int r32 = (r29 + r31) * 31;
            boolean r33 = this.l;
            ?? r34 = r33;
            if (r33 == false) goto L39;
            r34 = 1;
        L39:
            int r35 = (r32 + r34) * 31;
            boolean r36 = this.m;
            ?? r37 = r36;
            if (r36 == false) goto L42;
            r37 = 1;
        L42:
            int r38 = (r35 + r37) * 31;
            DialogInterface.OnCancelListener r39 = this.n;
            if (r39 == null) goto L46;
            r9 = r39.hashCode();
        L46:
            int r40 = (r38 + r9) * 31;
            boolean r41 = this.o;
            if (r41 == true) goto L51;
            r2 = r41;
        L51:
            return r40 + r2;
        L35:
            r31 = r30.hashCode();
            goto L36
        L28:
            r25 = r24.hashCode();
            goto L29
        L15:
            r13 = r12.hashCode();
            goto L16
        L11:
            r10 = r8.hashCode();
            goto L12
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Builder(maxPanelHeight=").append(this.f35878a).append(", useToneBg=").append(this.f35879b).append(", isExpandable=").append(this.f35880c).append(", header=").append(this.f35881d).append(", content=").append(this.f35882e).append(", floatHeader=").append(this.f).append(", backgroundDimEnable=").append(this.g).append(", adaptNavBarColor=").append(this.h).append(", navBarColor=").append(this.i).append(", clipTopCorner=").append(this.j).append(", dismissListener=").append(this.k).append(", retainInstance=");
            r0.append(this.l).append(", autoSwitchDayNight=").append(this.m).append(", onCancelListener=").append(this.n).append(", removeMinHeight=").append(this.o).append(')');
            return r0.toString();
        }

        public a(int r6, boolean r7, boolean r8, com.obric.oui.panel.header.c r9, View r10, boolean r11, boolean r12, boolean r13, Integer r14, boolean r15, DialogInterface.OnDismissListener r16, boolean r17, boolean r18, DialogInterface.OnCancelListener r19, boolean r20) {
            DialogInterface.OnDismissListener r1 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r16, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
            DialogInterface.OnCancelListener r2 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r19, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin");
            this.f35878a = r6;
            this.f35879b = r7;
            this.f35880c = r8;
            this.f35881d = r9;
            this.f35882e = r10;
            this.f = r11;
            this.g = r12;
            this.h = r13;
            this.i = r14;
            this.j = r15;
            this.k = r1;
            this.l = r17;
            this.m = r18;
            this.n = r2;
            this.o = r20;
            this.p = true;
            this.q = ZeusTransformUtils.mapRes(R.style.OBasicPanel, "style", "OBasicPanel");
        }

        public /* synthetic */ a(int r17, boolean r18, boolean r19, com.obric.oui.panel.header.c r20, View r21, boolean r22, boolean r23, boolean r24, Integer r25, boolean r26, DialogInterface.OnDismissListener r27, boolean r28, boolean r29, DialogInterface.OnCancelListener r30, boolean r31, int r32, h r33) {
            DialogInterface.OnDismissListener r1 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r27, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
            DialogInterface.OnCancelListener r2 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r30, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin");
            if ((r32 & 1) == 0) goto L5;
            int r3 = -1;
        L7:
            if ((r32 & 2) == 0) goto L9;
            boolean r4 = false;
        L11:
            if ((r32 & 4) == 0) goto L13;
            boolean r6 = false;
        L15:
            if ((r32 & 8) == 0) goto L17;
            com.obric.oui.panel.header.c r7 = null;
        L19:
            if ((r32 & 16) == 0) goto L21;
            View r9 = null;
        L23:
            if ((r32 & 32) == 0) goto L25;
            boolean r10 = false;
        L26:
            boolean r12 = true;
            if ((r32 & 64) == 0) goto L29;
            boolean r11 = true;
        L31:
            if ((r32 & 128) == 0) goto L33;
            boolean r13 = false;
        L35:
            if ((r32 & 256) == 0) goto L37;
            Integer r14 = null;
        L39:
            if ((r32 & 512) != 0) goto L43;
            r12 = r26;
        L43:
            if ((r32 & 1024) == 0) goto L46;
            r1 = null;
        L46:
            if ((r32 & 2048) == 0) goto L48;
            boolean r15 = false;
        L50:
            if ((r32 & 4096) == 0) goto L52;
            boolean r5 = false;
        L54:
            if ((r32 & 8192) == 0) goto L57;
            r2 = null;
        L57:
            if ((r32 & 16384) == 0) goto L59;
            boolean r0 = false;
        L60:
            this(r3, r4, r6, r7, r9, r10, r11, r13, r14, r12, r1, r15, r5, r2, r0);
            return;
        L59:
            r0 = r31;
            goto L60
        L52:
            r5 = r29;
            goto L54
        L48:
            r15 = r28;
            goto L50
        L37:
            r14 = r25;
            goto L39
        L33:
            r13 = r24;
            goto L35
        L29:
            r11 = r23;
            goto L31
        L25:
            r10 = r22;
            goto L26
        L21:
            r9 = r21;
            goto L23
        L17:
            r7 = r20;
            goto L19
        L13:
            r6 = r19;
            goto L15
        L9:
            r4 = r18;
            goto L11
        L5:
            r3 = r17;
            goto L7
        }

        public final View a() {
            return this.f35882e;
        }
    }

    /* JADX INFO: compiled from: OBasicPanel.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: OBasicPanel.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f35883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f35884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a f35885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f35886d;

        /* JADX INFO: compiled from: OBasicPanel.kt */
        public static final enum a extends Enum<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f35887a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f35888b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final a f35889c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ a[] f35890d = null;

            private static final /* synthetic */ a[] a() {
                return new a[]{f35887a, f35888b, f35889c};
            }

            public static a valueOf(String r2) {
                return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
            }

            public static a[] values() {
                return (a[]) ZeusTransformUtils.preCheckCast(f35890d.clone(), a[].class, "com.obric.aiagent.plugin");
            }

            private a(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f35887a = new a("BLACK_NO_BG", 0);
                f35888b = new a("WHITE_WITH_BG", 1);
                f35889c = new a("BLACK_WITH_BG", 2);
                f35890d = a();
            }
        }

        public c() {
            this(false, false, null, false, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f35883a == r6.f35883a) goto L12;
            return false;
        L12:
            if (this.f35884b == r6.f35884b) goto L15;
            return false;
        L15:
            if (this.f35885c == r6.f35885c) goto L18;
            return false;
        L18:
            if (this.f35886d == r6.f35886d) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        public int hashCode() {
            boolean r0 = this.f35883a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f35884b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (((r3 + r5) * 31) + this.f35885c.hashCode()) * 31;
            boolean r7 = this.f35886d;
            if (r7 == true) goto L13;
            r1 = r7;
        L13:
            return r6 + r1;
        }

        public String toString() {
            return "PadCompatConfig(isEnabled=" + this.f35883a + ", isMultiPanel=" + this.f35884b + ", closeIconStyle=" + this.f35885c + ", forceEnable=" + this.f35886d + ')';
        }

        public c(boolean r2, boolean r3, a r4, boolean r5) {
            o.e(r4, "closeIconStyle");
            this.f35883a = r2;
            this.f35884b = r3;
            this.f35885c = r4;
            this.f35886d = r5;
        }

        public /* synthetic */ c(boolean r2, boolean r3, a r4, boolean r5, int r6, h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = a.f35889c;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    static {
        Companion = new b(null);
    }

    public OBasicPanel() {
    }

    public final a getConfig() {
        a r0 = this.config;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("config");
        return null;
    }

    public final void setConfig(a r2) {
        o.e(r2, "<set-?>");
        this.config = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        o.e(r1, "inflater");
        if (this.config != null) goto L7;
        return null;
    L7:
        if (getConfig().a() == null) goto L12;
        View r4 = getConfig().a();
        o.a(r4);
        if (r4.getParent() == null) goto L12;
        View r5 = getConfig().a();
        o.a(r5);
        ViewParent r6 = r5.getParent();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(getConfig().a());
    L12:
        return getConfig().a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.config != null) goto L16;
        Dialog r0 = getDialog();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == false) goto L17;
        Dialog r3 = getDialog();
        if (r3 == null) goto L18;
        r3.cancel();
        return;
    L18:
        return;
    L17:
        return;
    L8:
        if (r0.isShowing() != true) goto L10;
        r1 = true;
        goto L10
    }

    public final void setPanelConfig(a r2) {
        o.e(r2, "builder");
        setConfig(r2);
    }
}
