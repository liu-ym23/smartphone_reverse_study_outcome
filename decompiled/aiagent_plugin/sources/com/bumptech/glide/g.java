package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.f.k;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.target.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class g<TranscodeType> extends com.bumptech.glide.request.a<g<TranscodeType>> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.bumptech.glide.request.h f3340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RequestManager f3342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<TranscodeType> f3343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Glide f3344e;
    private final GlideContext f;
    private h<?, ? super TranscodeType> g;
    private Object h;
    private List<com.bumptech.glide.request.g<TranscodeType>> i;
    private g<TranscodeType> j;
    private g<TranscodeType> k;
    private Float l;
    private boolean m;
    private boolean n;
    private boolean o;

    /* JADX INFO: renamed from: com.bumptech.glide.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: RequestBuilder.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3345a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3346b = null;

        static {
            int[] r0 = new int[e.values().length];
            f3346b = r0;
            r0[e.f3297d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L34:
            f3346b[e.f3296c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L44:
            f3346b[e.f3295b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            f3346b[e.f3294a.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            int[] r4 = new int[ImageView.ScaleType.values().length];
            f3345a = r4;
            r4[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L36:
            f3345a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L42:
            f3345a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L48:
            f3345a[ImageView.ScaleType.FIT_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L32:
            f3345a[ImageView.ScaleType.FIT_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L40:
            f3345a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L52:
            f3345a[ImageView.ScaleType.CENTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L38:
            f3345a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a b(com.bumptech.glide.request.a r1) {
        return a(r1);
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ com.bumptech.glide.request.a c() {
        return a();
    }

    @Override // com.bumptech.glide.request.a
    public /* synthetic */ Object clone() {
        return a();
    }

    static {
        f3340a = (com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(new com.bumptech.glide.request.h().a(j.f3677c), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin")).a(e.f3297d), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin")).b(true), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin");
    }

    public g(Glide r3, RequestManager r4, Class<TranscodeType> r5, Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        this.m = true;
        this.f3344e = r3;
        this.f3342c = r4;
        this.f3343d = r5;
        this.f3341b = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.g = r4.getDefaultTransitionOptions(r5);
        this.f = (GlideContext) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getGlideContext(), "com.obric.aiagent.plugin"), GlideContext.class, "com.obric.aiagent.plugin");
        a(r4.getDefaultRequestListeners());
        a(r4.getDefaultRequestOptions());
    }

    private void a(List<com.bumptech.glide.request.g<Object>> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        a((com.bumptech.glide.request.g) ZeusTransformUtils.preCheckCast(r5.next(), com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public g<TranscodeType> a(com.bumptech.glide.request.a<?> r2) {
        com.bumptech.glide.f.j.a(r2);
        return (g) ZeusTransformUtils.preCheckCast(super.b(r2), g.class, "com.obric.aiagent.plugin");
    }

    public g<TranscodeType> a(com.bumptech.glide.request.g<TranscodeType> r3) {
        com.bumptech.glide.request.g<TranscodeType> r4 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L8:
        return this;
    L5:
        if (this.i != null) goto L7;
        this.i = new ArrayList();
    L7:
        this.i.add(r4);
        goto L8
    }

    public g<TranscodeType> a(Object r1) {
        return b(r1);
    }

    private g<TranscodeType> b(Object r1) {
        this.h = r1;
        this.n = true;
        return this;
    }

    public g<TranscodeType> a(Bitmap r1) {
        return b(r1).a(com.bumptech.glide.request.h.b(j.f3676b));
    }

    public g<TranscodeType> a(Drawable r1) {
        return b(r1).a(com.bumptech.glide.request.h.b(j.f3676b));
    }

    public g<TranscodeType> a(String r1) {
        return b(r1);
    }

    public g<TranscodeType> a(Uri r1) {
        return b(r1);
    }

    public g<TranscodeType> a(File r1) {
        return b(r1);
    }

    public g<TranscodeType> a(Integer r1) {
        return b(r1).a(com.bumptech.glide.request.h.b(com.bumptech.glide.e.a.a(this.f3341b)));
    }

    @Deprecated
    public g<TranscodeType> a(URL r1) {
        return b(r1);
    }

    public g<TranscodeType> a(byte[] r1) {
        g<TranscodeType> r0 = b(r1);
        if (r0.k() == true) goto L6;
        r0 = r0.a(com.bumptech.glide.request.h.b(j.f3676b));
    L6:
        if (r0.l() == false) goto L8;
        return r0;
    L8:
        return r0.a(com.bumptech.glide.request.h.c(true));
    }

    public g<TranscodeType> a() {
        g<TranscodeType> r2 = (g) ZeusTransformUtils.preCheckCast(super.c(), g.class, "com.obric.aiagent.plugin");
        r2.g = r2.g.a();
        return r2;
    }

    public <Y extends i<TranscodeType>> Y a(Y r3) {
        return (Y) a((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), null, com.bumptech.glide.f.e.a());
    }

    <Y extends i<TranscodeType>> Y a(Y r3, com.bumptech.glide.request.g<TranscodeType> r4, Executor r5) {
        return (Y) a((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin"), this, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private <Y extends i<TranscodeType>> Y a(Y r3, com.bumptech.glide.request.g<TranscodeType> r4, com.bumptech.glide.request.a<?> r5, Executor r6) {
        Y r7 = (Y) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.g<TranscodeType> r8 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.f.j.a(r7);
        if (this.n == false) goto L15;
        com.bumptech.glide.request.d r10 = b(r7, r8, r5, r9);
        com.bumptech.glide.request.d r11 = r7.a();
        if (r10.a(r11) == true) goto L7;
    L12:
        this.f3342c.clear(r7);
        r7.a(r10);
        this.f3342c.track(r7, r10);
        return r7;
    L7:
        if (a(r5, r11) == true) goto L12;
        if (((com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r11), com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin")).d() == true) goto L11;
        r11.a();
    L11:
        return r7;
    L15:
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean a(com.bumptech.glide.request.a<?> r2, com.bumptech.glide.request.d r3) {
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        if (r2.y() == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.e() == false) goto L7;
        return true;
    }

    public ViewTarget<ImageView, TranscodeType> a(ImageView r4) {
        k.a();
        com.bumptech.glide.f.j.a(r4);
        if (e() == false) goto L5;
        com.bumptech.glide.request.a r0 = this;
    L17:
        return (ViewTarget) ZeusTransformUtils.preCheckCast(a(this.f.buildImageViewTarget(r4, this.f3343d), null, r0, com.bumptech.glide.f.e.a()), ViewTarget.class, "com.obric.aiagent.plugin");
    L5:
        if (d() == true) goto L7;
        r0 = this;
        goto L17
    L7:
        if (r4.getScaleType() != null) goto L9;
        r0 = this;
        goto L17
    L9:
        switch(AnonymousClass1.f3345a[r4.getScaleType().ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L20;
        };
    L11:
        r0 = c().h();
        goto L17
    L12:
        r0 = c().g();
        goto L17
    L13:
        r0 = c().h();
        goto L17
    L14:
        r0 = c().f();
        goto L17
    L20:
        r0 = this;
        goto L17
    }

    public com.bumptech.glide.request.c<TranscodeType> b() {
        return a(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public com.bumptech.glide.request.c<TranscodeType> a(int r2, int r3) {
        com.bumptech.glide.request.f r0 = new com.bumptech.glide.request.f(r2, r3);
        return (com.bumptech.glide.request.c) ZeusTransformUtils.preCheckCast(a(r0, r0, com.bumptech.glide.f.e.b()), com.bumptech.glide.request.c.class, "com.obric.aiagent.plugin");
    }

    private e b(e r3) {
        int r4 = AnonymousClass1.f3346b[r3.ordinal()];
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L14;
        if (r4 == 4) goto L14;
        throw new IllegalArgumentException("unknown priority: " + B());
    L14:
        return e.f3294a;
    L16:
        return e.f3295b;
    L18:
        return e.f3296c;
    }

    private com.bumptech.glide.request.d b(i<TranscodeType> r14, com.bumptech.glide.request.g<TranscodeType> r15, com.bumptech.glide.request.a<?> r16, Executor r17) {
        i<TranscodeType> r4 = (i) ZeusTransformUtils.wrapperContextForParams(r14, i.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.g<TranscodeType> r5 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r15, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin");
        Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r17, Executor.class, "com.obric.aiagent.plugin");
        return a(new Object(), r4, r5, null, this.g, r16.B(), r16.C(), r16.E(), r16, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.request.d a(Object r17, i<TranscodeType> r18, com.bumptech.glide.request.g<TranscodeType> r19, com.bumptech.glide.request.e r20, h<?, ? super TranscodeType> r21, e r22, int r23, int r24, com.bumptech.glide.request.a<?> r25, Executor r26) {
        i<TranscodeType> r12 = (i) ZeusTransformUtils.wrapperContextForParams(r18, i.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.g<TranscodeType> r13 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r19, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.e r0 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r20, com.bumptech.glide.request.e.class, "com.obric.aiagent.plugin");
        Executor r14 = (Executor) ZeusTransformUtils.wrapperContextForParams(r26, Executor.class, "com.obric.aiagent.plugin");
        if (this.k == null) goto L5;
        com.bumptech.glide.request.e r4 = new com.bumptech.glide.request.b(r17, r0);
        com.bumptech.glide.request.e r10 = r4;
    L6:
        com.bumptech.glide.request.b r15 = r10;
        com.bumptech.glide.request.d r1 = b(r17, r12, r13, r4, r21, r22, r23, r24, r25, r14);
        if (r15 != 0) goto L9;
        return r1;
    L9:
        int r2 = this.k.C();
        int r3 = this.k.E();
        if (k.a(r23, r24) == true) goto L12;
    L14:
        int r11 = r3;
        g<TranscodeType> r5 = this.k;
        r15.a(r1, r5.a(r17, r12, r13, r15, r5.g, r5.B(), r2, r11, this.k, r14));
        return r15;
    L12:
        if (this.k.D() == true) goto L14;
        r2 = r25.C();
        r3 = r25.E();
        goto L14
    L5:
        r4 = r0;
        r10 = null;
        goto L6
    }

    private com.bumptech.glide.request.d b(Object r22, i<TranscodeType> r23, com.bumptech.glide.request.g<TranscodeType> r24, com.bumptech.glide.request.e r25, h<?, ? super TranscodeType> r26, e r27, int r28, int r29, com.bumptech.glide.request.a<?> r30, Executor r31) {
        i<TranscodeType> r14 = (i) ZeusTransformUtils.wrapperContextForParams(r23, i.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.g<TranscodeType> r15 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r24, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.e r5 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r25, com.bumptech.glide.request.e.class, "com.obric.aiagent.plugin");
        Executor r16 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.aiagent.plugin");
        g<TranscodeType> r0 = this.j;
        if (r0 == null) goto L24;
        if (this.o == true) goto L22;
        h<?, ? super TranscodeType> r1 = r0.g;
        if (r0.m == false) goto L9;
        h<?, ? super TranscodeType> r17 = r26;
    L11:
        if (r0.A() == false) goto L13;
        e r2 = this.j.B();
    L14:
        e r18 = r2;
        int r3 = this.j.C();
        int r4 = this.j.E();
        if (k.a(r28, r29) == true) goto L17;
    L19:
        com.bumptech.glide.request.k r10 = new com.bumptech.glide.request.k(r22, r5);
        com.bumptech.glide.request.d r11 = a(r22, r14, r15, r30, r10, r26, r27, r28, r29, r16);
        this.o = true;
        g<TranscodeType> r9 = this.j;
        h<?, ? super TranscodeType> r6 = r17;
        com.bumptech.glide.request.d r7 = r9.a(r22, r14, r15, r10, r6, r18, r3, r4, r9, r16);
        this.o = false;
        r10.a(r11, r7);
        return r10;
    L17:
        if (this.j.D() == true) goto L19;
        r3 = r30.C();
        r4 = r30.E();
        goto L19
    L13:
        r2 = b(r27);
        goto L14
    L9:
        r17 = r1;
        goto L11
    L22:
        throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    L24:
        if (this.l == null) goto L28;
        com.bumptech.glide.request.k r12 = new com.bumptech.glide.request.k(r22, r5);
        r12.a(a(r22, r14, r15, r30, r12, r26, r27, r28, r29, r16), a(r22, r14, r15, r30.c().a(this.l.floatValue()), r12, r26, b(r27), r28, r29, r16));
        return r12;
    L28:
        return a(r22, r14, r15, r30, r5, r26, r27, r28, r29, r16);
    }

    private com.bumptech.glide.request.d a(Object r20, i<TranscodeType> r21, com.bumptech.glide.request.g<TranscodeType> r22, com.bumptech.glide.request.a<?> r23, com.bumptech.glide.request.e r24, h<?, ? super TranscodeType> r25, e r26, int r27, int r28, Executor r29) {
        i r12 = (i) ZeusTransformUtils.wrapperContextForParams(r21, i.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.g r13 = (com.bumptech.glide.request.g) ZeusTransformUtils.wrapperContextForParams(r22, com.bumptech.glide.request.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.request.e r15 = (com.bumptech.glide.request.e) ZeusTransformUtils.wrapperContextForParams(r24, com.bumptech.glide.request.e.class, "com.obric.aiagent.plugin");
        Executor r18 = (Executor) ZeusTransformUtils.wrapperContextForParams(r29, Executor.class, "com.obric.aiagent.plugin");
        Context r3 = this.f3341b;
        GlideContext r4 = this.f;
        return com.bumptech.glide.request.j.a(r3, r4, r20, this.h, this.f3343d, r23, r27, r28, r26, r12, r13, this.i, r15, r4.getEngine(), r25.b(), r18);
    }
}
