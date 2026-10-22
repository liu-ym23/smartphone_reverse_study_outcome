package u1;

import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import v9.C5685n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0005\u001a\u00020\u00102\b\b\u0001\u0010\u0006\u001a\u00020\u00102\b\b\u0001\u0010\u0007\u001a\u00020\u00102\b\b\u0001\u0010\b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\r2\b\b\u0001\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lu1/c;", "", "<init>", "()V", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, Const.INTENT_KEY_APIKEY, "(IIIILcoil/size/Scale;)I", "", "c", "(IIIILcoil/size/Scale;)D", "", Const.INTENT_KEY_UMID, "(FFFFLcoil/size/Scale;)F", Const.INTENT_KEY_PKGNAME, "(DDDDLcoil/size/Scale;)D", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f42403a = new c();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42404a;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f42404a = iArr;
        }
    }

    public static final int a(int srcWidth, int srcHeight, int dstWidth, int dstHeight, Scale scale) {
        int iMin;
        int iHighestOneBit = Integer.highestOneBit(srcWidth / dstWidth);
        int iHighestOneBit2 = Integer.highestOneBit(srcHeight / dstHeight);
        int i10 = a.f42404a[scale.ordinal()];
        if (i10 == 1) {
            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
        }
        return C5685n.f(iMin, 1);
    }

    public static final double b(double srcWidth, double srcHeight, double dstWidth, double dstHeight, Scale scale) {
        double d10 = dstWidth / srcWidth;
        double d11 = dstHeight / srcHeight;
        int i10 = a.f42404a[scale.ordinal()];
        if (i10 == 1) {
            return Math.max(d10, d11);
        }
        if (i10 == 2) {
            return Math.min(d10, d11);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double c(int srcWidth, int srcHeight, int dstWidth, int dstHeight, Scale scale) {
        double d10 = dstWidth / srcWidth;
        double d11 = dstHeight / srcHeight;
        int i10 = a.f42404a[scale.ordinal()];
        if (i10 == 1) {
            return Math.max(d10, d11);
        }
        if (i10 == 2) {
            return Math.min(d10, d11);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float d(float srcWidth, float srcHeight, float dstWidth, float dstHeight, Scale scale) {
        float f10 = dstWidth / srcWidth;
        float f11 = dstHeight / srcHeight;
        int i10 = a.f42404a[scale.ordinal()];
        if (i10 == 1) {
            return Math.max(f10, f11);
        }
        if (i10 == 2) {
            return Math.min(f10, f11);
        }
        throw new NoWhenBranchMatchedException();
    }
}
