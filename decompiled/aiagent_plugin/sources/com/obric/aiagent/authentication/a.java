package com.obric.aiagent.authentication;

import android.content.Context;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthPolicyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0328a f16379a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f16380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f16381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.a.a f16383e;
    private final Gson f;
    private final HashMap<String, List<ProcessPolicies>> g;

    /* JADX INFO: renamed from: com.obric.aiagent.authentication.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AuthPolicyManager.kt */
    public static final class C0328a {
        public /* synthetic */ C0328a(h r1) {
            this();
        }

        private C0328a() {
        }
    }

    static {
        f16379a = new C0328a(null);
    }

    public a(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        this.f16380b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f16381c = r6;
        this.f16383e = new com.bytedance.a.a();
        this.f = new Gson();
        this.g = new HashMap();
    }

    public /* synthetic */ a(Context r2, b r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final void a(List<String> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "policyFiles");
        o.e(r10, "authorizedAppsFile");
        if (this.f16382d == true) goto L50;
        File r2 = new File(new File(this.f16380b.getFilesDir(), "authentication_policies"), r10);
        File r0 = r2.getParentFile();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L14;
        File r3 = r2.getParentFile();
        if (r3 == null) goto L14;
        r3.mkdirs();
    L14:
        InputStream r12 = this.f16380b.getAssets().open(r10);
        o.a(r12);
        d.f.b.a(r12, (OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r2), OutputStream.class, "com.obric.aiagent.plugin"), 0, 2, null);
        this.f16383e.a(this.f16380b, r2.getPath(), 1);
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r13.hasNext() == false) goto L47;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        InputStream r4 = this.f16380b.getAssets().open(r14);
        o.a(r4);     // Catch: Throwable -> L44
        JSONObject r5 = new JSONObject(d.o.o.a(d.f.b.a(r4))).optJSONObject("content");     // Catch: Throwable -> L44
        if (r5 == null) goto L21;
        Integer r6 = Integer.valueOf(r5.optInt("version"));     // Catch: Throwable -> L44
    L22:
        if (r6 == null) goto L16;
        if (r6.intValue() != 1) goto L16;
        Gson r7 = this.f;     // Catch: Throwable -> L44
        String r8 = r5.toString();     // Catch: Throwable -> L44
        o.c(r8, "toString(...)");     // Catch: Throwable -> L44
        V1PolicyContent r15 = (V1PolicyContent) ZeusTransformUtils.preCheckCast(r7.fromJson(a(r8, ao.a(s.a("currentPackageName", this.f16380b.getPackageName()))), V1PolicyContent.class), V1PolicyContent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r15.getCategory(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r16 != null) goto L29;
    L32:
        boolean r17 = true;
    L33:
        if (r17 == true) goto L16;
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(r15.getPolicies(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        if (r18 != null) goto L37;
    L40:
        boolean r19 = true;
    L41:
        if (r19 == true) goto L16;
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.aiagent.plugin")).put(r15.getCategory(), r15.getPolicies());     // Catch: Throwable -> L44
        goto L16
    L37:
        if (r18.isEmpty() == true) goto L40;
        r19 = false;
        goto L41
    L29:
        if (r16.length() == 0) goto L32;
        r17 = false;
        goto L33
    L21:
        r6 = null;
    L44:
        th = move-exception;
        throw new RuntimeException("parse policy file " + r14 + " failed", th);
    L47:
        this.f16382d = true;
        return;
    L7:
        if (r0.exists() != true) goto L9;
        r1 = true;
        goto L10
    L50:
        throw new IllegalStateException("authentication policies has been loaded");
    }

    public static /* synthetic */ Object a(a r6, String r7, String r8, String r9, String r10, String r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.a(r7, r8, r9, r10, r11);
    }

    public final Object a(String r8, String r9, String r10, String r11, String r12) {
        o.e(r8, "category");
        o.e(r9, "subject");
        o.e(r10, "target");
        o.e(r11, "action");
        List r13 = (List) ZeusTransformUtils.preCheckCast(this.g.get(r8), List.class, "com.obric.aiagent.plugin");
        Object r0 = null;
        if (r13 == null) goto L27;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r14.hasNext() == false) goto L25;
        Object r4 = r14.next();
        ProcessPolicies r5 = (ProcessPolicies) ZeusTransformUtils.preCheckCast(r4, ProcessPolicies.class, "com.obric.aiagent.plugin");
        List<String> r6 = r5.getSubject();
        if (r6 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L22;
        List<String> r15 = r5.getTarget();
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L20:
        if (r16 == false) goto L22;
        boolean r17 = true;
    L23:
        if (r17 == false) goto L6;
    L26:
        ProcessPolicies r18 = (ProcessPolicies) ZeusTransformUtils.preCheckCast(r4, ProcessPolicies.class, "com.obric.aiagent.plugin");
    L28:
        if (r18 == null) goto L71;
        Map<String, ActionPolicy> r19 = r18.getActions();
        if (r19 == null) goto L71;
        Set<Map.Entry<String, ActionPolicy>> r20 = r19.entrySet();
        if (r20 == null) goto L71;
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L35:
        if (r21.hasNext() == false) goto L45;
        Object r22 = r21.next();
        Map.Entry r23 = (Map.Entry) ZeusTransformUtils.preCheckCast(r22, Map.Entry.class, "com.obric.aiagent.plugin");
        if (o.a(r23.getKey(), r11) == false) goto L39;
    L42:
        boolean r24 = true;
    L43:
        if (r24 == false) goto L35;
        r0 = r22;
        goto L45
    L39:
        if (o.a(r23.getKey(), "*") == true) goto L42;
        r24 = false;
    L45:
        Map.Entry r25 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L71;
        ActionPolicy r26 = (ActionPolicy) ZeusTransformUtils.preCheckCast(r25.getValue(), ActionPolicy.class, "com.obric.aiagent.plugin");
        if (r26 == null) goto L71;
        if (r12 != null) goto L51;
        r12 = "";
    L51:
        String r110 = r12.toLowerCase();
        o.c(r110, "toLowerCase(...)");
        PolicyItem r27 = r26.getSubActionPolicy(r110);
        if (r27 == null) goto L71;
        if (this.f16383e.a(r9) == true) goto L58;
        n.a r28 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Subject app authentication error"), Throwable.class, "com.obric.aiagent.plugin")));
    L58:
        if (this.f16383e.b(r10) == true) goto L62;
        n.a r29 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Target app authentication error"), Throwable.class, "com.obric.aiagent.plugin")));
    L62:
        if (r27.getSettingKey() == null) goto L69;
        b r30 = this.f16381c;
        if (r30 == null) goto L69;
        if (r30.a(r27.getSettingKey()) == false) goto L69;
        n.a r31 = n.f38560a;
        return n.f(Integer.valueOf(this.f16381c.b(r27.getSettingKey())));
    L69:
        n.a r32 = n.f38560a;
        return n.f(Integer.valueOf(r27.getType()));
    L71:
        n.a r33 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("No applicable policy"), Throwable.class, "com.obric.aiagent.plugin")));
    L17:
        if (r15.contains(r10) != true) goto L19;
        r16 = true;
    L22:
        r17 = false;
        goto L23
    L10:
        if (r6.contains(r9) != true) goto L12;
        r7 = true;
        goto L13
    L25:
        r4 = null;
        goto L26
    L27:
        r18 = null;
        goto L28
    }

    private final String a(String r8, Map<String, String> r9) {
        Iterator r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
        String r1 = r8;
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin");
        r1 = d.o.o.a(r1, "{{" + r11 + "}}", (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.aiagent.plugin"), false, 4, null);
        goto L4
    L6:
        return r1;
    }
}
