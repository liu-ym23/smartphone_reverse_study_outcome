package io.ktor.network.tls;

import La.D;
import Ua.C1060i;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Ua.M;
import Wa.r;
import Y8.t;
import Z8.C1168p;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import fb.s;
import fb.v;
import fb.x;
import g9.InterfaceC4112d;
import io.ktor.network.tls.cipher.TLSCipher;
import io.ktor.network.tls.extensions.HashAndSign;
import io.ktor.network.tls.extensions.SignatureAlgorithm;
import io.ktor.network.tls.extensions.SignatureAlgorithmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ProduceKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0016\u0010\u0014J4\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0082@¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\"\u0010#J2\u0010%\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010$\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0082@¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010'\u001a\u00020\u001bH\u0082@¢\u0006\u0004\b)\u0010*J \u0010,\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020(H\u0082@¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b.\u0010\u0014J\u0018\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020/H\u0082@¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b3\u0010\u0014J,\u00109\u001a\u00020\u00102\u0006\u00105\u001a\u0002042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u001006H\u0082@¢\u0006\u0004\b9\u0010:J\r\u0010<\u001a\u00020;¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b>\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010?R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010IR\u0016\u0010J\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010P\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bS\u0010TR#\u0010X\u001a\b\u0012\u0004\u0012\u00020W0V8\u0006¢\u0006\u0012\n\u0004\bX\u0010Y\u0012\u0004\b\\\u0010]\u001a\u0004\bZ\u0010[R\"\u0010_\u001a\u00020^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR#\u0010f\u001a\b\u0012\u0004\u0012\u00020W0e8\u0006¢\u0006\u0012\n\u0004\bf\u0010g\u0012\u0004\bj\u0010]\u001a\u0004\bh\u0010iR \u0010l\u001a\b\u0012\u0004\u0012\u00020k0V8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bl\u0010Y\u0012\u0004\bm\u0010]¨\u0006n"}, d2 = {"Lio/ktor/network/tls/TLSClientHandshake;", "LUa/M;", "Lio/ktor/utils/io/ByteReadChannel;", "rawInput", "Lio/ktor/utils/io/ByteWriteChannel;", "rawOutput", "Lio/ktor/network/tls/TLSConfig;", "config", "Lkotlin/coroutines/d;", "coroutineContext", "LUa/x;", "closeTask", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/network/tls/TLSConfig;Lkotlin/coroutines/d;LUa/x;)V", "Lio/ktor/network/tls/TLSServerHello;", "serverHello", "LY8/t;", "verifyHello", "(Lio/ktor/network/tls/TLSServerHello;)V", "sendClientHello", "(Le9/c;)Ljava/lang/Object;", "receiveServerHello", "handleCertificatesAndKeys", "Lio/ktor/network/tls/SecretExchangeType;", "exchangeType", "Ljava/security/cert/Certificate;", "serverCertificate", "Lio/ktor/network/tls/CertificateInfo;", "certificateInfo", "Lio/ktor/network/tls/EncryptionInfo;", "encryptionInfo", "handleServerDone", "(Lio/ktor/network/tls/SecretExchangeType;Ljava/security/cert/Certificate;Lio/ktor/network/tls/CertificateInfo;Lio/ktor/network/tls/EncryptionInfo;Le9/c;)Ljava/lang/Object;", "", "generatePreSecret", "(Lio/ktor/network/tls/EncryptionInfo;)[B", "preSecret", "sendClientKeyExchange", "(Lio/ktor/network/tls/SecretExchangeType;Ljava/security/cert/Certificate;[BLio/ktor/network/tls/EncryptionInfo;Le9/c;)Ljava/lang/Object;", "info", "Lio/ktor/network/tls/CertificateAndKey;", "sendClientCertificate", "(Lio/ktor/network/tls/CertificateInfo;Le9/c;)Ljava/lang/Object;", "certificateAndKey", "sendClientCertificateVerify", "(Lio/ktor/network/tls/CertificateInfo;Lio/ktor/network/tls/CertificateAndKey;Le9/c;)Ljava/lang/Object;", "sendChangeCipherSpec", "Ljavax/crypto/spec/SecretKeySpec;", "masterKey", "sendClientFinished", "(Ljavax/crypto/spec/SecretKeySpec;Le9/c;)Ljava/lang/Object;", "receiveServerFinished", "Lio/ktor/network/tls/TLSHandshakeType;", "handshakeType", "Lkotlin/Function1;", "Lfb/s;", "block", "sendHandshakeRecord", "(Lio/ktor/network/tls/TLSHandshakeType;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/g;", "close", "()Lkotlinx/coroutines/g;", "negotiate", "Lio/ktor/network/tls/TLSConfig;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "LUa/x;", "Lio/ktor/network/tls/Digest;", "digest", "Lfb/s;", "clientSeed", "[B", "Lio/ktor/network/tls/TLSServerHello;", "masterSecret", "Ljavax/crypto/spec/SecretKeySpec;", "keyMaterial$delegate", "LY8/h;", "getKeyMaterial", "()[B", "keyMaterial", "Lio/ktor/network/tls/cipher/TLSCipher;", "cipher$delegate", "getCipher", "()Lio/ktor/network/tls/cipher/TLSCipher;", "cipher", "LWa/r;", "Lio/ktor/network/tls/TLSRecord;", "input", "LWa/r;", "getInput", "()LWa/r;", "getInput$annotations", "()V", "", "useCipher", "Z", "getUseCipher", "()Z", "setUseCipher", "(Z)V", "LWa/s;", "output", "LWa/s;", "getOutput", "()LWa/s;", "getOutput$annotations", "Lio/ktor/network/tls/TLSHandshake;", "handshakes", "getHandshakes$annotations", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSClientHandshake implements M {

    /* renamed from: cipher$delegate, reason: from kotlin metadata */
    private final Y8.h cipher;
    private final byte[] clientSeed;
    private final InterfaceC1089x closeTask;
    private final TLSConfig config;
    private final kotlin.coroutines.d coroutineContext;
    private final s digest;
    private final r<TLSHandshake> handshakes;
    private final r<TLSRecord> input;

    /* renamed from: keyMaterial$delegate, reason: from kotlin metadata */
    private final Y8.h keyMaterial;
    private volatile SecretKeySpec masterSecret;
    private final Wa.s<TLSRecord> output;
    private volatile TLSServerHello serverHello;
    private boolean useCipher;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SecretExchangeType.values().length];
            try {
                iArr[SecretExchangeType.ECDHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecretExchangeType.RSA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TLSHandshakeType.values().length];
            try {
                iArr2[TLSHandshakeType.Certificate.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[TLSHandshakeType.CertificateRequest.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[TLSHandshakeType.ServerKeyExchange.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TLSHandshakeType.ServerDone.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {240, 307}, m = "handleCertificatesAndKeys")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$handleCertificatesAndKeys$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.handleCertificatesAndKeys(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {327, 331, 345, 347, 348}, m = "handleServerDone")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$handleServerDone$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43101 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C43101(InterfaceC4014c<? super C43101> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.handleServerDone(null, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {177, 178, 181, 182}, m = "negotiate")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$negotiate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43111 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C43111(InterfaceC4014c<? super C43111> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.negotiate(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {460}, m = "receiveServerFinished")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$receiveServerFinished$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43121 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43121(InterfaceC4014c<? super C43121> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.receiveServerFinished(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {224}, m = "receiveServerHello")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$receiveServerHello$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43131(InterfaceC4014c<? super C43131> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.receiveServerHello(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {444}, m = "sendChangeCipherSpec")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$sendChangeCipherSpec$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43141 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43141(InterfaceC4014c<? super C43141> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.sendChangeCipherSpec(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {411}, m = "sendClientCertificate")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$sendClientCertificate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43151(InterfaceC4014c<? super C43151> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.sendClientCertificate(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSClientHandshake", f = "TLSClientHandshake.kt", l = {494}, m = "sendHandshakeRecord")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSClientHandshake$sendHandshakeRecord$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C43161(InterfaceC4014c<? super C43161> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSClientHandshake.this.sendHandshakeRecord(null, null, this);
        }
    }

    public TLSClientHandshake(ByteReadChannel rawInput, final ByteWriteChannel rawOutput, TLSConfig config, kotlin.coroutines.d coroutineContext, InterfaceC1089x closeTask) {
        p.i(rawInput, "rawInput");
        p.i(rawOutput, "rawOutput");
        p.i(config, "config");
        p.i(coroutineContext, "coroutineContext");
        p.i(closeTask, "closeTask");
        this.config = config;
        this.coroutineContext = coroutineContext;
        this.closeTask = closeTask;
        this.digest = UtilsKt.Digest();
        this.clientSeed = TLSClientHandshakeKt.generateClientSeed(config.getRandom());
        this.keyMaterial = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.network.tls.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TLSClientHandshake.keyMaterial_delegate$lambda$1(this.f33322a);
            }
        });
        this.cipher = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.network.tls.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TLSClientHandshake.cipher_delegate$lambda$2(this.f33323a);
            }
        });
        this.input = ProduceKt.e(this, new CoroutineName("cio-tls-parser"), 0, new TLSClientHandshake$input$1(rawInput, this, null), 2, null);
        Wa.s<TLSRecord> sVarB = Wa.b.b(this, new CoroutineName("cio-tls-encoder"), 0, null, null, new TLSClientHandshake$output$1(this, rawOutput, null), 14, null);
        sVarB.invokeOnClose(new InterfaceC5074l() { // from class: io.ktor.network.tls.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSClientHandshake.output$lambda$4$lambda$3(this.f33324a, rawOutput, (Throwable) obj);
            }
        });
        this.output = sVarB;
        this.handshakes = ProduceKt.e(this, new CoroutineName("cio-tls-handshake"), 0, new TLSClientHandshake$handshakes$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TLSCipher cipher_delegate$lambda$2(TLSClientHandshake tLSClientHandshake) {
        TLSCipher.Companion companion = TLSCipher.INSTANCE;
        TLSServerHello tLSServerHello = tLSClientHandshake.serverHello;
        if (tLSServerHello == null) {
            p.A("serverHello");
            tLSServerHello = null;
        }
        return companion.fromSuite(tLSServerHello.getCipherSuite(), tLSClientHandshake.getKeyMaterial());
    }

    private final byte[] generatePreSecret(EncryptionInfo encryptionInfo) throws IllegalStateException, NoSuchAlgorithmException, TLSException, InvalidKeyException {
        TLSServerHello tLSServerHello = this.serverHello;
        if (tLSServerHello == null) {
            p.A("serverHello");
            tLSServerHello = null;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[tLSServerHello.getCipherSuite().getExchangeType().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            byte[] bArr = new byte[48];
            this.config.getRandom().nextBytes(bArr);
            bArr[0] = 3;
            bArr[1] = 3;
            return bArr;
        }
        KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH");
        p.f(keyAgreement);
        if (encryptionInfo == null) {
            throw new TLSException("ECDHE_ECDSA: Encryption info should be provided", null, 2, null);
        }
        keyAgreement.init(encryptionInfo.getClientPrivate());
        keyAgreement.doPhase(encryptionInfo.getServerPublic(), true);
        byte[] bArrGenerateSecret = keyAgreement.generateSecret();
        p.f(bArrGenerateSecret);
        return bArrGenerateSecret;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TLSCipher getCipher() {
        return (TLSCipher) this.cipher.getValue();
    }

    private static /* synthetic */ void getHandshakes$annotations() {
    }

    public static /* synthetic */ void getInput$annotations() {
    }

    private final byte[] getKeyMaterial() {
        return (byte[]) this.keyMaterial.getValue();
    }

    public static /* synthetic */ void getOutput$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e9, code lost:
    
        if (handleServerDone(r11, (java.security.cert.Certificate) r4, r9, r3, r2) == r6) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0265, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:74:0x023c, B:73:0x023a], limit reached: 107 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097 A[PHI: r1 r3 r7 r8 r9 r10 r11
      0x0097: PHI (r1v9 java.lang.Object) = (r1v8 java.lang.Object), (r1v1 java.lang.Object) binds: [B:21:0x0094, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r3v4 io.ktor.network.tls.EncryptionInfo) = (r3v3 io.ktor.network.tls.EncryptionInfo), (r3v16 io.ktor.network.tls.EncryptionInfo) binds: [B:21:0x0094, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r7v2 int) = (r7v1 int), (r7v0 int) binds: [B:21:0x0094, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r8v2 ??) = (r8v12 ??), (r8v11 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) binds: [B:21:0x0094, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r9v2 io.ktor.network.tls.CertificateInfo) = (r9v1 io.ktor.network.tls.CertificateInfo), (r9v13 io.ktor.network.tls.CertificateInfo) binds: [B:21:0x0094, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r10v2 kotlin.jvm.internal.Ref$ObjectRef) = (r10v1 kotlin.jvm.internal.Ref$ObjectRef), (r10v4 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:21:0x0094, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r11v2 io.ktor.network.tls.SecretExchangeType) = (r11v1 io.ktor.network.tls.SecretExchangeType), (r11v11 io.ktor.network.tls.SecretExchangeType) binds: [B:21:0x0094, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r13v7, types: [T, java.security.cert.X509Certificate] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Throwable, kotlin.jvm.internal.i] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable, kotlin.jvm.internal.i] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0094 -> B:23:0x0097). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleCertificatesAndKeys(e9.InterfaceC4014c<? super Y8.t> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.handleCertificatesAndKeys(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b4, code lost:
    
        if (sendClientCertificateVerify(r11, r3, r5) == r6) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0223, code lost:
    
        if (sendClientFinished(r12, r5) != r6) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleServerDone(io.ktor.network.tls.SecretExchangeType r23, java.security.cert.Certificate r24, io.ktor.network.tls.CertificateInfo r25, io.ktor.network.tls.EncryptionInfo r26, e9.InterfaceC4014c<? super Y8.t> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.handleServerDone(io.ktor.network.tls.SecretExchangeType, java.security.cert.Certificate, io.ktor.network.tls.CertificateInfo, io.ktor.network.tls.EncryptionInfo, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] keyMaterial_delegate$lambda$1(TLSClientHandshake tLSClientHandshake) {
        TLSServerHello tLSServerHello = tLSClientHandshake.serverHello;
        TLSServerHello tLSServerHello2 = null;
        if (tLSServerHello == null) {
            p.A("serverHello");
            tLSServerHello = null;
        }
        CipherSuite cipherSuite = tLSServerHello.getCipherSuite();
        SecretKeySpec secretKeySpec = tLSClientHandshake.masterSecret;
        if (secretKeySpec == null) {
            p.A("masterSecret");
            secretKeySpec = null;
        }
        TLSServerHello tLSServerHello3 = tLSClientHandshake.serverHello;
        if (tLSServerHello3 == null) {
            p.A("serverHello");
        } else {
            tLSServerHello2 = tLSServerHello3;
        }
        return KeysKt.keyMaterial(secretKeySpec, C1168p.E(tLSServerHello2.getServerSeed(), tLSClientHandshake.clientSeed), cipherSuite.getKeyStrengthInBytes(), cipherSuite.getMacStrengthInBytes(), cipherSuite.getFixedIvLength());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t output$lambda$4$lambda$3(TLSClientHandshake tLSClientHandshake, ByteWriteChannel byteWriteChannel, Throwable th) {
        C1060i.d(tLSClientHandshake, new CoroutineName("cio-tls-closer"), null, new TLSClientHandshake$output$2$1$1(tLSClientHandshake, byteWriteChannel, null), 2, null);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object receiveServerFinished(e9.InterfaceC4014c<? super Y8.t> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.receiveServerFinished(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object receiveServerHello(e9.InterfaceC4014c<? super io.ktor.network.tls.TLSServerHello> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.network.tls.TLSClientHandshake.C43131
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.network.tls.TLSClientHandshake$receiveServerHello$1 r0 = (io.ktor.network.tls.TLSClientHandshake.C43131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.tls.TLSClientHandshake$receiveServerHello$1 r0 = new io.ktor.network.tls.TLSClientHandshake$receiveServerHello$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            Wa.r<io.ktor.network.tls.TLSHandshake> r4 = r4.handshakes
            r0.label = r3
            java.lang.Object r5 = r4.receive(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            io.ktor.network.tls.TLSHandshake r5 = (io.ktor.network.tls.TLSHandshake) r5
            io.ktor.network.tls.TLSHandshakeType r4 = r5.getType()
            io.ktor.network.tls.TLSHandshakeType r0 = io.ktor.network.tls.TLSHandshakeType.ServerHello
            if (r4 != r0) goto L52
            fb.v r4 = r5.getPacket()
            io.ktor.network.tls.TLSServerHello r4 = io.ktor.network.tls.ParserKt.readTLSServerHello(r4)
            return r4
        L52:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Expected TLS handshake ServerHello but got "
            r4.append(r0)
            io.ktor.network.tls.TLSHandshakeType r5 = r5.getType()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.receiveServerHello(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendChangeCipherSpec(e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.network.tls.TLSClientHandshake.C43141
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.network.tls.TLSClientHandshake$sendChangeCipherSpec$1 r0 = (io.ktor.network.tls.TLSClientHandshake.C43141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.tls.TLSClientHandshake$sendChangeCipherSpec$1 r0 = new io.ktor.network.tls.TLSClientHandshake$sendChangeCipherSpec$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r10 = r0.L$0
            fb.v r10 = (fb.v) r10
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L2d
            goto L5a
        L2d:
            r0 = move-exception
            r11 = r0
            goto L60
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            kotlin.C4849c.b(r11)
            fb.a r7 = new fb.a
            r7.<init>()
            r7.H0(r3)
            Wa.s<io.ktor.network.tls.TLSRecord> r10 = r10.output     // Catch: java.lang.Throwable -> L5d
            io.ktor.network.tls.TLSRecord r4 = new io.ktor.network.tls.TLSRecord     // Catch: java.lang.Throwable -> L5d
            io.ktor.network.tls.TLSRecordType r5 = io.ktor.network.tls.TLSRecordType.ChangeCipherSpec     // Catch: java.lang.Throwable -> L5d
            r8 = 2
            r9 = 0
            r6 = 0
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5d
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L5d
            r0.label = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r10 = r10.send(r4, r0)     // Catch: java.lang.Throwable -> L5d
            if (r10 != r1) goto L5a
            return r1
        L5a:
            Y8.t r10 = Y8.t.f7040a
            return r10
        L5d:
            r0 = move-exception
            r11 = r0
            r10 = r7
        L60:
            r10.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.sendChangeCipherSpec(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendClientCertificate(io.ktor.network.tls.CertificateInfo r13, e9.InterfaceC4014c<? super io.ktor.network.tls.CertificateAndKey> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.sendClientCertificate(io.ktor.network.tls.CertificateInfo, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sendClientCertificate$lambda$27(CertificateAndKey certificateAndKey, s sendHandshakeRecord) throws CertificateEncodingException {
        X509Certificate[] certificateChain;
        p.i(sendHandshakeRecord, "$this$sendHandshakeRecord");
        if (certificateAndKey == null || (certificateChain = certificateAndKey.getCertificateChain()) == null) {
            certificateChain = new X509Certificate[0];
        }
        RenderKt.writeTLSCertificates(sendHandshakeRecord, certificateChain);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendClientCertificateVerify(CertificateInfo certificateInfo, CertificateAndKey certificateAndKey, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        final HashAndSign hashAndSign;
        X509Certificate x509Certificate = (X509Certificate) Z8.r.X(certificateAndKey.getCertificateChain());
        HashAndSign[] hashAndSign2 = certificateInfo.getHashAndSign();
        int length = hashAndSign2.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                hashAndSign = null;
                break;
            }
            hashAndSign = hashAndSign2[i10];
            if (D.L(hashAndSign.getName(), x509Certificate.getSigAlgName(), true)) {
                break;
            }
            i10++;
        }
        if (hashAndSign != null && hashAndSign.getSign() != SignatureAlgorithm.DSA) {
            final Signature signature = Signature.getInstance(((X509Certificate) Z8.r.X(certificateAndKey.getCertificateChain())).getSigAlgName());
            p.f(signature);
            signature.initSign(certificateAndKey.getKey());
            Object objSendHandshakeRecord = sendHandshakeRecord(TLSHandshakeType.CertificateVerify, new InterfaceC5074l() { // from class: io.ktor.network.tls.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TLSClientHandshake.sendClientCertificateVerify$lambda$30(hashAndSign, this, signature, (s) obj);
                }
            }, interfaceC4014c);
            return objSendHandshakeRecord == C4063a.g() ? objSendHandshakeRecord : t.f7040a;
        }
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sendClientCertificateVerify$lambda$30(HashAndSign hashAndSign, TLSClientHandshake tLSClientHandshake, final Signature signature, s sendHandshakeRecord) throws Exception {
        p.i(sendHandshakeRecord, "$this$sendHandshakeRecord");
        sendHandshakeRecord.H0(hashAndSign.getHash().getCode());
        sendHandshakeRecord.H0(hashAndSign.getSign().getCode());
        ByteReadPacketKt.preview(tLSClientHandshake.digest, new InterfaceC5074l() { // from class: io.ktor.network.tls.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSClientHandshake.sendClientCertificateVerify$lambda$30$lambda$29(signature, (v) obj);
            }
        });
        byte[] bArrSign = signature.sign();
        p.f(bArrSign);
        sendHandshakeRecord.writeShort((short) bArrSign.length);
        BytePacketBuilderKt.writeFully$default(sendHandshakeRecord, bArrSign, 0, 0, 6, null);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sendClientCertificateVerify$lambda$30$lambda$29(Signature signature, v it) throws SignatureException {
        p.i(it, "it");
        signature.update(x.c(it));
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendClientFinished(SecretKeySpec secretKeySpec, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        s sVar = this.digest;
        TLSServerHello tLSServerHello = this.serverHello;
        if (tLSServerHello == null) {
            p.A("serverHello");
            tLSServerHello = null;
        }
        final v vVarFinished = RenderKt.finished(Digest.m161doHashimpl(sVar, tLSServerHello.getCipherSuite().getHash().getOpenSSLName()), secretKeySpec);
        Object objSendHandshakeRecord = sendHandshakeRecord(TLSHandshakeType.Finished, new InterfaceC5074l() { // from class: io.ktor.network.tls.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSClientHandshake.sendClientFinished$lambda$32(vVarFinished, (s) obj);
            }
        }, interfaceC4014c);
        return objSendHandshakeRecord == C4063a.g() ? objSendHandshakeRecord : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sendClientFinished$lambda$32(v vVar, s sendHandshakeRecord) {
        p.i(sendHandshakeRecord, "$this$sendHandshakeRecord");
        BytePacketBuilderKt.writePacket(sendHandshakeRecord, vVar);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendClientHello(InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objSendHandshakeRecord = sendHandshakeRecord(TLSHandshakeType.ClientHello, new InterfaceC5074l() { // from class: io.ktor.network.tls.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSClientHandshake.sendClientHello$lambda$9(this.f33326a, (s) obj);
            }
        }, interfaceC4014c);
        return objSendHandshakeRecord == C4063a.g() ? objSendHandshakeRecord : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sendClientHello$lambda$9(TLSClientHandshake tLSClientHandshake, s sendHandshakeRecord) throws TLSException {
        p.i(sendHandshakeRecord, "$this$sendHandshakeRecord");
        RenderKt.writeTLSClientHello(sendHandshakeRecord, TLSVersion.TLS12, tLSClientHandshake.config.getCipherSuites(), tLSClientHandshake.clientSeed, new byte[32], tLSClientHandshake.config.getServerName());
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendClientKeyExchange(SecretExchangeType secretExchangeType, Certificate certificate, byte[] bArr, EncryptionInfo encryptionInfo, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        final C4074a c4074a;
        int i10 = WhenMappings.$EnumSwitchMapping$0[secretExchangeType.ordinal()];
        if (i10 == 1) {
            c4074a = new C4074a();
            if (encryptionInfo == null) {
                throw new TLSException("ECDHE: Encryption info should be provided", null, 2, null);
            }
            RenderKt.writePublicKeyUncompressed(c4074a, encryptionInfo.getClientPublic());
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            c4074a = new C4074a();
            PublicKey publicKey = certificate.getPublicKey();
            p.h(publicKey, "getPublicKey(...)");
            RenderKt.writeEncryptedPreMasterSecret(c4074a, bArr, publicKey, this.config.getRandom());
        }
        Object objSendHandshakeRecord = sendHandshakeRecord(TLSHandshakeType.ClientKeyExchange, new InterfaceC5074l() { // from class: io.ktor.network.tls.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSClientHandshake.sendClientKeyExchange$lambda$22(c4074a, (s) obj);
            }
        }, interfaceC4014c);
        return objSendHandshakeRecord == C4063a.g() ? objSendHandshakeRecord : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t sendClientKeyExchange$lambda$22(v vVar, s sendHandshakeRecord) {
        p.i(sendHandshakeRecord, "$this$sendHandshakeRecord");
        BytePacketBuilderKt.writePacket(sendHandshakeRecord, vVar);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendHandshakeRecord(io.ktor.network.tls.TLSHandshakeType r11, p9.InterfaceC5074l<? super fb.s, Y8.t> r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof io.ktor.network.tls.TLSClientHandshake.C43161
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.network.tls.TLSClientHandshake$sendHandshakeRecord$1 r0 = (io.ktor.network.tls.TLSClientHandshake.C43161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.tls.TLSClientHandshake$sendHandshakeRecord$1 r0 = new io.ktor.network.tls.TLSClientHandshake$sendHandshakeRecord$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r10 = r0.L$4
            io.ktor.network.tls.TLSRecord r10 = (io.ktor.network.tls.TLSRecord) r10
            java.lang.Object r11 = r0.L$3
            fb.v r11 = (fb.v) r11
            java.lang.Object r11 = r0.L$2
            fb.v r11 = (fb.v) r11
            java.lang.Object r11 = r0.L$1
            p9.l r11 = (p9.InterfaceC5074l) r11
            java.lang.Object r11 = r0.L$0
            io.ktor.network.tls.TLSHandshakeType r11 = (io.ktor.network.tls.TLSHandshakeType) r11
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L3d
            goto L97
        L3d:
            r0 = move-exception
            r11 = r0
            goto L9d
        L40:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L48:
            kotlin.C4849c.b(r13)
            fb.a r13 = new fb.a
            r13.<init>()
            r12.invoke(r13)
            fb.a r7 = new fb.a
            r7.<init>()
            long r4 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r13)
            int r2 = (int) r4
            io.ktor.network.tls.RenderKt.writeTLSHandshakeType(r7, r11, r2)
            io.ktor.utils.io.core.BytePacketBuilderKt.writePacket(r7, r13)
            fb.s r2 = r10.digest
            io.ktor.network.tls.Digest.m166updateimpl(r2, r7)
            io.ktor.network.tls.TLSRecord r4 = new io.ktor.network.tls.TLSRecord
            io.ktor.network.tls.TLSRecordType r5 = io.ktor.network.tls.TLSRecordType.Handshake
            r8 = 2
            r9 = 0
            r6 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            Wa.s<io.ktor.network.tls.TLSRecord> r10 = r10.output     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L9a
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r11 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L9a
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r11 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L9a
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r11 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L9a
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L9a
            r0.L$4 = r4     // Catch: java.lang.Throwable -> L9a
            r0.label = r3     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r10 = r10.send(r4, r0)     // Catch: java.lang.Throwable -> L9a
            if (r10 != r1) goto L97
            return r1
        L97:
            Y8.t r10 = Y8.t.f7040a
            return r10
        L9a:
            r0 = move-exception
            r11 = r0
            r10 = r4
        L9d:
            fb.v r10 = r10.getPacket()
            r10.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.sendHandshakeRecord(io.ktor.network.tls.TLSHandshakeType, p9.l, e9.c):java.lang.Object");
    }

    private final void verifyHello(TLSServerHello serverHello) throws TLSException {
        CipherSuite cipherSuite = serverHello.getCipherSuite();
        if (!this.config.getCipherSuites().contains(cipherSuite)) {
            throw new IllegalStateException(("Unsupported cipher suite " + cipherSuite.getName() + " in SERVER_HELLO").toString());
        }
        List<HashAndSign> supportedSignatureAlgorithms = SignatureAlgorithmKt.getSupportedSignatureAlgorithms();
        ArrayList arrayList = new ArrayList();
        for (Object obj : supportedSignatureAlgorithms) {
            HashAndSign hashAndSign = (HashAndSign) obj;
            if (hashAndSign.getHash() == cipherSuite.getHash() && hashAndSign.getSign() == cipherSuite.getSignatureAlgorithm()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new TLSException("No appropriate hash algorithm for suite: " + cipherSuite, null, 2, null);
        }
        List<HashAndSign> hashAndSignAlgorithms = serverHello.getHashAndSignAlgorithms();
        if (hashAndSignAlgorithms.isEmpty()) {
            return;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (hashAndSignAlgorithms.contains((HashAndSign) it.next())) {
                    return;
                }
            }
        }
        throw new TLSException("No sign algorithms in common. \nServer candidates: " + hashAndSignAlgorithms + " \nClient candidates: " + arrayList, null, 2, null);
    }

    public final kotlinx.coroutines.g close() {
        r.o(this.input, null, 1, null);
        Wa.s.a(this.output, null, 1, null);
        return this.closeTask;
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    public final r<TLSRecord> getInput() {
        return this.input;
    }

    public final Wa.s<TLSRecord> getOutput() {
        return this.output;
    }

    public final boolean getUseCipher() {
        return this.useCipher;
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0072: MOVE (r10 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:30:0x0072 */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5 A[Catch: all -> 0x00cc, TryCatch #3 {all -> 0x00cc, blocks: (B:52:0x00ea, B:43:0x00bd, B:45:0x00c5, B:48:0x00d1, B:39:0x00a7, B:35:0x008d), top: B:68:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object negotiate(e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSClientHandshake.negotiate(e9.c):java.lang.Object");
    }

    public final void setUseCipher(boolean z10) {
        this.useCipher = z10;
    }

    public /* synthetic */ TLSClientHandshake(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, TLSConfig tLSConfig, kotlin.coroutines.d dVar, InterfaceC1089x interfaceC1089x, int i10, kotlin.jvm.internal.i iVar) {
        this(byteReadChannel, byteWriteChannel, tLSConfig, dVar, (i10 & 16) != 0 ? JobKt__JobKt.b(null, 1, null) : interfaceC1089x);
    }
}
