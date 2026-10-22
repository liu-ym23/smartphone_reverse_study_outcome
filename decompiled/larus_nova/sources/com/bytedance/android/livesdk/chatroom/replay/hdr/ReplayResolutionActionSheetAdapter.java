package com.bytedance.android.livesdk.chatroom.replay.hdr;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.l;
import com.bytedance.android.livesdk.chatroom.vs_base.util.k;
import com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pm1.h;
import yr1.n;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/hdr/ReplayResolutionActionSheetAdapter;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayResolutionActionSheetAdapter extends ReplayActionSheet.ActionSheetAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReplayResolutionActionSheet f108738b;

    public static final class a {
    }

    static {
    }

    public ReplayResolutionActionSheetAdapter(ReplayResolutionActionSheet r100) {
        Intrinsics.checkNotNullParameter(r100, "actionSheet");
        super(r100);
        this.f108738b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        List<? extends ReplayActionSheet.d> r101 = this.f108738b.f118235h;
        if (r101 == null) goto L8;
        ReplayActionSheet.d r102 = (ReplayActionSheet.d) ListProtector.get(r101, r100);
        if (r102 == null) goto L8;
        String r103 = r102.f118250a;
        if (r103 == null) goto L8;
    L10:
        return l.c(r103) ? 1 : 0;
    L8:
        r103 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet.ActionSheetAdapter
    public final ReplayActionSheet.ActionSheetItemViewHolder z2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        LayoutInflater r101 = LayoutInflater.from(r100.getContext());
        if (this.f108738b.U90() == false) goto L5;
        int r102 = R.layout.ttlive_replay_item_switch_video_quality_portrait;
    L7:
        return new LandscapeVideoQualityViewHolder(r101.inflate(r102, r100, false));
    L5:
        r102 = R.layout.ttlive_replay_item_switch_video_quality_landscape;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet.ActionSheetAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((ReplayActionSheet.ActionSheetItemViewHolder) r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet.ActionSheetAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet.ActionSheetAdapter
    public final void y2(ReplayActionSheet.ActionSheetItemViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "viewHolder");
        List<? extends ReplayActionSheet.d> r100 = this.f108738b.f118235h;
        if (r100 == null) goto L108;
        final ReplayActionSheet.d r101 = (ReplayActionSheet.d) ListProtector.get(r100, r111);
        if (r101 != null) goto L8;
        return;
    L8:
        if ((r110 instanceof LandscapeVideoQualityViewHolder) == true) goto L10;
        ReplayActionSheet.ActionSheetItemViewHolder r102 = null;
    L11:
        final LandscapeVideoQualityViewHolder r103 = (LandscapeVideoQualityViewHolder) r102;
        if (r103 == null) goto L97;
        final boolean r104 = this.f108738b.U90();
        final DataCenter r105 = this.f108738b.f118238k;
        final Function1<String, Unit> r106 = new AnonymousClass1(this, r101);
        Intrinsics.checkNotNullParameter(r106, "onSelectListener");
        if ((r101 instanceof d) == true) goto L16;
        ReplayActionSheet.d r107 = null;
    L17:
        final d r108 = (d) r107;
        if (r108 == null) goto L97;
        ((TextView) r103.itemView.findViewById(R.id.quality_text)).setText(r108.f118250a);
        CharSequence r112 = "";
        ((TextView) r103.itemView.findViewById(R.id.p_text)).setText("");
        if (l.c(r101.f118250a) == false) goto L23;
        String r109 = "音画增强";
    L28:
        if (r109.length() != 0) goto L30;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L34;
        UtilityKotlinExtentionsKt.t(r103.itemView.findViewById(R.id.secondary_hint));
    L36:
        if (((d) r101).f108745g == false) goto L38;
        Integer r114 = Integer.valueOf(R.drawable.ttlive_bg_vs_paid_resolution_fufei);
    L60:
        if (r114 == null) goto L62;
        UtilityKotlinExtentionsKt.w(r103.itemView.findViewById(R.id.quality_img_text));
        ((HSImageView) r103.itemView.findViewById(R.id.quality_img_text)).setActualImageResource(r114.intValue());
    L63:
        if (r104 == false) goto L65;
        k.d(r103.itemView, com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.c(16));
    L67:
        if (r108.f118252c == false) goto L69;
        r103.T3(r108);
    L94:
        if (r108.f108743e != 1) goto L96;
        ((TextView) r103.itemView.findViewById(R.id.quality_text)).setAlpha(0.3f);
        UtilityKotlinExtentionsKt.w(r103.itemView.findViewById(R.id.quality_text));
        ((TextView) r103.itemView.findViewById(R.id.p_text)).setAlpha(0.3f);
        UtilityKotlinExtentionsKt.w(r103.itemView.findViewById(R.id.p_text));
        ((TextView) r103.itemView.findViewById(R.id.secondary_hint)).setAlpha(0.3f);
        r103.itemView.setOnClickListener(com.bytedance.android.livesdk.chatroom.replay.hdr.a.f108739a);
        goto L97
    L96:
        ((TextView) r103.itemView.findViewById(R.id.quality_text)).setAlpha(1.0f);
        UtilityKotlinExtentionsKt.w(r103.itemView.findViewById(R.id.quality_text));
        ((TextView) r103.itemView.findViewById(R.id.p_text)).setAlpha(1.0f);
        ((TextView) r103.itemView.findViewById(R.id.secondary_hint)).setAlpha(0.5f);
        UtilityKotlinExtentionsKt.w(r103.itemView.findViewById(R.id.p_text));
        r103.itemView.setOnClickListener(new LandscapeVideoQualityViewHolder$bindData$2(r103, r105, r108, r104, r106, r101));
        goto L97
    L69:
        ((TextView) r103.itemView.findViewById(R.id.quality_text)).setTextColor(s1.h(R.color.ttlive_white));
        ((TextView) r103.itemView.findViewById(R.id.p_text)).setTextColor(s1.h(R.color.ttlive_white));
        ((TextView) r103.itemView.findViewById(R.id.secondary_hint)).setTextColor(s1.h(R.color.ttlive_white));
        if (r104 == false) goto L72;
        r103.itemView.setBackgroundResource(0);
    L73:
        View r115 = r103.itemView;
        StringBuilder r116 = new StringBuilder();
        View r117 = r103.itemView;
        if (r117 == null) goto L76;
        View r118 = r117.findViewById(R.id.quality_text);
    L77:
        TextView r119 = (TextView) r118;
        if (r119 == null) goto L81;
        CharSequence r120 = r119.getText();
        if (r120 == null) goto L81;
    L82:
        r116.append(r120);
        View r121 = r103.itemView;
        if (r121 == null) goto L85;
        View r122 = r121.findViewById(R.id.p_text);
    L86:
        TextView r123 = (TextView) r122;
        if (r123 == null) goto L92;
        CharSequence r124 = r123.getText();
        if (r124 == null) goto L92;
        r112 = r124;
    L92:
        r116.append(r112);
        r116.append("按钮");
        r115.setContentDescription(r116.toString());
        goto L94
    L85:
        r122 = null;
    L81:
        r120 = "";
        goto L82
    L76:
        r118 = null;
        goto L77
    L72:
        r103.itemView.setBackgroundResource(R.drawable.ttlive_replay_bg_resolution_select_item_bg_normal);
        goto L73
    L65:
        k.c(r103.itemView, com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.c(12));
        goto L67
    L62:
        UtilityKotlinExtentionsKt.t(r103.itemView.findViewById(R.id.quality_img_text));
        goto L63
    L38:
        String r125 = r101.f118250a;
        ALogger.d("ReplayResolutionManager", "is HDR resolution:" + r125);
        if (Intrinsics.areEqual(r125, "4k") == true) goto L55;
        Iterator<T> r126 = l.f117941a.iterator();
    L42:
        if (r126.hasNext() == false) goto L46;
        Object r127 = r126.next();
        if (Intrinsics.areEqual(((l.a) r127).f117942a, "4k") == false) goto L42;
    L47:
        l.a r128 = (l.a) r127;
        if (r128 == null) goto L50;
        String r129 = r128.f117943b;
    L52:
        if (Intrinsics.areEqual(r125, r129) == true) goto L55;
        boolean r130 = false;
    L56:
        if (r130 == false) goto L58;
        r114 = Integer.valueOf(R.drawable.ttlive_bg_vs_paid_resolution_xianshi);
        goto L60
    L58:
        r114 = null;
        goto L60
    L50:
        r129 = null;
        goto L52
    L46:
        r127 = null;
    L55:
        r130 = true;
        goto L56
    L34:
        UtilityKotlinExtentionsKt.w(r103.itemView.findViewById(R.id.secondary_hint));
        ((TextView) r103.itemView.findViewById(R.id.secondary_hint)).setText(r109);
        goto L36
    L30:
        r113 = false;
        goto L32
    L23:
        int r131 = ((d) r101).f108742d;
        Object r132 = h.f529822d.c(n.class);
        Intrinsics.checkNotNull(r132);
        if (r131 <= ((n) r132).a()) goto L26;
        r109 = "高帧率";
        goto L28
    L26:
        r109 = "";
        goto L28
    L16:
        r107 = r101;
    L97:
        View r133 = r110.f118249a;
        if ((r133 instanceof TextView) == true) goto L100;
        View r134 = null;
    L101:
        TextView r135 = (TextView) r134;
        if (r135 == null) goto L109;
        r135.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    L109:
        return;
    L100:
        r134 = r133;
        goto L101
    L10:
        r102 = r110;
        goto L11
    }
}
