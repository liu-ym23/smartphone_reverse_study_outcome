package com.bytedance.android.live.liveinteract.voicechat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li0.d;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/view/VoiceChatRecyclerView;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "getRedTeamBg", "()Landroid/graphics/drawable/Drawable;", "redTeamBg", "Landroid/graphics/Rect;", ce.f26391f, "getRedTeamRect", "()Landroid/graphics/Rect;", "redTeamRect", "h", "getBlueTeamBg", "blueTeamBg", RXScreenCaptureService.KEY_INDEX, "getBlueTeamRect", "blueTeamRect", "Lcom/bytedance/android/live/liveinteract/voicechat/view/VoiceChatTeamFightItemDecoration;", ce.f26395j, "getTeamFightDecoration", "()Lcom/bytedance/android/live/liveinteract/voicechat/view/VoiceChatTeamFightItemDecoration;", "teamFightDecoration", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceChatRecyclerView extends LinkMicRecyclerView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f80887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f80888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f80889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f80890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f80891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f80892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f80893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f80894m;

    private final Drawable getBlueTeamBg() {
        return (Drawable) this.f80889h.getValue();
    }

    private final Rect getBlueTeamRect() {
        return (Rect) this.f80890i.getValue();
    }

    private final Drawable getRedTeamBg() {
        return (Drawable) this.f80887f.getValue();
    }

    private final Rect getRedTeamRect() {
        return (Rect) this.f80888g.getValue();
    }

    private final VoiceChatTeamFightItemDecoration getTeamFightDecoration() {
        return (VoiceChatTeamFightItemDecoration) this.f80891j.getValue();
    }

    public final void t() {
        this.f80893l = false;
        this.f80894m = false;
        removeItemDecoration(getTeamFightDecoration());
        invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "c");
        if (this.f80893l == true) goto L5;
    L24:
        super.onDraw(r100);
        return;
    L5:
        if (d.e() == true) goto L24;
        Rect r101 = getRedTeamRect();
        r101.right = (getWidth() / 2) - (this.f80892k / 2);
        Rect r102 = getRedTeamRect();
        r102.bottom = getHeight();
        if (this.f80894m == false) goto L9;
        Rect r103 = getRedTeamRect();
        r103.top = (getHeight() * 95) / MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL;
    L9:
        Drawable r104 = getRedTeamBg();
        if (r104 == null) goto L12;
        r104.setBounds(getRedTeamRect());
    L12:
        Drawable r105 = getRedTeamBg();
        if (r105 == null) goto L15;
        r105.draw(r100);
    L15:
        Rect r106 = getBlueTeamRect();
        r106.left = (getWidth() / 2) + (this.f80892k / 2);
        Rect r107 = getBlueTeamRect();
        r107.right = getWidth();
        Rect r108 = getBlueTeamRect();
        r108.bottom = getHeight();
        if (this.f80894m == false) goto L18;
        Rect r109 = getBlueTeamRect();
        r109.top = (getHeight() * 95) / MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL;
    L18:
        Drawable r110 = getBlueTeamBg();
        if (r110 == null) goto L21;
        r110.setBounds(getBlueTeamRect());
    L21:
        Drawable r111 = getBlueTeamBg();
        if (r111 == null) goto L24;
        r111.draw(r100);
        goto L24
    }

    public VoiceChatRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public VoiceChatRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f80887f = InfraKotlinExtsKt.mainThreadLazy(VoiceChatRecyclerView$redTeamBg$2.INSTANCE);
        this.f80888g = InfraKotlinExtsKt.mainThreadLazy(new VoiceChatRecyclerView$redTeamRect$2(this));
        this.f80889h = InfraKotlinExtsKt.mainThreadLazy(VoiceChatRecyclerView$blueTeamBg$2.INSTANCE);
        this.f80890i = InfraKotlinExtsKt.mainThreadLazy(new VoiceChatRecyclerView$blueTeamRect$2(this));
        this.f80891j = InfraKotlinExtsKt.mainThreadLazy(VoiceChatRecyclerView$teamFightDecoration$2.INSTANCE);
        this.f80892k = s1.f(1.0f);
    }
}
