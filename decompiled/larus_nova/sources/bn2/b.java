package bn2;

import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f19715a;

    public b(a r100) {
        this.f19715a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Response r111 = (Response) r110;
        this.f19715a.f19709e = ((cn2.b) r111.data).a();
        a r100 = this.f19715a;
        cn2.b r101 = (cn2.b) r111.data;
        r100.getClass();
        r100.f19708d++;
        if (r101 == null) goto L22;
        List<cn2.a> r102 = r101.c();
        if (r102 == null) goto L22;
        Iterator<cn2.a> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L22;
        cn2.a r104 = r103.next();
        if (r100.f19706b.get(r104.d()) != null) goto L8;
        FollowInfo r105 = r104.b();
        if (r105 == null) goto L17;
        if (r105.getPushStatus() != 1) goto L17;
        r100.a(r104, false);
    L17:
        FollowInfo r106 = r104.b();
        if (r106 == null) goto L8;
        if (r106.getPushStatus() != 3) goto L8;
        r100.b(r104, false);
    L22:
        a r107 = this.f19715a;
        ArrayList<fz.a> r108 = r107.f19705a;
        a.InterfaceC0318a r109 = r107.f19707c;
        if (r109 == null) goto L39;
        r109.b(r108, ((cn2.b) r111.data).a());
        return;
    }
}
