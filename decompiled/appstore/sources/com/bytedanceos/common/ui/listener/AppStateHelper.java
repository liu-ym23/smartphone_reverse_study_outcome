package com.bytedanceos.common.ui.listener;

import android.app.Activity;
import android.app.Application;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateHelper {
    public static final int STATE_BACKGROUND = 0;
    public static final int STATE_FOREGROUND = 1;
    private static volatile AppStateHelper sInstance;
    private int mAppState;
    private int mCreatedCount;
    private boolean mIsHotBoot;
    private List<AppStateChangeListener> mListenerList;
    private int mSartedCount;

    public interface AppStateChangeListener {
        void onBackground(Activity r10);

        void onForeground(Activity r10);
    }

    private AppStateHelper() {
        this.mAppState = 0;
        this.mCreatedCount = 0;
        this.mSartedCount = 0;
        this.mIsHotBoot = false;
        this.mListenerList = new AnonymousClass1(this);
    }

    public static /* synthetic */ List access$000(AppStateHelper r10) {
        return r10.mListenerList;
    }

    public static /* synthetic */ int access$100(AppStateHelper r10) {
        return r10.mCreatedCount;
    }

    public static /* synthetic */ int access$108(AppStateHelper r10) {
        int r11 = r10.mCreatedCount;
        r10.mCreatedCount = r11 + 1;
        return r11;
    }

    public static /* synthetic */ int access$110(AppStateHelper r10) {
        int r11 = r10.mCreatedCount;
        r10.mCreatedCount = r11 - 1;
        return r11;
    }

    public static /* synthetic */ int access$200(AppStateHelper r10) {
        return r10.mSartedCount;
    }

    public static /* synthetic */ int access$208(AppStateHelper r10) {
        int r11 = r10.mSartedCount;
        r10.mSartedCount = r11 + 1;
        return r11;
    }

    public static /* synthetic */ int access$210(AppStateHelper r10) {
        int r11 = r10.mSartedCount;
        r10.mSartedCount = r11 - 1;
        return r11;
    }

    public static /* synthetic */ int access$302(AppStateHelper r10, int r11) {
        r10.mAppState = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$402(AppStateHelper r10, boolean r11) {
        r10.mIsHotBoot = r11;
        return r11;
    }

    public static AppStateHelper getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(AppStateHelper.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppStateHelper();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AppStateHelper.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void addListener(AppStateChangeListener r10) {
        if (r10 == null) goto L5;
        this.mListenerList.add(r10);
        return;
    }

    public int getAppState() {
        return this.mAppState;
    }

    public boolean isHotBoot() {
        return this.mIsHotBoot;
    }

    public boolean isSingleActivity() {
        if (this.mCreatedCount <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void register(Application r10) {
        r10.registerActivityLifecycleCallbacks(new AnonymousClass2(this));
    }

    public void removeListener(AppStateChangeListener r10) {
        if (r10 == null) goto L5;
        this.mListenerList.remove(r10);
        return;
    }
}
