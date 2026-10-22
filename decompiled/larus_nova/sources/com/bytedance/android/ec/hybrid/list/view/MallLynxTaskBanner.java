package com.bytedance.android.ec.hybrid.list.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0007R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/view/MallLynxTaskBanner;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "", "containerID", "Ljava/lang/String;", "getContainerID", "()Ljava/lang/String;", "", "", "initData", "Ljava/util/Map;", "getInitData", "()Ljava/util/Map;", "viewGroup", "Landroid/widget/FrameLayout;", "getViewGroup", "()Landroid/widget/FrameLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallLynxTaskBanner extends FrameLayout implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, WeakReference<MallLynxTaskBanner>> f47419a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f47420b = null;

    public static final class a {
        public a() {
        }

        public final Activity getActivity(Context r100) {
            if ((r100 instanceof Activity) == false) goto L6;
            return (Activity) r100;
        L6:
            if ((r100 instanceof ContextWrapper) == true) goto L11;
            return null;
        L11:
            return getActivity(((ContextWrapper) r100).getBaseContext());
        }
    }

    public final String getContainerID() {
        return null;
    }

    public final Map<String, Object> getInitData() {
        return null;
    }

    public final FrameLayout getViewGroup() {
        return null;
    }

    static {
        f47420b = new a();
        f47419a = new LinkedHashMap();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        throw null;
    }
}
