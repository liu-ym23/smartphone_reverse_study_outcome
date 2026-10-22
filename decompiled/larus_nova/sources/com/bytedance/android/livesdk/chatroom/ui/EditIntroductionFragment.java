package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/EditIntroductionFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/chatroom/utils/d0;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EditIntroductionFragment extends LiveDialogFragment implements com.bytedance.android.livesdk.chatroom.utils.d0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f112142p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f112143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f112144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f112145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f112146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f112147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f112148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SpannableStringBuilder f112149j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public n6 f112150k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IdentityHashMap<String, s6> f112151l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f112152m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f112153n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final EditIntroductionFragment$imageGetter$1 f112154o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditIntroductionFragment f112155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f112156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f112157c;

        public b(EditIntroductionFragment r100, Function2 r101, String r102) {
            this.f112155a = r100;
            this.f112156b = r101;
            this.f112157c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            EditText r102 = this.f112155a.f112145f;
            if (r102 == null) goto L6;
            r102.post(new b6(this, r101));
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f112158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f112159b;

        public c(Function1 r100, String r101) {
            this.f112158a = r100;
            this.f112159b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f112158a.invoke(this.f112159b);
        }
    }

    public static final class d implements LiveBottomSheetDialog.m {
        public d() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean shouldInterceptSlide(int r100) {
            return false;
        }
    }

    public static final class e implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditIntroductionFragment f112160a;

        public e(EditIntroductionFragment r100) {
            this.f112160a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            EditIntroductionFragment r101 = this.f112160a;
            EditIntroductionFragment.S90(r101, r101.f112148i);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditIntroductionFragment f112161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f112162b;

        public f(EditIntroductionFragment r100, Map r101) {
            this.f112161a = r100;
            this.f112162b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_activity_info_filling_page_detail_done", this.f112162b, new Object[0]);
            EditText r101 = this.f112161a.f112145f;
            if (r101 == null) goto L5;
            Editable r102 = r101.getText();
        L6:
            String r103 = Html.toHtml(r102);
            EditIntroductionFragment.S90(this.f112161a, r103);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditIntroductionFragment f112163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f112164b;

        public g(EditIntroductionFragment r100, Map r101) {
            this.f112163a = r100;
            this.f112164b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_activity_info_filling_page_detail_return", this.f112164b, new Object[0]);
            EditIntroductionFragment r101 = this.f112163a;
            EditIntroductionFragment.S90(r101, r101.f112148i);
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditIntroductionFragment f112165a;

        public h(EditIntroductionFragment r100) {
            this.f112165a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            EditIntroductionFragment r101 = this.f112165a;
            n6 r102 = r101.f112150k;
            if (r102 == null) goto L6;
            r102.A9(r101);
            return;
        }
    }

    static {
    }

    public EditIntroductionFragment() {
        this.f112148i = "";
        this.f112151l = new IdentityHashMap();
        this.f112153n = 686;
        this.f112154o = new EditIntroductionFragment$imageGetter$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Map<String, n6> r100 = com.bytedance.android.livesdk.chatroom.utils.s4.f114621a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.f114622b).remove(this);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        String r102 = r101.getString("upload_callback_key");
        if (r102 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r102, "key");
        com.bytedance.android.livesdk.chatroom.utils.s4.f114621a.remove(r102);
        return;
    L6:
        r102 = "";
        goto L7
    }

    public static final void T90(EditIntroductionFragment r100) {
        if (r100.f112151l.isEmpty() == false) goto L15;
        EditText r101 = r100.f112145f;
        if (r101 == null) goto L7;
        r101.setText(r100.f112149j);
    L7:
        EditText r102 = r100.f112145f;
        if (r102 == null) goto L16;
        Editable r103 = r102.getText();
        if (r103 == null) goto L12;
        int r104 = r103.length();
    L13:
        r102.setSelection(r104);
        return;
    L12:
        r104 = 0;
        goto L13
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (this.f112152m == false) goto L18;
        Dialog r101 = getDialog();
        if (r101 == null) goto L19;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L20;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L13:
        r103.setPadding(0, 0, 0, 0);
        View r105 = r102.findViewById(R.id.ttlive_design_bottom_sheet);
        if (r105 == null) goto L16;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.height = -1;
        r105.setLayoutParams(r106);
    L16:
        WindowManager.LayoutParams r107 = r102.getAttributes();
        r107.width = -1;
        r107.height = (int) fm3.e.a(r102.getContext(), this.f112153n);
        r102.setAttributes(r107);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        boolean r102 = r101.getBoolean("open_as_dialog_fragment");
    L6:
        this.f112152m = r102;
        if (r102 == false) goto L14;
        Bundle r103 = getArguments();
        if (r103 == null) goto L11;
        int r104 = r103.getInt("page_height");
    L12:
        this.f112153n = r104;
        setStyle(1, R.style.ttlive_edit_introduction_fragment);
        setBottomSheetSlideProcessor(new d());
        return;
    L11:
        r104 = 686;
        goto L12
    L14:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (this.f112152m == false) goto L5;
        r101.setCanceledOnTouchOutside(false);
        r101.setOnCancelListener(new e(this));
    L5:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.d0
    public final void z9(final String r100) {
        if ((getActivity() instanceof Context) == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.length() != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L15;
        U90(r100, new EditIntroductionFragment$onUploadSuccess$1(this, r100), EditIntroductionFragment$onUploadSuccess$2.INSTANCE);
        return;
    L15:
        return;
    L9:
        r101 = false;
        goto L10
    }

    public static final void S90(EditIntroductionFragment r100, String r101) {
        n6 r102 = r100.f112150k;
        if (r102 == null) goto L5;
        r102.B9(r101);
    L5:
        int r103 = x8.a.f562881a;
        x8.a.d("EditIntroductionFragment", "finish edit " + r101, false);
        if (r100.f112152m == true) goto L17;
        FragmentActivity r104 = r100.getActivity();
        if (r104 == null) goto L21;
        r104.finish();
        return;
    L21:
        return;
    L17:
        r100.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L19;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r112 = getArguments();
        if (r112 == null) goto L7;
        String r113 = r112.getString("upload_callback_key");
        if (r113 == null) goto L7;
        Map<String, n6> r114 = com.bytedance.android.livesdk.chatroom.utils.s4.f114621a;
        Intrinsics.checkNotNullParameter(r113, "key");
        this.f112150k = com.bytedance.android.livesdk.chatroom.utils.s4.f114621a.remove(r113);
    L7:
        Bundle r115 = getArguments();
        String r116 = "";
        if (r115 == null) goto L13;
        String r117 = r115.getString("edit_content", "");
        if (r117 == null) goto L13;
        r116 = r117;
    L13:
        this.f112148i = r116;
        Bundle r118 = getArguments();
        if (r118 == null) goto L16;
        boolean r119 = r118.getBoolean("add_image_directly", false);
    L17:
        if (r119 == false) goto L22;
        n6 r120 = this.f112150k;
        if (r120 == null) goto L22;
        r120.A9(this);
    L22:
        if (this.f112148i.length() <= 0) goto L24;
        boolean r121 = true;
    L25:
        if (r121 == false) goto L53;
        Spanned r100 = null;
        Spanned r122 = Html.fromHtml(this.f112148i, this.f112154o, null);
        if ((r122 instanceof SpannableStringBuilder) == false) goto L30;
        r100 = r122;
    L30:
        SpannableStringBuilder r101 = (SpannableStringBuilder) r100;
        this.f112149j = r101;
        if (r101 == null) goto L53;
        ImageSpan[] r123 = (ImageSpan[]) r101.getSpans(0, r101.length(), ImageSpan.class);
        if (r123 == null) goto L53;
        int r102 = r123.length;
        int r103 = 0;
    L36:
        if (r103 >= r102) goto L49;
        ImageSpan r104 = r123[r103];
        String r105 = r104.getSource();
        if (r105 == null) goto L47;
        SpannableStringBuilder r106 = this.f112149j;
        int r107 = -1;
        if (r106 == null) goto L42;
        int r108 = r106.getSpanStart(r104);
    L43:
        SpannableStringBuilder r109 = this.f112149j;
        if (r109 == null) goto L46;
        r107 = r109.getSpanEnd(r104);
    L46:
        this.f112151l.put(r105, new s6(r108, r107, r104));
        goto L47
    L42:
        r108 = -1;
    L47:
        r103 = r103 + 1;
        goto L36
    L49:
        if (this.f112151l.isEmpty() == false) goto L53;
        EditText r124 = this.f112145f;
        if (r124 == null) goto L53;
        r124.setText(this.f112149j);
    L53:
        EditText r125 = this.f112145f;
        if (r125 == null) goto L56;
        r125.setOnTouchListener(new c6(this));
    L56:
        Map<String, n6> r126 = com.bytedance.android.livesdk.chatroom.utils.s4.f114621a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.f114622b).add(this);
        Map r127 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from_merge", "direct_shoot"), TuplesKt.to("live_type", "video_live")});
        View r128 = this.f112143d;
        if (r128 == null) goto L59;
        r128.setOnClickListener(new f(this, r127));
    L59:
        View r129 = this.f112144e;
        if (r129 == null) goto L62;
        r129.setOnClickListener(new g(this, r127));
    L62:
        View r130 = this.f112146g;
        if (r130 == null) goto L69;
        r130.setOnClickListener(new h(this));
        return;
    L69:
        return;
    L24:
        r121 = false;
        goto L25
    L16:
        r119 = false;
        goto L17
    }

    public final void U90(String r100, Function2<? super String, ? super Drawable, Unit> r101, Function1<? super String, Unit> r102) {
        com.bytedance.android.livesdk.chatroom.utils.a1.l(new ImageModel(null, CollectionsKt.listOf(r100)), 0, 0, true, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r101, r100), new c(r102, r100));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        n6 r103 = this.f112150k;
        if (r103 == null) goto L5;
        r103.C9(r100, r101, r102);
    L5:
        super.onActivityResult(r100, r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_introduction_edit_layout, r101, false);
        this.f112147h = r103;
        View r104 = null;
        if (r103 == null) goto L5;
        EditText r105 = (EditText) r103.findViewById(R.id.introduction_edit);
    L6:
        this.f112145f = r105;
        View r106 = this.f112147h;
        if (r106 == null) goto L9;
        View r107 = r106.findViewById(R.id.add_pic);
    L10:
        this.f112146g = r107;
        View r108 = this.f112147h;
        if (r108 == null) goto L13;
        View r109 = r108.findViewById(R.id.finish_introduction_btn);
    L14:
        this.f112143d = r109;
        View r110 = this.f112147h;
        if (r110 == null) goto L17;
        r104 = r110.findViewById(R.id.exit_introduction_edit_btn);
    L17:
        this.f112144e = r104;
        return this.f112147h;
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
