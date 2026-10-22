package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.u0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f147802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f147803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f147804c;

    public static final class a extends u0 {
        public a(x r100, String r101) {
            super(r101);
            f("page_name", "live_list");
            f("source_page", l0.n());
            f(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_list_card");
            f("anchor_id", l0.i("anchor_id"));
            f("group_id", l0.i("group_id"));
            f(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, l0.d());
            f(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, l0.e());
            f("enter_from_merge", l0.d());
            f("enter_method", l0.i("enter_method"));
            f("room_id", l0.i("room_id"));
            if (r100.f147802a.length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            f("btm_id", r100.f147802a);
            return;
        L9:
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public x(String r100, String r101, Map r102) {
        this.f147802a = r100;
        this.f147803b = r101;
        this.f147804c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = new a(this, this.f147803b);     // Catch: Throwable -> L4
        r100.g(this.f147804c);     // Catch: Throwable -> L4
        r100.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
