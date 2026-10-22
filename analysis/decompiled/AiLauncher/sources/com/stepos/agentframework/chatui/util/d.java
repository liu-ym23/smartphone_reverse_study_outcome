package com.stepos.agentframework.chatui.util;

import Y8.t;
import Z8.C1165m;
import Z8.C1173v;
import Z8.M;
import android.R;
import android.app.KeyguardManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import v9.C5685n;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\fJ+\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\fJ=\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J!\u00100\u001a\u0004\u0018\u00010\b2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b2\u00101J\u0019\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u0004\u0018\u000106*\u00020\bH\u0002¢\u0006\u0004\b7\u00108J#\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006092\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010;J\u001f\u0010>\u001a\u00020=2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u000fH\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u001e\u0010S\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010NR&\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e090T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010HR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001e0X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006["}, d2 = {"Lcom/stepos/agentframework/chatui/util/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "messageRes", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "LY8/t;", "n", "(Landroid/content/Context;ILandroid/view/View;)V", "v", "o", "", "repeatable", "forceOverlay", "q", "(Landroid/content/Context;ILandroid/view/View;ZZ)V", "appContext", "", "message", "w", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "anchorVisible", "m", "(Landroid/content/Context;ZZZ)Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", "", "now", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "t", "(Landroid/content/Context;Ljava/lang/CharSequence;)Z", "z", "(Landroid/content/Context;)Landroid/content/Context;", "", "k", "(Landroid/content/Context;)F", M5.e.RESULT_RENDERED, "x", "(Landroid/content/Context;Landroid/content/Context;)V", Parameters.ROOT, "l", "(Landroid/view/View;Landroid/content/Context;)V", "inflateContext", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Ljava/lang/CharSequence;)Landroid/view/View;", Const.INTENT_KEY_UMID, "Landroid/graphics/drawable/Drawable;", "c", "(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "Landroid/widget/ImageView;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;)Landroid/widget/ImageView;", "Lkotlin/Pair;", "y", "(Landroid/content/Context;)Lkotlin/Pair;", "useKeyguardDialog", "Landroid/view/WindowManager$LayoutParams;", "f", "(Landroid/content/Context;Z)Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager;", "wm", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/WindowManager;)V", "", "TAG", "Ljava/lang/String;", "DURATION_MS", "J", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/ref/WeakReference;", "currentViewRef", "Ljava/lang/ref/WeakReference;", "Ljava/lang/Runnable;", "removeRunnable", "Ljava/lang/Runnable;", "Landroid/widget/Toast;", "systemToastRef", "", "SYSTEM_TOAST_QUOTA", "Ljava/util/List;", "QUOTA_MAX_WINDOW_MS", "LZ8/m;", "systemToastTimes", "LZ8/m;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {
    private static final long DURATION_MS = 2000;
    private static final long QUOTA_MAX_WINDOW_MS;
    private static final List<Pair<Integer, Long>> SYSTEM_TOAST_QUOTA;
    private static final String TAG = "KeyguardAwareToast";
    private static WeakReference<View> currentViewRef;
    private static Runnable removeRunnable;
    private static WeakReference<Toast> systemToastRef;
    private static final C1165m<Long> systemToastTimes;
    public static final d INSTANCE = new d();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    static {
        List<Pair<Integer, Long>> listP = C1173v.p(Y8.j.a(3, 20000L), Y8.j.a(5, 42000L), Y8.j.a(6, 68000L));
        SYSTEM_TOAST_QUOTA = listP;
        Iterator<T> it = listP.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        long jLongValue = ((Number) ((Pair) it.next()).f()).longValue();
        while (it.hasNext()) {
            long jLongValue2 = ((Number) ((Pair) it.next()).f()).longValue();
            if (jLongValue < jLongValue2) {
                jLongValue = jLongValue2;
            }
        }
        QUOTA_MAX_WINDOW_MS = jLongValue;
        systemToastTimes = new C1165m<>();
    }

    public static final int e(float f10, float f11) {
        return (int) (f11 * f10);
    }

    public static /* synthetic */ void p(d dVar, Context context, int i10, View view, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            view = null;
        }
        dVar.o(context, i10, view);
    }

    public static /* synthetic */ void r(d dVar, Context context, int i10, View view, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        dVar.q(context, i10, view, z10, z11);
    }

    public static final void s(Context context, int i10, WeakReference weakReference, boolean z10, boolean z11) {
        View view;
        String string = context.getString(i10);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        boolean z12 = true;
        if (weakReference != null && (view = (View) weakReference.get()) != null && (!view.isShown() || view.getWindowVisibility() != 0)) {
            z12 = false;
        }
        d dVar = INSTANCE;
        kotlin.jvm.internal.p.f(context);
        if (dVar.m(context, z12, z10, z11) && dVar.t(context, string)) {
            return;
        }
        dVar.w(context, string);
    }

    public static final void u(WindowManager windowManager) {
        INSTANCE.g(windowManager);
    }

    public final boolean A() {
        int i10;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        j(jElapsedRealtime);
        List<Pair<Integer, Long>> list = SYSTEM_TOAST_QUOTA;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int iIntValue = ((Number) pair.a()).intValue();
            long jLongValue = ((Number) pair.b()).longValue();
            C1165m<Long> c1165m = systemToastTimes;
            if (c1165m == null || !c1165m.isEmpty()) {
                Iterator<Long> it2 = c1165m.iterator();
                i10 = 0;
                while (it2.hasNext()) {
                    if (jElapsedRealtime - it2.next().longValue() <= jLongValue && (i10 = i10 + 1) < 0) {
                        C1173v.v();
                    }
                }
            } else {
                i10 = 0;
            }
            if (i10 >= iIntValue) {
                return true;
            }
        }
        return false;
    }

    public final Drawable c(Context appContext) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(appContext.getPackageManager().getApplicationIcon(appContext.getApplicationInfo()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "getApplicationIcon failed", thE, false, 8, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (Drawable) objB;
    }

    public final View d(Context appContext, CharSequence message) {
        DisplayMetrics displayMetrics = appContext.getResources().getDisplayMetrics();
        float f10 = displayMetrics.density;
        C4148a.k(TAG, "use fallback chip", false, 4, null);
        TextView textView = new TextView(appContext);
        textView.setText(message);
        textView.setTextColor(-1);
        textView.setTextSize(2, 14.0f);
        textView.setPadding(e(f10, 20.0f), e(f10, 12.0f), e(f10, 20.0f), e(f10, 12.0f));
        textView.setMaxWidth(displayMetrics.widthPixels - e(f10, 48.0f));
        Drawable drawableC = INSTANCE.c(appContext);
        if (drawableC != null) {
            drawableC.setBounds(0, 0, e(f10, 24.0f), e(f10, 24.0f));
            textView.setCompoundDrawablesRelative(drawableC, null, null, null);
            textView.setCompoundDrawablePadding(e(f10, 10.0f));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(e(f10, 12.0f));
        gradientDrawable.setColor(-13882324);
        textView.setBackground(gradientDrawable);
        return textView;
    }

    public final WindowManager.LayoutParams f(Context appContext, boolean useKeyguardDialog) {
        int i10 = useKeyguardDialog ? 2009 : 2038;
        Pair<Integer, Integer> pairY = y(appContext);
        int iIntValue = pairY.a().intValue();
        int iIntValue2 = pairY.b().intValue();
        C4148a.k(TAG, "buildLayoutParams keyguardDialog=" + useKeyguardDialog + " gravity=" + iIntValue + " y=" + iIntValue2, false, 4, null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, i10, 524312, -3);
        layoutParams.gravity = iIntValue;
        layoutParams.y = iIntValue2;
        layoutParams.setFitInsetsIgnoringVisibility(true);
        layoutParams.windowAnimations = R.style.Animation.Toast;
        return layoutParams;
    }

    public final void g(WindowManager wm) {
        View view;
        Object objB;
        Runnable runnable = removeRunnable;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        removeRunnable = null;
        WeakReference<View> weakReference = currentViewRef;
        if (weakReference != null && (view = weakReference.get()) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                wm.removeViewImmediate(view);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
        currentViewRef = null;
    }

    public final ImageView h(View view) {
        if (view instanceof ImageView) {
            return (ImageView) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            Iterator<Integer> it = C5685n.s(0, viewGroup.getChildCount()).iterator();
            while (it.hasNext()) {
                int iNextInt = ((M) it).nextInt();
                d dVar = INSTANCE;
                View childAt = viewGroup.getChildAt(iNextInt);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                ImageView imageViewH = dVar.h(childAt);
                if (imageViewH != null) {
                    return imageViewH;
                }
            }
        }
        return null;
    }

    public final View i(Context inflateContext, CharSequence message) {
        Object objB;
        Object objB2;
        Resources system = Resources.getSystem();
        Integer numValueOf = Integer.valueOf(system.getIdentifier("transient_notification", "layout", UxipConstants.f30662a));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        int iIntValue = numValueOf.intValue();
        Integer numValueOf2 = Integer.valueOf(system.getIdentifier("message", "id", UxipConstants.f30662a));
        if (numValueOf2.intValue() == 0) {
            numValueOf2 = null;
        }
        if (numValueOf2 == null) {
            return null;
        }
        int iIntValue2 = numValueOf2.intValue();
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewInflate = LayoutInflater.from(inflateContext).inflate(iIntValue, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(iIntValue2);
            TextView textView = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
            if (textView == null) {
                viewInflate = null;
            } else {
                textView.setText(message);
                kotlin.jvm.internal.p.f(viewInflate);
                ImageView imageViewH = h(viewInflate);
                if (imageViewH != null) {
                    try {
                        imageViewH.setVisibility(0);
                        imageViewH.setImageDrawable(c(inflateContext));
                        objB2 = Result.b(t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB2 = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB2);
                    if (thE != null) {
                        C4148a.t(TAG, "fill toast app icon failed", thE, false, 8, null);
                    }
                    Result.a(objB2);
                }
                C4148a.k(TAG, "use system toast layout transient_notification", false, 4, null);
            }
            objB = Result.b(viewInflate);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB);
        if (thE2 != null) {
            C4148a.t(TAG, "inflate system toast layout failed, use fallback chip", thE2, false, 8, null);
        }
        return (View) (Result.g(objB) ? null : objB);
    }

    public final void j(long now) {
        while (true) {
            C1165m<Long> c1165m = systemToastTimes;
            if (c1165m.isEmpty() || now - c1165m.first().longValue() <= QUOTA_MAX_WINDOW_MS) {
                return;
            } else {
                c1165m.removeFirst();
            }
        }
    }

    public final float k(Context appContext) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Float.valueOf(Settings.System.getFloat(appContext.getContentResolver(), "font_scale")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Float fValueOf = Float.valueOf(0.0f);
        if (Result.g(objB)) {
            objB = fValueOf;
        }
        return ((Number) objB).floatValue();
    }

    public final void l(View root, Context rendered) {
        float f10 = rendered.getResources().getConfiguration().fontScale;
        Float fB = s.b(k(rendered), f10);
        if (fB != null) {
            float fFloatValue = fB.floatValue();
            float f11 = fFloatValue / f10;
            int identifier = Resources.getSystem().getIdentifier("message", "id", UxipConstants.f30662a);
            TextView textView = identifier != 0 ? (TextView) root.findViewById(identifier) : null;
            if (textView == null) {
                textView = root instanceof TextView ? (TextView) root : null;
                if (textView == null) {
                    return;
                }
            }
            textView.setTextSize(0, textView.getTextSize() * f11);
            C4148a.k(TAG, "rescale toast text x" + f11 + " (context fontScale stayed " + f10 + ", system=" + fFloatValue + ")", false, 4, null);
        }
    }

    public final boolean m(Context appContext, boolean anchorVisible, boolean repeatable, boolean forceOverlay) {
        Object systemService = appContext.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        boolean z10 = keyguardManager != null && keyguardManager.isKeyguardLocked();
        Object systemService2 = appContext.getSystemService("power");
        PowerManager powerManager = systemService2 instanceof PowerManager ? (PowerManager) systemService2 : null;
        boolean z11 = powerManager != null && powerManager.isInteractive();
        boolean z12 = repeatable && A();
        boolean z13 = (forceOverlay || z10 || z12) && z11 && anchorVisible;
        C4148a.k(TAG, "shouldUseOverlay=" + z13 + " (repeatable=" + repeatable + " forceOverlay=" + forceOverlay + " keyguardLocked=" + z10 + " overQuota=" + z12 + " sysToasts=" + systemToastTimes.size() + " interactive=" + z11 + " anchorVisible=" + anchorVisible + ")", false, 4, null);
        return z13;
    }

    public final void n(Context context, int messageRes, View anchor) {
        kotlin.jvm.internal.p.i(context, "context");
        r(this, context, messageRes, anchor, false, false, 16, null);
    }

    public final void o(Context context, int messageRes, View anchor) {
        kotlin.jvm.internal.p.i(context, "context");
        q(context, messageRes, anchor, true, true);
    }

    public final void q(Context context, final int messageRes, View anchor, final boolean repeatable, final boolean forceOverlay) {
        final Context applicationContext = context.getApplicationContext();
        final WeakReference weakReference = anchor != null ? new WeakReference(anchor) : null;
        mainHandler.post(new Runnable() { // from class: com.stepos.agentframework.chatui.util.b
            @Override // java.lang.Runnable
            public final void run() {
                d.s(applicationContext, messageRes, weakReference, repeatable, forceOverlay);
            }
        });
    }

    public final boolean t(Context appContext, CharSequence message) {
        Object objB;
        Object objB2;
        Object systemService = appContext.getSystemService("window");
        final WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return false;
        }
        g(windowManager);
        Context contextZ = z(appContext);
        View viewI = i(contextZ, message);
        if (viewI == null) {
            viewI = d(contextZ, message);
        }
        l(viewI, contextZ);
        try {
            Result.Companion companion = Result.INSTANCE;
            windowManager.addView(viewI, f(appContext, true));
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "addView with TYPE_KEYGUARD_DIALOG failed, fallback", thE, false, 8, null);
        }
        if (!Result.h(objB)) {
            try {
                windowManager.addView(viewI, f(appContext, false));
                objB2 = Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            Throwable thE2 = Result.e(objB2);
            if (thE2 != null) {
                C4148a.t(TAG, "addView with TYPE_APPLICATION_OVERLAY failed, fallback to Toast", thE2, false, 8, null);
            }
            if (Result.g(objB2)) {
                return false;
            }
        }
        currentViewRef = new WeakReference<>(viewI);
        Runnable runnable = new Runnable() { // from class: com.stepos.agentframework.chatui.util.c
            @Override // java.lang.Runnable
            public final void run() {
                d.u(windowManager);
            }
        };
        mainHandler.postDelayed(runnable, 2000L);
        removeRunnable = runnable;
        return true;
    }

    public final void v(Context context, int messageRes, View anchor) {
        kotlin.jvm.internal.p.i(context, "context");
        q(context, messageRes, anchor, true, false);
    }

    public final void w(Context appContext, CharSequence message) {
        Toast toast;
        Object objB;
        WeakReference<Toast> weakReference = systemToastRef;
        if (weakReference != null && (toast = weakReference.get()) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                toast.cancel();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
        Toast toastMakeText = Toast.makeText(appContext, message, 0);
        systemToastRef = new WeakReference<>(toastMakeText);
        toastMakeText.show();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        systemToastTimes.addLast(Long.valueOf(jElapsedRealtime));
        j(jElapsedRealtime);
    }

    public final void x(Context rendered, Context appContext) {
        DisplayMetrics displayMetrics = rendered.getResources().getDisplayMetrics();
        if (displayMetrics == appContext.getResources().getDisplayMetrics()) {
            C4148a.u(TAG, "toast context shares app displayMetrics, skip scaledDensity write", false, 4, null);
            return;
        }
        float f10 = displayMetrics.density * rendered.getResources().getConfiguration().fontScale;
        if (displayMetrics.scaledDensity == f10) {
            return;
        }
        displayMetrics.scaledDensity = f10;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> y(android.content.Context r6) {
        /*
            r5 = this;
            android.content.res.Resources r5 = android.content.res.Resources.getSystem()
            java.lang.String r0 = "config_toastDefaultGravity"
            java.lang.String r1 = "integer"
            java.lang.String r2 = "android"
            int r0 = r5.getIdentifier(r0, r1, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r1 = r0.intValue()
            r3 = 0
            if (r1 == 0) goto L1a
            goto L1b
        L1a:
            r0 = r3
        L1b:
            if (r0 == 0) goto L4b
            int r0 = r0.intValue()
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L30
            int r0 = r5.getInteger(r0)     // Catch: java.lang.Throwable -> L30
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L30
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L30
            goto L3b
        L30:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L3b:
            boolean r1 = kotlin.Result.g(r0)
            if (r1 == 0) goto L42
            r0 = r3
        L42:
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L4b
            int r0 = r0.intValue()
            goto L4d
        L4b:
            r0 = 81
        L4d:
            java.lang.String r1 = "toast_y_offset"
            java.lang.String r4 = "dimen"
            int r1 = r5.getIdentifier(r1, r4, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = r1.intValue()
            if (r2 == 0) goto L60
            goto L61
        L60:
            r1 = r3
        L61:
            if (r1 == 0) goto L92
            int r1 = r1.intValue()
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L76
            int r5 = r5.getDimensionPixelSize(r1)     // Catch: java.lang.Throwable -> L76
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L76
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L76
            goto L81
        L76:
            r5 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L81:
            boolean r1 = kotlin.Result.g(r5)
            if (r1 == 0) goto L88
            goto L89
        L88:
            r3 = r5
        L89:
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L92
            int r5 = r3.intValue()
            goto La1
        L92:
            r5 = 64
            float r5 = (float) r5
            android.content.res.Resources r6 = r6.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            float r6 = r6.density
            float r5 = r5 * r6
            int r5 = (int) r5
        La1:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            kotlin.Pair r5 = Y8.j.a(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.util.d.y(android.content.Context):kotlin.Pair");
    }

    public final Context z(Context appContext) {
        boolean z10;
        Integer numA;
        Configuration configuration = new Configuration(appContext.getResources().getConfiguration());
        Float fB = s.b(k(appContext), configuration.fontScale);
        boolean z11 = true;
        if (fB != null) {
            C4148a.k(TAG, "align toast fontScale to system: " + configuration.fontScale + " -> " + fB, false, 4, null);
            configuration.fontScale = fB.floatValue();
            z10 = true;
        } else {
            z10 = false;
        }
        Object systemService = appContext.getSystemService("uimode");
        UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
        Integer numValueOf = uiModeManager != null ? Integer.valueOf(uiModeManager.getNightMode()) : null;
        if (numValueOf == null || (numA = s.a(numValueOf.intValue(), configuration.uiMode)) == null) {
            z11 = z10;
        } else {
            configuration.uiMode = (configuration.uiMode & (-49)) | numA.intValue();
            C4148a.k(TAG, "align toast night bit to system: nightMode=" + numValueOf + " uiMode=" + appContext.getResources().getConfiguration().uiMode + " -> " + configuration.uiMode, false, 4, null);
        }
        if (!z11) {
            return appContext;
        }
        Context contextCreateConfigurationContext = appContext.createConfigurationContext(configuration);
        kotlin.jvm.internal.p.f(contextCreateConfigurationContext);
        x(contextCreateConfigurationContext, appContext);
        return contextCreateConfigurationContext;
    }
}
