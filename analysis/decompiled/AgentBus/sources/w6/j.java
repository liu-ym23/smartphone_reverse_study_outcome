package w6;

import android.content.Context;
import com.stepos.cloud.securedata.SecureDataEnvironment;
import java.util.Locale;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final s2.f f10806a;

    public j(Context context) {
        Context applicationContext = context.getApplicationContext();
        q7.k.d(applicationContext, "getApplicationContext(...)");
        this.f10806a = k.access$getPublicKeyDataStore(applicationContext);
    }

    public static w2.d a(SecureDataEnvironment secureDataEnvironment, String str) {
        String lowerCase = secureDataEnvironment.name().toLowerCase(Locale.ROOT);
        q7.k.d(lowerCase, "toLowerCase(...)");
        String str2 = "public_key_" + lowerCase + "_" + str;
        q7.k.e(str2, "name");
        return new w2.d(str2);
    }

    public static final /* synthetic */ w2.d access$publicKeyKey(j jVar, SecureDataEnvironment secureDataEnvironment, String str) {
        jVar.getClass();
        return a(secureDataEnvironment, str);
    }
}
