package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BY\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jc\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\b\u0010-\u001a\u00020.H\u0016J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020.HÖ\u0001J\u0018\u00104\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u00020.H\u0002J\t\u00107\u001a\u00020\u000bHÖ\u0001J\u0018\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020.H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001c¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/entity/app/VideoFrame;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "startTime", "", "endTime", "frameTime", TracingConstants.KEY_TAGS, "", "", "faces", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "caption", "ocr", "(JJJLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "getEndTime", "()J", "setEndTime", "(J)V", "getFaces", "()Ljava/util/List;", "setFaces", "(Ljava/util/List;)V", "getFrameTime", "setFrameTime", "getOcr", "setOcr", "getStartTime", "setStartTime", "getTags", "setTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "readExtensionField", "", "theirVersion", "toString", "writeToParcel", "dest", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VideoFrame implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String caption;
    private long endTime;

    @Nullable
    private List<PhotoFaceEntity> faces;
    private long frameTime;

    @Nullable
    private String ocr;
    private long startTime;

    @Nullable
    private List<String> tags;

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/app/VideoFrame$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/VideoFrame;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<VideoFrame> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VideoFrame createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new VideoFrame(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VideoFrame[] newArray(int r10) {
            return new VideoFrame[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VideoFrame createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VideoFrame[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public VideoFrame(long r10, long r11, long r12, @Nullable List<String> r13, @Nullable List<PhotoFaceEntity> r14, @Nullable String r15, @Nullable String r16) {
        this.startTime = r10;
        this.endTime = r11;
        this.frameTime = r12;
        this.tags = r13;
        this.faces = r14;
        this.caption = r15;
        this.ocr = r16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoFrame copy$default(VideoFrame r11, long r12, long r14, long r16, List r18, List r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r10 = r11.startTime;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r13 = r11.endTime;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r15 = r11.frameTime;
    L15:
        if ((r22 & 8) == 0) goto L17;
        List r17 = r11.tags;
    L19:
        if ((r22 & 16) == 0) goto L21;
        List r24 = r11.faces;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r25 = r11.caption;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r110 = r11.ocr;
    L31:
        return r11.copy(r10, r13, r15, r17, r24, r25, r110);
    L29:
        r110 = r21;
        goto L31
    L25:
        r25 = r20;
        goto L27
    L21:
        r24 = r19;
        goto L23
    L17:
        r17 = r18;
        goto L19
    L13:
        r15 = r16;
        goto L15
    L9:
        r13 = r14;
        goto L11
    L5:
        r10 = r12;
        goto L7
    }

    private final void readExtensionField(Parcel r10, int r11) {
        if (r11 <= 0) goto L4;
        int r12 = 0;
    L5:
        ClassLoader r13 = AppEntity.class.getClassLoader();
        int r14 = 1;
    L6:
        if (r14 > r12) goto L8;
        r14 = r14 + 1;
    L8:
        if (r14 > r11) goto L10;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r13);
        r14 = r14 + 1;
        goto L8
    L10:
        return;
    L4:
        r12 = r11;
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

    @Nullable
    public final List<String> component4() {
        return this.tags;
    }

    @Nullable
    public final List<PhotoFaceEntity> component5() {
        return this.faces;
    }

    @Nullable
    public final String component6() {
        return this.caption;
    }

    @Nullable
    public final String component7() {
        return this.ocr;
    }

    @NotNull
    public final VideoFrame copy(long r13, long r15, long r17, @Nullable List<String> r19, @Nullable List<PhotoFaceEntity> r20, @Nullable String r21, @Nullable String r22) {
        return new VideoFrame(r13, r15, r17, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof VideoFrame) == true) goto L8;
        return false;
    L8:
        VideoFrame r11 = (VideoFrame) r10;
        if (this.startTime == r11.startTime) goto L12;
        return false;
    L12:
        if (this.endTime == r11.endTime) goto L15;
        return false;
    L15:
        if (this.frameTime == r11.frameTime) goto L18;
        return false;
    L18:
        if (q.b(this.tags, r11.tags) == true) goto L21;
        return false;
    L21:
        if (q.b(this.faces, r11.faces) == true) goto L24;
        return false;
    L24:
        if (q.b(this.caption, r11.caption) == true) goto L27;
        return false;
    L27:
        if (q.b(this.ocr, r11.ocr) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Nullable
    public final String getCaption() {
        return this.caption;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final List<PhotoFaceEntity> getFaces() {
        return this.faces;
    }

    public final long getFrameTime() {
        return this.frameTime;
    }

    @Nullable
    public final String getOcr() {
        return this.ocr;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int r10 = ((((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.endTime)) * 31) + Long.hashCode(this.frameTime)) * 31;
        List<String> r11 = this.tags;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        List<PhotoFaceEntity> r15 = this.faces;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.caption;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        String r21 = this.ocr;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        return r20 + r12;
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setCaption(@Nullable String r10) {
        this.caption = r10;
    }

    public final void setEndTime(long r10) {
        this.endTime = r10;
    }

    public final void setFaces(@Nullable List<PhotoFaceEntity> r10) {
        this.faces = r10;
    }

    public final void setFrameTime(long r10) {
        this.frameTime = r10;
    }

    public final void setOcr(@Nullable String r10) {
        this.ocr = r10;
    }

    public final void setStartTime(long r10) {
        this.startTime = r10;
    }

    public final void setTags(@Nullable List<String> r10) {
        this.tags = r10;
    }

    @NotNull
    public String toString() {
        return "VideoFrame(startTime=" + this.startTime + ", endTime=" + this.endTime + ", frameTime=" + this.frameTime + ", tags=" + this.tags + ", faces=" + this.faces + ", caption=" + this.caption + ", ocr=" + this.ocr + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "dest");
        r10.writeLong(this.startTime);
        r10.writeLong(this.endTime);
        r10.writeLong(this.frameTime);
        r10.writeStringList(this.tags);
        r10.writeTypedList(this.faces);
        r10.writeString(this.caption);
        r10.writeString(this.ocr);
        r10.writeInt(0);
    }

    public /* synthetic */ VideoFrame(long r14, long r16, long r18, List r20, List r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 8) == 0) goto L5;
        List r10 = null;
    L7:
        if ((r24 & 16) == 0) goto L9;
        List r11 = null;
    L11:
        if ((r24 & 32) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r24 & 64) == 0) goto L17;
        String r13 = null;
    L18:
        this(r14, r16, r18, r10, r11, r12, r13);
        return;
    L17:
        r13 = r23;
        goto L18
    L13:
        r12 = r22;
        goto L15
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public VideoFrame(@NotNull Parcel r13) {
        q.g(r13, "parcel");
        this(r13.readLong(), r13.readLong(), r13.readLong(), r13.createStringArrayList(), r13.createTypedArrayList(PhotoFaceEntity.CREATOR), r13.readString(), r13.readString());
        readExtensionField(r13, r13.readInt());
    }
}
