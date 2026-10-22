package androidx.datastore.preferences.protobuf;

import android.graphics.Path;
import android.graphics.Typeface;
import com.stepos.core.ota.domain.OtaAction;
import java.util.List;
import k5.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a.C0099a f1806a;

    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        if (str.length() == 2) {
            return str.charAt(0) + OtaAction.GLOBAL;
        }
        return str.charAt(0) + OtaAction.GLOBAL + str.substring(str.length() - 1);
    }

    public abstract void b(vc.j jVar);

    public abstract pc.a c(ec.c cVar, List list);

    public abstract Path d(float f8, float f9, float f10, float f11);

    public abstract pc.c e(ec.c cVar, Object obj);

    public abstract float f(Object obj);

    public abstract void g(int i10);

    public abstract void h(Typeface typeface, boolean z);

    public abstract void i(Object obj, float f8);

    public abstract void j(byte[] bArr, int i10, int i11);
}
