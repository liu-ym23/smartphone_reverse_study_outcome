package io.ktor.utils.io.core;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import fb.C4074a;
import fb.s;
import fb.v;
import fb.x;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import n9.C4946a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000N\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0016*\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a%\u0010\u001e\u001a\u00020\u001d*\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010 \u001a\u00020\u001d*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b \u0010!\u001a+\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"*\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b$\u0010%\u001a+\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"*\u00020&2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b$\u0010'\u001a\u0013\u0010(\u001a\u00020\u001d*\u00020\u0005H\u0007¢\u0006\u0004\b(\u0010)\"\u0017\u0010*\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u001b\u00101\u001a\u00020\u0016*\u00020\u00058F¢\u0006\f\u0012\u0004\b0\u0010)\u001a\u0004\b.\u0010/*\f\b\u0007\u0010\u0006\"\u00020\u00052\u00020\u0005¨\u00062"}, d2 = {"", "array", "", "offset", "length", "Lfb/v;", "ByteReadPacket", "([BII)Lfb/v;", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "Lfb/a;", "Sink", "(Lio/ktor/utils/io/pool/ObjectPool;)Lfb/a;", "()Lfb/a;", "out", "readAvailable", "(Lfb/v;Lfb/a;)I", ChatTracker.CLICK_COPY, "(Lfb/v;)Lfb/v;", "", "readShortLittleEndian", "(Lfb/v;)S", "", "count", "discard", "(Lfb/v;J)J", "Lkotlin/Function1;", "", "block", "LY8/t;", "takeWhile", "(Lfb/v;Lp9/l;)V", "readFully", "(Lfb/v;[BII)V", ExifInterface.GPS_DIRECTION_TRUE, "function", "preview", "(Lfb/v;Lp9/l;)Ljava/lang/Object;", "Lfb/s;", "(Lfb/s;Lp9/l;)Ljava/lang/Object;", "release", "(Lfb/v;)V", "ByteReadPacketEmpty", "Lfb/v;", "getByteReadPacketEmpty", "()Lfb/v;", "getRemaining", "(Lfb/v;)J", "getRemaining$annotations", "remaining", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteReadPacketKt {
    private static final v ByteReadPacketEmpty = new C4074a();

    public static final v ByteReadPacket(byte[] array, int i10, int i11) {
        p.i(array, "array");
        C4074a c4074a = new C4074a();
        c4074a.write(array, i10, i11 + i10);
        return c4074a;
    }

    public static /* synthetic */ void ByteReadPacket$annotations() {
    }

    public static /* synthetic */ v ByteReadPacket$default(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return ByteReadPacket(bArr, i10, i11);
    }

    public static final C4074a Sink(ObjectPool<?> pool) {
        p.i(pool, "pool");
        return new C4074a();
    }

    public static final v copy(v vVar) {
        p.i(vVar, "<this>");
        return vVar.peek();
    }

    public static final long discard(v vVar, long j10) throws EOFException {
        p.i(vVar, "<this>");
        vVar.request(j10);
        long jMin = Math.min(j10, getRemaining(vVar));
        vVar.a().skip(jMin);
        return jMin;
    }

    public static /* synthetic */ long discard$default(v vVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return discard(vVar, j10);
    }

    public static final v getByteReadPacketEmpty() {
        return ByteReadPacketEmpty;
    }

    public static final long getRemaining(v vVar) {
        p.i(vVar, "<this>");
        return vVar.a().n();
    }

    public static /* synthetic */ void getRemaining$annotations(v vVar) {
    }

    public static final <T> T preview(v vVar, InterfaceC5074l<? super v, ? extends T> function) throws Exception {
        p.i(vVar, "<this>");
        p.i(function, "function");
        v vVarPeek = vVar.a().peek();
        try {
            T tInvoke = function.invoke(vVarPeek);
            C4946a.a(vVarPeek, null);
            return tInvoke;
        } finally {
        }
    }

    public static final int readAvailable(v vVar, C4074a out) {
        p.i(vVar, "<this>");
        p.i(out, "out");
        long jN = vVar.a().n();
        out.m0(vVar);
        return (int) jN;
    }

    public static final void readFully(v vVar, byte[] out, int i10, int i11) {
        p.i(vVar, "<this>");
        p.i(out, "out");
        x.i(vVar, out, i10, i11 + i10);
    }

    public static /* synthetic */ void readFully$default(v vVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        readFully(vVar, bArr, i10, i11);
    }

    public static final short readShortLittleEndian(v vVar) {
        p.i(vVar, "<this>");
        return x.h(vVar.a());
    }

    public static final void release(v vVar) {
        p.i(vVar, "<this>");
        vVar.close();
    }

    public static final void takeWhile(v vVar, InterfaceC5074l<? super C4074a, Boolean> block) {
        p.i(vVar, "<this>");
        p.i(block, "block");
        while (!vVar.k() && block.invoke(vVar.a()).booleanValue()) {
        }
    }

    public static final C4074a Sink() {
        return new C4074a();
    }

    public static final <T> T preview(s sVar, InterfaceC5074l<? super v, ? extends T> function) throws Exception {
        p.i(sVar, "<this>");
        p.i(function, "function");
        v vVarPeek = sVar.a().peek();
        try {
            T tInvoke = function.invoke(vVarPeek);
            C4946a.a(vVarPeek, null);
            return tInvoke;
        } finally {
        }
    }
}
