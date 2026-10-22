package com.stepos.widget.searchbar;

import J6.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006#"}, d2 = {"com/stepos/widget/searchbar/StepOSSearchBar$SavedState", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", AppAgent.CONSTRUCT, "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", AgentBusWakeContract.EXTRA_SOURCE, "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "endIconActivated", "Z", "getEndIconActivated$StepOSWidget_release", "()Z", "setEndIconActivated$StepOSWidget_release", "(Z)V", "cancelButtonVisible", "getCancelButtonVisible$StepOSWidget_release", "setCancelButtonVisible$StepOSWidget_release", "navigationButtonVisible", "getNavigationButtonVisible$StepOSWidget_release", "setNavigationButtonVisible$StepOSWidget_release", "trailingButtonVisible", "getTrailingButtonVisible$StepOSWidget_release", "setTrailingButtonVisible$StepOSWidget_release", "Companion", "J6/a", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSSearchBar$SavedState extends AbsSavedState {
    private boolean cancelButtonVisible;
    private boolean endIconActivated;
    private boolean navigationButtonVisible;
    private boolean trailingButtonVisible;
    public static final a Companion = new a();
    public static final Parcelable.Creator<StepOSSearchBar$SavedState> CREATOR = new C6.a(3);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSearchBar$SavedState(Parcelable superState) {
        super(superState);
        k.f(superState, "superState");
    }

    /* renamed from: getCancelButtonVisible$StepOSWidget_release, reason: from getter */
    public final boolean getCancelButtonVisible() {
        return this.cancelButtonVisible;
    }

    /* renamed from: getEndIconActivated$StepOSWidget_release, reason: from getter */
    public final boolean getEndIconActivated() {
        return this.endIconActivated;
    }

    /* renamed from: getNavigationButtonVisible$StepOSWidget_release, reason: from getter */
    public final boolean getNavigationButtonVisible() {
        return this.navigationButtonVisible;
    }

    /* renamed from: getTrailingButtonVisible$StepOSWidget_release, reason: from getter */
    public final boolean getTrailingButtonVisible() {
        return this.trailingButtonVisible;
    }

    public final void setCancelButtonVisible$StepOSWidget_release(boolean z10) {
        this.cancelButtonVisible = z10;
    }

    public final void setEndIconActivated$StepOSWidget_release(boolean z10) {
        this.endIconActivated = z10;
    }

    public final void setNavigationButtonVisible$StepOSWidget_release(boolean z10) {
        this.navigationButtonVisible = z10;
    }

    public final void setTrailingButtonVisible$StepOSWidget_release(boolean z10) {
        this.trailingButtonVisible = z10;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        k.f(out, "out");
        super.writeToParcel(out, flags);
        out.writeInt(this.endIconActivated ? 1 : 0);
        out.writeInt(this.cancelButtonVisible ? 1 : 0);
        out.writeInt(this.navigationButtonVisible ? 1 : 0);
        out.writeInt(this.trailingButtonVisible ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSearchBar$SavedState(Parcel source, ClassLoader classLoader) {
        super(source, classLoader);
        k.f(source, "source");
        this.endIconActivated = source.readInt() != 0;
        this.cancelButtonVisible = source.readInt() != 0;
        this.navigationButtonVisible = source.readInt() != 0;
        this.trailingButtonVisible = source.readInt() != 0;
    }
}
