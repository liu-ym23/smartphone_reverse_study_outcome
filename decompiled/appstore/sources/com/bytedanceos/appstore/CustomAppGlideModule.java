package com.bytedanceos.appstore;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes2.dex */
@GlideModule
public class CustomAppGlideModule extends AppGlideModule {

    public class a implements RequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomAppGlideModule f8261a;

        public a(CustomAppGlideModule r10) {
            this.f8261a = r10;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException r10, Object r11, Target r12, boolean r13) {
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Object r10, Object r11, Target r12, DataSource r13, boolean r14) {
            return false;
        }
    }

    public CustomAppGlideModule() {
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context r10, GlideBuilder r11) {
        super.applyOptions(r10, r11);
        r11.setLogLevel(6);
        r11.addGlobalRequestListener(new a(this));
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context r10, Glide r11, Registry r12) {
        super.registerComponents(r10, r11, r12);
        r12.append(String.class, Bitmap.class, new ke.b.C0289b(r10));
        r12.append(String.class, Bitmap.class, new ke.a.b(r10));
    }
}
