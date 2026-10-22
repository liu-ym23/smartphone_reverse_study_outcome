package com.bytedance.als.lazy;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.als.b;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.objectcontainer.InstanceCreatedCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/als/lazy/MultipleInstanceCreatedCallbackWithLifecycleWrapper;", "Lcom/bytedance/als/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/objectcontainer/InstanceCreatedCallback;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "als_release"}, k = 1, mv = {1, 4, 1})
public final class MultipleInstanceCreatedCallbackWithLifecycleWrapper<T extends b> implements InstanceCreatedCallback<T>, LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        throw null;
    }

    @Override // com.bytedance.objectcontainer.InstanceCreatedCallback
    public final void a(Class r100, Object r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter((b) r101, "instance");
        if (r102 == false) goto L6;
        return;
    L6:
        throw null;
    }
}
