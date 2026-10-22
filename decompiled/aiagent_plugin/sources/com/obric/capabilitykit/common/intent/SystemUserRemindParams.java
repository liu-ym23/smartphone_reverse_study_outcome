package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: SystemUserRemindParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemUserRemindParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemUserRemindParams> CREATOR = null;
    private String[] candidate;
    private String content;
    private Options[] options;
    private String title;

    /* JADX INFO: compiled from: SystemUserRemindParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemUserRemindParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserRemindParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            if (r9.readInt() != 0) goto L5;
            Options[] r1 = null;
        L9:
            SystemUserRemindParams r6 = new SystemUserRemindParams(r1, r9.readString(), r9.readString(), r9.createStringArray());
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r3 = 1;
        L10:
            if (r3 > r2) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 > r0) goto L14;
            a.a(r9, r8);
            r3 = r3 + 1;
            goto L12
        L14:
            return r6;
        L5:
            int r4 = r9.readInt();
            Options[] r5 = new Options[r4];
            int r7 = 0;
        L6:
            if (r7 == r4) goto L8;
            r5[r7] = (Options) ZeusTransformUtils.preCheckCast(Options.CREATOR.createFromParcel(r9), Options.class, "com.obric.aiagent.plugin");
            r7 = r7 + 1;
            goto L6
        L8:
            r1 = r5;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserRemindParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserRemindParams[] newArray(int r1) {
            return new SystemUserRemindParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserRemindParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public SystemUserRemindParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemUserRemindParams copy$default(SystemUserRemindParams r0, Options[] r1, String r2, String r3, String[] r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.options;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.title;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.candidate;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Options[] component1() {
        return this.options;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.title;
    }

    public final String[] component4() {
        return this.candidate;
    }

    public final SystemUserRemindParams copy(Options[] r1, String r2, String r3, String[] r4) {
        return new SystemUserRemindParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemUserRemindParams.class) == true) goto L8;
        return false;
    L8:
        SystemUserRemindParams r6 = (SystemUserRemindParams) ZeusTransformUtils.preCheckCast(r5, SystemUserRemindParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.options, r6.options) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (o.a(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (o.a(this.candidate, r6.candidate) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Options[] r0 = this.options;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String[] r10 = this.candidate;
        if (r10 == null) goto L19;
        r1 = Arrays.hashCode(r10);
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "SystemUserRemindParams(options=" + Arrays.toString(this.options) + ", content=" + this.content + ", title=" + this.title + ", candidate=" + Arrays.toString(this.candidate) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        o.e(r5, "out");
        Options[] r1 = this.options;
        if (r1 != null) goto L5;
        r5.writeInt(0);
    L8:
        r5.writeString(this.content);
        r5.writeString(this.title);
        r5.writeStringArray(this.candidate);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L8;
        r1[r0].writeToParcel(r5, r6);
        r0 = r0 + 1;
        goto L6
    }

    public SystemUserRemindParams(Options[] r1, String r2, String r3, String[] r4) {
        this.options = r1;
        this.content = r2;
        this.title = r3;
        this.candidate = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemUserRemindParams(Options[] r2, String r3, String r4, String[] r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final Options[] getOptions() {
        return this.options;
    }

    public final void setOptions(Options[] r1) {
        this.options = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final String[] getCandidate() {
        return this.candidate;
    }

    public final void setCandidate(String[] r1) {
        this.candidate = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, SystemUserRemindParams.class) == false) goto L5;
        Options[] r1 = this.options;
        if (r1 != null) goto L9;
        r1 = ((SystemUserRemindParams) ZeusTransformUtils.preCheckCast(r6, SystemUserRemindParams.class, "com.obric.aiagent.plugin")).options;
    L9:
        String r3 = this.content;
        if (r3 != null) goto L12;
        r3 = ((SystemUserRemindParams) ZeusTransformUtils.preCheckCast(r6, SystemUserRemindParams.class, "com.obric.aiagent.plugin")).content;
    L12:
        String r4 = this.title;
        if (r4 != null) goto L15;
        r4 = ((SystemUserRemindParams) ZeusTransformUtils.preCheckCast(r6, SystemUserRemindParams.class, "com.obric.aiagent.plugin")).title;
    L15:
        String[] r5 = this.candidate;
        if (r5 != null) goto L19;
        r5 = ((SystemUserRemindParams) ZeusTransformUtils.preCheckCast(r6, SystemUserRemindParams.class, "com.obric.aiagent.plugin")).candidate;
    L19:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemUserRemindParams(r1, r3, r4, r5), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
