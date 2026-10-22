package com.bytedance.android.shopping.feed.utils;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements s83.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f175446b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s83.d f175447a;

    @Override // s83.d
    public final void a(View r100) {
        this.f175447a.a(r100);
    }

    @Override // s83.d
    public final void b() {
        this.f175447a.b();
    }

    @Override // s83.d
    public final void c() {
        this.f175447a.c();
    }

    @Override // s83.d
    public final void d(boolean r110, String r111, FragmentActivity r112, boolean r113, boolean r114, String r115) {
        Intrinsics.checkNotNullParameter(r111, "eventType");
        Intrinsics.checkNotNullParameter("VideoProductFeedFragment", "owner");
        this.f175447a.d(r110, r111, r112, r113, r114, r115);
    }

    @Override // s83.d
    public final void e(boolean r100, Context r101) {
        this.f175447a.e(r100, r101);
    }

    @Override // s83.d
    public final void f() {
        this.f175447a.f();
    }

    @Override // s83.d
    public final void g() {
        this.f175447a.g();
    }

    @Override // s83.d
    public final void h() {
        this.f175447a.h();
    }

    @Override // s83.d
    public final boolean isPlaying() {
        return this.f175447a.isPlaying();
    }

    static {
        f175446b = new f();
    }

    public f() {
        int r100 = ECSdk.f48106a;
        s83.g r101 = (s83.g) ECSdk.a(s83.g.class);
        if (r101 == null) goto L6;
        s83.d r102 = r101.N();
        if (r102 == null) goto L6;
    L7:
        this.f175447a = r102;
        return;
    L6:
        r102 = new e();
        goto L7
    }
}
