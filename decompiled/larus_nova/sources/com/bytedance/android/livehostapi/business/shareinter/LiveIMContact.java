package com.bytedance.android.livehostapi.business.shareinter;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact;", "", "LiveConversation", "LiveIMUser", "LiveRecentIMUsers", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveIMContact {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact$LiveConversation;", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact;", "getConversationId", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface LiveConversation extends LiveIMContact {
        String getConversationId();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact$LiveIMUser;", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact;", "getId", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface LiveIMUser extends LiveIMContact {
        String getId();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact$LiveRecentIMUsers;", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMContact;", "getLiveIMContact", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface LiveRecentIMUsers extends LiveIMContact {
        List<LiveIMContact> getLiveIMContact();
    }
}
