package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalQUResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String origin_query;
    private List<RewriteQuery> query_rewrite;
    private String slot_result;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalQUResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalQUResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalQUResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalQUResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalQUResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalQUResult[] newArray(int r1) {
            return new GlobalQUResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalQUResult copy$default(GlobalQUResult r1, String r2, List r3, String r4, int r5, Object r6) {
        List<RewriteQuery> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.origin_query;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.query_rewrite;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.slot_result;
    L12:
        return r1.copy(r2, r7, r4);
    }

    public final String component1() {
        return this.origin_query;
    }

    public final List<RewriteQuery> component2() {
        return this.query_rewrite;
    }

    public final String component3() {
        return this.slot_result;
    }

    public final GlobalQUResult copy(String r2, List<RewriteQuery> r3, String r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "origin_query");
        return new GlobalQUResult(r2, r1, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalQUResult.class) == true) goto L8;
        return false;
    L8:
        GlobalQUResult r6 = (GlobalQUResult) ZeusTransformUtils.preCheckCast(r5, GlobalQUResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.origin_query, r6.origin_query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.query_rewrite, r6.query_rewrite) == true) goto L15;
        return false;
    L15:
        if (o.a(this.slot_result, r6.slot_result) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.origin_query.hashCode() * 31;
        List<RewriteQuery> r1 = this.query_rewrite;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.slot_result;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "GlobalQUResult(origin_query=" + this.origin_query + ", query_rewrite=" + this.query_rewrite + ", slot_result=" + this.slot_result + ')';
    }

    public GlobalQUResult(String r3, List<RewriteQuery> r4, String r5) {
        List<RewriteQuery> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "origin_query");
        this.origin_query = r3;
        this.query_rewrite = r6;
        this.slot_result = r5;
    }

    public /* synthetic */ GlobalQUResult(String r2, List r3, String r4, int r5, h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        this(r2, r7, r4);
    }

    public final String getOrigin_query() {
        return this.origin_query;
    }

    public final List<RewriteQuery> getQuery_rewrite() {
        return this.query_rewrite;
    }

    public final void setQuery_rewrite(List<RewriteQuery> r3) {
        this.query_rewrite = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final String getSlot_result() {
        return this.slot_result;
    }

    public final void setSlot_result(String r1) {
        this.slot_result = r1;
    }

    public GlobalQUResult(Parcel r5) {
        o.e(r5, "parcel");
        String r0 = r5.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this(r0, (List) ZeusTransformUtils.preCheckCast(r5.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin"), r5.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.origin_query);
        r1.writeTypedList(this.query_rewrite);
        r1.writeString(this.slot_result);
    }
}
