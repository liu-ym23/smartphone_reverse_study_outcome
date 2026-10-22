package l4;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\tR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ll4/a;", "", "<init>", "()V", "", "text", "tag", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "c", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "", "DEBUG", "Z", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: l4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4871a {
    public static final C4871a INSTANCE = new C4871a();
    private static String TAG = "AgentLogger_LLM_API";
    private static boolean DEBUG = true;

    public static /* synthetic */ void b(C4871a c4871a, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = TAG;
        }
        c4871a.a(str, str2);
    }

    public static /* synthetic */ void d(C4871a c4871a, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = TAG;
        }
        c4871a.c(str, str2);
    }

    public final void a(String text, String tag) {
        p.i(text, "text");
        p.i(tag, "tag");
        if (DEBUG) {
            C4148a.c(tag, text, true);
        }
    }

    public final void c(String text, String tag) {
        p.i(text, "text");
        p.i(tag, "tag");
        if (DEBUG) {
            C4148a.j(tag, text, true);
        }
    }
}
