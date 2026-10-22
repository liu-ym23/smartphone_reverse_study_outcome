package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import com.obric.appstore.network.entity.template.PageType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/appstore/network/entity/PageTypeReq;", "Lcom/obric/appstore/network/entity/PageReq;", "pageId", "", "pageVersion", "", "pageContentId", "page", "size", "(Ljava/lang/String;ILjava/lang/Integer;II)V", "getPageContentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageId", "()Ljava/lang/String;", "getPageVersion", "()I", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PageTypeReq extends PageReq {

    @SerializedName("page_content_id")
    @Nullable
    private final Integer pageContentId;

    @SerializedName("page_id")
    @NotNull
    private final String pageId;

    @SerializedName("page_version")
    private final int pageVersion;

    public PageTypeReq() {
        String r10 = null;
        int r11 = 0;
        Integer r12 = null;
        int r13 = 0;
        int r14 = 0;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    @Nullable
    public final Integer getPageContentId() {
        return this.pageContentId;
    }

    @NotNull
    public final String getPageId() {
        return this.pageId;
    }

    public final int getPageVersion() {
        return this.pageVersion;
    }

    public /* synthetic */ PageTypeReq(String r10, int r11, Integer r12, int r13, int r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = PageType.UNKNOWN.getValue();
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = 2;
    L8:
        int r17 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = null;
    L11:
        Integer r18 = r12;
        if ((r15 & 8) == 0) goto L14;
        r13 = 1;
    L14:
        int r19 = r13;
        if ((r15 & 16) == 0) goto L17;
        r14 = 20;
    L17:
        String r20 = r10;
        this(r20, r17, r18, r19, r14);
    }

    public PageTypeReq(@NotNull String r10, int r11, @Nullable Integer r12, int r13, int r14) {
        q.g(r10, "pageId");
        super(r13, r14);
        this.pageId = r10;
        this.pageVersion = r11;
        this.pageContentId = r12;
    }
}
