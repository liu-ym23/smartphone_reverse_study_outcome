package com.bytedance.android.shopping.commentv3.base;

import android.content.Context;
import com.bytedance.android.shopping.commentv3.base.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public class BaseCommentLogic<State extends b> extends a<State> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f172659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.commentv3.data.b f172660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f172661e;

    public final Context getContext() {
        return (Context) this.f172661e.getValue();
    }

    public BaseCommentLogic() {
        this.f172661e = LazyKt.lazy(new BaseCommentLogic$context$2(this));
    }
}
