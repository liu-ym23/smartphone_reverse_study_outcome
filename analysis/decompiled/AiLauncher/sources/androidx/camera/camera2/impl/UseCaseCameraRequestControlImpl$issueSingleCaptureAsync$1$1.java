package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.Q;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import androidx.camera.core.impl.l;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import t.C5473b;
import t.InterfaceC5495w;
import w.M;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "LUa/Q;", "Ljava/lang/Void;", "<anonymous>", "()Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1", f = "UseCaseCameraRequestControl.kt", l = {530}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super List<? extends Q<? extends Void>>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9936a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9937b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<l> f9938c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9939d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9940e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9941f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, List<l> list, int i10, int i11, int i12, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9937b = useCaseCameraRequestControlImpl;
        this.f9938c = list;
        this.f9939d = i10;
        this.f9940e = i11;
        this.f9941f = i12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1(this.f9937b, this.f9938c, this.f9939d, this.f9940e, this.f9941f, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super List<? extends Q<Void>>> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$issueSingleCaptureAsync$1$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9936a;
        if (i10 == 0) {
            C4849c.b(obj);
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl#issueSingleCaptureAsync");
            }
            if (this.f9937b.H(this.f9938c)) {
                this.f9937b.D(this.f9938c.size(), "Capture request failed due to invalid surface");
            }
            UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.f9937b;
            UseCaseCameraRequestControlImpl.InfoBundle infoBundleI = useCaseCameraRequestControlImpl.I(useCaseCameraRequestControlImpl.infoBundleMap);
            UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl2 = this.f9937b;
            List<l> list = this.f9938c;
            int i11 = this.f9939d;
            int i12 = this.f9940e;
            int i13 = this.f9941f;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControl: Submitting still captures to capture pipeline");
            }
            InterfaceC5495w interfaceC5495wE = useCaseCameraRequestControlImpl2.E();
            M template = infoBundleI.getTemplate();
            p.f(template);
            int value = template.getValue();
            a aVarC = infoBundleI.getOptions().c();
            this.f9936a = 1;
            obj = interfaceC5495wE.c(list, value, aVarC, i11, i12, i13, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return (List) obj;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super List<? extends Q<? extends Void>>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super List<? extends Q<Void>>>) interfaceC4014c);
    }
}
