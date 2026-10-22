package com.bytedance.android.live.ktv.common.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isTimeOut", "", VideoSurfaceTexture.KEY_TIME, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class ViewStatisticsWrapper$startWatchNextDraw$1 extends Lambda implements Function2<Boolean, Long, Unit> {
    final /* synthetic */ v this$0;

    public ViewStatisticsWrapper$startWatchNextDraw$1(v r100) {
        this.this$0 = r100;
        super(2);
    }

    public final void invoke(boolean r100, long r101) {
        v r102 = this.this$0;
        k r103 = r102.f70704c;
        String r104 = r102.f70702a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "name");
        l r105 = r103.f70691a;
        if (r105 == null) goto L5;
        r105.ue(r104, r100, r101);
    L5:
        this.this$0.f70703b.setOneDrawCallback(null);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Long r101) {
        invoke(r100.booleanValue(), r101.longValue());
        return Unit.INSTANCE;
    }
}
