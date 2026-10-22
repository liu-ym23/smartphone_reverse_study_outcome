package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes2.dex */
public class CdnDeviceBandwidthSampler extends DeviceBandwidthSampler {

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class CdnDeviceBandwidthSamplerHolder {
        public static final CdnDeviceBandwidthSampler instance = null;

        private CdnDeviceBandwidthSamplerHolder() {
        }

        static {
            instance = new CdnDeviceBandwidthSampler(CdnConnectionClassManager.getInstance(), null);
        }
    }

    /* synthetic */ CdnDeviceBandwidthSampler(CdnConnectionClassManager r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static CdnDeviceBandwidthSampler getInstance() {
        return CdnDeviceBandwidthSamplerHolder.instance;
    }

    private CdnDeviceBandwidthSampler(CdnConnectionClassManager r1) {
        super(r1);
    }
}
