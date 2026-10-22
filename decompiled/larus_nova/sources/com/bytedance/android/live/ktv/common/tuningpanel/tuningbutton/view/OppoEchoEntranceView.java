package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/OppoEchoEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OppoEchoEntranceView extends ConstraintLayout implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f70472e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f70473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f70474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleRegistry f70475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f70476d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f70477a;

        public a(Function0 r100) {
            this.f70477a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f70477a.invoke();
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OppoEchoEntranceView f70478a;

        public b(OppoEchoEntranceView r100) {
            this.f70478a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            OppoEchoEntranceView r102 = this.f70478a;
            int r103 = OppoEchoEntranceView.f70472e;
            r102.S5();
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final void S5() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f70476d;
        if (r100 != null) goto L5;
    L11:
        setVisibility(8);
        return;
    L5:
        if (r100.h() != true) goto L11;
        if (Intrinsics.areEqual(this.f70476d.I(), Boolean.TRUE) == false) goto L9;
    L10:
        setVisibility(0);
        return;
    L9:
        if (this.f70476d.Z() != true) goto L11;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f70475c.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f70475c.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.f70475c;
    }

    public final void R5(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "goIntroPageCallback");
        String r101 = getContext().getString(R.string.ttlive_go_echo_setting_dialog_tips);
        SpannableString r102 = new SpannableString(r101);
        r102.setSpan(new UnderlineSpan(), 0, r101.length(), 0);
        this.f70474b.setText(r102);
        this.f70474b.setOnClickListener(new a(r100));
        this.f70473a.setText(getContext().getString(R.string.ttlive_ktv_echo));
        S5();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = this.f70476d;
        if (r103 == null) goto L6;
        r103.t(this, new b(this));
        return;
    }

    public OppoEchoEntranceView(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f70476d = r100;
        LifecycleRegistry r102 = new LifecycleRegistry(this);
        this.f70475c = r102;
        r102.setCurrentState(Lifecycle.State.CREATED);
        LayoutInflater.from(r101).inflate(R.layout.ttlive_ktv_oppo_echo_entrance_item_layout, this).setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        this.f70473a = (TextView) findViewById(R.id.entrance_title);
        this.f70474b = (TextView) findViewById(R.id.entrance_content);
    }
}
