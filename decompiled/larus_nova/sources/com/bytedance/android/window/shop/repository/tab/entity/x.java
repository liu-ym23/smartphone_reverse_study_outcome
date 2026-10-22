package com.bytedance.android.window.shop.repository.tab.entity;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class x extends f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f189641l = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f189642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WindowProductCategoryVODeprecated f189643k;

    public static final class a {
        public static x a(List r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "categoryDtoList");
            int r102 = WindowProductCategoryVODeprecated.f189507k;
            WindowProductCategoryVODeprecated r103 = WindowProductCategoryVODeprecated.b.a(r100);
            if (r103 != null) goto L7;
            return null;
        L7:
            return new x(r103, r101);
        }
    }

    static {
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryId");
        Iterator<WindowProductCategoryVODeprecated.a> r101 = this.f189643k.f189508j.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r101.next().f189512a, r100) == true) goto L10;
        r102 = r102 + 1;
    L10:
        if (r102 < 0) goto L15;
        this.f189642j = r102;
        return;
    L15:
        return;
    L9:
        r102 = -1;
        goto L10
    }

    public x(WindowProductCategoryVODeprecated r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "categoryVO");
        super(AVMDLDataLoader.KeyIsNextDownloadThreshold);
        this.f189643k = r100;
        if (r101 == null) goto L6;
        e(r101);
        return;
    }
}
