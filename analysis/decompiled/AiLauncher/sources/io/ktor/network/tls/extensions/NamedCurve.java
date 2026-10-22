package io.ktor.network.tls.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.wake.circle.F;
import h9.InterfaceC4149a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006("}, d2 = {"Lio/ktor/network/tls/extensions/NamedCurve;", "", "", "code", "", "fieldSize", "<init>", "(Ljava/lang/String;ISI)V", ExifInterface.LATITUDE_SOUTH, "getCode", "()S", "I", "getFieldSize", "()I", "Companion", "sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NamedCurve {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ NamedCurve[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final short code;
    private final int fieldSize;
    public static final NamedCurve sect163k1 = new NamedCurve("sect163k1", 0, 1, 163);
    public static final NamedCurve sect163r1 = new NamedCurve("sect163r1", 1, 2, 163);
    public static final NamedCurve sect163r2 = new NamedCurve("sect163r2", 2, 3, 163);
    public static final NamedCurve sect193r1 = new NamedCurve("sect193r1", 3, 4, 193);
    public static final NamedCurve sect193r2 = new NamedCurve("sect193r2", 4, 5, 193);
    public static final NamedCurve sect233k1 = new NamedCurve("sect233k1", 5, 6, 233);
    public static final NamedCurve sect233r1 = new NamedCurve("sect233r1", 6, 7, 233);
    public static final NamedCurve sect239k1 = new NamedCurve("sect239k1", 7, 8, 239);
    public static final NamedCurve sect283k1 = new NamedCurve("sect283k1", 8, 9, 283);
    public static final NamedCurve sect283r1 = new NamedCurve("sect283r1", 9, 10, 283);
    public static final NamedCurve sect409k1 = new NamedCurve("sect409k1", 10, 11, 409);
    public static final NamedCurve sect409r1 = new NamedCurve("sect409r1", 11, 12, 409);
    public static final NamedCurve sect571k1 = new NamedCurve("sect571k1", 12, 13, 571);
    public static final NamedCurve sect571r1 = new NamedCurve("sect571r1", 13, 14, 571);
    public static final NamedCurve secp160k1 = new NamedCurve("secp160k1", 14, 15, F.LOOP_END_FRAME);
    public static final NamedCurve secp160r1 = new NamedCurve("secp160r1", 15, 16, F.LOOP_END_FRAME);
    public static final NamedCurve secp160r2 = new NamedCurve("secp160r2", 16, 17, F.LOOP_END_FRAME);
    public static final NamedCurve secp192k1 = new NamedCurve("secp192k1", 17, 18, 192);
    public static final NamedCurve secp192r1 = new NamedCurve("secp192r1", 18, 19, 192);
    public static final NamedCurve secp224k1 = new NamedCurve("secp224k1", 19, 20, 224);
    public static final NamedCurve secp224r1 = new NamedCurve("secp224r1", 20, 21, 224);
    public static final NamedCurve secp256k1 = new NamedCurve("secp256k1", 21, 22, 256);
    public static final NamedCurve secp256r1 = new NamedCurve("secp256r1", 22, 23, 256);
    public static final NamedCurve secp384r1 = new NamedCurve("secp384r1", 23, 24, b.BLOCK_CHARS);
    public static final NamedCurve secp521r1 = new NamedCurve("secp521r1", 24, 25, 521);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/network/tls/extensions/NamedCurve$Companion;", "", "<init>", "()V", "", "code", "Lio/ktor/network/tls/extensions/NamedCurve;", "fromCode", "(S)Lio/ktor/network/tls/extensions/NamedCurve;", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final NamedCurve fromCode(short code) {
            NamedCurve next;
            Iterator<NamedCurve> it = NamedCurve.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getCode() == code) {
                    break;
                }
            }
            return next;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ NamedCurve[] $values() {
        return new NamedCurve[]{sect163k1, sect163r1, sect163r2, sect193r1, sect193r2, sect233k1, sect233r1, sect239k1, sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, secp160k1, secp160r1, secp160r2, secp192k1, secp192r1, secp224k1, secp224r1, secp256k1, secp256r1, secp384r1, secp521r1};
    }

    static {
        NamedCurve[] namedCurveArr$values = $values();
        $VALUES = namedCurveArr$values;
        $ENTRIES = a.a(namedCurveArr$values);
        INSTANCE = new Companion(null);
    }

    private NamedCurve(String str, int i10, short s10, int i11) {
        this.code = s10;
        this.fieldSize = i11;
    }

    public static InterfaceC4149a<NamedCurve> getEntries() {
        return $ENTRIES;
    }

    public static NamedCurve valueOf(String str) {
        return (NamedCurve) Enum.valueOf(NamedCurve.class, str);
    }

    public static NamedCurve[] values() {
        return (NamedCurve[]) $VALUES.clone();
    }

    public final short getCode() {
        return this.code;
    }

    public final int getFieldSize() {
        return this.fieldSize;
    }
}
