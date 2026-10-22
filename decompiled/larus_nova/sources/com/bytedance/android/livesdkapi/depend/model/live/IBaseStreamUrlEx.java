package com.bytedance.android.livesdkapi.depend.model.live;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001d\u001a\u00020\u001bH&J\b\u0010\u001e\u001a\u00020\u001bH&J\b\u0010\u001f\u001a\u00020\u001bH&J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020!H&¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlEx;", "", "getBindNodeRtmpUrl", "", "getCompoundSceneType", "", "getCompoundStreamData", "getCompoundStreamDefaultQualitySdkKey", "getDefaultDefinition", "getDefaultQuality", "getDefaultQualityStrategy", "getExtension", "Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "getLowestQuality", "getMultiStreamData", "getMultiStreamDataFromPullDatas", "key", "getMultiStreamDefaultQualityName", "getMultiStreamDefaultQualitySdkKey", "getMultiStreamLowestQualityName", "getPullSdkParamsStr", "getQualities", "", "getQualityList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getVPassDefault", "", "hasLiveCoreSDKData", "isCompoundScene", "isMultiPullDataValid", "isPullUrlValid", "validateMultiPullData", "", "validatePullUrl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBaseStreamUrlEx {
    String getBindNodeRtmpUrl();

    int getCompoundSceneType();

    String getCompoundStreamData();

    String getCompoundStreamDefaultQualitySdkKey();

    String getDefaultDefinition();

    String getDefaultQuality();

    String getDefaultQualityStrategy();

    IExtension getExtension();

    String getLowestQuality();

    String getMultiStreamData();

    String getMultiStreamDataFromPullDatas();

    String getMultiStreamDataFromPullDatas(String r100);

    String getMultiStreamDefaultQualityName();

    String getMultiStreamDefaultQualitySdkKey();

    String getMultiStreamLowestQualityName();

    String getPullSdkParamsStr();

    Set<String> getQualities();

    List<IQuality> getQualityList();

    boolean getVPassDefault();

    boolean hasLiveCoreSDKData();

    boolean isCompoundScene();

    boolean isMultiPullDataValid();

    boolean isPullUrlValid();

    void validateMultiPullData();

    void validatePullUrl();
}
