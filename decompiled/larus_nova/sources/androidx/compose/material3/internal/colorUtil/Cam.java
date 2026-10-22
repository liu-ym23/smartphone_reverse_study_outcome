package androidx.compose.material3.internal.colorUtil;

import androidx.camera.video.AudioStats;
import androidx.core.graphics.ColorUtils;
import com.amap.api.col.s.ce;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006 "}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Cam;", "", "hue", "", "chroma", ce.f26395j, "m", "s", "jstar", "astar", "bstar", "<init>", "(FFFFFFFF)V", "getHue", "()F", "getChroma", "getJ", "getM", "getS", "getJstar", "setJstar", "(F)V", "getAstar", "getBstar", "distance", "other", "viewedInSrgb", "", "viewed", "frame", "Landroidx/compose/material3/internal/colorUtil/Frame;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Cam {
    public static final int $stable = 0;
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    public static final Companion Companion = null;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f11498j;
    private float jstar;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f11499m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final float f11500s;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J(\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Cam$Companion;", "", "<init>", "()V", "DL_MAX", "", "DE_MAX", "CHROMA_SEARCH_ENDPOINT", "LIGHTNESS_SEARCH_ENDPOINT", "getInt", "", "hue", "chroma", "lstar", "fromInt", "Landroidx/compose/material3/internal/colorUtil/Cam;", "argb", "fromIntInFrame", "frame", "Landroidx/compose/material3/internal/colorUtil/Frame;", "fromJch", ce.f26395j, "c", "h", "fromJchInFrame", "findCamByJ", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Cam fromInt(int r100) {
            return fromIntInFrame(r100, Frame.Companion.getDefault());
        }

        private final Cam fromIntInFrame(int r110, Frame r210) {
            CamUtils r100 = CamUtils.INSTANCE;
            float[] r101 = r100.xyzFromInt(r110);
            float[][] r102 = r100.getXYZ_TO_CAM16RGB();
            float r103 = r101[0];
            float[] r104 = r102[0];
            float r105 = r104[0] * r103;
            float r106 = r101[1];
            float r107 = r105 + (r104[1] * r106);
            float r108 = r101[2];
            float r109 = r107 + (r104[2] * r108);
            float[] r111 = r102[1];
            float r112 = ((r111[0] * r103) + (r111[1] * r106)) + (r111[2] * r108);
            float[] r113 = r102[2];
            float r114 = ((r103 * r113[0]) + (r106 * r113[1])) + (r108 * r113[2]);
            float r115 = r210.getRgbD()[0] * r109;
            float r116 = r210.getRgbD()[1] * r112;
            float r117 = r210.getRgbD()[2] * r114;
            double r118 = 0.42f;
            float r119 = (float) Math.pow((r210.getFl() * Math.abs(r115)) / 100.0f, r118);
            float r120 = (float) Math.pow((r210.getFl() * Math.abs(r116)) / 100.0f, r118);
            float r121 = (float) Math.pow((r210.getFl() * Math.abs(r117)) / 100.0f, r118);
            float r122 = ((Math.signum(r115) * 400.0f) * r119) / (r119 + 27.13f);
            float r123 = ((Math.signum(r116) * 400.0f) * r120) / (r120 + 27.13f);
            float r124 = ((Math.signum(r117) * 400.0f) * r121) / (r121 + 27.13f);
            float r125 = (((r122 * 11.0f) + ((-12.0f) * r123)) + r124) / 11.0f;
            float r126 = ((r122 + r123) - (r124 * 2.0f)) / 9.0f;
            float r127 = r123 * 20.0f;
            float r128 = (((r122 * 20.0f) + r127) + (21.0f * r124)) / 20.0f;
            float r129 = (((r122 * 40.0f) + r127) + r124) / 20.0f;
            float r130 = (((float) Math.atan2(r126, r125)) * 180.0f) / 3.1415927f;
            if (r130 >= 0.0f) goto L7;
            r130 = r130 + 360.0f;
        L5:
            float r131 = r130;
            float r132 = (r131 * 3.1415927f) / 180.0f;
            float r133 = ((float) Math.pow((r129 * r210.getNbb()) / r210.getAw(), r210.getC() * r210.getZ())) * 100.0f;
            if (r131 >= 20.14d) goto L12;
            float r134 = 360 + r131;
        L13:
            float r135 = ((float) Math.pow(((((((((float) Math.cos(((r134 * 3.1415927f) / 180.0f) + 2.0f)) + 3.8f) * 0.25f) * 3846.1538f) * r210.getNc()) * r210.getNcb()) * ((float) Math.sqrt((r125 * r125) + (r126 * r126)))) / (r128 + 0.305f), 0.9f)) * ((float) Math.pow(1.64f - ((float) Math.pow(0.29f, r210.getN())), 0.73f));
            float r136 = r135 * ((float) Math.sqrt(r133 / 100.0f));
            float r137 = r136 * r210.getFlRoot();
            float r138 = ((float) Math.sqrt((r135 * r210.getC()) / (r210.getAw() + 4.0f))) * 50.0f;
            float r139 = (1.7f * r133) / ((0.007f * r133) + 1.0f);
            float r140 = ((float) Math.log((0.0228f * r137) + 1.0f)) * 43.85965f;
            double r141 = r132;
            return new Cam(r131, r136, r133, r137, r138, r139, r140 * ((float) Math.cos(r141)), r140 * ((float) Math.sin(r141)));
        L12:
            r134 = r131;
            goto L13
        L7:
            if (r130 < 360.0f) goto L5;
            r130 = r130 - 360.0f;
            goto L5
        }

        private final Cam findCamByJ(float r110, float r111, float r112) {
            float r100 = 100.0f;
            float r101 = 1000.0f;
            Cam r102 = null;
            float r103 = 1000.0f;
            float r104 = 0.0f;
        L4:
            if (Math.abs(r104 - r100) <= 0.009999999776482582d) goto L25;
            float r105 = ((r100 - r104) / 2) + r104;
            int r106 = fromJch(r105, r111, r110).viewedInSrgb();
            float r107 = CamUtils.INSTANCE.lstarFromInt(r106);
            float r108 = (float) Math.abs(r112 - r107);
            if (r108 >= 0.2f) goto L10;
            Cam r109 = fromInt(r106);
            float r113 = r109.distance(fromJch(r109.getJ(), r109.getChroma(), r110));
            if (r113 > 1.0f) goto L10;
            r102 = r109;
            r101 = r108;
            r103 = r113;
        L10:
            boolean r114 = true;
            if (r101 != 0.0f) goto L13;
            boolean r115 = true;
        L14:
            if (r115 == false) goto L22;
            if (r103 == 0.0f) goto L19;
            r114 = false;
        L19:
            if (r114 == true) goto L25;
        L22:
            if (r107 < r112) goto L23;
            r100 = r105;
            goto L4
        L23:
            r104 = r105;
            goto L4
        L13:
            r115 = false;
        L25:
            return r102;
        }

        private final Cam fromJch(float r100, float r101, float r102) {
            return fromJchInFrame(r100, r101, r102, Frame.Companion.getDefault());
        }

        public final int getInt(float r100, float r101, float r102) {
            return getInt(r100, r101, r102, Frame.Companion.getDefault());
        }

        private final Cam fromJchInFrame(float r110, float r111, float r112, Frame r113) {
            float r100 = r111 * r113.getFlRoot();
            float r101 = ((float) Math.sqrt(((r111 / ((float) Math.sqrt(((double) r110) / 100.0d))) * r113.getC()) / (r113.getAw() + 4.0f))) * 50.0f;
            float r102 = (1.7f * r110) / ((0.007f * r110) + 1.0f);
            float r103 = ((float) Math.log((((double) r100) * 0.0228d) + 1.0d)) * 43.85965f;
            double r104 = (3.1415927f * r112) / 180.0f;
            return new Cam(r112, r111, r110, r100, r101, r102, r103 * ((float) Math.cos(r104)), r103 * ((float) Math.sin(r104)));
        }

        private final int getInt(float r110, float r111, float r112, Frame r113) {
            if (Intrinsics.areEqual(r113, Frame.Companion.getDefault()) == false) goto L7;
            return HctSolver.INSTANCE.solveToInt(r110, r111, r112);
        L7:
            if (r111 < 1.0d) goto L36;
            if (Math.round(r112) <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
            if (Math.round(r112) >= 100.0d) goto L36;
            if (r110 >= 0.0f) goto L16;
            float r114 = 0.0f;
        L17:
            float r100 = r111;
            Cam r101 = null;
            float r102 = 0.0f;
            boolean r103 = true;
        L19:
            if (Math.abs(r102 - r111) < 0.4000000059604645d) goto L30;
            Cam r104 = findCamByJ(r114, r100, r112);
            if (r103 == true) goto L22;
            if (r104 != null) goto L28;
            r111 = r100;
        L29:
            r100 = ((r111 - r102) / 2.0f) + r102;
            goto L19
        L28:
            r102 = r100;
            r101 = r104;
            goto L29
        L22:
            if (r104 != null) goto L24;
            r100 = ((r111 - r102) / 2.0f) + r102;
            r103 = false;
            goto L19
        L24:
            return r104.viewed(r113);
        L30:
            if (r101 != null) goto L34;
            return CamUtils.INSTANCE.intFromLstar(r112);
        L34:
            return r101.viewed(r113);
        L16:
            r114 = Math.min(360.0f, r110);
        L36:
            return CamUtils.INSTANCE.intFromLstar(r112);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public final int viewedInSrgb() {
        return viewed(Frame.Companion.getDefault());
    }

    public final float getAstar() {
        return this.astar;
    }

    public final float getBstar() {
        return this.bstar;
    }

    public final float getChroma() {
        return this.chroma;
    }

    public final float getHue() {
        return this.hue;
    }

    public final float getJ() {
        return this.f11498j;
    }

    public final float getJstar() {
        return this.jstar;
    }

    public final float getM() {
        return this.f11499m;
    }

    public final float getS() {
        return this.f11500s;
    }

    public final float distance(Cam r100) {
        float r101 = this.jstar - r100.jstar;
        float r102 = this.astar - r100.astar;
        float r103 = this.bstar - r100.bstar;
        return (float) (Math.pow(Math.sqrt(((r101 * r101) + (r102 * r102)) + (r103 * r103)), 0.63d) * 1.41d);
    }

    public final void setJstar(float r100) {
        this.jstar = r100;
    }

    public final int viewed(Frame r110) {
        float r100 = this.chroma;
        if (r100 != 0.0f) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L15;
        float r102 = this.f11498j;
        if (r102 != 0.0f) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        float r104 = r100 / ((float) Math.sqrt(r102 / 100.0f));
    L16:
        float r105 = r104 / ((float) Math.pow(1.64f - ((float) Math.pow((float) Math.pow(0.29f, r110.getN()), 0.73f)), 1.1111112f));
        float r106 = (this.hue * 3.1415927f) / 180.0f;
        float r107 = (((float) Math.cos(2.0f + r106)) + 3.8f) * 0.25f;
        float r108 = r110.getAw() * ((float) Math.pow(this.f11498j / 100.0f, (1.0f / r110.getC()) / r110.getZ()));
        float r109 = ((r107 * 3846.1538f) * r110.getNc()) * r110.getNcb();
        float r111 = r108 / r110.getNbb();
        double r112 = r106;
        float r113 = (float) Math.sin(r112);
        float r114 = (float) Math.cos(r112);
        float r115 = (((0.305f + r111) * 23.0f) * r105) / (((r109 * 23.0f) + ((11.0f * r105) * r114)) + ((r105 * 108.0f) * r113));
        float r116 = r114 * r115;
        float r117 = r115 * r113;
        float r118 = r111 * 460.0f;
        float r119 = (((451.0f * r116) + r118) + (288.0f * r117)) / 1403.0f;
        float r120 = ((r118 - (891.0f * r116)) - (261.0f * r117)) / 1403.0f;
        float r121 = ((r118 - (r116 * 220.0f)) - (r117 * 6300.0f)) / 1403.0f;
        double r122 = 2.3809524f;
        float r123 = (Math.signum(r119) * (100.0f / r110.getFl())) * ((float) Math.pow(Math.max(0.0f, (Math.abs(r119) * 27.13f) / (400.0f - Math.abs(r119))), r122));
        float r124 = (Math.signum(r120) * (100.0f / r110.getFl())) * ((float) Math.pow(Math.max(0.0f, (Math.abs(r120) * 27.13f) / (400.0f - Math.abs(r120))), r122));
        float r125 = (Math.signum(r121) * (100.0f / r110.getFl())) * ((float) Math.pow(Math.max(0.0f, (Math.abs(r121) * 27.13f) / (400.0f - Math.abs(r121))), r122));
        float r126 = r123 / r110.getRgbD()[0];
        float r127 = r124 / r110.getRgbD()[1];
        float r128 = r125 / r110.getRgbD()[2];
        float[][] r129 = CamUtils.INSTANCE.getCAM16RGB_TO_XYZ();
        float[] r130 = r129[0];
        float r131 = ((r130[0] * r126) + (r130[1] * r127)) + (r130[2] * r128);
        float[] r132 = r129[1];
        float r133 = ((r132[0] * r126) + (r132[1] * r127)) + (r132[2] * r128);
        float[] r134 = r129[2];
        return ColorUtils.XYZToColor(r131, r133, ((r126 * r134[0]) + (r127 * r134[1])) + (r128 * r134[2]));
    L11:
        r103 = false;
    L15:
        r104 = 0.0f;
        goto L16
    L5:
        r101 = false;
        goto L7
    }

    public Cam(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107) {
        this.hue = r100;
        this.chroma = r101;
        this.f11498j = r102;
        this.f11499m = r103;
        this.f11500s = r104;
        this.jstar = r105;
        this.astar = r106;
        this.bstar = r107;
    }
}
