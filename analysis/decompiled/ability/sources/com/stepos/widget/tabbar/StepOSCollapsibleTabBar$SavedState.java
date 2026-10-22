package com.stepos.widget.tabbar;

import K6.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.customview.view.AbsSavedState;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"com/stepos/widget/tabbar/StepOSCollapsibleTabBar$SavedState", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", AppAgent.CONSTRUCT, "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", AgentBusWakeContract.EXTRA_SOURCE, "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "selectedItemId", "I", "getSelectedItemId$StepOSWidget_release", "()I", "setSelectedItemId$StepOSWidget_release", "(I)V", "", "collapsed", "Z", "getCollapsed$StepOSWidget_release", "()Z", "setCollapsed$StepOSWidget_release", "(Z)V", "Companion", "K6/a", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSCollapsibleTabBar$SavedState extends AbsSavedState {
    private boolean collapsed;

    @IdRes
    private int selectedItemId;
    public static final a Companion = new a();
    public static final Parcelable.Creator<StepOSCollapsibleTabBar$SavedState> CREATOR = new C6.a(4);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleTabBar$SavedState(Parcelable superState) {
        super(superState);
        k.f(superState, "superState");
    }

    /* renamed from: getCollapsed$StepOSWidget_release, reason: from getter */
    public final boolean getCollapsed() {
        return this.collapsed;
    }

    /* renamed from: getSelectedItemId$StepOSWidget_release, reason: from getter */
    public final int getSelectedItemId() {
        return this.selectedItemId;
    }

    public final void setCollapsed$StepOSWidget_release(boolean z10) {
        this.collapsed = z10;
    }

    public final void setSelectedItemId$StepOSWidget_release(int i) {
        this.selectedItemId = i;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        k.f(out, "out");
        super.writeToParcel(out, flags);
        out.writeInt(this.selectedItemId);
        out.writeInt(this.collapsed ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleTabBar$SavedState(Parcel source, ClassLoader classLoader) {
        super(source, classLoader);
        k.f(source, "source");
        this.selectedItemId = source.readInt();
        this.collapsed = source.readInt() != 0;
    }
}
