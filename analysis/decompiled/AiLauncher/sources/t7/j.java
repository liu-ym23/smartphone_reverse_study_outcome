package t7;

import Y8.t;
import Z8.C1172u;
import Z8.F;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import s7.EffectDefinition;
import s7.k;
import s7.l;
import s7.o;
import s7.r;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0012\u001a\u00020\u0006*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Ls7/o$a;", "Landroid/view/View;", "view", "Ls7/o;", "c", "(Ls7/o$a;Landroid/view/View;)Ls7/o;", "Ls7/l;", "Ls7/e;", "effect", "Lkotlin/Function1;", "Ls7/j;", "LY8/t;", "config", "Ls7/k;", "f", "(Ls7/l;Ls7/e;Lp9/l;)Ls7/k;", "e", "(Ls7/o;)Ls7/l;", "fx", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {
    public static final o c(o.Companion companion, View view) {
        p.i(companion, "<this>");
        p.i(view, "view");
        final o oVarB = companion.b(view);
        oVarB.j(new g(oVarB));
        view.post(new Runnable() { // from class: t7.h
            @Override // java.lang.Runnable
            public final void run() {
                j.d(oVarB);
            }
        });
        return oVarB;
    }

    public static final void d(o oVar) {
        oVar.l();
    }

    public static final l e(o oVar) {
        p.i(oVar, "<this>");
        List<r> listE = oVar.e();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listE) {
            if (obj instanceof l) {
                arrayList.add(obj);
            }
        }
        l lVar = (l) F.s0(arrayList);
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("FxModule 未注册，请通过 motionkit-fx 的 MotionHost.create() 创建宿主");
    }

    public static final k f(l lVar, EffectDefinition effect, InterfaceC5074l<? super s7.j, t> config) {
        p.i(lVar, "<this>");
        p.i(effect, "effect");
        p.i(config, "config");
        return lVar.b(C1172u.e(effect), config);
    }

    public static /* synthetic */ k g(l lVar, EffectDefinition effectDefinition, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: t7.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return j.h((s7.j) obj2);
                }
            };
        }
        return f(lVar, effectDefinition, interfaceC5074l);
    }

    public static final t h(s7.j jVar) {
        p.i(jVar, "<this>");
        return t.f7040a;
    }
}
