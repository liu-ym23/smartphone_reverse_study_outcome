package com.zyql.common.utils.upload;

import B7.a;
import C7.r;
import J7.c;
import S7.n;
import X6.f;
import android.content.ContentResolver;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.volcengine.tos.TOSV2;
import com.volcengine.tos.TosException;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Input;
import com.volcengine.tos.model.object.PreSignedURLInput;
import com.volcengine.tos.model.object.PreSignedURLOutput;
import com.volcengine.tos.model.object.PutObjectInput;
import com.volcengine.tos.model.object.UploadPartV2Input;
import com.volcengine.tos.model.object.UploadPartV2Output;
import com.volcengine.tos.model.object.UploadedPartV2;
import com.zyql.common.utils.upload.UploadManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J:\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/zyql/common/utils/upload/TOSUploader;", "", AppAgent.CONSTRUCT, "()V", "Lcom/volcengine/tos/TOSV2;", "client", "", "bucket", "key", "Ljava/io/InputStream;", "input", "", "size", "fileTag", "Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "normalUpload", "(Lcom/volcengine/tos/TOSV2;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;JLjava/lang/String;)Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "totalSize", "multipartUpload", "Landroid/content/Context;", "context", "tosClient", "Lcom/zyql/common/utils/upload/UploadManager$UploadTask;", "task", "expireDuration", "upload", "(Landroid/content/Context;Lcom/volcengine/tos/TOSV2;Ljava/lang/String;Lcom/zyql/common/utils/upload/UploadManager$UploadTask;JLH7/c;)Ljava/lang/Object;", "", "MIN_SIZE", "I", "EXPIRED_TIMES", "J", "TAG", "Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TOSUploader {
    public static final long EXPIRED_TIMES = 1800000;
    public static final TOSUploader INSTANCE = new TOSUploader();
    public static final int MIN_SIZE = 10485760;
    private static final String TAG = "TOSUploader";

    @c(c = "com.zyql.common.utils.upload.TOSUploader$upload$2", f = "TOSUploader.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/zyql/common/utils/upload/UploadManager$UploadResult;", "<anonymous>", "(Lm9/z;)Lcom/zyql/common/utils/upload/UploadManager$UploadResult;"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.zyql.common.utils.upload.TOSUploader$upload$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $bucket;
        final /* synthetic */ Context $context;
        final /* synthetic */ long $expireDuration;
        final /* synthetic */ UploadManager.UploadTask $task;
        final /* synthetic */ TOSV2 $tosClient;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(UploadManager.UploadTask uploadTask, Context context, TOSV2 tosv2, String str, long j5, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$task = uploadTask;
            this.$context = context;
            this.$tosClient = tosv2;
            this.$bucket = str;
            this.$expireDuration = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$task, this.$context, this.$tosClient, this.$bucket, this.$expireDuration, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
            InputStream inputStreamOpenInputStream;
            String str;
            UploadManager.UploadResult uploadResultMultipartUpload;
            boolean z10;
            String str2;
            UploadManager.UploadResult uploadResultMultipartUpload2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            Log.i(TOSUploader.TAG, "开始上传任务 objectKey=" + this.$task.getObjectKey() + ", urlOrPath=" + this.$task.getUriOrPath());
            ContentResolver contentResolver = this.$context.getContentResolver();
            String uriOrPath = this.$task.getUriOrPath();
            try {
                parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(this.$task.getUri(), "r");
            } catch (Exception unused) {
                Log.e(TOSUploader.TAG, "无法获取文件描述符: fd=null, uri=" + this.$task.getUriOrPath());
                parcelFileDescriptorOpenFileDescriptor = null;
            }
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                String str3 = "fd=null, uri=";
                Log.i(TOSUploader.TAG, "fd=null, uri=" + this.$task.getUriOrPath());
                File file = new File(this.$task.getUriOrPath());
                if (!file.exists()) {
                    return new UploadManager.UploadResult(this.$task.getObjectKey(), null, false, new Exception(a.k("文件不存在：", this.$task.getUriOrPath())));
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                long length = file.length();
                try {
                    if (length < 10485760) {
                        str2 = "GET";
                        try {
                            str3 = null;
                            uploadResultMultipartUpload2 = TOSUploader.INSTANCE.normalUpload(this.$tosClient, this.$bucket, this.$task.getObjectKey(), fileInputStream, length, uriOrPath);
                        } catch (Throwable th) {
                            th = th;
                            z10 = 0;
                            try {
                                return new UploadManager.UploadResult(uriOrPath, null, z10, th);
                            } finally {
                                fileInputStream.close();
                            }
                        }
                    } else {
                        str2 = "GET";
                        str3 = null;
                        uploadResultMultipartUpload2 = TOSUploader.INSTANCE.multipartUpload(this.$tosClient, this.$bucket, this.$task.getObjectKey(), fileInputStream, length, uriOrPath);
                    }
                    UploadManager.UploadResult uploadResultCopy$default = uploadResultMultipartUpload2;
                    if (uploadResultCopy$default.getSuccess()) {
                        uploadResultCopy$default = UploadManager.UploadResult.copy$default(uploadResultCopy$default, null, this.$tosClient.preSignedURL(PreSignedURLInput.builder().httpMethod(str2).bucket(this.$bucket).key(this.$task.getObjectKey()).expires(this.$expireDuration).build()).getSignedUrl(), false, null, 13, null);
                    }
                    return uploadResultCopy$default;
                } catch (Throwable th2) {
                    th = th2;
                    z10 = str3;
                }
            } else {
                long statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                Log.i(TOSUploader.TAG, "文件大小: " + statSize + " bytes");
                try {
                    inputStreamOpenInputStream = contentResolver.openInputStream(this.$task.getUri());
                } catch (Exception e) {
                    Log.e(TOSUploader.TAG, "无法读取文件: inputStream=null, uri=" + this.$task.getUri(), e);
                    inputStreamOpenInputStream = null;
                }
                if (inputStreamOpenInputStream == null) {
                    Log.e(TOSUploader.TAG, "无法读取文件: inputStream=null, uri=" + this.$task.getUri());
                    return new UploadManager.UploadResult(uriOrPath, null, false, new Exception("无法读取文件（inputStream = null）"));
                }
                try {
                    if (statSize < 10485760) {
                        Log.i(TOSUploader.TAG, "执行普通上传（PutObject）");
                        str = "GET";
                        uploadResultMultipartUpload = TOSUploader.INSTANCE.normalUpload(this.$tosClient, this.$bucket, this.$task.getObjectKey(), inputStreamOpenInputStream, statSize, uriOrPath);
                    } else {
                        str = "GET";
                        Log.i(TOSUploader.TAG, "执行分片上传（MultipartUpload）");
                        uploadResultMultipartUpload = TOSUploader.INSTANCE.multipartUpload(this.$tosClient, this.$bucket, this.$task.getObjectKey(), inputStreamOpenInputStream, statSize, uriOrPath);
                    }
                    UploadManager.UploadResult uploadResultCopy$default2 = uploadResultMultipartUpload;
                    if (uploadResultCopy$default2.getSuccess()) {
                        Log.i(TOSUploader.TAG, "上传成功，开始生成预签名 URL");
                        PreSignedURLOutput preSignedURLOutputPreSignedURL = this.$tosClient.preSignedURL(PreSignedURLInput.builder().httpMethod(str).bucket(this.$bucket).key(this.$task.getObjectKey()).expires(this.$expireDuration).build());
                        Log.i(TOSUploader.TAG, "预签名 URL 生成成功: " + preSignedURLOutputPreSignedURL.getSignedUrl());
                        uploadResultCopy$default2 = UploadManager.UploadResult.copy$default(uploadResultCopy$default2, null, preSignedURLOutputPreSignedURL.getSignedUrl(), false, null, 13, null);
                    } else {
                        Log.e(TOSUploader.TAG, "上传失败 objectKey=" + this.$task.getObjectKey());
                    }
                    Log.d(TOSUploader.TAG, "关闭文件资源");
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable unused2) {
                    }
                    try {
                        inputStreamOpenInputStream.close();
                        return uploadResultCopy$default2;
                    } catch (Throwable unused3) {
                        return uploadResultCopy$default2;
                    }
                } catch (Throwable th3) {
                    try {
                        Log.e(TOSUploader.TAG, "上传异常 objectKey=" + this.$task.getObjectKey(), th3);
                        UploadManager.UploadResult uploadResult = new UploadManager.UploadResult(uriOrPath, null, false, th3);
                        Log.d(TOSUploader.TAG, "关闭文件资源");
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable unused4) {
                        }
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable unused5) {
                        }
                        return uploadResult;
                    } finally {
                    }
                }
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super UploadManager.UploadResult> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private TOSUploader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UploadManager.UploadResult multipartUpload(TOSV2 client, String bucket, String key, InputStream input, long totalSize, String fileTag) throws TosException, IOException {
        Log.i(TAG, "分片上传初始化 bucket=" + bucket + ", key=" + key);
        int i = MIN_SIZE;
        long j5 = (long) MIN_SIZE;
        int i6 = (int) (((totalSize + j5) - 1) / j5);
        Log.i(TAG, "分片上传 partSize=10485760, partCount=" + i6);
        String uploadID = client.createMultipartUpload(bucket, key, new f[0]).getUploadID();
        Log.i(TAG, "分片任务创建成功 uploadID=" + uploadID);
        ArrayList arrayList = new ArrayList();
        if (1 <= i6) {
            int i10 = 1;
            while (true) {
                byte[] bArr = new byte[i];
                int i11 = input.read(bArr);
                if (i11 > 0) {
                    StringBuilder sbS = androidx.appfunctions.metadata.a.s(i10, "上传分片 ", i6, " / ", ", size=");
                    sbS.append(i11);
                    Log.d(TAG, sbS.toString());
                    UploadPartV2Output uploadPartV2OutputUploadPart = client.uploadPart(UploadPartV2Input.builder().bucket(bucket).key(key).uploadID(uploadID).partNumber(i10).content(new ByteArrayInputStream(bArr, 0, i11)).build());
                    Log.i(TAG, "分片上传成功 partNumber=" + uploadPartV2OutputUploadPart.getPartNumber() + ", etag=" + uploadPartV2OutputUploadPart.getEtag());
                    UploadedPartV2 uploadedPartV2Build = UploadedPartV2.builder().partNumber(uploadPartV2OutputUploadPart.getPartNumber()).etag(uploadPartV2OutputUploadPart.getEtag()).build();
                    k.e(uploadedPartV2Build, "build(...)");
                    arrayList.add(uploadedPartV2Build);
                    if (i10 == i6) {
                        break;
                    }
                    i10++;
                    i = MIN_SIZE;
                } else {
                    Log.w(TAG, androidx.compose.foundation.b.o(i10, "第 ", i11, " 片无数据可读(read=", ")，提前结束循环"));
                    break;
                }
            }
        }
        Log.i(TAG, "所有分片上传完成，开始合并 uploadID=" + uploadID);
        client.completeMultipartUpload(CompleteMultipartUploadV2Input.builder().bucket(bucket).key(key).uploadID(uploadID).uploadedParts(arrayList).build());
        Log.i(TAG, "分片合并完成 key=" + key);
        return new UploadManager.UploadResult(fileTag, null, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UploadManager.UploadResult normalUpload(TOSV2 client, String bucket, String key, InputStream input, long size, String fileTag) throws TosException {
        StringBuilder sbW = a.w("普通上传 bucket=", bucket, ", key=", key, ", size=");
        sbW.append(size);
        Log.d(TAG, sbW.toString());
        client.putObject(PutObjectInput.builder().bucket(bucket).key(key).content(input).contentLength(size).build());
        Log.i(TAG, "普通上传完成 key=" + key);
        return new UploadManager.UploadResult(fileTag, null, true, null);
    }

    public final Object upload(Context context, TOSV2 tosv2, String str, UploadManager.UploadTask uploadTask, long j5, H7.c<? super UploadManager.UploadResult> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(uploadTask, context, tosv2, str, j5, null), cVar);
    }
}
