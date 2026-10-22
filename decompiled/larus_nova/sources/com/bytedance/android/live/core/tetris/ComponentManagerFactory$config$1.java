package com.bytedance.android.live.core.tetris;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.element.ElementBuilderMap;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g70.f;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ComponentManagerFactory$config$1 implements com.bytedance.android.live.core.tetris.componentx.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f65474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h70.b f65475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f65476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f65477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f70.a f65478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f65479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f65480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Runnable, Unit> f65481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f65482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f65483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.tetris.layer.view.a f65484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f65485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ DataCenter f65486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ List f65487n;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f65488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f65489b;

        @Override // g70.f
        public final boolean a() {
            return this.f65488a;
        }

        public a(ComponentManagerFactory$config$1 r100) {
            this.f65488a = ComponentManagerABHelper.INSTANCE.enableFullLog();
            this.f65489b = "ComponentManager_" + r100.f65485l;
        }

        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            ALogger.e(this.f65489b, r100);
        }

        @Override // g70.f
        public final void log(String r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            ALogger.i(this.f65489b, r100);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentManagerFactory$config$1 f65490a;

        public final r70.a<h70.b> a() {
            return this.f65490a.f65484k.f65871f;
        }

        public final ElementBuilderMap b() {
            ElementBuilderMap r100 = this.f65490a.f65484k.f65867b;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("elementBuilderMap");
        L5:
            return r100;
        }

        public final r70.b<h70.b> c() {
            return this.f65490a.f65484k.f65870e;
        }

        public final LayerEventDispatcher d() {
            LayerEventDispatcher r100 = this.f65490a.f65484k.f65869d;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layerEventDispatcher");
        L5:
            return r100;
        }

        public final Map<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> e() {
            return this.f65490a.f65484k.f65873h;
        }

        public final p70.b f() {
            return this.f65490a.f65484k.f65877l;
        }

        public final r70.a<h70.b> g() {
            return this.f65490a.f65484k.f65872g;
        }

        public final b80.a h() {
            return this.f65490a.f65484k.f65874i;
        }

        public final com.bytedance.android.live.core.tetris.layer.view.a.C1086a i() {
            return this.f65490a.f65484k.f65876k;
        }

        public b(ComponentManagerFactory$config$1 r100) {
            this.f65490a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentManagerFactory$config$1 f65491a;

        public final com.bytedance.android.live.core.tetris.layer.core.delegate.c<h70.b> a() {
            com.bytedance.android.live.core.tetris.layer.core.delegate.c<h70.b> r100 = this.f65491a.f65484k.f65866a;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layerDelegateConfig");
        L5:
            return r100;
        }

        public final Map<LayerIndex, Integer> b() {
            this.f65491a.f65484k.getClass();
            return null;
        }

        public c(ComponentManagerFactory$config$1 r100) {
            this.f65491a = r100;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final b a() {
        return this.f65480g;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final String b() {
        return this.f65477d;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final c c() {
        return this.f65479f;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final Function1<Runnable, Unit> d() {
        return this.f65481h;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final h70.b getComponentContext() {
        return this.f65475b;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public Context getContext() {
        return this.f65476c;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.a
    public final a getLogger() {
        return this.f65482i;
    }

    public ComponentManagerFactory$config$1(LifecycleOwner r100, com.bytedance.android.live.core.tetris.layer.view.a r101, Context r102, String r103, DataCenter r104, f70.a r105, List r106) {
        this.f65483j = r100;
        this.f65484k = r101;
        this.f65485l = r103;
        this.f65486m = r104;
        this.f65487n = r106;
        this.f65474a = r100;
        this.f65475b = r101.a();
        this.f65476c = r102;
        StringBuilder r107 = new StringBuilder();
        r107.append(r103);
        r107.append(':');
        if (r104 == null) goto L6;
        String r108 = c50.b.b(r104);
        if (r108 == null) goto L6;
    L7:
        r107.append(r108);
        this.f65477d = r107.toString();
        this.f65478e = r105;
        this.f65479f = new c(this);
        this.f65480g = new b(this);
        this.f65481h = new ComponentManagerFactory$config$1$cmcRunnableExecutor$1(this);
        this.f65482i = new a(this);
        return;
    L6:
        r108 = "null";
        goto L7
    }
}
