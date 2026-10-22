package kotlin.experimental;

import kotlin.Metadata;

/* JADX INFO: compiled from: bitwiseOperations.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0005\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f¨\u0006\u0007"}, d2 = {"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class BitwiseOperationsKt {
    private static final byte and(byte r0, byte r1) {
        return (byte) (r0 & r1);
    }

    private static final short and(short r0, short r1) {
        return (short) (r0 & r1);
    }

    private static final byte inv(byte r0) {
        return (byte) (~r0);
    }

    private static final short inv(short r0) {
        return (short) (~r0);
    }

    private static final byte or(byte r0, byte r1) {
        return (byte) (r0 | r1);
    }

    private static final short or(short r0, short r1) {
        return (short) (r0 | r1);
    }

    private static final byte xor(byte r0, byte r1) {
        return (byte) (r0 ^ r1);
    }

    private static final short xor(short r0, short r1) {
        return (short) (r0 ^ r1);
    }
}
