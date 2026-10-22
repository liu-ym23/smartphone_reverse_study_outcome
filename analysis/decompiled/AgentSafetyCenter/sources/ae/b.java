package ae;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.invoke.VarHandle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import od.f;
import p.f0;
import p.g0;
import p.j0;
import p.n0;
import p.o0;
import p.z;
import v1.e1;
import v1.f1;
import v1.m0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f645a;

    public /* synthetic */ b(int i) {
        this.f645a = i;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f645a) {
            case 0:
                return new char[1024];
            case 1:
                return new Random();
            case 2:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(bd.b.f2078e);
                return simpleDateFormat;
            case 3:
                try {
                    return MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                    f.e("no md5 algorythm found");
                    return null;
                }
            case 4:
                Choreographer choreographer = Choreographer.getInstance();
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    m0 m0Var = new m0(choreographer, Handler.createAsync(looperMyLooper));
                    return m0Var.plus(m0Var.f14502o);
                }
                f.e("no Looper on this thread");
                return null;
            default:
                f1 f1Var = new f1();
                f1Var.f14417a = new Rect();
                f1Var.f14418b = new Rect();
                f1Var.f14419c = new Rect();
                e1 e1Var = new e1();
                long[] jArr = n0.f9597a;
                e1Var.f14408c = new f0();
                int i = o0.f9601a;
                e1Var.f14409f = new g0();
                e1Var.f14410g = new f0();
                z zVar = j0.f9585a;
                e1Var.f14411h = new z();
                VarHandle.storeStoreFence();
                f1Var.f14420d = e1Var;
                f1Var.f14421e = new ArrayList();
                VarHandle.storeStoreFence();
                return f1Var;
        }
    }
}
