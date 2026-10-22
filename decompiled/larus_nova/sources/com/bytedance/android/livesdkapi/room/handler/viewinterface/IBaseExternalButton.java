package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IBaseExternalButton;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalView;", "getButtonViewInMore", "Landroid/view/View;", "getTargetButtonName", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBaseExternalButton extends IExternalView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static View getButtonViewInMore(IBaseExternalButton r100) {
            return null;
        }
    }

    View getButtonViewInMore();

    String getTargetButtonName();
}
