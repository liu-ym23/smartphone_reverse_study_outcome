package u2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* renamed from: u2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5571b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f42422a;

    public C5571b(Context context) {
        this.f42422a = context;
    }

    @ResultIgnorabilityUnspecified
    public ApplicationInfo a(String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f42422a.getPackageManager().getApplicationInfo(str, i10);
    }

    public CharSequence b(String str) throws PackageManager.NameNotFoundException {
        Context context = this.f42422a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    @ResultIgnorabilityUnspecified
    public PackageInfo c(String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f42422a.getPackageManager().getPackageInfo(str, i10);
    }
}
