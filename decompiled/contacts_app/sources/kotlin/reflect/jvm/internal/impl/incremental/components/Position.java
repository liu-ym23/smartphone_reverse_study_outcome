package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Position implements Serializable {
    public static final Companion Companion = null;
    private static final Position NO_POSITION = null;
    private final int column;
    private final int line;

    /* JADX INFO: compiled from: LookupLocation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Position getNO_POSITION() {
            return Position.access$getNO_POSITION$cp();
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Position) == true) goto L8;
        return false;
    L8:
        Position r6 = (Position) r5;
        if (this.line == r6.line) goto L12;
        return false;
    L12:
        if (this.column == r6.column) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ')';
    }

    public Position(int r1, int r2) {
        this.line = r1;
        this.column = r2;
    }

    public static final /* synthetic */ Position access$getNO_POSITION$cp() {
        return NO_POSITION;
    }

    static {
        Companion = new Companion(null);
        NO_POSITION = new Position(-1, -1);
    }
}
