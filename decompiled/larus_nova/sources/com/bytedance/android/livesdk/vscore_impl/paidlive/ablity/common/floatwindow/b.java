package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.floatwindow;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.paidlive.PaidInRoomFloatWindowAbilityCenterImpl;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends AbsLiveBizWindowLayoutAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.b f160184a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
    public final String getBizTag() {
        return PaidInRoomFloatWindowAbilityCenterImpl.BIZ_TAG;
    }

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
    public final boolean enable() {
        return this.f160184a.w0().isInRoom();
    }

    public b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r100) {
        Intrinsics.checkNotNullParameter(r100, "paidScope");
        this.f160184a = r100;
        Objects.toString(r100.w0());
    }

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility
    public final FrameLayout.LayoutParams getCloseBtnLayoutParams(FrameLayout.LayoutParams r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(r100);
        r101.gravity = 8388659;
        return r101;
    }

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility
    public final FrameLayout.LayoutParams getMuteBtnLayoutParams(FrameLayout.LayoutParams r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(r100);
        r101.gravity = 8388661;
        return r101;
    }

    @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility
    public final RelativeLayout.LayoutParams getBizWindowLayoutParams(int r100, int r101, RelativeLayout.LayoutParams r102) {
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(r102);
        if (r100 <= r101) goto L5;
        r103.width = UtilityKotlinExtentionsKt.i(175);
        r103.height = UtilityKotlinExtentionsKt.i(99);
        r103.bottomMargin = (s1.w() - UtilityKotlinExtentionsKt.i(99)) / 2;
    L6:
        return r103;
    L5:
        r103.width = UtilityKotlinExtentionsKt.i(99);
        r103.height = UtilityKotlinExtentionsKt.i(175);
        r103.bottomMargin = (s1.w() - UtilityKotlinExtentionsKt.i(175)) / 2;
        goto L6
    }
}
