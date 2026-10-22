package com.bytedance.android.livesdk.chatroom.report;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m60.i;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/report/ReportDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReportDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final TokenCert f110381o = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f110382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f110383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f110384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f110385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f110386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f110387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f110388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f110389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f110390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f110391m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f110392n;

    public static final class a {
    }

    public interface b {
        void a();

        void b(boolean r100, String r101);
    }

    public static final class c implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReportDialogFragment f110393a;

        public c(ReportDialogFragment r100) {
            this.f110393a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 == 4) goto L5;
            return false;
        L5:
            if (r102.getAction() != 1) goto L17;
            LiveDoubleColorBallAnimationView r103 = this.f110393a.f110391m;
            if (r103 != null) goto L9;
        L14:
            Dialog r104 = this.f110393a.getDialog();
            if (r104 == null) goto L17;
            r104.cancel();
            goto L17
        L9:
            if (r103.getVisibility() != 0) goto L14;
            Disposable r105 = this.f110393a.f110390l;
            if (r105 == null) goto L13;
            r105.dispose();
        L13:
            this.f110393a.showLoading(false);
            f2.c("取消上传", 0);
        L17:
            return true;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReportDialogFragment f110394a;

        public d(ReportDialogFragment r100) {
            this.f110394a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ReportDialogFragment r101 = this.f110394a;
            boolean r102 = !r101.f110382d;
            r101.f110382d = r102;
            if (r102 == false) goto L5;
            int r103 = R.drawable.ttlive_ic_report_dialog_check;
        L6:
            ImageView r104 = r101.f110386h;
            if (r104 == null) goto L10;
            r104.setImageDrawable(s1.m(r103));
            return;
        L10:
            return;
        L5:
            r103 = R.drawable.ttlive_ic_report_dialog_unchecked;
            goto L6
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReportDialogFragment f110395a;

        public e(ReportDialogFragment r100) {
            this.f110395a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f110395a.f110389k;
            if (r101 == null) goto L5;
            r101.a();
        L5:
            Dialog r102 = this.f110395a.getDialog();
            if (r102 == null) goto L9;
            r102.cancel();
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReportDialogFragment f110396a;

        public f(ReportDialogFragment r100) {
            this.f110396a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v11, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r5v9, types: [java.util.List] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ReportDialogFragment r101 = this.f110396a;
            TokenCert r102 = ReportDialogFragment.f110381o;
            PolarisFileWrapper r103 = r101.S90();
            if (r103 == null) goto L5;
            ?? r104 = CollectionsKt.listOf(r103);
        L23:
            ReportDialogFragment r105 = this.f110396a;
            r105.getClass();
            if (Build.VERSION.SDK_INT < 33) goto L26;
            String[] r106 = {BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO};
        L27:
            Activity r107 = ContextUtil.contextToActivity(r105.getContext());
            SettingKey<Boolean> r108 = i.f512260a;
            new i.b(r107).b(new com.bytedance.android.livesdk.chatroom.report.c(r105, r104), null, ReportDialogFragment.f110381o, (String[]) Arrays.copyOf(r106, r106.length));
            return;
        L26:
            r106 = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
            goto L27
        L5:
            Bundle r109 = this.f110396a.getArguments();
            if (r109 == null) goto L22;
            ArrayList<String> r110 = r109.getStringArrayList("extra_files");
            if (r110 == null) goto L22;
            ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
            Iterator r112 = r110.iterator();
        L11:
            if (r112.hasNext() == false) goto L16;
            String r113 = (String) r112.next();
            if (r113 != null) goto L15;
            r113 = "";
        L15:
            r111.add(new PolarisFileWrapper(r113));
            goto L11
        L16:
            r104 = new ArrayList();
            Iterator r114 = r111.iterator();
        L18:
            if (r114.hasNext() == false) goto L23;
            Object r115 = r114.next();
            if (((File) r115).exists() == false) goto L18;
            r104.add(r115);
        L22:
            r104 = CollectionsKt.emptyList();
            goto L23
        }
    }

    static {
        f110381o = TokenCert.Companion.with("bpea-reportdialog_request_permission");
    }

    public ReportDialogFragment() {
        this.f110382d = true;
    }

    public final PolarisFileWrapper S90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L10;
        String r101 = r100.getString("extra_screen_shot_file");
        if (r101 == null) goto L10;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L10;
        return r102;
    L10:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f110390l;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        LiveDoubleColorBallAnimationView r101 = this.f110391m;
        if (r101 != null) goto L8;
    L10:
        showLoading(false);
        return;
    L8:
        if (r101.getVisibility() != 0) goto L10;
        f2.c("取消上传", 0);
        goto L10
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setLayout(s1.f(280.0f), s1.f(200.0f));
        return;
    L9:
        return;
    }

    public final void showLoading(boolean r100) {
        if (r100 == false) goto L9;
        LiveDoubleColorBallAnimationView r101 = this.f110391m;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r101);
    L6:
        View r102 = this.f110392n;
        if (r102 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r102);
        return;
    L16:
        return;
    L9:
        LiveDoubleColorBallAnimationView r103 = this.f110391m;
        if (r103 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r103);
    L12:
        View r104 = this.f110392n;
        if (r104 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        setCancelable(false);
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        r102.setOnKeyListener(new c(this));
    L5:
        ImageView r103 = this.f110386h;
        if (r103 == null) goto L8;
        r103.setOnClickListener(new d(this));
    L8:
        TextView r104 = this.f110387i;
        if (r104 == null) goto L11;
        r104.setOnClickListener(new e(this));
    L11:
        TextView r105 = this.f110388j;
        if (r105 == null) goto L15;
        r105.setOnClickListener(new f(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (r102 == null) goto L5;
        this.f110382d = r102.getBoolean("state_checked");
    L5:
        Dialog r103 = getDialog();
        boolean r104 = false;
        if (r103 == null) goto L10;
        Window r105 = r103.getWindow();
        if (r105 == null) goto L10;
        r105.setBackgroundDrawable(new ColorDrawable(0));
    L10:
        View r106 = r100.inflate(R.layout.ttlive_dialog_report_room, r101, false);
        this.f110383e = (TextView) r106.findViewById(R.id.confirm_hint);
        this.f110384f = (EditText) r106.findViewById(R.id.reason_editor);
        if (S90() == null) goto L13;
        r104 = true;
    L13:
        if (r104 == false) goto L28;
        ImageView r107 = (ImageView) r106.findViewById(R.id.checkbox);
        this.f110386h = r107;
        if (this.f110382d == false) goto L17;
        int r108 = R.drawable.ttlive_ic_report_dialog_check;
    L18:
        if (r107 == null) goto L20;
        r107.setImageDrawable(s1.m(r108));
    L20:
        PolarisFileWrapper r109 = S90();
        if (r109 != null) goto L23;
        Bitmap r110 = null;
    L24:
        if (r110 == null) goto L34;
        ImageView r111 = (ImageView) r106.findViewById(R.id.report_dialog_preview);
        if (r111 == null) goto L34;
        r111.setImageBitmap(r110);
    L34:
        this.f110387i = (TextView) r106.findViewById(R.id.btn_cancel);
        this.f110388j = (TextView) r106.findViewById(R.id.btn_confirm);
        this.f110391m = (LiveDoubleColorBallAnimationView) r106.findViewById(R.id.loading_view);
        this.f110392n = r106.findViewById(R.id.mask_view);
        return r106;
    L23:
        r110 = BitmapFactory.decodeFile(r109.getAbsolutePath());
        goto L24
    L17:
        r108 = R.drawable.ttlive_ic_report_dialog_unchecked;
        goto L18
    L28:
        TextView r112 = this.f110383e;
        if (r112 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r112);
    L31:
        ViewGroup r113 = (ViewGroup) r106.findViewById(R.id.preview_row);
        this.f110385g = r113;
        if (r113 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r113);
        goto L34
    }
}
