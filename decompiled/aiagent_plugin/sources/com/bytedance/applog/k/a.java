package com.bytedance.applog.k;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.c;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.util.g;
import com.bytedance.applog.util.p;
import com.bytedance.bdinstall.aw;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Api.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f5669d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f5670e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f5671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final c f5672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final g f5673c;

    /* JADX INFO: renamed from: com.bytedance.applog.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Api.java */
    private static class C0136a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte[] f5693c;

        C0136a(int r2) {
            this.f5691a = 0;
            this.f5691a = r2;
        }
    }

    public static boolean a(int r1) {
        if (r1 >= 500) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 600) goto L7;
        return true;
    }

    public static boolean b(int r1) {
        if (404 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f5669d = Collections.singletonList("Api");
        f5670e = new String[]{"GET", "POST"};
    }

    public a(c r2) {
        this.f5672b = r2;
        this.f5673c = new g(r2);
    }

    public g a() {
        return this.f5673c;
    }

    public static String a(String r6, String[] r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        Uri r8 = Uri.parse(r6);
        HashMap r0 = new HashMap(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        String r4 = r8.getQueryParameter(r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put(r3, r4);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        Uri.Builder r9 = r8.buildUpon();
        r9.clearQuery();
        Iterator r10 = r0.keySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        r9.appendQueryParameter(r5, (String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.aiagent.plugin"));
        goto L13
    L16:
        return r9.build().toString();
    }

    private C0136a a(int r18, String r19, HashMap<String, String> r20, byte[] r21, int r22) {
        this.f5672b.Z().c(11, "Start request http url: {}", new Object[]{r19});
        if (this.f5672b.am() == false) goto L13;
        if (r20 == null) goto L13;
        Iterator<Map.Entry<String, String>> r7 = r20.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r12.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r12.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L7;
        this.f5672b.Z().c(11, "http headers key: {}, value: {}", new Object[]{r12.getKey(), r12.getValue()});
    L13:
        C0136a r8 = new C0136a(r22);
        URL r13 = new URL(r19);     // Catch: Throwable -> L84
        if (this.f5672b.X() == null) goto L17;
        HttpURLConnection r2 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r13.openConnection(this.f5672b.X()), HttpURLConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
    L18:
        if (r18 != 0) goto L20;
        r2.setDoOutput(false);     // Catch: Throwable -> L84
    L23:
        r2.setRequestMethod(f5670e[r18]);     // Catch: Throwable -> L84
        if (r20 != null) goto L26;
    L36:
        r2.setRequestProperty(DownloadHelper.ACCEPT_ENCODING, DownloadHelper.GZIP);     // Catch: Throwable -> L84
        if (r21 != null) goto L39;
    L42:
        DataOutputStream r14 = null;
    L43:
        int r0 = r2.getResponseCode();     // Catch: Throwable -> L81
        if (r0 != 200) goto L80;
        if (r22 == 0) goto L47;
        InputStream r1 = r2.getInputStream();     // Catch: Throwable -> L81
        if (DownloadHelper.GZIP.equalsIgnoreCase(r2.getContentEncoding()) == false) goto L66;
        InputStream r3 = new GZIPInputStream(r1);     // Catch: Throwable -> L81
    L103:
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Throwable -> L77
        byte[] r5 = new byte[1024];     // Catch: Throwable -> L75
    L70:
        int r6 = r3.read(r5);     // Catch: Throwable -> L75
        if (r6 == (-1)) goto L73;
        r4.write(r5, 0, r6);     // Catch: Throwable -> L75
        goto L70
    L73:
        r8.f5693c = r4.toByteArray();     // Catch: Throwable -> L75
        BufferedReader r16 = null;
    L89:
        p.a(r14);
        p.a(r16);
        p.a(r3);
        p.a(r4);
        return r8;
    L75:
        th = th;
    L86:
        r16 = null;
    L98:
        this.f5672b.N().increaseStats(j.K);     // Catch: Throwable -> L93
        this.f5672b.Z().a(11, "Send request failed", th, new Object[0]);     // Catch: Throwable -> L93
        if (ZeusTransformUtils.instanceOf(th, aw.class) == false) goto L89;
        throw ((aw) ZeusTransformUtils.preCheckCast(th, aw.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        p.a(r14);
        p.a(r16);
        p.a(r3);
        p.a(r4);
        throw th;
    L77:
        th = th;
    L83:
        r4 = null;
        goto L86
    L66:
        r3 = r1;
        goto L103
    L47:
        if (r2.getContentLength() >= 10240) goto L60;
        InputStream r9 = r2.getInputStream();     // Catch: Throwable -> L81
        if (DownloadHelper.GZIP.equalsIgnoreCase(r2.getContentEncoding()) == false) goto L51;
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r9)));     // Catch: Throwable -> L81
    L96:
        StringBuilder r11 = new StringBuilder(r9.available());     // Catch: Throwable -> L58
    L53:
        String r15 = r10.readLine();     // Catch: Throwable -> L58
        if (r15 == null) goto L56;
        r11.append(r15).append("\n");     // Catch: Throwable -> L58
        goto L53
    L56:
        r8.f5692b = r11.toString();     // Catch: Throwable -> L58
        JSONObject r17 = new JSONObject(r8.f5692b);     // Catch: Throwable -> L58
        r17.put("Set-Cookie", r2.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L58
        r8.f5692b = r17.toString();     // Catch: Throwable -> L58
    L61:
        r16 = r10;
        r3 = null;
        r4 = null;
    L58:
        th = th;
        r16 = r10;
        r3 = null;
        r4 = null;
        goto L98
    L51:
        r10 = new BufferedReader(new InputStreamReader(r9));     // Catch: Throwable -> L81
        goto L96
    L60:
        this.f5672b.Z().d(11, f5669d, "respType is {}", new Object[]{Integer.valueOf(r22)});     // Catch: Throwable -> L81
        r10 = null;
        goto L61
    L80:
        throw new aw(r0, r2.getResponseMessage());     // Catch: Throwable -> L81
    L39:
        if (r21.length <= 0) goto L42;
        r14 = new DataOutputStream(r2.getOutputStream());     // Catch: Throwable -> L84
        r14.write(r21);     // Catch: Throwable -> L81
        r14.flush();     // Catch: Throwable -> L81
        r14.close();     // Catch: Throwable -> L81
    L81:
        th = th;
        r3 = null;
        goto L83
    L26:
        if (r20.isEmpty() == true) goto L36;
        Iterator<Map.Entry<String, String>> r23 = r20.entrySet().iterator();     // Catch: Throwable -> L84
    L29:
        if (r23.hasNext() == false) goto L36;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r23.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r110.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L35;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r110.getValue(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L35;
        r2.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r110.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r110.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L84
    L35:
        this.f5672b.Z().c(11, f5669d, "header key value invalid", new Object[0]);     // Catch: Throwable -> L84
        goto L29
    L20:
        if (r18 != 1) goto L22;
        r2.setDoOutput(true);     // Catch: Throwable -> L84
        goto L23
    L22:
        this.f5672b.Z().c(11, f5669d, "unknown method", new Object[0]);     // Catch: Throwable -> L84
        goto L23
    L17:
        r2 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(a(r13), HttpURLConnection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
    L84:
        th = th;
        r3 = null;
        r4 = null;
        r14 = null;
        goto L86
    }

    public String a(int r7, String r8, HashMap<String, String> r9, byte[] r10) {
        return a(r7, r8, r9, r10, 0).f5692b;
    }

    public byte[] b(int r7, String r8, HashMap<String, String> r9, byte[] r10) {
        return a(r7, r8, r9, r10, 1).f5693c;
    }

    public JSONObject a(String r12, JSONObject r13) {
        HashMap<String, String> r9 = a(false, false, -1, null);
        String r10 = UUID.randomUUID().toString();
        a(r12, r10, r13, 1, r9);
        String r14 = this.f5672b.q().a(this.f5673c.a(r12), this.f5673c.b(r13.toString()), r9);     // Catch: Throwable -> L5
    L7:
        if (r14 != null) goto L23;
        this.f5672b.Z().e(11, "Et response invalid", new Object[0]);
        a(r10, -1, null, "Empty et response");
        return null;
    L23:
        JSONObject r15 = new JSONObject(r14);     // Catch: Throwable -> L13
        a(r15);     // Catch: Throwable -> L11
        a(r10, 200, null, r14);     // Catch: Throwable -> L11
    L25:
        return r15;
    L11:
        th = th;
    L15:
        this.f5672b.Z().a(11, "Parse et response failed", th, new Object[0]);
        this.f5672b.N().increaseStats(j.L);
        a(r10, -1, null, "Parse et response failed");
    L13:
        th = th;
        r15 = null;
    L5:
        th = move-exception;
        this.f5672b.Z().a(11, "Send event to et failed", th, new Object[0]);
        r14 = null;
        goto L7
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10811. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    public int a(java.lang.String[] r31, byte[] r32, com.bytedance.applog.engine.Engine r33, java.lang.String[] r34, int r35, java.lang.String r36, java.util.Map<java.lang.String, java.lang.String> r37, boolean r38) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: CONST (r16v0 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (0 ??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.bytedance.applog.k.a.a(java.lang.String[], byte[], com.bytedance.applog.engine.Engine, java.lang.String[], int, java.lang.String, java.util.Map<java.lang.String, java.lang.String>, boolean):int, file: classes.dex
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
            Method dump skipped, instruction units count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.k.a.a(java.lang.String[], byte[], com.bytedance.applog.engine.Engine, java.lang.String[], int, java.lang.String, java.util.Map, boolean):int");
    }

    public boolean a(String r13, com.bytedance.applog.store.g r14) {
        if (r14 != null) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r13) == false) goto L8;
        return true;
    L8:
        HashMap<String, String> r1 = a(false, true, r14.G, r14.H);
        String r2 = UUID.randomUUID().toString();
        a(r13, r2, r14.u, 1, r1);
        this.f5672b.N().increaseStats(j.v);
        String r15 = this.f5672b.q().a(r13, r14.u, r1);     // Catch: Throwable -> L19
        this.f5672b.Z().b(11, f5669d, "trySendForward resp:{} ", new Object[]{r15});     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r15) == false) goto L12;
        int r16 = -1;
    L14:
        if (TextUtils.isEmpty(r15) == false) goto L16;
        byte[] r17 = null;
    L17:
        a(r2, r16, r17, null);     // Catch: Throwable -> L19
        return true;
    L16:
        r17 = r15.getBytes("UTF-8");     // Catch: Throwable -> L19
        goto L17
    L12:
        r16 = 200;
    L19:
        th = move-exception;
        this.f5672b.Z().a(11, f5669d, "trySendForward failed ", th, new Object[0]);
        this.f5672b.N().increaseStats(j.L);
        this.f5672b.N().increaseStats(j.w);
        this.f5672b.N().sendError("api send forward log failed", th);
        a(r2, -1, null, "Send forward log error");
        return false;
    }

    private void a(JSONObject r6) {
        long r1 = r6.optLong("server_time");     // Catch: Exception -> L9
        if (r1 <= 0) goto L13;
        final JSONObject r7 = new JSONObject();     // Catch: Exception -> L9
        r7.put("server_time", r1);     // Catch: Exception -> L9
        r7.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L9
        this.f5671a = r7;     // Catch: Exception -> L9
        if (l.a() == true) goto L14;
        l.a("server_time_sync", new AnonymousClass1(this, r7));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L13:
        return;
    L9:
        this.f5672b.N().increaseStats(j.P);
    }

    private HashMap<String, String> a(boolean r7, boolean r8, int r9, String r10) {
        HashMap<String, String> r0 = new HashMap(2);
        if (this.f5672b.k() == false) goto L5;
        r0.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L23;
    L20:
        if (r8 == true) goto L22;
        com.bytedance.applog.util.b.a(r0, r7);
    L22:
        return r0;
    L23:
        JSONObject r2 = new JSONObject(r10);     // Catch: Throwable -> L13
        Iterator<String> r11 = r2.keys();     // Catch: Throwable -> L13
    L10:
        if (r11.hasNext() == false) goto L20;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r0.put(r3, r2.optString(r3));     // Catch: Throwable -> L13
    L13:
        this.f5672b.N().increaseStats(j.P);
        if (r9 != 0) goto L17;
        r0.put("log-encode-type", DownloadHelper.GZIP);
        goto L20
    L17:
        if (r9 == 1) goto L19;
        if (r9 != 2) goto L20;
    L19:
        r0.put("log-encode-type", "zstd");
        r0.put("log-encode-token", String.valueOf(0));
        goto L20
    L5:
        r0.put(DownloadHelper.CONTENT_TYPE, "application/json; charset=utf-8");
        goto L7
    }

    public JSONObject b(String r12, JSONObject r13) {
        boolean r0 = false;
        HashMap<String, String> r9 = a(false, false, -1, null);
        String r10 = UUID.randomUUID().toString();
        a(r12, r10, r13, 1, r9);
        this.f5672b.N().increaseStats(j.x);
        byte[] r4 = this.f5673c.b(r13.toString());     // Catch: Throwable -> L16
        String r5 = r13.optString("key");     // Catch: Throwable -> L16
        String r14 = r13.optString("iv");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r5) == false) goto L6;
    L8:
        boolean r6 = false;
    L9:
        if (r6 == false) goto L14;
        byte[] r15 = this.f5672b.q().b(r12, r4, r9);     // Catch: Throwable -> L16
        byte[] r16 = g.a(r15, r5, r14);     // Catch: Throwable -> L16
        if (r16 != null) goto L13;
        String r17 = new String(r15);     // Catch: Throwable -> L16
    L18:
        if (r17 != null) goto L39;
        a(r10, -1, null, "Config response empty");
        JSONObject r18 = null;
    L28:
        if (r18 != null) goto L30;
    L32:
        if (r0 == true) goto L34;
        this.f5672b.N().increaseStats(j.y);
        return null;
    L34:
        return r18.optJSONObject("config");
    L30:
        if ("ss_app_log".equals(r18.optString("magic_tag", "")) == false) goto L32;
        r0 = true;
        goto L32
    L39:
        r18 = new JSONObject(r17);     // Catch: Throwable -> L24
        a(r18);     // Catch: Throwable -> L22
        a(r10, 200, null, r17);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r8 = th;
    L26:
        this.f5672b.N().increaseStats(j.P);
        this.f5672b.Z().a(11, f5669d, "Parse config response failed", r8, new Object[0]);
        a(r10, -1, null, "Parse config response failed");
    L24:
        th = move-exception;
        r8 = th;
        r18 = null;
        goto L26
    L13:
        r17 = new String(g.c(r16));     // Catch: Throwable -> L16
        goto L18
    L14:
        r17 = this.f5672b.q().a(r12, r4, r9);     // Catch: Throwable -> L16
        goto L18
    L6:
        if (TextUtils.isEmpty(r14) == true) goto L8;
        r6 = true;
    L16:
        th = move-exception;
        this.f5672b.N().increaseStats(j.L);
        this.f5672b.Z().a(11, f5669d, "config request failed", th, new Object[0]);
        this.f5672b.N().sendError("api send config failed", th);
        r17 = null;
        goto L18
    }

    public void a(JSONObject r8, boolean r9) {
        if (r9 == false) goto L9;
        if (this.f5672b.v() == false) goto L13;
        r8.put("uid_enable", 1);     // Catch: JSONException -> L21
    L7:
        boolean r10 = true;
    L14:
        if (r10 == true) goto L16;
        return;
    L16:
        if (this.f5672b.k() == false) goto L27;
        String[] r11 = g.a();     // Catch: JSONException -> L21
        if (g.a(r11) == false) goto L28;
        r8.put("key", r11[0]);     // Catch: JSONException -> L21
        r8.put("iv", r11[1]);     // Catch: JSONException -> L21
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r10 = false;
        goto L14
    L9:
        if (this.f5672b.f() == null) goto L13;
        if (this.f5672b.f().J() == false) goto L13;
        r8.put("event_filter", 1);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        this.f5672b.N().increaseStats(j.P);
        this.f5672b.Z().a(11, f5669d, "fillKeyIvForEncryptResp error", e, new Object[0]);
    }

    public void a(final String r10, final String r11, final JSONObject r12, final int r13, Map<String, String> r14) {
        final Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r7 = System.currentTimeMillis();
        l.a("do_request_begin", new AnonymousClass2(this, r2, r11, r10, r12, r13, r7));
    }

    public void a(final String r10, final String r11, final byte[] r12, final int r13, Map<String, String> r14) {
        final Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r7 = System.currentTimeMillis();
        l.a("do_request_begin", new AnonymousClass3(this, r2, r12, r11, r10, r13, r7));
    }

    public void a(final String r10, final int r11, final byte[] r12, final String r13) {
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r7 = System.currentTimeMillis();
        l.a("do_request_end", new AnonymousClass4(this, r10, r11, r12, r13, r7));
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static URLConnection a(URL r4) {
        URL r0 = (URL) ZeusTransformUtils.preCheckCast(r4, URL.class, "com.obric.aiagent.plugin");
        String r1 = r0.getHost();
        String r2 = r0.getPath();
        if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L5;
        ILogDepend.Companion.i("AiAgentUrlConnLancet", "openConnection drop host=" + r1 + " path=" + r2);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
        throw new IOException("[NetGuard] dropped ");
    L5:
        return r4.openConnection();
    }
}
