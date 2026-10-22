package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AwarenessConditionConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AwarenessConditionRule implements Parcelable {
    public static final Parcelable.Creator<AwarenessConditionRule> CREATOR = null;
    private final String operator;
    private final ArrayList<String> values;

    /* JADX INFO: compiled from: AwarenessConditionConfig.kt */
    public static final class Creator implements Parcelable.Creator<AwarenessConditionRule> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessConditionRule createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new AwarenessConditionRule(r2.readString(), r2.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessConditionRule createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessConditionRule[] newArray(int r1) {
            return new AwarenessConditionRule[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessConditionRule[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AwarenessConditionRule copy$default(AwarenessConditionRule r0, String r1, ArrayList r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.operator;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.values;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.operator;
    }

    public final ArrayList<String> component2() {
        return this.values;
    }

    public final AwarenessConditionRule copy(String r1, ArrayList<String> r2) {
        o.e(r1, "operator");
        o.e(r2, "values");
        return new AwarenessConditionRule(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AwarenessConditionRule.class) == true) goto L8;
        return false;
    L8:
        AwarenessConditionRule r6 = (AwarenessConditionRule) ZeusTransformUtils.preCheckCast(r5, AwarenessConditionRule.class, "com.obric.aiagent.plugin");
        if (o.a(this.operator, r6.operator) == true) goto L12;
        return false;
    L12:
        if (o.a(this.values, r6.values) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.operator.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        return "AwarenessConditionRule(operator=" + this.operator + ", values=" + this.values + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "dest");
        r2.writeString(this.operator);
        r2.writeStringList((List) ZeusTransformUtils.preCheckCast(this.values, List.class, "com.obric.aiagent.plugin"));
    }

    public AwarenessConditionRule(String r2, ArrayList<String> r3) {
        o.e(r2, "operator");
        o.e(r3, "values");
        this.operator = r2;
        this.values = r3;
    }

    public final String getOperator() {
        return this.operator;
    }

    public /* synthetic */ AwarenessConditionRule(String r1, ArrayList r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new ArrayList();
    L5:
        this(r1, r2);
    }

    public final ArrayList<String> getValues() {
        return this.values;
    }
}
