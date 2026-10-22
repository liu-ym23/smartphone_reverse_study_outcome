package com.stepos.ability.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class GuiAgentConfig implements Parcelable {
    public static final Parcelable.Creator<GuiAgentConfig> CREATOR = new a();
    private final Bundle extras;
    private final String modelName;
    private final String openAppName;
    private final int startMode;
    private final Surface surface;
    private final int taskType;
    private final boolean useExperienceLibrary;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<GuiAgentConfig> {
        @Override // android.os.Parcelable.Creator
        public final GuiAgentConfig createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new GuiAgentConfig((Surface) parcel.readParcelable(GuiAgentConfig.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readBundle(GuiAgentConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final GuiAgentConfig[] newArray(int i10) {
            return new GuiAgentConfig[i10];
        }
    }

    public GuiAgentConfig(Surface surface, int i10, int i11, String str, String str2, boolean z, Bundle bundle) {
        this.surface = surface;
        this.taskType = i10;
        this.startMode = i11;
        this.openAppName = str;
        this.modelName = str2;
        this.useExperienceLibrary = z;
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
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeParcelable(this.surface, i10);
        dest.writeInt(this.taskType);
        dest.writeInt(this.startMode);
        dest.writeString(this.openAppName);
        dest.writeString(this.modelName);
        dest.writeInt(this.useExperienceLibrary ? 1 : 0);
        dest.writeBundle(this.extras);
    }

    public /* synthetic */ GuiAgentConfig(Surface surface, int i10, int i11, String str, String str2, boolean z, Bundle bundle, int i12, e eVar) {
        this((i12 & 1) != 0 ? null : surface, i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : str, (i12 & 16) != 0 ? null : str2, (i12 & 32) != 0 ? true : z, (i12 & 64) != 0 ? null : bundle);
    }
}
