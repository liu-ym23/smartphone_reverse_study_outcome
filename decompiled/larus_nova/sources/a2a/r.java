package a2a;

import android.os.Message;
import com.ss.android.update.OnUpdateStatusChangedListener;

/* JADX INFO: loaded from: classes31.dex */
public final class r implements OnUpdateStatusChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f1486a;

    @Override // yhc.i
    public final void b(boolean r100) {
    }

    @Override // com.ss.android.update.OnUpdateStatusChangedListener
    public final void c(int r100) {
    }

    @Override // yhc.i
    public final void e(int r100, boolean r101) {
    }

    public r(q r100) {
        this.f1486a = r100;
    }

    @Override // yhc.i
    public final void a(boolean r100, boolean r101) {
        if (r101 == false) goto L4;
        return;
    L4:
        yhc.a r102 = new yhc.a();
        if (r100 == false) goto L7;
        int r103 = 3;
    L8:
        r102.f567683c = r103;
        Message r104 = Message.obtain();
        r104.what = 2;
        r104.obj = r102;
        this.f1486a.f1475c.sendMessage(r104);
        return;
    L7:
        r103 = 2;
        goto L8
    }

    @Override // yhc.i
    public final void d(int r100, int r101, boolean r102) {
        if (r102 == false) goto L4;
        return;
    L4:
        this.f1486a.getClass();
        if (r100 < 0) goto L12;
        if (r101 <= 0) goto L12;
        int r103 = 100;
        int r104 = (int) ((r100 / r101) * 100);
        if (r104 > 100) goto L14;
        r103 = r104;
    L14:
        if ((r103 + 0) > 1) goto L16;
        return;
    L16:
        yhc.a r105 = new yhc.a();
        r105.f567683c = 1;
        r105.f567681a = r100;
        r105.f567682b = r101;
        Message r106 = Message.obtain();
        r106.what = 1;
        r106.obj = r105;
        this.f1486a.f1475c.sendMessage(r106);
        return;
    L12:
        r103 = 0;
        goto L14
    }
}
