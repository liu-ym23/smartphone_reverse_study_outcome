package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes3.dex */
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    public int getChangingConfigurations() {
        return this.mWrapped.getChangingConfigurations();
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public int length() {
        return this.mWrapped.length();
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public ColorStateList getColorStateList(int r100) {
        if (this.mWrapped.hasValue(r100) == false) goto L10;
        int r101 = this.mWrapped.getResourceId(r100, 0);
        if (r101 == 0) goto L10;
        ColorStateList r102 = AppCompatResources.getColorStateList(this.mContext, r101);
        if (r102 == null) goto L10;
        return r102;
    L10:
        return this.mWrapped.getColorStateList(r100);
    }

    public Drawable getDrawable(int r100) {
        if (this.mWrapped.hasValue(r100) == false) goto L9;
        int r101 = this.mWrapped.getResourceId(r100, 0);
        if (r101 == 0) goto L9;
        return AppCompatResources.getDrawable(this.mContext, r101);
    L9:
        return this.mWrapped.getDrawable(r100);
    }

    public Drawable getDrawableIfKnown(int r100) {
        if (this.mWrapped.hasValue(r100) == false) goto L8;
        int r101 = this.mWrapped.getResourceId(r100, 0);
        if (r101 != 0) goto L7;
        return null;
    L7:
        return AppCompatDrawableManager.get().getDrawable(this.mContext, r101, true);
    L8:
        return null;
    }

    public int getIndex(int r100) {
        return this.mWrapped.getIndex(r100);
    }

    public String getNonResourceString(int r100) {
        return this.mWrapped.getNonResourceString(r100);
    }

    public String getString(int r100) {
        return this.mWrapped.getString(r100);
    }

    public CharSequence getText(int r100) {
        return this.mWrapped.getText(r100);
    }

    public CharSequence[] getTextArray(int r100) {
        return this.mWrapped.getTextArray(r100);
    }

    public int getType(int r100) {
        return this.mWrapped.getType(r100);
    }

    public boolean hasValue(int r100) {
        return this.mWrapped.hasValue(r100);
    }

    public TypedValue peekValue(int r100) {
        return this.mWrapped.peekValue(r100);
    }

    private TintTypedArray(Context r100, TypedArray r101) {
        this.mContext = r100;
        this.mWrapped = r101;
    }

    public boolean getBoolean(int r100, boolean r101) {
        return this.mWrapped.getBoolean(r100, r101);
    }

    public int getColor(int r100, int r101) {
        return this.mWrapped.getColor(r100, r101);
    }

    public float getDimension(int r100, float r101) {
        return this.mWrapped.getDimension(r100, r101);
    }

    public int getDimensionPixelOffset(int r100, int r101) {
        return this.mWrapped.getDimensionPixelOffset(r100, r101);
    }

    public int getDimensionPixelSize(int r100, int r101) {
        return this.mWrapped.getDimensionPixelSize(r100, r101);
    }

    public float getFloat(int r100, float r101) {
        return this.mWrapped.getFloat(r100, r101);
    }

    public int getInt(int r100, int r101) {
        return this.mWrapped.getInt(r100, r101);
    }

    public int getInteger(int r100, int r101) {
        return this.mWrapped.getInteger(r100, r101);
    }

    public int getLayoutDimension(int r100, int r101) {
        return this.mWrapped.getLayoutDimension(r100, r101);
    }

    public int getResourceId(int r100, int r101) {
        return this.mWrapped.getResourceId(r100, r101);
    }

    public boolean getValue(int r100, TypedValue r101) {
        return this.mWrapped.getValue(r100, r101);
    }

    public int getLayoutDimension(int r100, String r101) {
        return this.mWrapped.getLayoutDimension(r100, r101);
    }

    public static TintTypedArray obtainStyledAttributes(Context r100, int r101, int[] r102) {
        return new TintTypedArray(r100, r100.obtainStyledAttributes(r101, r102));
    }

    public Typeface getFont(int r100, int r101, ResourcesCompat.FontCallback r102) {
        int r103 = this.mWrapped.getResourceId(r100, 0);
        if (r103 != 0) goto L7;
        return null;
    L7:
        if (this.mTypedValue != null) goto L10;
        this.mTypedValue = new TypedValue();
    L10:
        return ResourcesCompat.getFont(this.mContext, r103, this.mTypedValue, r101, r102);
    }

    public static TintTypedArray obtainStyledAttributes(Context r100, AttributeSet r101, int[] r102) {
        return new TintTypedArray(r100, r100.obtainStyledAttributes(r101, r102));
    }

    public float getFraction(int r100, int r101, int r102, float r103) {
        return this.mWrapped.getFraction(r100, r101, r102, r103);
    }

    public static TintTypedArray obtainStyledAttributes(Context r100, AttributeSet r101, int[] r102, int r103, int r104) {
        return new TintTypedArray(r100, r100.obtainStyledAttributes(r101, r102, r103, r104));
    }
}
