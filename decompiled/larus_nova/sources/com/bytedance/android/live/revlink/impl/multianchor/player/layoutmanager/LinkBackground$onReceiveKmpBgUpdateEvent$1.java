package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class LinkBackground$onReceiveKmpBgUpdateEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $bottom;
    final /* synthetic */ String $bottomBgUrl;
    final /* synthetic */ boolean $isAnimBg;
    final /* synthetic */ int $top;
    final /* synthetic */ String $topBgUrl;
    final /* synthetic */ b this$0;

    public LinkBackground$onReceiveKmpBgUpdateEvent$1(b r100, int r101, int r102, String r103, String r104, boolean r105) {
        this.$top = r101;
        this.$bottom = r102;
        this.$topBgUrl = r103;
        this.$bottomBgUrl = r104;
        this.$isAnimBg = r105;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        jy0.b.d("LinkBackground", "notify onBgShowVertical");
        int r100 = b.f94591a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
