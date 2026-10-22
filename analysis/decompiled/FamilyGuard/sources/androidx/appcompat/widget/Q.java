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
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
class Q extends Resources {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f8243a;

    public Q(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f8243a = resources;
    }

    final Drawable a(int i5) {
        return super.getDrawable(i5);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i5) {
        return this.f8243a.getAnimation(i5);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i5) {
        return this.f8243a.getBoolean(i5);
    }

    @Override // android.content.res.Resources
    public int getColor(int i5) {
        return this.f8243a.getColor(i5);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i5) {
        return this.f8243a.getColorStateList(i5);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f8243a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i5) {
        return this.f8243a.getDimension(i5);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i5) {
        return this.f8243a.getDimensionPixelOffset(i5);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i5) {
        return this.f8243a.getDimensionPixelSize(i5);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f8243a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i5, Resources.Theme theme) {
        return androidx.core.content.res.h.f(this.f8243a, i5, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i5, int i6) {
        return androidx.core.content.res.h.g(this.f8243a, i5, i6, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i5, int i6, int i7) {
        return this.f8243a.getFraction(i5, i6, i7);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f8243a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i5) {
        return this.f8243a.getIntArray(i5);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i5) {
        return this.f8243a.getInteger(i5);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i5) {
        return this.f8243a.getLayout(i5);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i5) {
        return this.f8243a.getMovie(i5);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i5, int i6, Object... objArr) {
        return this.f8243a.getQuantityString(i5, i6, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i5, int i6) {
        return this.f8243a.getQuantityText(i5, i6);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i5) {
        return this.f8243a.getResourceEntryName(i5);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i5) {
        return this.f8243a.getResourceName(i5);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i5) {
        return this.f8243a.getResourcePackageName(i5);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i5) {
        return this.f8243a.getResourceTypeName(i5);
    }

    @Override // android.content.res.Resources
    public String getString(int i5) {
        return this.f8243a.getString(i5);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i5) {
        return this.f8243a.getStringArray(i5);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i5) {
        return this.f8243a.getText(i5);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i5) {
        return this.f8243a.getTextArray(i5);
    }

    @Override // android.content.res.Resources
    public void getValue(int i5, TypedValue typedValue, boolean z5) throws Resources.NotFoundException {
        this.f8243a.getValue(i5, typedValue, z5);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i5, int i6, TypedValue typedValue, boolean z5) throws Resources.NotFoundException {
        this.f8243a.getValueForDensity(i5, i6, typedValue, z5);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i5) {
        return this.f8243a.getXml(i5);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f8243a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i5) {
        return this.f8243a.obtainTypedArray(i5);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i5) {
        return this.f8243a.openRawResource(i5);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i5) {
        return this.f8243a.openRawResourceFd(i5);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f8243a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f8243a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f8243a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i5, int i6, Resources.Theme theme) {
        return androidx.core.content.res.h.g(this.f8243a, i5, i6, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i5, int i6) {
        return this.f8243a.getQuantityString(i5, i6);
    }

    @Override // android.content.res.Resources
    public String getString(int i5, Object... objArr) {
        return this.f8243a.getString(i5, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i5, CharSequence charSequence) {
        return this.f8243a.getText(i5, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z5) throws Resources.NotFoundException {
        this.f8243a.getValue(str, typedValue, z5);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i5, TypedValue typedValue) {
        return this.f8243a.openRawResource(i5, typedValue);
    }
}
