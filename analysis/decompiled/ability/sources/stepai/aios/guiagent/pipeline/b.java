package stepai.aios.guiagent.pipeline;

import A4.h;
import Ba.c;
import Ba.d;
import C7.r;
import Ca.C0203b;
import D7.v;
import D7.w;
import H4.o;
import N9.j;
import android.content.Context;
import j9.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1724q;
import m9.InterfaceC1723p;
import o9.InterfaceC1779e;
import s9.C1923c;
import stepai.aios.guiagent.config.RuntimeConfig;
import stepai.aios.guiagent.llm.Message;
import stepai.aios.guiagent.llm.MessageContent;
import stepai.aios.guiagent.model.SessionState;
import stepai.aios.guiagent.model.StepExecutionState;
import stepai.aios.guiagent.takeover.TakeoverErrorType;
import stepai.aios.guiagent.takeover.TakeoverException;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiOptions;
import stepai.aios.guiexecutor.input.UserInputManager;
import wa.C2110a;
import xa.InterfaceC2124a;
import z2.l;
import za.e;
import za.g;
import za.i;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6110a;
    public RuntimeConfig b;
    public final C2110a c;
    public final UserInputManager d;
    public final a e;
    public final C0203b f;
    public final stepai.aios.guiagent.session.a g;
    public final stepai.aios.guiagent.event.a h;
    public final c i;

    /* renamed from: j, reason: collision with root package name */
    public final d f6111j;
    public final ConcurrentHashMap k;
    public final C1923c l;
    public final stepai.aios.guiagent.takeover.a m;
    public final a n;
    public final stepai.aios.guiagent.takeover.a o;
    public final stepai.aios.guiagent.takeover.b p;

    public b(Context context, RuntimeConfig runtimeConfig, C2110a c2110a, UserInputManager userInputManager, a aVar, C0203b c0203b) {
        k.f(runtimeConfig, "runtimeConfig");
        this.f6110a = context;
        this.b = runtimeConfig;
        this.c = c2110a;
        this.d = userInputManager;
        this.e = aVar;
        this.f = c0203b;
        stepai.aios.guiagent.session.a aVar2 = new stepai.aios.guiagent.session.a(runtimeConfig.getSessionConfig());
        this.g = aVar2;
        this.h = new stepai.aios.guiagent.event.a(aVar2, c2110a);
        this.i = new c(context);
        this.f6111j = new d();
        this.k = new ConcurrentHashMap();
        this.l = AbstractC1683A.b(l.H(AbstractC1683A.c(), AbstractC1691I.f5315a));
        this.m = new stepai.aios.guiagent.takeover.a();
        a aVar3 = new a(this);
        this.n = aVar3;
        this.o = new stepai.aios.guiagent.takeover.a(aVar2, aVar3);
        this.p = new stepai.aios.guiagent.takeover.b(aVar2, aVar3);
        j.H("ExecutionPipeline initialized", "GuiExecutionPipeline");
    }

    public static void C(e eVar, String str) throws TakeoverException {
        if (eVar.e == SessionState.f) {
            return;
        }
        throw new TakeoverException(TakeoverErrorType.b, "会话不在接管状态（" + str + "）：" + eVar.e, null);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:199:0x0619 -> B:83:0x0326). Please report as a decompilation issue!!! */
    public static java.lang.Object J(stepai.aios.guiagent.pipeline.b r29, java.lang.String r30, kotlin.coroutines.jvm.internal.ContinuationImpl r31) {
        /*
            Method dump skipped, instructions count: 3650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.J(stepai.aios.guiagent.pipeline.b, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0117, code lost:
    
        if (r0.i(r1, r7) != r8) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0108 A[Catch: Exception -> 0x0047, PHI: r0 r1
      0x0108: PHI (r0v10 stepai.aios.guiagent.pipeline.b) = (r0v9 stepai.aios.guiagent.pipeline.b), (r0v17 stepai.aios.guiagent.pipeline.b) binds: [B:53:0x0105, B:24:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r1v4 java.lang.String) = (r1v3 java.lang.String), (r1v11 java.lang.String) binds: [B:53:0x0105, B:24:0x0056] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x0047, blocks: (B:17:0x0042, B:58:0x011a, B:24:0x0056, B:55:0x0108, B:52:0x00f7, B:32:0x0073, B:48:0x00cf, B:35:0x0079, B:38:0x0081, B:40:0x00a5, B:43:0x00b6, B:45:0x00be, B:49:0x00df), top: B:65:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object K(stepai.aios.guiagent.pipeline.b r16, java.lang.String r17, java.lang.String r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.K(stepai.aios.guiagent.pipeline.b, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0138, code lost:
    
        if (r4.c(r2, r0, r12) != r5) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017e, code lost:
    
        if (r3 != r5) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
    
        if (r3 != r5) goto L91;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4 A[Catch: Exception -> 0x00e6, TakeoverException -> 0x00ec, TryCatch #7 {TakeoverException -> 0x00ec, Exception -> 0x00e6, blocks: (B:42:0x00cb, B:44:0x00d4, B:52:0x00f2), top: B:103:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f2 A[Catch: Exception -> 0x00e6, TakeoverException -> 0x00ec, TRY_LEAVE, TryCatch #7 {TakeoverException -> 0x00ec, Exception -> 0x00e6, blocks: (B:42:0x00cb, B:44:0x00d4, B:52:0x00f2), top: B:103:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Exception, java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType, stepai.aios.guiagent.pipeline.b] */
    /* JADX WARN: Type inference failed for: r3v18, types: [stepai.aios.guiagent.takeover.b] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Exception, java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType] */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Exception, java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType, stepai.aios.guiagent.pipeline.b] */
    /* JADX WARN: Type inference failed for: r4v1, types: [stepai.aios.guiagent.takeover.b] */
    /* JADX WARN: Type inference failed for: r4v3, types: [stepai.aios.guiagent.takeover.b] */
    /* JADX WARN: Type inference failed for: r4v5, types: [stepai.aios.guiagent.takeover.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object M(stepai.aios.guiagent.pipeline.b r23, java.lang.String r24, java.lang.String r25, stepai.aios.guiagent.model.TakeoverReasonType r26, kotlin.coroutines.jvm.internal.ContinuationImpl r27) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.M(stepai.aios.guiagent.pipeline.b, java.lang.String, java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final ArrayList a(b bVar, List list, String str) {
        String strM = B7.a.m("**进行手机截图时失败，失败原因或错误信息： ", str, "**");
        List<Message> list2 = list;
        ArrayList arrayList = new ArrayList(w.c0(list2, 10));
        for (Message messageCopy$default : list2) {
            List<MessageContent> content = messageCopy$default.getContent();
            if (!(content instanceof Collection) || !content.isEmpty()) {
                for (MessageContent messageContent : content) {
                    if ((messageContent instanceof MessageContent.ImageBase64) || (messageContent instanceof MessageContent.Image)) {
                        messageCopy$default = Message.copy$default(messageCopy$default, null, v.R0(messageCopy$default.getContent(), new MessageContent.Text(strM)), null, null, null, 0L, 61, null);
                        break;
                    }
                }
            }
            arrayList.add(messageCopy$default);
        }
        return arrayList;
    }

    public static final ArrayList b(b bVar, List list, String str, String str2) {
        List<Message> list2 = list;
        ArrayList arrayList = new ArrayList(w.c0(list2, 10));
        for (Message messageCopy$default : list2) {
            List<MessageContent> content = messageCopy$default.getContent();
            ArrayList arrayList2 = new ArrayList(w.c0(content, 10));
            for (Object image : content) {
                MessageContent.ImageBase64 imageBase64 = image instanceof MessageContent.ImageBase64 ? (MessageContent.ImageBase64) image : null;
                if (imageBase64 != null && (str == null || m.s0(str) || k.b(imageBase64.getBase64(), str))) {
                    image = new MessageContent.Image(str2);
                }
                arrayList2.add(image);
            }
            if (!arrayList2.equals(messageCopy$default.getContent())) {
                messageCopy$default = Message.copy$default(messageCopy$default, null, arrayList2, null, null, null, 0L, 61, null);
            }
            arrayList.add(messageCopy$default);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0203 A[Catch: Exception -> 0x0226, CancellationException -> 0x022b, TRY_LEAVE, TryCatch #20 {CancellationException -> 0x022b, Exception -> 0x0226, blocks: (B:107:0x01ff, B:109:0x0203), top: B:200:0x01ff }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0230 A[Catch: Exception -> 0x025a, CancellationException -> 0x025d, TryCatch #25 {CancellationException -> 0x025d, Exception -> 0x025a, blocks: (B:138:0x02a6, B:140:0x02aa, B:143:0x02b2, B:146:0x02ba, B:148:0x02de, B:147:0x02bf, B:142:0x02ae, B:135:0x028e, B:132:0x0277, B:129:0x0260, B:111:0x021e, B:118:0x0230, B:120:0x0236, B:122:0x023e, B:151:0x02f4), top: B:193:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0260 A[Catch: Exception -> 0x025a, CancellationException -> 0x025d, PHI: r2 r3 r6 r10
      0x0260: PHI (r2v29 Aa.d) = (r2v20 Aa.d), (r2v20 Aa.d), (r2v31 Aa.d) binds: [B:121:0x023c, B:123:0x0256, B:41:0x00cf] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r3v33 m9.p) = (r3v29 m9.p), (r3v29 m9.p), (r3v34 m9.p) binds: [B:121:0x023c, B:123:0x0256, B:41:0x00cf] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r6v27 ??) = (r6v47 ??), (r6v48 ??), (r6v28 ??) binds: [B:121:0x023c, B:123:0x0256, B:41:0x00cf] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r10v21 java.lang.String) = (r10v39 java.lang.String), (r10v40 java.lang.String), (r10v22 java.lang.String) binds: [B:121:0x023c, B:123:0x0256, B:41:0x00cf] A[DONT_GENERATE, DONT_INLINE], TryCatch #25 {CancellationException -> 0x025d, Exception -> 0x025a, blocks: (B:138:0x02a6, B:140:0x02aa, B:143:0x02b2, B:146:0x02ba, B:148:0x02de, B:147:0x02bf, B:142:0x02ae, B:135:0x028e, B:132:0x0277, B:129:0x0260, B:111:0x021e, B:118:0x0230, B:120:0x0236, B:122:0x023e, B:151:0x02f4), top: B:193:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0277 A[Catch: Exception -> 0x025a, CancellationException -> 0x025d, PHI: r2 r3 r6 r10
      0x0277: PHI (r2v32 Aa.d) = (r2v29 Aa.d), (r2v34 Aa.d) binds: [B:130:0x0273, B:38:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x0277: PHI (r3v35 m9.p) = (r3v33 m9.p), (r3v36 m9.p) binds: [B:130:0x0273, B:38:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x0277: PHI (r6v29 ??) = (r6v46 ??), (r6v30 ??) binds: [B:130:0x0273, B:38:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x0277: PHI (r10v23 java.lang.String) = (r10v38 java.lang.String), (r10v24 java.lang.String) binds: [B:130:0x0273, B:38:0x00bf] A[DONT_GENERATE, DONT_INLINE], TryCatch #25 {CancellationException -> 0x025d, Exception -> 0x025a, blocks: (B:138:0x02a6, B:140:0x02aa, B:143:0x02b2, B:146:0x02ba, B:148:0x02de, B:147:0x02bf, B:142:0x02ae, B:135:0x028e, B:132:0x0277, B:129:0x0260, B:111:0x021e, B:118:0x0230, B:120:0x0236, B:122:0x023e, B:151:0x02f4), top: B:193:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x028e A[Catch: Exception -> 0x025a, CancellationException -> 0x025d, PHI: r2 r3 r6 r10
      0x028e: PHI (r2v35 Aa.d) = (r2v32 Aa.d), (r2v37 Aa.d) binds: [B:133:0x028a, B:35:0x00af] A[DONT_GENERATE, DONT_INLINE]
      0x028e: PHI (r3v37 m9.p) = (r3v35 m9.p), (r3v38 m9.p) binds: [B:133:0x028a, B:35:0x00af] A[DONT_GENERATE, DONT_INLINE]
      0x028e: PHI (r6v31 ??) = (r6v45 ??), (r6v32 ??) binds: [B:133:0x028a, B:35:0x00af] A[DONT_GENERATE, DONT_INLINE]
      0x028e: PHI (r10v25 java.lang.String) = (r10v37 java.lang.String), (r10v26 java.lang.String) binds: [B:133:0x028a, B:35:0x00af] A[DONT_GENERATE, DONT_INLINE], TryCatch #25 {CancellationException -> 0x025d, Exception -> 0x025a, blocks: (B:138:0x02a6, B:140:0x02aa, B:143:0x02b2, B:146:0x02ba, B:148:0x02de, B:147:0x02bf, B:142:0x02ae, B:135:0x028e, B:132:0x0277, B:129:0x0260, B:111:0x021e, B:118:0x0230, B:120:0x0236, B:122:0x023e, B:151:0x02f4), top: B:193:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02a6 A[Catch: Exception -> 0x025a, CancellationException -> 0x025d, PHI: r0 r2 r3 r6 r10
      0x02a6: PHI (r0v66 java.lang.Object) = (r0v65 java.lang.Object), (r0v1 java.lang.Object) binds: [B:136:0x02a2, B:27:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x02a6: PHI (r2v38 Aa.d) = (r2v35 Aa.d), (r2v40 Aa.d) binds: [B:136:0x02a2, B:27:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x02a6: PHI (r3v39 m9.p) = (r3v37 m9.p), (r3v40 m9.p) binds: [B:136:0x02a2, B:27:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x02a6: PHI (r6v33 ??) = (r6v44 ??), (r6v34 ??) binds: [B:136:0x02a2, B:27:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x02a6: PHI (r10v27 java.lang.String) = (r10v36 java.lang.String), (r10v28 java.lang.String) binds: [B:136:0x02a2, B:27:0x0092] A[DONT_GENERATE, DONT_INLINE], TryCatch #25 {CancellationException -> 0x025d, Exception -> 0x025a, blocks: (B:138:0x02a6, B:140:0x02aa, B:143:0x02b2, B:146:0x02ba, B:148:0x02de, B:147:0x02bf, B:142:0x02ae, B:135:0x028e, B:132:0x0277, B:129:0x0260, B:111:0x021e, B:118:0x0230, B:120:0x0236, B:122:0x023e, B:151:0x02f4), top: B:193:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ae A[Catch: Exception -> 0x025a, CancellationException -> 0x025d, TryCatch #25 {CancellationException -> 0x025d, Exception -> 0x025a, blocks: (B:138:0x02a6, B:140:0x02aa, B:143:0x02b2, B:146:0x02ba, B:148:0x02de, B:147:0x02bf, B:142:0x02ae, B:135:0x028e, B:132:0x0277, B:129:0x0260, B:111:0x021e, B:118:0x0230, B:120:0x0236, B:122:0x023e, B:151:0x02f4), top: B:193:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0162 A[Catch: Exception -> 0x0125, CancellationException -> 0x0128, TRY_ENTER, TRY_LEAVE, TryCatch #12 {CancellationException -> 0x0128, blocks: (B:62:0x0121, B:81:0x015e, B:83:0x0162, B:85:0x0166), top: B:188:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0166 A[Catch: CancellationException -> 0x0128, Exception -> 0x031d, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x031d, blocks: (B:81:0x015e, B:85:0x0166), top: B:185:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c8  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v27, types: [Ea.a, za.e] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29, types: [Ea.a, za.e] */
    /* JADX WARN: Type inference failed for: r6v3, types: [Ea.a, m9.p, za.e] */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31, types: [Ea.a, za.e] */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33, types: [Ea.a, java.lang.Object, za.e] */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v5, types: [Ea.a, H7.c, java.lang.String, m9.p, za.e] */
    /* JADX WARN: Type inference failed for: r6v6, types: [Ea.a, H7.c, java.lang.Object, java.lang.String, m9.p, za.e] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(stepai.aios.guiagent.pipeline.b r30, java.lang.String r31, Ea.a r32, m9.C1724q r33, kotlin.coroutines.jvm.internal.ContinuationImpl r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.c(stepai.aios.guiagent.pipeline.b, java.lang.String, Ea.a, m9.q, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static GuiCommand d(GuiCommand guiCommand, e eVar) {
        String str = eVar.f7004a;
        Integer num = eVar.d;
        int iIntValue = num != null ? num.intValue() : 0;
        Object obj = guiCommand.getMetadata().get("sessionId");
        return GuiCommand.copy$default(guiCommand, null, null, null, null, guiCommand.getOptions().getDisplayId() == null ? GuiOptions.copy$default(guiCommand.getOptions(), 0L, 0, 0L, null, false, false, null, 0, Integer.valueOf(iIntValue), 255, null) : guiCommand.getOptions(), k.b(obj instanceof String ? (String) obj : null, str) ? guiCommand.getMetadata() : kotlin.collections.a.U(guiCommand.getMetadata(), new Pair("sessionId", str)), null, 79, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(InterfaceC1723p interfaceC1723p, boolean z10) {
        if (interfaceC1723p == 0 || ((kotlinx.coroutines.c) interfaceC1723p).r()) {
            return;
        }
        ((C1724q) interfaceC1723p).U(Boolean.valueOf(z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object n(stepai.aios.guiagent.pipeline.b r34, za.f r35, kotlin.coroutines.jvm.internal.ContinuationImpl r36) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.n(stepai.aios.guiagent.pipeline.b, za.f, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bb, code lost:
    
        if (r11.i(r12, r3) != r4) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1 A[Catch: Exception -> 0x0039, PHI: r11 r12
      0x00b1: PHI (r11v8 stepai.aios.guiagent.pipeline.b) = 
      (r11v0 stepai.aios.guiagent.pipeline.b)
      (r11v0 stepai.aios.guiagent.pipeline.b)
      (r11v12 stepai.aios.guiagent.pipeline.b)
     binds: [B:28:0x0074, B:37:0x00ae, B:21:0x0048] A[DONT_GENERATE, DONT_INLINE]
      0x00b1: PHI (r12v2 java.lang.String) = (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v5 java.lang.String) binds: [B:28:0x0074, B:37:0x00ae, B:21:0x0048] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0039, blocks: (B:14:0x0034, B:42:0x00be, B:21:0x0048, B:39:0x00b1, B:24:0x004e, B:34:0x008b, B:27:0x0055, B:29:0x0076, B:31:0x007e, B:36:0x009d), top: B:47:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object u(stepai.aios.guiagent.pipeline.b r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.u(stepai.aios.guiagent.pipeline.b, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x03a6, code lost:
    
        if (m9.AbstractC1683A.w(r2, r4, r6) != r7) goto L151;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0216 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0217 A[Catch: Exception -> 0x010f, CancellationException -> 0x0111, TRY_ENTER, TRY_LEAVE, TryCatch #13 {CancellationException -> 0x0111, Exception -> 0x010f, blocks: (B:91:0x01d5, B:93:0x01db, B:101:0x0217, B:84:0x01a3, B:86:0x01a7, B:88:0x01be, B:87:0x01ad, B:60:0x010a, B:79:0x0179, B:81:0x017d, B:139:0x0346, B:140:0x035a), top: B:159:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0297 A[Catch: Exception -> 0x0337, CancellationException -> 0x033b, TryCatch #11 {CancellationException -> 0x033b, Exception -> 0x0337, blocks: (B:109:0x026f, B:110:0x0277, B:112:0x0281, B:114:0x0297, B:115:0x02a2), top: B:161:0x026f }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02de A[Catch: Exception -> 0x0065, CancellationException -> 0x0068, TryCatch #8 {CancellationException -> 0x0068, Exception -> 0x0065, blocks: (B:16:0x0060, B:129:0x0330, B:23:0x0073, B:124:0x030a, B:26:0x0082, B:119:0x02d6, B:121:0x02de, B:126:0x0311, B:42:0x00c0, B:45:0x00cc, B:97:0x01ff), top: B:160:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0311 A[Catch: Exception -> 0x0065, CancellationException -> 0x0068, TryCatch #8 {CancellationException -> 0x0068, Exception -> 0x0065, blocks: (B:16:0x0060, B:129:0x0330, B:23:0x0073, B:124:0x030a, B:26:0x0082, B:119:0x02d6, B:121:0x02de, B:126:0x0311, B:42:0x00c0, B:45:0x00cc, B:97:0x01ff), top: B:160:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0346 A[Catch: Exception -> 0x010f, CancellationException -> 0x0111, TRY_ENTER, TryCatch #13 {CancellationException -> 0x0111, Exception -> 0x010f, blocks: (B:91:0x01d5, B:93:0x01db, B:101:0x0217, B:84:0x01a3, B:86:0x01a7, B:88:0x01be, B:87:0x01ad, B:60:0x010a, B:79:0x0179, B:81:0x017d, B:139:0x0346, B:140:0x035a), top: B:159:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x037e A[PHI: r0 r1 r2 r3
      0x037e: PHI (r0v13 'e' java.lang.Exception) = (r0v11 'e' java.lang.Exception), (r0v84 'e' java.lang.Exception) binds: [B:146:0x037b, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x037e: PHI (r1v13 java.lang.String) = (r1v9 java.lang.String), (r1v58 java.lang.String) binds: [B:146:0x037b, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x037e: PHI (r2v5 java.lang.Object) = (r2v3 java.lang.Object), (r2v1 java.lang.Object) binds: [B:146:0x037b, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x037e: PHI (r3v7 stepai.aios.guiagent.pipeline.b) = (r3v35 stepai.aios.guiagent.pipeline.b), (r3v36 stepai.aios.guiagent.pipeline.b) binds: [B:146:0x037b, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[LOOP:0: B:110:0x0277->B:166:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017d A[Catch: Exception -> 0x010f, CancellationException -> 0x0111, TryCatch #13 {CancellationException -> 0x0111, Exception -> 0x010f, blocks: (B:91:0x01d5, B:93:0x01db, B:101:0x0217, B:84:0x01a3, B:86:0x01a7, B:88:0x01be, B:87:0x01ad, B:60:0x010a, B:79:0x0179, B:81:0x017d, B:139:0x0346, B:140:0x035a), top: B:159:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a7 A[Catch: Exception -> 0x010f, CancellationException -> 0x0111, TryCatch #13 {CancellationException -> 0x0111, Exception -> 0x010f, blocks: (B:91:0x01d5, B:93:0x01db, B:101:0x0217, B:84:0x01a3, B:86:0x01a7, B:88:0x01be, B:87:0x01ad, B:60:0x010a, B:79:0x0179, B:81:0x017d, B:139:0x0346, B:140:0x035a), top: B:159:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ad A[Catch: Exception -> 0x010f, CancellationException -> 0x0111, TryCatch #13 {CancellationException -> 0x0111, Exception -> 0x010f, blocks: (B:91:0x01d5, B:93:0x01db, B:101:0x0217, B:84:0x01a3, B:86:0x01a7, B:88:0x01be, B:87:0x01ad, B:60:0x010a, B:79:0x0179, B:81:0x017d, B:139:0x0346, B:140:0x035a), top: B:159:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d5 A[Catch: Exception -> 0x010f, CancellationException -> 0x0111, PHI: r0 r1 r2 r5 r8
      0x01d5: PHI (r0v37 Aa.d) = (r0v34 Aa.d), (r0v40 Aa.d) binds: [B:89:0x01d1, B:49:0x00e0] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r1v32 java.lang.String) = (r1v28 java.lang.String), (r1v34 java.lang.String) binds: [B:89:0x01d1, B:49:0x00e0] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r2v26 Aa.e) = (r2v24 Aa.e), (r2v30 Aa.e) binds: [B:89:0x01d1, B:49:0x00e0] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r5v11 Ea.a) = (r5v8 Ea.a), (r5v14 Ea.a) binds: [B:89:0x01d1, B:49:0x00e0] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r8v10 stepai.aios.guiagent.pipeline.b) = (r8v13 stepai.aios.guiagent.pipeline.b), (r8v14 stepai.aios.guiagent.pipeline.b) binds: [B:89:0x01d1, B:49:0x00e0] A[DONT_GENERATE, DONT_INLINE], TryCatch #13 {CancellationException -> 0x0111, Exception -> 0x010f, blocks: (B:91:0x01d5, B:93:0x01db, B:101:0x0217, B:84:0x01a3, B:86:0x01a7, B:88:0x01be, B:87:0x01ad, B:60:0x010a, B:79:0x0179, B:81:0x017d, B:139:0x0346, B:140:0x035a), top: B:159:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01db A[Catch: Exception -> 0x010f, CancellationException -> 0x0111, TRY_LEAVE, TryCatch #13 {CancellationException -> 0x0111, Exception -> 0x010f, blocks: (B:91:0x01d5, B:93:0x01db, B:101:0x0217, B:84:0x01a3, B:86:0x01a7, B:88:0x01be, B:87:0x01ad, B:60:0x010a, B:79:0x0179, B:81:0x017d, B:139:0x0346, B:140:0x035a), top: B:159:0x010a }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [stepai.aios.guiagent.pipeline.b] */
    /* JADX WARN: Type inference failed for: r3v6, types: [stepai.aios.guiagent.pipeline.b] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15, types: [stepai.aios.guiagent.pipeline.b] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v7, types: [stepai.aios.guiagent.pipeline.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object z(stepai.aios.guiagent.pipeline.b r26, java.lang.String r27, kotlin.coroutines.jvm.internal.ContinuationImpl r28) throws stepai.aios.guiagent.takeover.TakeoverException {
        /*
            Method dump skipped, instructions count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.z(stepai.aios.guiagent.pipeline.b, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(Aa.e r14, za.e r15, Ea.a r16, kotlin.coroutines.jvm.internal.ContinuationImpl r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.A(Aa.e, za.e, Ea.a, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable B(java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$requireContextAndSession$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.pipeline.ExecutionPipeline$requireContextAndSession$1 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$requireContextAndSession$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$requireContextAndSession$1 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$requireContextAndSession$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            Aa.d r5 = r0.f6087a
            kotlin.b.b(r7)
            goto L49
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.b.b(r7)
            Aa.d r7 = r5.F(r6)
            if (r7 != 0) goto L3b
            goto L4d
        L3b:
            r0.f6087a = r7
            r0.d = r3
            java.lang.Object r5 = r5.D(r6, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            r4 = r7
            r7 = r5
            r5 = r4
        L49:
            za.e r7 = (za.e) r7
            if (r7 != 0) goto L4f
        L4d:
            r5 = 0
            return r5
        L4f:
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r5, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.B(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(java.lang.String r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSession$1
            if (r0 == 0) goto L13
            r0 = r6
            stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSession$1 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSession$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSession$1 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSession$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.lang.String r5 = r0.f6088a
            kotlin.b.b(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.b.b(r6)
            r0.f6088a = r5
            r0.d = r3
            stepai.aios.guiagent.session.a r4 = r4.g
            java.lang.Object r6 = r4.j(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            za.e r6 = (za.e) r6
            if (r6 != 0) goto L58
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "Session not found: "
            r4.<init>(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "GuiExecutionPipeline"
            N9.j.J(r4, r5)
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.D(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(java.lang.String r5, java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) throws stepai.aios.guiagent.takeover.TakeoverException {
        /*
            r4 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSessionInManualTakeover$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSessionInManualTakeover$1 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSessionInManualTakeover$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSessionInManualTakeover$1 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$requireSessionInManualTakeover$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.String r6 = r0.b
            java.lang.String r5 = r0.f6089a
            kotlin.b.b(r7)
            goto L45
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r7)
            r0.f6089a = r5
            r0.b = r6
            r0.e = r3
            stepai.aios.guiagent.session.a r4 = r4.g
            java.lang.Object r7 = r4.j(r5, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            za.e r7 = (za.e) r7
            if (r7 == 0) goto L4d
            C(r7, r6)
            return r7
        L4d:
            stepai.aios.guiagent.takeover.TakeoverException r4 = new stepai.aios.guiagent.takeover.TakeoverException
            stepai.aios.guiagent.takeover.TakeoverErrorType r6 = stepai.aios.guiagent.takeover.TakeoverErrorType.f6156a
            java.lang.String r7 = "会话不存在："
            java.lang.String r5 = B7.a.k(r7, r5)
            r7 = 0
            r4.<init>(r6, r5, r7)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.E(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Aa.d F(String str) {
        Aa.d dVar = (Aa.d) this.k.get(str);
        if (dVar == null) {
            j.J("Task context not found: " + str, "GuiExecutionPipeline");
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(java.lang.String r7, java.lang.String r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$rollbackToTakeover$1
            if (r0 == 0) goto L13
            r0 = r9
            stepai.aios.guiagent.pipeline.ExecutionPipeline$rollbackToTakeover$1 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$rollbackToTakeover$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$rollbackToTakeover$1 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$rollbackToTakeover$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.e
            C7.r r3 = C7.r.f317a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L40
            if (r2 == r5) goto L38
            if (r2 != r4) goto L30
            java.lang.String r7 = r0.f6090a
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L2e
            return r3
        L2e:
            r6 = move-exception
            goto L82
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.String r8 = r0.b
            java.lang.String r7 = r0.f6090a
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L2e
            goto L59
        L40:
            kotlin.b.b(r9)
            boolean r9 = r6.x(r7)     // Catch: java.lang.Exception -> L2e
            if (r9 == 0) goto L4a
            goto L81
        L4a:
            stepai.aios.guiagent.session.a r9 = r6.g     // Catch: java.lang.Exception -> L2e
            r0.f6090a = r7     // Catch: java.lang.Exception -> L2e
            r0.b = r8     // Catch: java.lang.Exception -> L2e
            r0.e = r5     // Catch: java.lang.Exception -> L2e
            java.lang.Object r9 = r9.j(r7, r0)     // Catch: java.lang.Exception -> L2e
            if (r9 != r1) goto L59
            goto L80
        L59:
            za.e r9 = (za.e) r9     // Catch: java.lang.Exception -> L2e
            r2 = 0
            if (r9 == 0) goto L61
            stepai.aios.guiagent.model.SessionState r9 = r9.e     // Catch: java.lang.Exception -> L2e
            goto L62
        L61:
            r9 = r2
        L62:
            if (r9 == 0) goto L81
            boolean r5 = r9.a()     // Catch: java.lang.Exception -> L2e
            if (r5 != 0) goto L81
            stepai.aios.guiagent.model.SessionState r5 = stepai.aios.guiagent.model.SessionState.f     // Catch: java.lang.Exception -> L2e
            if (r9 == r5) goto L81
            stepai.aios.guiagent.pipeline.a r6 = r6.n     // Catch: java.lang.Exception -> L2e
            if (r8 != 0) goto L74
            java.lang.String r8 = "恢复失败"
        L74:
            r0.f6090a = r7     // Catch: java.lang.Exception -> L2e
            r0.b = r2     // Catch: java.lang.Exception -> L2e
            r0.e = r4     // Catch: java.lang.Exception -> L2e
            java.lang.Object r6 = r6.a(r7, r8, r0)     // Catch: java.lang.Exception -> L2e
            if (r6 != r1) goto L81
        L80:
            return r1
        L81:
            return r3
        L82:
            java.lang.String r6 = r6.getMessage()
            java.lang.String r8 = ": "
            java.lang.String r9 = "GuiExecutionPipeline"
            java.lang.String r0 = "Best-effort rollback to MANUAL_TAKEOVER failed for session "
            com.stepos.statsrpk.service.c.o(r0, r7, r8, r6, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.G(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:157:0x0630 -> B:41:0x0215). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:213:0x085c -> B:15:0x0055). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x037c -> B:41:0x0215). Please report as a decompilation issue!!! */
    public final java.lang.Object H(za.e r35, Aa.e r36, Aa.d r37, int r38, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext r39, kotlin.coroutines.jvm.internal.ContinuationImpl r40) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.H(za.e, Aa.e, Aa.d, int, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void I(String sessionId) {
        InterfaceC1779e interfaceC1779e;
        AtomicBoolean atomicBoolean;
        k.f(sessionId, "sessionId");
        Aa.d dVar = (Aa.d) this.k.get(sessionId);
        if (dVar != null && (atomicBoolean = dVar.d) != null) {
            atomicBoolean.set(true);
        }
        if (dVar != null && (interfaceC1779e = dVar.f) != null) {
            interfaceC1779e.a(ExecutionPipeline$ControlEvent.f6035a);
        }
        j.H("Stop signal set for session: ".concat(sessionId), "GuiExecutionPipeline");
    }

    public final Object L(Aa.d dVar, g gVar, ContinuationImpl continuationImpl) {
        Object objM;
        g gVar2 = (g) dVar.c.get(gVar.f7015a);
        if (gVar2 != null) {
            gVar = gVar2;
        }
        return (gVar.e.a() || (objM = m(dVar, gVar.d(StepExecutionState.g), continuationImpl)) != CoroutineSingletons.f4909a) ? r.f317a : objM;
    }

    public final Object N(String str, Aa.d dVar, i iVar, ContinuationImpl continuationImpl) {
        Object objH = this.h.h(str, new M0.k(this, dVar), iVar, continuationImpl);
        return objH == CoroutineSingletons.f4909a ? objH : r.f317a;
    }

    public final Object O(Aa.d dVar, final g gVar, ContinuationImpl continuationImpl) {
        dVar.c.put(gVar.f7015a, gVar);
        C2110a c2110a = this.c;
        final i iVar = dVar.b;
        if (iVar != null) {
            final wa.e eVar = c2110a.c;
            String str = iVar.f7018a;
            String str2 = gVar.f7015a;
            String strB = B7.a.B(str, "_", str2);
            ConcurrentHashMap concurrentHashMap = c2110a.b;
            g gVar2 = (g) concurrentHashMap.get(strB);
            concurrentHashMap.put(strB, gVar);
            StepExecutionState stepExecutionState = gVar2 != null ? gVar2.e : null;
            StepExecutionState stepExecutionState2 = gVar.e;
            if (stepExecutionState != stepExecutionState2) {
                switch (stepExecutionState2.ordinal()) {
                    case 1:
                        eVar.getClass();
                        final int i = 0;
                        eVar.a(str).execute(new Runnable() { // from class: wa.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i) {
                                    case 0:
                                        i iVar2 = iVar;
                                        g gVar3 = gVar;
                                        e eVar2 = eVar;
                                        eVar2.getClass();
                                        try {
                                            Iterator it = eVar2.f6861a.iterator();
                                            while (it.hasNext()) {
                                                ((InterfaceC2124a) it.next()).onStepStarted(iVar2, gVar3);
                                            }
                                            break;
                                        } catch (Exception e) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 1:
                                        i iVar3 = iVar;
                                        g gVar4 = gVar;
                                        e eVar3 = eVar;
                                        eVar3.getClass();
                                        try {
                                            Iterator it2 = eVar3.f6861a.iterator();
                                            while (it2.hasNext()) {
                                                ((InterfaceC2124a) it2.next()).onStepCompleted(iVar3, gVar4);
                                            }
                                            break;
                                        } catch (Exception e6) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCompleted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 2:
                                        i iVar4 = iVar;
                                        g gVar5 = gVar;
                                        e eVar4 = eVar;
                                        eVar4.getClass();
                                        try {
                                            Iterator it3 = eVar4.f6861a.iterator();
                                            while (it3.hasNext()) {
                                                ((InterfaceC2124a) it3.next()).onStepCancelled(iVar4, gVar5);
                                            }
                                            break;
                                        } catch (Exception e9) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCancelled", ": ", e9.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 3:
                                        i iVar5 = iVar;
                                        g gVar6 = gVar;
                                        e eVar5 = eVar;
                                        eVar5.getClass();
                                        try {
                                            Iterator it4 = eVar5.f6861a.iterator();
                                            while (it4.hasNext()) {
                                                ((InterfaceC2124a) it4.next()).onStepRetrying(iVar5, gVar6, 0);
                                            }
                                            break;
                                        } catch (Exception e10) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepRetrying", ": ", e10.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    default:
                                        i iVar6 = iVar;
                                        g gVar7 = gVar;
                                        e eVar6 = eVar;
                                        eVar6.getClass();
                                        try {
                                            Iterator it5 = eVar6.f6861a.iterator();
                                            while (it5.hasNext()) {
                                                ((InterfaceC2124a) it5.next()).onStepExecuting(iVar6, gVar7);
                                            }
                                            break;
                                        } catch (Exception e11) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepExecuting", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        }
                                }
                            }
                        });
                        j.H("Step started: ".concat(str2), "ExecutionEventManager");
                        break;
                    case 2:
                        eVar.getClass();
                        final int i6 = 4;
                        eVar.a(str).execute(new Runnable() { // from class: wa.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i6) {
                                    case 0:
                                        i iVar2 = iVar;
                                        g gVar3 = gVar;
                                        e eVar2 = eVar;
                                        eVar2.getClass();
                                        try {
                                            Iterator it = eVar2.f6861a.iterator();
                                            while (it.hasNext()) {
                                                ((InterfaceC2124a) it.next()).onStepStarted(iVar2, gVar3);
                                            }
                                            break;
                                        } catch (Exception e) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 1:
                                        i iVar3 = iVar;
                                        g gVar4 = gVar;
                                        e eVar3 = eVar;
                                        eVar3.getClass();
                                        try {
                                            Iterator it2 = eVar3.f6861a.iterator();
                                            while (it2.hasNext()) {
                                                ((InterfaceC2124a) it2.next()).onStepCompleted(iVar3, gVar4);
                                            }
                                            break;
                                        } catch (Exception e6) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCompleted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 2:
                                        i iVar4 = iVar;
                                        g gVar5 = gVar;
                                        e eVar4 = eVar;
                                        eVar4.getClass();
                                        try {
                                            Iterator it3 = eVar4.f6861a.iterator();
                                            while (it3.hasNext()) {
                                                ((InterfaceC2124a) it3.next()).onStepCancelled(iVar4, gVar5);
                                            }
                                            break;
                                        } catch (Exception e9) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCancelled", ": ", e9.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 3:
                                        i iVar5 = iVar;
                                        g gVar6 = gVar;
                                        e eVar5 = eVar;
                                        eVar5.getClass();
                                        try {
                                            Iterator it4 = eVar5.f6861a.iterator();
                                            while (it4.hasNext()) {
                                                ((InterfaceC2124a) it4.next()).onStepRetrying(iVar5, gVar6, 0);
                                            }
                                            break;
                                        } catch (Exception e10) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepRetrying", ": ", e10.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    default:
                                        i iVar6 = iVar;
                                        g gVar7 = gVar;
                                        e eVar6 = eVar;
                                        eVar6.getClass();
                                        try {
                                            Iterator it5 = eVar6.f6861a.iterator();
                                            while (it5.hasNext()) {
                                                ((InterfaceC2124a) it5.next()).onStepExecuting(iVar6, gVar7);
                                            }
                                            break;
                                        } catch (Exception e11) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepExecuting", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        }
                                }
                            }
                        });
                        j.H("Step executing: ".concat(str2), "ExecutionEventManager");
                        break;
                    case 3:
                        eVar.getClass();
                        final int i10 = 1;
                        eVar.a(str).execute(new Runnable() { // from class: wa.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i10) {
                                    case 0:
                                        i iVar2 = iVar;
                                        g gVar3 = gVar;
                                        e eVar2 = eVar;
                                        eVar2.getClass();
                                        try {
                                            Iterator it = eVar2.f6861a.iterator();
                                            while (it.hasNext()) {
                                                ((InterfaceC2124a) it.next()).onStepStarted(iVar2, gVar3);
                                            }
                                            break;
                                        } catch (Exception e) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 1:
                                        i iVar3 = iVar;
                                        g gVar4 = gVar;
                                        e eVar3 = eVar;
                                        eVar3.getClass();
                                        try {
                                            Iterator it2 = eVar3.f6861a.iterator();
                                            while (it2.hasNext()) {
                                                ((InterfaceC2124a) it2.next()).onStepCompleted(iVar3, gVar4);
                                            }
                                            break;
                                        } catch (Exception e6) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCompleted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 2:
                                        i iVar4 = iVar;
                                        g gVar5 = gVar;
                                        e eVar4 = eVar;
                                        eVar4.getClass();
                                        try {
                                            Iterator it3 = eVar4.f6861a.iterator();
                                            while (it3.hasNext()) {
                                                ((InterfaceC2124a) it3.next()).onStepCancelled(iVar4, gVar5);
                                            }
                                            break;
                                        } catch (Exception e9) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCancelled", ": ", e9.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 3:
                                        i iVar5 = iVar;
                                        g gVar6 = gVar;
                                        e eVar5 = eVar;
                                        eVar5.getClass();
                                        try {
                                            Iterator it4 = eVar5.f6861a.iterator();
                                            while (it4.hasNext()) {
                                                ((InterfaceC2124a) it4.next()).onStepRetrying(iVar5, gVar6, 0);
                                            }
                                            break;
                                        } catch (Exception e10) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepRetrying", ": ", e10.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    default:
                                        i iVar6 = iVar;
                                        g gVar7 = gVar;
                                        e eVar6 = eVar;
                                        eVar6.getClass();
                                        try {
                                            Iterator it5 = eVar6.f6861a.iterator();
                                            while (it5.hasNext()) {
                                                ((InterfaceC2124a) it5.next()).onStepExecuting(iVar6, gVar7);
                                            }
                                            break;
                                        } catch (Exception e11) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepExecuting", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        }
                                }
                            }
                        });
                        j.H("Step completed: ".concat(str2), "ExecutionEventManager");
                        break;
                    case 4:
                        j.J("Step failed: " + str2 + " - " + gVar.f7016j, "ExecutionEventManager");
                        break;
                    case 5:
                        eVar.getClass();
                        final int i11 = 3;
                        eVar.a(str).execute(new Runnable() { // from class: wa.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i11) {
                                    case 0:
                                        i iVar2 = iVar;
                                        g gVar3 = gVar;
                                        e eVar2 = eVar;
                                        eVar2.getClass();
                                        try {
                                            Iterator it = eVar2.f6861a.iterator();
                                            while (it.hasNext()) {
                                                ((InterfaceC2124a) it.next()).onStepStarted(iVar2, gVar3);
                                            }
                                            break;
                                        } catch (Exception e) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 1:
                                        i iVar3 = iVar;
                                        g gVar4 = gVar;
                                        e eVar3 = eVar;
                                        eVar3.getClass();
                                        try {
                                            Iterator it2 = eVar3.f6861a.iterator();
                                            while (it2.hasNext()) {
                                                ((InterfaceC2124a) it2.next()).onStepCompleted(iVar3, gVar4);
                                            }
                                            break;
                                        } catch (Exception e6) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCompleted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 2:
                                        i iVar4 = iVar;
                                        g gVar5 = gVar;
                                        e eVar4 = eVar;
                                        eVar4.getClass();
                                        try {
                                            Iterator it3 = eVar4.f6861a.iterator();
                                            while (it3.hasNext()) {
                                                ((InterfaceC2124a) it3.next()).onStepCancelled(iVar4, gVar5);
                                            }
                                            break;
                                        } catch (Exception e9) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCancelled", ": ", e9.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 3:
                                        i iVar5 = iVar;
                                        g gVar6 = gVar;
                                        e eVar5 = eVar;
                                        eVar5.getClass();
                                        try {
                                            Iterator it4 = eVar5.f6861a.iterator();
                                            while (it4.hasNext()) {
                                                ((InterfaceC2124a) it4.next()).onStepRetrying(iVar5, gVar6, 0);
                                            }
                                            break;
                                        } catch (Exception e10) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepRetrying", ": ", e10.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    default:
                                        i iVar6 = iVar;
                                        g gVar7 = gVar;
                                        e eVar6 = eVar;
                                        eVar6.getClass();
                                        try {
                                            Iterator it5 = eVar6.f6861a.iterator();
                                            while (it5.hasNext()) {
                                                ((InterfaceC2124a) it5.next()).onStepExecuting(iVar6, gVar7);
                                            }
                                            break;
                                        } catch (Exception e11) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepExecuting", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        }
                                }
                            }
                        });
                        j.H("Step retrying: " + str2 + ", retry count: 0", "ExecutionEventManager");
                        break;
                    case 6:
                        j.H("Step skipped: ".concat(str2), "ExecutionEventManager");
                        break;
                    case 7:
                        eVar.getClass();
                        final int i12 = 2;
                        eVar.a(iVar.f7018a).execute(new Runnable() { // from class: wa.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i12) {
                                    case 0:
                                        i iVar2 = iVar;
                                        g gVar3 = gVar;
                                        e eVar2 = eVar;
                                        eVar2.getClass();
                                        try {
                                            Iterator it = eVar2.f6861a.iterator();
                                            while (it.hasNext()) {
                                                ((InterfaceC2124a) it.next()).onStepStarted(iVar2, gVar3);
                                            }
                                            break;
                                        } catch (Exception e) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 1:
                                        i iVar3 = iVar;
                                        g gVar4 = gVar;
                                        e eVar3 = eVar;
                                        eVar3.getClass();
                                        try {
                                            Iterator it2 = eVar3.f6861a.iterator();
                                            while (it2.hasNext()) {
                                                ((InterfaceC2124a) it2.next()).onStepCompleted(iVar3, gVar4);
                                            }
                                            break;
                                        } catch (Exception e6) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCompleted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 2:
                                        i iVar4 = iVar;
                                        g gVar5 = gVar;
                                        e eVar4 = eVar;
                                        eVar4.getClass();
                                        try {
                                            Iterator it3 = eVar4.f6861a.iterator();
                                            while (it3.hasNext()) {
                                                ((InterfaceC2124a) it3.next()).onStepCancelled(iVar4, gVar5);
                                            }
                                            break;
                                        } catch (Exception e9) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCancelled", ": ", e9.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 3:
                                        i iVar5 = iVar;
                                        g gVar6 = gVar;
                                        e eVar5 = eVar;
                                        eVar5.getClass();
                                        try {
                                            Iterator it4 = eVar5.f6861a.iterator();
                                            while (it4.hasNext()) {
                                                ((InterfaceC2124a) it4.next()).onStepRetrying(iVar5, gVar6, 0);
                                            }
                                            break;
                                        } catch (Exception e10) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepRetrying", ": ", e10.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    default:
                                        i iVar6 = iVar;
                                        g gVar7 = gVar;
                                        e eVar6 = eVar;
                                        eVar6.getClass();
                                        try {
                                            Iterator it5 = eVar6.f6861a.iterator();
                                            while (it5.hasNext()) {
                                                ((InterfaceC2124a) it5.next()).onStepExecuting(iVar6, gVar7);
                                            }
                                            break;
                                        } catch (Exception e11) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepExecuting", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        }
                                }
                            }
                        });
                        j.H("Step cancelled: ".concat(str2), "ExecutionEventManager");
                        break;
                    case 8:
                        eVar.getClass();
                        final int i13 = 2;
                        eVar.a(iVar.f7018a).execute(new Runnable() { // from class: wa.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i13) {
                                    case 0:
                                        i iVar2 = iVar;
                                        g gVar3 = gVar;
                                        e eVar2 = eVar;
                                        eVar2.getClass();
                                        try {
                                            Iterator it = eVar2.f6861a.iterator();
                                            while (it.hasNext()) {
                                                ((InterfaceC2124a) it.next()).onStepStarted(iVar2, gVar3);
                                            }
                                            break;
                                        } catch (Exception e) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepStarted", ": ", e.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 1:
                                        i iVar3 = iVar;
                                        g gVar4 = gVar;
                                        e eVar3 = eVar;
                                        eVar3.getClass();
                                        try {
                                            Iterator it2 = eVar3.f6861a.iterator();
                                            while (it2.hasNext()) {
                                                ((InterfaceC2124a) it2.next()).onStepCompleted(iVar3, gVar4);
                                            }
                                            break;
                                        } catch (Exception e6) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCompleted", ": ", e6.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 2:
                                        i iVar4 = iVar;
                                        g gVar5 = gVar;
                                        e eVar4 = eVar;
                                        eVar4.getClass();
                                        try {
                                            Iterator it3 = eVar4.f6861a.iterator();
                                            while (it3.hasNext()) {
                                                ((InterfaceC2124a) it3.next()).onStepCancelled(iVar4, gVar5);
                                            }
                                            break;
                                        } catch (Exception e9) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepCancelled", ": ", e9.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    case 3:
                                        i iVar5 = iVar;
                                        g gVar6 = gVar;
                                        e eVar5 = eVar;
                                        eVar5.getClass();
                                        try {
                                            Iterator it4 = eVar5.f6861a.iterator();
                                            while (it4.hasNext()) {
                                                ((InterfaceC2124a) it4.next()).onStepRetrying(iVar5, gVar6, 0);
                                            }
                                            break;
                                        } catch (Exception e10) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepRetrying", ": ", e10.getMessage(), "TaskEventDispatcher");
                                            return;
                                        }
                                    default:
                                        i iVar6 = iVar;
                                        g gVar7 = gVar;
                                        e eVar6 = eVar;
                                        eVar6.getClass();
                                        try {
                                            Iterator it5 = eVar6.f6861a.iterator();
                                            while (it5.hasNext()) {
                                                ((InterfaceC2124a) it5.next()).onStepExecuting(iVar6, gVar7);
                                            }
                                            break;
                                        } catch (Exception e11) {
                                            com.stepos.statsrpk.service.c.o("Error dispatching event ", "onStepExecuting", ": ", e11.getMessage(), "TaskEventDispatcher");
                                        }
                                }
                            }
                        });
                        j.H("Step taken over: ".concat(str2), "ExecutionEventManager");
                        break;
                }
            }
        }
        Object objP = P(dVar, continuationImpl);
        return objP == CoroutineSingletons.f4909a ? objP : r.f317a;
    }

    public final Object P(Aa.d dVar, ContinuationImpl continuationImpl) {
        int i;
        int i6;
        Object objG;
        r rVar = r.f317a;
        i iVar = dVar.b;
        Collection collectionValues = dVar.c.values();
        boolean z10 = collectionValues instanceof Collection;
        Integer num = null;
        int i10 = 0;
        if (z10 && collectionValues.isEmpty()) {
            i = 0;
        } else {
            Iterator it = collectionValues.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (((g) it.next()).e == StepExecutionState.c && (i11 = i11 + 1) < 0) {
                    o.W();
                    throw null;
                }
            }
            i = i11;
        }
        if (z10 && collectionValues.isEmpty()) {
            i6 = 0;
        } else {
            Iterator it2 = collectionValues.iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                if (((g) it2.next()).e == StepExecutionState.d && (i12 = i12 + 1) < 0) {
                    o.W();
                    throw null;
                }
            }
            i6 = i12;
        }
        if (!z10 || !collectionValues.isEmpty()) {
            Iterator it3 = collectionValues.iterator();
            while (it3.hasNext()) {
                StepExecutionState stepExecutionState = ((g) it3.next()).e;
                if (stepExecutionState == StepExecutionState.e || stepExecutionState == StepExecutionState.g) {
                    i10++;
                    if (i10 < 0) {
                        o.W();
                        throw null;
                    }
                }
            }
        }
        int i13 = i10;
        Iterator it4 = collectionValues.iterator();
        if (it4.hasNext()) {
            num = new Integer(((g) it4.next()).b);
            while (it4.hasNext()) {
                Integer num2 = new Integer(((g) it4.next()).b);
                if (num.compareTo(num2) < 0) {
                    num = num2;
                }
            }
        }
        int iIntValue = num != null ? num.intValue() : iVar.f;
        int maxSteps = iVar.g;
        if (maxSteps <= 0) {
            maxSteps = dVar.f167a.f168a.getMaxSteps();
        }
        int i14 = maxSteps;
        za.c cVarA = za.c.a(iVar.h, iIntValue, i14, i, i6, i13, i14 > 0 ? (i / i14) * 100.0f : 0.0f, System.currentTimeMillis() - iVar.d, 832);
        return (cVarA.equals(iVar.h) || (objG = this.h.g(iVar.f7018a, new M0.k(this, dVar), cVarA, continuationImpl)) != CoroutineSingletons.f4909a) ? rVar : objG;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02fb A[Catch: Exception -> 0x030f, CancellationException -> 0x0375, TryCatch #0 {Exception -> 0x030f, blocks: (B:108:0x02d8, B:110:0x02fb, B:112:0x0302), top: B:139:0x02d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0302 A[Catch: Exception -> 0x030f, CancellationException -> 0x0375, TRY_LEAVE, TryCatch #0 {Exception -> 0x030f, blocks: (B:108:0x02d8, B:110:0x02fb, B:112:0x0302), top: B:139:0x02d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x030a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ff A[Catch: Exception -> 0x0209, CancellationException -> 0x0375, TRY_LEAVE, TryCatch #2 {Exception -> 0x0209, blocks: (B:88:0x01fb, B:90:0x01ff), top: B:142:0x01fb }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(Aa.e r25, za.e r26, za.g r27, stepai.aios.guiagent.ability.CaptureResult r28, kotlin.coroutines.jvm.internal.ContinuationImpl r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.e(Aa.e, za.e, za.g, stepai.aios.guiagent.ability.CaptureResult, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Object f(Aa.d dVar, g gVar, ContinuationImpl continuationImpl) {
        Object objM;
        g gVar2 = (g) dVar.c.get(gVar.f7015a);
        if (gVar2 != null) {
            gVar = gVar2;
        }
        return (gVar.e.a() || (objM = m(dVar, gVar.d(StepExecutionState.f), continuationImpl)) != CoroutineSingletons.f4909a) ? r.f317a : objM;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(Aa.d r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$cancelTask$2
            if (r0 == 0) goto L13
            r0 = r8
            stepai.aios.guiagent.pipeline.ExecutionPipeline$cancelTask$2 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$cancelTask$2) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$cancelTask$2 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$cancelTask$2
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.lang.String r7 = r0.f6052a
            kotlin.b.b(r8)
            goto L53
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.b.b(r8)
            za.i r8 = r5.b
            stepai.aios.guiagent.model.SessionState r8 = r8.c
            stepai.aios.guiagent.model.SessionState r2 = stepai.aios.guiagent.model.SessionState.i
            if (r8 != r2) goto L41
            za.d r4 = s2.C1912a.j(r7)
            return r4
        L41:
            stepai.aios.guiagent.event.a r8 = r4.h
            M0.k r2 = new M0.k
            r2.<init>(r4, r5)
            r0.f6052a = r7
            r0.d = r3
            java.lang.Object r4 = r8.a(r6, r2, r7, r0)
            if (r4 != r1) goto L53
            return r1
        L53:
            za.d r4 = s2.C1912a.j(r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.g(Aa.d, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(Aa.e r10, za.e r11, Aa.d r12, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.h(Aa.e, za.e, Aa.d, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Resources cleaned up for stopped session: "
            boolean r1 = r8 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupStoppedTaskResources$1
            if (r1 == 0) goto L15
            r1 = r8
            stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupStoppedTaskResources$1 r1 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupStoppedTaskResources$1) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.e = r2
            goto L1a
        L15:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupStoppedTaskResources$1 r1 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupStoppedTaskResources$1
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.e
            r4 = 1
            java.lang.String r5 = "GuiExecutionPipeline"
            if (r3 == 0) goto L3a
            if (r3 != r4) goto L32
            Aa.d r7 = r1.b
            java.lang.String r1 = r1.f6054a
            kotlin.b.b(r8)     // Catch: java.lang.Exception -> L2f
            goto L56
        L2f:
            r6 = move-exception
            r7 = r1
            goto L96
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.b.b(r8)
            java.util.concurrent.ConcurrentHashMap r8 = r6.k     // Catch: java.lang.Exception -> L6c
            java.lang.Object r8 = r8.get(r7)     // Catch: java.lang.Exception -> L6c
            Aa.d r8 = (Aa.d) r8     // Catch: java.lang.Exception -> L6c
            if (r8 == 0) goto L6e
            r1.f6054a = r7     // Catch: java.lang.Exception -> L6c
            r1.b = r8     // Catch: java.lang.Exception -> L6c
            r1.e = r4     // Catch: java.lang.Exception -> L6c
            java.lang.Object r1 = r6.j(r8, r7, r1)     // Catch: java.lang.Exception -> L6c
            if (r1 != r2) goto L54
            return r2
        L54:
            r1 = r7
            r7 = r8
        L56:
            za.i r8 = r7.b     // Catch: java.lang.Exception -> L2f
            stepai.aios.guiagent.model.SessionState r8 = r8.c     // Catch: java.lang.Exception -> L2f
            boolean r8 = r8.a()     // Catch: java.lang.Exception -> L2f
            if (r8 == 0) goto L6a
            java.util.concurrent.ConcurrentHashMap r8 = r6.k     // Catch: java.lang.Exception -> L2f
            r8.remove(r1, r7)     // Catch: java.lang.Exception -> L2f
            stepai.aios.guiagent.event.a r7 = r6.h     // Catch: java.lang.Exception -> L2f
            r7.b(r1)     // Catch: java.lang.Exception -> L2f
        L6a:
            r7 = r1
            goto L6e
        L6c:
            r6 = move-exception
            goto L96
        L6e:
            java.lang.String r8 = "sessionId"
            kotlin.jvm.internal.k.f(r7, r8)     // Catch: java.lang.Exception -> L6c
            java.util.concurrent.ConcurrentHashMap r6 = r6.k     // Catch: java.lang.Exception -> L6c
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Exception -> L6c
            Aa.d r6 = (Aa.d) r6     // Catch: java.lang.Exception -> L6c
            if (r6 == 0) goto L85
            java.util.concurrent.atomic.AtomicBoolean r6 = r6.d     // Catch: java.lang.Exception -> L6c
            if (r6 == 0) goto L85
            r8 = 0
            r6.set(r8)     // Catch: java.lang.Exception -> L6c
        L85:
            java.lang.String r6 = "Stop signal cleared for session: "
            java.lang.String r6 = r6.concat(r7)     // Catch: java.lang.Exception -> L6c
            N9.j.H(r6, r5)     // Catch: java.lang.Exception -> L6c
            java.lang.String r6 = r0.concat(r7)     // Catch: java.lang.Exception -> L6c
            N9.j.H(r6, r5)     // Catch: java.lang.Exception -> L6c
            goto La1
        L96:
            java.lang.String r6 = r6.getMessage()
            java.lang.String r8 = "Failed to cleanup resources for session: "
            java.lang.String r0 = ", error: "
            com.stepos.statsrpk.service.c.o(r8, r7, r0, r6, r5)
        La1:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.i(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(Aa.d r5, java.lang.String r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupTaskContext$1
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupTaskContext$1 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupTaskContext$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupTaskContext$1 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$cleanupTaskContext$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r4 = r0.f6055a
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)     // Catch: java.lang.Exception -> L5e
            goto L5e
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.d
            r1 = 0
            r4.set(r1)
            java.util.concurrent.atomic.AtomicReference r4 = r5.e
            r1 = 0
            r4.set(r1)
        L3e:
            o9.e r4 = r5.f
            java.lang.Object r4 = r4.q()
            boolean r4 = r4 instanceof o9.C1781g
            if (r4 == 0) goto L3e
            m9.c0 r4 = r5.g
            if (r4 == 0) goto L4f
            r4.cancel(r1)
        L4f:
            r5.g = r1
            Aa.e r4 = r5.f167a     // Catch: java.lang.Exception -> L5e
            stepai.aios.guiagent.pipeline.util.a r4 = r4.c     // Catch: java.lang.Exception -> L5e
            r0.c = r2     // Catch: java.lang.Exception -> L5e
            java.lang.Object r4 = r4.a(r6, r0)     // Catch: java.lang.Exception -> L5e
            if (r4 != r7) goto L5e
            return r7
        L5e:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.j(Aa.d, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Object l(Aa.d dVar, g gVar, String str, RuntimeException runtimeException, ContinuationImpl continuationImpl) {
        dVar.c.put(gVar.f7015a, gVar);
        dVar.h++;
        C2110a c2110a = this.c;
        i taskInfo = dVar.b;
        if (runtimeException == null) {
            runtimeException = new RuntimeException(str);
        }
        RuntimeException runtimeException2 = runtimeException;
        k.f(taskInfo, "taskInfo");
        String str2 = taskInfo.f7018a;
        String str3 = gVar.f7015a;
        String message = runtimeException2.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        g gVarC = gVar.c(message, runtimeException2);
        c2110a.b.put(B7.a.B(str2, "_", str3), gVarC);
        wa.e eVar = c2110a.c;
        eVar.getClass();
        eVar.a(str2).execute(new h(eVar, taskInfo, gVarC, runtimeException2, 2));
        j.J("Step failed: " + str3 + ", error: " + runtimeException2.getMessage(), "ExecutionEventManager");
        Object objP = P(dVar, continuationImpl);
        return objP == CoroutineSingletons.f4909a ? objP : r.f317a;
    }

    public final Object m(Aa.d dVar, g gVar, ContinuationImpl continuationImpl) {
        dVar.h = 0;
        Object objO = O(dVar, gVar, continuationImpl);
        return objO == CoroutineSingletons.f4909a ? objO : r.f317a;
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x026b: MOVE (r7 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:79:0x026b */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0279: MOVE (r7 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:81:0x026f */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x027e: MOVE (r7 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:83:0x027e */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x010f: MOVE (r13 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:41:0x010f */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x011d: MOVE (r13 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:43:0x0113 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0123: MOVE (r13 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:46:0x0123 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x027a: MOVE (r13 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:81:0x026f */
    public final java.lang.Object o(Aa.e r28, za.e r29, stepai.aios.guiagent.config.Action r30, za.g r31, kotlin.coroutines.jvm.internal.ContinuationImpl r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.o(Aa.e, za.e, stepai.aios.guiagent.config.Action, za.g, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Object p(Aa.d dVar, g gVar, String str, RuntimeException runtimeException, ContinuationImpl continuationImpl) {
        Object objL;
        g gVar2 = (g) dVar.c.get(gVar.f7015a);
        if (gVar2 != null) {
            gVar = gVar2;
        }
        return (gVar.e.a() || (objL = l(dVar, gVar.c(str, runtimeException), str, runtimeException, continuationImpl)) != CoroutineSingletons.f4909a) ? r.f317a : objL;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r5, Aa.d r6, java.lang.String r7, java.lang.Exception r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$failTask$1
            if (r0 == 0) goto L13
            r0 = r9
            stepai.aios.guiagent.pipeline.ExecutionPipeline$failTask$1 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$failTask$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$failTask$1 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$failTask$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.lang.String r7 = r0.f6061a
            kotlin.b.b(r9)
            goto L5c
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.b.b(r9)
            za.i r9 = r6.b
            stepai.aios.guiagent.model.SessionState r9 = r9.c
            boolean r9 = r9.a()
            if (r9 == 0) goto L43
            za.d r4 = s2.C1912a.j(r7)
            return r4
        L43:
            stepai.aios.guiagent.event.a r9 = r4.h
            M0.k r2 = new M0.k
            r2.<init>(r4, r6)
            if (r8 != 0) goto L51
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            r8.<init>(r7)
        L51:
            r0.f6061a = r7
            r0.d = r3
            java.lang.Object r4 = r9.d(r5, r2, r8, r0)
            if (r4 != r1) goto L5c
            return r1
        L5c:
            za.d r4 = s2.C1912a.j(r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.q(java.lang.String, Aa.d, java.lang.String, java.lang.Exception, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final stepai.aios.guiagent.session.a r() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04df A[Catch: all -> 0x07d7, Exception -> 0x07db, CancellationException -> 0x07dd, TryCatch #13 {CancellationException -> 0x07dd, Exception -> 0x07db, all -> 0x07d7, blocks: (B:134:0x04d9, B:136:0x04df, B:138:0x04e5), top: B:333:0x04d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x05e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0635 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x07ec A[Catch: all -> 0x08c0, TRY_LEAVE, TryCatch #0 {all -> 0x08c0, blocks: (B:223:0x07e2, B:225:0x07ec, B:246:0x08c3, B:248:0x08c9, B:263:0x0978, B:265:0x097e, B:266:0x0986), top: B:313:0x07e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0856  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x088b  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x08ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x08c3 A[Catch: all -> 0x08c0, TRY_ENTER, TryCatch #0 {all -> 0x08c0, blocks: (B:223:0x07e2, B:225:0x07ec, B:246:0x08c3, B:248:0x08c9, B:263:0x0978, B:265:0x097e, B:266:0x0986), top: B:313:0x07e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0915 A[PHI: r0 r2 r3 r4
      0x0915: PHI (r0v82 java.lang.Object) = (r0v81 java.lang.Object), (r0v1 java.lang.Object) binds: [B:253:0x0911, B:48:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0915: PHI (r2v82 stepai.aios.guiagent.config.Action) = (r2v78 stepai.aios.guiagent.config.Action), (r2v88 stepai.aios.guiagent.config.Action) binds: [B:253:0x0911, B:48:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0915: PHI (r3v62 za.e) = (r3v118 za.e), (r3v119 za.e) binds: [B:253:0x0911, B:48:0x0173] A[DONT_GENERATE, DONT_INLINE]
      0x0915: PHI (r4v61 Aa.e) = (r4v59 Aa.e), (r4v63 Aa.e) binds: [B:253:0x0911, B:48:0x0173] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0948  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0977 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x09e8 A[Catch: all -> 0x0a97, TRY_LEAVE, TryCatch #13 {all -> 0x0a97, blocks: (B:273:0x09e2, B:275:0x09e8), top: B:321:0x09e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0a5d  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0a90 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0a99  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0b38  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0b63 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:335:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d2 A[PHI: r2 r3 r4 r5 r7 r8
      0x01d2: PHI (r2v58 stepai.aios.guiexecutor.api.GuiResult) = (r2v55 stepai.aios.guiexecutor.api.GuiResult), (r2v64 stepai.aios.guiexecutor.api.GuiResult) binds: [B:148:0x0570, B:62:0x01bf] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r3v34 za.g) = (r3v32 za.g), (r3v47 za.g) binds: [B:148:0x0570, B:62:0x01bf] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r4v46 Aa.d) = (r4v44 Aa.d), (r4v49 Aa.d) binds: [B:148:0x0570, B:62:0x01bf] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r5v36 stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext) = 
      (r5v33 stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext)
      (r5v49 stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext)
     binds: [B:148:0x0570, B:62:0x01bf] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r7v27 za.e) = (r7v25 za.e), (r7v38 za.e) binds: [B:148:0x0570, B:62:0x01bf] A[DONT_GENERATE, DONT_INLINE]
      0x01d2: PHI (r8v19 Aa.e) = (r8v17 Aa.e), (r8v21 Aa.e) binds: [B:148:0x0570, B:62:0x01bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02d7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ef A[PHI: r0 r2 r3 r4 r5 r13 r16
      0x02ef: PHI (r0v26 Aa.d) = (r0v24 Aa.d), (r0v30 Aa.d) binds: [B:120:0x040c, B:88:0x02da] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r2v23 stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext) = 
      (r2v20 stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext)
      (r2v26 stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext)
     binds: [B:120:0x040c, B:88:0x02da] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r3v12 za.g) = (r3v10 za.g), (r3v14 za.g) binds: [B:120:0x040c, B:88:0x02da] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r4v13 stepai.aios.guiagent.config.Action) = (r4v11 stepai.aios.guiagent.config.Action), (r4v16 stepai.aios.guiagent.config.Action) binds: [B:120:0x040c, B:88:0x02da] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r5v9 za.e) = (r5v7 za.e), (r5v11 za.e) binds: [B:120:0x040c, B:88:0x02da] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r13v7 Aa.e) = (r13v5 Aa.e), (r13v8 Aa.e) binds: [B:120:0x040c, B:88:0x02da] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r16v1 java.lang.String) = (r16v0 java.lang.String), (r16v2 java.lang.String) binds: [B:120:0x040c, B:88:0x02da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Type inference failed for: r0v6, types: [stepai.aios.guiagent.session.a] */
    /* JADX WARN: Type inference failed for: r0v78, types: [stepai.aios.guiagent.session.a] */
    /* JADX WARN: Type inference failed for: r0v83, types: [stepai.aios.guiagent.session.a] */
    /* JADX WARN: Type inference failed for: r0v97, types: [stepai.aios.guiagent.session.a] */
    /* JADX WARN: Type inference failed for: r0v99, types: [stepai.aios.guiagent.session.a] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [Aa.d, Aa.e, java.lang.Object, java.lang.String, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32, types: [Aa.d, Aa.e, java.lang.Object, java.lang.String, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36, types: [Aa.d, Aa.e, java.lang.Object, java.lang.String, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v41, types: [Aa.d, Aa.e, java.lang.Object, java.lang.RuntimeException, java.lang.String, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r15v43, types: [Aa.d, Aa.e, java.lang.Object, java.lang.RuntimeException, java.lang.String, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v44 */
    /* JADX WARN: Type inference failed for: r15v45 */
    /* JADX WARN: Type inference failed for: r15v46, types: [Aa.d, Aa.e, java.lang.Object, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v47 */
    /* JADX WARN: Type inference failed for: r15v48, types: [Aa.d, Aa.e, java.lang.Object, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v49 */
    /* JADX WARN: Type inference failed for: r15v50 */
    /* JADX WARN: Type inference failed for: r15v51, types: [Aa.d, Aa.e, java.lang.Object, java.lang.RuntimeException, stepai.aios.guiagent.config.Action, stepai.aios.guiexecutor.api.GuiCommand, za.d, za.e, za.g] */
    /* JADX WARN: Type inference failed for: r15v52 */
    /* JADX WARN: Type inference failed for: r27v0, types: [stepai.aios.guiagent.pipeline.b] */
    /* JADX WARN: Type inference failed for: r2v152 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v47, types: [stepai.aios.guiagent.config.Action] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v6, types: [stepai.aios.guiagent.config.Action] */
    /* JADX WARN: Type inference failed for: r2v68, types: [stepai.aios.guiagent.config.Action] */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r3v109, types: [int] */
    /* JADX WARN: Type inference failed for: r3v110, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v36, types: [Aa.e] */
    /* JADX WARN: Type inference failed for: r4v4, types: [Aa.e] */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v72 */
    /* JADX WARN: Type inference failed for: r4v88 */
    /* JADX WARN: Type inference failed for: r4v89 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(Aa.e r28, za.e r29, stepai.aios.guiagent.config.Action r30, za.g r31, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext r32, kotlin.coroutines.jvm.internal.ContinuationImpl r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.s(Aa.e, za.e, stepai.aios.guiagent.config.Action, za.g, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x02f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0188 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0208 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0242 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(Aa.e r18, za.e r19, stepai.aios.guiagent.config.Action r20, za.g r21, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext r22, kotlin.coroutines.jvm.internal.ContinuationImpl r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.t(Aa.e, za.e, stepai.aios.guiagent.config.Action, za.g, stepai.aios.guiagent.pipeline.ExecutionPipeline$LoopContext, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d A[Catch: all -> 0x0093, Exception -> 0x0096, TRY_ENTER, TryCatch #5 {Exception -> 0x0096, blocks: (B:28:0x008e, B:63:0x012a, B:60:0x010d), top: B:154:0x0035, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015c A[Catch: Exception -> 0x0049, TryCatch #2 {Exception -> 0x0049, blocks: (B:14:0x0042, B:19:0x0057, B:22:0x006c, B:25:0x007e, B:85:0x017f, B:78:0x015c, B:80:0x0162, B:82:0x0166, B:72:0x014f, B:74:0x0155, B:75:0x0158, B:67:0x0142, B:69:0x0148, B:57:0x00f5, B:42:0x00b0, B:44:0x00b8, B:28:0x008e, B:63:0x012a, B:65:0x012d, B:60:0x010d), top: B:154:0x0035, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017f A[Catch: Exception -> 0x0049, PHI: r0 r2 r3 r6
      0x017f: PHI (r0v16 java.lang.Object) = (r0v11 java.lang.Object), (r0v1 java.lang.Object) binds: [B:83:0x017b, B:26:0x0081] A[DONT_GENERATE, DONT_INLINE]
      0x017f: PHI (r2v10 java.lang.String) = (r2v7 java.lang.String), (r2v35 java.lang.String) binds: [B:83:0x017b, B:26:0x0081] A[DONT_GENERATE, DONT_INLINE]
      0x017f: PHI (r3v4 Aa.d) = (r3v31 Aa.d), (r3v32 Aa.d) binds: [B:83:0x017b, B:26:0x0081] A[DONT_GENERATE, DONT_INLINE]
      0x017f: PHI (r6v3 za.e) = (r6v16 za.e), (r6v12 za.e) binds: [B:83:0x017b, B:26:0x0081] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {Exception -> 0x0049, blocks: (B:14:0x0042, B:19:0x0057, B:22:0x006c, B:25:0x007e, B:85:0x017f, B:78:0x015c, B:80:0x0162, B:82:0x0166, B:72:0x014f, B:74:0x0155, B:75:0x0158, B:67:0x0142, B:69:0x0148, B:57:0x00f5, B:42:0x00b0, B:44:0x00b8, B:28:0x008e, B:63:0x012a, B:65:0x012d, B:60:0x010d), top: B:154:0x0035, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c8 A[Catch: Exception -> 0x01e2, TryCatch #9 {Exception -> 0x01e2, blocks: (B:141:0x0269, B:137:0x0243, B:98:0x01d1, B:100:0x01db, B:107:0x01ea, B:112:0x01f5, B:114:0x01f9, B:133:0x0222, B:122:0x0209, B:123:0x020e, B:125:0x0211, B:127:0x0215, B:106:0x01e7, B:91:0x01bd, B:94:0x01c8), top: B:164:0x01bd }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ce  */
    /* JADX WARN: Type inference failed for: r2v0, types: [Aa.e] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16, types: [Aa.e, android.graphics.Bitmap, java.lang.Object, java.lang.String, za.h] */
    /* JADX WARN: Type inference failed for: r2v17, types: [Aa.d, Aa.e, android.graphics.Bitmap, java.lang.String, stepai.aios.guiagent.model.TakeoverReasonType, za.h] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v0, types: [za.e] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24, types: [za.e] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r6v2, types: [za.e] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v7, types: [za.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(Aa.e r21, za.e r22, kotlin.coroutines.jvm.internal.ContinuationImpl r23) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.v(Aa.e, za.e, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(Aa.d r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof stepai.aios.guiagent.pipeline.ExecutionPipeline$interruptAndCancel$1
            if (r0 == 0) goto L13
            r0 = r8
            stepai.aios.guiagent.pipeline.ExecutionPipeline$interruptAndCancel$1 r0 = (stepai.aios.guiagent.pipeline.ExecutionPipeline$interruptAndCancel$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            stepai.aios.guiagent.pipeline.ExecutionPipeline$interruptAndCancel$1 r0 = new stepai.aios.guiagent.pipeline.ExecutionPipeline$interruptAndCancel$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r4 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.e
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.lang.String r7 = r0.b
            Aa.d r5 = r0.f6073a
            kotlin.b.b(r4)
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r4)
            Aa.e r4 = r5.f167a
            stepai.aios.guiagent.pipeline.util.a r4 = r4.c
            r0.f6073a = r5
            r0.b = r7
            r0.e = r2
            java.lang.Object r4 = r4.b(r6, r0)
            if (r4 != r8) goto L47
            return r8
        L47:
            m9.c0 r4 = r5.g
            if (r4 == 0) goto L53
            java.util.concurrent.CancellationException r5 = new java.util.concurrent.CancellationException
            r5.<init>(r7)
            r4.cancel(r5)
        L53:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.w(Aa.d, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final boolean x(String sessionId) {
        AtomicBoolean atomicBoolean;
        k.f(sessionId, "sessionId");
        Aa.d dVar = (Aa.d) this.k.get(sessionId);
        if (dVar == null || (atomicBoolean = dVar.d) == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        if (kotlinx.coroutines.a.f(r14, r6) == r7) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018f A[Catch: Exception -> 0x0199, LOOP:0: B:48:0x0189->B:50:0x018f, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x0199, blocks: (B:47:0x0183, B:48:0x0189, B:50:0x018f), top: B:55:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(Aa.e r25, za.e r26, za.g r27, Aa.d r28, kotlin.coroutines.jvm.internal.ContinuationImpl r29) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.b.y(Aa.e, za.e, za.g, Aa.d, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
