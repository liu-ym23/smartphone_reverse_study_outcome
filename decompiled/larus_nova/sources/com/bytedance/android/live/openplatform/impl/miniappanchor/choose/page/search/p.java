package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class p {

    public static final class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f84291a = null;

        static {
            f84291a = new a();
        }

        public a() {
        }
    }

    public static final class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f84292a = null;

        static {
            f84292a = new b();
        }

        public b() {
        }
    }

    public static final class c extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f84293a = null;

        static {
            f84293a = new c();
        }

        public c() {
        }
    }

    public static final class d extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<MiniAppEntranceCell> f84294a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f84294a, ((d) r100).f84294a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<MiniAppEntranceCell> r100 = this.f84294a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(resultList=" + this.f84294a + ")";
        }

        public d(List<MiniAppEntranceCell> r100) {
            Intrinsics.checkNotNullParameter(r100, "resultList");
            this.f84294a = r100;
        }
    }

    public p() {
    }
}
