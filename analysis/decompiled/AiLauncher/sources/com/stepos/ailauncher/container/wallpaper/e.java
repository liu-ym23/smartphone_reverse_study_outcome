package com.stepos.ailauncher.container.wallpaper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.ailauncher.common.utils.C3197a;

/* loaded from: classes3.dex */
public class e {
    public static final String ACTION_WALLPAPER_COLOR_CHANGE = "com.stepos.launcher.WALLPAPER_COLOR_CHANGE";
    private static final String KEY_WALLPAPER_MAIN_COLOR = "wallpaper_main_color";
    private static final String PREFS_NAME = "wallpaper_main_color";
    private static final String TAG = "WallpaperColorManager";
    private static volatile e sInstance;
    private d listener;
    private final Context mContext;
    private a mReceiver;
    private SharedPreferences mSp;
    private int wallpaperMainColor;

    public static final class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                return;
            }
            Log.i(e.TAG, "intent:" + intent.getAction());
            if (e.ACTION_WALLPAPER_COLOR_CHANGE.equals(intent.getAction()) && C5.b.a(context, this, "wallpaper_color")) {
                int intExtra = intent.getIntExtra("default_color", -1);
                e.b().g(intExtra);
                if (e.b().c() != null) {
                    e.b().c().a(intExtra);
                }
                Log.i(e.TAG, "wallpaper changed " + intExtra);
            }
        }

        public a() {
        }
    }

    public e(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("wallpaper_main_color", 0);
        this.mSp = sharedPreferences;
        this.wallpaperMainColor = sharedPreferences.getInt("wallpaper_main_color", -1);
    }

    public static e b() {
        if (sInstance == null) {
            synchronized (e.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new e(C3197a.INSTANCE.a());
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public d c() {
        return this.listener;
    }

    public int d() {
        return this.wallpaperMainColor;
    }

    public void e() {
        if (this.mReceiver != null) {
            return;
        }
        this.mReceiver = new a();
        this.mContext.registerReceiver(this.mReceiver, new IntentFilter(ACTION_WALLPAPER_COLOR_CHANGE), 2);
    }

    public void f(d dVar) {
        this.listener = dVar;
    }

    public final void g(int i10) {
        this.wallpaperMainColor = i10;
        this.mSp.edit().putInt("wallpaper_main_color", i10).apply();
    }

    public void h() {
        a aVar = this.mReceiver;
        if (aVar == null) {
            return;
        }
        try {
            this.mContext.unregisterReceiver(aVar);
        } catch (IllegalArgumentException e10) {
            Log.w(TAG, "unregister receiver: " + e10.getMessage());
        }
        this.mReceiver = null;
    }
}
