package com.bytedance.android.live.liveinteract.revenue.adventure;

import ai0.d;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ih0.b;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/adventure/AdventureContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lai0/d;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AdventureContext extends DataContext implements d {
    public static final a Companion = null;

    public static final class a {
        public static boolean a() {
            IInteractService r100 = (IInteractService) k.f(IInteractService.class);
            if (r100 == null) goto L9;
            b r101 = r100.dynamicService(null);
            if (r101 == null) goto L9;
            if (r101.jl("adventure") != true) goto L9;
            return true;
        L9:
            return false;
        }

        @JvmStatic
        public final AdventureContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(d.class);
            if ((r100 instanceof AdventureContext) == true) goto L6;
            r100 = null;
        L6:
            return (AdventureContext) r100;
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final AdventureContext getContext() {
        return Companion.getContext();
    }

    public AdventureContext() {
    }
}
