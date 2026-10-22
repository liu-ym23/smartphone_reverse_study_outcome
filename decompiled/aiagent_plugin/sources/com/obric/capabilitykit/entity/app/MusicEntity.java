package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MusicEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private List<Artist> artists;
    private Cover cover;
    private long duration;
    private String name;
    private Preview preview;

    public static final class CREATOR implements Parcelable.Creator<MusicEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MusicEntity");
            return (MusicEntity) ZeusTransformUtils.preCheckCast(r1, MusicEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MusicEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicEntity[] newArray(int r1) {
            return new MusicEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MusicEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    public static final class a extends p implements b<Artist, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32134a = null;

        static {
            f32134a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(Artist r1) {
            o.e(r1, "it");
            return r1.getName();
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(Artist r3) {
            return a((Artist) ZeusTransformUtils.preCheckCast(r3, Artist.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MusicEntity(Parcel r14) {
        o.e(r14, "parcel");
        this(EntityExtKt.a(r14), r14.readLong(), r14.readLong(), EntityExtKt.a(r14), r14.createTypedArrayList(Artist.CREATOR), (Cover) ZeusTransformUtils.preCheckCast(r14.readParcelable(Cover.class.getClassLoader()), Cover.class, "com.obric.aiagent.plugin"), (Preview) ZeusTransformUtils.preCheckCast(r14.readParcelable(Preview.class.getClassLoader()), Preview.class, "com.obric.aiagent.plugin"), r14.readLong());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 0, r14.readInt());
    }

    public MusicEntity(String r11, long r12, long r14, String r16, List<Artist> r17, Cover r18, Preview r19, long r20) {
        List<Artist> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        o.e(r11, DbHelper.COL_ID);
        o.e(r16, "name");
        super(r11, r12, r14, EntityType.MUSIC);
        this.name = r16;
        this.artists = r9;
        this.cover = r18;
        this.preview = r19;
        this.duration = r20;
    }

    public /* synthetic */ MusicEntity(String r17, long r18, long r20, String r22, List r23, Cover r24, Preview r25, long r26, int r28, h r29) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        if ((r28 & 16) == 0) goto L5;
        List r11 = null;
    L7:
        if ((r28 & 32) == 0) goto L9;
        Cover r12 = null;
    L11:
        if ((r28 & 64) == 0) goto L13;
        Preview r13 = null;
    L15:
        if ((r28 & 128) == 0) goto L17;
        long r14 = 0;
    L18:
        this(r17, r18, r20, r22, r11, r12, r13, r14);
        return;
    L17:
        r14 = r26;
        goto L18
    L13:
        r13 = r25;
        goto L15
    L9:
        r12 = r24;
        goto L11
    L5:
        r11 = r1;
        goto L7
    }

    public final List<Artist> getArtists() {
        return this.artists;
    }

    public final Cover getCover() {
        return this.cover;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<Artist> r0 = this.artists;
        if (r0 == null) goto L5;
        String r1 = d.a.p.a(r0, ", ", null, null, 0, null, a.f32134a, 30, null);
    L6:
        String r3 = this.name;
        return new DisplayRepresentation(null, r3, r1, getLastModifiedTime());
    L5:
        r1 = null;
        goto L6
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final Preview getPreview() {
        return this.preview;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setArtists(List<Artist> r3) {
        this.artists = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setCover(Cover r1) {
        this.cover = r1;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    public final void setPreview(Preview r1) {
        this.preview = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeString(this.name);
        r3.writeTypedList(this.artists);
        r3.writeParcelable(this.cover, r4);
        r3.writeParcelable(this.preview, r4);
        r3.writeLong(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeInt(0);
    }
}
