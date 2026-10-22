package com.bytedance.android.shopping.new_cart.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import v96.g;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f179598a;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f179599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f179600b;

        public b(c r100, String r101) {
            this.f179599a = r100;
            this.f179600b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECToast.showToast$default(ECToast.INSTANCE, this.f179599a.f179598a, this.f179600b, null, 4, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f179598a = r100;
    }

    @Override // v96.g
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        bg3.a r101 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new b(this, r100));
    }
}
