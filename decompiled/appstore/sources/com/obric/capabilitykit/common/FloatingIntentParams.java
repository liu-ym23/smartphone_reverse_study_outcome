package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\bH\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\bH\u0016R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/FloatingIntentParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "position", "Lcom/obric/capabilitykit/common/Position;", Style.KEY_HEIGHT, "", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "", "(Lcom/obric/capabilitykit/common/Position;Ljava/lang/Integer;Ljava/util/concurrent/ConcurrentHashMap;)V", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosition", "()Lcom/obric/capabilitykit/common/Position;", "component1", "component2", "component3", "copy", "(Lcom/obric/capabilitykit/common/Position;Ljava/lang/Integer;Ljava/util/concurrent/ConcurrentHashMap;)Lcom/obric/capabilitykit/common/FloatingIntentParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class FloatingIntentParams implements Parcelable {

    @NotNull
    public static final a CREATOR = null;

    @Nullable
    private ConcurrentHashMap<String, String> ext;

    @Nullable
    private final Integer height;

    @NotNull
    private final Position position;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/FloatingIntentParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/common/FloatingIntentParams;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<FloatingIntentParams> {
        private a() {
        }

        @NotNull
        public FloatingIntentParams a(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            kotlin.jvm.internal.q.g(r10, "parcel");
            r10.readInt();
            FloatingIntentParams r12 = new FloatingIntentParams(r10);
            int r13 = Math.min(r11, 0);
            ClassLoader r14 = a.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L5;
            r15 = r15 + 1;
        L5:
            if (r15 > r11) goto L7;
            be.a.d(r10, r14);
            r15 = r15 + 1;
            goto L5
        L7:
            return r12;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FloatingIntentParams createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FloatingIntentParams[] newArray(int r10) {
            return a(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @NotNull
        public FloatingIntentParams[] a(int r10) {
            return new FloatingIntentParams[r10];
        }
    }

    static {
        CREATOR = new a(null);
    }

    public FloatingIntentParams() {
        Position r10 = null;
        Integer r11 = null;
        ConcurrentHashMap r12 = null;
        this(r10, r11, r12, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FloatingIntentParams copy$default(FloatingIntentParams r10, Position r11, Integer r12, ConcurrentHashMap r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.position;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.height;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.ext;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @NotNull
    public final Position component1() {
        return this.position;
    }

    @Nullable
    public final Integer component2() {
        return this.height;
    }

    @Nullable
    public final ConcurrentHashMap<String, String> component3() {
        return this.ext;
    }

    @NotNull
    public final FloatingIntentParams copy(@NotNull Position r10, @Nullable Integer r11, @Nullable ConcurrentHashMap<String, String> r12) {
        kotlin.jvm.internal.q.g(r10, "position");
        return new FloatingIntentParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FloatingIntentParams) == true) goto L8;
        return false;
    L8:
        FloatingIntentParams r11 = (FloatingIntentParams) r10;
        if (this.position == r11.position) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.height, r11.height) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.ext, r11.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @NotNull
    public final Position getPosition() {
        return this.position;
    }

    public int hashCode() {
        int r10 = this.position.hashCode() * 31;
        Integer r11 = this.height;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        ConcurrentHashMap<String, String> r15 = this.ext;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setExt(@Nullable ConcurrentHashMap<String, String> r10) {
        this.ext = r10;
    }

    @NotNull
    public String toString() {
        return "FloatingIntentParams(position=" + this.position + ", height=" + this.height + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        kotlin.jvm.internal.q.g(r10, "parcel");
        r10.writeInt(0);
        r10.writeValue(this.position);
        r10.writeValue(this.height);
        r10.writeSerializable(this.ext);
    }

    public FloatingIntentParams(@NotNull Parcel r10) {
        kotlin.jvm.internal.q.g(r10, "parcel");
        Object r11 = r10.readValue(Position.class.getClassLoader());
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.common.Position");
        Position r12 = (Position) r11;
        Object r13 = r10.readValue(Integer.TYPE.getClassLoader());
        ConcurrentHashMap r14 = null;
        if ((r13 instanceof Integer) == false) goto L5;
        Integer r15 = (Integer) r13;
    L6:
        Serializable r16 = r10.readSerializable();
        if ((r16 instanceof ConcurrentHashMap) == false) goto L9;
        r14 = (ConcurrentHashMap) r16;
    L9:
        this(r12, r15, r14);
        return;
    L5:
        r15 = null;
        goto L6
    }

    public FloatingIntentParams(@NotNull Position r10, @Nullable Integer r11, @Nullable ConcurrentHashMap<String, String> r12) {
        kotlin.jvm.internal.q.g(r10, "position");
        this.position = r10;
        this.height = r11;
        this.ext = r12;
    }

    public /* synthetic */ FloatingIntentParams(Position r10, Integer r11, ConcurrentHashMap r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = Position.BOTTOM;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
