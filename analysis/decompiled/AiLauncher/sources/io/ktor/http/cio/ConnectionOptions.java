package io.ktor.http.cio;

import Z8.C1173v;
import Z8.F;
import io.ktor.http.cio.ConnectionOptions;
import io.ktor.http.cio.internals.AsciiCharTree;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/http/cio/ConnectionOptions;", "", "", "close", "keepAlive", "upgrade", "", "", "extraOptions", "<init>", "(ZZZLjava/util/List;)V", "toString", "()Ljava/lang/String;", "buildToString", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Z", "getClose", "()Z", "getKeepAlive", "getUpgrade", "Ljava/util/List;", "getExtraOptions", "()Ljava/util/List;", "Companion", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionOptions {
    private static final ConnectionOptions Close;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConnectionOptions KeepAlive;
    private static final ConnectionOptions Upgrade;
    private static final AsciiCharTree<Pair<String, ConnectionOptions>> knownTypes;
    private final boolean close;
    private final List<String> extraOptions;
    private final boolean keepAlive;
    private final boolean upgrade;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR&\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/http/cio/ConnectionOptions$Companion;", "", "<init>", "()V", "", "connection", "Lio/ktor/http/cio/ConnectionOptions;", M5.e.FAIL_PARSE, "(Ljava/lang/CharSequence;)Lio/ktor/http/cio/ConnectionOptions;", "parseSlow", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30857p, "Lio/ktor/http/cio/ConnectionOptions;", "getClose", "()Lio/ktor/http/cio/ConnectionOptions;", "KeepAlive", "getKeepAlive", "Upgrade", "getUpgrade", "Lio/ktor/http/cio/internals/AsciiCharTree;", "Lkotlin/Pair;", "", "knownTypes", "Lio/ktor/http/cio/internals/AsciiCharTree;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean parse$lambda$0(char c10, int i10) {
            return false;
        }

        private final ConnectionOptions parseSlow(CharSequence connection) {
            int i10;
            int length = connection.length();
            ConnectionOptions keepAlive = null;
            ArrayList arrayList = null;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                while (true) {
                    char cCharAt = connection.charAt(i11);
                    if (cCharAt != ' ' && cCharAt != ',') {
                        i12 = i11;
                        i10 = i12;
                        break;
                    }
                    i11++;
                    if (i11 >= length) {
                        i10 = i11;
                        break;
                    }
                }
                while (i10 < length) {
                    char cCharAt2 = connection.charAt(i10);
                    if (cCharAt2 == ' ' || cCharAt2 == ',') {
                        break;
                    }
                    i10++;
                }
                Pair pair = (Pair) F.Z0(ConnectionOptions.knownTypes.search(connection, i12, i10, true, new p() { // from class: io.ktor.http.cio.i
                    @Override // p9.p
                    public final Object invoke(Object obj, Object obj2) {
                        return Boolean.valueOf(ConnectionOptions.Companion.parseSlow$lambda$1(((Character) obj).charValue(), ((Integer) obj2).intValue()));
                    }
                }));
                if (pair == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(connection.subSequence(i12, i10).toString());
                } else if (keepAlive == null) {
                    keepAlive = (ConnectionOptions) pair.f();
                } else {
                    boolean z10 = true;
                    boolean z11 = keepAlive.getClose() || ((ConnectionOptions) pair.f()).getClose();
                    boolean z12 = keepAlive.getKeepAlive() || ((ConnectionOptions) pair.f()).getKeepAlive();
                    if (!keepAlive.getUpgrade() && !((ConnectionOptions) pair.f()).getUpgrade()) {
                        z10 = false;
                    }
                    i11 = i10;
                    keepAlive = new ConnectionOptions(z11, z12, z10, C1173v.m());
                }
                i11 = i10;
            }
            if (keepAlive == null) {
                keepAlive = getKeepAlive();
            }
            return arrayList == null ? keepAlive : new ConnectionOptions(keepAlive.getClose(), keepAlive.getKeepAlive(), keepAlive.getUpgrade(), arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean parseSlow$lambda$1(char c10, int i10) {
            return false;
        }

        public final ConnectionOptions getClose() {
            return ConnectionOptions.Close;
        }

        public final ConnectionOptions getKeepAlive() {
            return ConnectionOptions.KeepAlive;
        }

        public final ConnectionOptions getUpgrade() {
            return ConnectionOptions.Upgrade;
        }

        public final ConnectionOptions parse(CharSequence connection) {
            if (connection == null) {
                return null;
            }
            List listSearch$default = AsciiCharTree.search$default(ConnectionOptions.knownTypes, connection, 0, 0, true, new p() { // from class: io.ktor.http.cio.j
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(ConnectionOptions.Companion.parse$lambda$0(((Character) obj).charValue(), ((Integer) obj2).intValue()));
                }
            }, 6, null);
            return listSearch$default.size() == 1 ? (ConnectionOptions) ((Pair) listSearch$default.get(0)).f() : parseSlow(connection);
        }

        private Companion() {
        }
    }

    static {
        boolean z10 = false;
        ConnectionOptions connectionOptions = new ConnectionOptions(true, z10, false, null, 14, null);
        Close = connectionOptions;
        boolean z11 = false;
        ConnectionOptions connectionOptions2 = new ConnectionOptions(z10, true, z11, null, 13, null);
        KeepAlive = connectionOptions2;
        ConnectionOptions connectionOptions3 = new ConnectionOptions(false, z11, true, null, 11, null);
        Upgrade = connectionOptions3;
        knownTypes = AsciiCharTree.INSTANCE.build(C1173v.p(Y8.j.a("close", connectionOptions), Y8.j.a("keep-alive", connectionOptions2), Y8.j.a("upgrade", connectionOptions3)), new InterfaceC5074l() { // from class: io.ktor.http.cio.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(ConnectionOptions.knownTypes$lambda$1((Pair) obj));
            }
        }, new p() { // from class: io.ktor.http.cio.h
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Character.valueOf(ConnectionOptions.knownTypes$lambda$2((Pair) obj, ((Integer) obj2).intValue()));
            }
        });
    }

    public ConnectionOptions() {
        this(false, false, false, null, 15, null);
    }

    private final String buildToString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList(this.extraOptions.size() + 3);
        if (this.close) {
            arrayList.add("close");
        }
        if (this.keepAlive) {
            arrayList.add("keep-alive");
        }
        if (this.upgrade) {
            arrayList.add("Upgrade");
        }
        if (!this.extraOptions.isEmpty()) {
            arrayList.addAll(this.extraOptions);
        }
        F.x0(arrayList, sb2, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int knownTypes$lambda$1(Pair it) {
        kotlin.jvm.internal.p.i(it, "it");
        return ((String) it.e()).length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final char knownTypes$lambda$2(Pair t10, int i10) {
        kotlin.jvm.internal.p.i(t10, "t");
        return ((String) t10.e()).charAt(i10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || ConnectionOptions.class != other.getClass()) {
            return false;
        }
        ConnectionOptions connectionOptions = (ConnectionOptions) other;
        return this.close == connectionOptions.close && this.keepAlive == connectionOptions.keepAlive && this.upgrade == connectionOptions.upgrade && kotlin.jvm.internal.p.d(this.extraOptions, connectionOptions.extraOptions);
    }

    public final boolean getClose() {
        return this.close;
    }

    public final List<String> getExtraOptions() {
        return this.extraOptions;
    }

    public final boolean getKeepAlive() {
        return this.keepAlive;
    }

    public final boolean getUpgrade() {
        return this.upgrade;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.close) * 31) + Boolean.hashCode(this.keepAlive)) * 31) + Boolean.hashCode(this.upgrade)) * 31) + this.extraOptions.hashCode();
    }

    public String toString() {
        if (!this.extraOptions.isEmpty()) {
            return buildToString();
        }
        boolean z10 = this.close;
        return (!z10 || this.keepAlive || this.upgrade) ? (z10 || !this.keepAlive || this.upgrade) ? (!z10 && this.keepAlive && this.upgrade) ? "keep-alive, Upgrade" : buildToString() : "keep-alive" : "close";
    }

    public ConnectionOptions(boolean z10, boolean z11, boolean z12, List<String> extraOptions) {
        kotlin.jvm.internal.p.i(extraOptions, "extraOptions");
        this.close = z10;
        this.keepAlive = z11;
        this.upgrade = z12;
        this.extraOptions = extraOptions;
    }

    public /* synthetic */ ConnectionOptions(boolean z10, boolean z11, boolean z12, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? C1173v.m() : list);
    }
}
