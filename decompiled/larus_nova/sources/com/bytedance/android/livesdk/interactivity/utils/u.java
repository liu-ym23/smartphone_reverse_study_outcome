package com.bytedance.android.livesdk.interactivity.utils;

import android.view.View;
import com.bytedance.live.artist.render.RenderEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class u {

    public static final class a implements tc2.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f141420a;

        public a(Function1 r100) {
            this.f141420a = r100;
        }

        @Override // tc2.d
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Function1 r101 = this.f141420a;
            if (r101 == null) goto L6;
            Unit r102 = (Unit) r101.invoke(r100);
            return;
        }
    }

    public static final void a(RenderEntity r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setOnClickListener");
        r100.a(tc2.d.class, new a(r101));
    }
}
