package com.obric.agent.intents.music.netease;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.oui.oswitch.SwitchCompat;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.o;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: CloudMusicCMApiService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "CloudMusicCMApiService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14762a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.f.a f14763b = null;

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14764a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f14765b = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f14766e = null;
        private static final /* synthetic */ d.d.a f = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f14768d;

        private static final /* synthetic */ a[] c() {
            return new a[]{f14764a, f14765b};
        }

        private a(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.f14767c = r3;
            this.f14768d = r4;
        }

        public final String a() {
            return this.f14767c;
        }

        public final String b() {
            return this.f14768d;
        }

        static {
            f14764a = new a("FAVORITE", 0, "goToPlayMusicForFavorite", "CMD_GET_PLAY_LIST_FAVORITE");
            f14765b = new a("DAILY_RECOMMEND", 1, "goToPlayMusicRorDayRecommend", "CMD_GET_PLAY_LIST_DAY_RECOMMEND");
            a[] r0 = c();
            f14766e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f14766e.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {160}, d = "fetchPlaylist", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f14771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14772d;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14771c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14770b = r3;
            this.f14772d |= Integer.MIN_VALUE;
            return d.a(this.f14771c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {92, 108}, d = "fetchSongList", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f14776d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14777e;

        c(d r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14776d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14775c = r3;
            this.f14777e |= Integer.MIN_VALUE;
            return this.f14776d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.music.netease.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {184, 198}, d = "pauseMusic", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService")
    static final class C0294d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f14778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f14779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14780c;

        C0294d(d r3, d.c.d<? super C0294d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14779b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14778a = r3;
            this.f14780c |= Integer.MIN_VALUE;
            return this.f14779b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {BDImageUploader.MessageIsPreHeatResultUsed, 149}, d = "playSongList", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14785e;
        /* synthetic */ Object f;
        final /* synthetic */ d g;
        int h;

        e(d r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {224, SwitchCompat.TRACK_ANIMATION_DURATION_ON}, d = "playSongsByEntity", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14790e;
        /* synthetic */ Object f;
        final /* synthetic */ d g;
        int h;

        f(d r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {297, 64, 66, 68, 70, 76}, d = "prepare", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14794d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14795e;
        /* synthetic */ Object f;
        final /* synthetic */ d g;
        int h;

        g(d r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return d.a(this.g, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService$prepare$2$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14796a;

        h(d.c.d<? super h> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f14796a != 0) goto L7;
            o.a(r1);
            return d.c.b.a.b.a(CMApiManager.INSTANCE.bindService());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CloudMusicCMApiService.kt */
    @d.c.b.a.f(b = "CloudMusicCMApiService.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.music.netease.CloudMusicCMApiService$prepare$2$2$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14797a;

        i(d.c.d<? super i> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f14797a != 0) goto L7;
            o.a(r1);
            CMApiManager.INSTANCE.bindService();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r2, int r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, a r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f14762a = new d();
        f14763b = kotlinx.coroutines.f.c.a(false, 1, null);
    }

    private final Context b() {
        return (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x01e1 -> B:15:0x0057). Please report as a decompilation issue!!! */
    private final Object a(int r12, d.c.d<? super Integer> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r14, g.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f;
        Object r2 = d.c.a.b.a();
        int r5 = 1;
        switch(r0.h) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L27;
            case 3: goto L24;
            case 4: goto L19;
            case 5: goto L16;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        int r11 = r0.f14793c;
        int r16 = r0.f14792b;
        int r3 = r0.f14791a;
        kotlinx.coroutines.f.a r7 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f14795e, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r15);     // Catch: Throwable -> L30
        int r17 = r16;
    L15:
        int r18 = r3;
        int r19 = r11 + 1;     // Catch: Throwable -> L30
    L56:
        if (r19 >= r17) goto L74;
        r0.f14795e = r7;     // Catch: Throwable -> L30
        r0.f14791a = r18;     // Catch: Throwable -> L30
        r0.f14792b = r17;     // Catch: Throwable -> L30
        r0.f14793c = r19;     // Catch: Throwable -> L30
        r0.f14794d = r19;     // Catch: Throwable -> L30
        r0.h = 4;     // Catch: Throwable -> L30
        if (ax.a(250, r0) != r2) goto L60;
        return r2;
    L60:
        r3 = r18;
        int r110 = r19;
    L62:
        if (CMApiManager.INSTANCE.isBindCMService() == false) goto L67;
        CMApiManager r111 = CMApiManager.INSTANCE;     // Catch: Throwable -> L30
        r0.f14795e = r7;     // Catch: Throwable -> L30
        r0.h = 5;     // Catch: Throwable -> L30
        r15 = r111.ensureToken(r0);     // Catch: Throwable -> L30
        if (r15 != r2) goto L66;
        return r2;
    L66:
        r5 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L30
        goto L74
    L67:
        if (r19 < r3) goto L69;
        ILogDepend.Companion.w(TAG, "prepare: bind 超时");     // Catch: Throwable -> L30
        goto L74
    L69:
        d.c.g r112 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        r0.f14795e = r7;     // Catch: Throwable -> L30
        r0.f14791a = r3;     // Catch: Throwable -> L30
        r0.f14792b = r17;     // Catch: Throwable -> L30
        r0.f14793c = r110;     // Catch: Throwable -> L30
        r0.h = 6;     // Catch: Throwable -> L30
        if (kotlinx.coroutines.i.a(r112, r8, r0) != r2) goto L72;
        return r2;
    L72:
        r11 = r110;
    L74:
        Integer r113 = d.c.b.a.b.a(r5);     // Catch: Throwable -> L30
        r7.b(null);
        return r113;
    L16:
        r7 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f14795e, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r15);     // Catch: Throwable -> L30
        goto L66
    L19:
        r19 = r0.f14794d;
        r110 = r0.f14793c;
        int r4 = r0.f14792b;
        int r9 = r0.f14791a;
        kotlinx.coroutines.f.a r10 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f14795e, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r15);     // Catch: Throwable -> L22
        r17 = r4;
        r3 = r9;
        r7 = r10;
    L22:
        th = th;
        r7 = r10;
    L77:
        r7.b(null);
        throw th;
    L24:
        int r114 = r0.f14791a;
        r7 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f14795e, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r15);     // Catch: Throwable -> L30
    L55:
        int r115 = r114 + 1;     // Catch: Throwable -> L30
        r18 = r114;
        r19 = 0;
        r17 = r115;
        goto L56
    L27:
        r7 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f14795e, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r15);     // Catch: Throwable -> L30
    L50:
        r5 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L30
        goto L74
    L32:
        r12 = r0.f14791a;
        kotlinx.coroutines.f.a r116 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f14795e, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        o.a(r15);
    L33:
        r7 = r116;
        if (CMApiManager.INSTANCE.isBindCMService() == false) goto L51;
        CMApiManager r117 = CMApiManager.INSTANCE;     // Catch: Throwable -> L30
        r0.f14795e = r7;     // Catch: Throwable -> L30
        r0.h = 2;     // Catch: Throwable -> L30
        r15 = r117.ensureToken(r0);     // Catch: Throwable -> L30
        if (r15 != r2) goto L50;
        return r2;
    L51:
        d.c.g r118 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        d.h.a.m r119 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        r0.f14795e = r7;     // Catch: Throwable -> L30
        r0.f14791a = r12;     // Catch: Throwable -> L30
        r0.h = 3;     // Catch: Throwable -> L30
        if (kotlinx.coroutines.i.a(r118, r119, r0) != r2) goto L54;
        return r2;
    L54:
        r114 = r12;
        goto L55
    L34:
        o.a(r15);
        if (l.f14846a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L39;
        ILogDepend.Companion.w(TAG, "prepare: 网易云音乐未安装");
        return d.c.b.a.b.a(100);
    L39:
        if (l.f14846a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L42;
        ILogDepend.Companion.w(TAG, "prepare: 网易云音乐版本过低");
        return d.c.b.a.b.a(106);
    L42:
        r116 = f14763b;
        r0.f14795e = r116;
        r0.f14791a = r12;
        r0.h = 1;
        if (r116.a(null, r0) != r2) goto L33;
        return r2;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L30:
        th = th;
    L7:
        r0 = new g(this, r14);
        goto L8
    }

    static /* synthetic */ Object a(d r1, int r2, d.c.d r3, int r4, Object r5) {
        d.c.d<? super Integer> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 3;
    L6:
        return r1.a(r2, r6);
    }

    public final Object a(a r10, d.c.d<? super d.m<Integer, com.obric.agent.intents.music.netease.a.a>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
        if ((r0.f14777e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14777e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f14775c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f14777e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r13);
    L39:
        return s.a(d.c.b.a.b.a(0), (com.obric.agent.intents.music.netease.a.a) ZeusTransformUtils.preCheckCast(r13, com.obric.agent.intents.music.netease.a.a.class, "com.obric.aiagent.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (a) ZeusTransformUtils.preCheckCast(r0.f14774b, a.class, "com.obric.aiagent.plugin");
        d this = (d) ZeusTransformUtils.preCheckCast(r0.f14773a, d.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L19:
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r14 == 0) goto L24;
        ILogDepend.Companion.w(TAG, "playPlaylistAndGetList: prepare failed code=" + r14);
        return s.a(d.c.b.a.b.a(r14), null);
    L24:
        if (r10 != a.f14764a) goto L35;
        Bundle r15 = CMApiManager.INSTANCE.execute("CMD_GET_USER_LOGIN_STATUS", new Bundle());
        if (r15 == null) goto L28;
        Integer r16 = d.c.b.a.b.a(r15.getInt("login_state"));
    L29:
        if (r16 != null) goto L32;
    L33:
        ILogDepend.Companion.w(TAG, "fetchSongList: [FAVORITE] user not logged in, loginState=" + r16);
        return s.a(d.c.b.a.b.a(202), null);
    L32:
        if (r16.intValue() == 2) goto L35;
    L28:
        r16 = null;
    L35:
        r0.f14773a = null;
        r0.f14774b = null;
        r0.f14777e = 2;
        r13 = this.b(r10, r0);
        if (r13 != r2) goto L39;
        return r2;
    L16:
        o.a(r13);
        r0.f14773a = this;
        r0.f14774b = r10;
        r0.f14777e = 1;
        r13 = a(this, 0, r0, 1, null);
        if (r13 != r2) goto L19;
        return r2;
    L7:
        r0 = new c(this, r12);
        goto L8
    }

    public final Object a(a r11, Set<String> r12, String r13, d.c.d<? super Integer> r14) {
        Set<String> r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r16, e.class, "com.obric.aiagent.plugin");
        if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
        r0.h -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f;
        Object r2 = d.c.a.b.a();
        int r3 = r0.h;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r17);
    L30:
        com.obric.agent.intents.music.netease.c r10 = (com.obric.agent.intents.music.netease.c) ZeusTransformUtils.preCheckCast(r17, com.obric.agent.intents.music.netease.c.class, "com.obric.aiagent.plugin");
        k.f14837a.a(r10.b());
        return d.c.b.a.b.a(r10.b());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f14785e, String.class, "com.obric.aiagent.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r0.f14784d, String.class, "com.obric.aiagent.plugin");
        r13 = (String) ZeusTransformUtils.preCheckCast(r0.f14783c, String.class, "com.obric.aiagent.plugin");
        r15 = (Set) ZeusTransformUtils.preCheckCast(r0.f14782b, Set.class, "com.obric.aiagent.plugin");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r0.f14781a, a.class, "com.obric.aiagent.plugin");
        o.a(r17);
        String r110 = r19;
        r11 = r4;
        Object r5 = r17;
    L20:
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r6 == 0) goto L24;
        ILogDepend.Companion.w(TAG, "playSongList: prepare failed code=" + r6);
        Integer r111 = d.c.b.a.b.a(r6);
        k.f14837a.a(r13, r110, r18, ((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, "com.obric.aiagent.plugin")).intValue());
        return r111;
    L24:
        Map r112 = ao.b(new d.m[]{s.a("action", r11.a()), s.a("actionTarget", "playController")});
        if (r110 == null) goto L27;
        r112.put("songId", r110);
    L27:
        Bundle r7 = new Bundle();
        d.h.b.o.a(r112, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        r7.putString("data", new JSONObject(r112).toString());
        r7.putString("channel", com.obric.agent.intents.music.netease.e.f14798a.b());
        CMApiManager.INSTANCE.setCurrentPlaySongIds(r15);
        CMApiManager.INSTANCE.setTriggerByLocalMsgId(r13);
        k.f14837a.a(r13, r110, r18);
        CMApiManager r113 = CMApiManager.INSTANCE;
        String r114 = CMApiManager.INSTANCE.getCmapiAccessToken();
        r0.f14781a = null;
        r0.f14782b = null;
        r0.f14783c = null;
        r0.f14784d = null;
        r0.f14785e = null;
        r0.h = 2;
        r17 = r113.executeAsync("CMAPI_PLAY_CONTROLLER", r114, r7, r0);
        if (r17 != r2) goto L30;
        return r2;
    L16:
        o.a(r17);
        r110 = (String) ZeusTransformUtils.preCheckCast(p.f((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
        r0.f14781a = r11;
        r0.f14782b = r15;
        r0.f14783c = r13;
        r0.f14784d = r110;
        r0.f14785e = DownloadConstants.QUERY_KEY;
        r0.h = 1;
        Object r115 = a(this, 0, r0, 1, null);
        if (r115 != r2) goto L19;
        return r2;
    L19:
        r5 = r115;
        r18 = DownloadConstants.QUERY_KEY;
    L7:
        r0 = new e(this, r16);
        goto L8
    }

    private final Object b(a r8, d.c.d<? super com.obric.agent.intents.music.netease.a.a> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r0.f14772d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14772d -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f14770b;
        Object r11 = d.c.a.b.a();
        int r2 = r0.f14772d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r8 = (a) ZeusTransformUtils.preCheckCast(r0.f14769a, a.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L17:
        Bundle r12 = ((com.obric.agent.intents.music.netease.c) ZeusTransformUtils.preCheckCast(r7, com.obric.agent.intents.music.netease.c.class, "com.obric.aiagent.plugin")).a();
        Integer r1 = null;
        if (r12 == null) goto L37;
        String r13 = r12.getString("data");
        if (r13 == null) goto L37;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L25;
        r13 = null;
    L25:
        if (r13 == null) goto L37;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L28
        Object r4 = d.n.f((com.obric.agent.intents.music.netease.a.a) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r13, com.obric.agent.intents.music.netease.a.a.class), com.obric.agent.intents.music.netease.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L28
    L30:
        Throwable r5 = d.n.c(r4);
        if (r5 == null) goto L34;
        ILogDepend.Companion.e(TAG, "fetchPlaylist[" + r8 + "] parse failed, json=" + r13, r5);
    L34:
        if (d.n.b(r4) == false) goto L36;
        r4 = null;
    L36:
        com.obric.agent.intents.music.netease.a.a r14 = (com.obric.agent.intents.music.netease.a.a) ZeusTransformUtils.preCheckCast(r4, com.obric.agent.intents.music.netease.a.a.class, "com.obric.aiagent.plugin");
    L38:
        ILogDepend.Companion r6 = ILogDepend.Companion;
        StringBuilder r15 = new StringBuilder().append("playPlaylist[").append(r8).append("] list onReturn num=");
        if (r14 == null) goto L41;
        r1 = r14.a();
    L41:
        r6.d(TAG, r15.append(r1).toString());
        return r14;
    L28:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;
        r4 = d.n.f(o.a(th));
    L37:
        r14 = null;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r7);
        Bundle r17 = new Bundle();
        r17.putString("data", new JSONObject().toString());
        r17.putString("channel", com.obric.agent.intents.music.netease.e.f14798a.b());
        CMApiManager r18 = CMApiManager.INSTANCE;
        String r19 = r8.b();
        String r20 = CMApiManager.INSTANCE.getCmapiAccessToken();
        r0.f14769a = r8;
        r0.f14772d = 1;
        r7 = r18.executeAsync(r19, r20, r17, r0);
        if (r7 != r11) goto L17;
        return r11;
    L7:
        r0 = new b(this, r10);
        goto L8
    }

    public final void a() {
        Intent r3 = new Intent();
        r3.setAction("android.intent.action.VIEW");
        r3.setData(Uri.parse("orpheus://player?autoPlay=true&isFromCMApi=true"));
        r3.addFlags(268435456);
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(f14762a.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, "com.obric.aiagent.plugin");
    }

    public final Object a(d.c.d<? super Integer> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C0294d.class) == false) goto L7;
        C0294d r0 = (C0294d) ZeusTransformUtils.preCheckCast(r9, C0294d.class, "com.obric.aiagent.plugin");
        if ((r0.f14780c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14780c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f14778a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f14780c;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        o.a(r10);
    L26:
        Integer r7 = d.c.b.a.b.a(((com.obric.agent.intents.music.netease.c) ZeusTransformUtils.preCheckCast(r10, com.obric.agent.intents.music.netease.c.class, "com.obric.aiagent.plugin")).b());
        ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue();
        k.f14837a.a("click_pause");
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        o.a(r10);
    L19:
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r11 == 0) goto L23;
        ILogDepend.Companion.w(TAG, "pauseMusic: prepare failed code=" + r11);
        return d.c.b.a.b.a(r11);
    L23:
        Map r12 = ao.b(new d.m[]{s.a("action", "pause"), s.a("actionTarget", "playController"), s.a("appId", "a3010100000000003a8e52bf0b4677ce")});
        Bundle r13 = new Bundle();
        d.h.b.o.a(r12, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        r13.putString("data", new JSONObject(r12).toString());
        r13.putString("channel", com.obric.agent.intents.music.netease.e.f14798a.b());
        CMApiManager r14 = CMApiManager.INSTANCE;
        String r4 = CMApiManager.INSTANCE.getCmapiAccessToken();
        r0.f14780c = 2;
        r10 = r14.executeAsync("CMAPI_PLAY_CONTROLLER", r4, r13, r0);
        if (r10 != r2) goto L26;
        return r2;
    L16:
        o.a(r10);
        r0.f14780c = 1;
        r10 = a(this, 0, r0, 1, null);
        if (r10 != r2) goto L19;
        return r2;
    L7:
        r0 = new C0294d(this, r9);
        goto L8
    }

    public final Object a(List<MusicEntity> r25, MusicEntity r26, String r27, d.c.d<? super Integer> r28) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, f.class) == false) goto L7;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin");
        if ((r4.h & Integer.MIN_VALUE) == 0) goto L7;
        r4.h -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f;
        Object r6 = d.c.a.b.a();
        int r7 = r4.h;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        o.a(r5);
    L60:
        com.obric.agent.intents.music.netease.c r0 = (com.obric.agent.intents.music.netease.c) ZeusTransformUtils.preCheckCast(r5, com.obric.agent.intents.music.netease.c.class, "com.obric.aiagent.plugin");
        k.f14837a.a(r0.b());
        return d.c.b.a.b.a(r0.b());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.f14790e, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.f14789d, String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.f14788c, String.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(r4.f14787b, List.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4.f14786a, String.class, "com.obric.aiagent.plugin");
        o.a(r5);
    L49:
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r10 == 0) goto L53;
        ILogDepend.Companion.w(TAG, "playSongs: prepare failed code=" + r10);
        Integer r11 = d.c.b.a.b.a(r10);
        k.f14837a.a(r13, r8, r2, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue());
        return r11;
    L53:
        String r14 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        ILogDepend.Companion.d(TAG, "playSongs size=" + r12.size() + " startId=" + r9);
        Map r15 = ao.b(new d.m[]{s.a("action", "play_id_list"), s.a("actionTarget", "playController"), s.a("idList", r14), s.a("idListFromOpenApi", d.c.b.a.b.a(false)), s.a("appId", "a3010100000000003a8e52bf0b4677ce"), s.a("notOpenPlayer", d.c.b.a.b.a(true))});
        if (r9 == null) goto L56;
        r15.put("songId", r9);
    L57:
        Bundle r16 = new Bundle();
        d.h.b.o.a(r15, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        r16.putString("data", new JSONObject(r15).toString());
        r16.putString("channel", com.obric.agent.intents.music.netease.e.f14798a.b());
        CMApiManager.INSTANCE.setCurrentPlaySongIds(p.q((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")));
        CMApiManager.INSTANCE.setTriggerByLocalMsgId(r13);
        k.f14837a.a(r13, r8, r2);
        CMApiManager r17 = CMApiManager.INSTANCE;
        String r18 = CMApiManager.INSTANCE.getCmapiAccessToken();
        r4.f14786a = null;
        r4.f14787b = null;
        r4.f14788c = null;
        r4.f14789d = null;
        r4.f14790e = null;
        r4.h = 2;
        r5 = r17.executeAsync("CMAPI_PLAY_CONTROLLER", r18, r16, r4);
        if (r5 != r6) goto L60;
        return r6;
    L56:
        r15.put("songIndex", d.c.b.a.b.a(0));
        goto L57
    L16:
        o.a(r5);
        if (r1 == null) goto L23;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r19, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r21 = r19.iterator();
    L20:
        if (r21.hasNext() == false) goto L22;
        r20.add(((MusicEntity) ZeusTransformUtils.preCheckCast(r21.next(), MusicEntity.class, "com.obric.aiagent.plugin")).getId());
        goto L20
    L22:
        r12 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin");
    L24:
        if (r26 == null) goto L26;
        r9 = r26.getId();
    L27:
        if (r9 != null) goto L31;
        if (r12 == null) goto L30;
        r8 = (String) ZeusTransformUtils.preCheckCast(p.l(r12), String.class, "com.obric.aiagent.plugin");
    L32:
        if (r26 != null) goto L34;
        String r22 = DownloadConstants.QUERY_KEY;
    L35:
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L38;
    L41:
        boolean r111 = true;
    L42:
        if (r111 == false) goto L45;
        ILogDepend.Companion.w(TAG, "playSongs: 歌曲列表为空");
        return d.c.b.a.b.a(1);
    L45:
        r13 = r27;
        r4.f14786a = r13;
        r4.f14787b = r12;
        r4.f14788c = r9;
        r4.f14789d = r8;
        r4.f14790e = r22;
        r4.h = 1;
        Object r23 = a(this, 0, r4, 1, null);
        if (r23 != r6) goto L48;
        return r6;
    L48:
        String r24 = r22;
        r5 = r23;
        r2 = r24;
        goto L49
    L38:
        if (r110.isEmpty() == true) goto L41;
        r111 = false;
        goto L42
    L34:
        r22 = "click_button";
        goto L35
    L30:
        r8 = null;
        goto L32
    L31:
        r8 = r9;
        goto L32
    L26:
        r9 = null;
        goto L27
    L23:
        r12 = null;
    L7:
        r4 = new f(this, r3);
        goto L8
    }
}
