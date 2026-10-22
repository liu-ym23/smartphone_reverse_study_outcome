package app.visly.stretch;

import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lapp/visly/stretch/Stretch;", "", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GaiaX"}, k = 1, mv = {1, 7, 1})
public final class Stretch {
    public static final a Companion = null;
    private static volatile boolean didInit;
    private static volatile boolean initing;
    private static volatile long ptr;

    public static final class a {
        @JvmStatic
        public static void a() {
            Intrinsics.checkNotNullParameter("stretch", "libName");
            FLogger r100 = FLogger.f375446a;
            r100.i("Librarian_loadLib", "loadLibrary start libName -> stretch");
            com.bytedance.librarian.a.c("stretch");
            r100.i("Librarian_loadLib", "loadLibrary success by librarian -> stretch");
        }

        public static void b() {
            if (Stretch.access$getDidInit$cp() == false) goto L5;
            return;
        L5:
            if (Stretch.access$getIniting$cp() == false) goto L8;
            return;
        L8:
            if (Stretch.access$getDidInit$cp() == false) goto L10;
            return;
        L10:
            monitor-enter(Stretch.class);
        L21:
            th = move-exception;
            throw th;
        L12:
            if (Stretch.access$getDidInit$cp() == false) goto L14;
        L19:
            monitor-exit(Stretch.class);
            return;
        L14:
            if (Stretch.access$getIniting$cp() == true) goto L19;
            Stretch.access$setIniting$cp(true);     // Catch: Throwable -> L21
            a();     // Catch: Throwable -> L21
            Stretch.Companion.getClass();     // Catch: Throwable -> L21
            Stretch.access$setPtr$cp(Stretch.access$nInit());     // Catch: Throwable -> L21
            Stretch.access$setDidInit$cp(true);     // Catch: Throwable -> L21
            Stretch.access$setIniting$cp(false);     // Catch: Throwable -> L21
            Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(Stretch.class);
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    private static final native long nInit();

    public static final /* synthetic */ long access$nInit() {
        return nInit();
    }

    public Stretch() {
    }

    public static final /* synthetic */ boolean access$getDidInit$cp() {
        return didInit;
    }

    public static final /* synthetic */ boolean access$getIniting$cp() {
        return initing;
    }

    public static final /* synthetic */ long access$getPtr$cp() {
        return ptr;
    }

    public static final /* synthetic */ void access$setDidInit$cp(boolean r100) {
        didInit = r100;
    }

    public static final /* synthetic */ void access$setIniting$cp(boolean r100) {
        initing = r100;
    }

    public static final /* synthetic */ void access$setPtr$cp(long r100) {
        ptr = r100;
    }
}
