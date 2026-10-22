package com.stepos.ailauncher.chat.view;

import A7.C0743k;
import A7.C0746n;
import Z8.C1172u;
import android.util.Log;
import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R)\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0014\u0010!\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0014\u0010\"\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0011R\u0014\u0010#\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0011R\u0014\u0010$\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u0011R\u0014\u0010'\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u0011R\u0014\u0010(\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u0011R\u0014\u0010)\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u0011¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/chat/view/K7;", "", "<init>", "()V", "Landroid/view/View;", "target", "", "crossWindow", "", "cornerRadiusDp", "Ly7/E;", "f", "(Landroid/view/View;ZLjava/lang/Float;)Ly7/E;", "", "TAG", "Ljava/lang/String;", "BLUR_RADIUS_PX", "F", "", "BLUR_TINT_COLOR", "I", "FROST", "", "Lkotlin/Pair;", "BLEND_STAGES", "Ljava/util/List;", "getBLEND_STAGES", "()Ljava/util/List;", "STROKE_INTENSITY", "STROKE_SPREAD", "STROKE_EDGE_ALPHA", "EDGE_RGB", "DARK_EDGE_RGB", "INNER_SHADOW_COLOR", "INNER_SHADOW_RADIUS_DP", "INNER_SHADOW_INTENSITY", "REFRACTION_ENABLED", "Z", "REFRACTION_STRENGTH", "REFRACTION_WIDTH", "REFRACTION_DISPERSION", "REFRACTION_DEPTH", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K7 {
    public static final float BLUR_RADIUS_PX = 90.0f;
    public static final int BLUR_TINT_COLOR = 16777215;
    private static final int DARK_EDGE_RGB = 13684944;
    private static final int EDGE_RGB = 13421772;
    public static final float FROST = 0.0f;
    public static final int INNER_SHADOW_COLOR = 855638015;
    public static final float INNER_SHADOW_INTENSITY = 0.15f;
    public static final float INNER_SHADOW_RADIUS_DP = 22.0f;
    public static final float REFRACTION_DEPTH = 0.28f;
    public static final float REFRACTION_DISPERSION = 6.0f;
    public static final boolean REFRACTION_ENABLED = true;
    public static final float REFRACTION_STRENGTH = 100.0f;
    public static final float REFRACTION_WIDTH = 167.0f;
    public static final int STROKE_EDGE_ALPHA = 128;
    public static final float STROKE_INTENSITY = 0.18f;
    public static final float STROKE_SPREAD = 4.0f;
    private static final String TAG = "SearchInputGlass";
    public static final K7 INSTANCE = new K7();
    private static final List<Pair<Integer, Integer>> BLEND_STAGES = C1172u.e(Y8.j.a(0, 100663295));

    public static final Y8.t g(C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(90.0f);
        apply.o(16777215);
        apply.l(0.0f);
        return Y8.t.f7040a;
    }

    public static final Y8.t h(double d10, double d11, A7.Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.J(1.0f);
        apply.C(0.18f);
        apply.I(4.0f);
        apply.D((float) Math.cos(d10));
        apply.E((float) Math.sin(d10));
        apply.F((float) Math.cos(d11));
        apply.G((float) Math.sin(d11));
        apply.u(1.0f);
        apply.v(true);
        apply.z(-2134061876);
        apply.x(-2133798704);
        return Y8.t.f7040a;
    }

    public static final Y8.t i(float f10, A7.L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.k(INNER_SHADOW_COLOR);
        apply.p(f10 * 22.0f);
        apply.m(0.15f);
        return Y8.t.f7040a;
    }

    public static final Y8.t j(A7.S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.m(100.0f);
        apply.n(167.0f);
        apply.k(6.0f);
        apply.j(0.28f);
        return Y8.t.f7040a;
    }

    public static final Y8.t k(C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(BLEND_STAGES);
        return Y8.t.f7040a;
    }

    public final y7.E f(View target, boolean crossWindow, Float cornerRadiusDp) {
        kotlin.jvm.internal.p.i(target, "target");
        final float f10 = target.getResources().getDisplayMetrics().density;
        y7.B bX = y7.H.a(s7.p.f40121a, target).x(crossWindow);
        if (cornerRadiusDp != null) {
            bX.w(cornerRadiusDp.floatValue() * f10);
        }
        final double radians = Math.toRadians(270.0d);
        final double radians2 = Math.toRadians(45.0d);
        y7.G g10 = y7.G.f43879a;
        y7.E eU = bX.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.F7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K7.g((C0746n) obj);
            }
        }).j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.G7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K7.h(radians, radians2, (A7.Z) obj);
            }
        }).j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.H7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K7.i(f10, (A7.L) obj);
            }
        }).j(g10.e(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.I7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K7.j((A7.S) obj);
            }
        }).j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.J7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return K7.k((C0743k) obj);
            }
        }).u();
        if (eU.c() == 0) {
            Log.i(TAG, "attach: fully degraded view=" + target.getClass().getSimpleName() + ", release");
            eU.g();
            return null;
        }
        Log.d(TAG, "attach: view=" + target.getClass().getSimpleName() + " crossWindow=" + crossWindow + " cornerRadiusDp=" + cornerRadiusDp + " activeCount=" + eU.c() + " ids=" + eU.d());
        return eU;
    }
}
