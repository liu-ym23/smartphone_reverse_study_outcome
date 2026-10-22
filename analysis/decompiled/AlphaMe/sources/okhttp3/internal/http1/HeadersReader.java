package okhttp3.internal.http1;

import h3.G;
import h3.H;
import k3.InterfaceC0696k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http1/HeadersReader;", "", "", "readLine", "()Ljava/lang/String;", "Lh3/H;", "readHeaders", "()Lh3/H;", "Lk3/k;", "source", "Lk3/k;", "getSource", "()Lk3/k;", "", "headerLimit", "J", "<init>", "(Lk3/k;)V", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class HeadersReader {
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;

    @NotNull
    private final InterfaceC0696k source;

    public HeadersReader(@NotNull InterfaceC0696k source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.headerLimit = 262144L;
    }

    @NotNull
    public final InterfaceC0696k getSource() {
        return this.source;
    }

    @NotNull
    public final H readHeaders() {
        G g4 = new G();
        while (true) {
            String line = readLine();
            if (line.length() == 0) {
                return g4.d();
            }
            g4.b(line);
        }
    }

    @NotNull
    public final String readLine() {
        String strY = this.source.y(this.headerLimit);
        this.headerLimit -= strY.length();
        return strY;
    }
}
