package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class u extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f1119a;

    public u(Resources r10) {
        super(r10.getAssets(), r10.getDisplayMetrics(), r10.getConfiguration());
        this.f1119a = r10;
    }

    public final Drawable a(int r10) {
        return super.getDrawable(r10);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int r10) {
        return this.f1119a.getAnimation(r10);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int r10) {
        return this.f1119a.getBoolean(r10);
    }

    @Override // android.content.res.Resources
    public int getColor(int r10) {
        return this.f1119a.getColor(r10);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r10) {
        return this.f1119a.getColorStateList(r10);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f1119a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int r10) {
        return this.f1119a.getDimension(r10);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int r10) {
        return this.f1119a.getDimensionPixelOffset(r10);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int r10) {
        return this.f1119a.getDimensionPixelSize(r10);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f1119a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r10, Resources.Theme r11) {
        return androidx.core.content.res.a.f(this.f1119a, r10, r11);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r10, int r11) {
        return androidx.core.content.res.a.g(this.f1119a, r10, r11, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int r10, int r11, int r12) {
        return this.f1119a.getFraction(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String r10, String r11, String r12) {
        return this.f1119a.getIdentifier(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int r10) {
        return this.f1119a.getIntArray(r10);
    }

    @Override // android.content.res.Resources
    public int getInteger(int r10) {
        return this.f1119a.getInteger(r10);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int r10) {
        return this.f1119a.getLayout(r10);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int r10) {
        return this.f1119a.getMovie(r10);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r10, int r11, Object... r12) {
        return this.f1119a.getQuantityString(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int r10, int r11) {
        return this.f1119a.getQuantityText(r10, r11);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int r10) {
        return this.f1119a.getResourceEntryName(r10);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int r10) {
        return this.f1119a.getResourceName(r10);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int r10) {
        return this.f1119a.getResourcePackageName(r10);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int r10) {
        return this.f1119a.getResourceTypeName(r10);
    }

    @Override // android.content.res.Resources
    public String getString(int r10) {
        return this.f1119a.getString(r10);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int r10) {
        return this.f1119a.getStringArray(r10);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r10) {
        return this.f1119a.getText(r10);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int r10) {
        return this.f1119a.getTextArray(r10);
    }

    @Override // android.content.res.Resources
    public void getValue(int r10, TypedValue r11, boolean r12) {
        this.f1119a.getValue(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int r10, int r11, TypedValue r12, boolean r13) {
        e.a.a(this.f1119a, r10, r11, r12, r13);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int r10) {
        return this.f1119a.getXml(r10);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet r10, int[] r11) {
        return this.f1119a.obtainAttributes(r10, r11);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int r10) {
        return this.f1119a.obtainTypedArray(r10);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r10) {
        return this.f1119a.openRawResource(r10);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int r10) {
        return this.f1119a.openRawResourceFd(r10);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String r10, AttributeSet r11, Bundle r12) {
        this.f1119a.parseBundleExtra(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser r10, Bundle r11) {
        this.f1119a.parseBundleExtras(r10, r11);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration r10, DisplayMetrics r11) {
        super.updateConfiguration(r10, r11);
        Resources r12 = this.f1119a;
        if (r12 == null) goto L6;
        r12.updateConfiguration(r10, r11);
        return;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r10, int r11, Resources.Theme r12) {
        return androidx.core.content.res.a.g(this.f1119a, r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r10, int r11) {
        return this.f1119a.getQuantityString(r10, r11);
    }

    @Override // android.content.res.Resources
    public String getString(int r10, Object... r11) {
        return this.f1119a.getString(r10, r11);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r10, CharSequence r11) {
        return this.f1119a.getText(r10, r11);
    }

    @Override // android.content.res.Resources
    public void getValue(String r10, TypedValue r11, boolean r12) {
        this.f1119a.getValue(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r10, TypedValue r11) {
        return this.f1119a.openRawResource(r10, r11);
    }
}
