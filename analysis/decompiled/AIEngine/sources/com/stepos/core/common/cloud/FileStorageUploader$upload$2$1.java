package com.stepos.core.common.cloud;

import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.io.File;
import java.util.Arrays;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.common.cloud.FileStorageUploader$upload$2$1", f = "FileStorageUploader.kt", l = {64, 73}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FileStorageUploader$upload$2$1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {
    final /* synthetic */ String $bizCode;
    final /* synthetic */ Integer $effectiveExpires;
    final /* synthetic */ File $localFile;
    final /* synthetic */ String $sourceType;
    final /* synthetic */ FileStorageUploader $this_runCatching;
    long J$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageUploader$upload$2$1(FileStorageUploader fileStorageUploader, File file, String str, String str2, Integer num, qb.b<? super FileStorageUploader$upload$2$1> bVar) {
        super(2, bVar);
        this.$this_runCatching = fileStorageUploader;
        this.$localFile = file;
        this.$bizCode = str;
        this.$sourceType = str2;
        this.$effectiveExpires = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new FileStorageUploader$upload$2$1(this.$this_runCatching, this.$localFile, this.$bizCode, this.$sourceType, this.$effectiveExpires, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long jElapsedRealtime;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            jElapsedRealtime = SystemClock.elapsedRealtime();
            FileStorageUploader fileStorageUploader = this.$this_runCatching;
            File file = this.$localFile;
            String str = this.$bizCode;
            String str2 = this.$sourceType;
            this.J$0 = jElapsedRealtime;
            this.label = 1;
            obj = fileStorageUploader.startSingleUpload(file, str, str2, this);
            if (obj != coroutineSingletons) {
            }
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            return obj;
        }
        jElapsedRealtime = this.J$0;
        kotlin.c.b(obj);
        String str3 = (String) obj;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        double length = jElapsedRealtime2 > 0 ? ((this.$localFile.length() * 1000.0d) / 1024.0d) / jElapsedRealtime2 : 0.0d;
        LogModule logModule = LogModule.ABILITY;
        String name = this.$localFile.getName();
        long length2 = this.$localFile.length();
        String str4 = String.format("%.1f", Arrays.copyOf(new Object[]{new Double(length)}, 1));
        StringBuilder sbL = com.stepos.core.ota.d.l("FileStorageUploader: upload transfer done file=", length2, name, " size=");
        a0.a.s(jElapsedRealtime2, " elapsedMs=", " speed=", sbL);
        sbL.append(str4);
        sbL.append("KB/s");
        AIEngineLogger.i(logModule, FileStorageUploader.TAG, sbL.toString());
        FileStorageUploader fileStorageUploader2 = this.$this_runCatching;
        Integer num = this.$effectiveExpires;
        this.label = 2;
        Object objFetchDownloadUrl = fileStorageUploader2.fetchDownloadUrl(str3, num, this);
        return objFetchDownloadUrl == coroutineSingletons ? coroutineSingletons : objFetchDownloadUrl;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
        return ((FileStorageUploader$upload$2$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
