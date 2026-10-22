package j1;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lj1/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/io/File;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Ljava/io/File;", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: j1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4755b {

    /* renamed from: a, reason: collision with root package name */
    public static final C4755b f34467a = new C4755b();

    public static final File a(Context context) {
        p.i(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        p.h(noBackupFilesDir, "getNoBackupFilesDir(...)");
        return noBackupFilesDir;
    }
}
