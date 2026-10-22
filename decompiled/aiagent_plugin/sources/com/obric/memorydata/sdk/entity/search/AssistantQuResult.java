package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AssistantQuResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<QuAction> actions;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<AssistantQuResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AssistantQuResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AssistantQuResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssistantQuResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new AssistantQuResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssistantQuResult[] newArray(int r1) {
            return new AssistantQuResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ AssistantQuResult copy$default(AssistantQuResult r1, List r2, int r3, Object r4) {
        List<QuAction> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.actions;
    L6:
        return r1.copy(r5);
    }

    public final List<QuAction> component1() {
        return this.actions;
    }

    public final AssistantQuResult copy(List<QuAction> r2) {
        return new AssistantQuResult((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AssistantQuResult.class) == true) goto L8;
        return false;
    L8:
        AssistantQuResult r6 = (AssistantQuResult) ZeusTransformUtils.preCheckCast(r5, AssistantQuResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.actions, r6.actions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<QuAction> r0 = this.actions;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "AssistantQuResult(actions=" + this.actions + ')';
    }

    public AssistantQuResult(List<QuAction> r3) {
        this.actions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final List<QuAction> getActions() {
        return this.actions;
    }

    public AssistantQuResult(Parcel r4) {
        o.e(r4, "parcel");
        this((List) ZeusTransformUtils.preCheckCast(r4.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(QuAction.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeTypedList(this.actions);
    }
}
