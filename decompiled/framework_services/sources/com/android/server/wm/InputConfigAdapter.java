package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
class InputConfigAdapter {
    private static final FlagMapping[] INPUT_FEATURE_TO_CONFIG_MAP = null;
    private static final int INPUT_FEATURE_TO_CONFIG_MASK = 0;
    private static final FlagMapping[] LAYOUT_PARAM_FLAG_TO_CONFIG_MAP = null;
    private static final int LAYOUT_PARAM_FLAG_TO_CONFIG_MASK = 0;

    private static class FlagMapping {
        final int mFlag;
        final int mInputConfig;
        final boolean mInverted;

        FlagMapping(int flag, int inputConfig, boolean inverted) {
            this.mFlag = flag;
            this.mInputConfig = inputConfig;
            this.mInverted = inverted;
        }
    }

    private InputConfigAdapter() {
    }

    static {
        INPUT_FEATURE_TO_CONFIG_MAP = new FlagMapping[]{new FlagMapping(1, 1, false), new FlagMapping(2, 2048, false), new FlagMapping(4, 16384, false), new FlagMapping(8, 262144, false)};
        INPUT_FEATURE_TO_CONFIG_MASK = computeMask(INPUT_FEATURE_TO_CONFIG_MAP);
        LAYOUT_PARAM_FLAG_TO_CONFIG_MAP = new FlagMapping[]{new FlagMapping(16, 8, false), new FlagMapping(262144, 512, false), new FlagMapping(536870912, 1024, false)};
        LAYOUT_PARAM_FLAG_TO_CONFIG_MASK = computeMask(LAYOUT_PARAM_FLAG_TO_CONFIG_MAP);
    }

    static int getMask() {
        return (LAYOUT_PARAM_FLAG_TO_CONFIG_MASK | INPUT_FEATURE_TO_CONFIG_MASK) | 64;
    }

    static int getInputConfigFromWindowParams(int type, int flags, int inputFeatures) {
        if (type != 2013) goto L5;
        int r0 = 64;
    L7:
        return (r0 | applyMapping(flags, LAYOUT_PARAM_FLAG_TO_CONFIG_MAP)) | applyMapping(inputFeatures, INPUT_FEATURE_TO_CONFIG_MAP);
    L5:
        r0 = 0;
        goto L7
    }

    private static int applyMapping(int flags, FlagMapping[] flagToConfigMap) {
        int inputConfig = 0;
        int r1 = flagToConfigMap.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        FlagMapping mapping = flagToConfigMap[r3];
        if ((mapping.mFlag & flags) == 0) goto L7;
        boolean flagSet = true;
    L9:
        if (flagSet == mapping.mInverted) goto L11;
        inputConfig = inputConfig | mapping.mInputConfig;
    L11:
        r3 = r3 + 1;
        goto L3
    L7:
        flagSet = false;
        goto L9
    L12:
        return inputConfig;
    }

    private static int computeMask(FlagMapping[] flagToConfigMap) {
        int mask = 0;
        int r1 = flagToConfigMap.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        FlagMapping mapping = flagToConfigMap[r2];
        mask = mask | mapping.mInputConfig;
        r2 = r2 + 1;
        goto L3
    L5:
        return mask;
    }
}
