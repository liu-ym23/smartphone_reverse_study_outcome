package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.toolbox.ServerElements;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BE\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\fH\u0016R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", ServerElements.CONTENT, "endDate", "endTime", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getEndDate", "setEndDate", "getEndTime", "setEndTime", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTodoMemoryEntity extends MemoryEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @NotNull
    private String content;

    @Nullable
    private String endDate;

    @Nullable
    private String endTime;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<EventTodoMemoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EventTodoMemoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity");
            return (EventTodoMemoryEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EventTodoMemoryEntity[] newArray(int r10) {
            return new EventTodoMemoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTodoMemoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTodoMemoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EventTodoMemoryEntity(@NotNull Parcel r12) {
        q.g(r12, "parcel");
        this(EntityExtKt.f(r12), r12.readLong(), r12.readLong(), r12.readInt(), EntityExtKt.f(r12), r12.readString(), r12.readString());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 0, r12.readInt());
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    @NotNull
    public JSONObject convertToModelInput() {
        JSONObject r10 = new JSONObject();
        r10.put("type", getType());
        r10.put("createTime", getCreateTime());
        r10.put("modifyTime", getLastModifiedTime());
        r10.put("ecaId", getEcaId());
        r10.put(ServerElements.CONTENT, makeModelInputValue("待办内容", this.content));
        String r11 = this.endDate;
        if (r11 == null) goto L5;
        q.d(r11);
        r10.put("endDate", makeModelInputValue("待办截止日期", r11));
    L5:
        String r12 = this.endTime;
        if (r12 == null) goto L8;
        q.d(r12);
        r10.put("endTime", makeModelInputValue("待办截止时间", r12));
    L8:
        return r10;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final String getEndTime() {
        return this.endTime;
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

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    public final void setContent(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.content = r10;
    }

    public final void setEndDate(@Nullable String r10) {
        this.endDate = r10;
    }

    public final void setEndTime(@Nullable String r10) {
        this.endTime = r10;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.content);
        r10.writeString(this.endDate);
        r10.writeString(this.endTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r10, r11);
        r10.writeInt(0);
    }

    public EventTodoMemoryEntity(@NotNull String r11, long r12, long r14, int r16, @NotNull String r17, @Nullable String r18, @Nullable String r19) {
        q.g(r11, "id");
        q.g(r17, ServerElements.CONTENT);
        super(r11, r12, r14, EntityType.MEMORY_EVENT_TODO, r16);
        this.content = r17;
        this.endDate = r18;
        this.endTime = r19;
    }

    public /* synthetic */ EventTodoMemoryEntity(String r13, long r14, long r16, int r18, String r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 32) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r22 & 64) == 0) goto L9;
        String r11 = null;
    L10:
        this(r13, r14, r16, r18, r19, r10, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }
}
