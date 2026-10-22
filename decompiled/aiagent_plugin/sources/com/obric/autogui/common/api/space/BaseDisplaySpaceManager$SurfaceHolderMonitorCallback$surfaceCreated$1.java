package com.obric.autogui.common.api.space;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import java.lang.ref.WeakReference;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "BaseDisplaySpaceManager.kt", c = {320}, d = "invokeSuspend", e = "com.obric.autogui.common.api.space.BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1")
final class BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1 extends l implements m<am, d<? super x>, Object> {
    final /* synthetic */ SurfaceHolder $holder;
    int label;
    final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

    BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1(SurfaceHolder r3, BaseDisplaySpaceManager<S> r4, d<? super BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1> r5) {
        SurfaceHolder r6 = (SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        this.$holder = r6;
        this.this$0 = r4;
        super(2, r7);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r3, d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1(this.$holder, this.this$0, r5), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r11) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r11);
    L29:
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r11);
        Surface r12 = this.$holder.getSurface();
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Created Surface holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r12) + ", activeSpace=" + this.this$0.getActiveSpace());
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(BaseDisplaySpaceManager.access$getMCurrentSurfaceHolder$p(this.this$0).get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        SurfaceHolder r3 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r2.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
    L13:
        if (r3 != this.$holder) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        Loog.INSTANCE.w(this.this$0.getLogTag(), "[SurfaceHolder] --> Created Surface holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r12) + ", activeSpace=" + this.this$0.getActiveSpace() + ", NotCurrentHolder.");
        return x.f38692a;
    L19:
        if (r12 != null) goto L21;
    L30:
        Loog.INSTANCE.w(this.this$0.getLogTag(), "[SurfaceHolder] --> Created Surface holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r12) + ", activeSpace=" + this.this$0.getActiveSpace() + ", NullOrInvalidSurface.");
        return x.f38692a;
    L21:
        if (r12.isValid() == false) goto L30;
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Created Surface configureSurface(surface) holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r12));
        DisplayOperatingSpace r5 = this.this$0.getActiveSpace();
        if (r5 == null) goto L29;
        d<? super x> r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        if (r5.configureSurface(r12, r6) != r0) goto L29;
        return r0;
    L15:
        r4 = false;
        goto L16
    L11:
        r3 = null;
        goto L13
    }
}
