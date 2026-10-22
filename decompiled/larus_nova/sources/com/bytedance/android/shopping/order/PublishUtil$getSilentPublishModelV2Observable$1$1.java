package com.bytedance.android.shopping.order;

import cg3.i;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "editModel", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PublishUtil$getSilentPublishModelV2Observable$1$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ ObservableEmitter $emitter;

    public PublishUtil$getSilentPublishModelV2Observable$1$1(ObservableEmitter r100) {
        this.$emitter = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        if (r100 == null) goto L4;
        this.$emitter.onNext(new i(r100));
        return;
    L4:
        this.$emitter.onError(new Throwable("silent publish video failed"));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
