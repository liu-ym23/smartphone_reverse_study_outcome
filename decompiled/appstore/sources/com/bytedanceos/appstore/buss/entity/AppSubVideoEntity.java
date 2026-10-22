package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppSubVideoEntity;", "", ServerElements.VIDEO_IMAGE, "", "url", ServerElements.VIDEO_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDirect", "()Ljava/lang/String;", "getImg", "getUrl", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppSubVideoEntity {

    @NotNull
    private final String direct;

    @NotNull
    private final String img;

    @NotNull
    private final String url;

    public AppSubVideoEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, ServerElements.VIDEO_IMAGE);
        q.g(r11, "url");
        q.g(r12, ServerElements.VIDEO_TYPE);
        this.img = r10;
        this.url = r11;
        this.direct = r12;
    }

    public static /* synthetic */ AppSubVideoEntity copy$default(AppSubVideoEntity r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.img;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.url;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.direct;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final String component1() {
        return this.img;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final String component3() {
        return this.direct;
    }

    @NotNull
    public final AppSubVideoEntity copy(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, ServerElements.VIDEO_IMAGE);
        q.g(r11, "url");
        q.g(r12, ServerElements.VIDEO_TYPE);
        return new AppSubVideoEntity(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppSubVideoEntity) == true) goto L8;
        return false;
    L8:
        AppSubVideoEntity r11 = (AppSubVideoEntity) r10;
        if (q.b(this.img, r11.img) == true) goto L12;
        return false;
    L12:
        if (q.b(this.url, r11.url) == true) goto L15;
        return false;
    L15:
        if (q.b(this.direct, r11.direct) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getDirect() {
        return this.direct;
    }

    @NotNull
    public final String getImg() {
        return this.img;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.img.hashCode() * 31) + this.url.hashCode()) * 31) + this.direct.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppSubVideoEntity(img=" + this.img + ", url=" + this.url + ", direct=" + this.direct + ')';
    }
}
