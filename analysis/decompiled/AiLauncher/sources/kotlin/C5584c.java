package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.EasingType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lu7/c;", "", "<init>", "()V", "Lcom/stepos/motionkit/EasingType;", "type", "", "t", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/motionkit/EasingType;F)F", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: u7.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5584c {

    /* renamed from: a, reason: collision with root package name */
    public static final C5584c f42443a = new C5584c();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: u7.c$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42444a;

        static {
            int[] iArr = new int[EasingType.values().length];
            try {
                iArr[EasingType.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EasingType.EASE_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EasingType.EASE_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EasingType.EASE_IN_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EasingType.SPRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f42444a = iArr;
        }
    }

    public final float a(EasingType type, float t10) {
        p.i(type, "type");
        int i10 = a.f42444a[type.ordinal()];
        if (i10 == 1) {
            return t10;
        }
        if (i10 == 2) {
            return t10 * t10;
        }
        if (i10 == 3) {
            float f10 = 1.0f - t10;
            return 1.0f - (f10 * f10);
        }
        if (i10 == 4) {
            if (t10 < 0.5f) {
                return 2.0f * t10 * t10;
            }
            float f11 = (t10 * (-2.0f)) + 2.0f;
            return 1.0f - ((f11 * f11) / 2.0f);
        }
        if (i10 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (t10 <= 0.0f) {
            return 0.0f;
        }
        if (t10 >= 1.0f) {
            return 1.0f;
        }
        return (((float) Math.pow(2.0d, t10 * (-10.0d))) * ((float) Math.sin(((t10 * 10.0f) - 0.75f) * 2.0943952f))) + 1.0f;
    }
}
