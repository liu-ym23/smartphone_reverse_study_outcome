package b41;

import android.graphics.RectF;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f17473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c41.a f17474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc0.d f17475c;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f17476a;

        public a(c r100) {
            this.f17476a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            rc0.c r101 = (rc0.c) r100;
            if (r101 == null) goto L10;
            RectF r102 = r101.f537026a;
            if (r102 == null) goto L11;
            this.f17476a.f17474b.f22376b.setValue(new g90.a(r101.f537030e, r102, r101.f537031f, o51.f.k.f522069e.f522057b));
            return;
        L11:
            return;
        }
    }

    public c(c41.a r100, kc0.d r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f17474b = r100;
        this.f17475c = r101;
        this.f17473a = new a(this);
    }
}
