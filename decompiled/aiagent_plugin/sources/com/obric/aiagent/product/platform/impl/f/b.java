package com.obric.aiagent.product.platform.impl.f;

import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PacificVibrateFeedback.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IVibrateFeedback {
    private static final String TAG = "PacificVibrateFeedback";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18846a = null;

    /* JADX INFO: compiled from: PacificVibrateFeedback.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18846a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(String r1) {
        IVibrateFeedback.DefaultImpls.performVibratorSmtFeedback(this, r1);
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(FeedbackType r1) {
        o.e(r1, "feedbackType");
        c.f18847a.a(r1.getTypeName());
    }
}
