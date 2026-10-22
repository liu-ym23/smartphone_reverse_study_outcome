package com.bytedance.als.dsl;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.als.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/als/dsl/AlsVMContainer;", "Landroidx/lifecycle/ViewModel;", "", "_clear", "Landroidx/fragment/app/FragmentActivity;", "activity", "resetIfNeeded$als_release", "(Landroidx/fragment/app/FragmentActivity;)V", "resetIfNeeded", "Lcom/bytedance/als/dsl/Config;", "config", "Lcom/bytedance/als/dsl/Config;", "getConfig", "()Lcom/bytedance/als/dsl/Config;", "setConfig", "(Lcom/bytedance/als/dsl/Config;)V", "Lcom/bytedance/als/a;", "alsVM", "Lcom/bytedance/als/a;", "getAlsVM", "()Lcom/bytedance/als/a;", "setAlsVM", "(Lcom/bytedance/als/a;)V", "Lcom/bytedance/als/dsl/OCAdapterViewModel;", "ocVM", "Lcom/bytedance/als/dsl/OCAdapterViewModel;", "getOcVM", "()Lcom/bytedance/als/dsl/OCAdapterViewModel;", "setOcVM", "(Lcom/bytedance/als/dsl/OCAdapterViewModel;)V", "Ljava/lang/ref/WeakReference;", "_activity", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class AlsVMContainer extends ViewModel {
    private WeakReference<FragmentActivity> _activity;
    private a alsVM;
    private Config config;
    private OCAdapterViewModel ocVM;

    private final void _clear() {
        this.alsVM = null;
        this.ocVM = null;
    }

    public AlsVMContainer() {
        this.config = new Config();
    }

    public final a getAlsVM() {
        return this.alsVM;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final OCAdapterViewModel getOcVM() {
        return this.ocVM;
    }

    public final void resetIfNeeded$als_release(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakReference<FragmentActivity> r101 = this._activity;
        if (r101 == null) goto L5;
        FragmentActivity r102 = r101.get();
    L7:
        if ((!Intrinsics.areEqual(r102, r100)) == false) goto L10;
        this._activity = new WeakReference(r100);
        _clear();
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setAlsVM(a r100) {
        this.alsVM = r100;
    }

    public final void setConfig(Config r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.config = r100;
    }

    public final void setOcVM(OCAdapterViewModel r100) {
        this.ocVM = r100;
    }
}
