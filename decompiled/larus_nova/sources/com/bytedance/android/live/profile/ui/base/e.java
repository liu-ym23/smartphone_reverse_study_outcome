package com.bytedance.android.live.profile.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f86325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f86326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f86327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f86328d;

    @Override // com.bytedance.android.live.profile.ui.base.d
    public Context getContext() {
        return this.f86328d.getContext();
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void removeAllViews() {
        this.f86328d.removeAllViews();
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final <T extends View> T a(int r100) {
        return (T) this.f86328d.findViewById(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void c(int r100) {
        a1.k(this.f86328d, r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final boolean d(int r100) {
        View r101 = this.f86326b;
        if (r101 != null) goto L6;
        return false;
    L6:
        a1.k(r101, r100);
        return true;
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f86328d.addView(r100, -1, -1);
    }

    public final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f86328d.addView(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void removeView(View r100) {
        this.f86328d.removeView(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final void addView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        this.f86328d.addView(r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final View b(ProfilePreInflateViewInfo r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        Context r102 = getContext();
        if (r102 != null) goto L6;
        return null;
    L6:
        Lazy r103 = ProfilePreInflateUtil.f100873a;
        return ProfilePreInflateUtil.c(r100, r102, LayoutInflater.from(r102), this.f86328d, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.base.d
    public final View f(int r100, boolean r101) {
        Context r102 = getContext();
        if (r102 != null) goto L7;
        return null;
    L7:
        return LayoutInflater.from(r102).inflate(r100, this.f86328d, r101);
    }

    public e(View r100, ViewGroup r101, c r102) {
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f86327c = r100;
        this.f86328d = r101;
        int r103 = -1;
        View r104 = null;
        if (r100 == null) goto L8;
        if (r102 == null) goto L6;
        int r105 = r102.f86324c;
    L7:
        View r106 = r100.findViewById(r105);
    L9:
        this.f86325a = r106;
        if (r100 == null) goto L14;
        if (r102 == null) goto L13;
        r103 = r102.f86323b;
    L13:
        r104 = r100.findViewById(r103);
    L14:
        this.f86326b = r104;
        return;
    L6:
        r105 = -1;
        goto L7
    L8:
        r106 = null;
        goto L9
    }
}
