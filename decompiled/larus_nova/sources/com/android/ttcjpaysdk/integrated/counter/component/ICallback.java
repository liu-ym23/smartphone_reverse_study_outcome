package com.android.ttcjpaysdk.integrated.counter.component;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.integrated.counter.component.config.IDYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.logger.PayComponentLogger;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.component.view.SelectFrom;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000* \b\u0000\u0010\u0001*\u001a\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00022\u00020\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/ICallback;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayTypeConfig;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayType;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IDYPayType;", "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "", "getContext", "Landroid/app/Activity;", "onPayTypeChange", "", "componentViewProxy", "Lcom/android/ttcjpaysdk/integrated/counter/component/IComponentProxy;", "showType", "Lcom/android/ttcjpaysdk/integrated/counter/component/logger/PayComponentLogger$ShowType;", "onSelectPayType", "selectFrom", "Lcom/android/ttcjpaysdk/integrated/counter/component/view/SelectFrom;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICallback<T extends IPayTypeConfig<? extends IPayType, ? extends IDYPayType, ? extends IPayTypeChangeInfo>> {
    Activity getContext();

    void onPayTypeChange(IComponentProxy<T> r100, PayComponentLogger.ShowType r101);

    void onSelectPayType(IComponentProxy<T> r100, SelectFrom r101);
}
