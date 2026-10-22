package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d1<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f123672a = null;

    static {
        f123672a = new d1();
    }

    public d1() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        BaseListResponse r102 = (BaseListResponse) r100;
        FeedItem r103 = (FeedItem) r101;
        Intrinsics.checkNotNullParameter(r102, "recRes");
        Intrinsics.checkNotNullParameter(r103, "historyRes");
        List<T> r104 = r102.data;
        if (r104 == 0) goto L5;
        int r105 = r104.size();
    L6:
        if (r105 <= 0) goto L26;
        List<T> r106 = r102.data;
        if (r106 == 0) goto L13;
        FeedItem r107 = (FeedItem) ListProtector.get(r106, 0);
        if (r107 == null) goto L13;
        if (r107.type != 1001) goto L13;
    L25:
        ListProtector.add(r102.data, 1, r103);
    L27:
        return r102;
    L13:
        List<T> r108 = r102.data;
        if (r108 == 0) goto L19;
        FeedItem r109 = (FeedItem) ListProtector.get(r108, 0);
        if (r109 == null) goto L19;
        if (r109.type == (-1)) goto L25;
    L19:
        List<T> r110 = r102.data;
        if (r110 == 0) goto L26;
        FeedItem r111 = (FeedItem) ListProtector.get(r110, 0);
        if (r111 == null) goto L26;
        if (r111.type == 6) goto L25;
    L26:
        ListProtector.add(r102.data, 0, r103);
        goto L27
    L5:
        r105 = 0;
        goto L6
    }
}
