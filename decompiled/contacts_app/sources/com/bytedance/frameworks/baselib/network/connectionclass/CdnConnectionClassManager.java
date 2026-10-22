package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes2.dex */
public class CdnConnectionClassManager extends ConnectionClassManager {

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.connectionclass.CdnConnectionClassManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class CdnConnectionClassManaagerHolder {
        public static final CdnConnectionClassManager instance = null;

        private CdnConnectionClassManaagerHolder() {
        }

        static {
            instance = new CdnConnectionClassManager(null);
        }
    }

    /* synthetic */ CdnConnectionClassManager(AnonymousClass1 r1) {
        this();
    }

    public static CdnConnectionClassManager getInstance() {
        return CdnConnectionClassManaagerHolder.instance;
    }

    private CdnConnectionClassManager() {
    }
}
