package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: NotesUpdateParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesUpdateParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<NotesUpdateParams> CREATOR = null;
    private NoteContent content;
    private NoteEntity target;
    private String title;

    /* JADX INFO: compiled from: NotesUpdateParams.kt */
    public static final class Creator implements Parcelable.Creator<NotesUpdateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotesUpdateParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            o.e(r8, "parcel");
            NoteEntity r2 = (NoteEntity) ZeusTransformUtils.preCheckCast(r8.readParcelable(NotesUpdateParams.class.getClassLoader()), NoteEntity.class, "com.obric.aiagent.plugin");
            String r3 = r8.readString();
            if (r8.readInt() != 0) goto L5;
            NoteContent r5 = null;
        L6:
            NotesUpdateParams r1 = new NotesUpdateParams(r2, r3, (NoteContent) ZeusTransformUtils.preCheckCast(r5, NoteContent.class, "com.obric.aiagent.plugin"));
            int r4 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r6 = 1;
        L7:
            if (r6 > r4) goto L9;
            r6 = r6 + 1;
        L9:
            if (r6 > r0) goto L11;
            a.a(r8, r7);
            r6 = r6 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r5 = NoteContent.CREATOR.createFromParcel(r8);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesUpdateParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotesUpdateParams[] newArray(int r1) {
            return new NotesUpdateParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesUpdateParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public NotesUpdateParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NotesUpdateParams copy$default(NotesUpdateParams r0, NoteEntity r1, String r2, NoteContent r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.content;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final NoteEntity component1() {
        return this.target;
    }

    public final String component2() {
        return this.title;
    }

    public final NoteContent component3() {
        return this.content;
    }

    public final NotesUpdateParams copy(NoteEntity r1, String r2, NoteContent r3) {
        return new NotesUpdateParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NotesUpdateParams.class) == true) goto L8;
        return false;
    L8:
        NotesUpdateParams r6 = (NotesUpdateParams) ZeusTransformUtils.preCheckCast(r5, NotesUpdateParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (o.a(this.content, r6.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        NoteEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        NoteContent r7 = this.content;
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
        return "NotesUpdateParams(target=" + this.target + ", title=" + this.title + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.target, Parcelable.class, "com.obric.aiagent.plugin"), r6);
        r5.writeString(this.title);
        NoteContent r4 = this.content;
        if (r4 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        r4.writeToParcel(r5, r6);
    }

    public NotesUpdateParams(NoteEntity r1, String r2, NoteContent r3) {
        this.target = r1;
        this.title = r2;
        this.content = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ NotesUpdateParams(NoteEntity r2, String r3, NoteContent r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final NoteEntity getTarget() {
        return this.target;
    }

    public final void setTarget(NoteEntity r1) {
        this.target = r1;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final NoteContent getContent() {
        return this.content;
    }

    public final void setContent(NoteContent r1) {
        this.content = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, NotesUpdateParams.class) == false) goto L5;
        NoteEntity r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((NotesUpdateParams) ZeusTransformUtils.preCheckCast(r5, NotesUpdateParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        String r3 = this.title;
        if (r3 != null) goto L12;
        r3 = ((NotesUpdateParams) ZeusTransformUtils.preCheckCast(r5, NotesUpdateParams.class, "com.obric.aiagent.plugin")).title;
    L12:
        NoteContent r4 = this.content;
        if (r4 != null) goto L16;
        r4 = ((NotesUpdateParams) ZeusTransformUtils.preCheckCast(r5, NotesUpdateParams.class, "com.obric.aiagent.plugin")).content;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new NotesUpdateParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.b(new Object[]{this.target, this.content});
    }
}
