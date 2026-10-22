package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GlideUrl implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";

    @Nullable
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final Headers headers;

    @Nullable
    private String safeStringUrl;

    @Nullable
    private URL safeUrl;

    @Nullable
    private final String stringUrl;

    @Nullable
    private final URL url;

    public GlideUrl(URL r10) {
        this(r10, Headers.DEFAULT);
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getCacheKey().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl) == false) goto L9;
        String r10 = this.stringUrl;
        if (TextUtils.isEmpty(r10) == false) goto L7;
        r10 = ((URL) Preconditions.checkNotNull(this.url)).toString();
    L7:
        this.safeStringUrl = Uri.encode(r10, ALLOWED_URI_CHARS);
    L9:
        return this.safeStringUrl;
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl != null) goto L6;
        this.safeUrl = new URL(getSafeStringUrl());
    L6:
        return this.safeUrl;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof GlideUrl) == false) goto L10;
        GlideUrl r11 = (GlideUrl) r10;
        if (getCacheKey().equals(r11.getCacheKey()) == true) goto L7;
        return false;
    L7:
        if (this.headers.equals(r11.headers) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public String getCacheKey() {
        String r10 = this.stringUrl;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return ((URL) Preconditions.checkNotNull(this.url)).toString();
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        int r10 = getCacheKey().hashCode();
        this.hashCode = r10;
        this.hashCode = (r10 * 31) + this.headers.hashCode();
    L6:
        return this.hashCode;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest r10) {
        r10.update(getCacheKeyBytes());
    }

    public GlideUrl(String r10) {
        this(r10, Headers.DEFAULT);
    }

    public GlideUrl(URL r10, Headers r11) {
        this.url = (URL) Preconditions.checkNotNull(r10);
        this.stringUrl = null;
        this.headers = (Headers) Preconditions.checkNotNull(r11);
    }

    public GlideUrl(String r10, Headers r11) {
        this.url = null;
        this.stringUrl = Preconditions.checkNotEmpty(r10);
        this.headers = (Headers) Preconditions.checkNotNull(r11);
    }
}
