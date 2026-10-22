package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0015\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\rH&J\b\u0010\u0019\u001a\u00020\rH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001aH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001aH&¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtraDef;", "", "getHeight", "", "getHeightFlex", "getWidthFlex", "getWidth", "getMinBitrate", "getDefaultBitrate", "getMaxBitrate", "getProfile", "", "isHardwareEncode", "getBitrateAdaptStrategy", "getFPS", "getAnchorInteractProfile", "getAudienceInteractProfile", "Lcom/bytedance/android/livesdkapi/depend/model/live/ISrConfig;", "getSrConfig", "isEnableH265", "", "getGopSec", "isRoi", "isSwRoi", "", "getNgbPushUrl", "getNgbPushUrlPrefix", "Lcom/bytedance/android/livesdkapi/depend/model/live/AdaptionInfo;", "getAdaptionInfo", "getBusinessName", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IStreamUrlExtra extends c<IStreamUrlExtra>, IStreamUrlExtraDef {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    AdaptionInfo getAdaptionInfo();

    int getAnchorInteractProfile();

    int getAudienceInteractProfile();

    int getBitrateAdaptStrategy();

    String getBusinessName();

    int getDefaultBitrate();

    int getFPS();

    float getGopSec();

    int getHeight();

    long getHeightFlex();

    int getMaxBitrate();

    int getMinBitrate();

    String getNgbPushUrl();

    String getNgbPushUrlPrefix();

    int getProfile();

    ISrConfig getSrConfig();

    int getWidth();

    long getWidthFlex();

    boolean isEnableH265();

    boolean isHardwareEncode();

    boolean isRoi();

    boolean isSwRoi();
}
