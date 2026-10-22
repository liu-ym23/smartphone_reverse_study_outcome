package G;

import android.content.Context;
import android.os.UserManager;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class k {
    @DoNotInline
    public static boolean a(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
