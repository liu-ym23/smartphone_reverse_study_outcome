package com.bytedanceos.appstore.buss.entity;

import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppFeedBackItemEntity;", "", "uri", "Landroid/net/Uri;", "appPackageName", "", "(Landroid/net/Uri;Ljava/lang/String;)V", "getAppPackageName", "()Ljava/lang/String;", "setAppPackageName", "(Ljava/lang/String;)V", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppFeedBackItemEntity {

    @Nullable
    private String appPackageName;

    @Nullable
    private Uri uri;

    /* JADX WARN: Multi-variable type inference failed */
    public AppFeedBackItemEntity() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AppFeedBackItemEntity copy$default(AppFeedBackItemEntity r10, Uri r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.uri;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.appPackageName;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final Uri component1() {
        return this.uri;
    }

    @Nullable
    public final String component2() {
        return this.appPackageName;
    }

    @NotNull
    public final AppFeedBackItemEntity copy(@Nullable Uri r10, @Nullable String r11) {
        return new AppFeedBackItemEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppFeedBackItemEntity) == true) goto L8;
        return false;
    L8:
        AppFeedBackItemEntity r11 = (AppFeedBackItemEntity) r10;
        if (q.b(this.uri, r11.uri) == true) goto L12;
        return false;
    L12:
        if (q.b(this.appPackageName, r11.appPackageName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getAppPackageName() {
        return this.appPackageName;
    }

    @Nullable
    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        Uri r10 = this.uri;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.appPackageName;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setAppPackageName(@Nullable String r10) {
        this.appPackageName = r10;
    }

    public final void setUri(@Nullable Uri r10) {
        this.uri = r10;
    }

    @NotNull
    public String toString() {
        return "AppFeedBackItemEntity(uri=" + this.uri + ", appPackageName=" + this.appPackageName + ')';
    }

    public AppFeedBackItemEntity(@Nullable Uri r10, @Nullable String r11) {
        this.uri = r10;
        this.appPackageName = r11;
    }

    public /* synthetic */ AppFeedBackItemEntity(Uri r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
