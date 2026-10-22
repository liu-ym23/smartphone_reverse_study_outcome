package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import com.obric.capabilitykit.common.UiType;

/* JADX INFO: loaded from: classes.dex */
public class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MenuBuilder f563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.a f564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MenuPresenter.Callback f566d;

    public f(MenuBuilder r10) {
        this.f563a = r10;
    }

    public void a() {
        androidx.appcompat.app.a r10 = this.f564b;
        if (r10 == null) goto L6;
        r10.dismiss();
        return;
    }

    public void b(IBinder r10) {
        MenuBuilder r11 = this.f563a;
        androidx.appcompat.app.a.C0006a r12 = new androidx.appcompat.app.a.C0006a(r11.getContext());
        d r13 = new d(r12.getContext(), R$layout.abc_list_menu_item_layout);
        this.f565c = r13;
        r13.setCallback(this);
        this.f563a.addMenuPresenter(this.f565c);
        r12.setAdapter(this.f565c.a(), this);
        View r14 = r11.getHeaderView();
        if (r14 == null) goto L5;
        r12.setCustomTitle(r14);
    L6:
        r12.setOnKeyListener(this);
        androidx.appcompat.app.a r15 = r12.create();
        this.f564b = r15;
        r15.setOnDismissListener(this);
        WindowManager.LayoutParams r16 = this.f564b.getWindow().getAttributes();
        r16.type = 1003;
        if (r10 == null) goto L9;
        r16.token = r10;
    L9:
        r16.flags |= UiType.FLAG_PHONE_CARD;
        this.f564b.show();
        return;
    L5:
        r12.setIcon(r11.getHeaderIcon()).setTitle(r11.getHeaderTitle());
        goto L6
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r10, int r11) {
        this.f563a.performItemAction((g) this.f565c.a().getItem(r11), 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        if (r11 == false) goto L4;
    L5:
        a();
    L6:
        MenuPresenter.Callback r12 = this.f566d;
        if (r12 == null) goto L10;
        r12.onCloseMenu(r10, r11);
        return;
    L10:
        return;
    L4:
        if (r10 != this.f563a) goto L6;
        goto L5
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r10) {
        this.f565c.onCloseMenu(this.f563a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r10, int r11, KeyEvent r12) {
        if (r11 == 82) goto L7;
        if (r11 == 4) goto L7;
    L33:
        return this.f563a.performShortcut(r11, r12, 0);
    L7:
        if (r12.getAction() != 0) goto L19;
        if (r12.getRepeatCount() != 0) goto L19;
        Window r13 = this.f564b.getWindow();
        if (r13 == null) goto L33;
        View r14 = r13.getDecorView();
        if (r14 == null) goto L33;
        KeyEvent.DispatcherState r15 = r14.getKeyDispatcherState();
        if (r15 == null) goto L33;
        r15.startTracking(r12, this);
        return true;
    L19:
        if (r12.getAction() != 1) goto L33;
        if (r12.isCanceled() == true) goto L33;
        Window r16 = this.f564b.getWindow();
        if (r16 == null) goto L33;
        View r17 = r16.getDecorView();
        if (r17 == null) goto L33;
        KeyEvent.DispatcherState r18 = r17.getKeyDispatcherState();
        if (r18 == null) goto L33;
        if (r18.isTracking(r12) == false) goto L33;
        this.f563a.close(true);
        r10.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder r10) {
        MenuPresenter.Callback r11 = this.f566d;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.onOpenSubMenu(r10);
    }
}
