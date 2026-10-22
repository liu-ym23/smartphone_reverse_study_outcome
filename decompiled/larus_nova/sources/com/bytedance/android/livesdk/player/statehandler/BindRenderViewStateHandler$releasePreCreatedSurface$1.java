package com.bytedance.android.livesdk.player.statehandler;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"release", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class BindRenderViewStateHandler$releasePreCreatedSurface$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BindRenderViewStateHandler this$0;

    public BindRenderViewStateHandler$releasePreCreatedSurface$1(BindRenderViewStateHandler r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IRenderView r100 = this.this$0.f156058a;
        if (r100 == null) goto L15;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L7;
        r101 = null;
    L7:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L10;
        r102.removeView(r100.getSelfView());
    L10:
        LivePlayerContext r103 = this.this$0.f156064g;
        StringBuilder r104 = new StringBuilder("releasePreCreatedSurface() release renderView : ");
        IRenderView r105 = this.this$0.f156058a;
        if (r105 == null) goto L13;
        Integer r106 = Integer.valueOf(r105.hashCode());
    L14:
        r104.append(r106);
        r103.e(r104.toString(), true);
        goto L15
    L13:
        r106 = null;
    L15:
        BindRenderViewStateHandler r107 = this.this$0;
        r107.f156058a = null;
        r107.f156059b = false;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
