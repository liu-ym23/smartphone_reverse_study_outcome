package cm1;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f24161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f24162b;

    public c(a r100, Context r101) {
        this.f24161a = r100;
        this.f24162b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f24161a;
        Context r103 = this.f24162b;
        r102.getClass();
        if (r103 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof ApiServerException) == true) goto L8;
        r101 = null;
    L8:
        ApiServerException r104 = (ApiServerException) r101;
        if (r104 == null) goto L13;
        String r105 = r104.getPrompt();
        if (r105 == null) goto L13;
        rm3.c.g(r103, r105, 0, true, 16);
        return;
    L13:
        rm3.c.f(r103, R.string.ttlive_report_fail, true, 16);
    }
}
