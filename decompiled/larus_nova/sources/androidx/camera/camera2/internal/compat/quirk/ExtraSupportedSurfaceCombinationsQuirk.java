package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ExtraSupportedSurfaceCombinationsQuirk implements Quirk {
    private static final SurfaceCombination FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION = null;
    private static final SurfaceCombination LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION = null;
    private static final Set<String> SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS = null;
    private static final Set<String> SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS = null;
    private static final String TAG = "ExtraSupportedSurfaceCombinationsQuirk";

    public ExtraSupportedSurfaceCombinationsQuirk() {
    }

    private static SurfaceCombination createFullYuvPrivYuvConfiguration() {
        SurfaceCombination r100 = new SurfaceCombination();
        SurfaceConfig.ConfigType r101 = SurfaceConfig.ConfigType.YUV;
        r100.addSurfaceConfig(SurfaceConfig.create(r101, SurfaceConfig.ConfigSize.VGA));
        r100.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        r100.addSurfaceConfig(SurfaceConfig.create(r101, SurfaceConfig.ConfigSize.MAXIMUM));
        return r100;
    }

    private static SurfaceCombination createLevel3PrivPrivYuvSubsetConfiguration() {
        SurfaceCombination r100 = new SurfaceCombination();
        SurfaceConfig.ConfigType r101 = SurfaceConfig.ConfigType.PRIV;
        r100.addSurfaceConfig(SurfaceConfig.create(r101, SurfaceConfig.ConfigSize.PREVIEW));
        r100.addSurfaceConfig(SurfaceConfig.create(r101, SurfaceConfig.ConfigSize.VGA));
        r100.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        return r100;
    }

    private static boolean isSamsungS7() {
        String r100 = Build.DEVICE;
        if ("heroqltevzw".equalsIgnoreCase(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if ("heroqltetmo".equalsIgnoreCase(r100) == true) goto L8;
        return false;
    }

    private static boolean supportExtraLevel3ConfigurationsGoogleDevice() {
        if ("google".equalsIgnoreCase(Build.BRAND) == true) goto L6;
        return false;
    L6:
        String r100 = Build.MODEL.toUpperCase(Locale.US);
        return SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS.contains(r100);
    }

    private static boolean supportExtraLevel3ConfigurationsSamsungDevice() {
        if (SmEditTextLeakOpt.SAMSUNG.equalsIgnoreCase(Build.BRAND) == true) goto L5;
        return false;
    L5:
        String r100 = Build.MODEL.toUpperCase(Locale.US);
        Iterator<String> r101 = SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (r100.startsWith(r101.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    static {
        FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION = createFullYuvPrivYuvConfiguration();
        LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION = createLevel3PrivPrivYuvSubsetConfiguration();
        SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS = new HashSet(Arrays.asList(new String[]{"PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"}));
        SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS = new HashSet(Arrays.asList(new String[]{"SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26"}));
    }

    public static boolean load() {
        if (isSamsungS7() == false) goto L5;
    L10:
        return true;
    L5:
        if (supportExtraLevel3ConfigurationsGoogleDevice() == true) goto L10;
        if (supportExtraLevel3ConfigurationsSamsungDevice() == true) goto L10;
        return false;
    }

    private List<SurfaceCombination> getSamsungS7ExtraCombinations(String r100) {
        ArrayList r101 = new ArrayList();
        if (r100.equals("1") == false) goto L5;
        r101.add(FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION);
    L5:
        return r101;
    }

    public List<SurfaceCombination> getExtraSupportedSurfaceCombinations(String r100) {
        if (isSamsungS7() == false) goto L7;
        return getSamsungS7ExtraCombinations(r100);
    L7:
        if (supportExtraLevel3ConfigurationsGoogleDevice() == true) goto L14;
        if (supportExtraLevel3ConfigurationsSamsungDevice() == true) goto L14;
        return Collections.emptyList();
    L14:
        return Collections.singletonList(LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION);
    }
}
