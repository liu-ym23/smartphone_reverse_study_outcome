package com.bytedance.android.livesdkapi.live;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/live/ILiveExternalCameraServiceForOther;", "Lcom/bytedance/android/live/base/IService;", "isConnected", "", "isDisableAbility", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveExternalCameraServiceForOther extends IService {
    boolean isConnected();

    boolean isDisableAbility();
}
