package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayDcGeckoConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "cache_expire_days", "", "check_cache_min_gap_days", "check_delay_time", "switch", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDcGeckoConfig implements CJPayObject, Serializable {
    public long cache_expire_days;
    public long check_cache_min_gap_days;
    public long check_delay_time;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    public String f51switch;

    public CJPayDcGeckoConfig() {
        this.check_delay_time = 30;
        this.cache_expire_days = 30;
        this.check_cache_min_gap_days = 3;
        this.f51switch = "0";
    }
}
