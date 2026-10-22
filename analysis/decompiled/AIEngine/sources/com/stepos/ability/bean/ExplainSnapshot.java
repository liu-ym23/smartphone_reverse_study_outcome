package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import h0.e;
import java.util.List;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExplainSnapshot implements Parcelable {
    public static final Parcelable.Creator<ExplainSnapshot> CREATOR = new a();
    private final String current;
    private final List<String> history;
    private final int stepIndex;
    private final int totalStepsHint;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<ExplainSnapshot> {
        @Override // android.os.Parcelable.Creator
        public final ExplainSnapshot createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new ExplainSnapshot(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final ExplainSnapshot[] newArray(int i10) {
            return new ExplainSnapshot[i10];
        }
    }

    public ExplainSnapshot(int i10, int i11, String current, List<String> history) {
        g.f(current, "current");
        g.f(history, "history");
        this.stepIndex = i10;
        this.totalStepsHint = i11;
        this.current = current;
        this.history = history;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExplainSnapshot copy$default(ExplainSnapshot explainSnapshot, int i10, int i11, String str, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = explainSnapshot.stepIndex;
        }
        if ((i12 & 2) != 0) {
            i11 = explainSnapshot.totalStepsHint;
        }
        if ((i12 & 4) != 0) {
            str = explainSnapshot.current;
        }
        if ((i12 & 8) != 0) {
            list = explainSnapshot.history;
        }
        return explainSnapshot.copy(i10, i11, str, list);
    }

    public final int component1() {
        return this.stepIndex;
    }

    public final int component2() {
        return this.totalStepsHint;
    }

    public final String component3() {
        return this.current;
    }

    public final List<String> component4() {
        return this.history;
    }

    public final ExplainSnapshot copy(int i10, int i11, String current, List<String> history) {
        g.f(current, "current");
        g.f(history, "history");
        return new ExplainSnapshot(i10, i11, current, history);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExplainSnapshot)) {
            return false;
        }
        ExplainSnapshot explainSnapshot = (ExplainSnapshot) obj;
        return this.stepIndex == explainSnapshot.stepIndex && this.totalStepsHint == explainSnapshot.totalStepsHint && g.b(this.current, explainSnapshot.current) && g.b(this.history, explainSnapshot.history);
    }

    public final String getCurrent() {
        return this.current;
    }

    public final List<String> getHistory() {
        return this.history;
    }

    public final int getStepIndex() {
        return this.stepIndex;
    }

    public final int getTotalStepsHint() {
        return this.totalStepsHint;
    }

    public int hashCode() {
        return this.history.hashCode() + d.a(ai.onnxruntime.a.d(this.totalStepsHint, Integer.hashCode(this.stepIndex) * 31, 31), 31, this.current);
    }

    public String toString() {
        int i10 = this.stepIndex;
        int i11 = this.totalStepsHint;
        String str = this.current;
        List<String> list = this.history;
        StringBuilder sbD = e.d(i10, "ExplainSnapshot(stepIndex=", i11, ", totalStepsHint=", ", current=");
        sbD.append(str);
        sbD.append(", history=");
        sbD.append(list);
        sbD.append(")");
        return sbD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.stepIndex);
        dest.writeInt(this.totalStepsHint);
        dest.writeString(this.current);
        dest.writeStringList(this.history);
    }
}
