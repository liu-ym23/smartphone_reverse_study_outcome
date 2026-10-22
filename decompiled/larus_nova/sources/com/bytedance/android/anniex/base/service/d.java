package com.bytedance.android.anniex.base.service;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class d extends s26.a {

    public static class a {
        public a() {
        }
    }

    public static class b {
        public b() {
        }

        public View a(Context r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            return null;
        }

        public void b(int r100) {
        }

        public void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
        }

        public void d(int r100) {
        }

        public void e(boolean r100) {
        }

        public void f(boolean r100) {
        }
    }

    public d() {
    }

    public static a G0(b16.a r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        s26.d r101 = s26.d.f540305c;
        if (((d) s26.d.f540305c.c(d.class)) != null) goto L7;
        return null;
    L7:
        return G0(r100);
    }

    public static void H0(ia.c r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        s26.d r101 = s26.d.f540305c;
        if (((d) s26.d.f540305c.c(d.class)) == null) goto L6;
        H0(r100);
        return;
    }

    public b I0(m16.b r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        s26.d r102 = s26.d.f540305c;
        d r103 = (d) s26.d.f540305c.c(d.class);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.I0(r100, r101);
    }
}
