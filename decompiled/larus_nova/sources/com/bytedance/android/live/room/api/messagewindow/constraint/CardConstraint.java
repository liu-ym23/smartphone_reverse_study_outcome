package com.bytedance.android.live.room.api.messagewindow.constraint;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class CardConstraint {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f98973h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Position f98974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f98975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f98976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f98977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f98978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f98979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f98980g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/constraint/CardConstraint$Position;", "", "TopLeft", "TopRight", "BottomRight", "CenterRight", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Position extends Enum<Position> {
        public static final Position BottomRight = null;
        public static final Position CenterRight = null;
        public static final Position TopLeft = null;
        public static final Position TopRight = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Position[] f98981a = null;

        static {
            Position r100 = new Position("TopLeft", 0);
            TopLeft = r100;
            Position r101 = new Position("TopRight", 1);
            TopRight = r101;
            Position r102 = new Position("BottomRight", 2);
            BottomRight = r102;
            Position r103 = new Position("CenterRight", 3);
            CenterRight = r103;
            f98981a = new Position[]{r100, r101, r102, r103};
        }

        public static Position valueOf(String r100) {
            return (Position) r27.a.a(Position.class, r100);
        }

        public static Position[] values() {
            return (Position[]) f98981a.clone();
        }

        public Position(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f98982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f98983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f98984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f98985d;

        public b() {
        }
    }

    static {
    }

    public CardConstraint() {
        this(-2, -2);
    }

    public final int hashCode() {
        return (((((((((((this.f98979f * 31) + this.f98980g) * 31) + this.f98974a.hashCode()) * 31) + this.f98975b) * 31) + this.f98976c) * 31) + this.f98977d) * 31) + this.f98978e;
    }

    public CardConstraint(CardConstraint r100) {
        Intrinsics.checkNotNullParameter(r100, "constraint");
        this(r100.f98979f, r100.f98980g);
        this.f98974a = r100.f98974a;
        this.f98975b = r100.f98975b;
        this.f98976c = r100.f98976c;
        this.f98977d = r100.f98977d;
        this.f98978e = r100.f98978e;
    }

    public final void a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_MARGIN);
        b r101 = new b();
        r100.invoke(r101);
        Integer r102 = r101.f98982a;
        if (r102 == null) goto L5;
        this.f98975b = r102.intValue();
    L5:
        Integer r103 = r101.f98983b;
        if (r103 == null) goto L8;
        this.f98976c = r103.intValue();
    L8:
        Integer r104 = r101.f98984c;
        if (r104 == null) goto L11;
        this.f98977d = r104.intValue();
    L11:
        Integer r105 = r101.f98985d;
        if (r105 == null) goto L15;
        this.f98978e = r105.intValue();
        return;
    }

    public final void b(Position r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f98974a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(CardConstraint.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L36;
        CardConstraint r102 = (CardConstraint) r100;
        if (this.f98979f == r102.f98979f) goto L17;
        return false;
    L17:
        if (this.f98980g == r102.f98980g) goto L20;
        return false;
    L20:
        if (this.f98974a == r102.f98974a) goto L23;
        return false;
    L23:
        if (this.f98975b == r102.f98975b) goto L26;
        return false;
    L26:
        if (this.f98976c == r102.f98976c) goto L29;
        return false;
    L29:
        if (this.f98977d == r102.f98977d) goto L32;
        return false;
    L32:
        if (this.f98978e == r102.f98978e) goto L34;
        return false;
    L34:
        return true;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint");
    L8:
        r101 = null;
        goto L10
    }

    public CardConstraint(int r100, int r101) {
        this.f98979f = r100;
        this.f98980g = r101;
        this.f98974a = Position.BottomRight;
    }
}
