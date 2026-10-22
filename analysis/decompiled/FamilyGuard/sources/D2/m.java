package D2;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.stepos.familyguard.R;

/* loaded from: classes.dex */
public class m implements z<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f1192a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f1193b;

    public m(ImageView imageView, boolean z5) {
        this.f1192a = imageView;
        this.f1193b = z5;
    }

    @Override // D2.z
    public void b() {
        Application applicationA = P1.a.a();
        Drawable drawableF = androidx.core.content.res.h.f(applicationA.getResources(), R.drawable.us_ic_default_app, applicationA.getTheme());
        if (this.f1193b) {
            this.f1192a.setBackground(drawableF);
        } else {
            this.f1192a.setImageDrawable(drawableF);
        }
    }

    @Override // D2.z
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Drawable drawable) {
        if (drawable == null) {
            Application applicationA = P1.a.a();
            drawable = androidx.core.content.res.h.f(applicationA.getResources(), R.drawable.us_ic_default_app, applicationA.getTheme());
        }
        if (this.f1193b) {
            this.f1192a.setBackground(drawable);
        } else {
            this.f1192a.setImageDrawable(drawable);
        }
    }
}
