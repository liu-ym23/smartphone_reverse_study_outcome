package com.obric.autogui.agents.vlm.models.omni.c;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppPredictionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: compiled from: AppPredictionProvider.kt */
    @d.c.b.a.f(b = "AppPredictionProvider.kt", c = {159}, d = "loadAppPredictionInput", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.AppPredictionProviderKt")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f28256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f28257c;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f28256b = r2;
            this.f28257c |= Integer.MIN_VALUE;
            return e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppPredictionProvider.kt */
    @d.c.b.a.f(b = "AppPredictionProvider.kt", c = {169}, d = "loadCurrentAppCandidates", e = "com.obric.autogui.agents.vlm.models.omni.prewarm.AppPredictionProviderKt")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f28258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f28259b;

        b(d.c.d<? super b> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f28258a = r2;
            this.f28259b |= Integer.MIN_VALUE;
            return e.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ String a(c r0) {
        return b(r0);
    }

    public static final /* synthetic */ String a(String r0) {
        return b(r0);
    }

    public static final Object a(Context r5, String r6, d.c.d<? super c> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if ((r0.f28257c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28257c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f28256b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28257c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.f28255a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
    L18:
        return new c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString(), (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        r0.f28255a = r6;
        r0.f28257c = 1;
        r10 = a(r8, r0);
        if (r10 != r2) goto L18;
        return r2;
    L7:
        r0 = new a(r9);
        goto L8
    }

    public static final Object a(Context r8, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.c.a>> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r0.f28259b & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28259b -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f28258a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28259b;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r12);
    L17:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.agents.vlm.models.impl.applist.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.impl.applist.b.class, "com.obric.aiagent.plugin")).b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r13.iterator();
    L19:
        if (r15.hasNext() == false) goto L47;
        String[] r1 = (String[]) ZeusTransformUtils.preCheckCast(r15.next(), String[].class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        String r5 = (String) ZeusTransformUtils.preCheckCast(d.a.i.b(r1, 0), String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.c.a r6 = null;
        if (r5 == null) goto L23;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L24:
        String r16 = "";
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        String r17 = (String) ZeusTransformUtils.preCheckCast(d.a.i.b(r1, 1), String.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L30;
        String r18 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L31:
        if (r18 == null) goto L35;
        r16 = r18;
    L35:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L37;
        boolean r19 = true;
    L38:
        if (r19 == false) goto L40;
    L45:
        if (r6 == null) goto L19;
        r14.add(r6);
        goto L19
    L40:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L42;
        r4 = true;
    L42:
        if (r4 == true) goto L45;
        r6 = new com.obric.autogui.agents.vlm.models.omni.c.a(r7, r16);
        goto L45
    L37:
        r19 = false;
        goto L38
    L30:
        r18 = null;
        goto L31
    L23:
        r7 = null;
        goto L24
    L47:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        HashSet r21 = new HashSet();
        ArrayList r22 = new ArrayList();
        Iterator r23 = r20.iterator();
    L49:
        if (r23.hasNext() == false) goto L54;
        Object r24 = r23.next();
        if (r21.add(((com.obric.autogui.agents.vlm.models.omni.c.a) ZeusTransformUtils.preCheckCast(r24, com.obric.autogui.agents.vlm.models.omni.c.a.class, "com.obric.aiagent.plugin")).b()) == false) goto L49;
        r22.add(r24);
        goto L49
    L54:
        return (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        com.obric.autogui.agents.vlm.models.impl.applist.b r25 = new com.obric.autogui.agents.vlm.models.impl.applist.b(r10);
        r0.f28259b = 1;
        r12 = r25.a(r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new b(r11);
        goto L8
    }

    private static final String b(c r11) {
        Gson r0 = new Gson();
        d.m[] r2 = new d.m[2];
        r2[0] = s.a(DownloadConstants.QUERY_KEY, r11.a());
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11.b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r12, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        com.obric.autogui.agents.vlm.models.omni.c.a r6 = (com.obric.autogui.agents.vlm.models.omni.c.a) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.autogui.agents.vlm.models.omni.c.a.class, "com.obric.aiagent.plugin");
        r3.add(ao.a(new d.m[]{s.a("appName", r6.a()), s.a("packageName", r6.b())}));
        goto L4
    L6:
        r2[1] = s.a("appList", (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
        String r14 = r0.toJson(ao.a(r2));
        d.h.b.o.c(r14, "toJson(...)");
        return r14;
    }

    private static final String b(String r14) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin");
        String r3 = null;
        int r9 = -1;
        int r4 = 0;
        int r5 = 0;
        boolean r6 = false;
        boolean r7 = false;
        int r8 = 0;
    L4:
        if (r4 >= r0.length()) goto L45;
        char r10 = r0.charAt(r4);
        int r11 = r5 + 1;
        boolean r13 = true;
        if (r6 == false) goto L14;
        if (r7 == false) goto L10;
        r7 = false;
    L44:
        r4 = r4 + 1;
        r5 = r11;
        goto L4
    L10:
        if (r10 != '\\') goto L12;
        r7 = true;
        goto L44
    L12:
        if (r10 != '\"') goto L44;
        r6 = false;
        goto L44
    L14:
        if (r10 != '\"') goto L16;
        if (r8 <= 0) goto L44;
        r6 = true;
        goto L44
    L16:
        if (r10 != '[') goto L18;
    L38:
        if (r8 == 0) goto L41;
        r5 = r9;
    L41:
        r8 = r8 + 1;
        r9 = r5;
        goto L44
    L18:
        if (r10 != ']') goto L20;
    L24:
        if (r8 <= 0) goto L44;
        r8 = r8 - 1;
        if (r8 != 0) goto L44;
        if (r9 < 0) goto L44;
        String r12 = r14.substring(r9, r11);
        d.h.b.o.c(r12, "substring(...)");
        JsonElement r15 = JsonParser.parseString(r12);     // Catch: Exception -> L46
        if (r15.isJsonArray() == true) goto L35;
        if (r15.isJsonObject() == false) goto L34;
    L35:
        if (r13 == false) goto L37;
        r3 = r12;
    L37:
        r9 = -1;
    L34:
        r13 = false;
        goto L35
    L20:
        if (r10 == '{') goto L38;
        if (r10 == '}') goto L24;
    L45:
        return r3;
    }
}
