package com.android.ttcjpaysdk.bdpay.counter.outer.customView;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/customView/SwitchListener;", "", "changeState", "", "isChecked", "", "reportEvent", "eventName", "", "params", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SwitchListener {
    void changeState(boolean r100);

    void reportEvent(String r100, Map<String, ? extends Object> r101);
}
