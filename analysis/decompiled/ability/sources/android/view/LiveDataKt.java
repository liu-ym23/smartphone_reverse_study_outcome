package android.view;

import C7.c;
import S7.k;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function1;", "LC7/r;", "onChanged", "Landroidx/lifecycle/Observer;", "observe", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;LS7/k;)Landroidx/lifecycle/Observer;", "lifecycle-livedata-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LiveDataKt {
    @c
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner owner, final k onChanged) {
        kotlin.jvm.internal.k.f(liveData, "<this>");
        kotlin.jvm.internal.k.f(owner, "owner");
        kotlin.jvm.internal.k.f(onChanged, "onChanged");
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // android.view.Observer
            public final void onChanged(T t9) {
                onChanged.invoke(t9);
            }
        };
        liveData.observe(owner, observer);
        return observer;
    }
}
