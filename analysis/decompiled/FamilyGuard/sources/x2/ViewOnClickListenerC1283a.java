package x2;

import N1.h;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stepos.familyguard.R;
import java.lang.reflect.InvocationTargetException;
import stepos.support.v7.widget.r;

/* renamed from: x2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1283a extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f23785a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f23786b;

    /* renamed from: c, reason: collision with root package name */
    private MenuItem f23787c;

    /* renamed from: d, reason: collision with root package name */
    private Context f23788d;

    /* renamed from: e, reason: collision with root package name */
    private r f23789e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23790f;

    /* renamed from: g, reason: collision with root package name */
    private RotateAnimation f23791g;

    /* renamed from: h, reason: collision with root package name */
    private RotateAnimation f23792h;

    /* renamed from: i, reason: collision with root package name */
    private int f23793i;

    /* renamed from: j, reason: collision with root package name */
    private d f23794j;

    /* renamed from: x2.a$a, reason: collision with other inner class name */
    class AnimationAnimationListenerC0258a implements Animation.AnimationListener {
        AnimationAnimationListenerC0258a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ViewOnClickListenerC1283a.this.f23794j.onMenuItemClick(ViewOnClickListenerC1283a.this.f23787c);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: x2.a$b */
    class b implements r.a {
        b() {
        }

        @Override // stepos.support.v7.widget.r.a
        public void a(r rVar) {
            ViewOnClickListenerC1283a.this.f23790f = false;
            ViewOnClickListenerC1283a.this.f23785a.startAnimation(ViewOnClickListenerC1283a.this.f23792h);
        }
    }

    /* renamed from: x2.a$c */
    class c implements r.b {
        c() {
        }

        @Override // stepos.support.v7.widget.r.b
        public boolean onMenuItemClick(MenuItem menuItem) {
            ViewOnClickListenerC1283a.this.f23787c = menuItem;
            return true;
        }
    }

    /* renamed from: x2.a$d */
    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ViewOnClickListenerC1283a(Context context, int i5) {
        super(context);
        g(context, i5);
    }

    private void g(Context context, int i5) {
        this.f23788d = context;
        this.f23793i = i5;
        View viewInflate = View.inflate(context, R.layout.us_actionbar_view_unfold, this);
        this.f23785a = (ImageView) viewInflate.findViewById(R.id.arrow);
        this.f23786b = (TextView) viewInflate.findViewById(R.id.title);
        i();
        h();
        setOnClickListener(this);
    }

    private void h() {
        this.f23791g = j(true);
        RotateAnimation rotateAnimationJ = j(false);
        this.f23792h = rotateAnimationJ;
        rotateAnimationJ.setAnimationListener(new AnimationAnimationListenerC0258a());
    }

    private void i() {
        Context context = this.f23788d;
        r rVar = new r(context, ((stepos.support.v7.app.d) context).findViewById(R.id.action_bar), 8388613);
        this.f23789e = rVar;
        rVar.g().inflate(this.f23793i, this.f23789e.f());
        this.f23789e.i(new b());
        this.f23789e.j(new c());
    }

    private RotateAnimation j(boolean z5) {
        RotateAnimation rotateAnimation = z5 ? new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f) : new RotateAnimation(180.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(330L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f));
        return rotateAnimation;
    }

    public Menu getMenu() {
        return this.f23789e.f();
    }

    public void k() {
        this.f23789e.e();
        this.f23791g.cancel();
        this.f23792h.cancel();
        try {
            Object obj = h.a(RelativeLayout.class).b("mGraph").get(this);
            h.a(obj.getClass()).a("clear", new Class[0]).a(obj, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f23790f) {
            return;
        }
        this.f23785a.startAnimation(this.f23791g);
        this.f23789e.k();
        this.f23790f = true;
    }

    public void setCurrentMenuItem(MenuItem menuItem) {
        this.f23787c = menuItem;
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.f23794j = dVar;
    }

    public void setTitle(String str) {
        this.f23786b.setText(str);
    }
}
