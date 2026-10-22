package com.bytedance.android.livesdk.feed.preview;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.feed.openui.view.HSLargeLiveCardView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/feed/preview/LiveFeedPreview;", "Landroid/widget/FrameLayout;", "Lmw1/a;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "f", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "client", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedPreview extends FrameLayout implements mw1.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f124283h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Room f124284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f124285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mw1.f f124286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qw1.e f124287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f124288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ILivePlayerClient f124289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap f124290g;

    public LiveFeedPreview(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveFeedPreview(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View b() {
        if (this.f124290g != null) goto L5;
        this.f124290g = new HashMap();
    L5:
        View r100 = (View) this.f124290g.get(Integer.valueOf(R.id.renderView));
        if (r100 != null) goto L9;
        View r101 = findViewById(R.id.renderView);
        this.f124290g.put(Integer.valueOf(R.id.renderView), r101);
        return r101;
    L9:
        return r100;
    }

    @Override // mw1.a
    public final void startPreview() {
        this.f124285b = true;
        this.f124289f.bindRenderView((TextureRenderView) b());
        Room r100 = this.f124284a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L6:
        if (r100.isMultiPullDataValid() == false) goto L21;
        LiveRequest.Builder r101 = new LiveRequest.Builder();
        Room r102 = this.f124284a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L10:
        String r103 = r102.getMultiStreamData();
        String r104 = "";
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        LiveRequest.Builder r105 = r101.streamData(r103);
        Room r106 = this.f124284a;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L16:
        String r107 = r106.getMultiStreamDefaultQualitySdkKey();
        if (r107 == null) goto L20;
        r104 = r107;
    L20:
        LiveRequest r108 = r105.resolution(r104).preview(true).mute(true).build();
        this.f124289f.stream(r108, new AnonymousClass1(this));
    L28:
        Room r109 = this.f124284a;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L32:
        if (this.f124285b == true) goto L35;
        return;
    L35:
        if (this.f124287d != null) goto L37;
        this.f124287d = new qw1.e(r109.f162599id, r109.getStreamId(), new f(this));
    L37:
        qw1.e r110 = this.f124287d;
        if (r110 == null) goto L41;
        r110.a();
        return;
    L41:
        return;
    L21:
        LiveRequest r111 = new LiveRequest.Builder().preview(true).mute(true).build();
        Room r112 = this.f124284a;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L24:
        r111.setLegacyPullUrl(r112.buildPullUrl());
        Room r113 = this.f124284a;
        if (r113 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L27:
        r111.setLegacySdkParams(r113.getSdkParams());
        this.f124289f.stream(r111, new AnonymousClass2(this));
        goto L28
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f124288e = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f124288e = false;
    }

    public final ILivePlayerClient getClient() {
        return this.f124289f;
    }

    public final void e(Integer r100) {
        if (this.f124288e == true) goto L5;
        return;
    L5:
        stopPreview(false);
        Room r101 = this.f124284a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L8:
        r101.setStatus(4);
        if (r100 == null) goto L15;
        int r102 = r100.intValue();
        Room r103 = this.f124284a;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L13:
        r103.setMosaicStatus(r102);
        return;
    }

    @Override // mw1.a
    public final void stopPreview(boolean r100) {
        this.f124285b = false;
        qw1.e r101 = this.f124287d;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        this.f124287d = null;
        mw1.f r102 = this.f124286c;
        if (r102 == null) goto L8;
        r102.b(false);
    L8:
        if (r100 == false) goto L10;
        this.f124289f.stopAndRelease(getContext());
        return;
    L10:
        this.f124289f.stop();
    }

    public static final void c(LiveFeedPreview r100, LifecycleOwner r101) {
        ILivePlayerClient r102 = r100.f124289f;
        IRoomEventHub r103 = r102.getEventHub();
        r103.getVideoSizeChanged().observe(r101, new b(r100, r101));
        r103.getFirstFrame().observe(r101, new c(r102, r100, r101));
        r103.getSeiUpdate().observe(r101, new d(r100, r101));
    }

    public LiveFeedPreview(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        String.valueOf(0);
        this.f124289f = is0.c.c().createClient(new LivePlayerConfig(LivePlayerScene.INSTANCE.getPREVIEW(), null, null, false, null, false, false, null, false, 0, false, 2046, null));
        View.inflate(getContext(), R.layout.ttlive_view_feed_preview, this);
    }

    public static final void d(LiveFeedPreview r100, int r101, int r102) {
        mw1.f r103 = r100.f124286c;
        if (r103 == null) goto L5;
        r103.a(r101, r102);
    L5:
        if (r101 >= r102) goto L12;
        ViewGroup.LayoutParams r104 = ((TextureRenderView) r100.b()).getLayoutParams();
        if (r104 == null) goto L10;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
        r105.leftMargin = 0;
        r105.rightMargin = 0;
        goto L12
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId() != ThreadMethodProxy.currentThread().getId()) goto L14;
        ((TextureRenderView) r100.b()).setVideoSize(r101, r102);
        return;
    L14:
        ((TextureRenderView) r100.b()).post(new e(r100, r101, r102));
    }

    @Override // mw1.a
    public final void a(String r100, Room r101, HSLargeLiveCardView.e r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "roomData");
        this.f124284a = r101;
        this.f124286c = r102;
    }

    public /* synthetic */ LiveFeedPreview(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
