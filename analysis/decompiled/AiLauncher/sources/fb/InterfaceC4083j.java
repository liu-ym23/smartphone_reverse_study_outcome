package fb;

import java.io.Flushable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lfb/j;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Ljava/io/Flushable;", "Lfb/a;", "source", "", "byteCount", "LY8/t;", "write", "(Lfb/a;J)V", "flush", "()V", "close", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC4083j extends AutoCloseable, Flushable {
    void close();

    @Override // java.io.Flushable
    void flush();

    void write(C4074a source, long byteCount);
}
