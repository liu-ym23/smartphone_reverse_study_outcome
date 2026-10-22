package com.smt.obric.appstore.assistant.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.strings.R$string;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.JumpActivity;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.execution.IntentImpl;
import com.obric.capabilitykit.common.intent.BaseSystemDownloadAppIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemDownloadAppParams;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u001c\u0010\fR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R*\u0010$\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/smt/obric/appstore/assistant/intent/DownloadAppIntentImpl;", "Lcom/obric/capabilitykit/common/intent/BaseSystemDownloadAppIntent;", "<init>", "()V", "Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "params", "Lcom/obric/capabilitykit/common/DispatchContext;", "dispatchContext", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "onIntent", "(Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/smt/obric/appstore/assistant/intent/b;", "", "tts", "(Lcom/smt/obric/appstore/assistant/intent/b;)Ljava/lang/String;", "Landroid/content/Context;", "context", "appName", "", "isSystemApp", "sessionId", "", "routeSearchApp", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;)V", "isBlock", "()Z", "doAction", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Deferred;", "deferredResult", "Lkotlinx/coroutines/Deferred;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@IntentImpl
@SourceDebugExtension({"SMAP\nDownloadAppIntentImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadAppIntentImpl.kt\ncom/smt/obric/appstore/assistant/intent/DownloadAppIntentImpl\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,430:1\n120#2,10:431\n1#3:441\n29#4:442\n*S KotlinDebug\n*F\n+ 1 DownloadAppIntentImpl.kt\ncom/smt/obric/appstore/assistant/intent/DownloadAppIntentImpl\n*L\n211#1:431,10\n399#1:442\n*E\n"})
public final class DownloadAppIntentImpl extends BaseSystemDownloadAppIntent {

    @Nullable
    private Deferred<IntentResult<AppInfoEntity[]>> deferredResult;

    @NotNull
    private final Mutex mutex;

    @NotNull
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl$doAction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl", f = "DownloadAppIntentImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {436, 212, 231}, m = "doAction", n = {"this", "params", "dispatchContext", "$this$withLock_u24default$iv", "this", "params", "dispatchContext", "$this$withLock_u24default$iv", "params", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DownloadAppIntentImpl this$0;

        public AnonymousClass1(DownloadAppIntentImpl r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doAction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl$onIntent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl", f = "DownloadAppIntentImpl.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6}, l = {251, 271, 273, 277, 296, 302, 364}, m = "onIntent", n = {"this", "params", "dispatchContext", "needEndSession", "sessionId", "$this$onIntent_u24lambda_u247", "isNewSession", "appName", "params", "dispatchContext", "needEndSession", "sessionId", "$this$onIntent_u24lambda_u247", "isNewSession", "appName", "params", "dispatchContext", "needEndSession", "sessionId", "$this$onIntent_u24lambda_u247", "isNewSession", "appName", "params", "needEndSession", "sessionId", "$this$onIntent_u24lambda_u247", "appName", "params", "needEndSession", "sessionId", "$this$onIntent_u24lambda_u247", "appName", "r"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0"})
    public static final class C04521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DownloadAppIntentImpl this$0;

        public C04521(DownloadAppIntentImpl r10, Continuation<? super C04521> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return DownloadAppIntentImpl.access$onIntent(this.this$0, null, null, this);
        }
    }

    public DownloadAppIntentImpl() {
        this.mutex = MutexKt.b(false, 1, null);
        this.scope = d0.a(l0.b().plus(x1.b(null, 1, null)));
    }

    public static final /* synthetic */ Object access$onIntent(DownloadAppIntentImpl r10, SystemDownloadAppParams r11, DispatchContext r12, Continuation r13) {
        return r10.onIntent(r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x009b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:25:0x009b */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x009c: MOVE (r6 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:25:0x009b */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x009d: MOVE (r12 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:25:0x009b */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v45, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v13, types: [com.obric.capabilitykit.common.DispatchContext, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v16, types: [com.obric.capabilitykit.common.DispatchContext] */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v35 */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r14v38 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [com.smt.obric.appstore.assistant.intent.DownloadAppIntentState] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v32, types: [com.smt.obric.appstore.assistant.intent.DownloadAppIntentImpl] */
    /* JADX WARN: Type inference failed for: r1v37, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.capabilitykit.common.DispatchContext, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v44, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.smt.obric.appstore.assistant.intent.DownloadAppIntentV2Handler] */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v17, types: [com.smt.obric.appstore.assistant.intent.DownloadAppIntentState] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22, types: [T] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v35, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v5, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object, kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final Object onIntent(SystemDownloadAppParams r31, DispatchContext r32, Continuation<? super IntentResult<AppInfoEntity[]>> r33) {
        ?? r10 = this;
        ?? r11 = r32;
        if ((r33 instanceof C04521) == false) goto L7;
        C04521 r12 = (C04521) r33;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        ?? r16 = r12.label;
        switch(r16) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L18;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        Object r17 = r12.L$0;
        c.b(r14);
    L147:
        c.b(r17);
        return r17;
    L13:
        String r18 = (String) r12.L$4;
        DownloadAppIntentImpl r19 = (DownloadAppIntentImpl) r12.L$3;
        Ref$ObjectRef r20 = (Ref$ObjectRef) r12.L$2;
        Ref$BooleanRef r21 = (Ref$BooleanRef) r12.L$1;
        SystemDownloadAppParams r110 = (SystemDownloadAppParams) r12.L$0;
        c.b(r14);     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r10 = r18;
        ?? r22 = r19;
        r11 = r20;
        r16 = r21;
    L103:
        b r23 = (b) f.f(((f) r14).l());     // Catch: Throwable -> L16
        if (r23 != null) goto L107;
        j.p("[AI_Intent] [DownloadApp] resultCh.receive() return null, sid=" + ((String) r11.element) + ", appName=" + r10);     // Catch: Throwable -> L16
        IntentResult r24 = new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);     // Catch: Throwable -> L16
        r11 = r11;
        r16 = r16;
    L120:
        r17 = Result.m35constructorimpl(r24);     // Catch: Throwable -> L16
        ?? r25 = r11;
        ?? r26 = r16;
    L124:
        if (Result.m41isFailureimpl(r17) == false) goto L126;
        Object r27 = null;
    L127:
        IntentResult r28 = (IntentResult) r27;
        StringBuilder r29 = new StringBuilder();
        r29.append("[AI_Intent] [DownloadApp] result, sid=");
        r29.append((String) r25.element);
        r29.append(", appName=");
        r29.append(r110.getAppName());
        r29.append(", result code=");
        if (r28 == null) goto L130;
        Integer r30 = tf.a.c(r28.getRet());
    L131:
        r29.append(r30);
        r29.append(", details=");
        if (r28 == null) goto L134;
        String r34 = r28.getDetails();
    L135:
        r29.append(r34);
        j.n(r29.toString());
        if (r26.element == true) goto L142;
        if (r28 == null) goto L142;
        if (r28.getRet() == 0) goto L147;
        if (r28.getRet() == 4011) goto L147;
    L142:
        String r35 = (String) r25.element;
        if (r35 == null) goto L147;
        DownloadAppIntentState r36 = DownloadAppIntentState.f17875a;
        r12.L$0 = r17;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.L$4 = null;
        r12.L$5 = null;
        r12.L$6 = null;
        r12.L$7 = null;
        r12.label = 7;
        if (r36.d(r35, r12) != r15) goto L147;
        return r15;
    L134:
        r34 = null;
        goto L135
    L130:
        r30 = null;
        goto L131
    L126:
        r27 = r17;
        goto L127
    L107:
        j.n("[AI_Intent] [DownloadApp] resultCh received, sid=" + ((String) r11.element) + ", appName=" + r10 + ", result=" + r23);     // Catch: Throwable -> L16
        r16.element = r23.a();     // Catch: Throwable -> L16
        String r111 = r22.tts(r23);     // Catch: Throwable -> L16
        if ((r23 instanceof b.d) == false) goto L111;
        int r112 = 1;
    L114:
        r24 = new IntentResult(r112, null, null, r111, false, false, 0, null, null, null, 1014, null);     // Catch: Throwable -> L16
        r11 = r11;
        r16 = r16;
        goto L120
    L111:
        if (r23.a() == true) goto L113;
        j.n("[AI_Intent] [MultiRound] [DownloadApp] sid=" + ((String) r11.element) + ", ret=4011");     // Catch: Throwable -> L16
        r112 = 4011;
        goto L114
    L113:
        r112 = 0;
        goto L114
    L18:
        String r37 = (String) r12.L$4;
        DownloadAppIntentImpl r38 = (DownloadAppIntentImpl) r12.L$3;
        Ref$ObjectRef r39 = (Ref$ObjectRef) r12.L$2;
        Ref$BooleanRef r40 = (Ref$BooleanRef) r12.L$1;
        r110 = (SystemDownloadAppParams) r12.L$0;
        c.b(r14);     // Catch: Throwable -> L16
        String r41 = r37;
        ?? r42 = r38;
        Ref$ObjectRef r43 = r39;
        ?? r44 = r40;
    L98:
        Channel r45 = (Channel) r14;     // Catch: Throwable -> L16
        if (r45 == null) goto L116;
        DownloadAppIntentImpl$onIntent$r$1$r$1 r46 = new DownloadAppIntentImpl$onIntent$r$1$r$1(r43, r45, null);     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r12.L$0 = r110;     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r12.L$1 = r44;     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r12.L$2 = r43;     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r12.L$3 = r42;     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r12.L$4 = r41;     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r12.label = 6;     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r14 = TimeoutKt.c(300000, r46, r12);     // Catch: Throwable -> L16 TimeoutCancellationException -> L115
        r10 = r41;
        r22 = r42;
        r11 = r43;
        r16 = r44;
        if (r14 != r15) goto L103;
        return r15;
    L116:
        j.b("[AI_Intent] [DownloadApp] resultCh is null, sid=" + ((String) r43.element));     // Catch: Throwable -> L16
        r24 = new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);     // Catch: Throwable -> L16
        r11 = r43;
        r16 = r44;
        goto L120
    L21:
        Ref$ObjectRef r47 = (Ref$ObjectRef) r12.L$7;
        String r48 = (String) r12.L$6;
        Ref$BooleanRef r49 = (Ref$BooleanRef) r12.L$5;
        DownloadAppIntentImpl r50 = (DownloadAppIntentImpl) r12.L$4;
        Ref$ObjectRef r113 = (Ref$ObjectRef) r12.L$3;
        Ref$BooleanRef r114 = (Ref$BooleanRef) r12.L$2;
        DispatchContext r115 = (DispatchContext) r12.L$1;
        SystemDownloadAppParams r116 = (SystemDownloadAppParams) r12.L$0;
        c.b(r14);     // Catch: Throwable -> L24
        ?? r51 = r50;
        ?? r117 = r114;
        ?? r118 = r115;
    L76:
        String r52 = (String) r14;     // Catch: Throwable -> L24
        Ref$ObjectRef r53 = r47;
        ?? r54 = r51;
        ?? r55 = r52;
        ?? r119 = r117;
        ?? r120 = r118;
    L77:
        r53.element = r55;     // Catch: Throwable -> L24
        Boolean r56 = r116.isSystemApp();     // Catch: Throwable -> L24
        if (r56 == null) goto L80;
        boolean r57 = r56.booleanValue();     // Catch: Throwable -> L24
    L82:
        String r58 = "";
        if (r49.element == false) goto L90;
        Context r59 = r120.getContext();     // Catch: Throwable -> L24
        j.o("[AI_Intent] [DownloadApp] goto app search page, sid=" + ((String) r113.element) + ", appName=" + r48 + ", isSystemApp=" + r116.isSystemApp() + ", proceed=" + r116.getProceed());     // Catch: Throwable -> L24
        String r60 = (String) r113.element;     // Catch: Throwable -> L24
        if (r60 != null) goto L87;
        r60 = "";
    L87:
        r54.routeSearchApp(r59, r48, r57, r60);     // Catch: Throwable -> L24
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == true) goto L90;
        j.p("[AI_Intent] [DownloadApp] privacy not agree, sid=" + ((String) r113.element) + ", appName=" + r48);     // Catch: Throwable -> L24
        r24 = new IntentResult(201, null, null, null, false, false, 0, null, null, null, 1022, null);     // Catch: Throwable -> L24
        r11 = r113;
        r16 = r119;
        r110 = r116;
    L90:
        DownloadAppIntentState r61 = DownloadAppIntentState.f17875a;     // Catch: Throwable -> L24
        String r62 = (String) r113.element;     // Catch: Throwable -> L24
        if (r62 == null) goto L94;
        r58 = r62;
    L94:
        r12.L$0 = r116;     // Catch: Throwable -> L24
        r12.L$1 = r119;     // Catch: Throwable -> L24
        r12.L$2 = r113;     // Catch: Throwable -> L24
        r12.L$3 = r54;     // Catch: Throwable -> L24
        r12.L$4 = r48;     // Catch: Throwable -> L24
        r12.L$5 = null;     // Catch: Throwable -> L24
        r12.L$6 = null;     // Catch: Throwable -> L24
        r12.L$7 = null;     // Catch: Throwable -> L24
        r12.label = 5;     // Catch: Throwable -> L24
        r14 = r61.f(r58, r12);     // Catch: Throwable -> L24
        if (r14 != r15) goto L97;
        return r15;
    L97:
        r43 = r113;
        r44 = r119;
        r110 = r116;
        String r210 = r48;
        r42 = r54;
        r41 = r210;
        goto L98
    L80:
        r57 = false;
        goto L82
    L26:
        Ref$ObjectRef r63 = (Ref$ObjectRef) r12.L$7;
        r48 = (String) r12.L$6;
        r49 = (Ref$BooleanRef) r12.L$5;
        DownloadAppIntentImpl r64 = (DownloadAppIntentImpl) r12.L$4;
        r113 = (Ref$ObjectRef) r12.L$3;
        Ref$BooleanRef r121 = (Ref$BooleanRef) r12.L$2;
        DispatchContext r122 = (DispatchContext) r12.L$1;
        r116 = (SystemDownloadAppParams) r12.L$0;
        c.b(r14);     // Catch: Throwable -> L24
        Object r211 = r14;
        r53 = r63;
        ?? r65 = r64;
        ?? r123 = r121;
        ?? r124 = r122;
    L70:
        String r66 = (String) r211;     // Catch: Throwable -> L24
        r54 = r65;
        r55 = r66;
        r119 = r123;
        r120 = r124;
        if (r66 != null) goto L77;
        j.p("[AI_Intent] [DownloadApp] err, params.proceed=true, but currentSessionId is null，create new session");     // Catch: Throwable -> L24
        r49.element = true;     // Catch: Throwable -> L24
        ?? r67 = DownloadAppIntentState.f17875a;     // Catch: Throwable -> L24
        r12.L$0 = r116;     // Catch: Throwable -> L24
        r12.L$1 = r124;     // Catch: Throwable -> L24
        r12.L$2 = r123;     // Catch: Throwable -> L24
        r12.L$3 = r113;     // Catch: Throwable -> L24
        r12.L$4 = r65;     // Catch: Throwable -> L24
        r12.L$5 = r49;     // Catch: Throwable -> L24
        r12.L$6 = r48;     // Catch: Throwable -> L24
        r12.L$7 = r53;     // Catch: Throwable -> L24
        r12.label = 4;     // Catch: Throwable -> L24
        Object r68 = r67.g(r124, r12);     // Catch: Throwable -> L24
        if (r68 != r15) goto L75;
        return r15;
    L75:
        r51 = r65;
        r47 = r53;
        r14 = r68;
        r117 = r123;
        r118 = r124;
        goto L76
    L30:
        Ref$ObjectRef r69 = (Ref$ObjectRef) r12.L$7;
        r48 = (String) r12.L$6;
        r49 = (Ref$BooleanRef) r12.L$5;
        DownloadAppIntentImpl r70 = (DownloadAppIntentImpl) r12.L$4;
        r113 = (Ref$ObjectRef) r12.L$3;
        Ref$BooleanRef r125 = (Ref$BooleanRef) r12.L$2;
        DispatchContext r126 = (DispatchContext) r12.L$1;
        r116 = (SystemDownloadAppParams) r12.L$0;
        c.b(r14);     // Catch: Throwable -> L24
        Object r212 = r14;
        r53 = r69;
        ?? r71 = r70;
        ?? r127 = r125;
        ?? r128 = r126;
    L62:
        r54 = r71;
        r55 = (String) r212;     // Catch: Throwable -> L24
        r119 = r127;
        r120 = r128;
        goto L77
    L34:
        DownloadAppIntentImpl r72 = (DownloadAppIntentImpl) r12.L$0;
        c.b(r14);
    L42:
        IntentResult r73 = (IntentResult) r14;
        if (r73 != null) goto L153;
    L45:
        j.p("[AI_Intent] [DownloadApp][V2] handler is null");
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    L153:
        return r73;
    L35:
        c.b(r14);
        if (r31.getOperateType() == null) goto L47;
        ?? r74 = (DownloadAppIntentV2Handler) h9.a.f20383a.a(DownloadAppIntentV2Handler.class);
        if (r74 == 0) goto L45;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r74.handle(r31, r11, r12);
        if (r14 != r15) goto L42;
        return r15;
    L47:
        r16 = new Ref$BooleanRef();
        r16.element = true;
        r53 = new Ref$ObjectRef();
        Result.a r129 = Result.Companion;     // Catch: Throwable -> L64
        String r130 = r31.getAppName();     // Catch: Throwable -> L64
        if (r130 != null) goto L51;
    L118:
        j.p("[AI_Intent] [[DownloadApp] invalid appName=" + r31.getAppName() + ", sid=" + ((String) r53.element));     // Catch: Throwable -> L64
        r24 = new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);     // Catch: Throwable -> L64
        r110 = r31;
        r11 = r53;
        r16 = r16;
        goto L120
    L51:
        if (o.r(r130) == false) goto L54;
        r130 = null;
    L54:
        if (r130 == null) goto L118;
        Ref$BooleanRef r131 = new Ref$BooleanRef();     // Catch: Throwable -> L64
        boolean r132 = q.b(r31.getProceed(), tf.a.a(true));     // Catch: Throwable -> L64
        r131.element = !r132;     // Catch: Throwable -> L64
        if (r132 == true) goto L66;
        ?? r133 = DownloadAppIntentState.f17875a;     // Catch: Throwable -> L64
        r12.L$0 = r31;     // Catch: Throwable -> L64
        r12.L$1 = r11;     // Catch: Throwable -> L64
        r12.L$2 = r16;     // Catch: Throwable -> L64
        r12.L$3 = r53;     // Catch: Throwable -> L64
        r12.L$4 = r10;     // Catch: Throwable -> L64
        r12.L$5 = r131;     // Catch: Throwable -> L64
        r12.L$6 = r130;     // Catch: Throwable -> L64
        r12.L$7 = r53;     // Catch: Throwable -> L64
        r12.label = 2;     // Catch: Throwable -> L64
        Object r134 = r133.g(r11, r12);     // Catch: Throwable -> L64
        if (r134 != r15) goto L61;
        return r15;
    L61:
        r116 = r31;
        r48 = r130;
        r113 = r53;
        r212 = r134;
        r128 = r11;
        r49 = r131;
        r127 = r16;
        r71 = r10;
        goto L62
    L66:
        DownloadAppIntentState r135 = DownloadAppIntentState.f17875a;     // Catch: Throwable -> L64
        r12.L$0 = r31;     // Catch: Throwable -> L64
        r12.L$1 = r11;     // Catch: Throwable -> L64
        r12.L$2 = r16;     // Catch: Throwable -> L64
        r12.L$3 = r53;     // Catch: Throwable -> L64
        r12.L$4 = r10;     // Catch: Throwable -> L64
        r12.L$5 = r131;     // Catch: Throwable -> L64
        r12.L$6 = r130;     // Catch: Throwable -> L64
        r12.L$7 = r53;     // Catch: Throwable -> L64
        r12.label = 3;     // Catch: Throwable -> L64
        Object r136 = r135.c(r12);     // Catch: Throwable -> L64
        if (r136 != r15) goto L69;
        return r15;
    L69:
        r116 = r31;
        r48 = r130;
        r113 = r53;
        r211 = r136;
        r124 = r11;
        r49 = r131;
        r123 = r16;
        r65 = r10;
    L64:
        th = th;
        r110 = r31;
        r11 = r53;
    L122:
        Result.a r75 = Result.Companion;
        r17 = Result.m35constructorimpl(c.a(th));
        r25 = r11;
        r26 = r16;
        goto L124
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L115:
        j.p("[AI_Intent] [DownloadApp] timeout resultCh.receive(), sid=" + ((String) r11.element) + ", appName=" + r10);     // Catch: Throwable -> L16
        r24 = new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);     // Catch: Throwable -> L16
        r11 = r11;
        r16 = r16;
    L16:
        th = th;
    L24:
        th = th;
        r11 = r12;
        r16 = r13;
        r110 = r15;
    L7:
        r12 = new C04521(r10, r33);
        goto L8
    }

    private final void routeSearchApp(Context r10, String r11, boolean r12, String r13) {
        Intent r14 = new Intent();
        r14.setAction("android.intent.action.VIEW");
        Uri r15 = Uri.parse("market://search?q=" + r11 + "&isid=" + r13);
        q.f(r15, "parse(this)");
        Uri.Builder r16 = r15.buildUpon();
        if (r12 == false) goto L5;
        r16.appendQueryParameter("s", "1");
    L5:
        r14.setData(r16.build());
        r14.setPackage(r10.getPackageName());
        r14.setFlags(268468224);
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == true) goto L8;
        r14.putExtra(JumpActivity.ARG_KEEP_FULLSCREEN_FOR_PRIVACY, true);
    L8:
        r10.startActivity(r14);
    }

    private final String tts(b r10) {
        if ((r10 instanceof b.C0214b) == false) goto L6;
        Integer r11 = Integer.valueOf(R$string.APP_DOWNLOAD_DOWNLOADING);
    L20:
        if (r11 == null) goto L25;
        BaseApplication r12 = BaseApplication.c();
        q.f(r12, "getContext(...)");
        return r12.getString(r11.intValue());
    L25:
        return null;
    L6:
        if ((r10 instanceof b.e) == false) goto L9;
        r11 = Integer.valueOf(R$string.APP_DOWNLOAD_SEARCHED);
        goto L20
    L9:
        if ((r10 instanceof b.a) == false) goto L12;
        r11 = Integer.valueOf(R$string.APP_DOWNLOAD_CELLULAR_DATA_WARNING);
        goto L20
    L12:
        if ((r10 instanceof b.c) == false) goto L18;
        if (((b.c) r10).b() == false) goto L16;
    L15:
        r11 = null;
        goto L20
    L16:
        r11 = Integer.valueOf(R$string.APP_DOWNLOAD_SEARCHED);
        goto L20
    L18:
        if ((r10 instanceof b.d) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemDownloadAppIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r10, DispatchContext r11, Continuation<? super IntentResult<AppInfoEntity[]>> r12) {
        return doAction((SystemDownloadAppParams) r10, r11, r12);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemDownloadAppIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemDownloadAppIntent
    @Nullable
    public Object doAction(@NotNull SystemDownloadAppParams r17, @NotNull DispatchContext r18, @NotNull Continuation<? super IntentResult<AppInfoEntity[]>> r19) {
        DownloadAppIntentImpl r10 = this;
        if ((r19 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r11 = (AnonymousClass1) r19;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L26;
        if (r15 == 1) goto L25;
        if (r15 == 2) goto L20;
        if (r15 != 3) goto L19;
        Deferred<IntentResult<AppInfoEntity[]>> r16 = (Deferred) r11.L$1;
        SystemDownloadAppParams r20 = (SystemDownloadAppParams) r11.L$0;
        c.b(r13);     // Catch: CancellationException -> L16
    L44:
        IntentResult r21 = (IntentResult) r13;     // Catch: CancellationException -> L16
    L49:
        j.n("[AI_Intent] [DownloadApp] doAction result, appName=" + r20.getAppName() + ", result code=" + r21.getRet() + ", details=" + r21.getDetails());
        return r21;
    L16:
        e = e;
    L48:
        e.printStackTrace();
        r16.cancel(e);
        j.q("[AI_Intent] [DownloadApp] doAction waiting result, err, appName=" + r20.getAppName(), e);
        r21 = new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
        goto L49
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        Mutex r22 = (Mutex) r11.L$3;
        DispatchContext r23 = (DispatchContext) r11.L$2;
        SystemDownloadAppParams r24 = (SystemDownloadAppParams) r11.L$1;
        DownloadAppIntentImpl r25 = (DownloadAppIntentImpl) r11.L$0;
        c.b(r13);     // Catch: Throwable -> L23
    L35:
        DispatchContext r26 = r23;
        Mutex r27 = r22;
        SystemDownloadAppParams r28 = r24;
        r10 = r25;
    L38:
        Deferred<IntentResult<AppInfoEntity[]>> r29 = h.b(r10.scope, null, null, new DownloadAppIntentImpl$doAction$result$1$newDeferred$1(r10, r28, r26, null), 3, null);     // Catch: Throwable -> L36
        r10.deferredResult = r29;     // Catch: Throwable -> L36
        r27.unlock(null);
        j.n("[AI_Intent] [DownloadApp] doAction waiting result, appName=" + r28.getAppName());     // Catch: CancellationException -> L46
        r11.L$0 = r28;     // Catch: CancellationException -> L46
        r11.L$1 = r29;     // Catch: CancellationException -> L46
        r11.L$2 = null;     // Catch: CancellationException -> L46
        r11.L$3 = null;     // Catch: CancellationException -> L46
        r11.label = 3;     // Catch: CancellationException -> L46
        r13 = r29.await(r11);     // Catch: CancellationException -> L46
        if (r13 != r14) goto L43;
        return r14;
    L43:
        r20 = r28;
        r16 = r29;
    L46:
        e = e;
        r20 = r28;
        r16 = r29;
    L36:
        Throwable th = th;
        r22 = r27;
    L51:
        r22.unlock(null);
        throw th;
    L23:
        th = th;
        goto L51
    L25:
        Mutex r30 = (Mutex) r11.L$3;
        DispatchContext r31 = (DispatchContext) r11.L$2;
        SystemDownloadAppParams r32 = (SystemDownloadAppParams) r11.L$1;
        DownloadAppIntentImpl r33 = (DownloadAppIntentImpl) r11.L$0;
        c.b(r13);
        r27 = r30;
        r10 = r33;
        r26 = r31;
        r28 = r32;
    L59:
        Deferred<IntentResult<AppInfoEntity[]>> r34 = r10.deferredResult;     // Catch: Throwable -> L36
        if (r34 == null) goto L38;
        r11.L$0 = r10;     // Catch: Throwable -> L36
        r11.L$1 = r28;     // Catch: Throwable -> L36
        r11.L$2 = r26;     // Catch: Throwable -> L36
        r11.L$3 = r27;     // Catch: Throwable -> L36
        r11.label = 2;     // Catch: Throwable -> L36
        if (h1.e(r34, r11) != r14) goto L34;
        return r14;
    L34:
        r25 = r10;
        r24 = r28;
        r23 = r26;
        r22 = r27;
        goto L35
    L26:
        c.b(r13);
        j.n("[AI_Intent] [DownloadApp] doAction invoke, appName=" + r17.getAppName() + ", proceed=" + r17.getProceed() + ", operateType=" + r17.getOperateType() + ", updateRange=" + r17.getUpdateRange() + ", isSystemApp=" + r17.isSystemApp());
        r27 = r10.mutex;
        r11.L$0 = r10;
        r28 = r17;
        r11.L$1 = r28;
        r26 = r18;
        r11.L$2 = r26;
        r11.L$3 = r27;
        r11.label = 1;
        if (r27.lock(null, r11) != r14) goto L59;
        return r14;
    L7:
        r11 = new AnonymousClass1(r10, r19);
        goto L8
    }
}
