package io.ktor.websocket;

import e9.InterfaceC4014c;
import fb.C4074a;
import fb.v;
import g9.InterfaceC4112d;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.MemoryKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a$\u0010\u000b\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0087@¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\u0011\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\u0087@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lfb/v;", "", "maskKey", "mask", "(Lfb/v;I)Lfb/v;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/websocket/Frame;", "frame", "", "masking", "LY8/t;", "writeFrame", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/websocket/Frame;ZLe9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "", "maxFrameSize", "lastOpcode", "readFrame", "(Lio/ktor/utils/io/ByteReadChannel;JILe9/c;)Ljava/lang/Object;", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RawWebSocketCommonKt {

    @InterfaceC4112d(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", l = {226, 227, 246, 247, 255, 263}, m = "readFrame")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.websocket.RawWebSocketCommonKt$readFrame$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        byte B$0;
        byte B$1;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.readFrame(null, 0L, 0, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.websocket.RawWebSocketCommonKt", f = "RawWebSocketCommon.kt", l = {183, 193, 196, 197, 205, 211}, m = "writeFrame")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.websocket.RawWebSocketCommonKt$writeFrame$1, reason: invalid class name and case insensitive filesystem */
    public static final class C44611 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C44611(InterfaceC4014c<? super C44611> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommonKt.writeFrame(null, null, false, this);
        }
    }

    private static final v mask(final v vVar, final int i10) {
        return (v) MemoryKt.withMemory(4, new InterfaceC5074l() { // from class: io.ktor.websocket.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RawWebSocketCommonKt.mask$lambda$2(i10, vVar, (byte[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v mask$lambda$2(int i10, v vVar, byte[] maskMemory) {
        p.i(maskMemory, "maskMemory");
        MemoryKt.storeIntAt(maskMemory, 0, i10);
        C4074a c4074a = new C4074a();
        int remaining = (int) ByteReadPacketKt.getRemaining(vVar);
        for (int i11 = 0; i11 < remaining; i11++) {
            c4074a.H0((byte) (vVar.readByte() ^ maskMemory[i11 % 4]));
        }
        return c4074a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x016f, code lost:
    
        if (r1 == r3) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0195, code lost:
    
        if (r1 == r3) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01df, code lost:
    
        if (r1 == r3) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0247  */
    @io.ktor.utils.io.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFrame(io.ktor.utils.io.ByteReadChannel r20, long r21, int r23, e9.InterfaceC4014c<? super io.ktor.websocket.Frame> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.readFrame(io.ktor.utils.io.ByteReadChannel, long, int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0152, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeLong(r14, r11, r2) == r3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0156, code lost:
    
        r6 = r8;
        r8 = r11;
        r9 = r12;
        r11 = r13;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0176, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeShort(r14, (short) r11, r2) == r3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01e6, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(r12, r10, r2) == r3) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @io.ktor.utils.io.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeFrame(io.ktor.utils.io.ByteWriteChannel r16, io.ktor.websocket.Frame r17, boolean r18, e9.InterfaceC4014c<? super Y8.t> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommonKt.writeFrame(io.ktor.utils.io.ByteWriteChannel, io.ktor.websocket.Frame, boolean, e9.c):java.lang.Object");
    }
}
