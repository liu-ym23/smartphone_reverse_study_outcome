package bd;

import androidx.datastore.preferences.protobuf.b1;
import gc.q;
import java.util.ArrayList;
import okhttp3.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static final void a(f.a aVar, String name, String value) {
        kotlin.jvm.internal.g.f(aVar, "<this>");
        kotlin.jvm.internal.g.f(name, "name");
        kotlin.jvm.internal.g.f(value, "value");
        ArrayList arrayList = aVar.f10976a;
        arrayList.add(name);
        arrayList.add(q.L0(value).toString());
    }

    public static final void b(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        if (name.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = name.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = name.charAt(i10);
            if ('!' > cCharAt || cCharAt >= 127) {
                StringBuilder sb2 = new StringBuilder("Unexpected char 0x");
                b1.l(16);
                String string = Integer.toString(cCharAt, 16);
                kotlin.jvm.internal.g.e(string, "toString(...)");
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                com.stepos.core.ota.d.o(i10, string, " at ", " in header name: ", sb2);
                sb2.append(name);
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }

    public static final void c(String value, String name) {
        kotlin.jvm.internal.g.f(value, "value");
        kotlin.jvm.internal.g.f(name, "name");
        int length = value.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = value.charAt(i10);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb2 = new StringBuilder("Unexpected char 0x");
                b1.l(16);
                String string = Integer.toString(cCharAt, 16);
                kotlin.jvm.internal.g.e(string, "toString(...)");
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                com.stepos.core.ota.d.o(i10, string, " at ", " in ", sb2);
                sb2.append(name);
                sb2.append(" value");
                sb2.append(i.k(name) ? "" : ": ".concat(value));
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }
}
