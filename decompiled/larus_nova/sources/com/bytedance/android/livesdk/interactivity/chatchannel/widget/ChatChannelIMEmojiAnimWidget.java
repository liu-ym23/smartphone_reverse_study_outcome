package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.os.Handler;
import android.view.ViewGroup;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelIMEmojiAnimWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelIMEmojiAnimWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f134522h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f134523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.c f134524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f134525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f134526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f134527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f134528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f134529g;

    public static final class a {
    }

    public static final class b implements IPlayerActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatChannelIMEmojiAnimWidget f134530a;

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.CC.$default$onFirstFrame(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final /* synthetic */ void onReportPlayMetrics(Map r100) {
            IPlayerActionListener.CC.$default$onReportPlayMetrics(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onEnd() {
            ChatChannelIMEmojiAnimWidget r100 = this.f134530a;
            int r101 = ChatChannelIMEmojiAnimWidget.f134522h;
            r100.xq("player end");
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStart() {
            ChatChannelIMEmojiAnimWidget r100 = this.f134530a;
            int r101 = ChatChannelIMEmojiAnimWidget.f134522h;
            r100.xq("player start");
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStop() {
            ChatChannelIMEmojiAnimWidget r100 = this.f134530a;
            int r101 = ChatChannelIMEmojiAnimWidget.f134522h;
            r100.xq("player stop");
        }

        public b(ChatChannelIMEmojiAnimWidget r100) {
            this.f134530a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onFileLoaded(int r100, int r101) {
            ChatChannelIMEmojiAnimWidget r102 = this.f134530a;
            String r103 = "onFileLoaded with=" + r100 + " height=" + r101;
            int r104 = ChatChannelIMEmojiAnimWidget.f134522h;
            r102.xq(r103);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void updateTextEffectPosition(float r100, float r101, float r102, float r103) {
            ChatChannelIMEmojiAnimWidget r104 = this.f134530a;
            String r105 = "updateTextEffectPosition. w=" + r100 + " h=" + r101 + " x=" + r102 + " y=" + r103;
            int r106 = ChatChannelIMEmojiAnimWidget.f134522h;
            r104.xq(r105);
            float r107 = 0;
            if (r100 > r107) goto L5;
            return;
        L5:
            if (r101 <= r107) goto L23;
            ViewGroup r108 = this.f134530a.f134523a;
            if (r108 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("playerView");
        L10:
            if (PadConfigUtils.c() == false) goto L17;
            if (e5.n() == false) goto L14;
            float r109 = UtilityKotlinExtentionsKt.h(155);
            float r110 = 0.3f;
        L15:
            float r111 = r109 * r110;
        L20:
            r108.setTranslationY(r111);
            return;
        L14:
            r109 = UtilityKotlinExtentionsKt.h(155);
            r110 = 0.5f;
            goto L15
        L17:
            if (this.f134530a.isScreenPortrait() == false) goto L19;
            r111 = UtilityKotlinExtentionsKt.h(155) + (s1.w() - r101);
            goto L20
        L19:
            r111 = 0.0f;
            goto L20
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_chat_channel_im_emoji_anim_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        yq("onUnload");
        this.f134524b = null;
        this.f134525c.clear();
        ((Handler) this.f134528f.getValue()).removeCallbacksAndMessages(null);
    }

    public ChatChannelIMEmojiAnimWidget() {
        this.f134525c = new CompositeDisposable();
        this.f134527e = -1;
        this.f134528f = LazyKt.lazy(ChatChannelIMEmojiAnimWidget$mainHandler$2.INSTANCE);
        this.f134529g = new b(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f134523a = (ViewGroup) this.contentView.findViewById(R.id.channel_emoji_anim_player_view);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        xq(WidgetCostModule.TYPE_ON_LOAD);
        RoomContext r101 = getDataContext();
        if (r101 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.f r102 = com.bytedance.android.livesdk.interactivity.api.g.a(r101);
        if (r102 == null) goto L11;
        com.bytedance.live.datacontext.j<s22.e> r103 = r102.getChatChannelManager();
        if (r103 == null) goto L12;
        r103.c(new AnonymousClass1(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void xq(String r100) {
        ALogger.i("ChatChannelIMEmojiAnimWidget", r100);
    }

    public final void yq(String r100) {
        xq("release. reason=" + r100);
        this.f134527e = -1;
        com.bytedance.android.livesdk.interactivity.api.c r101 = this.f134524b;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        Disposable r102 = this.f134526d;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        this.f134526d = null;
    }

    public static final void wq(ChatChannelIMEmojiAnimWidget r100, long r101) {
        r100.getClass();
        r100.xq("onChannelPageVisible. curChannelId=" + r100.f134527e + " channelId=" + r101);
        if (r100.f134527e != r101) goto L6;
        return;
    L6:
        if (r101 > 0) goto L8;
        r100.yq("invalid channelId " + r101);
        return;
    L8:
        r100.f134527e = r101;
        Disposable r102 = r100.f134526d;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        s22.e r103 = ChatChannelUtils.b(r100.getDataContext());
        if (r103 == null) goto L20;
        s22.a r104 = r103.getChannel(r101);
        if (r104 == null) goto L20;
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r105 = r104.A();
        if (r105 == null) goto L20;
        PropertyOwner<IMessageListManager.a> r106 = r105.f140882c;
        r106.getClass();
        Observable<IMessageListManager.a> r107 = r106.subscribeOn(AndroidSchedulers.mainThread());
        if (r107 == null) goto L20;
        Disposable r108 = r107.subscribe(new h(r100));
    L21:
        r100.f134526d = r108;
        return;
    L20:
        r108 = null;
        goto L21
    }
}
