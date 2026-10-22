package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: OfficeSearchLarkContactInfoByAsrParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OfficeSearchLarkContactInfoByAsrParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<OfficeSearchLarkContactInfoByAsrParams> CREATOR = null;
    private String[] audioFiles;

    /* JADX INFO: compiled from: OfficeSearchLarkContactInfoByAsrParams.kt */
    public static final class Creator implements Parcelable.Creator<OfficeSearchLarkContactInfoByAsrParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchLarkContactInfoByAsrParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            OfficeSearchLarkContactInfoByAsrParams r1 = new OfficeSearchLarkContactInfoByAsrParams(r5.createStringArray());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchLarkContactInfoByAsrParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchLarkContactInfoByAsrParams[] newArray(int r1) {
            return new OfficeSearchLarkContactInfoByAsrParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchLarkContactInfoByAsrParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSearchLarkContactInfoByAsrParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OfficeSearchLarkContactInfoByAsrParams copy$default(OfficeSearchLarkContactInfoByAsrParams r0, String[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.audioFiles;
    L6:
        return r0.copy(r1);
    }

    public final String[] component1() {
        return this.audioFiles;
    }

    public final OfficeSearchLarkContactInfoByAsrParams copy(String[] r1) {
        return new OfficeSearchLarkContactInfoByAsrParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeSearchLarkContactInfoByAsrParams.class) == true) goto L8;
        return false;
    L8:
        OfficeSearchLarkContactInfoByAsrParams r6 = (OfficeSearchLarkContactInfoByAsrParams) ZeusTransformUtils.preCheckCast(r5, OfficeSearchLarkContactInfoByAsrParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.audioFiles, r6.audioFiles) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String[] r0 = this.audioFiles;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public String toString() {
        return "OfficeSearchLarkContactInfoByAsrParams(audioFiles=" + Arrays.toString(this.audioFiles) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeStringArray(this.audioFiles);
    }

    public OfficeSearchLarkContactInfoByAsrParams(String[] r1) {
        this.audioFiles = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ OfficeSearchLarkContactInfoByAsrParams(String[] r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String[] getAudioFiles() {
        return this.audioFiles;
    }

    public final void setAudioFiles(String[] r1) {
        this.audioFiles = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, OfficeSearchLarkContactInfoByAsrParams.class) == false) goto L5;
        String[] r3 = this.audioFiles;
        if (r3 != null) goto L10;
        r3 = ((OfficeSearchLarkContactInfoByAsrParams) ZeusTransformUtils.preCheckCast(r4, OfficeSearchLarkContactInfoByAsrParams.class, "com.obric.aiagent.plugin")).audioFiles;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new OfficeSearchLarkContactInfoByAsrParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
