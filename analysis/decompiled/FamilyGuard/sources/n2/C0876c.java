package n2;

import C4.G;
import android.text.TextUtils;
import com.stepos.familyguard.encrypt.AESUtils;
import f2.C0702g;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import l0.AbstractC0822a;
import o0.EnumC0889b;

/* renamed from: n2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0876c<T> implements R4.f<G, T> {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f18915c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f18916d;

    /* renamed from: a, reason: collision with root package name */
    private final Type f18917a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18918b;

    C0876c(String str, Type type) {
        this.f18918b = str;
        this.f18917a = type;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strTrim = str.trim();
        return strTrim.startsWith("{") && strTrim.endsWith("}");
    }

    @Override // R4.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(G g5) {
        i iVar;
        try {
            try {
                if (!f18915c) {
                    synchronized (C0876c.class) {
                        try {
                            if (!f18915c) {
                                Field[] declaredFields = g5.getClass().getDeclaredFields();
                                int length = declaredFields.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        break;
                                    }
                                    Field field = declaredFields[i5];
                                    if (field.getType() == G.class) {
                                        f18916d = field;
                                        field.setAccessible(true);
                                        break;
                                    }
                                    i5++;
                                }
                                f18915c = true;
                            }
                        } finally {
                        }
                    }
                }
                Field field2 = f18916d;
                if (field2 != null) {
                    try {
                        iVar = (i) field2.get(g5);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                } else {
                    iVar = null;
                }
                String strX = g5.x();
                if (iVar != null && iVar.C()) {
                    String strA = AESUtils.a(strX);
                    if ((TextUtils.isEmpty(strA) || !c(strA)) && c(strX)) {
                        C0702g.O(this.f18918b, "AES decode empty/invalid, fallback to plaintext json");
                    } else {
                        strX = strA;
                    }
                }
                if (iVar != null) {
                    C0702g.y(this.f18918b, "(" + iVar.A() + ") <-- RESULT: " + strX);
                }
                T t5 = (T) AbstractC0822a.B(strX, this.f18917a, new EnumC0889b[0]);
                g5.close();
                return t5;
            } finally {
                g5.close();
            }
        } catch (IOException e7) {
            throw e7;
        } catch (Exception e8) {
            throw new IOException(e8);
        }
    }
}
