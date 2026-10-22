package com.android.ttcjpaysdk.base.framework.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.framework.IBackPressedListener;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.mvp.base.MvpBaseFragment;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0018\b\u0000\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002*\b\b\u0001\u0010\u0005*\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00010\u00072\u00020\bB\u0005¢\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\u0004\u0018\u00018\u0001H\u0004¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0002\u0010\u0005H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u001a\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/mvp/MvpBaseLoggerFragment;", "P", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "L", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "Lcom/android/ttcjpaysdk/base/mvp/base/MvpBaseFragment;", "Lcom/android/ttcjpaysdk/base/framework/IBackPressedListener;", "()V", "TAG", "", "mvpLogger", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "getLogger", "()Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "initLogger", "()Ljava/lang/Object;", "interceptBackPressed", "", TeaEventTrack.ACTION_DRAMA_NEXT, "", "onAttach", "activity", "Landroid/app/Activity;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MvpBaseLoggerFragment<P extends BasePresenter<? extends MvpModel, ? extends MvpView>, L extends MvpLogger> extends MvpBaseFragment<P> implements IBackPressedListener {
    private final String TAG;
    private L mvpLogger;

    private final <L> L initLogger() {
        Type r100 = getClass().getGenericSuperclass();     // Catch: Exception -> L11
        if (r100 != null) goto L7;
        return null;
    L7:
        if ((r100 instanceof ParameterizedType) == true) goto L9;
        return null;
    L9:
        Type r101 = ((ParameterizedType) r100).getActualTypeArguments()[1];     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.Class<L of com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerFragment.initLogger>");     // Catch: Exception -> L11
        return (L) ((Class) r101).newInstance();
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("MvpBaseLoggerFragment#getLogger", e);
        CJBasicCommonUtils.logCatch("CJCatch", "MvpBaseLoggerFragment#getLogger", e);
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.IBackPressedListener
    public boolean interceptBackPressed() {
        return false;
    }

    public abstract void next();

    public MvpBaseLoggerFragment() {
        this.TAG = "FragmentLifeCircle";
    }

    @Override // com.android.ttcjpaysdk.base.mvp.base.MvpBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mvpLogger != null) goto L5;
        this.mvpLogger = null;
    L5:
        CJLogger.d(this.TAG, getClass().getCanonicalName() + " onDestroyView");
    }

    public final L getLogger() {
        return this.mvpLogger;
    }

    @Override // com.android.ttcjpaysdk.base.mvp.base.MvpBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.mvpLogger = (L) initLogger();     // Catch: Exception -> L5
    L7:
        super.onAttach(r100);
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("MvpBaseLoggerFragment#onAttach", e);
        CJBasicCommonUtils.logCatch("CJCatch", "MvpBaseLoggerFragment#onAttach", e);
        goto L7
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.isViewInit = true;
        CJLogger.d(this.TAG, getClass().getCanonicalName() + " onViewCreated");
    }

    @Override // com.android.ttcjpaysdk.base.mvp.base.MvpBaseFragment, com.android.ttcjpaysdk.base.framework.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = super.onCreateView(r100, r101, r102);
        initData();
        Intrinsics.checkNotNull(r103);
        initViews(r103, r102);
        initActions(r103);
        next();
        CJLogger.d(this.TAG, getClass().getCanonicalName() + " onCreateView");
        return r103;
    }
}
