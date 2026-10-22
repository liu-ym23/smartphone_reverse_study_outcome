package com.obric.aiagent.product.platform.api.windoweffects;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IWindowEffects.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IWindowEffects {
    public static final Companion Companion = null;
    public static final String DEFAULT_WINDOW_LAYER_NAME = "obric-assistant-window";

    /* JADX INFO: compiled from: IWindowEffects.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String DEFAULT_WINDOW_LAYER_NAME = "obric-assistant-window";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IWindowEffects.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void showScreenShotEffect$default(IWindowEffects r2, boolean r3, String r4, int r5, Object r6) {
            IWindowEffects r7 = (IWindowEffects) ZeusTransformUtils.wrapperContextForParams(r2, IWindowEffects.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L13;
            if ((r5 & 1) == 0) goto L8;
            r3 = false;
        L8:
            if ((r5 & 2) == 0) goto L10;
            r4 = "obric-assistant-window";
        L10:
            r7.showScreenShotEffect(r3, r4);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showScreenShotEffect");
        }

        public static /* synthetic */ void playRippleEffect$default(IWindowEffects r2, boolean r3, String r4, int r5, Object r6) {
            IWindowEffects r7 = (IWindowEffects) ZeusTransformUtils.wrapperContextForParams(r2, IWindowEffects.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L13;
            if ((r5 & 1) == 0) goto L8;
            r3 = false;
        L8:
            if ((r5 & 2) == 0) goto L10;
            r4 = "obric-assistant-window";
        L10:
            r7.playRippleEffect(r3, r4);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playRippleEffect");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void playRippleEffect(boolean r1, String r2);

    void showScreenShotEffect(boolean r1, String r2);

    void startActivateEffect(boolean r1);

    void stopActivateEffect();
}
