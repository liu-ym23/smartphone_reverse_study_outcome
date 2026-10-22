package b;

import android.app.Notification;
import b.k;
import com.stepos.core.common.notification.NotificationSender;
import com.stepos.deepbinder.core.provider.ClientServiceProvider;
import d.d;
import e.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3011a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3012b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3013c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3014d;

    public /* synthetic */ l(int i10, int i11, Object obj, Object obj2) {
        this.f3011a = i11;
        this.f3013c = obj;
        this.f3012b = i10;
        this.f3014d = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3011a) {
            case 0:
                k.f fVar = (k.f) this.f3013c;
                T t8 = ((a.C0074a) this.f3014d).f8513a;
                String str = (String) fVar.f8238a.get(Integer.valueOf(this.f3012b));
                if (str != null) {
                    d.a aVar = (d.a) fVar.f8242e.get(str);
                    if ((aVar != null ? aVar.f8245a : null) != null) {
                        d.a<O> aVar2 = aVar.f8245a;
                        kotlin.jvm.internal.g.d(aVar2, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
                        if (fVar.f8241d.remove(str)) {
                            aVar2.a(t8);
                            break;
                        }
                    } else {
                        fVar.f8244g.remove(str);
                        fVar.f8243f.put(str, t8);
                        break;
                    }
                }
                break;
            case 1:
                NotificationSender.sendDelayed$lambda$0((NotificationSender) this.f3013c, this.f3012b, (Notification) this.f3014d);
                break;
            case 2:
                ((androidx.profileinstaller.b) this.f3013c).f2448b.b(this.f3012b, this.f3014d);
                break;
            default:
                ((ClientServiceProvider) this.f3013c).recycle(this.f3012b, (long[]) this.f3014d);
                break;
        }
    }
}
