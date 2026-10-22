package aec;

import aec.e;
import android.content.MutableContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.widget.recyclerview.hive.HiveAdapter;
import com.ss.android.lark.widget.recyclerview.hive.HiveViewHolder;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<Value, VH extends e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Constructor<VH> f3126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f<Value> f3127b;

    public abstract int b();

    public abstract void c(VH r100, Value r101);

    public void g(VH r100) {
    }

    public VH f() {
    L7:
        e = move-exception;
        e.printStackTrace();
        throw new IllegalStateException(e.getMessage());
    L3:
        if (this.f3126a != null) goto L5;
        Constructor<VH> r100 = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]).getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L7
        this.f3126a = r100;     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
    L5:
        return this.f3126a.newInstance(new Object[0]);
    }

    public int h() {
        return getClass().hashCode();
    }

    public a() {
    }

    public final View a(ViewGroup r100) {
        if (b() > 0) goto L7;
        return null;
    L7:
        if ((r100.getContext() instanceof dwa.d) == false) goto L11;
        return ((dwa.d) r100.getContext()).Ey().a(r100.getContext(), b(), r100);
    L11:
        if ((r100.getContext() instanceof MutableContextWrapper) == false) goto L17;
        if ((((MutableContextWrapper) r100.getContext()).getBaseContext() instanceof dwa.d) == false) goto L17;
        return ((dwa.d) ((MutableContextWrapper) r100.getContext()).getBaseContext()).Ey().a(r100.getContext(), b(), r100);
    L17:
        return LayoutInflater.from(r100.getContext()).inflate(b(), r100, false);
    }

    public final void d(e r100) {
        f<Value> r101 = this.f3127b;
        if (r101 == null) goto L8;
        b r102 = (b) r101;
        HiveViewHolder r103 = HiveAdapter.z2(r100.f3132a);
        if (r103 == null) goto L9;
        r102.f3128a.d((d) r103.f448186a);
        return;
    L9:
        return;
    }

    public final boolean e(e r100) {
        f<Value> r101 = this.f3127b;
        if (r101 == null) goto L7;
        b r102 = (b) r101;
        HiveViewHolder r103 = HiveAdapter.z2(r100.f3132a);
        if (r103 == null) goto L7;
        return r102.f3128a.e((d) r103.f448186a);
    L7:
        return false;
    }
}
