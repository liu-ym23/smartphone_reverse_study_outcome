package com.bytedance.android.livesdkapi.publicscreen;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/publicscreen/AbsPublicScreenBottomWidget;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/AbsExternalWidget;", "()V", "<set-?>", "", "biz", "getBiz", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdkapi/publicscreen/IPublicScreenBottomListener;", "callback", "getCallback", "()Lcom/bytedance/android/livesdkapi/publicscreen/IPublicScreenBottomListener;", "getBusinessName", "onInit", "", "cardBiz", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsPublicScreenBottomWidget extends AbsExternalWidget {
    private String biz;
    private IPublicScreenBottomListener callback;

    public abstract String getBusinessName();

    public void onInit() {
    }

    public AbsPublicScreenBottomWidget() {
    }

    public final String getBiz() {
        return this.biz;
    }

    public final IPublicScreenBottomListener getCallback() {
        return this.callback;
    }

    public final void onInit(String r100, IPublicScreenBottomListener r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.biz = r100;
        this.callback = r101;
        onInit();
    }
}
