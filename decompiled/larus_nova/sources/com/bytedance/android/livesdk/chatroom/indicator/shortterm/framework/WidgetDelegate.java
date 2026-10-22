package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/framework/WidgetDelegate;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "Lio/reactivex/disposables/Disposable;", "Landroid/content/Context;", "getContext", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WidgetDelegate implements IWidget, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f106626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f106627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f106628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f106629d;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WidgetDelegate f106630a;

        public a(WidgetDelegate r100) {
            this.f106630a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f106630a.f106626a.markState(Lifecycle.State.DESTROYED);
            WidgetDelegate r100 = this.f106630a;
            r100.f106628c = null;
            r100.f106629d = null;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f106627b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f106627b.isDisposed();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public Context getContext() {
        return this.f106628c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final DataCenter getDataCenter() {
        return this.f106629d;
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f106626a;
    }

    public WidgetDelegate(Context r100, DataCenter r101) {
        this.f106628c = r100;
        this.f106629d = r101;
        LifecycleRegistry r102 = new LifecycleRegistry(this);
        this.f106626a = r102;
        CompositeDisposable r103 = new CompositeDisposable();
        this.f106627b = r103;
        r103.add(Disposables.fromAction(new a(this)));
        r102.markState(Lifecycle.State.RESUMED);
    }
}
