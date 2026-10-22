package d7;

import android.app.ActivityThread;
import android.app.Application;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ld7/d;", "", "<init>", "()V", "Ljava/io/File;", Const.INTENT_KEY_APIKEY, "()Ljava/io/File;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f32141a = new d();

    public final File a() {
        Application applicationCurrentApplication = ActivityThread.currentApplication();
        if (applicationCurrentApplication == null) {
            throw new IllegalStateException("ActivityThread.currentApplication() is null; cannot resolve storage root");
        }
        String parent = applicationCurrentApplication.getFilesDir().getParent();
        if (parent != null) {
            return new File(parent);
        }
        throw new IllegalStateException(("filesDir has no parent: " + applicationCurrentApplication.getFilesDir().getAbsolutePath()).toString());
    }
}
