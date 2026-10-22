package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/ability/bean/GuiAgentConfig;", "Landroid/os/Parcelable;", "Landroid/view/Surface;", "surface", "", "taskType", "startMode", "", "openAppName", "modelName", "", "useExperienceLibrary", "Landroid/os/Bundle;", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, AppAgent.CONSTRUCT, "(Landroid/view/Surface;IILjava/lang/String;Ljava/lang/String;ZLandroid/os/Bundle;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "I", "getTaskType", "getStartMode", "Ljava/lang/String;", "getOpenAppName", "()Ljava/lang/String;", "getModelName", "Z", "getUseExperienceLibrary", "()Z", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiAgentConfig implements Parcelable {
    public static final Parcelable.Creator<GuiAgentConfig> CREATOR = new Creator();
    private final Bundle extras;
    private final String modelName;
    private final String openAppName;
    private final int startMode;
    private final Surface surface;
    private final int taskType;
    private final boolean useExperienceLibrary;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GuiAgentConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuiAgentConfig createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new GuiAgentConfig((Surface) parcel.readParcelable(GuiAgentConfig.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readBundle(GuiAgentConfig.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuiAgentConfig[] newArray(int i) {
            return new GuiAgentConfig[i];
        }
    }

    public GuiAgentConfig(Surface surface, int i, int i6, String str, String str2, boolean z10, Bundle bundle) {
        this.surface = surface;
        this.taskType = i;
        this.startMode = i6;
        this.openAppName = str;
        this.modelName = str2;
        this.useExperienceLibrary = z10;
        this.extras = bundle;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getOpenAppName() {
        return this.openAppName;
    }

    public final int getStartMode() {
        return this.startMode;
    }

    public final Surface getSurface() {
        return this.surface;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final boolean getUseExperienceLibrary() {
        return this.useExperienceLibrary;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeParcelable(this.surface, flags);
        dest.writeInt(this.taskType);
        dest.writeInt(this.startMode);
        dest.writeString(this.openAppName);
        dest.writeString(this.modelName);
        dest.writeInt(this.useExperienceLibrary ? 1 : 0);
        dest.writeBundle(this.extras);
    }

    public /* synthetic */ GuiAgentConfig(Surface surface, int i, int i6, String str, String str2, boolean z10, Bundle bundle, int i10, e eVar) {
        this((i10 & 1) != 0 ? null : surface, i, (i10 & 4) != 0 ? 0 : i6, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? true : z10, (i10 & 64) != 0 ? null : bundle);
    }
}
