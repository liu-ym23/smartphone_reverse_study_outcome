package io.ktor.http.header;

import La.D;
import Z8.C1172u;
import Z8.C1173v;
import Z8.r;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.http.HeaderValueParam;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/http/header/AcceptEncoding;", "Lio/ktor/http/HeaderValueWithParameters;", "", "acceptEncoding", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "", "qValue", "(Ljava/lang/String;D)V", "withQValue", "(D)Lio/ktor/http/header/AcceptEncoding;", "pattern", "", "match", "(Lio/ktor/http/header/AcceptEncoding;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getAcceptEncoding", "()Ljava/lang/String;", "Companion", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptEncoding extends HeaderValueWithParameters {
    private static final AcceptEncoding All;
    private static final AcceptEncoding Br;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AcceptEncoding Compress;
    private static final AcceptEncoding Deflate;
    private static final AcceptEncoding Gzip;
    private static final AcceptEncoding Identity;
    private static final AcceptEncoding Zstd;
    private final String acceptEncoding;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lio/ktor/http/header/AcceptEncoding$Companion;", "", "<init>", "()V", "", "Lio/ktor/http/header/AcceptEncoding;", "encodings", "", "mergeAcceptEncodings", "([Lio/ktor/http/header/AcceptEncoding;)Ljava/lang/String;", "Gzip", "Lio/ktor/http/header/AcceptEncoding;", "getGzip", "()Lio/ktor/http/header/AcceptEncoding;", "Compress", "getCompress", "Deflate", "getDeflate", "Br", "getBr", "Zstd", "getZstd", "Identity", "getIdentity", "All", "getAll", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final AcceptEncoding getAll() {
            return AcceptEncoding.All;
        }

        public final AcceptEncoding getBr() {
            return AcceptEncoding.Br;
        }

        public final AcceptEncoding getCompress() {
            return AcceptEncoding.Compress;
        }

        public final AcceptEncoding getDeflate() {
            return AcceptEncoding.Deflate;
        }

        public final AcceptEncoding getGzip() {
            return AcceptEncoding.Gzip;
        }

        public final AcceptEncoding getIdentity() {
            return AcceptEncoding.Identity;
        }

        public final AcceptEncoding getZstd() {
            return AcceptEncoding.Zstd;
        }

        public final String mergeAcceptEncodings(AcceptEncoding... encodings) {
            p.i(encodings, "encodings");
            return r.w0(encodings, ", ", null, null, 0, null, null, 62, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i10 = 2;
        Gzip = new AcceptEncoding("gzip", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Compress = new AcceptEncoding("compress", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Deflate = new AcceptEncoding("deflate", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Br = new AcceptEncoding("br", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Zstd = new AcceptEncoding("zstd", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        Identity = new AcceptEncoding(e.f30860s, 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        All = new AcceptEncoding("*", 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
    }

    public /* synthetic */ AcceptEncoding(String str, List list, int i10, i iVar) {
        this(str, (List<HeaderValueParam>) ((i10 & 2) != 0 ? C1173v.m() : list));
    }

    public boolean equals(Object other) {
        if (!(other instanceof AcceptEncoding)) {
            return false;
        }
        AcceptEncoding acceptEncoding = (AcceptEncoding) other;
        return D.L(this.acceptEncoding, acceptEncoding.acceptEncoding, true) && p.d(getParameters(), acceptEncoding.getParameters());
    }

    public final String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    public int hashCode() {
        String lowerCase = this.acceptEncoding.toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return lowerCase.hashCode() + (getParameters().hashCode() * 31);
    }

    public final boolean match(AcceptEncoding pattern) {
        boolean zL;
        p.i(pattern, "pattern");
        if (!p.d(pattern.acceptEncoding, "*") && !D.L(pattern.acceptEncoding, this.acceptEncoding, true)) {
            return false;
        }
        for (HeaderValueParam headerValueParam : pattern.getParameters()) {
            String name = headerValueParam.getName();
            String value = headerValueParam.getValue();
            if (p.d(name, "*")) {
                if (!p.d(value, "*")) {
                    List<HeaderValueParam> parameters = getParameters();
                    if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                        Iterator<T> it = parameters.iterator();
                        while (it.hasNext()) {
                            if (D.L(((HeaderValueParam) it.next()).getValue(), value, true)) {
                            }
                        }
                    }
                    zL = false;
                }
                zL = true;
                break;
            }
            String strParameter = parameter(name);
            if (!p.d(value, "*")) {
                zL = D.L(strParameter, value, true);
            } else {
                if (strParameter != null) {
                    zL = true;
                    break;
                    break;
                }
                zL = false;
            }
            if (!zL) {
                return false;
            }
        }
        return true;
    }

    public final AcceptEncoding withQValue(double qValue) {
        return p.d(String.valueOf(qValue), parameter("q")) ? this : new AcceptEncoding(this.acceptEncoding, qValue);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptEncoding(String acceptEncoding, List<HeaderValueParam> parameters) {
        super(acceptEncoding, parameters);
        p.i(acceptEncoding, "acceptEncoding");
        p.i(parameters, "parameters");
        this.acceptEncoding = acceptEncoding;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AcceptEncoding(String acceptEncoding, double d10) {
        this(acceptEncoding, (List<HeaderValueParam>) C1172u.e(new HeaderValueParam("q", String.valueOf(d10))));
        p.i(acceptEncoding, "acceptEncoding");
    }
}
