package com.a.c.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: On.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.b.d.b f3126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.c.b.d.b f3127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.a.c.b.d.d f3128c;

    /* JADX INFO: renamed from: com.a.c.b.c.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: On.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3129a = null;

        static {
            int[] r0 = new int[com.a.c.b.d.c.values().length];
            f3129a = r0;
            r0[com.a.c.b.d.c.f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f3129a[com.a.c.b.d.c.f3135d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f3129a[com.a.c.b.d.c.f3134c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f3129a[com.a.c.b.d.c.f3133b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f3129a[com.a.c.b.d.c.f3136e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public f(com.a.c.b.d.b r3) {
        this(r3, new com.a.c.b.d.d(com.a.c.b.d.c.f));
    }

    public f(com.a.c.b.d.b r3, com.a.c.b.d.d r4) {
        this(r3, r4, new com.a.c.b.d.b(-1));
        com.a.e.a.a(!r4.b().equals(com.a.c.b.d.c.f3135d), "value missing for a#b cron expression");
    }

    public f(com.a.c.b.d.b r2, com.a.c.b.d.d r3, com.a.c.b.d.b r4) {
        com.a.e.a.a(r2, "time must not be null");
        com.a.e.a.a(r3, "special char must not null");
        com.a.e.a.a(r4, "nth value must not be null");
        this.f3126a = r2;
        this.f3128c = r3;
        this.f3127b = r4;
    }

    public com.a.c.b.d.b b() {
        return this.f3126a;
    }

    public com.a.c.b.d.b c() {
        return this.f3127b;
    }

    public com.a.c.b.d.d f() {
        return this.f3128c;
    }

    @Override // com.a.c.b.c.e
    public e a(com.a.c.b.c.a.a r3) {
        return ((com.a.c.b.c.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.a.c.b.c.a.a.class, "com.obric.aiagent.plugin")).a(this);
    }

    @Override // com.a.c.b.c.e
    public String a() {
        int r0 = AnonymousClass1.f3129a[this.f3128c.b().ordinal()];
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L27;
        if (r0 == 3) goto L22;
        if (r0 == 4) goto L17;
        if (r0 != 5) goto L13;
        return "?";
    L13:
        return this.f3128c.toString();
    L17:
        if (a(b()) == false) goto L20;
        return "L" + g();
    L20:
        return String.format("%sL", new Object[]{b()});
    L22:
        if (a(b()) == false) goto L25;
        return "W";
    L25:
        return String.format("%sW", new Object[]{b()});
    L27:
        return String.format("%s#%s", new Object[]{b(), c()});
    L29:
        return b().toString();
    }

    private String g() {
        if (a(c()) == false) goto L6;
        return "";
    L6:
        return String.format("-%s", new Object[]{c()});
    }

    private boolean a(com.a.c.b.d.b r1) {
        if (r1.b().intValue() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
