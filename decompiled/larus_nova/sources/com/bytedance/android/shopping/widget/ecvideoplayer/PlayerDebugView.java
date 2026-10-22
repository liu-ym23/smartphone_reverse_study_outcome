package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR$\u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR$\u0010%\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\r¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/widget/ecvideoplayer/PlayerDebugView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/b;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "ecVideoPlayer", "", "setPlayer", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getPlayerExecutorTV", "()Landroid/widget/TextView;", "setPlayerExecutorTV", "(Landroid/widget/TextView;)V", "playerExecutorTV", "b", "getPlayerStatusTV", "setPlayerStatusTV", "playerStatusTV", "c", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "getEcPlayer", "()Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "setEcPlayer", "(Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;)V", "ecPlayer", "d", "getProgressTV", "setProgressTV", "progressTV", "e", "getSurfaceTV", "setSurfaceTV", "surfaceTV", "f", "getEcVideoViewTV", "setEcVideoViewTV", "ecVideoViewTV", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerDebugView extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f187380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f187381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECVideoPlayer f187382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f187383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f187384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f187385f;

    public static final class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f187386a = null;

        static {
            f187386a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            int r101 = com.bytedance.android.shopping.widget.ecvideoplayer.a.f187394a;
            int r102 = ECVideoView.f187372h;
            return true;
        }
    }

    public PlayerDebugView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlayerDebugView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void g() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRenderStart() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onVideoSizeChanged(int r100, int r101) {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void E() {
        TextView r100 = this.f187381b;
        if (r100 == null) goto L6;
        r100.setText("PlayerStatus:Preparing");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onIdle() {
        TextView r100 = this.f187381b;
        if (r100 == null) goto L6;
        r100.setText("PlayerStatus:Idle");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPaused() {
        TextView r100 = this.f187381b;
        if (r100 == null) goto L6;
        r100.setText("PlayerStatus:Paused");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPlaying() {
        TextView r100 = this.f187381b;
        if (r100 == null) goto L6;
        r100.setText("PlayerStatus:Playing");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRelease() {
        TextView r100 = this.f187381b;
        if (r100 == null) goto L6;
        r100.setText("PlayerStatus:Release");
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void w() {
        TextView r100 = this.f187381b;
        if (r100 == null) goto L6;
        r100.setText("PlayerStatus:Buffering");
        return;
    }

    public final ECVideoPlayer getEcPlayer() {
        return this.f187382c;
    }

    public final TextView getEcVideoViewTV() {
        return this.f187385f;
    }

    public final TextView getPlayerExecutorTV() {
        return this.f187380a;
    }

    public final TextView getPlayerStatusTV() {
        return this.f187381b;
    }

    public final TextView getProgressTV() {
        return this.f187383d;
    }

    public final TextView getSurfaceTV() {
        return this.f187384e;
    }

    public final void a(Surface r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        TextView r101 = this.f187384e;
        if (r101 == null) goto L6;
        r101.setText("surface:" + r100.hashCode());
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onError(Error r100) {
        TextView r101 = this.f187381b;
        if (r101 == null) goto L10;
        StringBuilder r102 = new StringBuilder("PlayerStatus:ERROR code= ");
        if (r100 == null) goto L7;
        Integer r103 = Integer.valueOf(r100.code);
    L8:
        r102.append(r103);
        r101.setText(r102.toString());
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void setEcPlayer(ECVideoPlayer r100) {
        this.f187382c = r100;
    }

    public final void setEcVideoViewTV(TextView r100) {
        this.f187385f = r100;
    }

    public final void setPlayer(ECVideoPlayer r100) {
        Intrinsics.checkNotNullParameter(r100, "ecVideoPlayer");
        TextView r101 = this.f187381b;
        if (r101 == null) goto L5;
        r101.setText("PlayerStatus:None");
    L5:
        TextView r102 = this.f187380a;
        if (r102 == null) goto L8;
        r102.setText("PlayerExecutor:" + r100.f187338b.hashCode());
    L8:
        TextView r103 = this.f187385f;
        if (r103 == null) goto L11;
        r103.setText("ECVideoView:" + getParent().hashCode());
    L11:
        this.f187382c = r100;
        if (r100 == null) goto L15;
        r100.a(this);
        return;
    }

    public final void setPlayerExecutorTV(TextView r100) {
        this.f187380a = r100;
    }

    public final void setPlayerStatusTV(TextView r100) {
        this.f187381b = r100;
    }

    public final void setProgressTV(TextView r100) {
        this.f187383d = r100;
    }

    public final void setSurfaceTV(TextView r100) {
        this.f187384e = r100;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void h(int r100, int r101) {
        TextView r102 = this.f187383d;
        if (r102 == null) goto L6;
        r102.setText("Progress:" + r100 + '/' + r101);
        return;
    }

    public PlayerDebugView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_player_debug_view, this);
        this.f187380a = (TextView) findViewById(R.id.player_executor_tv);
        this.f187381b = (TextView) findViewById(R.id.player_status_tv);
        this.f187383d = (TextView) findViewById(R.id.progress_tv);
        this.f187384e = (TextView) findViewById(R.id.surface_tv);
        this.f187385f = (TextView) findViewById(R.id.ec_video_view_tv);
        TextView r103 = this.f187381b;
        if (r103 == null) goto L5;
        r103.setText("PlayerStatus:None");
    L5:
        TextView r104 = this.f187380a;
        if (r104 == null) goto L8;
        r104.setText("PlayerExecutor:None");
    L8:
        TextView r105 = this.f187383d;
        if (r105 == null) goto L11;
        r105.setText("progress:None");
    L11:
        TextView r106 = this.f187384e;
        if (r106 == null) goto L14;
        r106.setText("surface:None");
    L14:
        setOnLongClickListener(a.f187386a);
    }

    public /* synthetic */ PlayerDebugView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
