package android.view.viewmodel.internal;

import S7.a;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "lock", "Lkotlin/Function0;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "synchronized", "(Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;LS7/a;)Ljava/lang/Object;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SynchronizedObjectKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m7160synchronized(SynchronizedObject lock, a action) {
        T t9;
        k.f(lock, "lock");
        k.f(action, "action");
        synchronized (lock) {
            t9 = (T) action.invoke();
        }
        return t9;
    }
}
