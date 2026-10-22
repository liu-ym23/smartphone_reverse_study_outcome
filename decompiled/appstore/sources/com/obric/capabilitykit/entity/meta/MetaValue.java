package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b'\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H ¢\u0006\u0002\b\u0011J%\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaValue;", "Landroid/os/Parcelable;", "type", "", "(I)V", "()V", "getType", "()I", "setType", "describeContents", "onReadMetaValueExtensionField", "", "parcel", "Landroid/os/Parcel;", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "readMetaValueExtensionField", "ourVersion", "theirVersion", "readMetaValueExtensionField$capabilitykitcommon_release", "toString", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class MetaValue implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;
    private int type;

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaValue$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "json", "", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaValue;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaValue> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaValue createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            throw new UnsupportedOperationException("can't construct MetaValue");
        }

        @NotNull
        public final MetaValue fromJson(@NotNull String r10) {
            q.g(r10, "json");
            Object r11 = EntityExtKt.a().fromJson(r10, MetaValue.class);
            q.f(r11, "entityGson.fromJson(json, MetaValue::class.java)");
            return (MetaValue) r11;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaValue[] newArray(int r10) {
            return new MetaValue[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaValue createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaValue[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaValue() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public abstract void onReadMetaValueExtensionField$capabilitykitcommon_release(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12);

    public final void readMetaValueExtensionField$capabilitykitcommon_release(@NotNull Parcel r10, int r11, int r12) {
        q.g(r10, "parcel");
        if (r12 > r11) goto L6;
        r11 = r12;
    L6:
        ClassLoader r13 = MetaValue.class.getClassLoader();
        int r14 = 1;
    L7:
        if (r14 > r11) goto L9;
        onReadMetaValueExtensionField$capabilitykitcommon_release(r10, r13, r14);
        r14 = r14 + 1;
    L9:
        if (r14 > r12) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r13);
        r14 = r14 + 1;
        goto L9
    }

    public final void setType(int r10) {
        this.type = r10;
    }

    @NotNull
    public String toString() {
        return EntityExtKt.toJson(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        throw new UnsupportedOperationException("MetaValue can't writeToParcel");
    }

    public MetaValue(int r10) {
        this();
        this.type = r10;
    }
}
