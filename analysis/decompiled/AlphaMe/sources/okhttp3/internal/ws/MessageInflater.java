package okhttp3.internal.ws;

import f1.AbstractC0557a;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import k3.C0694i;
import k3.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "Lk3/i;", "buffer", "", "inflate", "(Lk3/i;)V", "close", "()V", "", "noContextTakeover", "Z", "deflatedBytes", "Lk3/i;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Lk3/r;", "inflaterSource", "Lk3/r;", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class MessageInflater implements Closeable {

    @NotNull
    private final C0694i deflatedBytes;

    @NotNull
    private final Inflater inflater;

    @NotNull
    private final r inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z4) {
        this.noContextTakeover = z4;
        C0694i source = new C0694i();
        this.deflatedBytes = source;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.inflaterSource = new r(AbstractC0557a.h(source), inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(@NotNull C0694i buffer) throws DataFormatException, IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (this.deflatedBytes.f13357b != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.A(buffer);
        this.deflatedBytes.Y(65535);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.f13357b;
        do {
            this.inflaterSource.a(buffer, LongCompanionObject.MAX_VALUE);
        } while (this.inflater.getBytesRead() < bytesRead);
    }
}
