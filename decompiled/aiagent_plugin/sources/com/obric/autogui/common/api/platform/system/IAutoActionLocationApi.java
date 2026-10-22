package com.obric.autogui.common.api.platform.system;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: IAutoActionLocationApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionLocationApi {

    /* JADX INFO: compiled from: IAutoActionLocationApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object acquireCoarseLocation$default(IAutoActionLocationApi r2, Context r3, boolean r4, boolean r5, d r6, int r7, Object r8) {
            IAutoActionLocationApi r9 = (IAutoActionLocationApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionLocationApi.class, "com.obric.aiagent.plugin");
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d<? super com.obric.autogui.common.d<CoarseLocationInfo>> r11 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 2) == 0) goto L8;
            r4 = false;
        L8:
            if ((r7 & 4) == 0) goto L11;
            r5 = false;
        L11:
            return r9.acquireCoarseLocation(r10, r4, r5, r11);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: acquireCoarseLocation");
        }

        public static /* synthetic */ Object acquirePOILocation$default(IAutoActionLocationApi r2, Context r3, boolean r4, d r5, int r6, Object r7) {
            IAutoActionLocationApi r8 = (IAutoActionLocationApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionLocationApi.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d<? super com.obric.autogui.common.d<POILocationInfo>> r10 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = false;
        L8:
            return r8.acquirePOILocation(r9, r4, r10);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: acquirePOILocation");
        }
    }

    Object acquireCoarseLocation(Context r1, boolean r2, boolean r3, d<? super com.obric.autogui.common.d<CoarseLocationInfo>> r4);

    Object acquirePOILocation(Context r1, boolean r2, d<? super com.obric.autogui.common.d<POILocationInfo>> r3);
}
