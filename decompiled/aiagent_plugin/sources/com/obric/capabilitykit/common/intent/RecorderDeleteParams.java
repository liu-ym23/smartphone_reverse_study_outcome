package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: RecorderDeleteParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RecorderDeleteParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<RecorderDeleteParams> CREATOR = null;
    private Boolean deleteAll;
    private RecordingEntity[] targets;

    /* JADX INFO: compiled from: RecorderDeleteParams.kt */
    public static final class Creator implements Parcelable.Creator<RecorderDeleteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderDeleteParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            Boolean r2 = null;
            if (r10.readInt() != 0) goto L5;
            RecordingEntity[] r4 = null;
        L8:
            int r5 = 1;
            if (r10.readInt() != 0) goto L12;
        L16:
            RecorderDeleteParams r1 = new RecorderDeleteParams(r4, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
        L17:
            if (r5 > r3) goto L19;
            r5 = r5 + 1;
        L19:
            if (r5 > r0) goto L21;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L19
        L21:
            return r1;
        L12:
            if (r10.readInt() == 0) goto L14;
            boolean r6 = true;
        L15:
            r2 = Boolean.valueOf(r6);
            goto L16
        L14:
            r6 = false;
            goto L15
        L5:
            int r7 = r10.readInt();
            r4 = new RecordingEntity[r7];
            int r8 = 0;
        L6:
            if (r8 == r7) goto L8;
            r4[r8] = (RecordingEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(RecorderDeleteParams.class.getClassLoader()), RecordingEntity.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderDeleteParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderDeleteParams[] newArray(int r1) {
            return new RecorderDeleteParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderDeleteParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecorderDeleteParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RecorderDeleteParams copy$default(RecorderDeleteParams r0, RecordingEntity[] r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.deleteAll;
    L9:
        return r0.copy(r1, r2);
    }

    public final RecordingEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.deleteAll;
    }

    public final RecorderDeleteParams copy(RecordingEntity[] r1, Boolean r2) {
        return new RecorderDeleteParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RecorderDeleteParams.class) == true) goto L8;
        return false;
    L8:
        RecorderDeleteParams r6 = (RecorderDeleteParams) ZeusTransformUtils.preCheckCast(r5, RecorderDeleteParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.targets, r6.targets) == true) goto L12;
        return false;
    L12:
        if (o.a(this.deleteAll, r6.deleteAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        RecordingEntity[] r0 = this.targets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.deleteAll;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "RecorderDeleteParams(targets=" + Arrays.toString(this.targets) + ", deleteAll=" + this.deleteAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r9, int r10) {
        r9.writeInt(0);
        o.e(r9, "out");
        RecordingEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r9.writeInt(0);
    L8:
        Boolean r8 = this.deleteAll;
        if (r8 != null) goto L11;
        r9.writeInt(0);
        return;
    L11:
        r9.writeInt(1);
        r9.writeInt(r8.booleanValue() ? 1 : 0);
        return;
    L5:
        r9.writeInt(1);
        int r3 = r1.length;
        r9.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1[r4], Parcelable.class, "com.obric.aiagent.plugin"), r10);
        r4 = r4 + 1;
        goto L6
    }

    public RecorderDeleteParams(RecordingEntity[] r1, Boolean r2) {
        this.targets = r1;
        this.deleteAll = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ RecorderDeleteParams(RecordingEntity[] r2, Boolean r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final RecordingEntity[] getTargets() {
        return this.targets;
    }

    public final void setTargets(RecordingEntity[] r1) {
        this.targets = r1;
    }

    public final Boolean getDeleteAll() {
        return this.deleteAll;
    }

    public final void setDeleteAll(Boolean r1) {
        this.deleteAll = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, RecorderDeleteParams.class) == false) goto L5;
        RecordingEntity[] r1 = this.targets;
        if (r1 != null) goto L9;
        r1 = ((RecorderDeleteParams) ZeusTransformUtils.preCheckCast(r4, RecorderDeleteParams.class, "com.obric.aiagent.plugin")).targets;
    L9:
        Boolean r3 = this.deleteAll;
        if (r3 != null) goto L13;
        r3 = ((RecorderDeleteParams) ZeusTransformUtils.preCheckCast(r4, RecorderDeleteParams.class, "com.obric.aiagent.plugin")).deleteAll;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new RecorderDeleteParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.targets);
    }
}
