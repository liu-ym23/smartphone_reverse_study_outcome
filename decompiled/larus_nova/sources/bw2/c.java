package bw2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f21017a;

    public c(d r100) {
        this.f21017a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == true) goto L7;
        v61.a r101 = this.f21017a.f21020c;
        if (r101 == null) goto L16;
        r101.show();
        return;
    L16:
        return;
    L7:
        v61.a r102 = this.f21017a.f21020c;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.o() == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L19;
        r102.dismiss();
        return;
    }
}
