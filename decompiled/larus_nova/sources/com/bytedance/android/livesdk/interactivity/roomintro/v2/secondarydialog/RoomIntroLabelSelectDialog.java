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
import com.bytedance.android.live.core.arch.mvvm.f;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.LabelGroup;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.SelectLabelView;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/secondarydialog/RoomIntroLabelSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIntroLabelSelectDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f140663j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoomIntroDataSource f140664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f140665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f140666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f140667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f140668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f140669i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomIntroLabelSelectDialog f140670a;

        public b(RoomIntroLabelSelectDialog r100) {
            this.f140670a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f140670a.dismiss();     // Catch: Exception -> L5
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

    public RoomIntroLabelSelectDialog() {
        this.f140669i = new CompositeDisposable();
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
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        this.f140669i.clear();     // Catch: Throwable -> L7
        RoomIntroDataSource r101 = this.f140664d;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.f140582h.a(Unit.INSTANCE);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Integer r112 = this.f140665e;
        if (r112 == null) goto L7;
        int r113 = r112.intValue();
        View r114 = this.f140666f;
        if (r114 == null) goto L7;
        a1.k(r114, r113);
    L7:
        RoomIntroDataSource r115 = this.f140664d;
        if (r115 == null) goto L16;
        PropertyOwner r116 = r115.f140584j;
        if (r116 == null) goto L16;
        Observable r117 = f.b(r116);
        if (r117 == null) goto L16;
        Disposable r118 = r117.subscribe(new c(this));
        if (r118 == null) goto L16;
        RxUtilKt.c(r118, this.f140669i);
    L16:
        RoomIntroDataSource r119 = this.f140664d;
        if (r119 == null) goto L51;
        List<LabelGroup> r120 = r119.f140590p;
        if (r120 == null) goto L64;
        Iterator<T> r121 = r120.iterator();
    L22:
        if (r121.hasNext() == false) goto L65;
        LabelGroup r122 = (LabelGroup) r121.next();
        int r100 = 0;
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_select_label_group, this.f140668h, false);
        if (r101 == null) goto L22;
        TextView r102 = (TextView) r101.findViewById(R.id.group_title);
        if (r102 == null) goto L29;
        r102.setText(r122.getGroupText());
    L29:
        final WrapLineFlowLayout r103 = (WrapLineFlowLayout) r101.findViewById(R.id.select_tags_container);
        if (r103 == null) goto L22;
        List<RoomIntroLabel> r123 = r122.getLabels();
        if (r123 == null) goto L48;
        Iterator<T> r124 = r123.iterator();
    L36:
        if (r124.hasNext() == false) goto L48;
        RoomIntroLabel r104 = (RoomIntroLabel) r124.next();
        final SelectLabelView r105 = new SelectLabelView(r103.getContext(), null, 6, r100);
        r103.addView(r105);
        Intrinsics.checkNotNullParameter(r104, "label");
        r105.f140601d = r104;
        String r106 = r104.getTypeName();
        String r107 = "";
        if (r106 != null) goto L40;
        r106 = "";
    L40:
        String r108 = r104.getLabelText();
        if (r108 == null) goto L44;
        r107 = r108;
    L44:
        TextView r109 = r105.f140600c;
        if (r109 == null) goto L47;
        r109.setText(r106 + 65306 + r107);
    L47:
        r105.a(r104.getSelected());
        r105.setOnClickListener(x0.a(new RoomIntroLabelSelectDialog$createLabelGroupLayout$$inlined$forEach$lambda$1(r105, this, r103)));
    L48:
        ViewGroup r125 = this.f140668h;
        if (r125 == null) goto L22;
        r125.addView(r101);
        goto L22
    L65:
        return;
    L64:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_room_intro_label_select, r101, false);
        this.f140666f = r103;
        ViewGroup r104 = null;
        if (r103 == null) goto L5;
        TextView r105 = (TextView) r103.findViewById(R.id.title);
    L6:
        this.f140667g = r105;
        View r106 = this.f140666f;
        if (r106 == null) goto L9;
        r104 = (ViewGroup) r106.findViewById(R.id.tag_group_container);
    L9:
        this.f140668h = r104;
        View r107 = this.f140666f;
        if (r107 == null) goto L15;
        View r108 = r107.findViewById(R.id.back_icon);
        if (r108 == null) goto L15;
        r108.setOnClickListener(new b(this));
    L15:
        return this.f140666f;
    L5:
        r105 = null;
        goto L6
    }
}
