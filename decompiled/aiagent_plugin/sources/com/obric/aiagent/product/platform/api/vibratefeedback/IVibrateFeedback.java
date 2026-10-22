package com.obric.aiagent.product.platform.api.vibratefeedback;

import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IVibrateFeedback.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IVibrateFeedback {

    /* JADX INFO: compiled from: IVibrateFeedback.kt */
    public static final class DefaultImpls {
        public static void performVibratorSmtFeedback(IVibrateFeedback r2, String r3) {
            IVibrateFeedback r4 = (IVibrateFeedback) ZeusTransformUtils.wrapperContextForParams(r2, IVibrateFeedback.class, "com.obric.aiagent.plugin");
            o.e(r3, "feedbackTypeName");
            FeedbackType r0 = FeedbackType.Companion.getByTypeName(r3);
            if (r0 == null) goto L5;
            r4.performVibratorSmtFeedback(r0);
            return;
        L5:
            ISysLogDepend.Companion.w("IVibrateFeedback", "not found type for " + r3);
        }

        private static FeedbackType getFeedbackType(IVibrateFeedback r4, String r5) {
            IVibrateFeedback r6 = (IVibrateFeedback) ZeusTransformUtils.wrapperContextForParams(r4, IVibrateFeedback.class, "com.obric.aiagent.plugin");
            FeedbackType[] r7 = FeedbackType.values();
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            FeedbackType r2 = r7[r1];
            if (o.a(r2.getTypeName(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    void performVibratorSmtFeedback(FeedbackType r1);

    void performVibratorSmtFeedback(String r1);
}
