package obric.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SearchBarListView extends ListView {
    private boolean isShowShadow;
    private List<View> mHeaders;
    private Paint mPaint;
    private View mSearchBarHeader;
    private Bitmap mShadowBitmap;

    public SearchBarListView(Context context) {
        this(context, null);
    }

    public SearchBarListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchBarListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.isShowShadow = true;
        this.mHeaders = new ArrayList();
        this.mPaint = new Paint();
    }

    private Bitmap getShadowBitmap(Context context) {
        NinePatchDrawable r6 = (NinePatchDrawable) context.getResources().getDrawable(R.drawable.secondary_bar_shadow);
        int r0 = getMeasuredWidth();
        int r1 = r6.getIntrinsicHeight();
        if (r0 == 0) goto L8;
        if (r1 == 0) goto L10;
        int r5 = getMeasuredWidth();
        int r2 = r6.getIntrinsicHeight();
        r6.getOpacity();
        Bitmap r7 = Bitmap.createBitmap(r5, r2, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r7);
        r6.setBounds(0, 0, r0, r1);
        r6.draw(r3);
        return r7;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mShadowBitmap != null) goto L6;
        this.mShadowBitmap = getShadowBitmap(getContext());
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.isShowShadow == true) goto L5;
        return;
    L5:
        if (this.mShadowBitmap != null) goto L7;
        return;
    L7:
        if (getScrollY() <= 0) goto L10;
        int r0 = getScrollY();
    L15:
        canvas.drawBitmap(this.mShadowBitmap, 0.0f, r0, this.mPaint);
        return;
    L10:
        if (this.mSearchBarHeader != null) goto L12;
    L14:
        r0 = 0;
        goto L15
    L12:
        if (getFirstVisiblePosition() > getSearchBarIndex()) goto L14;
        r0 = this.mSearchBarHeader.getHeight() + this.mSearchBarHeader.getTop();
        goto L15
    }

    public void setShowShadow(boolean show) {
        this.isShowShadow = show;
        invalidateViews();
    }

    public boolean isShowShadow() {
        return this.isShowShadow;
    }

    public void setSearchBar(View searchBar) {
        this.mSearchBarHeader = searchBar;
    }

    public View getSearchBar() {
        return this.mSearchBarHeader;
    }

    private int getSearchBarIndex() {
        return this.mHeaders.indexOf(this.mSearchBarHeader);
    }

    @Override // android.widget.ListView
    public void addHeaderView(View v) {
        super.addHeaderView(v);
        addHeaderToList(v);
    }

    @Override // android.widget.ListView
    public void addHeaderView(View v, Object data, boolean isSelectable) {
        super.addHeaderView(v, data, isSelectable);
        addHeaderToList(v);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View v) {
        this.mHeaders.remove(v);
        return super.removeHeaderView(v);
    }

    private void addHeaderToList(View v) {
        if (this.mHeaders.contains(v) == true) goto L6;
        this.mHeaders.add(v);
        return;
    }
}
