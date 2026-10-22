package io.ktor.network.sockets;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\n¨\u0006\u001b"}, d2 = {"Lio/ktor/network/sockets/UnixSocketAddress;", "Lio/ktor/network/sockets/SocketAddress;", "Ljava/net/SocketAddress;", Const.JSON_KEY_ADDRESS, "<init>", "(Ljava/net/SocketAddress;)V", "", "path", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)Lio/ktor/network/sockets/UnixSocketAddress;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/net/SocketAddress;", "getAddress$ktor_network", "()Ljava/net/SocketAddress;", "getPath", "Companion", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnixSocketAddress extends SocketAddress {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final Class<?> unixDomainSocketAddressClass;
    private final java.net.SocketAddress address;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/network/sockets/UnixSocketAddress$Companion;", "", "<init>", "()V", "Ljava/lang/Class;", "checkSupportForUnixDomainSockets$ktor_network", "()Ljava/lang/Class;", "checkSupportForUnixDomainSockets", "", "isSupported", "()Z", "unixDomainSocketAddressClass", "Ljava/lang/Class;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Class<?> checkSupportForUnixDomainSockets$ktor_network() {
            Class<?> cls = UnixSocketAddress.unixDomainSocketAddressClass;
            if (cls != null) {
                return cls;
            }
            throw new IllegalStateException("Unix domain sockets are unsupported before Java 16.");
        }

        public final boolean isSupported() {
            return UnixSocketAddress.unixDomainSocketAddressClass != null;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Class<?> cls = null;
        try {
            cls = Class.forName(SocketAddressJvmKt.UNIX_DOMAIN_SOCKET_ADDRESS_CLASS);
        } catch (ClassNotFoundException unused) {
        }
        unixDomainSocketAddressClass = cls;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnixSocketAddress(java.net.SocketAddress address) {
        super(null);
        p.i(address, "address");
        this.address = address;
        if (!p.d(getAddress().getClass().getName(), SocketAddressJvmKt.UNIX_DOMAIN_SOCKET_ADDRESS_CLASS)) {
            throw new IllegalStateException("address should be java.net.UnixDomainSocketAddress");
        }
    }

    public static /* synthetic */ UnixSocketAddress copy$default(UnixSocketAddress unixSocketAddress, String str, int i10, Object obj) throws NoSuchMethodException, SecurityException {
        if ((i10 & 1) != 0) {
            str = unixSocketAddress.getPath();
        }
        return unixSocketAddress.copy(str);
    }

    public final String component1() {
        return getPath();
    }

    public final UnixSocketAddress copy(String path) {
        p.i(path, "path");
        return new UnixSocketAddress(path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!p.d(UnixSocketAddress.class, other != null ? other.getClass() : null)) {
            return false;
        }
        p.g(other, "null cannot be cast to non-null type io.ktor.network.sockets.UnixSocketAddress");
        return p.d(getAddress(), ((UnixSocketAddress) other).getAddress());
    }

    @Override // io.ktor.network.sockets.SocketAddress
    /* renamed from: getAddress$ktor_network, reason: from getter */
    public java.net.SocketAddress getAddress() {
        return this.address;
    }

    public final String getPath() throws NoSuchMethodException, SecurityException {
        Method method = INSTANCE.checkSupportForUnixDomainSockets$ktor_network().getMethod("getPath", null);
        p.h(method, "getMethod(...)");
        return method.invoke(getAddress(), null).toString();
    }

    public int hashCode() {
        return getAddress().hashCode();
    }

    public String toString() {
        return getAddress().toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public UnixSocketAddress(String path) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        p.i(path, "path");
        Object objInvoke = INSTANCE.checkSupportForUnixDomainSockets$ktor_network().getMethod("of", String.class).invoke(null, path);
        p.g(objInvoke, "null cannot be cast to non-null type java.net.SocketAddress");
        this((java.net.SocketAddress) objInvoke);
    }
}
