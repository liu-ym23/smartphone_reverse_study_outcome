package h6;

import android.util.Log;
import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.aiengine.modelmanager.OtaModelClient;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t implements e6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f9348a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f9349b;

    public t(String str, boolean z) {
        this.f9348a = z;
        this.f9349b = str;
    }

    @Override // e6.a
    public final void onFailed(int i10, String message) {
        kotlin.jvm.internal.g.f(message, "message");
        StringBuilder sb2 = new StringBuilder("resumeFlow[retry=");
        sb2.append(this.f9348a);
        sb2.append("] ");
        String str = this.f9349b;
        sb2.append(str);
        sb2.append(" failed code=");
        sb2.append(i10);
        sb2.append(" msg=");
        sb2.append(message);
        Log.w("OtaModelClient", sb2.toString());
        OtaModelClient.f5871a.getClass();
        OtaModelClient.b(i10, str);
    }

    @Override // e6.a
    public final void onReady(boolean z) {
        OtaModelClient.f5871a.getClass();
        OtaModelClient.b(0, this.f9349b);
    }

    @Override // e6.a
    public final void onStateChanged(ModelFlowStage stage) {
        kotlin.jvm.internal.g.f(stage, "stage");
        Log.i("OtaModelClient", "resumeFlow[retry=" + this.f9348a + "] " + this.f9349b + " stage=" + stage);
    }
}
