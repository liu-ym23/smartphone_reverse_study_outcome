package android.ss.com.vboost;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.ss.com.vboost.request.RequestManager;
import android.ss.com.vboost.utils.LogUtil;
import android.ss.com.vboost.utils.RomUtils;
import android.util.SparseArray;
import androidx.camera.core.RetryPolicy;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CapabilityScheduler {
    private static final FrequencyLevel DEFAULT_CORE_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_CORE_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CORE_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_CORE_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_CORE_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_CORE_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CORE_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_CORE_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_CPU_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_CPU_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CPU_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_CPU_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_CPU_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_CPU_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_CPU_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_CPU_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_DDR_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_DDR_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_DDR_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_DDR_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_DDR_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_DDR_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_DDR_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_DDR_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_GPU_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_GPU_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_GPU_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_GPU_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_GPU_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_GPU_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_GPU_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_GPU_LIMIT_SHORT_TIMEOUT = 3000;
    private static final FrequencyLevel DEFAULT_UFS_BOOST_LONG_LEVEL = null;
    private static final long DEFAULT_UFS_BOOST_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_UFS_BOOST_SHORT_LEVEL = null;
    private static final long DEFAULT_UFS_BOOST_SHORT_TIMEOUT = 1000;
    private static final FrequencyLevel DEFAULT_UFS_LIMIT_LONG_LEVEL = null;
    private static final long DEFAULT_UFS_LIMIT_LONG_TIMEOUT = 6000;
    private static final FrequencyLevel DEFAULT_UFS_LIMIT_SHORT_LEVEL = null;
    private static final long DEFAULT_UFS_LIMIT_SHORT_TIMEOUT = 3000;
    private static final int PRIORITY_LEVEL = 0;
    private static final String TAG = "CapabilityScheduler";
    private static SparseArray<CustomRequest> curRequest;
    private static ISchedulerInitialConfigProvider mIInitialConfigProvider;
    private static volatile long start;

    static {
        FrequencyLevel r100 = FrequencyLevel.LEVEL_9;
        DEFAULT_CPU_BOOST_SHORT_LEVEL = r100;
        DEFAULT_CPU_BOOST_LONG_LEVEL = r100;
        FrequencyLevel r101 = FrequencyLevel.LEVEL_3;
        DEFAULT_CPU_LIMIT_SHORT_LEVEL = r101;
        DEFAULT_CPU_LIMIT_LONG_LEVEL = r101;
        DEFAULT_GPU_BOOST_SHORT_LEVEL = r100;
        DEFAULT_GPU_BOOST_LONG_LEVEL = r100;
        DEFAULT_GPU_LIMIT_SHORT_LEVEL = r101;
        DEFAULT_GPU_LIMIT_LONG_LEVEL = r101;
        DEFAULT_DDR_BOOST_SHORT_LEVEL = r100;
        DEFAULT_DDR_BOOST_LONG_LEVEL = r100;
        DEFAULT_DDR_LIMIT_SHORT_LEVEL = r101;
        DEFAULT_DDR_LIMIT_LONG_LEVEL = r101;
        DEFAULT_UFS_BOOST_SHORT_LEVEL = r100;
        DEFAULT_UFS_BOOST_LONG_LEVEL = r100;
        DEFAULT_UFS_LIMIT_SHORT_LEVEL = r101;
        DEFAULT_UFS_LIMIT_LONG_LEVEL = r101;
        DEFAULT_CORE_BOOST_SHORT_LEVEL = r100;
        DEFAULT_CORE_BOOST_LONG_LEVEL = r100;
        DEFAULT_CORE_LIMIT_SHORT_LEVEL = r101;
        DEFAULT_CORE_LIMIT_LONG_LEVEL = r101;
        start = 0;
        curRequest = new SparseArray();
        mIInitialConfigProvider = null;
    }

    public CapabilityScheduler() {
    }

    public static ISchedulerInitialConfigProvider getInitialConfigProvider() {
        return mIInitialConfigProvider;
    }

    public static Set<CapabilityType> getSupportCapabilities() {
        return RequestManager.getInstance().getSupportCapabilities();
    }

    public static boolean isSupportCapability(CapabilityType r100) {
        return RequestManager.getInstance().isSupportCapability(r100);
    }

    public static int networkEnhance() {
        return 1;
    }

    public static void perfIn() {
        if ("1".equals(RomUtils.getSystemProperty("debug.vboost.disable")) == false) goto L5;
        boolean r100 = false;
    L6:
        switchVboost(r100);
        start = System.nanoTime();
        return;
    L5:
        r100 = true;
        goto L6
    }

    public static void perfOut() {
        LogUtil.debug(TAG, "cost:" + String.valueOf(System.nanoTime() - start));
    }

    public static int preloadIo() {
        return 1;
    }

    public static void registerApplication(Context r100) {
        RequestManager.getInstance().register(r100);
    }

    public static void registerApplogListener(VboostListener.VboostApplogListener r100) {
        RequestManager.getInstance().registerApplog(r100);
    }

    public static void registerSystemListener(VboostListener.SystemListener r100) {
        RequestManager.getInstance().registerSystemListener(r100);
    }

    public static void requestCpuBoost() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_FREQ_MIN, DEFAULT_CPU_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestCpuBoostLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_FREQ_MIN, DEFAULT_CPU_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestCpuCoreBoost() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_CORE_MIN, DEFAULT_CORE_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestCpuCoreBoostLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_CORE_MIN, DEFAULT_CORE_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestCpuCoreLimit() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_CORE_MAX, DEFAULT_CORE_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestCpuCoreLimitLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_CORE_MAX, DEFAULT_CORE_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestCpuLimit() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_FREQ_MAX, DEFAULT_CPU_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestCpuLimitLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.CPU_FREQ_MAX, DEFAULT_CPU_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static int requestCustomBoost(CustomRequest r100) {
        if (r100.restore == true) goto L5;
        RequestManager.getInstance().commitRequest(r100);
        return 0;
    L5:
        RequestManager.getInstance().cancelRequest(r100);
        return 0;
    }

    public static void requestDdrBoost() {
        CustomRequest r100 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestDdrBoostLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestDdrLimit() {
        CustomRequest r100 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestDdrLimitLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.BUS_FREQ_MIN, DEFAULT_DDR_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestGpuBoost() {
        CustomRequest r100 = new CustomRequest(CapabilityType.GPU_FREQ_MIN, DEFAULT_GPU_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestGpuBoostLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.GPU_FREQ_MIN, DEFAULT_GPU_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestGpuLimit() {
        CustomRequest r100 = new CustomRequest(CapabilityType.GPU_FREQ_MAX, DEFAULT_GPU_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestGpuLimitLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.GPU_FREQ_MAX, DEFAULT_GPU_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static IImageThumbFetch.Fetcher requestImageThumbFetcher() {
        CustomRequest r100 = new CustomRequest();
        r100.type = CapabilityType.THUMB_FETCH.getIndex();
        Object r101 = RequestManager.getInstance().commitRequest(r100);
        if ((r101 instanceof IImageThumbFetch.Fetcher) == true) goto L5;
        return null;
    L5:
        return (IImageThumbFetch.Fetcher) r101;
    }

    public static int requestOptimizedScene(CustomScene r100, int r101) {
        CustomRequest r102 = new CustomRequest(CapabilityType.PRESET_SCENE, r100);
        r102.timeout = r101;
        RequestManager.getInstance().commitRequest(r102);
        return 1;
    }

    public static int requestOptimizedScene(CustomScene r100, Status r101) {
        if (r101 != Status.END) goto L9;
        CustomRequest r102 = curRequest.get(r100.getId());
        if (r102 != null) goto L8;
        LogUtil.warn(TAG, "restore a not start scene: " + r100.getDesc());
        return 0;
    L8:
        r102.restore = true;
        RequestManager.getInstance().commitRequest(r102);
        curRequest.remove(r100.getId());
    L12:
        return 1;
    L9:
        CustomRequest r103 = new CustomRequest(CapabilityType.PRESET_SCENE, r100);
        r103.restore = false;
        if (RequestManager.getInstance().commitRequest(r103) == null) goto L12;
        curRequest.put(r100.getId(), r103);
        goto L12
    }

    public static void requestUfsBoost() {
        CustomRequest r100 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_BOOST_SHORT_LEVEL, 1000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestUfsBoostLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_BOOST_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestUfsLimit() {
        CustomRequest r100 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_LIMIT_SHORT_LEVEL, 3000);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestUfsLimitLong() {
        CustomRequest r100 = new CustomRequest(CapabilityType.UFS_FREQ_MIN, DEFAULT_UFS_LIMIT_LONG_LEVEL, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        RequestManager.getInstance().commitRequest(r100);
    }

    public static void requestVibrateCapability(int r100, float r101, float r102, float r103, String r104) {
        CustomRequest r105 = new CustomRequest();
        Bundle r106 = new Bundle();
        r105.bundle = r106;
        r106.putInt("scene_type", r100);
        r105.bundle.putFloat("intensity", r101);
        r105.bundle.putFloat("sharpness", r102);
        r105.bundle.putFloat("duration", r103);
        r105.bundle.putString("jsonFilePath", r104);
        r105.type = CapabilityType.VIBRATE_ENHANCE.getIndex();
        RequestManager.getInstance().commitRequest(r105);
    }

    public static int resetAffinity(int r100) {
        CustomRequest r101 = new CustomRequest();
        r101.type = CapabilityType.CPU_AFFINITY.getIndex();
        r101.tid = r100;
        RequestManager.getInstance().commitRequest(r101);
        return 1;
    }

    public static int resetPowerState() {
        return 1;
    }

    public static int resetPriority(int r100) {
        CustomRequest r101 = new CustomRequest();
        r101.type = CapabilityType.TASK_PRIORITY.getIndex();
        r101.tid = r100;
        RequestManager.getInstance().commitRequest(r101);
        return 1;
    }

    public static void restoreCpuBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_FREQ_MIN);
    }

    public static void restoreCpuCoreBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_CORE_MIN);
    }

    public static void restoreCpuCoreLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_CORE_MAX);
    }

    public static void restoreCpuLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.CPU_FREQ_MAX);
    }

    public static void restoreDdrBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.BUS_FREQ_MIN);
    }

    public static void restoreDdrLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.BUS_FREQ_MAX);
    }

    public static void restoreGpuBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.GPU_FREQ_MIN);
    }

    public static void restoreGpuLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.GPU_FREQ_MAX);
    }

    public static void restoreUfsBoost() {
        RequestManager.getInstance().cancelRequest(CapabilityType.UFS_FREQ_MIN);
    }

    public static void restoreUfsLimit() {
        RequestManager.getInstance().cancelRequest(CapabilityType.UFS_FREQ_MAX);
    }

    public static int setAffinity(int r100, int r101) {
        CustomRequest r102 = new CustomRequest();
        r102.type = CapabilityType.CPU_AFFINITY.getIndex();
        r102.tid = r100;
        r102.cluster = r101;
        RequestManager.getInstance().commitRequest(r102);
        return 1;
    }

    public static void setAffinity(int r100) {
        setAffinity(Process.myTid(), r100);
    }

    public static void setAllowedScenes(HashSet<Integer> r100) {
        RequestManager.getInstance().setAllowedScenes(r100);
    }

    public static void setInitialConfigProvider(ISchedulerInitialConfigProvider r100) {
        mIInitialConfigProvider = r100;
    }

    public static void setLogLevel(int r100) {
        LogUtil.setLogLevel(r100);
    }

    public static int setPowerState() {
        return 1;
    }

    public static void setPriority(int r100) {
        setPriority(Process.myTid(), r100);
    }

    public static void setPriority(int r100, int r101) {
        CustomRequest r102 = new CustomRequest();
        r102.type = CapabilityType.TASK_PRIORITY.getIndex();
        r102.tid = r100;
        r102.priority = r101;
        RequestManager.getInstance().commitRequest(r102);
    }

    public static void switchVboost(boolean r100) {
        RequestManager.setEnableVboost(r100);
    }

    public static void unregisterSystemListener(VboostListener.SystemListener r100) {
        RequestManager.getInstance().unregisterSystemListener(r100);
    }
}
