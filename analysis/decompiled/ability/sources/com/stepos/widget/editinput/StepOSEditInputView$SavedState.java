package com.stepos.widget.editinput;

import C6.a;
import C6.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001)B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R$\u0010\"\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"com/stepos/widget/editinput/StepOSEditInputView$SavedState", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", AppAgent.CONSTRUCT, "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", AgentBusWakeContract.EXTRA_SOURCE, "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "passwordVisible", "Z", "getPasswordVisible$StepOSWidget_release", "()Z", "setPasswordVisible$StepOSWidget_release", "(Z)V", "passwordToggleEnabled", "getPasswordToggleEnabled$StepOSWidget_release", "setPasswordToggleEnabled$StepOSWidget_release", "autoCleanIconEnabled", "getAutoCleanIconEnabled$StepOSWidget_release", "setAutoCleanIconEnabled$StepOSWidget_release", "cleanIconVisible", "getCleanIconVisible$StepOSWidget_release", "setCleanIconVisible$StepOSWidget_release", "", "error", "Ljava/lang/String;", "getError$StepOSWidget_release", "()Ljava/lang/String;", "setError$StepOSWidget_release", "(Ljava/lang/String;)V", "Companion", "C6/b", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StepOSEditInputView$SavedState extends AbsSavedState {
    private boolean autoCleanIconEnabled;
    private boolean cleanIconVisible;
    private String error;
    private boolean passwordToggleEnabled;
    private boolean passwordVisible;
    public static final b Companion = new b();
    public static final Parcelable.Creator<StepOSEditInputView$SavedState> CREATOR = new a(0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSEditInputView$SavedState(Parcelable superState) {
        super(superState);
        k.f(superState, "superState");
        this.autoCleanIconEnabled = true;
    }

    /* renamed from: getAutoCleanIconEnabled$StepOSWidget_release, reason: from getter */
    public final boolean getAutoCleanIconEnabled() {
        return this.autoCleanIconEnabled;
    }

    /* renamed from: getCleanIconVisible$StepOSWidget_release, reason: from getter */
    public final boolean getCleanIconVisible() {
        return this.cleanIconVisible;
    }

    /* renamed from: getError$StepOSWidget_release, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: getPasswordToggleEnabled$StepOSWidget_release, reason: from getter */
    public final boolean getPasswordToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    /* renamed from: getPasswordVisible$StepOSWidget_release, reason: from getter */
    public final boolean getPasswordVisible() {
        return this.passwordVisible;
    }

    public final void setAutoCleanIconEnabled$StepOSWidget_release(boolean z10) {
        this.autoCleanIconEnabled = z10;
    }

    public final void setCleanIconVisible$StepOSWidget_release(boolean z10) {
        this.cleanIconVisible = z10;
    }

    public final void setError$StepOSWidget_release(String str) {
        this.error = str;
    }

    public final void setPasswordToggleEnabled$StepOSWidget_release(boolean z10) {
        this.passwordToggleEnabled = z10;
    }

    public final void setPasswordVisible$StepOSWidget_release(boolean z10) {
        this.passwordVisible = z10;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        k.f(out, "out");
        super.writeToParcel(out, flags);
        out.writeInt(this.passwordVisible ? 1 : 0);
        out.writeInt(this.passwordToggleEnabled ? 1 : 0);
        out.writeInt(this.autoCleanIconEnabled ? 1 : 0);
        out.writeInt(this.cleanIconVisible ? 1 : 0);
        out.writeString(this.error);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSEditInputView$SavedState(Parcel source, ClassLoader classLoader) {
        super(source, classLoader);
        k.f(source, "source");
        this.autoCleanIconEnabled = true;
        this.passwordVisible = source.readInt() != 0;
        this.passwordToggleEnabled = source.readInt() != 0;
        this.autoCleanIconEnabled = source.readInt() != 0;
        this.cleanIconVisible = source.readInt() != 0;
        this.error = source.readString();
    }
}
