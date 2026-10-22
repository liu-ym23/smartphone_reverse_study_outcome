package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class NoteEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 5;
    private List<FileEntity> files;
    private FormatModeEnum formatMode;
    private boolean isFavorite;
    private String noteFolder;
    private List<RecordingEntity> recordings;
    private String text;
    private String title;

    public static final class CREATOR implements Parcelable.Creator<NoteEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.NoteEntity");
            return (NoteEntity) ZeusTransformUtils.preCheckCast(r1, NoteEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteEntity[] newArray(int r1) {
            return new NoteEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public NoteEntity(Parcel r13) {
        o.e(r13, "parcel");
        this(EntityExtKt.a(r13), r13.readLong(), r13.readLong(), EntityExtKt.a(r13), EntityExtKt.a(r13), FormatModeEnum.Companion.a(r13.readString()), r13.readString(), EntityExtKt.b(r13));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        int r0 = r13.readInt();
        this.files = r13.createTypedArrayList(FileEntity.CREATOR);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 1, r0);
    }

    public NoteEntity(String r11, long r12, long r14, String r16, String r17, FormatModeEnum r18, String r19, boolean r20) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r16, DBDefinition.TITLE);
        o.e(r17, "text");
        super(r11, r12, r14, EntityType.NOTE);
        this.title = r16;
        this.text = r17;
        this.formatMode = r18;
        this.noteFolder = r19;
        this.isFavorite = r20;
    }

    public /* synthetic */ NoteEntity(String r15, long r16, long r18, String r20, String r21, FormatModeEnum r22, String r23, boolean r24, int r25, h r26) {
        if ((r25 & 32) == 0) goto L5;
        FormatModeEnum r11 = null;
    L7:
        if ((r25 & 64) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r25 & 128) == 0) goto L13;
        boolean r13 = false;
    L14:
        this(r15, r16, r18, r20, r21, r11, r12, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r12 = r23;
        goto L11
    L5:
        r11 = r22;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(null, this.title, null, getLastModifiedTime(), 5, null);
    }

    public final List<FileEntity> getFiles() {
        return this.files;
    }

    public final FormatModeEnum getFormatMode() {
        return this.formatMode;
    }

    public final String getNoteFolder() {
        return this.noteFolder;
    }

    public final List<RecordingEntity> getRecordings() {
        return this.recordings;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        List<FileEntity> r4 = this.files;
        if (r4 == null) goto L9;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        p.a(r0, ((FileEntity) ZeusTransformUtils.preCheckCast(r5.next(), FileEntity.class, "com.obric.aiagent.plugin")).getSharedUris());
        goto L6
    L11:
        return r0;
    L9:
        return p.b();
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.recordings = (List) ZeusTransformUtils.preCheckCast(r2.readValue(r3), List.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setFavorite(boolean r1) {
        this.isFavorite = r1;
    }

    public final void setFiles(List<FileEntity> r3) {
        this.files = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setFormatMode(FormatModeEnum r1) {
        this.formatMode = r1;
    }

    public final void setNoteFolder(String r1) {
        this.noteFolder = r1;
    }

    public final void setRecordings(List<RecordingEntity> r3) {
        this.recordings = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setText(String r2) {
        o.e(r2, "<set-?>");
        this.text = r2;
    }

    public final void setTitle(String r2) {
        o.e(r2, "<set-?>");
        this.title = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.title);
        r1.writeString(this.text);
        FormatModeEnum r3 = this.formatMode;
        if (r3 == null) goto L5;
        String r4 = r3.name();
    L6:
        r1.writeString(r4);
        r1.writeString(this.noteFolder);
        EntityExtKt.a(r1, this.isFavorite);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(1);
        r1.writeTypedList(this.files);
        r1.writeValue(this.recordings);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
