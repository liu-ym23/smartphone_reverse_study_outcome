package androidx.core.content.res;

import androidx.camera.video.AudioStats;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes17.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public float getAStar() {
        return this.mAstar;
    }

    public float getBStar() {
        return this.mBstar;
    }

    public float getChroma() {
        return this.mChroma;
    }

    public float getHue() {
        return this.mHue;
    }

    public float getJ() {
        return this.mJ;
    }

    public float getJStar() {
        return this.mJstar;
    }

    public float getM() {
        return this.mM;
    }

    public float getQ() {
        return this.mQ;
    }

    public float getS() {
        return this.mS;
    }

    public static CamColor fromColor(int r110) {
        float[] r100 = new float[7];
        float[] r101 = new float[3];
        fromColorInViewingConditions(r110, ViewingConditions.DEFAULT, r100, r101);
        return new CamColor(r101[0], r101[1], r100[0], r100[1], r100[2], r100[3], r100[4], r100[5], r100[6]);
    }

    public float distance(CamColor r100) {
        float r101 = getJStar() - r100.getJStar();
        float r102 = getAStar() - r100.getAStar();
        float r103 = getBStar() - r100.getBStar();
        return (float) (Math.pow(Math.sqrt(((r101 * r101) + (r102 * r102)) + (r103 * r103)), 0.63d) * 1.41d);
    }

    public int viewed(ViewingConditions r110) {
        if (getChroma() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        float r100 = 0.0f;
    L9:
        float r101 = (float) Math.pow(((double) r100) / Math.pow(1.64d - Math.pow(0.29d, r110.getN()), 0.73d), 1.1111111111111112d);
        double r102 = (getHue() * 3.1415927f) / 180.0f;
        float r103 = ((float) (Math.cos(2.0d + r102) + 3.8d)) * 0.25f;
        float r104 = r110.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) r110.getC())) / ((double) r110.getZ())));
        float r105 = ((r103 * 3846.1538f) * r110.getNc()) * r110.getNcb();
        float r106 = r104 / r110.getNbb();
        float r107 = (float) Math.sin(r102);
        float r108 = (float) Math.cos(r102);
        float r109 = (((0.305f + r106) * 23.0f) * r101) / (((r105 * 23.0f) + ((11.0f * r101) * r108)) + ((r101 * 108.0f) * r107));
        float r111 = r108 * r109;
        float r112 = r109 * r107;
        float r113 = r106 * 460.0f;
        float r114 = (((451.0f * r111) + r113) + (288.0f * r112)) / 1403.0f;
        float r115 = ((r113 - (891.0f * r111)) - (261.0f * r112)) / 1403.0f;
        float r116 = ((r113 - (r111 * 220.0f)) - (r112 * 6300.0f)) / 1403.0f;
        float r117 = (Math.signum(r114) * (100.0f / r110.getFl())) * ((float) Math.pow((float) Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, (((double) Math.abs(r114)) * 27.13d) / (400.0d - ((double) Math.abs(r114)))), 2.380952380952381d));
        float r118 = (Math.signum(r115) * (100.0f / r110.getFl())) * ((float) Math.pow((float) Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, (((double) Math.abs(r115)) * 27.13d) / (400.0d - ((double) Math.abs(r115)))), 2.380952380952381d));
        float r119 = (Math.signum(r116) * (100.0f / r110.getFl())) * ((float) Math.pow((float) Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, (((double) Math.abs(r116)) * 27.13d) / (400.0d - ((double) Math.abs(r116)))), 2.380952380952381d));
        float r120 = r117 / r110.getRgbD()[0];
        float r121 = r118 / r110.getRgbD()[1];
        float r122 = r119 / r110.getRgbD()[2];
        float[][] r123 = CamUtils.CAM16RGB_TO_XYZ;
        float[] r124 = r123[0];
        float r125 = ((r124[0] * r120) + (r124[1] * r121)) + (r124[2] * r122);
        float[] r126 = r123[1];
        float r127 = ((r126[0] * r120) + (r126[1] * r121)) + (r126[2] * r122);
        float[] r128 = r123[2];
        return ColorUtils.XYZToColor(r125, r127, ((r120 * r128[0]) + (r121 * r128[1])) + (r122 * r128[2]));
    L5:
        if (getJ() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r100 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        goto L9
    }

    public static void getM3HCTfromColor(int r100, float[] r101) {
        fromColorInViewingConditions(r100, ViewingConditions.DEFAULT, null, r101);
        r101[2] = CamUtils.lStarFromInt(r100);
    }

    private static CamColor findCamByJ(float r110, float r111, float r112) {
        float r100 = 100.0f;
        float r101 = 1000.0f;
        CamColor r102 = null;
        float r103 = 1000.0f;
        float r104 = 0.0f;
    L4:
        if (Math.abs(r104 - r100) <= 0.01f) goto L19;
        float r105 = ((r100 - r104) / 2.0f) + r104;
        int r106 = fromJch(r105, r111, r110).viewedInSrgb();
        float r107 = CamUtils.lStarFromInt(r106);
        float r108 = Math.abs(r112 - r107);
        if (r108 >= 0.2f) goto L11;
        CamColor r109 = fromColor(r106);
        float r113 = r109.distance(fromJch(r109.getJ(), r109.getChroma(), r110));
        if (r113 > 1.0f) goto L11;
        r102 = r109;
        r101 = r108;
        r103 = r113;
    L11:
        if (r101 != 0.0f) goto L16;
        if (r103 == 0.0f) goto L19;
    L16:
        if (r107 < r112) goto L17;
        r100 = r105;
        goto L4
    L17:
        r104 = r105;
    L19:
        return r102;
    }

    private static CamColor fromJch(float r100, float r101, float r102) {
        return fromJchInFrame(r100, r101, r102, ViewingConditions.DEFAULT);
    }

    public static int toColor(float r100, float r101, float r102) {
        return toColor(r100, r101, r102, ViewingConditions.DEFAULT);
    }

    public static void fromColorInViewingConditions(int r110, ViewingConditions r210, float[] r211, float[] r212) {
        CamUtils.xyzFromInt(r110, r212);
        float[][] r100 = CamUtils.XYZ_TO_CAM16RGB;
        float r101 = r212[0];
        float[] r102 = r100[0];
        float r103 = r102[0] * r101;
        float r104 = r212[1];
        float r105 = r103 + (r102[1] * r104);
        float r106 = r212[2];
        float r107 = r105 + (r102[2] * r106);
        float[] r108 = r100[1];
        float r111 = ((r108[0] * r101) + (r108[1] * r104)) + (r108[2] * r106);
        float[] r109 = r100[2];
        float r112 = ((r101 * r109[0]) + (r104 * r109[1])) + (r106 * r109[2]);
        float r113 = r210.getRgbD()[0] * r107;
        float r114 = r210.getRgbD()[1] * r111;
        float r115 = r210.getRgbD()[2] * r112;
        float r116 = (float) Math.pow(((double) (r210.getFl() * Math.abs(r113))) / 100.0d, 0.42d);
        float r117 = (float) Math.pow(((double) (r210.getFl() * Math.abs(r114))) / 100.0d, 0.42d);
        float r118 = (float) Math.pow(((double) (r210.getFl() * Math.abs(r115))) / 100.0d, 0.42d);
        float r119 = ((Math.signum(r113) * 400.0f) * r116) / (r116 + 27.13f);
        float r120 = ((Math.signum(r114) * 400.0f) * r117) / (r117 + 27.13f);
        float r121 = ((Math.signum(r115) * 400.0f) * r118) / (r118 + 27.13f);
        double r122 = r121;
        float r123 = ((float) (((((double) r119) * 11.0d) + (((double) r120) * (-12.0d))) + r122)) / 11.0f;
        float r124 = ((float) (((double) (r119 + r120)) - (r122 * 2.0d))) / 9.0f;
        float r125 = r120 * 20.0f;
        float r126 = (((r119 * 20.0f) + r125) + (21.0f * r121)) / 20.0f;
        float r127 = (((r119 * 40.0f) + r125) + r121) / 20.0f;
        float r128 = (((float) Math.atan2(r124, r123)) * 180.0f) / 3.1415927f;
        if (r128 >= 0.0f) goto L6;
        r128 = r128 + 360.0f;
    L8:
        float r129 = (3.1415927f * r128) / 180.0f;
        float r130 = ((float) Math.pow((r127 * r210.getNbb()) / r210.getAw(), r210.getC() * r210.getZ())) * 100.0f;
        float r131 = (((4.0f / r210.getC()) * ((float) Math.sqrt(r130 / 100.0f))) * (r210.getAw() + 4.0f)) * r210.getFlRoot();
        if (r128 >= 20.14d) goto L11;
        float r132 = 360.0f + r128;
    L12:
        float r133 = ((float) Math.pow(1.64d - Math.pow(0.29d, r210.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) r132) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r210.getNc()) * r210.getNcb()) * ((float) Math.sqrt((r123 * r123) + (r124 * r124)))) / (r126 + 0.305f), 0.9d));
        float r134 = ((float) Math.sqrt(((double) r130) / 100.0d)) * r133;
        float r135 = r210.getFlRoot() * r134;
        float r136 = ((float) Math.sqrt((r133 * r210.getC()) / (r210.getAw() + 4.0f))) * 50.0f;
        float r137 = (1.7f * r130) / ((0.007f * r130) + 1.0f);
        float r138 = ((float) Math.log((0.0228f * r135) + 1.0f)) * 43.85965f;
        double r139 = r129;
        float r140 = ((float) Math.cos(r139)) * r138;
        float r141 = r138 * ((float) Math.sin(r139));
        r212[0] = r128;
        r212[1] = r134;
        if (r211 == null) goto L16;
        r211[0] = r130;
        r211[1] = r131;
        r211[2] = r135;
        r211[3] = r136;
        r211[4] = r137;
        r211[5] = r140;
        r211[6] = r141;
        return;
    L16:
        return;
    L11:
        r132 = r128;
        goto L12
    L6:
        if (r128 < 360.0f) goto L8;
        r128 = r128 - 360.0f;
        goto L8
    }

    private static CamColor fromJchInFrame(float r110, float r111, float r112, ViewingConditions r113) {
        double r100 = ((double) r110) / 100.0d;
        float r101 = (((4.0f / r113.getC()) * ((float) Math.sqrt(r100))) * (r113.getAw() + 4.0f)) * r113.getFlRoot();
        float r102 = r111 * r113.getFlRoot();
        float r103 = ((float) Math.sqrt(((r111 / ((float) Math.sqrt(r100))) * r113.getC()) / (r113.getAw() + 4.0f))) * 50.0f;
        float r104 = (1.7f * r110) / ((0.007f * r110) + 1.0f);
        float r105 = ((float) Math.log((((double) r102) * 0.0228d) + 1.0d)) * 43.85965f;
        double r106 = (3.1415927f * r112) / 180.0f;
        return new CamColor(r112, r111, r110, r101, r102, r103, r104, r105 * ((float) Math.cos(r106)), r105 * ((float) Math.sin(r106)));
    }

    public static int toColor(float r100, float r101, float r102, ViewingConditions r103) {
        if (r101 < 1.0d) goto L32;
        if (Math.round(r102) <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
        if (Math.round(r102) >= 100.0d) goto L32;
        if (r100 >= 0.0f) goto L12;
        float r104 = 0.0f;
    L13:
        float r105 = r101;
        CamColor r106 = null;
        float r107 = 0.0f;
        boolean r108 = true;
    L15:
        if (Math.abs(r107 - r101) < 0.4f) goto L26;
        CamColor r109 = findCamByJ(r104, r105, r102);
        if (r108 == true) goto L18;
        if (r109 != null) goto L24;
        r101 = r105;
    L25:
        r105 = ((r101 - r107) / 2.0f) + r107;
        goto L15
    L24:
        r107 = r105;
        r106 = r109;
        goto L25
    L18:
        if (r109 != null) goto L20;
        r105 = ((r101 - r107) / 2.0f) + r107;
        r108 = false;
        goto L15
    L20:
        return r109.viewed(r103);
    L26:
        if (r106 != null) goto L30;
        return CamUtils.intFromLStar(r102);
    L30:
        return r106.viewed(r103);
    L12:
        r104 = Math.min(360.0f, r100);
    L32:
        return CamUtils.intFromLStar(r102);
    }

    public CamColor(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108) {
        this.mHue = r100;
        this.mChroma = r101;
        this.mJ = r102;
        this.mQ = r103;
        this.mM = r104;
        this.mS = r105;
        this.mJstar = r106;
        this.mAstar = r107;
        this.mBstar = r108;
    }
}
