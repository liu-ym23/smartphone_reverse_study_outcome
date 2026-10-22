package obric.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class BottomMenuPopupWindow extends PopupWindow implements View.OnClickListener {
    public static final int MENU_ITEM_COLUMN = 4;
    public static final int MENU_ITEM_COLUMN_LAND = 3;
    private Animation mAnimation;
    private ColorDrawable mBackground;
    private BottomMenuPopupAdapter mBrowserMenuPopupAdapter;
    private Context mContext;
    private int mCustomNumColumn;
    protected GridView mGridView;
    boolean mIsLand;
    private View mParentPanel;

    static /* synthetic */ Animation access$002(BottomMenuPopupWindow r0, Animation r1) {
        r0.mAnimation = r1;
        return r1;
    }

    static /* synthetic */ void access$101(BottomMenuPopupWindow r0) {
        super.dismiss();
    }

    public BottomMenuPopupWindow(Context context) {
        super(context);
        initLayout(context);
    }

    protected void initLayout(Context context) {
        this.mContext = context;
        ColorDrawable r1 = new ColorDrawable(context.getResources().getColor(R.color.add_nav_text_color));
        this.mBackground = r1;
        setBackgroundDrawable(r1);
        setFocusable(true);
        setTouchable(true);
        View r0 = LayoutInflater.from(context).inflate(R.layout.menu_resolver_layout, null);
        ViewGroup r2 = (ViewGroup) r0.findViewById(R.id.container);
        this.mParentPanel = r0.findViewById(R.id.parentPanel);
        r2.setOnClickListener(this);
        GridView r3 = (GridView) r0.findViewById(R.id.gridview);
        this.mGridView = r3;
        r3.setSelector(new ColorDrawable(0));
        MenuDialogTitleBar r4 = (MenuDialogTitleBar) r0.findViewById(R.id.menu_dialog_title_bar);
        if (r4 == null) goto L7;
        r4.setOnRightButtonClickListener(this);
        int r5 = context.getResources().getIdentifier("chooseActivity", "string", "android");
        if (r5 <= 0) goto L7;
        r4.setTitle(context.getResources().getText(r5));
    L7:
        setContentView(r0);
        r0.setSystemUiVisibility(1024);
    }

    public void setAdapter(BottomMenuPopupAdapter adapter) {
        if (this.mContext.getResources().getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L6:
        this.mIsLand = r0;
        int r1 = this.mCustomNumColumn;
        if (r1 <= 0) goto L9;
        this.mGridView.setNumColumns(r1);
    L14:
        this.mGridView.setAdapter(adapter);
        return;
    L9:
        GridView r2 = this.mGridView;
        if (r0 == false) goto L12;
        int r3 = 3;
    L13:
        r2.setNumColumns(r3);
        goto L14
    L12:
        r3 = 4;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.mGridView.setOnItemClickListener(listener);
    }

    public void setNumColumns(int numColumns) {
        this.mCustomNumColumn = numColumns;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        dismissWithAnimation();
    }

    private void dismissWithAnimation() {
        if (this.mAnimation == null) goto L5;
        return;
    L5:
        Animation r0 = AnimationUtils.loadAnimation(this.mContext, R.anim.popup_exit);
        this.mAnimation = r0;
        r0.setFillAfter(true);
        this.mAnimation.setAnimationListener(new AnonymousClass1(this));
        this.mParentPanel.startAnimation(this.mAnimation);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View parent, int gravity, int x, int y) {
        if (this.mAnimation == null) goto L5;
        return;
    L5:
        super.showAtLocation(parent, gravity, x, y);
        Animation r2 = AnimationUtils.loadAnimation(this.mContext, R.anim.popup_enter);
        this.mAnimation = r2;
        this.mParentPanel.startAnimation(r2);
        this.mAnimation.setAnimationListener(new AnonymousClass2(this));
    }

    public void showBrowserMenu(View anchorView, Menu menu, int childHeight, int PopupWindowWidth, int PopupWindowHeight, int offsetX, int offsetY) {
        int r0 = menu.size();
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        MenuItem r4 = menu.getItem(r3);
        if (r4.isVisible() == false) goto L7;
        r1.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        BottomMenuPopupAdapter r8 = new BottomMenuPopupAdapter(this.mContext, r1);
        this.mBrowserMenuPopupAdapter = r8;
        setAdapter(r8);
        this.mBrowserMenuPopupAdapter.setChildHeight(childHeight);
        setWidth(PopupWindowWidth);
        setHeight(PopupWindowHeight);
        showAtLocation(anchorView, 0, offsetX, offsetY);
    }

    public void showBrowserMenu(View anchorView, Menu menu, int childHeight, int PopupWindowWidth, int PopupWindowHeight) {
        showBrowserMenu(anchorView, menu, childHeight, PopupWindowWidth, PopupWindowHeight, 0, 0);
    }
}
