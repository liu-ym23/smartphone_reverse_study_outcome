package com.obric.memorydata.sdk.assistant;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: QueryContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class QueryContext implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int DEFAULT_QUERY_TYPE = 0;
    private final int queryType;
    private final int windowState;

    /* JADX INFO: compiled from: QueryContext.kt */
    public static final class CREATOR implements Parcelable.Creator<QueryContext> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ QueryContext createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ QueryContext[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryContext createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            int r1 = r2.readInt();
            if (r2.dataAvail() <= 0) goto L5;
            int r3 = r2.readInt();
        L7:
            return new QueryContext(r1, r3);
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QueryContext[] newArray(int r1) {
            return new QueryContext[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ QueryContext copy$default(QueryContext r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.windowState;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.queryType;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.windowState;
    }

    public final int component2() {
        return this.queryType;
    }

    public final QueryContext copy(int r1, int r2) {
        return new QueryContext(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QueryContext.class) == true) goto L8;
        return false;
    L8:
        QueryContext r6 = (QueryContext) ZeusTransformUtils.preCheckCast(r5, QueryContext.class, "com.obric.aiagent.plugin");
        if (this.windowState == r6.windowState) goto L12;
        return false;
    L12:
        if (this.queryType == r6.queryType) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.windowState) * 31) + Integer.hashCode(this.queryType);
    }

    public String toString() {
        return "QueryContext(windowState=" + this.windowState + ", queryType=" + this.queryType + ')';
    }

    public QueryContext(int r1, int r2) {
        this.windowState = r1;
        this.queryType = r2;
    }

    public final int getWindowState() {
        return this.windowState;
    }

    public final int getQueryType() {
        return this.queryType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeInt(this.windowState);
        r1.writeInt(this.queryType);
    }
}
