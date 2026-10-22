package com.stepos.widget.list;

import C6.a;
import F6.h;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.customview.view.AbsSavedState;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"com/stepos/widget/list/StepOSSwipeActionLayout$SavedState", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", AppAgent.CONSTRUCT, "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", AgentBusWakeContract.EXTRA_SOURCE, "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "open", "Z", "getOpen", "()Z", "setOpen", "(Z)V", "Companion", "F6/h", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSSwipeActionLayout$SavedState extends AbsSavedState {
    private boolean open;
    public static final h Companion = new h();
    public static final Parcelable.ClassLoaderCreator<StepOSSwipeActionLayout$SavedState> CREATOR = new a(1);

    public StepOSSwipeActionLayout$SavedState(Parcelable parcelable) {
        super(parcelable == null ? AbsSavedState.EMPTY_STATE : parcelable);
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final void setOpen(boolean z10) {
        this.open = z10;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        k.f(out, "out");
        super.writeToParcel(out, flags);
        out.writeInt(this.open ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwipeActionLayout$SavedState(Parcel source, ClassLoader classLoader) {
        super(source, classLoader);
        k.f(source, "source");
        this.open = source.readInt() != 0;
    }
}
