package com.obric.autogui.common.api.platform.ui;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IAutoActionUIApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionUIApi {

    /* JADX INFO: compiled from: IAutoActionUIApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void showToast$default(IAutoActionUIApi r2, CharSequence r3, Context r4, int r5, Object r6) {
            IAutoActionUIApi r7 = (IAutoActionUIApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionUIApi.class, "com.obric.aiagent.plugin");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r9 = null;
        L7:
            r7.showToast(r8, r9);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
        }

        public static /* synthetic */ void showToast$default(IAutoActionUIApi r2, int r3, boolean r4, Context r5, int r6, Object r7) {
            IAutoActionUIApi r8 = (IAutoActionUIApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionUIApi.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 2) == 0) goto L8;
            r4 = false;
        L8:
            if ((r6 & 4) == 0) goto L10;
            r9 = null;
        L10:
            r8.showToast(r3, r4, r9);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showToast");
        }
    }

    void showToast(int r1, boolean r2, Context r3);

    void showToast(CharSequence r1, Context r2);
}
