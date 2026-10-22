package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<Model, GlideUrl> modelCache;

    public abstract String getUrl(Model r100, int r101, int r102, Options r103);

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> r100) {
        this(r100, null);
    }

    private static List<Key> getAlternateKeys(Collection<String> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new GlideUrl(r102.next()));
        goto L4
    L6:
        return r101;
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> r100, ModelCache<Model, GlideUrl> r101) {
        this.concreteLoader = r100;
        this.modelCache = r101;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(Model r100, int r101, int r102, Options r103) {
        ModelCache<Model, GlideUrl> r104 = this.modelCache;
        if (r104 == null) goto L5;
        GlideUrl r105 = r104.get(r100, r101, r102);
    L6:
        if (r105 != null) goto L14;
        String r106 = getUrl(r100, r101, r102, r103);
        if (TextUtils.isEmpty(r106) == false) goto L10;
        return null;
    L10:
        GlideUrl r107 = new GlideUrl(r106, getHeaders(r100, r101, r102, r103));
        ModelCache<Model, GlideUrl> r108 = this.modelCache;
        if (r108 == null) goto L13;
        r108.put(r100, r101, r102, r107);
    L13:
        r105 = r107;
    L14:
        List<String> r109 = getAlternateUrls(r100, r101, r102, r103);
        ModelLoader.LoadData<InputStream> r110 = this.concreteLoader.buildLoadData(r105, r101, r102, r103);
        if (r110 != null) goto L17;
    L21:
        return r110;
    L17:
        if (r109.isEmpty() == true) goto L21;
        return new ModelLoader.LoadData(r110.sourceKey, getAlternateKeys(r109), r110.fetcher);
    L5:
        r105 = null;
        goto L6
    }

    public List<String> getAlternateUrls(Model r100, int r101, int r102, Options r103) {
        return Collections.emptyList();
    }

    public Headers getHeaders(Model r100, int r101, int r102, Options r103) {
        return Headers.DEFAULT;
    }
}
