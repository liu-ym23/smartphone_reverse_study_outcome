package com.stepos.core.ota.crypto;

import java.util.Iterator;
import kotlin.jvm.internal.e;
import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CryptoAlgorithm {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ CryptoAlgorithm[] $VALUES;
    public static final Companion Companion;

    /* renamed from: id, reason: collision with root package name */
    private final int f7538id;
    public static final CryptoAlgorithm AES_256_GCM = new CryptoAlgorithm("AES_256_GCM", 0, 1);
    public static final CryptoAlgorithm CHACHA20_POLY1305 = new CryptoAlgorithm("CHACHA20_POLY1305", 1, 2);
    public static final CryptoAlgorithm SM4_GCM = new CryptoAlgorithm("SM4_GCM", 2, 3);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final CryptoAlgorithm fromId(int i10) {
            CryptoAlgorithm next;
            Iterator<CryptoAlgorithm> it = CryptoAlgorithm.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getId() == i10) {
                    break;
                }
            }
            return next;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ CryptoAlgorithm[] $values() {
        return new CryptoAlgorithm[]{AES_256_GCM, CHACHA20_POLY1305, SM4_GCM};
    }

    static {
        CryptoAlgorithm[] cryptoAlgorithmArr$values = $values();
        $VALUES = cryptoAlgorithmArr$values;
        $ENTRIES = kotlin.enums.a.a(cryptoAlgorithmArr$values);
        Companion = new Companion(null);
    }

    private CryptoAlgorithm(String str, int i10, int i11) {
        this.f7538id = i11;
    }

    public static a<CryptoAlgorithm> getEntries() {
        return $ENTRIES;
    }

    public static CryptoAlgorithm valueOf(String str) {
        return (CryptoAlgorithm) Enum.valueOf(CryptoAlgorithm.class, str);
    }

    public static CryptoAlgorithm[] values() {
        return (CryptoAlgorithm[]) $VALUES.clone();
    }

    public final int getId() {
        return this.f7538id;
    }
}
