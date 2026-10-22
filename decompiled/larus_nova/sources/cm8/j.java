package cm8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f24209f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f24210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f24211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cm8.a f24212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f24213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f24214e;

    public static final class a {
    }

    public static final class b implements bm8.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f24215a;

        @Override // bm8.j
        public final void refresh() {
            f r100 = this.f24215a.f24211b;
            if (r100 == null) goto L8;
            Function0<Unit> r101 = r100.f24205l;
            if (r101 == null) goto L9;
            r101.invoke();
            return;
        L9:
            return;
        }

        public b(j r100) {
            this.f24215a = r100;
        }
    }

    static {
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f24210a = r100;
        this.f24213d = LazyKt.lazy(new g());
        this.f24214e = new b(this);
    }
}
