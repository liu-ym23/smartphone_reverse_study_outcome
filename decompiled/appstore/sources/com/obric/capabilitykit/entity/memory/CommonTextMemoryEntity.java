package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bc\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0011H\u0016J\"\u0010&\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\fH\u0016J\u0018\u0010+\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\fH\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "summary", "memoryCreateTime", "title", "tagList", "", "category", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getMemoryCreateTime", "setMemoryCreateTime", "getSummary", "setSummary", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "getTitle", "setTitle", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonTextMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 0;

    @Nullable
    private String category;

    @Nullable
    private String memoryCreateTime;

    @NotNull
    private String summary;

    @Nullable
    private List<String> tagList;

    @Nullable
    private String title;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CommonTextMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CommonTextMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity");
            return (CommonTextMemoryEntity) r11;
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CommonTextMemoryEntity[] newArray(int r10) {
            return new CommonTextMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CommonTextMemoryEntity(@NotNull Parcel r17) {
        q.g(r17, "parcel");
        String r11 = null;
        List r12 = null;
        String r13 = null;
        this(EntityExtKt.f(r17), r17.readLong(), r17.readLong(), r17.readInt(), EntityExtKt.f(r17), r17.readString(), r11, r12, r13, 448, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r17);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r17, 3, r17.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put("title", this.title);
        r10.put("summary", makeModelInputValue("总结的记忆内容", this.summary));
        String r11 = this.memoryCreateTime;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("memoryCreateTime", makeModelInputValue("记忆时间", r11));
    L5:
        return r10;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getMemoryCreateTime() {
        return this.memoryCreateTime;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    @NotNull
    public List<Uri> getSharedUris() {
        FileEntity r10 = getScreenshot();
        if (r10 == null) goto L7;
        List<Uri> r11 = r10.getSharedUris();
        if (r11 == null) goto L7;
        return r11;
    L7:
        return t.i();
    }

    @NotNull
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final List<String> getTagList() {
        return this.tagList;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 == 1) goto L17;
        List<String> r13 = null;
        String r14 = null;
        if (r12 != 2) goto L7;
        Object r15 = r10.readValue(r11);
        if ((r15 instanceof List) == false) goto L16;
        r13 = (List) r15;
    L16:
        this.tagList = r13;
        return;
    L7:
        if (r12 != 3) goto L21;
        Object r16 = r10.readValue(r11);
        if ((r16 instanceof String) == false) goto L12;
        r14 = (String) r16;
    L12:
        this.category = r14;
        return;
    L21:
        return;
    L17:
        this.title = (String) r10.readValue(r11);
    }

    public final void setCategory(@Nullable String r10) {
        this.category = r10;
    }

    public final void setMemoryCreateTime(@Nullable String r10) {
        this.memoryCreateTime = r10;
    }

    public final void setSummary(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.summary = r10;
    }

    public final void setTagList(@Nullable List<String> r10) {
        this.tagList = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.summary);
        r10.writeString(this.memoryCreateTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(3);
        r10.writeValue(this.title);
        r10.writeValue(this.tagList);
        r10.writeValue(this.category);
    }

    public CommonTextMemoryEntity(@NotNull String r11, long r12, long r14, int r16, @NotNull String r17, @Nullable String r18, @Nullable String r19, @Nullable List<String> r20, @Nullable String r21) {
        q.g(r11, "id");
        q.g(r17, "summary");
        super(r11, r12, r14, EntityType.MEMORY_COMMON_TEXT, r16);
        this.summary = r17;
        this.memoryCreateTime = r18;
        this.title = r19;
        this.tagList = r20;
        this.category = r21;
    }

    public /* synthetic */ CommonTextMemoryEntity(String r16, long r17, long r19, int r21, String r22, String r23, String r24, List r25, String r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 32) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r27 & 64) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r27 & 128) == 0) goto L13;
        List r13 = null;
    L15:
        if ((r27 & 256) == 0) goto L17;
        String r14 = null;
    L18:
        this(r16, r17, r19, r21, r22, r11, r12, r13, r14);
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
        r11 = r23;
        goto L7
    }
}
