package com.obric.aiagent.product.platform.api.app;

import d.h.b.h;

/* JADX INFO: compiled from: ObricAutoVirtualDisplayRecordSetListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricAutoVirtualDisplayRecordSetListener {
    public static final Companion Companion = null;
    public static final int RECORD_SET_CLOSE_REASON_DISPLAY_REMOVED = 2;
    public static final int RECORD_SET_CLOSE_REASON_ENDED = 1;
    public static final int RECORD_SET_CLOSE_REASON_REPLACED = 4;

    /* JADX INFO: compiled from: ObricAutoVirtualDisplayRecordSetListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract void onPackageAdmitted(long r1, String r3);

    public abstract void onRecordSetClosed(long r1, int r3);

    public ObricAutoVirtualDisplayRecordSetListener() {
    }
}
