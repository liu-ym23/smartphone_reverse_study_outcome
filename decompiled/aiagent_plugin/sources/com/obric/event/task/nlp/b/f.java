package com.obric.event.task.nlp.b;

import android.content.Context;
import android.util.EventsUtils;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.event.task.nlp.api.n;
import com.obric.event.task.nlp.spi.IEventTaskNlpDepend;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskNlpManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f32960a = null;

    /* JADX INFO: compiled from: EventTaskNlpManager.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32961a = null;

        static {
            int[] r0 = new int[com.obric.event.task.nlp.api.f.values().length];
            r0[com.obric.event.task.nlp.api.f.f32904a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.obric.event.task.nlp.api.f.f32906c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.obric.event.task.nlp.api.f.f32905b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f32961a = r0;
        }
    }

    /* JADX INFO: compiled from: EventTaskNlpManager.kt */
    @d.c.b.a.f(b = "EventTaskNlpManager.kt", c = {277}, d = "checkDTOBaseValid", e = "com.obric.event.task.nlp.manager.EventTaskNlpManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f32963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f32964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f32965d;

        b(f r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32964c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32963b = r3;
            this.f32965d |= Integer.MIN_VALUE;
            return f.a(this.f32964c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskNlpManager.kt */
    @d.c.b.a.f(b = "EventTaskNlpManager.kt", c = {246}, d = "convertJson2Dto", e = "com.obric.event.task.nlp.manager.EventTaskNlpManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f32967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f32968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f32969d;

        c(f r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32968c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32967b = r3;
            this.f32969d |= Integer.MIN_VALUE;
            return f.a(this.f32968c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskNlpManager.kt */
    @d.c.b.a.f(b = "EventTaskNlpManager.kt", c = {27, 37}, d = "createConditionTaskDraft", e = "com.obric.event.task.nlp.manager.EventTaskNlpManager")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f32972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f32973d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f32974e;
        int f;

        d(f r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32974e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32973d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f32974e.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskNlpManager.kt */
    @d.c.b.a.f(b = "EventTaskNlpManager.kt", c = {301}, d = "handleConditionCandidate", e = "com.obric.event.task.nlp.manager.EventTaskNlpManager")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f32977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f32978d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f32979e;
        /* synthetic */ Object f;
        final /* synthetic */ f g;
        int h;

        e(f r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return f.a(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.event.task.nlp.b.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventTaskNlpManager.kt */
    @d.c.b.a.f(b = "EventTaskNlpManager.kt", c = {125, 133, 144, 149, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT, 212}, d = "submitTaskFromQuery", e = "com.obric.event.task.nlp.manager.EventTaskNlpManager")
    static final class C0901f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f32982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f32983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f32984e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ f h;
        int i;

        C0901f(f r3, d.c.d<? super C0901f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: EventTaskNlpManager.kt */
    @d.c.b.a.f(b = "EventTaskNlpManager.kt", c = {79, EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "updateTaskFromQuery", e = "com.obric.event.task.nlp.manager.EventTaskNlpManager")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f32987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f32988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f32989e;
        int f;

        g(f r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32989e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32988d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f32989e.b(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private f() {
    }

    public static final /* synthetic */ Object a(f r2, com.obric.event.task.nlp.api.g r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, String r3, com.obric.event.task.nlp.api.g r4, Context r5, d.c.d r6) {
        return r2.a(r3, r4, (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f32960a = new f();
        TAG = "EventTaskNlpManager";
    }

    public final Object a(String r10, String r11, Context r12, d.c.d<? super com.obric.event.task.nlp.api.d<String>> r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, d.class) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.f32973d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        String r7 = "";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        com.obric.event.task.nlp.api.g r9 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r1.f32972c, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r1.f32971b, String.class, "com.obric.aiagent.plugin");
        f r17 = (f) ZeusTransformUtils.preCheckCast(r1.f32970a, f.class, "com.obric.aiagent.plugin");
        o.a(r16);
    L31:
        com.obric.event.task.nlp.api.d r18 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r16, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        if (r18.a() != null) goto L39;
        String r19 = r18.b();
        if (r19 == null) goto L37;
        r7 = r19;
    L37:
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "createConditionTaskDraft handleConditionCandidate error, msg = " + r7);
        return r17.a(r7, r18.c());
    L39:
        r9.a(r10);
        r9.a(n.f32939a);
        r9.a(com.obric.event.task.nlp.api.m.f32935a);
        com.obric.event.task.nlp.api.d<String> r20 = com.obric.event.task.nlp.b.g.f32990a.a(r9);
        if (r20.a() != null) goto L47;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "createConditionTaskDraft convertDto2Json error");
        String r110 = r20.b();
        if (r110 == null) goto L46;
        r7 = r110;
    L46:
        return r17.a(r7, r20.c());
    L47:
        com.obric.event.task.nlp.b.c r111 = com.obric.event.task.nlp.b.c.f32953a;
        String r112 = r20.a();
        d.h.b.o.a(r112);
        r111.b(r10, (String) ZeusTransformUtils.preCheckCast(r112, String.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "createConditionTaskDraft return success");
        String r21 = r20.a();
        d.h.b.o.a(r21);
        return r17.a((String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (Context) ZeusTransformUtils.preCheckCast(r1.f32972c, Context.class, "com.obric.aiagent.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r1.f32971b, String.class, "com.obric.aiagent.plugin");
        f this = (f) ZeusTransformUtils.preCheckCast(r1.f32970a, f.class, "com.obric.aiagent.plugin");
        o.a(r16);
    L19:
        com.obric.event.task.nlp.api.d r113 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r16, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.a.a r114 = com.obric.event.task.nlp.a.a.f32889a;
        String r0 = TAG;
        r114.b(r0, "createConditionTaskDraft checkResult result = " + r113.a() + ", errMsg = " + r113.b());
        if (r113.a() != null) goto L27;
        String r115 = r113.b();
        if (r115 == null) goto L25;
        r7 = r115;
    L25:
        com.obric.event.task.nlp.a.a.f32889a.d(r0, "createConditionTaskDraft check data error");
        return this.a(r7, r113.c());
    L27:
        Object r116 = r113.a();
        d.h.b.o.a(r116);
        com.obric.event.task.nlp.api.g r117 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r116, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        r1.f32970a = this;
        r1.f32971b = r10;
        r1.f32972c = r117;
        r1.f = 2;
        r16 = this.a(r10, r117, r14, r1);
        if (r16 != r3) goto L30;
        return r3;
    L30:
        r17 = this;
        r9 = r117;
        goto L31
    L16:
        o.a(r16);
        r1.f32970a = this;
        r1.f32971b = r10;
        r1.f32972c = r14;
        r1.f = 1;
        r16 = a(r11, r1);
        if (r16 != r3) goto L19;
        return r3;
    L7:
        r1 = new d(this, r15);
        goto L8
    }

    public final Object b(String r11, String r12, Context r13, d.c.d<? super com.obric.event.task.nlp.api.d<String>> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, g.class) == false) goto L7;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r17 = r1.f32988d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        String r7 = "";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        com.obric.event.task.nlp.api.g r10 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r1.f32987c, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        r11 = (String) ZeusTransformUtils.preCheckCast(r1.f32986b, String.class, "com.obric.aiagent.plugin");
        f r18 = (f) ZeusTransformUtils.preCheckCast(r1.f32985a, f.class, "com.obric.aiagent.plugin");
        o.a(r17);
    L49:
        com.obric.event.task.nlp.api.d r19 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r17, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        if (r19.a() != null) goto L57;
        String r110 = r19.b();
        if (r110 == null) goto L55;
        r7 = r110;
    L55:
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "updateTaskFromQuery handleConditionCandidate error, msg = " + r7);
        return r18.a(r7, r19.c());
    L57:
        r10.a(n.f32939a);
        com.obric.event.task.nlp.api.d<String> r111 = com.obric.event.task.nlp.b.g.f32990a.a(r10);
        if (r111.a() != null) goto L65;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "updateTaskFromQuery convertDto2Json error");
        String r112 = r111.b();
        if (r112 == null) goto L64;
        r7 = r112;
    L64:
        return r18.a(r7, r111.c());
    L65:
        com.obric.event.task.nlp.b.c r113 = com.obric.event.task.nlp.b.c.f32953a;
        String r114 = r111.a();
        d.h.b.o.a(r114);
        r113.b(r11, (String) ZeusTransformUtils.preCheckCast(r114, String.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "updateTaskFromQuery return success");
        String r115 = r111.a();
        d.h.b.o.a(r115);
        return r18.a((String) ZeusTransformUtils.preCheckCast(r115, String.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r15 = (Context) ZeusTransformUtils.preCheckCast(r1.f32987c, Context.class, "com.obric.aiagent.plugin");
        r11 = (String) ZeusTransformUtils.preCheckCast(r1.f32986b, String.class, "com.obric.aiagent.plugin");
        f this = (f) ZeusTransformUtils.preCheckCast(r1.f32985a, f.class, "com.obric.aiagent.plugin");
        o.a(r17);
    L37:
        com.obric.event.task.nlp.api.d r116 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r17, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.a.a r117 = com.obric.event.task.nlp.a.a.f32889a;
        String r0 = TAG;
        r117.b(r0, "updateTaskFromQuery checkResult result = " + r116.a() + ", errMsg = " + r116.b());
        if (r116.a() != null) goto L45;
        String r118 = r116.b();
        if (r118 == null) goto L43;
        r7 = r118;
    L43:
        com.obric.event.task.nlp.a.a.f32889a.d(r0, "updateTaskFromQuery check data error");
        return this.a(r7, r116.c());
    L45:
        Object r119 = r116.a();
        d.h.b.o.a(r119);
        com.obric.event.task.nlp.api.g r120 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r119, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        r1.f32985a = this;
        r1.f32986b = r11;
        r1.f32987c = r120;
        r1.f = 2;
        r17 = this.a(r11, r120, r15, r1);
        if (r17 != r3) goto L48;
        return r3;
    L48:
        r18 = this;
        r10 = r120;
        goto L49
    L16:
        o.a(r17);
        com.obric.event.task.nlp.a.a r121 = com.obric.event.task.nlp.a.a.f32889a;
        String r2 = TAG;
        r121.b(r2, "updateTaskFromQuery key = " + r11);
        String r122 = com.obric.event.task.nlp.b.c.f32953a.a(r11);
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r122, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L26;
        com.obric.event.task.nlp.a.a.f32889a.d(r2, "updateTaskFromQuery origin data not fount");
        return a("origin data not fount", ErrorCode.EventTask.TARGET_DATA_NOT_FOUND);
    L26:
        com.obric.event.task.nlp.api.d<String> r123 = com.obric.event.task.nlp.b.g.f32990a.a(r122, r12);
        if (r123.a() != null) goto L34;
        String r124 = r123.b();
        if (r124 == null) goto L32;
        r7 = r124;
    L32:
        com.obric.event.task.nlp.a.a.f32889a.d(r2, "updateTaskFromQuery merge json error, msg = " + r7);
        return a(r7, r123.c());
    L34:
        String r125 = r123.a();
        d.h.b.o.a(r125);
        String r126 = (String) ZeusTransformUtils.preCheckCast(r125, String.class, "com.obric.aiagent.plugin");
        r1.f32985a = this;
        r1.f32986b = r11;
        r1.f32987c = r15;
        r1.f = 1;
        r17 = a(r126, r1);
        if (r17 != r3) goto L37;
        return r3;
    L19:
        if (r5.length() == 0) goto L22;
        r6 = false;
    L7:
        r1 = new g(this, r16);
        goto L8
    }

    public final Object a(String r27, String r28, d.c.d<? super com.obric.event.task.nlp.api.d<String>> r29) {
        f r0 = this;
        String r1 = r27;
        String r2 = r28;
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, C0901f.class) == false) goto L7;
        C0901f r8 = (C0901f) ZeusTransformUtils.preCheckCast(r6, C0901f.class, "com.obric.aiagent.plugin");
        if ((r8.i & Integer.MIN_VALUE) == 0) goto L7;
        r8.i -= Integer.MIN_VALUE;
    L8:
        Object r7 = r8.g;
        Object r9 = d.c.a.b.a();
        String r12 = "";
        switch(r8.i) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.f32983d, String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.f32982c, String.class, "com.obric.aiagent.plugin");
        EventTask r5 = (EventTask) ZeusTransformUtils.preCheckCast(r8.f32981b, EventTask.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8.f32980a, String.class, "com.obric.aiagent.plugin");
        o.a(r7);     // Catch: Exception -> L15
        String r19 = "submitTaskFromQuery ";
    L129:
        String r11 = r3;
        EventTask r13 = r5;
        String r14 = r10;
    L131:
        com.obric.event.task.base.report.b.f32757a.a((ConditionTask) ZeusTransformUtils.preCheckCast(r13, ConditionTask.class, "com.obric.aiagent.plugin"), r14);     // Catch: Exception -> L133
        com.obric.event.task.base.report.o.a(com.obric.event.task.base.report.o.f32870a, (ConditionTask) ZeusTransformUtils.preCheckCast(r13, ConditionTask.class, "com.obric.aiagent.plugin"), r14, DownloadConstants.QUERY_KEY, null, null, 24, null);     // Catch: Exception -> L133
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "submitTaskFromQuery success");     // Catch: Exception -> L133
        return new com.obric.event.task.nlp.api.d(r11, null, 0, r4, 2, null);
    L133:
        Exception e2 = e;
    L134:
        String r15 = "update status exception, e = " + e2.getMessage();
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, r19 + r15, (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));
        return new com.obric.event.task.nlp.api.d(null, r15, ErrorCode.EventTask.UPDATE_STATUS_ERROR, null, 8, null);
    L15:
        e2 = e;
        r19 = "submitTaskFromQuery ";
        goto L134
    L17:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r8.f32984e, String.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r8.f32983d, String.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r8.f32982c, String.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r8.f32981b, String.class, "com.obric.aiagent.plugin");
        f r20 = (f) ZeusTransformUtils.preCheckCast(r8.f32980a, f.class, "com.obric.aiagent.plugin");
        o.a(r7);
        r19 = "submitTaskFromQuery ";
        String r111 = "";
    L80:
        EventTaskResult r112 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r7, EventTaskResult.class, "com.obric.aiagent.plugin");
        String r113 = r110;
        String r114 = r18;
        String r21 = r17;
    L82:
        String r22 = r16;
        EventTaskResult r23 = r112;
    L83:
        com.obric.event.task.nlp.a.a r24 = com.obric.event.task.nlp.a.a.f32889a;
        String r115 = TAG;
        StringBuilder r116 = new StringBuilder().append("createConditionTaskDraft addResult code = ");
        if (r23 == null) goto L86;
        Integer r117 = d.c.b.a.b.a(r23.getCode());
    L87:
        r24.b(r115, r116.append(r117).toString());
        if (r23 != null) goto L92;
        return r20.a("addEventTask result empty", ErrorCode.EventTask.ADD_TASK_ERROR);
    L92:
        if (r23.getCode() != 0) goto L94;
        List<EventTask> r25 = r23.getData();
        boolean r118 = false;
        if (r25 == null) goto L98;
        r13 = (EventTask) ZeusTransformUtils.preCheckCast(r25.get(0), EventTask.class, "com.obric.aiagent.plugin");
    L99:
        if (r13 == null) goto L136;
        CharSequence r119 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.getId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r119 != null) goto L103;
    L104:
        r118 = true;
    L105:
        if (r118 == true) goto L136;
        if (ZeusTransformUtils.instanceOf(r13, ConditionTask.class) == false) goto L136;
        JSONObject r26 = new JSONObject(r21);     // Catch: Exception -> L133
        r26.put("eca_id", ((ConditionTask) ZeusTransformUtils.preCheckCast(r13, ConditionTask.class, "com.obric.aiagent.plugin")).getId());     // Catch: Exception -> L133
        if (r26.has("status") == false) goto L113;
        r26.put("status", "submitted");     // Catch: Exception -> L133
    L113:
        if (r26.has("runtime_status") == false) goto L122;
        String r30 = "open";
        Integer r31 = ((ConditionTask) ZeusTransformUtils.preCheckCast(r13, ConditionTask.class, "com.obric.aiagent.plugin")).getEnableStatus();     // Catch: Exception -> L133
        if (r31 != null) goto L118;
    L119:
        r30 = "closed";
        String r120 = "the number of open tasks has exceeded the limit, so the current task is now closed.";
    L121:
        r26.put("runtime_status", r30);     // Catch: Exception -> L133
    L123:
        String r32 = r26.toString();     // Catch: Exception -> L133
        d.h.b.o.c(r32, "toString(...)");     // Catch: Exception -> L133
        com.obric.event.task.nlp.a.a.f32889a.b(r115, "submitTaskFromQuery final json success");     // Catch: Exception -> L133
        com.obric.event.task.nlp.b.c.f32953a.b(r113, r32);     // Catch: Exception -> L133
        com.obric.event.task.nlp.b.c r33 = com.obric.event.task.nlp.b.c.f32953a;     // Catch: Exception -> L133
        String r34 = ((ConditionTask) ZeusTransformUtils.preCheckCast(r13, ConditionTask.class, "com.obric.aiagent.plugin")).getId();     // Catch: Exception -> L133
        d.h.b.o.a(r34);     // Catch: Exception -> L133
        r33.c(r113, r34);     // Catch: Exception -> L133
        IEventTaskNlpDepend r35 = (IEventTaskNlpDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskNlpDepend.class), IEventTaskNlpDepend.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L133
        if (r35 == null) goto L130;
        ConditionTask r36 = (ConditionTask) ZeusTransformUtils.preCheckCast(r13, ConditionTask.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L133
        r8.f32980a = r22;     // Catch: Exception -> L133
        r8.f32981b = r13;     // Catch: Exception -> L133
        r8.f32982c = r120;     // Catch: Exception -> L133
        r8.f32983d = r32;     // Catch: Exception -> L133
        r8.f32984e = null;     // Catch: Exception -> L133
        r8.f = null;     // Catch: Exception -> L133
        r8.i = 6;     // Catch: Exception -> L133
        if (r35.showTaskCard(r36, r114, r8) != r9) goto L128;
        return r9;
    L128:
        r5 = r13;
        r3 = r32;
        r10 = r22;
        r4 = r120;
        goto L129
    L130:
        r11 = r32;
        r4 = r120;
        r14 = r22;
        goto L131
    L118:
        if (r31.intValue() != 0) goto L119;
        r120 = r111;
        goto L121
    L122:
        r120 = r111;
        goto L123
    L103:
        if (r119.length() != 0) goto L105;
    L136:
        com.obric.event.task.nlp.a.a.f32889a.d(r115, "createConditionTaskDraft addEventTask error, msg = task empty");
        return r20.a("addEventTask error, msg = task empty", ErrorCode.EventTask.ADD_TASK_ERROR);
    L98:
        r13 = null;
        goto L99
    L94:
        return r20.a("addEventTask error, code = " + r23.getCode() + ", msg = " + r23.getMsg(), ErrorCode.EventTask.ADD_TASK_ERROR);
    L86:
        r117 = null;
        goto L87
    L18:
        String r37 = (String) ZeusTransformUtils.preCheckCast(r8.f32984e, String.class, "com.obric.aiagent.plugin");
        String r38 = (String) ZeusTransformUtils.preCheckCast(r8.f32983d, String.class, "com.obric.aiagent.plugin");
        String r39 = (String) ZeusTransformUtils.preCheckCast(r8.f32982c, String.class, "com.obric.aiagent.plugin");
        String r121 = (String) ZeusTransformUtils.preCheckCast(r8.f32981b, String.class, "com.obric.aiagent.plugin");
        r20 = (f) ZeusTransformUtils.preCheckCast(r8.f32980a, f.class, "com.obric.aiagent.plugin");
        o.a(r7);
        r111 = "";
    L69:
        EventTaskResult r40 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r7, EventTaskResult.class, "com.obric.aiagent.plugin");
        r113 = r121;
        r114 = r39;
        r21 = r38;
        r22 = r37;
        r23 = r40;
    L71:
        r19 = "submitTaskFromQuery ";
        goto L83
    L19:
        IEventTaskApi r41 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(r8.f, IEventTaskApi.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.d r42 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r8.f32984e, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        r21 = (String) ZeusTransformUtils.preCheckCast(r8.f32983d, String.class, "com.obric.aiagent.plugin");
        r114 = (String) ZeusTransformUtils.preCheckCast(r8.f32982c, String.class, "com.obric.aiagent.plugin");
        r113 = (String) ZeusTransformUtils.preCheckCast(r8.f32981b, String.class, "com.obric.aiagent.plugin");
        r20 = (f) ZeusTransformUtils.preCheckCast(r8.f32980a, f.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L60:
        ConditionTask r43 = (ConditionTask) ZeusTransformUtils.preCheckCast(r7, ConditionTask.class, "com.obric.aiagent.plugin");
    L62:
        if (r43 != null) goto L72;
        r22 = "create";
        r111 = "";
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "submitTaskFromQuery execute add task");
        if (r41 == null) goto L70;
        Object r44 = r42.a();
        d.h.b.o.a(r44);
        EventTaskSpec r45 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(r44, EventTaskSpec.class, "com.obric.aiagent.plugin");
        r8.f32980a = r20;
        r8.f32981b = r113;
        r8.f32982c = r114;
        r8.f32983d = r21;
        r8.f32984e = "create";
        r8.f = null;
        r8.i = 4;
        Object r46 = r41.addEventTask(r45, r8);
        if (r46 != r9) goto L68;
        return r9;
    L68:
        r38 = r21;
        r39 = r114;
        r121 = r113;
        r7 = r46;
        r37 = "create";
        goto L69
    L70:
        r23 = null;
        goto L71
    L72:
        r111 = "";
        r19 = "submitTaskFromQuery ";
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "submitTaskFromQuery execute update task");
        ConditionTaskSpec r47 = (ConditionTaskSpec) ZeusTransformUtils.preCheckCast(r42.a(), ConditionTaskSpec.class, "com.obric.aiagent.plugin");
        if (r47 == null) goto L75;
        r47.setEnableStatus(r43.getEnableStatus());
    L75:
        if (r41 == null) goto L81;
        d.h.b.o.a(r47);
        EventTaskSpec r48 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(r47, EventTaskSpec.class, "com.obric.aiagent.plugin");
        r8.f32980a = r20;
        r8.f32981b = r113;
        r8.f32982c = r114;
        r8.f32983d = r21;
        r8.f32984e = "update";
        r8.f = null;
        r8.i = 5;
        r7 = r41.updateEventTask(r113, r48, r8);
        if (r7 != r9) goto L79;
        return r9;
    L79:
        r17 = r21;
        r18 = r114;
        r16 = "update";
        r110 = r113;
        goto L80
    L81:
        r16 = "update";
        r112 = null;
        goto L82
    L20:
        String r49 = (String) ZeusTransformUtils.preCheckCast(r8.f32983d, String.class, "com.obric.aiagent.plugin");
        String r50 = (String) ZeusTransformUtils.preCheckCast(r8.f32982c, String.class, "com.obric.aiagent.plugin");
        String r51 = (String) ZeusTransformUtils.preCheckCast(r8.f32981b, String.class, "com.obric.aiagent.plugin");
        r20 = (f) ZeusTransformUtils.preCheckCast(r8.f32980a, f.class, "com.obric.aiagent.plugin");
        o.a(r7);
        r114 = r50;
        r113 = r51;
        r21 = r49;
    L47:
        r42 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r7, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        if (r42.a() != null) goto L55;
        String r52 = r42.b();
        if (r52 == null) goto L53;
        r12 = r52;
    L53:
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "submitTaskFromQuery parseSpec error, msg = " + r12);
        return r20.a(r12, r42.c());
    L55:
        r41 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r41 == null) goto L61;
        r8.f32980a = r20;
        r8.f32981b = r113;
        r8.f32982c = r114;
        r8.f32983d = r21;
        r8.f32984e = r42;
        r8.f = r41;
        r8.i = 3;
        r7 = r41.getConditionTask(r113, r8);
        if (r7 != r9) goto L60;
        return r9;
    L61:
        r43 = null;
        goto L62
    L21:
        String r53 = (String) ZeusTransformUtils.preCheckCast(r8.f32983d, String.class, "com.obric.aiagent.plugin");
        String r54 = (String) ZeusTransformUtils.preCheckCast(r8.f32982c, String.class, "com.obric.aiagent.plugin");
        String r55 = (String) ZeusTransformUtils.preCheckCast(r8.f32981b, String.class, "com.obric.aiagent.plugin");
        f r56 = (f) ZeusTransformUtils.preCheckCast(r8.f32980a, f.class, "com.obric.aiagent.plugin");
        o.a(r7);
        String r57 = r53;
        r0 = r56;
        r2 = r54;
        r1 = r55;
    L35:
        com.obric.event.task.nlp.api.d r58 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r7, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.a.a r122 = com.obric.event.task.nlp.a.a.f32889a;
        String r123 = TAG;
        r122.b(r123, "submitTaskFromQuery checkResult result = " + r58.a() + ", errMsg = " + r58.b());
        if (r58.a() != null) goto L43;
        String r59 = r58.b();
        if (r59 == null) goto L41;
        r12 = r59;
    L41:
        com.obric.event.task.nlp.a.a.f32889a.d(r123, "submitTaskFromQuery check data error");
        return r0.a(r12, r58.c());
    L43:
        com.obric.event.task.nlp.b.g r124 = com.obric.event.task.nlp.b.g.f32990a;
        Object r60 = r58.a();
        d.h.b.o.a(r60);
        com.obric.event.task.nlp.api.g r61 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r60, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        r8.f32980a = r0;
        r8.f32981b = r1;
        r8.f32982c = r2;
        r8.f32983d = r57;
        r8.i = 2;
        r7 = r124.a(r1, r2, r61, r8);
        if (r7 != r9) goto L46;
        return r9;
    L46:
        r113 = r1;
        r114 = r2;
        r21 = r57;
        r20 = r0;
        goto L47
    L22:
        o.a(r7);
        com.obric.event.task.nlp.a.a r62 = com.obric.event.task.nlp.a.a.f32889a;
        String r63 = TAG;
        r62.b(r63, "submitTaskFromQuery key = " + r1 + ", questionId = " + r2);
        r57 = com.obric.event.task.nlp.b.c.f32953a.a(r1);
        CharSequence r125 = (CharSequence) ZeusTransformUtils.preCheckCast(r57, CharSequence.class, "com.obric.aiagent.plugin");
        if (r125 != null) goto L25;
    L28:
        boolean r126 = true;
    L29:
        if (r126 == false) goto L32;
        com.obric.event.task.nlp.a.a.f32889a.d(r63, "submitTaskFromQuery origin data not fount");
        return new com.obric.event.task.nlp.api.d(null, "origin data not fount", ErrorCode.EventTask.TARGET_DATA_NOT_FOUND, null, 8, null);
    L32:
        r8.f32980a = r0;
        r8.f32981b = r1;
        r8.f32982c = r2;
        r8.f32983d = r57;
        r8.i = 1;
        r7 = r0.a(r57, r8);
        if (r7 != r9) goto L35;
        return r9;
    L25:
        if (r125.length() == 0) goto L28;
        r126 = false;
        goto L29
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r8 = new C0901f(r0, r6);
        goto L8
    }

    private final Object a(String r18, d.c.d<? super com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.g>> r19) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
        if ((r4.f32969d & Integer.MIN_VALUE) == 0) goto L7;
        r4.f32969d -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f32967b;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f32969d;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        com.obric.event.task.nlp.api.g r0 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r4.f32966a, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        o.a(r3);
        com.obric.event.task.nlp.api.g r11 = r0;
    L26:
        com.obric.event.task.nlp.api.d r1 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r3, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L35;
        String r7 = r1.b();
        if (r7 != null) goto L31;
        String r10 = "";
    L32:
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "checkData checkDTOBaseValid error, msg = " + r10);
        return new com.obric.event.task.nlp.api.d(null, r10, r1.c(), null, 8, null);
    L31:
        r10 = r7;
        goto L32
    L35:
        return new com.obric.event.task.nlp.api.d(r11, null, 0, null, 10, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r3);
        com.obric.event.task.nlp.a.a r8 = com.obric.event.task.nlp.a.a.f32889a;
        String r9 = TAG;
        r8.b(r9, "checkData start");
        com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.g> r12 = com.obric.event.task.nlp.b.g.f32990a.a(r18);
        com.obric.event.task.nlp.api.g r13 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r12.a(), com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L22;
        String r14 = r12.b();
        if (r14 != null) goto L19;
        String r15 = "";
    L20:
        com.obric.event.task.nlp.a.a.f32889a.d(r9, "checkData parseJSON2DTO error, msg = " + r15);
        com.obric.event.task.nlp.a.a.f32889a.d(r9, "checkData parseJSON2DTO error, jsonStr = " + r18);
        return new com.obric.event.task.nlp.api.d(null, r15, r12.c(), null, 8, null);
    L19:
        r15 = r14;
        goto L20
    L22:
        r4.f32966a = r13;
        r4.f32969d = 1;
        r3 = a(r13, r4);
        if (r3 != r5) goto L25;
        return r5;
    L25:
        r11 = r13;
    L7:
        r4 = new c(this, r2);
        goto L8
    }

    private final com.obric.event.task.nlp.api.d<String> a(String r8, int r9) {
        return new com.obric.event.task.nlp.api.d(null, r8, r9, null, 8, null);
    }

    private final com.obric.event.task.nlp.api.d<String> a(String r8) {
        return new com.obric.event.task.nlp.api.d(r8, null, 0, null, 10, null);
    }

    private final Object a(com.obric.event.task.nlp.api.g r15, d.c.d<? super com.obric.event.task.nlp.api.d<Boolean>> r16) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r16, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L7;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
        if ((r2.f32965d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f32965d -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f32963b;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f32965d;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        com.obric.event.task.nlp.api.g r5 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r2.f32962a, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        o.a(r1);
    L30:
        com.obric.event.task.nlp.api.d r6 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r1, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L34;
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6.a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L35:
        if (r7 == true) goto L39;
        return new com.obric.event.task.nlp.api.d(d.c.b.a.b.a(false), "taskInstruction sensitive check failed", ErrorCode.EventTask.INSTRUCTION_ILLEGAL, null, 8, null);
    L39:
        if (r5.g() != null) goto L53;
        if (r5.h() != null) goto L53;
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r5.i(), Collection.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L45;
    L48:
        boolean r9 = true;
    L49:
        if (r9 == false) goto L53;
        return new com.obric.event.task.nlp.api.d(d.c.b.a.b.a(false), "condition empty", ErrorCode.EventTask.CONDITION_EMPTY, null, 8, null);
    L45:
        if (r8.isEmpty() == true) goto L48;
        r9 = false;
    L53:
        return new com.obric.event.task.nlp.api.d(d.c.b.a.b.a(true), null, 0, null, 10, null);
    L34:
        r7 = true;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "checkDTOBaseValid");
        String r10 = r15.b();
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == true) goto L23;
        IEventTaskNlpDepend r13 = (IEventTaskNlpDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskNlpDepend.class), IEventTaskNlpDepend.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L33;
        r2.f32962a = r15;
        r2.f32965d = 1;
        r1 = r13.checkQuery("", r10, "condition", r2);
        if (r1 != r3) goto L29;
        return r3;
    L29:
        r5 = r15;
        goto L30
    L33:
        r5 = r15;
        goto L34
    L23:
        return new com.obric.event.task.nlp.api.d(d.c.b.a.b.a(false), "taskInstruction is empty", ErrorCode.EventTask.INSTRUCTION_EMPTY, null, 8, null);
    L17:
        if (r11.length() == 0) goto L20;
        r12 = false;
    L7:
        r2 = new b(this, r0);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v50, types: [T, java.lang.String] */
    private final Object a(String r25, com.obric.event.task.nlp.api.g r26, Context r27, d.c.d<? super com.obric.event.task.nlp.api.d<String>> r28) {
        f r0 = this;
        String r1 = r25;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r27, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.f;
        Object r7 = d.c.a.b.a();
        int r8 = r5.h;
        String r10 = "";
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        z.f r3 = (z.f) ZeusTransformUtils.preCheckCast(r5.f32979e, z.f.class, "com.obric.aiagent.plugin");
        r2 = (Context) ZeusTransformUtils.preCheckCast(r5.f32978d, Context.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.g r9 = (com.obric.event.task.nlp.api.g) ZeusTransformUtils.preCheckCast(r5.f32977c, com.obric.event.task.nlp.api.g.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r5.f32976b, String.class, "com.obric.aiagent.plugin");
        f r12 = (f) ZeusTransformUtils.preCheckCast(r5.f32975a, f.class, "com.obric.aiagent.plugin");
        o.a(r6);
        r26 = r9;
        r1 = r11;
        z.f r13 = r3;
        r0 = r12;
        Object r14 = r6;
    L35:
        com.obric.event.task.nlp.api.d r15 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r14, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L40;
    L39:
        r15 = new com.obric.event.task.nlp.api.d(null, "location depend service unavailable", 1, null, 8, null);
    L40:
        com.obric.event.task.nlp.api.i r16 = (com.obric.event.task.nlp.api.i) ZeusTransformUtils.preCheckCast(r15.a(), com.obric.event.task.nlp.api.i.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L51;
        String r17 = r15.b();
        T r18 = r10;
        if (r17 == null) goto L46;
        r18 = r17;
    L46:
        r13.f38504a = r18;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "handleConditionCandidate location candidate error, msg = " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return r0.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), r15.c());
    L51:
        List<com.obric.event.task.nlp.api.e> r19 = r26.i();
        ArrayList r20 = new ArrayList();
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L54;
    L57:
        boolean r111 = true;
    L58:
        if (r111 == true) goto L180;
        int r112 = r19.size();
        if (r112 <= 1) goto L63;
        r13.f38504a = "device size error size = " + r112;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "handleConditionCandidate deviceInfoSize error, " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return r0.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), ErrorCode.EventTask.DEVICE_CONDITION_SIZE_ERROR);
    L63:
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L65:
        if (r21.hasNext() == false) goto L180;
        com.obric.event.task.nlp.api.e r22 = (com.obric.event.task.nlp.api.e) ZeusTransformUtils.preCheckCast(r21.next(), com.obric.event.task.nlp.api.e.class, "com.obric.aiagent.plugin");
        com.obric.event.task.nlp.api.f r113 = r22.getType();
        com.obric.event.task.nlp.a.a r114 = com.obric.event.task.nlp.a.a.f32889a;
        String r23 = TAG;
        r114.b(r23, "handleConditionCandidate deviceCondition type = " + r113);
        if (r113 != null) goto L69;
        int r115 = -1;
    L71:
        if (r115 != 1) goto L73;
        Map<String, Object> r24 = r22.a();
        if (r24 == null) goto L148;
        Object r29 = r24.get(com.obric.event.task.nlp.api.h.c());
    L150:
        if (ZeusTransformUtils.instanceOf(r29, com.obric.event.task.nlp.api.a.class) == false) goto L152;
        com.obric.event.task.nlp.api.a r30 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r29, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L154:
        if (r30 == null) goto L155;
        com.obric.event.task.nlp.api.b r116 = r30.a();
        if (r116 == null) goto L160;
        String r117 = r116.a();
    L161:
        CharSequence r118 = (CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.aiagent.plugin");
        if (r118 != null) goto L164;
    L167:
        boolean r119 = true;
    L168:
        if (r119 == false) goto L178;
        com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.a> r31 = i.f33003a.a(r1, r30);
        if (r31.a() == null) goto L171;
        HashMap r120 = new HashMap();
        Map r121 = (Map) ZeusTransformUtils.preCheckCast(r120, Map.class, "com.obric.aiagent.plugin");
        String r122 = com.obric.event.task.nlp.api.h.c();
        com.obric.event.task.nlp.api.a r32 = r31.a();
        d.h.b.o.a(r32);
        r121.put(r122, r32);
        com.obric.event.task.nlp.api.e r33 = new com.obric.event.task.nlp.api.e(com.obric.event.task.nlp.api.f.f32904a, (Map) ZeusTransformUtils.preCheckCast(r120, Map.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.a.a.f32889a.b(r23, "handleConditionCandidate sms handle success");
        d.c.b.a.b.a(r20.add(r33));
        goto L65
    L171:
        String r34 = r31.b();
        T r123 = r10;
        if (r34 == null) goto L175;
        r123 = r34;
    L175:
        r13.f38504a = r123;
        com.obric.event.task.nlp.a.a.f32889a.d(r23, "handleConditionCandidate sms info error = " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return f32960a.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), r31.c());
    L178:
        com.obric.event.task.nlp.a.a.f32889a.b(r23, "handleConditionCandidate sms has selected id, id = " + r117);
        goto L65
    L164:
        if (r118.length() == 0) goto L167;
        r119 = false;
        goto L168
    L160:
        r117 = null;
        goto L161
    L155:
        r13.f38504a = "sms params empty";
        com.obric.event.task.nlp.a.a.f32889a.d(r23, "handleConditionCandidate sms info error = " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return f32960a.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), ErrorCode.EventTask.SMS_PARAMS_EMPTY);
    L152:
        r30 = null;
        goto L154
    L148:
        r29 = null;
        goto L150
    L73:
        if (r115 != 2) goto L75;
        Map<String, Object> r35 = r22.a();
        if (r35 == null) goto L114;
        Object r36 = r35.get(com.obric.event.task.nlp.api.h.a());
    L116:
        if (ZeusTransformUtils.instanceOf(r36, com.obric.event.task.nlp.api.a.class) == false) goto L118;
        com.obric.event.task.nlp.api.a r37 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r36, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L120:
        if (r37 == null) goto L121;
        com.obric.event.task.nlp.api.b r124 = r37.a();
        if (r124 == null) goto L126;
        String r125 = r124.a();
    L127:
        CharSequence r126 = (CharSequence) ZeusTransformUtils.preCheckCast(r125, CharSequence.class, "com.obric.aiagent.plugin");
        if (r126 != null) goto L130;
    L133:
        boolean r127 = true;
    L134:
        if (r127 == false) goto L144;
        com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.a> r38 = m.f33011a.a(r1, r37, r2);
        if (r38.a() == null) goto L137;
        HashMap r128 = new HashMap();
        Map r129 = (Map) ZeusTransformUtils.preCheckCast(r128, Map.class, "com.obric.aiagent.plugin");
        String r130 = com.obric.event.task.nlp.api.h.a();
        com.obric.event.task.nlp.api.a r39 = r38.a();
        d.h.b.o.a(r39);
        r129.put(r130, r39);
        com.obric.event.task.nlp.api.e r40 = new com.obric.event.task.nlp.api.e(com.obric.event.task.nlp.api.f.f32906c, (Map) ZeusTransformUtils.preCheckCast(r128, Map.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.a.a.f32889a.b(r23, "handleConditionCandidate wifi handle success");
        d.c.b.a.b.a(r20.add(r40));
        goto L65
    L137:
        String r41 = r38.b();
        T r131 = r10;
        if (r41 == null) goto L141;
        r131 = r41;
    L141:
        r13.f38504a = r131;
        com.obric.event.task.nlp.a.a.f32889a.d(r23, "handleConditionCandidate wifi info error = " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return f32960a.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), r38.c());
    L144:
        com.obric.event.task.nlp.a.a.f32889a.b(r23, "handleConditionCandidate wifi has selected id, id = " + r125);
        goto L65
    L130:
        if (r126.length() == 0) goto L133;
        r127 = false;
        goto L134
    L126:
        r125 = null;
        goto L127
    L121:
        r13.f38504a = "wifi params empty";
        com.obric.event.task.nlp.a.a.f32889a.d(r23, "handleConditionCandidate wifi info error = " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return f32960a.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), ErrorCode.EventTask.WIFI_PARAMS_EMPTY);
    L118:
        r37 = null;
        goto L120
    L114:
        r36 = null;
        goto L116
    L75:
        if (r115 == 3) goto L77;
        com.obric.event.task.nlp.a.a.f32889a.b(r23, "handleConditionCandidate do not handle other type");
        goto L65
    L77:
        Map<String, Object> r42 = r22.a();
        if (r42 == null) goto L80;
        Object r43 = r42.get(com.obric.event.task.nlp.api.h.b());
    L82:
        if (ZeusTransformUtils.instanceOf(r43, com.obric.event.task.nlp.api.a.class) == false) goto L84;
        com.obric.event.task.nlp.api.a r44 = (com.obric.event.task.nlp.api.a) ZeusTransformUtils.preCheckCast(r43, com.obric.event.task.nlp.api.a.class, "com.obric.aiagent.plugin");
    L86:
        if (r44 == null) goto L87;
        com.obric.event.task.nlp.api.b r132 = r44.a();
        if (r132 == null) goto L92;
        String r133 = r132.a();
    L93:
        CharSequence r134 = (CharSequence) ZeusTransformUtils.preCheckCast(r133, CharSequence.class, "com.obric.aiagent.plugin");
        if (r134 != null) goto L96;
    L99:
        boolean r135 = true;
    L100:
        if (r135 == false) goto L110;
        com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.a> r45 = com.obric.event.task.nlp.b.b.f32951a.a(r1, r44, r2);
        if (r45.a() == null) goto L103;
        HashMap r136 = new HashMap();
        Map r137 = (Map) ZeusTransformUtils.preCheckCast(r136, Map.class, "com.obric.aiagent.plugin");
        String r138 = com.obric.event.task.nlp.api.h.b();
        com.obric.event.task.nlp.api.a r46 = r45.a();
        d.h.b.o.a(r46);
        r137.put(r138, r46);
        com.obric.event.task.nlp.api.e r47 = new com.obric.event.task.nlp.api.e(com.obric.event.task.nlp.api.f.f32905b, (Map) ZeusTransformUtils.preCheckCast(r136, Map.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.a.a.f32889a.b(r23, "handleConditionCandidate bluetooth handle success");
        d.c.b.a.b.a(r20.add(r47));
        goto L65
    L103:
        String r48 = r45.b();
        T r139 = r10;
        if (r48 == null) goto L107;
        r139 = r48;
    L107:
        r13.f38504a = r139;
        com.obric.event.task.nlp.a.a.f32889a.d(r23, "handleConditionCandidate bluetooth info error = " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return f32960a.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), r45.c());
    L110:
        com.obric.event.task.nlp.a.a.f32889a.b(r23, "handleConditionCandidate bluetooth has selected id, id = " + r133);
        goto L65
    L96:
        if (r134.length() == 0) goto L99;
        r135 = false;
        goto L100
    L92:
        r133 = null;
        goto L93
    L87:
        r13.f38504a = "bluetooth params empty";
        com.obric.event.task.nlp.a.a.f32889a.d(r23, "handleConditionCandidate bluetooth info error = " + ((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin")));
        return f32960a.a((String) ZeusTransformUtils.preCheckCast(r13.f38504a, String.class, "com.obric.aiagent.plugin"), ErrorCode.EventTask.BLUETOOTH_PARAMS_EMPTY);
    L84:
        r44 = null;
        goto L86
    L80:
        r43 = null;
        goto L82
    L69:
        r115 = a.f32961a[r113.ordinal()];
    L180:
        if (r16 == null) goto L183;
        r26.a(r16);
    L183:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L185;
        r26.a((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin"));
    L185:
        com.obric.event.task.nlp.a.a.f32889a.b(TAG, "handleConditionCandidate key = " + r1 + ", success");
        return new com.obric.event.task.nlp.api.d("success", null, 0, null, 10, null);
    L54:
        if (r110.isEmpty() == true) goto L57;
        r111 = false;
        goto L58
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        com.obric.event.task.nlp.a.a r49 = com.obric.event.task.nlp.a.a.f32889a;
        String r50 = TAG;
        r49.b(r50, "handleConditionCandidate key = " + r1);
        r13 = new z.f();
        r13.f38504a = "";
        com.obric.event.task.nlp.api.i r140 = r26.h();
        if (r140 == null) goto L50;
        com.obric.event.task.nlp.api.a r141 = r140.c();
        if (r141 == null) goto L21;
        com.obric.event.task.nlp.api.b r142 = r141.a();
        if (r142 == null) goto L21;
        String r143 = r142.a();
    L22:
        CharSequence r144 = (CharSequence) ZeusTransformUtils.preCheckCast(r143, CharSequence.class, "com.obric.aiagent.plugin");
        if (r144 != null) goto L25;
    L28:
        boolean r145 = true;
    L29:
        if (r145 == false) goto L48;
        IEventTaskNlpDepend r51 = (IEventTaskNlpDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskNlpDepend.class), IEventTaskNlpDepend.class, "com.obric.aiagent.plugin");
        if (r51 == null) goto L38;
        r5.f32975a = r0;
        r5.f32976b = r1;
        r26 = r26;
        r5.f32977c = r26;
        r5.f32978d = r2;
        r5.f32979e = r13;
        r5.h = 1;
        r14 = r51.handleLocationConditionCandidate(r1, r140, r2, r5);
        if (r14 != r7) goto L35;
        return r7;
    L38:
        r26 = r26;
        goto L39
    L48:
        com.obric.event.task.nlp.a.a.f32889a.b(r50, "handleConditionCandidate has location selected id , id = " + r143);
        goto L50
    L25:
        if (r144.length() == 0) goto L28;
        r145 = false;
    L21:
        r143 = null;
    L50:
        r16 = null;
    L7:
        r5 = new e(r0, r4);
        goto L8
    }
}
