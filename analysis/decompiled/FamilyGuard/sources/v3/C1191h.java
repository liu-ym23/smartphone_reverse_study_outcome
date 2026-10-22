package v3;

import com.stepos.widget.list.StepOSListItem;
import j4.k;
import java.lang.ref.WeakReference;
import s3.l;

/* renamed from: v3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1191h {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<StepOSListItem> f23346a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f23347b = true;

    private final StepOSListItem b() {
        StepOSListItem stepOSListItem;
        WeakReference<StepOSListItem> weakReference = this.f23346a;
        if (weakReference == null || (stepOSListItem = weakReference.get()) == null || stepOSListItem.getSwitchHapticFeedbackOwner$StepOSWidget_release() != this) {
            return null;
        }
        return stepOSListItem;
    }

    public final void a(StepOSListItem stepOSListItem) {
        k.g(stepOSListItem, "row");
        this.f23346a = new WeakReference<>(stepOSListItem);
        stepOSListItem.setSwitchHapticFeedbackOwner$StepOSWidget_release(this);
        stepOSListItem.setSwitchHapticFeedbackEnabled(this.f23347b);
    }

    public final void c() {
        StepOSListItem stepOSListItemB;
        if (this.f23347b && (stepOSListItemB = b()) != null) {
            l.f20292a.c(stepOSListItemB);
        }
    }
}
