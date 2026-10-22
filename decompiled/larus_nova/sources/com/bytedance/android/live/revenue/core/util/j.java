package com.bytedance.android.live.revenue.core.util;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes47.dex */
@Deprecated(message = "https://bytedance.larkoffice.com/docx/QAEhdrRcmoh0dfx0uAhcctoTnQg")
public interface j {
    public static final a C0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f91039a = null;

        public a() {
        }

        static {
            f91039a = new a();
        }

        @Deprecated(message = "https://bytedance.larkoffice.com/docx/QAEhdrRcmoh0dfx0uAhcctoTnQg")
        public final com.bytedance.android.live.revenue.core.b a() {
            Object r100 = com.bytedance.live.datacontext.d.d(this);
            if ((r100 instanceof j) == true) goto L5;
            r100 = null;
        L5:
            j r101 = (j) r100;
            if (r101 != null) goto L8;
            return null;
        L8:
            return r101.getInst();
        }
    }

    static {
        C0 = a.f91039a;
    }

    com.bytedance.android.live.revenue.core.b getInst();
}
