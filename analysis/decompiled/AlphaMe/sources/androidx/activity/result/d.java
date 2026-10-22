package androidx.activity.result;

import d.AbstractC0528b;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2420a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f2421b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0528b f2422c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2423d;

    public d(Object obj, Serializable serializable, AbstractC0528b abstractC0528b, int i4) {
        this.f2420a = i4;
        this.f2423d = obj;
        this.f2421b = serializable;
        this.f2422c = abstractC0528b;
    }

    @Override // androidx.activity.result.b
    public final void a(Object obj) {
        int i4 = this.f2420a;
        AbstractC0528b abstractC0528b = this.f2422c;
        Object obj2 = this.f2423d;
        Serializable serializable = this.f2421b;
        switch (i4) {
            case 0:
                g gVar = (g) obj2;
                String str = (String) serializable;
                Integer num = (Integer) gVar.f2429b.get(str);
                if (num != null) {
                    gVar.f2431d.add(str);
                    try {
                        ((g) obj2).b(num.intValue(), abstractC0528b, obj);
                        return;
                    } catch (Exception e4) {
                        gVar.f2431d.remove(str);
                        throw e4;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0528b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            case 1:
                g gVar2 = (g) obj2;
                String str2 = (String) serializable;
                Integer num2 = (Integer) gVar2.f2429b.get(str2);
                if (num2 != null) {
                    gVar2.f2431d.add(str2);
                    try {
                        ((g) obj2).b(num2.intValue(), abstractC0528b, obj);
                        return;
                    } catch (Exception e5) {
                        gVar2.f2431d.remove(str2);
                        throw e5;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0528b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                b bVar = (b) ((AtomicReference) serializable).get();
                if (bVar == null) {
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }
                bVar.a(obj);
                return;
        }
    }

    @Override // androidx.activity.result.b
    public final void b() {
        int i4 = this.f2420a;
        Object obj = this.f2423d;
        Serializable serializable = this.f2421b;
        switch (i4) {
            case 0:
                ((g) obj).f((String) serializable);
                break;
            case 1:
                ((g) obj).f((String) serializable);
                break;
            default:
                b bVar = (b) ((AtomicReference) serializable).getAndSet(null);
                if (bVar != null) {
                    bVar.b();
                    break;
                }
                break;
        }
    }
}
