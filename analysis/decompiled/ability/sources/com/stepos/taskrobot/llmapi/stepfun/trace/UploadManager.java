package com.stepos.taskrobot.llmapi.stepfun.trace;

import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.tracer.remote.IUpload;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0096@¢\u0006\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/UploadManager;", "Lstepai/aios/guiagent/tracer/remote/IUpload;", AppAgent.CONSTRUCT, "()V", "", "contentBytes", "", "fileName", "fileSuffix", AgentBusWakeContract.EXTRA_TRACE_ID, "", "headers", "Lstepai/aios/guiagent/tracer/remote/UploadResult;", "uploadContent", "([BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "filePath", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "content", "uploadString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadManager implements IUpload {
    public static final UploadManager INSTANCE = new UploadManager();

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager", f = "UploadManager.kt", l = {85}, m = "uploadContent", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadManager.this.uploadContent(null, null, null, null, null, this);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager", f = "UploadManager.kt", l = {32}, m = "uploadFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C11961(H7.c<? super C11961> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadManager.this.uploadFile(null, null, null, this);
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager", f = "UploadManager.kt", l = {59}, m = "uploadString", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C11971(H7.c<? super C11971> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadManager.this.uploadString(null, null, null, this);
        }
    }

    private UploadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadContent(byte[] r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, H7.c<? super stepai.aios.guiagent.tracer.remote.UploadResult> r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadContent$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadContent$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadContent$1
            r0.<init>(r10)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L43
            if (r1 != r2) goto L3b
            java.lang.Object r5 = r0.L$4
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r5 = r0.L$3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            byte[] r5 = (byte[]) r5
            kotlin.b.b(r4)
            goto L8d
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.b.b(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "uploadContent contentBytes = "
            r4.<init>(r1)
            r4.append(r5)
            java.lang.String r1 = " fileName = "
            r4.append(r1)
            r4.append(r6)
            java.lang.String r6 = " fileSuffix = "
            java.lang.String r1 = " traceId = "
            androidx.constraintlayout.core.dsl.a.A(r4, r6, r7, r1, r8)
            java.lang.String r6 = " headers = "
            r4.append(r6)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = "UploadManager"
            f6.AbstractC1436a.a(r6, r4, r2)
            com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2 r4 = new com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2
            r4.<init>()
            java.lang.String r5 = r5.toString()
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.L$3 = r6
            r0.L$4 = r6
            r0.label = r2
            java.lang.Object r4 = r4.uploadData(r5, r0)
            if (r4 != r10) goto L8d
            return r10
        L8d:
            stepai.aios.guiagent.tracer.remote.UploadResult r4 = new stepai.aios.guiagent.tracer.remote.UploadResult
            java.lang.String r5 = "ok"
            java.lang.String r6 = "11111"
            r4.<init>(r2, r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager.uploadContent(byte[], java.lang.String, java.lang.String, java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object uploadContent$default(UploadManager uploadManager, byte[] bArr, String str, String str2, String str3, Map map, H7.c cVar, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            map = null;
        }
        return uploadManager.uploadContent(bArr, str, str2, str3, map, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // stepai.aios.guiagent.tracer.remote.IUpload
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object uploadFile(java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, H7.c<? super stepai.aios.guiagent.tracer.remote.UploadResult> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager.C11961
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadFile$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager.C11961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadFile$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager$uploadFile$1
            r0.<init>(r9)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L47
            if (r1 != r2) goto L3f
            java.lang.Object r6 = r0.L$4
            byte[] r6 = (byte[]) r6
            java.lang.Object r6 = r0.L$3
            java.io.File r6 = (java.io.File) r6
            java.lang.Object r6 = r0.L$2
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r5)     // Catch: java.lang.Exception -> L3d
            goto L9a
        L3d:
            r5 = move-exception
            goto L9d
        L3f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L47:
            kotlin.b.b(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "uploadFile filePath = "
            r5.<init>(r1)
            r5.append(r6)
            java.lang.String r1 = " traceId = "
            r5.append(r1)
            r5.append(r7)
            java.lang.String r1 = " headers = "
            r5.append(r1)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r8 = "UploadManager"
            f6.AbstractC1436a.a(r8, r5, r2)
            java.io.File r5 = new java.io.File
            r5.<init>(r6)
            boolean r8 = r5.exists()
            if (r8 == 0) goto La7
            boolean r8 = r5.isFile()
            if (r8 != 0) goto L7f
            goto La7
        L7f:
            O7.i.V(r5)     // Catch: java.lang.Exception -> L3d
            com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2 r5 = new com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager2     // Catch: java.lang.Exception -> L3d
            r5.<init>()     // Catch: java.lang.Exception -> L3d
            r0.L$0 = r4     // Catch: java.lang.Exception -> L3d
            r0.L$1 = r4     // Catch: java.lang.Exception -> L3d
            r0.L$2 = r4     // Catch: java.lang.Exception -> L3d
            r0.L$3 = r4     // Catch: java.lang.Exception -> L3d
            r0.L$4 = r4     // Catch: java.lang.Exception -> L3d
            r0.label = r2     // Catch: java.lang.Exception -> L3d
            java.lang.Object r5 = r5.uploadFile(r6, r7, r0)     // Catch: java.lang.Exception -> L3d
            if (r5 != r9) goto L9a
            return r9
        L9a:
            stepai.aios.guiagent.tracer.remote.UploadResult r5 = (stepai.aios.guiagent.tracer.remote.UploadResult) r5     // Catch: java.lang.Exception -> L3d
            return r5
        L9d:
            stepai.aios.guiagent.tracer.remote.UploadResult r6 = new stepai.aios.guiagent.tracer.remote.UploadResult
            java.lang.String r5 = r5.getMessage()
            r6.<init>(r3, r5, r4)
            return r6
        La7:
            stepai.aios.guiagent.tracer.remote.UploadResult r5 = new stepai.aios.guiagent.tracer.remote.UploadResult
            java.lang.String r6 = "file not found"
            r5.<init>(r3, r6, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager.uploadFile(java.lang.String, java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r9v2 */
    @Override // stepai.aios.guiagent.tracer.remote.IUpload
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object uploadString(java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, H7.c<? super stepai.aios.guiagent.tracer.remote.UploadResult> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.trace.UploadManager.uploadString(java.lang.String, java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }
}
