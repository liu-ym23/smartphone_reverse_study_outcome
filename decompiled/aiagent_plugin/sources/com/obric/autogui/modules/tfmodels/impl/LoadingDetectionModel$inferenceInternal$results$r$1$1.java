package com.obric.autogui.modules.tfmodels.impl;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.b;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.n;
import org.tensorflow.lite.task.vision.classifier.Classifications;

/* JADX INFO: compiled from: LoadingDetectionModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "LoadingDetectionModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.modules.tfmodels.impl.LoadingDetectionModel$inferenceInternal$results$r$1$1")
final class LoadingDetectionModel$inferenceInternal$results$r$1$1 extends l implements b<d<? super x>, Object> {
    final /* synthetic */ n<List<? extends Classifications>> $cont;
    final /* synthetic */ Bitmap $input;
    int label;
    final /* synthetic */ LoadingDetectionModel this$0;

    LoadingDetectionModel$inferenceInternal$results$r$1$1(LoadingDetectionModel r3, Bitmap r4, n<? super List<? extends Classifications>> r5, d<? super LoadingDetectionModel$inferenceInternal$results$r$1$1> r6) {
        n<List<? extends Classifications>> r7 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.$input = r4;
        this.$cont = r7;
        super(1, r8);
    }

    @Override // d.c.b.a.a
    public final d<x> create(d<?> r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new LoadingDetectionModel$inferenceInternal$results$r$1$1(this.this$0, this.$input, this.$cont, r6), d.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super x> r3) {
        return ((LoadingDetectionModel$inferenceInternal$results$r$1$1) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), LoadingDetectionModel$inferenceInternal$results$r$1$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.h.a.b
    public /* synthetic */ Object invoke(d<? super x> r3) {
        return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r6) {
        d.c.a.b.a();
        if (this.label != 0) goto L16;
        o.a(r6);
        LoadingDetectionModel r7 = this.this$0;
        Bitmap r0 = this.$input;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r8 = d.n.f(LoadingDetectionModel.access$getMHelper$p(r7).classify(r0));     // Catch: Throwable -> L7
    L9:
        LoadingDetectionModel r2 = this.this$0;
        n<List<? extends Classifications>> r3 = this.$cont;
        Throwable r4 = d.n.c(r8);
        if (r4 != null) goto L13;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        this.$input.recycle();
        d r5 = (d) ZeusTransformUtils.preCheckCast(this.$cont, d.class, "com.obric.aiagent.plugin");
        d.n.a r10 = d.n.f38560a;
        r5.resumeWith(d.n.f(r9));
        return x.f38692a;
    L13:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r2), " - cannot get inference result: e=" + r4);
        d r11 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
        d.n.a r12 = d.n.f38560a;
        r11.resumeWith(d.n.f(p.b()));
        return x.f38692a;
    L7:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r8 = d.n.f(o.a(th));
        goto L9
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
