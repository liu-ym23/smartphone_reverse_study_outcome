package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.LiveProfileSettingDialog;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/FansClubSettingWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubSettingWidget extends MiddlewareRoomWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveProfileSettingDialog f113104a;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FansClubSettingWidget f113105a;

        public a(FansClubSettingWidget r100) {
            this.f113105a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            zg1.c0 r101 = (zg1.c0) r100;
            if (r101 == null) goto L6;
            this.f113105a.wq(r101);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        a r100 = new a(this);
        ((ObservableSubscribeProxy) xs2.b.a().b(zg1.c0.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r100);
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L6;
        r101.observe("cmd_show_fans_club_setting", this);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        LiveProfileSettingDialog r100 = this.f113104a;
        if (r100 == null) goto L14;
        if (r100 == null) goto L14;
        if (r100.isShowing() != true) goto L14;
        LiveProfileSettingDialog r101 = this.f113104a;
        Intrinsics.checkNotNull(r101);
        r101.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L14;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        DataCenter r103 = this.dataCenter;
        if (r103 == null) goto L20;
        r103.removeObserver(this);
        return;
    }

    public FansClubSettingWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Intrinsics.checkNotNullParameter(r101, "kvData");
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == false) goto L7;
        return;
    L7:
        if (r101.getData() == null) goto L22;
        String r102 = r101.getKey();
        if (r102.hashCode() == (-424351287)) goto L13;
        return;
    L13:
        if (r102.equals("cmd_show_fans_club_setting") == false) goto L20;
        zg1.c0 r103 = (zg1.c0) r101.getData();
        if (r103 == null) goto L21;
        wq(r103);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void wq(zg1.c0 r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r101 = ho1.a.d(getComponentContext());
        boolean r102 = true;
        if (r101 != null) goto L5;
    L6:
        if (r101 != null) goto L8;
    L10:
        r102 = false;
    L11:
        LiveProfileSettingDialog r103 = this.f113104a;
        if (r103 != null) goto L14;
        IService r104 = jc1.k.f(IUserService.class);
        Intrinsics.checkNotNull(r104);
        IUser r105 = ((IUserService) r104).user().b();
        DataCenter r106 = this.dataCenter;
        r100.getClass();
        LiveProfileSettingDialog r107 = new LiveProfileSettingDialog();
        r107.f112324f = r105;
        r107.f112332n = r102;
        r107.f112326h = null;
        r107.f112327i = null;
        r107.f112325g = r106;
        this.f113104a = r107;
    L15:
        if (r101 == null) goto L29;
        FragmentManager r108 = r101.getChildFragmentManager();
        if (r108 == null) goto L30;
        LiveProfileSettingDialog r109 = this.f113104a;
        if (r109 == null) goto L31;
        int r110 = LiveProfileSettingDialog.f112321o;
        LandscapeRestrictionOperation r111 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r109, "LiveProfileSettingDialog", r111);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r108, r109, r111) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L24:
        r109.show(r108, "LiveProfileSettingDialog");
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L14:
        r100.getClass();
        r103.f112326h = null;
        r103.f112327i = null;
        goto L15
    L8:
        if (r101.V9() != true) goto L10;
    L5:
        if (r101.dg() == true) goto L11;
        goto L6
    }
}
