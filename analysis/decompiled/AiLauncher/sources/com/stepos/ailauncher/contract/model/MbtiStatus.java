package com.stepos.ailauncher.contract.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ@\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u0010\u0010\u001e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\rJ\u001a\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b'\u0010\u0017R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u001a¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/contract/model/MbtiStatus;", "Landroid/os/Parcelable;", "", "tested", "", "reportUrl", "demoReportUrl", "", "marqueeTexts", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/util/List;", ChatTracker.CLICK_COPY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/stepos/ailauncher/contract/model/MbtiStatus;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getTested", "Ljava/lang/String;", "getReportUrl", "getDemoReportUrl", "Ljava/util/List;", "getMarqueeTexts", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MbtiStatus implements Parcelable {
    public static final Parcelable.Creator<MbtiStatus> CREATOR = new Creator();

    @SerializedName("demoReportUrl")
    private final String demoReportUrl;

    @SerializedName("marqueeTexts")
    private final List<String> marqueeTexts;

    @SerializedName("reportUrl")
    private final String reportUrl;

    @SerializedName("tested")
    private final boolean tested;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MbtiStatus> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MbtiStatus createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new MbtiStatus(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MbtiStatus[] newArray(int i10) {
            return new MbtiStatus[i10];
        }
    }

    public MbtiStatus(boolean z10, String str, String demoReportUrl, List<String> marqueeTexts) {
        p.i(demoReportUrl, "demoReportUrl");
        p.i(marqueeTexts, "marqueeTexts");
        this.tested = z10;
        this.reportUrl = str;
        this.demoReportUrl = demoReportUrl;
        this.marqueeTexts = marqueeTexts;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MbtiStatus copy$default(MbtiStatus mbtiStatus, boolean z10, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = mbtiStatus.tested;
        }
        if ((i10 & 2) != 0) {
            str = mbtiStatus.reportUrl;
        }
        if ((i10 & 4) != 0) {
            str2 = mbtiStatus.demoReportUrl;
        }
        if ((i10 & 8) != 0) {
            list = mbtiStatus.marqueeTexts;
        }
        return mbtiStatus.copy(z10, str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getTested() {
        return this.tested;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReportUrl() {
        return this.reportUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDemoReportUrl() {
        return this.demoReportUrl;
    }

    public final List<String> component4() {
        return this.marqueeTexts;
    }

    public final MbtiStatus copy(boolean tested, String reportUrl, String demoReportUrl, List<String> marqueeTexts) {
        p.i(demoReportUrl, "demoReportUrl");
        p.i(marqueeTexts, "marqueeTexts");
        return new MbtiStatus(tested, reportUrl, demoReportUrl, marqueeTexts);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MbtiStatus)) {
            return false;
        }
        MbtiStatus mbtiStatus = (MbtiStatus) other;
        return this.tested == mbtiStatus.tested && p.d(this.reportUrl, mbtiStatus.reportUrl) && p.d(this.demoReportUrl, mbtiStatus.demoReportUrl) && p.d(this.marqueeTexts, mbtiStatus.marqueeTexts);
    }

    public final String getDemoReportUrl() {
        return this.demoReportUrl;
    }

    public final List<String> getMarqueeTexts() {
        return this.marqueeTexts;
    }

    public final String getReportUrl() {
        return this.reportUrl;
    }

    public final boolean getTested() {
        return this.tested;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.tested) * 31;
        String str = this.reportUrl;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.demoReportUrl.hashCode()) * 31) + this.marqueeTexts.hashCode();
    }

    public String toString() {
        return "MbtiStatus(tested=" + this.tested + ", reportUrl=" + this.reportUrl + ", demoReportUrl=" + this.demoReportUrl + ", marqueeTexts=" + this.marqueeTexts + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.tested ? 1 : 0);
        dest.writeString(this.reportUrl);
        dest.writeString(this.demoReportUrl);
        dest.writeStringList(this.marqueeTexts);
    }
}
