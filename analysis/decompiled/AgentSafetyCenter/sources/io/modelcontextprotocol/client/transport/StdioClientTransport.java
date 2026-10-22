package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StdioClientTransport implements McpClientTransport {
    private static final rd.b logger = rd.d.b(StdioClientTransport.class);
    private Scheduler errorScheduler;
    private final Sinks.Many<String> errorSink;
    private Scheduler inboundScheduler;
    private final Sinks.Many<McpSchema.JSONRPCMessage> inboundSink;
    private McpJsonMapper jsonMapper;
    private Scheduler outboundScheduler;
    private final Sinks.Many<McpSchema.JSONRPCMessage> outboundSink;
    private final ServerParameters params;
    private Process process;
    private volatile boolean isClosing = false;
    private Consumer<String> stdErrorHandler = new f0(1);

    public StdioClientTransport(ServerParameters serverParameters, McpJsonMapper mcpJsonMapper) {
        Assert.notNull(serverParameters, "The params can not be null");
        Assert.notNull(mcpJsonMapper, "The JsonMapper can not be null");
        this.inboundSink = Sinks.many().unicast().onBackpressureBuffer();
        this.outboundSink = Sinks.many().unicast().onBackpressureBuffer();
        this.params = serverParameters;
        this.jsonMapper = mcpJsonMapper;
        this.errorSink = Sinks.many().unicast().onBackpressureBuffer();
        this.inboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "inbound");
        this.outboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "outbound");
        this.errorScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "error");
    }

    private void handleIncomingErrors() {
        Flux<String> fluxAsFlux = this.errorSink.asFlux();
        g0 g0Var = new g0(0);
        g0Var.f6178f = this;
        VarHandle.storeStoreFence();
        fluxAsFlux.subscribe(g0Var);
    }

    private void handleIncomingMessages(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        Flux<McpSchema.JSONRPCMessage> fluxAsFlux = this.inboundSink.asFlux();
        d dVar = new d(1);
        dVar.f6167b = function;
        VarHandle.storeStoreFence();
        fluxAsFlux.flatMap(dVar).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$11() {
        this.isClosing = true;
        logger.debug("Initiating graceful shutdown");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$12() {
        this.inboundSink.tryEmitComplete();
        this.outboundSink.tryEmitComplete();
        this.errorSink.tryEmitComplete();
        return Mono.delay(Duration.ofMillis(100L)).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$13() {
        rd.b bVar = logger;
        bVar.debug("Sending TERM to process");
        Process process = this.process;
        if (process != null) {
            process.destroy();
            return Mono.fromFuture(this.process.onExit());
        }
        bVar.warn("Process not started");
        return Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$closeGracefully$14(Process process) {
        if (process.exitValue() != 0) {
            logger.b(Integer.valueOf(process.exitValue()), "Process terminated with code {}");
        } else {
            logger.info("MCP server process stopped");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeGracefully$15() {
        try {
            this.inboundScheduler.dispose();
            this.errorScheduler.dispose();
            this.outboundScheduler.dispose();
            logger.debug("Graceful shutdown completed");
        } catch (Exception e10) {
            logger.error("Error during graceful shutdown", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$1(Function function) throws IOException {
        rd.b bVar = logger;
        bVar.info("MCP server starting.");
        handleIncomingMessages(function);
        handleIncomingErrors();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.params.getCommand());
        arrayList.addAll(this.params.getArgs());
        ProcessBuilder processBuilder = getProcessBuilder();
        processBuilder.command(arrayList);
        processBuilder.environment().putAll(this.params.getEnv());
        try {
            Process processStart = processBuilder.start();
            this.process = processStart;
            if (processStart.getInputStream() == null || this.process.getOutputStream() == null) {
                this.process.destroy();
                od.f.o("Process input or output stream is null");
            } else {
                startInboundProcessing();
                startOutboundProcessing();
                startErrorProcessing();
                bVar.info("MCP server started");
            }
        } catch (IOException e10) {
            od.f.g("Failed to start process with command: ".concat(String.valueOf(arrayList)), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleIncomingErrors$5(String str) {
        this.stdErrorHandler.accept(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$handleIncomingMessages$3(Context context) {
        return context.put("observation", "myObservation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ qd.c lambda$handleIncomingMessages$4(Function function, McpSchema.JSONRPCMessage jSONRPCMessage) {
        return Mono.just(jSONRPCMessage).transform(function).contextWrite(new b(8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOutbound$10(Throwable th) {
        if (this.isClosing) {
            return;
        }
        logger.error("Error in outbound processing", th);
        this.isClosing = true;
        this.outboundSink.tryEmitComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOutbound$9() {
        this.isClosing = true;
        this.outboundSink.tryEmitComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(String str) {
        logger.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r5.isClosing != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        io.modelcontextprotocol.client.transport.StdioClientTransport.logger.error("Failed to emit error message");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$startErrorProcessing$2() {
        /*
            r5 = this;
            r0 = 1
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
            java.lang.Process r3 = r5.process     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
            java.io.InputStream r3 = r3.getErrorStream()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
        L11:
            boolean r2 = r5.isClosing     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L41
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L41
            reactor.core.publisher.Sinks$Many<java.lang.String> r3 = r5.errorSink     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            reactor.core.publisher.Sinks$EmitResult r2 = r3.tryEmitNext(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            boolean r2 = r2.isSuccess()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r2 != 0) goto L11
            boolean r2 = r5.isClosing     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r2 != 0) goto L41
            rd.b r2 = io.modelcontextprotocol.client.transport.StdioClientTransport.logger     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.String r3 = "Failed to emit error message"
            r2.error(r3)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            goto L41
        L33:
            r2 = move-exception
            goto L50
        L35:
            r2 = move-exception
            boolean r3 = r5.isClosing     // Catch: java.lang.Throwable -> L33
            if (r3 != 0) goto L41
            rd.b r3 = io.modelcontextprotocol.client.transport.StdioClientTransport.logger     // Catch: java.lang.Throwable -> L33
            java.lang.String r4 = "Error processing error message"
            r3.error(r4, r2)     // Catch: java.lang.Throwable -> L33
        L41:
            r1.close()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
        L44:
            r5.isClosing = r0
            reactor.core.publisher.Sinks$Many<java.lang.String> r5 = r5.errorSink
            r5.tryEmitComplete()
            goto L65
        L4c:
            r1 = move-exception
            goto L66
        L4e:
            r1 = move-exception
            goto L59
        L50:
            r1.close()     // Catch: java.lang.Throwable -> L54
            goto L58
        L54:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
        L58:
            throw r2     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e
        L59:
            boolean r2 = r5.isClosing     // Catch: java.lang.Throwable -> L4c
            if (r2 != 0) goto L44
            rd.b r2 = io.modelcontextprotocol.client.transport.StdioClientTransport.logger     // Catch: java.lang.Throwable -> L4c
            java.lang.String r3 = "Error reading from error stream"
            r2.error(r3, r1)     // Catch: java.lang.Throwable -> L4c
            goto L44
        L65:
            return
        L66:
            r5.isClosing = r0
            reactor.core.publisher.Sinks$Many<java.lang.String> r5 = r5.errorSink
            r5.tryEmitComplete()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.client.transport.StdioClientTransport.lambda$startErrorProcessing$2():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if (r6.isClosing != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        io.modelcontextprotocol.client.transport.StdioClientTransport.logger.f(r3, "Failed to enqueue inbound message: {}");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$startInboundProcessing$6() {
        /*
            r6 = this;
            r0 = 1
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.Process r3 = r6.process     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L11:
            boolean r2 = r6.isClosing     // Catch: java.lang.Throwable -> L39
            if (r2 != 0) goto L47
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L47
            io.modelcontextprotocol.json.McpJsonMapper r3 = r6.jsonMapper     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            io.modelcontextprotocol.spec.McpSchema$JSONRPCMessage r3 = io.modelcontextprotocol.spec.McpSchema.deserializeJsonRpcMessage(r3, r2)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            reactor.core.publisher.Sinks$Many<io.modelcontextprotocol.spec.McpSchema$JSONRPCMessage> r4 = r6.inboundSink     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            reactor.core.publisher.Sinks$EmitResult r4 = r4.tryEmitNext(r3)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            boolean r4 = r4.isSuccess()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            if (r4 != 0) goto L11
            boolean r4 = r6.isClosing     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            if (r4 != 0) goto L47
            rd.b r4 = io.modelcontextprotocol.client.transport.StdioClientTransport.logger     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.String r5 = "Failed to enqueue inbound message: {}"
            r4.f(r3, r5)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            goto L47
        L39:
            r2 = move-exception
            goto L56
        L3b:
            r3 = move-exception
            boolean r4 = r6.isClosing     // Catch: java.lang.Throwable -> L39
            if (r4 != 0) goto L47
            rd.b r4 = io.modelcontextprotocol.client.transport.StdioClientTransport.logger     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = "Error processing inbound message for line: {}"
            r4.e(r5, r2, r3)     // Catch: java.lang.Throwable -> L39
        L47:
            r1.close()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L4a:
            r6.isClosing = r0
            reactor.core.publisher.Sinks$Many<io.modelcontextprotocol.spec.McpSchema$JSONRPCMessage> r6 = r6.inboundSink
            r6.tryEmitComplete()
            goto L6b
        L52:
            r1 = move-exception
            goto L6c
        L54:
            r1 = move-exception
            goto L5f
        L56:
            r1.close()     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L5e:
            throw r2     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L5f:
            boolean r2 = r6.isClosing     // Catch: java.lang.Throwable -> L52
            if (r2 != 0) goto L4a
            rd.b r2 = io.modelcontextprotocol.client.transport.StdioClientTransport.logger     // Catch: java.lang.Throwable -> L52
            java.lang.String r3 = "Error reading from input stream"
            r2.error(r3, r1)     // Catch: java.lang.Throwable -> L52
            goto L4a
        L6b:
            return
        L6c:
            r6.isClosing = r0
            reactor.core.publisher.Sinks$Many<io.modelcontextprotocol.spec.McpSchema$JSONRPCMessage> r6 = r6.inboundSink
            r6.tryEmitComplete()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.client.transport.StdioClientTransport.lambda$startInboundProcessing$6():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutboundProcessing$7(McpSchema.JSONRPCMessage jSONRPCMessage, SynchronousSink synchronousSink) {
        if (jSONRPCMessage == null || this.isClosing) {
            return;
        }
        try {
            String strReplace = this.jsonMapper.writeValueAsString(jSONRPCMessage).replace("\r\n", "\\n").replace("\n", "\\n").replace("\r", "\\n");
            OutputStream outputStream = this.process.getOutputStream();
            synchronized (outputStream) {
                Charset charset = StandardCharsets.UTF_8;
                outputStream.write(strReplace.getBytes(charset));
                outputStream.write("\n".getBytes(charset));
                outputStream.flush();
            }
            synchronousSink.next(jSONRPCMessage);
        } catch (IOException e10) {
            synchronousSink.error(new RuntimeException(e10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Flux lambda$startOutboundProcessing$8(Flux flux) {
        Flux fluxPublishOn = flux.publishOn(this.outboundScheduler);
        h0 h0Var = new h0();
        h0Var.f6180c = this;
        VarHandle.storeStoreFence();
        return fluxPublishOn.handle(h0Var);
    }

    private void startErrorProcessing() {
        Scheduler scheduler = this.errorScheduler;
        e0 e0Var = new e0(2);
        e0Var.f6173f = this;
        VarHandle.storeStoreFence();
        scheduler.schedule(e0Var);
    }

    private void startInboundProcessing() {
        Scheduler scheduler = this.inboundScheduler;
        e0 e0Var = new e0(3);
        e0Var.f6173f = this;
        VarHandle.storeStoreFence();
        scheduler.schedule(e0Var);
    }

    private void startOutboundProcessing() {
        i iVar = new i(1);
        iVar.f6182b = this;
        VarHandle.storeStoreFence();
        handleOutbound(iVar);
    }

    public void awaitForExit() throws InterruptedException {
        try {
            this.process.waitFor();
        } catch (InterruptedException e10) {
            od.f.g("Process interrupted", e10);
        }
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> closeGracefully() {
        e0 e0Var = new e0(4);
        e0Var.f6173f = this;
        VarHandle.storeStoreFence();
        Mono monoFromRunnable = Mono.fromRunnable(e0Var);
        int i = 0;
        j0 j0Var = new j0(i);
        j0Var.f6189f = this;
        VarHandle.storeStoreFence();
        Mono monoThen = monoFromRunnable.then(Mono.defer(j0Var));
        int i3 = 1;
        j0 j0Var2 = new j0(i3);
        j0Var2.f6189f = this;
        VarHandle.storeStoreFence();
        Mono monoDoOnNext = monoThen.then(Mono.defer(j0Var2)).doOnNext(new f0(i));
        e0 e0Var2 = new e0(i3);
        e0Var2.f6173f = this;
        VarHandle.storeStoreFence();
        return monoDoOnNext.then(Mono.fromRunnable(e0Var2)).then().subscribeOn(Schedulers.boundedElastic());
    }

    @Override // io.modelcontextprotocol.spec.McpClientTransport
    public Mono<Void> connect(Function<Mono<McpSchema.JSONRPCMessage>, Mono<McpSchema.JSONRPCMessage>> function) {
        i0 i0Var = new i0();
        i0Var.f6183c = this;
        i0Var.f6184f = function;
        VarHandle.storeStoreFence();
        return Mono.fromRunnable(i0Var).subscribeOn(Schedulers.boundedElastic());
    }

    public Sinks.Many<String> getErrorSink() {
        return this.errorSink;
    }

    public ProcessBuilder getProcessBuilder() {
        return new ProcessBuilder(new String[0]);
    }

    public void handleOutbound(Function<Flux<McpSchema.JSONRPCMessage>, Flux<McpSchema.JSONRPCMessage>> function) {
        Flux<McpSchema.JSONRPCMessage> fluxApply = function.apply(this.outboundSink.asFlux());
        e0 e0Var = new e0(0);
        e0Var.f6173f = this;
        VarHandle.storeStoreFence();
        Flux<McpSchema.JSONRPCMessage> fluxDoOnComplete = fluxApply.doOnComplete(e0Var);
        g0 g0Var = new g0(1);
        g0Var.f6178f = this;
        VarHandle.storeStoreFence();
        fluxDoOnComplete.doOnError(g0Var).subscribe();
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
        return this.outboundSink.tryEmitNext(jSONRPCMessage).isSuccess() ? Mono.empty() : Mono.error(new RuntimeException("Failed to enqueue message"));
    }

    public void setStdErrorHandler(Consumer<String> consumer) {
        this.stdErrorHandler = consumer;
    }

    @Override // io.modelcontextprotocol.spec.McpTransport
    public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
        return (T) this.jsonMapper.convertValue(obj, typeRef);
    }
}
