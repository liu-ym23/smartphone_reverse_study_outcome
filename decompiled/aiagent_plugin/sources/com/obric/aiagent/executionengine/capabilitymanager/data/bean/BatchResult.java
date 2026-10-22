package com.obric.aiagent.executionengine.capabilitymanager.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BatchResult implements Parcelable {
    public static final Parcelable.Creator<BatchResult> CREATOR = null;

    @SerializedName("bind_result")
    private final RegisterResult bindResult;

    @SerializedName("enable_result")
    private final RegisterResult enableResult;

    @SerializedName("register_result")
    private final List<RegisterResult> registerResult;

    /* JADX INFO: compiled from: Result.kt */
    public static final class Creator implements Parcelable.Creator<BatchResult> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BatchResult createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            RegisterResult r0 = null;
            if (r5.readInt() != 0) goto L5;
            ArrayList r1 = null;
        L8:
            List r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
            if (r5.readInt() != 0) goto L11;
            RegisterResult r2 = null;
        L12:
            RegisterResult r3 = (RegisterResult) ZeusTransformUtils.preCheckCast(r2, RegisterResult.class, "com.obric.aiagent.plugin");
            if (r5.readInt() == 0) goto L17;
            r0 = RegisterResult.CREATOR.createFromParcel(r5);
        L17:
            return new BatchResult(r4, r3, (RegisterResult) ZeusTransformUtils.preCheckCast(r0, RegisterResult.class, "com.obric.aiagent.plugin"));
        L11:
            r2 = RegisterResult.CREATOR.createFromParcel(r5);
            goto L12
        L5:
            int r6 = r5.readInt();
            r1 = new ArrayList(r6);
            int r7 = 0;
        L6:
            if (r7 == r6) goto L8;
            r1.add(RegisterResult.CREATOR.createFromParcel(r5));
            r7 = r7 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BatchResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BatchResult[] newArray(int r1) {
            return new BatchResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BatchResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ BatchResult copy$default(BatchResult r1, List r2, RegisterResult r3, RegisterResult r4, int r5, Object r6) {
        List<RegisterResult> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.registerResult;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.enableResult;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.bindResult;
    L12:
        return r1.copy(r7, r3, r4);
    }

    public final List<RegisterResult> component1() {
        return this.registerResult;
    }

    public final RegisterResult component2() {
        return this.enableResult;
    }

    public final RegisterResult component3() {
        return this.bindResult;
    }

    public final BatchResult copy(List<RegisterResult> r2, RegisterResult r3, RegisterResult r4) {
        return new BatchResult((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BatchResult.class) == true) goto L8;
        return false;
    L8:
        BatchResult r6 = (BatchResult) ZeusTransformUtils.preCheckCast(r5, BatchResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.registerResult, r6.registerResult) == true) goto L12;
        return false;
    L12:
        if (o.a(this.enableResult, r6.enableResult) == true) goto L15;
        return false;
    L15:
        if (o.a(this.bindResult, r6.bindResult) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<RegisterResult> r0 = this.registerResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        RegisterResult r4 = this.enableResult;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        RegisterResult r7 = this.bindResult;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BatchResult(registerResult=" + this.registerResult + ", enableResult=" + this.enableResult + ", bindResult=" + this.bindResult + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r7, int r8) {
        o.e(r7, "dest");
        List<RegisterResult> r0 = this.registerResult;
        if (r0 != null) goto L5;
        r7.writeInt(0);
    L9:
        RegisterResult r1 = this.enableResult;
        if (r1 != null) goto L12;
        r7.writeInt(0);
    L13:
        RegisterResult r6 = this.bindResult;
        if (r6 != null) goto L16;
        r7.writeInt(0);
        return;
    L16:
        r7.writeInt(1);
        r6.writeToParcel(r7, r8);
        return;
    L12:
        r7.writeInt(1);
        r1.writeToParcel(r7, r8);
        goto L13
    L5:
        r7.writeInt(1);
        r7.writeInt(r0.size());
        Iterator<RegisterResult> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((RegisterResult) ZeusTransformUtils.preCheckCast(r2.next(), RegisterResult.class, "com.obric.aiagent.plugin")).writeToParcel(r7, r8);
        goto L7
    }

    public BatchResult(List<RegisterResult> r3, RegisterResult r4, RegisterResult r5) {
        this.registerResult = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.enableResult = r4;
        this.bindResult = r5;
    }

    public final List<RegisterResult> getRegisterResult() {
        return this.registerResult;
    }

    public final RegisterResult getEnableResult() {
        return this.enableResult;
    }

    public final RegisterResult getBindResult() {
        return this.bindResult;
    }
}
