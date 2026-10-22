package io.ktor.network.tls.cipher;

import io.ktor.network.tls.CipherSuite;
import io.ktor.network.tls.CipherType;
import io.ktor.network.tls.TLSRecord;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lio/ktor/network/tls/cipher/TLSCipher;", "", "Lio/ktor/network/tls/TLSRecord;", "record", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30736c, "(Lio/ktor/network/tls/TLSRecord;)Lio/ktor/network/tls/TLSRecord;", "decrypt", "Companion", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface TLSCipher {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/network/tls/cipher/TLSCipher$Companion;", "", "<init>", "()V", "Lio/ktor/network/tls/CipherSuite;", "suite", "", "keyMaterial", "Lio/ktor/network/tls/cipher/TLSCipher;", "fromSuite", "(Lio/ktor/network/tls/CipherSuite;[B)Lio/ktor/network/tls/cipher/TLSCipher;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CipherType.values().length];
                try {
                    iArr[CipherType.GCM.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CipherType.CBC.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public final TLSCipher fromSuite(CipherSuite suite, byte[] keyMaterial) {
            p.i(suite, "suite");
            p.i(keyMaterial, "keyMaterial");
            int i10 = WhenMappings.$EnumSwitchMapping$0[suite.getCipherType().ordinal()];
            if (i10 == 1) {
                return new GCMCipher(suite, keyMaterial);
            }
            if (i10 == 2) {
                return new CBCCipher(suite, keyMaterial);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    TLSRecord decrypt(TLSRecord record);

    TLSRecord encrypt(TLSRecord record);
}
