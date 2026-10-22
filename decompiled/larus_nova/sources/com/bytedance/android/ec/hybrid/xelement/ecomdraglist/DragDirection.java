package com.bytedance.android.ec.hybrid.xelement.ecomdraglist;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/hybrid/xelement/ecomdraglist/DragDirection;", "", "", "direction", "I", "getDirection", "()I", "DIRECTION_ALL", "DIRECTION_HORIZONTAL", "DIRECTION_VERTICAL", "ec-xelement_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DragDirection extends Enum<DragDirection> {
    public static final DragDirection DIRECTION_ALL = null;
    public static final DragDirection DIRECTION_HORIZONTAL = null;
    public static final DragDirection DIRECTION_VERTICAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DragDirection[] f47719a = null;
    private final int direction;

    static {
        DragDirection r100 = new DragDirection("DIRECTION_ALL", 0, 0);
        DIRECTION_ALL = r100;
        DragDirection r101 = new DragDirection("DIRECTION_HORIZONTAL", 1, 1);
        DIRECTION_HORIZONTAL = r101;
        DragDirection r102 = new DragDirection("DIRECTION_VERTICAL", 2, 2);
        DIRECTION_VERTICAL = r102;
        f47719a = new DragDirection[]{r100, r101, r102};
    }

    public static DragDirection valueOf(String r100) {
        return (DragDirection) a.a(DragDirection.class, r100);
    }

    public static DragDirection[] values() {
        return (DragDirection[]) f47719a.clone();
    }

    public final int getDirection() {
        return this.direction;
    }

    public DragDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.direction = r102;
    }
}
