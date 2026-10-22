package ak2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements wd.d, IExternalButton {
    public a() {
    }

    @Override // wd.d, com.bytedance.android.livesdkapi.room.handler.viewinterface.IBaseExternalButton
    public View getButtonViewInMore() {
        return null;
    }

    public abstract Context getContext();

    public abstract View getRealView();

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    @Deprecated(message = "使用 onViewWillDetach 替代", replaceWith = @ReplaceWith(expression = "onViewWillDetach()", imports = {}))
    public void onHide() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onLoad() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    @Deprecated(message = "使用 onViewAttached 替代", replaceWith = @ReplaceWith(expression = "onViewAttached()", imports = {}))
    public void onShow() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public boolean onTriggerAnimation(long r100) {
        return false;
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onUnload() {
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewDetached() {
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // wd.e
    public void onViewWillAttach(wd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewWillDetach() {
    }

    public abstract void setRealView(View r100);

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public void onBehaviorUpdate(String r100) {
        Intrinsics.checkNotNullParameter(r100, ControlRule.KEY_EXTRA_DATA);
        Intrinsics.checkNotNullParameter(r100, ControlRule.KEY_EXTRA_DATA);
        IExternalButton.DefaultImpls.onBehaviorUpdate(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton
    public void onShow(ToolbarMatchInterface r100) {
        IExternalButton.DefaultImpls.onShow(this, r100);
    }
}
