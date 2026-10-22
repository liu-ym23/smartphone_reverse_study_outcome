package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalAssistantSearchKgResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<String> kgRelation;

    /* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalAssistantSearchKgResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchKgResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchKgResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchKgResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalAssistantSearchKgResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchKgResult[] newArray(int r1) {
            return new GlobalAssistantSearchKgResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalAssistantSearchKgResult copy$default(GlobalAssistantSearchKgResult r1, List r2, int r3, Object r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.kgRelation;
    L6:
        return r1.copy(r5);
    }

    public final List<String> component1() {
        return this.kgRelation;
    }

    public final GlobalAssistantSearchKgResult copy(List<String> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "kgRelation");
        return new GlobalAssistantSearchKgResult(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantSearchKgResult.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchKgResult r6 = (GlobalAssistantSearchKgResult) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantSearchKgResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.kgRelation, r6.kgRelation) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.kgRelation.hashCode();
    }

    public String toString() {
        return "GlobalAssistantSearchKgResult(kgRelation=" + this.kgRelation + ')';
    }

    public GlobalAssistantSearchKgResult(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "kgRelation");
        this.kgRelation = r4;
    }

    public final List<String> getKgRelation() {
        return this.kgRelation;
    }

    public GlobalAssistantSearchKgResult(Parcel r3) {
        o.e(r3, "parcel");
        ArrayList<String> r4 = r3.createStringArrayList();
        if (r4 == null) goto L5;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L6:
        this(r5);
        return;
    L5:
        r5 = p.b();
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeStringList(this.kgRelation);
    }
}
