package com.bytedance.android.window.shop.repository.tab.entity;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i0 extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f189576m = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f189577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WindowProductCategoryVODeprecated f189578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f189579l;

    public static final class a {
        public static i0 a(List r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "categoryDtoList");
            int r102 = WindowProductCategoryVODeprecated.f189507k;
            WindowProductCategoryVODeprecated r103 = WindowProductCategoryVODeprecated.b.a(r100);
            if (r103 != null) goto L5;
            return null;
        L5:
            if (r101 != null) goto L11;
            WindowProductCategoryVODeprecated.a r104 = (WindowProductCategoryVODeprecated.a) CollectionsKt.firstOrNull(r103.f189508j);
            if (r104 == null) goto L9;
            r101 = r104.f189512a;
            goto L11
        L9:
            r101 = null;
        L11:
            return new i0(r103, r101);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i0) == false) goto L10;
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f189578k, r101.f189578k) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f189579l, r101.f189579l) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        WindowProductCategoryVODeprecated r100 = this.f189578k;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f189579l;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowSubCategoryVO(subCategoryVO=" + this.f189578k + ", selectCategoryId=" + this.f189579l + ")";
    }

    public i0(WindowProductCategoryVODeprecated r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subCategoryVO");
        super(AVMDLDataLoader.KeyIsEnableLoaderPreempt);
        this.f189578k = r100;
        this.f189579l = r101;
        if (r101 == null) goto L17;
        Iterator<WindowProductCategoryVODeprecated.a> r102 = r100.f189508j.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r102.next().f189512a, r101) == true) goto L12;
        r103 = r103 + 1;
    L12:
        if (r103 < 0) goto L18;
        this.f189577j = r103;
        return;
    L18:
        return;
    L11:
        r103 = -1;
        goto L12
    }
}
