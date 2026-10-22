package com.stepos.agentframework.adapter.netcore;

import P6.DownloadUrlResponse;
import Ua.InterfaceC1066l;
import Ua.M;
import com.stepos.common.utils.filestorage.FileStorageManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper$resolveDownloadUrl$2", f = "FileStorageUploadHelper.kt", l = {343}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class FileStorageUploadHelper$resolveDownloadUrl$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ String $fileId;
    int I$0;
    Object L$0;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<DownloadUrlResponse, Y8.t> {
        final /* synthetic */ InterfaceC1066l<String> $cont;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC1066l<? super String> interfaceC1066l) {
            this.$cont = interfaceC1066l;
        }

        public final void a(DownloadUrlResponse resp) {
            kotlin.jvm.internal.p.i(resp, "resp");
            InterfaceC1066l<String> interfaceC1066l = this.$cont;
            String downloadUrl = resp.getDownloadUrl();
            if (downloadUrl.length() == 0) {
                downloadUrl = null;
            }
            interfaceC1066l.resumeWith(Result.b(downloadUrl));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(DownloadUrlResponse downloadUrlResponse) {
            a(downloadUrlResponse);
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<Throwable, Y8.t> {
        final /* synthetic */ InterfaceC1066l<String> $cont;
        final /* synthetic */ String $fileId;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, InterfaceC1066l<? super String> interfaceC1066l) {
            this.$fileId = str;
            this.$cont = interfaceC1066l;
        }

        public final void a(Throwable e10) {
            kotlin.jvm.internal.p.i(e10, "e");
            C4148a.g("FileStorageUploadHelper", "getDownloadUrl failed: fileId=" + this.$fileId, e10, false, 8, null);
            this.$cont.resumeWith(Result.b(null));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Throwable th) {
            a(th);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageUploadHelper$resolveDownloadUrl$2(String str, InterfaceC4014c<? super FileStorageUploadHelper$resolveDownloadUrl$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FileStorageUploadHelper$resolveDownloadUrl$2(this.$fileId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((FileStorageUploadHelper$resolveDownloadUrl$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        String str = this.$fileId;
        this.L$0 = str;
        this.I$0 = 0;
        this.label = 1;
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(this), 1);
        cVar.I();
        try {
            FileStorageManager.INSTANCE.i(str, null, null, new a(cVar), new b(str, cVar));
        } catch (Throwable th) {
            C4148a.g("FileStorageUploadHelper", "getDownloadUrl threw: fileId=" + str, th, false, 8, null);
            cVar.resumeWith(Result.b(null));
        }
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(this);
        }
        return objC == objG ? objG : objC;
    }
}
