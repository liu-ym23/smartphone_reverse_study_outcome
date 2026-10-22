package com.bytedanceos.appstore.buss.network.demo;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.m0;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/demo/DemoActivity;", "Lcom/bytedanceos/appstore/buss/base/BaseActivity;", "<init>", "()V", "", "J", "initView", "initData", "I", "Lcom/bytedanceos/appstore/buss/network/demo/DemoViewModel;", "c", "Lkotlin/Lazy;", "K", "()Lcom/bytedanceos/appstore/buss/network/demo/DemoViewModel;", NetKey.MODEL, "", "H", "()I", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDemoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DemoActivity.kt\ncom/bytedanceos/appstore/buss/network/demo/DemoActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,44:1\n75#2,13:45\n*S KotlinDebug\n*F\n+ 1 DemoActivity.kt\ncom/bytedanceos/appstore/buss/network/demo/DemoActivity\n*L\n16#1:45,13\n*E\n"})
public final class DemoActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f8800c;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f8801a;

        public a(Function1 r10) {
            q.g(r10, "function");
            this.f8801a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f8801a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f8801a.invoke(r10);
        }
    }

    public DemoActivity() {
        Function0<ViewModelProvider.Factory> r10 = new DemoActivity$special$$inlined$viewModels$default$1(this);
        final Function0 r11 = null;
        this.f8800c = new m0(u.b(DemoViewModel.class), new DemoActivity$special$$inlined$viewModels$default$2(this), r10, new DemoActivity$special$$inlined$viewModels$default$3(r11, this));
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public int H() {
        return R.layout.activity_tv_demo;
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void I() {
        K().h();
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void J() {
        K().i().i(this, new a(DemoActivity$subscribeUi$1.INSTANCE));
    }

    public final DemoViewModel K() {
        return (DemoViewModel) this.f8800c.getValue();
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initData() {
    }

    @Override // com.bytedanceos.appstore.buss.base.BaseActivity
    public void initView() {
    }
}
