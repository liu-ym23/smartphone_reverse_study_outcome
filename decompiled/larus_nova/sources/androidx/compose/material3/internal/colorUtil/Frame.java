package androidx.compose.material3.internal.colorUtil;

import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0013\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBY\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Frame;", "", OfficeSDKRequestTag.KEY_NEW_USER, "", "aw", "nbb", "ncb", "c", "nc", "rgbD", "", "fl", "flRoot", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "<init>", "(FFFFFF[FFFF)V", "getN", "()F", "getAw", "getNbb", "getNcb", "getC", "getNc", "getRgbD", "()[F", "getFl", "getFlRoot", "getZ", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Frame {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Frame Default = null;

    /* JADX INFO: renamed from: aw, reason: collision with root package name */
    private final float f11501aw;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f11502c;

    /* JADX INFO: renamed from: fl, reason: collision with root package name */
    private final float f11503fl;
    private final float flRoot;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f11504n;

    /* JADX INFO: renamed from: nbb, reason: collision with root package name */
    private final float f11505nbb;

    /* JADX INFO: renamed from: nc, reason: collision with root package name */
    private final float f11506nc;

    /* JADX INFO: renamed from: ncb, reason: collision with root package name */
    private final float f11507ncb;
    private final float[] rgbD;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final float f11508z;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Frame$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/material3/internal/colorUtil/Frame;", "getDefault", "()Landroidx/compose/material3/internal/colorUtil/Frame;", "make", "whitepoint", "", "adaptingLuminance", "", "backgroundLstar", "surround", "discountingIlluminant", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Frame getDefault() {
            return Frame.access$getDefault$cp();
        }

        public final Frame make(float[] r210, float r211, float r212, float r213, boolean r214) {
            CamUtils r100 = CamUtils.INSTANCE;
            float[][] r101 = r100.getXYZ_TO_CAM16RGB();
            float r102 = r210[0];
            float[] r103 = r101[0];
            float r104 = r103[0] * r102;
            float r105 = r210[1];
            float r106 = r104 + (r103[1] * r105);
            float r110 = r210[2];
            float r107 = r106 + (r103[2] * r110);
            float[] r108 = r101[1];
            float r111 = ((r108[0] * r102) + (r108[1] * r105)) + (r108[2] * r110);
            float[] r109 = r101[2];
            float r112 = ((r102 * r109[0]) + (r105 * r109[1])) + (r110 * r109[2]);
            float r113 = (r213 / 10.0f) + 0.8f;
            if (r113 < 0.9d) goto L5;
            float r114 = Frame_androidKt.access$lerp(0.59f, 0.69f, (r113 - 0.9f) * 10.0f);
        L6:
            float r115 = r114;
            if (r214 == false) goto L9;
            float r116 = 1.0f;
        L10:
            double r117 = r116;
            if (r117 <= 1.0d) goto L14;
            r116 = 1.0f;
        L16:
            float[] r118 = {(((100.0f / r107) * r116) + 1.0f) - r116, (((100.0f / r111) * r116) + 1.0f) - r116, (((100.0f / r112) * r116) + 1.0f) - r116};
            float r119 = 1.0f / ((5.0f * r211) + 1.0f);
            float r120 = ((r119 * r119) * r119) * r119;
            float r121 = 1.0f - r120;
            float r122 = (r120 * r211) + (((0.1f * r121) * r121) * ((float) Math.cbrt(((double) r211) * 5.0d)));
            float r123 = ((float) r100.yFromLstar(r212)) / r210[1];
            double r124 = r123;
            float r215 = ((float) Math.sqrt(r124)) + 1.48f;
            float r125 = 0.725f / ((float) Math.pow(r124, 0.2f));
            double r126 = 0.42f;
            float r127 = (float) Math.pow(((r118[2] * r122) * r112) / 100.0f, r126);
            float[] r128 = {(float) Math.pow(((r118[0] * r122) * r107) / 100.0f, r126), (float) Math.pow(((r118[1] * r122) * r111) / 100.0f, r126), r127};
            float r129 = r128[0];
            float r130 = r128[1];
            return new Frame(r123, (((((r129 * 400.0f) / (r129 + 27.13f)) * 2.0f) + ((r130 * 400.0f) / (r130 + 27.13f))) + (((400.0f * r127) / (r127 + 27.13f)) * 0.05f)) * r125, r125, r125, r115, r113, r118, r122, (float) Math.pow(r122, 0.25f), r215, null);
        L14:
            if (r117 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
            r116 = 0.0f;
            goto L16
        L9:
            r116 = (1.0f - (((float) Math.exp(((-r211) - 42.0f) / 92.0f)) * 0.2777778f)) * r113;
            goto L10
        L5:
            r114 = Frame_androidKt.access$lerp(0.525f, 0.59f, (r113 - 0.8f) * 10.0f);
            goto L6
        }
    }

    public /* synthetic */ Frame(float r100, float r101, float r102, float r103, float r104, float r105, float[] r106, float r107, float r108, float r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }

    static {
        Companion r100 = new Companion(null);
        Companion = r100;
        $stable = 8;
        CamUtils r101 = CamUtils.INSTANCE;
        Default = r100.make(r101.getWHITE_POINT_D65(), (float) ((r101.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    public static final /* synthetic */ Frame access$getDefault$cp() {
        return Default;
    }

    public final float getAw() {
        return this.f11501aw;
    }

    public final float getC() {
        return this.f11502c;
    }

    public final float getFl() {
        return this.f11503fl;
    }

    public final float getFlRoot() {
        return this.flRoot;
    }

    public final float getN() {
        return this.f11504n;
    }

    public final float getNbb() {
        return this.f11505nbb;
    }

    public final float getNc() {
        return this.f11506nc;
    }

    public final float getNcb() {
        return this.f11507ncb;
    }

    public final float[] getRgbD() {
        return this.rgbD;
    }

    public final float getZ() {
        return this.f11508z;
    }

    private Frame(float r100, float r101, float r102, float r103, float r104, float r105, float[] r106, float r107, float r108, float r110) {
        this.f11504n = r100;
        this.f11501aw = r101;
        this.f11505nbb = r102;
        this.f11507ncb = r103;
        this.f11502c = r104;
        this.f11506nc = r105;
        this.rgbD = r106;
        this.f11503fl = r107;
        this.flRoot = r108;
        this.f11508z = r110;
    }
}
