package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IExternalButton;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/IBaseExternalButton;", "onBehaviorUpdate", "", ControlRule.KEY_EXTRA_DATA, "", SendEventContainerMethodParamModel.EventKinds.onShow, "data", "Lcom/bytedance/android/livesdkapi/room/handler/toolbar/ToolbarMatchInterface;", "onTriggerAnimation", "", "callbackTime", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalButton extends IBaseExternalButton {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static View getButtonViewInMore(IExternalButton r100) {
            return IBaseExternalButton.DefaultImpls.getButtonViewInMore(r100);
        }

        public static void onBehaviorUpdate(IExternalButton r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, ControlRule.KEY_EXTRA_DATA);
        }

        public static void onShow(IExternalButton r100, ToolbarMatchInterface r101) {
        }

        public static boolean onTriggerAnimation(IExternalButton r100, long r101) {
            return false;
        }
    }

    void onBehaviorUpdate(String r100);

    void onShow(ToolbarMatchInterface r100);

    boolean onTriggerAnimation(long r100);
}
