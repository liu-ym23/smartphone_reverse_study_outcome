package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016j\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/Position;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TOP", "BOTTOM", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Position extends Enum<Position> implements Parcelable {
    private static final /* synthetic */ Position[] $VALUES = null;
    public static final Position BOTTOM = null;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<Position> CREATOR = null;

    @NotNull
    public static final b Companion = null;
    public static final Position TOP = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/common/Position$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/Position;", "fromString", CommonKey.KEY_VALUE, "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        @NotNull
        public final Position a(@NotNull String r10) {
            kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
            Position[] r11 = Position.values();
            int r12 = 0;
        L4:
            if (r12 >= 2) goto L9;
            Position r13 = r11[r12];
            if (kotlin.jvm.internal.q.b(r13.name(), r10) == true) goto L10;
            r12 = r12 + 1;
        L10:
            if (r13 == null) goto L13;
            return r13;
        L13:
            throw new IllegalArgumentException("Position must be either 'TOP' or 'BOTTOM'.");
        L9:
            r13 = null;
            goto L10
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final /* synthetic */ Position[] $values() {
        return new Position[]{TOP, BOTTOM};
    }

    static {
        TOP = new Position("TOP", 0);
        BOTTOM = new Position("BOTTOM", 1);
        $VALUES = $values();
        Companion = new b(null);
        CREATOR = new a();
    }

    private Position(String r10, int r11) {
        super(r10, r11);
    }

    public static Position valueOf(String r10) {
        return (Position) Enum.valueOf(Position.class, r10);
    }

    public static Position[] values() {
        return (Position[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "parcel");
        r10.writeString(name());
    }
}
