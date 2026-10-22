package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import android.graphics.RectF;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class LinkBackground$onReceiveBgUpdateEvent$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RectF $contentInScreen;
    final /* synthetic */ b this$0;

    public LinkBackground$onReceiveBgUpdateEvent$3(b r100, RectF r101) {
        this.$contentInScreen = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b03.a r100 = b03.a.f16857a;
        if (b03.a.b() == false) goto L6;
        int r101 = b.f94591a;
        throw null;
    L6:
        jy0.b.d("LinkBackground", "notify onBgShowVertical");
        float r102 = this.$contentInScreen.top;
        int r103 = b.f94591a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
