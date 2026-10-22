package androidx.compose.ui.platform;

import android.os.Build;
import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.PrimaryTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J`\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0016JP\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/platform/AndroidTextToolbar;", "Landroidx/compose/ui/platform/TextToolbar;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "actionMode", "Landroid/view/ActionMode;", "textActionModeCallback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "value", "Landroidx/compose/ui/platform/TextToolbarStatus;", "status", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "showMenu", "", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "hide", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidTextToolbar implements TextToolbar {
    public static final int $stable = 8;
    private ActionMode actionMode;
    private TextToolbarStatus status;
    private final TextActionModeCallback textActionModeCallback;
    private final View view;

    @Override // androidx.compose.ui.platform.TextToolbar
    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode r100 = this.actionMode;
        if (r100 == null) goto L5;
        r100.finish();
    L5:
        this.actionMode = null;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public TextToolbarStatus getStatus() {
        return this.status;
    }

    public AndroidTextToolbar(View r110) {
        this.view = r110;
        this.textActionModeCallback = new TextActionModeCallback(new AndroidTextToolbar$textActionModeCallback$1(this), null, null, null, null, null, null, 126, null);
        this.status = TextToolbarStatus.Hidden;
    }

    public static final /* synthetic */ void access$setActionMode$p(AndroidTextToolbar r100, ActionMode r101) {
        r100.actionMode = r101;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void showMenu(Rect r100, Function0<Unit> r101, Function0<Unit> r110, Function0<Unit> r111, Function0<Unit> r112) {
        showMenu(r100, r101, r110, r111, r112, null);
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void showMenu(Rect r100, Function0<Unit> r101, Function0<Unit> r102, Function0<Unit> r103, Function0<Unit> r104, Function0<Unit> r105) {
        this.textActionModeCallback.setRect(r100);
        this.textActionModeCallback.setOnCopyRequested(r101);
        this.textActionModeCallback.setOnCutRequested(r103);
        this.textActionModeCallback.setOnPasteRequested(r102);
        this.textActionModeCallback.setOnSelectAllRequested(r104);
        this.textActionModeCallback.setOnAutofillRequested(r105);
        ActionMode r106 = this.actionMode;
        if (r106 != null) goto L9;
        this.status = TextToolbarStatus.Shown;
        if (Build.VERSION.SDK_INT < 23) goto L7;
        ActionMode r107 = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1);
    L8:
        this.actionMode = r107;
        return;
    L7:
        r107 = this.view.startActionMode(new PrimaryTextActionModeCallback(this.textActionModeCallback));
        goto L8
    L9:
        if (r106 == null) goto L13;
        r106.invalidate();
        return;
    }
}
