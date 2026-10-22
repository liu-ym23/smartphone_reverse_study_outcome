package c72;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ androidx.core.util.Consumer f22638a;

    public b(androidx.core.util.Consumer r100) {
        this.f22638a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        androidx.core.util.Consumer r102 = this.f22638a;
        if (r102 == null) goto L6;
        r102.accept(Boolean.FALSE);
    L6:
        if ((r101 instanceof ApiServerException) == false) goto L16;
        ApiServerException r103 = (ApiServerException) r101;
        String r104 = r103.getPrompt();
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
        f2.c(r103.getPrompt(), 0);
        return;
    L10:
        if (r104.length() == 0) goto L13;
        r105 = false;
    L16:
        f2.b(R.string.ttlive_web_network_error, 0);
    }
}
