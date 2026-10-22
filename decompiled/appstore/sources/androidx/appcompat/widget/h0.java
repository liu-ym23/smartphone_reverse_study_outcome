package androidx.appcompat.widget;

import android.content.Context;
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
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class h0 extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f1031c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f1032b;

    static {
    }

    public h0(Context r10, Resources r11) {
        super(r11);
        this.f1032b = new WeakReference(r10);
    }

    public static boolean b() {
        return f1031c;
    }

    public static boolean c() {
        b();
        return false;
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getAnimation(int r10) {
        return super.getAnimation(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ boolean getBoolean(int r10) {
        return super.getBoolean(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getColor(int r10) {
        return super.getColor(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ ColorStateList getColorStateList(int r10) {
        return super.getColorStateList(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ Configuration getConfiguration() {
        return super.getConfiguration();
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ float getDimension(int r10) {
        return super.getDimension(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getDimensionPixelOffset(int r10) {
        return super.getDimensionPixelOffset(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getDimensionPixelSize(int r10) {
        return super.getDimensionPixelSize(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawable(int r10, Resources.Theme r11) {
        return super.getDrawable(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int r10, int r11) {
        return super.getDrawableForDensity(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ float getFraction(int r10, int r11, int r12) {
        return super.getFraction(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getIdentifier(String r10, String r11, String r12) {
        return super.getIdentifier(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ int[] getIntArray(int r10) {
        return super.getIntArray(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getInteger(int r10) {
        return super.getInteger(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getLayout(int r10) {
        return super.getLayout(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ Movie getMovie(int r10) {
        return super.getMovie(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getQuantityString(int r10, int r11) {
        return super.getQuantityString(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getQuantityText(int r10, int r11) {
        return super.getQuantityText(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceEntryName(int r10) {
        return super.getResourceEntryName(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceName(int r10) {
        return super.getResourceName(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourcePackageName(int r10) {
        return super.getResourcePackageName(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceTypeName(int r10) {
        return super.getResourceTypeName(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getString(int r10) {
        return super.getString(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String[] getStringArray(int r10) {
        return super.getStringArray(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getText(int r10) {
        return super.getText(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence[] getTextArray(int r10) {
        return super.getTextArray(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(int r10, TypedValue r11, boolean r12) {
        super.getValue(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValueForDensity(int r10, int r11, TypedValue r12, boolean r13) {
        super.getValueForDensity(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getXml(int r10) {
        return super.getXml(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ TypedArray obtainAttributes(AttributeSet r10, int[] r11) {
        return super.obtainAttributes(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ TypedArray obtainTypedArray(int r10) {
        return super.obtainTypedArray(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ InputStream openRawResource(int r10) {
        return super.openRawResource(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ AssetFileDescriptor openRawResourceFd(int r10) {
        return super.openRawResourceFd(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtra(String r10, AttributeSet r11, Bundle r12) {
        super.parseBundleExtra(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser r10, Bundle r11) {
        super.parseBundleExtras(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration r10, DisplayMetrics r11) {
        super.updateConfiguration(r10, r11);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r10) {
        Context r11 = (Context) this.f1032b.get();
        if (r11 == null) goto L7;
        return ResourceManagerInternal.g().s(r11, this, r10);
    L7:
        return a(r10);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int r10, int r11, Resources.Theme r12) {
        return super.getDrawableForDensity(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getQuantityString(int r10, int r11, Object[] r12) {
        return super.getQuantityString(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getString(int r10, Object[] r11) {
        return super.getString(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getText(int r10, CharSequence r11) {
        return super.getText(r10, r11);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(String r10, TypedValue r11, boolean r12) {
        super.getValue(r10, r11, r12);
    }

    @Override // androidx.appcompat.widget.u, android.content.res.Resources
    public /* bridge */ /* synthetic */ InputStream openRawResource(int r10, TypedValue r11) {
        return super.openRawResource(r10, r11);
    }
}
