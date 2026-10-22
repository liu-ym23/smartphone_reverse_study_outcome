package o5;

import La.H;
import Z8.F;
import Z8.X;
import android.app.Activity;
import android.app.ComponentCaller;
import android.net.Uri;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lo5/d;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;)Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/app/Activity;)Ljava/util/Set;", "TAG", "Ljava/lang/String;", "WHITELIST", "Ljava/util/Set;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final String TAG = "ChatLaunchGuard";
    public static final d INSTANCE = new d();
    private static final Set<String> WHITELIST = X.d("com.android.soundrecorder");

    public final String a(Activity activity) {
        p.i(activity, "activity");
        Set<String> setB = b(activity);
        if (setB.isEmpty()) {
            C4148a.u(TAG, "caller package unknown", false, 4, null);
            return "caller package unknown";
        }
        Set<String> set = setB;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (WHITELIST.contains((String) it.next())) {
                    return null;
                }
            }
        }
        y yVar = y.f34840a;
        String str = String.format("caller not in whitelist: %s", Arrays.copyOf(new Object[]{setB}, 1));
        p.h(str, "format(...)");
        C4148a.u(TAG, str, false, 4, null);
        return "caller not in whitelist: " + F.A0(set, null, null, null, 0, null, null, 63, null);
    }

    public final Set<String> b(Activity activity) {
        Object objB;
        Object objB2;
        String host;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String callingPackage = activity.getCallingPackage();
        if (callingPackage != null) {
            if (H.x0(callingPackage)) {
                callingPackage = null;
            }
            if (callingPackage != null) {
                linkedHashSet.add(callingPackage);
            }
        }
        if (Build.VERSION.SDK_INT >= 35) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ComponentCaller initialCaller = activity.getInitialCaller();
                objB = Result.b(initialCaller != null ? initialCaller.getPackage() : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            String str = (String) objB;
            if (str != null) {
                if (H.x0(str)) {
                    str = null;
                }
                if (str != null) {
                    linkedHashSet.add(str);
                }
            }
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(activity.getReferrer());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        Uri uri = (Uri) objB2;
        if (uri != null) {
            if (!p.d(uri.getScheme(), "android-app")) {
                uri = null;
            }
            if (uri != null && (host = uri.getHost()) != null) {
                String str2 = H.x0(host) ? null : host;
                if (str2 != null) {
                    linkedHashSet.add(str2);
                }
            }
        }
        return linkedHashSet;
    }
}
