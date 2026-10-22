package com.stepos.widget.tabbar;

import C6.a;
import K6.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IdRes;
import androidx.customview.view.AbsSavedState;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\f\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006#"}, d2 = {"com/stepos/widget/tabbar/StepOSTabBar$SavedState", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", AppAgent.CONSTRUCT, "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", AgentBusWakeContract.EXTRA_SOURCE, "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "selectedItemId", "I", "getSelectedItemId$StepOSWidget_release", "()I", "setSelectedItemId$StepOSWidget_release", "(I)V", "", "badgeItemIds", "[I", "getBadgeItemIds$StepOSWidget_release", "()[I", "setBadgeItemIds$StepOSWidget_release", "([I)V", "badgeCounts", "getBadgeCounts$StepOSWidget_release", "setBadgeCounts$StepOSWidget_release", "Companion", "K6/b", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSTabBar$SavedState extends AbsSavedState {
    private int[] badgeCounts;
    private int[] badgeItemIds;

    @IdRes
    private int selectedItemId;
    public static final b Companion = new b();
    public static final Parcelable.Creator<StepOSTabBar$SavedState> CREATOR = new a(5);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSTabBar$SavedState(Parcelable superState) {
        super(superState);
        k.f(superState, "superState");
        this.badgeItemIds = new int[0];
        this.badgeCounts = new int[0];
    }

    /* renamed from: getBadgeCounts$StepOSWidget_release, reason: from getter */
    public final int[] getBadgeCounts() {
        return this.badgeCounts;
    }

    /* renamed from: getBadgeItemIds$StepOSWidget_release, reason: from getter */
    public final int[] getBadgeItemIds() {
        return this.badgeItemIds;
    }

    /* renamed from: getSelectedItemId$StepOSWidget_release, reason: from getter */
    public final int getSelectedItemId() {
        return this.selectedItemId;
    }

    public final void setBadgeCounts$StepOSWidget_release(int[] iArr) {
        k.f(iArr, "<set-?>");
        this.badgeCounts = iArr;
    }

    public final void setBadgeItemIds$StepOSWidget_release(int[] iArr) {
        k.f(iArr, "<set-?>");
        this.badgeItemIds = iArr;
    }

    public final void setSelectedItemId$StepOSWidget_release(int i) {
        this.selectedItemId = i;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        k.f(out, "out");
        super.writeToParcel(out, flags);
        out.writeInt(this.selectedItemId);
        out.writeInt(this.badgeItemIds.length);
        for (int i : this.badgeItemIds) {
            out.writeInt(i);
        }
        for (int i6 : this.badgeCounts) {
            out.writeInt(i6);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSTabBar$SavedState(Parcel source, ClassLoader classLoader) {
        int i;
        super(source, classLoader);
        k.f(source, "source");
        this.badgeItemIds = new int[0];
        this.badgeCounts = new int[0];
        this.selectedItemId = source.readInt();
        if (source.dataAvail() >= 4 && (i = source.readInt()) > 0 && source.dataAvail() >= i * 8) {
            int[] iArr = new int[i];
            for (int i6 = 0; i6 < i; i6++) {
                iArr[i6] = source.readInt();
            }
            this.badgeItemIds = iArr;
            int[] iArr2 = new int[i];
            for (int i10 = 0; i10 < i; i10++) {
                iArr2[i10] = source.readInt();
            }
            this.badgeCounts = iArr2;
        }
    }
}
