package v9;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "that", "Lv9/f;", Const.INTENT_KEY_PKGNAME, "(DD)Lv9/f;", "", "c", "(FF)Lv9/f;", "", "isPositive", "", "step", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ZLjava/lang/Number;)V", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* renamed from: v9.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5684m {
    public static final void a(boolean z10, Number step) {
        p.i(step, "step");
        if (z10) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    public static InterfaceC5677f<Double> b(double d10, double d11) {
        return new C5675d(d10, d11);
    }

    public static InterfaceC5677f<Float> c(float f10, float f11) {
        return new C5676e(f10, f11);
    }
}
