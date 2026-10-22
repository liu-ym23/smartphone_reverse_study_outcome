package com.obric.callandsms.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DonationTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/callandsms/common/DonationTrackerDelegate;", "", "()V", "tracker", "Lcom/obric/callandsms/common/DonationTracker;", "getTracker", "setTracker", "", "contactsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DonationTrackerDelegate {
    public static final DonationTrackerDelegate INSTANCE = null;
    private static DonationTracker tracker;

    static {
        INSTANCE = new DonationTrackerDelegate();
    }

    private DonationTrackerDelegate() {
    }

    public final void setTracker(DonationTracker r1) {
        Intrinsics.checkNotNullParameter(r1, "tracker");
        tracker = r1;
    }

    public final DonationTracker getTracker() {
        return tracker;
    }
}
