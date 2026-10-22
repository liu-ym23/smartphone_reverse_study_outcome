package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum CollisionBehavior extends Enum<CollisionBehavior> {
    public static final CollisionBehavior ALWAYS_SHOW = null;
    public static final CollisionBehavior COLLIDE_INNER_AND_BASEPOI = null;
    public static final CollisionBehavior COLLIDE_WITH_BASEPOI = null;
    public static final CollisionBehavior COLLIDE_WITH_INNER = null;
    public static final CollisionBehavior HIDE_BY_PRIORITY = null;
    public static final CollisionBehavior NOT_COLLIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ CollisionBehavior[] f30857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30858b;

    static {
        CollisionBehavior r100 = new CollisionBehavior("NOT_COLLIDE", 0, 0);
        NOT_COLLIDE = r100;
        CollisionBehavior r101 = new CollisionBehavior("ALWAYS_SHOW", 1, 1);
        ALWAYS_SHOW = r101;
        CollisionBehavior r102 = new CollisionBehavior("HIDE_BY_PRIORITY", 2, 2);
        HIDE_BY_PRIORITY = r102;
        CollisionBehavior r103 = new CollisionBehavior("COLLIDE_WITH_INNER", 3, 4);
        COLLIDE_WITH_INNER = r103;
        CollisionBehavior r104 = new CollisionBehavior("COLLIDE_WITH_BASEPOI", 4, 8);
        COLLIDE_WITH_BASEPOI = r104;
        CollisionBehavior r110 = new CollisionBehavior("COLLIDE_INNER_AND_BASEPOI", 5, 12);
        COLLIDE_INNER_AND_BASEPOI = r110;
        f30857a = new CollisionBehavior[]{r100, r101, r102, r103, r104, r110};
    }

    public static CollisionBehavior[] values() {
        return (CollisionBehavior[]) f30857a.clone();
    }

    public int getNumber() {
        return this.f30858b;
    }

    public static CollisionBehavior valueOf(String r100) {
        return (CollisionBehavior) r27.a.a(CollisionBehavior.class, r100);
    }

    private CollisionBehavior(String r100, int r101, int r102) {
        super(r100, r101);
        this.f30858b = r102;
    }
}
