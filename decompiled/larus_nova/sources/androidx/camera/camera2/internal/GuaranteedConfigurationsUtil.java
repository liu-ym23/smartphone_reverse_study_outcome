package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GuaranteedConfigurationsUtil {
    public static List<SurfaceCombination> get10BitSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r101);
        SurfaceCombination r104 = new SurfaceCombination();
        SurfaceConfig.ConfigType r105 = SurfaceConfig.ConfigType.YUV;
        r104.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r104);
        SurfaceCombination r106 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r107 = SurfaceConfig.ConfigSize.PREVIEW;
        r106.addSurfaceConfig(SurfaceConfig.create(r102, r107));
        SurfaceConfig.ConfigType r108 = SurfaceConfig.ConfigType.JPEG;
        r106.addSurfaceConfig(SurfaceConfig.create(r108, r103));
        r100.add(r106);
        SurfaceCombination r109 = new SurfaceCombination();
        r109.addSurfaceConfig(SurfaceConfig.create(r102, r107));
        r109.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r109);
        SurfaceCombination r110 = new SurfaceCombination();
        r110.addSurfaceConfig(SurfaceConfig.create(r105, r107));
        r110.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r110);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r107));
        SurfaceConfig.ConfigSize r112 = SurfaceConfig.ConfigSize.RECORD;
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r112));
        r100.add(r111);
        SurfaceCombination r113 = new SurfaceCombination();
        r113.addSurfaceConfig(SurfaceConfig.create(r102, r107));
        r113.addSurfaceConfig(SurfaceConfig.create(r102, r112));
        r113.addSurfaceConfig(SurfaceConfig.create(r105, r112));
        r100.add(r113);
        SurfaceCombination r114 = new SurfaceCombination();
        r114.addSurfaceConfig(SurfaceConfig.create(r102, r107));
        r114.addSurfaceConfig(SurfaceConfig.create(r102, r112));
        r114.addSurfaceConfig(SurfaceConfig.create(r108, r112));
        r100.add(r114);
        return r100;
    }

    public static List<SurfaceCombination> getBurstSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.PREVIEW;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigSize r104 = SurfaceConfig.ConfigSize.MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r104));
        r100.add(r101);
        SurfaceCombination r105 = new SurfaceCombination();
        r105.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigType r106 = SurfaceConfig.ConfigType.YUV;
        r105.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r105);
        SurfaceCombination r107 = new SurfaceCombination();
        r107.addSurfaceConfig(SurfaceConfig.create(r106, r103));
        r107.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r107);
        return r100;
    }

    public static List<SurfaceCombination> getConcurrentSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.s1440p;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r101);
        SurfaceCombination r104 = new SurfaceCombination();
        SurfaceConfig.ConfigType r105 = SurfaceConfig.ConfigType.PRIV;
        r104.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r104);
        SurfaceCombination r106 = new SurfaceCombination();
        SurfaceConfig.ConfigType r107 = SurfaceConfig.ConfigType.JPEG;
        r106.addSurfaceConfig(SurfaceConfig.create(r107, r103));
        r100.add(r106);
        SurfaceCombination r108 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r109 = SurfaceConfig.ConfigSize.s720p;
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r108.addSurfaceConfig(SurfaceConfig.create(r107, r103));
        r100.add(r108);
        SurfaceCombination r110 = new SurfaceCombination();
        r110.addSurfaceConfig(SurfaceConfig.create(r105, r109));
        r110.addSurfaceConfig(SurfaceConfig.create(r107, r103));
        r100.add(r110);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r111);
        SurfaceCombination r112 = new SurfaceCombination();
        r112.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r112.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r112);
        SurfaceCombination r113 = new SurfaceCombination();
        r113.addSurfaceConfig(SurfaceConfig.create(r105, r109));
        r113.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r113);
        SurfaceCombination r114 = new SurfaceCombination();
        r114.addSurfaceConfig(SurfaceConfig.create(r105, r109));
        r114.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r114);
        return r100;
    }

    public static List<SurfaceCombination> getFullSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.PREVIEW;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigSize r104 = SurfaceConfig.ConfigSize.MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r104));
        r100.add(r101);
        SurfaceCombination r105 = new SurfaceCombination();
        r105.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigType r106 = SurfaceConfig.ConfigType.YUV;
        r105.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r105);
        SurfaceCombination r107 = new SurfaceCombination();
        r107.addSurfaceConfig(SurfaceConfig.create(r106, r103));
        r107.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r107);
        SurfaceCombination r108 = new SurfaceCombination();
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r108.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, r104));
        r100.add(r108);
        SurfaceCombination r109 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r110 = SurfaceConfig.ConfigSize.VGA;
        r109.addSurfaceConfig(SurfaceConfig.create(r106, r110));
        r109.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r109.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r109);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r106, r110));
        r111.addSurfaceConfig(SurfaceConfig.create(r106, r103));
        r111.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r111);
        return r100;
    }

    public static List<SurfaceCombination> getLegacySupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r101);
        SurfaceCombination r104 = new SurfaceCombination();
        SurfaceConfig.ConfigType r105 = SurfaceConfig.ConfigType.JPEG;
        r104.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r104);
        SurfaceCombination r106 = new SurfaceCombination();
        SurfaceConfig.ConfigType r107 = SurfaceConfig.ConfigType.YUV;
        r106.addSurfaceConfig(SurfaceConfig.create(r107, r103));
        r100.add(r106);
        SurfaceCombination r108 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r109 = SurfaceConfig.ConfigSize.PREVIEW;
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r108.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r108);
        SurfaceCombination r110 = new SurfaceCombination();
        r110.addSurfaceConfig(SurfaceConfig.create(r107, r109));
        r110.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r110);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r100.add(r111);
        SurfaceCombination r112 = new SurfaceCombination();
        r112.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r112.addSurfaceConfig(SurfaceConfig.create(r107, r109));
        r100.add(r112);
        SurfaceCombination r113 = new SurfaceCombination();
        r113.addSurfaceConfig(SurfaceConfig.create(r102, r109));
        r113.addSurfaceConfig(SurfaceConfig.create(r107, r109));
        r113.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r113);
        return r100;
    }

    public static List<SurfaceCombination> getLevel3SupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.PREVIEW;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigSize r104 = SurfaceConfig.ConfigSize.VGA;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r104));
        SurfaceConfig.ConfigType r105 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize r106 = SurfaceConfig.ConfigSize.MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r105, r106));
        SurfaceConfig.ConfigType r107 = SurfaceConfig.ConfigType.RAW;
        r101.addSurfaceConfig(SurfaceConfig.create(r107, r106));
        r100.add(r101);
        SurfaceCombination r108 = new SurfaceCombination();
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r104));
        r108.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, r106));
        r108.addSurfaceConfig(SurfaceConfig.create(r107, r106));
        r100.add(r108);
        return r100;
    }

    public static List<SurfaceCombination> getLimitedSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.PREVIEW;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigSize r104 = SurfaceConfig.ConfigSize.RECORD;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r104));
        r100.add(r101);
        SurfaceCombination r105 = new SurfaceCombination();
        r105.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigType r106 = SurfaceConfig.ConfigType.YUV;
        r105.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r105);
        SurfaceCombination r107 = new SurfaceCombination();
        r107.addSurfaceConfig(SurfaceConfig.create(r106, r103));
        r107.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r100.add(r107);
        SurfaceCombination r108 = new SurfaceCombination();
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r108.addSurfaceConfig(SurfaceConfig.create(r102, r104));
        SurfaceConfig.ConfigType r109 = SurfaceConfig.ConfigType.JPEG;
        r108.addSurfaceConfig(SurfaceConfig.create(r109, r104));
        r100.add(r108);
        SurfaceCombination r110 = new SurfaceCombination();
        r110.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r110.addSurfaceConfig(SurfaceConfig.create(r106, r104));
        r110.addSurfaceConfig(SurfaceConfig.create(r109, r104));
        r100.add(r110);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r106, r103));
        r111.addSurfaceConfig(SurfaceConfig.create(r106, r103));
        r111.addSurfaceConfig(SurfaceConfig.create(r109, SurfaceConfig.ConfigSize.MAXIMUM));
        r100.add(r111);
        return r100;
    }

    public static List<SurfaceCombination> getPreviewStabilizationSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.s1440p;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r101);
        SurfaceCombination r104 = new SurfaceCombination();
        SurfaceConfig.ConfigType r105 = SurfaceConfig.ConfigType.YUV;
        r104.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r104);
        SurfaceCombination r106 = new SurfaceCombination();
        r106.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigType r107 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize r108 = SurfaceConfig.ConfigSize.MAXIMUM;
        r106.addSurfaceConfig(SurfaceConfig.create(r107, r108));
        r100.add(r106);
        SurfaceCombination r109 = new SurfaceCombination();
        r109.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r109.addSurfaceConfig(SurfaceConfig.create(r107, r108));
        r100.add(r109);
        SurfaceCombination r110 = new SurfaceCombination();
        r110.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r110.addSurfaceConfig(SurfaceConfig.create(r105, r108));
        r100.add(r110);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r111.addSurfaceConfig(SurfaceConfig.create(r105, r108));
        r100.add(r111);
        SurfaceCombination r112 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r113 = SurfaceConfig.ConfigSize.PREVIEW;
        r112.addSurfaceConfig(SurfaceConfig.create(r102, r113));
        r112.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r112);
        SurfaceCombination r114 = new SurfaceCombination();
        r114.addSurfaceConfig(SurfaceConfig.create(r105, r113));
        r114.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r114);
        SurfaceCombination r115 = new SurfaceCombination();
        r115.addSurfaceConfig(SurfaceConfig.create(r102, r113));
        r115.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r115);
        SurfaceCombination r116 = new SurfaceCombination();
        r116.addSurfaceConfig(SurfaceConfig.create(r105, r113));
        r116.addSurfaceConfig(SurfaceConfig.create(r105, r103));
        r100.add(r116);
        return r100;
    }

    public static List<SurfaceCombination> getRAWSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r101);
        SurfaceCombination r104 = new SurfaceCombination();
        SurfaceConfig.ConfigType r105 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r106 = SurfaceConfig.ConfigSize.PREVIEW;
        r104.addSurfaceConfig(SurfaceConfig.create(r105, r106));
        r104.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r104);
        SurfaceCombination r107 = new SurfaceCombination();
        SurfaceConfig.ConfigType r108 = SurfaceConfig.ConfigType.YUV;
        r107.addSurfaceConfig(SurfaceConfig.create(r108, r106));
        r107.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r107);
        SurfaceCombination r109 = new SurfaceCombination();
        r109.addSurfaceConfig(SurfaceConfig.create(r105, r106));
        r109.addSurfaceConfig(SurfaceConfig.create(r105, r106));
        r109.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r109);
        SurfaceCombination r110 = new SurfaceCombination();
        r110.addSurfaceConfig(SurfaceConfig.create(r105, r106));
        r110.addSurfaceConfig(SurfaceConfig.create(r108, r106));
        r110.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r110);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r108, r106));
        r111.addSurfaceConfig(SurfaceConfig.create(r108, r106));
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r111);
        SurfaceCombination r112 = new SurfaceCombination();
        r112.addSurfaceConfig(SurfaceConfig.create(r105, r106));
        SurfaceConfig.ConfigType r113 = SurfaceConfig.ConfigType.JPEG;
        r112.addSurfaceConfig(SurfaceConfig.create(r113, r103));
        r112.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r112);
        SurfaceCombination r114 = new SurfaceCombination();
        r114.addSurfaceConfig(SurfaceConfig.create(r108, r106));
        r114.addSurfaceConfig(SurfaceConfig.create(r113, r103));
        r114.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r114);
        return r100;
    }

    public static List<SurfaceCombination> getStreamUseCaseSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.s1440p;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103, 4));
        r100.add(r101);
        SurfaceCombination r104 = new SurfaceCombination();
        SurfaceConfig.ConfigType r105 = SurfaceConfig.ConfigType.YUV;
        r104.addSurfaceConfig(SurfaceConfig.create(r105, r103, 4));
        r100.add(r104);
        SurfaceCombination r106 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r107 = SurfaceConfig.ConfigSize.RECORD;
        r106.addSurfaceConfig(SurfaceConfig.create(r102, r107, 3));
        r100.add(r106);
        SurfaceCombination r108 = new SurfaceCombination();
        r108.addSurfaceConfig(SurfaceConfig.create(r105, r107, 3));
        r100.add(r108);
        SurfaceCombination r109 = new SurfaceCombination();
        SurfaceConfig.ConfigType r110 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize r111 = SurfaceConfig.ConfigSize.MAXIMUM;
        r109.addSurfaceConfig(SurfaceConfig.create(r110, r111, 2));
        r100.add(r109);
        SurfaceCombination r112 = new SurfaceCombination();
        r112.addSurfaceConfig(SurfaceConfig.create(r105, r111, 2));
        r100.add(r112);
        SurfaceCombination r113 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r114 = SurfaceConfig.ConfigSize.PREVIEW;
        r113.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r113.addSurfaceConfig(SurfaceConfig.create(r110, r111, 2));
        r100.add(r113);
        SurfaceCombination r115 = new SurfaceCombination();
        r115.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r115.addSurfaceConfig(SurfaceConfig.create(r105, r111, 2));
        r100.add(r115);
        SurfaceCombination r116 = new SurfaceCombination();
        r116.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r116.addSurfaceConfig(SurfaceConfig.create(r102, r107, 3));
        r100.add(r116);
        SurfaceCombination r117 = new SurfaceCombination();
        r117.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r117.addSurfaceConfig(SurfaceConfig.create(r105, r107, 3));
        r100.add(r117);
        SurfaceCombination r118 = new SurfaceCombination();
        r118.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r118.addSurfaceConfig(SurfaceConfig.create(r105, r114, 1));
        r100.add(r118);
        SurfaceCombination r119 = new SurfaceCombination();
        r119.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r119.addSurfaceConfig(SurfaceConfig.create(r102, r107, 3));
        r119.addSurfaceConfig(SurfaceConfig.create(r110, r107, 2));
        r100.add(r119);
        SurfaceCombination r120 = new SurfaceCombination();
        r120.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r120.addSurfaceConfig(SurfaceConfig.create(r105, r107, 3));
        r120.addSurfaceConfig(SurfaceConfig.create(r110, r107, 2));
        r100.add(r120);
        SurfaceCombination r121 = new SurfaceCombination();
        r121.addSurfaceConfig(SurfaceConfig.create(r102, r114, 1));
        r121.addSurfaceConfig(SurfaceConfig.create(r105, r114, 1));
        r121.addSurfaceConfig(SurfaceConfig.create(r110, r111, 2));
        r100.add(r121);
        return r100;
    }

    public static List<SurfaceCombination> getUltraHdrSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.JPEG_R;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r101);
        SurfaceCombination r104 = new SurfaceCombination();
        r104.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        r104.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r100.add(r104);
        return r100;
    }

    public static List<SurfaceCombination> getUltraHighResolutionSupportedCombinationList() {
        ArrayList r100 = new ArrayList();
        SurfaceCombination r101 = new SurfaceCombination();
        SurfaceConfig.ConfigType r102 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize r103 = SurfaceConfig.ConfigSize.ULTRA_MAXIMUM;
        r101.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        SurfaceConfig.ConfigType r104 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r105 = SurfaceConfig.ConfigSize.PREVIEW;
        r101.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        SurfaceConfig.ConfigSize r106 = SurfaceConfig.ConfigSize.RECORD;
        r101.addSurfaceConfig(SurfaceConfig.create(r104, r106));
        r100.add(r101);
        SurfaceCombination r107 = new SurfaceCombination();
        SurfaceConfig.ConfigType r108 = SurfaceConfig.ConfigType.JPEG;
        r107.addSurfaceConfig(SurfaceConfig.create(r108, r103));
        r107.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r107.addSurfaceConfig(SurfaceConfig.create(r104, r106));
        r100.add(r107);
        SurfaceCombination r109 = new SurfaceCombination();
        SurfaceConfig.ConfigType r110 = SurfaceConfig.ConfigType.RAW;
        r109.addSurfaceConfig(SurfaceConfig.create(r110, r103));
        r109.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r109.addSurfaceConfig(SurfaceConfig.create(r104, r106));
        r100.add(r109);
        SurfaceCombination r111 = new SurfaceCombination();
        r111.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r111.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        SurfaceConfig.ConfigSize r112 = SurfaceConfig.ConfigSize.MAXIMUM;
        r111.addSurfaceConfig(SurfaceConfig.create(r108, r112));
        r100.add(r111);
        SurfaceCombination r113 = new SurfaceCombination();
        r113.addSurfaceConfig(SurfaceConfig.create(r108, r103));
        r113.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r113.addSurfaceConfig(SurfaceConfig.create(r108, r112));
        r100.add(r113);
        SurfaceCombination r114 = new SurfaceCombination();
        r114.addSurfaceConfig(SurfaceConfig.create(r110, r103));
        r114.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r114.addSurfaceConfig(SurfaceConfig.create(r108, r112));
        r100.add(r114);
        SurfaceCombination r115 = new SurfaceCombination();
        r115.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r115.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r115.addSurfaceConfig(SurfaceConfig.create(r102, r112));
        r100.add(r115);
        SurfaceCombination r116 = new SurfaceCombination();
        r116.addSurfaceConfig(SurfaceConfig.create(r108, r103));
        r116.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r116.addSurfaceConfig(SurfaceConfig.create(r102, r112));
        r100.add(r116);
        SurfaceCombination r117 = new SurfaceCombination();
        r117.addSurfaceConfig(SurfaceConfig.create(r110, r103));
        r117.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r117.addSurfaceConfig(SurfaceConfig.create(r102, r112));
        r100.add(r117);
        SurfaceCombination r118 = new SurfaceCombination();
        r118.addSurfaceConfig(SurfaceConfig.create(r102, r103));
        r118.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r118.addSurfaceConfig(SurfaceConfig.create(r110, r112));
        r100.add(r118);
        SurfaceCombination r119 = new SurfaceCombination();
        r119.addSurfaceConfig(SurfaceConfig.create(r108, r103));
        r119.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r119.addSurfaceConfig(SurfaceConfig.create(r110, r112));
        r100.add(r119);
        SurfaceCombination r120 = new SurfaceCombination();
        r120.addSurfaceConfig(SurfaceConfig.create(r110, r103));
        r120.addSurfaceConfig(SurfaceConfig.create(r104, r105));
        r120.addSurfaceConfig(SurfaceConfig.create(r110, r112));
        r100.add(r120);
        return r100;
    }

    private GuaranteedConfigurationsUtil() {
    }

    public static List<SurfaceCombination> generateSupportedCombinationList(int r100, boolean r101, boolean r102) {
        ArrayList r103 = new ArrayList();
        r103.addAll(getLegacySupportedCombinationList());
        if (r100 == 0) goto L6;
        if (r100 == 1) goto L6;
        if (r100 == 3) goto L6;
    L7:
        if (r100 == 1) goto L9;
        if (r100 == 3) goto L9;
    L10:
        if (r101 == false) goto L12;
        r103.addAll(getRAWSupportedCombinationList());
    L12:
        if (r102 == false) goto L15;
        if (r100 != 0) goto L15;
        r103.addAll(getBurstSupportedCombinationList());
    L15:
        if (r100 != 3) goto L17;
        r103.addAll(getLevel3SupportedCombinationList());
    L17:
        return r103;
    L9:
        r103.addAll(getFullSupportedCombinationList());
    L6:
        r103.addAll(getLimitedSupportedCombinationList());
        goto L7
    }
}
