package K7;

import android.content.Context;

/* loaded from: classes.dex */
public class c {
    public static void a() {
        i iVarC = i.c();
        synchronized (iVarC) {
            iVarC.f4127h = null;
        }
    }

    public static String b(Context context) {
        i iVarC = i.c();
        return iVarC.d(context.getApplicationContext(), iVarC.f4121b);
    }

    public static void c(Context context, a aVar) {
        i iVarC = i.c();
        synchronized (iVarC) {
            iVarC.f4127h = aVar;
        }
    }
}
