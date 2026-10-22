package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;

    @Nullable
    private final ModelCache<Model, GlideUrl> modelCache;

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> r10) {
        this(r10, null);
    }

    private static List<Key> getAlternateKeys(Collection<String> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(new GlideUrl(r12.next()));
        goto L4
    L6:
        return r11;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Model r10, int r11, int r12, @NonNull Options r13) {
        ModelCache<Model, GlideUrl> r14 = this.modelCache;
        if (r14 == null) goto L5;
        GlideUrl r15 = r14.get(r10, r11, r12);
    L6:
        if (r15 != null) goto L14;
        String r16 = getUrl(r10, r11, r12, r13);
        if (TextUtils.isEmpty(r16) == false) goto L10;
        return null;
    L10:
        GlideUrl r17 = new GlideUrl(r16, getHeaders(r10, r11, r12, r13));
        ModelCache<Model, GlideUrl> r18 = this.modelCache;
        if (r18 == null) goto L13;
        r18.put(r10, r11, r12, r17);
    L13:
        r15 = r17;
    L14:
        List<String> r19 = getAlternateUrls(r10, r11, r12, r13);
        ModelLoader.LoadData<InputStream> r20 = this.concreteLoader.buildLoadData(r15, r11, r12, r13);
        if (r20 != null) goto L17;
    L21:
        return r20;
    L17:
        if (r19.isEmpty() == true) goto L21;
        return new ModelLoader.LoadData(r20.sourceKey, getAlternateKeys(r19), r20.fetcher);
    L5:
        r15 = null;
        goto L6
    }

    public List<String> getAlternateUrls(Model r10, int r11, int r12, Options r13) {
        return Collections.emptyList();
    }

    @Nullable
    public Headers getHeaders(Model r10, int r11, int r12, Options r13) {
        return Headers.DEFAULT;
    }

    public abstract String getUrl(Model r10, int r11, int r12, Options r13);

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> r10, @Nullable ModelCache<Model, GlideUrl> r11) {
        this.concreteLoader = r10;
        this.modelCache = r11;
    }
}
