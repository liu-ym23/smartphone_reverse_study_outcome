package K;

import android.content.Context;
import j4.k;
import java.io.File;

/* loaded from: classes.dex */
public final class a {
    public static final File a(Context context, String str) {
        k.g(context, "<this>");
        k.g(str, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), k.m("datastore/", str));
    }
}
