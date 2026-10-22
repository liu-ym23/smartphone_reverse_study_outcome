package com.bytedance.android.livesdk.chatroom.roommanage.binder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.adapter.binding.SwitchSettingItemBinder;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.roommanage.AnchorManageAdminDataContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mx.l;

/* JADX INFO: loaded from: classes7.dex */
public class RefineSettingItemBinder extends SwitchSettingItemBinder<d> {

    public static final class a implements LiveSwitchButton.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f111274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwitchSettingViewHolder f111275b;

        public a(d r100, SwitchSettingViewHolder r101) {
            this.f111274a = r100;
            this.f111275b = r101;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
        public final void d0(LiveSwitchButton r100, boolean r101) {
            this.f111274a.c(this.f111275b, r101);
        }
    }

    public RefineSettingItemBinder() {
        super(false);
    }

    @Override // com.bytedance.android.live.adapter.binding.SwitchSettingItemBinder, me.drakeet.multitype.b
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, Object r101) {
        j((SwitchSettingViewHolder) r100, (d) r101);
    }

    @Override // com.bytedance.android.live.adapter.binding.SwitchSettingItemBinder, me.drakeet.multitype.b
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        return i(r100, r101);
    }

    @Override // com.bytedance.android.live.adapter.binding.SwitchSettingItemBinder
    public final /* bridge */ /* synthetic */ void h(SwitchSettingViewHolder r100, l r101) {
        j(r100, (d) r101);
    }

    public final void j(SwitchSettingViewHolder r100, final d r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        super.h(r100, r101);
        DataContext r102 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(AnchorManageAdminDataContext.class));
        if ((r102 instanceof AnchorManageAdminDataContext) == true) goto L6;
        r102 = null;
    L6:
        if (((AnchorManageAdminDataContext) r102) != null) goto L8;
        return;
    L8:
        final LiveSwitchButton r103 = r100.f58552d;
        r103.setChecked(r101.f516148l);
        r103.setTag(r101.f111279p.f105078b + ", " + r101.f516148l);
        LiveRoomPermission r104 = r101.f111279p;
        if (r104.f105081e == true) goto L11;
        r103.setOnCheckedChangeListener(new a(r101, r100));
        r103.setOnClickListener(x0.a(new RefineSettingItemBinder$onBindViewHolder$3(r103)));
        return;
    L11:
        if (r104.f105083g != 1) goto L16;
        r100.f58543b.setText(r104.f105079c);
        r103.setAlpha(0.34f);
        r103.setOnClickListener(x0.a(new RefineSettingItemBinder$onBindViewHolder$1(r101)));
        return;
    }
}
