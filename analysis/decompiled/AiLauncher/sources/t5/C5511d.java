package t5;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lt5/d;", "", "<init>", "()V", "", "AUTHORITY", "Ljava/lang/String;", "Landroid/net/Uri;", "CONTENT_URI_IMPROVE", "Landroid/net/Uri;", Const.INTENT_KEY_APIKEY, "()Landroid/net/Uri;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: t5.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5511d {
    public static final String AUTHORITY = "com.stepos.ailauncher.settings.provider";
    private static final Uri CONTENT_URI_IMPROVE;
    public static final C5511d INSTANCE = new C5511d();

    static {
        Uri uri = Uri.parse("content://com.stepos.ailauncher.settings.provider/improve_assistant");
        p.h(uri, "parse(...)");
        CONTENT_URI_IMPROVE = uri;
    }

    public final Uri a() {
        return CONTENT_URI_IMPROVE;
    }
}
