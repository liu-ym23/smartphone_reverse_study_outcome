package g0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.DoNotInline;

/* renamed from: g0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0569i {
    @DoNotInline
    public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
    }
}
