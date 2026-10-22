package androidx.compose.ui.platform.actionmodecallback;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.api.creation.TplType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/FloatingTextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "callback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "<init>", "(Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;)V", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", MapController.ITEM_LAYER_TAG, "Landroid/view/MenuItem;", "onCreateActionMode", TplType.MENU, "Landroid/view/Menu;", "onPrepareActionMode", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatingTextActionModeCallback extends ActionMode.Callback2 {
    public static final int $stable = 8;
    private final TextActionModeCallback callback;

    public FloatingTextActionModeCallback(TextActionModeCallback r100) {
        this.callback = r100;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r100) {
        this.callback.onDestroyActionMode();
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        return this.callback.onActionItemClicked(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return this.callback.onCreateActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return this.callback.onPrepareActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode r100, View r101, Rect r102) {
        androidx.compose.ui.geometry.Rect r103 = this.callback.getRect();
        if (r102 == null) goto L6;
        r102.set((int) r103.getLeft(), (int) r103.getTop(), (int) r103.getRight(), (int) r103.getBottom());
        return;
    }
}
