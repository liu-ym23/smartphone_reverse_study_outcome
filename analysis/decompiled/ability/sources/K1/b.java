package K1;

import D9.n;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import u1.d;
import x.c;
import x.j;
import x.o;

/* loaded from: classes2.dex */
public abstract class b implements j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f904a;
    public final Object b;

    public b(Context context, a aVar) {
        this.f904a = context;
        this.b = aVar;
    }

    public abstract o a();

    public abstract Intent b(Context context);

    @Override // x.j
    public n c(Context context) {
        String str = (String) new d(context, b(context), a()).j();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        n nVar = new n();
        nVar.f443a = str;
        return nVar;
    }

    @Override // x.j
    public boolean g(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) ((c) this.b).b(context)).booleanValue();
    }

    public b(String str) {
        this.b = new c(this);
        this.f904a = str;
    }
}
