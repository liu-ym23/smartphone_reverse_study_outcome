package com.bytedance.android.ec.core.widget;

import android.view.View;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    public static final class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function1 f46087g;

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f46087g.invoke(r100);
        }

        public a(Function1 r100, Long r101, String r102) {
            this.f46087g = r100;
            super(r101, r102);
        }
    }

    public static void a(Query r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$limitClickListener");
        r100.a(new e(r101, null, null));
    }

    public static final void b(View r100, Long r101, String r102, Function1<? super View, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$setOnLimitClickListener");
        Intrinsics.checkNotNullParameter(r103, "listener");
        r100.setOnClickListener(new a(r103, r101, r102));
    }

    public static /* synthetic */ void c(View r100, Long r101, String r102, Function1 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r102 = null;
    L8:
        b(r100, r101, r102, r103);
    }
}
