package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalAssistantSearchResponse implements Parcelable {
    public static final CREATOR CREATOR = null;
    private int code;
    private GlobalAssistantSearchDomainResult domainResult;
    private GlobalAssistantSearchEntityResult entityResult;
    private String extra;
    private GlobalAssistantSearchKgResult kgResult;
    private GlobalAssistantSearchMemoryResult memoryResult;
    private String message;
    private ProactiveRecommendationSearchResult proactiveRecommendationResult;

    /* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalAssistantSearchResponse> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchResponse createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantSearchResponse[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchResponse createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalAssistantSearchResponse(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantSearchResponse[] newArray(int r1) {
            return new GlobalAssistantSearchResponse[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalAssistantSearchResponse copy$default(GlobalAssistantSearchResponse r9, int r10, String r11, GlobalAssistantSearchEntityResult r12, GlobalAssistantSearchKgResult r13, GlobalAssistantSearchDomainResult r14, GlobalAssistantSearchMemoryResult r15, ProactiveRecommendationSearchResult r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        int r2 = r9.code;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.message;
    L11:
        if ((r18 & 4) == 0) goto L13;
        GlobalAssistantSearchEntityResult r4 = r9.entityResult;
    L15:
        if ((r18 & 8) == 0) goto L17;
        GlobalAssistantSearchKgResult r5 = r9.kgResult;
    L19:
        if ((r18 & 16) == 0) goto L21;
        GlobalAssistantSearchDomainResult r6 = r9.domainResult;
    L23:
        if ((r18 & 32) == 0) goto L25;
        GlobalAssistantSearchMemoryResult r7 = r9.memoryResult;
    L27:
        if ((r18 & 64) == 0) goto L29;
        ProactiveRecommendationSearchResult r8 = r9.proactiveRecommendationResult;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.extra;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$7RyLgopz6mL-B9Nq-hXg6uDQqNU, reason: not valid java name */
    public static /* synthetic */ x m954lambda$7RyLgopz6mLB9NqhXg6uDQqNU(GlobalAssistantSearchResponse r0, String r1) {
        return removeExtra$lambda$2(r0, r1);
    }

    public static /* synthetic */ Object lambda$XNCUGIq8fA0Px1F4ktE6AGEk7r8(GlobalAssistantSearchResponse r0, String r1) {
        return getExtra$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ptuxcSz9dg-FGC8Y5JWVRHDGr3I, reason: not valid java name */
    public static /* synthetic */ JSONObject m955lambda$ptuxcSz9dgFGC8Y5JWVRHDGr3I(GlobalAssistantSearchResponse r0) {
        return addExtra$lambda$0(r0);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final GlobalAssistantSearchEntityResult component3() {
        return this.entityResult;
    }

    public final GlobalAssistantSearchKgResult component4() {
        return this.kgResult;
    }

    public final GlobalAssistantSearchDomainResult component5() {
        return this.domainResult;
    }

    public final GlobalAssistantSearchMemoryResult component6() {
        return this.memoryResult;
    }

    public final ProactiveRecommendationSearchResult component7() {
        return this.proactiveRecommendationResult;
    }

    public final String component8() {
        return this.extra;
    }

    public final GlobalAssistantSearchResponse copy(int r11, String r12, GlobalAssistantSearchEntityResult r13, GlobalAssistantSearchKgResult r14, GlobalAssistantSearchDomainResult r15, GlobalAssistantSearchMemoryResult r16, ProactiveRecommendationSearchResult r17, String r18) {
        o.e(r12, "message");
        return new GlobalAssistantSearchResponse(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantSearchResponse.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantSearchResponse r6 = (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantSearchResponse.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (o.a(this.entityResult, r6.entityResult) == true) goto L18;
        return false;
    L18:
        if (o.a(this.kgResult, r6.kgResult) == true) goto L21;
        return false;
    L21:
        if (o.a(this.domainResult, r6.domainResult) == true) goto L24;
        return false;
    L24:
        if (o.a(this.memoryResult, r6.memoryResult) == true) goto L27;
        return false;
    L27:
        if (o.a(this.proactiveRecommendationResult, r6.proactiveRecommendationResult) == true) goto L30;
        return false;
    L30:
        if (o.a(this.extra, r6.extra) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        GlobalAssistantSearchEntityResult r1 = this.entityResult;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        GlobalAssistantSearchKgResult r5 = this.kgResult;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        GlobalAssistantSearchDomainResult r8 = this.domainResult;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        GlobalAssistantSearchMemoryResult r11 = this.memoryResult;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ProactiveRecommendationSearchResult r14 = this.proactiveRecommendationResult;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.extra;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "GlobalAssistantSearchResponse(code=" + this.code + ", message=" + this.message + ", entityResult=" + this.entityResult + ", kgResult=" + this.kgResult + ", domainResult=" + this.domainResult + ", memoryResult=" + this.memoryResult + ", proactiveRecommendationResult=" + this.proactiveRecommendationResult + ", extra=" + this.extra + ')';
    }

    public GlobalAssistantSearchResponse(int r2, String r3, GlobalAssistantSearchEntityResult r4, GlobalAssistantSearchKgResult r5, GlobalAssistantSearchDomainResult r6, GlobalAssistantSearchMemoryResult r7, ProactiveRecommendationSearchResult r8, String r9) {
        o.e(r3, "message");
        this.code = r2;
        this.message = r3;
        this.entityResult = r4;
        this.kgResult = r5;
        this.domainResult = r6;
        this.memoryResult = r7;
        this.proactiveRecommendationResult = r8;
        this.extra = r9;
    }

    public /* synthetic */ GlobalAssistantSearchResponse(int r13, String r14, GlobalAssistantSearchEntityResult r15, GlobalAssistantSearchKgResult r16, GlobalAssistantSearchDomainResult r17, GlobalAssistantSearchMemoryResult r18, ProactiveRecommendationSearchResult r19, String r20, int r21, h r22) {
        if ((r21 & 4) == 0) goto L5;
        GlobalAssistantSearchEntityResult r6 = null;
    L7:
        if ((r21 & 8) == 0) goto L9;
        GlobalAssistantSearchKgResult r7 = null;
    L11:
        if ((r21 & 16) == 0) goto L13;
        GlobalAssistantSearchDomainResult r8 = null;
    L15:
        if ((r21 & 32) == 0) goto L17;
        GlobalAssistantSearchMemoryResult r9 = null;
    L19:
        if ((r21 & 64) == 0) goto L21;
        ProactiveRecommendationSearchResult r10 = null;
    L23:
        if ((r21 & 128) == 0) goto L25;
        String r11 = null;
    L26:
        this(r13, r14, r6, r7, r8, r9, r10, r11);
        return;
    L25:
        r11 = r20;
        goto L26
    L21:
        r10 = r19;
        goto L23
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String r2) {
        o.e(r2, "<set-?>");
        this.message = r2;
    }

    public final GlobalAssistantSearchEntityResult getEntityResult() {
        return this.entityResult;
    }

    public final void setEntityResult(GlobalAssistantSearchEntityResult r1) {
        this.entityResult = r1;
    }

    public final GlobalAssistantSearchKgResult getKgResult() {
        return this.kgResult;
    }

    public final void setKgResult(GlobalAssistantSearchKgResult r1) {
        this.kgResult = r1;
    }

    public final GlobalAssistantSearchDomainResult getDomainResult() {
        return this.domainResult;
    }

    public final void setDomainResult(GlobalAssistantSearchDomainResult r1) {
        this.domainResult = r1;
    }

    public final GlobalAssistantSearchMemoryResult getMemoryResult() {
        return this.memoryResult;
    }

    public final void setMemoryResult(GlobalAssistantSearchMemoryResult r1) {
        this.memoryResult = r1;
    }

    public final ProactiveRecommendationSearchResult getProactiveRecommendationResult() {
        return this.proactiveRecommendationResult;
    }

    public final void setProactiveRecommendationResult(ProactiveRecommendationSearchResult r1) {
        this.proactiveRecommendationResult = r1;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String r1) {
        this.extra = r1;
    }

    public GlobalAssistantSearchResponse(Parcel r11) {
        o.e(r11, "parcel");
        int r2 = r11.readInt();
        String r0 = r11.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this(r2, r0, (GlobalAssistantSearchEntityResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchEntityResult.class.getClassLoader()), GlobalAssistantSearchEntityResult.class, "com.obric.aiagent.plugin"), (GlobalAssistantSearchKgResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchKgResult.class.getClassLoader()), GlobalAssistantSearchKgResult.class, "com.obric.aiagent.plugin"), (GlobalAssistantSearchDomainResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchDomainResult.class.getClassLoader()), GlobalAssistantSearchDomainResult.class, "com.obric.aiagent.plugin"), (GlobalAssistantSearchMemoryResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(GlobalAssistantSearchMemoryResult.class.getClassLoader()), GlobalAssistantSearchMemoryResult.class, "com.obric.aiagent.plugin"), (ProactiveRecommendationSearchResult) ZeusTransformUtils.preCheckCast(r11.readParcelable(ProactiveRecommendationSearchResult.class.getClassLoader()), ProactiveRecommendationSearchResult.class, "com.obric.aiagent.plugin"), r11.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "parcel");
        r4.writeInt(this.code);
        r4.writeString(this.message);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.entityResult, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.kgResult, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.domainResult, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.memoryResult, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.proactiveRecommendationResult, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeString(this.extra);
    }

    public final void addExtra(String r4, Object r5) {
        o.e(r4, "key");
        o.e(r5, "value");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.extra, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        JSONObject r2 = new JSONObject();
    L14:
        r2.put(r4, r5);
        this.extra = r2.toString();
        return;
    L11:
        r2 = (JSONObject) ZeusTransformUtils.preCheckCast(c.a(new $$Lambda$GlobalAssistantSearchResponse$ptuxcSz9dgFGC8Y5JWVRHDGr3I(this)), JSONObject.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L14;
        r2 = new JSONObject();
        goto L14
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final JSONObject addExtra$lambda$0(GlobalAssistantSearchResponse r1) {
        return new JSONObject(r1.extra);
    }

    public final Object getExtra(final String r4) {
        o.e(r4, "key");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.extra, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        return c.a(new $$Lambda$GlobalAssistantSearchResponse$XNCUGIq8fA0Px1F4ktE6AGEk7r8(this, r4));
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final Object getExtra$lambda$1(GlobalAssistantSearchResponse r1, String r2) {
        return new JSONObject(r1.extra).opt(r2);
    }

    public final void removeExtra(final String r4) {
        o.e(r4, "key");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.extra, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        c.a(new $$Lambda$GlobalAssistantSearchResponse$7RyLgopz6mLB9NqhXg6uDQqNU(this, r4));
        return;
    L12:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final x removeExtra$lambda$2(GlobalAssistantSearchResponse r2, String r3) {
        JSONObject r0 = new JSONObject(r2.extra);
        r0.remove(r3);
        r2.extra = r0.toString();
        return x.f38692a;
    }
}
