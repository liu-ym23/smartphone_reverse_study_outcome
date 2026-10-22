package com.bytedance.android.live.liveinteract.animation.universalwidget;

import android.graphics.Path;
import com.bytedance.android.live.liveinteract.animation.universalwidget.context.LinkUniversalAnimContext;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.live.datacontext.DataContext;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public interface a {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final C1150a f71316f0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.animation.universalwidget.a$a, reason: collision with other inner class name */
    public static final class C1150a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1150a f71317a = null;

        public C1150a() {
        }

        static {
            f71317a = new C1150a();
        }

        public static a a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.a.class);
            if ((r100 instanceof LinkUniversalAnimContext) == true) goto L5;
            r100 = null;
        L5:
            LinkUniversalAnimContext r101 = (LinkUniversalAnimContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<a> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ boolean a(a r100) {
            return r100.Zg("");
        }
    }

    static {
        f71316f0 = C1150a.f71317a;
    }

    void Jl(Path r100);

    void Le(String r100, JsonObject r101, oh0.a r102);

    boolean Zg(String r100);

    void d4(int r100, int r101);

    void m9(com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r101, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r102, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r103, String r104, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r105, MultiLinkScriptInfo r106, com.bytedance.android.live.liveinteract.animation.e r107);

    void start3DAnim(com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r101, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r102, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r103, String r104, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r105, MultiLinkScriptInfo r106, com.bytedance.android.live.liveinteract.animation.e r107);

    void y7(Function0<Unit> r100);

    void zn(Function0<Unit> r100);
}
