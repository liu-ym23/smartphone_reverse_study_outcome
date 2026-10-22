package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NotesCreateParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesCreateParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<NotesCreateParams> CREATOR = null;
    private String content;
    private String title;

    /* JADX INFO: compiled from: NotesCreateParams.kt */
    public static final class Creator implements Parcelable.Creator<NotesCreateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotesCreateParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            NotesCreateParams r1 = new NotesCreateParams(r5.readString(), r5.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesCreateParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotesCreateParams[] newArray(int r1) {
            return new NotesCreateParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesCreateParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotesCreateParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NotesCreateParams copy$default(NotesCreateParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final NotesCreateParams copy(String r1, String r2) {
        return new NotesCreateParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NotesCreateParams.class) == true) goto L8;
        return false;
    L8:
        NotesCreateParams r6 = (NotesCreateParams) ZeusTransformUtils.preCheckCast(r5, NotesCreateParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NotesCreateParams(title=" + this.title + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.title);
        r1.writeString(this.content);
    }

    public NotesCreateParams(String r1, String r2) {
        this.title = r1;
        this.content = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ NotesCreateParams(String r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, NotesCreateParams.class) == false) goto L5;
        String r1 = this.title;
        if (r1 != null) goto L9;
        r1 = ((NotesCreateParams) ZeusTransformUtils.preCheckCast(r4, NotesCreateParams.class, "com.obric.aiagent.plugin")).title;
    L9:
        String r3 = this.content;
        if (r3 != null) goto L13;
        r3 = ((NotesCreateParams) ZeusTransformUtils.preCheckCast(r4, NotesCreateParams.class, "com.obric.aiagent.plugin")).content;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new NotesCreateParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.title;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        StringBuilder r4 = r0.append(r3).append('|');
        String r5 = this.content;
        if (r5 == null) goto L10;
        r2 = r5.toString();
    L10:
        return r4.append(r2).toString();
    L5:
        r3 = null;
        goto L6
    }
}
