package cb;

import com.tonyodev.fetch2.Download;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f3369b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Download f3370c;

    public /* synthetic */ l(v vVar, Download download, int i10) {
        this.f3368a = i10;
        this.f3369b = vVar;
        this.f3370c = download;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f3368a;
        int i11 = 0;
        v vVar = this.f3369b;
        switch (i10) {
            case 0:
                synchronized (vVar.f3404c) {
                    try {
                        ArrayList arrayList = vVar.f3407f;
                        int size = arrayList.size();
                        while (i11 < size) {
                            Object obj = arrayList.get(i11);
                            i11++;
                            if (((ya.g) obj).a()) {
                                lb.n nVar = lb.n.f10413a;
                            }
                        }
                        lb.n nVar2 = lb.n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                synchronized (vVar.f3404c) {
                    try {
                        ArrayList arrayList2 = vVar.f3407f;
                        int size2 = arrayList2.size();
                        while (i11 < size2) {
                            Object obj2 = arrayList2.get(i11);
                            i11++;
                            if (((ya.g) obj2).a()) {
                                lb.n nVar3 = lb.n.f10413a;
                            }
                        }
                        lb.n nVar32 = lb.n.f10413a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            default:
                synchronized (vVar.f3404c) {
                    try {
                        ArrayList arrayList3 = vVar.f3407f;
                        int size3 = arrayList3.size();
                        while (i11 < size3) {
                            Object obj3 = arrayList3.get(i11);
                            i11++;
                            if (((ya.g) obj3).a()) {
                                lb.n nVar4 = lb.n.f10413a;
                            }
                        }
                        lb.n nVar42 = lb.n.f10413a;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
        }
    }
}
