package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.content.SharedPreferences;
import com.bytedance.android.livesdk.utils.v5;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShowTipsHelper f60683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f60684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f60685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f60686d;

    public k(ShowTipsHelper r100, Ref.ObjectRef r101, String r102, int r103) {
        this.f60683a = r100;
        this.f60684b = r101;
        this.f60685c = r102;
        this.f60686d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        ShowTipsHelper r100 = this.f60683a;
        if (r100.f60664e == false) goto L6;
        return;
    L6:
        if (r100.f60668i.invoke().booleanValue() == true) goto L8;
        return;
    L8:
        SharedPreferences r101 = (SharedPreferences) this.f60683a.f60662c.getValue();
        this.f60683a.getClass();
        if (r101.getInt(new SimpleDateFormat("YYYY-MM-dd").format(new Date()), 0) < 2) goto L11;
        return;
    L11:
        String r102 = com.bytedance.android.live.broadcastgame.opengame.service.e.f60998a;
        String r103 = (String) this.f60684b.element;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        com.bytedance.android.live.broadcastgame.opengame.service.e.f60998a = r103;
        this.f60683a.f60669j.invoke();
        ShowTipsHelper r104 = this.f60683a;
        String r105 = this.f60685c;
        r104.f60664e = true;
        String r106 = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        ((SharedPreferences) r104.f60662c.getValue()).edit().putInt(r106, ((SharedPreferences) r104.f60662c.getValue()).getInt(r106, 0) + 1).putBoolean(r106 + r105, true).apply();
        v5.b().edit().putInt("live.key.SHOW_START_GAME_TIP_COUNT", this.f60686d + 1).apply();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
