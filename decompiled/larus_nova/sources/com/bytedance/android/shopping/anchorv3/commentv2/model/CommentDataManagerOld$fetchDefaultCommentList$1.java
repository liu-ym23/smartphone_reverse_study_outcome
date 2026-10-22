package com.bytedance.android.shopping.anchorv3.commentv2.model;

import com.bytedance.android.ec.model.response.t0;
import com.bytedance.android.shopping.anchorv3.commentv2.monitor.CommentPerformanceMonitor;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "success", "Lcom/bytedance/android/ec/model/response/t0;", "response", "", AbsMethodDelegate.TAG_INVOKE, "(ZLcom/bytedance/android/ec/model/response/t0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CommentDataManagerOld$fetchDefaultCommentList$1 extends Lambda implements Function2<Boolean, t0, Unit> {
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ CommentRefreshFrom $refreshFrom;
    final /* synthetic */ b this$0;

    public CommentDataManagerOld$fetchDefaultCommentList$1(b r100, CommentRefreshFrom r101, boolean r102) {
        this.$refreshFrom = r101;
        this.$isRefresh = r102;
        super(2);
    }

    public final void invoke(boolean r100, t0 r101) {
        CommentPerformanceMonitor.a r102 = CommentPerformanceMonitor.f164734i;
        String r103 = this.$refreshFrom.getPerfMobKey();
        r102.getClass();
        CommentPerformanceMonitor r104 = CommentPerformanceMonitor.a.a(r103);
        r104.f164739e = System.currentTimeMillis();
        if (r100 == false) goto L7;
        if (r101 == null) goto L7;
        int r105 = b.f164732a;
        throw null;
    L7:
        int r106 = b.f164732a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, t0 r101) {
        invoke(r100.booleanValue(), r101);
        return Unit.INSTANCE;
    }
}
