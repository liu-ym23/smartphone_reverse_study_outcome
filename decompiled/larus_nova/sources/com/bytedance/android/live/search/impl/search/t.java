package com.bytedance.android.live.search.impl.search;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f100786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f100787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f100788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f100789d;

    public interface a {
        void H6();

        void Xp(ra1.h r100);
    }

    public t(FragmentActivity r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f100788c = r100;
        this.f100789d = r101;
    }
}
