package com.obric.aiagent.executionengine.scheduler.impl.job;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ai;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ToolExecutionAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f18560a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f18561b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f18562c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final LinkedHashMap<String, Map<String, String>> f18563d = null;

    public static /* synthetic */ void lambda$3sSjdJglbbSUxQzs3oY2ouOR_aI(IMAppAction r0, List r1, Boolean r2, IMAppAction r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$9WA796kQzdfXEkgcr-2aTA4AgQM, reason: not valid java name */
    public static /* synthetic */ Thread m191lambda$9WA796kQzdfXEkgcr2aTA4AgQM(Runnable r0) {
        return a(r0);
    }

    private i() {
    }

    static {
        f18560a = new i();
        f18561b = Executors.newSingleThreadExecutor($$Lambda$i$9WA796kQzdfXEkgcr2aTA4AgQM.INSTANCE);
        f18562c = new Object();
        f18563d = new LinkedHashMap();
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "tool-audit-logger");
    }

    public final void a(IMAppAction r13, IMAppAction r14, JobResult r15) {
        o.e(r13, Ext.KEY_REQUEST);
        o.e(r14, "result");
        Boolean r0 = null;
        if (r15 == null) goto L5;
        List<IntentExecutionRecord> r1 = r15.getExecRecords();
    L6:
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L28;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L17;
    L19:
        Iterator r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L25;
        if (j.a((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r6.next(), IntentExecutionRecord.class, "com.obric.aiagent.plugin")) == true) goto L21;
        r5 = false;
    L25:
        if (r5 == false) goto L28;
        ILogDepend.Companion.i("ToolAuditLogger", "defer non-final Omni tool audit, messageId=" + r13.getMessageId() + ", questionId=" + r13.getQuestionId() + ", records=" + r1.size());
        return;
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
    L28:
        if (r1 == null) goto L37;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
        int r10 = 0;
    L31:
        if (r9.hasNext() == false) goto L36;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L35;
        p.c();
    L35:
        r8.add(new h((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r11, IntentExecutionRecord.class, "com.obric.aiagent.plugin"), r10, null, 4, null));
        r10 = r12;
        goto L31
    L36:
        List<h> r16 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L38:
        if (r15 == null) goto L40;
        r0 = Boolean.valueOf(r15.getHasError());
    L40:
        a(r13, r14, r16, r0);
        return;
    L37:
        r16 = null;
        goto L38
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final c a(Collection<c> r37, IntentResult<?> r38, Map<?, ?> r39) {
        Collection<c> r2 = (Collection) ZeusTransformUtils.wrapperContextForParams(r37, Collection.class, "com.obric.aiagent.plugin");
        Map<?, ?> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r39, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "jobs");
        o.e(r38, "finalResult");
        if (r38.isFinal() == true) goto L67;
        return null;
    L67:
        g r3 = a(r2, r4);     // Catch: Exception -> L63
        if (r3 != null) goto L8;
        return null;
    L8:
        c r5 = r3.a();     // Catch: Exception -> L63
        int r14 = r3.b();     // Catch: Exception -> L63
        if (r4 == null) goto L11;
        Object r6 = r4.get(Ext.KEY_ACTION_ID);     // Catch: Exception -> L63
    L13:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L15;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L63
    L16:
        String r8 = String.valueOf(r5.b().getActionId());     // Catch: Exception -> L63
        boolean r9 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
    L21:
        r9 = false;
    L22:
        if (r9 == true) goto L27;
        r8 = null;
    L27:
        if (r5.c(r8) == true) goto L33;
        ILogDepend.Companion r0 = ILogDepend.Companion;     // Catch: Exception -> L63
        StringBuilder r10 = new StringBuilder().append("skip duplicate final Omni tool audit, jobId=").append(r5.e()).append(", actionId=");     // Catch: Exception -> L63
        if (r7 != null) goto L31;
        r7 = "";
    L31:
        r0.w("ToolAuditLogger", r10.append(r7).append(", recordIndex=").append(r14).toString());     // Catch: Exception -> L63
        return r5;
    L33:
        c.b r11 = r3.c();     // Catch: Exception -> L63
        IMAppAction r12 = IMAppAction.copy$default(r5.b(), 0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);     // Catch: Exception -> L63
        IMAppActionExt r13 = r5.b().getExt();     // Catch: Exception -> L63
        if (r13 == null) goto L36;
        IMAppActionExt r15 = new IMAppActionExt();     // Catch: Exception -> L63
        r15.putAll((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L63
    L37:
        r12.setExt(r15);     // Catch: Exception -> L63
        IMAppActionExt r16 = new IMAppActionExt();     // Catch: Exception -> L63
        IMAppActionExt r17 = r11.b().b().getExt();     // Catch: Exception -> L63
        if (r17 == null) goto L40;
        r16.putAll((Map) ZeusTransformUtils.preCheckCast(r17, Map.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L63
    L40:
        IntentResult<?> r18 = r11.b().a();     // Catch: Exception -> L63
        if (r18 == null) goto L45;
        ConcurrentHashMap<String, String> r19 = r18.getExt();     // Catch: Exception -> L63
        if (r19 == null) goto L45;
        r16.putAll((Map) ZeusTransformUtils.preCheckCast(r19, Map.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L63
    L45:
        ConcurrentHashMap<String, String> r20 = r38.getExt();     // Catch: Exception -> L63
        if (r20 == null) goto L48;
        r16.putAll((Map) ZeusTransformUtils.preCheckCast(r20, Map.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L63
    L48:
        IMAppAction r21 = IMAppAction.copy$default(r11.b().b(), 0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);     // Catch: Exception -> L63
        r21.setExt(r16);     // Catch: Exception -> L63
        String r22 = r11.a().getAction();     // Catch: Exception -> L63
        String r23 = r11.a().getPackageName();     // Catch: Exception -> L63
        String r24 = r11.a().getImplClassName();     // Catch: Exception -> L63
        if (r24 != null) goto L68;
        r24 = "";
    L68:
        IntentExecutionRecord r25 = new IntentExecutionRecord(r22, r23, r24, r38, false);     // Catch: Exception -> L61
        ILogDepend.Companion r26 = ILogDepend.Companion;     // Catch: Exception -> L61
        StringBuilder r27 = new StringBuilder().append("enqueue final Omni tool audit, jobId=").append(r5.e()).append(", actionId=");     // Catch: Exception -> L61
        if (r7 != null) goto L55;
        r7 = "";
    L55:
        r26.i("ToolAuditLogger", r27.append(r7).append(", recordIndex=").append(r14).toString());     // Catch: Exception -> L61
        c r28 = null;
        a(r12, r21, p.a(new h(r25, r14, j.a(r38))), null);     // Catch: Exception -> L59
        return r5;
    L59:
        e = e;
    L65:
        ILogDepend.Companion.e("ToolAuditLogger", "final Omni tool audit preparation failed: " + e.getClass().getSimpleName());
        return r28;
    L61:
        e = e;
        r28 = null;
        goto L65
    L36:
        r15 = null;
        goto L37
    L19:
        if (o.a(r8, "null") == true) goto L21;
    L15:
        r7 = null;
        goto L16
    L11:
        r6 = null;
    L63:
        e = e;
        r28 = null;
        goto L65
    }

    private final g a(Collection<c> r18, Map<?, ?> r19) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r18, Collection.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        if (r2 != null) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if (r2 == null) goto L11;
        Object r3 = r2.get(Ext.KEY_ACTION_ID);
    L13:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L15;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L17:
        if (r4 != null) goto L19;
    L26:
        r4 = null;
    L28:
        if (r6 == false) goto L33;
        if (r4 != null) goto L33;
        ILogDepend.Companion.e("ToolAuditLogger", "skip final Omni tool audit: malformed explicit actionId");
        return null;
    L33:
        if (r2 != null) goto L35;
    L37:
        boolean r10 = false;
    L38:
        if (r2 == null) goto L40;
        Object r7 = r2.get(Ext.KEY_INTENT_NAME);
    L42:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L44;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L45:
        if (r8 != null) goto L47;
    L54:
        r8 = null;
    L55:
        if (r10 == false) goto L59;
        if (r8 != null) goto L59;
        ILogDepend.Companion.e("ToolAuditLogger", "skip final Omni tool audit: malformed explicit intentName");
        return null;
    L59:
        if (r4 != null) goto L61;
        Collection r9 = r0;
    L68:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L70:
        if (r13.hasNext() == false) goto L90;
        c r14 = (c) ZeusTransformUtils.preCheckCast(r13.next(), c.class, "com.obric.aiagent.plugin");
        Iterable r15 = p.r((Iterable) ZeusTransformUtils.preCheckCast(r14.a(), Iterable.class, "com.obric.aiagent.plugin"));
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r15.iterator();
    L73:
        if (r17.hasNext() == false) goto L89;
        ai r110 = (ai) ZeusTransformUtils.preCheckCast(r17.next(), ai.class, "com.obric.aiagent.plugin");
        c.b r20 = (c.b) ZeusTransformUtils.preCheckCast(r110.b(), c.b.class, "com.obric.aiagent.plugin");
        IntentResult<?> r111 = r20.b().a();
        if (r111 != null) goto L77;
    L85:
        g r21 = null;
    L86:
        if (r21 == null) goto L73;
        r16.add(r21);
        goto L73
    L77:
        if (r111.isFinal() == true) goto L85;
        String r112 = r20.a().getAction();
        String r113 = r20.a().getImplClassName();
        if (r113 != null) goto L81;
        String r22 = "";
    L83:
        if (j.a(r112, r22) == false) goto L85;
        int r114 = r110.a();
        o.a(r20);
        r21 = new g(r14, r114, r20);
        goto L86
    L81:
        r22 = r113;
        goto L83
    L89:
        p.a(r12, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        goto L70
    L90:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L94;
        if (r8 == null) goto L94;
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r26 = r24.iterator();
    L97:
        if (r26.hasNext() == false) goto L101;
        Object r27 = r26.next();
        if (d.o.o.a(((g) ZeusTransformUtils.preCheckCast(r27, g.class, "com.obric.aiagent.plugin")).c().a().getAction(), r8, true) == false) goto L97;
        r25.add(r27);
        goto L97
    L101:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin");
    L102:
        g r1 = (g) ZeusTransformUtils.preCheckCast(p.p(r28), g.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L111;
        if (r8 != null) goto L106;
    L109:
        if (r5 == false) goto L111;
    L112:
        if (r1 != null) goto L121;
        ILogDepend.Companion r29 = ILogDepend.Companion;
        StringBuilder r30 = new StringBuilder().append("skip final Omni tool audit: pending record is not unique, actionId=");
        if (r4 != null) goto L116;
        r4 = "";
    L116:
        StringBuilder r31 = r30.append(r4).append(", intentName=");
        if (r8 != null) goto L119;
        r8 = "";
    L119:
        r29.e("ToolAuditLogger", r31.append(r8).append(", jobs=").append(r0.size()).append(", pendingRecords=").append(r23.size()).append(", matchedRecords=").append(r28.size()).toString());
        return null;
    L121:
        return r1;
    L106:
        if (d.o.o.a(r1.c().a().getAction(), r8, true) == true) goto L109;
        r5 = false;
    L111:
        r1 = null;
    L94:
        r28 = r23;
        goto L102
    L61:
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r34 = r32.iterator();
    L63:
        if (r34.hasNext() == false) goto L67;
        Object r115 = r34.next();
        if (o.a(String.valueOf(((c) ZeusTransformUtils.preCheckCast(r115, c.class, "com.obric.aiagent.plugin")).b().getActionId()), r4) == false) goto L63;
        r33.add(r115);
        goto L63
    L67:
        r9 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r33, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
        goto L68
    L47:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L49;
    L51:
        boolean r35 = false;
    L52:
        if (r35 == false) goto L54;
    L49:
        if (o.a(r8, "null") == true) goto L51;
        r35 = true;
        goto L52
    L44:
        r8 = null;
        goto L45
    L40:
        r7 = null;
        goto L42
    L35:
        if (r2.containsKey(Ext.KEY_INTENT_NAME) != true) goto L37;
        r10 = true;
        goto L38
    L19:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L21;
    L23:
        boolean r36 = false;
    L24:
        if (r36 == false) goto L26;
    L21:
        if (o.a(r4, "null") == true) goto L23;
        r36 = true;
        goto L24
    L15:
        r4 = null;
        goto L17
    L11:
        r3 = null;
        goto L13
    L5:
        if (r2.containsKey(Ext.KEY_ACTION_ID) != true) goto L7;
        r6 = true;
        goto L9
    }

    private final void a(final IMAppAction r3, final IMAppAction r4, List<h> r5, final Boolean r6) {
        final List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        ILogDepend.Companion.d("ToolAuditLogger", "skip tool audit: records unavailable, messageId=" + r3.getMessageId() + ", questionId=" + r3.getQuestionId());
        return;
    L7:
        if (r2.isEmpty() == false) goto L15;
        ILogDepend.Companion.d("ToolAuditLogger", "skip tool audit: records empty, messageId=" + r3.getMessageId() + ", questionId=" + r3.getQuestionId() + ", hasError=" + r6);
        return;
    L15:
        f18561b.execute(new $$Lambda$i$3sSjdJglbbSUxQzs3oY2ouOR_aI(r3, r2, r6, r4));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ILogDepend.Companion.e("ToolAuditLogger", "tool audit enqueue failed: " + e.getClass().getSimpleName());
    }

    private static final void a(IMAppAction r9, List r10, Boolean r11, IMAppAction r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        String r3 = j.a(r9);     // Catch: Exception -> L51
        ILogDepend.Companion.w("ToolAuditLogger", "write tool audit start, instructionId=" + r3 + ", messageId=" + r9.getMessageId() + ", questionId=" + r9.getQuestionId() + ", records=" + r13.size() + ", hasError=" + r11);     // Catch: Exception -> L51
        b r14 = j.a(r9, r12, r3);     // Catch: Exception -> L51
        ILogDepend.Companion r4 = ILogDepend.Companion;     // Catch: Exception -> L51
        StringBuilder r0 = new StringBuilder().append("start tool audit: records=").append(r13.size()).append(", messageId=").append(r9.getMessageId()).append(", questionId=").append(r9.getQuestionId()).append(", instructionId=");     // Catch: Exception -> L51
        String r5 = j.a(r14.a());     // Catch: Exception -> L51
        String r6 = "";
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        StringBuilder r1 = r0.append(r5).append(", omniLogId=");     // Catch: Exception -> L51
        String r7 = j.b(r14.a());     // Catch: Exception -> L51
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        StringBuilder r2 = r1.append(r7).append(", referenceMsgId=");     // Catch: Exception -> L51
        String r8 = j.c(r14.a());     // Catch: Exception -> L51
        if (r8 == null) goto L14;
        r6 = r8;
    L14:
        StringBuilder r15 = r2.append(r6).append(", toolInputs=").append(r14.b().size()).append(", hasQuery=");     // Catch: Exception -> L51
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.a().a(new String[]{DownloadConstants.QUERY_KEY}), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
        boolean r17 = false;
        if (r16 != null) goto L17;
    L20:
        boolean r18 = true;
    L21:
        if (r18 == true) goto L23;
        boolean r19 = true;
    L24:
        StringBuilder r20 = r15.append(r19).append(", hasInputCheckInfo=");     // Catch: Exception -> L51
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.a().a(new String[]{"check_user_input_audit_info"}), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
        if (r21 != null) goto L27;
    L30:
        boolean r22 = true;
    L31:
        if (r22 == true) goto L33;
        boolean r23 = true;
    L34:
        StringBuilder r24 = r20.append(r23).append(", hasOutputCheckInfo=");     // Catch: Exception -> L51
        CharSequence r25 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.a().a(new String[]{"check_llm_output_audit_info"}), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
        if (r25 != null) goto L37;
    L40:
        boolean r26 = true;
    L41:
        if (r26 == true) goto L43;
        r17 = true;
    L43:
        r4.i("ToolAuditLogger", r24.append(r17).toString());     // Catch: Exception -> L51
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L51
    L44:
        if (r110.hasNext() == false) goto L62;
        h r27 = (h) ZeusTransformUtils.preCheckCast(r110.next(), h.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
        IntentExecutionRecord r28 = r27.a();     // Catch: Exception -> L51
        if (j.a(r28) == true) goto L48;
        j.a(r28, r12, r14.a(r27.b()), r27.c());     // Catch: Exception -> L51
        goto L44
    L48:
        ILogDepend.Companion.i("ToolAuditLogger", "defer non-final Omni tool audit, messageId=" + r9.getMessageId() + ", questionId=" + r9.getQuestionId() + ", recordIndex=" + r27.b() + ", intentName=" + r28.getIntentName());     // Catch: Exception -> L51
        goto L44
    L62:
        return;
    L37:
        if (d.o.o.d(r25) == true) goto L40;
        r26 = false;
        goto L41
    L33:
        r23 = false;
        goto L34
    L27:
        if (d.o.o.d(r21) == true) goto L30;
        r22 = false;
        goto L31
    L23:
        r19 = false;
        goto L24
    L17:
        if (d.o.o.d(r16) == true) goto L20;
        r18 = false;
    L51:
        e = move-exception;
        ILogDepend.Companion.e("ToolAuditLogger", "tool audit write failed: " + e.getClass().getSimpleName());
    }

    public final Map<String, String> a(String r5, String r6) {
        String r4 = j.a(r5);
        if (r4 == null) goto L16;
        Object r7 = f18562c;
        monitor-enter(r7);
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(f18563d.get(r4), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        ILogDepend.Companion.i("ToolAuditLogger", "find message ext hit cache: instructionId=" + r4 + ", extKeys=" + r0.keySet().size());     // Catch: Throwable -> L13
        Map<String, String> r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(r0), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        monitor-exit(r7);
        return r8;
    L11:
        monitor-exit(r7);
    L13:
        th = move-exception;
        throw th;
    L16:
        String r9 = j.a(r6);
        if (r9 != null) goto L19;
        return null;
    L19:
        Map<String, String> r10 = j.b(r9);
        if (r10 != null) goto L22;
        return null;
    L22:
        if (r4 != null) goto L24;
    L33:
        return r10;
    L24:
        if ((!r10.isEmpty()) == false) goto L33;
        Object r11 = f18562c;
        monitor-enter(r11);
        LinkedHashMap<String, Map<String, String>> r1 = f18563d;     // Catch: Throwable -> L30
        r1.clear();     // Catch: Throwable -> L30
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")).put(r4, new LinkedHashMap(r10));     // Catch: Throwable -> L30
        x r12 = x.f38692a;     // Catch: Throwable -> L30
        monitor-exit(r11);
    L30:
        th = move-exception;
        throw th;
    }
}
