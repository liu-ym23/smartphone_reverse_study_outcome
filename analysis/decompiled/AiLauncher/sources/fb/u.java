package fb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000b¨\u0006\r"}, d2 = {"Lfb/s;", "", "float", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lfb/s;F)V", "", "double", Const.INTENT_KEY_APIKEY, "(Lfb/s;D)V", "", "[B", "HEX_DIGIT_BYTES", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f32634a;

    static {
        byte[] bArr = new byte[16];
        int i10 = 0;
        while (i10 < 16) {
            bArr[i10] = (byte) ((i10 < 10 ? 48 : 87) + i10);
            i10++;
        }
        f32634a = bArr;
    }

    public static final void a(s sVar, double d10) {
        kotlin.jvm.internal.p.i(sVar, "<this>");
        sVar.writeLong(Double.doubleToLongBits(d10));
    }

    public static final void b(s sVar, float f10) {
        kotlin.jvm.internal.p.i(sVar, "<this>");
        sVar.writeInt(Float.floatToIntBits(f10));
    }
}
