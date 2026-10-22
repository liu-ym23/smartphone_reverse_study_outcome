package com.bytedance.android.live.core.verify.fragment;

import am2.x;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widget.e1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import u80.a;
import u80.b;
import u80.h;
import u80.i;

/* JADX INFO: loaded from: classes45.dex */
public class CommonVerifyFragment extends BaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f66435k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EditText f66436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EditText f66437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f66438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e1 f66439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f66440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f66441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f66442j;

    public final void U90() {
        e1 r100 = this.f66439g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L27;
        e1 r101 = this.f66439g;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L16:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }

    public CommonVerifyFragment() {
    }

    public static void T90(CommonVerifyFragment r100) {
        View r101 = r100.f66438f;
        if (TextUtils.isEmpty(r100.f66437e.getText().toString()) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        r101.setEnabled(r102);
        return;
    L5:
        if (TextUtils.isEmpty(r100.f66436d.getText().toString()) == true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (getArguments() == null) goto L6;
        this.f66440h = getArguments().getString("KEY_REQUEST_PAGE");
        this.f66441i = getArguments().getString("popup_source");
        this.f66442j = getArguments().getString("enter_from");
        return;
    }

    public static void S90(CommonVerifyFragment r100, Throwable r110) {
        r100.U90();
        HashMap r101 = new HashMap();
        r101.put("request_page", r100.f66440h);
        r101.put("popup_source", r100.f66441i);
        if ((r110 instanceof ApiServerException) == false) goto L13;
        int r102 = ((ApiServerException) r110).getErrorCode();
        if (r102 != 20072) goto L8;
        r101.put("fail_reason", "already certified");
        goto L13
    L8:
        if (r102 != 20087) goto L11;
        r101.put("fail_reason", "invalid id card");
        goto L13
    L11:
        if (r102 != 20088) goto L13;
        r101.put("fail_reason", "mismatching");
    L13:
        u.l().sendLog("livesdk_live_name_certification_fail_show", r101, new Object[]{x.class, Room.class});
        if ((r110 instanceof ApiException) == true) goto L16;
        return;
    L16:
        if (((ApiException) r110).getErrorCode() != 20048) goto L20;
        HashMap r111 = new HashMap();
        r111.put("request_page", r100.f66440h);
        r111.put("popup_source", r100.f66441i);
        r111.put("result", "juveniles");
        u.l().sendLog("livesdk_user_identification_result", r111, new Object[]{x.class, Room.class});
        if (r100.getActivity() == null) goto L23;
        Intent r112 = new Intent();
        r112.putExtra("key_verify_result", 2);
        r100.getActivity().setResult(0, r112);
        r100.getActivity().finish();
        return;
    L23:
        return;
    L20:
        ExceptionUtils.handleException(r100.getContext(), r110);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.ttlive_fragment_common_verify, r101, false);
        r103.findViewById(R.id.back_btn).setOnClickListener(new a(this));
        this.f66436d = (EditText) r103.findViewById(R.id.cloud_name_edt);
        this.f66437e = (EditText) r103.findViewById(R.id.cloud_id_edt);
        this.f66436d.addTextChangedListener(new h(this));
        this.f66437e.addTextChangedListener(new i(this));
        View r104 = r103.findViewById(R.id.cloud_submit);
        this.f66438f = r104;
        r104.setOnClickListener(new b(this));
        HashMap r105 = new HashMap();
        r105.put("request_page", this.f66440h);
        u.l().sendLog("livesdk_live_name_certification_page_show", r105, new Object[]{x.class, Room.class});
        return r103;
    }
}
