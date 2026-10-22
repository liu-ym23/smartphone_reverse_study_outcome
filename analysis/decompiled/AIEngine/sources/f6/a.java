package f6;

import android.util.Log;
import com.stepos.aiengine.memory.AiModelPressureHandler;
import com.stepos.core.ota.d;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AiModelPressureHandler f8760a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f8761b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8762c;

    public /* synthetic */ a(AiModelPressureHandler aiModelPressureHandler, Ref$IntRef ref$IntRef, int i10) {
        this.f8760a = aiModelPressureHandler;
        this.f8761b = ref$IntRef;
        this.f8762c = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        int iIntValue = this.f8760a.f5791i.invoke().intValue();
        Ref$IntRef ref$IntRef = this.f8761b;
        if (iIntValue < 0 || iIntValue >= ref$IntRef.f10074a) {
            int i10 = ref$IntRef.f10074a;
            if (iIntValue >= i10) {
                Log.i("AiModelPressureHandler", d.e(i10, "[memory] fresh rss not dropping (", iIntValue, " -> ", " MB), keep evicting"));
            }
        } else {
            ref$IntRef.f10074a = iIntValue;
        }
        return Boolean.valueOf(iIntValue >= 0 && iIntValue < this.f8762c);
    }
}
