package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<AvatarGender, Sticker> f72761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Sticker f72762b;

    public interface a {
        void a(Sticker r100);

        void onError(Exception r100);
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f72763a;

        public b(WeakReference r100) {
            this.f72763a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            y.f72762b = r100;
            WeakReference r101 = this.f72763a;
            if (r101 == null) goto L8;
            a r102 = (a) r101.get();
            if (r102 == null) goto L9;
            r102.a(r100);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            WeakReference r101 = this.f72763a;
            if (r101 == null) goto L8;
            a r102 = (a) r101.get();
            if (r102 == null) goto L9;
            r102.onError(r100);
            return;
        L9:
            return;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarGender f72764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f72765b;

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            Map<AvatarGender, Sticker> r101 = y.f72761a;
            y.f72761a.put(this.f72764a, r100);
            WeakReference r102 = this.f72765b;
            if (r102 == null) goto L8;
            a r103 = (a) r102.get();
            if (r103 == null) goto L9;
            r103.a(r100);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            WeakReference r101 = this.f72765b;
            if (r101 == null) goto L8;
            a r102 = (a) r101.get();
            if (r102 == null) goto L9;
            r102.onError(r100);
            return;
        L9:
            return;
        }

        public c(AvatarGender r100, WeakReference r101) {
            this.f72764a = r100;
            this.f72765b = r101;
        }
    }

    static {
        f72761a = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(a r100) {
        Sticker r101 = f72762b;
        if (r101 == null) goto L7;
        if (r100 == null) goto L12;
        r100.a(r101);
        return;
    L12:
        return;
    L7:
        if (r100 == null) goto L9;
        WeakReference r102 = new WeakReference(r100);
    L10:
        String r103 = i.f72640a;
        b r104 = new b(r102);
        LiveEffectContextFactoryType r105 = LiveEffectContextFactoryType.DEFAULT;
        Intrinsics.checkNotNullParameter(r105, "type");
        EffectManager r106 = ((IMiddlewareEffectService) jc1.k.n(IMiddlewareEffectService.class)).effectContext(r105).getEffectManager();
        Intrinsics.checkNotNullParameter(r105, "type");
        ((IMiddlewareEffectService) jc1.k.n(IMiddlewareEffectService.class)).effectContext(r105).c().a().a("livedigitavatar", new z(r103, r106, r104));
        return;
    L9:
        r102 = null;
        goto L10
    }

    @JvmStatic
    public static final void b(AvatarGender r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "gender");
        Sticker r102 = (Sticker) ((LinkedHashMap) f72761a).get(r100);
        if (r102 == null) goto L7;
        if (r101 == null) goto L12;
        r101.a(r102);
        return;
    L12:
        return;
    L7:
        if (r101 == null) goto L9;
        WeakReference r103 = new WeakReference(r101);
    L10:
        String r104 = r100.getStickId();
        c r105 = new c(r100, r103);
        LiveEffectContextFactoryType r106 = LiveEffectContextFactoryType.DEFAULT;
        Intrinsics.checkNotNullParameter(r106, "type");
        EffectManager r107 = ((IMiddlewareEffectService) jc1.k.n(IMiddlewareEffectService.class)).effectContext(r106).getEffectManager();
        Intrinsics.checkNotNullParameter(r106, "type");
        ((IMiddlewareEffectService) jc1.k.n(IMiddlewareEffectService.class)).effectContext(r106).c().a().a("livedigitavatar", new z(r104, r107, r105));
        return;
    L9:
        r103 = null;
        goto L10
    }
}
