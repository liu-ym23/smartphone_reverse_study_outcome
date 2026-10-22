package com.stepos.taskrobot.taskmanager.experiencelib.model;

import androidx.annotation.Keep;
import androidx.appfunctions.metadata.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SpeculationLabel;", "", "labels", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SpeculationLabel$Label;", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "getLabels", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", TextFieldImplKt.LabelId, "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SpeculationLabel {

    @SerializedName("labels")
    private final List<Label> labels;

    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SpeculationLabel$Label;", "", "step", "", "isSpeculation", "", "specConfidence", "", "specReason", "", AppAgent.CONSTRUCT, "(IZDLjava/lang/String;)V", "getStep", "()I", "()Z", "getSpecConfidence", "()D", "getSpecReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Label {

        @SerializedName("is_speculation")
        private final boolean isSpeculation;

        @SerializedName("spec_confidence")
        private final double specConfidence;

        @SerializedName("spec_reason")
        private final String specReason;

        @SerializedName("step")
        private final int step;

        public Label(int i, boolean z10, double d, String specReason) {
            k.f(specReason, "specReason");
            this.step = i;
            this.isSpeculation = z10;
            this.specConfidence = d;
            this.specReason = specReason;
        }

        public static /* synthetic */ Label copy$default(Label label, int i, boolean z10, double d, String str, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = label.step;
            }
            if ((i6 & 2) != 0) {
                z10 = label.isSpeculation;
            }
            if ((i6 & 4) != 0) {
                d = label.specConfidence;
            }
            if ((i6 & 8) != 0) {
                str = label.specReason;
            }
            String str2 = str;
            return label.copy(i, z10, d, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStep() {
            return this.step;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSpeculation() {
            return this.isSpeculation;
        }

        /* renamed from: component3, reason: from getter */
        public final double getSpecConfidence() {
            return this.specConfidence;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSpecReason() {
            return this.specReason;
        }

        public final Label copy(int step, boolean isSpeculation, double specConfidence, String specReason) {
            k.f(specReason, "specReason");
            return new Label(step, isSpeculation, specConfidence, specReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Label)) {
                return false;
            }
            Label label = (Label) other;
            return this.step == label.step && this.isSpeculation == label.isSpeculation && Double.compare(this.specConfidence, label.specConfidence) == 0 && k.b(this.specReason, label.specReason);
        }

        public final double getSpecConfidence() {
            return this.specConfidence;
        }

        public final String getSpecReason() {
            return this.specReason;
        }

        public final int getStep() {
            return this.step;
        }

        public int hashCode() {
            return this.specReason.hashCode() + ((Double.hashCode(this.specConfidence) + a.d(Integer.hashCode(this.step) * 31, 31, this.isSpeculation)) * 31);
        }

        public final boolean isSpeculation() {
            return this.isSpeculation;
        }

        public String toString() {
            return "Label(step=" + this.step + ", isSpeculation=" + this.isSpeculation + ", specConfidence=" + this.specConfidence + ", specReason=" + this.specReason + ")";
        }
    }

    public SpeculationLabel() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpeculationLabel copy$default(SpeculationLabel speculationLabel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = speculationLabel.labels;
        }
        return speculationLabel.copy(list);
    }

    public final List<Label> component1() {
        return this.labels;
    }

    public final SpeculationLabel copy(List<Label> labels) {
        k.f(labels, "labels");
        return new SpeculationLabel(labels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SpeculationLabel) && k.b(this.labels, ((SpeculationLabel) other).labels);
    }

    public final List<Label> getLabels() {
        return this.labels;
    }

    public int hashCode() {
        return this.labels.hashCode();
    }

    public String toString() {
        return "SpeculationLabel(labels=" + this.labels + ")";
    }

    public SpeculationLabel(List<Label> labels) {
        k.f(labels, "labels");
        this.labels = labels;
    }

    public SpeculationLabel(List list, int i, e eVar) {
        this((i & 1) != 0 ? EmptyList.f4893a : list);
    }
}
