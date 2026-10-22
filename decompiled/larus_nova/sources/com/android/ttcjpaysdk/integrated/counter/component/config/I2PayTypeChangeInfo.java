package com.android.ttcjpaysdk.integrated.counter.component.config;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PayComponentBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/I2PayTypeChangeInfo;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "", "toPayTypeChangeInfo", "componentBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "(Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;)Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface I2PayTypeChangeInfo<T extends IPayTypeChangeInfo> {
    T toPayTypeChangeInfo(PayComponentBean r100);
}
