package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0}, l = {81}, m = "safeRun", n = {"$this$safeRun"}, s = {"L$0"})
public final class WidgetResourceLoader$safeRun$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetResourceLoader this$0;

    public WidgetResourceLoader$safeRun$1(WidgetResourceLoader r100, Continuation<? super WidgetResourceLoader$safeRun$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        WidgetResourceLoader r101 = this.this$0;
        ConcurrentHashMap<String, CompletableDeferred<Widget>> r102 = WidgetResourceLoader.f37940e;
        return r101.o(null, null, this);
    }
}
