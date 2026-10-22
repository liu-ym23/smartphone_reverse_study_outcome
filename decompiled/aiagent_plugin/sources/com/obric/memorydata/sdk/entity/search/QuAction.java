package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class QuAction implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName(DbHelper.COL_ID)
    private final int actionId;
    private final String actionName;
    private final Map<String, ParamItem> inputParams;
    private int searchResultCount;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<QuAction> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ QuAction createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ QuAction[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuAction createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new QuAction(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuAction[] newArray(int r1) {
            return new QuAction[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ QuAction copy$default(QuAction r1, int r2, String r3, Map r4, int r5, int r6, Object r7) {
        Map<String, ParamItem> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.actionId;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.actionName;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.inputParams;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.searchResultCount;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final int component1() {
        return this.actionId;
    }

    public final String component2() {
        return this.actionName;
    }

    public final Map<String, ParamItem> component3() {
        return this.inputParams;
    }

    public final int component4() {
        return this.searchResultCount;
    }

    public final QuAction copy(int r2, String r3, Map<String, ParamItem> r4, int r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "actionName");
        return new QuAction(r2, r3, r1, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QuAction.class) == true) goto L8;
        return false;
    L8:
        QuAction r6 = (QuAction) ZeusTransformUtils.preCheckCast(r5, QuAction.class, "com.obric.aiagent.plugin");
        if (this.actionId == r6.actionId) goto L12;
        return false;
    L12:
        if (o.a(this.actionName, r6.actionName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.inputParams, r6.inputParams) == true) goto L18;
        return false;
    L18:
        if (this.searchResultCount == r6.searchResultCount) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.actionId) * 31) + this.actionName.hashCode()) * 31;
        Map<String, ParamItem> r1 = this.inputParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.searchResultCount);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "QuAction(actionId=" + this.actionId + ", actionName=" + this.actionName + ", inputParams=" + this.inputParams + ", searchResultCount=" + this.searchResultCount + ')';
    }

    public QuAction(int r3, String r4, Map<String, ParamItem> r5, int r6) {
        Map<String, ParamItem> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "actionName");
        this.actionId = r3;
        this.actionName = r4;
        this.inputParams = r7;
        this.searchResultCount = r6;
    }

    public /* synthetic */ QuAction(int r2, String r3, Map r4, int r5, int r6, h r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = 0;
    L5:
        this(r2, r3, r8, r5);
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final Map<String, ParamItem> getInputParams() {
        return this.inputParams;
    }

    public final int getSearchResultCount() {
        return this.searchResultCount;
    }

    public final void setSearchResultCount(int r1) {
        this.searchResultCount = r1;
    }

    public QuAction(Parcel r6) {
        o.e(r6, "parcel");
        int r0 = r6.readInt();
        String r1 = r6.readString();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this(r0, r1, (Map) ZeusTransformUtils.preCheckCast(r6.readHashMap(QuAction.class.getClassLoader()), Map.class, "com.obric.aiagent.plugin"), r6.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeInt(this.actionId);
        r1.writeString(this.actionName);
        r1.writeMap(this.inputParams);
        r1.writeInt(this.searchResultCount);
    }
}
