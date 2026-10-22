package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/DynamicEmojiView;", "Landroid/widget/FrameLayout;", "", "getResourceLayout", "Lcom/bytedance/android/livesdk/chatroom/ui/f6;", "listener", "", "setOnEmojiAnimationListener", "Lcom/bytedance/android/livesdk/chatroom/ui/e6;", "callback", "setEmojiAnimCallback", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getRandomEmojiView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicEmojiView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f112131j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f112132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wj0.d f112133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f112134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f112135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f112136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e6 f112137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animatable f112138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f112139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HSImageView f112140i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DynamicEmojiView f112141a;

        public a(DynamicEmojiView r100) {
            this.f112141a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Pair r111 = (Pair) r110;
            wj0.c r100 = (wj0.c) r111.component1();
            wj0.c r112 = (wj0.c) r111.component2();
            DynamicEmojiView r101 = this.f112141a;
            int r102 = DynamicEmojiView.f112131j;
            r101.getClass();
            if ((r112 instanceof wj0.c.d) == false) goto L15;
            e6 r103 = r101.f112137f;
            if (r103 == null) goto L7;
            r103.c(new d6.c(((wj0.c.d) r112).f559927a));
        L7:
            wj0.b r113 = ((wj0.c.d) r112).f559927a;
            if (r113.f559922b.isRandomEmoji == false) goto L11;
            r101.f112133b.b(new wj0.a.b(r113));
            return;
        L11:
            if (j40.o1.f497274a.getValue().booleanValue() == true) goto L13;
            r101.f112135d = Observable.timer(r113.f559922b.getDynamicAnimDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new w5(r101, r113));
        L13:
            ((HSImageView) r101.a(R.id.emoji_random_result_iv)).setVisibility(8);
            ((HSImageView) r101.a(R.id.emoji_animation)).setVisibility(0);
            ((HSImageView) r101.a(R.id.emoji_animation)).setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(com.bytedance.android.livesdk.chatroom.utils.a1.b(r113.f559922b.emojiDynamicImage(), -1)).setAutoPlayAnimations(true).setControllerListener(new x5(r101, r113)).build());
            return;
        L15:
            if ((r112 instanceof wj0.c.C8119c) == false) goto L18;
            wj0.b r114 = ((wj0.c.C8119c) r112).f559926a;
            r101.f112135d = Observable.timer(r114.f559922b.getDynamicAnimDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y5(r101, r114));
            ((HSImageView) r101.a(R.id.emoji_random_result_iv)).setVisibility(8);
            ((HSImageView) r101.a(R.id.emoji_animation)).setVisibility(0);
            ((HSImageView) r101.a(R.id.emoji_animation)).setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(com.bytedance.android.livesdk.chatroom.utils.a1.b(r114.f559922b.emojiDynamicImage(), -1)).setAutoPlayAnimations(true).build());
            ImageLoader.preload(r101.getContext(), r114.f559923c);
            return;
        L18:
            if ((r112 instanceof wj0.c.e) == false) goto L24;
            e6 r104 = r101.f112137f;
            if (r104 == null) goto L22;
            r104.c(new d6.b(((wj0.c.e) r112).f559928a));
        L22:
            wj0.b r115 = ((wj0.c.e) r112).f559928a;
            r101.f112136e = Observable.timer(r115.f559922b.getEmojiResultShowDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new z5(r101, r115));
            ((HSImageView) r101.a(R.id.emoji_random_result_iv)).setVisibility(0);
            ((HSImageView) r101.a(R.id.emoji_animation)).setVisibility(8);
            ((HSImageView) r101.a(R.id.emoji_random_result_iv)).setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(com.bytedance.android.livesdk.chatroom.utils.a1.b(r115.f559923c, -1)).setControllerListener(new a6(r101, r115)).build());
            return;
        L24:
            if ((r112 instanceof wj0.c.a) == false) goto L32;
            e6 r105 = r101.f112137f;
            if (r105 == null) goto L28;
            r105.c(new d6.a(((wj0.c.a) r112).f559925a));
        L28:
            Function0<Unit> r106 = r101.f112139h;
            if (r106 == null) goto L31;
            r106.invoke();
        L31:
            xs2.b.a().post(new wj0.e(((wj0.c.a) r112).f559925a.f559922b));
            r101.c();
            return;
        L32:
            boolean r116 = r112 instanceof wj0.c.b;
        }
    }

    public DynamicEmojiView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DynamicEmojiView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getResourceLayout() {
        return R.layout.ttlive_view_dynamic_emoji;
    }

    @Deprecated(message = "监听动画进度方式替换，为了扩展监听多个动画节点", replaceWith = @ReplaceWith(expression = "DynamicEmoji.setEmojiAnimCallback()", imports = {}))
    public final void setOnEmojiAnimationListener(f6 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void c() {
        this.f112133b.b(new wj0.a.c());
        Disposable r100 = this.f112135d;
        if (r100 != null) goto L5;
    L7:
        Disposable r101 = this.f112136e;
        if (r101 == null) goto L13;
        if (r101.isDisposed() == true) goto L13;
        r101.dispose();
    L13:
        if (((HSImageView) a(R.id.emoji_animation)).getVisibility() != 0) goto L16;
        ((HSImageView) a(R.id.emoji_animation)).setVisibility(8);
    L16:
        if (((HSImageView) a(R.id.emoji_random_result_iv)).getVisibility() != 0) goto L19;
        ((HSImageView) a(R.id.emoji_random_result_iv)).setVisibility(8);
        return;
    L19:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r100.dispose();
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f112134c.add(RxUtilKt.e(this.f112133b.f559930b).subscribe(new a(this)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        this.f112134c.clear();
    }

    public final HSImageView getRandomEmojiView() {
        return this.f112140i;
    }

    public final View a(int r100) {
        if (this.f112132a != null) goto L5;
        this.f112132a = new LinkedHashMap();
    L5:
        View r101 = this.f112132a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f112132a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setEmojiAnimCallback(e6 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f112137f = r100;
    }

    public final void b(wj0.b r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "emojiMessage");
        Intrinsics.checkNotNullParameter(r101, "taskEnd");
        Intrinsics.checkNotNullParameter(r100, "emojiMessage");
        wj0.d r102 = this.f112133b;
        if ((r102.f559929a instanceof wj0.c.b) == true) goto L7;
        wj0.b r103 = r102.a();
        if (r103 == null) goto L7;
        this.f112133b.b(new wj0.a.C8118a(r103));
    L7:
        this.f112133b.b(new wj0.a.d(r100));
        this.f112139h = r101;
    }

    public DynamicEmojiView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f112132a = new LinkedHashMap();
        this.f112133b = new wj0.d();
        this.f112134c = new CompositeDisposable();
        LayoutInflater.from(r100).inflate(getResourceLayout(), this, true);
        HSImageView r103 = (HSImageView) findViewById(R.id.random_emoji_view);
        this.f112140i = r103;
        if (r103 == null) goto L6;
        r103.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return;
    }

    public /* synthetic */ DynamicEmojiView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
