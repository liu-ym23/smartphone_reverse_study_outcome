package com.bytedance.android.shopping.orderlist.common.utils;

import android.content.Context;
import com.bytedance.android.ec.core.utils.b1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f179973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.monitor.error.a f179974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f179975c;

    public static final class a implements b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f179976a;

        public a(k r100) {
            this.f179976a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.b1
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            this.f179976a.f179974b.a();
        }
    }

    public final Context getContext() {
        return this.f179975c;
    }

    public k(com.bytedance.android.shopping.orderlist.common.monitor.error.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f179974b = r100;
        this.f179975c = r101;
        this.f179973a = new a(this);
    }
}
