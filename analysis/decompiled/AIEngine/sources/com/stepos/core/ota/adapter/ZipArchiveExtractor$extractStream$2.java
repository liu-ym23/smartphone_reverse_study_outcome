package com.stepos.core.ota.adapter;

import java.io.InputStream;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.ZipArchiveExtractor$extractStream$2", f = "InstallAdapters.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ZipArchiveExtractor$extractStream$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends n>>, Object> {
    final /* synthetic */ String $destDir;
    final /* synthetic */ InputStream $source;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZipArchiveExtractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipArchiveExtractor$extractStream$2(ZipArchiveExtractor zipArchiveExtractor, InputStream inputStream, String str, b<? super ZipArchiveExtractor$extractStream$2> bVar) {
        super(2, bVar);
        this.this$0 = zipArchiveExtractor;
        this.$source = inputStream;
        this.$destDir = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ZipArchiveExtractor$extractStream$2 zipArchiveExtractor$extractStream$2 = new ZipArchiveExtractor$extractStream$2(this.this$0, this.$source, this.$destDir, bVar);
        zipArchiveExtractor$extractStream$2.L$0 = obj;
        return zipArchiveExtractor$extractStream$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends n>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<n>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        try {
            this.this$0.unzip(this.$source, this.$destDir);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<n>> bVar) {
        return ((ZipArchiveExtractor$extractStream$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
