package com.android.ttcjpaysdk.integrated.sign.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/Theme;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "trade_name_color", "", "getTrade_name_color", "()Ljava/lang/String;", "setTrade_name_color", "(Ljava/lang/String;)V", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Theme implements CJPayObject {
    private String trade_name_color;

    public Theme() {
    }

    public final String getTrade_name_color() {
        return this.trade_name_color;
    }

    public final void setTrade_name_color(String r100) {
        this.trade_name_color = r100;
    }
}
