package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", CommonKey.KEY_VALUE, "", "type", "", "(DLjava/lang/String;)V", "getType", "()Ljava/lang/String;", "getValue", "()D", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SearchScoreParam implements Parcelable {

    @NotNull
    public static final a CREATOR = null;

    @NotNull
    private final String type;
    private final double value;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public SearchScoreParam a(Parcel r10) {
            q.g(r10, "parcel");
            return new SearchScoreParam(r10);
        }

        public SearchScoreParam[] b(int r10) {
            return new SearchScoreParam[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public SearchScoreParam() {
        double r10 = 0.0d;
        String r11 = null;
        this(r10, r11, 3, null);
    }

    public static /* synthetic */ SearchScoreParam copy$default(SearchScoreParam r10, double r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.value;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.type;
    L9:
        return r10.copy(r11, r12);
    }

    public final double component1() {
        return this.value;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final SearchScoreParam copy(double r10, @NotNull String r11) {
        q.g(r11, "type");
        return new SearchScoreParam(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SearchScoreParam) == true) goto L8;
        return false;
    L8:
        SearchScoreParam r11 = (SearchScoreParam) r10;
        if (Double.compare(this.value, r11.value) == 0) goto L12;
        return false;
    L12:
        if (q.b(this.type, r11.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        return (Double.hashCode(this.value) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchScoreParam(value=" + this.value + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeDouble(this.value);
        r10.writeString(this.type);
    }

    public SearchScoreParam(double r10, @NotNull String r11) {
        q.g(r11, "type");
        this.value = r10;
        this.type = r11;
    }

    public /* synthetic */ SearchScoreParam(double r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0.0d;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = "";
    L8:
        this(r10, r11);
    }

    public SearchScoreParam(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        double r11 = r10.readDouble();
        String r12 = r10.readString();
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        this(r11, r12);
    }
}
