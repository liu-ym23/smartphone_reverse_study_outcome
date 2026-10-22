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
import java.util.List;

/* JADX INFO: compiled from: RecorderShowRecordingParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RecorderShowRecordingParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<RecorderShowRecordingParams> CREATOR = null;
    private RecordingEntity target;

    /* JADX INFO: compiled from: RecorderShowRecordingParams.kt */
    public static final class Creator implements Parcelable.Creator<RecorderShowRecordingParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderShowRecordingParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            RecorderShowRecordingParams r1 = new RecorderShowRecordingParams((RecordingEntity) ZeusTransformUtils.preCheckCast(r6.readParcelable(RecorderShowRecordingParams.class.getClassLoader()), RecordingEntity.class, "com.obric.aiagent.plugin"));
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r6, r5);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderShowRecordingParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderShowRecordingParams[] newArray(int r1) {
            return new RecorderShowRecordingParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderShowRecordingParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecorderShowRecordingParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RecorderShowRecordingParams copy$default(RecorderShowRecordingParams r0, RecordingEntity r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        return r0.copy(r1);
    }

    public final RecordingEntity component1() {
        return this.target;
    }

    public final RecorderShowRecordingParams copy(RecordingEntity r1) {
        return new RecorderShowRecordingParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RecorderShowRecordingParams.class) == true) goto L8;
        return false;
    L8:
        RecorderShowRecordingParams r6 = (RecorderShowRecordingParams) ZeusTransformUtils.preCheckCast(r5, RecorderShowRecordingParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        RecordingEntity r0 = this.target;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "RecorderShowRecordingParams(target=" + this.target + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.target, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }

    public RecorderShowRecordingParams(RecordingEntity r1) {
        this.target = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ RecorderShowRecordingParams(RecordingEntity r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final RecordingEntity getTarget() {
        return this.target;
    }

    public final void setTarget(RecordingEntity r1) {
        this.target = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, RecorderShowRecordingParams.class) == false) goto L5;
        RecordingEntity r3 = this.target;
        if (r3 != null) goto L10;
        r3 = ((RecorderShowRecordingParams) ZeusTransformUtils.preCheckCast(r4, RecorderShowRecordingParams.class, "com.obric.aiagent.plugin")).target;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new RecorderShowRecordingParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.target);
    }
}
