package r3;

import android.content.Context;
import android.content.SharedPreferences;
import h3.C4127c;
import h3.C4139o;
import h3.InterfaceC4128d;
import h3.InterfaceC4131g;
import java.util.UUID;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: b, reason: collision with root package name */
    public static final C4127c<?> f38800b = C4127c.a(l.class).b(C4139o.g(C5214h.class)).b(C4139o.g(Context.class)).d(new InterfaceC4131g() { // from class: r3.C
        @Override // h3.InterfaceC4131g
        public final Object a(InterfaceC4128d interfaceC4128d) {
            return new l((Context) interfaceC4128d.get(Context.class));
        }
    }).c();

    /* renamed from: a, reason: collision with root package name */
    public final Context f38801a;

    public l(Context context) {
        this.f38801a = context;
    }

    public synchronized String a() {
        String string = b().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        b().edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }

    public final SharedPreferences b() {
        return this.f38801a.getSharedPreferences("com.google.mlkit.internal", 0);
    }
}
