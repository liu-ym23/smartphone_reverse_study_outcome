package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2Backend", f = "Camera2Backend.kt", l = {111, 129}, m = "isConfigSupported-NpXggIU", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2Backend$isConfigSupported$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10233a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10234b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10235c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f10236d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Camera2Backend f10237e;

    /* renamed from: f, reason: collision with root package name */
    public int f10238f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2Backend$isConfigSupported$1(Camera2Backend camera2Backend, InterfaceC4014c<? super Camera2Backend$isConfigSupported$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10237e = camera2Backend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10236d = obj;
        this.f10238f |= Integer.MIN_VALUE;
        return this.f10237e.b(null, this);
    }
}
