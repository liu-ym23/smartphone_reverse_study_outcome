package com.bytedance.android.livesdkapi.util;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.bytedance.android.livesdkapi.model.LiveMoreEntranceFloatWindowModel;
import com.bytedance.android.livesdkapi.model.LiveMoreEntranceStackRoomModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u0004\u0018\u00010\tJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u001bJ\"\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/LiveMultiTabFloatWindowStore;", "", "()V", "currentEnterFromMerge", "", "currentEnterMethod", "currentModel", "Lcom/bytedance/android/livesdkapi/model/LiveMoreEntranceFloatWindowModel;", "currentStackRoomModel", "Lcom/bytedance/android/livesdkapi/model/LiveMoreEntranceStackRoomModel;", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "isMoreLiveToLiveTab", "setMoreLiveToLiveTab", "isTabChange", "setTabChange", "targetTabIdMap", "", "getTargetTabIdMap", "()Ljava/util/Map;", "setTargetTabIdMap", "(Ljava/util/Map;)V", "clearEnterFromMerge", "", "clearEnterMethod", "consumedCurrentModel", "getBackRoomInfo", "getCurrentModel", "getEnterFromMerge", "getEnterMethod", "resetBackRoomInfo", "saveBackRoomInfo", "info", "Landroid/os/Bundle;", "refInfo", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdkapi/depend/live/StackContext;", "saveEnterFromMerge", "enterFromMerge", "saveEnterMethod", "enterMethod", "setCurrentModel", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMultiTabFloatWindowStore {
    public static final LiveMultiTabFloatWindowStore INSTANCE = null;
    private static String currentEnterFromMerge;
    private static String currentEnterMethod;
    private static LiveMoreEntranceFloatWindowModel currentModel;
    private static LiveMoreEntranceStackRoomModel currentStackRoomModel;
    private static boolean enable;
    private static boolean isMoreLiveToLiveTab;
    private static boolean isTabChange;
    private static Map<String, String> targetTabIdMap;

    private LiveMultiTabFloatWindowStore() {
    }

    public final void clearEnterFromMerge() {
        currentEnterFromMerge = null;
    }

    public final void clearEnterMethod() {
        currentEnterMethod = null;
    }

    public final void resetBackRoomInfo() {
        currentStackRoomModel = null;
    }

    static {
        INSTANCE = new LiveMultiTabFloatWindowStore();
    }

    public final void consumedCurrentModel() {
        LiveMoreEntranceFloatWindowModel r100 = currentModel;
        if (r100 == null) goto L6;
        r100.setConsumed(true);
        return;
    }

    public final String getEnterFromMerge() {
        String r100 = currentEnterFromMerge;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getEnterMethod() {
        String r100 = currentEnterMethod;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final LiveMoreEntranceStackRoomModel getBackRoomInfo() {
        return currentStackRoomModel;
    }

    public final LiveMoreEntranceFloatWindowModel getCurrentModel() {
        return currentModel;
    }

    public final boolean getEnable() {
        return enable;
    }

    public final Map<String, String> getTargetTabIdMap() {
        return targetTabIdMap;
    }

    public final boolean isMoreLiveToLiveTab() {
        return isMoreLiveToLiveTab;
    }

    public final boolean isTabChange() {
        return isTabChange;
    }

    public final void saveEnterFromMerge(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        currentEnterFromMerge = r100;
    }

    public final void saveEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        currentEnterMethod = r100;
    }

    public final void setCurrentModel(LiveMoreEntranceFloatWindowModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        currentModel = r100;
    }

    public final void setEnable(boolean r100) {
        enable = r100;
    }

    public final void setMoreLiveToLiveTab(boolean r100) {
        isMoreLiveToLiveTab = r100;
    }

    public final void setTabChange(boolean r100) {
        isTabChange = r100;
    }

    public final void setTargetTabIdMap(Map<String, String> r100) {
        targetTabIdMap = r100;
    }

    public final void saveBackRoomInfo(Bundle r100, Bundle r101, StackContext r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        currentStackRoomModel = new LiveMoreEntranceStackRoomModel(r100, r101, r110, SystemClock.elapsedRealtime());
    }
}
