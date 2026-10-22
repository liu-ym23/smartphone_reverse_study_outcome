package com.android.ttcjpaysdk.integrated.sign.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/CashDeskShowConf;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "confirm_btn_desc", "", "left_time_s", "", "query_result_time_s", "remain_time_s", "theme", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/Theme;", "trade_desc", "whether_show_left_time", "", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CashDeskShowConf implements CJPayObject {
    public String confirm_btn_desc;
    public long left_time_s;
    public long query_result_time_s;
    public long remain_time_s;
    public Theme theme;
    public String trade_desc;
    public boolean whether_show_left_time;

    public CashDeskShowConf() {
        this.confirm_btn_desc = "";
        this.theme = new Theme();
        this.trade_desc = "";
    }
}
