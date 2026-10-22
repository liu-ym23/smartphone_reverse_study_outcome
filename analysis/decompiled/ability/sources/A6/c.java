package A6;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.stepos.common.widget.J;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f111a;
    public WeakReference b;

    public /* synthetic */ c(int i) {
        this.f111a = i;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        switch (this.f111a) {
            case 0:
                kotlin.jvm.internal.k.f(msg, "msg");
                int i = msg.what;
                if (i != -3 && i != -2 && i != -1) {
                    if (i == 1) {
                        Object obj = msg.obj;
                        DialogInterface dialogInterface = obj instanceof DialogInterface ? (DialogInterface) obj : null;
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                            break;
                        }
                    }
                } else {
                    DialogInterface dialogInterface2 = (DialogInterface) this.b.get();
                    if (dialogInterface2 != null) {
                        Object obj2 = msg.obj;
                        DialogInterface.OnClickListener onClickListener = obj2 instanceof DialogInterface.OnClickListener ? (DialogInterface.OnClickListener) obj2 : null;
                        if (onClickListener != null) {
                            onClickListener.onClick(dialogInterface2, msg.what);
                            break;
                        }
                    }
                }
                break;
            case 1:
                J j5 = (J) this.b.get();
                if (j5 != null) {
                    j5.d.computeScrollOffset();
                    int currY = j5.d.getCurrY();
                    int i6 = j5.e - currY;
                    j5.e = currY;
                    j5.f3718a.d(i6);
                    if (Math.abs(currY - j5.d.getFinalY()) < 1) {
                        j5.d.forceFinished(true);
                    }
                    if (!j5.d.isFinished()) {
                        int i10 = msg.what;
                        if (i10 == 1 || i10 == 0) {
                            j5.h.sendEmptyMessage(i10);
                            break;
                        }
                    } else if (msg.what != 0) {
                        j5.a();
                        break;
                    } else {
                        j5.b();
                        break;
                    }
                }
                break;
            case 2:
                int i11 = msg.what;
                if (i11 != -3 && i11 != -2 && i11 != -1) {
                    if (i11 == 1) {
                        ((DialogInterface) msg.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) msg.obj).onClick((DialogInterface) this.b.get(), msg.what);
                    break;
                }
                break;
            default:
                int i12 = msg.what;
                if (i12 != -3 && i12 != -2 && i12 != -1) {
                    if (i12 == 1) {
                        ((DialogInterface) msg.obj).dismiss();
                        break;
                    }
                } else {
                    ((DialogInterface.OnClickListener) msg.obj).onClick((DialogInterface) this.b.get(), msg.what);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar) {
        super(Looper.getMainLooper());
        this.f111a = 0;
        this.b = new WeakReference(gVar);
    }

    public c(J j5) {
        this.f111a = 1;
        this.b = new WeakReference(j5);
    }
}
