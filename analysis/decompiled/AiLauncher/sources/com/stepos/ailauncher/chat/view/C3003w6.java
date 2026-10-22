package com.stepos.ailauncher.chat.view;

import A7.C0743k;
import A7.C0746n;
import android.content.Context;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013JY\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\b\b\u0000\u0010\u001a*\u00020\u0019*\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/view/w6;", "", "<init>", "()V", "Landroid/view/View;", "target", "", "crossWindow", "", "cornerRadiusDp", "Ly7/E;", Const.INTENT_KEY_UMID, "(Landroid/view/View;ZF)Ly7/E;", "radiusPx", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/view/B6;", "LY8/t;", "onBlurBinding", "c", "(Landroid/view/View;FFLp9/l;)Ly7/E;", "", "tintOverride", "blurRadiusPx", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;ZFLjava/lang/Integer;Ljava/lang/Float;Lp9/l;)Ly7/E;", "Ly7/F;", "P", "Ly7/C;", "params", "e", "(Ly7/C;Ly7/F;)Ly7/C;", "KEYBOARD_TINT", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.w6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3003w6 {
    public static final C3003w6 INSTANCE = new C3003w6();
    private static final int KEYBOARD_TINT = 1291845632;

    /* JADX INFO: Add missing generic type declarations: [P] */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"com/stepos/ailauncher/chat/view/w6$a", "Ly7/C;", Const.INTENT_KEY_PKGNAME, "()Ly7/F;", "Landroid/content/Context;", "context", "", "isSupported", "(Landroid/content/Context;)Z", "Landroid/view/View;", "view", "params", "Ly7/s;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Ly7/F;)Ly7/s;", "", "getId", "()Ljava/lang/String;", "id", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.w6$a */
    public static final class a<P> implements y7.C<P> {
        private final /* synthetic */ y7.C<P> $$delegate_0;

        /* JADX INFO: Incorrect field signature: TP; */
        final /* synthetic */ y7.F $params;

        /* JADX WARN: Incorrect types in method signature: (Ly7/C<TP;>;TP;)V */
        public a(y7.C c10, y7.F f10) {
            this.$params = f10;
            this.$$delegate_0 = c10;
        }

        /* JADX WARN: Incorrect types in method signature: (Landroid/view/View;TP;)Ly7/s; */
        @Override // y7.C
        public y7.s a(View view, y7.F params) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(params, "params");
            return this.$$delegate_0.a(view, params);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TP; */
        @Override // y7.C
        /* renamed from: b, reason: from getter */
        public y7.F get$params() {
            return this.$params;
        }

        @Override // y7.C
        public String getId() {
            return this.$$delegate_0.getId();
        }

        @Override // y7.C
        public boolean isSupported(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            return this.$$delegate_0.isSupported(context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ y7.E b(C3003w6 c3003w6, View view, boolean z10, float f10, Integer num, Float f11, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            num = null;
        }
        if ((i10 & 16) != 0) {
            f11 = null;
        }
        if ((i10 & 32) != 0) {
            interfaceC5074l = null;
        }
        return c3003w6.a(view, z10, f10, num, f11, interfaceC5074l);
    }

    public final y7.E a(View target, boolean crossWindow, float cornerRadiusDp, Integer tintOverride, Float blurRadiusPx, InterfaceC5074l<? super B6, Y8.t> onBlurBinding) {
        y7.C cE;
        float f10 = target.getResources().getDisplayMetrics().density;
        y7.o oVarI = y7.o.INSTANCE.i();
        C0746n c0746nD = oVarI.D(f10);
        if (tintOverride != null) {
            c0746nD.o(tintOverride.intValue());
        }
        if (blurRadiusPx != null) {
            c0746nD.n(blurRadiusPx.floatValue());
        }
        if (onBlurBinding != null) {
            cE = new B6(c0746nD);
            onBlurBinding.invoke(cE);
        } else {
            cE = e(y7.G.f43879a.b(), c0746nD);
        }
        A7.Z zG = oVarI.G(f10);
        A7.L lE = oVarI.E(f10);
        A7.S sF = oVarI.F(f10);
        C0743k c0743kC = oVarI.C(f10);
        y7.B bK = y7.B.k(y7.H.a(s7.p.f40121a, target).x(crossWindow).w(cornerRadiusDp * f10), cE, null, 2, null);
        y7.G g10 = y7.G.f43879a;
        y7.E eU = y7.B.k(y7.B.k(y7.B.k(y7.B.k(bK, e(g10.f(), zG), null, 2, null), e(g10.d(), lE), null, 2, null), e(g10.e(), sF), null, 2, null), e(g10.a(), c0743kC), null, 2, null).u();
        if (eU.c() != 0) {
            return eU;
        }
        C2851i7.INSTANCE.h(eU);
        return null;
    }

    public final y7.E c(View target, float cornerRadiusDp, float radiusPx, InterfaceC5074l<? super B6, Y8.t> onBlurBinding) {
        kotlin.jvm.internal.p.i(target, "target");
        kotlin.jvm.internal.p.i(onBlurBinding, "onBlurBinding");
        return b(this, target, false, cornerRadiusDp, null, Float.valueOf(radiusPx), onBlurBinding, 8, null);
    }

    public final y7.E d(View target, boolean crossWindow, float cornerRadiusDp) {
        kotlin.jvm.internal.p.i(target, "target");
        return b(this, target, crossWindow, cornerRadiusDp, Integer.valueOf(KEYBOARD_TINT), null, null, 48, null);
    }

    public final <P extends y7.F> y7.C<P> e(y7.C<P> c10, P p10) {
        return new a(c10, p10);
    }
}
