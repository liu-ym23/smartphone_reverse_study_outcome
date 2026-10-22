package com.bytedance.android.livesdk.live.listprovider;

import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f147569a;

    public j(String r100) {
        this.f147569a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        m.f147572a.put(this.f147569a, (Pair) r100);
        ALogger.i("FeedCacheListProvider", "pre request finished for " + this.f147569a);
    }
}
