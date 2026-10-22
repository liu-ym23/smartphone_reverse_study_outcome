package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bytedanceos.appstore.CustomAppGlideModule;
import com.bytedanceos.common.c;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final CustomAppGlideModule appGlideModule;

    public GeneratedAppGlideModuleImpl() {
        this.appGlideModule = new CustomAppGlideModule();
        if (Log.isLoggable("Glide", 3) == false) goto L6;
        Log.d("Glide", "Discovered AppGlideModule from annotation: com.bytedanceos.appstore.CustomAppGlideModule");
        Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bytedanceos.common.CustomAppCommonGlideModule");
        return;
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(@NonNull Context r10, @NonNull GlideBuilder r11) {
        this.appGlideModule.applyOptions(r10, r11);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public /* bridge */ /* synthetic */ RequestManagerRetriever.RequestManagerFactory getRequestManagerFactory() {
        return getRequestManagerFactory();
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@NonNull Context r10, @NonNull Glide r11, @NonNull Registry r12) {
        new c().registerComponents(r10, r11, r12);
        this.appGlideModule.registerComponents(r10, r11, r12);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }
}
