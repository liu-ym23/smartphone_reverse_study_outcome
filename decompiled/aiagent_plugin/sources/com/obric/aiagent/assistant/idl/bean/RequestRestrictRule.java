package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: RequestRestrictRule.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestRestrictRule implements Parcelable {
    public static final Parcelable.Creator<RequestRestrictRule> CREATOR = null;
    private final List<String> allowedHosts;
    private final List<String> allowedPaths;
    private final List<String> allowedUrlPrefixes;

    /* JADX INFO: compiled from: RequestRestrictRule.kt */
    public static final class Creator implements Parcelable.Creator<RequestRestrictRule> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RequestRestrictRule createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            return new RequestRestrictRule((List) ZeusTransformUtils.preCheckCast(r5.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r5.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r5.createStringArrayList(), List.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RequestRestrictRule createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RequestRestrictRule[] newArray(int r1) {
            return new RequestRestrictRule[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RequestRestrictRule[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public RequestRestrictRule() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RequestRestrictRule copy$default(RequestRestrictRule r1, List r2, List r3, List r4, int r5, Object r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.allowedHosts;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = r1.allowedPaths;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r9 = r1.allowedUrlPrefixes;
    L12:
        return r1.copy(r7, r8, r9);
    }

    public final List<String> component1() {
        return this.allowedHosts;
    }

    public final List<String> component2() {
        return this.allowedPaths;
    }

    public final List<String> component3() {
        return this.allowedUrlPrefixes;
    }

    public final RequestRestrictRule copy(List<String> r2, List<String> r3, List<String> r4) {
        return new RequestRestrictRule((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RequestRestrictRule.class) == true) goto L8;
        return false;
    L8:
        RequestRestrictRule r6 = (RequestRestrictRule) ZeusTransformUtils.preCheckCast(r5, RequestRestrictRule.class, "com.obric.aiagent.plugin");
        if (o.a(this.allowedHosts, r6.allowedHosts) == true) goto L12;
        return false;
    L12:
        if (o.a(this.allowedPaths, r6.allowedPaths) == true) goto L15;
        return false;
    L15:
        if (o.a(this.allowedUrlPrefixes, r6.allowedUrlPrefixes) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.allowedHosts;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.allowedPaths;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.allowedUrlPrefixes;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RequestRestrictRule(allowedHosts=" + this.allowedHosts + ", allowedPaths=" + this.allowedPaths + ", allowedUrlPrefixes=" + this.allowedUrlPrefixes + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeStringList(this.allowedHosts);
        r1.writeStringList(this.allowedPaths);
        r1.writeStringList(this.allowedUrlPrefixes);
    }

    public RequestRestrictRule(List<String> r3, List<String> r4, List<String> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.allowedHosts = r6;
        this.allowedPaths = r7;
        this.allowedUrlPrefixes = r8;
    }

    public /* synthetic */ RequestRestrictRule(List r2, List r3, List r4, int r5, h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = null;
    L11:
        this(r7, r8, r9);
    }

    public final List<String> getAllowedHosts() {
        return this.allowedHosts;
    }

    public final List<String> getAllowedPaths() {
        return this.allowedPaths;
    }

    public final List<String> getAllowedUrlPrefixes() {
        return this.allowedUrlPrefixes;
    }
}
