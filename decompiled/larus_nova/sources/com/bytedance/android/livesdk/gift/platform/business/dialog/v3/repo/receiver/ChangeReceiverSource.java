package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/repo/receiver/ChangeReceiverSource;", "", "ReceiverPanel", "Other", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChangeReceiverSource extends Enum<ChangeReceiverSource> {
    public static final ChangeReceiverSource Other = null;
    public static final ChangeReceiverSource ReceiverPanel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChangeReceiverSource[] f128408a = null;

    static {
        ChangeReceiverSource r100 = new ChangeReceiverSource("ReceiverPanel", 0);
        ReceiverPanel = r100;
        ChangeReceiverSource r101 = new ChangeReceiverSource("Other", 1);
        Other = r101;
        f128408a = new ChangeReceiverSource[]{r100, r101};
    }

    public static ChangeReceiverSource valueOf(String r100) {
        return (ChangeReceiverSource) r27.a.a(ChangeReceiverSource.class, r100);
    }

    public static ChangeReceiverSource[] values() {
        return (ChangeReceiverSource[]) f128408a.clone();
    }

    public ChangeReceiverSource(String r100, int r101) {
        super(r100, r101);
    }
}
