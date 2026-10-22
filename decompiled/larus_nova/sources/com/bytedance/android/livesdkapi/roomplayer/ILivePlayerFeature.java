package com.bytedance.android.livesdkapi.roomplayer;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerFeature;", "", "getFeature", ExifInterface.GPS_DIRECTION_TRUE, "key", "", "valueIfNotFound", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerFeature {
    <T> Object getFeature(String r100, T r101);
}
