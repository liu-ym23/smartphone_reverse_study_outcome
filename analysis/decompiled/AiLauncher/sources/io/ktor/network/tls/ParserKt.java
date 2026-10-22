package io.ktor.network.tls;

import Y8.t;
import e9.InterfaceC4014c;
import fb.C4074a;
import fb.v;
import fb.x;
import g9.InterfaceC4112d;
import io.ktor.network.tls.extensions.NamedCurve;
import io.ktor.network.tls.extensions.TLSExtension;
import io.ktor.network.tls.extensions.TLSExtensionType;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u0004H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0015\u001a\u00020\u0014*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0018\u001a\u00020\u0017*\u00020\u0000H\u0082@¢\u0006\u0004\b\u0018\u0010\u0003\u001a\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\u0012*\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u0012*\u00020\u0000H\u0080@¢\u0006\u0004\b\u001c\u0010\u0003\"\u0014\u0010\u001d\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/network/tls/TLSRecord;", "readTLSRecord", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "Lfb/v;", "Lio/ktor/network/tls/TLSHandshake;", "readTLSHandshake", "(Lfb/v;)Lio/ktor/network/tls/TLSHandshake;", "Lio/ktor/network/tls/TLSServerHello;", "readTLSServerHello", "(Lfb/v;)Lio/ktor/network/tls/TLSServerHello;", "Lio/ktor/network/tls/extensions/NamedCurve;", "readCurveParams", "(Lfb/v;)Lio/ktor/network/tls/extensions/NamedCurve;", "", "Ljava/security/cert/Certificate;", "readTLSCertificate", "(Lfb/v;)Ljava/util/List;", "", "fieldSize", "Ljava/security/spec/ECPoint;", "readECPoint", "(Lfb/v;I)Ljava/security/spec/ECPoint;", "Lio/ktor/network/tls/TLSVersion;", "readTLSVersion", "(Lfb/v;)Lio/ktor/network/tls/TLSVersion;", "readTripleByteLength", "(Lfb/v;)I", "readShortCompatible", "MAX_TLS_FRAME_SIZE", "I", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ParserKt {
    private static final int MAX_TLS_FRAME_SIZE = 18432;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServerKeyExchangeType.values().length];
            try {
                iArr[ServerKeyExchangeType.NamedCurve.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServerKeyExchangeType.ExplicitPrime.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ServerKeyExchangeType.ExplicitChar.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.ParserKt", f = "Parser.kt", l = {148, 149}, m = "readShortCompatible")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.ParserKt$readShortCompatible$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ParserKt.readShortCompatible(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.ParserKt", f = "Parser.kt", l = {19, 20, 22, 25}, m = "readTLSRecord")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.ParserKt$readTLSRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C43081(InterfaceC4014c<? super C43081> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ParserKt.readTLSRecord(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.ParserKt", f = "Parser.kt", l = {139}, m = "readTLSVersion")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.ParserKt$readTLSVersion$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43091(InterfaceC4014c<? super C43091> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ParserKt.readTLSVersion(null, this);
        }
    }

    public static final NamedCurve readCurveParams(v vVar) {
        p.i(vVar, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[ServerKeyExchangeType.INSTANCE.byCode(vVar.readByte() & 255).ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                throw new IllegalStateException("ExplicitPrime server key exchange type is not yet supported");
            }
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalStateException("ExplicitChar server key exchange type is not yet supported");
        }
        NamedCurve namedCurveFromCode = NamedCurve.INSTANCE.fromCode(vVar.readShort());
        if (namedCurveFromCode != null) {
            return namedCurveFromCode;
        }
        throw new TLSException("Unknown EC id", null, 2, null);
    }

    public static final ECPoint readECPoint(v vVar, int i10) {
        p.i(vVar, "<this>");
        int i11 = vVar.readByte() & 255;
        if (vVar.readByte() != 4) {
            throw new TLSException("Point should be uncompressed", null, 2, null);
        }
        int i12 = (i11 - 1) / 2;
        if (((i10 + 7) >>> 3) == i12) {
            return new ECPoint(new BigInteger(1, x.d(vVar, i12)), new BigInteger(1, x.d(vVar, i12)));
        }
        throw new TLSException("Invalid point component length", null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readShortCompatible(io.ktor.utils.io.ByteReadChannel r6, e9.InterfaceC4014c<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.network.tls.ParserKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.network.tls.ParserKt$readShortCompatible$1 r0 = (io.ktor.network.tls.ParserKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.tls.ParserKt$readShortCompatible$1 r0 = new io.ktor.network.tls.ParserKt$readShortCompatible$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            int r6 = r0.I$0
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            kotlin.C4849c.b(r7)
            goto L6c
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.C4849c.b(r7)
            goto L50
        L42:
            kotlin.C4849c.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = io.ktor.utils.io.ByteReadChannelOperationsKt.readByte(r6, r0)
            if (r7 != r1) goto L50
            goto L68
        L50:
            java.lang.Number r7 = (java.lang.Number) r7
            byte r7 = r7.byteValue()
            r7 = r7 & 255(0xff, float:3.57E-43)
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannelOperationsKt.readByte(r6, r0)
            if (r6 != r1) goto L69
        L68:
            return r1
        L69:
            r5 = r7
            r7 = r6
            r6 = r5
        L6c:
            java.lang.Number r7 = (java.lang.Number) r7
            byte r7 = r7.byteValue()
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            int r6 = r6 + r7
            java.lang.Integer r6 = g9.C4109a.f(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.ParserKt.readShortCompatible(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static final List<Certificate> readTLSCertificate(v vVar) {
        p.i(vVar, "<this>");
        int tripleByteLength = readTripleByteLength(vVar);
        ArrayList arrayList = new ArrayList();
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        p.f(certificateFactory);
        int i10 = 0;
        while (i10 < tripleByteLength) {
            int tripleByteLength2 = readTripleByteLength(vVar);
            if (tripleByteLength2 > tripleByteLength - i10) {
                throw new TLSException("Certificate length is too big", null, 2, null);
            }
            if (tripleByteLength2 > ByteReadPacketKt.getRemaining(vVar)) {
                throw new TLSException("Certificate length is too big", null, 2, null);
            }
            byte[] bArr = new byte[tripleByteLength2];
            v vVar2 = vVar;
            ByteReadPacketKt.readFully$default(vVar2, bArr, 0, 0, 6, null);
            i10 += tripleByteLength2 + 3;
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArr)));
            vVar = vVar2;
        }
        return arrayList;
    }

    public static final TLSHandshake readTLSHandshake(v vVar) {
        p.i(vVar, "<this>");
        TLSHandshake tLSHandshake = new TLSHandshake();
        int i10 = vVar.readInt();
        tLSHandshake.setType(TLSHandshakeType.INSTANCE.byCode(i10 >>> 24));
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully$default(c4074a, x.d(vVar, i10 & 16777215), 0, 0, 6, null);
        tLSHandshake.setPacket(c4074a);
        return tLSHandshake;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readTLSRecord(io.ktor.utils.io.ByteReadChannel r8, e9.InterfaceC4014c<? super io.ktor.network.tls.TLSRecord> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.ParserKt.readTLSRecord(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static final TLSServerHello readTLSServerHello(v vVar) throws TLSException {
        p.i(vVar, "<this>");
        TLSVersion tLSVersion = readTLSVersion(vVar);
        byte[] bArr = new byte[32];
        ByteReadPacketKt.readFully$default(vVar, bArr, 0, 0, 6, null);
        int i10 = vVar.readByte() & 255;
        if (i10 > 32) {
            throw new TLSException("sessionId length limit of 32 bytes exceeded: " + i10 + " specified", null, 2, null);
        }
        byte[] bArr2 = new byte[32];
        ByteReadPacketKt.readFully(vVar, bArr2, 0, i10);
        short s10 = vVar.readShort();
        short s11 = (short) (vVar.readByte() & 255);
        if (s11 != 0) {
            throw new TLSException("Unsupported TLS compression method " + ((int) s11) + " (only null 0 compression method is supported)", null, 2, null);
        }
        if (((int) ByteReadPacketKt.getRemaining(vVar)) == 0) {
            return new TLSServerHello(tLSVersion, bArr, bArr2, s10, s11, null, 32, null);
        }
        int i11 = vVar.readShort() & 65535;
        if (((int) ByteReadPacketKt.getRemaining(vVar)) != i11) {
            throw new TLSException("Invalid extensions size: requested " + i11 + ", available " + ByteReadPacketKt.getRemaining(vVar), null, 2, null);
        }
        ArrayList arrayList = new ArrayList();
        while (ByteReadPacketKt.getRemaining(vVar) > 0) {
            int i12 = vVar.readShort() & 65535;
            int i13 = vVar.readShort() & 65535;
            TLSExtensionType tLSExtensionTypeByCode = TLSExtensionType.INSTANCE.byCode(i12);
            C4074a c4074a = new C4074a();
            BytePacketBuilderKt.writeFully$default(c4074a, x.d(vVar, i13), 0, 0, 6, null);
            t tVar = t.f7040a;
            arrayList.add(new TLSExtension(tLSExtensionTypeByCode, i13, c4074a));
        }
        return new TLSServerHello(tLSVersion, bArr, bArr2, s10, s11, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readTLSVersion(io.ktor.utils.io.ByteReadChannel r5, e9.InterfaceC4014c<? super io.ktor.network.tls.TLSVersion> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.network.tls.ParserKt.C43091
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.network.tls.ParserKt$readTLSVersion$1 r0 = (io.ktor.network.tls.ParserKt.C43091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.tls.ParserKt$readTLSVersion$1 r0 = new io.ktor.network.tls.ParserKt$readTLSVersion$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$1
            io.ktor.network.tls.TLSVersion$Companion r5 = (io.ktor.network.tls.TLSVersion.Companion) r5
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            kotlin.C4849c.b(r6)
            goto L52
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.C4849c.b(r6)
            io.ktor.network.tls.TLSVersion$Companion r6 = io.ktor.network.tls.TLSVersion.INSTANCE
            java.lang.Object r2 = g9.h.a(r5)
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = readShortCompatible(r5, r0)
            if (r5 != r1) goto L4f
            return r1
        L4f:
            r4 = r6
            r6 = r5
            r5 = r4
        L52:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r0 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r0
            io.ktor.network.tls.TLSVersion r5 = r5.byCode(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.ParserKt.readTLSVersion(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static final int readTripleByteLength(v vVar) {
        p.i(vVar, "<this>");
        return (vVar.readShort() & 65535) | ((vVar.readByte() & 255) << 16);
    }

    private static final TLSVersion readTLSVersion(v vVar) {
        return TLSVersion.INSTANCE.byCode(vVar.readShort() & 65535);
    }
}
