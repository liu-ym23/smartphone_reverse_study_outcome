package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0004\rR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/DisplayImageListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/m;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "getOnSchemaHandleListener", "()Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "setOnSchemaHandleListener", "(Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;)V", "onSchemaHandleListener", "Lkotlin/Function0;", "", "b", "Lkotlin/jvm/functions/Function0;", "getRenderCallback", "()Lkotlin/jvm/functions/Function0;", "renderCallback", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplayImageListView extends FrameLayout implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f136461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f136462b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f136463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f136464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f136465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f136466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Drawable f136467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f136468f;

        public a(int r100, int r101) {
            this.f136463a = r100;
            this.f136464b = r101;
            this.f136465c = true;
            this.f136466d = 0.0f;
            this.f136467e = null;
            this.f136468f = false;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f136469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f136470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f136471c;

        public b(int r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "onAllLoadEndCallback");
            this.f136470b = r100;
            this.f136471c = r101;
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f136472a;

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.e
        public final void a() {
            this.f136472a.a();
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.e
        public final void b() {
            this.f136472a.b();
        }

        public c(CombinedTextRenderView.b r100) {
            this.f136472a = r100;
        }
    }

    public DisplayImageListView() {
        throw null;
    }

    public DisplayImageListView(Context r100) {
        this(r100, null, 0, null, 14);
    }

    public DisplayImageListView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, 12);
    }

    public DisplayImageListView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, null, 8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void f(com.bytedance.android.live.base.model.message.f r100, n r101) {
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return (r100 - 1) - r101;
    }

    public final o getOnSchemaHandleListener() {
        return this.f136461a;
    }

    public final Function0<Unit> getRenderCallback() {
        return this.f136462b;
    }

    public final void setOnSchemaHandleListener(o r100) {
        this.f136461a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void n(com.bytedance.android.live.base.model.message.f r100, n r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "comboItem");
        Intrinsics.checkNotNullParameter(r101, "comboListener");
        if (r100.d() != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.common.combinedtext.a.a(this, new c((CombinedTextRenderView.b) r101)).start();
    }

    public DisplayImageListView(Context r100, AttributeSet r101, int r102, Function0 r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = AnonymousClass1.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "renderCallback");
        super(r100, r101, r102);
        this.f136462b = r103;
        setChildrenDrawingOrderEnabled(true);
    }
}
