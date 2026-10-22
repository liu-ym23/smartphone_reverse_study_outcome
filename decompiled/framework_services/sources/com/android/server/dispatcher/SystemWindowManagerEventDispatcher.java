package com.android.server.dispatcher;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.WindowManager;
import com.android.server.LocalServices;
import com.android.server.common.IGameAssistSerivce;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SystemWindowManagerEventDispatcher extends AbsDispatcher<SystemWindowObserver> {
    private static final AbsDispatcher.Lazy<SystemWindowManagerEventDispatcher> INSTANCE = null;
    public static final String TAG = "GameAssist.SystemWindowManagerEventDispatcher";
    private final FocuesWindow mFocuesWindow;
    private final List<SystemWindow> mSystemWindows;

    public static class FocuesWindow {
        private String mPackageName;
        private Rect mVisRect;
        private int mWindowType;

        public FocuesWindow() {
        }

        public void set(String packageName, int windowType, Rect visRect) {
            this.mPackageName = packageName;
            this.mWindowType = windowType;
            this.mVisRect = new Rect(visRect);
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public int getWindowType() {
            return this.mWindowType;
        }

        public Rect getVisRect() {
            return this.mVisRect;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.mPackageName);
            bundle.putInt("window_type", this.mWindowType);
            bundle.putParcelable("vis_rect", this.mVisRect);
            return bundle;
        }

        public String toString() {
            return "FocuesWindow{mPackageName='" + this.mPackageName + "', mWindowType=" + this.mWindowType + ", mVisRect=" + this.mVisRect + '}';
        }
    }

    public static class SystemWindow {
        public final String mPackageName;
        public final String mTitle;
        public final int mWindowType;

        public SystemWindow(String title, String packageName, int windowType) {
            this.mTitle = title;
            this.mPackageName = packageName;
            this.mWindowType = windowType;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("title", this.mTitle);
            bundle.putString("package_name", this.mPackageName);
            bundle.putInt("window_type", this.mWindowType);
            return bundle;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mTitle});
        }

        public boolean equals(Object anObject) {
            if (anObject == null) goto L19;
            if ((anObject instanceof SystemWindow) == false) goto L15;
            String titile = ((SystemWindow) anObject).mTitle;
            if (titile == null) goto L19;
            if (this.mTitle == null) goto L19;
            if (titile.equals(this.mTitle) == false) goto L19;
            return true;
        L15:
            if ((anObject instanceof String) == false) goto L19;
            return ((String) anObject).equals(this.mTitle);
        L19:
            return super.equals(anObject);
        }

        public String toString() {
            return "SystemWindow{mTitle='" + this.mTitle + "', mPackageName='" + this.mPackageName + "', mWindowType=" + this.mWindowType + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$9s7Omv94hRioiRRrWiWYHt1gmPA(SystemWindowManagerEventDispatcher r0, String r1, int r2, Rect r3) {
        r0.lambda$notifyFocuesWindowChanged$0(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$TsU_0yK3GaB7hNh_ZRQP24EQJ_U(boolean r0, SystemWindow r1, SystemWindowObserver r2) {
        lambda$notifySystemWindowChanged$3(r0, r1, r2);
    }

    public static /* synthetic */ SystemWindowManagerEventDispatcher $r8$lambda$UYv53aQITyDohazlVU275xU9LaA() {
        return new SystemWindowManagerEventDispatcher();
    }

    public static /* synthetic */ void $r8$lambda$xXdGvJTOJvxZdWsFGerqbo1ulMA(SystemWindowManagerEventDispatcher r0, boolean r1, String r2, String r3, int r4) {
        r0.lambda$notifySystemWindowChanged$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$ylBhjxVQF0rXHQj7qFpciNnX7KQ(SystemWindowManagerEventDispatcher r0, SystemWindowObserver r1) {
        r0.lambda$notifyFocuesWindowChanged$1(r1);
    }

    static {
        INSTANCE = new AbsDispatcher.Lazy(new SystemWindowManagerEventDispatcher$$ExternalSyntheticLambda0());
    }

    private SystemWindowManagerEventDispatcher() {
        this.mSystemWindows = new ArrayList();
        this.mFocuesWindow = new FocuesWindow();
    }

    public static SystemWindowManagerEventDispatcher getInstance() {
        return (SystemWindowManagerEventDispatcher) INSTANCE.get();
    }

    private /* synthetic */ void lambda$notifyFocuesWindowChanged$0(String packageName, int windowType, Rect visRect) {
        notifyFocuesWindowChanged(packageName, windowType, visRect);
    }

    public void notifyFocuesWindowChanged(final String packageName, final int windowType, final Rect visRect) {
        if (switchThreads(new SystemWindowManagerEventDispatcher$$ExternalSyntheticLambda1(this, packageName, windowType, visRect)) == false) goto L5;
        return;
    L5:
        this.mFocuesWindow.set(packageName, windowType, visRect);
        notifyObserver(new SystemWindowManagerEventDispatcher$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$notifyFocuesWindowChanged$1(SystemWindowObserver o) {
        o.onFocuesWindowChanged(this.mFocuesWindow);
    }

    public String getSystemWindowTitle(int type, String packageName, WindowManager.LayoutParams attrs) {
        String systemTitle = getWindowTitle(type, packageName, attrs);
        if (systemTitle == null) goto L5;
        return systemTitle;
    L5:
        IGameAssistSerivce gameAssist = (IGameAssistSerivce) LocalServices.getService(IGameAssistSerivce.class);
        if (gameAssist != null) goto L8;
    L13:
        return null;
    L8:
        if (gameAssist.isMutexWindow(packageName, attrs) == false) goto L13;
        CharSequence title = attrs.getTitle();
        if (title != null) goto L12;
        return null;
    L12:
        return title.toString();
    }

    public String getWindowTitle(int windowType, String packageName, WindowManager.LayoutParams attrs) {
        if (windowType < 2020) goto L25;
        if (packageName == null) goto L25;
        if (attrs.getTitle() == null) goto L25;
        String title = attrs.getTitle().toString();
        if ("FitCard".equals(title) == false) goto L11;
    L24:
        return null;
    L11:
        if ("GameAssist".equals(title) == true) goto L24;
        if ("IndicateLeft".equals(title) == true) goto L24;
        if ("IndicateRight".equals(title) == true) goto L24;
        if (title.contains("Toast") == true) goto L24;
        if (title.contains("EXITING") == true) goto L24;
        if ("FloatBar".equals(title) == true) goto L24;
        return title;
    L25:
        return null;
    }

    public boolean hasSystemWindow(String title) {
        List<SystemWindow> r0 = this.mSystemWindows;
        monitor-enter(r0);
        Iterator<SystemWindow> r1 = this.mSystemWindows.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L15;
        SystemWindow window = r1.next();     // Catch: Throwable -> L12
        if (window.equals(title) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public void notifySystemWindowChanged(boolean show, int type, String packageName, WindowManager.LayoutParams attrs, int windowType) {
        String systemWidowTitle = getInstance().getSystemWindowTitle(type, packageName, attrs);
        if (systemWidowTitle == null) goto L6;
        notifySystemWindowChanged(show, systemWidowTitle, packageName, windowType);
        return;
    }

    private /* synthetic */ void lambda$notifySystemWindowChanged$2(boolean show, String title, String packageName, int windowType) {
        notifySystemWindowChanged(show, title, packageName, windowType);
    }

    public void notifySystemWindowChanged(final boolean show, final String title, final String packageName, final int windowType) {
        if (switchThreads(new SystemWindowManagerEventDispatcher$$ExternalSyntheticLambda3(this, show, title, packageName, windowType)) == false) goto L5;
        return;
    L5:
        final SystemWindow systemWindow = new SystemWindow(title, packageName, windowType);
        List<SystemWindow> r8 = this.mSystemWindows;
        monitor-enter(r8);
        if (show == true) goto L24;
    L13:
        if (show == false) goto L15;
    L17:
        boolean notify = false;
    L18:
        monitor-exit(r8);     // Catch: Throwable -> L11
        if (notify == false) goto L26;
        notifyObserver(new SystemWindowManagerEventDispatcher$$ExternalSyntheticLambda4(show, systemWindow));
        return;
    L26:
        return;
    L11:
        th = move-exception;
        throw th;
    L15:
        if (this.mSystemWindows.contains(systemWindow) == false) goto L17;
        this.mSystemWindows.remove(systemWindow);     // Catch: Throwable -> L11
        notify = true;
        goto L18
    L24:
        if (this.mSystemWindows.contains(systemWindow) == true) goto L13;
        this.mSystemWindows.add(systemWindow);     // Catch: Throwable -> L11
        notify = true;
        goto L18
    }

    private static /* synthetic */ void lambda$notifySystemWindowChanged$3(boolean show, SystemWindow systemWindow, SystemWindowObserver o) {
        o.onSystemWindowChanged(show, systemWindow);
    }
}
