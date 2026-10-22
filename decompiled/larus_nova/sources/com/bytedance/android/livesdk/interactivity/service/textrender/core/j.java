package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements Disposable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f141017e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<m> f141018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f141019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f141020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f141021d;

    public static final class a {
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f141020c = true;
    }

    static {
        f141017e = (int) UIUtils.dip2Px(s1.getContext(), 16);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f141020c;
    }

    public j(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "asyncInfos");
        this.f141021d = r100;
        this.f141018a = new PriorityQueue(10, new l());
    }

    public final void b(int r100, Drawable r101) {
        if (this.f141020c == false) goto L5;
        return;
    L5:
        if (r101 != null) goto L9;
        h r102 = this.f141019b;
        if (r102 == null) goto L9;
        r102.b(((b) ListProtector.get(this.f141021d, r100)).f141007d);
    L9:
        this.f141018a.add(new m(r101, r100));
        if (this.f141018a.size() == this.f141021d.size()) goto L12;
        return;
    L12:
        if (this.f141020c == true) goto L20;
        h r103 = this.f141019b;
        if (r103 == null) goto L19;
        r103.a(this.f141018a);
        return;
    L19:
        return;
    }
}
