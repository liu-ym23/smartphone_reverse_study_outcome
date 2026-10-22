package m;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ int f8023a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int f8024b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ WeakReference f8025c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ s0 f8026d;

    public final void a(int i) {
        Handler handler = new Handler(Looper.getMainLooper());
        e3.j jVar = new e3.j(0);
        VarHandle.storeStoreFence();
        handler.post(jVar);
    }

    public final void b(Typeface typeface) {
        Handler handler = new Handler(Looper.getMainLooper());
        androidx.room.a0 a0Var = new androidx.room.a0(1);
        a0Var.f1506f = this;
        a0Var.f1507g = typeface;
        VarHandle.storeStoreFence();
        handler.post(a0Var);
    }

    public final void c(Typeface typeface) {
        int i = this.f8023a;
        if (i != -1) {
            typeface = r0.a(typeface, i, (this.f8024b & 2) != 0);
        }
        s0 s0Var = this.f8026d;
        WeakReference weakReference = this.f8025c;
        if (s0Var.f8074m) {
            s0Var.f8073l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                boolean zIsAttachedToWindow = textView.isAttachedToWindow();
                int i3 = s0Var.f8071j;
                if (!zIsAttachedToWindow) {
                    textView.setTypeface(typeface, i3);
                    return;
                }
                androidx.activity.h hVar = new androidx.activity.h(3);
                hVar.f679h = textView;
                hVar.f678g = typeface;
                hVar.f677f = i3;
                VarHandle.storeStoreFence();
                textView.post(hVar);
            }
        }
    }
}
