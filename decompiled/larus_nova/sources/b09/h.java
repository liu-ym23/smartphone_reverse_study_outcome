package b09;

import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends sa7.h<xa7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16904a;

    public h(int r100) {
        this.f16904a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        Handler r102 = e.f16894a;
        final int r103 = this.f16904a;
        r102.post(new f(r103));
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, final int r101) {
        xa7.c r102 = (xa7.c) r100;
        Handler r103 = e.f16894a;
        final int r104 = this.f16904a;
        r103.post(new g(r104, r101));
    }
}
