package com.stepos.taskrobot.common.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J>\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\fJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u0018¨\u0006)"}, d2 = {"Lcom/stepos/taskrobot/common/bean/ExplainSnapshot;", "Landroid/os/Parcelable;", "", "stepIndex", "totalStepsHint", "", "current", "", "history", AppAgent.CONSTRUCT, "(IILjava/lang/String;Ljava/util/List;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "component3", "()Ljava/lang/String;", "component4", "()Ljava/util/List;", "copy", "(IILjava/lang/String;Ljava/util/List;)Lcom/stepos/taskrobot/common/bean/ExplainSnapshot;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStepIndex", "getTotalStepsHint", "Ljava/lang/String;", "getCurrent", "Ljava/util/List;", "getHistory", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExplainSnapshot implements Parcelable {
    public static final Parcelable.Creator<ExplainSnapshot> CREATOR = new Creator();
    private final String current;
    private final List<String> history;
    private final int stepIndex;
    private final int totalStepsHint;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExplainSnapshot> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExplainSnapshot createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new ExplainSnapshot(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExplainSnapshot[] newArray(int i) {
            return new ExplainSnapshot[i];
        }
    }

    public ExplainSnapshot(int i, int i6, String current, List<String> history) {
        k.f(current, "current");
        k.f(history, "history");
        this.stepIndex = i;
        this.totalStepsHint = i6;
        this.current = current;
        this.history = history;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExplainSnapshot copy$default(ExplainSnapshot explainSnapshot, int i, int i6, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = explainSnapshot.stepIndex;
        }
        if ((i10 & 2) != 0) {
            i6 = explainSnapshot.totalStepsHint;
        }
        if ((i10 & 4) != 0) {
            str = explainSnapshot.current;
        }
        if ((i10 & 8) != 0) {
            list = explainSnapshot.history;
        }
        return explainSnapshot.copy(i, i6, str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStepIndex() {
        return this.stepIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotalStepsHint() {
        return this.totalStepsHint;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCurrent() {
        return this.current;
    }

    public final List<String> component4() {
        return this.history;
    }

    public final ExplainSnapshot copy(int stepIndex, int totalStepsHint, String current, List<String> history) {
        k.f(current, "current");
        k.f(history, "history");
        return new ExplainSnapshot(stepIndex, totalStepsHint, current, history);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExplainSnapshot)) {
            return false;
        }
        ExplainSnapshot explainSnapshot = (ExplainSnapshot) other;
        return this.stepIndex == explainSnapshot.stepIndex && this.totalStepsHint == explainSnapshot.totalStepsHint && k.b(this.current, explainSnapshot.current) && k.b(this.history, explainSnapshot.history);
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
        return this.history.hashCode() + a.c(androidx.constraintlayout.core.dsl.a.a(this.totalStepsHint, Integer.hashCode(this.stepIndex) * 31, 31), 31, this.current);
    }

    public String toString() {
        int i = this.stepIndex;
        int i6 = this.totalStepsHint;
        String str = this.current;
        List<String> list = this.history;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "ExplainSnapshot(stepIndex=", i6, ", totalStepsHint=", ", current=");
        sbS.append(str);
        sbS.append(", history=");
        sbS.append(list);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.stepIndex);
        dest.writeInt(this.totalStepsHint);
        dest.writeString(this.current);
        dest.writeStringList(this.history);
    }
}
