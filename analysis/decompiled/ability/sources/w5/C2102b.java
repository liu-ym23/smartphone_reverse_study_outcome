package w5;

import C7.f;
import F9.A;
import F9.M;
import F9.z;
import K9.g;
import android.content.Context;
import android.os.Build;
import androidx.core.os.EnvironmentCompat;
import com.uxsense.ApexSDK;
import java.util.Locale;
import kotlin.jvm.internal.k;

/* renamed from: w5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2102b implements A {

    /* renamed from: a, reason: collision with root package name */
    public final String f6850a;
    public final Context b;
    public final f c;
    public final f d;

    public C2102b(Context context) {
        k.f(context, "context");
        this.f6850a = "Android";
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
        final int i = 0;
        this.c = kotlin.a.a(new S7.a(this) { // from class: w5.a
            public final /* synthetic */ C2102b b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                C2102b c2102b = this.b;
                switch (i6) {
                    case 0:
                        Context context2 = c2102b.b;
                        k.f(context2, "context");
                        String str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                        return str == null ? ApexSDK.VERSION : str;
                    default:
                        Context context3 = c2102b.b;
                        k.f(context3, "context");
                        return String.valueOf(context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0).versionCode);
                }
            }
        });
        final int i6 = 1;
        this.d = kotlin.a.a(new S7.a(this) { // from class: w5.a
            public final /* synthetic */ C2102b b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                C2102b c2102b = this.b;
                switch (i62) {
                    case 0:
                        Context context2 = c2102b.b;
                        k.f(context2, "context");
                        String str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                        return str == null ? ApexSDK.VERSION : str;
                    default:
                        Context context3 = c2102b.b;
                        k.f(context3, "context");
                        return String.valueOf(context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0).versionCode);
                }
            }
        });
    }

    @Override // F9.A
    public final M intercept(z zVar) {
        g gVar = (g) zVar;
        K1.a aVarB = gVar.e.b();
        aVarB.b("zy-device-id", B5.b.f194a);
        String str = Build.MODEL;
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        aVarB.b("zy-device-model", str);
        String str3 = Build.BRAND;
        if (str3 == null) {
            str3 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        aVarB.b("zy-device-brand", str3);
        aVarB.b("zy-client-type", this.f6850a);
        String languageTag = Locale.getDefault().toLanguageTag();
        k.e(languageTag, "toLanguageTag(...)");
        aVarB.b("zy-client-lang", languageTag);
        String str4 = Build.VERSION.RELEASE;
        if (str4 != null) {
            str2 = str4;
        }
        aVarB.b("zy-system-ver", "Android ".concat(str2));
        aVarB.b("zy-app-ver-name", (String) this.c.getF4884a());
        aVarB.b("zy-app-ver-code", (String) this.d.getF4884a());
        return gVar.b(aVarB.d());
    }
}
