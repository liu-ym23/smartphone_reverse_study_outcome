package com.bytedance.android.shopping.sameproduct.event;

import android.app.Activity;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/event/SameTrackerProvider;", "Landroidx/lifecycle/ViewModel;", "", com.bytedance.android.ec.core.event.a.KEY_TRACKER, "Ljava/lang/Object;", "getTracker", "()Ljava/lang/Object;", "setTracker", "(Ljava/lang/Object;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameTrackerProvider extends ViewModel {
    public static final a Companion = null;
    private Object tracker;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(Context r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r102 = d0.f165305a.getActivity(r100);
            if (r102 == null) goto L7;
            ((SameTrackerProvider) ViewModelProviders.of((FragmentActivity) r102).get(SameTrackerProvider.class)).setTracker(r101);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final <T> void setTracker(Context r100, T r101) {
        Companion.getClass();
        a.a(r100, r101);
    }

    public SameTrackerProvider() {
    }

    public final Object getTracker() {
        return this.tracker;
    }

    @JvmStatic
    public static final /* synthetic */ <T> T getTracker(Context r100) {
        Companion.getClass();
        if (r100 != null) goto L5;
        return null;
    L5:
        Activity r101 = d0.f165305a.getActivity(r100);
        if (r101 == null) goto L10;
        T r102 = (T) ((SameTrackerProvider) ViewModelProviders.of((FragmentActivity) r101).get(SameTrackerProvider.class)).getTracker();
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return r102;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void setTracker(Object r100) {
        this.tracker = r100;
    }
}
