package io.ktor.server.routing;

import La.H;
import Z8.C1173v;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.CodecsKt;
import io.ktor.server.routing.RoutingPath;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/server/routing/RoutingPath;", "", "", "Lio/ktor/server/routing/RoutingPathSegment;", "parts", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getParts", "()Ljava/util/List;", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingPath {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RoutingPath root = new RoutingPath(C1173v.m());
    private final List<RoutingPathSegment> parts;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/server/routing/RoutingPath$Companion;", "", "<init>", "()V", "", "path", "Lio/ktor/server/routing/RoutingPath;", M5.e.FAIL_PARSE, "(Ljava/lang/String;)Lio/ktor/server/routing/RoutingPath;", Parameters.ROOT, "Lio/ktor/server/routing/RoutingPath;", "getRoot", "()Lio/ktor/server/routing/RoutingPath;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean parse$lambda$0(String it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.length() > 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RoutingPathSegment parse$lambda$1(String segment) {
            kotlin.jvm.internal.p.i(segment, "segment");
            return (H.f0(segment, '{', false, 2, null) && H.f0(segment, '}', false, 2, null)) ? new RoutingPathSegment(segment, RoutingPathSegmentKind.Parameter) : new RoutingPathSegment(CodecsKt.decodeURLPart$default(segment, 0, 0, null, 7, null), RoutingPathSegmentKind.Constant);
        }

        public final RoutingPath getRoot() {
            return RoutingPath.root;
        }

        public final RoutingPath parse(String path) {
            kotlin.jvm.internal.p.i(path, "path");
            return kotlin.jvm.internal.p.d(path, "/") ? getRoot() : new RoutingPath(SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(H.d1(path, new String[]{"/"}, false, 0, 6, null), new InterfaceC5074l() { // from class: io.ktor.server.routing.A
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(RoutingPath.Companion.parse$lambda$0((String) obj));
                }
            }), new InterfaceC5074l() { // from class: io.ktor.server.routing.B
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return RoutingPath.Companion.parse$lambda$1((String) obj);
                }
            })), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoutingPath(List list, kotlin.jvm.internal.i iVar) {
        this(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$0(RoutingPathSegment it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getValue();
    }

    public final List<RoutingPathSegment> getParts() {
        return this.parts;
    }

    public String toString() {
        return Z8.F.A0(this.parts, "/", null, null, 0, null, new InterfaceC5074l() { // from class: io.ktor.server.routing.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RoutingPath.toString$lambda$0((RoutingPathSegment) obj);
            }
        }, 30, null);
    }

    private RoutingPath(List<RoutingPathSegment> list) {
        this.parts = list;
    }
}
