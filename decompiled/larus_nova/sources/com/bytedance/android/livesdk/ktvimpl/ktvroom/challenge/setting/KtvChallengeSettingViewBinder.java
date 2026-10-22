package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeSettingViewModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvChallengeSettingViewBinder extends me.drakeet.multitype.b<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a, KtvChallengeSettingHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f144586c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KtvChallengeSettingViewModel f144587b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/setting/KtvChallengeSettingViewBinder$KtvChallengeSettingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class KtvChallengeSettingHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f144588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KtvChallengeSettingViewBinder f144589b;

        public KtvChallengeSettingHolder(KtvChallengeSettingViewBinder r100, final View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f144589b = r100;
            super(r101);
            this.f144588a = LazyKt.lazy(new KtvChallengeSettingViewBinder$KtvChallengeSettingHolder$content$2(r101));
        }
    }

    public static final class a {
    }

    static {
    }

    public KtvChallengeSettingViewBinder(KtvChallengeSettingViewModel r100) {
        this.f144587b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r101) {
        KtvChallengeSettingHolder r102 = (KtvChallengeSettingHolder) r100;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        int r104 = r102.getAdapterPosition();
        int r105 = r103.f144687c;
        boolean r106 = true;
        if (r105 != 1) goto L11;
        KtvChallengeSettingViewModel r107 = r102.f144589b.f144587b;
        if (r107 == null) goto L19;
        Pair<Integer, Integer> r108 = r107.getCurrentChallengeConfigIndex();
        if (r108 == null) goto L19;
        if (r104 != r108.getFirst().intValue()) goto L19;
    L20:
        if (r106 == false) goto L22;
        int r109 = R.drawable.ttlive_bg_ktv_challenge_setting_item_selected;
    L23:
        r102.itemView.setBackgroundResource(r109);
        r102.itemView.post(new b(r102, r103));
        ((TextView) r102.f144588a.getValue()).setText(r103.f144686b);
        if (r106 == false) goto L26;
        String r110 = CJPayColorConstants.CJ_PAY_RED;
    L27:
        ((TextView) r102.f144588a.getValue()).setTextColor(ColorProtector.parseColor(r110));
        if (r103.f144687c != 2) goto L33;
        if (r106 == false) goto L33;
        if (r103.f144688d == false) goto L33;
        Drawable r111 = s1.m(R.drawable.ttlive_ktv_challenge_custom_target_mark);
        r111.setBounds(0, 0, UtilityKotlinExtentionsKt.i(12), UtilityKotlinExtentionsKt.i(12));
        ((TextView) r102.f144588a.getValue()).setCompoundDrawables(null, null, r111, null);
    L34:
        r102.itemView.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting.a(r102, r103));
        return;
    L33:
        ((TextView) r102.f144588a.getValue()).setCompoundDrawables(null, null, null, null);
        goto L34
    L26:
        r110 = "#161823";
        goto L27
    L22:
        r109 = R.drawable.ttlive_bg_ktv_challenge_setting_item_unselected;
    L19:
        r106 = false;
        goto L20
    L11:
        if (r105 != 2) goto L19;
        KtvChallengeSettingViewModel r112 = r102.f144589b.f144587b;
        if (r112 == null) goto L19;
        Pair<Integer, Integer> r113 = r112.getCurrentChallengeConfigIndex();
        if (r113 == null) goto L19;
        if (r104 != r113.getSecond().intValue()) goto L19;
        goto L19
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new KtvChallengeSettingHolder(this, r100.inflate(R.layout.ttlive_ktv_challenge_setting_item, r101, false));
    }
}
