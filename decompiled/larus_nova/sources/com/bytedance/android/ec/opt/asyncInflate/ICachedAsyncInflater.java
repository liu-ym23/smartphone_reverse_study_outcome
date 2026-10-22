package com.bytedance.android.ec.opt.asyncInflate;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/opt/asyncInflate/ICachedAsyncInflater;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public interface ICachedAsyncInflater extends LifecycleObserver {

    public interface a {
        void recycle();
    }

    public interface b {
        View a(Activity r100);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();
}
