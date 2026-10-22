package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f84195a = null;

        static {
            f84195a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.b$b, reason: collision with other inner class name */
    public static final class C1280b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1280b f84196a = null;

        static {
            f84196a = new C1280b();
        }

        public C1280b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<MiniAppEntranceCell> f84197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c f84198b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f84197a, r101.f84197a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f84198b, r101.f84198b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<MiniAppEntranceCell> r100 = this.f84197a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r104 = this.f84198b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(entranceCellList=" + this.f84197a + ", groupProperty=" + this.f84198b + ")";
        }

        public c(List<MiniAppEntranceCell> r100, com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c r101) {
            Intrinsics.checkNotNullParameter(r100, "entranceCellList");
            Intrinsics.checkNotNullParameter(r101, "groupProperty");
            this.f84197a = r100;
            this.f84198b = r101;
        }
    }

    public b() {
    }
}
