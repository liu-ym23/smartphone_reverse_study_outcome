package caa;

import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements z9a.a {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // z9a.a
    public final void a(FeedbackType r100) {
        Intrinsics.checkNotNullParameter(r100, "feedbackType");
        Lazy r101 = h.f22975a;
        h.b(r100.getTypeName());
    }
}
