package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.QuickShotRecordControl, needDynamicControl = true, type = PlayerViewControl.Type.ALPHA)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickRecordWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotAndRecordBaseWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lcom/bytedance/android/livesdk/chatroom/ui/record/presenter/QuickRecordingPresenter$b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickRecordWidget extends LandscapeQuickShotAndRecordBaseWidget implements Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a, QuickRecordingPresenter.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f118927j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.record.presenter.b f118928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IAnchorBacktrackService f118929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f118930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IRoom f118931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f118932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f118933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f118934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f118935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f118936i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_quick_record_area;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void Gm() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        r100.put("data_live_quick_record_finish", Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void a1() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        r100.put("data_live_quick_record_start", Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void onShareDialogDismiss() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        r100.put("data_live_quick_record_layer_hide", Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void onShareDialogShow() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.put("data_live_quick_record_layer_show", Boolean.TRUE);
    L5:
        gr1.a r101 = jr1.c.a();
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r102 = r101.provideVSPlayerViewControlService(this.dataCenter);
        if (r102 == null) goto L12;
        r102.j(false);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L10;
        List r101 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_record_layer_show", "data_live_quick_record_layer_hide", "data_audience_backtrace_service", "data_backtrack_service"});
        if (r101 == null) goto L10;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r100.removeObserver((String) r102.next(), this);
    L10:
        this.f118935h.clear();
        com.bytedance.android.livesdk.chatroom.ui.record.presenter.b r103 = this.f118928a;
        if (r103 == null) goto L13;
        r103.f114037e = true;
    L13:
        Disposable r104 = this.f118936i;
        if (r104 == null) goto L16;
        r104.dispose();
    L16:
        this.f118933f = false;
    }

    public LandscapeQuickRecordWidget() {
        this.f118932e = true;
        this.f118934g = new CompositeDisposable();
        this.f118935h = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        com.bytedance.android.livesdk.chatroom.ui.record.presenter.b r100 = this.f118928a;
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f118932e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.record.presenter.QuickRecordingPresenter.b
    public final void lk(boolean r100) {
        f118927j = r100;
        xq(false);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        String r102 = r101.getKey();
        boolean r103 = true;
        IAnchorBacktrackService.State r104 = null;
        switch(r102.hashCode()) {
            case 118051045: goto L30;
            case 836394094: goto L20;
            case 1660640366: goto L13;
            case 1660967465: goto L6;
            default: goto L51;
        };
    L51:
        return;
    L6:
        if (r102.equals("data_live_quick_record_layer_show") == false) goto L40;
        gr1.a r105 = jr1.c.a();
        if (r105 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r106 = r105.provideVSPlayerViewControlService(this.dataCenter);
        if (r106 == null) goto L42;
        r106.j(false);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L13:
        if (r102.equals("data_live_quick_record_layer_hide") == false) goto L44;
        gr1.a r107 = jr1.c.a();
        if (r107 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r108 = r107.provideVSPlayerViewControlService(this.dataCenter);
        if (r108 == null) goto L46;
        r108.j(false);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L20:
        if (r102.equals("data_audience_backtrace_service") == false) goto L48;
        IAnchorBacktrackService r109 = this.f118929b;
        if (r109 == null) goto L25;
        r104 = r109.getState();
    L25:
        if (r104 == IAnchorBacktrackService.State.BACKTRACK_DOING) goto L28;
        r103 = false;
    L28:
        xq(r103);
        return;
    L48:
        return;
    L30:
        if (r102.equals("data_backtrack_service") == false) goto L50;
        IAnchorBacktrackService r110 = this.f118929b;
        if (r110 == null) goto L35;
        r104 = r110.getState();
    L35:
        if (r104 == IAnchorBacktrackService.State.BACKTRACK_DOING) goto L38;
        r103 = false;
    L38:
        xq(r103);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        final Function1<Boolean, Unit> r111 = new AnonymousClass1(this);
        if (oo1.i.a() == false) goto L36;
        int r100 = bs1.a.f20221a;
        Function1<Boolean, Unit> r101 = new LandscapeQuickRecordWidget$enableInsideRecord$1(r111);
        Intrinsics.checkNotNullParameter(r101, "callback");
        MediaCodecInfo[] r112 = new MediaCodecList(1).getCodecInfos();
        int r102 = r112.length;
        int r103 = 0;
        boolean r104 = true;
    L6:
        if (r103 >= r102) goto L20;
        MediaCodecInfo r105 = r112[r103];
        if (r105.isEncoder() == false) goto L19;
        if (StringsKt.contains$default(r105.getName(), "avc", false, 2, null) == false) goto L19;
        String[] r106 = r105.getSupportedTypes();
        int r107 = r106.length;
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L19;
        String r109 = r106[r108];
        if (StringsKt.equals(r109, KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE, true) == false) goto L18;
        MediaCodec.createEncoderByType(r109).release();     // Catch: Exception -> L17
    L17:
        r104 = false;
    L18:
        r108 = r108 + 1;
    L19:
        r103 = r103 + 1;
        goto L6
    L20:
        int r113 = r112.length;
        int r114 = 0;
    L21:
        if (r114 >= r113) goto L35;
        MediaCodecInfo r115 = r112[r114];
        if (r115.isEncoder() == false) goto L34;
        if (StringsKt.contains$default(r115.getName(), "aac", false, 2, null) == false) goto L34;
        String[] r116 = r115.getSupportedTypes();
        int r117 = r116.length;
        int r118 = 0;
    L27:
        if (r118 >= r117) goto L34;
        String r119 = r116[r118];
        if (StringsKt.equals(r119, "audio/mp4a-latm", true) == false) goto L33;
        MediaCodec.createEncoderByType(r119).release();     // Catch: Exception -> L32
    L32:
        r104 = false;
    L33:
        r118 = r118 + 1;
    L34:
        r114 = r114 + 1;
        goto L21
    L35:
        r101.invoke(Boolean.valueOf(r104));
        return;
    L36:
        r111.invoke(Boolean.FALSE);
    }

    public final void xq(boolean r100) {
        IRoom r101 = this.f118931d;
        if (r101 == null) goto L17;
        IRoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 == null) goto L17;
        if (r102.enableLandscapeQuickRecord() != true) goto L17;
        if (f118927j == false) goto L11;
    L13:
        View r103 = this.f118930c;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
    L16:
        UtilityKotlinExtentionsKt.z(r103, !r100);
        return;
    L11:
        if (this.f118933f == true) goto L13;
    L17:
        View r104 = this.f118930c;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("recordBtn");
    L20:
        UtilityKotlinExtentionsKt.t(r104);
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget, com.bytedance.android.live.liveinteract.c, gd0.f
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r102 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.ui.record.presenter.b r103 = this.f118928a;
        if (r103 == null) goto L9;
        r103.onActivityResult(r100, r101, r102);
        return;
    L9:
        return;
    }
}
