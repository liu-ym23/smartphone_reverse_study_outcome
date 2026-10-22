package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.MiniAppExplainCardApi;
import com.bytedance.android.livesdk.utils.r2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardTitleEditorDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardTitleEditorDialog extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f84410k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f84411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f84412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f84413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f84414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f84415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public so0.a f84416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a f84417j;

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

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExplainCardTitleEditorDialog f84418a;

        public c(ExplainCardTitleEditorDialog r100) {
            this.f84418a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ExplainCardTitleEditorDialog r101 = this.f84418a;
            EditText r102 = (EditText) r101.S90(R.id.title_edit);
            if (r102 == null) goto L5;
            Editable r103 = r102.getText();
        L6:
            ExplainCardTitleEditorDialog.T90(r101, r103.toString());
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExplainCardTitleEditorDialog f84419a;

        public d(ExplainCardTitleEditorDialog r100) {
            this.f84419a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            EditText r101 = (EditText) this.f84419a.S90(R.id.title_edit);
            if (r101 == null) goto L6;
            r101.setText("");
            return;
        }
    }

    static {
    }

    public ExplainCardTitleEditorDialog() {
        this.f84417j = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.f84411d = new LinkedHashMap();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r100 = ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().f530019a.f530021b.get();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f84416i = r100;
        this.f84412e = LazyKt.lazy(new ExplainCardTitleEditorDialog$cardViewModel$2(this));
        this.f84413f = 1;
        this.f84414g = "";
        this.f84415h = "";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f84417j.b();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f84411d.clear();
    }

    public final View S90(int r100) {
        if (this.f84411d != null) goto L5;
        this.f84411d = new LinkedHashMap();
    L5:
        View r101 = this.f84411d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f84411d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void U90(boolean r100) {
        TextView r101 = (TextView) S90(R.id.confirm_button);
        if (r101 == null) goto L5;
        r101.setEnabled(r100);
    L5:
        if (r100 == false) goto L9;
        TextView r102 = (TextView) S90(R.id.confirm_button);
        if (r102 == null) goto L13;
        r102.setTextColor(ContextCompat.getColor(requireContext(), R.color.ttlive_mini_app_title_editor_confirm_normal));
        return;
    L13:
        return;
    L9:
        TextView r103 = (TextView) S90(R.id.confirm_button);
        if (r103 == null) goto L15;
        r103.setTextColor(ContextCompat.getColor(requireContext(), R.color.ttlive_mini_app_title_editor_confirm_default));
        return;
    }

    public final void V90(String r100) {
        int r101 = r100.length();
        TextView r102 = (TextView) S90(R.id.character_limit_view);
        boolean r103 = true;
        if (r102 == null) goto L5;
        r102.setText(getString(R.string.ttlive_open_platform_edit_character_limit, new Object[]{Integer.valueOf(r101), 15}));
    L5:
        ImageView r104 = (ImageView) S90(R.id.clear_view);
        if (r104 == null) goto L11;
        if (r101 <= 0) goto L9;
        int r105 = 0;
    L10:
        r104.setVisibility(r105);
        goto L11
    L9:
        r105 = 4;
    L11:
        if (r101 <= 0) goto L27;
        ImageView r106 = (ImageView) S90(R.id.clear_view);
        if (r106 == null) goto L15;
        r106.setVisibility(0);
    L15:
        if (r101 < 15) goto L23;
        TextView r107 = (TextView) S90(R.id.character_limit_view);
        if (r107 == null) goto L19;
        r107.setTextColor(ContextCompat.getColor(requireContext(), R.color.ttlive_mini_app_title_editor_alert));
    L19:
        if (r101 == 15) goto L22;
        r103 = false;
    L22:
        U90(r103);
        return;
    L23:
        TextView r108 = (TextView) S90(R.id.character_limit_view);
        if (r108 == null) goto L26;
        r108.setTextColor(ContextCompat.getColor(requireContext(), R.color.ttlive_mini_app_title_editor_character_limit_normal));
    L26:
        U90(true);
        return;
    L27:
        ImageView r109 = (ImageView) S90(R.id.clear_view);
        if (r109 == null) goto L30;
        r109.setVisibility(4);
    L30:
        U90(false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setLayout(-1, -2);
    L7:
        ((TextView) S90(R.id.title_label)).setText(this.f84414g);
        EditText r103 = (EditText) S90(R.id.title_edit);
        String r104 = null;
        if (r103 == null) goto L16;
        String r105 = this.f84415h;
        if (r2.a(r105) == true) goto L13;
        r105 = null;
    L13:
        if (r105 != null) goto L15;
        r105 = getString(R.string.ttlive_open_platform_custom_recommend_reason);
    L15:
        r103.setText(r105);
    L16:
        EditText r106 = (EditText) S90(R.id.title_edit);
        if (r106 == null) goto L19;
        r106.requestFocus();
    L19:
        EditText r107 = (EditText) S90(R.id.title_edit);
        boolean r108 = false;
        if (r107 == null) goto L22;
        r107.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new b()});
    L22:
        EditText r109 = (EditText) S90(R.id.title_edit);
        if (r109 == null) goto L25;
        r109.setOnEditorActionListener(new n(this));
    L25:
        EditText r110 = (EditText) S90(R.id.title_edit);
        if (r110 == null) goto L28;
        r110.setOnFocusChangeListener(new o(this));
    L28:
        EditText r111 = (EditText) S90(R.id.title_edit);
        if (r111 == null) goto L31;
        r111.addTextChangedListener(new p(this));
    L31:
        TextView r112 = (TextView) S90(R.id.confirm_button);
        if (r112 == null) goto L35;
        r112.setOnClickListener(new c(this));
    L35:
        if (r2.a(this.f84415h) == true) goto L37;
    L39:
        U90(r108);
        ImageView r113 = (ImageView) S90(R.id.clear_view);
        if (r113 == null) goto L42;
        r113.setOnClickListener(new d(this));
    L42:
        TextView r114 = (TextView) S90(R.id.sensitive_words_alert_view);
        if (r114 == null) goto L45;
        r114.setVisibility(8);
    L45:
        String r115 = this.f84415h;
        if (r2.a(r115) == false) goto L48;
        r104 = r115;
    L48:
        if (r104 != null) goto L50;
        r104 = getString(R.string.ttlive_open_platform_custom_recommend_reason);
    L50:
        V90(r104);
        return;
    L37:
        if (this.f84415h.length() > 15) goto L39;
        r108 = true;
        goto L39
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        int r102 = r101.getInt("editor_type");
    L6:
        this.f84413f = r102;
        Bundle r103 = getArguments();
        if (r103 == null) goto L10;
        String r104 = r103.getString("editor_label_title");
        if (r104 == null) goto L10;
    L11:
        this.f84414g = r104;
        Bundle r105 = getArguments();
        if (r105 == null) goto L15;
        String r106 = r105.getString("editor_title");
        if (r106 == null) goto L15;
    L16:
        this.f84415h = r106;
        int r107 = qo0.a.f534145a;
        qo0.a.c("ExplainCardTitleEditorDialog", "onCreate, type: " + this.f84413f + ", label: " + this.f84414g + ", title: " + this.f84415h);
        return;
    L15:
        r106 = "";
    L10:
        r104 = getString(R.string.ttlive_open_platform_edit_label_explain_card);
        goto L11
    L5:
        r102 = 1;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.requestWindowFeature(1);
        r101.setCanceledOnTouchOutside(true);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setSoftInputMode(21);
        r102.setGravity(80);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.getAttributes().windowAnimations = R.style.ttlive_open_platform_bottom_Dialog;
    L5:
        return r101;
    }

    public static final void T90(ExplainCardTitleEditorDialog r100, String r101) {
        r100.getClass();
        int r102 = qo0.a.f534145a;
        qo0.a.c("ExplainCardTitleEditorDialog", "start check content, title: " + r101);
        Lazy r103 = LiveOpenPlatformClient.f84032c;
        Disposable r104 = ((MiniAppExplainCardApi) LiveOpenPlatformClient.a.a().a(MiniAppExplainCardApi.class)).checkStamp(4, r101).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(r100, r101), r.f84446a);
        Intrinsics.checkNotNullParameter(r104, "$this$autoDispose");
        r100.f84417j.a(r104);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_miniapp_title_editor, r101, false);
    }
}
