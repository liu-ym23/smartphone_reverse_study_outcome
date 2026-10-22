package com.stepos.ailauncher.contract.api.homegesture;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "HOME", "OWNER_DESTROY", "RECENTS", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeDismissReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ HomeDismissReason[] $VALUES;
    public static final HomeDismissReason HOME = new HomeDismissReason("HOME", 0);
    public static final HomeDismissReason OWNER_DESTROY = new HomeDismissReason("OWNER_DESTROY", 1);
    public static final HomeDismissReason RECENTS = new HomeDismissReason("RECENTS", 2);

    private static final /* synthetic */ HomeDismissReason[] $values() {
        return new HomeDismissReason[]{HOME, OWNER_DESTROY, RECENTS};
    }

    static {
        HomeDismissReason[] homeDismissReasonArr$values = $values();
        $VALUES = homeDismissReasonArr$values;
        $ENTRIES = a.a(homeDismissReasonArr$values);
    }

    private HomeDismissReason(String str, int i10) {
    }

    public static InterfaceC4149a<HomeDismissReason> getEntries() {
        return $ENTRIES;
    }

    public static HomeDismissReason valueOf(String str) {
        return (HomeDismissReason) Enum.valueOf(HomeDismissReason.class, str);
    }

    public static HomeDismissReason[] values() {
        return (HomeDismissReason[]) $VALUES.clone();
    }
}
