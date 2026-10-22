package com.obric.appstore.network.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/obric/appstore/network/entity/CategoryListReq;", "Lcom/obric/appstore/network/entity/PageReq;", "cid1", "", "cid2", "page", "", "size", "(JJII)V", "getCid1", "()J", "getCid2", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryListReq extends PageReq {

    @SerializedName("CID1")
    private final long cid1;

    @SerializedName("CID2")
    private final long cid2;

    public CategoryListReq() {
        long r10 = 0;
        long r11 = 0;
        int r12 = 0;
        int r13 = 0;
        this(r10, r11, r12, r13, 15, null);
    }

    public final long getCid1() {
        return this.cid1;
    }

    public final long getCid2() {
        return this.cid2;
    }

    public /* synthetic */ CategoryListReq(long r10, long r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = 1;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = 20;
    L14:
        this(r10, r11, r12, r13);
    }

    public CategoryListReq(long r10, long r11, int r12, int r13) {
        super(r12, r13);
        this.cid1 = r10;
        this.cid2 = r11;
    }
}
