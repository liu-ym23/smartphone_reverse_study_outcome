package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes2.dex */
class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private MenuPresenter.Callback mPresenterCallback;

    public void dismiss() {
        AlertDialog r100 = this.mDialog;
        if (r100 == null) goto L6;
        INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r100);
        return;
    }

    public MenuDialogHelper(MenuBuilder r100) {
        this.mMenu = r100;
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder r100) {
        MenuPresenter.Callback r101 = this.mPresenterCallback;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.onOpenSubMenu(r100);
    }

    public void setPresenterCallback(MenuPresenter.Callback r100) {
        this.mPresenterCallback = r100;
    }

    public void show(IBinder r100) {
        MenuBuilder r101 = this.mMenu;
        AlertDialog.Builder r102 = new AlertDialog.Builder(r101.getContext());
        ListMenuPresenter r103 = new ListMenuPresenter(r102.getContext(), R.layout.abc_list_menu_item_layout);
        this.mPresenter = r103;
        r103.setCallback(this);
        this.mMenu.addMenuPresenter(this.mPresenter);
        r102.setAdapter(this.mPresenter.getAdapter(), this);
        View r104 = r101.getHeaderView();
        if (r104 == null) goto L5;
        r102.setCustomTitle(r104);
    L6:
        r102.setOnKeyListener(this);
        AlertDialog r105 = r102.create();
        this.mDialog = r105;
        r105.setOnDismissListener(this);
        WindowManager.LayoutParams r106 = this.mDialog.getWindow().getAttributes();
        r106.type = 1003;
        if (r100 == null) goto L9;
        r106.token = r100;
    L9:
        r106.flags |= 131072;
        INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.mDialog);
        return;
    L5:
        r102.setIcon(r101.getHeaderIcon()).setTitle(r101.getHeaderTitle());
        goto L6
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r100, int r101) {
        this.mMenu.performItemAction((MenuItemImpl) this.mPresenter.getAdapter().getItem(r101), 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder r100, boolean r101) {
        if (r101 == false) goto L4;
    L5:
        dismiss();
    L6:
        MenuPresenter.Callback r102 = this.mPresenterCallback;
        if (r102 == null) goto L10;
        r102.onCloseMenu(r100, r101);
        return;
    L10:
        return;
    L4:
        if (r100 != this.mMenu) goto L6;
        goto L5
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 == 82) goto L7;
        if (r101 == 4) goto L7;
    L33:
        return this.mMenu.performShortcut(r101, r102, 0);
    L7:
        if (r102.getAction() != 0) goto L19;
        if (r102.getRepeatCount() != 0) goto L19;
        Window r103 = this.mDialog.getWindow();
        if (r103 == null) goto L33;
        View r104 = INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103);
        if (r104 == null) goto L33;
        KeyEvent.DispatcherState r105 = r104.getKeyDispatcherState();
        if (r105 == null) goto L33;
        r105.startTracking(r102, this);
        return true;
    L19:
        if (r102.getAction() != 1) goto L33;
        if (r102.isCanceled() == true) goto L33;
        Window r106 = this.mDialog.getWindow();
        if (r106 == null) goto L33;
        View r107 = INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r106);
        if (r107 == null) goto L33;
        KeyEvent.DispatcherState r108 = r107.getKeyDispatcherState();
        if (r108 == null) goto L33;
        if (r108.isTracking(r102) == false) goto L33;
        this.mMenu.close(true);
        r100.dismiss();
        return true;
    }
}
