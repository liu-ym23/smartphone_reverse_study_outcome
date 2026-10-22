package com.bytedance.android.shopping.commentv3.base;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class CommentApiCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f172671a;

    public final List<d> a() {
        return (List) this.f172671a.getValue();
    }

    public CommentApiCenter() {
        this.f172671a = LazyKt.lazy(CommentApiCenter$apiList$2.INSTANCE);
    }
}
