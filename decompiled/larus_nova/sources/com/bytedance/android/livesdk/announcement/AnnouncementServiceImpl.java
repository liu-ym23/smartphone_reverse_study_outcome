package com.bytedance.android.livesdk.announcement;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcast.api.IBroadcastAnnounceService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.announcement.instruction.AnnouncementInstructionDialog;
import com.bytedance.android.livesdk.announcement.time.AnnouncementTimeSettingDialog;
import com.bytedance.android.livesdk.announcement.viewholder.AnnouncementAnchorDynamicViewHolder;
import com.bytedance.android.livesdk.announcement.viewholder.AnnouncementAudienceDynamicViewHolder;
import com.bytedance.android.livesdk.config.vd;
import com.bytedance.android.livesdk.config.vq;
import com.bytedance.android.livesdk.config.xd;
import com.bytedance.android.livesdkapi.announcement.AnnounceSequenceTipConfig;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceChooseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceMoreSettingConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceRepeatWeekChooseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceSettingConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceSubmitSuccessConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceTimeChooseConfig;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.timon.calendar.EventRecord;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 v2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\bt\u0010uJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J.\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u001c\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016JF\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J*\u0010!\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016JD\u0010'\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0016JV\u00100\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0,2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010.H\u0016J^\u00100\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0,2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010.H\u0016J\u001a\u00103\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0016JB\u00108\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001005H\u0016Jn\u0010>\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0,2\b\u0010=\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010A\u001a\u00020\u00102\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010@\u001a\u00020?H\u0016J\b\u0010C\u001a\u00020\u0010H\u0016J\u0010\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010@\u001a\u00020FH\u0016J\u0010\u0010I\u001a\u00020\u00102\u0006\u0010@\u001a\u00020HH\u0016J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010@\u001a\u00020JH\u0016J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010@\u001a\u00020LH\u0016J\u0010\u0010O\u001a\u00020\u00102\u0006\u0010@\u001a\u00020NH\u0016J\u0010\u0010Q\u001a\u00020\u00102\u0006\u0010@\u001a\u00020PH\u0016J\u0018\u0010R\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J@\u0010W\u001a\u00020V2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010T\u001a\u00020S2\u0006\u00109\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0004H\u0016JG\u0010]\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2#\u0010\\\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010X¢\u0006\f\bY\u0012\b\bZ\u0012\u0004\b\b([\u0012\u0004\u0012\u00020\u001005H\u0016J\u001e\u0010`\u001a\u0004\u0018\u00010^2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010_\u001a\u0004\u0018\u00010^H\u0016J\u001c\u0010b\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010a\u001a\u0004\u0018\u00010^H\u0016J\u0018\u0010c\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u001a\u0010f\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010e\u001a\u00020dH\u0016J\u0010\u0010h\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u0004H\u0016J\b\u0010i\u001a\u00020\u0004H\u0016R\u001b\u0010n\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR!\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00040o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010k\u001a\u0004\bq\u0010r¨\u0006x"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementServiceImpl;", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "contextIsValid", "enable", "announcementIsOpen", "", "secUid", "lightTheme", "requestPage", "anchorId", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "createAudienceAnnouncementDynamicViewHolder", "Lkotlin/Function0;", "", "announcementSwitchChangeAction", "createAnchorAnnouncementDynamicViewHolder", "secAnchorId", "subscribe", "Lio/reactivex/Observable;", "subscribeAnnouncement", "", "appointmentId", "enterFromMerge", "enterMethod", "source", "onSuccess", "Lio/reactivex/disposables/Disposable;", "subscribeAnnouncementOpt", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$EntryDialogListener;", "entryDialogListener", "openAnnouncementSettingEntryDialog", "isFullScreen", "enterFrom", "enablePublishVideo", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$SettingDialogCloseAction;", "callback", "openAnnouncementSettingDialog", DyPayConstant.KEY_START_TIME, "nickName", "", "enterFromType", "", "logParams", "", "scheduledWeekDays", "addAudienceAnnounceCalendar", "scheduled_date", "scheduled_time", "removeAudienceAnnounceCalendar", "isCycle", "Lkotlin/Function1;", "", "onFailed", "queryAnnouncementStatus", "liveType", "enableFanGroupMention", "backToSettingPage", "previewExtraLog", "closeCallback", "openAnnouncementSettingDialogPreview", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSettingConfig;", "config", "openAnnouncementCreateDialogOpt", "openAnnouncementUpdateDialogOpt", "fetchAnnouncement", "getAnnouncementObserver", "enableAnnounceGroupOpt", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceChooseConfig;", "openAnnouncementChooseDialogOpt", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceTimeChooseConfig;", "openAnnouncementDateChooseDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceRepeatWeekChooseConfig;", "openAnnouncementRepeatWeekChooseDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceMoreSettingConfig;", "openAnnouncementMoreSettingDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSubmitSuccessConfig;", "openAnnouncementCreateSuccessDialog", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceSequenceTipConfig;", "openAnnouncementSequenceTipDialog", "openAnnouncementInstructionDialog", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$DialogCloseAction;", "dialogDismissCallback", "useCacheData", "", "createAnnouncementEntryWidget", "Lcom/bytedance/android/livesdk/announce/b;", "Lkotlin/ParameterName;", "name", "newDate", "newDateCallback", "openAnnouncementTimeSettingDialog", "Lcom/bytedance/android/livesdk/announce/AnnouncementInfo;", "backUp", "getAnnouncementInfo", "announcementInfo", "setAnnouncementInfo", "logAnnouncementShow", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementStickerSetCallback;", "stickerSetCallback", "operateAnnouncementFromStickPanel", "canOpen", "changeAnnounceStickSwitchStatus", "currentAnnouncementStickerSwitchStatus", "needShowFanGroupEntry$delegate", "Lkotlin/Lazy;", "getNeedShowFanGroupEntry", "()Z", "needShowFanGroupEntry", "Lcom/bytedance/android/livesdkapi/depend/prefs/Property;", "stickerSwitch$delegate", "getStickerSwitch", "()Lcom/bytedance/android/livesdkapi/depend/prefs/Property;", "stickerSwitch", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnnouncementServiceImpl implements IAnnouncementService {
    public static final a Companion = null;
    public static final int EXP1 = 1;
    public static final int ONLINE = 0;
    public static final String TAG = "AnnouncementServiceImpl";
    private final Lazy needShowFanGroupEntry$delegate;
    private final Lazy stickerSwitch$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements AnnouncementEntryDialog.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementServiceImpl f103178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f103179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IAnnouncementService.EntryDialogListener f103180c;

        @Override // com.bytedance.android.livesdk.announcement.AnnouncementEntryDialog.b
        public final void onClose() {
            AnnouncementInfo r100 = this.f103178a.getAnnouncementInfo(this.f103179b, null);
            if (r100 == null) goto L15;
            IAnnouncementService.EntryDialogListener r101 = this.f103180c;
            if (r101 == null) goto L16;
            boolean r102 = r100.switchStatus;
            String r103 = r100.content;
            String r104 = r100.scheduledTimeText;
            if (r100.getEditContent() == false) goto L9;
        L12:
            boolean r105 = true;
        L13:
            r101.onClose(r102, r103, r104, r105);
            return;
        L9:
            if (r100.getEditTime() == true) goto L12;
            r105 = false;
            goto L13
        L16:
            return;
        }

        public b(AnnouncementServiceImpl r100, Context r101, IAnnouncementService.EntryDialogListener r102) {
            this.f103178a = r100;
            this.f103179b = r101;
            this.f103180c = r102;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementViewModel f103181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f103182b;

        public c(AnnouncementViewModel r100, Function1 r101) {
            this.f103181a = r100;
            this.f103182b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
            this.f103182b.invoke(this.f103181a.getDateInfo().getValue());
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f103183a = null;

        static {
            f103183a = new d();
        }

        public d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AnnouncementViewModel.c r101 = (AnnouncementViewModel.c) r100;
            if (r101 == null) goto L6;
            String r102 = r101.f103314a;
            if (r102 == null) goto L6;
        L7:
            f2.c(r102, 0);
            return;
        L6:
            r102 = "";
            goto L7
        }
    }

    public static final class e implements IAnnouncementService.TimeDialogListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementViewModel f103184a;

        public e(AnnouncementViewModel r100) {
            this.f103184a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.TimeDialogListener
        public final void onClose(com.bytedance.android.livesdk.announce.b r100, boolean r110) {
            if (r110 == false) goto L5;
            this.f103184a.updateDateInfo(r100);
            AnnouncementViewModel.submitAnnouncement$default(this.f103184a, 0, true, false, false, null, 29, null);
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementViewModel f103185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnnouncementServiceImpl f103186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f103187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AnnouncementViewModel f103188d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ IAnnouncementService.AnnouncementStickerSetCallback f103189e;

        public f(AnnouncementViewModel r100, AnnouncementServiceImpl r101, Context r102, AnnouncementViewModel r103, IAnnouncementService.AnnouncementStickerSetCallback r104) {
            this.f103185a = r100;
            this.f103186b = r101;
            this.f103187c = r102;
            this.f103188d = r103;
            this.f103189e = r104;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            AnnouncementInfo r111 = (AnnouncementInfo) r110;
            if (r111 != null) goto L5;
        L17:
            ALogger.d("announcement", "operateAnnouncementFromStickPanel invalid context observer announce info");
            return;
        L5:
            if (AnnouncementServiceImpl.access$contextIsValid(this.f103186b, this.f103187c) == false) goto L17;
            if (r111.auditStatus == 3) goto L10;
        L16:
            ALogger.d("announcement", "operateAnnouncementFromStickPanel ->  announcement audit status not passed! popup entry dialog");
            this.f103185a.getAnnouncementInfo().removeObservers((LifecycleOwner) this.f103187c);
            IAnnouncementService.DefaultImpls.openAnnouncementSettingDialog$default(this.f103186b, this.f103187c, false, false, "trailer_prop", "sticker", false, new com.bytedance.android.livesdk.announcement.g(this), 32, null);
            return;
        L10:
            if (r111.switchStatus == false) goto L16;
            com.bytedance.android.livesdk.announce.b r112 = this.f103188d.getDateInfo().getValue();
            ALogger.d("announcement", "operateAnnouncementFromStickPanel ->  announcement audit passed!");
            if (r112 != null) goto L14;
            return;
        L14:
            if (r112.e() == false) goto L20;
            ALogger.d("announcement", "operateAnnouncementFromStickPanel -> set announcement sticker time : " + r112.b());
            this.f103189e.setAnnouncementSticker(r112.b());
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f103190a;

        public g(Function1 r100) {
            this.f103190a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f103190a.invoke(Boolean.valueOf(((AnnouncementApi.QueryAnnouncementInfoResoponseOpt) ((BaseResponse) r100).data).getHasSubscribed()));
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f103191a;

        public h(Function1 r100) {
            this.f103191a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Function1 r101 = this.f103191a;
            r101.invoke((Throwable) r100);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f103192a;

        public i(Function0 r100) {
            this.f103192a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseResponse r101 = (BaseResponse) r100;
            this.f103192a.invoke();
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f103193a = null;

        static {
            f103193a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("announcement", String.valueOf(((Throwable) r100).toString()));
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f103194a;

        public k(Function0 r100) {
            this.f103194a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseResponse r101 = (BaseResponse) r100;
            this.f103194a.invoke();
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f103195a = null;

        static {
            f103195a = new l();
        }

        public l() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("announcement", String.valueOf(((Throwable) r100).toString()));
        }
    }

    static {
        Companion = new a();
    }

    private final Property<Boolean> getStickerSwitch() {
        return (Property) this.stickerSwitch$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public boolean getNeedShowFanGroupEntry() {
        return ((Boolean) this.needShowFanGroupEntry$delegate.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public boolean enable() {
        return vd.f121439a.getValue().booleanValue();
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public boolean enableAnnounceGroupOpt() {
        IBroadcastAnnounceService r100 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.enableAnnounceGroupOpt();
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void fetchAnnouncement() {
        IBroadcastAnnounceService r100 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r100 == null) goto L6;
        r100.fetchAnnouncement();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public Observable<Boolean> getAnnouncementObserver() {
        IBroadcastAnnounceService r100 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAnnouncementObserver();
    }

    public AnnouncementServiceImpl() {
        jc1.k.l(IAnnouncementService.class, this);
        ALogger.d("announcement", "register announcement service impl");
        this.needShowFanGroupEntry$delegate = LazyKt.lazy(AnnouncementServiceImpl$needShowFanGroupEntry$2.INSTANCE);
        this.stickerSwitch$delegate = LazyKt.lazy(AnnouncementServiceImpl$stickerSwitch$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public boolean currentAnnouncementStickerSwitchStatus() {
        return getStickerSwitch().getValue().booleanValue();
    }

    private final boolean contextIsValid(Context r100) {
        if ((r100 instanceof Activity) == true) goto L5;
        Context r101 = null;
    L6:
        Activity r102 = (Activity) r101;
        boolean r103 = r100 instanceof LifecycleOwner;
        if (r100 == null) goto L13;
        if (r103 == false) goto L13;
        if (r102 == null) goto L13;
        if (r102.isFinishing() == true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r101 = r100;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public boolean announcementIsOpen(Context r100) {
        if (r100 != null) goto L6;
        ALogger.d("announcement", "announcementIsOpen ->  null context");
        return false;
    L6:
        AnnouncementInfo r101 = getAnnouncementInfo(r100, null);
        if (r101 != null) goto L10;
        ALogger.d("announcement", "announcementIsOpen ->  null announcement info");
        return false;
    L10:
        ALogger.d("announcement", "announcementIsOpen -> enable : " + enable() + " ; isValid : " + r101.isValid() + " ; time text : " + r101.scheduledTimeText + " ; audit status : " + r101.auditStatus + "; stickerSwitch : " + getStickerSwitch().getValue());
        if (enable() == true) goto L13;
        return false;
    L13:
        if (r101.isValid() == true) goto L15;
        return false;
    L15:
        if (r101.switchStatus == true) goto L17;
        return false;
    L17:
        if (r101.scheduledTimeText.length() <= 0) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == true) goto L22;
        return false;
    L22:
        if (r101.auditStatus == 3) goto L24;
        return false;
    L24:
        if (getStickerSwitch().getValue().booleanValue() == false) goto L32;
        return true;
    L32:
        return false;
    L19:
        r102 = false;
        goto L20
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void changeAnnounceStickSwitchStatus(boolean r100) {
        ALogger.d("announcement", "changeAnnounceStickSwitchStatus canOpen : " + r100);
        getStickerSwitch().setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementChooseDialogOpt(OpenAnnounceChooseConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementChooseDialogOpt(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementCreateDialogOpt(OpenAnnounceSettingConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementCreateDialogOpt(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementCreateSuccessDialog(OpenAnnounceSubmitSuccessConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementCreateSuccessDialog(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementDateChooseDialog(OpenAnnounceTimeChooseConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementDateChooseDialog(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementMoreSettingDialog(OpenAnnounceMoreSettingConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementMoreSettingDialog(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementRepeatWeekChooseDialog(OpenAnnounceRepeatWeekChooseConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementRepeatWeekChooseDialog(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementSequenceTipDialog(AnnounceSequenceTipConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementSequenceTipDialog(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementUpdateDialogOpt(OpenAnnounceSettingConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        IBroadcastAnnounceService r101 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r101 == null) goto L6;
        r101.openAnnouncementUpdateDialogOpt(r100);
        return;
    }

    public static final /* synthetic */ boolean access$contextIsValid(AnnouncementServiceImpl r100, Context r101) {
        return r100.contextIsValid(r101);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public AnnouncementInfo getAnnouncementInfo(Context r100, AnnouncementInfo r101) {
        ALogger.d("announcement", "getAnnouncementInfo");
        AnnouncementViewModel.Companion.getClass();
        AnnouncementViewModel r102 = AnnouncementViewModel.a.a(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        AnnouncementInfo r103 = r102.getAnnouncementInfo().getValue();
        if (r103 != null) goto L11;
        if (r101 == null) goto L11;
        ALogger.d("announcement", "getAnnouncementInfo : use default announce info -> " + r101);
        r102.getAnnouncementInfo().setValue(r101);
        return r101;
    L11:
        if (r103 != null) goto L13;
        ALogger.d("announcement", "announcement service : get announcement info null");
    L13:
        return r103;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService
    public void logAnnouncementShow(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        ALogger.d("announcement", "logAnnouncementShow -> requestPage : " + r100 + "  anchorId : " + r101);
        int r102 = com.bytedance.android.livesdk.announcement.f.f103363a;
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        HashMap r103 = new HashMap();
        r103.put("request_page", r100);
        r103.put("author_id", r101);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_user_show", r103, new Object[0]);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementInstructionDialog(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = AnnouncementInstructionDialog.f103510g;
        AnnouncementInstructionDialog.a.b(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void operateAnnouncementFromStickPanel(Context r110, IAnnouncementService.AnnouncementStickerSetCallback r111) {
        Intrinsics.checkNotNullParameter(r111, "stickerSetCallback");
        ALogger.d("announcement", "operateAnnouncementFromStickPanel");
        if (contextIsValid(r110) == true) goto L6;
        ALogger.d("announcement", "operateAnnouncementFromStickPanel invalid context");
        return;
    L6:
        AnnouncementViewModel.Companion.getClass();
        AnnouncementViewModel r100 = AnnouncementViewModel.a.a(r110);
        if (r100 != null) goto L9;
        return;
    L9:
        NextLiveData<AnnouncementInfo> r101 = r100.getAnnouncementInfo();
        if (r110 == 0) goto L14;
        r101.observe((LifecycleOwner) r110, new f(r100, this, r110, r100, r111));
        AnnouncementViewModel.fetchAnnouncementInfo$default(r100, false, 1, null);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService
    public void removeAudienceAnnounceCalendar(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "appointmentId");
        Activity r100 = com.bytedance.android.live.core.utils.a.d();
        boolean r101 = false;
        if ((r100 instanceof FragmentActivity) == true) goto L9;
        StringBuilder r112 = new StringBuilder("create AnnouncementSettingDialogOpt, invalid context: ");
        if (r100 != null) goto L7;
        r101 = true;
    L7:
        r112.append(r101);
        ALogger.e(TAG, r112.toString());
        return;
    L9:
        int r102 = x0.f103638a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "appointmentId");
        if (vq.f121470a.getValue().booleanValue() == false) goto L56;
        com.bytedance.android.livesdk.calendar.b r103 = new com.bytedance.android.livesdk.calendar.b(r100);
        Intrinsics.checkNotNullParameter(r111, "appointmentId");
        String r113 = x0.c(r111);
        Intrinsics.checkNotNullParameter(r113, com.heytap.mcssdk.constant.b.f276361k);
        Activity r104 = null;
    L24:
        th = move-exception;
        ALogger.throwable(5, "CalendarManager", "failed to get calendar event, eventId=" + r113, th);
        ALogger.e("CalendarManager", "failed to get calendar event, eventId=" + r113);
        Pair r105 = TuplesKt.to(ICalendarManager.ErrorCode.Unknown, null);
    L26:
        StringBuilder r106 = new StringBuilder("key is ");
        r106.append(r113);
        r106.append(", status is ");
        if (r105 == null) goto L31;
        ICalendarManager.ErrorCode r114 = (ICalendarManager.ErrorCode) r105.getFirst();
        if (r114 == null) goto L31;
        Integer r115 = Integer.valueOf(r114.getValue());
    L32:
        r106.append(r115);
        ALogger.i("AudienceAnnounceCalendarUtil", r106.toString());
        if (r105 == null) goto L39;
        ICalendarManager.ErrorCode r116 = (ICalendarManager.ErrorCode) r105.getFirst();
        if (r116 == null) goto L39;
        if (r116.equals(ICalendarManager.ErrorCode.Success) != true) goto L39;
        r101 = true;
    L39:
        if (r101 == true) goto L42;
        ALogger.i("AudienceAnnounceCalendarUtil", r111.concat(" is not exist, return"));
        return;
    L42:
        if (r103.a() != true) goto L44;
        x0.e(r103, r111);
        return;
    L44:
        IHostApp r117 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r117 == null) goto L47;
        r104 = r117.getCurrentActivity();
    L47:
        if (r104 == null) goto L55;
        int r118 = x0.f103638a;
        x0.f(r104, r103, r100, false, null, new LinkedHashMap(), r111);
        return;
    L55:
        return;
    L31:
        r115 = null;
        goto L32
    L14:
        if (r113.length() != 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        r105 = TuplesKt.to(ICalendarManager.ErrorCode.ArgumentError, null);     // Catch: Throwable -> L24
    L50:
        goto L26
    L19:
        EventRecord r108 = com.bytedance.timon.calendar.c.d(r113);     // Catch: Throwable -> L24
        if (r108 == null) goto L22;
        ICalendarManager.ErrorCode r109 = ICalendarManager.ErrorCode.Success;     // Catch: Throwable -> L24
        ICalendarManager.EventRecord r119 = new ICalendarManager.EventRecord();     // Catch: Throwable -> L24
        r119.setEventId(r108.f());     // Catch: Throwable -> L24
        long r120 = 1000;
        r119.setStartTime(r108.m() / r120);     // Catch: Throwable -> L24
        r119.setEndTime(r108.e() / r120);     // Catch: Throwable -> L24
        r119.setTitle(r108.n());     // Catch: Throwable -> L24
        r119.setDescription(r108.d());     // Catch: Throwable -> L24
        r119.setAlarmMinutes(r108.a());     // Catch: Throwable -> L24
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r105 = TuplesKt.to(r109, r119);     // Catch: Throwable -> L24
        goto L50
    L22:
        r105 = TuplesKt.to(ICalendarManager.ErrorCode.NotFound, null);     // Catch: Throwable -> L24
        goto L50
    L16:
        r107 = false;
        goto L17
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void setAnnouncementInfo(Context r100, AnnouncementInfo r101) {
        ALogger.d("announcement", "setAnnouncementInfo");
        if (xd.f121594a.getValue().booleanValue() == true) goto L8;
        AnnouncementViewModel.Companion.getClass();
        AnnouncementViewModel r102 = AnnouncementViewModel.a.a(r100);
        if (r102 == null) goto L9;
        AnnouncementViewModel.updateAnnounceAndDateInfo$default(r102, r101, false, 2, null);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService
    public Observable<?> subscribeAnnouncement(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "secAnchorId");
        ALogger.d("announcement", "subscribeAnnouncement ->  secAnchorId : " + r100 + " ; subscribe : " + r101);
        return ((AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class)).subscribeAnnouncement(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public RecyclerView.ViewHolder createAnchorAnnouncementDynamicViewHolder(Context r100, boolean r101, String r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "announcementSwitchChangeAction");
        ALogger.d("announcement", "createAnchorAnnouncementDynamicViewHolder ->  lightTheme : " + r101);
        return new AnnouncementAnchorDynamicViewHolder(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementSettingEntryDialog(Context r100, boolean r101, String r102, IAnnouncementService.EntryDialogListener r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "requestPage");
        ALogger.d("announcement", "openAnnouncementSettingEntryDialog -> requestPage : " + r102);
        int r104 = AnnouncementEntryDialog.f103141k;
        b r105 = new b(this, r100, r103);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "requestPage");
        Intrinsics.checkNotNullParameter(r105, "closeCallback");
        Intrinsics.checkNotNullParameter("", "liveType");
        if ((r100 instanceof FragmentActivity) == false) goto L18;
        FragmentManager r106 = ((FragmentActivity) r100).getSupportFragmentManager();
        if ((r106.findFragmentByTag("AnnouncementEntryDialog") instanceof AnnouncementEntryDialog) == false) goto L15;
        Fragment r107 = r106.findFragmentByTag("AnnouncementEntryDialog");
        if (r107 == null) goto L14;
        AnnouncementEntryDialog r108 = (AnnouncementEntryDialog) r107;
        if (r108.isAdded() == true) goto L19;
        AnnouncementEntryDialog.a.a(r108, r106);
        return;
    L19:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.announcement.AnnouncementEntryDialog");
    L15:
        AnnouncementEntryDialog r109 = new AnnouncementEntryDialog();
        r109.f103145g = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r109.f103143e = r102;
        r109.f103144f = r105;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        AnnouncementEntryDialog.a.a(r109, r106);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementTimeSettingDialog(Context r100, boolean r101, String r110, Function1<? super com.bytedance.android.livesdk.announce.b, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "requestPage");
        Intrinsics.checkNotNullParameter(r111, "newDateCallback");
        ALogger.d("announcement", "openAnnouncementTimeSettingDialog ->  requestPage : " + r110);
        if (contextIsValid(r100) == true) goto L6;
        ALogger.d("announcement", "openAnnouncementTimeSettingDialog invalid context");
        return;
    L6:
        AnnouncementViewModel.Companion.getClass();
        AnnouncementViewModel r102 = AnnouncementViewModel.a.a(r100);
        if (r102 == null) goto L13;
        NextLiveData<AnnouncementViewModel.c> r103 = r102.getSubmitTip();
        if (r100 == 0) goto L12;
        LifecycleOwner r104 = (LifecycleOwner) r100;
        r103.observe(r104, d.f103183a);
        r102.getSubmitStatus().observe(r104, new c(r102, r111));
        com.bytedance.android.livesdk.announce.b r105 = r102.getDateInfo().getValue();
        e r106 = new e(r102);
        int r112 = AnnouncementTimeSettingDialog.f103570l;
        AnnouncementTimeSettingDialog.a.b(r100, r105, r106, r101, r110, false);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService
    public Disposable queryAnnouncementStatus(long r100, boolean r110, Function1<? super Boolean, Unit> r111, Function1<? super Throwable, Unit> r112) {
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        Intrinsics.checkNotNullParameter(r112, "onFailed");
        return RxUtilKt.h(AnnouncementApi.CC.queryAnnouncementInfoOpt$default((AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class), r100, false, r110, 2, null).compose(RxUtil.rxSchedulerHelper())).subscribe(new g(r111), new h(r112));
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public RecyclerView.ViewHolder createAudienceAnnouncementDynamicViewHolder(Context r100, String r110, boolean r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "secUid");
        Intrinsics.checkNotNullParameter(r112, "requestPage");
        Intrinsics.checkNotNullParameter(r113, "anchorId");
        ALogger.d("announcement", "createAudienceAnnouncementDynamicViewHolder ->  requestPage : " + r112 + ", lightTheme : " + r111);
        return new AnnouncementAudienceDynamicViewHolder(r100, r110, r111, r112, r113);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService
    public Disposable subscribeAnnouncementOpt(long r100, String r101, String r102, boolean r103, String r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r105, "onSuccess");
        ALogger.d("announcement", "subscribeAnnouncement ->  appointmentId : " + r100 + " ; subscribe : " + r103);
        if (r103 == false) goto L7;
        return RxUtilKt.h(((AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class)).subscribeAnnouncementOpt(Long.valueOf(r100), r101, r102, r104)).subscribe(new i(r105), j.f103193a);
    L7:
        return RxUtilKt.h(((AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class)).unSubscribeAnnouncementOpt(Long.valueOf(r100), r101, r102, r104)).subscribe(new k(r105), l.f103195a);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService
    public boolean addAudienceAnnounceCalendar(Context r110, long r111, String r112, String r113, int r114, Map<String, String> r115, List<Integer> r116) {
        Intrinsics.checkNotNullParameter(r112, "anchorId");
        Intrinsics.checkNotNullParameter(r113, "nickName");
        Intrinsics.checkNotNullParameter(r115, "logParams");
        Activity r100 = com.bytedance.android.live.core.utils.a.d();
        if ((r100 instanceof FragmentActivity) == true) goto L11;
        StringBuilder r101 = new StringBuilder("create AnnouncementSettingDialogOpt, invalid context: ");
        if (r100 != null) goto L7;
        boolean r102 = true;
    L8:
        r101.append(r102);
        ALogger.e(TAG, r101.toString());
        return false;
    L7:
        r102 = false;
        goto L8
    L11:
        return x0.a(r100, r114, r111, r112, r113, r115, r116);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public Object createAnnouncementEntryWidget(Context r100, boolean r110, String r111, IAnnouncementService.DialogCloseAction r112, String r113, boolean r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "requestPage");
        Intrinsics.checkNotNullParameter(r112, "dialogDismissCallback");
        Intrinsics.checkNotNullParameter(r113, "liveType");
        ALogger.d("announcement", "createAnnouncementEntryWidget -> requestPage : " + r111);
        return new AnnouncementEntryWidget(r110, r111, r112, r113, r114, r115);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementSettingDialog(Context r100, boolean r101, boolean r102, String r103, String r110, boolean r111, IAnnouncementService.SettingDialogCloseAction r112) {
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        ALogger.d("announcement", "openAnnouncementSettingDialog ->  enterFrom: " + r110);
        AnnouncementSettingDialog2.a r104 = AnnouncementSettingDialog2.f103227y;
        boolean r105 = getNeedShowFanGroupEntry();
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter("", "liveType");
        boolean r106 = false;
        if (r100 != null) goto L5;
    L18:
        StringBuilder r107 = new StringBuilder("create AnnouncementSettingDialog2, invalid context: ");
        if (r100 != null) goto L21;
        r106 = true;
    L21:
        r107.append(r106);
        ALogger.e("AnnouncementCreateDialog", r107.toString());
        return;
    L5:
        if ((r100 instanceof FragmentActivity) == false) goto L18;
        FragmentManager r108 = ((FragmentActivity) r100).getSupportFragmentManager();
        if ((r108.findFragmentByTag("AnnouncementCreateDialog") instanceof AnnouncementSettingDialog2) == false) goto L17;
        Fragment r109 = r108.findFragmentByTag("AnnouncementCreateDialog");
        if (r109 == null) goto L16;
        AnnouncementSettingDialog2 r113 = (AnnouncementSettingDialog2) r109;
        if (r113.isAdded() == true) goto L25;
        AnnouncementSettingDialog2.a.a(r113, r108);
        return;
    L25:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.announcement.AnnouncementSettingDialog2");
    L17:
        AnnouncementSettingDialog2 r114 = new AnnouncementSettingDialog2();
        r114.f103232h = r101;
        r114.f103241q = r103;
        r114.f103242r = r110;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r114.f103231g = "";
        r114.f103230f = false;
        r114.f103235k = r112;
        r114.f103233i = r102;
        r114.f103234j = r105;
        r114.f103237m = r111;
        AnnouncementSettingDialog2.a.a(r114, r108);
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IMiddlewareAnnouncementService
    public boolean addAudienceAnnounceCalendar(Context r110, String r111, String r112, String r113, String r114, int r115, Map<String, String> r116, List<Integer> r117) {
        Intrinsics.checkNotNullParameter(r111, "scheduled_date");
        Intrinsics.checkNotNullParameter(r112, "scheduled_time");
        Intrinsics.checkNotNullParameter(r113, "anchorId");
        Intrinsics.checkNotNullParameter(r114, "nickName");
        Intrinsics.checkNotNullParameter(r116, "logParams");
        Activity r100 = com.bytedance.android.live.core.utils.a.d();
        if ((r100 instanceof FragmentActivity) == true) goto L13;
        StringBuilder r101 = new StringBuilder("create AnnouncementSettingDialogOpt, invalid context: ");
        if (r100 != null) goto L7;
        boolean r102 = true;
    L8:
        r101.append(r102);
        ALogger.e(TAG, r101.toString());
        return false;
    L7:
        r102 = false;
        goto L8
    L13:
        return x0.a(r100, r115, x0.h(r111, r112), r113, r114, r116, r117);
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService
    public void openAnnouncementSettingDialogPreview(Context r100, boolean r101, String r102, String r103, String r104, boolean r105, boolean r106, boolean r110, boolean r111, Map<String, String> r112, IAnnouncementService.SettingDialogCloseAction r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "requestPage");
        Intrinsics.checkNotNullParameter(r103, "enterFrom");
        Intrinsics.checkNotNullParameter(r104, "liveType");
        Intrinsics.checkNotNullParameter(r112, "previewExtraLog");
        ALogger.d("announcement", "openAnnouncementSettingDialog ->  enterFrom: " + r103);
        AnnouncementSettingDialog2.a r107 = AnnouncementSettingDialog2.f103227y;
        AnnouncementSettingDialog2.a.b(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113);
    }
}
