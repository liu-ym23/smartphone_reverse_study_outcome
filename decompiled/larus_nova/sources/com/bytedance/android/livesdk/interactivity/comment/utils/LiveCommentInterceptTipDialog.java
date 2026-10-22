package com.bytedance.android.livesdk.interactivity.comment.utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/utils/LiveCommentInterceptTipDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommentInterceptTipDialog extends DialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f136250d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCommentInterceptTipDialog f136251a;

        public a(LiveCommentInterceptTipDialog r100) {
            this.f136251a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f136251a.dismiss();     // Catch: Exception -> L5
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

    public LiveCommentInterceptTipDialog() {
        this.f136250d = "";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = getView();
        Button r103 = null;
        if (r102 == null) goto L5;
        TextView r104 = (TextView) r102.findViewById(R.id.tip_content);
    L6:
        if (r104 == null) goto L8;
        r104.setText("通过jsb:" + this.f136250d + "调用直播发评能力进行快捷发评时，该jsb请求缺失有效request_source参数，请联系zhangwen.wendyys或zhaofei.hym");
    L8:
        View r105 = getView();
        if (r105 == null) goto L11;
        r103 = (Button) r105.findViewById(R.id.cancel);
    L11:
        if (r103 == null) goto L14;
        r103.setOnClickListener(new a(this));
        return;
    L14:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_comment_intercept_tip_dialog, null, false);
    }
}
