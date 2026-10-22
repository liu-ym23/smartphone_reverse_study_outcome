package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/AppFeedBackPicEntity;", "", "name", "", "type", "size", "", ServerElements.INFO, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "getName", "getSize", "()J", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppFeedBackPicEntity {

    @NotNull
    private final String info;

    @NotNull
    private final String name;
    private final long size;

    @NotNull
    private final String type;

    public AppFeedBackPicEntity(@NotNull String r10, @NotNull String r11, long r12, @NotNull String r13) {
        q.g(r10, "name");
        q.g(r11, "type");
        q.g(r13, ServerElements.INFO);
        this.name = r10;
        this.type = r11;
        this.size = r12;
        this.info = r13;
    }

    public static /* synthetic */ AppFeedBackPicEntity copy$default(AppFeedBackPicEntity r10, String r11, String r12, long r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r12 = r10.type;
    L8:
        String r17 = r12;
        if ((r15 & 4) == 0) goto L11;
        r13 = r10.size;
    L11:
        long r18 = r13;
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.info;
    L14:
        String r19 = r11;
        return r10.copy(r19, r17, r18, r14);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    public final long component3() {
        return this.size;
    }

    @NotNull
    public final String component4() {
        return this.info;
    }

    @NotNull
    public final AppFeedBackPicEntity copy(@NotNull String r10, @NotNull String r11, long r12, @NotNull String r13) {
        q.g(r10, "name");
        q.g(r11, "type");
        q.g(r13, ServerElements.INFO);
        return new AppFeedBackPicEntity(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppFeedBackPicEntity) == true) goto L8;
        return false;
    L8:
        AppFeedBackPicEntity r11 = (AppFeedBackPicEntity) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.type, r11.type) == true) goto L15;
        return false;
    L15:
        if (this.size == r11.size) goto L18;
        return false;
    L18:
        if (q.b(this.info, r11.info) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @NotNull
    public final String getInfo() {
        return this.info;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getSize() {
        return this.size;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.size)) * 31) + this.info.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppFeedBackPicEntity(name=" + this.name + ", type=" + this.type + ", size=" + this.size + ", info=" + this.info + ')';
    }
}
