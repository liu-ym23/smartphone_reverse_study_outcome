package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ia2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityTextViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityBaseViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class QuickAbilityTextViewHolder extends QuickAbilityBaseViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f139531f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f139532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LottieAnimationView f139533e;

    public static final class a {
        public static View a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_ai_agent_quick_ability_base_item, r100, false);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder
    public boolean V3(b r100) {
        return false;
    }

    public final void W3() {
        TextView r100 = this.f139532d;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r100);
    L5:
        LottieAnimationView r101 = this.f139533e;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.u(r101);
    L8:
        LottieAnimationView r102 = this.f139533e;
        if (r102 == null) goto L12;
        r102.pauseAnimation();
        return;
    }

    public QuickAbilityTextViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f139532d = (TextView) r100.findViewById(R.id.text);
        this.f139533e = (LottieAnimationView) r100.findViewById(R.id.loading);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder
    public final void U3(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        View r101 = this.f139529c;
        if (r100.f488850d == false) goto L5;
        int r102 = 28;
    L6:
        a1.k(r101, UtilityKotlinExtentionsKt.i(r102));
        TextView r103 = this.f139532d;
        if (r103 == null) goto L10;
        r103.setText(r100.f488847a.getText());
    L10:
        if (r100.f488848b == false) goto L20;
        TextView r104 = this.f139532d;
        if (r104 == null) goto L14;
        UtilityKotlinExtentionsKt.u(r104);
    L14:
        LottieAnimationView r105 = this.f139533e;
        if (r105 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r105);
    L17:
        LottieAnimationView r106 = this.f139533e;
        if (r106 == null) goto L22;
        r106.playAnimation();
        return;
    L22:
        return;
    L20:
        W3();
        return;
    L5:
        r102 = 24;
        goto L6
    }
}
