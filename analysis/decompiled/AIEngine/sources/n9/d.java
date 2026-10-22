package n9;

import com.stepos.core.common.loadguard.LoadPhaseTimer;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import u6.c;
import vc.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10681a;

    public /* synthetic */ d(int i10) {
        this.f10681a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f10681a) {
            case 0:
                Class it = (Class) obj;
                g.f(it, "it");
                return it.getSimpleName();
            case 1:
                g.f((String) obj, "it");
                return new c.a();
            case 2:
                return LoadPhaseTimer.summary$lambda$1((Pair) obj);
            case 3:
                Map.Entry entry = (Map.Entry) obj;
                g.f(entry, "<destruct>");
                String str = (String) entry.getKey();
                uc.g gVar = (uc.g) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                n.a(sb2, str);
                sb2.append(':');
                sb2.append(gVar);
                String string = sb2.toString();
                g.e(string, "toString(...)");
                return string;
            case 4:
                Class it2 = (Class) obj;
                g.f(it2, "it");
                return jd.b.e(it2.getName());
            case 5:
                ParameterWrapper it3 = (ParameterWrapper) obj;
                g.f(it3, "it");
                return jd.b.e(it3.getName());
            case 6:
                synchronized (y.d.f13933b) {
                    List<? extends l<Object, lb.n>> list = y.d.f13938g;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        list.get(i10).invoke(obj);
                    }
                }
                return lb.n.f10413a;
            default:
                return lb.n.f10413a;
        }
    }
}
