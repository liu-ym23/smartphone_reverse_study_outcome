package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r6, r7);
            this.gravity = 0;
            TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.ActionBarLayout);
            this.gravity = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.ActionBarLayout_android_layout_gravity, "styleable", "ActionBarLayout_android_layout_gravity"), 0);
            r8.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2);
            this.gravity = 0;
            this.gravity = r3;
        }

        public LayoutParams(int r3) {
            this(-2, -1, r3);
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.gravity = 0;
            this.gravity = r2.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }
    }

    public interface a {
        void a(boolean r1);
    }

    @Deprecated
    public interface b {
        boolean a(int r1, long r2);
    }

    @Deprecated
    public static abstract class c {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();

        public c() {
        }
    }

    public abstract int a();

    public androidx.appcompat.view.b a(androidx.appcompat.view.b.a r2) {
        androidx.appcompat.view.b.a r1 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r2, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
        return null;
    }

    public void a(int r1) {
    }

    public void a(Configuration r1) {
    }

    public void a(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public void a(boolean r1) {
    }

    public boolean a(int r1, KeyEvent r2) {
        return false;
    }

    public boolean a(KeyEvent r1) {
        return false;
    }

    public Context b() {
        return null;
    }

    public void c(boolean r1) {
    }

    public boolean c() {
        return false;
    }

    public void d(boolean r1) {
    }

    public boolean d() {
        return false;
    }

    public void e(boolean r1) {
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    void g() {
    }

    public ActionBar() {
    }

    public void b(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void a(float r1) {
        if (r1 != 0.0f) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
}
