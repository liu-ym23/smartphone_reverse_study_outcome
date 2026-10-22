package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    public ContextThemeWrapper() {
        super(null);
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L9;
        Configuration r100 = this.mOverrideConfiguration;
        if (r100 != null) goto L7;
        this.mResources = super.getResources();
        goto L9
    L7:
        Context r101 = createConfigurationContext(r100);
        NewMiraResourcesManager.getInstance().install(r101);
        this.mResources = r101.getResources();
    L9:
        return this.mResources;
    }

    private void initializeTheme() {
        if (this.mTheme != null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        this.mTheme = getResources().newTheme();
        Resources.Theme r101 = getBaseContext().getTheme();
        if (r101 == null) goto L10;
        this.mTheme.setTo(r101);
    L10:
        onApplyThemeResource(this.mTheme, this.mThemeResource, r100);
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r100 = this.mTheme;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.mThemeResource != 0) goto L8;
        this.mThemeResource = R.style.Theme_AppCompat_Light;
    L8:
        initializeTheme();
        return this.mTheme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_ContextThemeWrapper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void applyOverrideConfiguration(Configuration r100) {
        if (this.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r100);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r100) {
        if ("layout_inflater".equals(r100) == false) goto L10;
        if (this.mInflater != null) goto L8;
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.mInflater;
    L10:
        return getBaseContext().getSystemService(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r100) {
        if (this.mThemeResource == r100) goto L6;
        this.mThemeResource = r100;
        initializeTheme();
        return;
    }

    public ContextThemeWrapper(Context r100, int r101) {
        super(r100);
        this.mThemeResource = r101;
    }

    public ContextThemeWrapper(Context r100, Resources.Theme r101) {
        super(r100);
        this.mTheme = r101;
    }

    public void onApplyThemeResource(Resources.Theme r100, int r101, boolean r102) {
        r100.applyStyle(r101, true);
    }
}
