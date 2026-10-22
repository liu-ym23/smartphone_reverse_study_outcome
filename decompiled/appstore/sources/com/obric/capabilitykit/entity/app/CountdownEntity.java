package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B=\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020 H\u0016R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "countdownSeconds", ServerElements.LABEL, "status", "Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;", "(Ljava/lang/String;JJJLjava/lang/String;Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;)V", "getCountdownSeconds", "()J", "setCountdownSeconds", "(J)V", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getStatus", "()Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;", "setStatus", "(Lcom/obric/capabilitykit/entity/enums/CountdownStatusEnum;)V", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CountdownEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 1;
    private long countdownSeconds;

    @Nullable
    private String label;

    @Nullable
    private CountdownStatusEnum status;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CountdownEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CountdownEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CountdownEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CountdownEntity");
            return (CountdownEntity) r11;
        }

        public final int getVersion() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CountdownEntity[] newArray(int r10) {
            return new CountdownEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CountdownEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CountdownEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CountdownEntity(@NotNull Parcel r14) {
        q.g(r14, "parcel");
        CountdownStatusEnum r10 = null;
        this(EntityExtKt.f(r14), r14.readLong(), r14.readLong(), r14.readLong(), r14.readString(), r10, 32, null);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 1, r14.readInt());
    }

    public final long getCountdownSeconds() {
        return this.countdownSeconds;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final CountdownStatusEnum getStatus() {
        return this.status;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L6;
        this.status = CountdownStatusEnum.Companion.a((String) r10.readValue(r11));
        return;
    }

    public final void setCountdownSeconds(long r10) {
        this.countdownSeconds = r10;
    }

    public final void setLabel(@Nullable String r10) {
        this.label = r10;
    }

    public final void setStatus(@Nullable CountdownStatusEnum r10) {
        this.status = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeLong(this.countdownSeconds);
        r10.writeString(this.label);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(1);
        CountdownStatusEnum r12 = this.status;
        if (r12 == null) goto L5;
        String r13 = r12.name();
    L6:
        r10.writeValue(r13);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public CountdownEntity(@NotNull String r10, long r11, long r12, long r14, @Nullable String r16, @Nullable CountdownStatusEnum r17) {
        q.g(r10, "id");
        super(r10, r11, r12, 702);
        this.countdownSeconds = r14;
        this.label = r16;
        this.status = r17;
    }

    public /* synthetic */ CountdownEntity(String r13, long r14, long r16, long r18, String r20, CountdownStatusEnum r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 16) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r22 & 32) == 0) goto L9;
        CountdownStatusEnum r11 = null;
    L10:
        this(r13, r14, r16, r18, r10, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }
}
