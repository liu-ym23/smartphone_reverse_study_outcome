package d1;

import android.text.TextUtils;
import b1.C0821b;
import f1.C1431a;
import java.util.concurrent.CopyOnWriteArraySet;
import m1.AbstractC1673a;

/* loaded from: classes2.dex */
public final class e extends AbstractC1673a {

    /* renamed from: a, reason: collision with root package name */
    public volatile c1.b f4286a;
    public C1431a b;

    public final void a(C0821b c0821b) {
        c1.b bVar = this.f4286a;
        synchronized (bVar) {
            if (!bVar.f2081a && bVar.b) {
                bVar.g = c0821b;
                bVar.f2081a = true;
                String strR = S0.b.r(((CopyOnWriteArraySet) Z0.a.C().f1582a).toArray());
                if (TextUtils.isEmpty(strR)) {
                    strR = "";
                }
                S0.b.i = strR;
                bVar.c = true ^ bVar.d.e;
                synchronized (bVar) {
                    bVar.a(bVar.h);
                }
            }
        }
    }

    @Override // m1.AbstractC1673a, m1.b
    public final void b() {
        this.f4286a.b(true);
    }

    @Override // m1.AbstractC1673a, m1.b
    public final void c() {
        this.f4286a.b(false);
    }
}
