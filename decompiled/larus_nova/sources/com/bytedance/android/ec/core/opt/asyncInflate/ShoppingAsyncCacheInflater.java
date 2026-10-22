package com.bytedance.android.ec.core.opt.asyncInflate;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.opt.asyncInflate.AsyncCacheInflaterImpl;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0003\u001a\u00020\u0002H\u0017¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/opt/asyncInflate/ShoppingAsyncCacheInflater;", "Lcom/bytedance/android/ec/opt/asyncInflate/ICachedAsyncInflater;", "", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShoppingAsyncCacheInflater implements ICachedAsyncInflater {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Activity, ShoppingAsyncCacheInflater> f45261d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncCacheInflaterImpl f45262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f45263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f45264c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater$a$a, reason: collision with other inner class name */
        public static final class RunnableC0808a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ShoppingAsyncCacheInflater f45265a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f45266b;

            public RunnableC0808a(ShoppingAsyncCacheInflater r100, Activity r101) {
                this.f45265a = r100;
                this.f45266b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ((LifecycleOwner) this.f45266b).getLifecycle().addObserver(this.f45265a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static ShoppingAsyncCacheInflater a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r101 = e.getActivity(r100);
            if ((r101 instanceof LifecycleOwner) == false) goto L8;
            Map<Activity, ShoppingAsyncCacheInflater> r102 = ShoppingAsyncCacheInflater.f45261d;
            ShoppingAsyncCacheInflater r103 = (ShoppingAsyncCacheInflater) ((LinkedHashMap) r102).get(r101);
            if (r103 != null) goto L9;
            ShoppingAsyncCacheInflater r104 = new ShoppingAsyncCacheInflater(new AsyncCacheInflaterImpl(r101), r101, r100);
            new Handler(Looper.getMainLooper()).post(new RunnableC0808a(r104, r101));
            r102.put(r101, r104);
            return r104;
        L9:
            return r103;
        L8:
            return new ShoppingAsyncCacheInflater(null, null, r100);
        }
    }

    public static final class b implements com.bytedance.android.ec.opt.asyncInflate.b {
        public b() {
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.b
        public final com.bytedance.android.ec.opt.asyncInflate.b a(int r100, int r101) {
            return this;
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.b
        public final String commit() {
            return "";
        }
    }

    static {
        f45261d = new LinkedHashMap();
    }

    public final com.bytedance.android.ec.opt.asyncInflate.b a() {
        AsyncCacheInflaterImpl r100 = this.f45262a;
        if (r100 == null) goto L7;
        r100.getClass();
        return new AsyncCacheInflaterImpl.InflateTransactionImpl(r100);
    L7:
        return new b();
    }

    @Override // com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        AsyncCacheInflaterImpl r100 = this.f45262a;
        if (r100 == null) goto L5;
        r100.onDestroy();
    L5:
        Activity r101 = this.f45263b;
        if (r101 == null) goto L9;
        f45261d.remove(r101);
        return;
    }

    public final View b(String r100, ICachedAsyncInflater.b r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutId");
        AsyncCacheInflaterImpl r102 = this.f45262a;
        View r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.c(r100, r101);
    L6:
        if (r104 != null) goto L15;
        Activity r105 = this.f45263b;
        if (r105 == null) goto L14;
        if (r101 == null) goto L11;
        r103 = r101.a(r105);
    L11:
        if (r103 == null) goto L14;
        return r103;
    L14:
        throw new Exception("[Django] >> AsyncCacheInflater: no view and no viewCreator, name = " + r100 + ", activity = " + this.f45263b);
    L15:
        return r104;
    L5:
        r104 = null;
        goto L6
    }

    public ShoppingAsyncCacheInflater(AsyncCacheInflaterImpl r100, Activity r101, Context r102) {
        this.f45262a = r100;
        this.f45263b = r101;
        this.f45264c = r102;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final View aU(int r100, ViewGroup r101, boolean r102) {
        AsyncCacheInflaterImpl r103 = this.f45262a;
        if (r103 == null) goto L41;
        CopyOnWriteArraySet<View> r104 = r103.f47988a.get(Integer.valueOf(r100));
        if (r104 == null) goto L11;
        View r105 = AsyncCacheInflaterImpl.e(r104, false);
        if (r105 == null) goto L11;
        StringBuilder r106 = new StringBuilder("[Django] >> AsyncCacheInflater: preloadViewCaches has view, name = ");
        Map<Object, String> r107 = r103.f47993f;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        r106.append((String) r108.get(Integer.valueOf(r100)));
        String r109 = r106.toString();
        System.out.println(r109);
        r103.d(Integer.valueOf(r100), r105);
        if (r101 == null) goto L39;
        r101.addView(r105);
    L38:
        r105 = r101;
    L39:
        if (r105 == null) goto L41;
        return r105;
    L11:
        CopyOnWriteArraySet<View> r110 = r103.f47989b.get(Integer.valueOf(r100));
        if (r110 == null) goto L16;
        r105 = AsyncCacheInflaterImpl.e(r110, true);
        if (r105 == null) goto L16;
        StringBuilder r111 = new StringBuilder("[Django] >> AsyncCacheInflater: viewHolderItemViewCaches has view, name = ");
        Map<Object, String> r112 = r103.f47993f;
        LinkedHashMap r113 = (LinkedHashMap) r112;
        r111.append((String) r113.get(Integer.valueOf(r100)));
        String r114 = r111.toString();
        System.out.println(r114);
        r103.d(Integer.valueOf(r100), r105);
    L16:
        CopyOnWriteArraySet<View> r115 = r103.f47990c.get(Integer.valueOf(r100));
        if (r115 == null) goto L23;
        r105 = AsyncCacheInflaterImpl.e(r115, true);
        if (r105 == null) goto L23;
        StringBuilder r116 = new StringBuilder("[Django] >> AsyncCacheInflater: statefulViewCaches has view, name = ");
        Map<Object, String> r117 = r103.f47993f;
        LinkedHashMap r118 = (LinkedHashMap) r117;
        r116.append((String) r118.get(Integer.valueOf(r100)));
        String r119 = r116.toString();
        System.out.println(r119);
        r103.d(Integer.valueOf(r100), r105);
        if (r101 == null) goto L39;
        r101.addView(r105);
    L23:
        CopyOnWriteArraySet<View> r120 = r103.f47991d.get(Integer.valueOf(r100));
        if (r120 == null) goto L31;
        r105 = AsyncCacheInflaterImpl.e(r120, true);
        if (r105 == null) goto L31;
        StringBuilder r121 = new StringBuilder("[Django] >> AsyncCacheInflater: statelessViewCaches has view, name = ");
        Map<Object, String> r122 = r103.f47993f;
        LinkedHashMap r123 = (LinkedHashMap) r122;
        r121.append((String) r123.get(Integer.valueOf(r100)));
        String r124 = r121.toString();
        System.out.println(r124);
        r103.d(Integer.valueOf(r100), r105);
        if (r101 == null) goto L39;
        r101.addView(r105);
    L31:
        if (r103.f47993f.containsKey(Integer.valueOf(r100)) == false) goto L33;
        StringBuilder r125 = new StringBuilder("[Django] >> AsyncCacheInflater: no view, name = ");
        Map<Object, String> r126 = r103.f47993f;
        LinkedHashMap r127 = (LinkedHashMap) r126;
        r125.append((String) r127.get(Integer.valueOf(r100)));
        String r128 = r125.toString();
        System.out.println(r128);
    L33:
        r105 = LayoutInflater.from(r103.f47998k).cloneInContext(r103.f47998k).inflate(r100, r101, false);
        if (r103.f47993f.containsKey(Integer.valueOf(r100)) == false) goto L36;
        r103.d(Integer.valueOf(r100), r105);
    L36:
        if (r101 == null) goto L39;
        r101.addView(r105);
    L41:
        return th.a.c(this.f45264c, r100, r101, true);
    }
}
