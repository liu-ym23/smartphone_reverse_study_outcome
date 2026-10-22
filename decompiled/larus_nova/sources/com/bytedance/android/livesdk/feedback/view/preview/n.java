package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
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
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f125036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f125037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f125038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FeedbackLikeView f125039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LivePlayerView f125040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ILivePlayerClient f125041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RoomCardStruct f125042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f125043h;

    public static final class a {
    }

    static {
    }

    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.c
    public final void startPreview() {
        Room r100 = this.f125042g.room;
        if (r100 == null) goto L24;
        ILivePlayerClient r101 = this.f125041f;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        r100 = null;
    L14:
        if (r100 == null) goto L25;
        this.f125041f = this.f125040e.getClient();     // Catch: Exception -> L19
        this.f125040e.updateIdentifier(r100.getIdStr());     // Catch: Exception -> L19
        LiveRequest r103 = new LiveRequest.Builder().streamData(r100.getMultiStreamData()).resolution(ResolutionManager.INSTANCE.getMultiStreamDefaultQualitySdkKey(r100, true, true)).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r100.getStreamType())).preview(true).mute(true).build();     // Catch: Exception -> L19
        ILivePlayerClient r104 = this.f125041f;     // Catch: Exception -> L19
        if (r104 == null) goto L26;
        r104.stream(r103, new SmallPreviewItemView$innerPlay$1(this));     // Catch: Exception -> L19
        return;
    L26:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        return;
    L7:
        if (r101.isPlaying() != true) goto L10;
        r102 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.c
    public final void stopPreview() {
        ILivePlayerClient r100 = this.f125041f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isPlaying() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r100.stop();
        HSImageView r101 = this.f125038c;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.0f, 1.0f});
        r102.setDuration(200);
        r102.addListener(new o(r101));
        r102.start();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ILivePlayerClient r100 = this.f125041f;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public final h getListener() {
        return this.f125043h;
    }

    public final RoomCardStruct getRoomCardStruct() {
        return this.f125042g;
    }

    public n(Context r110, RoomCardStruct r111, h r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "roomCardStruct");
        ViewGroup.LayoutParams r100 = null;
        super(r110, null, 0);
        this.f125042g = r111;
        this.f125043h = r112;
        FrameLayout.inflate(r110, R.layout.ttlive_view_feedback_small_preview_item, this);
        ViewGroup r113 = (ViewGroup) findViewById(R.id.root_view);
        this.f125036a = r113;
        ViewGroup r114 = (ViewGroup) findViewById(R.id.content_view);
        this.f125037b = r114;
        TextView r101 = (TextView) findViewById(R.id.title);
        TextView r102 = (TextView) findViewById(R.id.sub_title);
        HSImageView r103 = (HSImageView) findViewById(R.id.preview_cover);
        this.f125038c = r103;
        HSImageView r104 = (HSImageView) findViewById(R.id.feedback_blur_cover);
        LivePlayerView r105 = (LivePlayerView) findViewById(R.id.feed_back_player_view);
        this.f125040e = r105;
        FeedbackLikeView r106 = (FeedbackLikeView) findViewById(R.id.like_view);
        this.f125039d = r106;
        r105.setScaleType(2);
        Room r107 = r111.room;
        if (r107 == null) goto L5;
        py.k r108 = r107.getCover();
    L6:
        ImageLoader.bindImage(r103, r108);
        Room r109 = r111.room;
        if (r109 == null) goto L9;
        py.k r115 = r109.getCover();
    L10:
        ImageLoader.bindImage(r104, r115, new l3(5, 1.0f, null));
        String r116 = r111.title;
        String r117 = "";
        if (r116 != null) goto L14;
        r116 = "";
    L14:
        r101.setText(r116);
        String r118 = r111.subTitle;
        if (r118 == null) goto L17;
        r117 = r118;
    L17:
        r102.setText(r117);
        r114.setOnClickListener(new l(this));
        boolean r119 = r111.isLike();
        r106.f124989c = r119;
        View r120 = r106.f124987a;
        if (r119 == false) goto L20;
        Drawable r121 = s1.m(R.drawable.ttlive_ic_feedback_like);
    L21:
        r120.setBackground(r121);
        r106.setLikeClickListener(new m(this));
        Pair<Float, Float> r122 = com.bytedance.android.livesdk.feedback.c.a(0.7609756f, UtilityKotlinExtentionsKt.h(VideoRef.VALUE_VIDEO_REF_CONST_DEPTH), UtilityKotlinExtentionsKt.h(48));
        if (r113 == null) goto L24;
        r100 = r113.getLayoutParams();
    L24:
        if (r100 == null) goto L29;
        r100.width = ((int) r122.getFirst().floatValue()) / 2;
        r100.height = ((int) r122.getSecond().floatValue()) / 2;
        if (r113 == null) goto L30;
        r113.setLayoutParams(r100);
        return;
    L30:
        return;
    L29:
        return;
    L20:
        r121 = s1.m(R.drawable.ttlive_ic_feedback_unlike);
        goto L21
    L9:
        r115 = null;
        goto L10
    L5:
        r108 = null;
        goto L6
    }
}
