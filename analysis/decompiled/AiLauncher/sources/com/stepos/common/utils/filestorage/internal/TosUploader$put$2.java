package com.stepos.common.utils.filestorage.internal;

import P6.TosCallbackBody;
import Ua.M;
import Y8.t;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.io.IOException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.x;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LP6/j;", "<anonymous>", "(LUa/M;)LP6/j;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "com.stepos.common.utils.filestorage.internal.TosUploader$put$2", f = "TosUploader.kt", l = {58}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TosUploader$put$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super TosCallbackBody>, Object> {
    final /* synthetic */ Long $contentLength;
    final /* synthetic */ String $contentType;
    final /* synthetic */ Context $context;
    final /* synthetic */ InterfaceC5074l<Long, t> $onBytesWritten;
    final /* synthetic */ String $uploadUrl;
    final /* synthetic */ Uri $uri;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ TosUploader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TosUploader$put$2(String str, Context context, Uri uri, Long l10, InterfaceC5074l<? super Long, t> interfaceC5074l, String str2, TosUploader tosUploader, InterfaceC4014c<? super TosUploader$put$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$contentType = str;
        this.$context = context;
        this.$uri = uri;
        this.$contentLength = l10;
        this.$onBytesWritten = interfaceC5074l;
        this.$uploadUrl = str2;
        this.this$0 = tosUploader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TosUploader$put$2(this.$contentType, this.$context, this.$uri, this.$contentLength, this.$onBytesWritten, this.$uploadUrl, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super TosCallbackBody> interfaceC4014c) {
        return ((TosUploader$put$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        String str2;
        Object objD;
        long j10;
        long jCurrentTimeMillis;
        TosCallbackBody tosCallbackBodyE;
        int code;
        String status;
        String fileId;
        String auditStatus;
        String auditDecision;
        String sensitiveStatus;
        String sensitiveDecision;
        Boolean detectPassed;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            C5528A c5528aB = new C5528A.a().t(this.$uploadUrl).p(new f(this.$context, this.$uri, x.INSTANCE.b(this.$contentType), this.$contentLength, this.$onBytesWritten)).b();
            String host = c5528aB.getUrl().getHost();
            Uri uri = this.$uri;
            String str3 = this.$contentType;
            Long l10 = this.$contentLength;
            long jLongValue = l10 != null ? l10.longValue() : -1L;
            StringBuilder sb2 = new StringBuilder();
            str = "/";
            sb2.append("→ PUT ");
            sb2.append(host);
            sb2.append(" uri=");
            sb2.append(uri);
            sb2.append(" ct=");
            sb2.append(str3);
            sb2.append(" size=");
            sb2.append(jLongValue);
            Log.i(f.BODY_TAG, sb2.toString());
            try {
                TosUploader tosUploader = this.this$0;
                InterfaceC5538e interfaceC5538eA = tosUploader.okHttp.a(c5528aB);
                this.L$0 = host;
                this.J$0 = jCurrentTimeMillis2;
                this.label = 1;
                objD = tosUploader.d(interfaceC5538eA, this);
                if (objD == objG) {
                    return objG;
                }
                j10 = jCurrentTimeMillis2;
                str2 = host;
            } catch (IOException e10) {
                e = e10;
                str2 = host;
                Log.w(f.BODY_TAG, "✗ PUT " + str2 + " network error: " + e.getMessage());
                throw new FileStorageException.TosPutFailed(-1, "TOS PUT network error: " + e.getMessage(), e);
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = this.J$0;
            str2 = (String) this.L$0;
            try {
                C4849c.b(obj);
                str = "/";
                objD = obj;
            } catch (IOException e11) {
                e = e11;
                Log.w(f.BODY_TAG, "✗ PUT " + str2 + " network error: " + e.getMessage());
                throw new FileStorageException.TosPutFailed(-1, "TOS PUT network error: " + e.getMessage(), e);
            }
        }
        C5530C c5530c = (C5530C) objD;
        TosUploader tosUploader2 = this.this$0;
        try {
            jCurrentTimeMillis = System.currentTimeMillis() - j10;
            try {
                tosCallbackBodyE = tosUploader2.e(c5530c);
                code = c5530c.getCode();
                status = tosCallbackBodyE.getStatus();
                fileId = tosCallbackBodyE.getFileId();
                auditStatus = tosCallbackBodyE.getAuditStatus();
                auditDecision = tosCallbackBodyE.getAuditDecision();
                sensitiveStatus = tosCallbackBodyE.getSensitiveStatus();
                sensitiveDecision = tosCallbackBodyE.getSensitiveDecision();
                detectPassed = tosCallbackBodyE.getDetectPassed();
            } catch (FileStorageException e12) {
                e = e12;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("← PUT ");
            sb3.append(str2);
            sb3.append(" http=");
            sb3.append(code);
            sb3.append(" ");
            sb3.append(jCurrentTimeMillis);
            sb3.append("ms status=");
            sb3.append(status);
            sb3.append(" fileId=");
            sb3.append(fileId);
            sb3.append(" audit=");
            sb3.append(auditStatus);
            String str4 = str;
            sb3.append(str4);
            sb3.append(auditDecision);
            sb3.append(" sensitive=");
            sb3.append(sensitiveStatus);
            sb3.append(str4);
            sb3.append(sensitiveDecision);
            sb3.append(" detectPassed=");
            sb3.append(detectPassed);
            Log.i(f.BODY_TAG, sb3.toString());
            l9.b.a(c5530c, null);
            return tosCallbackBodyE;
        } catch (FileStorageException e13) {
            e = e13;
            c5530c = c5530c;
            Log.w(f.BODY_TAG, "← PUT " + str2 + " http=" + c5530c.getCode() + " " + jCurrentTimeMillis + "ms err=" + e.getClass().getSimpleName() + ": " + e.getMessage());
            throw e;
        } catch (Throwable th2) {
            th = th2;
            c5530c = c5530c;
            Throwable th3 = th;
            try {
                throw th3;
            } catch (Throwable th4) {
                l9.b.a(c5530c, th3);
                throw th4;
            }
        }
    }
}
