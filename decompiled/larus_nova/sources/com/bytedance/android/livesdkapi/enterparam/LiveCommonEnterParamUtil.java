package com.bytedance.android.livesdkapi.enterparam;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.PreviewEtData;
import com.bytedance.android.livesdkapi.util.LiveSdkApiBundleOptUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/enterparam/LiveCommonEnterParamUtil;", "", "()V", "getCommonBundle", "Landroid/os/Bundle;", "bundle", "getCommonParamsData", "Lcom/bytedance/android/livesdkapi/enterparam/CommonEnterParamsData;", "getCommonParamsDataOrPut", "getFirstRoomBundle", "getFirstShowRoomBundle", "putCommonParams", "", "etDataList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewEtData;", "putCommonParamsData", "commonEnterParam", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonEnterParamUtil {
    public static final LiveCommonEnterParamUtil INSTANCE = null;

    private LiveCommonEnterParamUtil() {
    }

    static {
        INSTANCE = new LiveCommonEnterParamUtil();
    }

    @JvmStatic
    public static final Bundle getCommonBundle(Bundle r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_PARAM);
    }

    @JvmStatic
    public static final CommonEnterParamsData getCommonParamsData(Bundle r100) {
        return (CommonEnterParamsData) LiveSdkApiBundleOptUtils.getParcelableBinderData(r100, ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM);
    }

    @JvmStatic
    public static final Bundle getFirstRoomBundle(Bundle r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_FIRST_ROOM);
    }

    @JvmStatic
    public static final Bundle getFirstShowRoomBundle(Bundle r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_FIRST_SHOW_ROOM);
    }

    public final CommonEnterParamsData getCommonParamsDataOrPut(Bundle r110) {
        Intrinsics.checkNotNullParameter(r110, "bundle");
        CommonEnterParamsData r100 = getCommonParamsData(r110);
        if (r100 != null) goto L6;
        CommonEnterParamsData r101 = new CommonEnterParamsData(null, null, null, null, null, null, 63, null);
        putCommonParamsData(r110, r101);
        return r101;
    L6:
        return r100;
    }

    @JvmStatic
    public static final void putCommonParamsData(Bundle r100, CommonEnterParamsData r101) {
        Intrinsics.checkNotNullParameter(r101, "commonEnterParam");
        LiveSdkApiBundleOptUtils.putParcelableBinderData(r100, ILiveRoomPlayFragmentConstant.EXTRA_LIVE_COMMON_ENTER_PARAM, r101);
    }

    public final void putCommonParams(Bundle r100, List<PreviewEtData> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<PreviewEtData> r102 = r101;
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        CommonEnterParamsData r104 = getCommonParamsDataOrPut(r100);
        Iterator<PreviewEtData> r105 = r101.iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        PreviewEtData r106 = r105.next();
        PreviewEtDataManager r107 = PreviewEtDataManager.INSTANCE;
        r107.putIntoCommonData(r107.getPreviewEtDataCache(r106), r104);
        goto L15
    L17:
        return;
    L7:
        if (r102.isEmpty() == true) goto L10;
        r103 = false;
        goto L11
    }
}
