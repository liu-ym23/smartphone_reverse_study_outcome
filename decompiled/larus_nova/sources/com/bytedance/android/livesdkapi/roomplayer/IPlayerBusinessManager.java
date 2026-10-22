package com.bytedance.android.livesdkapi.roomplayer;

import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\u0002\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerBusinessManager;", "", "business", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerBusiness;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerBusiness;", MiPushClient.COMMAND_REGISTER, "", "(Ljava/lang/Class;Lcom/bytedance/android/livesdkapi/roomplayer/IPlayerBusiness;)V", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerBusinessManager {
    <T extends IPlayerBusiness> T business(Class<T> r100);

    <T extends IPlayerBusiness> void register(Class<T> r100, T r101);
}
