package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    static class a {
        static Context a(ContextThemeWrapper r2, Configuration r3) {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextThemeWrapper) ZeusTransformUtils.wrapperContextForParams(r2, ContextThemeWrapper.class, "com.obric.aiagent.plugin")).createConfigurationContext(r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }
    }

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context r3, int r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mThemeResource = r4;
    }

    public ContextThemeWrapper(Context r3, Resources.Theme r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        this.mTheme = r4;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r3) {
        super.attachBaseContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public void applyOverrideConfiguration(Configuration r2) {
        if (this.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r2);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L17;
        if (this.mOverrideConfiguration != null) goto L7;
    L15:
        this.mResources = super.getResources();
        goto L17
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (isEmptyConfiguration(this.mOverrideConfiguration) == true) goto L15;
    L12:
        if (Build.VERSION.SDK_INT < 17) goto L14;
        this.mResources = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(this, this.mOverrideConfiguration), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        goto L17
    L14:
        Resources r0 = super.getResources();
        Configuration r1 = new Configuration(r0.getConfiguration());
        r1.updateFrom(this.mOverrideConfiguration);
        this.mResources = new Resources(r0.getAssets(), r0.getDisplayMetrics(), r1);
    L17:
        return this.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        if (this.mThemeResource == r2) goto L6;
        this.mThemeResource = r2;
        initializeTheme();
        return;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r0 = this.mTheme;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mThemeResource != 0) goto L8;
        this.mThemeResource = ZeusTransformUtils.mapRes(R.style.Theme_AppCompat_Light, "style", "Theme_AppCompat_Light");
    L8:
        initializeTheme();
        return this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r3) {
        if ("layout_inflater".equals(r3) == false) goto L10;
        if (this.mInflater != null) goto L8;
        this.mInflater = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).cloneInContext(this);
    L8:
        return this.mInflater;
    L10:
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService(r3);
    }

    public void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        r1.applyStyle(r2, true);
    }

    private void initializeTheme() {
        if (this.mTheme != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.mTheme = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").newTheme();
        Resources.Theme r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme();
        if (r1 == null) goto L10;
        this.mTheme.setTo(r1);
    L10:
        onApplyThemeResource(this.mTheme, this.mThemeResource, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getAssets();
    }

    private static boolean isEmptyConfiguration(Configuration r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        if (sEmptyConfig != null) goto L9;
        Configuration r0 = new Configuration();
        r0.fontScale = 0.0f;
        sEmptyConfig = r0;
    L9:
        return r2.equals(sEmptyConfig);
    }
}
