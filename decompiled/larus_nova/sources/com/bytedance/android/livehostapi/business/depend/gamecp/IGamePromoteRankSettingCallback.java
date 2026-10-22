package com.bytedance.android.livehostapi.business.depend.gamecp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePromoteRankSettingCallback;", "", "onShowEntrance", "", "show", "", "onStatusChanged", "status", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGamePromoteRankSettingCallback {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.gamecp.IGamePromoteRankSettingCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onShowEntrance(IGamePromoteRankSettingCallback r100, boolean r101) {
        }

        public static /* synthetic */ void access$onShowEntrance$jd(IGamePromoteRankSettingCallback r100, boolean r101) {
            $default$onShowEntrance(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onShowEntrance(IGamePromoteRankSettingCallback r100, boolean r101) {
            CC.access$onShowEntrance$jd(r100, r101);
        }
    }

    void onShowEntrance(boolean r100);

    void onStatusChanged(int r100);
}
