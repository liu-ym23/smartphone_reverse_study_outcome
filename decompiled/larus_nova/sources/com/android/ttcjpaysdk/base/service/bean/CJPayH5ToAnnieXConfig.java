package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/CJPayH5ToAnnieXConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "enable_facepp", "", "wx_h5_pay_config", "Lcom/android/ttcjpaysdk/base/service/bean/WxH5PayConfig;", "(ZLcom/android/ttcjpaysdk/base/service/bean/WxH5PayConfig;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayH5ToAnnieXConfig implements CJPayObject, Serializable {
    public boolean enable_facepp;
    public WxH5PayConfig wx_h5_pay_config;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayH5ToAnnieXConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public CJPayH5ToAnnieXConfig(boolean r100, WxH5PayConfig r101) {
        Intrinsics.checkNotNullParameter(r101, "wx_h5_pay_config");
        this.enable_facepp = r100;
        this.wx_h5_pay_config = r101;
    }

    public /* synthetic */ CJPayH5ToAnnieXConfig(boolean r100, WxH5PayConfig r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r110 = new WxH5PayConfig(null, null, null, false, null, 31, null);
    L8:
        this(r100, r110);
    }
}
