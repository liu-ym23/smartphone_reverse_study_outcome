package com.android.ttcjpaysdk.integrated.counter.component;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.ui.widget.PayComponentView;
import com.android.ttcjpaysdk.integrated.counter.component.config.IDYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.logger.PayComponentLogger;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.component.view.IPayTypeParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000* \b\u0000\u0010\u0001*\u001a\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00022\u00020\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u001f\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH&J3\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t0\u0014H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u000f\u0010\u001b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u001cJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010!H&¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/IComponentProxy;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayTypeConfig;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayType;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IDYPayType;", "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "", "bindDefault", "bindView", "", "payTypeConfig", "showType", "Lcom/android/ttcjpaysdk/integrated/counter/component/logger/PayComponentLogger$ShowType;", "(Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayTypeConfig;Lcom/android/ttcjpaysdk/integrated/counter/component/logger/PayComponentLogger$ShowType;)V", "bindViewWhitChangeInfo", "payTypeChangeInfo", "confirm", "invokeData", "Lorg/json/JSONObject;", "onReady", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "clientSessionId", "getCurComponentView", "Lcom/android/ttcjpaysdk/base/ui/widget/PayComponentView$IComponentView;", "getCurPayTypeConfig", "()Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayTypeConfig;", "getPayTypeParams", "Lcom/android/ttcjpaysdk/integrated/counter/component/view/IPayTypeParams;", "setCallback", "callback", "Lcom/android/ttcjpaysdk/integrated/counter/component/ICallback;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IComponentProxy<T extends IPayTypeConfig<? extends IPayType, ? extends IDYPayType, ? extends IPayTypeChangeInfo>> {
    IComponentProxy<T> bindDefault();

    void bindView(T r100, PayComponentLogger.ShowType r101);

    void bindViewWhitChangeInfo(IPayTypeChangeInfo r100, PayComponentLogger.ShowType r101);

    void confirm(JSONObject r100, Function1<? super String, Unit> r101);

    PayComponentView.IComponentView getCurComponentView();

    T getCurPayTypeConfig();

    IPayTypeParams getPayTypeParams();

    IComponentProxy<T> setCallback(ICallback<T> r100);
}
