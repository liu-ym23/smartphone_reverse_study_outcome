package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.announce.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.announcement.AnnouncementServiceImpl")
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u0000 P2\u00020\u0001:\tQRSPTUVWXJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J0\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J.\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H'JL\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&Jz\u0010 \u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!H&J\b\u0010#\u001a\u00020\u000fH&J\b\u0010$\u001a\u00020\u0002H&J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H&J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020(H&J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020(H&J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020+H&J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020-H&J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020/H&J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010&\u001a\u000201H&J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010&\u001a\u000203H&J\u0018\u00105\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&JB\u0010:\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u00108\u001a\u00020\u0002H&JM\u0010A\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00072%\b\u0002\u0010@\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010<¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u000f0;H'J \u0010D\u001a\u0004\u0018\u00010B2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010C\u001a\u0004\u0018\u00010BH&J\u001c\u0010F\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010E\u001a\u0004\u0018\u00010BH&J\u001a\u0010I\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010H\u001a\u00020GH&J\u0010\u0010K\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0002H&J\b\u0010L\u001a\u00020\u0002H&R\u0014\u0010O\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006Y"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService;", "Lcom/bytedance/android/livesdkapi/announcement/IMiddlewareAnnouncementService;", "", "enable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "announcementIsOpen", "", "secUid", "lightTheme", "requestPage", "anchorId", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAudienceAnnouncementDynamicViewHolder", "Lkotlin/Function0;", "", "announcementSwitchChangeAction", "createAnchorAnnouncementDynamicViewHolder", "enterFrom", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$EntryDialogListener;", "closeCallback", "openAnnouncementSettingEntryDialog", "isFullScreen", "enablePublishVideo", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$SettingDialogCloseAction;", "callback", "openAnnouncementSettingDialog", "liveType", "enableFanGroupMention", "backToSettingPage", "", "previewExtraLog", "openAnnouncementSettingDialogPreview", "Lio/reactivex/Observable;", "getAnnouncementObserver", "fetchAnnouncement", "enableAnnounceGroupOpt", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceChooseConfig;", "config", "openAnnouncementChooseDialogOpt", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSettingConfig;", "openAnnouncementCreateDialogOpt", "openAnnouncementUpdateDialogOpt", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceTimeChooseConfig;", "openAnnouncementDateChooseDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceRepeatWeekChooseConfig;", "openAnnouncementRepeatWeekChooseDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceMoreSettingConfig;", "openAnnouncementMoreSettingDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSubmitSuccessConfig;", "openAnnouncementCreateSuccessDialog", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceSequenceTipConfig;", "openAnnouncementSequenceTipDialog", "openAnnouncementInstructionDialog", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$DialogCloseAction;", "dialogDismissCallback", "useCacheData", "", "createAnnouncementEntryWidget", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/announce/b;", "Lkotlin/ParameterName;", "name", "newDate", "newDateCallback", "openAnnouncementTimeSettingDialog", "Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "backUp", "getAnnouncementInfo", "announcementInfo", "setAnnouncementInfo", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementStickerSetCallback;", "stickerSetCallback", "operateAnnouncementFromStickPanel", "canOpen", "changeAnnounceStickSwitchStatus", "currentAnnouncementStickerSwitchStatus", "getNeedShowFanGroupEntry", "()Z", "needShowFanGroupEntry", "Companion", "AnnouncementDialogCallback", "AnnouncementStickerSetCallback", "CloseAction", "DialogCloseAction", "EntryDialogListener", "SettingDialogCloseAction", "TimeDialogListener", "VideoBindDialogListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAnnouncementService extends IMiddlewareAnnouncementService {
    public static final Companion Companion = null;
    public static final String ENTER_FROM_ANCHOR_CENTER = "center";
    public static final String ENTER_FROM_FAN_GROUP = "fangroup";
    public static final String ENTER_FROM_LIVE_MORE = "live_more";
    public static final String ENTER_FROM_LIVE_START = "livepage";
    public static final String ENTER_FROM_LIVE_STORY = "livestory";
    public static final String ENTER_FROM_STICKER = "sticker";
    public static final String PARAMS_ANCHOR_ID = "user_id";
    public static final String PARAMS_CID = "cid";
    public static final String PARAMS_LOG_EXTRA = "log_extra";
    public static final String PARAMS_REQUEST_PAGE = "request_page";
    public static final String PARAMS_SEC_UID = "sec_uid";
    public static final String REQUEST_PAGE_DYNAMIC = "live_event";
    public static final String REQUEST_PAGE_LIVE_FOLLOW_FEED = "more_anchor_list";
    public static final String REQUEST_PAGE_LIVE_START = "live_start";
    public static final String REQUEST_PAGE_MORE_LIVE = "more_live";
    public static final String REQUEST_PAGE_TRAILER_PROP = "trailer_prop";
    public static final String TAG = "announcement";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "", "onAnnnounceListChanged", "", "closeAction", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$CloseAction;", "onBackData", "returnsInfo", "", "", "onBackFE", "onBackFansGroup", "onBackLiveStart", "onBackOtherPlace", "onJustDismiss", "onOuterDeleteStickOrExtension", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface AnnouncementDialogCallback {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void onAnnnounceListChanged(AnnouncementDialogCallback r100, CloseAction r101) {
                Intrinsics.checkNotNullParameter(r101, "closeAction");
            }

            public static void onBackData(AnnouncementDialogCallback r100, Map<String, String> r101) {
                Intrinsics.checkNotNullParameter(r101, "returnsInfo");
            }

            public static void onBackFE(AnnouncementDialogCallback r100, CloseAction r101) {
                Intrinsics.checkNotNullParameter(r101, "closeAction");
            }

            public static void onBackFansGroup(AnnouncementDialogCallback r100, Map<String, String> r101) {
                Intrinsics.checkNotNullParameter(r101, "returnsInfo");
            }

            public static void onBackLiveStart(AnnouncementDialogCallback r100, CloseAction r101) {
                Intrinsics.checkNotNullParameter(r101, "closeAction");
            }

            public static void onBackOtherPlace(AnnouncementDialogCallback r100, CloseAction r101) {
                Intrinsics.checkNotNullParameter(r101, "closeAction");
            }

            public static void onJustDismiss(AnnouncementDialogCallback r100) {
            }

            public static void onOuterDeleteStickOrExtension(AnnouncementDialogCallback r100) {
            }
        }

        void onAnnnounceListChanged(CloseAction r100);

        void onBackData(Map<String, String> r100);

        void onBackFE(CloseAction r100);

        void onBackFansGroup(Map<String, String> r100);

        void onBackLiveStart(CloseAction r100);

        void onBackOtherPlace(CloseAction r100);

        void onJustDismiss();

        void onOuterDeleteStickOrExtension();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementStickerSetCallback;", "", "setAnnouncementSticker", "", "content", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface AnnouncementStickerSetCallback {
        void setAnnouncementSticker(String r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$CloseAction;", "", "announcementInfo", "Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "(Ljava/lang/String;ILcom/bytedance/android/livesdk/announce/AnnouncementInfo;)V", "getAnnouncementInfo", "()Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "setAnnouncementInfo", "(Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;)V", "ANNOUNCE_CHANGED", "CANNOT_FIND_ANNOUNCEMENT", "BIND_VIDEO_SUCCESS", "ONLY_DISMISS", "DELETE_SUCCESS", "CREATE_SUCCESS", "UPDATE_SUCCESS", "CHANGE_SUCCESS", "CHOSEN_ANNOUNCEMENT_CHANGED", "default", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CloseAction extends Enum<CloseAction> {
        private static final /* synthetic */ CloseAction[] $VALUES = null;
        public static final CloseAction ANNOUNCE_CHANGED = null;
        public static final CloseAction BIND_VIDEO_SUCCESS = null;
        public static final CloseAction CANNOT_FIND_ANNOUNCEMENT = null;
        public static final CloseAction CHANGE_SUCCESS = null;
        public static final CloseAction CHOSEN_ANNOUNCEMENT_CHANGED = null;
        public static final CloseAction CREATE_SUCCESS = null;
        public static final CloseAction DELETE_SUCCESS = null;
        public static final CloseAction ONLY_DISMISS = null;
        public static final CloseAction UPDATE_SUCCESS = null;

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public static final CloseAction f89default = null;
        private AnnouncementInfo announcementInfo;

        /* JADX WARN: Multi-variable type inference failed */
        static {
            CloseAction r100 = new CloseAction("ANNOUNCE_CHANGED", 0, null, 1, null);
            ANNOUNCE_CHANGED = r100;
            CloseAction r101 = new CloseAction("CANNOT_FIND_ANNOUNCEMENT", 1, null, 1, null);
            CANNOT_FIND_ANNOUNCEMENT = r101;
            int r102 = 1;
            DefaultConstructorMarker r103 = null;
            CloseAction r104 = new CloseAction("BIND_VIDEO_SUCCESS", 2, 0 == true ? 1 : 0, r102, r103);
            BIND_VIDEO_SUCCESS = r104;
            CloseAction r105 = new CloseAction("ONLY_DISMISS", 3, 0 == true ? 1 : 0, r102, r103);
            ONLY_DISMISS = r105;
            CloseAction r106 = new CloseAction("DELETE_SUCCESS", 4, 0 == true ? 1 : 0, r102, r103);
            DELETE_SUCCESS = r106;
            CloseAction r107 = new CloseAction("CREATE_SUCCESS", 5, 0 == true ? 1 : 0, r102, r103);
            CREATE_SUCCESS = r107;
            CloseAction r108 = new CloseAction("UPDATE_SUCCESS", 6, 0 == true ? 1 : 0, r102, r103);
            UPDATE_SUCCESS = r108;
            CloseAction r109 = new CloseAction("CHANGE_SUCCESS", 7, 0 == true ? 1 : 0, r102, r103);
            CHANGE_SUCCESS = r109;
            CloseAction r110 = new CloseAction("CHOSEN_ANNOUNCEMENT_CHANGED", 8, 0 == true ? 1 : 0, r102, r103);
            CHOSEN_ANNOUNCEMENT_CHANGED = r110;
            CloseAction r111 = new CloseAction("default", 9, 0 == true ? 1 : 0, r102, r103);
            f89default = r111;
            $VALUES = new CloseAction[]{r100, r101, r104, r105, r106, r107, r108, r109, r110, r111};
        }

        public static CloseAction valueOf(String r100) {
            return (CloseAction) a.a(CloseAction.class, r100);
        }

        public static CloseAction[] values() {
            return (CloseAction[]) $VALUES.clone();
        }

        public final AnnouncementInfo getAnnouncementInfo() {
            return this.announcementInfo;
        }

        public final void setAnnouncementInfo(AnnouncementInfo r100) {
            this.announcementInfo = r100;
        }

        private CloseAction(String r100, int r101, AnnouncementInfo r102) {
            super(r100, r101);
            this.announcementInfo = r102;
        }

        public /* synthetic */ CloseAction(String r100, int r101, AnnouncementInfo r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$Companion;", "", "()V", "ENTER_FROM_ANCHOR_CENTER", "", "ENTER_FROM_FAN_GROUP", "ENTER_FROM_LIVE_MORE", "ENTER_FROM_LIVE_START", "ENTER_FROM_LIVE_STORY", "ENTER_FROM_STICKER", "PARAMS_ANCHOR_ID", "PARAMS_CID", "PARAMS_LOG_EXTRA", "PARAMS_REQUEST_PAGE", "PARAMS_SEC_UID", "REQUEST_PAGE_DYNAMIC", "REQUEST_PAGE_LIVE_FOLLOW_FEED", "REQUEST_PAGE_LIVE_START", "REQUEST_PAGE_MORE_LIVE", "REQUEST_PAGE_TRAILER_PROP", "TAG", "chosenAnnouncementId", "getChosenAnnouncementId", "()Ljava/lang/String;", "noDimDialogBackgroundPages", "", "dimDialogBackground", "", "requestPage", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String ENTER_FROM_ANCHOR_CENTER = "center";
        public static final String ENTER_FROM_FAN_GROUP = "fangroup";
        public static final String ENTER_FROM_LIVE_MORE = "live_more";
        public static final String ENTER_FROM_LIVE_START = "livepage";
        public static final String ENTER_FROM_LIVE_STORY = "livestory";
        public static final String ENTER_FROM_STICKER = "sticker";
        public static final String PARAMS_ANCHOR_ID = "user_id";
        public static final String PARAMS_CID = "cid";
        public static final String PARAMS_LOG_EXTRA = "log_extra";
        public static final String PARAMS_REQUEST_PAGE = "request_page";
        public static final String PARAMS_SEC_UID = "sec_uid";
        public static final String REQUEST_PAGE_DYNAMIC = "live_event";
        public static final String REQUEST_PAGE_LIVE_FOLLOW_FEED = "more_anchor_list";
        public static final String REQUEST_PAGE_LIVE_START = "live_start";
        public static final String REQUEST_PAGE_MORE_LIVE = "more_live";
        public static final String REQUEST_PAGE_TRAILER_PROP = "trailer_prop";
        public static final String TAG = "announcement";
        private static final String chosenAnnouncementId = null;
        private static final List<String> noDimDialogBackgroundPages = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            chosenAnnouncementId = "announcement_id";
            noDimDialogBackgroundPages = CollectionsKt.listOf(new String[]{"trailer_prop", "live_start"});
        }

        public final String getChosenAnnouncementId() {
            return chosenAnnouncementId;
        }

        public final boolean dimDialogBackground(String r100) {
            Intrinsics.checkNotNullParameter(r100, "requestPage");
            return !noDimDialogBackgroundPages.contains(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ AnnouncementInfo getAnnouncementInfo$default(IAnnouncementService r100, Context r101, AnnouncementInfo r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.getAnnouncementInfo(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnnouncementInfo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RecyclerView.ViewHolder createAnchorAnnouncementDynamicViewHolder$default(IAnnouncementService r100, Context r101, boolean r102, String r103, Function0 r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = AnonymousClass1.INSTANCE;
        L7:
            return r100.createAnchorAnnouncementDynamicViewHolder(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAnchorAnnouncementDynamicViewHolder");
        }

        public static /* synthetic */ void openAnnouncementSettingEntryDialog$default(IAnnouncementService r100, Context r101, boolean r102, String r103, EntryDialogListener r104, int r105, Object r106) {
            if (r106 != null) goto L12;
            if ((r105 & 4) == 0) goto L7;
            r103 = "";
        L7:
            if ((r105 & 8) == 0) goto L9;
            r104 = null;
        L9:
            r100.openAnnouncementSettingEntryDialog(r101, r102, r103, r104);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openAnnouncementSettingEntryDialog");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openAnnouncementTimeSettingDialog$default(IAnnouncementService r100, Context r101, boolean r102, String r103, Function1 r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 2) == 0) goto L7;
            r102 = false;
        L7:
            if ((r105 & 4) == 0) goto L10;
            r103 = "";
        L10:
            if ((r105 & 8) == 0) goto L12;
            r104 = C102471.INSTANCE;
        L12:
            r100.openAnnouncementTimeSettingDialog(r101, r102, r103, r104);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openAnnouncementTimeSettingDialog");
        }

        public static /* synthetic */ Object createAnnouncementEntryWidget$default(IAnnouncementService r100, Context r110, boolean r111, String r112, DialogCloseAction r113, String r114, boolean r115, boolean r116, int r117, Object r118) {
            if (r118 != null) goto L10;
            if ((r117 & 64) == 0) goto L6;
            boolean r101 = false;
        L8:
            return r100.createAnnouncementEntryWidget(r110, r111, r112, r113, r114, r115, r101);
        L6:
            r101 = r116;
            goto L8
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAnnouncementEntryWidget");
        }

        public static /* synthetic */ void openAnnouncementSettingDialog$default(IAnnouncementService r110, Context r111, boolean r112, boolean r113, String r114, String r115, boolean r116, SettingDialogCloseAction r117, int r118, Object r119) {
            if (r119 != null) goto L22;
            if ((r118 & 8) == 0) goto L6;
            String r100 = "";
        L8:
            if ((r118 & 16) == 0) goto L10;
            String r101 = "";
        L12:
            if ((r118 & 32) == 0) goto L14;
            boolean r102 = false;
        L16:
            if ((r118 & 64) == 0) goto L18;
            SettingDialogCloseAction r103 = null;
        L19:
            r110.openAnnouncementSettingDialog(r111, r112, r113, r100, r101, r102, r103);
            return;
        L18:
            r103 = r117;
            goto L19
        L14:
            r102 = r116;
            goto L16
        L10:
            r101 = r115;
            goto L12
        L6:
            r100 = r114;
            goto L8
        L22:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openAnnouncementSettingDialog");
        }

        public static /* synthetic */ void openAnnouncementSettingDialogPreview$default(IAnnouncementService r110, Context r111, boolean r112, String r113, String r114, String r210, boolean r211, boolean r212, boolean r213, boolean r214, Map r215, SettingDialogCloseAction r216, int r217, Object r218) {
            if (r218 != null) goto L31;
            if ((r217 & 4) == 0) goto L7;
            String r100 = "";
        L9:
            if ((r217 & 8) == 0) goto L11;
            String r101 = "";
        L13:
            if ((r217 & 64) == 0) goto L15;
            boolean r115 = false;
        L17:
            if ((r217 & 128) == 0) goto L19;
            boolean r116 = false;
        L21:
            if ((r217 & 256) == 0) goto L23;
            boolean r117 = false;
        L25:
            if ((r217 & 1024) == 0) goto L27;
            SettingDialogCloseAction r118 = null;
        L28:
            r110.openAnnouncementSettingDialogPreview(r111, r112, r100, r101, r210, r211, r115, r116, r117, r215, r118);
            return;
        L27:
            r118 = r216;
            goto L28
        L23:
            r117 = r214;
            goto L25
        L19:
            r116 = r213;
            goto L21
        L15:
            r115 = r212;
            goto L17
        L11:
            r101 = r114;
            goto L13
        L7:
            r100 = r113;
            goto L9
        L31:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openAnnouncementSettingDialogPreview");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$DialogCloseAction;", "", "close", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface DialogCloseAction {
        void close();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$EntryDialogListener;", "", "onClose", "", "isOpen", "", "content", "", "timeStr", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EntryDialogListener {
        void onClose(boolean r100, String r101, String r102, boolean r103);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$SettingDialogCloseAction;", "", "", "enable", "", "onAnnouncementSwitchChange", "submitSuccess", "Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "newContent", "Lcom/bytedance/android/livesdk/announce/b;", "newDate", "onAnnouncementSubmit", "onDismiss", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface SettingDialogCloseAction {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void onAnnouncementSubmit(SettingDialogCloseAction r100, boolean r101, AnnouncementInfo r102, b r103) {
            }

            public static void onAnnouncementSwitchChange(SettingDialogCloseAction r100, boolean r101) {
            }

            public static void onDismiss(SettingDialogCloseAction r100) {
            }
        }

        void onAnnouncementSubmit(boolean r100, AnnouncementInfo r101, b r102);

        void onAnnouncementSwitchChange(boolean r100);

        void onDismiss();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$TimeDialogListener;", "", "Lcom/bytedance/android/livesdk/announce/b;", "timeInfo", "", "update", "", "onClose", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface TimeDialogListener {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static /* synthetic */ void onClose$default(TimeDialogListener r100, b r101, boolean r102, int r103, Object r104) {
                if (r104 != null) goto L12;
                if ((r103 & 1) == 0) goto L7;
                r101 = null;
            L7:
                if ((r103 & 2) == 0) goto L9;
                r102 = false;
            L9:
                r100.onClose(r101, r102);
                return;
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClose");
            }
        }

        void onClose(b r100, boolean r101);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$VideoBindDialogListener;", "", "onClose", "", "update", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface VideoBindDialogListener {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static /* synthetic */ void onClose$default(VideoBindDialogListener r100, boolean r101, int r102, Object r103) {
                if (r103 != null) goto L9;
                if ((r102 & 1) == 0) goto L6;
                r101 = false;
            L6:
                r100.onClose(r101);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClose");
            }
        }

        void onClose(boolean r100);
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean announcementIsOpen(Context r100);

    void changeAnnounceStickSwitchStatus(boolean r100);

    RecyclerView.ViewHolder createAnchorAnnouncementDynamicViewHolder(Context r100, boolean r101, String r102, Function0<Unit> r103);

    Object createAnnouncementEntryWidget(Context r100, boolean r101, String r102, DialogCloseAction r103, String r104, boolean r105, boolean r106);

    RecyclerView.ViewHolder createAudienceAnnouncementDynamicViewHolder(Context r100, String r101, boolean r102, String r103, String r104);

    boolean currentAnnouncementStickerSwitchStatus();

    boolean enable();

    boolean enableAnnounceGroupOpt();

    void fetchAnnouncement();

    AnnouncementInfo getAnnouncementInfo(Context r100, AnnouncementInfo r101);

    Observable<Boolean> getAnnouncementObserver();

    boolean getNeedShowFanGroupEntry();

    void openAnnouncementChooseDialogOpt(OpenAnnounceChooseConfig r100);

    void openAnnouncementCreateDialogOpt(OpenAnnounceSettingConfig r100);

    void openAnnouncementCreateSuccessDialog(OpenAnnounceSubmitSuccessConfig r100);

    void openAnnouncementDateChooseDialog(OpenAnnounceTimeChooseConfig r100);

    void openAnnouncementInstructionDialog(Context r100, boolean r101);

    void openAnnouncementMoreSettingDialog(OpenAnnounceMoreSettingConfig r100);

    void openAnnouncementRepeatWeekChooseDialog(OpenAnnounceRepeatWeekChooseConfig r100);

    void openAnnouncementSequenceTipDialog(AnnounceSequenceTipConfig r100);

    void openAnnouncementSettingDialog(Context r100, boolean r101, boolean r102, String r103, String r104, boolean r105, SettingDialogCloseAction r106);

    void openAnnouncementSettingDialogPreview(Context r100, boolean r101, String r102, String r103, String r104, boolean r105, boolean r106, boolean r107, boolean r108, Map<String, String> r110, SettingDialogCloseAction r111);

    @Deprecated(message = "交互调整后请直接打开SettingDialog")
    void openAnnouncementSettingEntryDialog(Context r100, boolean r101, String r102, EntryDialogListener r103);

    @Deprecated(message = "交互调整后请直接打开SettingDialog")
    void openAnnouncementTimeSettingDialog(Context r100, boolean r101, String r102, Function1<? super b, Unit> r103);

    void openAnnouncementUpdateDialogOpt(OpenAnnounceSettingConfig r100);

    void operateAnnouncementFromStickPanel(Context r100, AnnouncementStickerSetCallback r101);

    void setAnnouncementInfo(Context r100, AnnouncementInfo r101);
}
