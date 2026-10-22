package com.bytedance.android.livesdk.push;

import android.util.LruCache;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePushImpl implements ILivePush {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Object> f156864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f156865b;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
    }

    static {
    }

    public LivePushImpl() {
        new LruCache(2);
        LinkedHashSet r100 = new LinkedHashSet();
        this.f156864a = r100;
        a r101 = new a();
        Intrinsics.checkNotNullParameter(r101, "pushIntercept");
        r100.add(r101);
        this.f156865b = LazyKt.lazy(LivePushImpl$pushView$2.INSTANCE);
    }
}
