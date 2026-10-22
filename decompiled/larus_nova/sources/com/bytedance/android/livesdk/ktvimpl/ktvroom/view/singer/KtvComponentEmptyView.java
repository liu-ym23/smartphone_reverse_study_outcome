package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb0.b;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.locallife.live.view.LiveLifeAtmosphereAnimView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u000bR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentEmptyView;", "Landroid/widget/FrameLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getKtvComponentInfoContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "ktvComponentInfoContainer", "Landroid/widget/LinearLayout;", "b", "getKtvComponentSingInfoHintContainer", "()Landroid/widget/LinearLayout;", "ktvComponentSingInfoHintContainer", "Landroid/widget/TextView;", "c", "getKtvComponentSingInfoHintName", "()Landroid/widget/TextView;", "ktvComponentSingInfoHintName", "d", "getKtvComponentSingInfoHintSinger", "ktvComponentSingInfoHintSinger", "e", "getKtvComponentSingInfoContainer", "ktvComponentSingInfoContainer", "Lcom/bytedance/android/live/core/widget/HSImageView;", "f", "getKtvComponentSingerAvatar", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "ktvComponentSingerAvatar", ce.f26391f, "getKtvComponentSingerInfoHint", "ktvComponentSingerInfoHint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentEmptyView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f145280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f145281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f145282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f145283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f145284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f145285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f145286g;

    public static final class a {
    }

    static {
    }

    public KtvComponentEmptyView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvComponentEmptyView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ConstraintLayout getKtvComponentInfoContainer() {
        return (ConstraintLayout) this.f145280a.getValue();
    }

    private final LinearLayout getKtvComponentSingInfoContainer() {
        return (LinearLayout) this.f145284e.getValue();
    }

    private final LinearLayout getKtvComponentSingInfoHintContainer() {
        return (LinearLayout) this.f145281b.getValue();
    }

    private final TextView getKtvComponentSingInfoHintName() {
        return (TextView) this.f145282c.getValue();
    }

    private final TextView getKtvComponentSingInfoHintSinger() {
        return (TextView) this.f145283d.getValue();
    }

    private final HSImageView getKtvComponentSingerAvatar() {
        return (HSImageView) this.f145285f.getValue();
    }

    private final TextView getKtvComponentSingerInfoHint() {
        return (TextView) this.f145286g.getValue();
    }

    public final void b(KtvMusic r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LinearLayout r101 = getKtvComponentSingInfoContainer();
        if (r101 == null) goto L7;
        UtilityKotlinExtentionsKt.t(r101);
    L7:
        LinearLayout r102 = getKtvComponentSingInfoHintContainer();
        if (r102 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r102);
    L10:
        String r103 = r100.getMTitle();
        String r104 = "";
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        String r105 = r100.getMAuthor();
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        ConstraintLayout r106 = getKtvComponentInfoContainer();
        if (r106 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r106);
        r106.setBackground(null);
    L19:
        TextView r107 = getKtvComponentSingInfoHintName();
        if (r107 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r107);
        r107.setText(r103);
    L22:
        TextView r108 = getKtvComponentSingInfoHintSinger();
        if (r108 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r108);
        if (r105.length() != 0) goto L27;
        boolean r109 = true;
    L28:
        if (r109 == true) goto L31;
        r104 = " -" + a(r105, 10);
    L31:
        r108.setText(r104);
        return;
    L27:
        r109 = false;
        goto L28
    }

    public final void d(KtvMusic r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        LinearLayout r100 = getKtvComponentSingInfoContainer();
        if (r100 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r100);
    L7:
        LinearLayout r101 = getKtvComponentSingInfoHintContainer();
        if (r101 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r101);
    L10:
        OrderInfo r102 = r110.getOrderInfo();
        if (r102 == null) goto L13;
        InteractiveSongUserInfo r103 = r102.getTopUser();
    L14:
        if (r103 == null) goto L16;
        String r104 = r103.getHighScoreSongCountFlex();
    L17:
        int r105 = d5.b(r104);
        if (r105 <= 0) goto L20;
        boolean r106 = true;
    L21:
        WantListenInfo r107 = r110.getWantListenInfo();
        long r108 = 0;
        if (r107 == null) goto L24;
        long r109 = r107.getWantListenCount().longValue();
    L26:
        if (r109 <= 0) goto L28;
        boolean r111 = true;
    L29:
        StringBuilder r112 = new StringBuilder("showSecondInfo ;; isWantListenSong == ");
        r112.append(r111);
        r112.append(" ;; isHighScoreSong == ");
        r112.append(r106);
        r112.append(" ;; topUser?.avatarThumb == ");
        if (r103 == null) goto L32;
        k r113 = r103.getAvatarThumbFlex();
    L33:
        r112.append(r113);
        r112.append(" ;; topUser?.nickName == ");
        if (r103 == null) goto L36;
        String r114 = r103.getNickNameFlex();
    L37:
        r112.append(r114);
        ALogger.i("KtvComponentEmptyView", r112.toString());
        String r115 = "";
        if (r111 == false) goto L56;
        WantListenInfo r116 = r110.getWantListenInfo();
        if (r116 == null) goto L42;
        r108 = r116.getWantListenCount().longValue();
    L42:
        bb0.a r117 = b.f18525a;
        long r118 = r110.getMId();
        bb0.a r119 = b.f18525a;
        if (r119 == null) goto L45;
        boolean r120 = r119.i(r118);
    L46:
        if (r120 == true) goto L48;
        String r121 = s1.C(R.string.ttlive_ktv_only_other_want_listen_tips, new Object[]{Long.valueOf(r108)});
    L53:
        r115 = r121;
    L54:
        c(0, null, R.drawable.ttlive_ktv_want_listen_white_icon, 14.0f, r115);
        return;
    L48:
        if (r108 <= 1) goto L50;
        r121 = s1.C(R.string.ttlive_ktv_self_and_other_want_listen_tips, new Object[]{Long.valueOf(r108 - 1)});
        goto L53
    L50:
        if (r108 != 1) goto L54;
        r121 = s1.B(R.string.ttlive_ktv_only_self_want_listen_tips);
        goto L53
    L45:
        r120 = false;
        goto L46
    L56:
        if (r106 == false) goto L77;
        if (r103 == null) goto L60;
        k r122 = r103.getAvatarThumbFlex();
    L62:
        if ((r122 instanceof k) == true) goto L64;
        k r123 = null;
    L65:
        StringBuilder r124 = new StringBuilder();
        if (r103 == null) goto L71;
        String r125 = r103.getNickNameFlex();
        if (r125 == null) goto L71;
        r115 = r125;
    L71:
        r124.append(a(r115, 16));
        r124.append("唱过");
        if (r105 <= 999) goto L74;
        String r126 = LiveLifeAtmosphereAnimView.TV_MAX_NUM_FLAMES;
    L75:
        r124.append(r126);
        r124.append("首高分歌");
        c(R.drawable.ttlive_bg_ktv_component_sing_info_bg, r123, 0, 10.0f, r124.toString());
        return;
    L74:
        r126 = String.valueOf(r105);
        goto L75
    L64:
        r123 = r122;
        goto L65
    L60:
        r122 = null;
        goto L62
    L77:
        if (r103 == null) goto L79;
        k r127 = r103.getAvatarThumbFlex();
    L81:
        if ((r127 instanceof k) == true) goto L84;
        r127 = null;
    L84:
        if (r103 == null) goto L89;
        String r128 = r103.getNickNameFlex();
        if (r128 == null) goto L89;
        r115 = r128;
    L89:
        c(0, r127, 0, 14.0f, a(r115, 16));
        return;
    L79:
        r127 = null;
        goto L81
    L36:
        r114 = null;
        goto L37
    L32:
        r113 = null;
        goto L33
    L28:
        r111 = false;
        goto L29
    L24:
        r109 = 0;
        goto L26
    L20:
        r106 = false;
        goto L21
    L16:
        r104 = null;
        goto L17
    L13:
        r103 = null;
        goto L14
    }

    public static String a(String r100, int r101) {
        if (r100.length() > r101) goto L6;
        return r100;
    L6:
        return r100.substring(0, r101) + "...";
    }

    public KtvComponentEmptyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.ttlive_ksong_component_empty_view, this);
        this.f145280a = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentInfoContainer$2(this));
        this.f145281b = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoHintContainer$2(this));
        this.f145282c = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoHintName$2(this));
        this.f145283d = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoHintSinger$2(this));
        this.f145284e = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingInfoContainer$2(this));
        this.f145285f = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingerAvatar$2(this));
        this.f145286g = LazyKt.lazy(new KtvComponentEmptyView$ktvComponentSingerInfoHint$2(this));
    }

    public /* synthetic */ KtvComponentEmptyView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void c(int r100, k r101, int r102, float r103, String r104) {
        LinearLayout r105 = getKtvComponentSingInfoContainer();
        if (r105 == null) goto L14;
        r105.setBackground(null);
        r105.setBackgroundResource(r100);
        HSImageView r106 = getKtvComponentSingerAvatar();
        if (r106 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r106);
        if (r101 == null) goto L9;
        ImageLoader.bindImage(r106, r101);
        goto L10
    L9:
        a1.m(r106, r102);
    L10:
        TextView r107 = getKtvComponentSingerInfoHint();
        if (r107 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r107);
        r107.setTextSize(r103);
        r107.setText(r104);
        return;
    L15:
        return;
    }
}
