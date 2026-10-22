package apb;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/* JADX INFO: loaded from: classes36.dex */
public interface b {
    boolean a();

    String b();

    void c(zob.b r100);

    String d(Locale r100);

    Locale e();

    void f(Application r100, yob.b r101);

    Locale g();

    Locale getCacheLanguageSetting();

    Locale getLanguageSetting();

    void h(Configuration r100);

    Context i(Context r100, Locale r101);

    boolean isGooglePlay();

    Context j(Context r100);

    void k(zob.b r100);

    void l(Application r100);

    boolean m(Application r100, Locale r101);
}
