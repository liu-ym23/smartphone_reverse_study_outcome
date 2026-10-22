package com.bytedance.android.livesdk.castscreen.views;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/TokenLoginDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TokenLoginDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f104752h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f104753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f104754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f104755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f104756g;

    public static final class a {
        public static void a(TokenLoginDialogFragment r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "TokenLoginDialogFragment", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "TokenLoginDialogFragment");
        }
    }

    public interface b {
        void a();
    }

    static {
    }

    public TokenLoginDialogFragment() {
        this.f104753d = new LinkedHashMap();
        this.f104755f = 10;
        this.f104756g = LazyKt.lazy(new TokenLoginDialogFragment$handler$2(this));
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
    L8:
        ((Handler) this.f104756g.getValue()).removeMessages(100);
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L8;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f104754e = null;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f104753d.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ((Handler) this.f104756g.getValue()).removeMessages(100);
        if (isShowing() == false) goto L7;
        Message r100 = Message.obtain();
        r100.what = 100;
        ((Handler) this.f104756g.getValue()).sendMessageDelayed(r100, 1000);
        return;
    }

    public final View S90(int r100) {
        if (this.f104753d != null) goto L5;
        this.f104753d = new LinkedHashMap();
    L5:
        View r101 = this.f104753d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f104753d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void T90(int r100) {
        Button r101 = (Button) S90(R.id.token_login_cancel_btn);
        if (r101 == null) goto L6;
        r101.setText("不登录（" + r100 + "s）");
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(0, R.style.ttlive_CommonBottomDialog);
        setAnimationType("bottom");
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        IUser r102 = ((IUserService) k.n(IUserService.class)).user().b();
        a1.v((ImageView) S90(R.id.token_login_avatar), r102.getAvatarMedium(), R.drawable.ttlive_ic_default_head_small);
        ((TextView) S90(R.id.token_login_username)).setText(r102.getNickName());
        T90(this.f104755f);
        ((AppCompatImageView) S90(R.id.token_login_close_icon)).setOnClickListener(new c(this));
        ((Button) S90(R.id.token_login_cancel_btn)).setOnClickListener(new d(this));
        ((Button) S90(R.id.token_login_confirm_btn)).setOnClickListener(new e(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_vs_token_login, r101, false);
    }
}
