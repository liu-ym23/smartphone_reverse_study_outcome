package com.bytedance.android.livesdk.interactivity.comment.share;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f136237a = null;

    static {
        f136237a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof ApiServerException) == false) goto L13;
        ApiServerException r102 = (ApiServerException) r101;
        String r103 = r102.getPrompt();
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
        f2.c(r102.getPrompt(), 0);
        return;
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
    L13:
        f2.b(R.string.ttlive_web_network_error, 0);
    }
}
