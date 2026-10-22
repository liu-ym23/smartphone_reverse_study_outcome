package com.android.server.inputmethod;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.LocaleList;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class SystemLocaleWrapper {
    private static final AtomicReference<LocaleList> sSystemLocale = null;

    interface Callback {
        void onLocaleChanged(LocaleList r1, LocaleList r2);
    }

    private static final class LocaleChangeListener extends BroadcastReceiver {
        private final Callback mCallback;
        private final Context mContext;

        LocaleChangeListener(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction()) == true) goto L5;
            return;
        L5:
            LocaleList newLocales = this.mContext.getResources().getConfiguration().getLocales();
            LocaleList prevLocales = (LocaleList) SystemLocaleWrapper.m4790$$Nest$sfgetsSystemLocale().getAndSet(newLocales);
            if (Objects.equals(newLocales, prevLocales) == true) goto L9;
            this.mCallback.onLocaleChanged(prevLocales, newLocales);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsSystemLocale, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicReference m4790$$Nest$sfgetsSystemLocale() {
        return sSystemLocale;
    }

    private SystemLocaleWrapper() {
    }

    static {
        sSystemLocale = new AtomicReference(new LocaleList(new Locale[]{Locale.getDefault()}));
    }

    static LocaleList get(int userId) {
        return sSystemLocale.get();
    }

    static void onStart(Context context, Callback callback, Handler handler) {
        sSystemLocale.set(context.getResources().getConfiguration().getLocales());
        context.registerReceiver(new LocaleChangeListener(context, callback), new IntentFilter("android.intent.action.LOCALE_CHANGED"), null, handler);
    }
}
