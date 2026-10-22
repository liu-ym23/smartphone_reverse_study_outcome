package cb;

import com.tonyodev.fetch2.Download;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3374a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f3375b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Download f3376c;

    public /* synthetic */ n(v vVar, Download download, int i10) {
        this.f3374a = i10;
        this.f3375b = vVar;
        this.f3376c = download;
    }

    private final void a() {
        v vVar = this.f3375b;
        synchronized (vVar.f3404c) {
            try {
                ArrayList arrayList = vVar.f3407f;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (((ya.g) obj).a()) {
                        break;
                    }
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = 0;
        switch (this.f3374a) {
            case 0:
                v vVar = this.f3375b;
                synchronized (vVar.f3404c) {
                    try {
                        ArrayList arrayList = vVar.f3407f;
                        int size = arrayList.size();
                        while (i10 < size) {
                            Object obj = arrayList.get(i10);
                            i10++;
                            if (((ya.g) obj).a()) {
                                lb.n nVar = lb.n.f10413a;
                            }
                        }
                        lb.n nVar2 = lb.n.f10413a;
                    } finally {
                    }
                }
                return;
            case 1:
                v vVar2 = this.f3375b;
                synchronized (vVar2.f3404c) {
                    try {
                        ArrayList arrayList2 = vVar2.f3407f;
                        int size2 = arrayList2.size();
                        while (i10 < size2) {
                            Object obj2 = arrayList2.get(i10);
                            i10++;
                            if (((ya.g) obj2).a()) {
                                lb.n nVar3 = lb.n.f10413a;
                            }
                        }
                        lb.n nVar32 = lb.n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 2:
                v vVar3 = this.f3375b;
                synchronized (vVar3.f3404c) {
                    try {
                        ArrayList arrayList3 = vVar3.f3407f;
                        int size3 = arrayList3.size();
                        while (i10 < size3) {
                            Object obj3 = arrayList3.get(i10);
                            i10++;
                            if (((ya.g) obj3).a()) {
                                lb.n nVar4 = lb.n.f10413a;
                            }
                        }
                        lb.n nVar42 = lb.n.f10413a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            case 3:
                a();
                return;
            default:
                v vVar4 = this.f3375b;
                synchronized (vVar4.f3404c) {
                    try {
                        ArrayList arrayList4 = vVar4.f3407f;
                        int size4 = arrayList4.size();
                        while (i10 < size4) {
                            Object obj4 = arrayList4.get(i10);
                            i10++;
                            if (((ya.g) obj4).a()) {
                                lb.n nVar5 = lb.n.f10413a;
                            }
                        }
                        lb.n nVar52 = lb.n.f10413a;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
        }
    }
}
