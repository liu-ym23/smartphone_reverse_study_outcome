package com.obric.memorydata.sdk.awareness;

/* JADX INFO: compiled from: HomeCompanyAddressLearningSharedState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HomeCompanyAddressLearningSharedState {
    public static final int AUTO_LEARN_STATE_DISABLED = 0;
    public static final int AUTO_LEARN_STATE_ENABLED = 1;
    public static final int AUTO_LEARN_STATE_UNKNOWN = -1;
    public static final HomeCompanyAddressLearningSharedState INSTANCE = null;
    public static final String KEY_AUTO_LEARN_STATE = "memorydata_home_company_auto_learn_state";
    public static final String KEY_COMPANY_LEARNING_STATUS = "memorydata_company_address_learning_status";
    public static final String KEY_HOME_LEARNING_STATUS = "memorydata_home_address_learning_status";
    public static final int LEARNING_STATUS_DISABLED = 0;
    public static final int LEARNING_STATUS_LEARNED = 2;
    public static final int LEARNING_STATUS_LEARNING = 1;
    public static final int LEARNING_STATUS_UNKNOWN = -1;

    static {
        INSTANCE = new HomeCompanyAddressLearningSharedState();
    }

    private HomeCompanyAddressLearningSharedState() {
    }
}
