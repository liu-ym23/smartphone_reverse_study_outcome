package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OComplexTaskConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OComplexTaskConfig implements Parcelable {
    public static final Parcelable.Creator<OComplexTaskConfig> CREATOR = null;
    private final String llmModel;
    private final int localSearchEnableScene;
    private final String modeLevel;
    private final String taskMode;

    /* JADX INFO: compiled from: OComplexTaskConfig.kt */
    public static final class Creator implements Parcelable.Creator<OComplexTaskConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OComplexTaskConfig createFromParcel(Parcel r4) {
            o.e(r4, "parcel");
            return new OComplexTaskConfig(r4.readString(), r4.readString(), r4.readInt(), r4.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OComplexTaskConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OComplexTaskConfig[] newArray(int r1) {
            return new OComplexTaskConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OComplexTaskConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.taskMode);
        r1.writeString(this.llmModel);
        r1.writeInt(this.localSearchEnableScene);
        r1.writeString(this.modeLevel);
    }

    public OComplexTaskConfig(String r2, String r3, int r4, String r5) {
        o.e(r2, "taskMode");
        o.e(r3, "llmModel");
        o.e(r5, "modeLevel");
        this.taskMode = r2;
        this.llmModel = r3;
        this.localSearchEnableScene = r4;
        this.modeLevel = r5;
    }

    public final String getTaskMode() {
        return this.taskMode;
    }

    public final String getLlmModel() {
        return this.llmModel;
    }

    public final int getLocalSearchEnableScene() {
        return this.localSearchEnableScene;
    }

    public final String getModeLevel() {
        return this.modeLevel;
    }
}
