package com.bytedance.android.livesdk.gift.platform.core.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f130832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f130833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f130834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f130835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f130836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f130837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f130838g;

    public a() {
        this(null, null, GiftInsertStatus.NOT_STRATEGY, null, "", null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f130832a, r101.f130832a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130833b, r101.f130833b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f130834c, r101.f130834c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f130835d, r101.f130835d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f130836e, r101.f130836e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f130837f, r101.f130837f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f130838g, r101.f130838g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f130832a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f130833b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f130834c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f130835d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f130836e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.f130837f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        JSONObject r119 = this.f130838g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "AiRecommendInfoModel(sliceId=" + this.f130832a + ", strategyScene=" + this.f130833b + ", giftInsertStatus=" + this.f130834c + ", roomLiveScene=" + this.f130835d + ", strategyStickerContent=" + this.f130836e + ", commonUserFeature=" + this.f130837f + ", giftSceneMap=" + this.f130838g + ")";
    }

    public a(String r100, String r101, String r102, String r103, String r104, Map<String, String> r105, JSONObject r106) {
        Intrinsics.checkNotNullParameter(r102, "giftInsertStatus");
        Intrinsics.checkNotNullParameter(r104, "strategyStickerContent");
        this.f130832a = r100;
        this.f130833b = r101;
        this.f130834c = r102;
        this.f130835d = r103;
        this.f130836e = r104;
        this.f130837f = r105;
        this.f130838g = r106;
    }
}
