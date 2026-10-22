package com.android.ttcjpaysdk.facelive.core;

import android.app.Activity;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.event.CJBackToPayHomeEvent;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.facelive.data.GetTicketResponse;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/core/FaceLiveDefaultImpl;", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive;", "()V", "doFace", "", "activity", "Landroid/app/Activity;", "ticketResponse", "Lcom/android/ttcjpaysdk/facelive/data/GetTicketResponse;", "extra", "Lcom/android/ttcjpaysdk/facelive/core/IFaceLive$IExtra;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceLiveDefaultImpl implements IFaceLive {
    public FaceLiveDefaultImpl() {
    }

    @Override // com.android.ttcjpaysdk.facelive.core.IFaceLive
    public void doFace(Activity r100, GetTicketResponse r101, IFaceLive.IExtra r102) {
        Intrinsics.checkNotNullParameter(r101, "ticketResponse");
        if (r100 == null) goto L5;
        String r103 = r100.getString(R.string.cj_pay_server_error_toast);
    L6:
        CJPayBasicUtils.displayToast(r100, r103);
        EventManager.INSTANCE.notifyLast(new CJBackToPayHomeEvent(false, 1, null));
        return;
    L5:
        r103 = null;
        goto L6
    }
}
