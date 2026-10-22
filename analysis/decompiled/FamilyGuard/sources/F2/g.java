package F2;

import Z.g;
import android.content.ContentValues;
import android.content.Context;
import com.stepos.minor.MinorDataBase;
import com.stepos.minor.state.MinorStateEntity;
import d0.InterfaceC0647b;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    private static g f1679b;

    /* renamed from: a, reason: collision with root package name */
    private final MinorDataBase f1680a;

    class a extends g.b {
        a() {
        }

        @Override // Z.g.b
        public void a(InterfaceC0647b interfaceC0647b) {
            super.a(interfaceC0647b);
            interfaceC0647b.g();
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", Integer.valueOf(I2.a.INIT.ordinal()));
            interfaceC0647b.M(MinorStateEntity.TABLE_NAME, 1, contentValues);
            contentValues.clear();
            interfaceC0647b.B();
            interfaceC0647b.P();
        }
    }

    private g(Context context) {
        this.f1680a = (MinorDataBase) Z.f.a(context, MinorDataBase.class, "minor.db").a(new a()).c();
    }

    public static synchronized g a(Context context) {
        try {
            if (f1679b == null) {
                f1679b = new g(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f1679b;
    }

    public MinorDataBase b() {
        return this.f1680a;
    }
}
