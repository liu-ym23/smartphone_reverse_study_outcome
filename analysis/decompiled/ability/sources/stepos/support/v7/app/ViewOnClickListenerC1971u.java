package stepos.support.v7.app;

import android.os.Message;
import android.view.View;

/* renamed from: stepos.support.v7.app.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnClickListenerC1971u implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6340a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ViewOnClickListenerC1971u(Object obj, int i) {
        this.f6340a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, stepos.support.v7.app.l] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        switch (this.f6340a) {
            case 0:
                AbstractC1975y abstractC1975y = (AbstractC1975y) this.b;
                ?? r22 = abstractC1975y.e;
                if (!abstractC1975y.o) {
                    r22.onBackTopTouch();
                    break;
                }
                break;
            default:
                Z z10 = (Z) this.b;
                Message messageObtain = (view != z10.p || (message3 = z10.f6283r) == null) ? (view != z10.f6285t || (message2 = z10.f6286v) == null) ? (view != z10.f6288x || (message = z10.f6289z) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                z10.f6264R.obtainMessage(1, z10.d).sendToTarget();
                break;
        }
    }
}
