package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RewriteQuery implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String domain;
    private final String query;
    private final Set<String> subDomain;
    private final String type;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<RewriteQuery> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RewriteQuery createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RewriteQuery[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RewriteQuery createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new RewriteQuery(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RewriteQuery[] newArray(int r1) {
            return new RewriteQuery[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ RewriteQuery copy$default(RewriteQuery r1, String r2, String r3, String r4, Set r5, int r6, Object r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.domain;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.query;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.type;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.subDomain;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.type;
    }

    public final Set<String> component4() {
        return this.subDomain;
    }

    public final RewriteQuery copy(String r2, String r3, String r4, Set<String> r5) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        o.e(r2, "domain");
        o.e(r3, DownloadConstants.QUERY_KEY);
        return new RewriteQuery(r2, r3, r4, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RewriteQuery.class) == true) goto L8;
        return false;
    L8:
        RewriteQuery r6 = (RewriteQuery) ZeusTransformUtils.preCheckCast(r5, RewriteQuery.class, "com.obric.aiagent.plugin");
        if (o.a(this.domain, r6.domain) == true) goto L12;
        return false;
    L12:
        if (o.a(this.query, r6.query) == true) goto L15;
        return false;
    L15:
        if (o.a(this.type, r6.type) == true) goto L18;
        return false;
    L18:
        if (o.a(this.subDomain, r6.subDomain) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.domain.hashCode() * 31) + this.query.hashCode()) * 31;
        String r1 = this.type;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Set<String> r5 = this.subDomain;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RewriteQuery(domain=" + this.domain + ", query=" + this.query + ", type=" + this.type + ", subDomain=" + this.subDomain + ')';
    }

    public RewriteQuery(String r3, String r4, String r5, Set<String> r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
        o.e(r3, "domain");
        o.e(r4, DownloadConstants.QUERY_KEY);
        this.domain = r3;
        this.query = r4;
        this.type = r5;
        this.subDomain = r7;
    }

    public /* synthetic */ RewriteQuery(String r2, String r3, String r4, Set r5, int r6, h r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = null;
    L8:
        this(r2, r3, r4, r8);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getType() {
        return this.type;
    }

    public final Set<String> getSubDomain() {
        return this.subDomain;
    }

    public RewriteQuery(Parcel r4) {
        o.e(r4, "parcel");
        String r0 = r4.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r4.readString();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        String r3 = r4.readString();
        if (r3 != null) goto L12;
        r3 = DownloadSettingKeys.BugFix.DEFAULT;
    L12:
        String[] r5 = r4.createStringArray();
        if (r5 == null) goto L15;
        Set r6 = i.i(r5);
    L16:
        this(r0, r1, r3, r6);
        return;
    L15:
        r6 = null;
        goto L16
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        r2.writeString(this.domain);
        r2.writeString(this.query);
        r2.writeString(this.type);
        Set<String> r1 = this.subDomain;
        if (r1 == null) goto L5;
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
    L6:
        r2.writeStringArray(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
