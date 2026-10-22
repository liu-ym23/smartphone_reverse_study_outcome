package androidx.compose.ui.platform.actionmodecallback;

import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.api.creation.TplType;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B}\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u001a\u0010%\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u001a\u0010&\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010'\u001a\u0004\u0018\u00010(J\u0006\u0010)\u001a\u00020\u0004J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b+J\u001d\u0010,\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020-H\u0000¢\u0006\u0002\b.J(\u0010/\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020-2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0016R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0016R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0016¨\u00061"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "", "onActionModeDestroy", "Lkotlin/Function0;", "", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnActionModeDestroy", "()Lkotlin/jvm/functions/Function0;", "getRect", "()Landroidx/compose/ui/geometry/Rect;", "setRect", "(Landroidx/compose/ui/geometry/Rect;)V", "getOnCopyRequested", "setOnCopyRequested", "(Lkotlin/jvm/functions/Function0;)V", "getOnPasteRequested", "setOnPasteRequested", "getOnCutRequested", "setOnCutRequested", "getOnSelectAllRequested", "setOnSelectAllRequested", "getOnAutofillRequested", "setOnAutofillRequested", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", TplType.MENU, "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", MapController.ITEM_LAYER_TAG, "Landroid/view/MenuItem;", "onDestroyActionMode", "updateMenuItems", "updateMenuItems$ui_release", "addMenuItem", "Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "addMenuItem$ui_release", "addOrRemoveMenuItem", "callback", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextActionModeCallback {
    public static final int $stable = 8;
    private final Function0<Unit> onActionModeDestroy;
    private Function0<Unit> onAutofillRequested;
    private Function0<Unit> onCopyRequested;
    private Function0<Unit> onCutRequested;
    private Function0<Unit> onPasteRequested;
    private Function0<Unit> onSelectAllRequested;
    private Rect rect;

    public TextActionModeCallback() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final void onDestroyActionMode() {
        Function0<Unit> r100 = this.onActionModeDestroy;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public final Function0<Unit> getOnActionModeDestroy() {
        return this.onActionModeDestroy;
    }

    public final Function0<Unit> getOnAutofillRequested() {
        return this.onAutofillRequested;
    }

    public final Function0<Unit> getOnCopyRequested() {
        return this.onCopyRequested;
    }

    public final Function0<Unit> getOnCutRequested() {
        return this.onCutRequested;
    }

    public final Function0<Unit> getOnPasteRequested() {
        return this.onPasteRequested;
    }

    public final Function0<Unit> getOnSelectAllRequested() {
        return this.onSelectAllRequested;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final void setOnAutofillRequested(Function0<Unit> r100) {
        this.onAutofillRequested = r100;
    }

    public final void setOnCopyRequested(Function0<Unit> r100) {
        this.onCopyRequested = r100;
    }

    public final void setOnCutRequested(Function0<Unit> r100) {
        this.onCutRequested = r100;
    }

    public final void setOnPasteRequested(Function0<Unit> r100) {
        this.onPasteRequested = r100;
    }

    public final void setOnSelectAllRequested(Function0<Unit> r100) {
        this.onSelectAllRequested = r100;
    }

    public final void setRect(Rect r100) {
        this.rect = r100;
    }

    public final void updateMenuItems$ui_release(Menu r100) {
        addOrRemoveMenuItem(r100, MenuItemOption.Copy, this.onCopyRequested);
        addOrRemoveMenuItem(r100, MenuItemOption.Paste, this.onPasteRequested);
        addOrRemoveMenuItem(r100, MenuItemOption.Cut, this.onCutRequested);
        addOrRemoveMenuItem(r100, MenuItemOption.SelectAll, this.onSelectAllRequested);
        addOrRemoveMenuItem(r100, MenuItemOption.Autofill, this.onAutofillRequested);
    }

    public final void addMenuItem$ui_release(Menu r100, MenuItemOption r101) {
        r100.add(0, r101.getId(), r101.getOrder(), r101.getTitleResource()).setShowAsAction(1);
    }

    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        Intrinsics.checkNotNull(r101);
        int r102 = r101.getItemId();
        if (r102 != MenuItemOption.Copy.getId()) goto L8;
        Function0<Unit> r103 = this.onCopyRequested;
        if (r103 == null) goto L27;
        r103.invoke();
    L27:
        if (r100 == null) goto L33;
        r100.finish();
        return true;
    L33:
        return true;
    L8:
        if (r102 != MenuItemOption.Paste.getId()) goto L13;
        Function0<Unit> r104 = this.onPasteRequested;
        if (r104 == null) goto L27;
        r104.invoke();
        goto L27
    L13:
        if (r102 != MenuItemOption.Cut.getId()) goto L18;
        Function0<Unit> r105 = this.onCutRequested;
        if (r105 == null) goto L27;
        r105.invoke();
        goto L27
    L18:
        if (r102 != MenuItemOption.SelectAll.getId()) goto L23;
        Function0<Unit> r106 = this.onSelectAllRequested;
        if (r106 == null) goto L27;
        r106.invoke();
        goto L27
    L23:
        if (r102 != MenuItemOption.Autofill.getId()) goto L31;
        Function0<Unit> r107 = this.onAutofillRequested;
        if (r107 == null) goto L27;
        r107.invoke();
        goto L27
    L31:
        return false;
    }

    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        if (r101 == null) goto L26;
        if (r100 == null) goto L24;
        if (this.onCopyRequested == null) goto L8;
        addMenuItem$ui_release(r101, MenuItemOption.Copy);
    L8:
        if (this.onPasteRequested == null) goto L11;
        addMenuItem$ui_release(r101, MenuItemOption.Paste);
    L11:
        if (this.onCutRequested == null) goto L14;
        addMenuItem$ui_release(r101, MenuItemOption.Cut);
    L14:
        if (this.onSelectAllRequested == null) goto L17;
        addMenuItem$ui_release(r101, MenuItemOption.SelectAll);
    L17:
        if (this.onAutofillRequested != null) goto L19;
        return true;
    L19:
        if (Build.VERSION.SDK_INT < 26) goto L28;
        addMenuItem$ui_release(r101, MenuItemOption.Autofill);
        return true;
    L28:
        return true;
    L24:
        throw new IllegalArgumentException("onCreateActionMode requires a non-null mode".toString());
    L26:
        throw new IllegalArgumentException("onCreateActionMode requires a non-null menu".toString());
    }

    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        updateMenuItems$ui_release(r101);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    private final void addOrRemoveMenuItem(Menu r100, MenuItemOption r101, Function0<Unit> r102) {
        if (r102 != null) goto L4;
    L6:
        if (r102 == null) goto L8;
        return;
    L8:
        if (r100.findItem(r101.getId()) == null) goto L13;
        r100.removeItem(r101.getId());
        return;
    L13:
        return;
    L4:
        if (r100.findItem(r101.getId()) != null) goto L6;
        addMenuItem$ui_release(r100, r101);
    }

    public TextActionModeCallback(Function0<Unit> r100, Rect r101, Function0<Unit> r102, Function0<Unit> r103, Function0<Unit> r104, Function0<Unit> r105, Function0<Unit> r106) {
        this.onActionModeDestroy = r100;
        this.rect = r101;
        this.onCopyRequested = r102;
        this.onPasteRequested = r103;
        this.onCutRequested = r104;
        this.onSelectAllRequested = r105;
        this.onAutofillRequested = r106;
    }

    public /* synthetic */ TextActionModeCallback(Function0 r100, Rect r101, Function0 r102, Function0 r110, Function0 r111, Function0 r112, Function0 r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Function0 r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        r101 = Rect.Companion.getZero();
    L9:
        Rect r103 = r101;
        if ((r114 & 4) == 0) goto L12;
        Function0 r104 = null;
    L14:
        if ((r114 & 8) == 0) goto L16;
        Function0 r105 = null;
    L18:
        if ((r114 & 16) == 0) goto L20;
        Function0 r106 = null;
    L22:
        if ((r114 & 32) == 0) goto L24;
        Function0 r107 = null;
    L26:
        if ((r114 & 64) == 0) goto L28;
        Function0 r117 = null;
    L29:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L24:
        r107 = r112;
        goto L26
    L20:
        r106 = r111;
        goto L22
    L16:
        r105 = r110;
        goto L18
    L12:
        r104 = r102;
        goto L14
    L5:
        r116 = r100;
        goto L7
    }
}
