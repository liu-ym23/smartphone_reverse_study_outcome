package J1;

import H1.e;
import H1.g;
import H1.h;
import H1.i;
import H1.l;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.stepos.common.widget.SwimmingAnimationView;

/* loaded from: classes.dex */
public class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Context f3201a;

    /* renamed from: b, reason: collision with root package name */
    private Window f3202b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3203c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f3204d;

    /* renamed from: e, reason: collision with root package name */
    private int f3205e;

    /* renamed from: f, reason: collision with root package name */
    private float f3206f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f3207g;

    /* renamed from: h, reason: collision with root package name */
    private SwimmingAnimationView f3208h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f3209i;

    /* renamed from: j, reason: collision with root package name */
    private int f3210j;

    public b(Context context) {
        this(context, l.f2376h);
    }

    private void a() {
        this.f3208h = (SwimmingAnimationView) findViewById(h.f2241c);
        this.f3209i = (TextView) findViewById(h.f2239b);
        d();
        c();
    }

    private void c() {
        SwimmingAnimationView swimmingAnimationView = this.f3208h;
        if (swimmingAnimationView == null) {
            return;
        }
        swimmingAnimationView.setVisibility(this.f3210j);
    }

    private void d() {
        if (this.f3209i == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f3204d)) {
            this.f3209i.setVisibility(8);
            return;
        }
        this.f3209i.setVisibility(0);
        this.f3209i.setText(this.f3204d);
        this.f3209i.setTextColor(this.f3201a.getResources().getColor(e.f2081c));
    }

    public void b(CharSequence charSequence) {
        this.f3204d = charSequence;
        d();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        this.f3202b = window;
        if (window != null) {
            window.requestFeature(1);
            this.f3202b.setDimAmount(this.f3206f);
            this.f3202b.setBackgroundDrawable(this.f3207g);
            this.f3202b.getDecorView().setSystemUiVisibility(8192);
            try {
                WindowManager.LayoutParams attributes = this.f3202b.getAttributes();
                N1.h.b(attributes).b("statusBarColor").d(attributes, -16777216);
                this.f3202b.setAttributes(attributes);
            } catch (Exception e6) {
                Log.w("LoadingDialog", "statusBarColor set failed, " + e6.getMessage());
            }
        }
        setContentView(i.f2310a);
        a();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Log.d("LoadingDialog", "onStart");
        this.f3208h.g();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        Log.d("LoadingDialog", "onStop");
        this.f3208h.h();
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z5) {
        super.setCancelable(z5);
        this.f3203c = z5;
    }

    public b(Context context, int i5) {
        super(context, i5);
        this.f3203c = true;
        this.f3205e = -16777216;
        this.f3206f = 0.2f;
        this.f3210j = 0;
        Context context2 = getContext();
        this.f3201a = context2;
        this.f3207g = context2.getResources().getDrawable(g.f2190f);
    }
}
