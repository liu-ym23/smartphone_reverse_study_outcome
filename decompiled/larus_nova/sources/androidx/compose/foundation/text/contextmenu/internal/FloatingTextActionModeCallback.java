package androidx.compose.foundation.text.contextmenu.internal;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.api.creation.TplType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/FloatingTextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "Landroid/view/ActionMode$Callback;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;)V", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", TplType.MENU, "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", MapController.ITEM_LAYER_TAG, "Landroid/view/MenuItem;", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FloatingTextActionModeCallback extends ActionMode.Callback2 implements ActionMode.Callback {
    private final TextActionModeCallback textActionModeCallback;

    public FloatingTextActionModeCallback(TextActionModeCallback r100) {
        this.textActionModeCallback = r100;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r100) {
        this.textActionModeCallback.onDestroyActionMode(r100);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        return this.textActionModeCallback.onActionItemClicked(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return this.textActionModeCallback.onCreateActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return this.textActionModeCallback.onPrepareActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode r100, View r101, Rect r102) {
        androidx.compose.ui.geometry.Rect r103 = this.textActionModeCallback.onGetContentRect(r100, r101);
        r102.set(Math.round(r103.getLeft()), Math.round(r103.getTop()), Math.round(r103.getRight()), Math.round(r103.getBottom()));
    }
}
