package M4;

import android.os.Trace;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bR(\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"LM4/d;", "", "<init>", "()V", "", "section", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "msg", Const.INTENT_KEY_APIKEY, "", "Z", "getLogEnabled", "()Z", "setLogEnabled", "(Z)V", "getLogEnabled$annotations", "logEnabled", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4544a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean logEnabled = true;

    public final void a(String msg) {
        kotlin.jvm.internal.p.i(msg, "msg");
        if (logEnabled) {
            Log.i("AgentSpriteSDK", msg);
        }
    }

    public final void b(String section) {
        kotlin.jvm.internal.p.i(section, "section");
        Trace.beginSection(section);
        Trace.endSection();
    }
}
