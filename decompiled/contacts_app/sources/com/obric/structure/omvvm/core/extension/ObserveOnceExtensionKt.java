package com.obric.structure.omvvm.core.extension;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.GlobalProxyLancet;
import com.obric.structure.omvvm.core.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ObserveOnceExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a6\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007\u001a4\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"observeOnce", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/obric/structure/omvvm/core/viewmodel/QLiveData;", "observeOnceWithTimeout", "timeout", "", "observeUntil", "needContinueObserver", "Lcom/obric/structure/omvvm/core/extension/NeedContinueObserver;", "omvvm-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ObserveOnceExtensionKt {
    /* JADX INFO: renamed from: $r8$lambda$lq69J1x3wrsXej3e4-RHkfOoB1U, reason: not valid java name */
    public static /* synthetic */ void m768$r8$lambda$lq69J1x3wrsXej3e4RHkfOoB1U(Ref.BooleanRef r0, Observer r1, Ref.ObjectRef r2, LiveData r3) {
        observeOnceWithTimeout$lambda$1(r0, r1, r2, r3);
    }

    public static final <T> void observeOnce(final LiveData<T> r1, LifecycleOwner r2, final Observer<T> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        r1.observe(r2, new AnonymousClass1(r3, r1));
    }

    public static final <T> void observeOnce(final QLiveData<T> r1, LifecycleOwner r2, final Observer<T> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        r1.observe(r2, new AnonymousClass2(r3, r1));
    }

    public static final <T> void observeOnceWithTimeout(final LiveData<T> r10, LifecycleOwner r11, long r12, final Observer<T> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r14, "observer");
        final Ref.BooleanRef r2 = new Ref.BooleanRef();
        final Handler r0 = new Handler(Looper.getMainLooper());
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        final Runnable r8 = new ObserveOnceExtensionKt$$ExternalSyntheticLambda0(r2, r14, r7, r10);
        r7.element = new C03881(r2, r14, r0, r8, r10);
        r0.postDelayed(r8, r12);
        r10.observe(r11, (Observer) r7.element);
    }

    private static final void observeOnceWithTimeout$lambda$1(Ref.BooleanRef r1, Observer r2, Ref.ObjectRef r3, LiveData r4) {
        Intrinsics.checkNotNullParameter(r1, "$hasReceivedData");
        Intrinsics.checkNotNullParameter(r2, "$observer");
        Intrinsics.checkNotNullParameter(r3, "$observerFun");
        Intrinsics.checkNotNullParameter(r4, "$this_observeOnceWithTimeout");
        if (r1.element == true) goto L8;
        r1.element = true;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("observeOnceWithTimeout", "timeout");
        r2.onChanged(null);
        Observer r5 = (Observer) r3.element;
        if (r5 == null) goto L9;
        r4.removeObserver(r5);
        return;
    L9:
        return;
    }

    public static final <T> void observeUntil(final LiveData<T> r1, LifecycleOwner r2, final Observer<T> r3, final NeedContinueObserver r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        Intrinsics.checkNotNullParameter(r4, "needContinueObserver");
        r1.observe(r2, new C03891(r3, r4, r1));
    }
}
