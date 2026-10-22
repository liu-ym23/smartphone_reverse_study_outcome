package com.bytedance.android.livesdk.player.statehandler;

import android.graphics.SurfaceTexture;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"useSurface", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BindRenderViewStateHandler$tryUsePreCreatedSurface$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BindRenderViewStateHandler this$0;

    public BindRenderViewStateHandler$tryUsePreCreatedSurface$1(BindRenderViewStateHandler r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BindRenderViewStateHandler r100 = this.this$0;
        r100.f156060c = false;
        IRenderView r101 = r100.f156064g.b();
        IRenderView r102 = null;
        if (r101 == null) goto L5;
        SurfaceTexture r103 = r101.getSurfaceTexture();
    L6:
        if (r103 == null) goto L9;
        this.this$0.e();
        return;
    L9:
        IRenderView r104 = this.this$0.f156058a;
        if (r104 == null) goto L24;
        SurfaceTexture r105 = r104.getSurfaceTexture();
        if (r105 == null) goto L25;
        this.this$0.b(r105);
        IRenderView r106 = this.this$0.f156064g.b();
        if ((r106 instanceof TextureRenderView) == false) goto L17;
        r102 = r106;
    L17:
        TextureRenderView r107 = (TextureRenderView) r102;
        if (r107 != null) goto L20;
        return;
    L20:
        if ((!Intrinsics.areEqual(r107.getSurfaceTexture(), r105)) == false) goto L22;
        this.this$0.f156064g.e("tryUsePreCreatedSurface() renderView : " + r105.hashCode(), true);
        r107.setSurfaceTexture(r105);
    L22:
        this.this$0.e();
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
