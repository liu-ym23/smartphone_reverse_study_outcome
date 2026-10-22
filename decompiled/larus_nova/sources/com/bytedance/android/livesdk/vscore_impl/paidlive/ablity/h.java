package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.s;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends PaidRoomTempWatchEndView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f160224s;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f160225a;

        public a(h r100) {
            this.f160225a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<? super Map<String, String>, Unit> r101 = this.f160225a.getTempWatchEndViewUiInfo().f159436j;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(MapsKt.emptyMap());
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.PaidRoomTempWatchEndView
    public int getLayoutId() {
        return R.layout.ttlive_view_subscribe_room_temp_end;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.PaidRoomTempWatchEndView, com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void logTempMaskShow() {
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.PaidRoomTempWatchEndView, com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void z2() {
    }

    public final void n() {
        if (getScope().w0().isPreview() == true) goto L5;
        return;
    L5:
        if (getHasInitRootView() == false) goto L16;
        TextView r100 = getMBtPaidLiveGoBuyTicket();
        if (r100 == null) goto L9;
        r100.setOnClickListener(new a(this));
    L9:
        StringBuilder r101 = new StringBuilder("init click in ");
        r101.append(getScope().w0());
        r101.append(", view:");
        TextView r102 = getMBtPaidLiveGoBuyTicket();
        if (r102 == null) goto L12;
        Object r103 = Integer.valueOf(r102.hashCode());
    L13:
        r101.append(r103);
        h(r101.toString());
        return;
    L12:
        r103 = "null";
        goto L13
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.PaidRoomTempWatchEndView
    public String getLogT() {
        return this.f160224s;
    }

    public h(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        super(r100);
        this.f160224s = "SubscribeTempWatchEndView[" + hashCode() + "][" + r100.i0() + "][" + r100.w0() + ']';
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.PaidRoomTempWatchEndView, com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public void setUIInfo(s r100) {
        Intrinsics.checkNotNullParameter(r100, "uiInfo");
        super.setUIInfo(r100);
        n();
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.PaidRoomTempWatchEndView, com.bytedance.android.livesdk.vscore_api.paidlive.ability.l
    public final void Kb(IRenderView r100, boolean r101) {
        if (getHasRender() == true) goto L5;
        n();
    L5:
        super.Kb(r100, r101);
    }
}
