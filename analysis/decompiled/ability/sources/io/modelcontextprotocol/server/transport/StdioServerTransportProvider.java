package io.modelcontextprotocol.server.transport;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.HTTP;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes3.dex */
public class StdioServerTransportProvider implements McpServerTransportProvider {
    private static final InterfaceC0315b logger = AbstractC0317d.b(StdioServerTransportProvider.class);
    private final Sinks.One<Void> inboundReady;
    private final InputStream inputStream;
    private final AtomicBoolean isClosing;
    private final McpJsonMapper jsonMapper;
    private final OutputStream outputStream;
    private McpServerSession session;

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
            this.inboundSink.asFlux().flatMap(new d(this, 9)).doOnTerminate(new n(this, 3)).subscribe();
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
        public /* synthetic */ Z9.c lambda$handleIncomingMessages$2(McpSchema.JSONRPCMessage jSONRPCMessage) {
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
                            StdioServerTransportProvider.logger.j(line, "Received JSON message: {}");
                            try {
                                if (!this.inboundSink.tryEmitNext(McpSchema.deserializeJsonRpcMessage(StdioServerTransportProvider.this.jsonMapper, line)).isSuccess()) {
                                    break;
                                }
                            } catch (Exception e) {
                                logIfNotClosing("Error processing inbound message", e);
                            }
                        } catch (IOException e6) {
                            logIfNotClosing("Error reading from stdin", e6);
                        }
                    }
                } catch (Exception e9) {
                    logIfNotClosing("Error in inbound processing", e9);
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

        private /* synthetic */ Flux lambda$startOutboundProcessing$10(Flux flux) {
            final int i = 0;
            Flux fluxDoOnComplete = flux.doOnSubscribe(new Consumer(this) { // from class: io.modelcontextprotocol.server.transport.p
                public final /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i6 = i;
                    StdioServerTransportProvider.StdioMcpSessionTransport stdioMcpSessionTransport = this.b;
                    switch (i6) {
                        case 0:
                            stdioMcpSessionTransport.lambda$startOutboundProcessing$5((Z9.e) obj);
                            break;
                        default:
                            stdioMcpSessionTransport.lambda$startOutboundProcessing$8((Throwable) obj);
                            break;
                    }
                }
            }).publishOn(this.outboundScheduler).handle(new BiConsumer() { // from class: io.modelcontextprotocol.server.transport.q
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f4732a.lambda$startOutboundProcessing$6((McpSchema.JSONRPCMessage) obj, (SynchronousSink) obj2);
                }
            }).doOnComplete(new n(this, 2));
            final int i6 = 1;
            return fluxDoOnComplete.doOnError(new Consumer(this) { // from class: io.modelcontextprotocol.server.transport.p
                public final /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i62 = i6;
                    StdioServerTransportProvider.StdioMcpSessionTransport stdioMcpSessionTransport = this.b;
                    switch (i62) {
                        case 0:
                            stdioMcpSessionTransport.lambda$startOutboundProcessing$5((Z9.e) obj);
                            break;
                        default:
                            stdioMcpSessionTransport.lambda$startOutboundProcessing$8((Throwable) obj);
                            break;
                    }
                }
            }).map(new r());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startOutboundProcessing$5(Z9.e eVar) {
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
                String strReplace = StdioServerTransportProvider.this.jsonMapper.writeValueAsString(jSONRPCMessage).replace(HTTP.CRLF, "\\n").replace("\n", "\\n").replace("\r", "\\n");
                synchronized (StdioServerTransportProvider.this.outputStream) {
                    OutputStream outputStream = StdioServerTransportProvider.this.outputStream;
                    Charset charset = StandardCharsets.UTF_8;
                    outputStream.write(strReplace.getBytes(charset));
                    StdioServerTransportProvider.this.outputStream.write("\n".getBytes(charset));
                    StdioServerTransportProvider.this.outputStream.flush();
                }
                synchronousSink.next(jSONRPCMessage);
            } catch (IOException e) {
                if (StdioServerTransportProvider.this.isClosing.get()) {
                    StdioServerTransportProvider.logger.debug("Stream closed during shutdown", e);
                } else {
                    StdioServerTransportProvider.logger.error("Error writing message", e);
                    synchronousSink.error(new RuntimeException(e));
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
                this.inboundScheduler.schedule(new n(this, 1));
            }
        }

        private void startOutboundProcessing() {
            lambda$startOutboundProcessing$10(this.outboundSink.asFlux()).subscribe();
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        /* renamed from: close */
        public void lambda$closeGracefully$1() {
            StdioServerTransportProvider.this.isClosing.set(true);
            StdioServerTransportProvider.logger.debug("Session transport closed");
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> closeGracefully() {
            return Mono.fromRunnable(new n(this, 0));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public Mono<Void> sendMessage(final McpSchema.JSONRPCMessage jSONRPCMessage) {
            return Mono.zip(StdioServerTransportProvider.this.inboundReady.asMono(), this.outboundReady.asMono()).then(Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.server.transport.o
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f4730a.lambda$sendMessage$0(jSONRPCMessage);
                }
            }));
        }

        @Override // io.modelcontextprotocol.spec.McpTransport
        public <T> T unmarshalFrom(Object obj, TypeRef<T> typeRef) {
            return (T) StdioServerTransportProvider.this.jsonMapper.convertValue(obj, typeRef);
        }
    }

    public StdioServerTransportProvider(McpJsonMapper mcpJsonMapper) {
        this(mcpJsonMapper, System.in, System.out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyClients$0(Throwable th) {
        logger.e(th.getMessage(), "Failed to send notification: {}");
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
}
