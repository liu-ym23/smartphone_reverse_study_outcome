package bs7;

import com.byted.cast.proxy.Config;
import com.byted.cast.proxy.ILogger;
import com.byted.cast.proxy.IServerListener;
import com.danikula.videocache.ProxyCacheException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, d> f20274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f20275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ILogger f20276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IServerListener f20278f;

    public final int b() {
        Object r100 = this.f20273a;
        monitor-enter(r100);
        Iterator r101 = ((ConcurrentHashMap) this.f20274b).values().iterator();     // Catch: Throwable -> L10
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L8;
        r102 = r102 + ((d) r101.next()).f20279a.get();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public c(Config r100) {
        f r101 = new f(new cs7.a(), r100);
        this.f20273a = new Object();
        this.f20274b = new ConcurrentHashMap();
        this.f20277e = true;
        this.f20275c = r101;
        if (r100 == null) goto L7;
        this.f20277e = r100.isEnableDebug();
        this.f20276d = r100.getLogger();
        this.f20278f = r100.getServerListener();
        return;
    }

    public final d a(String r100) throws ProxyCacheException {
        Object r101 = this.f20273a;
        monitor-enter(r101);
        d r102 = (d) ((ConcurrentHashMap) this.f20274b).get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = new d(r100, this.f20275c);     // Catch: Throwable -> L9
        ((ConcurrentHashMap) this.f20274b).put(r100, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public final void c(ProxyCacheException r100) {
        String r101 = "HttpProxyCacheServer error: " + r100;
        ILogger r102 = this.f20276d;
        if (r102 == null) goto L6;
        r102.onError("HttpProxyCacheServer", r101);
        return;
    }

    public final void d(String r100) {
        if (this.f20277e == false) goto L8;
        ILogger r101 = this.f20276d;
        if (r101 == null) goto L9;
        r101.onDebug("HttpProxyCacheServer", r100);
        return;
    L9:
        return;
    }

    public final void e(Socket r100) {
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
            boolean r0 = r4.isInputShutdown()     // Catch: java.io.IOException -> La java.net.SocketException -> L16
            if (r0 != 0) goto L1b
            r4.shutdownInput()     // Catch: java.io.IOException -> La java.net.SocketException -> L16
            goto L1b
        La:
            r0 = move-exception
            com.danikula.videocache.ProxyCacheException r1 = new com.danikula.videocache.ProxyCacheException
            java.lang.String r2 = "Error closing socket input stream"
            r1.<init>(r2, r0)
            r3.c(r1)
            goto L1b
        L16:
            java.lang.String r0 = "Releasing input stream… Socket is closed by client."
            r3.d(r0)
        L1b:
            boolean r0 = r4.isOutputShutdown()     // Catch: java.io.IOException -> L25
            if (r0 != 0) goto L42
            r4.shutdownOutput()     // Catch: java.io.IOException -> L25
            goto L42
        L25:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to close socket on proxy side: +"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = ". It seems client have already closed connection."
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.byted.cast.proxy.ILogger r1 = r3.f20276d
            if (r1 == 0) goto L42
            java.lang.String r2 = "HttpProxyCacheServer"
            r1.onWarn(r2, r0)
        L42:
            boolean r0 = r4.isClosed()     // Catch: java.io.IOException -> L4c
            if (r0 != 0) goto L57
            r4.close()     // Catch: java.io.IOException -> L4c
            goto L57
        L4c:
            r4 = move-exception
            com.danikula.videocache.ProxyCacheException r0 = new com.danikula.videocache.ProxyCacheException
            java.lang.String r1 = "Error closing socket"
            r0.<init>(r1, r4)
            r3.c(r0)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bs7.c.e(java.net.Socket):void");
    }
}
