package fb;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u001f\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lfb/k;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lfb/a;", "sink", "", "byteCount", "readAtMostTo", "(Lfb/a;J)J", "LY8/t;", "close", "()V", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC4084k extends AutoCloseable {
    @Override // java.lang.AutoCloseable, fb.InterfaceC4083j
    void close();

    long readAtMostTo(C4074a sink, long byteCount);
}
