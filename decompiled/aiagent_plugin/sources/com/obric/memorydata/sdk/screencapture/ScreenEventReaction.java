package com.obric.memorydata.sdk.screencapture;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.UUID;

/* JADX INFO: compiled from: ScreenEventReaction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenEventReaction implements Parcelable {
    public static final Parcelable.Creator<ScreenEventReaction> CREATOR = null;
    private final String id;
    private final ScreenEventRule rule;
    private transient String sourcePackage;
    private final TaskOptions taskOptions;

    /* JADX INFO: compiled from: ScreenEventReaction.kt */
    public static final class Creator implements Parcelable.Creator<ScreenEventReaction> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenEventReaction createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            return new ScreenEventReaction(r5.readString(), (ScreenEventRule) ZeusTransformUtils.preCheckCast(r5.readParcelable(ScreenEventReaction.class.getClassLoader()), ScreenEventRule.class, "com.obric.aiagent.plugin"), (TaskOptions) ZeusTransformUtils.preCheckCast(TaskOptions.CREATOR.createFromParcel(r5), TaskOptions.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenEventReaction createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenEventReaction[] newArray(int r1) {
            return new ScreenEventReaction[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenEventReaction[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ScreenEventReaction copy$default(ScreenEventReaction r0, String r1, ScreenEventRule r2, TaskOptions r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.rule;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.taskOptions;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getSourcePackage$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final ScreenEventRule component2() {
        return this.rule;
    }

    public final TaskOptions component3() {
        return this.taskOptions;
    }

    public final ScreenEventReaction copy(String r1, ScreenEventRule r2, TaskOptions r3) {
        o.e(r1, DbHelper.COL_ID);
        o.e(r2, "rule");
        o.e(r3, "taskOptions");
        return new ScreenEventReaction(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String toString() {
        return "ScreenEventReaction(id=" + this.id + ", rule=" + this.rule + ", taskOptions=" + this.taskOptions + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeString(this.id);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.rule, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        this.taskOptions.writeToParcel(r4, r5);
    }

    public ScreenEventReaction(String r2, ScreenEventRule r3, TaskOptions r4) {
        o.e(r2, DbHelper.COL_ID);
        o.e(r3, "rule");
        o.e(r4, "taskOptions");
        this.id = r2;
        this.rule = r3;
        this.taskOptions = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ScreenEventReaction(String r1, ScreenEventRule r2, TaskOptions r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = UUID.randomUUID().toString();
    L6:
        if ((r4 & 4) == 0) goto L8;
        ScreenshotOption r6 = null;
        Object[] r7 = 0 == true ? 1 : 0;
        r3 = new TaskOptions(r6, r7, 3, 0 == true ? 1 : 0);
    L8:
        this(r1, r2, r3);
    }

    public final String getId() {
        return this.id;
    }

    public final ScreenEventRule getRule() {
        return this.rule;
    }

    public final TaskOptions getTaskOptions() {
        return this.taskOptions;
    }

    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    public final void setSourcePackage(String r1) {
        this.sourcePackage = r1;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ScreenEventReaction.class) == true) goto L7;
        return false;
    L7:
        return o.a(this.id, ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r3, ScreenEventReaction.class, "com.obric.aiagent.plugin")).id);
    }
}
