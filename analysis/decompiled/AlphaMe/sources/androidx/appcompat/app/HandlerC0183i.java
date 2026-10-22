package androidx.appcompat.app;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.app.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerC0183i extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2617a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f2618b;

    public HandlerC0183i(DialogInterface dialogInterface, int i4) {
        this.f2617a = i4;
        if (i4 == 1) {
            this.f2618b = new WeakReference(dialogInterface);
        } else if (i4 != 2) {
            this.f2618b = new WeakReference(dialogInterface);
        } else {
            this.f2618b = new WeakReference(dialogInterface);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (this.f2617a) {
            case 0:
                int i4 = message.what;
                if (i4 != -3 && i4 != -2 && i4 != -1) {
                    if (i4 == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f2618b.get(), message.what);
                    break;
                }
                break;
            case 1:
                int i5 = message.what;
                if (i5 != -3 && i5 != -2 && i5 != -1) {
                    if (i5 == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f2618b.get(), message.what);
                    break;
                }
                break;
            default:
                int i6 = message.what;
                if (i6 != -3 && i6 != -2 && i6 != -1) {
                    if (i6 == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f2618b.get(), message.what);
                    break;
                }
                break;
        }
    }
}
