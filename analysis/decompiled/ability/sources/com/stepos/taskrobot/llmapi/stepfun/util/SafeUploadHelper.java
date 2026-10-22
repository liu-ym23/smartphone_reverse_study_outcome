package com.stepos.taskrobot.llmapi.stepfun.util;

import J7.c;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/util/SafeUploadHelper;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "", "pathList", "logTag", "getUrls", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Lw9/a;", "uploadMutex", "Lw9/a;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeUploadHelper {
    private static final String TAG = "SafeUploadHelper";
    public static final SafeUploadHelper INSTANCE = new SafeUploadHelper();
    private static final InterfaceC2108a uploadMutex = new kotlinx.coroutines.sync.a();

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.util.SafeUploadHelper", f = "SafeUploadHelper.kt", l = {99, 102}, m = "getUrls", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.util.SafeUploadHelper$getUrls$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
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
            return SafeUploadHelper.this.getUrls(null, null, null, this);
        }
    }

    private SafeUploadHelper() {
    }

    public static /* synthetic */ Object getUrls$default(SafeUploadHelper safeUploadHelper, Context context, List list, String str, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            str = TAG;
        }
        return safeUploadHelper.getUrls(context, list, str, cVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(1:(1:(6:12|50|13|35|43|44)(2:19|20))(1:21))(2:22|(2:24|25)(3:26|(1:29)|33))|52|30|47|31|(4:34|35|43|44)|33) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0130, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0131, code lost:
    
        r8 = r1;
        r4 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getUrls(android.content.Context r26, java.util.List<java.lang.String> r27, java.lang.String r28, H7.c<? super java.util.List<java.lang.String>> r29) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.util.SafeUploadHelper.getUrls(android.content.Context, java.util.List, java.lang.String, H7.c):java.lang.Object");
    }
}
