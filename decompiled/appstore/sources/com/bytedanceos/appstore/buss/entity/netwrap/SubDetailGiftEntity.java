package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/SubDetailGiftEntity;", "", "name", "", "num", ServerElements.SECOND_BAR_PIC, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getNum", "getPic", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubDetailGiftEntity {

    @NotNull
    private final String name;

    @NotNull
    private final String num;

    @NotNull
    private final String pic;

    public SubDetailGiftEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, "name");
        q.g(r11, "num");
        q.g(r12, ServerElements.SECOND_BAR_PIC);
        this.name = r10;
        this.num = r11;
        this.pic = r12;
    }

    public static /* synthetic */ SubDetailGiftEntity copy$default(SubDetailGiftEntity r10, String r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.name;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.num;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.pic;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.num;
    }

    @NotNull
    public final String component3() {
        return this.pic;
    }

    @NotNull
    public final SubDetailGiftEntity copy(@NotNull String r10, @NotNull String r11, @NotNull String r12) {
        q.g(r10, "name");
        q.g(r11, "num");
        q.g(r12, ServerElements.SECOND_BAR_PIC);
        return new SubDetailGiftEntity(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubDetailGiftEntity) == true) goto L8;
        return false;
    L8:
        SubDetailGiftEntity r11 = (SubDetailGiftEntity) r10;
        if (q.b(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (q.b(this.num, r11.num) == true) goto L15;
        return false;
    L15:
        if (q.b(this.pic, r11.pic) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNum() {
        return this.num;
    }

    @NotNull
    public final String getPic() {
        return this.pic;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.num.hashCode()) * 31) + this.pic.hashCode();
    }

    @NotNull
    public String toString() {
        return "SubDetailGiftEntity(name=" + this.name + ", num=" + this.num + ", pic=" + this.pic + ')';
    }
}
