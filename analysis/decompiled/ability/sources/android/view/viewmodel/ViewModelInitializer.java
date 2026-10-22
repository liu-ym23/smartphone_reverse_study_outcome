package android.view.viewmodel;

import M.a;
import S7.k;
import Z7.d;
import android.view.ViewModel;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\nB+\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\fR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "Landroidx/lifecycle/ViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "", "LZ7/d;", "clazz", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "initializer", AppAgent.CONSTRUCT, "(LZ7/d;LS7/k;)V", "Ljava/lang/Class;", "(Ljava/lang/Class;LS7/k;)V", "LZ7/d;", "getClazz$lifecycle_viewmodel_release", "()LZ7/d;", "LS7/k;", "getInitializer$lifecycle_viewmodel_release", "()LS7/k;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    private final d clazz;
    private final k initializer;

    public ViewModelInitializer(d clazz, k initializer) {
        kotlin.jvm.internal.k.f(clazz, "clazz");
        kotlin.jvm.internal.k.f(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
    }

    /* renamed from: getClazz$lifecycle_viewmodel_release, reason: from getter */
    public final d getClazz() {
        return this.clazz;
    }

    /* renamed from: getInitializer$lifecycle_viewmodel_release, reason: from getter */
    public final k getInitializer() {
        return this.initializer;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelInitializer(Class<T> clazz, k initializer) {
        this(a.c0(clazz), initializer);
        kotlin.jvm.internal.k.f(clazz, "clazz");
        kotlin.jvm.internal.k.f(initializer, "initializer");
    }
}
