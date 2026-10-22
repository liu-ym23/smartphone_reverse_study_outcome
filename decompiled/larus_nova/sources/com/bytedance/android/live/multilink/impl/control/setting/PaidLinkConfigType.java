package com.bytedance.android.live.multilink.impl.control.setting;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/control/setting/PaidLinkConfigType;", "", "InteractAudience", "VideoTalk", CancelRetainContactInfoFunctions.All, "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PaidLinkConfigType extends Enum<PaidLinkConfigType> {
    public static final PaidLinkConfigType All = null;
    public static final PaidLinkConfigType InteractAudience = null;
    public static final PaidLinkConfigType VideoTalk = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaidLinkConfigType[] f83404a = null;

    static {
        PaidLinkConfigType r100 = new PaidLinkConfigType("InteractAudience", 0);
        InteractAudience = r100;
        PaidLinkConfigType r101 = new PaidLinkConfigType("VideoTalk", 1);
        VideoTalk = r101;
        PaidLinkConfigType r102 = new PaidLinkConfigType(CancelRetainContactInfoFunctions.All, 2);
        All = r102;
        f83404a = new PaidLinkConfigType[]{r100, r101, r102};
    }

    public static PaidLinkConfigType valueOf(String r100) {
        return (PaidLinkConfigType) a.a(PaidLinkConfigType.class, r100);
    }

    public static PaidLinkConfigType[] values() {
        return (PaidLinkConfigType[]) f83404a.clone();
    }

    public PaidLinkConfigType(String r100, int r101) {
        super(r100, r101);
    }
}
