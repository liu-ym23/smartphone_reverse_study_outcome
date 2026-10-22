package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Observer<List<? extends p>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowTabsSelectionJSbPluginExp f188964a;

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    public a(ECWindowTabsSelectionJSbPluginExp r100) {
        this.f188964a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onNext(List<? extends p> r100) {
        List<? extends p> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "category");
        List<? extends p> r102 = r101;
        if (r102.isEmpty() == true) goto L9;
        ((ArrayList) this.f188964a.f188959b).clear();
        ((ArrayList) this.f188964a.f188959b).addAll(r102);
    L7:
        if ((!((ArrayList) this.f188964a.f188960c).isEmpty()) == false) goto L11;
        ((Runnable) ListProtector.remove(this.f188964a.f188960c, 0)).run();
        goto L7
    L11:
        return;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.f188964a.f188961d = r100;
    }
}
