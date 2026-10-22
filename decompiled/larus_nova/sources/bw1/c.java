package bw1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f20999a;

    public c(cw1.b r100) {
        this.f20999a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Long r101 = (Long) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.longValue() < 0) goto L9;
        this.f20999a.a();
        this.f20999a.b(r101.longValue());
        return;
    }
}
