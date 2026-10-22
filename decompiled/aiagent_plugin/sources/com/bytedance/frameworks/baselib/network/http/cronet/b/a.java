package com.bytedance.frameworks.baselib.network.http.cronet.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.af;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseCronetSsCall.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.bytedance.frameworks.baselib.network.http.d.a {
    private static final String TAG = "BaseCronetSsCall";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile boolean f8204b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static volatile boolean f8205c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f8206d = true;
    private static volatile boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile int f8207a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f8208e;

    static {
    }

    public static /* synthetic */ void lambda$bIwZNSOJb8zxF9QMGMa5zlBPtnk(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    void a(HttpURLConnection r1) {
    }

    abstract HttpURLConnection b();

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public boolean i() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public boolean k() {
        return false;
    }

    public static void a(boolean r0) {
        f8204b = r0;
    }

    public static void b(boolean r0) {
        f8205c = r0;
    }

    public static void a() {
        k = true;
    }

    a(com.bytedance.retrofit2.b.c r3) {
        super(r3);
        this.f8207a = 0;
        this.f8208e = 0;
        this.g.G = 0;     // Catch: Exception -> L5
        this.g.K.put("hc", "SsCronetHttpClient");     // Catch: Exception -> L5
        this.g.K.put("hcv", i.c());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.retrofit2.b.e
    public boolean a(long r1) {
        this.f8208e = r1;
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public int c() {
        return this.f8207a;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public String d() {
        return a(DownloadHelper.CONTENT_TYPE);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public Map<String, List<String>> e() {
        if (b() != null) goto L7;
        return null;
    L7:
        return b().getHeaderFields();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public String a(String r3) {
        if (b() != null) goto L6;
        return null;
    L6:
        String r0 = b().getHeaderField(r3);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return b().getHeaderField(r3.toLowerCase());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public InputStream f() {
        if (b() != null) goto L7;
        return null;
    L7:
        return b().getInputStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public InputStream g() {
        if (b() != null) goto L7;
        return null;
    L7:
        return b().getErrorStream();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public String h() {
        if (b() != null) goto L7;
        return "";
    L7:
        return b().getResponseMessage();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.c
    public void j() {
        if (b() == null) goto L6;
        b().disconnect();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public boolean l() {
        if (this.h == false) goto L5;
    L8:
        return true;
    L5:
        if (i.b() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(String r4, com.bytedance.retrofit2.b.c r5, com.bytedance.frameworks.baselib.network.http.b r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        r6.f8138d.aa();     // Catch: Throwable -> L21 Exception -> L23
        r6.f8136b = c(r5);     // Catch: Throwable -> L21 Exception -> L23
        if (f8204b == true) goto L6;
    L14:
        boolean r0 = false;
    L15:
        r6.f8135a = r0;     // Catch: Throwable -> L21 Exception -> L23
        if (Logger.debug() == false) goto L18;
        Logger.e(TAG, "url is " + r4 + " useCronetInputStreamWithTTBuffer: " + r6.f8135a);     // Catch: Throwable -> L21 Exception -> L23
    L18:
        HttpURLConnection r1 = a(r4, r6);     // Catch: Throwable -> L21 Exception -> L23
        a(r5, r6, r1, r8);     // Catch: Throwable -> L21 Exception -> L23
        a(r1);     // Catch: Throwable -> L21 Exception -> L23
        r6.f8138d.ab();
        return;
    L6:
        if (f8205c == false) goto L14;
        if (r6.f8136b > 0) goto L14;
        if (r5.h() == true) goto L14;
        if (r5.k() > 0) goto L14;
        r0 = true;
    L23:
        e = move-exception;
        throw com.bytedance.retrofit2.f.c.a(e, r4, r6.P, r6);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r6.f8138d.ab();
        throw th;
    }

    public HttpURLConnection a(String r3, com.bytedance.frameworks.baselib.network.http.b r4) {
        long r0 = -1;
        r0 = r4.f8138d.aw();     // Catch: Throwable -> L6
        HttpURLConnection r2 = i.b(r3, r4);     // Catch: Throwable -> L6
        r4.f8138d.b(r0);
        return r2;
    L6:
        th = move-exception;
        r4.f8138d.b(r0);
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x042e -> B:347:0x043c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 20981. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    public void a(com.bytedance.retrofit2.b.c r25, com.bytedance.frameworks.baselib.network.http.b r26, java.net.HttpURLConnection r27, java.util.Map<java.lang.String, java.lang.String> r28) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: IGET (r8v0 ?? I:T extends com.bytedance.frameworks.baselib.network.http.c) = (r26v0 com.bytedance.frameworks.baselib.network.http.b) A[Catch: all -> 0x0829, DECLARE_VAR, TRY_LEAVE] (LINE:231) com.bytedance.frameworks.baselib.network.http.b.c com.bytedance.frameworks.baselib.network.http.c in method: com.bytedance.frameworks.baselib.network.http.cronet.b.a.a(com.bytedance.retrofit2.b.c, com.bytedance.frameworks.baselib.network.http.b, java.net.HttpURLConnection, java.util.Map<java.lang.String, java.lang.String>):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2098
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.frameworks.baselib.network.http.cronet.b.a.a(com.bytedance.retrofit2.b.c, com.bytedance.frameworks.baselib.network.http.b, java.net.HttpURLConnection, java.util.Map):void");
    }

    private static String a(com.bytedance.retrofit2.e.j r2) {
        com.bytedance.retrofit2.e.j r3 = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.retrofit2.e.a.class) == false) goto L5;
        com.bytedance.retrofit2.e.a r0 = (com.bytedance.retrofit2.e.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.retrofit2.e.a.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r0.f()) == true) goto L9;
        String r4 = r0.h();
        if (TextUtils.isEmpty(r4) == false) goto L13;
        Logger.e(TAG, "Request compress body md5 shouldn't be null.");
    L13:
        return r4;
    L9:
        return r3.d();
    L5:
        return r3.d();
    }

    private static void a(com.bytedance.retrofit2.b.c r2) {
        if (r2.p() != null) goto L5;
        return;
    L5:
        com.bytedance.retrofit2.b.b r0 = r2.a("x-bd-content-encoding");
        if (r0 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r0.b()) == true) goto L19;
        JSONObject r3 = r2.p().aq;
        if (r3 != null) goto L16;
        return;
    L16:
        r3.put("encode", r0.b());     // Catch: JSONException -> L15
        r3.put("disableReason", com.bytedance.retrofit2.e.f.e.j.a());     // Catch: JSONException -> L15
        return;
    L20:
        return;
    }

    private static void a(long r3, long r5, int r7, long r8, com.bytedance.retrofit2.b.c r10, com.bytedance.retrofit2.e.f.b r11) {
        if (r10.p() != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put("beforeSize", r3);     // Catch: JSONException -> L10
        if (r7 == 0) goto L12;
        r1.put("disableReason", r7);     // Catch: JSONException -> L10
    L12:
        if (r11 != null) goto L33;
        r10.p().aq = r1;
        return;
    L33:
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        r10.p().aq = r1;
        return;
    L16:
        if (TextUtils.isEmpty(r11.f9529c) == true) goto L19;
        r1.put("type", r11.f9529c);     // Catch: JSONException -> L29
        r1.put("afterSize", r5);     // Catch: JSONException -> L29
    L19:
        if (r11.f9530d == 0) goto L27;
        r1.put("disableReason", r11.f9530d);     // Catch: JSONException -> L29
        if (r11.f9530d == com.bytedance.retrofit2.e.f.e.h.a()) goto L25;
        if (r11.f9530d != com.bytedance.retrofit2.e.f.e.g.a()) goto L27;
    L25:
        if (TextUtils.isEmpty(r11.f9531e) == true) goto L27;
        r1.put("prefix", r11.f9531e);     // Catch: JSONException -> L29
    L27:
        r1.put("duration", System.currentTimeMillis() - r8);     // Catch: JSONException -> L29
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static String a(com.bytedance.retrofit2.e.j r12, com.bytedance.retrofit2.b.c r13) {
        com.bytedance.retrofit2.e.j r14 = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, com.bytedance.retrofit2.e.a.class) == false) goto L38;
        if (r13 == null) goto L38;
        com.bytedance.retrofit2.e.a r0 = (com.bytedance.retrofit2.e.a) ZeusTransformUtils.preCheckCast(r14, com.bytedance.retrofit2.e.a.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r0.f()) == false) goto L9;
        long r3 = r14.c();
        if ("POST".equalsIgnoreCase(r13.a()) == true) goto L14;
        a(r3, 0, com.bytedance.retrofit2.e.f.e.l.a(), 0, r13, null);
        return null;
    L14:
        com.bytedance.retrofit2.b.b r1 = r13.a("x-metasec-bp-body-compress");
        if (r1 != null) goto L17;
    L20:
        com.bytedance.retrofit2.b.b r2 = r13.a("content-encoding");
        if (r2 != null) goto L23;
    L26:
        long r8 = System.currentTimeMillis();
        if (r0.g() == true) goto L29;
    L32:
        com.bytedance.retrofit2.e.f.b r10 = r0.a(r13.n(), r13.o(), b(r13));
        if (r10 != null) goto L36;
        a(r3, 0, com.bytedance.retrofit2.e.f.e.k.a(), r8, r13, null);
        return null;
    L36:
        a(r3, r14.c(), 0, r8, r13, r10);
        return r10.f9529c;
    L29:
        if (com.bytedance.retrofit2.e.f.a() == false) goto L32;
        a(r3, 0, com.bytedance.retrofit2.e.f.e.i.a(), r8, r13, null);
        return null;
    L23:
        if (TextUtils.isEmpty(r2.b()) == true) goto L26;
        a(r3, 0, com.bytedance.retrofit2.e.f.e.m.a(), 0, r13, null);
        return null;
    L17:
        if ("1".equals(r1.b()) == false) goto L20;
        a(r3, 0, com.bytedance.retrofit2.e.f.e.n.a(), 0, r13, null);
        return null;
    L9:
        return r0.f();
    L38:
        return null;
    }

    private static boolean b(com.bytedance.retrofit2.b.c r1) {
        com.bytedance.retrofit2.b.b r2 = r1.a("x-metasec-content-encoding");
        if (r2 != null) goto L7;
        return false;
    L7:
        return "1".equals(r2.b());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(af r4) {
        long r0 = r4.ay();
        this.f8207a = b(b());     // Catch: Throwable -> L6
        r4.d(r0);
        return;
    L6:
        th = move-exception;
        r4.d(r0);
        throw th;
    }

    public int b(HttpURLConnection r2) {
        com.bytedance.retrofit2.e.j r1 = this.f.d();
        if (r1 == null) goto L6;
        r1.a(r2.getOutputStream());
    L6:
        return r2.getResponseCode();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(com.bytedance.retrofit2.e.i r5) {
        com.bytedance.retrofit2.e.i r6 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (this.f.h() == false) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, com.bytedance.retrofit2.e.g.class) == false) goto L17;
        this.g.f8138d.aB();
        com.bytedance.frameworks.baselib.network.http.h.b.a().a(b(), ((com.bytedance.retrofit2.e.g) ZeusTransformUtils.preCheckCast(r6, com.bytedance.retrofit2.e.g.class, "com.obric.aiagent.plugin")).i(), $$Lambda$a$bIwZNSOJb8zxF9QMGMa5zlBPtnk.INSTANCE);     // Catch: Throwable -> L12
    L10:
        this.g.f8138d.aC();
        return;
    }

    private static /* synthetic */ void a(String r0, String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        i.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.d.a
    public void a(com.bytedance.retrofit2.b.c r7, Exception r8) {
        String r9 = r8.getMessage();
        if (i.b() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r9) == false) goto L7;
        return;
    L7:
        if (r9.contains("net::ERR_INTERNET_DISCONNECTED") == false) goto L12;
        new com.bytedance.frameworks.baselib.network.http.c.e("network not available for " + this.f.o() + ", message:" + r9).a(false, true, this.f.b(), "", this.g);
        return;
    }

    public void c(HttpURLConnection r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (this.i == true) goto L12;
        r9.disconnect();
        this.i = true;
        if (this.f.h() == false) goto L11;
        j.a().a(this.f.b(), this.g.x, this.g.y, this.g.O, this.g.f8134J);
        return;
    L11:
        return;
    }

    private int c(com.bytedance.retrofit2.b.c r1) {
        return i.a(r1.o(), this.g);
    }
}
