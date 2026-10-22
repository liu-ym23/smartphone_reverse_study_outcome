package com.bytedance.android.livehostapi.business.depend.livead;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ICommerceMessage;", "", "getMessageContent", "", "getMessageType", "", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICommerceMessage {
    public static final long ADD_ANCHOR_COMMERCE_CARD = 3;
    public static final long ADD_COMMERCE_CARD = 1;
    public static final long ADD_COMMERCE_LOTTERY = 6;
    public static final Companion Companion = null;
    public static final long DISABLE_LIVE_ANCHOR = 5;
    public static final int MSG_TYPE = 2001;
    public static final long REMOVE_COMMERCE_CARD = 2;
    public static final long UPDATE_CANDIDATE_COUNT = 7;
    public static final long UPDATE_LIVE_BUSINESS_TYPE = 4;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/ICommerceMessage$Companion;", "", "()V", "ADD_ANCHOR_COMMERCE_CARD", "", "ADD_COMMERCE_CARD", "ADD_COMMERCE_LOTTERY", "DISABLE_LIVE_ANCHOR", "MSG_TYPE", "", "REMOVE_COMMERCE_CARD", "UPDATE_CANDIDATE_COUNT", "UPDATE_LIVE_BUSINESS_TYPE", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final long ADD_ANCHOR_COMMERCE_CARD = 3;
        public static final long ADD_COMMERCE_CARD = 1;
        public static final long ADD_COMMERCE_LOTTERY = 6;
        public static final long DISABLE_LIVE_ANCHOR = 5;
        public static final int MSG_TYPE = 2001;
        public static final long REMOVE_COMMERCE_CARD = 2;
        public static final long UPDATE_CANDIDATE_COUNT = 7;
        public static final long UPDATE_LIVE_BUSINESS_TYPE = 4;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String getMessageContent();

    long getMessageType();
}
