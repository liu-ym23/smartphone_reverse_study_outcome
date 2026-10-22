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
@f(b = "BaseDisplaySpaceManager.kt", c = {381}, d = "invokeSuspend", e = "com.obric.autogui.common.api.space.BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1")
final class BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1 extends l implements m<am, d<? super x>, Object> {
    final /* synthetic */ SurfaceHolder $holder;
    Object L$0;
    int label;
    final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

    BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1(BaseDisplaySpaceManager<S> r3, SurfaceHolder r4, d<? super BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1> r5) {
        SurfaceHolder r6 = (SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceHolder.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.$holder = r6;
        super(2, r7);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r3, d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1(this.this$0, this.$holder, r5), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r15) {
        Object r0 = b.a();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Surface r2 = (Surface) ZeusTransformUtils.preCheckCast(this.L$0, Surface.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L35:
        Surface r3 = r2;
    L36:
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Destroyed Surface configureSurface(null) after holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r3));
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Destroyed Surface holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r3) + ", as=" + this.this$0.getActiveSpace());
        if (r3 == null) goto L39;
        BaseDisplaySpaceManager<S> r16 = this.this$0;
        Loog.INSTANCE.i(r16.getLogTag(), "[SurfaceHolder] --> Destroyed Surface release before surface=" + BaseDisplaySpaceManager.access$describeSurface(r16, r3));
        r3.release();
        Loog.INSTANCE.i(r16.getLogTag(), "[SurfaceHolder] --> Destroyed Surface release after surface=" + BaseDisplaySpaceManager.access$describeSurface(r16, r3));
    L39:
        BaseDisplaySpaceManager.access$getMCurrentSurfaceHolder$p(this.this$0).set(null);
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Destroyed Surface clearCurrentHolder holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0));
        return x.f38692a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r15);
        WeakReference r17 = (WeakReference) ZeusTransformUtils.preCheckCast(BaseDisplaySpaceManager.access$getMCurrentSurfaceHolder$p(this.this$0).get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L11;
        SurfaceHolder r18 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r17.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
    L12:
        r3 = this.$holder.getSurface();
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Destroyed Surface enter holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, r18) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r3) + ", activeSpace=" + this.this$0.getActiveSpace());
        if (r18 != this.$holder) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L26;
        Loog.INSTANCE.w(this.this$0.getLogTag(), "[SurfaceHolder] --> Destroyed Surface holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, r18) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r3) + ", activeSpace=" + this.this$0.getActiveSpace() + ", NotCurrentHolder.");
        Loog r5 = Loog.INSTANCE;
        String r6 = this.this$0.getLogTag();
        StringBuilder r19 = new StringBuilder().append("[SurfaceHolder] --> Destroyed NotCurrentHolder Surface, holder=").append(BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder)).append(", currentHolder=").append(BaseDisplaySpaceManager.access$describeHolder(this.this$0, r18)).append(", surface=").append(BaseDisplaySpaceManager.access$describeSurface(this.this$0, r3)).append(", willConfigureNull=false, willRelease=");
        if (r3 != null) goto L21;
        r4 = false;
    L21:
        r5.w(r6, r19.append(r4).append(", as=").append(this.this$0.getActiveSpace()).toString());
        if (r3 == null) goto L25;
        BaseDisplaySpaceManager<S> r14 = this.this$0;
        Loog.INSTANCE.w(r14.getLogTag(), "[SurfaceHolder] --> Destroyed NotCurrentHolder release() before surface=" + BaseDisplaySpaceManager.access$describeSurface(r14, r3));
        r3.release();
        Loog.INSTANCE.w(r14.getLogTag(), "[SurfaceHolder] --> Destroyed NotCurrentHolder release() after surface=" + BaseDisplaySpaceManager.access$describeSurface(r14, r3));
    L25:
        return x.f38692a;
    L26:
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Destroyed Surface configureHandUsing(false) holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder));
        DisplayOperatingSpace r110 = this.this$0.getActiveSpace();
        if (r110 == null) goto L29;
        ((AOOperatingSpace) ZeusTransformUtils.preCheckCast(r110, AOOperatingSpace.class, "com.obric.aiagent.plugin")).configureHandUsing(false, null, null);
    L29:
        Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Destroyed Surface configureSurface(null) before holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, r3));
        DisplayOperatingSpace r111 = this.this$0.getActiveSpace();
        if (r111 == null) goto L36;
        d<? super x> r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.L$0 = r3;
        this.label = 1;
        if (r111.configureSurface(null, r7) != r0) goto L34;
        return r0;
    L34:
        r2 = r3;
        goto L35
    L15:
        r9 = false;
        goto L16
    L11:
        r18 = null;
        goto L12
    }
}
