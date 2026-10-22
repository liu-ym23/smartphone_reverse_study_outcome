package qa;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedanceos.common.toolbox.i;
import com.obric.appstore.autoupdate.R$id;
import com.obric.appstore.autoupdate.R$layout;
import com.obric.appstore.autoupdate.R$string;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f23614h = "UpdateProgressDialog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f23615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f23618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f23619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OProgressView f23620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OInsetSheet f23621g;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f23622a;

        public a(g r10) {
            this.f23622a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            f.e().k(g.a(this.f23622a), g.b(this.f23622a));
            g.c(this.f23622a).removeCallbacksAndMessages(null);
            this.f23622a.h();
            if (g.d(this.f23622a) != 2) goto L6;
            Process.killProcess(Process.myPid());
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f23623a;

        public b(g r10) {
            this.f23623a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f23623a.n();
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f23624a;

        public c(g r10) {
            this.f23624a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what != 297) goto L12;
            int r11 = f.e().d(g.a(this.f23624a), g.b(this.f23624a));
            if (r11 >= 0) goto L8;
            i.a(g.e(), "appstore progress: -1" + g.b(this.f23624a));
            return;
        L8:
            if (r11 != 100) goto L10;
            i.a(g.e(), "appstore progress:" + r11);
            g.f(this.f23624a, r11);
            this.f23624a.h();
            return;
        L10:
            g.f(this.f23624a, r11);
            sendEmptyMessageDelayed(297, 300);
            return;
        }

        public /* synthetic */ c(g r10, a r11) {
            this(r10);
        }
    }

    static {
    }

    public g(Context r10, String r11, int r12) {
        this.f23615a = r10;
        this.f23616b = r11;
        this.f23617c = r12;
        this.f23618d = new c(this, null);
        this.f23621g = new OInsetSheet(r10);
        l();
    }

    public static /* synthetic */ Context a(g r10) {
        return r10.f23615a;
    }

    public static /* synthetic */ String b(g r10) {
        return r10.f23616b;
    }

    public static /* synthetic */ c c(g r10) {
        return r10.f23618d;
    }

    public static /* synthetic */ int d(g r10) {
        return r10.f23617c;
    }

    public static /* synthetic */ String e() {
        return f23614h;
    }

    public static /* synthetic */ void f(g r10, int r11) {
        r10.m(r11);
    }

    public final void g() {
        OInsetSheet r10 = this.f23621g;     // Catch: Exception -> L6
        if (r10 == null) goto L9;
        r10.dismiss();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public void h() {
        g();
        this.f23618d.removeMessages(297);
    }

    public final View i() {
        View r10 = LayoutInflater.from(this.f23615a).inflate(R$layout.obric_auto_downloading, null);
        this.f23619e = (TextView) r10.findViewById(R$id.auto_downloading_percent);
        this.f23620f = (OProgressView) r10.findViewById(R$id.auto_progressbar);
        m(0);
        return r10;
    }

    public final View j() {
        OSelectionPanelBtnView r10 = new OSelectionPanelBtnView(this.f23615a);
        r10.getBtnPositive().setVisibility(8);
        r10.getHorizontal_space().setVisibility(8);
        r10.getBtnNegative().setText(R.string.cancel);
        r10.getBtnNegative().setOnClickListener(new a(this));
        return r10;
    }

    public final View k() {
        OInsetSheetTitleBar r10 = new OInsetSheetTitleBar(this.f23615a);
        r10.setShowLeftBack(false);
        r10.setTitleText(this.f23615a.getString(R$string.auto_progress_title));
        r10.c();
        return r10;
    }

    public void l() {
        this.f23621g.A(OInsetSheet.PanelWidth.BOARD_WIDTH);
        this.f23621g.w(k());
        this.f23621g.r(i());
        this.f23621g.u(j());
        this.f23621g.q(false);
        this.f23621g.setCanceledOnTouchOutside(true);
        this.f23621g.setCancelable(false);
    }

    public final void m(int r10) {
        TextView r11 = this.f23619e;
        if (r11 == null) goto L5;
        r11.setText(String.format("%d%%", new Object[]{Integer.valueOf(r10)}));
    L5:
        OProgressView r12 = this.f23620f;
        if (r12 == null) goto L9;
        r12.setProgress(r10);
        return;
    }

    public void n() {
    L5:
        e = move-exception;
        i.c(f23614h, "show: ", e);
    L10:
        this.f23618d.sendEmptyMessageDelayed(297, 300);
        return;
    L3:
        if ((this.f23615a instanceof Activity) == true) goto L7;
        this.f23621g.getWindow().setType(2038);     // Catch: Exception -> L5
    L7:
        this.f23621g.show();     // Catch: Exception -> L5
        goto L10
    }

    public void o(long r10) {
        if (r10 > 0) goto L6;
        n();
        return;
    L6:
        this.f23618d.postDelayed(new b(this), r10);
    }
}
