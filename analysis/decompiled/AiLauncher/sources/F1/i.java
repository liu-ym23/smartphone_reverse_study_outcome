package F1;

import B1.c;
import Mb.InterfaceC0968f;
import android.graphics.Bitmap;
import coil.size.Scale;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okio.ByteString;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0014\u001a\u00020\u0011*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"LMb/f;", "Lokio/ByteString;", SingleFileBundle.KEY_BYTES, "", "fromIndex", "toIndex", Const.INTENT_KEY_APIKEY, "(LMb/f;Lokio/ByteString;JJ)J", "Landroid/graphics/Bitmap$Config;", Const.INTENT_KEY_UMID, "(Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap$Config;", "LB1/c;", "Lcoil/size/Scale;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "", "c", "(LB1/c;Lcoil/size/Scale;)F", "", Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/Bitmap$Config;)Z", "isHardware", "coil-svg_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2548a;

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
            f2548a = iArr;
        }
    }

    public static final long a(InterfaceC0968f interfaceC0968f, ByteString byteString, long j10, long j11) throws IOException {
        if (byteString.K() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        byte bL = byteString.l(0);
        long jK = j11 - byteString.K();
        long j12 = j10;
        while (j12 < jK) {
            InterfaceC0968f interfaceC0968f2 = interfaceC0968f;
            long jE = interfaceC0968f2.E(bL, j12, jK);
            if (jE == -1 || interfaceC0968f2.P(jE, byteString)) {
                return jE;
            }
            j12 = jE + 1;
            interfaceC0968f = interfaceC0968f2;
        }
        return -1L;
    }

    public static final boolean b(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }

    public static final float c(B1.c cVar, Scale scale) {
        if (cVar instanceof c.a) {
            return ((c.a) cVar).px;
        }
        int i10 = a.f2548a[scale.ordinal()];
        if (i10 == 1) {
            return Float.MIN_VALUE;
        }
        if (i10 == 2) {
            return Float.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Bitmap.Config d(Bitmap.Config config) {
        return (config == null || b(config)) ? Bitmap.Config.ARGB_8888 : config;
    }
}
