package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f141764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f141765b;

    public interface a {
        void dR();

        void sendLog(String r100, Map<String, String> r101);

        void yR(ChangeSettingSource r100);
    }

    public abstract int a();

    public void b() {
    }

    public void c(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
    }

    public void d() {
    }

    public void e() {
    }

    public final void f(Map r100) {
        Intrinsics.checkNotNullParameter("livesdk_preview_bullet_comment_setting_change", "name");
        this.f141765b.sendLog("livesdk_preview_bullet_comment_setting_change", r100);
    }

    public b(o r100, SimpleZDanmakuSettingDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r101, "panelCallback");
        this.f141764a = r100;
        this.f141765b = r101;
    }
}
