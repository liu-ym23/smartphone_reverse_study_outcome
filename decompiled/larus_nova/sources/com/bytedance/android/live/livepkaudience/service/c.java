package com.bytedance.android.live.livepkaudience.service;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: classes46.dex */
public interface c {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final a f82250w0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f82251a = null;

        public a() {
        }

        static {
            f82251a = new a();
        }

        public static LinkPkInteractGuestDataContext a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("linkpk_interact_guest_data_service");
            if ((r100 instanceof LinkPkInteractGuestDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (LinkPkInteractGuestDataContext) r100;
        }
    }

    static {
        f82250w0 = a.f82251a;
    }

    String getAudienceSelfLinkMicId();

    String getGuestAnchorLinkMicId();

    MutableLiveData<String> getGuestLynxListData();

    com.bytedance.android.live.pkaudience.api.d getPkAudienceLogData();

    String getSelfAnchorLinkMicId();

    Boolean hasAudienceJoinSelfAnchorLink();

    void resetLinkData();

    void setAudienceSelfLinkMicId(String r100);

    void setGameData(String r100);

    void setGuestAnchorLinkMicId(String r100, String r101);

    void setSelfAnchorLinkMicId(String r100);
}
