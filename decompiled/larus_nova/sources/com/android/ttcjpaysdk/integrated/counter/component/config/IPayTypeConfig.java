package com.android.ttcjpaysdk.integrated.counter.component.config;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.integrated.counter.component.config.IDYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayType;
import com.android.ttcjpaysdk.integrated.counter.component.logger.ILogPayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PayComponentBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00050\u00072\u00020\bJ\r\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\r\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\r\u0010\u0014\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayTypeConfig;", "C", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayType;", "D", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/IDYPayType;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/integrated/counter/component/lynx/IPayTypeChangeInfo;", "Lcom/android/ttcjpaysdk/integrated/counter/component/config/I2PayTypeChangeInfo;", "Lcom/android/ttcjpaysdk/integrated/counter/component/logger/ILogPayTypeConfig;", "buildAliPayConfig", "()Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayType;", "buildDYConfig", "dyPayTypeConfig", "(Lcom/android/ttcjpaysdk/integrated/counter/component/config/IDYPayType;)Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayType;", "buildDefaultConfig", "payComponentBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "(Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;)Lcom/android/ttcjpaysdk/integrated/counter/component/config/IPayType;", "buildFundPayConfig", "buildSuperPayConfig", "buildWXConfig", "buildWithChangeInfo", "", "payTypeChangeInfo", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPayTypeConfig<C extends IPayType, D extends IDYPayType, T extends IPayTypeChangeInfo> extends I2PayTypeChangeInfo<T>, ILogPayTypeConfig {
    C buildAliPayConfig();

    C buildDYConfig(D r100);

    C buildDefaultConfig(PayComponentBean r100);

    C buildFundPayConfig();

    C buildSuperPayConfig();

    C buildWXConfig();

    void buildWithChangeInfo(PayComponentBean r100, IPayTypeChangeInfo r101);
}
