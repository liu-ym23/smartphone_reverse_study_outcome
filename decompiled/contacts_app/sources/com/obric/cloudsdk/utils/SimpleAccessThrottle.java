package com.obric.cloudsdk.utils;

import com.obric.cloudsdk.kv.base.KvLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Throttle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/cloudsdk/utils/SimpleAccessThrottle;", "", "signature", "", "intervalThreshold", "", "(Ljava/lang/String;J)V", "timeStamp", "isTooFrequently", "", "refresh", "", "Companion", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimpleAccessThrottle {
    public static final Companion Companion = null;
    private static final String TAG = "SimpleAccessThrottle";
    private final long intervalThreshold;
    private final String signature;
    private volatile long timeStamp;

    /* JADX INFO: compiled from: Throttle.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/cloudsdk/utils/SimpleAccessThrottle$Companion;", "", "()V", "TAG", "", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SimpleAccessThrottle(String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "signature");
        this.signature = r3;
        this.intervalThreshold = r4;
        KvLog.INSTANCE.d(TAG, "init SimpleAccessThrottle, " + r3 + ", " + r4);
    }

    public final boolean isTooFrequently() {
        boolean r1 = false;
        if (this.intervalThreshold <= 0) goto L10;
        long r2 = this.timeStamp;
        this.timeStamp = System.currentTimeMillis();
        long r4 = this.timeStamp - r2;
        if (r4 >= this.intervalThreshold) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        KvLog.INSTANCE.w(TAG, this.signature + ", too frequently, " + r4);
    L10:
        return r1;
    }

    public final void refresh() {
        this.timeStamp = System.currentTimeMillis();
    }
}
