package atb;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import atb.a;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.transfer.NotificationTransferActivity;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b<T, R extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f16294a;

    public abstract String b();

    public abstract String c();

    public abstract void e();

    public abstract void f();

    public abstract int g();

    public abstract String h();

    public abstract int i();

    public abstract PendingIntent j(Intent r100);

    public abstract void k();

    public abstract Uri l();

    public c m() {
        return null;
    }

    public abstract String n();

    public abstract String o();

    public abstract void p();

    public abstract boolean q();

    public void d() {
        e();
    }

    public b(T r100) {
        this.f16294a = r100;
        p();
    }

    public final void a(a r100) {
        g();
        e();
        int r101 = NotificationTransferActivity.f433084a;
        Intent r102 = new Intent();
        r102.putExtra("extra_is_from_notification", true);
        Application r103 = LarkContext.getApplication();
        Log.i("NotificationTransferActivity", "getTransferActivityWrapperIntentOnDemand: process -> " + z.b(r103));
        Intent r104 = new Intent(r103, NotificationTransferActivity.class);
        r104.putExtra("extra_original_intent", r102);
        r104.setFlags(r102.getFlags());
        j(r104);
        r100.f16292a = o();
        r100.f16293b = c();
        k();
        q();
        n();
        f();
        h();
        i();
        b();
        if (m() != null) goto L6;
        l();
    L6:
        if ((r100 instanceof d) == false) goto L9;
        d r105 = (d) r100;
        d();
        return;
    }
}
