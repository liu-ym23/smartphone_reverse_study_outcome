package com.bytedance.android.shopping.inflow.common.viewmodel;

import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import fa3.b;
import fa3.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0011\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/inflow/common/viewmodel/UselessJediViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/inflow/common/viewmodel/UselessState;", "Lfa3/d;", "defaultState", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "", "doClear", "remove", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class UselessJediViewModel extends JediViewModel<UselessState> implements d {
    private final /* synthetic */ b $$delegate_0;

    @Override // fa3.d
    public Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.$$delegate_0.add(r100);
        return r100;
    }

    public void doClear() {
        this.$$delegate_0.a();
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public UselessState defaultState() {
        return new UselessState();
    }

    public UselessJediViewModel() {
        this.$$delegate_0 = new b();
    }

    @Override // com.bytedance.jedi.arch.JediViewModel
    public /* bridge */ /* synthetic */ State defaultState() {
        return defaultState();
    }

    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        b r101 = this.$$delegate_0;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "disposable");
        CompositeDisposable r102 = r101.f476020a;
        if (r102 == null) goto L6;
        r102.remove(r100);
        return;
    }
}
