package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> f86941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> f86942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.live.profile.ui.base.g> f86943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> f86944d;

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f86941a, r101.f86941a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f86942b, r101.f86942b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f86943c, r101.f86943c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f86944d, r101.f86944d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> r100 = this.f86941a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> r104 = this.f86942b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.android.live.profile.ui.base.g> r107 = this.f86943c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<com.bytedance.android.live.profile.ui.base.g, com.bytedance.android.live.profile.ui.base.f> r110 = this.f86944d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        StringBuilder r100 = new StringBuilder("CompareResult(\nresult=");
        r100.append(a(this.f86941a));
        r100.append(", \nadd=");
        r100.append(a(this.f86942b));
        r100.append(", \nremove=");
        List<com.bytedance.android.live.profile.ui.base.g> r101 = this.f86943c;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        com.bytedance.android.live.profile.ui.base.g r104 = (com.bytedance.android.live.profile.ui.base.g) r103.next();
        r102.add(r104.getComponentType().getClass().getSimpleName() + "@" + r104.hashCode());
        goto L4
    L6:
        r100.append(r102);
        r100.append(", \nupdate=");
        r100.append(a(this.f86944d));
        return r100.toString();
    }

    public e(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        ArrayList r103 = new ArrayList();
        LinkedHashMap r104 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "add");
        Intrinsics.checkNotNullParameter(r103, "remove");
        Intrinsics.checkNotNullParameter(r104, "update");
        this.f86941a = r101;
        this.f86942b = r102;
        this.f86943c = r103;
        this.f86944d = r104;
    }

    public static String a(Map r100) {
        Iterator r101 = r100.entrySet().iterator();
        String r102 = "{";
    L4:
        if (r101.hasNext() == false) goto L20;
        Map.Entry r103 = (Map.Entry) r101.next();
        String r104 = r102 + ((com.bytedance.android.live.profile.ui.base.g) r103.getKey()).getComponentType().getClass().getSimpleName() + "@" + r103.getKey().hashCode() + ContainerUtils.KEY_VALUE_DELIMITER;
        StringBuilder r105 = new StringBuilder();
        r105.append(r104);
        if (r103.getValue() == null) goto L17;
        StringBuilder r106 = new StringBuilder();
        com.bytedance.android.live.profile.ui.base.f r107 = (com.bytedance.android.live.profile.ui.base.f) r103.getValue();
        Integer r108 = null;
        if (r107 == null) goto L12;
        ComponentType r109 = r107.getComponentType();
        if (r109 == null) goto L12;
        String r110 = r109.getClass().getSimpleName();
    L13:
        r106.append(r110);
        r106.append("@");
        com.bytedance.android.live.profile.ui.base.f r111 = (com.bytedance.android.live.profile.ui.base.f) r103.getValue();
        if (r111 == null) goto L16;
        r108 = Integer.valueOf(r111.hashCode());
    L16:
        r106.append(r108);
        String r112 = r106.toString();
    L18:
        r105.append(r112);
        r102 = r105.toString() + ",";
    L12:
        r110 = null;
        goto L13
    L17:
        r112 = "null";
        goto L18
    L20:
        return r102 + com.alipay.sdk.m.u.i.f25855d;
    }
}
