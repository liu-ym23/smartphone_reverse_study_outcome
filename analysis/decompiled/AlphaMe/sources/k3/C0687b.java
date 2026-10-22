package k3;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import kotlin.Unit;
import stepos.support.v7.widget.y0;

/* renamed from: k3.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0687b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13340a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0687b() {
        this(1);
        this.f13340a = 1;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws NoSuchMethodException, SecurityException {
        C0690e c0690eA;
        switch (this.f13340a) {
            case 0:
                break;
            default:
                if (y0.f15252b == null) {
                    try {
                        Method method = View.class.getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        y0.f15252b = method;
                    } catch (NoSuchMethodException unused) {
                        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                    }
                }
                if (y0.f15251a == null) {
                    try {
                        Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                        y0.f15251a = declaredMethod;
                        if (!declaredMethod.isAccessible()) {
                            y0.f15251a.setAccessible(true);
                        }
                    } catch (NoSuchMethodException unused2) {
                        Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                    }
                }
                y0.f15253c = 2;
                return;
        }
        while (true) {
            try {
                synchronized (C0690e.class) {
                    C0690e.Companion.getClass();
                    c0690eA = C0686a.a();
                    if (c0690eA == C0690e.head) {
                        C0690e.head = null;
                        return;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (c0690eA != null) {
                    c0690eA.timedOut();
                }
            } catch (InterruptedException unused3) {
                continue;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0687b(int i4) {
        super("Okio Watchdog");
        this.f13340a = i4;
        if (i4 != 1) {
            setDaemon(true);
        }
    }
}
