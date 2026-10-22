package androidx.camera.camera2.pipe.graph;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.Controller3A", f = "Controller3A.kt", l = {373}, m = "lock3A-Qz1gx5w", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Controller3A$lock3A$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10838a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10839b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10840c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10841d;

    /* renamed from: e, reason: collision with root package name */
    public Object f10842e;

    /* renamed from: f, reason: collision with root package name */
    public Object f10843f;

    /* renamed from: g, reason: collision with root package name */
    public Object f10844g;

    /* renamed from: h, reason: collision with root package name */
    public int f10845h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f10846i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Controller3A f10847j;

    /* renamed from: k, reason: collision with root package name */
    public int f10848k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Controller3A$lock3A$1(Controller3A controller3A, InterfaceC4014c<? super Controller3A$lock3A$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10847j = controller3A;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10846i = obj;
        this.f10848k |= Integer.MIN_VALUE;
        return this.f10847j.i(null, null, null, null, null, null, null, null, null, 0, null, null, this);
    }
}
