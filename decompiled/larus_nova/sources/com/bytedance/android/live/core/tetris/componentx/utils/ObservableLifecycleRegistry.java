package com.bytedance.android.live.core.tetris.componentx.utils;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.tetris.componentx.component.a;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import g70.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/utils/ObservableLifecycleRegistry;", "Landroidx/lifecycle/LifecycleRegistry;", "Lg70/h;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ObservableLifecycleRegistry extends LifecycleRegistry implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<h.a> f65633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f65634b;

    public ObservableLifecycleRegistry(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(r100);
        this.f65634b = r100;
        this.f65633a = new LinkedHashSet();
    }

    @Override // g70.h
    public final boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return this.f65633a.remove(r100);
    }

    @Override // androidx.lifecycle.LifecycleRegistry, androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Iterator<T> r101 = this.f65633a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((h.a) r101.next()).d(r100);
        goto L4
    L6:
        super.addObserver(r100);
        Iterator<T> r102 = this.f65633a.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((h.a) r102.next()).c(r100);
        goto L8
    }

    @Override // g70.h
    public final boolean c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return this.f65633a.add(r100);
    }

    @Override // androidx.lifecycle.LifecycleRegistry, androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Iterator<T> r101 = this.f65633a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((h.a) r101.next()).a(r100);
        goto L4
    L6:
        super.removeObserver(r100);
        Iterator<T> r102 = this.f65633a.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((h.a) r102.next()).b(r100);
        goto L8
    }
}
