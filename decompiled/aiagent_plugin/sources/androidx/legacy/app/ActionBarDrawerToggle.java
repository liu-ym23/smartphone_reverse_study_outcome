package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.c {
    private static final String TAG = "ActionBarDrawerToggle";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1909b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Activity f1910a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f1911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SlideDrawable f1913e;
    private final int f;
    private final int g;
    private b h;

    private class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final /* synthetic */ ActionBarDrawerToggle this$0;

        SlideDrawable(ActionBarDrawerToggle r2, Drawable r3) {
            this.this$0 = r2;
            boolean r4 = false;
            super(r3, 0);
            if (Build.VERSION.SDK_INT <= 18) goto L5;
            r4 = true;
        L5:
            this.mHasMirroring = r4;
            this.mTmpRect = new Rect();
        }

        public void setPosition(float r1) {
            this.mPosition = r1;
            invalidateSelf();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float r1) {
            this.mOffset = r1;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas r6) {
            copyBounds(this.mTmpRect);
            r6.save();
            int r1 = 1;
            if (ViewCompat.i(ZeusTransformUtils.getWindow(this.this$0.f1910a, "com.obric.aiagent.plugin").getDecorView()) != 1) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            r1 = -1;
        L8:
            float r2 = this.mTmpRect.width();
            r6.translate((((-this.mOffset) * r2) * this.mPosition) * r1, 0.0f);
            if (r0 == true) goto L11;
        L13:
            super.draw(r6);
            r6.restore();
            return;
        L11:
            if (this.mHasMirroring == true) goto L13;
            r6.translate(r2, 0.0f);
            r6.scale(-1.0f, 1.0f);
            goto L13
        L5:
            r0 = false;
            goto L6
        }
    }

    @Deprecated
    public interface a {
        void a(int r1);
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Method f1914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Method f1915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f1916c;

        b(Activity r8) {
            Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
            this.f1914a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.f1915b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r10 = r9.findViewById(R.id.home);
            if (r10 != null) goto L8;
            return;
        L8:
            ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
            if (r11.getChildCount() == 2) goto L11;
            return;
        L11:
            View r0 = r11.getChildAt(0);
            View r12 = r11.getChildAt(1);
            if (r0.getId() != 16908332) goto L15;
            r0 = r12;
        L15:
            if (ZeusTransformUtils.instanceOf(r0, ImageView.class) == false) goto L20;
            this.f1916c = (ImageView) ZeusTransformUtils.preCheckCast(r0, ImageView.class, "com.obric.aiagent.plugin");
            return;
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void a(int r1) {
    }

    static {
        f1909b = new int[]{R.attr.homeAsUpIndicator};
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void a(View r4, float r5) {
        float r6 = this.f1913e.getPosition();
        if (r5 <= 0.5f) goto L5;
        float r7 = Math.max(r6, Math.max(0.0f, r5 - 0.5f) * 2.0f);
    L6:
        this.f1913e.setPosition(r7);
        return;
    L5:
        r7 = Math.min(r6, r5 * 2.0f);
        goto L6
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void a(View r2) {
        this.f1913e.setPosition(1.0f);
        if (this.f1912d == false) goto L6;
        b(this.g);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.c
    public void b(View r2) {
        this.f1913e.setPosition(0.0f);
        if (this.f1912d == false) goto L6;
        b(this.f);
        return;
    }

    private void b(int r4) {
        a r0 = this.f1911c;
        if (r0 == null) goto L7;
        r0.a(r4);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L12;
        ActionBar r3 = this.f1910a.getActionBar();
        if (r3 == null) goto L23;
        r3.setHomeActionContentDescription(r4);
        return;
    L23:
        return;
    L12:
        if (this.h != null) goto L15;
        this.h = new b(this.f1910a);
    L15:
        if (this.h.f1914a == null) goto L25;
        ActionBar r1 = this.f1910a.getActionBar();     // Catch: Exception -> L18
        this.h.f1915b.invoke(r1, new Object[]{Integer.valueOf(r4)});     // Catch: Exception -> L18
        r1.setSubtitle(r1.getSubtitle());     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        a(TAG, "Couldn't set content description via JB-MR2 API", e);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
