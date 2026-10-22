package v7;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import w7.C5740a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015¨\u0006\u0018"}, d2 = {"Lv7/r;", "Ls7/i;", "<init>", "()V", "Ls7/o;", "host", "Landroid/view/View;", "targetView", "Ls7/c;", "compiled", "Ls7/j;", "config", "Ls7/e;", "definition", "Ls7/k;", Const.INTENT_KEY_APIKEY, "(Ls7/o;Landroid/view/View;Ls7/c;Ls7/j;Ls7/e;)Ls7/k;", "LY8/t;", "release", "", "Lv7/t;", "Ljava/util/List;", "instances", Const.INTENT_KEY_PKGNAME, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r implements s7.i {

    /* renamed from: c, reason: collision with root package name */
    public static volatile InterfaceC5074l<? super EffectDefinition, ? extends s> f42774c = new InterfaceC5074l() { // from class: v7.o
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return r.e((EffectDefinition) obj);
        }
    };

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<t> instances = new ArrayList();

    public static final C5740a e(EffectDefinition effectDefinition) {
        kotlin.jvm.internal.p.i(effectDefinition, "<unused var>");
        return new C5740a();
    }

    public static final Y8.t f(t tVar, long j10, float f10) {
        tVar.b(j10);
        return Y8.t.f7040a;
    }

    public static final Y8.t g(s sVar, r rVar, t tVar) {
        sVar.c();
        rVar.instances.remove(tVar);
        return Y8.t.f7040a;
    }

    @Override // s7.i
    public s7.k a(s7.o host, View targetView, s7.c compiled, s7.j config, EffectDefinition definition) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(targetView, "targetView");
        kotlin.jvm.internal.p.i(compiled, "compiled");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(definition, "definition");
        B7.a aVar = new B7.a(definition);
        final s sVarInvoke = f42774c.invoke(definition);
        sVarInvoke.d(targetView);
        sVarInvoke.b(compiled.getSource());
        sVarInvoke.e(definition.getRequiresBackground());
        sVarInvoke.start();
        sVarInvoke.a(aVar.j());
        final t tVar = new t(sVarInvoke, aVar);
        this.instances.add(tVar);
        return new t7.d(System.nanoTime(), new p9.p() { // from class: v7.p
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return r.f(tVar, ((Long) obj).longValue(), ((Float) obj2).floatValue());
            }
        }, new InterfaceC5063a() { // from class: v7.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.g(sVarInvoke, this, tVar);
            }
        }, aVar);
    }

    @Override // s7.i
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((t) it.next()).getChannel().c();
        }
        this.instances.clear();
    }
}
