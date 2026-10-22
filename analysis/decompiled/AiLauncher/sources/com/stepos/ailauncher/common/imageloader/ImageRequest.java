package com.stepos.ailauncher.common.imageloader;

import android.graphics.drawable.Drawable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import io.requery.android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b(\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b,\u0010+R\u0017\u0010\t\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b-\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b.\u0010\u001fR\u0017\u0010\u000b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b/\u0010\u001fR\u0017\u0010\f\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b0\u0010\u001fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b2\u00103R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u000f\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u0010\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b7\u00103R\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0011\u00101\u001a\u0004\b8\u00103R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u00101\u001a\u0004\b9\u00103R\u0017\u0010\u0013\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0013\u00101\u001a\u0004\b:\u00103R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0018\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\bA\u00103¨\u0006B"}, d2 = {"Lcom/stepos/ailauncher/common/imageloader/i;", "", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "placeholderResId", "errorResId", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "errorDrawable", "cornerRadiusDp", "topCornerRadiusDp", "overrideWidth", "overrideHeight", "", "centerCrop", "crossFadeMs", "dontAnimate", "preferRgb565", "forceArgb8888", "skipMemoryCache", "Lcom/stepos/ailauncher/common/imageloader/DiskCache;", "diskCache", "", "thumbnailSizeMultiplier", "sizeSoftCap", "<init>", "(Ljava/lang/Object;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;IIIIZLjava/lang/Integer;ZZZZLcom/stepos/ailauncher/common/imageloader/DiskCache;FZ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Object;", "I", "m", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/graphics/drawable/Drawable;", "l", "()Landroid/graphics/drawable/Drawable;", "f", Const.INTENT_KEY_PKGNAME, "r", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Z", Const.INTENT_KEY_APIKEY, "()Z", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "e", "n", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "p", "Lcom/stepos/ailauncher/common/imageloader/DiskCache;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/common/imageloader/DiskCache;", "F", "q", "()F", "o", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.imageloader.i, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ImageRequest {
    private final boolean centerCrop;
    private final int cornerRadiusDp;
    private final Integer crossFadeMs;
    private final DiskCache diskCache;
    private final boolean dontAnimate;
    private final Drawable errorDrawable;
    private final int errorResId;
    private final boolean forceArgb8888;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private final Drawable placeholderDrawable;
    private final int placeholderResId;
    private final boolean preferRgb565;
    private final boolean sizeSoftCap;
    private final boolean skipMemoryCache;
    private final float thumbnailSizeMultiplier;
    private final int topCornerRadiusDp;

    public ImageRequest(Object obj, int i10, int i11, Drawable drawable, Drawable drawable2, int i12, int i13, int i14, int i15, boolean z10, Integer num, boolean z11, boolean z12, boolean z13, boolean z14, DiskCache diskCache, float f10, boolean z15) {
        p.i(diskCache, "diskCache");
        this.model = obj;
        this.placeholderResId = i10;
        this.errorResId = i11;
        this.placeholderDrawable = drawable;
        this.errorDrawable = drawable2;
        this.cornerRadiusDp = i12;
        this.topCornerRadiusDp = i13;
        this.overrideWidth = i14;
        this.overrideHeight = i15;
        this.centerCrop = z10;
        this.crossFadeMs = num;
        this.dontAnimate = z11;
        this.preferRgb565 = z12;
        this.forceArgb8888 = z13;
        this.skipMemoryCache = z14;
        this.diskCache = diskCache;
        this.thumbnailSizeMultiplier = f10;
        this.sizeSoftCap = z15;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCenterCrop() {
        return this.centerCrop;
    }

    /* renamed from: b, reason: from getter */
    public final int getCornerRadiusDp() {
        return this.cornerRadiusDp;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getCrossFadeMs() {
        return this.crossFadeMs;
    }

    /* renamed from: d, reason: from getter */
    public final DiskCache getDiskCache() {
        return this.diskCache;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getDontAnimate() {
        return this.dontAnimate;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) other;
        return p.d(this.model, imageRequest.model) && this.placeholderResId == imageRequest.placeholderResId && this.errorResId == imageRequest.errorResId && p.d(this.placeholderDrawable, imageRequest.placeholderDrawable) && p.d(this.errorDrawable, imageRequest.errorDrawable) && this.cornerRadiusDp == imageRequest.cornerRadiusDp && this.topCornerRadiusDp == imageRequest.topCornerRadiusDp && this.overrideWidth == imageRequest.overrideWidth && this.overrideHeight == imageRequest.overrideHeight && this.centerCrop == imageRequest.centerCrop && p.d(this.crossFadeMs, imageRequest.crossFadeMs) && this.dontAnimate == imageRequest.dontAnimate && this.preferRgb565 == imageRequest.preferRgb565 && this.forceArgb8888 == imageRequest.forceArgb8888 && this.skipMemoryCache == imageRequest.skipMemoryCache && this.diskCache == imageRequest.diskCache && Float.compare(this.thumbnailSizeMultiplier, imageRequest.thumbnailSizeMultiplier) == 0 && this.sizeSoftCap == imageRequest.sizeSoftCap;
    }

    /* renamed from: f, reason: from getter */
    public final Drawable getErrorDrawable() {
        return this.errorDrawable;
    }

    /* renamed from: g, reason: from getter */
    public final int getErrorResId() {
        return this.errorResId;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getForceArgb8888() {
        return this.forceArgb8888;
    }

    public int hashCode() {
        Object obj = this.model;
        int iHashCode = (((((obj == null ? 0 : obj.hashCode()) * 31) + Integer.hashCode(this.placeholderResId)) * 31) + Integer.hashCode(this.errorResId)) * 31;
        Drawable drawable = this.placeholderDrawable;
        int iHashCode2 = (iHashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
        Drawable drawable2 = this.errorDrawable;
        int iHashCode3 = (((((((((((iHashCode2 + (drawable2 == null ? 0 : drawable2.hashCode())) * 31) + Integer.hashCode(this.cornerRadiusDp)) * 31) + Integer.hashCode(this.topCornerRadiusDp)) * 31) + Integer.hashCode(this.overrideWidth)) * 31) + Integer.hashCode(this.overrideHeight)) * 31) + Boolean.hashCode(this.centerCrop)) * 31;
        Integer num = this.crossFadeMs;
        return ((((((((((((((iHashCode3 + (num != null ? num.hashCode() : 0)) * 31) + Boolean.hashCode(this.dontAnimate)) * 31) + Boolean.hashCode(this.preferRgb565)) * 31) + Boolean.hashCode(this.forceArgb8888)) * 31) + Boolean.hashCode(this.skipMemoryCache)) * 31) + this.diskCache.hashCode()) * 31) + Float.hashCode(this.thumbnailSizeMultiplier)) * 31) + Boolean.hashCode(this.sizeSoftCap);
    }

    /* renamed from: i, reason: from getter */
    public final Object getModel() {
        return this.model;
    }

    /* renamed from: j, reason: from getter */
    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    /* renamed from: k, reason: from getter */
    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    /* renamed from: l, reason: from getter */
    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    /* renamed from: m, reason: from getter */
    public final int getPlaceholderResId() {
        return this.placeholderResId;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getPreferRgb565() {
        return this.preferRgb565;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getSizeSoftCap() {
        return this.sizeSoftCap;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getSkipMemoryCache() {
        return this.skipMemoryCache;
    }

    /* renamed from: q, reason: from getter */
    public final float getThumbnailSizeMultiplier() {
        return this.thumbnailSizeMultiplier;
    }

    /* renamed from: r, reason: from getter */
    public final int getTopCornerRadiusDp() {
        return this.topCornerRadiusDp;
    }

    public String toString() {
        return "ImageRequest(model=" + this.model + ", placeholderResId=" + this.placeholderResId + ", errorResId=" + this.errorResId + ", placeholderDrawable=" + this.placeholderDrawable + ", errorDrawable=" + this.errorDrawable + ", cornerRadiusDp=" + this.cornerRadiusDp + ", topCornerRadiusDp=" + this.topCornerRadiusDp + ", overrideWidth=" + this.overrideWidth + ", overrideHeight=" + this.overrideHeight + ", centerCrop=" + this.centerCrop + ", crossFadeMs=" + this.crossFadeMs + ", dontAnimate=" + this.dontAnimate + ", preferRgb565=" + this.preferRgb565 + ", forceArgb8888=" + this.forceArgb8888 + ", skipMemoryCache=" + this.skipMemoryCache + ", diskCache=" + this.diskCache + ", thumbnailSizeMultiplier=" + this.thumbnailSizeMultiplier + ", sizeSoftCap=" + this.sizeSoftCap + ")";
    }

    public /* synthetic */ ImageRequest(Object obj, int i10, int i11, Drawable drawable, Drawable drawable2, int i12, int i13, int i14, int i15, boolean z10, Integer num, boolean z11, boolean z12, boolean z13, boolean z14, DiskCache diskCache, float f10, boolean z15, int i16, kotlin.jvm.internal.i iVar) {
        this(obj, (i16 & 2) != 0 ? 0 : i10, (i16 & 4) != 0 ? 0 : i11, (i16 & 8) != 0 ? null : drawable, (i16 & 16) != 0 ? null : drawable2, (i16 & 32) != 0 ? 0 : i12, (i16 & 64) != 0 ? 0 : i13, (i16 & 128) != 0 ? 0 : i14, (i16 & 256) != 0 ? 0 : i15, (i16 & 512) != 0 ? false : z10, (i16 & 1024) == 0 ? num : null, (i16 & 2048) != 0 ? false : z11, (i16 & 4096) != 0 ? false : z12, (i16 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? false : z13, (i16 & 16384) == 0 ? z14 : false, (32768 & i16) != 0 ? DiskCache.AUTOMATIC : diskCache, (i16 & 65536) != 0 ? 0.0f : f10, (i16 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? true : z15);
    }
}
