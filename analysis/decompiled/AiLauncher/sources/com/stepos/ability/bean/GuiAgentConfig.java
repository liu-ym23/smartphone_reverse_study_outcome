package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/ability/bean/GuiAgentConfig;", "Landroid/os/Parcelable;", "Landroid/view/Surface;", "surface", "", "taskType", "startMode", "", "openAppName", "modelName", "", "useExperienceLibrary", "Landroid/os/Bundle;", "extras", "<init>", "(Landroid/view/Surface;IILjava/lang/String;Ljava/lang/String;ZLandroid/os/Bundle;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "I", "getTaskType", "getStartMode", "Ljava/lang/String;", "getOpenAppName", "()Ljava/lang/String;", "getModelName", "Z", "getUseExperienceLibrary", "()Z", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GuiAgentConfig implements Parcelable {
    public static final Parcelable.Creator<GuiAgentConfig> CREATOR = new a();
    private final Bundle extras;
    private final String modelName;
    private final String openAppName;
    private final int startMode;
    private final Surface surface;
    private final int taskType;
    private final boolean useExperienceLibrary;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<GuiAgentConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GuiAgentConfig createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new GuiAgentConfig((Surface) parcel.readParcelable(GuiAgentConfig.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readBundle(GuiAgentConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GuiAgentConfig[] newArray(int i10) {
            return new GuiAgentConfig[i10];
        }
    }

    public GuiAgentConfig(Surface surface, int i10, int i11, String str, String str2, boolean z10, Bundle bundle) {
        this.surface = surface;
        this.taskType = i10;
        this.startMode = i11;
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
        p.i(dest, "dest");
        dest.writeParcelable(this.surface, flags);
        dest.writeInt(this.taskType);
        dest.writeInt(this.startMode);
        dest.writeString(this.openAppName);
        dest.writeString(this.modelName);
        dest.writeInt(this.useExperienceLibrary ? 1 : 0);
        dest.writeBundle(this.extras);
    }

    public /* synthetic */ GuiAgentConfig(Surface surface, int i10, int i11, String str, String str2, boolean z10, Bundle bundle, int i12, i iVar) {
        this((i12 & 1) != 0 ? null : surface, i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : str, (i12 & 16) != 0 ? null : str2, (i12 & 32) != 0 ? true : z10, (i12 & 64) != 0 ? null : bundle);
    }
}
