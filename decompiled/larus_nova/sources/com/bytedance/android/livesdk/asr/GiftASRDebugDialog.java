package com.bytedance.android.livesdk.asr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/asr/GiftASRDebugDialog;", "Landroidx/fragment/app/DialogFragment;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftASRDebugDialog extends DialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f103939h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f103940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f103941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f103942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ButtonStatus f103943g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftASRDebugDialog f103944a;

        public a(GiftASRDebugDialog r100) {
            this.f103944a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f103944a.getClass();     // Catch: Exception -> L5
            throw null;     // Catch: Exception -> L5
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public final void S90() {
        TextView r100 = this.f103941e;
        if (r100 == null) goto L6;
        r100.setText(this.f103943g.getButtonText());
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f103942f;
        TextView r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.findViewById(R.id.close_container);
    L6:
        this.f103940d = r104;
        View r105 = this.f103942f;
        if (r105 == null) goto L9;
        r103 = (TextView) r105.findViewById(R.id.record_button);
    L9:
        this.f103941e = r103;
        View r106 = this.f103942f;
        if (r106 == null) goto L12;
        TextView r107 = (TextView) r106.findViewById(R.id.content_area);
    L12:
        View r108 = this.f103940d;
        if (r108 == null) goto L15;
        r108.setOnClickListener(new a(this));
    L15:
        S90();
        TextView r109 = this.f103941e;
        if (r109 == null) goto L19;
        r109.setOnClickListener(new com.bytedance.android.livesdk.asr.a(this));
        return;
    L19:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_gift_asr_debug_view, r101, false);
        this.f103942f = r103;
        return r103;
    }
}
