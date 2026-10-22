package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.M;
import Y8.t;
import android.util.Log;
import androidx.camera.core.ImageCapture;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import t.C5473b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.FlashControl$applyScreenFlash$2", f = "FlashControl.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class FlashControl$applyScreenFlash$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9774a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f9775b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlashControl f9776c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ImageCapture.i f9777d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashControl$applyScreenFlash$2(long j10, FlashControl flashControl, ImageCapture.i iVar, InterfaceC4014c<? super FlashControl$applyScreenFlash$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9775b = j10;
        this.f9776c = flashControl;
        this.f9777d = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FlashControl$applyScreenFlash$2(this.f9775b, this.f9776c, this.f9777d, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FlashControl$applyScreenFlash$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f9774a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        long jCurrentTimeMillis = System.currentTimeMillis() + this.f9775b;
        ImageCapture.h hVarK = this.f9776c.get_screenFlash();
        if (hVarK != null) {
            hVarK.a(jCurrentTimeMillis, this.f9777d);
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "applyScreenFlash: ScreenFlash.apply() invoked, expirationTimeMillis = " + jCurrentTimeMillis);
        }
        return t.f7040a;
    }
}
