package akb;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class d {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Event f4103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f4104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4105c;

        public final void a() {
            String r100 = this.f4105c;
            if (r100 != null) goto L5;
            return;
        L5:
            this.f4104b.getClass();
            Intrinsics.checkNotNullParameter(r100, "key");
            AppreciableKit.Companion.getInstance().end(r100);
        }

        public final void c() {
            d r100 = this.f4104b;
            Event r101 = this.f4103a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "event");
            Intrinsics.checkNotNullParameter(r101, "event");
            this.f4105c = AppreciableKit.Companion.getInstance().start(r100.a(), r100.b(), r101, null, true, null, null, null, null);
        }

        public a(Event r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "ugAppreciable");
            this.f4103a = r100;
            this.f4104b = r101;
        }

        public final void b(int r110, String r111) {
            d r100 = this.f4104b;
            Event r101 = this.f4103a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "event");
            ErrorType r102 = ErrorType.Network;
            ErrorLevel r103 = ErrorLevel.Exception;
            Boolean r112 = Boolean.TRUE;
            Intrinsics.checkNotNullParameter(r102, "errorType");
            Intrinsics.checkNotNullParameter(r103, "errorLevel");
            ErrorParams r104 = new ErrorParams(r100.a(), r100.b(), r101, r102, r103, r110, null, null, r111, r112, null, null, null);
            AppreciableKit.Companion.getInstance().error(r104);
        }
    }

    public d() {
    }

    public abstract Biz a();

    public abstract Scene b();
}
