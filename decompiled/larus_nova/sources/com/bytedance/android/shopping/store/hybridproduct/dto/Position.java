package com.bytedance.android.shopping.store.hybridproduct.dto;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/Position;", "", "", "direction", "I", "getDirection", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LEFT", "RIGHT", "TOP", "BOTTOM", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Position extends Enum<Position> {
    public static final Position BOTTOM = null;
    public static final a Companion = null;
    public static final Position LEFT = null;
    public static final Position RIGHT = null;
    public static final Position TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Position[] f184976a = null;
    private final int direction;

    public static final class a {
        public a() {
        }
    }

    static {
        Position r100 = new Position("LEFT", 0, 1);
        LEFT = r100;
        Position r101 = new Position("RIGHT", 1, 2);
        RIGHT = r101;
        Position r102 = new Position("TOP", 2, 3);
        TOP = r102;
        Position r103 = new Position("BOTTOM", 3, 4);
        BOTTOM = r103;
        f184976a = new Position[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static Position valueOf(String r100) {
        return (Position) r27.a.a(Position.class, r100);
    }

    public static Position[] values() {
        return (Position[]) f184976a.clone();
    }

    public final int getDirection() {
        return this.direction;
    }

    public Position(String r100, int r101, int r102) {
        super(r100, r101);
        this.direction = r102;
    }
}
