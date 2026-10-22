package com.android.ttcjpaysdk.base.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.eventbus.Observer;
import com.android.ttcjpaysdk.base.framework.BaseFragment;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0018\b\u0000\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H$J\u000f\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0001\u0010\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006)"}, d2 = {"Lcom/android/ttcjpaysdk/base/mvp/base/MvpBaseFragment;", "P", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "Lcom/android/ttcjpaysdk/base/framework/BaseFragment;", "()V", "mObserver", "Lcom/android/ttcjpaysdk/base/eventbus/Observer;", "mPresenter", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "getContext", "Landroid/content/Context;", "getModel", "getPresenter", "()Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "initPresenter", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "observerableEvents", "", "Ljava/lang/Class;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "()[Ljava/lang/Class;", "onAttach", "", "activity", "Landroid/app/Activity;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEvent", "event", "registerEventBus", "unRegisterEventBus", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MvpBaseFragment<P extends BasePresenter<? extends MvpModel, ? extends MvpView>> extends BaseFragment implements MvpView {
    private Observer mObserver;
    private P mPresenter;

    private final <T> T initPresenter() {
        Type r100 = getClass().getGenericSuperclass();     // Catch: Exception -> L11
        if (r100 != null) goto L7;
        return null;
    L7:
        if ((r100 instanceof ParameterizedType) == true) goto L9;
        return null;
    L9:
        Type r101 = ((ParameterizedType) r100).getActualTypeArguments()[0];     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<T of com.android.ttcjpaysdk.base.mvp.base.MvpBaseFragment.initPresenter>");     // Catch: Exception -> L11
        return (T) ((Class) r101).newInstance();
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("MvpBaseFragment#onDestroyView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "MvpBaseFragment#onDestroyView", e);
        return null;
    }

    public abstract MvpModel getModel();

    public Class<? extends BaseEvent>[] observerableEvents() {
        return null;
    }

    public void onEvent(BaseEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    private final void registerEventBus() {
        this.mObserver = new AnonymousClass1(this);
        Class<? extends BaseEvent>[] r100 = observerableEvents();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L9:
        if ((!r101) == false) goto L16;
        EventManager r102 = EventManager.INSTANCE;
        Observer r103 = this.mObserver;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mObserver");
        r103 = null;
    L13:
        r102.register(r103);
        return;
    L16:
        return;
    L7:
        r101 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        P r100 = this.mPresenter;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.detachView();
        this.mPresenter = null;
    L5:
        unRegisterEventBus();
        super.onDestroyView();
    }

    private final void unRegisterEventBus() {
        Class<? extends BaseEvent>[] r100 = observerableEvents();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length != 0) goto L7;
        boolean r101 = true;
    L9:
        if ((!r101) == false) goto L16;
        EventManager r102 = EventManager.INSTANCE;
        Observer r103 = this.mObserver;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mObserver");
        r103 = null;
    L13:
        r102.unregister(r103);
        return;
    L16:
        return;
    L7:
        r101 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (getActivity() != null) goto L5;
        return null;
    L5:
        FragmentActivity r100 = getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.content.Context");
        return r100;
    }

    public MvpBaseFragment() {
    }

    public final P getPresenter() {
        return this.mPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super.onAttach(r100);
        this.mPresenter = (P) initPresenter();     // Catch: Exception -> L5
    L7:
        P r101 = this.mPresenter;
        if (r101 == null) goto L13;
        Intrinsics.checkNotNull(r101);
        r101.attachView(getModel(), this);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("MvpBaseFragment#onAttach", e);
        CJBasicCommonUtils.logCatch("CJCatch", "MvpBaseFragment#onAttach", e);
        goto L7
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        registerEventBus();
        return super.onCreateView(r100, r101, r102);
    }
}
