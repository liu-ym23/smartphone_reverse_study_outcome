package r9;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.media.cache.http.IState;
import com.media.cache.http.Method;
import com.media.cache.http.ResponseState;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f23801h = "Content-Type";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f23802i = "Date";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f23803j = "Connection";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f23804k = "Transfer-Encoding";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f23805l = "E, d MMM yyyy HH:mm:ss 'GMT'";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f23806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p9.a f23807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f23808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IState f23811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InputStream f23812g;

    static {
    }

    public d(c r10, p9.a r11) {
        this.f23806a = r10;
        this.f23807b = r11;
        File r12 = r11.a();
        this.f23808c = r12;
        this.f23809d = r10.d();
        this.f23810e = r10.e();
        String r13 = r10.f();
        if (r13.startsWith("/http://") == false) goto L5;
    L16:
        String r14 = r13.substring(1);
        if (r14.contains("&jeffmony&") == false) goto L30;
        String[] r15 = r14.split("&jeffmony&");
        String r16 = r15[0];
        File r17 = new File(r12, r15[1]);
        if (r17.exists() == true) goto L33;
        this.f23812g = b(r16, r17);     // Catch: Exception -> L27
        this.f23811f = ResponseState.OK;     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        throw new Exception("HttpResponse download file failed:" + e);
    L33:
        this.f23812g = new FileInputStream(r17);     // Catch: Exception -> L22
        this.f23811f = ResponseState.OK;     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        throw new Exception("No files found to the request:" + r17.getAbsolutePath(), e);
    L30:
        return;
    L5:
        if (r13.startsWith("/https://") == true) goto L16;
        File r18 = new File(r12, r10.f());
        o0.a.d("jeffmony HttpResponse file exist=" + r18.exists());
        if (r18.exists() == true) goto L35;
        this.f23811f = ResponseState.INTERNAL_ERROR;
        throw new Exception("No files found to the request:" + r18.getAbsolutePath());
    L35:
        this.f23812g = new FileInputStream(r18);     // Catch: Exception -> L11
        this.f23811f = ResponseState.OK;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        throw new Exception("No files found to the request:" + r18.getAbsolutePath(), e);
    }

    public void a(PrintWriter r10, String r11, String r12) {
        r10.append(r11).append(": ").append(r12).append("\r\n");
    }

    public InputStream b(String r10, File r11) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
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
            */
        /*
            this = this;
            r0 = 0
            java.net.HttpURLConnection r4 = r3.c(r4)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            int r1 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L1e
            java.io.InputStream r0 = r4.getInputStream()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            r3.d(r0, r5)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1b
            r4.disconnect()
            return r0
        L18:
            r3 = move-exception
            r0 = r4
            goto L26
        L1b:
            r3 = move-exception
            r0 = r4
            goto L25
        L1e:
            r4.disconnect()
            return r0
        L22:
            r3 = move-exception
            goto L26
        L24:
            r3 = move-exception
        L25:
            throw r3     // Catch: java.lang.Throwable -> L22
        L26:
            if (r0 == 0) goto L2b
            r0.disconnect()
        L2b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.d.b(java.lang.String, java.io.File):java.io.InputStream");
    }

    public final HttpURLConnection c(String r10) {
        int r11 = 0;
    L3:
        HttpURLConnection r12 = (HttpURLConnection) new URL(r10).openConnection();
        if (this.f23807b.k() == true) goto L6;
    L8:
        r12.setConnectTimeout(this.f23807b.d());
        r12.setReadTimeout(this.f23807b.h());
        int r13 = r12.getResponseCode();
        if (r13 != 301) goto L11;
    L16:
        boolean r14 = true;
    L17:
        if (r14 == false) goto L20;
        r11 = r11 + 1;
        r12.disconnect();
    L20:
        if (r11 > 3) goto L24;
        if (r14 == true) goto L3;
        return r12;
    L24:
        throw new Exception("Too many redirects: " + r11);
    L11:
        if (r13 == 302) goto L16;
        if (r13 == 303) goto L16;
        r14 = false;
        goto L17
    L6:
        if ((r12 instanceof HttpsURLConnection) == false) goto L8;
        u9.b.h((HttpsURLConnection) r12);
        goto L8
    }

    public final void d(InputStream r10, File r11) {
        FileOutputStream r12 = new FileOutputStream(r11);     // Catch: Throwable -> L15 Exception -> L17
    L27:
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L10 Exception -> L12
    L6:
        int r14 = r10.read(r13);     // Catch: Throwable -> L10 Exception -> L12
        if (r14 == (-1)) goto L14;
        r12.write(r13, 0, r14);     // Catch: Throwable -> L10 Exception -> L12
    L14:
        u9.d.b(r10);
        u9.d.b(r12);
        return;
    L12:
        Exception e10 = e;
    L19:
        o0.a.d(r11.getAbsolutePath() + " saveFile failed, exception=" + e10);     // Catch: Throwable -> L10
        if (r11.exists() == false) goto L14;
        r11.delete();     // Catch: Throwable -> L10
    L10:
        Throwable th = th;
    L24:
        u9.d.b(r10);
        u9.d.b(null);
        throw th;
    L17:
        e = move-exception;
        r12 = null;
        e10 = e;
    L15:
        th = move-exception;
        th = th;
        goto L24
    }

    public void e(OutputStream r10) {
        SimpleDateFormat r11 = new SimpleDateFormat(f23805l, Locale.US);
        r11.setTimeZone(TimeZone.getTimeZone("GMT"));
    L10:
        e = move-exception;
        throw new Exception("send response failed: ", e);     // Catch: Throwable -> L8
    L4:
        if (this.f23811f == null) goto L27;
        PrintWriter r12 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(r10, new b(this.f23809d).b())), false);     // Catch: Throwable -> L8 IOException -> L10
        if (TextUtils.isEmpty(this.f23810e) == false) goto L12;
        r12.append("HTTP/1.1 ");     // Catch: Throwable -> L8 IOException -> L10
    L13:
        r12.append(this.f23811f.getDescription()).append(" \r\n");     // Catch: Throwable -> L8 IOException -> L10
        if (TextUtils.isEmpty(this.f23809d) == true) goto L16;
        a(r12, f23801h, this.f23809d);     // Catch: Throwable -> L8 IOException -> L10
    L16:
        a(r12, f23802i, r11.format(new Date()));     // Catch: Throwable -> L8 IOException -> L10
        String r13 = f23803j;     // Catch: Throwable -> L8 IOException -> L10
        if (this.f23806a.g() == false) goto L19;
        String r14 = "keep-alive";
    L20:
        a(r12, r13, r14);     // Catch: Throwable -> L8 IOException -> L10
        if (this.f23806a.i() == Method.HEAD) goto L23;
        a(r12, f23804k, HTTP.CHUNK_CODING);     // Catch: Throwable -> L8 IOException -> L10
    L23:
        r12.append("\r\n");     // Catch: Throwable -> L8 IOException -> L10
        r12.flush();     // Catch: Throwable -> L8 IOException -> L10
        g(r10);     // Catch: Throwable -> L8 IOException -> L10
        r10.flush();     // Catch: Throwable -> L8 IOException -> L10
        u9.d.b(this.f23812g);
        return;
    L19:
        r14 = "close";
        goto L20
    L12:
        r12.append(this.f23810e + " ");     // Catch: Throwable -> L8 IOException -> L10
        goto L13
    L27:
        throw new Exception("sendResponse(): Status can't be null.");     // Catch: Throwable -> L8 IOException -> L10
    L8:
        th = move-exception;
        u9.d.b(this.f23812g);
        throw th;
    }

    public final void f(OutputStream r10, long r11) {
        byte[] r12 = new byte[(int) PlaybackStateCompat.ACTION_PLAY_FROM_URI];
        if (r11 != (-1)) goto L5;
        boolean r13 = true;
    L7:
        if (r11 > 0) goto L9;
        if (r13 == true) goto L9;
        return;
    L9:
        if (r13 == false) goto L11;
        long r14 = 8192;
    L12:
        InputStream r15 = this.f23812g;
        if (r15 == null) goto L30;
        int r16 = r15.read(r12, 0, (int) r14);
        if (r16 <= 0) goto L17;
        r10.write(r12, 0, r16);
        if (r13 == true) goto L7;
        r11 = r11 - ((long) r16);
        goto L7
    L17:
        return;
    L30:
        return;
    L11:
        r14 = Math.min(r11, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        goto L12
    L5:
        r13 = false;
        goto L7
    }

    public final void g(OutputStream r10) {
        a r11 = new a(r10);
        f(r11, -1);
        r11.a();
    }
}
