package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/view/preview/LargeCardPreviewView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/feedback/view/preview/b;", "Landroid/view/View;", "getView", "Lcom/bytedance/android/live/base/model/feedback/RoomCardStruct;", "getRoomInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LargeCardPreviewView extends FrameLayout implements com.bytedance.android.livesdk.feedback.view.preview.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f124991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f124992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f124993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f124994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePlayerView f124995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ILivePlayerClient f124996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RoomCardStruct f124997g;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f124998a;

        public a(Function0 r100) {
            this.f124998a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f124998a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100, r101);
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f124999a;

        public b(Function0 r100) {
            this.f124999a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f124999a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100, r101);
        }
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void startPreview() {
        RoomCardStruct r100 = this.f124997g;
        Room r101 = null;
        if (r100 == null) goto L5;
        Room r102 = r100.room;
    L6:
        ILivePlayerClient r103 = this.f124996f;
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        r101 = r102;
    L15:
        if (r101 == null) goto L25;
        this.f124996f = this.f124995e.getClient();     // Catch: Exception -> L20
        this.f124995e.updateIdentifier(r101.getIdStr());     // Catch: Exception -> L20
        LiveRequest r105 = new LiveRequest.Builder().streamData(r101.getMultiStreamData()).resolution(ResolutionManager.INSTANCE.getMultiStreamDefaultQualitySdkKey(r101, true, true)).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r101.getStreamType())).preview(true).mute(true).build();     // Catch: Exception -> L20
        ILivePlayerClient r106 = this.f124996f;     // Catch: Exception -> L20
        if (r106 == null) goto L26;
        r106.stream(r105, new LargeCardPreviewView$innerPlay$1(this));     // Catch: Exception -> L20
        return;
    L26:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        return;
    L9:
        if (r103.isPlaying() != true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void stopPreview() {
        ILivePlayerClient r100 = this.f124996f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isPlaying() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r100.stop();
        this.f124993c.setVisibility(0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ILivePlayerClient r100 = this.f124996f;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public RoomCardStruct getRoomInfo() {
        return this.f124997g;
    }

    public /* synthetic */ LargeCardPreviewView(Context r100) {
        this(r100, null, 0);
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onFinish");
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
        r101.setDuration(200);
        r101.addListener(new a(r100));
        r101.start();
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onFinish");
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.9f, 1.0f});
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.9f, 1.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.7f, 1.0f});
        AnimatorSet r104 = new AnimatorSet();
        r104.setDuration(300);
        r104.addListener(new b(r100));
        r104.playTogether(new Animator[]{r103, r101, r102});
        r104.start();
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void c(RoomCardStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        this.f124997g = r100;
        HSImageView r101 = this.f124993c;
        Room r102 = r100.room;
        if (r102 == null) goto L5;
        py.k r103 = r102.getCover();
    L6:
        ImageLoader.bindImage(r101, r103);
        HSImageView r104 = this.f124994d;
        Room r105 = r100.room;
        if (r105 == null) goto L9;
        py.k r106 = r105.getCover();
    L10:
        ImageLoader.bindImage(r104, r106, new l3(5, 1.0f, null));
        TextView r107 = this.f124992b;
        RoomCardStruct r108 = this.f124997g;
        String r109 = "";
        if (r108 == null) goto L15;
        String r110 = r108.title;
        if (r110 == null) goto L15;
    L16:
        r107.setText(r110);
        TextView r111 = this.f124991a;
        RoomCardStruct r112 = this.f124997g;
        if (r112 == null) goto L21;
        String r113 = r112.subTitle;
        if (r113 == null) goto L21;
        r109 = r113;
    L21:
        r111.setText(r109);
        return;
    L15:
        r110 = "";
        goto L16
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public LargeCardPreviewView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.ttlive_view_feedback_large_preview_view, this);
        this.f124992b = (TextView) findViewById(R.id.title);
        this.f124991a = (TextView) findViewById(R.id.sub_title);
        this.f124993c = (HSImageView) findViewById(R.id.preview_cover);
        this.f124995e = (LivePlayerView) findViewById(R.id.feed_back_player_view);
        this.f124994d = (HSImageView) findViewById(R.id.feedback_blur_cover);
    }
}
