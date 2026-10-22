package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.android.live.uikit.toast.CustomToast;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    public static final Option<Integer> TIMEOUT = null;
    private final ModelCache<GlideUrl, GlideUrl> modelCache;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private final ModelCache<GlideUrl, GlideUrl> modelCache;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory() {
            this.modelCache = new ModelCache(500);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory r100) {
            return new HttpGlideUrlLoader(this.modelCache);
        }
    }

    public HttpGlideUrlLoader() {
        this(null);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(GlideUrl r100) {
        return true;
    }

    static {
        TIMEOUT = Option.memory("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(CustomToast.LENGTH_SHORT));
    }

    public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> r100) {
        this.modelCache = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(GlideUrl r100) {
        return handles2(r100);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<InputStream> buildLoadData2(GlideUrl r100, int r101, int r102, Options r103) {
        ModelCache<GlideUrl, GlideUrl> r104 = this.modelCache;
        if (r104 == null) goto L9;
        GlideUrl r105 = r104.get(r100, 0, 0);
        if (r105 != null) goto L7;
        this.modelCache.put(r100, 0, 0, r100);
        goto L9
    L7:
        r100 = r105;
    L9:
        return new ModelLoader.LoadData(r100, new HttpUrlFetcher(r100, ((Integer) r103.get(TIMEOUT)).intValue()));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<InputStream> buildLoadData(GlideUrl r100, int r101, int r102, Options r103) {
        return buildLoadData2(r100, r101, r102, r103);
    }
}
