package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class GlideUrl implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final Headers headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getCacheKey().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl) == false) goto L9;
        String r100 = this.stringUrl;
        if (TextUtils.isEmpty(r100) == false) goto L7;
        r100 = ((URL) Preconditions.checkNotNull(this.url)).toString();
    L7:
        this.safeStringUrl = Uri.encode(r100, ALLOWED_URI_CHARS);
    L9:
        return this.safeStringUrl;
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl != null) goto L6;
        this.safeUrl = new URL(getSafeStringUrl());
    L6:
        return this.safeUrl;
    }

    public String getCacheKey() {
        String r100 = this.stringUrl;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return ((URL) Preconditions.checkNotNull(this.url)).toString();
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        int r100 = getCacheKey().hashCode();
        this.hashCode = r100;
        this.hashCode = (r100 * 31) + this.headers.hashCode();
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

    public GlideUrl(String r100) {
        this(r100, Headers.DEFAULT);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof GlideUrl) == false) goto L10;
        GlideUrl r101 = (GlideUrl) r100;
        if (getCacheKey().equals(r101.getCacheKey()) == true) goto L7;
        return false;
    L7:
        if (this.headers.equals(r101.headers) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }

    public GlideUrl(URL r100) {
        this(r100, Headers.DEFAULT);
    }

    public GlideUrl(URL r100, Headers r101) {
        this.url = (URL) Preconditions.checkNotNull(r100);
        this.stringUrl = null;
        this.headers = (Headers) Preconditions.checkNotNull(r101);
    }

    public GlideUrl(String r100, Headers r101) {
        this.url = null;
        this.stringUrl = Preconditions.checkNotEmpty(r100);
        this.headers = (Headers) Preconditions.checkNotNull(r101);
    }
}
