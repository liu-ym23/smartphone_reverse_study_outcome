package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityHashData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "hashCodeValue", "", "(Ljava/lang/String;I)V", "getHashCodeValue", "()I", "getId", "()Ljava/lang/String;", "describeContents", "writeToParcel", "", "flags", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityHashData implements Parcelable {

    @NotNull
    public static final a CREATOR = null;
    private final int hashCodeValue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f11405id;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public EntityHashData a(Parcel r10) {
            q.g(r10, "parcel");
            return new EntityHashData(r10);
        }

        public EntityHashData[] b(int r10) {
            return new EntityHashData[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityHashData(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        String r11 = r10.readString();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        this(r11, r10.readInt());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    @NotNull
    public final String getId() {
        return this.f11405id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.f11405id);
        r10.writeInt(this.hashCodeValue);
    }

    public EntityHashData(@NotNull String r10, int r11) {
        q.g(r10, "id");
        this.f11405id = r10;
        this.hashCodeValue = r11;
    }
}
