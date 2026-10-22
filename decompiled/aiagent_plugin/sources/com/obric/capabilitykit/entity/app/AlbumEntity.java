package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AlbumEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 1;
    private FileEntity cover;
    private int mediaCount;
    private String name;

    public static final class CREATOR implements Parcelable.Creator<AlbumEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlbumEntity");
            return (AlbumEntity) ZeusTransformUtils.preCheckCast(r1, AlbumEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlbumEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumEntity[] newArray(int r1) {
            return new AlbumEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlbumEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AlbumEntity(Parcel r10) {
        o.e(r10, "parcel");
        this(EntityExtKt.a(r10), r10.readLong(), r10.readLong(), EntityExtKt.a(r10), (FileEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(FileEntity.class.getClassLoader()), FileEntity.class, "com.obric.aiagent.plugin"));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 1, r10.readInt());
    }

    public AlbumEntity(String r9, long r10, long r12, String r14, FileEntity r15) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "name");
        super(r9, r10, r12, 302);
        this.name = r14;
        this.cover = r15;
    }

    public final FileEntity getCover() {
        return this.cover;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        FileEntity r0 = this.cover;
        if (r0 == null) goto L5;
        Uri r1 = r0.getContentUrl();
    L7:
        return new DisplayRepresentation(r1, this.name, String.valueOf(this.mediaCount), getLastModifiedTime());
    L5:
        r1 = null;
        goto L7
    }

    public final int getMediaCount() {
        return this.mediaCount;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = this.cover;
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return p.b();
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        Object r5 = r2.readValue(r3);
        o.a(r5, "null cannot be cast to non-null type kotlin.Int");
        this.mediaCount = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    }

    public final void setCover(FileEntity r1) {
        this.cover = r1;
    }

    public final void setMediaCount(int r1) {
        this.mediaCount = r1;
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.name);
        r2.writeParcelable(this.cover, r3);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(1);
        r2.writeValue(Integer.valueOf(this.mediaCount));
    }
}
