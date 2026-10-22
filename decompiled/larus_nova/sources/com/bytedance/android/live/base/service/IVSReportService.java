package com.bytedance.android.live.base.service;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.vs.report.VSReportServiceImpl")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dJP\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&JF\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\bH&¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/base/service/IVSReportService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IRoomData;", "room", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "userId", "", "isAnchor", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "userProfileEvent", "Lcom/bytedance/android/live/base/model/user/User;", "user", "isVertical", "Landroidx/lifecycle/ViewModel;", "dataCenter", "report", "isLive", "toUserId", "toCommentId", "reportType", "requestPage", "toCommentType", "", "logReport", "isPortrait", "loginCheck", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSReportService extends IService {
    public static final int CHAT_TYPE_COMMENT = 1;
    public static final int COMMENT_SOURCE_LIVE = 1;
    public static final int COMMENT_SOURCE_PREMIER = 2;
    public static final int COMMENT_SOURCE_RECORD = 3;
    public static final a Companion = null;
    public static final String SAVE_REPORT_ANCHOR_URL = "live.REPORT_ANCHOR_URL";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f58953a = null;

        public a() {
        }

        static {
            f58953a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ void a(IVSReportService r100, boolean r101, String r110, String r111, String r112, ViewModel r113) {
            r100.logReport(r101, r110, "", r111, r112, r113, null);
        }
    }

    static {
        Companion = a.f58953a;
    }

    void logReport(boolean r100, String r101, String r102, String r103, String r104, ViewModel r105, String r106);

    boolean loginCheck(Context r100, boolean r101);

    boolean report(IRoomData r100, Context r101, String r102, boolean r103, UserProfileEvent r104, User r105, boolean r106, ViewModel r107);
}
