package io.ktor.websocket;

import La.H;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.aiengine.args.SingleFileBundle;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketDeflateExtension;
import io.ktor.websocket.internals.DeflaterUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/.B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R.\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010%¨\u00060"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "config", "<init>", "(Lio/ktor/websocket/WebSocketDeflateExtension$Config;)V", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "negotiatedProtocols", "", "clientNegotiation", "(Ljava/util/List;)Z", "requestedProtocols", "serverNegotiation", "(Ljava/util/List;)Ljava/util/List;", "Lio/ktor/websocket/Frame;", "frame", "processOutgoingFrame", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processIncomingFrame", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "factory", "Lio/ktor/websocket/WebSocketExtensionFactory;", "getFactory", "()Lio/ktor/websocket/WebSocketExtensionFactory;", "protocols", "Ljava/util/List;", "getProtocols", "()Ljava/util/List;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "outgoingNoContextTakeover", "Z", "getOutgoingNoContextTakeover$ktor_websockets", "()Z", "setOutgoingNoContextTakeover$ktor_websockets", "(Z)V", "incomingNoContextTakeover", "getIncomingNoContextTakeover$ktor_websockets", "setIncomingNoContextTakeover$ktor_websockets", "decompressIncoming", "Companion", "Config", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketDeflateExtension implements WebSocketExtension<Config> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<WebSocketDeflateExtension> key;
    private static final boolean rsv1;
    private static final boolean rsv2 = false;
    private static final boolean rsv3 = false;
    private final Config config;
    private boolean decompressIncoming;
    private final Deflater deflater;
    private final WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> factory;
    private boolean incomingNoContextTakeover;
    private final Inflater inflater;
    private boolean outgoingNoContextTakeover;
    private final List<WebSocketExtensionHeader> protocols;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Companion;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketDeflateExtension;", "<init>", "()V", "Lkotlin/Function1;", "LY8/t;", "config", W4.b.STEP_INSTALL, "(Lp9/l;)Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "", "rsv1", "Z", "getRsv1", "()Z", "rsv2", "getRsv2", "rsv3", "getRsv3", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion implements WebSocketExtensionFactory<Config, WebSocketDeflateExtension> {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public AttributeKey<WebSocketDeflateExtension> getKey() {
            return WebSocketDeflateExtension.key;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv1() {
            return WebSocketDeflateExtension.rsv1;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv2() {
            return WebSocketDeflateExtension.rsv2;
        }

        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public boolean getRsv3() {
            return WebSocketDeflateExtension.rsv3;
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.websocket.WebSocketExtensionFactory
        public WebSocketDeflateExtension install(InterfaceC5074l<? super Config, t> config) {
            p.i(config, "config");
            Config config2 = new Config();
            config.invoke(config2);
            return new WebSocketDeflateExtension(config2);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u0011R4\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\nR.\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'\"\u0004\b+\u0010\n¨\u0006,"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "", "<init>", "()V", "Lkotlin/Function1;", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "LY8/t;", "block", "configureProtocols", "(Lp9/l;)V", "Lio/ktor/websocket/Frame;", "", "compressIf", "", SingleFileBundle.KEY_BYTES, "compressIfBiggerThan", "(I)V", "", "build$ktor_websockets", "()Ljava/util/List;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "clientNoContextTakeOver", "Z", "getClientNoContextTakeOver", "()Z", "setClientNoContextTakeOver", "(Z)V", "serverNoContextTakeOver", "getServerNoContextTakeOver", "setServerNoContextTakeOver", "compressionLevel", "I", "getCompressionLevel", "()I", "setCompressionLevel", "manualConfig", "Lp9/l;", "getManualConfig$ktor_websockets", "()Lp9/l;", "setManualConfig$ktor_websockets", "compressCondition", "getCompressCondition$ktor_websockets", "setCompressCondition$ktor_websockets", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Config {
        private boolean clientNoContextTakeOver;
        private boolean serverNoContextTakeOver;
        private int compressionLevel = -1;
        private InterfaceC5074l<? super List<WebSocketExtensionHeader>, t> manualConfig = new InterfaceC5074l() { // from class: io.ktor.websocket.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WebSocketDeflateExtension.Config.manualConfig$lambda$0((List) obj);
            }
        };
        private InterfaceC5074l<? super Frame, Boolean> compressCondition = new InterfaceC5074l() { // from class: io.ktor.websocket.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(WebSocketDeflateExtension.Config.compressCondition$lambda$1((Frame) obj));
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressCondition$lambda$1(Frame it) {
            p.i(it, "it");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressIf$lambda$3(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, Frame it) {
            p.i(it, "it");
            return ((Boolean) interfaceC5074l.invoke(it)).booleanValue() && ((Boolean) interfaceC5074l2.invoke(it)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean compressIfBiggerThan$lambda$4(int i10, Frame frame) {
            p.i(frame, "frame");
            return frame.getData().length > i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t configureProtocols$lambda$2(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, List it) {
            p.i(it, "it");
            interfaceC5074l.invoke(it);
            interfaceC5074l2.invoke(it);
            return t.f7040a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t manualConfig$lambda$0(List it) {
            p.i(it, "it");
            return t.f7040a;
        }

        public final List<WebSocketExtensionHeader> build$ktor_websockets() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.clientNoContextTakeOver) {
                arrayList2.add("client_no_context_takeover");
            }
            if (this.serverNoContextTakeOver) {
                arrayList2.add("server_no_context_takeover");
            }
            arrayList.add(new WebSocketExtensionHeader("permessage-deflate", arrayList2));
            this.manualConfig.invoke(arrayList);
            return arrayList;
        }

        public final void compressIf(final InterfaceC5074l<? super Frame, Boolean> block) {
            p.i(block, "block");
            final InterfaceC5074l<? super Frame, Boolean> interfaceC5074l = this.compressCondition;
            this.compressCondition = new InterfaceC5074l() { // from class: io.ktor.websocket.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(WebSocketDeflateExtension.Config.compressIf$lambda$3(block, interfaceC5074l, (Frame) obj));
                }
            };
        }

        public final void compressIfBiggerThan(final int bytes) {
            compressIf(new InterfaceC5074l() { // from class: io.ktor.websocket.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(WebSocketDeflateExtension.Config.compressIfBiggerThan$lambda$4(bytes, (Frame) obj));
                }
            });
        }

        public final void configureProtocols(final InterfaceC5074l<? super List<WebSocketExtensionHeader>, t> block) {
            p.i(block, "block");
            final InterfaceC5074l<? super List<WebSocketExtensionHeader>, t> interfaceC5074l = this.manualConfig;
            this.manualConfig = new InterfaceC5074l() { // from class: io.ktor.websocket.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WebSocketDeflateExtension.Config.configureProtocols$lambda$2(interfaceC5074l, block, (List) obj);
                }
            };
        }

        public final boolean getClientNoContextTakeOver() {
            return this.clientNoContextTakeOver;
        }

        public final InterfaceC5074l<Frame, Boolean> getCompressCondition$ktor_websockets() {
            return this.compressCondition;
        }

        public final int getCompressionLevel() {
            return this.compressionLevel;
        }

        public final InterfaceC5074l<List<WebSocketExtensionHeader>, t> getManualConfig$ktor_websockets() {
            return this.manualConfig;
        }

        public final boolean getServerNoContextTakeOver() {
            return this.serverNoContextTakeOver;
        }

        public final void setClientNoContextTakeOver(boolean z10) {
            this.clientNoContextTakeOver = z10;
        }

        public final void setCompressCondition$ktor_websockets(InterfaceC5074l<? super Frame, Boolean> interfaceC5074l) {
            p.i(interfaceC5074l, "<set-?>");
            this.compressCondition = interfaceC5074l;
        }

        public final void setCompressionLevel(int i10) {
            this.compressionLevel = i10;
        }

        public final void setManualConfig$ktor_websockets(InterfaceC5074l<? super List<WebSocketExtensionHeader>, t> interfaceC5074l) {
            p.i(interfaceC5074l, "<set-?>");
            this.manualConfig = interfaceC5074l;
        }

        public final void setServerNoContextTakeOver(boolean z10) {
            this.serverNoContextTakeOver = z10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        InterfaceC5755n interfaceC5755nM = null;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(WebSocketDeflateExtension.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(WebSocketDeflateExtension.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("WebsocketDeflateExtension", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        rsv1 = true;
    }

    public WebSocketDeflateExtension(Config config) {
        p.i(config, "config");
        this.config = config;
        this.factory = INSTANCE;
        this.protocols = config.build$ktor_websockets();
        this.inflater = new Inflater(true);
        this.deflater = new Deflater(config.getCompressionLevel(), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.ktor.websocket.WebSocketExtension
    public boolean clientNegotiation(List<WebSocketExtensionHeader> negotiatedProtocols) {
        Object next;
        p.i(negotiatedProtocols, "negotiatedProtocols");
        Iterator<T> it = negotiatedProtocols.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (p.d(((WebSocketExtensionHeader) next).getName(), "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) next;
        if (webSocketExtensionHeader == null) {
            return false;
        }
        this.incomingNoContextTakeover = this.config.getServerNoContextTakeOver();
        this.outgoingNoContextTakeover = this.config.getClientNoContextTakeOver();
        for (Pair<String, String> pair : webSocketExtensionHeader.parseParameters()) {
            String strA = pair.a();
            String strB = pair.b();
            switch (strA.hashCode()) {
                case -708713803:
                    if (strA.equals("client_no_context_takeover")) {
                        if (!H.x0(strB)) {
                            throw new IllegalStateException(("WebSocket permessage-deflate extension parameter client_no_context_takeover shouldn't have a value. Current: " + strB).toString());
                        }
                        this.outgoingNoContextTakeover = true;
                        break;
                    } else {
                        continue;
                    }
                case 646404390:
                    if (strA.equals("client_max_window_bits") && !H.x0(strB) && Integer.parseInt(strB) != 15) {
                        throw new IllegalStateException("Only 15 window size is supported.");
                    }
                    break;
                case 1266201133:
                    if (strA.equals("server_no_context_takeover")) {
                        if (!H.x0(strB)) {
                            throw new IllegalStateException(("WebSocket permessage-deflate extension parameter server_no_context_takeover shouldn't have a value. Current: " + strB).toString());
                        }
                        this.incomingNoContextTakeover = true;
                        break;
                    } else {
                        continue;
                    }
                case 2034279582:
                    strA.equals("server_max_window_bits");
                    break;
            }
        }
        return true;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public WebSocketExtensionFactory<Config, ? extends WebSocketExtension<Config>> getFactory() {
        return this.factory;
    }

    /* renamed from: getIncomingNoContextTakeover$ktor_websockets, reason: from getter */
    public final boolean getIncomingNoContextTakeover() {
        return this.incomingNoContextTakeover;
    }

    /* renamed from: getOutgoingNoContextTakeover$ktor_websockets, reason: from getter */
    public final boolean getOutgoingNoContextTakeover() {
        return this.outgoingNoContextTakeover;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public List<WebSocketExtensionHeader> getProtocols() {
        return this.protocols;
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public Frame processIncomingFrame(Frame frame) {
        p.i(frame, "frame");
        if (!WebSocketDeflateExtensionKt.isCompressed(frame) && !this.decompressIncoming) {
            return frame;
        }
        this.decompressIncoming = true;
        byte[] bArrInflateFully = DeflaterUtilsKt.inflateFully(this.inflater, frame.getData());
        if (this.incomingNoContextTakeover) {
            this.inflater.reset();
        }
        if (frame.getFin()) {
            this.decompressIncoming = false;
        }
        return Frame.INSTANCE.byType(frame.getFin(), frame.getFrameType(), bArrInflateFully, !rsv1, frame.getRsv2(), frame.getRsv3());
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public Frame processOutgoingFrame(Frame frame) {
        p.i(frame, "frame");
        if ((!(frame instanceof Frame.Text) && !(frame instanceof Frame.Binary)) || !this.config.getCompressCondition$ktor_websockets().invoke(frame).booleanValue()) {
            return frame;
        }
        byte[] bArrDeflateFully = DeflaterUtilsKt.deflateFully(this.deflater, frame.getData());
        if (this.outgoingNoContextTakeover) {
            this.deflater.reset();
        }
        return Frame.INSTANCE.byType(frame.getFin(), frame.getFrameType(), bArrDeflateFully, rsv1, frame.getRsv2(), frame.getRsv3());
    }

    @Override // io.ktor.websocket.WebSocketExtension
    public List<WebSocketExtensionHeader> serverNegotiation(List<WebSocketExtensionHeader> requestedProtocols) {
        Object next;
        p.i(requestedProtocols, "requestedProtocols");
        Iterator<T> it = requestedProtocols.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (p.d(((WebSocketExtensionHeader) next).getName(), "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) next;
        if (webSocketExtensionHeader == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, String> pair : webSocketExtensionHeader.parseParameters()) {
            String strA = pair.a();
            String strB = pair.b();
            Locale locale = Locale.getDefault();
            p.h(locale, "getDefault(...)");
            String lowerCase = strA.toLowerCase(locale);
            p.h(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -708713803:
                    if (!lowerCase.equals("client_no_context_takeover")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strA + ", " + strB + ')').toString());
                    }
                    if (!H.x0(strB)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    this.incomingNoContextTakeover = true;
                    arrayList.add("client_no_context_takeover");
                case 646404390:
                    if (!lowerCase.equals("client_max_window_bits")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strA + ", " + strB + ')').toString());
                    }
                case 1266201133:
                    if (!lowerCase.equals("server_no_context_takeover")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strA + ", " + strB + ')').toString());
                    }
                    if (!H.x0(strB)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    this.outgoingNoContextTakeover = true;
                    arrayList.add("server_no_context_takeover");
                case 2034279582:
                    if (!lowerCase.equals("server_max_window_bits")) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strA + ", " + strB + ')').toString());
                    }
                    if (Integer.parseInt(strB) != 15) {
                        throw new IllegalStateException("Only 15 window size is supported");
                    }
                default:
                    throw new IllegalStateException(("Unsupported extension parameter: (" + strA + ", " + strB + ')').toString());
            }
        }
        return C1172u.e(new WebSocketExtensionHeader("permessage-deflate", arrayList));
    }

    public final void setIncomingNoContextTakeover$ktor_websockets(boolean z10) {
        this.incomingNoContextTakeover = z10;
    }

    public final void setOutgoingNoContextTakeover$ktor_websockets(boolean z10) {
        this.outgoingNoContextTakeover = z10;
    }
}
