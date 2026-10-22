package com.bytedance.android.livehostapi.business.depend.livead;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/IGroupPurchaseItemCallback;", "", "onFailed", "", "e", "", "onSuccess", "itemInfo", "Lcom/bytedance/android/livehostapi/business/depend/livead/GroupPurchaseItem;", "Companion", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGroupPurchaseItemCallback {
    public static final Companion Companion = null;
    public static final String REQUEST_FROM_ENTER = "enter";
    public static final String REQUEST_FROM_PUSH = "push";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/IGroupPurchaseItemCallback$Companion;", "", "()V", "REQUEST_FROM_ENTER", "", "REQUEST_FROM_PUSH", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String REQUEST_FROM_ENTER = "enter";
        public static final String REQUEST_FROM_PUSH = "push";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onFailed(Throwable r100);

    void onSuccess(GroupPurchaseItem r100);
}
