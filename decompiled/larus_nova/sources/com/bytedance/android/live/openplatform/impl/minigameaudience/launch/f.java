package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f85306a = null;

    static {
        f85306a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        f2.c(s1.B(R.string.ttlive_open_platform_mg_live_direct_play_explain), 0);
    }
}
