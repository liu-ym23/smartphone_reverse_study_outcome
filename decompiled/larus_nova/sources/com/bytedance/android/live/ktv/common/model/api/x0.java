package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/x0;", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/TagDressPageItem;", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "b", "()Ljava/util/List;", "Lpy/k;", "avatar", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x0 implements vh7.h {

    @SerializedName("avatar")
    protected py.k avatar;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected List<TagDressPageItem> tags;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x0) == false) goto L10;
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<TagDressPageItem> r100 = this.tags;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        py.k r104 = this.avatar;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TagList(tags=" + this.tags + ", avatar=" + this.avatar + ")";
    }

    public x0() {
        this.tags = null;
        this.avatar = null;
    }

    public final py.k a() {
        return this.avatar;
    }

    public final List<TagDressPageItem> b() {
        return this.tags;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public x0(am3.g r100) {
        this.tags = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.tags.add(new TagDressPageItem(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.avatar = vh7.f.a(r100, py.k.class);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.tags.isEmpty() == false) goto L16;
        this.tags = null;
    L16:
        if (this.avatar != null) goto L28;
        this.avatar = null;
        return;
    }
}
