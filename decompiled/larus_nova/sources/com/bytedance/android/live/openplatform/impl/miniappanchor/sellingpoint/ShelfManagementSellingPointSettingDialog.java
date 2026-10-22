package com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.SellingPointApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCard;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductIntroductionLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductPriceView;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/sellingpoint/ShelfManagementSellingPointSettingDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementSellingPointSettingDialog extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f84488j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f84489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public so0.a f84490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShelfCardInfo f84491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f84492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f84493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f84494i;

    public static final class a {
    }

    public static final class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r103, "dest");
            if (new Regex("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+").containsMatchIn(r100) == false) goto L5;
            return "";
        L5:
            return null;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog f84495a;

        public c(ShelfManagementSellingPointSettingDialog r100) {
            this.f84495a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((EditText) this.f84495a.S90(R.id.edit_text)).requestFocus();     // Catch: Throwable -> L4 Exception -> L10
            t2.b(this.f84495a.getContext(), (EditText) this.f84495a.S90(R.id.edit_text));     // Catch: Throwable -> L4 Exception -> L10
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog f84496a;

        public d(ShelfManagementSellingPointSettingDialog r100) {
            this.f84496a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f84496a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog f84497a;

        public e(ShelfManagementSellingPointSettingDialog r100) {
            this.f84497a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ShelfManagementSellingPointSettingDialog r101 = this.f84497a;
            r101.f84494i = true;
            r101.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L12;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog f84498a;

        public f(ShelfManagementSellingPointSettingDialog r100) {
            this.f84498a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ShelfManagementSellingPointSettingDialog r101 = this.f84498a;
            ShelfManagementSellingPointSettingDialog.T90(r101, ((EditText) r101.S90(R.id.edit_text)).getText().toString());
        }
    }

    static {
    }

    public final long V90() {
        so0.a r100 = this.f84490e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r101 = r100.a();
        Long r102 = null;
        if (r101 != null) goto L8;
    L12:
        ShelfCardInfo r103 = this.f84491f;
        if (r103 == null) goto L15;
        r102 = Long.valueOf(r103.O());
    L15:
        if (r102 != null) goto L19;
        return 0;
    L19:
        return r102.longValue();
    L8:
        if (r101.isInLive() != true) goto L12;
        ShelfCardInfo r104 = this.f84491f;
        if (r104 == null) goto L15;
        r102 = Long.valueOf(r104.getCardId());
        goto L15
    }

    public ShelfManagementSellingPointSettingDialog() {
        new CompositeDisposable();
        this.f84489d = new LinkedHashMap();
        this.f84492g = -1;
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r100 = ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().f530019a.f530021b.get();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f84490e = r100;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f84489d.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ((EditText) S90(R.id.edit_text)).post(new c(this));
    }

    public final View S90(int r100) {
        if (this.f84489d != null) goto L5;
        this.f84489d = new LinkedHashMap();
    L5:
        View r101 = this.f84489d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f84489d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void U90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        if (this.f84494i == false) goto L5;
        xs2.b.a().post(new zp0.a());
    L5:
        long r101 = V90();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r102 = AnchorMiniAppDataContext.a.a();
        String r103 = null;
        if (r102 == null) goto L10;
        i<HashMap<Long, String>> r104 = r102.getSellingPointEditCache();
        if (r104 == null) goto L10;
        HashMap<Long, String> r105 = r104.getValue();
    L11:
        ShelfCardInfo r106 = this.f84491f;
        if (r106 == null) goto L14;
        r103 = r106.b();
    L14:
        if (r103 != null) goto L24;
        AnchorMiniAppDataContext r107 = AnchorMiniAppDataContext.a.a();
        if (r107 == null) goto L22;
        i<HashMap<Long, String>> r108 = r107.getSellingPointEditCache();
        if (r108 == null) goto L22;
        HashMap<Long, String> r109 = r108.getValue();
        if (r109 == null) goto L22;
        String r110 = r109.put(Long.valueOf(V90()), ((EditText) S90(R.id.edit_text)).getText().toString());
    L22:
        if (r105 == null) goto L27;
        String r111 = r105.put(Long.valueOf(r101), ((EditText) S90(R.id.edit_text)).getText().toString());
        return;
    L27:
        return;
    L24:
        if (r105 == null) goto L29;
        String r112 = r105.remove(Long.valueOf(r101));
        return;
    L29:
        return;
    L10:
        r105 = null;
        goto L11
    }

    public final void W90(String r210) {
        xs2.b.a().post(new zp0.a());
        ShelfCardInfo r100 = this.f84491f;
        if (r100 == null) goto L5;
        xs2.b.a().post(new zp0.c(ShelfCardInfo.g(r100, null, null, null, null, false, null, 0, 0, null, null, null, 0, r210, null, null, null, null, 0, 0, -268435457, 7), this.f84492g));
    L5:
        t2.a(getContext(), (EditText) S90(R.id.edit_text));
        this.f84494i = true;
        dismiss();     // Catch: Exception -> L8
    L12:
        so0.a r101 = this.f84490e;
        if (r101 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L15:
        OpenPlatformContext r102 = r101.a();
        if (r102 == null) goto L34;
        AnchorMiniAppAppLogContextService r103 = (AnchorMiniAppAppLogContextService) r102.getService(AnchorMiniAppAppLogContextService.class);
        if (r103 == null) goto L35;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r104 = AnchorMiniAppDataContext.a.a();
        if (r104 == null) goto L29;
        n<ShelfInfo> r105 = r104.m8183getShelfInfo();
        if (r105 == null) goto L29;
        ShelfInfo r106 = r105.getValue();
        if (r106 == null) goto L29;
        ShelfMicroAppInfo r107 = r106.appInfo;
        if (r107 == null) goto L29;
        String r108 = r107.appId;
        if (r108 == null) goto L29;
    L30:
        r103.reportEditSellingPointResult(r108, true, r210.length(), "");
        return;
    L29:
        r108 = "";
        goto L30
    L35:
        return;
    L34:
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r109 = DialogFragmentLancet.sLastShowStack;
        if (r109 == null) goto L12;
        com.bytedance.crash.d.d(r109, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public final void X90(String r100) {
        int r101 = r100.length();
        ((TextView) S90(R.id.character_limit_text)).setText(getString(R.string.ttlive_open_platform_edit_character_limit, new Object[]{Integer.valueOf(r101), 15}));
        if (r101 <= 0) goto L12;
        if (r101 < 15) goto L8;
        TextView r102 = (TextView) S90(R.id.character_limit_text);
        if (r102 == null) goto L13;
        r102.setTextColor(ContextCompat.getColor(requireContext(), R.color.ttlive_op_color_fe2c55));
        return;
    L13:
        return;
    L8:
        TextView r103 = (TextView) S90(R.id.character_limit_text);
        if (r103 == null) goto L15;
        r103.setTextColor(ContextCompat.getColor(requireContext(), R.color.ttlive_douyin_text_TextTertiary));
        return;
    L15:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setLayout(-1, -2);
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.dimAmount = 1.0f;
        Unit r104 = Unit.INSTANCE;
        r102.setAttributes(r103);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        setStyle(1, R.style.ttlive_common_bottom_dialog);
        super.onCreate(r100);
        setCancelable(true);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        ShelfCardInfo r102 = (ShelfCardInfo) r101.getParcelable("card_info");
    L6:
        this.f84491f = r102;
        Bundle r103 = getArguments();
        if (r103 == null) goto L9;
        int r104 = r103.getInt(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION);
    L10:
        this.f84492g = r104;
        so0.a r105 = this.f84490e;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L13:
        OpenPlatformContext r106 = r105.a();
        if (r106 == null) goto L30;
        AnchorMiniAppAppLogContextService r107 = (AnchorMiniAppAppLogContextService) r106.getService(AnchorMiniAppAppLogContextService.class);
        if (r107 == null) goto L31;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r108 = AnchorMiniAppDataContext.a.a();
        if (r108 == null) goto L27;
        n<ShelfInfo> r109 = r108.m8183getShelfInfo();
        if (r109 == null) goto L27;
        ShelfInfo r110 = r109.getValue();
        if (r110 == null) goto L27;
        ShelfMicroAppInfo r111 = r110.appInfo;
        if (r111 == null) goto L27;
        String r112 = r111.appId;
        if (r112 == null) goto L27;
    L28:
        r107.reportEditSellingPointPanelShow(r112);
        return;
    L27:
        r112 = "";
        goto L28
    L31:
        return;
    L30:
        return;
    L9:
        r104 = -1;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(21);
    L5:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        U90(r100);     // Catch: Throwable -> L5
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

    public static final void T90(ShelfManagementSellingPointSettingDialog r100, String r101) {
        r100.getClass();
        if (StringsKt.isBlank(r101) == false) goto L5;
        r100.W90("");
        return;
    L5:
        Lazy r102 = LiveOpenPlatformClient.f84032c;
        SellingPointApi r103 = (SellingPointApi) LiveOpenPlatformClient.a.a().a(SellingPointApi.class);
        so0.a r104 = r100.f84490e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L8:
        OpenPlatformContext r105 = r104.a();
        long r106 = 0;
        if (r105 == null) goto L11;
        long r107 = r105.getRoomId();
    L12:
        ShelfCardInfo r108 = r100.f84491f;
        if (r108 == null) goto L15;
        r106 = r108.getCardId();
    L15:
        r103.checkSellingPoint(r107, r106, r101).compose(RxUtil.rxSchedulerHelper()).subscribe(new wp0.a(r100, r101), wp0.b.f560546a);
        return;
    L11:
        r107 = 0;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ((ImageView) S90(R.id.back_btn)).setOnClickListener(new d(this));
        ((ImageView) S90(R.id.close_btn)).setOnClickListener(new e(this));
        ShelfCardInfo r100 = this.f84491f;
        if (r100 == null) goto L5;
        String r101 = r100.b();
    L6:
        String r102 = "";
        if (r101 != null) goto L19;
        long r103 = V90();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r104 = AnchorMiniAppDataContext.a.a();
        if (r104 == null) goto L14;
        i<HashMap<Long, String>> r105 = r104.getSellingPointEditCache();
        if (r105 == null) goto L14;
        HashMap<Long, String> r106 = r105.getValue();
    L15:
        if (r106 == null) goto L18;
        r101 = r106.get(Long.valueOf(r103));
        if (r101 != null) goto L19;
    L18:
        r101 = "";
    L14:
        r106 = null;
    L19:
        ShelfCardInfo r107 = this.f84491f;
        if (r107 == null) goto L81;
        ShelfManagementCard r108 = (ShelfManagementCard) S90(R.id.shelf_management_card);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "shelfCardInfo");
        ImageLoader.bindImage((HSImageView) r108.a(R.id.card_cover_img), r107.h());
        ((TextView) r108.a(R.id.card_title_tv)).setText(r107.i(null));
        boolean r109 = ee0.f120119a.getValue().s();
        if (r109 == false) goto L27;
        ((TextView) r108.a(R.id.selling_point_tv)).setVisibility(0);
        TextView r112 = (TextView) r108.a(R.id.selling_point_tv);
        String r113 = r107.b();
        if (r113 == null) goto L26;
        r102 = r113;
    L26:
        r112.setText(r102);
    L28:
        ProductInfo r114 = r107.getProductInfo();
        com.bytedance.android.live.openplatform.api.utils.a r115 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        if (r115.h() == false) goto L67;
        if (r114 == null) goto L67;
        if (r115.i() == false) goto L43;
        List<ProductIntroductionInfo> r116 = r114.introductionList;
        if (r116 != null) goto L36;
    L39:
        boolean r117 = true;
    L40:
        if (r117 == true) goto L43;
        CommonProductIntroductionLayout r118 = (CommonProductIntroductionLayout) r108.a(R.id.product_introduction);
        List<ProductIntroductionInfo> r119 = r114.introductionList;
        Intrinsics.checkNotNull(r119);
        r118.r(r115.k(r119));
        ((CommonProductIntroductionLayout) r108.a(R.id.product_introduction)).setVisibility(0);
        boolean r120 = true;
    L44:
        if (r109 == false) goto L48;
        if (r120 == false) goto L48;
        ((CommonProductLabelLayout) r108.a(R.id.product_label)).setVisibility(8);
    L61:
        if (r115.e() == true) goto L63;
    L66:
        ((CommonProductPriceView) r108.a(R.id.product_price)).setVisibility(8);
    L68:
        String r121 = r107.b();
        if (r121 != null) goto L71;
    L74:
        boolean r122 = true;
    L75:
        if (r122 == false) goto L81;
        ShelfManagementCard r123 = (ShelfManagementCard) S90(R.id.shelf_management_card);
        if (r2.a(r101) == false) goto L79;
        String r124 = r101;
    L80:
        r123.getClass();
        Intrinsics.checkNotNullParameter(r124, "sellingPoint");
        ((TextView) r123.a(R.id.selling_point_tv)).setText(r124);
        goto L81
    L79:
        r124 = s1.B(R.string.ttlive_open_platform_edit_selling_point_default);
        goto L80
    L71:
        if (r121.length() == 0) goto L74;
        r122 = false;
        goto L75
    L63:
        if (r114.price == null) goto L66;
        CommonProductPriceView r125 = (CommonProductPriceView) r108.a(R.id.product_price);
        ProductPriceInfo r126 = r114.price;
        Intrinsics.checkNotNull(r126);
        r125.b(r126);
        ((CommonProductPriceView) r108.a(R.id.product_price)).setVisibility(0);
    L48:
        if (r115.j() == false) goto L59;
        List<ProductLabelInfo> r127 = r114.labelList;
        if (r127 != null) goto L52;
    L55:
        boolean r128 = true;
    L56:
        if (r128 == true) goto L59;
        CommonProductLabelLayout r129 = (CommonProductLabelLayout) r108.a(R.id.product_label);
        List<ProductLabelInfo> r130 = r114.labelList;
        Intrinsics.checkNotNull(r130);
        r129.r(r115.l(r130));
        ((CommonProductLabelLayout) r108.a(R.id.product_label)).setVisibility(0);
        goto L61
    L52:
        if (r127.isEmpty() == true) goto L55;
        r128 = false;
    L59:
        ((CommonProductLabelLayout) r108.a(R.id.product_label)).setVisibility(8);
        goto L61
    L36:
        if (r116.isEmpty() == true) goto L39;
        r117 = false;
    L43:
        ((CommonProductIntroductionLayout) r108.a(R.id.product_introduction)).setVisibility(8);
        r120 = false;
    L67:
        ((CommonProductIntroductionLayout) r108.a(R.id.product_introduction)).setVisibility(8);
        ((CommonProductLabelLayout) r108.a(R.id.product_label)).setVisibility(8);
        ((CommonProductPriceView) r108.a(R.id.product_price)).setVisibility(8);
        goto L68
    L27:
        ((TextView) r108.a(R.id.selling_point_tv)).setVisibility(8);
    L81:
        ((EditText) S90(R.id.edit_text)).setText(r101);
        ((EditText) S90(R.id.edit_text)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new b()});
        ((EditText) S90(R.id.edit_text)).setOnEditorActionListener(new wp0.c(this));
        ((EditText) S90(R.id.edit_text)).setOnFocusChangeListener(new wp0.d(this));
        ((EditText) S90(R.id.edit_text)).addTextChangedListener(new wp0.e(this));
        X90(r101);
        ((TextView) S90(R.id.save_btn)).setOnClickListener(new f(this));
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_miniapp_shelf_management_selling_point_setting_dialog, r101, false);
    }
}
