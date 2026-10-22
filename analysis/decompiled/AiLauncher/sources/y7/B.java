package y7;

import A7.C0743k;
import A7.C0746n;
import A7.C0757z;
import A7.L;
import A7.S;
import A7.Z;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.motionkit.ErrorLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s7.MotionKitError;
import y7.E;
import z7.C6370e;
import z7.C6375j;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002)%B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0017\u001a\u00020\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0015H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010-R*\u0010:\u001a\u0016\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00100¨\u0006="}, d2 = {"Ly7/B;", "", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "", x5.d.EXTRA_ENABLED, "x", "(Z)Ly7/B;", "", "px", "w", "(F)Ly7/B;", "r", "()Ly7/B;", "Ly7/F;", "P", "Ly7/C;", "capability", "Lkotlin/Function1;", "LY8/t;", "block", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ly7/C;Lp9/l;)Ly7/B;", "Ly7/o;", "effect", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ly7/o;)Ly7/B;", "Ly7/E;", "u", "()Ly7/E;", "y", "()V", "z", "()Z", "s", Const.INTENT_KEY_APIKEY, "Landroid/view/View;", "", "Ly7/B$b;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", AuthSessionDto.STATUS_PENDING, "c", "Z", "crossWindow", Const.INTENT_KEY_UMID, "F", "cornerRadius", "e", "cornerRadiusExplicit", "f", "glassTextMode", "Lkotlin/Function2;", "LA7/z;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lp9/p;", "glassTextFragment", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "cornerSmoothness", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<b<?>> pending;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean crossWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float cornerRadius;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean cornerRadiusExplicit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean glassTextMode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public p9.p<? super C0757z, ? super Float, Y8.t> glassTextFragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public float cornerSmoothness;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001c¨\u0006\u001e"}, d2 = {"Ly7/B$b;", "Ly7/F;", "P", "", "Ly7/C;", "capability", "params", "<init>", "(Ly7/C;Ly7/F;)V", "Landroid/view/View;", "view", "", "c", "(Landroid/view/View;)Z", "crossWindow", "", "cornerRadius", "Ly7/s;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;ZF)Ly7/s;", "Ly7/C;", "getCapability", "()Ly7/C;", Const.INTENT_KEY_PKGNAME, "Ly7/F;", "getParams", "()Ly7/F;", "", "()Ljava/lang/String;", "id", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b<P extends F> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C<P> capability;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final P params;

        public b(C<P> capability, P params) {
            kotlin.jvm.internal.p.i(capability, "capability");
            kotlin.jvm.internal.p.i(params, "params");
            this.capability = capability;
            this.params = params;
        }

        public final s a(View view, boolean crossWindow, float cornerRadius) {
            kotlin.jvm.internal.p.i(view, "view");
            this.params.d(crossWindow);
            this.params.c(cornerRadius);
            return this.capability.a(view, this.params);
        }

        public final String b() {
            return this.capability.getId();
        }

        public final boolean c(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            C<P> c10 = this.capability;
            Context context = view.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            return c10.isSupported(context);
        }
    }

    public B(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        this.view = view;
        this.pending = new ArrayList();
    }

    public static /* synthetic */ B k(B b10, C c10, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: y7.z
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return B.l((F) obj2);
                }
            };
        }
        return b10.j(c10, interfaceC5074l);
    }

    public static final Y8.t l(F f10) {
        kotlin.jvm.internal.p.i(f10, "<this>");
        return Y8.t.f7040a;
    }

    public static final Y8.t m(o oVar, float f10, C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        oVar.w().invoke(apply, Float.valueOf(f10));
        return Y8.t.f7040a;
    }

    public static final Y8.t n(o oVar, float f10, Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        oVar.B().invoke(apply, Float.valueOf(f10));
        return Y8.t.f7040a;
    }

    public static final Y8.t o(o oVar, float f10, L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        oVar.z().invoke(apply, Float.valueOf(f10));
        return Y8.t.f7040a;
    }

    public static final Y8.t p(o oVar, float f10, S apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        oVar.A().invoke(apply, Float.valueOf(f10));
        return Y8.t.f7040a;
    }

    public static final Y8.t q(o oVar, float f10, C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        oVar.v().invoke(apply, Float.valueOf(f10));
        return Y8.t.f7040a;
    }

    public static final CharSequence t(E.a it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getCapabilityId();
    }

    public static final E v(B b10) {
        return b10.s();
    }

    public final B i(final o effect) {
        kotlin.jvm.internal.p.i(effect, "effect");
        final float f10 = this.view.getResources().getDisplayMetrics().density;
        if (!this.cornerRadiusExplicit) {
            this.cornerRadius = effect.getCornerRadiusDp() * f10;
        }
        G g10 = G.f43879a;
        j(g10.b(), new InterfaceC5074l() { // from class: y7.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return B.m(effect, f10, (C0746n) obj);
            }
        });
        j(g10.f(), new InterfaceC5074l() { // from class: y7.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return B.n(effect, f10, (Z) obj);
            }
        });
        j(g10.d(), new InterfaceC5074l() { // from class: y7.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return B.o(effect, f10, (L) obj);
            }
        });
        j(g10.e(), new InterfaceC5074l() { // from class: y7.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return B.p(effect, f10, (S) obj);
            }
        });
        j(g10.a(), new InterfaceC5074l() { // from class: y7.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return B.q(effect, f10, (C0743k) obj);
            }
        });
        this.glassTextFragment = effect.y();
        return this;
    }

    public final <P extends F> B j(C<P> capability, InterfaceC5074l<? super P, Y8.t> block) {
        kotlin.jvm.internal.p.i(capability, "capability");
        kotlin.jvm.internal.p.i(block, "block");
        F f10 = capability.get$params();
        block.invoke(f10);
        this.pending.add(new b<>(capability, f10));
        return this;
    }

    public final B r() {
        this.glassTextMode = true;
        return this;
    }

    public final E s() {
        s sVarA;
        ArrayList arrayList = new ArrayList();
        for (b<?> bVar : this.pending) {
            if (bVar.c(this.view)) {
                s7.p pVar = s7.p.f40121a;
                try {
                    sVarA = bVar.a(this.view, this.crossWindow, this.cornerRadius);
                } catch (Exception e10) {
                    pVar.a(new MotionKitError(ErrorLevel.DEGRADED, "FX operation failed", e10));
                    sVarA = null;
                }
                if (sVarA == null) {
                    Log.w("MotionKitMaterial", "能力 " + bVar.b() + " 绑定失败，静默降级跳过");
                } else {
                    arrayList.add(new E.a(bVar.b(), sVarA));
                }
            } else {
                Log.i("MotionKitMaterial", "能力 " + bVar.b() + " 当前设备不支持，静默降级跳过");
            }
        }
        this.pending.clear();
        if (this.crossWindow) {
            C6370e.f45191a.q(this.view, this.cornerRadius);
        } else {
            C6375j.f45214a.A(this.view, this.cornerRadius);
        }
        if (this.crossWindow) {
            C6370e.f45191a.s(this.view, this.cornerSmoothness);
        } else {
            C6375j.f45214a.C(this.view, this.cornerSmoothness);
        }
        Log.i("MotionKitMaterial", "commit: 完成，生效能力数=" + arrayList.size() + " [" + Z8.F.A0(arrayList, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: y7.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return B.t((E.a) obj);
            }
        }, 30, null) + "]");
        return new E(this.view, this.crossWindow, arrayList);
    }

    public final E u() {
        y();
        return this.crossWindow ? s() : (E) C6375j.f45214a.o(new InterfaceC5063a() { // from class: y7.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return B.v(this.f43942a);
            }
        });
    }

    public final B w(float px) {
        this.cornerRadius = px;
        this.cornerRadiusExplicit = true;
        return this;
    }

    public final B x(boolean enabled) {
        this.crossWindow = enabled;
        return this;
    }

    public final void y() {
        if (this.glassTextMode) {
            String id = G.f43879a.c().getId();
            List<b<?>> list = this.pending;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.p.d(((b) it.next()).b(), id)) {
                        Log.i("MotionKitMaterial", "commit: 已登记 " + id + "，跳过入口注入(避免绑两份)");
                        return;
                    }
                }
            }
            float f10 = this.view.getResources().getDisplayMetrics().density;
            G g10 = G.f43879a;
            C0757z c0757z = (C0757z) g10.c().get$params();
            p9.p<? super C0757z, ? super Float, Y8.t> pVar = this.glassTextFragment;
            if (pVar != null) {
                pVar.invoke(c0757z, Float.valueOf(f10));
            }
            c0757z.h(z());
            this.pending.add(new b<>(g10.c(), c0757z));
        }
    }

    public final boolean z() {
        if (this.pending.isEmpty()) {
            return false;
        }
        List<b<?>> list = this.pending;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!kotlin.jvm.internal.p.d(((b) it.next()).b(), G.f43879a.a().getId())) {
                List<b<?>> list2 = this.pending;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (kotlin.jvm.internal.p.d(((b) it2.next()).b(), G.f43879a.a().getId())) {
                            Log.w("MotionKitMaterial", "commit: Blend 与其他能力共存，文字走 SDF 玻璃路径（纯混色未启用）");
                            break;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
