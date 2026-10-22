package com.bytedance.android.live.adapter.binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.b;
import mx.l;
import rm3.c;

/* JADX INFO: loaded from: classes45.dex */
public class SwitchSettingItemBinder<T extends l> extends b<T, SwitchSettingViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super SwitchSettingViewHolder, Unit> f58546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f58547c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f58548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwitchSettingViewHolder f58549b;

        public a(l r100, SwitchSettingViewHolder r101) {
            this.f58548a = r100;
            this.f58549b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            l r101 = this.f58548a;
            if (r101.f516133i == false) goto L5;
            boolean r102 = !this.f58549b.f58552d.isChecked();
            if (this.f58548a.b(r102) == true) goto L11;
            this.f58549b.f58552d.setChecked(r102);
        L11:
            this.f58548a.c(this.f58549b, r102);
            return;
        L5:
            if ((!StringsKt.isBlank(r101.f516134j)) == false) goto L13;
            String r103 = c.f538539a;
            c.g(s1.getContext(), this.f58548a.f516134j, 0, true, 16);
            return;
        }
    }

    public SwitchSettingItemBinder(boolean r100) {
        this.f58547c = r100;
    }

    @Override // me.drakeet.multitype.b
    public /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, Object r101) {
        h((SwitchSettingViewHolder) r100, (l) r101);
    }

    @Override // me.drakeet.multitype.b
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        return i(r100, r101);
    }

    public void h(SwitchSettingViewHolder r100, final T r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ALogger.d("SwitchSettingItem", r101.f516129e + ", check: " + r101.f516148l + ", holder: " + r100.hashCode());
        r101.e();
        r100.T3(r101);
        final LiveSwitchButton r102 = r100.f58552d;
        r102.setOnCheckedChangeListener(null);
        r102.setOnClickListener(null);
        r100.f58552d.setChecked(r101.f516148l);
        if (r101.f516133i == false) goto L5;
        float r103 = 1.0f;
    L6:
        r102.setAlpha(r103);
        r100.f58554f.setVisibility(8);
        View.OnClickListener r104 = r101.f();
        if (r104 == null) goto L9;
        r100.f58554f.setVisibility(0);
        r100.f58554f.setOnClickListener(r104);
    L9:
        TextView r105 = r100.f58553e;
        if (r105 == null) goto L12;
        r105.setVisibility(8);
    L12:
        r100.f58552d.setOnClickListener(new a(r101, r100));
        if (this.f58547c == false) goto L26;
        TextView r106 = r100.f58542a;
        if (r106 == null) goto L17;
        r106.setTextColor(s1.h(R.color.ttlive_dialog_main_text));
    L17:
        TextView r107 = r100.f58543b;
        if (r107 == null) goto L20;
        r107.setTextColor(s1.h(R.color.ttlive_dialog_sub_content_text));
    L20:
        TextView r108 = r100.f58553e;
        if (r108 == null) goto L23;
        r108.setTextColor(s1.h(R.color.ttlive_dialog_sub_content_text));
    L23:
        LiveSwitchButton r109 = r100.f58552d;
        if (r109 == null) goto L26;
        r109.setSwitchBackgroundColor(s1.h(R.color.ttlive_dialog_switch_button_unchecked));
    L26:
        r100.itemView.setFocusable(true);
        r100.itemView.setClickable(true);
        r3.e(r100.itemView, new SwitchSettingItemBinder$onBindViewHolder$4(r101, r102));
        return;
    L5:
        r103 = 0.5f;
        goto L6
    }

    public SwitchSettingViewHolder i(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        SwitchSettingViewHolder r102 = new SwitchSettingViewHolder(r100.inflate(R.layout.ttlive_viewholder_live_room_manage_switch_setting_item, r101, false));
        r102.f58552d.setEnableEffect(false);
        Function1<? super SwitchSettingViewHolder, Unit> r103 = this.f58546b;
        if (r103 == null) goto L5;
        Unit r104 = r103.invoke(r102);
    L5:
        return r102;
    }
}
