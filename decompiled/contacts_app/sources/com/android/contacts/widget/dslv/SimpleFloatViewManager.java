package com.android.contacts.widget.dslv;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleFloatViewManager implements DragSortListView.FloatViewManager {
    private int mFloatBGColor;
    private Bitmap mFloatBitmap;
    private ImageView mImageView;
    private ListView mListView;
    private int mPaddingBottom;
    private int mPaddingTop;

    @Override // com.android.contacts.widget.dslv.DragSortListView.FloatViewManager
    public void onDragFloatView(View r1, Point r2, Point r3) {
    }

    public SimpleFloatViewManager(ListView r2) {
        this.mFloatBGColor = -16777216;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mListView = r2;
    }

    public void setBackgroundColor(int r1) {
        this.mFloatBGColor = r1;
    }

    @Override // com.android.contacts.widget.dslv.DragSortListView.FloatViewManager
    public View onCreateFloatView(int r13) {
        ListView r0 = this.mListView;
        View r14 = r0.getChildAt((r13 + r0.getHeaderViewsCount()) - this.mListView.getFirstVisiblePosition());
        if (r14 != null) goto L5;
        return null;
    L5:
        r14.setPressed(false);
        r14.setDrawingCacheEnabled(true);
        Drawable r2 = this.mListView.getContext().getResources().getDrawable(R.drawable.shadow_top);
        Drawable r3 = this.mListView.getContext().getResources().getDrawable(R.drawable.shadow_bottom);
        Bitmap r4 = ((BitmapDrawable) r2).getBitmap();
        Bitmap r5 = ((BitmapDrawable) r3).getBitmap();
        Bitmap r6 = r14.getDrawingCache();
        int r7 = r6.getWidth();
        this.mPaddingTop = r4.getHeight();
        int r8 = r5.getHeight();
        this.mPaddingBottom = r8;
        this.mFloatBitmap = Bitmap.createBitmap(r7, (this.mPaddingTop + r8) + r6.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r9 = new Canvas(this.mFloatBitmap);
        Rect r10 = new Rect();
        Rect r11 = new Rect();
        int r12 = r4.getHeight();
        r10.set(0, 0, r4.getWidth(), r4.getHeight());
        r11.set(0, 0, r7, r12);
        r9.drawBitmap(r4, r10, r11, null);
        int r15 = r6.getHeight() + r12;
        r10.set(0, 0, r6.getWidth(), r6.getHeight());
        r11.set(0, r12, r7, r15);
        r9.drawBitmap(r6, r10, r11, null);
        int r16 = r5.getHeight() + r15;
        r10.set(0, 0, r5.getWidth(), r5.getHeight());
        r11.set(0, r15, r7, r16);
        r9.drawBitmap(r5, r10, r11, null);
        r14.setDrawingCacheEnabled(false);
        if (this.mImageView != null) goto L8;
        this.mImageView = new ImageView(this.mListView.getContext());
    L8:
        this.mImageView.setPadding(0, 0, 0, 0);
        this.mImageView.setImageBitmap(this.mFloatBitmap);
        this.mImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return this.mImageView;
    }

    @Override // com.android.contacts.widget.dslv.DragSortListView.FloatViewManager
    public void onDestroyFloatView(View r2) {
        ((ImageView) r2).setImageDrawable(null);
        this.mFloatBitmap.recycle();
        this.mFloatBitmap = null;
    }

    @Override // com.android.contacts.widget.dslv.DragSortListView.FloatViewManager
    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    @Override // com.android.contacts.widget.dslv.DragSortListView.FloatViewManager
    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }
}
