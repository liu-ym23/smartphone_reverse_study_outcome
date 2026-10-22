package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 a2\u00020\u0001:\u0001bB\u0007¢\u0006\u0004\b_\u0010`J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\rR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\rR!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\rR!\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\rR!\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\rR!\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010\rR!\u00106\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR!\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR!\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\rR!\u0010C\u001a\b\u0012\u0004\u0012\u00020@0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR!\u0010F\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\rR!\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\rR!\u0010L\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u000b\u001a\u0004\bK\u0010\rR!\u0010O\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u000b\u001a\u0004\bN\u0010\rR!\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u000b\u001a\u0004\bQ\u0010\rR!\u0010U\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u000b\u001a\u0004\bT\u0010\rR!\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bW\u0010\rR!\u0010[\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u000b\u001a\u0004\bZ\u0010\rR!\u0010^\u001a\b\u0012\u0004\u0012\u00020\\0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u000b\u001a\u0004\b^\u0010\r¨\u0006c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/InteractionWidgetsPosContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "share", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "Lcom/bytedance/live/datacontext/m;", "", "ktvSeatBottomPos$delegate", "Lcom/bytedance/live/datacontext/p;", "getKtvSeatBottomPos", "()Lcom/bytedance/live/datacontext/m;", "ktvSeatBottomPos", "ktvChorusBottomPos$delegate", "getKtvChorusBottomPos", "ktvChorusBottomPos", "audioTalkBottomPos$delegate", "getAudioTalkBottomPos", "audioTalkBottomPos", "audioTalkRadioBottomOffset$delegate", "getAudioTalkRadioBottomOffset", "audioTalkRadioBottomOffset", "audioTalkRadioPublicScreenTopMargin$delegate", "getAudioTalkRadioPublicScreenTopMargin", "audioTalkRadioPublicScreenTopMargin", "videoEqualTalkBottomPos$delegate", "getVideoEqualTalkBottomPos", "videoEqualTalkBottomPos", "Lok1/a;", "audioGiftTrayPos$delegate", "getAudioGiftTrayPos", "audioGiftTrayPos", "platformGiftTrayPos$delegate", "getPlatformGiftTrayPos", "platformGiftTrayPos", "equalVideoTalkGiftTrayPos$delegate", "getEqualVideoTalkGiftTrayPos", "equalVideoTalkGiftTrayPos", "videoChorusGiftTrayPos$delegate", "getVideoChorusGiftTrayPos", "videoChorusGiftTrayPos", "videoTalkTop2V4V4GiftHeightTrayPos$delegate", "getVideoTalkTop2V4V4GiftHeightTrayPos", "videoTalkTop2V4V4GiftHeightTrayPos", "multiPkGiftTrayPos$delegate", "getMultiPkGiftTrayPos", "multiPkGiftTrayPos", "revenuePkGiftTrayPos$delegate", "getRevenuePkGiftTrayPos", "revenuePkGiftTrayPos", "gameGiftTrayPos$delegate", "getGameGiftTrayPos", "gameGiftTrayPos", "mediaGiftTrayPos$delegate", "getMediaGiftTrayPos", "mediaGiftTrayPos", "vsGiftTrayPos$delegate", "getVsGiftTrayPos", "vsGiftTrayPos", "matchRoomGiftTrayPos$delegate", "getMatchRoomGiftTrayPos", "matchRoomGiftTrayPos", "Lok1/b;", "matchRoomMsgTrayPos$delegate", "getMatchRoomMsgTrayPos", "matchRoomMsgTrayPos", "hotMsgTrayPos$delegate", "getHotMsgTrayPos", "hotMsgTrayPos", "answerQuestionContainerHeight$delegate", "getAnswerQuestionContainerHeight", "answerQuestionContainerHeight", "publicScreenHeight$delegate", "getPublicScreenHeight", "publicScreenHeight", "publicScreenLeftMargin$delegate", "getPublicScreenLeftMargin", "publicScreenLeftMargin", "publicScreenRightMargin$delegate", "getPublicScreenRightMargin", "publicScreenRightMargin", "publicScreenBottomMargin$delegate", "getPublicScreenBottomMargin", "publicScreenBottomMargin", "vsChorusConcertHeight$delegate", "getVsChorusConcertHeight", "vsChorusConcertHeight", "publicScreenVisibility$delegate", "getPublicScreenVisibility", "publicScreenVisibility", "", "isPublicScreenWidthHalfMode$delegate", "isPublicScreenWidthHalfMode", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractionWidgetsPosContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private static final int ANCHOR_TOOLBAR_HEIGHT = 0;
    public static final a Companion = null;
    private static final int ENTER_ANIMATION_HEIGHT = 0;
    private static final int GIFT_TRAY_HEIGHT = 0;
    private static final int INPUT_DIALOG_HEIGHT = 0;
    private static final int MULTI_PK_OFFSET_HEIGHT = 0;
    private static final int PAD_TOOLBAR_HEIGHT = 0;
    private static final int SHORT_VIDEO_PUBLIC_SCREEN_HEIGHT = 0;
    private static final int SHORT_VIDEO_SEAT_HEIGHT = 0;
    private static final int SMALL_GIFT_TRAY_HEIGHT = 0;
    private static final String TAG = null;
    private static final int TOOLBAR_HEIGHT = 0;
    private final com.bytedance.live.datacontext.p answerQuestionContainerHeight$delegate;
    private final com.bytedance.live.datacontext.p audioGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p audioTalkBottomPos$delegate;
    private final com.bytedance.live.datacontext.p audioTalkRadioBottomOffset$delegate;
    private final com.bytedance.live.datacontext.p audioTalkRadioPublicScreenTopMargin$delegate;
    private final com.bytedance.live.datacontext.p equalVideoTalkGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p gameGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p hotMsgTrayPos$delegate;
    private final com.bytedance.live.datacontext.p isPublicScreenWidthHalfMode$delegate;
    private final com.bytedance.live.datacontext.p ktvChorusBottomPos$delegate;
    private final com.bytedance.live.datacontext.p ktvSeatBottomPos$delegate;
    private final com.bytedance.live.datacontext.p matchRoomGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p matchRoomMsgTrayPos$delegate;
    private final com.bytedance.live.datacontext.p mediaGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p multiPkGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p platformGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p publicScreenBottomMargin$delegate;
    private final com.bytedance.live.datacontext.p publicScreenHeight$delegate;
    private final com.bytedance.live.datacontext.p publicScreenLeftMargin$delegate;
    private final com.bytedance.live.datacontext.p publicScreenRightMargin$delegate;
    private final com.bytedance.live.datacontext.p publicScreenVisibility$delegate;
    private final com.bytedance.live.datacontext.p revenuePkGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p videoChorusGiftTrayPos$delegate;
    private final com.bytedance.live.datacontext.p videoEqualTalkBottomPos$delegate;
    private final com.bytedance.live.datacontext.p videoTalkTop2V4V4GiftHeightTrayPos$delegate;
    private final com.bytedance.live.datacontext.p vsChorusConcertHeight$delegate;
    private final com.bytedance.live.datacontext.p vsGiftTrayPos$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static InteractionWidgetsPosContext a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(InteractionWidgetsPosContext.class);
            if ((r100 instanceof InteractionWidgetsPosContext) == true) goto L6;
            r100 = null;
        L6:
            return (InteractionWidgetsPosContext) r100;
        }

        public static String d(DataCenter r100) {
            StringBuilder r101 = new StringBuilder();
            r101.append(InteractionWidgetsPosContext.access$getTAG$cp());
            r101.append('_');
            if (r100 == null) goto L5;
            Integer r102 = Integer.valueOf(r100.hashCode());
        L6:
            r101.append(r102);
            return r101.toString();
        L5:
            r102 = null;
            goto L6
        }

        @JvmStatic
        public static InteractionWidgetsPosContext b(DataCenter r100, long r101) {
            DataContext r102 = null;
            if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L24;
            if (r100 == null) goto L9;
            DataContext r103 = com.bytedance.live.datacontext.d.d(d(r100));
            if ((r103 instanceof InteractionWidgetsPosContext) == true) goto L8;
            r103 = null;
        L8:
            InteractionWidgetsPosContext r104 = (InteractionWidgetsPosContext) r103;
        L10:
            if (r104 == null) goto L12;
        L17:
            if (r104 != null) goto L30;
            DataContext r105 = com.bytedance.live.datacontext.d.d(InteractionWidgetsPosContext.class);
            if ((r105 instanceof InteractionWidgetsPosContext) == false) goto L23;
            r102 = r105;
        L23:
            return (InteractionWidgetsPosContext) r102;
        L30:
            return r104;
        L12:
            if (r101 == 0) goto L17;
            DataContext r106 = com.bytedance.live.datacontext.d.d(InteractionWidgetsPosContext.access$getTAG$cp() + '_' + r101);
            if ((r106 instanceof InteractionWidgetsPosContext) == true) goto L16;
            r106 = null;
        L16:
            r104 = (InteractionWidgetsPosContext) r106;
            goto L17
        L9:
            r104 = null;
            goto L10
        L24:
            DataContext r107 = com.bytedance.live.datacontext.d.d(InteractionWidgetsPosContext.class);
            if ((r107 instanceof InteractionWidgetsPosContext) == false) goto L29;
            r102 = r107;
        L29:
            return (InteractionWidgetsPosContext) r102;
        }

        public static /* synthetic */ InteractionWidgetsPosContext c(a r100, DataCenter r101, long r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = 0;
        L8:
            r100.getClass();
            return b(r101, r102);
        }
    }

    @JvmStatic
    public static final InteractionWidgetsPosContext getShared() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final InteractionWidgetsPosContext getShared(DataCenter r100, long r101) {
        Companion.getClass();
        return a.b(r100, r101);
    }

    public final com.bytedance.live.datacontext.m<Integer> getAnswerQuestionContainerHeight() {
        return (com.bytedance.live.datacontext.m) this.answerQuestionContainerHeight$delegate.a(this, $$delegatedProperties[19]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getAudioGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.audioGiftTrayPos$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getAudioTalkBottomPos() {
        return (com.bytedance.live.datacontext.m) this.audioTalkBottomPos$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getAudioTalkRadioBottomOffset() {
        return (com.bytedance.live.datacontext.m) this.audioTalkRadioBottomOffset$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getAudioTalkRadioPublicScreenTopMargin() {
        return (com.bytedance.live.datacontext.m) this.audioTalkRadioPublicScreenTopMargin$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getEqualVideoTalkGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.equalVideoTalkGiftTrayPos$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getGameGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.gameGiftTrayPos$delegate.a(this, $$delegatedProperties[13]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getHotMsgTrayPos() {
        return (com.bytedance.live.datacontext.m) this.hotMsgTrayPos$delegate.a(this, $$delegatedProperties[18]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getKtvChorusBottomPos() {
        return (com.bytedance.live.datacontext.m) this.ktvChorusBottomPos$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getKtvSeatBottomPos() {
        return (com.bytedance.live.datacontext.m) this.ktvSeatBottomPos$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getMatchRoomGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.matchRoomGiftTrayPos$delegate.a(this, $$delegatedProperties[16]);
    }

    public final com.bytedance.live.datacontext.m<ok1.b> getMatchRoomMsgTrayPos() {
        return (com.bytedance.live.datacontext.m) this.matchRoomMsgTrayPos$delegate.a(this, $$delegatedProperties[17]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getMediaGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.mediaGiftTrayPos$delegate.a(this, $$delegatedProperties[14]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getMultiPkGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.multiPkGiftTrayPos$delegate.a(this, $$delegatedProperties[11]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getPlatformGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.platformGiftTrayPos$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getPublicScreenBottomMargin() {
        return (com.bytedance.live.datacontext.m) this.publicScreenBottomMargin$delegate.a(this, $$delegatedProperties[23]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getPublicScreenHeight() {
        return (com.bytedance.live.datacontext.m) this.publicScreenHeight$delegate.a(this, $$delegatedProperties[20]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getPublicScreenLeftMargin() {
        return (com.bytedance.live.datacontext.m) this.publicScreenLeftMargin$delegate.a(this, $$delegatedProperties[21]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getPublicScreenRightMargin() {
        return (com.bytedance.live.datacontext.m) this.publicScreenRightMargin$delegate.a(this, $$delegatedProperties[22]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getPublicScreenVisibility() {
        return (com.bytedance.live.datacontext.m) this.publicScreenVisibility$delegate.a(this, $$delegatedProperties[25]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getRevenuePkGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.revenuePkGiftTrayPos$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getVideoChorusGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.videoChorusGiftTrayPos$delegate.a(this, $$delegatedProperties[9]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getVideoEqualTalkBottomPos() {
        return (com.bytedance.live.datacontext.m) this.videoEqualTalkBottomPos$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getVideoTalkTop2V4V4GiftHeightTrayPos() {
        return (com.bytedance.live.datacontext.m) this.videoTalkTop2V4V4GiftHeightTrayPos$delegate.a(this, $$delegatedProperties[10]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getVsChorusConcertHeight() {
        return (com.bytedance.live.datacontext.m) this.vsChorusConcertHeight$delegate.a(this, $$delegatedProperties[24]);
    }

    public final com.bytedance.live.datacontext.m<ok1.a> getVsGiftTrayPos() {
        return (com.bytedance.live.datacontext.m) this.vsGiftTrayPos$delegate.a(this, $$delegatedProperties[15]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isPublicScreenWidthHalfMode() {
        return (com.bytedance.live.datacontext.m) this.isPublicScreenWidthHalfMode$delegate.a(this, $$delegatedProperties[26]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "ktvSeatBottomPos", "getKtvSeatBottomPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "ktvChorusBottomPos", "getKtvChorusBottomPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "audioTalkBottomPos", "getAudioTalkBottomPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "audioTalkRadioBottomOffset", "getAudioTalkRadioBottomOffset()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "audioTalkRadioPublicScreenTopMargin", "getAudioTalkRadioPublicScreenTopMargin()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "videoEqualTalkBottomPos", "getVideoEqualTalkBottomPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "audioGiftTrayPos", "getAudioGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "platformGiftTrayPos", "getPlatformGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "equalVideoTalkGiftTrayPos", "getEqualVideoTalkGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "videoChorusGiftTrayPos", "getVideoChorusGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "videoTalkTop2V4V4GiftHeightTrayPos", "getVideoTalkTop2V4V4GiftHeightTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "multiPkGiftTrayPos", "getMultiPkGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "revenuePkGiftTrayPos", "getRevenuePkGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "gameGiftTrayPos", "getGameGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "mediaGiftTrayPos", "getMediaGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "vsGiftTrayPos", "getVsGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "matchRoomGiftTrayPos", "getMatchRoomGiftTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "matchRoomMsgTrayPos", "getMatchRoomMsgTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "hotMsgTrayPos", "getHotMsgTrayPos()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "answerQuestionContainerHeight", "getAnswerQuestionContainerHeight()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "publicScreenHeight", "getPublicScreenHeight()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "publicScreenLeftMargin", "getPublicScreenLeftMargin()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "publicScreenRightMargin", "getPublicScreenRightMargin()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "publicScreenBottomMargin", "getPublicScreenBottomMargin()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "vsChorusConcertHeight", "getVsChorusConcertHeight()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "publicScreenVisibility", "getPublicScreenVisibility()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractionWidgetsPosContext.class, "isPublicScreenWidthHalfMode", "isPublicScreenWidthHalfMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
        TAG = "InteractionWidgetsPosContext";
        ENTER_ANIMATION_HEIGHT = UtilityKotlinExtentionsKt.i(32);
        GIFT_TRAY_HEIGHT = UtilityKotlinExtentionsKt.i(108);
        SMALL_GIFT_TRAY_HEIGHT = UtilityKotlinExtentionsKt.i(98);
        MULTI_PK_OFFSET_HEIGHT = UtilityKotlinExtentionsKt.i(4);
        TOOLBAR_HEIGHT = UtilityKotlinExtentionsKt.i(52);
        ANCHOR_TOOLBAR_HEIGHT = UtilityKotlinExtentionsKt.i(60);
        PAD_TOOLBAR_HEIGHT = UtilityKotlinExtentionsKt.i(64);
        INPUT_DIALOG_HEIGHT = s1.j(R.dimen.ttlive_input_dialog_input_container_height);
        SHORT_VIDEO_SEAT_HEIGHT = s1.j(R.dimen.ttlive_short_video_linker_list_container_height);
        SHORT_VIDEO_PUBLIC_SCREEN_HEIGHT = UtilityKotlinExtentionsKt.i(90);
    }

    public final void share() {
        com.bytedance.live.datacontext.b.a(this, InteractionWidgetsPosContext.class);
    }

    public InteractionWidgetsPosContext() {
        this.ktvSeatBottomPos$delegate = com.bytedance.live.datacontext.q.d(this, Integer.valueOf(y.f119318a));
        this.ktvChorusBottomPos$delegate = com.bytedance.live.datacontext.q.d(this, Integer.valueOf(y.f119319b));
        this.audioTalkBottomPos$delegate = com.bytedance.live.datacontext.q.d(this, Integer.valueOf(y.f119320c));
        this.audioTalkRadioBottomOffset$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.audioTalkRadioPublicScreenTopMargin$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.videoEqualTalkBottomPos$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.audioGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.platformGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.equalVideoTalkGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.videoChorusGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.videoTalkTop2V4V4GiftHeightTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.multiPkGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.revenuePkGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.gameGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.mediaGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.vsGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.matchRoomGiftTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.a(-10086, 0));
        this.matchRoomMsgTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, new ok1.b(UtilityKotlinExtentionsKt.i(0), true));
        this.hotMsgTrayPos$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.answerQuestionContainerHeight$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.publicScreenHeight$delegate = com.bytedance.live.datacontext.q.d(this, Integer.valueOf(UtilityKotlinExtentionsKt.i(160)));
        this.publicScreenLeftMargin$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.publicScreenRightMargin$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.publicScreenBottomMargin$delegate = com.bytedance.live.datacontext.q.d(this, Integer.valueOf(UtilityKotlinExtentionsKt.i(52)));
        this.vsChorusConcertHeight$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.publicScreenVisibility$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.isPublicScreenWidthHalfMode$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.FALSE);
    }

    public static final /* synthetic */ int access$getANCHOR_TOOLBAR_HEIGHT$cp() {
        return ANCHOR_TOOLBAR_HEIGHT;
    }

    public static final /* synthetic */ int access$getENTER_ANIMATION_HEIGHT$cp() {
        return ENTER_ANIMATION_HEIGHT;
    }

    public static final /* synthetic */ int access$getGIFT_TRAY_HEIGHT$cp() {
        return GIFT_TRAY_HEIGHT;
    }

    public static final /* synthetic */ int access$getINPUT_DIALOG_HEIGHT$cp() {
        return INPUT_DIALOG_HEIGHT;
    }

    public static final /* synthetic */ int access$getMULTI_PK_OFFSET_HEIGHT$cp() {
        return MULTI_PK_OFFSET_HEIGHT;
    }

    public static final /* synthetic */ int access$getPAD_TOOLBAR_HEIGHT$cp() {
        return PAD_TOOLBAR_HEIGHT;
    }

    public static final /* synthetic */ int access$getSHORT_VIDEO_PUBLIC_SCREEN_HEIGHT$cp() {
        return SHORT_VIDEO_PUBLIC_SCREEN_HEIGHT;
    }

    public static final /* synthetic */ int access$getSHORT_VIDEO_SEAT_HEIGHT$cp() {
        return SHORT_VIDEO_SEAT_HEIGHT;
    }

    public static final /* synthetic */ int access$getSMALL_GIFT_TRAY_HEIGHT$cp() {
        return SMALL_GIFT_TRAY_HEIGHT;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ int access$getTOOLBAR_HEIGHT$cp() {
        return TOOLBAR_HEIGHT;
    }

    public final void share(DataCenter r100, long r101) {
        if (r100 == null) goto L5;
        Companion.getClass();
        com.bytedance.live.datacontext.b.a(this, a.d(r100));
    L5:
        if (r101 == 0) goto L8;
        Companion.getClass();
        com.bytedance.live.datacontext.b.a(this, access$getTAG$cp() + '_' + r101);
        return;
    }
}
