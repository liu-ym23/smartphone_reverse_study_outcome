package androidx.loader.a;

import androidx.lifecycle.ap;
import androidx.lifecycle.p;
import androidx.loader.content.Loader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: LoaderManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.loader.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoaderManager.java */
    public interface InterfaceC0064a<D> {
        void a(Loader<D> r1);

        void a(Loader<D> r1, D r2);
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String r1, FileDescriptor r2, PrintWriter r3, String[] r4);

    public a() {
    }

    public static <T extends p & ap> a a(T r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        return new b(r4, ((ap) ZeusTransformUtils.preCheckCast(r4, ap.class, "com.obric.aiagent.plugin")).getViewModelStore());
    }
}
