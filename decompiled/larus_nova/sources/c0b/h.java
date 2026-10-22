package c0b;

import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f21976b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f21977a;

        public a(View r100) {
            this.f21977a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((TextView) this.f21977a.findViewById(R.id.tips_bar)).setText("");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(JCameraViewV2 r100, View r101) {
        this.f21975a = r100;
        this.f21976b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        JCameraViewV2 r101 = this.f21975a;
        d0b.d r102 = r101.f410896c;
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.b(r101.f410917x));
    L7:
        if (r103 != null) goto L9;
    L11:
        ((TextView) this.f21976b.findViewById(R.id.tips_bar)).setText(UIUtils.getString(this.f21975a.f410894a, R.string.Lark_IM_SavePhotoFail_Toast));
    L12:
        this.f21975a.postDelayed(new a(this.f21976b), 2000);
        return;
    L9:
        if (r103.booleanValue() == false) goto L11;
        ((TextView) this.f21976b.findViewById(R.id.tips_bar)).setText(UIUtils.getString(this.f21975a.f410894a, R.string.Lark_Legacy_SavedToast));
        goto L12
    L5:
        r103 = null;
        goto L7
    }
}
