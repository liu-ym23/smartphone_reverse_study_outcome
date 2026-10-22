package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BY\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jc\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\b\u0010-\u001a\u00020.H\u0016J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020.HÖ\u0001J\u0018\u00104\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u00020.H\u0002J\t\u00107\u001a\u00020\u000bHÖ\u0001J\u0018\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020.H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001c¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/entity/app/VideoFrame;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "startTime", "", "endTime", "frameTime", TracingConstants.KEY_TAGS, "", "", "faces", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "caption", "ocr", "(JJJLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "getEndTime", "()J", "setEndTime", "(J)V", "getFaces", "()Ljava/util/List;", "setFaces", "(Ljava/util/List;)V", "getFrameTime", "setFrameTime", "getOcr", "setOcr", "getStartTime", "setStartTime", "getTags", "setTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "readExtensionField", "", "theirVersion", "toString", "writeToParcel", "dest", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VideoFrame implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String caption;
    private long endTime;
    private List<PhotoFaceEntity> faces;
    private long frameTime;
    private String ocr;
    private long startTime;
    private List<String> tags;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/app/VideoFrame$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/VideoFrame;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<VideoFrame> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoFrame createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new VideoFrame(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VideoFrame createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoFrame[] newArray(int r1) {
            return new VideoFrame[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VideoFrame[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public VideoFrame(long r1, long r3, long r5, List<String> r7, List<PhotoFaceEntity> r8, String r9, String r10) {
        this.startTime = r1;
        this.endTime = r3;
        this.frameTime = r5;
        this.tags = r7;
        this.faces = r8;
        this.caption = r9;
        this.ocr = r10;
    }

    public /* synthetic */ VideoFrame(long r14, long r16, long r18, List r20, List r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 8) == 0) goto L5;
        List r9 = null;
    L7:
        if ((r24 & 16) == 0) goto L9;
        List r10 = null;
    L11:
        if ((r24 & 32) == 0) goto L13;
        String r11 = null;
    L15:
        if ((r24 & 64) == 0) goto L17;
        String r12 = null;
    L18:
        this(r14, r16, r18, r9, r10, r11, r12);
        return;
    L17:
        r12 = r23;
        goto L18
    L13:
        r11 = r22;
        goto L15
    L9:
        r10 = r21;
        goto L11
    L5:
        r9 = r20;
        goto L7
    }

    public VideoFrame(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        this(r13.readLong(), r13.readLong(), r13.readLong(), r13.createStringArrayList(), r13.createTypedArrayList(PhotoFaceEntity.CREATOR), r13.readString(), r13.readString());
        readExtensionField(r13, r13.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoFrame copy$default(VideoFrame r11, long r12, long r14, long r16, List r18, List r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r1 = r11.startTime;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r3 = r11.endTime;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r5 = r11.frameTime;
    L15:
        if ((r22 & 8) == 0) goto L17;
        List r7 = r11.tags;
    L19:
        if ((r22 & 16) == 0) goto L21;
        List r8 = r11.faces;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r9 = r11.caption;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r10 = r11.ocr;
    L31:
        return r11.copy(r1, r3, r5, r7, r8, r9, r10);
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    private final void readExtensionField(Parcel r3, int r4) {
        if (r4 <= 0) goto L4;
        int r2 = 0;
    L5:
        ClassLoader r0 = AppEntity.class.getClassLoader();
        int r1 = 1;
    L6:
        if (r1 > r2) goto L8;
        r1 = r1 + 1;
    L8:
        if (r1 > r4) goto L10;
        ParcelUtils.INSTANCE.skipValueSafely(r3, r0);
        r1 = r1 + 1;
        goto L8
    L10:
        return;
    L4:
        r2 = r4;
        goto L5
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTime;
    }

    public final long component3() {
        return this.frameTime;
    }

    public final List<String> component4() {
        return this.tags;
    }

    public final List<PhotoFaceEntity> component5() {
        return this.faces;
    }

    public final String component6() {
        return this.caption;
    }

    public final String component7() {
        return this.ocr;
    }

    public final VideoFrame copy(long r13, long r15, long r17, List<String> r19, List<PhotoFaceEntity> r20, String r21, String r22) {
        return new VideoFrame(r13, r15, r17, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof VideoFrame) == true) goto L8;
        return false;
    L8:
        VideoFrame r9 = (VideoFrame) r8;
        if (this.startTime == r9.startTime) goto L12;
        return false;
    L12:
        if (this.endTime == r9.endTime) goto L15;
        return false;
    L15:
        if (this.frameTime == r9.frameTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tags, r9.tags) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.faces, r9.faces) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.caption, r9.caption) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ocr, r9.ocr) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final List<PhotoFaceEntity> getFaces() {
        return this.faces;
    }

    public final long getFrameTime() {
        return this.frameTime;
    }

    public final String getOcr() {
        return this.ocr;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.endTime)) * 31) + Long.hashCode(this.frameTime)) * 31;
        List<String> r1 = this.tags;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<PhotoFaceEntity> r5 = this.faces;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.caption;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.ocr;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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

    public final void setCaption(String r1) {
        this.caption = r1;
    }

    public final void setEndTime(long r1) {
        this.endTime = r1;
    }

    public final void setFaces(List<PhotoFaceEntity> r1) {
        this.faces = r1;
    }

    public final void setFrameTime(long r1) {
        this.frameTime = r1;
    }

    public final void setOcr(String r1) {
        this.ocr = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final void setTags(List<String> r1) {
        this.tags = r1;
    }

    public String toString() {
        return "VideoFrame(startTime=" + this.startTime + ", endTime=" + this.endTime + ", frameTime=" + this.frameTime + ", tags=" + this.tags + ", faces=" + this.faces + ", caption=" + this.caption + ", ocr=" + this.ocr + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.startTime);
        r3.writeLong(this.endTime);
        r3.writeLong(this.frameTime);
        r3.writeStringList(this.tags);
        r3.writeTypedList(this.faces);
        r3.writeString(this.caption);
        r3.writeString(this.ocr);
        r3.writeInt(0);
    }
}
