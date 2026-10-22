package kotlinx.coroutines.flow;

import Xa.c;
import Xa.d;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.ai.selector.camera.CustomCameraView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.internal.CombineKt;
import p9.InterfaceC5063a;
import p9.q;
import p9.r;
import p9.s;

@Metadata(d1 = {"\u0000>\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001ai\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0007¢\u0006\u0004\b\t\u0010\n\u001ak\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0004\b\f\u0010\n\u001a\u0085\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032.\u0010\b\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u009f\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010\b\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a¹\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0012\"\u0004\b\u0004\u0010\u0017\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032:\u0010\b\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e0\u001d\"\u0004\b\u0000\u0010\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"T1", "T2", "R", "LXa/b;", "flow", "Lkotlin/Function3;", "Le9/c;", "", "transform", "f", "(LXa/b;LXa/b;Lp9/q;)LXa/b;", "flow2", "e", "T3", "flow3", "Lkotlin/Function4;", Const.INTENT_KEY_UMID, "(LXa/b;LXa/b;LXa/b;Lp9/r;)LXa/b;", "T4", "flow4", "Lkotlin/Function5;", "c", "(LXa/b;LXa/b;LXa/b;LXa/b;Lp9/s;)LXa/b;", "T5", "flow5", "Lkotlin/Function6;", Const.INTENT_KEY_PKGNAME, "(LXa/b;LXa/b;LXa/b;LXa/b;LXa/b;Lp9/t;)LXa/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lp9/a;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ZipKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ZipKt$a", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<R> implements Xa.b<R> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Xa.b f36600a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Xa.b f36601b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f36602c;

        public a(Xa.b bVar, Xa.b bVar2, q qVar) {
            this.f36600a = bVar;
            this.f36601b = bVar2;
            this.f36602c = qVar;
        }

        @Override // Xa.b
        public Object collect(c<? super R> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objA = CombineKt.a(cVar, new Xa.b[]{this.f36600a, this.f36601b}, FlowKt__ZipKt.g(), new FlowKt__ZipKt$combine$1$1(this.f36602c, null), interfaceC4014c);
            return objA == C4063a.g() ? objA : t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5063a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f36603a = new b();

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    public static final <T1, T2, T3, T4, T5, R> Xa.b<R> b(Xa.b<? extends T1> bVar, Xa.b<? extends T2> bVar2, Xa.b<? extends T3> bVar3, Xa.b<? extends T4> bVar4, Xa.b<? extends T5> bVar5, final p9.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super InterfaceC4014c<? super R>, ? extends Object> tVar) {
        final Xa.b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5};
        return new Xa.b<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "", "it", "LY8/t;", "<anonymous>", "(LXa/c;Lkotlin/Array;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", l = {329, CustomCameraView.BUTTON_STATE_ONLY_RECORDER}, m = "invokeSuspend", v = 1)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements q<c<? super R>, Object[], InterfaceC4014c<? super t>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public Object f36592a;

                /* renamed from: b, reason: collision with root package name */
                public int f36593b;

                /* renamed from: c, reason: collision with root package name */
                public /* synthetic */ Object f36594c;

                /* renamed from: d, reason: collision with root package name */
                public /* synthetic */ Object f36595d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ p9.t f36596e;

                /* renamed from: f, reason: collision with root package name */
                public Object f36597f;

                /* renamed from: g, reason: collision with root package name */
                public Object f36598g;

                /* renamed from: h, reason: collision with root package name */
                public int f36599h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(InterfaceC4014c interfaceC4014c, p9.t tVar) {
                    super(3, interfaceC4014c);
                    this.f36596e = tVar;
                }

                @Override // p9.q
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object invoke(c<? super R> cVar, Object[] objArr, InterfaceC4014c<? super t> interfaceC4014c) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c, this.f36596e);
                    anonymousClass2.f36594c = cVar;
                    anonymousClass2.f36595d = objArr;
                    return anonymousClass2.invokeSuspend(t.f7040a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x008f, code lost:
                
                    if (r3.emit(r13, r11) == r2) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
                    /*
                        r12 = this;
                        java.lang.Object r0 = r12.f36594c
                        Xa.c r0 = (Xa.c) r0
                        java.lang.Object r1 = r12.f36595d
                        java.lang.Object[] r1 = (java.lang.Object[]) r1
                        java.lang.Object r2 = f9.C4063a.g()
                        int r3 = r12.f36593b
                        r4 = 2
                        r5 = 1
                        if (r3 == 0) goto L34
                        if (r3 == r5) goto L23
                        if (r3 != r4) goto L1b
                        kotlin.C4849c.b(r13)
                        goto L92
                    L1b:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r13)
                        throw r12
                    L23:
                        java.lang.Object r3 = r12.f36598g
                        java.lang.Object[] r3 = (java.lang.Object[]) r3
                        java.lang.Object r3 = r12.f36597f
                        e9.c r3 = (e9.InterfaceC4014c) r3
                        java.lang.Object r3 = r12.f36592a
                        Xa.c r3 = (Xa.c) r3
                        kotlin.C4849c.b(r13)
                        r11 = r12
                        goto L76
                    L34:
                        kotlin.C4849c.b(r13)
                        r13 = r5
                        p9.t r5 = r12.f36596e
                        r3 = 0
                        r6 = r1[r3]
                        r7 = r1[r13]
                        r8 = r1[r4]
                        r9 = 3
                        r9 = r1[r9]
                        r10 = 4
                        r10 = r1[r10]
                        java.lang.Object r11 = g9.h.a(r0)
                        r12.f36594c = r11
                        java.lang.Object r11 = g9.h.a(r1)
                        r12.f36595d = r11
                        r12.f36592a = r0
                        java.lang.Object r11 = g9.h.a(r12)
                        r12.f36597f = r11
                        java.lang.Object r11 = g9.h.a(r1)
                        r12.f36598g = r11
                        r12.f36599h = r3
                        r12.f36593b = r13
                        r13 = 6
                        kotlin.jvm.internal.n.c(r13)
                        r11 = r12
                        java.lang.Object r13 = r5.m(r6, r7, r8, r9, r10, r11)
                        r12 = 7
                        kotlin.jvm.internal.n.c(r12)
                        if (r13 != r2) goto L75
                        goto L91
                    L75:
                        r3 = r0
                    L76:
                        java.lang.Object r12 = g9.h.a(r0)
                        r11.f36594c = r12
                        java.lang.Object r12 = g9.h.a(r1)
                        r11.f36595d = r12
                        r12 = 0
                        r11.f36592a = r12
                        r11.f36597f = r12
                        r11.f36598g = r12
                        r11.f36593b = r4
                        java.lang.Object r12 = r3.emit(r13, r11)
                        if (r12 != r2) goto L92
                    L91:
                        return r2
                    L92:
                        Y8.t r12 = Y8.t.f7040a
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c cVar, InterfaceC4014c interfaceC4014c) {
                Object objA = CombineKt.a(cVar, bVarArr, FlowKt__ZipKt.g(), new AnonymousClass2(null, tVar), interfaceC4014c);
                return objA == C4063a.g() ? objA : t.f7040a;
            }
        };
    }

    public static final <T1, T2, T3, T4, R> Xa.b<R> c(Xa.b<? extends T1> bVar, Xa.b<? extends T2> bVar2, Xa.b<? extends T3> bVar3, Xa.b<? extends T4> bVar4, final s<? super T1, ? super T2, ? super T3, ? super T4, ? super InterfaceC4014c<? super R>, ? extends Object> sVar) {
        final Xa.b[] bVarArr = {bVar, bVar2, bVar3, bVar4};
        return new Xa.b<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "", "it", "LY8/t;", "<anonymous>", "(LXa/c;Lkotlin/Array;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", l = {329, CustomCameraView.BUTTON_STATE_ONLY_RECORDER}, m = "invokeSuspend", v = 1)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements q<c<? super R>, Object[], InterfaceC4014c<? super t>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public Object f36582a;

                /* renamed from: b, reason: collision with root package name */
                public int f36583b;

                /* renamed from: c, reason: collision with root package name */
                public /* synthetic */ Object f36584c;

                /* renamed from: d, reason: collision with root package name */
                public /* synthetic */ Object f36585d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ s f36586e;

                /* renamed from: f, reason: collision with root package name */
                public Object f36587f;

                /* renamed from: g, reason: collision with root package name */
                public Object f36588g;

                /* renamed from: h, reason: collision with root package name */
                public int f36589h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(InterfaceC4014c interfaceC4014c, s sVar) {
                    super(3, interfaceC4014c);
                    this.f36586e = sVar;
                }

                @Override // p9.q
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object invoke(c<? super R> cVar, Object[] objArr, InterfaceC4014c<? super t> interfaceC4014c) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c, this.f36586e);
                    anonymousClass2.f36584c = cVar;
                    anonymousClass2.f36585d = objArr;
                    return anonymousClass2.invokeSuspend(t.f7040a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x008c, code lost:
                
                    if (r3.emit(r12, r10) == r2) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
                    /*
                        r11 = this;
                        java.lang.Object r0 = r11.f36584c
                        Xa.c r0 = (Xa.c) r0
                        java.lang.Object r1 = r11.f36585d
                        java.lang.Object[] r1 = (java.lang.Object[]) r1
                        java.lang.Object r2 = f9.C4063a.g()
                        int r3 = r11.f36583b
                        r4 = 2
                        r5 = 1
                        if (r3 == 0) goto L34
                        if (r3 == r5) goto L23
                        if (r3 != r4) goto L1b
                        kotlin.C4849c.b(r12)
                        goto L8f
                    L1b:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L23:
                        java.lang.Object r3 = r11.f36588g
                        java.lang.Object[] r3 = (java.lang.Object[]) r3
                        java.lang.Object r3 = r11.f36587f
                        e9.c r3 = (e9.InterfaceC4014c) r3
                        java.lang.Object r3 = r11.f36582a
                        Xa.c r3 = (Xa.c) r3
                        kotlin.C4849c.b(r12)
                        r10 = r11
                        goto L73
                    L34:
                        kotlin.C4849c.b(r12)
                        r12 = r5
                        p9.s r5 = r11.f36586e
                        r3 = 0
                        r6 = r1[r3]
                        r7 = r1[r12]
                        r8 = r1[r4]
                        r9 = 3
                        r9 = r1[r9]
                        java.lang.Object r10 = g9.h.a(r0)
                        r11.f36584c = r10
                        java.lang.Object r10 = g9.h.a(r1)
                        r11.f36585d = r10
                        r11.f36582a = r0
                        java.lang.Object r10 = g9.h.a(r11)
                        r11.f36587f = r10
                        java.lang.Object r10 = g9.h.a(r1)
                        r11.f36588g = r10
                        r11.f36589h = r3
                        r11.f36583b = r12
                        r12 = 6
                        kotlin.jvm.internal.n.c(r12)
                        r10 = r11
                        java.lang.Object r12 = r5.invoke(r6, r7, r8, r9, r10)
                        r11 = 7
                        kotlin.jvm.internal.n.c(r11)
                        if (r12 != r2) goto L72
                        goto L8e
                    L72:
                        r3 = r0
                    L73:
                        java.lang.Object r11 = g9.h.a(r0)
                        r10.f36584c = r11
                        java.lang.Object r11 = g9.h.a(r1)
                        r10.f36585d = r11
                        r11 = 0
                        r10.f36582a = r11
                        r10.f36587f = r11
                        r10.f36588g = r11
                        r10.f36583b = r4
                        java.lang.Object r11 = r3.emit(r12, r10)
                        if (r11 != r2) goto L8f
                    L8e:
                        return r2
                    L8f:
                        Y8.t r11 = Y8.t.f7040a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c cVar, InterfaceC4014c interfaceC4014c) {
                Object objA = CombineKt.a(cVar, bVarArr, FlowKt__ZipKt.g(), new AnonymousClass2(null, sVar), interfaceC4014c);
                return objA == C4063a.g() ? objA : t.f7040a;
            }
        };
    }

    public static final <T1, T2, T3, R> Xa.b<R> d(Xa.b<? extends T1> bVar, Xa.b<? extends T2> bVar2, Xa.b<? extends T3> bVar3, final r<? super T1, ? super T2, ? super T3, ? super InterfaceC4014c<? super R>, ? extends Object> rVar) {
        final Xa.b[] bVarArr = {bVar, bVar2, bVar3};
        return new Xa.b<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "", "it", "LY8/t;", "<anonymous>", "(LXa/c;Lkotlin/Array;)V"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", l = {329, CustomCameraView.BUTTON_STATE_ONLY_RECORDER}, m = "invokeSuspend", v = 1)
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements q<c<? super R>, Object[], InterfaceC4014c<? super t>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public Object f36572a;

                /* renamed from: b, reason: collision with root package name */
                public int f36573b;

                /* renamed from: c, reason: collision with root package name */
                public /* synthetic */ Object f36574c;

                /* renamed from: d, reason: collision with root package name */
                public /* synthetic */ Object f36575d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ r f36576e;

                /* renamed from: f, reason: collision with root package name */
                public Object f36577f;

                /* renamed from: g, reason: collision with root package name */
                public Object f36578g;

                /* renamed from: h, reason: collision with root package name */
                public int f36579h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(InterfaceC4014c interfaceC4014c, r rVar) {
                    super(3, interfaceC4014c);
                    this.f36576e = rVar;
                }

                @Override // p9.q
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object invoke(c<? super R> cVar, Object[] objArr, InterfaceC4014c<? super t> interfaceC4014c) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c, this.f36576e);
                    anonymousClass2.f36574c = cVar;
                    anonymousClass2.f36575d = objArr;
                    return anonymousClass2.invokeSuspend(t.f7040a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:
                
                    if (r3.emit(r11, r10) == r2) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
                    /*
                        r10 = this;
                        java.lang.Object r0 = r10.f36574c
                        Xa.c r0 = (Xa.c) r0
                        java.lang.Object r1 = r10.f36575d
                        java.lang.Object[] r1 = (java.lang.Object[]) r1
                        java.lang.Object r2 = f9.C4063a.g()
                        int r3 = r10.f36573b
                        r4 = 2
                        r5 = 1
                        if (r3 == 0) goto L32
                        if (r3 == r5) goto L22
                        if (r3 != r4) goto L1a
                        kotlin.C4849c.b(r11)
                        goto L88
                    L1a:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L22:
                        java.lang.Object r3 = r10.f36578g
                        java.lang.Object[] r3 = (java.lang.Object[]) r3
                        java.lang.Object r3 = r10.f36577f
                        e9.c r3 = (e9.InterfaceC4014c) r3
                        java.lang.Object r3 = r10.f36572a
                        Xa.c r3 = (Xa.c) r3
                        kotlin.C4849c.b(r11)
                        goto L6c
                    L32:
                        kotlin.C4849c.b(r11)
                        p9.r r11 = r10.f36576e
                        r3 = 0
                        r6 = r1[r3]
                        r7 = r1[r5]
                        r8 = r1[r4]
                        java.lang.Object r9 = g9.h.a(r0)
                        r10.f36574c = r9
                        java.lang.Object r9 = g9.h.a(r1)
                        r10.f36575d = r9
                        r10.f36572a = r0
                        java.lang.Object r9 = g9.h.a(r10)
                        r10.f36577f = r9
                        java.lang.Object r9 = g9.h.a(r1)
                        r10.f36578g = r9
                        r10.f36579h = r3
                        r10.f36573b = r5
                        r3 = 6
                        kotlin.jvm.internal.n.c(r3)
                        java.lang.Object r11 = r11.invoke(r6, r7, r8, r10)
                        r3 = 7
                        kotlin.jvm.internal.n.c(r3)
                        if (r11 != r2) goto L6b
                        goto L87
                    L6b:
                        r3 = r0
                    L6c:
                        java.lang.Object r0 = g9.h.a(r0)
                        r10.f36574c = r0
                        java.lang.Object r0 = g9.h.a(r1)
                        r10.f36575d = r0
                        r0 = 0
                        r10.f36572a = r0
                        r10.f36577f = r0
                        r10.f36578g = r0
                        r10.f36573b = r4
                        java.lang.Object r10 = r3.emit(r11, r10)
                        if (r10 != r2) goto L88
                    L87:
                        return r2
                    L88:
                        Y8.t r10 = Y8.t.f7040a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c cVar, InterfaceC4014c interfaceC4014c) {
                Object objA = CombineKt.a(cVar, bVarArr, FlowKt__ZipKt.g(), new AnonymousClass2(null, rVar), interfaceC4014c);
                return objA == C4063a.g() ? objA : t.f7040a;
            }
        };
    }

    public static final <T1, T2, R> Xa.b<R> e(Xa.b<? extends T1> bVar, Xa.b<? extends T2> bVar2, q<? super T1, ? super T2, ? super InterfaceC4014c<? super R>, ? extends Object> qVar) {
        return d.C(bVar, bVar2, qVar);
    }

    public static final <T1, T2, R> Xa.b<R> f(Xa.b<? extends T1> bVar, Xa.b<? extends T2> bVar2, q<? super T1, ? super T2, ? super InterfaceC4014c<? super R>, ? extends Object> qVar) {
        return new a(bVar, bVar2, qVar);
    }

    public static final <T> InterfaceC5063a<T[]> g() {
        return b.f36603a;
    }
}
