package b;

import android.content.Intent;
import android.content.IntentSender;
import b.k;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3015a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3016b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3017c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f3018d;

    public /* synthetic */ m(k.f fVar, int i10, IntentSender.SendIntentException sendIntentException) {
        this.f3017c = fVar;
        this.f3016b = i10;
        this.f3018d = sendIntentException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3015a) {
            case 0:
                ((k.f) this.f3017c).a(this.f3016b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f3018d));
                break;
            default:
                ((ModelManagerFragment) this.f3017c).onConfirmFlowEnded((String) this.f3018d, this.f3016b);
                break;
        }
    }

    public /* synthetic */ m(ModelManagerFragment modelManagerFragment, String str, int i10) {
        this.f3017c = modelManagerFragment;
        this.f3018d = str;
        this.f3016b = i10;
    }
}
