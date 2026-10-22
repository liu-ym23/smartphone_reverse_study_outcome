package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.net.Uri;
import com.bytedance.android.live.broadcast.api.model.WelfarePermissionInfo;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.android.livesdk.message.model.tn;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.WelfareProjectInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/WelfareAnchorServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareAnchorServiceWidget extends RoomRecyclableWidget implements vlc.l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f117580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f117581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f117582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f117583d;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public WelfareAnchorServiceWidget() {
        this.f117580a = LazyKt.lazy(WelfareAnchorServiceWidget$welfareApi$2.INSTANCE);
        this.f117581b = new CompositeDisposable();
        this.f117583d = 15;
    }

    public static final JSONObject wq(WelfareAnchorServiceWidget r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        r101.put("code", 0);
        return r101;
    }

    public static final void xq(WelfareAnchorServiceWidget r100) {
        DataCenter r101 = r100.dataCenter;
        if (r101 == null) goto L40;
        WelfarePermissionInfo r102 = (WelfarePermissionInfo) r101.get("data_welfare_permission_info");
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.available == true) goto L9;
        return;
    L9:
        if (yt2.b.a().booleanValue() == false) goto L43;
        String r103 = r102.settingPageUrl;
        boolean r104 = false;
        if (r103 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L44;
        Uri r106 = UriProtector.parse(r102.settingPageUrl);
        String r107 = UriProtector.getQueryParameter(r106, "url");
        if (r107 != null) goto L21;
    L22:
        r104 = true;
    L23:
        if (r104 == true) goto L31;
        String r108 = UriProtector.parse(r107).buildUpon().appendQueryParameter("is_living", "1").build().toString();
        Uri.Builder r109 = r106.buildUpon().clearQuery();
        Iterator<T> r110 = UriProtector.getQueryParameterNames(r106).iterator();
    L26:
        if (r110.hasNext() == false) goto L30;
        String r111 = (String) r110.next();
        if ((!Intrinsics.areEqual(r111, "url")) == false) goto L26;
        r109.appendQueryParameter(r111, UriProtector.getQueryParameter(r106, r111));
        goto L26
    L30:
        r109.appendQueryParameter("url", r108);
        r106 = r109.build();
    L31:
        ILiveActionHandler r112 = (ILiveActionHandler) jc1.k.f(ILiveActionHandler.class);
        if (r112 == null) goto L45;
        r112.handle(r100.context, r106);
        return;
    L45:
        return;
    L21:
        if (r107.length() != 0) goto L23;
    L44:
        return;
    L13:
        if (r103.length() == 0) goto L16;
        r105 = false;
        goto L17
    L43:
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L16;
        String r102 = r101.getKey();
        if (r102.hashCode() == 919040494) goto L9;
        return;
    L9:
        if (r102.equals("data_live_mini_app_commerce_status") == false) goto L15;
        p2 r103 = (p2) r101.getData();
        if (r103 == null) goto L18;
        yq(r103);
        return;
    L18:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        RoomContext r101 = getDataContext();
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<Room> r102 = r101.getRoom();
        if (r102 == null) goto L9;
        Room r103 = r102.getValue();
        if (r103 == null) goto L9;
        WelfareProjectInfo r104 = r103.welfareProjectInfo;
    L10:
        if (r104 != null) goto L12;
    L14:
        this.f117582c = ((Number) this.dataCenter.get("data_anchor_welfare_id", 0L)).longValue();
        this.f117583d = ((Number) this.dataCenter.get("data_anchor_welfare_frequency", Long.valueOf(qy0.f121092a.getValue().f()))).longValue();
    L16:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L18;
        y3.m(this.dataCenter).k(ToolbarButton.WELFARE, new ToolbarAnchorWelfareBehavior(false));
    L18:
        RoomContext r105 = getDataContext();
        if (r105 == null) goto L23;
        com.bytedance.live.datacontext.j<vlc.d> r106 = r105.getMessageManager();
        if (r106 == null) goto L23;
        r106.c(new AnonymousClass1(this));
    L23:
        IBrowserService r107 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r107 == null) goto L30;
        Observable<Unit> r108 = r107.registerExternalMethodFactory(new i(this));
        if (r108 == null) goto L30;
        ObservableSubscribeProxy r109 = (ObservableSubscribeProxy) r108.as(autoDispose());
        if (r109 == null) goto L30;
        r109.subscribe();
    L30:
        DataCenter r110 = this.dataCenter;
        if (r110 == null) goto L33;
        r110.observe("data_live_mini_app_commerce_status", this);
    L33:
        yq(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.dataCenter));
        return;
    L12:
        if (r104.isValid() != true) goto L14;
        this.f117582c = r104.getProjectId();
        this.f117583d = r104.get_showFrequency();
    L9:
        r104 = null;
        goto L10
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof tn) == false) goto L18;
        tn r101 = (tn) r100;
        int r102 = r101.getOpType();
        if (r102 != 1) goto L9;
        WelfareProjectInfo r103 = r101.E();
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103.isValid() != true) goto L21;
        this.f117582c = r101.E().getProjectId();
        yq(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.dataCenter));
        return;
    L21:
        return;
    L9:
        if (r102 != 3) goto L22;
        this.f117582c = 0;
        yq(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.dataCenter));
        return;
    L22:
        return;
    }

    public final void yq(p2 r100) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L6;
        return;
    L6:
        if (r100.i() == 1) goto L8;
        y3.f(this.dataCenter).i(ToolbarButton.WELFARE_FOLD.extended());
    L10:
        if (r100.j() == 1) goto L12;
        y3.m(this.dataCenter).i(ToolbarButton.WELFARE.extended());
        return;
    L12:
        y3.m(this.dataCenter).c(ToolbarButton.WELFARE.extended());
        WelfareAppLogger.h();
        return;
    L8:
        y3.f(this.dataCenter).c(ToolbarButton.WELFARE_FOLD.extended());
        goto L10
    }
}
