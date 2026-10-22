package com.stepos.core.ota.adapter;

import com.stepos.core.ability.speech.PcmDumpBudget;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.ZipArchiveExtractor$extract$2", f = "InstallAdapters.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ZipArchiveExtractor$extract$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends n>>, Object> {
    final /* synthetic */ String $archivePath;
    final /* synthetic */ String $destDir;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZipArchiveExtractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZipArchiveExtractor$extract$2(String str, ZipArchiveExtractor zipArchiveExtractor, String str2, b<? super ZipArchiveExtractor$extract$2> bVar) {
        super(2, bVar);
        this.$archivePath = str;
        this.this$0 = zipArchiveExtractor;
        this.$destDir = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        ZipArchiveExtractor$extract$2 zipArchiveExtractor$extract$2 = new ZipArchiveExtractor$extract$2(this.$archivePath, this.this$0, this.$destDir, bVar);
        zipArchiveExtractor$extract$2.L$0 = obj;
        return zipArchiveExtractor$extract$2;
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
        String str = this.$archivePath;
        ZipArchiveExtractor zipArchiveExtractor = this.this$0;
        String str2 = this.$destDir;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                zipArchiveExtractor.unzip(bufferedInputStream, str2);
                n nVar = n.f10413a;
                bufferedInputStream.close();
                objA = n.f10413a;
            } finally {
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<n>> bVar) {
        return ((ZipArchiveExtractor$extract$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
