package c6;

import N5.g;
import android.app.Application;
import com.autonavi.aps.amapapi.config.Const;
import com.migu.music.ipc.MusicIpcSdk;
import com.stepos.ailauncher.migu.card.MusicListCardProvider;
import com.stepos.ailauncher.migu.play.MiguPlayController;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lc6/a;", "", "<init>", "()V", "Landroid/app/Application;", ContentType.Application.TYPE, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/app/Application;)V", "", "MUSIC_LIST", "Ljava/lang/String;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: c6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1500a {
    public static final C1500a INSTANCE = new C1500a();
    public static final String MUSIC_LIST = "music_list";

    public final void a(Application application) {
        p.i(application, "application");
        g.INSTANCE.a(MUSIC_LIST, new MusicListCardProvider());
        MiguPlayController.INSTANCE.Y(application);
        MusicIpcSdk.I().b0(false);
    }
}
