package com.bytedance.android.live.user;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.UserService")
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005H&J(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J(\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J>\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH&J>\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH&¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/user/IUserService;", "Lcom/bytedance/android/live/user/IMiddlewareUserService;", "Lcom/bytedance/android/live/user/IUserServiceForSaas;", "Lcom/bytedance/android/livesdk/user/f;", "user", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "Lcom/bytedance/android/live/user/VcdAuthorizationSource;", "source", "Lio/reactivex/Single;", "", "ensureVcdAuthorized", "showAuthorizeGuideDialogAfterSwitchToPortrait", "Lcom/bytedance/android/live/user/a;", "resumeShowAuthorizeGuideDialogAfterSwitchedToPortrait", PerfLog.PARAM_KEY_CONTEXT_ID, "", "content", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$AuthorizeCallback;", "callback", "", "showVcdContentGrant", "showVcdRelationshipGrant", "Landroid/content/Context;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "enterLiveSource", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "event", "", "orientation", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroidx/fragment/app/DialogFragment;", "showLynxProfileDialog", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "showLynxProfileDialogNew", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserService extends IMiddlewareUserService, IUserServiceForSaas {
    @Override // com.bytedance.android.live.user.IMiddlewareUserService
    Single<Boolean> ensureVcdAuthorized(FragmentActivity r100, VcdAuthorizationSource r101);

    @Override // com.bytedance.android.live.user.IMiddlewareUserService
    Single<a> resumeShowAuthorizeGuideDialogAfterSwitchedToPortrait(FragmentActivity r100);

    @Override // com.bytedance.android.live.user.IMiddlewareUserService
    boolean showAuthorizeGuideDialogAfterSwitchToPortrait(FragmentActivity r100, VcdAuthorizationSource r101);

    DialogFragment showLynxProfileDialog(Context r100, Room r101, String r102, UserProfileEvent r103, int r104, DataCenter r105);

    HybridDialog showLynxProfileDialogNew(Context r100, Room r101, String r102, UserProfileEvent r103, int r104, DataCenter r105);

    @Override // com.bytedance.android.live.user.IMiddlewareUserService
    void showVcdContentGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103);

    @Override // com.bytedance.android.live.user.IMiddlewareUserService
    void showVcdRelationshipGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103);

    @Override // com.bytedance.android.live.user.IMiddlewareUserService
    f user();
}
