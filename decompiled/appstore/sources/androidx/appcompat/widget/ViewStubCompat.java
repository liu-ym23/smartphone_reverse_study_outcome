package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnInflateListener f957e;

    public interface OnInflateListener {
        void onInflate(ViewStubCompat r10, View r11);
    }

    public ViewStubCompat(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public View a() {
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewGroup) == false) goto L24;
        if (this.f953a == 0) goto L22;
        ViewGroup r11 = (ViewGroup) r10;
        LayoutInflater r12 = this.f956d;
        if (r12 != null) goto L10;
        r12 = LayoutInflater.from(getContext());
    L10:
        View r13 = r12.inflate(this.f953a, r11, false);
        int r14 = this.f954b;
        if (r14 == (-1)) goto L13;
        r13.setId(r14);
    L13:
        int r15 = r11.indexOfChild(this);
        r11.removeViewInLayout(this);
        ViewGroup.LayoutParams r16 = getLayoutParams();
        if (r16 == null) goto L16;
        r11.addView(r13, r15, r16);
    L17:
        this.f955c = new WeakReference(r13);
        OnInflateListener r17 = this.f957e;
        if (r17 == null) goto L20;
        r17.onInflate(this, r13);
    L20:
        return r13;
    L16:
        r11.addView(r13, r15);
        goto L17
    L22:
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    L24:
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas r10) {
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
    }

    public int getInflatedId() {
        return this.f954b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f956d;
    }

    public int getLayoutResource() {
        return this.f953a;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int r10) {
        this.f954b = r10;
    }

    public void setLayoutInflater(LayoutInflater r10) {
        this.f956d = r10;
    }

    public void setLayoutResource(int r10) {
        this.f953a = r10;
    }

    public void setOnInflateListener(OnInflateListener r10) {
        this.f957e = r10;
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        WeakReference r11 = this.f955c;
        if (r11 == null) goto L9;
        View r12 = (View) r11.get();
        if (r12 == null) goto L8;
        r12.setVisibility(r10);
        return;
    L8:
        throw new IllegalStateException("setVisibility called on un-referenced view");
    L9:
        super.setVisibility(r10);
        if (r10 != 0) goto L12;
    L13:
        a();
        return;
    L12:
        if (r10 == 4) goto L13;
    }

    public ViewStubCompat(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f953a = 0;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.ViewStubCompat, r12, 0);
        this.f954b = r13.getResourceId(R$styleable.ViewStubCompat_android_inflatedId, -1);
        this.f953a = r13.getResourceId(R$styleable.ViewStubCompat_android_layout, 0);
        setId(r13.getResourceId(R$styleable.ViewStubCompat_android_id, -1));
        r13.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
