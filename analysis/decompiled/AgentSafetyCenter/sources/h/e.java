package h;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4781a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f4782b;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (this.f4781a) {
            case 0:
                int i = message.what;
                if (i != -3 && i != -2 && i != -1) {
                    if (i == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f4782b.get(), message.what);
                    break;
                }
                break;
            case 1:
                int i3 = message.what;
                if (i3 != -3 && i3 != -2 && i3 != -1) {
                    if (i3 == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f4782b.get(), message.what);
                    break;
                }
                break;
            default:
                int i10 = message.what;
                if (i10 != -3 && i10 != -2 && i10 != -1) {
                    if (i10 == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f4782b.get(), message.what);
                    break;
                }
                break;
        }
    }
}
