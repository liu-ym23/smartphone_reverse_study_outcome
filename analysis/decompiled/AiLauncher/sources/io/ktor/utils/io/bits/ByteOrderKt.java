package io.ktor.utils.io.bits;

import Y8.m;
import Y8.o;
import Y8.r;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0011\u0010\u0003\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0003\u001a\u00020\u0007*\u00020\u0007¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\u000e\u001a\u00020\u000b*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0016\u0010\u0010\u001a\u00020\u000b*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\"\u0016\u0010\u0014\u001a\u00020\n*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0016\u001a\u00020\n*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\"\u0016\u0010\u001a\u001a\u00020\u0011*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001c\u001a\u00020\u0011*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"LY8/r;", "reverseByteOrder-xj2QHRw", "(S)S", "reverseByteOrder", "LY8/m;", "reverseByteOrder-WZ4Q5Ns", "(I)I", "LY8/o;", "reverseByteOrder-VKZWuLQ", "(J)J", "", "", "getHighByte", "(S)B", "highByte", "getLowByte", "lowByte", "", "getHighShort", "(I)S", "highShort", "getLowShort", "lowShort", "", "getHighInt", "(J)I", "highInt", "getLowInt", "lowInt", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteOrderKt {
    public static final byte getHighByte(short s10) {
        return (byte) (s10 >>> 8);
    }

    public static final int getHighInt(long j10) {
        return (int) (j10 >>> 32);
    }

    public static final short getHighShort(int i10) {
        return (short) (i10 >>> 16);
    }

    public static final byte getLowByte(short s10) {
        return (byte) (s10 & 255);
    }

    public static final int getLowInt(long j10) {
        return (int) (j10 & 4294967295L);
    }

    public static final short getLowShort(int i10) {
        return (short) (i10 & 65535);
    }

    /* renamed from: reverseByteOrder-VKZWuLQ, reason: not valid java name */
    public static final long m215reverseByteOrderVKZWuLQ(long j10) {
        return o.b(Long.reverseBytes(j10));
    }

    /* renamed from: reverseByteOrder-WZ4Q5Ns, reason: not valid java name */
    public static final int m216reverseByteOrderWZ4Q5Ns(int i10) {
        return m.b(Integer.reverseBytes(i10));
    }

    /* renamed from: reverseByteOrder-xj2QHRw, reason: not valid java name */
    public static final short m217reverseByteOrderxj2QHRw(short s10) {
        return r.b(Short.reverseBytes(s10));
    }
}
