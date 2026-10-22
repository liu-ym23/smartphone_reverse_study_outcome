package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayUntiedBankCardSucceedEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "showToast", "", "toastMsg", "", "(ILjava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayUntiedBankCardSucceedEvent extends BaseEvent {
    public int showToast;
    public String toastMsg;

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayUntiedBankCardSucceedEvent() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public CJPayUntiedBankCardSucceedEvent(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "toastMsg");
        this.showToast = r100;
        this.toastMsg = r101;
    }

    public /* synthetic */ CJPayUntiedBankCardSucceedEvent(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
