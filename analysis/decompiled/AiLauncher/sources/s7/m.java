package s7;

import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\tJ)\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Ls7/m;", "", "<init>", "()V", "", "subtag", "msg", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "", "t", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", Const.INTENT_KEY_PKGNAME, "", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", x5.d.EXTRA_ENABLED, "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f40102a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static boolean enabled = true;

    public static /* synthetic */ void c(m mVar, String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        mVar.b(str, str2, th);
    }

    public static /* synthetic */ void f(m mVar, String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        mVar.e(str, str2, th);
    }

    public final void a(String subtag, String msg) {
        kotlin.jvm.internal.p.i(subtag, "subtag");
        kotlin.jvm.internal.p.i(msg, "msg");
        if (enabled) {
            Log.d("MotionKit/" + subtag, msg);
        }
    }

    public final void b(String subtag, String msg, Throwable t10) {
        kotlin.jvm.internal.p.i(subtag, "subtag");
        kotlin.jvm.internal.p.i(msg, "msg");
        if (enabled) {
            Log.e("MotionKit/" + subtag, msg, t10);
        }
    }

    public final void d(String subtag, String msg) {
        kotlin.jvm.internal.p.i(subtag, "subtag");
        kotlin.jvm.internal.p.i(msg, "msg");
        if (enabled) {
            Log.i("MotionKit/" + subtag, msg);
        }
    }

    public final void e(String subtag, String msg, Throwable t10) {
        kotlin.jvm.internal.p.i(subtag, "subtag");
        kotlin.jvm.internal.p.i(msg, "msg");
        if (enabled) {
            Log.w("MotionKit/" + subtag, msg, t10);
        }
    }
}
