package h7;

import H4.r;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.k;

/* renamed from: h7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1492b {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f4573a = new Handler(Looper.getMainLooper());

    public static void a(S7.a aVar) {
        if (k.b(Looper.myLooper(), Looper.getMainLooper())) {
            aVar.invoke();
        } else {
            f4573a.post(new r(7, aVar));
        }
    }
}
