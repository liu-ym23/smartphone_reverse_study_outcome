package b6;

import a6.z;
import b5.a0;
import kotlin.jvm.internal.p;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f926a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f927b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f928c;

    public /* synthetic */ e(Object obj, int i8, Object obj2) {
        this.f926a = i8;
        this.f927b = obj;
        this.f928c = obj2;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f926a) {
            case 0:
                f fVar = (f) this.f927b;
                fVar.f929c.removeCallbacks((d) this.f928c);
                break;
            case 1:
                l lVar = (l) this.f927b;
                l lVar2 = (l) this.f928c;
                p.e(obj, "<this>");
                if (lVar != null) {
                    lVar.invoke(obj);
                }
                lVar2.invoke(obj);
                break;
            default:
                l lVar3 = (l) this.f927b;
                z zVar = (z) this.f928c;
                x3.g gVar = (x3.g) obj;
                p.e(gVar, "<this>");
                lVar3.invoke(gVar);
                zVar.invoke(gVar);
                break;
        }
        return a0.f883a;
    }
}
