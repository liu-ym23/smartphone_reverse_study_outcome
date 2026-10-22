package com.bytedance.android.livesdkapi.api;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.live.core.CoreServiceImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH&J#\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H'J\u0018\u0010\u0013\u001a\u00020\u00142\u000e\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0007H&J\u001a\u0010\u0019\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\tH&J\b\u0010\u001b\u001a\u00020\u001cH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/api/IUtilsCommonService;", "Lcom/bytedance/android/live/base/IService;", "deviceScoreHelperGetScore", "", "isAnchor", "", "getBDNetWorkRequestTag", "", "liveBrightnessUtilGetSystemValue", "", "activity", "Landroid/app/Activity;", "liveClientGetService", ExifInterface.GPS_DIRECTION_TRUE, "cls", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "nQECommonParamsBuild", "Lorg/json/JSONObject;", "runOnUIThread", "", "runnable", "Lkotlin/Function0;", "showCenterToast", "msg", "showSystemToast", GXTemplateKey.GAIAX_LAYER_GRAVITY, "startTimeOfSDKInitTracer", "", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUtilsCommonService extends IService {
    float deviceScoreHelperGetScore(boolean r100);

    String getBDNetWorkRequestTag();

    int liveBrightnessUtilGetSystemValue(Activity r100);

    <T> T liveClientGetService(Class<T> r100);

    JSONObject nQECommonParamsBuild();

    void runOnUIThread(Function0<Unit> r100);

    void showCenterToast(String r100);

    void showSystemToast(String r100, int r101);

    long startTimeOfSDKInitTracer();
}
