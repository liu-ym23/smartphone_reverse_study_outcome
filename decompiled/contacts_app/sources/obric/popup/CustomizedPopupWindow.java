package obric.popup;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class CustomizedPopupWindow extends PopupWindow {
    public static final int DIRECTION_BOTTOM = 1;
    public static final int DIRECTION_CENTER_IN_SCREEN = 2;
    public static final int DIRECTION_TOP = 0;
    protected View mContentView;
    private Context mContext;
    private int mEdgeProtectionBottom;
    private int mEdgeProtectionLeft;
    private int mEdgeProtectionRight;
    private int mEdgeProtectionTop;
    private int mGravity;
    protected int mInitHeight;
    protected int mInitWidth;
    private int mOffsetX;
    private int mOffsetYIfBottom;
    private int mOffsetYIfTop;
    private int mPreferredDirection;
    private IWrapperView mWrapperView;

    public interface IWrapperView {
        View wrap(View businessView, int width, int height, ShowInfo showInfo);
    }

    class ShowInfo {
        View anchor;
        int anchorCenter;
        private int[] anchorLocation;
        private int[] anchorRootLocation;
        int contentHeightMeasureSpec;
        int contentWidthMeasureSpec;
        int decorationBottom;
        int decorationLeft;
        int decorationRight;
        int decorationTop;
        int direction;
        int height;
        final /* synthetic */ CustomizedPopupWindow this$0;
        Rect visibleWindowFrame;
        int width;
        int x;
        int y;

        static /* synthetic */ int[] access$000(ShowInfo r0) {
            return r0.anchorLocation;
        }

        ShowInfo(final CustomizedPopupWindow this$0, View anchor) {
            this.this$0 = this$0;
            this.anchorRootLocation = new int[2];
            this.anchorLocation = new int[2];
            this.visibleWindowFrame = new Rect();
            this.direction = CustomizedPopupWindow.access$100(this$0);
            this.decorationLeft = 0;
            this.decorationRight = 0;
            this.decorationTop = 0;
            this.decorationBottom = 0;
            this.anchor = anchor;
            anchor.getRootView().getLocationOnScreen(this.anchorRootLocation);
            anchor.getLocationOnScreen(this.anchorLocation);
            this.anchorCenter = this.anchorLocation[0] + (anchor.getWidth() / 2);
            anchor.getWindowVisibleDisplayFrame(this.visibleWindowFrame);
        }

        float anchorProportion() {
            return (this.anchorCenter - this.x) / this.width;
        }

        int windowWidth() {
            return (this.decorationLeft + this.width) + this.decorationRight;
        }

        int windowHeight() {
            return (this.decorationTop + this.height) + this.decorationBottom;
        }

        int getVisibleWidth() {
            return this.visibleWindowFrame.width();
        }

        int getVisibleHeight() {
            return this.visibleWindowFrame.height();
        }

        int getWindowX() {
            return this.x - this.anchorRootLocation[0];
        }

        int getWindowY() {
            return this.y - this.anchorRootLocation[1];
        }
    }

    protected int proxyHeight(int height) {
        return height;
    }

    protected int proxyWidth(int width) {
        return width;
    }

    static /* synthetic */ int access$100(CustomizedPopupWindow r0) {
        return r0.mPreferredDirection;
    }

    public CustomizedPopupWindow(Context context, int width, int height) {
        super(context);
        this.mPreferredDirection = 1;
        this.mGravity = 1;
        this.mOffsetX = 0;
        this.mOffsetYIfTop = 0;
        this.mOffsetYIfBottom = 0;
        this.mContext = context;
        this.mInitWidth = width;
        this.mInitHeight = height;
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public CustomizedPopupWindow offsetX(int offsetX) {
        this.mOffsetX = offsetX;
        return this;
    }

    public CustomizedPopupWindow offsetYIfTop(int y) {
        this.mOffsetYIfTop = y;
        return this;
    }

    public CustomizedPopupWindow offsetYIfBottom(int y) {
        this.mOffsetYIfBottom = y;
        return this;
    }

    public CustomizedPopupWindow preferredDirection(int preferredDirection) {
        this.mPreferredDirection = preferredDirection;
        return this;
    }

    public CustomizedPopupWindow setContentGravity(int gravity) {
        this.mGravity = gravity;
        return this;
    }

    public CustomizedPopupWindow view(View contentView) {
        this.mContentView = contentView;
        return this;
    }

    public CustomizedPopupWindow view(int contentViewResId) {
        return view(LayoutInflater.from(this.mContext).inflate(contentViewResId, null));
    }

    public CustomizedPopupWindow wrapContentView(IWrapperView view) {
        this.mWrapperView = view;
        return this;
    }

    public CustomizedPopupWindow edgeProtection(int distance) {
        this.mEdgeProtectionLeft = distance;
        this.mEdgeProtectionRight = distance;
        this.mEdgeProtectionTop = distance;
        this.mEdgeProtectionBottom = distance;
        return this;
    }

    public CustomizedPopupWindow edgeProtection(int left, int top, int right, int bottom) {
        this.mEdgeProtectionLeft = left;
        this.mEdgeProtectionTop = top;
        this.mEdgeProtectionRight = right;
        this.mEdgeProtectionBottom = bottom;
        return this;
    }

    public CustomizedPopupWindow contentPadding(int left, int top, int right, int bottom) {
        View r0 = this.mContentView;
        if (r0 == null) goto L7;
        r0.setPadding(left, top, right, bottom);
        return this;
    L7:
        throw new RuntimeException("you should set content view before set padding");
    }

    public View getContentViewSMT() {
        return this.mContentView;
    }

    public ShowInfo layoutShowInfo(View anchor) {
        if (this.mContentView == null) goto L7;
        ShowInfo r0 = new ShowInfo(this, anchor);
        View r2 = decorateContentView(r0);
        calculateWindowSize(r0, r2);
        calculateXY(r0);
        setContentView(r2);
        setAnimationStyleForDir(r0.direction);
        setWidth(r0.windowWidth());
        setHeight(r0.windowHeight());
        return r0;
    L7:
        throw new RuntimeException("you should call view() to set your content view");
    }

    public void show(View anchor) {
        ShowInfo r0 = layoutShowInfo(anchor);
        showAtLocation(anchor, 0, r0.getWindowX(), r0.getWindowY());
    }

    private void calculateWindowSize(ShowInfo showInfo, View contentView) {
        int r0 = this.mInitWidth;
        boolean r2 = true;
        if (r0 <= 0) goto L5;
        showInfo.width = proxyWidth(r0);
        showInfo.contentWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(showInfo.width, 1073741824);
    L8:
        boolean r1 = false;
    L10:
        int r6 = this.mInitHeight;
        if (r6 <= 0) goto L13;
        showInfo.height = proxyHeight(r6);
        showInfo.contentHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(showInfo.height, 1073741824);
    L16:
        r2 = false;
    L18:
        if (r1 == true) goto L20;
        if (r2 == true) goto L20;
        return;
    L20:
        contentView.measure(showInfo.contentWidthMeasureSpec, showInfo.contentHeightMeasureSpec);
        if (r1 == false) goto L23;
        showInfo.width = proxyWidth(contentView.getMeasuredWidth());
    L23:
        if (r2 == false) goto L27;
        showInfo.height = proxyHeight(contentView.getMeasuredHeight());
        return;
    L27:
        return;
    L13:
        int r7 = (showInfo.getVisibleHeight() - this.mEdgeProtectionTop) - this.mEdgeProtectionBottom;
        if (this.mInitHeight != (-1)) goto L17;
        showInfo.height = proxyHeight(r7);
        showInfo.contentHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(showInfo.height, 1073741824);
        goto L16
    L17:
        showInfo.contentHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(proxyHeight(r7), Integer.MIN_VALUE);
        goto L18
    L5:
        int r3 = (showInfo.getVisibleWidth() - this.mEdgeProtectionLeft) - this.mEdgeProtectionRight;
        if (this.mInitWidth != (-1)) goto L9;
        showInfo.width = proxyWidth(r3);
        showInfo.contentWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(showInfo.width, 1073741824);
        goto L8
    L9:
        showInfo.contentWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(proxyWidth(r3), Integer.MIN_VALUE);
        r1 = true;
        goto L10
    }

    private void calculateXY(ShowInfo showInfo) {
        int r3 = 2;
        if (showInfo.anchorCenter >= (showInfo.visibleWindowFrame.left + (showInfo.getVisibleWidth() / 2))) goto L5;
        showInfo.x = Math.max(this.mEdgeProtectionLeft + showInfo.visibleWindowFrame.left, applyGravityLocX(showInfo) + this.mOffsetX);
    L6:
        int r0 = this.mPreferredDirection;
        if (r0 != 1) goto L9;
        r3 = 0;
    L11:
        handleDirection(showInfo, r0, r3);
        return;
    L9:
        if (r0 != 0) goto L11;
        r3 = 1;
        goto L11
    L5:
        showInfo.x = Math.min((showInfo.visibleWindowFrame.right - this.mEdgeProtectionRight) - showInfo.width, applyGravityLocX(showInfo) + this.mOffsetX);
        goto L6
    }

    private int applyGravityLocX(ShowInfo showInfo) {
        int r2 = this.mGravity & 7;
        if (r2 == 3) goto L9;
        if (r2 == 5) goto L11;
        return showInfo.anchorCenter - (showInfo.width / 2);
    L11:
        return ShowInfo.access$000(showInfo)[0] + showInfo.anchor.getWidth();
    L9:
        return ShowInfo.access$000(showInfo)[0];
    }

    private void handleDirection(ShowInfo showInfo, int currentDirection, int nextDirection) {
        if (currentDirection != 2) goto L6;
        showInfo.x = showInfo.visibleWindowFrame.left + ((showInfo.getVisibleWidth() - showInfo.width) / 2);
        showInfo.y = showInfo.visibleWindowFrame.top + ((showInfo.getVisibleHeight() - showInfo.height) / 2);
        showInfo.direction = 2;
        return;
    L6:
        if (currentDirection != 0) goto L11;
        showInfo.y = (ShowInfo.access$000(showInfo)[1] - showInfo.height) - this.mOffsetYIfTop;
        if (showInfo.y >= (this.mEdgeProtectionTop + showInfo.visibleWindowFrame.top)) goto L10;
        handleDirection(showInfo, nextDirection, 2);
        return;
    L10:
        showInfo.direction = 0;
        return;
    L11:
        if (currentDirection != 1) goto L20;
        showInfo.y = (ShowInfo.access$000(showInfo)[1] + showInfo.anchor.getHeight()) + this.mOffsetYIfBottom;
        if (showInfo.y <= ((showInfo.visibleWindowFrame.bottom - this.mEdgeProtectionBottom) - showInfo.height)) goto L15;
        handleDirection(showInfo, nextDirection, 2);
        return;
    L15:
        showInfo.direction = 1;
        return;
    }

    private View decorateContentView(ShowInfo showInfo) {
        IWrapperView r0 = this.mWrapperView;
        if (r0 != null) goto L6;
        return this.mContentView;
    L6:
        return r0.wrap(this.mContentView, this.mInitWidth, this.mInitHeight, showInfo);
    }

    private void setAnimationStyleForDir(int direction) {
        if (direction != 0) goto L4;
        boolean r2 = true;
    L5:
        int r0 = R.style.SMTUIPopupDropDownDown;
        if (r2 == false) goto L8;
        r0 = R.style.SMTUIPopupDropDownUp;
    L8:
        setAnimationStyle(r0);
        return;
    L4:
        r2 = false;
        goto L5
    }
}
