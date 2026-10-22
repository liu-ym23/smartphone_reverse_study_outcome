package x5;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lx5/d;", "", "<init>", "()V", "", "AUTHORITY", "Ljava/lang/String;", "Landroid/net/Uri;", "URI", "Landroid/net/Uri;", Const.INTENT_KEY_APIKEY, "()Landroid/net/Uri;", "METHOD_SET_AMOO_ENABLED", "EXTRA_ENABLED", "RESULT_SUCCESS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    public static final String AUTHORITY = "com.stepos.ability.voicewakeup.state";
    public static final String EXTRA_ENABLED = "enabled";
    public static final d INSTANCE = new d();
    public static final String METHOD_SET_AMOO_ENABLED = "set_amoo_enabled";
    public static final String RESULT_SUCCESS = "success";
    private static final Uri URI;

    static {
        Uri uri = Uri.parse("content://com.stepos.ability.voicewakeup.state");
        p.h(uri, "parse(...)");
        URI = uri;
    }

    public final Uri a() {
        return URI;
    }
}
