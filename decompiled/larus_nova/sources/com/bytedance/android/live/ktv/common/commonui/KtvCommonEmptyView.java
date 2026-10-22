package com.bytedance.android.live.ktv.common.commonui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.h;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kb0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "Landroid/widget/FrameLayout;", "", "Lkotlin/Function0;", "", "goSelectMusicAction", "setGoSelectMusicAction", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonEmptyView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f69479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f69480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f69481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f69482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f69483e;

    public KtvCommonEmptyView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvCommonEmptyView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void c(int r100) {
        if (r100 != 0) goto L7;
        LinearLayout r101 = this.f69482d;
        if (r101 == null) goto L17;
        r101.setVisibility(r100);
        return;
    L17:
        return;
    L7:
        if (r100 != 8) goto L12;
        LinearLayout r102 = this.f69482d;
        if (r102 == null) goto L19;
        r102.setVisibility(r100);
        return;
    L19:
        return;
    L12:
        if (r100 != 4) goto L21;
        LinearLayout r103 = this.f69482d;
        if (r103 == null) goto L22;
        r103.setVisibility(r100);
        return;
    L22:
        return;
    }

    public void setGoSelectMusicAction(Function0<Unit> r100) {
        LinearLayout r101 = this.f69482d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new b(r100));
        return;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "hintPhase1");
        Intrinsics.checkNotNullParameter(r101, "hintPhase2");
        TextView r102 = this.f69480b;
        if (r102 == null) goto L5;
        r102.setText(r100);
    L5:
        TextView r103 = this.f69481c;
        if (r103 == null) goto L9;
        r103.setText(r101);
        return;
    }

    public final void b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        String r102 = "";
        switch(r100.hashCode()) {
            case -2123439502: goto L39;
            case -1877754167: goto L36;
            case -906336856: goto L28;
            case -808572632: goto L17;
            case 3541915: goto L14;
            case 1050790300: goto L6;
            default: goto L46;
        };
    L46:
        TextView r103 = this.f69480b;
        if (r103 == null) goto L49;
        r103.setText(s1.B(R.string.ttlive_ktv_tab_music_list_empty_hint));
    L49:
        TextView r104 = this.f69481c;
        if (r104 == null) goto L61;
        r104.setText("");
        return;
    L61:
        return;
    L6:
        if (r100.equals("favorite") == false) goto L46;
        TextView r105 = this.f69480b;
        if (r105 == null) goto L10;
        r105.setText(s1.B(R.string.ttlive_ktv_favorite_list_empty_hint));
    L10:
        TextView r106 = this.f69481c;
        if (r106 == null) goto L53;
        r106.setText("");
        return;
    L53:
        return;
    L14:
        if (r100.equals("sung") == false) goto L46;
    L40:
        TextView r107 = this.f69480b;
        if (r107 == null) goto L43;
        r107.setText(s1.B(R.string.ttlive_ktv_room_selected_list_empty_hint_phase1));
    L43:
        TextView r108 = this.f69481c;
        if (r108 == null) goto L59;
        r108.setText(s1.B(R.string.ttlive_ktv_room_selected_list_empty_hint_phase2));
        return;
    L59:
        return;
    L17:
        if (r100.equals("recently") == false) goto L46;
        TextView r109 = this.f69480b;
        if (r109 == null) goto L21;
        r109.setText(s1.B(R.string.ttlive_ktv_recently_empty_hint_phase1));
    L21:
        TextView r110 = this.f69481c;
        if (r110 == null) goto L55;
        if (r101 == true) goto L26;
        r102 = s1.B(R.string.ttlive_ktv_recently_empty_hint_phase2);
    L26:
        r110.setText(r102);
        return;
    L55:
        return;
    L28:
        if (r100.equals("search") == false) goto L46;
        TextView r111 = this.f69480b;
        if (r111 == null) goto L32;
        r111.setText(s1.B(R.string.ttlive_ktv_search_empty_hint_phase1));
    L32:
        TextView r112 = this.f69481c;
        if (r112 == null) goto L57;
        r112.setText(s1.B(R.string.ttlive_ktv_search_empty_hint_phase2));
        return;
    L57:
        return;
    L36:
        if (r100.equals("play_list") == false) goto L46;
    L39:
        if (r100.equals("mine_want_sing") == false) goto L46;
        goto L40
    }

    public KtvCommonEmptyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_ktv_empty, this, true);
        this.f69479a = r103;
        if (r103 == null) goto L5;
        LinearLayout r104 = (LinearLayout) r103.findViewById(R.id.place_container);
    L5:
        View r105 = null;
        if (r103 == null) goto L8;
        ImageView r106 = (ImageView) r103.findViewById(R.id.empty_cover);
    L9:
        if (r103 == null) goto L11;
        TextView r107 = (TextView) r103.findViewById(R.id.empty_hint_phase1);
    L12:
        this.f69480b = r107;
        if (r103 == null) goto L15;
        TextView r108 = (TextView) r103.findViewById(R.id.empty_hint_phase2);
    L16:
        this.f69481c = r108;
        if (r103 == null) goto L19;
        LinearLayout r109 = (LinearLayout) r103.findViewById(R.id.go_select_music);
    L20:
        this.f69482d = r109;
        if (r103 == null) goto L23;
        TextView r110 = (TextView) r103.findViewById(R.id.go_select_music_text);
    L24:
        if (r103 == null) goto L26;
        r105 = r103.findViewById(R.id.go_select_music_icon);
    L26:
        this.f69483e = r105;
        int r111 = h.f70689a;
        if (r106 == null) goto L29;
        FrescoLoader.with(r106.getContext()).load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_bg_ktv_empty_black_light.png").into(r106);
    L29:
        if (r107 == null) goto L31;
        KtvOrderSongThemeManager.d(r107, 106);
    L31:
        if (r108 == null) goto L33;
        KtvOrderSongThemeManager.d(r108, 107);
    L33:
        if (r110 == null) goto L36;
        KtvOrderSongThemeManager.d(r110, 108);
        return;
    L36:
        return;
    L23:
        r110 = null;
        goto L24
    L19:
        r109 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    L8:
        r106 = null;
        goto L9
    }

    public /* synthetic */ KtvCommonEmptyView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
