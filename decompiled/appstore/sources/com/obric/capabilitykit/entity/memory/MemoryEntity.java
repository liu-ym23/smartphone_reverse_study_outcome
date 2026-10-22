package com.obric.capabilitykit.entity.memory;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b'\u0018\u0000 L2\u00020\u0001:\u0001LB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010>\u001a\u00020?H&J\u0018\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0006H\u0004J\u0015\u0010C\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bGJ\u001d\u0010H\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u000bH\u0000¢\u0006\u0002\bJJ\u0018\u0010K\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u000bH\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\u001c\u0010)\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012R\u001c\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u001c\u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0010\"\u0004\b4\u0010\u0012R\u001c\u00105\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0010\"\u0004\b7\u0010\u0012R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006M"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "type", "", "productType", "(Ljava/lang/String;JJII)V", "detail", "getDetail", "()Ljava/lang/String;", "setDetail", "(Ljava/lang/String;)V", "detailStatus", "getDetailStatus", "()I", "setDetailStatus", "(I)V", "evidenceCount", "getEvidenceCount", "setEvidenceCount", "logId", "getLogId", "setLogId", "getProductType", "setProductType", "screenshot", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getScreenshot", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setScreenshot", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceLink", "getSourceLink", "setSourceLink", "sourceLinkType", "getSourceLinkType", "setSourceLinkType", "sourcePackageName", "getSourcePackageName", "setSourcePackageName", "sourceQuery", "getSourceQuery", "setSourceQuery", "sourceText", "getSourceText", "setSourceText", "userEdit", "", "getUserEdit", "()Z", "setUserEdit", "(Z)V", "convertToModelInput", "Lorg/json/JSONObject;", "makeModelInputValue", "desc", CommonKey.KEY_VALUE, "readMemoryExtensionFieldFromParcel", "", "readMemoryExtensionFieldFromParcel$capabilitykitcommon_release", "writeMemoryBaseFieldToParcel", "writeMemoryBaseFieldToParcel$capabilitykitcommon_release", "writeMemoryExtensionFieldToParcel", "flags", "writeMemoryExtensionFieldToParcel$capabilitykitcommon_release", "writeToParcel", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class MemoryEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 9;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String detail;
    private int detailStatus;
    private int evidenceCount;

    @Nullable
    private String logId;
    private int productType;

    @Nullable
    private FileEntity screenshot;

    @Nullable
    private String sourceAppName;

    @Nullable
    private String sourceLink;

    @Nullable
    private String sourceLinkType;

    @Nullable
    private String sourcePackageName;

    @Nullable
    private String sourceQuery;

    @Nullable
    private String sourceText;
    private boolean userEdit;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.MemoryEntity");
            return (MemoryEntity) r11;
        }

        public final int getVersion() {
            return 9;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MemoryEntity[] newArray(int r10) {
            return new MemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MemoryEntity(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10), r10.readLong(), r10.readLong(), r10.readInt(), r10.readInt());
        throw new UnsupportedOperationException("Don't construct MemoryEntity Directly, use subclass instead");
    }

    @NotNull
    public abstract JSONObject convertToModelInput();

    @Nullable
    public final String getDetail() {
        return this.detail;
    }

    public final int getDetailStatus() {
        return this.detailStatus;
    }

    public final int getEvidenceCount() {
        return this.evidenceCount;
    }

    @Nullable
    public final String getLogId() {
        return this.logId;
    }

    public final int getProductType() {
        return this.productType;
    }

    @Nullable
    public final FileEntity getScreenshot() {
        return this.screenshot;
    }

    @Nullable
    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    @Nullable
    public final String getSourceLink() {
        return this.sourceLink;
    }

    @Nullable
    public final String getSourceLinkType() {
        return this.sourceLinkType;
    }

    @Nullable
    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    @Nullable
    public final String getSourceQuery() {
        return this.sourceQuery;
    }

    @Nullable
    public final String getSourceText() {
        return this.sourceText;
    }

    public final boolean getUserEdit() {
        return this.userEdit;
    }

    @NotNull
    public final JSONObject makeModelInputValue(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "desc");
        q.g(r11, CommonKey.KEY_VALUE);
        JSONObject r12 = new JSONObject();
        r12.put("desc", r10);
        r12.put(CommonKey.KEY_VALUE, r11);
        return r12;
    }

    public final void readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r11 = r10.readInt();
        this.sourceLinkType = r10.readString();
        this.sourceLink = r10.readString();
        this.screenshot = (FileEntity) r10.readParcelable(FileEntity.class.getClassLoader());
        int r12 = 9;
        if (r11 > 9) goto L6;
        r12 = r11;
    L6:
        ClassLoader r13 = MemoryEntity.class.getClassLoader();
        int r14 = 1;
    L7:
        if (r14 > r12) goto L39;
        int r15 = 0;
        int r16 = 0;
        boolean r17 = false;
        String r18 = null;
        Integer r19 = null;
        Boolean r20 = null;
        Integer r21 = null;
        switch(r14) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L23;
            case 8: goto L17;
            case 9: goto L11;
            default: goto L38;
        };
    L11:
        Object r22 = r10.readValue(r13);
        if ((r22 instanceof Integer) == false) goto L14;
        r19 = (Integer) r22;
    L14:
        if (r19 == null) goto L16;
        r16 = r19.intValue();
    L16:
        this.evidenceCount = r16;
        goto L38
    L17:
        Object r23 = r10.readValue(r13);
        if ((r23 instanceof Boolean) == false) goto L20;
        r20 = (Boolean) r23;
    L20:
        if (r20 == null) goto L22;
        r17 = r20.booleanValue();
    L22:
        this.userEdit = r17;
        goto L38
    L23:
        Object r24 = r10.readValue(r13);
        if ((r24 instanceof Integer) == false) goto L26;
        r21 = (Integer) r24;
    L26:
        if (r21 == null) goto L28;
        r15 = r21.intValue();
    L28:
        this.detailStatus = r15;
        goto L38
    L29:
        this.detail = (String) r10.readValue(r13);
        goto L38
    L30:
        this.sourceQuery = (String) r10.readValue(r13);
        goto L38
    L31:
        this.logId = (String) r10.readValue(r13);
        goto L38
    L32:
        this.sourceAppName = (String) r10.readValue(r13);
        goto L38
    L33:
        this.sourcePackageName = (String) r10.readValue(r13);
        goto L38
    L34:
        Object r25 = r10.readValue(r13);
        if ((r25 instanceof String) == false) goto L37;
        r18 = (String) r25;
    L37:
        this.sourceText = r18;
    L38:
        r14 = r14 + 1;
    L39:
        if (r14 > r11) goto L41;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r13);
        r14 = r14 + 1;
        goto L39
    }

    public final void setDetail(@Nullable String r10) {
        this.detail = r10;
    }

    public final void setDetailStatus(int r10) {
        this.detailStatus = r10;
    }

    public final void setEvidenceCount(int r10) {
        this.evidenceCount = r10;
    }

    public final void setLogId(@Nullable String r10) {
        this.logId = r10;
    }

    public final void setProductType(int r10) {
        this.productType = r10;
    }

    public final void setScreenshot(@Nullable FileEntity r10) {
        this.screenshot = r10;
    }

    public final void setSourceAppName(@Nullable String r10) {
        this.sourceAppName = r10;
    }

    public final void setSourceLink(@Nullable String r10) {
        this.sourceLink = r10;
    }

    public final void setSourceLinkType(@Nullable String r10) {
        this.sourceLinkType = r10;
    }

    public final void setSourcePackageName(@Nullable String r10) {
        this.sourcePackageName = r10;
    }

    public final void setSourceQuery(@Nullable String r10) {
        this.sourceQuery = r10;
    }

    public final void setSourceText(@Nullable String r10) {
        this.sourceText = r10;
    }

    public final void setUserEdit(boolean r10) {
        this.userEdit = r10;
    }

    public final void writeMemoryBaseFieldToParcel$capabilitykitcommon_release(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(this.productType);
    }

    public final void writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(9);
        r10.writeString(this.sourceLinkType);
        r10.writeString(this.sourceLink);
        r10.writeParcelable(this.screenshot, r11);
        r10.writeValue(this.sourceText);
        r10.writeValue(this.sourcePackageName);
        r10.writeValue(this.sourceAppName);
        r10.writeValue(this.logId);
        r10.writeValue(this.sourceQuery);
        r10.writeValue(this.detail);
        r10.writeValue(Integer.valueOf(this.detailStatus));
        r10.writeValue(Boolean.valueOf(this.userEdit));
        r10.writeValue(Integer.valueOf(this.evidenceCount));
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        throw new UnsupportedOperationException("Don't construct MemoryEntity Directly, use subclass instead");
    }

    public MemoryEntity(@NotNull String r10, long r11, long r12, int r13, int r14) {
        q.g(r10, "id");
        super(r10, r11, r12, r13);
        this.productType = r14;
    }
}
