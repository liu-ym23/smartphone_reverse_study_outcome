package C5;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LC5/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/BroadcastReceiver;", "receiver", "", "what", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroid/content/BroadcastReceiver;Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "REJECT_WHEN_SENDER_UNKNOWN", "Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final boolean REJECT_WHEN_SENDER_UNKNOWN = false;
    private static final String TAG = "BroadcastSenderVerifier";

    public static final boolean a(Context context, BroadcastReceiver receiver, String what) {
        p.i(context, "context");
        p.i(receiver, "receiver");
        p.i(what, "what");
        C4148a.d(TAG, "allow " + what + " in debug build (sender uid=" + receiver.getSentFromUid() + ")", false, 4, null);
        return true;
    }
}
