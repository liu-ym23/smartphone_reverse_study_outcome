package com.bytedance.android.livesdk.widgetdescriptor.matchroom.publish;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bolts.Task;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.uicomponent.loading.CircularProgressView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import gw2.b;
import gw2.c;
import gw2.e;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/widgetdescriptor/matchroom/publish/LivePortraitPublishLoadingWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lgw2/c;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePortraitPublishLoadingWidget extends LiveRecyclableWidget implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f162426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f162427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CircularProgressView f162428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f162429d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_vs_publish_share_loading;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a228";
    }

    @Override // gw2.c
    public final void tk() {
        f2.c("作品转发失败", 0);
        wq();
    }

    @Override // gw2.c
    public final void wo() {
        f2.c("作品转发取消", 0);
        wq();
    }

    public final void wq() {
        this.contentView.setVisibility(8);
        this.f162429d = null;
        TextView r100 = this.f162426a;
        if (r100 == null) goto L6;
        r100.setText(s1.C(R.string.ttlive_publish_video_progress, new Object[]{0}));
        return;
    }

    public final void xq() {
        if (this.f162429d != null) goto L5;
        Task.callInBackground(new b(this));
    L5:
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L9;
        VideoViewParams r101 = (VideoViewParams) r100.get("live_render_view_params", null);
        if (r101 == null) goto L9;
    L10:
        UIUtils.updateLayoutMargin(this.contentView, 0, (r101.f112571c + r101.f112570b) + s1.f(62.0f), s1.f(16.0f), 0);
        View r102 = this.contentView;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
    L13:
        TextView r103 = this.f162426a;
        if (r103 == null) goto L17;
        r103.setText(s1.C(R.string.ttlive_publish_video_progress, new Object[]{0}));
        return;
    L17:
        return;
    L9:
        r101 = new VideoViewParams(0, 0, 0, 0.0f);
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        wq();
        Set<c> r100 = e.f483026a;
        Intrinsics.checkNotNullParameter(this, "listener");
        e.f483026a.remove(this);
    }

    public LivePortraitPublishLoadingWidget() {
    }

    @Override // gw2.c
    public final void eg(String r100) {
        xq();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        View r101 = this.contentView;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f162426a = (TextView) this.contentView.findViewById(R.id.ttlive_publish_share_tv);
        this.f162427b = (ImageView) this.contentView.findViewById(R.id.ttlive_bg_publish_loading);
        this.f162428c = (CircularProgressView) this.contentView.findViewById(R.id.ttlive_publish_share_process);
        wq();
        Set<c> r101 = e.f483026a;
        Intrinsics.checkNotNullParameter(this, "listener");
        e.f483026a.add(this);
    }

    @Override // gw2.c
    public final void onSuccess(String r100) {
        f2.c("作品已转发", 0);
        wq();
    }

    @Override // gw2.c
    public final void hc(int r100, String r101) {
        if (this.contentView.getVisibility() == 0) goto L5;
        xq();
    L5:
        TextView r102 = this.f162426a;
        if (r102 == null) goto L8;
        r102.setText(s1.C(R.string.ttlive_publish_video_progress, new Object[]{Integer.valueOf(r100)}));
    L8:
        CircularProgressView r103 = this.f162428c;
        if (r103 == null) goto L12;
        r103.setProgress(r100 / 100.0f);
        return;
    }
}
