package com.bumptech.glide.integration.webp.decoder;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final class WebpFrameCacheStrategy {
    public static final WebpFrameCacheStrategy ALL = null;
    public static final WebpFrameCacheStrategy AUTO = null;
    public static final WebpFrameCacheStrategy NONE = null;
    private int mCacheSize;
    private CacheControl mCacheStrategy;

    /* JADX INFO: renamed from: com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private CacheControl cacheControl;
        private int cacheSize;

        public Builder() {
        }

        public WebpFrameCacheStrategy build() {
            return new WebpFrameCacheStrategy(this, null);
        }

        public Builder cacheAll() {
            this.cacheControl = CacheControl.CACHE_ALL;
            return this;
        }

        public Builder cacheAuto() {
            this.cacheControl = CacheControl.CACHE_AUTO;
            return this;
        }

        public Builder cacheLimited() {
            this.cacheControl = CacheControl.CACHE_LIMITED;
            return this;
        }

        public Builder noCache() {
            this.cacheControl = CacheControl.CACHE_NONE;
            return this;
        }

        public static /* synthetic */ CacheControl access$000(Builder r100) {
            return r100.cacheControl;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.cacheSize;
        }

        public Builder cacheControl(CacheControl r100) {
            this.cacheControl = r100;
            return this;
        }

        public Builder cacheSize(int r100) {
            this.cacheSize = r100;
            if (r100 != 0) goto L6;
            this.cacheControl = CacheControl.CACHE_NONE;
        L9:
            return this;
        L6:
            if (r100 != Integer.MAX_VALUE) goto L8;
            this.cacheControl = CacheControl.CACHE_ALL;
            goto L9
        L8:
            this.cacheControl = CacheControl.CACHE_LIMITED;
            goto L9
        }
    }

    public static final enum CacheControl extends Enum<CacheControl> {
        private static final /* synthetic */ CacheControl[] $VALUES = null;
        public static final CacheControl CACHE_ALL = null;
        public static final CacheControl CACHE_AUTO = null;
        public static final CacheControl CACHE_LIMITED = null;
        public static final CacheControl CACHE_NONE = null;

        static {
            CacheControl r100 = new CacheControl("CACHE_NONE", 0);
            CACHE_NONE = r100;
            CacheControl r101 = new CacheControl("CACHE_LIMITED", 1);
            CACHE_LIMITED = r101;
            CacheControl r102 = new CacheControl("CACHE_AUTO", 2);
            CACHE_AUTO = r102;
            CacheControl r103 = new CacheControl("CACHE_ALL", 3);
            CACHE_ALL = r103;
            $VALUES = new CacheControl[]{r100, r101, r102, r103};
        }

        public static CacheControl[] values() {
            return (CacheControl[]) $VALUES.clone();
        }

        public static CacheControl valueOf(String r100) {
            return (CacheControl) a.a(CacheControl.class, r100);
        }

        private CacheControl(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        NONE = new Builder().noCache().build();
        AUTO = new Builder().cacheAuto().build();
        ALL = new Builder().cacheAll().build();
    }

    public boolean cacheAll() {
        if (this.mCacheStrategy != CacheControl.CACHE_ALL) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean cacheAuto() {
        if (this.mCacheStrategy != CacheControl.CACHE_AUTO) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean noCache() {
        if (this.mCacheStrategy != CacheControl.CACHE_NONE) goto L5;
        return true;
    L5:
        return false;
    }

    public CacheControl getCacheControl() {
        return this.mCacheStrategy;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    private WebpFrameCacheStrategy(Builder r100) {
        this.mCacheStrategy = Builder.access$000(r100);
        this.mCacheSize = Builder.access$100(r100);
    }

    public /* synthetic */ WebpFrameCacheStrategy(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
