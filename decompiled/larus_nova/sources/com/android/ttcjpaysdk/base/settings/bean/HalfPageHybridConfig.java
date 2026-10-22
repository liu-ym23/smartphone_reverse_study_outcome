package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/HalfPageHybridConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "close_timeout", "", "(I)V", "getCloseTimeout", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HalfPageHybridConfig implements CJPayObject, Serializable {
    public int close_timeout;

    public HalfPageHybridConfig() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final long getCloseTimeout() {
        return ((long) this.close_timeout) * 1000;
    }

    public HalfPageHybridConfig(int r100) {
        this.close_timeout = r100;
    }

    public /* synthetic */ HalfPageHybridConfig(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 5;
    L5:
        this(r100);
    }
}
