package com.android.internal.chooser.widget;

import android.R;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ForwardingListener;
import android.widget.ListView;
import android.widget.MenuPopupWindow;
import android.widget.PopupWindow;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopup;
import com.android.internal.view.menu.MenuPopupHelper;
import com.android.internal.view.menu.ShowableListMenu;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class ChooserPopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    private OnDismissListener mOnDismissListener;
    private final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(ChooserPopupMenu chooserPopupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ChooserPopupMenu(Context context, View anchor) {
        this(context, anchor, 0);
    }

    public ChooserPopupMenu(Context context, View anchor, int gravity) {
        this(context, anchor, gravity, R.attr.popupMenuStyle, 0);
    }

    public ChooserPopupMenu(Context context, View anchor, int gravity, int popupStyleAttr, int popupStyleRes) {
        this.mContext = context;
        this.mAnchor = anchor;
        this.mMenu = new MenuBuilder(context);
        this.mMenu.setCallback(new MenuBuilder.Callback() { // from class: com.android.internal.chooser.widget.ChooserPopupMenu.1
            public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                if (ChooserPopupMenu.this.mMenuItemClickListener != null) {
                    return ChooserPopupMenu.this.mMenuItemClickListener.onMenuItemClick(item);
                }
                return false;
            }

            public void onMenuModeChange(MenuBuilder menu) {
            }
        });
        this.mPopup = new MenuPopupHelper(context, this.mMenu, anchor, false, popupStyleAttr, popupStyleRes);
        this.mPopup.setGravity(gravity);
        this.mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.android.internal.chooser.widget.ChooserPopupMenu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (ChooserPopupMenu.this.mOnDismissListener != null) {
                    ChooserPopupMenu.this.mOnDismissListener.onDismiss(ChooserPopupMenu.this);
                }
            }
        });
    }

    public void setGravity(int gravity) {
        this.mPopup.setGravity(gravity);
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new ForwardingListener(this.mAnchor) { // from class: com.android.internal.chooser.widget.ChooserPopupMenu.3
                protected boolean onForwardingStarted() {
                    ChooserPopupMenu.this.show();
                    return true;
                }

                protected boolean onForwardingStopped() {
                    ChooserPopupMenu.this.dismiss();
                    return true;
                }

                public ShowableListMenu getPopup() {
                    return ChooserPopupMenu.this.mPopup.getPopup();
                }
            };
        }
        return this.mDragListener;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.mContext);
    }

    public void inflate(int menuRes) {
        getMenuInflater().inflate(menuRes, this.mMenu);
    }

    public void show() {
        this.mPopup.show();
        final MenuPopup menuPopup = this.mPopup.getPopup();
        ListView listView = menuPopup.getListView();
        View parentView = (View) listView.getParent();
        if (parentView != null) {
            parentView.setOutlineProvider(new ViewOutlineProvider(this) { // from class: com.android.internal.chooser.widget.ChooserPopupMenu.4
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) throws NoSuchFieldException {
                    float radius;
                    try {
                        Field field = Class.forName("com.android.internal.view.menu.StandardMenuPopup").getDeclaredField("mPopup");
                        field.setAccessible(true);
                        MenuPopupWindow popupWindow = (MenuPopupWindow) field.get(menuPopup);
                        Drawable drawable = popupWindow.getBackground();
                        if (drawable == null) {
                            radius = 0.0f;
                        } else {
                            try {
                                Outline bgOutline = new Outline();
                                drawable.getOutline(bgOutline);
                                float radius2 = bgOutline.getRadius();
                                radius = radius2;
                            } catch (Exception e) {
                                return;
                            }
                        }
                        try {
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                    }
                }
            });
            parentView.setClipToOutline(true);
        }
    }

    public void show(int x, int y) {
        this.mPopup.getPopup().setHorizontalOffset(x);
        this.mPopup.getPopup().setVerticalOffset(y);
        this.mPopup.show();
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.mMenuItemClickListener = listener;
    }

    public void setOnDismissListener(OnDismissListener listener) {
        this.mOnDismissListener = listener;
    }

    public void setForceShowIcon(boolean forceShowIcon) {
        this.mPopup.setForceShowIcon(forceShowIcon);
    }

    public ListView getMenuListView() {
        if (!this.mPopup.isShowing()) {
            return null;
        }
        return this.mPopup.getPopup().getListView();
    }
}
