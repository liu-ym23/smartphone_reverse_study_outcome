package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppManagerEmptyEntity;", "", "leftIconRes", "", "title", "", "desc", "(ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getLeftIconRes", "()I", "getTitle", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppManagerEmptyEntity {

    @NotNull
    private final String desc;
    private final int leftIconRes;

    @NotNull
    private final String title;

    public AppManagerEmptyEntity(int r10, @NotNull String r11, @NotNull String r12) {
        q.g(r11, "title");
        q.g(r12, "desc");
        this.leftIconRes = r10;
        this.title = r11;
        this.desc = r12;
    }

    public static /* synthetic */ AppManagerEmptyEntity copy$default(AppManagerEmptyEntity r10, int r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.leftIconRes;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.title;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.desc;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final int component1() {
        return this.leftIconRes;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.desc;
    }

    @NotNull
    public final AppManagerEmptyEntity copy(int r10, @NotNull String r11, @NotNull String r12) {
        q.g(r11, "title");
        q.g(r12, "desc");
        return new AppManagerEmptyEntity(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppManagerEmptyEntity) == true) goto L8;
        return false;
    L8:
        AppManagerEmptyEntity r11 = (AppManagerEmptyEntity) r10;
        if (this.leftIconRes == r11.leftIconRes) goto L12;
        return false;
    L12:
        if (q.b(this.title, r11.title) == true) goto L15;
        return false;
    L15:
        if (q.b(this.desc, r11.desc) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getLeftIconRes() {
        return this.leftIconRes;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.leftIconRes) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppManagerEmptyEntity(leftIconRes=" + this.leftIconRes + ", title=" + this.title + ", desc=" + this.desc + ')';
    }
}
