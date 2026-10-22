package com.bytedance.android.livesdk.paidlive;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility;
import com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/paidlive/PaidInRoomFloatWindowAbilityCenterImpl;", "Lcom/bytedance/android/livesdkapi/service/vs/IPaidInRoomFloatWindowAbilityCenter;", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLayoutAbility;", "ability", "", "registerWindowLayoutAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowWidgetAbility;", "registerWindowWidgetAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLogAbility;", "registerWindowLogAbility", "provideWindowLayoutAbility", "provideWindowWidgetAbility", "provideWindowLogAbility", "currentWindowLayoutAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLayoutAbility;", "currentWindowWidgetAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowWidgetAbility;", "currentWindowLogAbility", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLogAbility;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidInRoomFloatWindowAbilityCenterImpl implements IPaidInRoomFloatWindowAbilityCenter {
    public static final String BIZ_TAG = "paid_inroom_small_window";
    public static final a Companion = null;
    public static final int PROPERTY = 11;
    private AbsLiveBizWindowLayoutAbility currentWindowLayoutAbility;
    private AbsLiveBizWindowLogAbility currentWindowLogAbility;
    private AbsLiveBizWindowWidgetAbility currentWindowWidgetAbility;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends AbsLiveBizWindowLayoutAbility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidInRoomFloatWindowAbilityCenterImpl f154219a;

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final boolean enable() {
            AbsLiveBizWindowLayoutAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLayoutAbility$p(this.f154219a);
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.enable();
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final String getBizTag() {
            AbsLiveBizWindowLayoutAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLayoutAbility$p(this.f154219a);
            if (r100 == null) goto L6;
            String r101 = r100.getBizTag();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return PaidInRoomFloatWindowAbilityCenterImpl.BIZ_TAG;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility, com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final int getPriority() {
            AbsLiveBizWindowLayoutAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLayoutAbility$p(this.f154219a);
            if (r100 != null) goto L7;
            return 11;
        L7:
            return r100.getPriority();
        }

        public b(PaidInRoomFloatWindowAbilityCenterImpl r100) {
            this.f154219a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility
        public final FrameLayout.LayoutParams getCloseBtnLayoutParams(FrameLayout.LayoutParams r100) {
            AbsLiveBizWindowLayoutAbility r101 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLayoutAbility$p(this.f154219a);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getCloseBtnLayoutParams(r100);
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility
        public final FrameLayout.LayoutParams getMuteBtnLayoutParams(FrameLayout.LayoutParams r100) {
            AbsLiveBizWindowLayoutAbility r101 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLayoutAbility$p(this.f154219a);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getMuteBtnLayoutParams(r100);
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility
        public final RelativeLayout.LayoutParams getBizWindowLayoutParams(int r100, int r101, RelativeLayout.LayoutParams r102) {
            AbsLiveBizWindowLayoutAbility r103 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLayoutAbility$p(this.f154219a);
            if (r103 != null) goto L7;
            return null;
        L7:
            return r103.getBizWindowLayoutParams(r100, r101, r102);
        }
    }

    public static final class c extends AbsLiveBizWindowLogAbility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidInRoomFloatWindowAbilityCenterImpl f154220a;

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final boolean enable() {
            AbsLiveBizWindowLogAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLogAbility$p(this.f154220a);
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.enable();
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final String getBizTag() {
            AbsLiveBizWindowLogAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLogAbility$p(this.f154220a);
            if (r100 == null) goto L6;
            String r101 = r100.getBizTag();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return PaidInRoomFloatWindowAbilityCenterImpl.BIZ_TAG;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility, com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final int getPriority() {
            AbsLiveBizWindowLogAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLogAbility$p(this.f154220a);
            if (r100 != null) goto L7;
            return 11;
        L7:
            return r100.getPriority();
        }

        public c(PaidInRoomFloatWindowAbilityCenterImpl r100) {
            this.f154220a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility
        public final Map<String, String> getBizExtra(boolean r100) {
            AbsLiveBizWindowLogAbility r101 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowLogAbility$p(this.f154220a);
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getBizExtra(r100);
        }
    }

    public static final class d extends AbsLiveBizWindowWidgetAbility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaidInRoomFloatWindowAbilityCenterImpl f154221a;

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final boolean enable() {
            AbsLiveBizWindowWidgetAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowWidgetAbility$p(this.f154221a);
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.enable();
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final String getBizTag() {
            AbsLiveBizWindowWidgetAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowWidgetAbility$p(this.f154221a);
            if (r100 == null) goto L6;
            String r101 = r100.getBizTag();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return PaidInRoomFloatWindowAbilityCenterImpl.BIZ_TAG;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility, com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility
        public final int getPriority() {
            AbsLiveBizWindowWidgetAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowWidgetAbility$p(this.f154221a);
            if (r100 != null) goto L7;
            return 11;
        L7:
            return r100.getPriority();
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility
        public final void onAttach() {
            AbsLiveBizWindowWidgetAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowWidgetAbility$p(this.f154221a);
            if (r100 == null) goto L6;
            r100.onAttach();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility
        public final void onBizInteractViewClick() {
            AbsLiveBizWindowWidgetAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowWidgetAbility$p(this.f154221a);
            if (r100 == null) goto L6;
            r100.onBizInteractViewClick();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility
        public final void onDetach() {
            AbsLiveBizWindowWidgetAbility r100 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowWidgetAbility$p(this.f154221a);
            if (r100 == null) goto L6;
            r100.onDetach();
            return;
        }

        public d(PaidInRoomFloatWindowAbilityCenterImpl r100) {
            this.f154221a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility
        public final View getBizInteractView(Context r100, int r101, int r102) {
            AbsLiveBizWindowWidgetAbility r103 = PaidInRoomFloatWindowAbilityCenterImpl.access$getCurrentWindowWidgetAbility$p(this.f154221a);
            if (r103 != null) goto L7;
            return null;
        L7:
            return r103.getBizInteractView(r100, r101, r102);
        }
    }

    static {
        Companion = new a();
    }

    public PaidInRoomFloatWindowAbilityCenterImpl() {
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter
    public AbsLiveBizWindowLayoutAbility provideWindowLayoutAbility() {
        return new b(this);
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter
    public AbsLiveBizWindowLogAbility provideWindowLogAbility() {
        return new c(this);
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter
    public AbsLiveBizWindowWidgetAbility provideWindowWidgetAbility() {
        return new d(this);
    }

    public static final /* synthetic */ AbsLiveBizWindowLayoutAbility access$getCurrentWindowLayoutAbility$p(PaidInRoomFloatWindowAbilityCenterImpl r100) {
        return r100.currentWindowLayoutAbility;
    }

    public static final /* synthetic */ AbsLiveBizWindowLogAbility access$getCurrentWindowLogAbility$p(PaidInRoomFloatWindowAbilityCenterImpl r100) {
        return r100.currentWindowLogAbility;
    }

    public static final /* synthetic */ AbsLiveBizWindowWidgetAbility access$getCurrentWindowWidgetAbility$p(PaidInRoomFloatWindowAbilityCenterImpl r100) {
        return r100.currentWindowWidgetAbility;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter
    public void registerWindowLayoutAbility(AbsLiveBizWindowLayoutAbility r100) {
        this.currentWindowLayoutAbility = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter
    public void registerWindowLogAbility(AbsLiveBizWindowLogAbility r100) {
        this.currentWindowLogAbility = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter
    public void registerWindowWidgetAbility(AbsLiveBizWindowWidgetAbility r100) {
        this.currentWindowWidgetAbility = r100;
    }

    public static final /* synthetic */ void access$setCurrentWindowLayoutAbility$p(PaidInRoomFloatWindowAbilityCenterImpl r100, AbsLiveBizWindowLayoutAbility r101) {
        r100.currentWindowLayoutAbility = r101;
    }

    public static final /* synthetic */ void access$setCurrentWindowLogAbility$p(PaidInRoomFloatWindowAbilityCenterImpl r100, AbsLiveBizWindowLogAbility r101) {
        r100.currentWindowLogAbility = r101;
    }

    public static final /* synthetic */ void access$setCurrentWindowWidgetAbility$p(PaidInRoomFloatWindowAbilityCenterImpl r100, AbsLiveBizWindowWidgetAbility r101) {
        r100.currentWindowWidgetAbility = r101;
    }
}
