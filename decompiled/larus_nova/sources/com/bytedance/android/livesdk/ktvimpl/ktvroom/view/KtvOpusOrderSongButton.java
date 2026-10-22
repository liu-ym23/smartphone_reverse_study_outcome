package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvOpusOrderSongButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setMCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "mCompositeDisposable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvOpusOrderSongButton extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f144944f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f144945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f144946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f144947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public KtvContext f144948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f144949e;

    public static final class a {
    }

    static {
    }

    public final boolean S5() {
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r100 = KtvModeOrderSongDataContext.Companion.e();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hasNewKtvDress() != true) goto L7;
        return true;
    }

    public final void R5() {
        int r100 = 0;
        if (S5() == false) goto L8;
        View r101 = this.f144947c;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L7:
        r101.setVisibility(0);
    L12:
        KtvContext r102 = this.f144948d;
        if (r102 == null) goto L15;
        r100 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(r102);
    L15:
        U5(r100);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r103 = com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l;
        View r104 = this.f144947c;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L18:
        r103.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(r104);
        return;
    L8:
        View r105 = this.f144947c;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L11:
        r105.setVisibility(8);
        goto L12
    }

    public final CompositeDisposable getMCompositeDisposable() {
        return this.f144949e;
    }

    public final void U5(int r100) {
        if (S5() == false) goto L10;
        TextView r101 = this.f144946b;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L7:
        r101.setVisibility(8);
        return;
    L10:
        if (r100 <= 0) goto L21;
        String r102 = String.valueOf(r100);
        if (r100 <= 99) goto L14;
        r102 = "99+";
    L14:
        TextView r103 = this.f144946b;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L17:
        r103.setVisibility(0);
        TextView r104 = this.f144946b;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L20:
        r104.setText(r102);
    L28:
        TextView r105 = this.f144946b;
        if (r105 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L31:
        if (r105 == null) goto L33;
        r105.setClickable(false);
    L33:
        TextView r106 = this.f144945a;
        if (r106 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L36:
        r3.a(r106, "点歌" + r100 + 39318);
        TextView r107 = this.f144946b;
        if (r107 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L39:
        r3.a(r107, "点歌" + r100 + 39318);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r108 = com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l;
        TextView r109 = this.f144946b;
        if (r109 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L42:
        r108.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(r109);
        return;
    L21:
        TextView r110 = this.f144946b;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L24:
        r110.setText("0");
        TextView r111 = this.f144946b;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L27:
        r111.setVisibility(8);
        goto L28
    }

    public final void setMCompositeDisposable(CompositeDisposable r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f144949e = r100;
    }

    public KtvOpusOrderSongButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f144949e = new CompositeDisposable();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_ktv_opus_order_button, this);
        this.f144945a = (TextView) findViewById(R.id.ktv_mv_order_song_btn);
        this.f144946b = (TextView) findViewById(R.id.ktv_mv_song_num);
        this.f144947c = findViewById(R.id.ktv_dress_yellow_dot);
    }

    public final void T5(final KtvContext r100, KtvRoomInteractViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER);
        Intrinsics.checkNotNullParameter(r101, "vm");
        if (this.f144949e.isDisposed() == false) goto L5;
        this.f144949e = new CompositeDisposable();
    L5:
        this.f144948d = r100;
        TextView r102 = this.f144945a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L8:
        r102.setOnClickListener(x0.a(new KtvOpusOrderSongButton$initFunction$1(this, r100)));
        R5();
    }
}
