package Hb;

import Mb.I;
import Mb.u;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okhttp3.internal.platform.d;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"LHb/a;", "LHb/b;", "", "path", "<init>", "(Ljava/lang/String;)V", "LMb/I;", "e", "()LMb/I;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a extends b {

    /* renamed from: i, reason: collision with root package name */
    public static final String f3235i = "PublicSuffixDatabase.list";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final String path;

    public a(String path) {
        p.i(path, "path");
        this.path = path;
    }

    @Override // Hb.b
    public I e() throws IOException {
        Context contextB = d.f37742a.b();
        AssetManager assets = contextB != null ? contextB.getAssets() : null;
        if (assets == null) {
            if (Build.FINGERPRINT == null) {
                throw new IOException("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
            }
            throw new IOException("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
        }
        InputStream inputStreamOpen = assets.open(d());
        p.h(inputStreamOpen, "open(...)");
        return u.l(inputStreamOpen);
    }

    @Override // Hb.b
    /* renamed from: j, reason: from getter and merged with bridge method [inline-methods] */
    public String d() {
        return this.path;
    }

    public /* synthetic */ a(String str, int i10, i iVar) {
        this((i10 & 1) != 0 ? f3235i : str);
    }
}
