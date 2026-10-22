package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.config.p81;
import com.bytedance.android.livesdk.config.q81;
import com.bytedance.android.livesdk.config.r81;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveTbArchOptConfig;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J=\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bR\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdkapi/room/handler/toolbar/LiveTbArchUtils;", "", "()V", "fixAddViewError", "", "kotlin.jvm.PlatformType", "Ljava/lang/Boolean;", "optViewCache", "setting", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveTbArchOptConfig;", "bizCheckInterceptCount", "", "enableAlog", "enableCollectTraceInfo", "enableOpt", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "enablePrefOpt", "enableTrace", "enableTraceSample", "runWithAB", ExifInterface.GPS_DIRECTION_TRUE, PlayerResolution.SDKKEY.ORIGIN, "Lkotlin/Function0;", "newBlock", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "traceSample", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTbArchUtils {
    public static final LiveTbArchUtils INSTANCE = null;
    private static final Boolean fixAddViewError = null;
    private static final Boolean optViewCache = null;
    private static final LiveTbArchOptConfig setting = null;

    private LiveTbArchUtils() {
    }

    static {
        INSTANCE = new LiveTbArchUtils();
        setting = p81.f120959a.getValue();
        fixAddViewError = q81.f121035a.getValue();
        optViewCache = r81.f121112a.getValue();
    }

    public final int bizCheckInterceptCount() {
        return setting.getBizCheckInterceptCount();
    }

    public final boolean enableAlog() {
        return setting.getEnableAlog();
    }

    public final boolean enableCollectTraceInfo() {
        return setting.getEnableCollectTraceInfo();
    }

    public final boolean enablePrefOpt() {
        return setting.getPrefOpt();
    }

    public final boolean enableTrace() {
        return setting.getEnableTrace();
    }

    public final boolean enableTraceSample() {
        return setting.getEnableTraceSample();
    }

    public final boolean fixAddViewError() {
        return fixAddViewError.booleanValue();
    }

    public final boolean optViewCache() {
        return optViewCache.booleanValue();
    }

    public final double traceSample() {
        return setting.getTraceSample();
    }

    public final boolean enableOpt(DataCenter r100) {
        if (r100 == null) goto L4;
        Boolean r101 = (Boolean) r100.get("data_is_anchor", Boolean.FALSE);
    L6:
        if ((!Intrinsics.areEqual(r101, Boolean.TRUE)) == true) goto L8;
    L10:
        return false;
    L8:
        if (setting.getEnable() == false) goto L10;
        return true;
    L4:
        r101 = null;
        goto L6
    }

    public final <T> T runWithAB(DataCenter r100, Function0<? extends T> r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r102, "newBlock");
        if (enableOpt(r100) == false) goto L6;
        return r102.invoke();
    L6:
        return r101.invoke();
    }
}
