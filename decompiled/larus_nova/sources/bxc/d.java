package bxc;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes41.dex */
public final class d<T> extends e<T> {
    @Override // bxc.e
    public final boolean e(String r100) {
        return false;
    }

    @Override // bxc.e
    public Context getContext() {
        T r100 = this.f21384a;
        if ((r100 instanceof Activity) == false) goto L7;
        return (Context) r100;
    L7:
        if ((r100 instanceof Fragment) == false) goto L11;
        return ((Fragment) r100).getContext();
    L11:
        throw new IllegalStateException("Unknown host: " + this.f21384a);
    }

    public d(T r100) {
        super(r100);
    }

    @Override // bxc.e
    public final void a(int r100, String... r101) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }

    @Override // bxc.e
    public final void f(String r100, String r101, String r102, int r103, int r104, String... r105) {
        throw new IllegalStateException("Should never be requesting permissions on API < 23!");
    }
}
