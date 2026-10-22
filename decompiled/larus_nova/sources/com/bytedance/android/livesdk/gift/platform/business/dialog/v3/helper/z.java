package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.anya.q0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class z implements com.bytedance.android.scope.o {

    public static final class a implements mb.c {
        public a() {
        }

        @Override // mb.c
        public final void a(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter("ttlive_anya_executor", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
        }

        @Override // mb.c
        public final void logD(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // mb.c
        public final void logW(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }
    }

    public static final class b implements mb.c {
        public b() {
        }

        @Override // mb.c
        public final void a(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter("ttlive_anya_executor", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
            jy0.b.b("ttlive_anya_executor", r100, r101);
        }

        @Override // mb.c
        public final void logD(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            jy0.b.a(r100, r101);
        }

        @Override // mb.c
        public final void logW(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            jy0.b.f(r100, r101, null, 4);
        }
    }

    public z() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        boolean r100 = q0.f41746a;
        ReadOnlyProperty r101 = m.f127445b;
        KProperty<?>[] r102 = m.f127444a;
        q0.f41746a = ((Boolean) r101.getValue(null, r102[0])).booleanValue();
        q0.f41747b = ((Boolean) m.f127446c.getValue(null, r102[1])).booleanValue();
        q0.f41748c = ((Boolean) m.f127447d.getValue(null, r102[2])).booleanValue();
        q0.f41749d = ((Boolean) m.f127448e.getValue(null, r102[3])).booleanValue();
        q0.f41750e = ((Boolean) m.f127449f.getValue(null, r102[4])).booleanValue();
        q0.f41751f = ((Boolean) m.f127451h.getValue(null, r102[6])).booleanValue();
        if (((Boolean) m.f127450g.getValue(null, r102[5])).booleanValue() == false) goto L5;
        mb.c r103 = mb.a.f512756a;
        mb.a.f512756a = new a();
        return;
    L5:
        mb.c r104 = mb.a.f512756a;
        mb.a.f512756a = new b();
    }
}
