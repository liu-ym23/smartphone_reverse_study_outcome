package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayBalanceRechargeOrWithdrawConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "dark", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayBalanceRechargeOrWithdrawConfig$CJPayBalanceThemeResourceObj;", "light", "CJPayBalanceThemeResourceObj", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBalanceRechargeOrWithdrawConfig implements CJPayObject, Serializable {
    public CJPayBalanceThemeResourceObj dark;
    public CJPayBalanceThemeResourceObj light;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayBalanceRechargeOrWithdrawConfig$CJPayBalanceThemeResourceObj;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "result_page_bg", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayBalanceThemeResourceObj implements CJPayObject, Serializable {
        public String result_page_bg;

        public CJPayBalanceThemeResourceObj() {
        }
    }

    public CJPayBalanceRechargeOrWithdrawConfig() {
        this.light = new CJPayBalanceThemeResourceObj();
        this.dark = new CJPayBalanceThemeResourceObj();
    }
}
