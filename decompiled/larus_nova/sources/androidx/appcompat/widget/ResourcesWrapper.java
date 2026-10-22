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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class ResourcesWrapper extends Resources {
    private final Resources mResources;

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return INVOKEVIRTUAL_androidx_appcompat_widget_ResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mResources);
    }

    public ResourcesWrapper(Resources r100) {
        super(r100.getAssets(), INVOKEVIRTUAL_androidx_appcompat_widget_ResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100), r100.getConfiguration());
        this.mResources = r100;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ResourcesWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int r100) throws Resources.NotFoundException {
        return this.mResources.getAnimation(r100);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int r100) throws Resources.NotFoundException {
        return this.mResources.getBoolean(r100);
    }

    @Override // android.content.res.Resources
    public int getColor(int r100) throws Resources.NotFoundException {
        return this.mResources.getColor(r100);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r100) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(r100);
    }

    @Override // android.content.res.Resources
    public float getDimension(int r100) throws Resources.NotFoundException {
        return this.mResources.getDimension(r100);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int r100) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(r100);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int r100) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(r100);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r100) throws Resources.NotFoundException {
        return this.mResources.getDrawable(r100);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int r100) throws Resources.NotFoundException {
        return this.mResources.getIntArray(r100);
    }

    @Override // android.content.res.Resources
    public int getInteger(int r100) throws Resources.NotFoundException {
        return this.mResources.getInteger(r100);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int r100) throws Resources.NotFoundException {
        return this.mResources.getLayout(r100);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int r100) throws Resources.NotFoundException {
        return this.mResources.getMovie(r100);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(r100);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourceName(r100);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(r100);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int r100) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(r100);
    }

    @Override // android.content.res.Resources
    public String getString(int r100) throws Resources.NotFoundException {
        return this.mResources.getString(r100);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int r100) throws Resources.NotFoundException {
        return this.mResources.getStringArray(r100);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r100) throws Resources.NotFoundException {
        return this.mResources.getText(r100);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int r100) throws Resources.NotFoundException {
        return this.mResources.getTextArray(r100);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int r100) throws Resources.NotFoundException {
        return this.mResources.getXml(r100);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int r100) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(r100);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r100) throws Resources.NotFoundException {
        return this.mResources.openRawResource(r100);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int r100) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(r100);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r100, Resources.Theme r101) throws Resources.NotFoundException {
        return this.mResources.getDrawable(r100, r101);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r100, int r101) throws Resources.NotFoundException {
        return this.mResources.getDrawableForDensity(r100, r101);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r100, int r101) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(r100, r101);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int r100, int r101) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(r100, r101);
    }

    @Override // android.content.res.Resources
    public String getString(int r100, Object... r101) throws Resources.NotFoundException {
        return this.mResources.getString(r100, r101);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r100, CharSequence r101) {
        return this.mResources.getText(r100, r101);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet r100, int[] r101) {
        return this.mResources.obtainAttributes(r100, r101);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r100, TypedValue r101) throws Resources.NotFoundException {
        return this.mResources.openRawResource(r100, r101);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser r100, Bundle r101) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(r100, r101);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration r100, DisplayMetrics r101) {
        super.updateConfiguration(r100, r101);
        Resources r102 = this.mResources;
        if (r102 == null) goto L6;
        r102.updateConfiguration(r100, r101);
        return;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int r100, int r101, Resources.Theme r102) {
        return this.mResources.getDrawableForDensity(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public float getFraction(int r100, int r101, int r102) {
        return this.mResources.getFraction(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String r100, String r101, String r102) {
        return this.mResources.getIdentifier(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r100, int r101, Object... r102) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public void getValue(int r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        this.mResources.getValue(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String r100, AttributeSet r101, Bundle r102) throws XmlPullParserException {
        this.mResources.parseBundleExtra(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public void getValue(String r100, TypedValue r101, boolean r102) throws Resources.NotFoundException {
        this.mResources.getValue(r100, r101, r102);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int r100, int r101, TypedValue r102, boolean r103) throws Resources.NotFoundException {
        this.mResources.getValueForDensity(r100, r101, r102, r103);
    }
}
