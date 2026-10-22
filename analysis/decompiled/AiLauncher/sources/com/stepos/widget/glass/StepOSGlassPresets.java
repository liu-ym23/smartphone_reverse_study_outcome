package com.stepos.widget.glass;

import A7.C0743k;
import A7.C0746n;
import Z8.C1172u;
import Z8.C1173v;
import com.stepos.ailauncher.chat.view.K7;
import com.stepos.ailauncher.task.detail.chip.TaskChipController;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import y7.o;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jk\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0014J\u0015\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0014J\u0015\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0014J\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0014J\u0015\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0014J\u0015\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0014J!\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/widget/glass/StepOSGlassPresets;", "", "<init>", "()V", "Ly7/o;", "base", "", "density", "innerShadowIntensityScale", "", "Lkotlin/Pair;", "", "blendStagesOverride", "edgeColorOverride", "darkColorOverride", "refractionStrengthOverride", "Lcom/stepos/widget/glass/GlassCustomizer;", "copyTier", "(Ly7/o;FFLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lcom/stepos/widget/glass/GlassCustomizer;", "LIGHT_SMALL_TUNED", "(F)Lcom/stepos/widget/glass/GlassCustomizer;", "DARK_SMALL_TUNED", "DARK_SMALL_BLEND_10", "LIGHT_MENU", "DARK_MENU", "MENU_LIGHT_TUNED", "MENU_DARK_TUNED", "TAB_BAR_LIGHT_TUNED", "TITLE_BAR_LIGHT_TUNED", "TITLE_BAR_DARK_TUNED", "CIRCLE_BUTTON_DARK_TUNED", "TAB_BAR_DARK_TUNED", "effect", "forSmallPreset$StepOSWidget_release", "(Ly7/o;F)Lcom/stepos/widget/glass/GlassCustomizer;", "forSmallPreset", "SMALL_REFRACTION_STRENGTH", "F", "LIGHT_SMALL_PROJECTION_SCALE", "DARK_BLEND_WHITE_10", "I", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSGlassPresets {
    private static final int DARK_BLEND_WHITE_10 = 452984831;
    public static final StepOSGlassPresets INSTANCE = new StepOSGlassPresets();
    private static final float LIGHT_SMALL_PROJECTION_SCALE = 0.5f;
    private static final float SMALL_REFRACTION_STRENGTH = 30.0f;

    private StepOSGlassPresets() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B CIRCLE_BUTTON_DARK_TUNED$lambda$35(final float f10, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.i0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$30((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.j0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$31((A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.k0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$32(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.l0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$33((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.m0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$34((C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$30(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(30.0f);
        apply.o(16777215);
        apply.l(0.06f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$31(A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.18f);
        apply.I(4.0f);
        apply.H(4.0f);
        apply.y(1.0f);
        apply.A(1.0f);
        apply.v(true);
        apply.u(1.0f);
        apply.z(-2136562010);
        apply.x(866559654);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        apply.D((float) Math.cos(radians));
        apply.E((float) Math.sin(radians));
        apply.F((float) Math.cos(radians2));
        apply.G((float) Math.sin(radians2));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$32(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(K7.INNER_SHADOW_COLOR);
        apply.p(f10 * 6.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$33(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(64.0f);
        apply.n(99.0f);
        apply.k(20.0f);
        apply.j(0.2f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t CIRCLE_BUTTON_DARK_TUNED$lambda$35$lambda$34(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1172u.e(Y8.j.a(0, 731486617)));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B MENU_DARK_TUNED$lambda$11(final float f10, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_DARK_TUNED$lambda$11$lambda$6((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_DARK_TUNED$lambda$11$lambda$7((A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_DARK_TUNED$lambda$11$lambda$8(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_DARK_TUNED$lambda$11$lambda$9((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_DARK_TUNED$lambda$11$lambda$10((C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_DARK_TUNED$lambda$11$lambda$10(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1173v.p(Y8.j.a(0, -15066598), Y8.j.a(0, -434496998), Y8.j.a(0, -1290135014)));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_DARK_TUNED$lambda$11$lambda$6(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.o(16777215);
        apply.l(0.16f);
        apply.n(30.0f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_DARK_TUNED$lambda$11$lambda$7(A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.25f);
        apply.H(0.0f);
        apply.I(0.0f);
        apply.A(0.5f);
        apply.y(0.75f);
        apply.z(-5855578);
        apply.x(-5855578);
        apply.u(1.0f);
        apply.v(true);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        apply.D((float) Math.cos(radians));
        apply.E((float) Math.sin(radians));
        apply.F((float) Math.cos(radians2));
        apply.G((float) Math.sin(radians2));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_DARK_TUNED$lambda$11$lambda$8(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(-15066598);
        apply.p(f10 * 10.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_DARK_TUNED$lambda$11$lambda$9(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(70.0f);
        apply.n(30.0f);
        apply.k(20.0f);
        apply.j(0.2f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B MENU_LIGHT_TUNED$lambda$5(final float f10, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_LIGHT_TUNED$lambda$5$lambda$0((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_LIGHT_TUNED$lambda$5$lambda$1((A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_LIGHT_TUNED$lambda$5$lambda$2(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_LIGHT_TUNED$lambda$5$lambda$3((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.MENU_LIGHT_TUNED$lambda$5$lambda$4((C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_LIGHT_TUNED$lambda$5$lambda$0(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.o(16777215);
        apply.l(0.16f);
        apply.n(30.0f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_LIGHT_TUNED$lambda$5$lambda$1(A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.25f);
        apply.H(0.0f);
        apply.I(0.0f);
        apply.A(0.5f);
        apply.y(0.75f);
        apply.z(-2368549);
        apply.x(-2368549);
        apply.u(1.0f);
        apply.v(true);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        apply.D((float) Math.cos(radians));
        apply.E((float) Math.sin(radians));
        apply.F((float) Math.cos(radians2));
        apply.G((float) Math.sin(radians2));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_LIGHT_TUNED$lambda$5$lambda$2(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(-14145496);
        apply.p(f10 * 10.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_LIGHT_TUNED$lambda$5$lambda$3(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(70.0f);
        apply.n(30.0f);
        apply.k(20.0f);
        apply.j(0.2f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t MENU_LIGHT_TUNED$lambda$5$lambda$4(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1173v.p(Y8.j.a(0, 448774079), Y8.j.a(0, Integer.valueOf(TaskChipController.STATIC_TEXT_COLOR))));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B TAB_BAR_DARK_TUNED$lambda$41(final float f10, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.N
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_DARK_TUNED$lambda$41$lambda$36((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.O
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_DARK_TUNED$lambda$41$lambda$37((A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.P
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_DARK_TUNED$lambda$41$lambda$38(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.Q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_DARK_TUNED$lambda$41$lambda$39((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.S
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_DARK_TUNED$lambda$41$lambda$40((C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_DARK_TUNED$lambda$41$lambda$36(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(30.0f);
        apply.o(16777215);
        apply.l(0.06f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_DARK_TUNED$lambda$41$lambda$37(A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.18f);
        apply.I(4.0f);
        apply.H(4.0f);
        apply.y(1.0f);
        apply.A(1.0f);
        apply.v(true);
        apply.u(1.0f);
        apply.z(-5855578);
        apply.x(-2136562010);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        apply.D((float) Math.cos(radians));
        apply.E((float) Math.sin(radians));
        apply.F((float) Math.cos(radians2));
        apply.G((float) Math.sin(radians2));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_DARK_TUNED$lambda$41$lambda$38(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(K7.INNER_SHADOW_COLOR);
        apply.p(f10 * 6.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_DARK_TUNED$lambda$41$lambda$39(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(64.0f);
        apply.n(99.0f);
        apply.k(20.0f);
        apply.j(0.2f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_DARK_TUNED$lambda$41$lambda$40(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1172u.e(Y8.j.a(0, 731486617)));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B TAB_BAR_LIGHT_TUNED$lambda$17(final float f10, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_LIGHT_TUNED$lambda$17$lambda$12((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_LIGHT_TUNED$lambda$17$lambda$13((A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_LIGHT_TUNED$lambda$17$lambda$14(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_LIGHT_TUNED$lambda$17$lambda$15((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TAB_BAR_LIGHT_TUNED$lambda$17$lambda$16((C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_LIGHT_TUNED$lambda$17$lambda$12(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(30.0f);
        apply.o(16777215);
        apply.l(0.06f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_LIGHT_TUNED$lambda$17$lambda$13(A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.18f);
        apply.I(4.0f);
        apply.H(4.0f);
        apply.y(1.0f);
        apply.A(1.0f);
        apply.v(true);
        apply.u(1.0f);
        apply.z(-1513240);
        apply.x(-2133798704);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        apply.D((float) Math.cos(radians));
        apply.E((float) Math.sin(radians));
        apply.F((float) Math.cos(radians2));
        apply.G((float) Math.sin(radians2));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_LIGHT_TUNED$lambda$17$lambda$14(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(K7.INNER_SHADOW_COLOR);
        apply.p(f10 * 6.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_LIGHT_TUNED$lambda$17$lambda$15(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(70.0f);
        apply.n(167.0f);
        apply.k(20.0f);
        apply.j(0.3f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TAB_BAR_LIGHT_TUNED$lambda$17$lambda$16(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1173v.p(Y8.j.a(0, 871954680), Y8.j.a(1, -1723579324), Y8.j.a(4, 1073741823), Y8.j.a(6, 1056964608)));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B TITLE_BAR_DARK_TUNED$lambda$29(final float f10, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.Z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_DARK_TUNED$lambda$29$lambda$24((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.a0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_DARK_TUNED$lambda$29$lambda$25((A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.b0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_DARK_TUNED$lambda$29$lambda$26(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.c0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_DARK_TUNED$lambda$29$lambda$27((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.d0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_DARK_TUNED$lambda$29$lambda$28((C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_DARK_TUNED$lambda$29$lambda$24(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(30.0f);
        apply.o(16777215);
        apply.l(0.06f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_DARK_TUNED$lambda$29$lambda$25(A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.18f);
        apply.I(4.0f);
        apply.H(4.0f);
        apply.y(1.0f);
        apply.A(1.0f);
        apply.v(true);
        apply.u(1.0f);
        apply.z(866559654);
        apply.x(866559654);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        apply.D((float) Math.cos(radians));
        apply.E((float) Math.sin(radians));
        apply.F((float) Math.cos(radians2));
        apply.G((float) Math.sin(radians2));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_DARK_TUNED$lambda$29$lambda$26(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(K7.INNER_SHADOW_COLOR);
        apply.p(f10 * 6.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_DARK_TUNED$lambda$29$lambda$27(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(64.0f);
        apply.n(99.0f);
        apply.k(20.0f);
        apply.j(0.2f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_DARK_TUNED$lambda$29$lambda$28(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1172u.e(Y8.j.a(0, 731486617)));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B TITLE_BAR_LIGHT_TUNED$lambda$23(final float f10, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$18((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.U
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$19((A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$20(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.W
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$21((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.X
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$22((C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$18(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(30.0f);
        apply.o(16777215);
        apply.l(0.06f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$19(A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.18f);
        apply.I(4.0f);
        apply.H(4.0f);
        apply.y(1.0f);
        apply.A(1.0f);
        apply.v(true);
        apply.u(1.0f);
        apply.z(552134888);
        apply.x(550555856);
        double radians = Math.toRadians(270.0d);
        double radians2 = Math.toRadians(45.0d);
        apply.D((float) Math.cos(radians));
        apply.E((float) Math.sin(radians));
        apply.F((float) Math.cos(radians2));
        apply.G((float) Math.sin(radians2));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$20(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(K7.INNER_SHADOW_COLOR);
        apply.p(f10 * 6.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$21(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(70.0f);
        apply.n(167.0f);
        apply.k(20.0f);
        apply.j(0.3f);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t TITLE_BAR_LIGHT_TUNED$lambda$23$lambda$22(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(C1173v.p(Y8.j.a(0, 871954680), Y8.j.a(1, -1723579324), Y8.j.a(4, 1073741823), Y8.j.a(6, 1056964608)));
        return Y8.t.f7040a;
    }

    private final GlassCustomizer copyTier(y7.o base, float density, float innerShadowIntensityScale, List<Pair<Integer, Integer>> blendStagesOverride, Integer edgeColorOverride, Integer darkColorOverride, Float refractionStrengthOverride) {
        final C0746n c0746nD = base.D(density);
        final A7.Z zG = base.G(density);
        final A7.L lE = base.E(density);
        final A7.S sF = base.F(density);
        final C0743k c0743kC = base.C(density);
        lE.m(lE.getIntensity() * innerShadowIntensityScale);
        if (refractionStrengthOverride != null) {
            sF.m(refractionStrengthOverride.floatValue());
        }
        if (edgeColorOverride != null) {
            zG.z(edgeColorOverride.intValue());
        }
        if (darkColorOverride != null) {
            zG.x(darkColorOverride.intValue());
        }
        if (blendStagesOverride != null) {
            c0743kC.f(blendStagesOverride);
        }
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.C
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.copyTier$lambda$50(c0746nD, zG, lE, sF, c0743kC, b10);
            }
        };
    }

    public static /* synthetic */ GlassCustomizer copyTier$default(StepOSGlassPresets stepOSGlassPresets, y7.o oVar, float f10, float f11, List list, Integer num, Integer num2, Float f12, int i10, Object obj) {
        Float f13;
        StepOSGlassPresets stepOSGlassPresets2;
        y7.o oVar2;
        float f14;
        if ((i10 & 4) != 0) {
            f11 = 1.0f;
        }
        float f15 = f11;
        List list2 = (i10 & 8) != 0 ? null : list;
        Integer num3 = (i10 & 16) != 0 ? null : num;
        Integer num4 = (i10 & 32) != 0 ? null : num2;
        if ((i10 & 64) != 0) {
            f13 = null;
            oVar2 = oVar;
            f14 = f10;
            stepOSGlassPresets2 = stepOSGlassPresets;
        } else {
            f13 = f12;
            stepOSGlassPresets2 = stepOSGlassPresets;
            oVar2 = oVar;
            f14 = f10;
        }
        return stepOSGlassPresets2.copyTier(oVar2, f14, f15, list2, num3, num4, f13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B copyTier$lambda$50(final C0746n c0746n, final A7.Z z10, final A7.L l10, final A7.S s10, final C0743k c0743k, y7.B builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        y7.G g10 = y7.G.f43879a;
        return builder.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.copyTier$lambda$50$lambda$45(c0746n, (C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.copyTier$lambda$50$lambda$46(z10, (A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.M
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.copyTier$lambda$50$lambda$47(l10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.Y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.copyTier$lambda$50$lambda$48(s10, (A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.widget.glass.h0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSGlassPresets.copyTier$lambda$50$lambda$49(c0743k, (C0743k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t copyTier$lambda$50$lambda$45(C0746n c0746n, C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        StepOSGlassPresetsKt.copyFrom(apply, c0746n);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t copyTier$lambda$50$lambda$46(A7.Z z10, A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        StepOSGlassPresetsKt.copyFrom(apply, z10);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t copyTier$lambda$50$lambda$47(A7.L l10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        StepOSGlassPresetsKt.copyFrom(apply, l10);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t copyTier$lambda$50$lambda$48(A7.S s10, A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        StepOSGlassPresetsKt.copyFrom(apply, s10);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t copyTier$lambda$50$lambda$49(C0743k c0743k, C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(c0743k.e());
        return Y8.t.f7040a;
    }

    public final GlassCustomizer CIRCLE_BUTTON_DARK_TUNED(final float density) {
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.K
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.CIRCLE_BUTTON_DARK_TUNED$lambda$35(density, b10);
            }
        };
    }

    public final GlassCustomizer DARK_MENU(float density) {
        return copyTier$default(this, y7.o.INSTANCE.h(), density, 0.0f, null, 201326592, 419430400, null, 76, null);
    }

    public final GlassCustomizer DARK_SMALL_BLEND_10(float density) {
        return copyTier$default(this, y7.o.INSTANCE.i(), density, 0.0f, C1172u.e(Y8.j.a(0, Integer.valueOf(DARK_BLEND_WHITE_10))), null, null, Float.valueOf(30.0f), 52, null);
    }

    public final GlassCustomizer DARK_SMALL_TUNED(float density) {
        return copyTier$default(this, y7.o.INSTANCE.i(), density, 0.0f, null, null, null, Float.valueOf(30.0f), 60, null);
    }

    public final GlassCustomizer LIGHT_MENU(float density) {
        return copyTier$default(this, y7.o.INSTANCE.j(), density, 0.0f, null, 201326592, 419430400, null, 76, null);
    }

    public final GlassCustomizer LIGHT_SMALL_TUNED(float density) {
        return copyTier$default(this, y7.o.INSTANCE.k(), density, 0.5f, null, null, null, Float.valueOf(30.0f), 56, null);
    }

    public final GlassCustomizer MENU_DARK_TUNED(final float density) {
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.J
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.MENU_DARK_TUNED$lambda$11(density, b10);
            }
        };
    }

    public final GlassCustomizer MENU_LIGHT_TUNED(final float density) {
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.I
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.MENU_LIGHT_TUNED$lambda$5(density, b10);
            }
        };
    }

    public final GlassCustomizer TAB_BAR_DARK_TUNED(final float density) {
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.f0
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.TAB_BAR_DARK_TUNED$lambda$41(density, b10);
            }
        };
    }

    public final GlassCustomizer TAB_BAR_LIGHT_TUNED(final float density) {
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.g0
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.TAB_BAR_LIGHT_TUNED$lambda$17(density, b10);
            }
        };
    }

    public final GlassCustomizer TITLE_BAR_DARK_TUNED(final float density) {
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.e0
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.TITLE_BAR_DARK_TUNED$lambda$29(density, b10);
            }
        };
    }

    public final GlassCustomizer TITLE_BAR_LIGHT_TUNED(final float density) {
        return new GlassCustomizer() { // from class: com.stepos.widget.glass.L
            @Override // com.stepos.widget.glass.GlassCustomizer
            public final y7.B customize(y7.B b10) {
                return StepOSGlassPresets.TITLE_BAR_LIGHT_TUNED$lambda$23(density, b10);
            }
        };
    }

    public final GlassCustomizer forSmallPreset$StepOSWidget_release(y7.o effect, float density) {
        kotlin.jvm.internal.p.i(effect, "effect");
        o.Companion companion = y7.o.INSTANCE;
        if (kotlin.jvm.internal.p.d(effect, companion.k())) {
            return LIGHT_SMALL_TUNED(density);
        }
        if (kotlin.jvm.internal.p.d(effect, companion.i())) {
            return DARK_SMALL_TUNED(density);
        }
        return null;
    }
}
