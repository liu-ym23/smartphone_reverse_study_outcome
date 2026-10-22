package fb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H'¢\u0006\u0004\b!\u0010 R\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010 \u001a\u0004\b#\u0010$\u0082\u0001\u0002\"'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006(À\u0006\u0001"}, d2 = {"Lfb/s;", "Lfb/j;", "", "source", "", "startIndex", "endIndex", "LY8/t;", "write", "([BII)V", "Lfb/k;", "", "m0", "(Lfb/k;)J", "byteCount", "t0", "(Lfb/k;J)V", "", "byte", "H0", "(B)V", "", "short", "writeShort", "(S)V", "int", "writeInt", "(I)V", "long", "writeLong", "(J)V", "flush", "()V", "X", "Lfb/a;", Const.INTENT_KEY_APIKEY, "()Lfb/a;", "getBuffer$annotations", "buffer", "Lfb/l;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface s extends InterfaceC4083j {
    static /* synthetic */ void y0(s sVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        sVar.write(bArr, i10, i11);
    }

    void H0(byte b10);

    void X();

    C4074a a();

    @Override // fb.InterfaceC4083j, java.io.Flushable
    void flush();

    long m0(InterfaceC4084k source);

    void t0(InterfaceC4084k source, long byteCount);

    void write(byte[] source, int startIndex, int endIndex);

    void writeInt(int i10);

    void writeLong(long j10);

    void writeShort(short s10);
}
