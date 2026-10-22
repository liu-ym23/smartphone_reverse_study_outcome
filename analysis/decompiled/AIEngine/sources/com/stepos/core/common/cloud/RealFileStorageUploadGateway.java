package com.stepos.core.common.cloud;

import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.common.utils.filestorage.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.Job;
import lb.n;
import o8.i;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RealFileStorageUploadGateway implements FileStorageUploadGateway {
    private final Context context;

    public RealFileStorageUploadGateway(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n enqueueSingle$lambda$0(l lVar, int i10) {
        lVar.invoke(Integer.valueOf(i10));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n enqueueSingle$lambda$1(int i10, String str, int i11) {
        kotlin.jvm.internal.g.f(str, "<unused var>");
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n enqueueSingle$lambda$2(int i10, i iVar, int i11, int i12) {
        kotlin.jvm.internal.g.f(iVar, "<unused var>");
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n fetchDownloadUrl$lambda$3(l lVar, o8.d response) {
        kotlin.jvm.internal.g.f(response, "response");
        lVar.invoke(response.f10795b);
        return n.f10413a;
    }

    @Override // com.stepos.core.common.cloud.FileStorageUploadGateway
    public Job enqueueSingle(o8.h request, String taskId, l<? super Integer, n> onProgress, l<? super List<i>, n> onFinished) {
        kotlin.jvm.internal.g.f(request, "request");
        kotlin.jvm.internal.g.f(taskId, "taskId");
        kotlin.jvm.internal.g.f(onProgress, "onProgress");
        kotlin.jvm.internal.g.f(onFinished, "onFinished");
        AtomicReference<a.C0046a> atomicReference = com.stepos.common.utils.filestorage.a.f6632a;
        Context applicationContext = this.context.getApplicationContext();
        kotlin.jvm.internal.g.e(applicationContext, "getApplicationContext(...)");
        return com.stepos.common.utils.filestorage.a.a(applicationContext, b1.P(request), taskId, new androidx.compose.runtime.i(onProgress, 5), onFinished, new e(), new f());
    }

    @Override // com.stepos.core.common.cloud.FileStorageUploadGateway
    public void fetchDownloadUrl(String fileId, Integer num, l<? super String, n> onSuccess, l<? super Throwable, n> onError) {
        kotlin.jvm.internal.g.f(fileId, "fileId");
        kotlin.jvm.internal.g.f(onSuccess, "onSuccess");
        kotlin.jvm.internal.g.f(onError, "onError");
        com.stepos.common.utils.filestorage.a.b(fileId, num, new androidx.compose.runtime.g(onSuccess, 7), onError);
    }
}
