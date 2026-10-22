package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum Position extends Enum<Position> implements Parcelable {
    private static final /* synthetic */ Position[] $VALUES = null;
    public static final Position BOTTOM = null;
    public static final Parcelable.Creator<Position> CREATOR = null;
    public static final b Companion = null;
    public static final Position TOP = null;

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        public final Position a(String r4) {
            d.h.b.o.e(r4, "value");
            Position[] r3 = Position.values();
            int r0 = 0;
        L4:
            if (r0 >= 2) goto L9;
            Position r1 = r3[r0];
            if (d.h.b.o.a(r1.name(), r4) == true) goto L10;
            r0 = r0 + 1;
        L10:
            if (r1 == null) goto L13;
            return r1;
        L13:
            throw new IllegalArgumentException("Position must be either 'TOP' or 'BOTTOM'.");
        L9:
            r1 = null;
            goto L10
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

    private Position(String r1, int r2) {
        super(r1, r2);
    }

    public static Position valueOf(String r2) {
        return (Position) ZeusTransformUtils.preCheckCast(Enum.valueOf(Position.class, r2), Position.class, "com.obric.aiagent.plugin");
    }

    public static Position[] values() {
        return (Position[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Position[].class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        d.h.b.o.e(r1, "parcel");
        r1.writeString(name());
    }
}
