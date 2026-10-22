package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpServerTransport;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import io.modelcontextprotocol.spec.ProtocolVersions;
import io.modelcontextprotocol.util.Assert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StdioServerTransportProvider implements McpServerTransportProvider {
    private static final rd.b logger = rd.d.b(StdioServerTransportProvider.class);
    private final Sinks.One<Void> inboundReady;
    private final InputStream inputStream;
    private final AtomicBoolean isClosing;
    private final McpJsonMapper jsonMapper;
    private final OutputStream outputStream;
    private McpServerSession session;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class StdioMcpSessionTransport implements McpServerTransport {
        private final AtomicBoolean isStarted = new AtomicBoolean(false);
        private final Sinks.One<Void> outboundReady = Sinks.one();
        private final Sinks.Many<McpSchema.JSONRPCMessage> inboundSink = Sinks.many().unicast().onBackpressureBuffer();
        private final Sinks.Many<McpSchema.JSONRPCMessage> outboundSink = Sinks.many().unicast().onBackpressureBuffer();
        private Scheduler inboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "stdio-inbound");
        private Scheduler outboundScheduler = Schedulers.fromExecutorService(Executors.newSingleThreadExecutor(), "stdio-outbound");

        public StdioMcpSessionTransport() {
        }

        private void handleIncomingMessages() {
            Flux<McpSchema.JSONRPCMessage> fluxAsFlux = this.inboundSink.asFlux();
            n nVar = new n(1);
            nVar.f6315b = this;
            VarHandle.storeStoreFence();
            Flux<R> fluxFlatMap = fluxAsFlux.flatMap(nVar);
            o oVar = new o(0);
            oVar.f6317f = this;
            VarHandle.storeStoreFence();
            fluxFlatMap.doOnTerminate(oVar).subscribe();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initProcessing() {
            handleIncomingMessages();
            startInboundProcessing();
            startOutboundProcessing();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$closeGracefully$1() {
            StdioServerTransportProvider.this.isClosing.set(true);
            StdioServerTransportProvider.logger.debug("Session transport closing gracefully");
            this.inboundSink.tryEmitComplete();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ qd.c lambda$handleIncomingMessages$2(McpSchema.JSONRPCMessage jSONRPCMessage) {
            return StdioServerTransportProvider.this.session.handle(jSONRPCMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleIncomingMessages$3() {
            this.outboundSink.tryEmitComplete();
            this.inboundScheduler.dispose();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Mono lambda$sendMessage$0(McpSchema.JSONRPCMessage jSONRPCMessage) {
            return this.outboundSink.tryEmitNext(jSONRPCMessage).isSuccess() ? Mono.empty() : Mono.error(new RuntimeException("Failed to enqueue message"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startInboundProcessing$4() {
            StdioServerTransportProvider.this.inboundReady.tryEmitValue(null);
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(StdioServerTransportProvider.this.inputStream));
                    while (!StdioServerTransportProvider.this.isClosing.get()) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null || StdioServerTransportProvider.this.isClosing.get()) {
                                break;
                            }
                            StdioServerTransportProvider.logger.h(line, "Received JSON message: {}");
                            try {
                                if (!this.inboundSink.tryEmitNext(McpSchema.deserializeJsonRpcMessage(StdioServerTransportProvider.this.jsonMapper, line)).isSuccess()) {
                                    break;
                                }
                            } catch (Exception e10) {
                                logIfNotClosing("Error processing inbound message", e10);
                            }
                        } catch (IOException e11) {
                            logIfNotClosing("Error reading from stdin", e11);
                        }
                    }
                } catch (Exception e12) {
                    logIfNotClosing("Error in inbound processing", e12);
                    StdioServerTransportProvider.this.isClosing.set(true);
                    if (StdioServerTransportProvider.this.session != null) {
                    }
                }
            } finally {
                StdioServerTransportProvider.this.isClosing.set(true);
                if (StdioServerTransportProvider.this.session != null) {
                    StdioServerTransportProvider.this.session.close();
                }
                this.inboundSink.tryEmitComplete();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Flux lambda$startOutboundProcessing$10(Flux flux) {
            q qVar = new q(0);
            qVar.f6321f = this;
            VarHandle.storeStoreFence();
            Flux fluxPublishOn = flux.doOnSubscribe(qVar).publishOn(this.outboundScheduler);
            r rVar = new r();
            rVar.f6322c = this;
            VarHandle.storeStoreFence();
            Flux fluxHandle = fluxPublishOn.handle(rVar);
            o oVar = new o(3);
            oVar.f6317f = this;
            VarHandle.storeStoreFence();
            Flux fluxDoOnComplete = fluxHandle.doOnComplete(oVar);
            q qVar2 = new q(1);
            qVar2.f6321f = this;
            VarHandle.storeStoreFence();
            return fluxDoOnComplete.doOnError(qVar2).map(new s());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$5(qd.e eVar) {
            this.outboundReady.tryEmitValue(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$6(McpSchema.JSONRPCMessage jSONRPCMessage, SynchronousSink synchronousSink) {
            if (jSONRPCMessage == null || StdioServerTransportProvider.this.isClosing.get()) {
                if (StdioServerTransportProvider.this.isClosing.get()) {
                    synchronousSink.complete();
                    return;
                }
                return;
            }
            try {
                String strReplace = StdioServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage).replace("\r\n", "\\n").replace("\n", "\\n").replace("\r", "\\n");
                synchronized (StdioServerTransportProvider.this.outputStream) {
                    OutputStream outputStream = StdioServerTransportProvider.this.outputStream;
                    Charset charset = StandardCharsets.UTF_8;
                    outputStream.write(strReplace.getBytes(charset));
                    StdioServerTransportProvider.this.outputStream.write("\n".getBytes(charset));
                    StdioServerTransportProvider.this.outputStream.flush();
                }
                synchronousSink.next(jSONRPCMessage);
            } catch (IOException e10) {
                if (StdioServerTransportProvider.this.isClosing.get()) {
                    StdioServerTransportProvider.logger.debug("Stream closed during shutdown", e10);
                } else {
                    StdioServerTransportProvider.logger.error("Error writing message", e10);
                    synchronousSink.error(new RuntimeException(e10));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$7() {
            StdioServerTransportProvider.this.isClosing.set(true);
            this.outboundScheduler.dispose();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$8(Throwable th) {
            if (StdioServerTransportProvider.this.isClosing.get()) {
                return;
            }
            StdioServerTransportProvider.logger.error("Error in outbound processing", th);
            StdioServerTransportProvider.this.isClosing.set(true);
            this.outboundScheduler.dispose();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.JSONRPCMessage lambda$startOutboundProcessing$9(Object obj) {
            return (McpSchema.JSONRPCMessage) obj;
        }

        private void logIfNotClosing(String str, Exception exc) {
            if (StdioServerTransportProvider.this.isClosing.get()) {
                return;
            }
            StdioServerTransportProvider.logger.error(str, exc);
        }

        private void startInboundProcessing() {
            if (this.isStarted.compareAndSet(false, true)) {
                Scheduler scheduler = this.inboundScheduler;
                o oVar = new o(2);
                oVar.f6317f = this;
                VarHandle.storeStoreFence();
                scheduler.schedule(oVar);
            }
        }

        private void startOutboundProcessing() {
            n nVar = new n(0);
            nVar.f6315b = this;
            VarHandle.storeStoreFence();
            ((Flux) nVar.apply(this.outboundSink.asFlux())).subscribe();
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        /* renamed from: close */
        public void lambda$closeGracefully$1() {
            StdioServerTransportProvider.this.isClosing.set(true);
            StdioServerTransportProvider.logger.debug("Session transport closed");
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            o oVar = new o(1);
            oVar.f6317f = this;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(oVar);
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage) {
            Mono monoZip = Mono.zip(StdioServerTransportProvider.this.inboundReady.asMono(), this.outboundReady.asMono());
            p pVar = new p();
            pVar.f6318c = this;
            pVar.f6319f = jSONRPCMessage;
            VarHandle.storeStoreFence();
            return monoZip.then(Mono.defer(pVar));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) StdioServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }
    }

    public StdioServerTransportProvider(McpJsonMapper mcpJsonMapper, InputStream inputStream, OutputStream outputStream) {
        this.isClosing = new AtomicBoolean(false);
        this.inboundReady = Sinks.one();
        Assert.notNull(mcpJsonMapper, "The JsonMapper can not be null");
        Assert.notNull(inputStream, "The InputStream can not be null");
        Assert.notNull(outputStream, "The OutputStream can not be null");
        this.jsonMapper = mcpJsonMapper;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyClients$0(Throwable th) {
        logger.f(th.getMessage(), "Failed to send notification: {}");
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> closeGracefully() {
        McpServerSession mcpServerSession = this.session;
        return mcpServerSession == null ? Mono.empty() : mcpServerSession.closeGracefully();
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public Mono<Void> notifyClients(String str, Object obj) {
        McpServerSession mcpServerSession = this.session;
        return mcpServerSession == null ? Mono.error(new McpError("No session to close")) : mcpServerSession.sendNotification(str, obj).doOnError(new j(1));
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProviderBase
    public List<String> protocolVersions() {
        return List.of(ProtocolVersions.MCP_2024_11_05);
    }

    @Override // io.modelcontextprotocol.spec.McpServerTransportProvider
    public void setSessionFactory(McpServerSession.Factory factory) {
        StdioMcpSessionTransport stdioMcpSessionTransport = new StdioMcpSessionTransport();
        this.session = factory.create(stdioMcpSessionTransport);
        stdioMcpSessionTransport.initProcessing();
    }

    public StdioServerTransportProvider(McpJsonMapper mcpJsonMapper) {
        this(mcpJsonMapper, System.in, System.out);
    }
}
