package C2;

import android.content.Context;
import android.os.Binder;
import android.os.Process;

/* loaded from: classes.dex */
public final class d {
    public static boolean a(Context context) {
        return b(context, Binder.getCallingUid());
    }

    public static boolean b(Context context, int i5) {
        if (context == null) {
            return false;
        }
        if (i5 == 1000 || i5 == Process.myUid()) {
            return true;
        }
        if (i5 < 0) {
            return false;
        }
        return context.getPackageManager().checkSignatures(Process.myUid(), i5) == 0;
    }
}
