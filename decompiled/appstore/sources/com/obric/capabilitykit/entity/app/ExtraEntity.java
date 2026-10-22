package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0014H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "key", "", CommonKey.KEY_VALUE, "", "isSemantic", "", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "()Z", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "describeContents", "", "isValidExtraString", "readExtensionField", "", "theirVersion", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExtraEntity implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;

    @NotNull
    public static final String KEY_EXTRA_1 = "extra1";

    @NotNull
    public static final String KEY_EXTRA_10 = "extra10";

    @NotNull
    public static final String KEY_EXTRA_2 = "extra2";

    @NotNull
    public static final String KEY_EXTRA_3 = "extra3";

    @NotNull
    public static final String KEY_EXTRA_4 = "extra4";

    @NotNull
    public static final String KEY_EXTRA_5 = "extra5";

    @NotNull
    public static final String KEY_EXTRA_6 = "extra6";

    @NotNull
    public static final String KEY_EXTRA_7 = "extra7";

    @NotNull
    public static final String KEY_EXTRA_8 = "extra8";

    @NotNull
    public static final String KEY_EXTRA_9 = "extra9";
    private static final int VERSION = 0;
    private final boolean isSemantic;

    @NotNull
    private final String key;

    @Nullable
    private Object value;

    @Keep
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005J\u001d\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ExtraEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "()V", "KEY_EXTRA_1", "", "KEY_EXTRA_10", "KEY_EXTRA_2", "KEY_EXTRA_3", "KEY_EXTRA_4", "KEY_EXTRA_5", "KEY_EXTRA_6", "KEY_EXTRA_7", "KEY_EXTRA_8", "KEY_EXTRA_9", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "json", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ExtraEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExtraEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new ExtraEntity(r10);
        }

        @NotNull
        public final ExtraEntity fromJson(@NotNull String r10) {
            q.g(r10, "json");
            Object r11 = EntityExtKt.a().fromJson(r10, ExtraEntity.class);
            q.f(r11, "entityGson.fromJson(json, ExtraEntity::class.java)");
            return (ExtraEntity) r11;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExtraEntity[] newArray(int r10) {
            return new ExtraEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ExtraEntity(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10), r10.readValue(ExtraEntity.class.getClassLoader()), EntityExtKt.e(r10));
        readExtensionField(r10, r10.readInt());
    }

    private final void readExtensionField(Parcel r10, int r11) {
        if (r11 <= 0) goto L4;
        int r12 = 0;
    L5:
        ClassLoader r13 = ExtraEntity.class.getClassLoader();
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public final boolean isSemantic() {
        return this.isSemantic;
    }

    public final boolean isValidExtraString(@NotNull String r10) {
        q.g(r10, "key");
        return new Regex("^extra([1-9]|10)$").matches(r10);
    }

    public final void setValue(@Nullable Object r10) {
        this.value = r10;
    }

    @NotNull
    public String toString() {
        return EntityExtKt.toJson(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.key);
        r10.writeValue(this.value);
        EntityExtKt.g(r10, this.isSemantic);
        r10.writeInt(0);
    }

    public ExtraEntity(@NotNull String r10, @Nullable Object r11, boolean r12) {
        q.g(r10, "key");
        this.key = r10;
        this.value = r11;
        this.isSemantic = r12;
        if (isValidExtraString(r10) == false) goto L10;
        if (EntityExtKt.d(this.value) == false) goto L7;
        return;
    L7:
        StringBuilder r13 = new StringBuilder();
        r13.append("ExtraEntity's value type ");
        Object r14 = this.value;
        q.d(r14);
        r13.append(r14.getClass().getName());
        r13.append(" is not supported");
        throw new IllegalArgumentException(r13.toString());
    L10:
        throw new IllegalArgumentException("ExtraEntity's key " + r10 + " is not valid, must be extraN (N is 1-10)");
    }

    public /* synthetic */ ExtraEntity(String r10, Object r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = false;
    L5:
        this(r10, r11, r12);
    }
}
