package com.stepos.widget.toolbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"com/stepos/widget/toolbar/StepOSCollapsingTitleBar$SavedState", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcelable;", "superState", AppAgent.CONSTRUCT, "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", AgentBusWakeContract.EXTRA_SOURCE, "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "collapseProgress", "F", "getCollapseProgress", "()F", "setCollapseProgress", "(F)V", "scrollRange", "I", "getScrollRange", "()I", "setScrollRange", "(I)V", "Companion", "com/stepos/widget/toolbar/b", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class StepOSCollapsingTitleBar$SavedState extends View.BaseSavedState {
    private float collapseProgress;
    private int scrollRange;
    public static final b Companion = new b();
    public static final Parcelable.ClassLoaderCreator<StepOSCollapsingTitleBar$SavedState> CREATOR = new a(0);

    public /* synthetic */ StepOSCollapsingTitleBar$SavedState(Parcel parcel, ClassLoader classLoader, kotlin.jvm.internal.e eVar) {
        this(parcel, classLoader);
    }

    public final float getCollapseProgress() {
        return this.collapseProgress;
    }

    public final int getScrollRange() {
        return this.scrollRange;
    }

    public final void setCollapseProgress(float f) {
        this.collapseProgress = f;
    }

    public final void setScrollRange(int i) {
        this.scrollRange = i;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        k.f(out, "out");
        super.writeToParcel(out, flags);
        out.writeFloat(this.collapseProgress);
        out.writeInt(this.scrollRange);
    }

    public StepOSCollapsingTitleBar$SavedState(Parcelable parcelable) {
        super(parcelable);
        this.scrollRange = 1;
    }

    private StepOSCollapsingTitleBar$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.scrollRange = 1;
        this.collapseProgress = parcel.readFloat();
        this.scrollRange = parcel.readInt();
    }
}
