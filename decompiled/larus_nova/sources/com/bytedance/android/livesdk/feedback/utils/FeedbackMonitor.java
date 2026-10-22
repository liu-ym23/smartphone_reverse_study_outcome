package com.bytedance.android.livesdk.feedback.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedbackMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f124865a = 0;

    public static final class Monitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f124866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f124867b;

        public final void d() {
            String r100 = this.f124866a;
            if (r100 != null) goto L5;
        L14:
            String r101 = ((StringBuilder) this.f124867b.getValue()).toString();
        L15:
            ALogger.i("LightFeedbackMonitor", r101);
            return;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == true) goto L11;
            r100 = null;
        L11:
            if (r100 == null) goto L14;
            r101 = "the page is " + r100 + ".\n" + ((StringBuilder) this.f124867b.getValue());
            if (r101 != null) goto L15;
        L7:
            r102 = false;
            goto L8
        }

        public Monitor() {
            this.f124866a = "";
            this.f124867b = LazyKt.lazy(FeedbackMonitor$Monitor$strBuilder$2.INSTANCE);
        }

        public final void b(Pair... r100) {
            Intrinsics.checkNotNullParameter(r100, "pairs");
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L10;
            Pair r103 = r100[r102];
            if (r103 == null) goto L9;
            Object r104 = r103.getSecond();
            if (r104 == null) goto L9;
            a((String) r103.getFirst(), r104);
        L9:
            r102 = r102 + 1;
            goto L3
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ((StringBuilder) this.f124867b.getValue()).append(r100 + '\n');
        }

        public final void a(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            ((StringBuilder) this.f124867b.getValue()).append("the " + r100 + " is " + r101 + ".\n");
        }
    }

    static {
    }
}
