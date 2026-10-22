package io.ktor.network.sockets;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 )2\u00020\u0001:\u0006*+,-.)B\u001f\b\u0004\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0000H ¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0000H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0010\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%\u0082\u0001\u0003\u0011/\r¨\u00060"}, d2 = {"Lio/ktor/network/sockets/SocketOptions;", "", "", "customOptions", "<init>", "(Ljava/util/Map;)V", "copy$ktor_network", "()Lio/ktor/network/sockets/SocketOptions;", ChatTracker.CLICK_COPY, "from", "LY8/t;", "copyCommon", "(Lio/ktor/network/sockets/SocketOptions;)V", "Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "peer$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "peer", "Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "tcpAccept$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "tcpAccept", "Ljava/util/Map;", "getCustomOptions", "()Ljava/util/Map;", "Lio/ktor/network/sockets/TypeOfService;", "typeOfService", "B", "getTypeOfService-zieKYfw", "()B", "setTypeOfService-SNCuOGA", "(B)V", "", "reuseAddress", "Z", "getReuseAddress", "()Z", "setReuseAddress", "(Z)V", "reusePort", "getReusePort", "setReusePort", "Companion", "GeneralSocketOptions", "AcceptorOptions", "PeerSocketOptions", "UDPSocketOptions", "TCPClientSocketOptions", "Lio/ktor/network/sockets/SocketOptions$GeneralSocketOptions;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class SocketOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Object, Object> customOptions;
    private boolean reuseAddress;
    private boolean reusePort;
    private byte typeOfService;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "Lio/ktor/network/sockets/SocketOptions;", "", "", "customOptions", "<init>", "(Ljava/util/Map;)V", "copy$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", ChatTracker.CLICK_COPY, "", "backlogSize", "I", "getBacklogSize", "()I", "setBacklogSize", "(I)V", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AcceptorOptions extends SocketOptions {
        private int backlogSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AcceptorOptions(Map<Object, Object> customOptions) {
            super(customOptions, null);
            p.i(customOptions, "customOptions");
            this.backlogSize = 511;
        }

        public final int getBacklogSize() {
            return this.backlogSize;
        }

        public final void setBacklogSize(int i10) {
            this.backlogSize = i10;
        }

        @Override // io.ktor.network.sockets.SocketOptions
        public AcceptorOptions copy$ktor_network() {
            AcceptorOptions acceptorOptions = new AcceptorOptions(new HashMap(getCustomOptions()));
            acceptorOptions.copyCommon(this);
            return acceptorOptions;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lio/ktor/network/sockets/SocketOptions$Companion;", "", "<init>", "()V", "Lio/ktor/network/sockets/SocketOptions;", "create$ktor_network", "()Lio/ktor/network/sockets/SocketOptions;", "create", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SocketOptions create$ktor_network() {
            return new GeneralSocketOptions(new HashMap());
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/network/sockets/SocketOptions$GeneralSocketOptions;", "Lio/ktor/network/sockets/SocketOptions;", "", "", "customOptions", "<init>", "(Ljava/util/Map;)V", "copy$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$GeneralSocketOptions;", ChatTracker.CLICK_COPY, "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GeneralSocketOptions extends SocketOptions {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GeneralSocketOptions(Map<Object, Object> customOptions) {
            super(customOptions, null);
            p.i(customOptions, "customOptions");
        }

        @Override // io.ktor.network.sockets.SocketOptions
        public GeneralSocketOptions copy$ktor_network() {
            GeneralSocketOptions generalSocketOptions = new GeneralSocketOptions(new HashMap(getCustomOptions()));
            generalSocketOptions.copyCommon(this);
            return generalSocketOptions;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "Lio/ktor/network/sockets/SocketOptions;", "", "", "customOptions", "<init>", "(Ljava/util/Map;)V", "from", "LY8/t;", "copyCommon", "(Lio/ktor/network/sockets/SocketOptions;)V", "copy$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", ChatTracker.CLICK_COPY, "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "tcpConnect$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "tcpConnect", "Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "udp$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "udp", "", "sendBufferSize", "I", "getSendBufferSize", "()I", "setSendBufferSize", "(I)V", "receiveBufferSize", "getReceiveBufferSize", "setReceiveBufferSize", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class PeerSocketOptions extends SocketOptions {
        private int receiveBufferSize;
        private int sendBufferSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PeerSocketOptions(Map<Object, Object> customOptions) {
            super(customOptions, null);
            p.i(customOptions, "customOptions");
            this.sendBufferSize = -1;
            this.receiveBufferSize = -1;
        }

        @Override // io.ktor.network.sockets.SocketOptions
        public void copyCommon(SocketOptions from) {
            p.i(from, "from");
            super.copyCommon(from);
            if (from instanceof PeerSocketOptions) {
                PeerSocketOptions peerSocketOptions = (PeerSocketOptions) from;
                this.sendBufferSize = peerSocketOptions.sendBufferSize;
                this.receiveBufferSize = peerSocketOptions.receiveBufferSize;
            }
        }

        public final int getReceiveBufferSize() {
            return this.receiveBufferSize;
        }

        public final int getSendBufferSize() {
            return this.sendBufferSize;
        }

        public final void setReceiveBufferSize(int i10) {
            this.receiveBufferSize = i10;
        }

        public final void setSendBufferSize(int i10) {
            this.sendBufferSize = i10;
        }

        public final TCPClientSocketOptions tcpConnect$ktor_network() {
            TCPClientSocketOptions tCPClientSocketOptions = new TCPClientSocketOptions(new HashMap(getCustomOptions()));
            copyCommon(this);
            return tCPClientSocketOptions;
        }

        public final UDPSocketOptions udp$ktor_network() {
            UDPSocketOptions uDPSocketOptions = new UDPSocketOptions(new HashMap(getCustomOptions()));
            copyCommon(this);
            return uDPSocketOptions;
        }

        @Override // io.ktor.network.sockets.SocketOptions
        public PeerSocketOptions copy$ktor_network() {
            PeerSocketOptions peerSocketOptions = new PeerSocketOptions(new HashMap(getCustomOptions()));
            peerSocketOptions.copyCommon(this);
            return peerSocketOptions;
        }
    }

    public /* synthetic */ SocketOptions(Map map, kotlin.jvm.internal.i iVar) {
        this(map);
    }

    public abstract SocketOptions copy$ktor_network();

    public void copyCommon(SocketOptions from) {
        p.i(from, "from");
        this.typeOfService = from.typeOfService;
        this.reuseAddress = from.reuseAddress;
        this.reusePort = from.reusePort;
    }

    public final Map<Object, Object> getCustomOptions() {
        return this.customOptions;
    }

    public final boolean getReuseAddress() {
        return this.reuseAddress;
    }

    public final boolean getReusePort() {
        return this.reusePort;
    }

    /* renamed from: getTypeOfService-zieKYfw, reason: not valid java name and from getter */
    public final byte getTypeOfService() {
        return this.typeOfService;
    }

    public final PeerSocketOptions peer$ktor_network() {
        PeerSocketOptions peerSocketOptions = new PeerSocketOptions(new HashMap(this.customOptions));
        copyCommon(this);
        return peerSocketOptions;
    }

    public final void setReuseAddress(boolean z10) {
        this.reuseAddress = z10;
    }

    public final void setReusePort(boolean z10) {
        this.reusePort = z10;
    }

    /* renamed from: setTypeOfService-SNCuOGA, reason: not valid java name */
    public final void m142setTypeOfServiceSNCuOGA(byte b10) {
        this.typeOfService = b10;
    }

    public final AcceptorOptions tcpAccept$ktor_network() {
        AcceptorOptions acceptorOptions = new AcceptorOptions(new HashMap(this.customOptions));
        acceptorOptions.copyCommon(this);
        return acceptorOptions;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "", "", "customOptions", "<init>", "(Ljava/util/Map;)V", "Lio/ktor/network/sockets/SocketOptions;", "from", "LY8/t;", "copyCommon", "(Lio/ktor/network/sockets/SocketOptions;)V", "copy$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", ChatTracker.CLICK_COPY, "", "noDelay", "Z", "getNoDelay", "()Z", "setNoDelay", "(Z)V", "", "lingerSeconds", "I", "getLingerSeconds", "()I", "setLingerSeconds", "(I)V", "keepAlive", "Ljava/lang/Boolean;", "getKeepAlive", "()Ljava/lang/Boolean;", "setKeepAlive", "(Ljava/lang/Boolean;)V", "", "socketTimeout", "J", "getSocketTimeout", "()J", "setSocketTimeout", "(J)V", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TCPClientSocketOptions extends PeerSocketOptions {
        private Boolean keepAlive;
        private int lingerSeconds;
        private boolean noDelay;
        private long socketTimeout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TCPClientSocketOptions(Map<Object, Object> customOptions) {
            super(customOptions);
            p.i(customOptions, "customOptions");
            this.noDelay = true;
            this.lingerSeconds = -1;
            this.socketTimeout = Long.MAX_VALUE;
        }

        @Override // io.ktor.network.sockets.SocketOptions.PeerSocketOptions, io.ktor.network.sockets.SocketOptions
        public void copyCommon(SocketOptions from) {
            p.i(from, "from");
            super.copyCommon(from);
            if (from instanceof TCPClientSocketOptions) {
                TCPClientSocketOptions tCPClientSocketOptions = (TCPClientSocketOptions) from;
                this.noDelay = tCPClientSocketOptions.noDelay;
                this.lingerSeconds = tCPClientSocketOptions.lingerSeconds;
                this.keepAlive = tCPClientSocketOptions.keepAlive;
            }
        }

        public final Boolean getKeepAlive() {
            return this.keepAlive;
        }

        public final int getLingerSeconds() {
            return this.lingerSeconds;
        }

        public final boolean getNoDelay() {
            return this.noDelay;
        }

        public final long getSocketTimeout() {
            return this.socketTimeout;
        }

        public final void setKeepAlive(Boolean bool) {
            this.keepAlive = bool;
        }

        public final void setLingerSeconds(int i10) {
            this.lingerSeconds = i10;
        }

        public final void setNoDelay(boolean z10) {
            this.noDelay = z10;
        }

        public final void setSocketTimeout(long j10) {
            this.socketTimeout = j10;
        }

        @Override // io.ktor.network.sockets.SocketOptions.PeerSocketOptions, io.ktor.network.sockets.SocketOptions
        public TCPClientSocketOptions copy$ktor_network() {
            TCPClientSocketOptions tCPClientSocketOptions = new TCPClientSocketOptions(new HashMap(getCustomOptions()));
            tCPClientSocketOptions.copyCommon(this);
            return tCPClientSocketOptions;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", "Lio/ktor/network/sockets/SocketOptions$PeerSocketOptions;", "", "", "customOptions", "<init>", "(Ljava/util/Map;)V", "Lio/ktor/network/sockets/SocketOptions;", "from", "LY8/t;", "copyCommon", "(Lio/ktor/network/sockets/SocketOptions;)V", "copy$ktor_network", "()Lio/ktor/network/sockets/SocketOptions$UDPSocketOptions;", ChatTracker.CLICK_COPY, "", "broadcast", "Z", "getBroadcast", "()Z", "setBroadcast", "(Z)V", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UDPSocketOptions extends PeerSocketOptions {
        private boolean broadcast;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UDPSocketOptions(Map<Object, Object> customOptions) {
            super(customOptions);
            p.i(customOptions, "customOptions");
        }

        @Override // io.ktor.network.sockets.SocketOptions.PeerSocketOptions, io.ktor.network.sockets.SocketOptions
        public void copyCommon(SocketOptions from) {
            p.i(from, "from");
            super.copyCommon(from);
            if (from instanceof UDPSocketOptions) {
                this.broadcast = ((UDPSocketOptions) from).broadcast;
            }
        }

        public final boolean getBroadcast() {
            return this.broadcast;
        }

        public final void setBroadcast(boolean z10) {
            this.broadcast = z10;
        }

        @Override // io.ktor.network.sockets.SocketOptions.PeerSocketOptions, io.ktor.network.sockets.SocketOptions
        public UDPSocketOptions copy$ktor_network() {
            UDPSocketOptions uDPSocketOptions = new UDPSocketOptions(new HashMap(getCustomOptions()));
            uDPSocketOptions.copyCommon(this);
            return uDPSocketOptions;
        }
    }

    private SocketOptions(Map<Object, Object> map) {
        this.customOptions = map;
        this.typeOfService = TypeOfService.INSTANCE.m157getUNDEFINEDzieKYfw();
    }
}
