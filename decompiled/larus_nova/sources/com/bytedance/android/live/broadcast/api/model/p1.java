package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.user.VisibleListData")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/p1;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/w1;", "userList", "Ljava/util/List;", "", "total", "I", "", "hasMore", "Z", "relationType", "", "Lcom/bytedance/android/live/broadcast/api/model/x1;", "memoryGroups", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p1 implements vh7.h {

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("memory_groups")
    public List<x1> memoryGroups;

    @SerializedName("relation_type")
    public int relationType;

    @SerializedName("total")
    public int total;

    @SerializedName("users")
    public List<w1> userList;

    public p1() {
        this.userList = new ArrayList();
        this.memoryGroups = new ArrayList();
    }

    public p1(am3.g r100) {
        this.userList = new ArrayList();
        this.memoryGroups = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        if (r102 == 1) goto L20;
        if (r102 != 2) goto L10;
        this.hasMore = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.total = r100.i();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.relationType = r100.i();
        goto L3
    L14:
        if (r102 != 6) goto L15;
        List r103 = this.memoryGroups;
        vh7.h r104 = new x1(r100);
    L21:
        r103.add(r104);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L20:
        r103 = this.userList;
        r104 = new w1(r100);
        goto L21
    L22:
        r100.d(r101);
        if (this.userList.isEmpty() == false) goto L26;
        this.userList = new ArrayList();
    L26:
        if (this.memoryGroups.isEmpty() == false) goto L45;
        this.memoryGroups = new ArrayList();
        return;
    }
}
