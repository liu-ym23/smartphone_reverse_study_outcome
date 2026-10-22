package ak2;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class b implements q {
    public b() {
    }

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

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
    }

    @Override // wd.e
    public void onViewAttached(wd.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
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
}
