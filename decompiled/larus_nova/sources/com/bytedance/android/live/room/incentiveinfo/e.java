package com.bytedance.android.live.room.incentiveinfo;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements u81.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u81.f f99678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IncentiveInfoLayout f99679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f99680c;

    @Override // u81.f.a
    public final void a() {
        x81.b<u81.d> r100 = this.f99679b.getItemHolderPool();
        if (r100 == null) goto L35;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= 99) goto L12;
        if (r100.f562884a[r102] == null) goto L10;
        r103 = r103 + 1;
    L10:
        r102 = r102 + 1;
        goto L6
    L12:
        if (Intrinsics.areEqual(this.f99679b.f99608d, this.f99678a) == false) goto L36;
        WeakReference<View> r104 = this.f99679b.f99607c;
        if (r104 == null) goto L16;
        View r105 = r104.get();
    L18:
        if (Intrinsics.areEqual(r105, this.f99680c) == true) goto L20;
        return;
    L20:
        if (r103 <= 1) goto L38;
        ALogger.d("IncentiveInfoLayout", "show next carousel holder");
        IncentiveInfoLayout r106 = this.f99679b;
        int r107 = r106.f99606b + 1;
        if (r107 < 0) goto L30;
        u81.c<? extends Object, ? extends u81.d> r108 = r106.getAdapter();
        if (r108 == null) goto L26;
        int r109 = r108.getItemSize();
    L27:
        if (r107 >= r109) goto L30;
        r101 = r107;
        goto L30
    L26:
        r109 = 0;
    L30:
        r106.c(r101, true);
        return;
    L38:
        return;
    L16:
        r105 = null;
        goto L18
    L36:
        return;
    }

    public e(u81.f r100, IncentiveInfoLayout r101, View r102) {
        this.f99678a = r100;
        this.f99679b = r101;
        this.f99680c = r102;
    }
}
