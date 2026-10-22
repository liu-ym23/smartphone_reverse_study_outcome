package com.bytedance.android.live.user;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.user.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&J(\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/user/IMiddlewareUserService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/user/e;", "user", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "Lcom/bytedance/android/live/user/VcdAuthorizationSource;", "source", "Lio/reactivex/Single;", "", "ensureVcdAuthorized", "showAuthorizeGuideDialogAfterSwitchToPortrait", "Lcom/bytedance/android/live/user/a;", "resumeShowAuthorizeGuideDialogAfterSwitchedToPortrait", PerfLog.PARAM_KEY_CONTEXT_ID, "", "content", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$AuthorizeCallback;", "callback", "", "showVcdContentGrant", "showVcdRelationshipGrant", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareUserService extends IService {
    Single<Boolean> ensureVcdAuthorized(FragmentActivity r100, VcdAuthorizationSource r101);

    Single<a> resumeShowAuthorizeGuideDialogAfterSwitchedToPortrait(FragmentActivity r100);

    boolean showAuthorizeGuideDialogAfterSwitchToPortrait(FragmentActivity r100, VcdAuthorizationSource r101);

    void showVcdContentGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103);

    void showVcdRelationshipGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103);

    e user();
}
