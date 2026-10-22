package org.tensorflow.lite;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DataType.java */
/* JADX INFO: loaded from: classes5.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40580b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f40581c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f40582d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f40583e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    private static final a[] j = null;
    private static final /* synthetic */ a[] k = null;
    private final int i;

    /* JADX INFO: renamed from: org.tensorflow.lite.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: DataType.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40584a = null;

        static {
            int[] r0 = new int[a.values().length];
            f40584a = r0;
            r0[a.f40579a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f40584a[a.f40580b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f40584a[a.g.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f40584a[a.h.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f40584a[a.f40581c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f40584a[a.f40582d.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f40584a[a.f.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f40584a[a.f40583e.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(k.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    static {
        a r0 = new a("FLOAT32", 0, 1);
        f40579a = r0;
        a r1 = new a("INT32", 1, 2);
        f40580b = r1;
        a r4 = new a("UINT8", 2, 3);
        f40581c = r4;
        a r6 = new a("INT64", 3, 4);
        f40582d = r6;
        a r8 = new a("STRING", 4, 5);
        f40583e = r8;
        a r10 = new a("BOOL", 5, 6);
        f = r10;
        a r12 = new a("INT16", 6, 7);
        g = r12;
        a r14 = new a("INT8", 7, 9);
        h = r14;
        k = new a[]{r0, r1, r4, r6, r8, r10, r12, r14};
        j = values();
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.i = r3;
    }

    public int a() {
        switch(AnonymousClass1.f40584a[ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return -1;
    L7:
        return 8;
    L9:
        return 1;
    L11:
        return 2;
    L13:
        return 4;
    L5:
        throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
    }
}
