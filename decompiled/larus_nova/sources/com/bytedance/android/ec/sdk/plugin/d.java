package com.bytedance.android.ec.sdk.plugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f48152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f48153b;

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return this.f48152a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f48152a.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        return this.f48152a.getTheme();
    }

    public d(Context r100) {
        super(r100);
        this.f48152a = new ContextThemeWrapper(getApplicationContext(), R.style.ECommerceAppTheme);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String r100) {
        if ("layout_inflater".equals(r100) == true) goto L7;
        return super.getSystemService(r100);
    L7:
        if (this.f48153b != null) goto L10;
        this.f48153b = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L10:
        return this.f48153b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int r100) {
        this.f48152a.setTheme(r100);
    }
}
