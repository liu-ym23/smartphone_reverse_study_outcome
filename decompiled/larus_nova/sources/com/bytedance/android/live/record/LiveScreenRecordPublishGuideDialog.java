package com.bytedance.android.live.record;

import am2.x;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.live.room.api.record.f;
import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import com.bytedance.android.live.room.api.record.guide.b;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.share.QzonePublish;
import hd0.c;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/record/LiveScreenRecordPublishGuideDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Lcom/bytedance/android/live/room/api/record/guide/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveScreenRecordPublishGuideDialog extends CommonStandardBottomDialog implements b {
    public static final /* synthetic */ int G = 0;
    public final String B;
    public final CompositeDisposable C;
    public View D;
    public ImageView E;
    public final PublishDialogInfo F;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_screen_record_publish_guide;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.C.clear();
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void W0(boolean r100) {
        if (r100 == false) goto L6;
        IInteractivityInjectService r101 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r101 == null) goto L9;
        r101.muteLivePlayerClient();
    L9:
        LiveScreenRecordGuideConfig.f99094c.getClass();
        if (((Boolean) LiveScreenRecordGuideConfig.f99093b.getValue()).booleanValue() == true) goto L12;
        return;
    L12:
        if (c.f().h() == true) goto L14;
        return;
    L14:
        if (r100 == false) goto L20;
        IPushStreamService r102 = (IPushStreamService) k.f(IPushStreamService.class);
        if (r102 == null) goto L28;
        com.bytedance.android.live.pushstream.d r103 = r102.getPushLiveStream();
        if (r103 == null) goto L29;
        r103.J0(LiveCommonConstants.REASON_SCREEN_RECORD_PREVIEW, new uv0.a(LiveRequestSourceRole.Business, "LiveScreenRecordPublishGuideDialog.mutePlayerClient", null));
        return;
    L29:
        return;
    L28:
        return;
    L20:
        IPushStreamService r104 = (IPushStreamService) k.f(IPushStreamService.class);
        if (r104 == null) goto L31;
        com.bytedance.android.live.pushstream.d r105 = r104.getPushLiveStream();
        if (r105 == null) goto L32;
        r105.q1(LiveCommonConstants.REASON_SCREEN_RECORD_PREVIEW, new uv0.a(LiveRequestSourceRole.Business, "LiveScreenRecordPublishGuideDialog.mutePlayerClient", null));
        return;
    L32:
        return;
    L31:
        return;
    L6:
        IInteractivityInjectService r106 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r106 == null) goto L9;
        r106.unmuteLivePlayerClient();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        if (r102 == null) goto L7;
        r102.dimAmount = 0.0f;
    L7:
        this.D = findViewById(R.id.llPublish);
        this.E = (ImageView) findViewById(R.id.ivThumb);
        View r103 = this.D;
        if (r103 == null) goto L10;
        r103.setOnClickListener(new lx0.b(this));
    L10:
        String r104 = this.B;
        int r105 = f.f99104a;
        Intrinsics.checkNotNullParameter(r104, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        MediaMetadataRetriever r106 = null;
        String r107 = null;
        r107 = null;
        if (FileUtils.isFileEmpty(r104) == false) goto L64;
    L33:
        Observable r108 = null;
    L34:
        if (r108 == null) goto L42;
        Observable r109 = r108.subscribeOn(Schedulers.io());
        if (r109 == null) goto L42;
        Observable r110 = RxUtilKt.h(r109);
        if (r110 == null) goto L42;
        Disposable r111 = r110.subscribe(new lx0.c(this));
        if (r111 == null) goto L42;
        com.bytedance.revenue.platform.api.core.rx.f.a(r111, this.C);
    L42:
        Pair[] r112 = new Pair[4];
        r112[0] = TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        r112[1] = TuplesKt.to("module_name", "comment_highlight_publish_guide");
        r112[2] = TuplesKt.to("highlights_content_id", (String) this.F.f99108d.getValue());
        DataCenter r113 = this.F.f99107c;
        if (r113 == null) goto L47;
        Room r114 = z.o(r113);
        if (r114 == null) goto L47;
        r107 = r114.getIdStr();
    L47:
        r112[3] = TuplesKt.to("room_id", String.valueOf(r107));
        j0.l().sendLog("livesdk_comment_highlight_module_show", MapsKt.mutableMapOf(r112), new Object[]{IRoom.class, x.class});
        return;
    L64:
        MediaMetadataRetriever r115 = new MediaMetadataRetriever();     // Catch: Throwable -> L23 Exception -> L25
        r115.setDataSource(r104);     // Catch: Throwable -> L19 Exception -> L21
        r108 = Observable.just(r115.getFrameAtTime(0, 2));     // Catch: Throwable -> L19 Exception -> L21
        r115.release();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r115 == null) goto L33;
        r115.release();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r106 = r115;
    L49:
        if (r106 != null) goto L55;
    L54:
        throw th;
    L55:
        r106.release();     // Catch: Exception -> L52
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L25:
        e = e;
        r115 = null;
    L23:
        th = th;
        goto L49
    }

    public LiveScreenRecordPublishGuideDialog(Context r100, PublishDialogInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "info");
        super(r100, false);
        this.F = r101;
        this.B = (String) r101.f99106b.getValue();
        this.C = new CompositeDisposable();
    }
}
