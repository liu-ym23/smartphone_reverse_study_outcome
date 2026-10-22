package com.bytedance.android.livesdk.preview;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class s1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1 f156601a = null;

    static {
        f156601a = new s1();
    }

    public s1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        f2.b(R.string.ttlive_dislike_preview_success_douyin, 0);
    }
}
