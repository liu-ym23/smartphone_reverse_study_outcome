package a4;

import android.text.TextPaint;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public int f167a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f168b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f169c;

    public f(i iVar) {
        this.f167a = 0;
        c cVar = new c();
        TextPaint textPaint = new TextPaint();
        cVar.f162a = textPaint;
        textPaint.setTextSize(10.0f);
        VarHandle.storeStoreFence();
        this.f169c = cVar;
        this.f168b = iVar;
    }

    public abstract void a(x4.a aVar);

    public abstract void b(x4.a aVar);

    public abstract void c(x4.a aVar);

    public abstract void d(x4.a aVar);

    public abstract void e(x4.a aVar);

    public abstract void f(x4.a aVar);

    public abstract androidx.room.v g(x4.a aVar);

    public f(int i, String str, String str2) {
        this.f167a = i;
        this.f168b = str;
        this.f169c = str2;
    }
}
