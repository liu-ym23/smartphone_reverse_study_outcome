package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu r100);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r100);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener != null) goto L6;
        final View r100 = this.mAnchor;
        this.mDragListener = new AnonymousClass3(this, r100);
    L6:
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    public ListView getMenuListView() {
        if (this.mPopup.isShowing() == true) goto L7;
        return null;
    L7:
        return this.mPopup.getListView();
    }

    public void show() {
        this.mPopup.show();
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public void inflate(int r100) {
        getMenuInflater().inflate(r100, this.mMenu);
    }

    public void setGravity(int r100) {
        this.mPopup.setGravity(r100);
    }

    public void setOnDismissListener(OnDismissListener r100) {
        this.mOnDismissListener = r100;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r100) {
        this.mMenuItemClickListener = r100;
    }

    public PopupMenu(Context r100, View r101) {
        this(r100, r101, 0);
    }

    public PopupMenu(Context r100, View r101, int r102) {
        this(r100, r101, r102, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context r100, View r110, int r111, int r112, int r113) {
        this.mContext = r100;
        this.mAnchor = r110;
        MenuBuilder r101 = new MenuBuilder(r100);
        this.mMenu = r101;
        r101.setCallback(new AnonymousClass1(this));
        MenuPopupHelper r102 = new MenuPopupHelper(r100, r101, r110, false, r112, r113);
        this.mPopup = r102;
        r102.setGravity(r111);
        r102.setOnDismissListener(new AnonymousClass2(this));
    }
}
