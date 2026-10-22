package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.collection.ArrayMap;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.VideoInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.tangram.Bind;
import com.bytedanceos.common.tangram.BusRegister;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.utils.JzvdUtil;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.eventbus.Event;
import com.tmall.wireless.tangram.eventbus.EventHandlerWrapper;
import com.tmall.wireless.tangram.eventbus.ReflectedActionFinder;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;

/* JADX INFO: loaded from: classes2.dex */
public class TrangramVideoView extends RelativeLayout implements Bind<VideoInfo>, ITangramViewLifeCycle, BusRegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JzvdStd f9972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EventHandlerWrapper f9975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Jzvd.ListenerAdapter f9976e;

    public class a extends Jzvd.ListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TrangramVideoView f9977a;

        public a(TrangramVideoView r10) {
            this.f9977a = r10;
        }

        @Override // cn.jzvd.Jzvd.ListenerAdapter, cn.jzvd.Jzvd.Listener
        public void onPrepared(MediaPlayer r10) {
            super.onPrepared(r10);
            d9.a.e().z(TrangramVideoView.a(this.f9977a), e.I0(), TrangramVideoView.b(this.f9977a));
        }

        @Override // cn.jzvd.Jzvd.ListenerAdapter, cn.jzvd.Jzvd.Listener
        public void onVideoStartButtonClick(View r10) {
            JzvdStd r11 = this.f9977a.f9972a;
            if (r11 == null) goto L8;
            int r12 = r11.getState();
            JzvdStd r13 = this.f9977a.f9972a;
            if (r12 != 3) goto L9;
            d9.a.e().z(TrangramVideoView.a(this.f9977a), false, TrangramVideoView.b(this.f9977a));
            return;
        L9:
            return;
        }
    }

    public TrangramVideoView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ String a(TrangramVideoView r10) {
        return r10.f9973b;
    }

    public static /* synthetic */ boolean b(TrangramVideoView r10) {
        return r10.f9974c;
    }

    private void d() {
        LayoutInflater.from(getContext()).inflate(R$layout.tangram_video_view, this, true);
        this.f9972a = (JzvdStd) findViewById(R$id.video_view);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(VideoInfo r10, BaseCell r11) {
        c(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void bindStyle(Style r10, BaseCell r11) {
    }

    public void c(VideoInfo r10, BaseCell r11) {
        JzvdStd r12 = this.f9972a;
        if (r12 == null) goto L10;
        r12.setBannerUrl(r10.mImgUrl);
        this.f9972a.setVideoUrl(r10.mVideoUrl);
        this.f9972a.setListener(this.f9976e);
        this.f9973b = r11.extras.optString("package");
        if (c0.b(e.X(r11.extras.optString(DownloadInfoColumns.COLUMN_API_URL), "source")) == 2) goto L7;
        boolean r13 = true;
    L8:
        this.f9974c = r13;
        return;
    L7:
        r13 = false;
        goto L8
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
    }

    public void execute(Event r10) {
        if (r10 == null) goto L8;
        ArrayMap r11 = r10.args;
        if (r11 == null) goto L8;
        if (r11.containsKey("play_status") == false) goto L8;
        boolean r12 = ((String) r10.args.get("play_status")).equals("play");
    L10:
        if (this.f9972a == null) goto L17;
        if (r12 == true) goto L13;
    L15:
        JzvdUtil.onPause(this.f9972a);
        return;
    L13:
        if (e.I0() == false) goto L15;
        JzvdUtil.onResume(this.f9972a);
        return;
    L17:
        return;
    L8:
        r12 = false;
        goto L10
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
        JzvdStd r11 = this.f9972a;
        if (r11 == null) goto L6;
        JzvdUtil.onResume(r11);
        d9.a.e().A(this.f9973b, this.f9974c);
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
        JzvdStd r11 = this.f9972a;
        if (r11 == null) goto L6;
        JzvdUtil.onPause(r11);
        return;
    }

    @Override // com.bytedanceos.common.tangram.BusRegister
    public void register(BusSupport r10) {
        if (this.f9975d != null) goto L5;
        this.f9975d = BusSupport.wrapEventHandler("bus_video_status_changed", "bus_video_status_changed_id", this, "");
    L5:
        r10.register(this.f9975d);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
    }

    @Override // com.bytedanceos.common.tangram.BusRegister
    public void unRegister(BusSupport r10) {
        EventHandlerWrapper r11 = this.f9975d;
        if (r11 == null) goto L6;
        r10.unregister(r11);
        ReflectedActionFinder.removeMethod(this);
        this.f9975d = null;
        return;
    }

    public TrangramVideoView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public TrangramVideoView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f9976e = new a(this);
        d();
    }
}
