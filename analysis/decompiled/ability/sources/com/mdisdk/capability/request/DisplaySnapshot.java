package com.mdisdk.capability.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.mdisdk.capability.model.WindowStateInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJX\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\"\u0010\u001bJ\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0016J\u001a\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b\u0005\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b-\u0010\u001bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u0010\u001eR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b0\u0010\u001bR\u0011\u00102\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\u0019R\u0013\u00104\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b3\u0010\u001bR\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b5\u0010\u001e¨\u00067"}, d2 = {"Lcom/mdisdk/capability/request/DisplaySnapshot;", "Landroid/os/Parcelable;", "", WindowStateInfo.KEY_DISPLAY_ID, "", "isActive", "", "topPackageName", "topActivityClassName", "", "Lcom/mdisdk/capability/model/WindowStateInfo;", "allWindows", "screenshotPath", AppAgent.CONSTRUCT, "(IZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Z", "component3", "()Ljava/lang/String;", "component4", "component5", "()Ljava/util/List;", "component6", "copy", "(IZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/mdisdk/capability/request/DisplaySnapshot;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getDisplayId", "Z", "Ljava/lang/String;", "getTopPackageName", "getTopActivityClassName", "Ljava/util/List;", "getAllWindows", "getScreenshotPath", "getHasForegroundActivity", "hasForegroundActivity", "getForegroundActivityComponent", "foregroundActivityComponent", "getApplicationWindows", "applicationWindows", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DisplaySnapshot implements Parcelable {
    public static final Parcelable.Creator<DisplaySnapshot> CREATOR = new Creator();
    private final List<WindowStateInfo> allWindows;
    private final int displayId;
    private final boolean isActive;
    private final String screenshotPath;
    private final String topActivityClassName;
    private final String topPackageName;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DisplaySnapshot> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DisplaySnapshot createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            int i = parcel.readInt();
            boolean z10 = parcel.readInt() != 0;
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i6 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i6);
            for (int i10 = 0; i10 != i6; i10++) {
                arrayList.add(parcel.readParcelable(DisplaySnapshot.class.getClassLoader()));
            }
            return new DisplaySnapshot(i, z10, string, string2, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DisplaySnapshot[] newArray(int i) {
            return new DisplaySnapshot[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DisplaySnapshot(int i, boolean z10, String str, String str2, List<? extends WindowStateInfo> allWindows, String str3) {
        k.f(allWindows, "allWindows");
        this.displayId = i;
        this.isActive = z10;
        this.topPackageName = str;
        this.topActivityClassName = str2;
        this.allWindows = allWindows;
        this.screenshotPath = str3;
    }

    public static /* synthetic */ DisplaySnapshot copy$default(DisplaySnapshot displaySnapshot, int i, boolean z10, String str, String str2, List list, String str3, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = displaySnapshot.displayId;
        }
        if ((i6 & 2) != 0) {
            z10 = displaySnapshot.isActive;
        }
        if ((i6 & 4) != 0) {
            str = displaySnapshot.topPackageName;
        }
        if ((i6 & 8) != 0) {
            str2 = displaySnapshot.topActivityClassName;
        }
        if ((i6 & 16) != 0) {
            list = displaySnapshot.allWindows;
        }
        if ((i6 & 32) != 0) {
            str3 = displaySnapshot.screenshotPath;
        }
        List list2 = list;
        String str4 = str3;
        return displaySnapshot.copy(i, z10, str, str2, list2, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDisplayId() {
        return this.displayId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTopPackageName() {
        return this.topPackageName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTopActivityClassName() {
        return this.topActivityClassName;
    }

    public final List<WindowStateInfo> component5() {
        return this.allWindows;
    }

    /* renamed from: component6, reason: from getter */
    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final DisplaySnapshot copy(int displayId, boolean isActive, String topPackageName, String topActivityClassName, List<? extends WindowStateInfo> allWindows, String screenshotPath) {
        k.f(allWindows, "allWindows");
        return new DisplaySnapshot(displayId, isActive, topPackageName, topActivityClassName, allWindows, screenshotPath);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplaySnapshot)) {
            return false;
        }
        DisplaySnapshot displaySnapshot = (DisplaySnapshot) other;
        return this.displayId == displaySnapshot.displayId && this.isActive == displaySnapshot.isActive && k.b(this.topPackageName, displaySnapshot.topPackageName) && k.b(this.topActivityClassName, displaySnapshot.topActivityClassName) && k.b(this.allWindows, displaySnapshot.allWindows) && k.b(this.screenshotPath, displaySnapshot.screenshotPath);
    }

    public final List<WindowStateInfo> getAllWindows() {
        return this.allWindows;
    }

    public final List<WindowStateInfo> getApplicationWindows() {
        List<WindowStateInfo> list = this.allWindows;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((WindowStateInfo) obj).getWindowType() == 2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final int getDisplayId() {
        return this.displayId;
    }

    public final String getForegroundActivityComponent() {
        if (!getHasForegroundActivity()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.topPackageName);
        sb.append(JsonPointer.SEPARATOR);
        String str = this.topActivityClassName;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public final boolean getHasForegroundActivity() {
        String str = this.topPackageName;
        return !(str == null || str.length() == 0);
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final String getTopActivityClassName() {
        return this.topActivityClassName;
    }

    public final String getTopPackageName() {
        return this.topPackageName;
    }

    public int hashCode() {
        int iD = a.d(Integer.hashCode(this.displayId) * 31, 31, this.isActive);
        String str = this.topPackageName;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.topActivityClassName;
        int iE = a.e(this.allWindows, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        String str3 = this.screenshotPath;
        return iE + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DisplaySnapshot(displayId=");
        sb.append(this.displayId);
        sb.append(", isActive=");
        sb.append(this.isActive);
        sb.append(", topPackageName=");
        sb.append(this.topPackageName);
        sb.append(", topActivityClassName=");
        sb.append(this.topActivityClassName);
        sb.append(", allWindows=");
        sb.append(this.allWindows);
        sb.append(", screenshotPath=");
        return B7.a.g(')', this.screenshotPath, sb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.displayId);
        dest.writeInt(this.isActive ? 1 : 0);
        dest.writeString(this.topPackageName);
        dest.writeString(this.topActivityClassName);
        List<WindowStateInfo> list = this.allWindows;
        dest.writeInt(list.size());
        Iterator<WindowStateInfo> it = list.iterator();
        while (it.hasNext()) {
            dest.writeParcelable(it.next(), flags);
        }
        dest.writeString(this.screenshotPath);
    }

    public DisplaySnapshot(int i, boolean z10, String str, String str2, List list, String str3, int i6, e eVar) {
        this(i, (i6 & 2) != 0 ? true : z10, (i6 & 4) != 0 ? null : str, (i6 & 8) != 0 ? null : str2, (i6 & 16) != 0 ? EmptyList.f4893a : list, (i6 & 32) != 0 ? null : str3);
    }
}
