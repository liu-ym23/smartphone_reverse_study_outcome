package com.bytedance.android.livesdk.dslservice.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.r;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f122942a;

    @Override // yt1.j
    public final View getTargetView() {
        return this.f122942a.f50701c;
    }

    @Override // yt1.j
    public final r a() {
        return this.f122942a;
    }

    public d(r r100) {
        this.f122942a = r100;
    }

    @Override // yt1.j
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        SliceViewUtilsKt.b(this.f122942a, r100, r101);
    }

    @Override // yt1.j
    public final void c(Map r100, int r101) {
        SliceViewUtilsKt.a(this.f122942a, "", r100, r101);
    }
}
