package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/s;", "", "", "content", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/ktv/common/model/api/t;", "poses", "Ljava/util/List;", "d", "()Ljava/util/List;", "setPoses", "(Ljava/util/List;)V", "color", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setColor", "groupId", "c", "setGroupId", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s implements vh7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f69987a;

    @SerializedName("color")
    protected String color;

    @SerializedName("content")
    protected String content;

    @SerializedName("group_id")
    protected String groupId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    protected List<t> poses;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L16;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.poses, r101.poses) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f69987a, r101.f69987a) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<t> r104 = this.poses;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.color;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.groupId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f69987a;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GuessWord(content=" + this.content + ", poses=" + this.poses + ", color=" + this.color + ", groupId=" + this.groupId + ", imprId=" + this.f69987a + ")";
    }

    public s() {
        this.content = "";
        this.poses = new ArrayList();
        this.color = "#EBA825";
        this.groupId = "";
    }

    public final String a() {
        return this.color;
    }

    public final String b() {
        return this.content;
    }

    public final String c() {
        return this.groupId;
    }

    public final List<t> d() {
        return this.poses;
    }

    public s(am3.g r100) {
        this.poses = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.content = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.poses.add(new t(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.color = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.groupId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.content != null) goto L22;
        this.content = "";
    L22:
        if (this.poses.isEmpty() == false) goto L25;
        this.poses = new ArrayList();
    L25:
        if (this.color != null) goto L28;
        this.color = "#EBA825";
    L28:
        if (this.groupId != null) goto L46;
        this.groupId = "";
        return;
    }
}
