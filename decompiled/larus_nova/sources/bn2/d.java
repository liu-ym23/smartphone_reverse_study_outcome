package bn2;

import android.content.Context;
import com.bytedance.android.livesdk.notification.notificationsetting.api.NotificationSettingStatusApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements bn2.a.InterfaceC0318a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MultiTypeAdapter f19717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f19718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bn2.a f19719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f19720d;

    public interface a {
        void eD(boolean r100);

        void uf(boolean r100, boolean r101);
    }

    public final void c() {
        bn2.a r100 = this.f19719c;
        if (r100 == null) goto L6;
        ((NotificationSettingStatusApi) com.bytedance.android.live.network.c.b().e(NotificationSettingStatusApi.class)).getFollowPushStatus(r100.f19710f, r100.f19708d).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r100), new c(r100));
        return;
    }

    public d(bn2.a r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "mView");
        this.f19719c = r100;
        this.f19720d = r101;
        r100.f19707c = this;
    }

    @Override // bn2.a.InterfaceC0318a
    public final void b(List<? extends fz.a> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorList");
        this.f19720d.eD(r101);
        ArrayList r102 = (ArrayList) r100;
        if (r102.isEmpty() == false) goto L5;
        j.f19729d.update(false);
    L5:
        MultiTypeAdapter r103 = this.f19717a;
        if (r103 == null) goto L8;
        r103.f513437a = r102;
    L8:
        if (r103 == null) goto L11;
        r103.notifyDataSetChanged();
        return;
    }

    @Override // bn2.a.InterfaceC0318a
    public final void a(List<? extends fz.a> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "anchorList");
        this.f19720d.uf(r101, r102);
    }
}
