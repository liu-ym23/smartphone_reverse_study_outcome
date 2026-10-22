package android.ss.com.vboost.request;

import android.ss.com.vboost.utils.LogUtil;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Callable<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4732b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f4733a;

    public b(d r100) {
        this.f4733a = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        if (android.ss.com.vboost.i.c.e().a(this.f4733a) == true) goto L5;
        LogUtil.debug(f4732b, "no provider support this ability " + this.f4733a.f4738a);
    L9:
        RequestManager.getInstance().completeRequest(this.f4733a, false);
        return null;
    L5:
        if (this.f4733a.f4747j == true) goto L7;
        android.ss.com.vboost.i.c.e().b(this.f4733a);
        goto L9
    L7:
        android.ss.com.vboost.i.c.e().c(this.f4733a);
        goto L9
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() {
        return call();
    }
}
