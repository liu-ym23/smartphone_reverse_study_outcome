package b85;

import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;

/* JADX INFO: loaded from: classes16.dex */
public final class s0 implements u75.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u75.b.a f18158a;

    public s0(u75.b.a r100) {
        this.f18158a = r100;
    }

    @Override // u75.b.a
    public final void b(com.bytedance.ee.bear.drive.view.preview.wrapper.z r100) {
        this.f18158a.b(r100);
    }

    @Override // u75.b.a
    public final void c(ErrCode r100) {
        this.f18158a.c(r100);
    }

    @Override // u75.b.a
    public final void onProgress(int r100) {
        if (r100 < 10) goto L6;
        this.f18158a.onProgress(r100);
        return;
    }

    @Override // u75.b.a
    public final <I> void a(InfoCode r100, I r101) {
        this.f18158a.a(r100, r101);
    }
}
