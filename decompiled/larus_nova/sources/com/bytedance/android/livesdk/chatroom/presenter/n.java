package com.bytedance.android.livesdk.chatroom.presenter;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.IoToUiTransformer;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveModuleCrashFixConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes7.dex */
public abstract class n<T extends IWidget> extends q46.b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IoToUiTransformer f107663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f107664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vlc.d f107665d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q46.b
    public void detachView() {
        if ((this instanceof vlc.l) == false) goto L7;
        vlc.d r100 = this.f107665d;
        if (r100 == null) goto L7;
        r100.removeMessageListener((vlc.l) this);
    L7:
        this.f107664c = null;
        this.f531633a = null;
    }

    public final <D> AutoDisposeConverter<D> e0() {
        if (this.f107663b != null) goto L6;
        this.f107663b = new IoToUiTransformer();
    L6:
        if (b0() != null) goto L12;
        if (LiveModuleCrashFixConfig.getLiveFixWidgetAutoDisposeNpe() == false) goto L12;
        return AutoDispose.autoDisposable(new com.bytedance.android.live.core.utils.rxutils.autodispose.b());
    L12:
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(b0(), Lifecycle.Event.ON_DESTROY), this.f107663b);
    }

    public final <D> AutoDisposeConverter<D> d0() {
        return AutoDispose.bind(b0());
    }

    public n() {
    }

    public void c0(T r100) {
        this.f531633a = r100;
        if (r100 == null) goto L8;
        DataCenter r101 = r100.getDataCenter();
        this.f107664c = r101;
        if (r101 == null) goto L9;
        this.f107665d = (vlc.d) r101.get("data_message_manager");
        return;
    L9:
        return;
    }

    public final void f0(Throwable r100) {
        ALogger.stacktrace(6, getClass().getName(), r100.getStackTrace());
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
