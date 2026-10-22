package com.bytedance.android.live.virtuallive.impl;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
public final class VirtualLynxPageUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f102602a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/virtuallive/impl/VirtualLynxPageUtil$VirtualShopTab;", "", "TRIAL", "FREE", AccountType.ALL, "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum VirtualShopTab extends Enum<VirtualShopTab> {
        public static final VirtualShopTab ALL = null;
        public static final VirtualShopTab FREE = null;
        public static final VirtualShopTab TRIAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VirtualShopTab[] f102603a = null;

        static {
            VirtualShopTab r100 = new VirtualShopTab("TRIAL", 0);
            TRIAL = r100;
            VirtualShopTab r101 = new VirtualShopTab("FREE", 1);
            FREE = r101;
            VirtualShopTab r102 = new VirtualShopTab(AccountType.ALL, 2);
            ALL = r102;
            f102603a = new VirtualShopTab[]{r100, r101, r102};
        }

        public static VirtualShopTab valueOf(String r100) {
            return (VirtualShopTab) r27.a.a(VirtualShopTab.class, r100);
        }

        public static VirtualShopTab[] values() {
            return (VirtualShopTab[]) f102603a.clone();
        }

        public VirtualShopTab(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }
}
