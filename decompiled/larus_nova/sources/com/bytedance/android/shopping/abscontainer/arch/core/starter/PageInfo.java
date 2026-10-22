package com.bytedance.android.shopping.abscontainer.arch.core.starter;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/arch/core/starter/PageInfo;", "Landroid/os/Parcelable;", "bizCode", "", "sessionID", "schemaModel", "Lcom/bytedance/android/ec/model/abscontainer/ISchemaModel;", "inSplitScreen", "", "isSplitScreenOpened", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/abscontainer/ISchemaModel;ZZ)V", "getBizCode", "()Ljava/lang/String;", "getInSplitScreen", "()Z", "getSchemaModel", "()Lcom/bytedance/android/ec/model/abscontainer/ISchemaModel;", "getSessionID", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PageInfo implements Parcelable {
    public static final Parcelable.Creator<PageInfo> CREATOR = null;
    private final String bizCode;
    private final boolean inSplitScreen;
    private final boolean isSplitScreenOpened;
    private final ISchemaModel schemaModel;
    private final String sessionID;

    public static class a implements Parcelable.Creator<PageInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PageInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            String r101 = r100.readString();
            String r102 = r100.readString();
            ISchemaModel r103 = (ISchemaModel) r100.readParcelable(PageInfo.class.getClassLoader());
            boolean r104 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            if (r100.readInt() == 0) goto L10;
            r104 = true;
        L10:
            return new PageInfo(r101, r102, r103, r105, r104);
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PageInfo[] newArray(int r100) {
            return new PageInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.bizCode);
        r100.writeString(this.sessionID);
        r100.writeParcelable(this.schemaModel, r101);
        r100.writeInt(this.inSplitScreen ? 1 : 0);
        r100.writeInt(this.isSplitScreenOpened ? 1 : 0);
    }

    public String getBizCode() {
        return this.bizCode;
    }

    public boolean getInSplitScreen() {
        return this.inSplitScreen;
    }

    public ISchemaModel getSchemaModel() {
        return this.schemaModel;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public boolean isSplitScreenOpened() {
        return this.isSplitScreenOpened;
    }

    public PageInfo(String r100, String r101, ISchemaModel r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "sessionID");
        Intrinsics.checkNotNullParameter(r102, "schemaModel");
        this.bizCode = r100;
        this.sessionID = r101;
        this.schemaModel = r102;
        this.inSplitScreen = r103;
        this.isSplitScreenOpened = r104;
    }

    public /* synthetic */ PageInfo(String r100, String r101, ISchemaModel r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 16) == 0) goto L9;
        boolean r103 = false;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
