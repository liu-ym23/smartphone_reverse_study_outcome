package com.obric.appstore.base;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.b0;
import androidx.lifecycle.k0;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends k0 implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f10578g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f10579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f10580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LocaleChangeAware f10581f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f10578g = new a(null);
    }

    public m(@NotNull b0 r10) {
        q.g(r10, "savedStateHandle");
        this.f10579d = r10;
    }

    public final void f(Context r10, LocaleChangeAware r11) {
        Locale r12 = r10.getResources().getConfiguration().getLocales().get(0);
        String r13 = r12.toLanguageTag();
        String r14 = (String) this.f10579d.c("KEY_LOCALE");
        if (r14 != null) goto L5;
    L7:
        this.f10579d.g("KEY_LOCALE", r13);
        return;
    L5:
        if (q.b(r14, r13) == true) goto L7;
        q.d(r12);
        r11.onLocaleChanged(r12);
        goto L7
    }

    public final void g(Context r10) {
        this.f10580e = r10;
    }

    public final void h(LocaleChangeAware r10) {
        this.f10581f = r10;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner r10) {
        q.g(r10, "owner");
        this.f10580e = null;
        this.f10581f = null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner r10) {
        q.g(r10, "owner");
        Context r11 = this.f10580e;
        if (r11 != null) goto L5;
        return;
    L5:
        LocaleChangeAware r12 = this.f10581f;
        if (r12 != null) goto L8;
        return;
    L8:
        f(r11, r12);
    }
}
