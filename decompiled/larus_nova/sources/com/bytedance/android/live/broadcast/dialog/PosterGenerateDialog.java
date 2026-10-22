package com.bytedance.android.live.broadcast.dialog;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.crash.d;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcast/dialog/PosterGenerateDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-shared-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PosterGenerateDialog extends DialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f59101h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f59102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnchorColumnPosterInfo f59103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f59104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f59105g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PosterGenerateDialog f59106a;

        public b(PosterGenerateDialog r100) {
            this.f59106a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f59106a.dismiss();     // Catch: Exception -> L5
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

    public PosterGenerateDialog() {
        this.f59102d = new LinkedHashMap();
        this.f59104f = new CompositeDisposable();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f59102d).clear();
    }

    public static final void T90(PosterGenerateDialog r210) {
        AnchorColumnPosterInfo r100 = r210.f59103e;
        if (r100 == null) goto L8;
        String r101 = jc1.a.b().getFilesDir().getAbsolutePath() + File.separator + "liveAnchorColumn";
        if (new PolarisFileWrapper(r101).exists() == true) goto L7;
        new PolarisFileWrapper(r101).mkdir();
    L7:
        r100.getAnchorUserID();
        System.currentTimeMillis();
    L8:
        CardView r102 = (CardView) r210.S90(R.id.cl_poster);
        if (r102 == null) goto L11;
        r102.buildDrawingCache();
    L11:
        CardView r103 = (CardView) r210.S90(R.id.cl_poster);
        if (r103 == null) goto L55;
        Bitmap r104 = r103.getDrawingCache();
        if (r104 == null) goto L56;
        Context r105 = r210.getContext();
        boolean r106 = false;
        OutputStream r107 = null;
        if (r105 == null) goto L37;
        ContentResolver r108 = r105.getContentResolver();
        if (r108 == null) goto L37;
        Uri r110 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues r111 = new ContentValues();
        ArrayList r112 = new ArrayList();
        Object[] r113 = {r110, r111};
        f06.b r114 = new f06.b();
        g06.a r109 = ApiHookConfig.f245611b.get(240017);
        if (r109 == null) goto L22;
        f06.a[] r115 = r109.f479473i;
    L23:
        f06.a[] r116 = r115;
        int r117 = r116.length;
        int r118 = 0;
    L25:
        if (r118 >= r117) goto L32;
        f06.a r119 = r116[r118];
        int r211 = r118;
        int r212 = r117;
        f06.a[] r213 = r116;
        Object[] r214 = r113;
        f06.d r120 = r119.preInvoke(240017, "android/content/ContentResolver", "insert", r108, r113, "android.net.Uri", r114);     // Catch: Exception -> L49
        if (r120.f474982a == true) goto L29;
        r112.add(r119);     // Catch: Exception -> L49
        goto L31
    L29:
        r106 = false;
    L34:
        if (r120.f474982a == false) goto L36;
        Uri r121 = (Uri) r120.f474983b;
    L38:
        if (r121 == null) goto L47;
        Context r122 = r210.getContext();
        if (r122 == null) goto L44;
        ContentResolver r123 = r122.getContentResolver();
        if (r123 == null) goto L44;
        r107 = ContentResolverWrapper.openOutputStream(r123, r121);
    L44:
        if (r107 == null) goto L47;
        r106 = r104.compress(Bitmap.CompressFormat.JPEG, 90, r107);
    L47:
        RxUtilKt.c(Observable.just(Boolean.valueOf(r106)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.broadcast.dialog.b(r210), new c(r210)), r210.f59104f);
        return;
    L36:
        r121 = r108.insert(r110, r111);
    L31:
        r118 = r211 + 1;
        r117 = r212;
        r116 = r213;
        r113 = r214;
        goto L25
    L32:
        r106 = false;
        r120 = new f06.d(false, null);
        goto L34
    L22:
        r115 = ApiHookConfig.f245613d;
    L37:
        r121 = null;
        goto L38
    L56:
        return;
    }

    public final View S90(int r100) {
        if (this.f59102d != null) goto L5;
        this.f59102d = new LinkedHashMap();
    L5:
        View r101 = this.f59102d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f59102d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        r101.setCanceledOnTouchOutside(true);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setLayout(-1, -2);
        r102.setGravity(17);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_poster_dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        this.f59104f.clear();     // Catch: Throwable -> L5
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

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.setOnClickListener(new b(this));
        LiveDoubleColorBallAnimationView r102 = (LiveDoubleColorBallAnimationView) S90(R.id.loading);
        if (r102 == null) goto L5;
        r102.setVisibility(0);
        r102.b();
    L5:
        AnchorColumnPosterInfo r103 = this.f59103e;
        if (r103 == null) goto L43;
        SimpleDraweeView r104 = (SimpleDraweeView) S90(R.id.sdv_background);
        if (r104 == null) goto L10;
        r104.setImageURI(r103.getColumnBackgroundUrl());
    L10:
        SimpleDraweeView r105 = (SimpleDraweeView) S90(R.id.sdv_background);
        if (r105 == null) goto L15;
        GenericDraweeHierarchy r106 = r105.getHierarchy();
        if (r106 == null) goto L15;
        r106.setActualImageFocusPoint(new PointF(0.0f, 0.0f));
    L15:
        SimpleDraweeView r107 = (SimpleDraweeView) S90(R.id.sdv_avatar);
        if (r107 == null) goto L18;
        r107.setImageURI(r103.getAvatarUrl());
    L18:
        TextView r108 = (TextView) S90(R.id.tv_user_name);
        if (r108 == null) goto L21;
        r108.setText(r103.getAnchorNickname());
    L21:
        TextView r109 = (TextView) S90(R.id.tv_title);
        if (r109 == null) goto L24;
        r109.setText(r103.getColumnTitle());
    L24:
        TextView r110 = (TextView) S90(R.id.tv_description);
        if (r110 == null) goto L27;
        r110.setText(r103.getColumnIntroduction());
    L27:
        ((IHostShare) k.n(IHostShare.class)).getQrCodeInfo(4, r103.getAnchorUserID(), new PosterGenerateDialog$initView$$inlined$let$lambda$1(this));
        int r111 = Color.parseColor(r103.getColumnBackgroundColor());     // Catch: Throwable -> L30
    L32:
        View r112 = S90(R.id.view_gap);
        if (r112 == null) goto L47;
        r112.setBackground(new ColorDrawable(r111));
    L47:
        Integer r113 = Integer.valueOf(ColorUtils.setAlphaComponent(r111, 0));     // Catch: Throwable -> L37
    L39:
        if (r113 == null) goto L43;
        View r114 = S90(R.id.view_background);
        if (r114 == null) goto L43;
        GradientDrawable r115 = new GradientDrawable();
        r115.setGradientType(0);
        r115.setColors(new int[]{r111, r113.intValue()});
        r115.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        Unit r116 = Unit.INSTANCE;
        r114.setBackground(r115);
    L37:
        th = move-exception;
        ALogger.e("PosterGenerateDialog", "background color parse fail", th);
        r113 = null;
    L30:
        th = move-exception;
        ALogger.e("PosterGenerateDialog", "background color parse fail", th);
        r111 = -1;
    L43:
        FrameLayout r117 = (FrameLayout) S90(R.id.fl_save_poster);
        if (r117 == null) goto L51;
        r117.setOnClickListener(new com.bytedance.android.live.broadcast.dialog.a(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_poster_generate, r101);
    }
}
