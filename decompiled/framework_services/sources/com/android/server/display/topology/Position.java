package com.android.server.display.topology;

/* JADX INFO: loaded from: classes2.dex */
public final enum Position extends Enum<Position> {
    private static final /* synthetic */ Position[] $VALUES = null;
    public static final Position bottom = null;
    public static final Position left = null;
    public static final Position right = null;
    public static final Position top = null;
    private final String rawName;

    private static /* synthetic */ Position[] $values() {
        return new Position[]{left, top, right, bottom};
    }

    public static Position valueOf(String name) {
        return (Position) Enum.valueOf(Position.class, name);
    }

    public static Position[] values() {
        return (Position[]) $VALUES.clone();
    }

    static {
        left = new Position("left", 0, "left");
        top = new Position("top", 1, "top");
        right = new Position("right", 2, "right");
        bottom = new Position("bottom", 3, "bottom");
        $VALUES = $values();
    }

    private Position(String r1, int r2, String rawName) {
        super(r1, r2);
        this.rawName = rawName;
    }

    public String getRawName() {
        return this.rawName;
    }

    static Position fromString(String rawString) {
        Position[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Position _f = r0[r2];
        if (_f.getRawName().equals(rawString) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return _f;
    L9:
        throw new IllegalArgumentException(rawString);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.rawName;
    }
}
