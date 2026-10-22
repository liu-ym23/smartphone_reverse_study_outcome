package coil.intercept;

import A1.g;
import A1.k;
import D1.b;
import Ua.M;
import Y8.t;
import coil.intercept.EngineInterceptor;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcoil/intercept/EngineInterceptor$b;", "<anonymous>", "(LUa/M;)Lcoil/intercept/EngineInterceptor$b;"}, k = 3, mv = {2, 0, 0})
@InterfaceC4112d(c = "coil.intercept.EngineInterceptor$transform$3", f = "EngineInterceptor.kt", l = {246}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class EngineInterceptor$transform$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super EngineInterceptor.b>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f15755a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15756b;

    /* renamed from: c, reason: collision with root package name */
    public int f15757c;

    /* renamed from: d, reason: collision with root package name */
    public int f15758d;

    /* renamed from: e, reason: collision with root package name */
    public int f15759e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f15760f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f15761g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor.b f15762h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k f15763i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ List<b> f15764j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ coil.b f15765k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ g f15766l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EngineInterceptor$transform$3(EngineInterceptor engineInterceptor, EngineInterceptor.b bVar, k kVar, List<? extends b> list, coil.b bVar2, g gVar, InterfaceC4014c<? super EngineInterceptor$transform$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f15761g = engineInterceptor;
        this.f15762h = bVar;
        this.f15763i = kVar;
        this.f15764j = list;
        this.f15765k = bVar2;
        this.f15766l = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        EngineInterceptor$transform$3 engineInterceptor$transform$3 = new EngineInterceptor$transform$3(this.f15761g, this.f15762h, this.f15763i, this.f15764j, this.f15765k, this.f15766l, interfaceC4014c);
        engineInterceptor$transform$3.f15760f = obj;
        return engineInterceptor$transform$3;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super EngineInterceptor.b> interfaceC4014c) {
        return ((EngineInterceptor$transform$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0073 -> B:13:0x0076). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.f15759e
            r2 = 1
            if (r1 == 0) goto L27
            if (r1 != r2) goto L1f
            int r1 = r10.f15758d
            int r3 = r10.f15757c
            java.lang.Object r4 = r10.f15756b
            A1.k r4 = (A1.k) r4
            java.lang.Object r5 = r10.f15755a
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r10.f15760f
            Ua.M r6 = (Ua.M) r6
            kotlin.C4849c.b(r11)
            goto L76
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L27:
            kotlin.C4849c.b(r11)
            java.lang.Object r11 = r10.f15760f
            Ua.M r11 = (Ua.M) r11
            coil.intercept.EngineInterceptor r1 = r10.f15761g
            coil.intercept.EngineInterceptor$b r3 = r10.f15762h
            android.graphics.drawable.Drawable r3 = r3.getDrawable()
            A1.k r4 = r10.f15763i
            java.util.List<D1.b> r5 = r10.f15764j
            android.graphics.Bitmap r1 = coil.intercept.EngineInterceptor.b(r1, r3, r4, r5)
            coil.b r3 = r10.f15765k
            A1.g r4 = r10.f15766l
            r3.n(r4, r1)
            java.util.List<D1.b> r3 = r10.f15764j
            A1.k r4 = r10.f15763i
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5
            int r5 = r5.size()
            r6 = 0
            r9 = r6
            r6 = r11
            r11 = r1
            r1 = r5
            r5 = r3
            r3 = r9
        L57:
            if (r3 >= r1) goto L7d
            java.lang.Object r7 = r5.get(r3)
            D1.b r7 = (D1.b) r7
            B1.g r8 = r4.getSize()
            r10.f15760f = r6
            r10.f15755a = r5
            r10.f15756b = r4
            r10.f15757c = r3
            r10.f15758d = r1
            r10.f15759e = r2
            java.lang.Object r11 = r7.a(r11, r8, r10)
            if (r11 != r0) goto L76
            return r0
        L76:
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            kotlinx.coroutines.d.g(r6)
            int r3 = r3 + r2
            goto L57
        L7d:
            coil.b r0 = r10.f15765k
            A1.g r1 = r10.f15766l
            r0.i(r1, r11)
            coil.intercept.EngineInterceptor$b r2 = r10.f15762h
            A1.g r10 = r10.f15766l
            android.content.Context r10 = r10.getContext()
            android.content.res.Resources r10 = r10.getResources()
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            r3.<init>(r10, r11)
            r7 = 14
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            coil.intercept.EngineInterceptor$b r10 = coil.intercept.EngineInterceptor.b.b(r2, r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor$transform$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
