package D6;

import com.stepos.motionkit.fx.material.MaterialBuilder;
import com.stepos.widget.circlebutton.StepOSCircleButton;
import com.stepos.widget.glass.StepOSGlassImageButton;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f386a;
    public final /* synthetic */ a b;

    public /* synthetic */ j(a aVar, int i) {
        this.f386a = i;
        this.b = aVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f386a;
        a aVar = this.b;
        MaterialBuilder it = (MaterialBuilder) obj;
        switch (i) {
            case 0:
                int i6 = StepOSGlassImageButton.f4106q;
                kotlin.jvm.internal.k.f(it, "it");
                break;
            default:
                int i10 = StepOSCircleButton.f4088F;
                kotlin.jvm.internal.k.f(it, "it");
                break;
        }
        return aVar.a(it);
    }
}
