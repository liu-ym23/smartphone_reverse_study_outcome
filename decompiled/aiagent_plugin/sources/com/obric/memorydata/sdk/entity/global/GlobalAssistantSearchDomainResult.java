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
public final class GlobalAssistantSearchDomainResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<GlobalSearchDomain> domainList;

    /* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalAssistantSearchDomainResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchDomainResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchDomainResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchDomainResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalAssistantSearchDomainResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchDomainResult[] newArray(int r1) {
            return new GlobalAssistantSearchDomainResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GlobalAssistantSearchDomainResult(List<GlobalSearchDomain> r3) {
        List<GlobalSearchDomain> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "domainList");
        this.domainList = r4;
    }

    public final List<GlobalSearchDomain> getDomainList() {
        return this.domainList;
    }

    public GlobalAssistantSearchDomainResult(Parcel r4) {
        o.e(r4, "parcel");
        ArrayList r5 = r4.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(GlobalSearchDomain.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r5 == null) goto L5;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    L6:
        this(r6);
        return;
    L5:
        r6 = p.b();
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeTypedList(this.domainList);
    }
}
