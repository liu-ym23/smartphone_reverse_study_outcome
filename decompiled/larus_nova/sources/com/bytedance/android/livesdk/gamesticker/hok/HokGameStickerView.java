package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.gamesticker.hok.anim.TaskState;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameStickerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameRoleView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getRoleView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameRoleView;", "roleView", "b", "getSecondRoleView", "secondRoleView", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameMoneyView;", "c", "getMoneyView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameMoneyView;", "moneyView", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameWinView;", "d", "getWinView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameWinView;", "winView", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameEquipView;", "e", "getEquipView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameEquipView;", "equipView", "Landroid/view/View;", "f", "getStickerBgView", "()Landroid/view/View;", "stickerBgView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameStickerView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f125554i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f125557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f125558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f125559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f125560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f125561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gamesticker.hok.anim.e f125562h;

    public static final class a implements com.bytedance.android.livesdk.gamesticker.hok.anim.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HokGameStickerView f125563a;

        public a(HokGameStickerView r100) {
            this.f125563a = r100;
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.d
        public final void a(com.bytedance.android.livesdk.gamesticker.hok.anim.a r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            HokGameStickerView r101 = this.f125563a;
            r100.e();
            int r102 = HokGameStickerView.f125554i;
            r101.getClass();
            this.f125563a.g();
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.d
        public final void b(com.bytedance.android.livesdk.gamesticker.hok.anim.a r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            HokGameStickerView r101 = this.f125563a;
            r100.e();
            int r102 = HokGameStickerView.f125554i;
            r101.getClass();
        }
    }

    public static final class b implements com.bytedance.android.livesdk.gamesticker.hok.anim.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HokGameStickerView f125564a;

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameRoleView a() {
            return HokGameStickerView.d(this.f125564a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameMoneyView b() {
            return HokGameStickerView.b(this.f125564a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameWinView c() {
            return HokGameStickerView.e(this.f125564a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameRoleView d() {
            return HokGameStickerView.c(this.f125564a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameEquipView e() {
            return HokGameStickerView.a(this.f125564a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final float getHeight() {
            if (this.f125564a.getHeight() == 0) goto L8;
            int r100 = this.f125564a.getHeight();
        L6:
            return r100;
        L8:
            if (this.f125564a.getMeasuredHeight() == 0) goto L10;
            r100 = this.f125564a.getMeasuredHeight();
            goto L6
        L10:
            r100 = s1.f(28.0f);
            goto L6
        }

        public b(HokGameStickerView r100) {
            this.f125564a = r100;
        }
    }

    public HokGameStickerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HokGameStickerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final HokGameEquipView getEquipView() {
        return (HokGameEquipView) this.f125559e.getValue();
    }

    private final HokGameMoneyView getMoneyView() {
        return (HokGameMoneyView) this.f125557c.getValue();
    }

    private final HokGameRoleView getRoleView() {
        return (HokGameRoleView) this.f125555a.getValue();
    }

    private final HokGameRoleView getSecondRoleView() {
        return (HokGameRoleView) this.f125556b.getValue();
    }

    private final View getStickerBgView() {
        return (View) this.f125560f.getValue();
    }

    private final HokGameWinView getWinView() {
        return (HokGameWinView) this.f125558d.getValue();
    }

    public final void g() {
        if (this.f125562h.f125582a.isEmpty() == true) goto L5;
        com.bytedance.android.livesdk.gamesticker.hok.anim.a r100 = this.f125562h.f125582a.peek();
        if (r100 != null) goto L9;
        return;
    L9:
        TaskState r101 = r100.f125575a;
        r100.e();
        Objects.toString(r100.f125575a);
        if (r101 != TaskState.CREATE) goto L13;
        r100.d();
        return;
    L13:
        if (r101 != TaskState.END) goto L17;
        com.bytedance.android.livesdk.gamesticker.hok.anim.e r102 = this.f125562h;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "task");
        r100.f125576b = null;
        r100.f125577c = null;
        r102.f125582a.remove(r100);
        g();
        return;
    L17:
        return;
    }

    public final void i() {
        com.bytedance.android.livesdk.gamesticker.hok.anim.e r100 = this.f125562h;
        Iterator<com.bytedance.android.livesdk.gamesticker.hok.anim.a> r101 = r100.f125582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.gamesticker.hok.anim.a r102 = r101.next();
        r102.f125576b = null;
        r102.f125577c = null;
        r102.a();
        goto L4
    L6:
        r100.f125582a.clear();
        getRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getWinView().setLiveInfo(null);
        getMoneyView().setMoneyCount(null);
        getEquipView().setEquipState(null);
    }

    public static final /* synthetic */ HokGameEquipView a(HokGameStickerView r100) {
        return r100.getEquipView();
    }

    public static final /* synthetic */ HokGameMoneyView b(HokGameStickerView r100) {
        return r100.getMoneyView();
    }

    public static final /* synthetic */ HokGameRoleView c(HokGameStickerView r100) {
        return r100.getRoleView();
    }

    public static final /* synthetic */ HokGameRoleView d(HokGameStickerView r100) {
        return r100.getSecondRoleView();
    }

    public static final /* synthetic */ HokGameWinView e(HokGameStickerView r100) {
        return r100.getWinView();
    }

    public final void f(c3 r100) {
        if (Intrinsics.areEqual(r100.g(), Boolean.TRUE) == false) goto L5;
        setVisibility(0);
        return;
    L5:
        setVisibility(4);
    }

    public final void h(int r100) {
        if (PadConfigUtils.c() == false) goto L6;
        return;
    L6:
        if (this.f125561g == r100) goto L8;
    L10:
        View r101 = getStickerBgView();
        if (r100 != 0) goto L13;
        Drawable r102 = s1.m(R.drawable.ttlive_bg_hok_sticker_vertical);
    L14:
        r101.setBackground(r102);
        this.f125561g = r100;
        return;
    L13:
        r102 = s1.m(R.drawable.ttlive_bg_hok_sticker_landscape);
        goto L14
    L8:
        if (getStickerBgView().getBackground() == null) goto L10;
    }

    public HokGameStickerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125555a = LazyKt.lazy(new HokGameStickerView$roleView$2(this));
        this.f125556b = LazyKt.lazy(new HokGameStickerView$secondRoleView$2(this));
        this.f125557c = LazyKt.lazy(new HokGameStickerView$moneyView$2(this));
        this.f125558d = LazyKt.lazy(new HokGameStickerView$winView$2(this));
        this.f125559e = LazyKt.lazy(new HokGameStickerView$equipView$2(this));
        this.f125560f = LazyKt.lazy(new HokGameStickerView$stickerBgView$2(this));
        b r103 = new b(this);
        this.f125562h = new com.bytedance.android.livesdk.gamesticker.hok.anim.e(new a(this), r103);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_game_hok_battle_sticker_view, this);
        getRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getWinView().setLiveInfo(null);
        getMoneyView().setMoneyCount(null);
        getEquipView().setEquipState(null);
    }

    public /* synthetic */ HokGameStickerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
