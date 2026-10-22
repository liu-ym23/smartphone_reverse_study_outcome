package ak2;

import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class e implements wd.d, IExternalButton {
    public e() {
    }

    @Override // wd.d, com.bytedance.android.livesdkapi.room.handler.viewinterface.IBaseExternalButton
    public final String getTargetButtonName() {
        return "COMMERCE";
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onHide() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onShow() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public final boolean onTriggerAnimation(long r100) {
        return false;
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // wd.e
    public final void onViewAttached(wd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // wd.e
    public final void onViewWillAttach(wd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        throw new IllegalStateException("should not call getView");
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public final void onBehaviorUpdate(String r100) {
        Intrinsics.checkNotNullParameter(r100, ControlRule.KEY_EXTRA_DATA);
        IExternalButton.DefaultImpls.onBehaviorUpdate(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public final void onShow(ToolbarMatchInterface r100) {
        IExternalButton.DefaultImpls.onShow(this, r100);
    }
}
