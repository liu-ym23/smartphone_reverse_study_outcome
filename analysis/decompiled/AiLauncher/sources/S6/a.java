package S6;

import Q8.c;
import Z8.C1173v;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.util.ReflectionException;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import d7.C3960b;
import d7.d;
import io.objectbox.BoxStore;
import io.objectbox.exception.DbException;
import io.objectbox.exception.DbSchemaException;
import io.objectbox.exception.FileCorruptException;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l9.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b8\u0006@BX\u0086.¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"LS6/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "Ljava/io/File;", "baseDir", "Lio/objectbox/BoxStore;", "c", "(Landroid/content/Context;Ljava/io/File;)Lio/objectbox/BoxStore;", Const.INTENT_KEY_UMID, "(Ljava/io/File;)V", UxipConstants.f30680s, "Lio/objectbox/BoxStore;", Const.INTENT_KEY_APIKEY, "()Lio/objectbox/BoxStore;", "boxStore", "", "Ljava/lang/String;", "getDbExceptionMessage", "()Ljava/lang/String;", "dbExceptionMessage", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5644a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static BoxStore boxStore;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static String dbExceptionMessage;

    public final BoxStore a() {
        BoxStore boxStore2 = boxStore;
        if (boxStore2 != null) {
            return boxStore2;
        }
        p.A("boxStore");
        return null;
    }

    public final void b(Context context) {
        p.i(context, "context");
        if (boxStore != null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        File fileA = d.f32141a.a();
        try {
            p.f(applicationContext);
            boxStore = c(applicationContext, fileA);
        } catch (ReflectionException e10) {
            dbExceptionMessage = e10.getMessage();
        } catch (DbSchemaException e11) {
            Log.w("ObjectBox", "Schema mismatch, wiping ObjectBox at " + fileA.getAbsolutePath() + ": " + e11.getMessage());
            d(fileA);
            try {
                p.f(applicationContext);
                boxStore = c(applicationContext, fileA);
            } catch (DbException e12) {
                dbExceptionMessage = e12.toString();
            }
        } catch (FileCorruptException e13) {
            Log.w("ObjectBox", "Corrupt ObjectBox at " + fileA.getAbsolutePath() + ", wiping: " + e13.getMessage());
            d(fileA);
            try {
                p.f(applicationContext);
                boxStore = c(applicationContext, fileA);
            } catch (DbException e14) {
                dbExceptionMessage = e14.toString();
            }
        } catch (DbException e15) {
            dbExceptionMessage = e15.toString();
        }
    }

    public final BoxStore c(Context context, File baseDir) {
        BoxStore boxStoreC = ((c) C3960b.a("com.stepos.datacenter.MyObjectBox", "builder", new Object[0])).a(context).b(baseDir).c();
        p.h(boxStoreC, "build(...)");
        return boxStoreC;
    }

    public final void d(File baseDir) {
        try {
            BoxStore.G(baseDir, null);
        } catch (Exception e10) {
            Log.w("ObjectBox", "deleteAllFiles failed, fallback to manual wipe: " + e10.getMessage());
            Iterator it = C1173v.p("data.mdb", "lock.mdb").iterator();
            while (it.hasNext()) {
                new File(baseDir, (String) it.next()).delete();
            }
            k.v(new File(baseDir, "objectbox"));
        }
    }
}
