package okhttp3.internal.http;

import h3.C0611u;
import h3.M;
import h3.f0;
import java.util.regex.Pattern;
import k3.InterfaceC0696k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/http/RealResponseBody;", "Lh3/f0;", "", "contentLength", "()J", "Lh3/M;", "contentType", "()Lh3/M;", "Lk3/k;", "source", "()Lk3/k;", "", "contentTypeString", "Ljava/lang/String;", "J", "Lk3/k;", "<init>", "(Ljava/lang/String;JLk3/k;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class RealResponseBody extends f0 {
    private final long contentLength;

    @Nullable
    private final String contentTypeString;

    @NotNull
    private final InterfaceC0696k source;

    public RealResponseBody(@Nullable String str, long j4, @NotNull InterfaceC0696k source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.contentTypeString = str;
        this.contentLength = j4;
        this.source = source;
    }

    @Override // h3.f0
    /* renamed from: contentLength, reason: from getter */
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // h3.f0
    @Nullable
    public M contentType() {
        String str = this.contentTypeString;
        if (str == null) {
            return null;
        }
        Pattern pattern = M.f12732d;
        return C0611u.t(str);
    }

    @Override // h3.f0
    @NotNull
    /* renamed from: source, reason: from getter */
    public InterfaceC0696k getSource() {
        return this.source;
    }
}
