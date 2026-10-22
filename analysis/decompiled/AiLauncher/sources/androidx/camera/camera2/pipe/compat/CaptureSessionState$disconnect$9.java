package androidx.camera.camera2.pipe.compat;

import android.os.Trace;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$9", f = "CaptureSessionState.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CaptureSessionState$disconnect$9 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10503a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaptureSessionState f10504b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ A.h f10505c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureSessionState$disconnect$9(CaptureSessionState captureSessionState, A.h hVar, InterfaceC4014c<? super CaptureSessionState$disconnect$9> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f10504b = captureSessionState;
        this.f10505c = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new CaptureSessionState$disconnect$9(this.f10504b, this.f10505c, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((CaptureSessionState$disconnect$9) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10503a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        z.h hVar = z.h.f44503a;
        String str = this.f10504b + " stopRepeating";
        A.h hVar2 = this.f10505c;
        try {
            Trace.beginSection(str);
            hVar2.f();
            Y8.t tVar = Y8.t.f7040a;
            Trace.endSection();
            String str2 = this.f10504b + " abortCaptures";
            A.h hVar3 = this.f10505c;
            try {
                Trace.beginSection(str2);
                hVar3.a();
                Trace.endSection();
                return Y8.t.f7040a;
            } finally {
            }
        } finally {
        }
    }
}
