package a0b;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.qrcode.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements com.ss.android.lark.media.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f1349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Scene f1350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f1351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f1352d;

    public interface a {
        void a(MediaMutex.LockError r100);

        void onSuccess();
    }

    public interface b {
    }

    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f1353a = null;

        static {
            f1353a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    static {
        f1349a = new h();
    }

    public h() {
    }

    @JvmStatic
    public static final void e() {
        Log.i("MediaResourceController", "releaseResourceIfNeed");
        f1351c = null;
        f1352d = null;
        Scene r100 = f1350b;
        if (r100 == null) goto L6;
        MediaMutex r101 = MediaMutex.f431631r;
        MediaMutex.f431631r.n(r100, f1349a);
        f1350b = null;
        return;
    }

    @Override // com.ss.android.lark.media.a
    public final void onSuccess() {
        Log.i("MediaResourceController", "apply resource success");
        a r100 = f1351c;
        if (r100 == null) goto L6;
        r100.onSuccess();
        return;
    }

    @Override // com.ss.android.lark.media.a
    public final void a(MediaMutex.LockError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Log.e("MediaResourceController", "apply resource error:" + r100);
        a r101 = f1351c;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        e();
    }

    @JvmStatic
    public static final void f(Context r100, MediaMutex.LockError r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "error");
        Log.i("MediaResourceController", "showConfirmDialog, error:" + r101);
        UDDialog r102 = new UDDialogBuilder(r100).title(r101.getErrorMessage()).cancelable(true).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_PickerConfirm, c.f1353a).build();
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }

    @Override // com.ss.android.lark.media.a
    public final void b(Scene r100, MediaType r101) {
        Intrinsics.checkNotNullParameter(r100, "byScene");
        Intrinsics.checkNotNullParameter(r101, "type");
        Log.i("MediaResourceController", "mediaResourceWasInterrupted, byScene:" + r100.getValue() + ", type:" + r101.getValue() + ", interruptMsg:");
        b r102 = f1352d;
        if (r102 == null) goto L12;
        n r103 = (n) r102;
        FragmentActivity r104 = r103.f439083a.f439086b;
        if (r104 != null) goto L7;
        return;
    L7:
        if (r104.isDestroyed() == false) goto L9;
        return;
    L9:
        if (r103.f439083a.f439086b.isFinishing() == true) goto L15;
        r103.f439083a.f439086b.finish();
        return;
    L15:
        return;
    }

    @Override // com.ss.android.lark.media.a
    public final void c(Scene r100, MediaType r101) {
        Intrinsics.checkNotNullParameter(r100, "fromScene");
        Intrinsics.checkNotNullParameter(r101, "type");
        Log.i("MediaResourceController", "mediaResourceInterruptionEnd, fromScene:" + r100.getValue() + ", type:" + r101.getValue());
        if (f1352d == null) goto L6;
        Log.i("QRCodeScanPresenter", "injectInterruptCallback onEnd");
        return;
    }

    @JvmStatic
    public static final void d(Scene r100, boolean r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "callback");
        e();
        Log.i("MediaResourceController", "applyResource, scene:" + r100 + ", mixWithOthers:" + r101);
        f1350b = r100;
        f1351c = r102;
        MediaMutex.f431631r.l(r100, r101, f1349a, true);
    }
}
