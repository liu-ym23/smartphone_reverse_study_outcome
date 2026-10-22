package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f80218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f80219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f80220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f80221e;

    public static final class a {
    }

    static {
    }

    public void a(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
    }

    public int b() {
        return 0;
    }

    public Object c() {
        return null;
    }

    public abstract int d();

    public String e() {
        return "";
    }

    public boolean i() {
        return false;
    }

    public abstract String j();

    public abstract void k(View r100);

    public boolean l() {
        return false;
    }

    public String f() {
        return this.f80217a;
    }

    public int g() {
        return this.f80218b;
    }

    public int h() {
        return this.f80219c;
    }

    public g(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f80221e = r100;
        this.f80217a = "";
        this.f80218b = -1;
        this.f80219c = R.drawable.ttlive_bg_time_limit;
        this.f80220d = s1.h(R.color.ttlive_chat_room_panel_item_text_enable_color);
    }
}
