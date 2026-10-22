package o8;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f7831a = new m();

    public static final c0 a(String str, String str2, String str3, String str4) {
        ArrayList arrayList = f0.f7814a;
        e9.f fVarE = e9.f.e(str2);
        String str5 = str2 + '(' + str3 + ')' + str4;
        q7.k.e(str, "internalName");
        q7.k.e(str5, "jvmDescriptor");
        return new c0(fVarE, str + '.' + str5);
    }
}
