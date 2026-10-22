package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dslservice.util.f;
import com.bytedance.android.livesdk.dslservice.util.o;
import com.bytedance.android.livesdk.dslservice.util.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;
import yt1.q;

/* JADX INFO: loaded from: classes8.dex */
public final class SliceDSLProcess$wrapInnerCallback$1 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f122916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f122917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f122918c;

    @Override // yt1.m
    public final void onFetchSuccess() {
    }

    public SliceDSLProcess$wrapInnerCallback$1(q r100, p r101, m r102) {
        this.f122916a = r100;
        this.f122917b = r101;
        this.f122918c = r102;
    }

    @Override // yt1.m
    public final void a(com.bytedance.android.livesdk.dslservice.a r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "loadFrom");
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        final String r104 = "UnKnown";
    L9:
        o r105 = o.f123008f;
        r105.d(new SliceDSLProcess$wrapInnerCallback$1$onLoadSuccess$1(this, r104));
        p r106 = this.f122917b;
        if (r106 == null) goto L12;
        r106.a(new e(this, r104));
    L12:
        String r107 = this.f122916a.f569037a;
        Intrinsics.checkNotNullParameter(r107, "id");
        Intrinsics.checkNotNullParameter(r104, "loadType");
        r105.f(DSLType.Slice, 1, r104, r107);
        m r108 = this.f122918c;
        if (r108 == null) goto L16;
        r108.a(r100, r101, r102);
        return;
    L16:
        return;
    L8:
        r104 = r102;
        goto L9
    L5:
        r103 = false;
        goto L6
    }

    @Override // yt1.m
    public final void b(String r100, final String r101, final Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "reason");
        o r103 = o.f123008f;
        String r104 = this.f122916a.f569037a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "id");
        Intrinsics.checkNotNullParameter("", "loadType");
        r103.f(DSLType.Slice, 0, "", r104);
        Function1<f, Unit> r105 = new SliceDSLProcess$wrapInnerCallback$1$onFailed$1(this, r101, r102);
        Intrinsics.checkNotNullParameter(r105, "initBlock");
        r103.e(2, r105);
        m r106 = this.f122918c;
        if (r106 == null) goto L6;
        r106.b(r100, r101, r102);
        return;
    }
}
