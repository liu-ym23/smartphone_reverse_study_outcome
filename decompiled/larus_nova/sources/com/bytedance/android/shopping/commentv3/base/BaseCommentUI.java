package com.bytedance.android.shopping.commentv3.base;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.shopping.commentv3.base.a;
import com.bytedance.android.shopping.commentv3.base.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/base/b;", "State", "Lcom/bytedance/android/shopping/commentv3/base/a;", "Logic", "Lcom/bytedance/android/shopping/commentv3/base/BaseUI;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseCommentUI<State extends b, Logic extends com.bytedance.android.shopping.commentv3.base.a<State>> extends BaseUI<State, Logic> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f172662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f172663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.commentv3.data.b f172664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseCommentUI<?, ?> f172665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f172666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f172667h;

    public static final class a {
    }

    static {
    }

    public void j() {
    }

    @Override // com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter
    public Lifecycle rK() {
        BaseCommentUI<?, ?> r100 = this.f172665f;
        if (r100 == null) goto L7;
        Lifecycle r101 = r100.rK();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new InvalidLifecycle();
    }

    public BaseCommentUI() {
        this.f172667h = LazyKt.lazy(BaseCommentUI$childUiMap$2.INSTANCE);
    }

    public final String k() {
        return getClass().getSimpleName();
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public void onCreate() {
        super.onCreate();
        j();
    }

    public final Context getContext() {
        return this.f172663d;
    }

    public final int l(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "number");
        c r101 = this.f172666g;
        if (r101 == null) goto L6;
        return r101.a(r100);
    L6:
        return com.bytedance.android.shopping.extensions.b.b(r100);
    }

    public final float m(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "number");
        c r101 = this.f172666g;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "number");
        return r101.f172677d.f476337b.f476344f.invoke(r100).floatValue();
    L6:
        return com.bytedance.android.shopping.extensions.b.c(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(BaseCommentUI r100, BaseCommentUI r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ((Map) r100.f172667h.getValue()).put(r101.k(), r101);
        r101.f172665f = r100.f172665f;
        c r102 = r100.f172666g;
        r101.f172666g = r102;
        com.bytedance.android.shopping.commentv3.data.b r103 = null;
        if (r102 == null) goto L7;
        Fragment r104 = r102.f172675b;
        if (r104 == null) goto L7;
        Context r105 = r104.getContext();
    L8:
        r101.f172663d = r105;
        if (r102 == null) goto L11;
        com.bytedance.android.shopping.commentv3.data.b r106 = r102.f172678e;
    L12:
        r101.f172664e = r106;
        Logic r107 = r101.f172668a;
        if ((r107 instanceof BaseCommentLogic) == true) goto L15;
        r107 = null;
    L15:
        BaseCommentLogic r108 = (BaseCommentLogic) r107;
        if (r108 == null) goto L22;
        r108.f172659c = r102;
        if (r102 == null) goto L20;
        r103 = r102.f172678e;
    L20:
        r108.f172660d = r103;
    L22:
        if ((r101 instanceof d) == false) goto L31;
        c r109 = r100.f172666g;
        if (r109 == null) goto L31;
        CommentApiCenter r110 = r109.f172674a;
        if (r110 == null) goto L31;
        d r111 = (d) r101;
        Intrinsics.checkNotNullParameter(r111, "api");
        if (r110.a().contains(r111) == true) goto L31;
        r110.a().add(r111);
    L31:
        BaseCommentUI<?, ?> r112 = r100.f172665f;
        if (r112 == null) goto L37;
        Lifecycle r113 = r112.getLifecycle();
        if (r113 == null) goto L38;
        r113.addObserver(r101);
        return;
    L38:
        return;
    L37:
        return;
    L11:
        r106 = null;
    L7:
        r105 = null;
        goto L8
    }

    public static final boolean h(BaseCommentUI r100, BaseCommentUI r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        dm.a.b r102 = dm.a.f469202a;
        dm.a.a(r100.k()).i("canChildBeAttached, this.key: " + r100.k() + ", child: " + r101.k() + '}');
        Intrinsics.checkNotNullParameter(r101, "ui");
        if (((Map) r100.f172667h.getValue()).containsKey(r101.k()) == false) goto L5;
        dm.a.a(r100.k()).i("canChildBeAttached, has attached, child.key: ".concat(r101.k()));
        return false;
    L5:
        return true;
    }

    public static final void i(BaseCommentUI r100, BaseCommentUI r101) {
        Intrinsics.checkNotNullParameter(r101, "parent");
        dm.a.b r102 = dm.a.f469202a;
        dm.a.a(r100.k()).i("onAttached, this: " + r100.k() + ", parent: " + r101.k() + '}');
    }
}
