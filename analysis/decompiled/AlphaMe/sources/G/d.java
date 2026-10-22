package G;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static LocaleList a(Configuration configuration) {
        return configuration.getLocales();
    }

    @DoNotInline
    public static void b(@NonNull Configuration configuration, @NonNull g gVar) {
        configuration.setLocales(((i) gVar.f464a).f465a);
    }
}
