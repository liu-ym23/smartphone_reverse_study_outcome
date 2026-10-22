package com.bytedance.android.livehostapi.business.depend.livead;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdLandingPageDialogFragment;", "", "dismiss", "", "getDialogFragment", "Landroidx/fragment/app/DialogFragment;", "isShowing", "", "setListener", "listener", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdLandingPageDialogFragment$Listener;", "show", "Listener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAdLandingPageDialogFragment {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveAdLandingPageDialogFragment$Listener;", "", "onDismiss", "", SendEventContainerMethodParamModel.EventKinds.onShow, "status", "", "onShowFail", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Listener {
        void onDismiss();

        void onShow(int r100);

        void onShowFail();
    }

    void dismiss();

    @Deprecated(message = "方法已废弃")
    DialogFragment getDialogFragment();

    boolean isShowing();

    void setListener(Listener r100);

    void show();
}
