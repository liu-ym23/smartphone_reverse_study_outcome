package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.PoiInfo;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r52.z1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/secondarydialog/PoiSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PoiSelectDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f140653l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoomIntroDataSource f140654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f140655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f140656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveSwitchButton f140657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f140658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HSImageView f140659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f140660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f140661k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiSelectDialog f140662a;

        public b(PoiSelectDialog r100) {
            this.f140662a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f140662a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public PoiSelectDialog() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        RoomIntroDataSource r101 = this.f140654d;
        boolean r102 = false;
        if (r101 == null) goto L9;
        PropertyOwner r103 = r101.f140585k;
        if (r103 == null) goto L9;
        Boolean r104 = (Boolean) r103.f64752a;
        if (r104 == null) goto L9;
        boolean r105 = r104.booleanValue();
    L11:
        if (this.f140661k == true) goto L34;
        if (r105 == false) goto L35;
        RoomIntroDataSource r106 = this.f140654d;
        if (r106 == null) goto L36;
        String r107 = r106.a();
        if (r107 != null) goto L18;
    L19:
        r102 = true;
    L20:
        if (r102 != true) goto L37;
        RoomIntroDataSource r108 = this.f140654d;
        if (r108 == null) goto L38;
        PoiInfo r109 = r108.f140589o.g();
        if (r109 == null) goto L26;
        String r110 = r109.getDefaultIntro();
    L27:
        if (r110 == null) goto L39;
        RoomIntroDataSource r111 = this.f140654d;
        if (r111 == null) goto L40;
        Intrinsics.checkNotNullParameter(r110, "text");
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a r112 = r111.f140577c;
        if (r112 == null) goto L41;
        r112.a(r110);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L26:
        r110 = null;
        goto L27
    L38:
        return;
    L37:
        return;
    L18:
        if (r107.length() != 0) goto L20;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L9:
        r105 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog);
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        S90(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f140656f;
        if (r102 == null) goto L9;
        Integer r103 = this.f140655e;
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        a1.k(r102, Math.max(MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE, r104));
        goto L9
    L7:
        r104 = 0;
    L9:
        LiveSwitchButton r105 = this.f140657g;
        if (r105 == null) goto L12;
        r105.setOnCheckedChangeListener(new com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog.b(this));
    L12:
        RoomIntroDataSource r106 = this.f140654d;
        if (r106 == null) goto L19;
        PropertyOwner r107 = r106.f140585k;
        if (r107 == null) goto L19;
        Boolean r108 = (Boolean) r107.f64752a;
        if (r108 == null) goto L19;
        boolean r109 = r108.booleanValue();
    L20:
        this.f140661k = r109;
        LiveSwitchButton r110 = this.f140657g;
        if (r110 == null) goto L23;
        boolean r111 = r110.isChecked();
    L24:
        if (r109 == r111) goto L28;
        LiveSwitchButton r112 = this.f140657g;
        if (r112 == null) goto L28;
        r112.f(false, false);
    L28:
        int r113 = s1.y() - UtilityKotlinExtentionsKt.i(40);
        RoomIntroDataSource r114 = this.f140654d;
        if (r114 == null) goto L31;
        double r115 = ((double) ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) r114.f140575a.getValue()).b()) / ((double) ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) r114.f140575a.getValue()).d());
    L32:
        int r116 = (int) (r115 * ((double) r113));
        HSImageView r117 = this.f140659i;
        if (r117 == null) goto L35;
        a1.k(r117, r116);
    L35:
        HSImageView r118 = this.f140659i;
        RoomIntroDataSource r119 = this.f140654d;
        String r120 = null;
        if (r119 == null) goto L38;
        String r121 = ((com.bytedance.android.livesdk.interactivity.api.settings.config.d) r119.f140575a.getValue()).c();
    L39:
        ImageLoader.bindImage(r118, r121);
        TextView r122 = this.f140658h;
        if (r122 != null) goto L42;
    L45:
        View r123 = this.f140660j;
        if (r123 == null) goto L49;
        r123.setOnClickListener(new b(this));
        return;
    L49:
        return;
    L42:
        if (this.f140654d == null) goto L44;
        r120 = z1.f536293a.getValue();
    L44:
        r122.setText(r120);
        goto L45
    L38:
        r121 = null;
        goto L39
    L31:
        r115 = 0.5313432835820896d;
        goto L32
    L23:
        r111 = false;
    L19:
        r109 = false;
        goto L20
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_poi_select, r101, false);
        this.f140656f = r103;
        this.f140657g = (LiveSwitchButton) r103.findViewById(R.id.poi_select_switch_button);
        this.f140658h = (TextView) r103.findViewById(R.id.poi_select_intro_text);
        this.f140659i = (HSImageView) r103.findViewById(R.id.poi_select_intro_image);
        this.f140660j = r103.findViewById(R.id.poi_select_back);
        return r103;
    }
}
