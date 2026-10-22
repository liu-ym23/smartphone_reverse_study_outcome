package N;

import android.content.Context;
import com.stepos.minor.Minor;
import j4.k;
import java.io.File;

/* loaded from: classes.dex */
public final class b {
    public static final File a(Context context, String str) {
        k.g(context, "<this>");
        k.g(str, Minor.COLUMN_NAME);
        return K.a.a(context, k.m(str, ".preferences_pb"));
    }
}
