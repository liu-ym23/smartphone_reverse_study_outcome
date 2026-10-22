package androidx.preference.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.s;

/* loaded from: classes.dex */
public class PreferenceImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private int f11107a;

    /* renamed from: b, reason: collision with root package name */
    private int f11108b;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f11108b;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f11107a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i5);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i5 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i6);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i6 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i5, i6);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i5) {
        this.f11108b = i5;
        super.setMaxHeight(i5);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i5) {
        this.f11107a = i5;
        super.setMaxWidth(i5);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f11107a = Integer.MAX_VALUE;
        this.f11108b = Integer.MAX_VALUE;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11166D0, i5, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(s.f11170F0, Integer.MAX_VALUE));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(s.f11168E0, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
    }
}
