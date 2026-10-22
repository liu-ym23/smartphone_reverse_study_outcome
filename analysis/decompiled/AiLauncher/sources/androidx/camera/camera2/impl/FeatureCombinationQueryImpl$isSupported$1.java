package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.M;
import Y8.t;
import Z8.C1174w;
import android.util.Log;
import androidx.camera.camera2.impl.c;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.h;
import androidx.camera.camera2.pipe.k;
import androidx.camera.camera2.pipe.o;
import androidx.camera.camera2.pipe.s;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import t.C5473b;
import w.P;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.FeatureCombinationQueryImpl$isSupported$1", f = "FeatureCombinationQueryImpl.kt", l = {59}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class FeatureCombinationQueryImpl$isSupported$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9754a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeatureCombinationQueryImpl f9755b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c.CameraGraphCreationResult f9756c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureCombinationQueryImpl$isSupported$1(FeatureCombinationQueryImpl featureCombinationQueryImpl, c.CameraGraphCreationResult cameraGraphCreationResult, InterfaceC4014c<? super FeatureCombinationQueryImpl$isSupported$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9755b = featureCombinationQueryImpl;
        this.f9756c = cameraGraphCreationResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FeatureCombinationQueryImpl$isSupported$1(this.f9755b, this.f9756c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((FeatureCombinationQueryImpl$isSupported$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9754a;
        if (i10 == 0) {
            C4849c.b(obj);
            h hVar = this.f9755b.cameraPipe;
            CameraGraph.b config = this.f9756c.getConfig();
            this.f9754a = 1;
            obj = hVar.b(config, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        c.CameraGraphCreationResult cameraGraphCreationResult = this.f9756c;
        o oVar = (o) obj;
        int value = oVar.getValue();
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            String str = C5473b.TRUNCATED_TAG;
            List<k.a> listR = cameraGraphCreationResult.getConfig().r();
            ArrayList arrayList = new ArrayList(C1174w.x(listR, 10));
            Iterator<T> it = listR.iterator();
            while (it.hasNext()) {
                List<s.a> listB = ((k.a) it.next()).b();
                ArrayList arrayList2 = new ArrayList(C1174w.x(listB, 10));
                for (s.a aVar : listB) {
                    arrayList2.add("size=" + aVar.getSize() + ", format=" + ((Object) P.i(aVar.getFormat())) + ", dynamicRangeProfile" + aVar.getDynamicRangeProfile());
                }
                arrayList.add(arrayList2);
            }
            Log.d(str, "FeatureCombinationQueryImpl#isSupported: result = " + ((Object) o.h(value)) + " for sessionParameters = " + cameraGraphCreationResult.getConfig().p() + " and streams = " + arrayList);
        }
        return C4109a.a(o.f(oVar.getValue(), o.INSTANCE.a()));
    }
}
