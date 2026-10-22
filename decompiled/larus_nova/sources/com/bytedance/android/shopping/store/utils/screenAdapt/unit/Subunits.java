package com.bytedance.android.shopping.store.utils.screenAdapt.unit;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/screenAdapt/unit/Subunits;", "", UserProfileEvent.POSITION_NONE, "PT", "IN", "MM", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Subunits extends Enum<Subunits> {
    public static final Subunits IN = null;
    public static final Subunits MM = null;
    public static final Subunits NONE = null;
    public static final Subunits PT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Subunits[] f186975a = null;

    static {
        Subunits r100 = new Subunits(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        Subunits r101 = new Subunits("PT", 1);
        PT = r101;
        Subunits r102 = new Subunits("IN", 2);
        IN = r102;
        Subunits r103 = new Subunits("MM", 3);
        MM = r103;
        f186975a = new Subunits[]{r100, r101, r102, r103};
    }

    public static Subunits valueOf(String r100) {
        return (Subunits) a.a(Subunits.class, r100);
    }

    public static Subunits[] values() {
        return (Subunits[]) f186975a.clone();
    }

    public Subunits(String r100, int r101) {
        super(r100, r101);
    }
}
