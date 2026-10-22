package com.bytedance.android.livehostapi.business.smartclient;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J:\u0010\f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\b2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\r\u0012\u0004\u0012\u00020\u00030\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\u0012H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/smartclient/ILiveSmartClientManager;", "", "cancelObserve", "", "sceneName", "", "getOrObserveData", "Lio/reactivex/subjects/BehaviorSubject;", "Lorg/json/JSONObject;", "registerProducer", "producer", "Lcom/bytedance/android/livehostapi/platform/IMiddlewareHostAction$ILiveSmartClientFeatureProducer;", "runTask", ExifInterface.GPS_DIRECTION_TRUE, "params", "callback", "Lkotlin/Function1;", "resultType", "Ljava/lang/Class;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveSmartClientManager {
    void cancelObserve(String r100);

    BehaviorSubject<JSONObject> getOrObserveData(String r100);

    void registerProducer(IMiddlewareHostAction.ILiveSmartClientFeatureProducer r100);

    <T> void runTask(JSONObject r100, Function1<? super T, Unit> r101, Class<T> r102);
}
