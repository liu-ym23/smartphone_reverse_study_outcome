package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {
    private a mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    public interface a {
        void a(ViewStubCompat r1, View r2);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r1) {
    }

    @Override // android.view.View
    public void draw(Canvas r1) {
    }

    public ViewStubCompat(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public ViewStubCompat(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r6);
        this.mLayoutResource = 0;
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.ViewStubCompat, r6, 0);
        this.mInflatedId = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ViewStubCompat_android_inflatedId, "styleable", "ViewStubCompat_android_inflatedId"), -1);
        this.mLayoutResource = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ViewStubCompat_android_layout, "styleable", "ViewStubCompat_android_layout"), 0);
        setId(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ViewStubCompat_android_id, "styleable", "ViewStubCompat_android_id"), -1));
        r9.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public void setInflatedId(int r1) {
        this.mInflatedId = r1;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public void setLayoutResource(int r1) {
        this.mLayoutResource = r1;
    }

    public void setLayoutInflater(LayoutInflater r1) {
        this.mInflater = r1;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        WeakReference<View> r0 = this.mInflatedViewRef;
        if (r0 == null) goto L9;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        r2.setVisibility(r3);
        return;
    L8:
        throw new IllegalStateException("setVisibility called on un-referenced view");
    L9:
        super.setVisibility(r3);
        if (r3 != 0) goto L12;
    L13:
        inflate();
        return;
    L12:
        if (r3 == 4) goto L13;
    }

    public View inflate() {
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L24;
        if (this.mLayoutResource == 0) goto L22;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
        LayoutInflater r2 = this.mInflater;
        if (r2 != null) goto L10;
        r2 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L10:
        View r3 = ZeusTransformUtils.inflate(r2, this.mLayoutResource, r1, false, "com.obric.aiagent.plugin");
        int r4 = this.mInflatedId;
        if (r4 == (-1)) goto L13;
        r3.setId(r4);
    L13:
        int r5 = r1.indexOfChild(this);
        r1.removeViewInLayout(this);
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if (r6 == null) goto L16;
        r1.addView(r3, r5, r6);
    L17:
        this.mInflatedViewRef = new WeakReference(r3);
        a r7 = this.mInflateListener;
        if (r7 == null) goto L20;
        r7.a(this, r3);
    L20:
        return r3;
    L16:
        r1.addView(r3, r5);
        goto L17
    L22:
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    L24:
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(a r3) {
        this.mInflateListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }
}
