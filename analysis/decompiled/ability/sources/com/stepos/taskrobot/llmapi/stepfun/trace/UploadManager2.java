package com.stepos.taskrobot.llmapi.stepfun.trace;

import C7.r;
import J7.c;
import S7.n;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.volcengine.tos.TOSV2;
import com.volcengine.tos.TOSV2ClientBuilder;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.TosException;
import com.volcengine.tos.TosServerException;
import com.volcengine.tos.model.bucket.CreateBucketV2Input;
import com.volcengine.tos.model.object.PutObjectBasicInput;
import com.volcengine.tos.model.object.PutObjectInput;
import com.volcengine.tos.model.object.PutObjectOutput;
import j9.AbstractC1607a;
import j9.t;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import stepai.aios.guiagent.tracer.remote.UploadResult;
import stepai.android.llm.base.twoway.FlowType;
import u9.d;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\f\u0010\tJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/UploadManager2;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "initData", "", SettingsConfig.KEY_DATA, "test", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "createBucket", "(LH7/c;)Ljava/lang/Object;", "uploadData", "getCurrentDateFormatted", "()Ljava/lang/String;", "filePath", AgentBusWakeContract.EXTRA_TRACE_ID, "Lstepai/aios/guiagent/tracer/remote/UploadResult;", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadManager2 {

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$createBucket$2", f = "UploadManager2.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$createBucket$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $bucketName;
        final /* synthetic */ TOSV2 $tos;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, TOSV2 tosv2, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$bucketName = str;
            this.$tos = tosv2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$bucketName, this.$tos, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                return new Integer(Log.i("bucket created: ", this.$tos.createBucket(new CreateBucketV2Input().setBucket(this.$bucketName)).getLocation()));
            } catch (TosException e) {
                e.printStackTrace();
                return r.f317a;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<Object> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$test$2", f = "UploadManager2.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$test$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11982 extends SuspendLambda implements n {
        final /* synthetic */ String $bucketName;
        final /* synthetic */ String $data;
        final /* synthetic */ String $objectKey;
        final /* synthetic */ TOSV2 $tos;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11982(String str, String str2, String str3, TOSV2 tosv2, H7.c<? super C11982> cVar) {
            super(2, cVar);
            this.$data = str;
            this.$bucketName = str2;
            this.$objectKey = str3;
            this.$tos = tosv2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C11982(this.$data, this.$bucketName, this.$objectKey, this.$tos, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Integer num;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                byte[] bytes = this.$data.getBytes(AbstractC1607a.f4778a);
                k.e(bytes, "getBytes(...)");
                PutObjectOutput putObjectOutputPutObject = this.$tos.putObject(new PutObjectInput().setPutObjectBasicInput(new PutObjectBasicInput().setBucket(this.$bucketName).setKey(this.$objectKey)).setContent(new ByteArrayInputStream(bytes)));
                Log.i("putObject", "object's etag is " + putObjectOutputPutObject.getEtag());
                return new Integer(Log.i("putObject", "object's crc64 is " + putObjectOutputPutObject.getHashCrc64ecma()));
            } catch (TosClientException e) {
                num = new Integer(Log.e("TosClientException", e.toString()));
                return num;
            } catch (TosServerException e6) {
                num = new Integer(Log.e("TosServerException", e6.toString()));
                return num;
            } catch (Throwable th) {
                th.printStackTrace();
                return r.f317a;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<Object> cVar) {
            return ((C11982) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$uploadData$2", f = "UploadManager2.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$uploadData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11992 extends SuspendLambda implements n {
        final /* synthetic */ String $bucketName;
        final /* synthetic */ String $data;
        final /* synthetic */ String $objectKey;
        final /* synthetic */ TOSV2 $tos;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11992(String str, String str2, String str3, TOSV2 tosv2, H7.c<? super C11992> cVar) {
            super(2, cVar);
            this.$data = str;
            this.$bucketName = str2;
            this.$objectKey = str3;
            this.$tos = tosv2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C11992(this.$data, this.$bucketName, this.$objectKey, this.$tos, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                byte[] bytes = this.$data.getBytes(AbstractC1607a.f4778a);
                k.e(bytes, "getBytes(...)");
                PutObjectOutput putObjectOutputPutObject = this.$tos.putObject(new PutObjectInput().setPutObjectBasicInput(new PutObjectBasicInput().setBucket(this.$bucketName).setKey(this.$objectKey)).setContent(new ByteArrayInputStream(bytes)));
                Log.i("dkk", "succeed, object's etag is " + putObjectOutputPutObject.getEtag());
                return new Integer(Log.i("dkk", "succeed, object's crc64 is " + putObjectOutputPutObject.getHashCrc64ecma()));
            } catch (TosException e) {
                Log.e("dkk", FlowType.FAILED);
                e.printStackTrace();
                return r.f317a;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<Object> cVar) {
            return ((C11992) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$uploadFile$2", f = "UploadManager2.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiagent/tracer/remote/UploadResult;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiagent/tracer/remote/UploadResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2$uploadFile$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12002 extends SuspendLambda implements n {
        final /* synthetic */ String $bucketName;
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $filePath;
        final /* synthetic */ String $objectKey;
        final /* synthetic */ TOSV2 $tos;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12002(String str, String str2, String str3, TOSV2 tosv2, String str4, H7.c<? super C12002> cVar) {
            super(2, cVar);
            this.$filePath = str;
            this.$bucketName = str2;
            this.$objectKey = str3;
            this.$tos = tosv2;
            this.$fileName = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12002(this.$filePath, this.$bucketName, this.$objectKey, this.$tos, this.$fileName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                Log.d("dkk", " startUpload");
                FileInputStream fileInputStream = new FileInputStream(this.$filePath);
                String str = this.$bucketName;
                String etag = this.$objectKey;
                TOSV2 tosv2 = this.$tos;
                String str2 = this.$fileName;
                try {
                    Log.d("dkk", " inputStream = " + fileInputStream);
                    PutObjectBasicInput key = new PutObjectBasicInput().setBucket(str).setKey(etag);
                    Log.d("dkk", " basicInput = " + key);
                    PutObjectInput content = new PutObjectInput().setPutObjectBasicInput(key).setContent(fileInputStream);
                    Log.d("dkk", " putObjectInput = " + content);
                    PutObjectOutput putObjectOutputPutObject = tosv2.putObject(content);
                    Log.i("dkk", "putObject succeed, object's etag is " + putObjectOutputPutObject.getEtag());
                    Log.i("dkk", "putObject succeed, object's crc64 is " + putObjectOutputPutObject.getHashCrc64ecma());
                    k.c(str2);
                    if (t.W(str2, ".json", false)) {
                        etag = putObjectOutputPutObject.getEtag();
                        k.e(etag, "getEtag(...)");
                    }
                    Log.i("dkk", "fileName = ".concat(str2));
                    UploadResult uploadResult = new UploadResult(true, "Success", etag);
                    fileInputStream.close();
                    return uploadResult;
                } finally {
                }
            } catch (TosException e) {
                Log.e("dkk", "putObject failed");
                e.printStackTrace();
                return new UploadResult(false, B7.a.k("Upload failed: ", e.getMessage()), "");
            } catch (IOException e6) {
                Log.e("dkk", "putObject read file failed");
                e6.printStackTrace();
                return new UploadResult(false, B7.a.k("File read failed: ", e6.getMessage()), "");
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super UploadResult> cVar) {
            return ((C12002) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public final Object createBucket(H7.c<? super r> cVar) throws Throwable {
        TraceParams traceParams = TraceParams.INSTANCE;
        TOSV2 tosv2Build = new TOSV2ClientBuilder().build(TraceParams.REGION, TraceParams.END_POINT, traceParams.getACCESS_KEY(), traceParams.getSECRET_KEY());
        d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(TraceParams.BUCKET_NAME, tosv2Build, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    public final String getCurrentDateFormatted() {
        String str = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Calendar.getInstance().getTime());
        k.e(str, "format(...)");
        return str;
    }

    public final void initData() {
        TraceParams traceParams = TraceParams.INSTANCE;
        new TOSV2ClientBuilder().build(TraceParams.REGION, TraceParams.END_POINT, traceParams.getACCESS_KEY(), traceParams.getSECRET_KEY());
    }

    public final Object test(String str, H7.c<? super r> cVar) throws Throwable {
        TraceParams traceParams = TraceParams.INSTANCE;
        TOSV2 tosv2Build = new TOSV2ClientBuilder().build(TraceParams.REGION, TraceParams.END_POINT, traceParams.getACCESS_KEY(), traceParams.getSECRET_KEY());
        d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new C11982(str, TraceParams.BUCKET_NAME, TraceParams.OBJECT_KEY, tosv2Build, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    public final Object uploadData(String str, H7.c<? super r> cVar) throws Throwable {
        TraceParams traceParams = TraceParams.INSTANCE;
        TOSV2 tosv2Build = new TOSV2ClientBuilder().build(TraceParams.REGION, TraceParams.END_POINT, traceParams.getACCESS_KEY(), traceParams.getSECRET_KEY());
        d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new C11992(str, TraceParams.BUCKET_NAME, TraceParams.OBJECT_KEY, tosv2Build, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    public final Object uploadFile(String str, String str2, H7.c<? super UploadResult> cVar) {
        String name = new File(str).getName();
        Log.d("dkk", " filePath = " + name);
        TraceParams traceParams = TraceParams.INSTANCE;
        String access_key = traceParams.getACCESS_KEY();
        String secret_key = traceParams.getSECRET_KEY();
        StringBuilder sbW = B7.a.w(TraceParams.OBJECT_KEY, getCurrentDateFormatted(), "-", str2, "/");
        sbW.append(name);
        String string = sbW.toString();
        Log.d("dkk", " filePath = " + str + "  objectKey = " + string);
        TOSV2 tosv2Build = new TOSV2ClientBuilder().build(TraceParams.REGION, TraceParams.END_POINT, access_key, secret_key);
        StringBuilder sb = new StringBuilder(" tos = ");
        sb.append(tosv2Build);
        Log.d("dkk", sb.toString());
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12002(str, TraceParams.BUCKET_NAME, string, tosv2Build, name, null), cVar);
    }
}
