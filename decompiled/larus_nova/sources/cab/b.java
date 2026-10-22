package cab;

import android.content.Context;
import com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin$visitLink$1$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22980a = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f22981b = null;

        static {
            f22981b = new a();
        }

        public a() {
        }

        @Override // cab.b
        public final boolean a(n r100) {
            Intrinsics.checkNotNullParameter(r100, "link");
            return false;
        }

        @Override // cab.b
        public final void b(Context r100, n r101, LarkLinkPlugin$visitLink$1$1 r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "link");
            Intrinsics.checkNotNullParameter(r102, "callback");
            r102.onSuccess(r101);
        }
    }

    static {
        f22980a = a.f22981b;
    }

    boolean a(n r100);

    void b(Context r100, n r101, LarkLinkPlugin$visitLink$1$1 r102);
}
