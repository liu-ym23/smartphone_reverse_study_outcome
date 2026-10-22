package com.bytedance.android.livesdkapi.brightness;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.brightness.LiveBrightnessService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\tH&J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0012\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/brightness/ILiveBrightnessService;", "Lcom/bytedance/android/live/base/IService;", "adjustWindowBright", "", "activity", "Landroid/app/Activity;", "scale", "(Landroid/app/Activity;F)Ljava/lang/Float;", "autoBrightnessSet", "", "isSearchScene", "", "getAutoBrightnessStatus", "", "getEnvBrightnessValue", "getSystemValue", BasicTestActionHandler.TEST_ACTION_RESET, "resetSystemBright", "setBright", "bright", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveBrightnessService extends IService {
    Float adjustWindowBright(Activity r100, float r101);

    void autoBrightnessSet(Activity r100, boolean r101);

    int getAutoBrightnessStatus();

    int getEnvBrightnessValue();

    int getSystemValue(Activity r100);

    void reset();

    void resetSystemBright(Activity r100);

    void setBright(Activity r100, float r101);
}
