package j5;

import Y8.t;
import android.app.Application;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.panelui.l;
import com.stepos.ailauncher.chat.sheet.DesktopChatResidentController;
import com.stepos.ailauncher.homegesture.w;
import h8.C4148a;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lj5/b;", "", "<init>", "()V", "Landroid/app/Application;", ContentType.Application.TYPE, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/app/Application;)V", "", "TAG", "Ljava/lang/String;", "ACTION_CONSUME_HOME_GESTURE", "ACTION_DISMISS_DESKTOP_CHAT", "", "initialized", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final String ACTION_CONSUME_HOME_GESTURE = "com.stepos.ailauncher.action.CONSUME_HOME_GESTURE";
    public static final String ACTION_DISMISS_DESKTOP_CHAT = "com.stepos.ailauncher.action.DISMISS_DESKTOP_CHAT";
    public static final b INSTANCE = new b();
    private static final String TAG = "DesktopChatHome";
    private static volatile boolean initialized;

    public static final t c() throws Resources.NotFoundException {
        DesktopChatResidentController.a3();
        return t.f7040a;
    }

    public final void b(Application application) {
        p.i(application, "application");
        if (initialized) {
            return;
        }
        l.INSTANCE.e();
        w.INSTANCE.f(new InterfaceC5063a() { // from class: j5.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return b.c();
            }
        });
        DesktopChatResidentController.INSTANCE.M1();
        initialized = true;
        C4148a.d(TAG, "init: panel bridge + root strategies", false, 4, null);
    }
}
