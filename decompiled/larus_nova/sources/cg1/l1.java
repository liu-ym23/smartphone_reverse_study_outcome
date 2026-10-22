package cg1;

import com.bytedance.android.livesdk.widget.schedule.LiveWidgetLoadTaskScheduler;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l1 implements Function1<com.bytedance.android.livesdk.widget.schedule.c, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveWidgetLoadTaskScheduler f23629a;

    public l1(LiveWidgetLoadTaskScheduler r100) {
        this.f23629a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(com.bytedance.android.livesdk.widget.schedule.c r100) {
        com.bytedance.android.livesdk.widget.schedule.c r101 = r100;
        LiveWidgetLoadTaskScheduler r102 = this.f23629a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "actual");
        r101.f162094a = new WeakReference(r102);
        return null;
    }
}
