package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewStubCompat extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    public interface OnInflateListener {
        void onInflate(ViewStubCompat r100, View r101);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r100) {
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
    }

    public View inflate() {
        ViewParent r100 = getParent();
        if ((r100 instanceof ViewGroup) == false) goto L24;
        if (this.mLayoutResource == 0) goto L22;
        ViewGroup r101 = (ViewGroup) r100;
        LayoutInflater r102 = this.mInflater;
        if (r102 != null) goto L10;
        r102 = LayoutInflater.from(getContext());
    L10:
        View r103 = r102.inflate(this.mLayoutResource, r101, false);
        int r104 = this.mInflatedId;
        if (r104 == (-1)) goto L13;
        r103.setId(r104);
    L13:
        int r105 = r101.indexOfChild(this);
        r101.removeViewInLayout(this);
        ViewGroup.LayoutParams r106 = getLayoutParams();
        if (r106 == null) goto L16;
        r101.addView(r103, r105, r106);
    L17:
        this.mInflatedViewRef = new WeakReference(r103);
        OnInflateListener r107 = this.mInflateListener;
        if (r107 == null) goto L20;
        r107.onInflate(this, r103);
    L20:
        return r103;
    L16:
        r101.addView(r103, r105);
        goto L17
    L22:
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    L24:
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public void setInflatedId(int r100) {
        this.mInflatedId = r100;
    }

    public void setLayoutInflater(LayoutInflater r100) {
        this.mInflater = r100;
    }

    public void setLayoutResource(int r100) {
        this.mLayoutResource = r100;
    }

    public void setOnInflateListener(OnInflateListener r100) {
        this.mInflateListener = r100;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        WeakReference<View> r101 = this.mInflatedViewRef;
        if (r101 == null) goto L9;
        View r102 = r101.get();
        if (r102 == null) goto L8;
        r102.setVisibility(r100);
        return;
    L8:
        throw new IllegalStateException("setVisibility called on un-referenced view");
    L9:
        super.setVisibility(r100);
        if (r100 != 0) goto L12;
    L13:
        inflate();
        return;
    L12:
        if (r100 == 4) goto L13;
    }

    public ViewStubCompat(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }

    public ViewStubCompat(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mLayoutResource = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.id, R.attr.layout, R.attr.inflatedId}, r102, 0);
        this.mInflatedId = r103.getResourceId(2, -1);
        this.mLayoutResource = r103.getResourceId(1, 0);
        setId(r103.getResourceId(0, -1));
        r103.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
