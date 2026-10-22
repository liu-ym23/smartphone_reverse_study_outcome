package com.bytedance.android.live.room.discovery;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/discovery/LiveSceneWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSceneWidget extends RowRecyclableWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f99325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f99326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Room f99327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f99328d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSceneWidget f99329a;

        public a(LiveSceneWidget r100) {
            this.f99329a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BannerInRoomCollection.BannerInfo r101 = ((BannerData) r100).getData().getSceneBanner();
            if (r101 == null) goto L54;
            LiveSceneWidget r102 = this.f99329a;
            r102.getClass();
            if (r101.getBannerList().isEmpty() == true) goto L55;
            r102.f99328d = true;
            View r103 = r102.contentView;
            if (r103 == null) goto L10;
            r103.setVisibility(0);
        L10:
            Unit r104 = Unit.INSTANCE;
            List<b1> r105 = r101.getBannerList();
            if (r105 == null) goto L44;
            ArrayList r106 = new ArrayList();
            Iterator<T> r107 = r105.iterator();
        L14:
            if (r107.hasNext() == false) goto L21;
            T r108 = r107.next();
            if (((b1) r108).getExtra() == null) goto L18;
            boolean r109 = true;
        L19:
            if (r109 == false) goto L14;
            r106.add(r108);
            goto L14
        L18:
            r109 = false;
            goto L19
        L21:
            Iterator r110 = r106.iterator();
        L23:
            if (r110.hasNext() == false) goto L44;
            b1 r111 = (b1) r110.next();
            TextView r112 = r102.f99326b;
            if (r112 == null) goto L31;
            if (r111 == null) goto L28;
            String r113 = r111.getExtra();
        L29:
            Intrinsics.checkNotNull(r113);
            r112.setText(new JSONObject(r113).optString("title"));
            goto L31
        L28:
            r113 = null;
        L31:
            if (r111.getImage() == null) goto L37;
            HSImageView r114 = r102.f99325a;
            if (r114 == null) goto L35;
            r114.setVisibility(0);
        L35:
            ImageUtil.loadImage(r102.f99325a, r111.getImage(), 0);
        L37:
            if (r111.getActionType() != 1) goto L39;
            String r115 = "live";
        L40:
            View r116 = r102.contentView;
            if (r116 == null) goto L43;
            r116.setOnClickListener(new k0(r111, r115, r102));
        L43:
            r102.xq("livesdk_activity_entrance_show", r115);
            goto L23
        L39:
            r115 = "h5";
        L44:
            r102.dataCenter.put("data_live_scene_shown", Boolean.TRUE);
            return;
        L55:
            return;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_scene_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a167";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        this.dataCenter.put("data_live_scene_shown", Boolean.FALSE);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L6;
        r100.removeObserver(this);
        return;
    }

    public LiveSceneWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L7:
        if (Intrinsics.areEqual(r102, "data_keyboard_status") == true) goto L9;
        return;
    L9:
        if (r101.getData() == null) goto L24;
        Object r103 = r101.getData();
        Intrinsics.checkNotNull(r103);
        boolean r104 = ((Boolean) r103).booleanValue();
        int r105 = 8;
        if (this.f99328d == true) goto L16;
        View r106 = this.contentView;
        if (r106 == null) goto L15;
        r106.setVisibility(8);
    L15:
        Unit r107 = Unit.INSTANCE;
        return;
    L16:
        View r108 = this.contentView;
        if (r108 == null) goto L26;
        if (r104 == false) goto L20;
        Unit r109 = Unit.INSTANCE;
    L21:
        r108.setVisibility(r105);
        return;
    L20:
        Unit r110 = Unit.INSTANCE;
        r105 = 0;
        goto L21
    L26:
        return;
    L24:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f99325a = (HSImageView) findViewById(R.id.scene_icon);
        this.f99326b = (TextView) findViewById(R.id.scene_tv);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f99327c = (Room) this.dataCenter.get("data_room", null);
        this.f99328d = false;
        boolean r101 = com.bytedance.android.live.core.utils.z.b(this.dataCenter).f66428b;
        if (r101 == true) goto L5;
        this.contentView.setBackground(s1.m(R.drawable.ttlive_scene_bg_land));
    L6:
        View r102 = this.contentView;
        if (r102 == null) goto L9;
        r102.setVisibility(8);
    L9:
        Unit r103 = Unit.INSTANCE;
        if (r101 == true) goto L12;
        UIUtils.updateLayoutMargin(this.contentView, 0, -3, s1.f(8.0f), -3);
    L13:
        HSImageView r104 = this.f99325a;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
    L16:
        IBannerManager r105 = (IBannerManager) this.dataCenter.get("data_in_room_banner_manager", null);
        if (r105 == null) goto L27;
        Room r106 = this.f99327c;
        if (r106 == null) goto L21;
        long r107 = r106.getRoomId();
    L22:
        Observable<BannerData> r108 = r105.observeBanner(r107, 0);
        if (r108 == null) goto L27;
        ObservableSubscribeProxy r109 = (ObservableSubscribeProxy) r108.as(autoDispose());
        if (r109 == null) goto L27;
        r109.subscribe(new a(this));
        goto L27
    L21:
        r107 = 0;
    L27:
        this.dataCenter.observe("data_keyboard_status", this);
        return;
    L12:
        UIUtils.updateLayoutMargin(this.contentView, 0, -3, 0, -3);
        goto L13
    L5:
        this.contentView.setBackground(s1.m(R.drawable.ttlive_scene_bg));
        goto L6
    }

    public final void wq(String r100) {
        HashMap r101 = new HashMap();
        Room r102 = this.f99327c;
        if (r102 == null) goto L6;
        String r103 = r102.getOwnerUserIdString();
        if (r103 == null) goto L6;
    L7:
        r101.put("anchor_id", r103);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100);
        r101.put("page_type", "live");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_activity_entrance_page_show", r101, new Object[]{new am2.x(), Room.class});
        return;
    L6:
        r103 = "0";
        goto L7
    }

    public final void xq(String r100, String r101) {
        HashMap r102 = new HashMap();
        Room r103 = this.f99327c;
        if (r103 == null) goto L6;
        String r104 = r103.getOwnerUserIdString();
        if (r104 == null) goto L6;
    L7:
        r102.put("anchor_id", r104);
        r102.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r101);
        com.bytedance.android.livesdk.log.u.l().sendLog(r100, r102, new Object[]{new am2.x(), Room.class});
        return;
    L6:
        r104 = "0";
        goto L7
    }
}
