package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import com.zyql.ai.selector.config.PictureConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import t.C5473b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.FlashControl$applyScreenFlash$3", f = "FlashControl.kt", l = {PictureConfig.CHOOSE_REQUEST}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class FlashControl$applyScreenFlash$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9778a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1083u<t> f9779b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f9780c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashControl$applyScreenFlash$3(InterfaceC1083u<t> interfaceC1083u, long j10, InterfaceC4014c<? super FlashControl$applyScreenFlash$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9779b = interfaceC1083u;
        this.f9780c = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FlashControl$applyScreenFlash$3(this.f9779b, this.f9780c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FlashControl$applyScreenFlash$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9778a;
        if (i10 == 0) {
            C4849c.b(obj);
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "applyScreenFlash: Waiting for ScreenFlashListener to be completed");
            }
            InterfaceC1083u<t> interfaceC1083u = this.f9779b;
            long j10 = this.f9780c;
            this.f9778a = 1;
            obj = CoroutineAdaptersKt.o(interfaceC1083u, j10, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "applyScreenFlash: ScreenFlashListener completed");
            }
        } else {
            C5473b c5473b3 = C5473b.f41865a;
            long j11 = this.f9780c;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "applyScreenFlash: ScreenFlashListener completion timed out after " + j11 + " ms");
            }
        }
        return t.f7040a;
    }
}
