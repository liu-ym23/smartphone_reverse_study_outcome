package Kb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import tb.C5530C;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ3\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"LKb/b;", "", "<init>", "()V", "LKb/a;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30739f, "Ltb/C;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_UMID, "(LKb/a;Ltb/C;)V", "", "id", "type", "data", Const.INTENT_KEY_PKGNAME, "(LKb/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(LKb/a;)V", "", "t", "c", "(LKb/a;Ljava/lang/Throwable;Ltb/C;)V", "okhttp-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class b {
    public abstract void a(a eventSource);

    public abstract void b(a eventSource, String id, String type, String data);

    public abstract void c(a eventSource, Throwable t10, C5530C response);

    public abstract void d(a eventSource, C5530C response);
}
