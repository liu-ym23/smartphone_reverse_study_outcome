package com.bytedance.android.livesdk.chatroom.widget.unionlive;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.livesdk.chatroom.ui.r5;
import com.bytedance.android.livesdk.message.model.om;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f119243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f119244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f119245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f119246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final om f119247e;

    public final void a() {
        Window r100 = getWindow();
        if (r100 == null) goto L9;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        if (r101 == null) goto L7;
        r101.y = UtilityKotlinExtentionsKt.i(50);
    L7:
        r100.setAttributes(r100.getAttributes());
        r100.setType(1000);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Disposable r101 = this.f119244b;
        if (r101 == null) goto L26;
        r101.dispose();
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        a();
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.f119246d.dispatchKeyEvent(r100);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        final Map.Entry r101 = null;
        this.f119243a = LayoutInflater.from(this.f119246d).inflate(R.layout.ttlive_union_live_guest_notice_bottom, null, false);
        Window r102 = getWindow();
        if (r102 == null) goto L5;
        r102.requestFeature(1);
        a();
        r102.setDimAmount(0.0f);
        r102.setGravity(80);
        r102.setFlags(32, 32);
        r102.setFlags(262144, 262144);
    L5:
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        View r103 = this.f119243a;
        if (r103 == null) goto L49;
        setContentView(r103);
        this.f119245c = (TextView) findViewById(R.id.tv_desc);
        ImageView r104 = (ImageView) findViewById(R.id.close);
        if (r104 == null) goto L10;
        r104.setOnClickListener(new a(this));
    L10:
        String r105 = this.f119247e.getText();
        Map<String, String> r106 = this.f119247e.E();
        if (r106 == null) goto L13;
        r101 = z0.a(r106);
    L13:
        if (r101 != null) goto L15;
    L27:
        TextView r107 = this.f119245c;
        if (r107 == null) goto L30;
        r107.setText(r105);
    L30:
        int r108 = View.MeasureSpec.makeMeasureSpec(s1.y(), 1073741824);
        int r109 = View.MeasureSpec.makeMeasureSpec(0, 0);
        View r110 = this.f119243a;
        if (r110 == null) goto L33;
        r110.measure(r108, r109);
    L33:
        View r111 = this.f119243a;
        if (r111 == null) goto L36;
        int r112 = r111.getMeasuredHeight();
    L37:
        Window r113 = getWindow();
        if (r113 == null) goto L40;
        r113.setLayout(-1, r112);
    L40:
        Disposable r114 = this.f119244b;
        if (r114 == null) goto L44;
        r114.dispose();
    L44:
        if (this.f119247e.getDuration() <= 0) goto L46;
        long r115 = this.f119247e.getDuration();
    L47:
        this.f119244b = Observable.timer(r115, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    L46:
        r115 = 5;
        goto L47
    L36:
        r112 = -2;
        goto L37
    L15:
        if (r101.getKey() == null) goto L27;
        if (r101.getValue() == null) goto L27;
        String r116 = (String) r101.getKey();
        SpannableStringBuilder r117 = new SpannableStringBuilder(r105).append(r116);
        r117.setSpan(new r5(-65536, new UnionGuestBottomNoticeDialog$initView$clickSpan$1(this, r101)), r117.length() - r116.length(), r117.length(), 33);
        TextView r118 = this.f119245c;
        if (r118 == null) goto L21;
        r118.setHighlightColor(0);
    L21:
        TextView r119 = this.f119245c;
        if (r119 == null) goto L24;
        r119.setMovementMethod(LinkMovementMethod.getInstance());
    L24:
        TextView r120 = this.f119245c;
        if (r120 == null) goto L30;
        r120.setText(r117);
        goto L30
    }

    public c(FragmentActivity r100, om r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "data");
        super(r100, R.style.ttlive_special_comb_dialog);
        this.f119246d = r100;
        this.f119247e = r101;
    }
}
