package com.stepos.agentframework.adapter.netcore;

import P6.UploadResult;
import Ua.M;
import android.content.Context;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LP6/m;", "<anonymous>", "(LUa/M;)LP6/m;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$doUpload$result$1", f = "FileStorageUploadHelper.kt", l = {175}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class FileStorageUploadHelper$doUpload$result$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super UploadResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ p9.s<Integer, Boolean, String, String, Long, Y8.t> $onProgress;
    final /* synthetic */ String $uriOrPath;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileStorageUploadHelper$doUpload$result$1(Context context, String str, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar, InterfaceC4014c<? super FileStorageUploadHelper$doUpload$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$context = context;
        this.$uriOrPath = str;
        this.$onProgress = sVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileStorageUploadHelper$doUpload$result$1(this.$context, this.$uriOrPath, this.$onProgress, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super UploadResult> interfaceC4014c) {
        return ((FileStorageUploadHelper$doUpload$result$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        FileStorageUploadHelper fileStorageUploadHelper = FileStorageUploadHelper.INSTANCE;
        Context context = this.$context;
        String str = this.$uriOrPath;
        p9.s<Integer, Boolean, String, String, Long, Y8.t> sVar = this.$onProgress;
        this.label = 1;
        Object objM = fileStorageUploadHelper.m(context, str, sVar, this);
        return objM == objG ? objG : objM;
    }
}
