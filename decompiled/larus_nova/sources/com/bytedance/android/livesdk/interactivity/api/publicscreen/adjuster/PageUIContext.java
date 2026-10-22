package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/PageUIContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "videoBottom$delegate", "Lcom/bytedance/live/datacontext/p;", "getVideoBottom", "()Lcom/bytedance/live/datacontext/m;", "videoBottom", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/interactivity/api/base/a;", "interactUIInfo$delegate", "getInteractUIInfo", "()Lcom/bytedance/live/datacontext/n;", "interactUIInfo", "requestPkHeightIncludeMarginDefault$delegate", "getRequestPkHeightIncludeMarginDefault", "requestPkHeightIncludeMarginDefault", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageUIContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p interactUIInfo$delegate;
    private final p requestPkHeightIncludeMarginDefault$delegate;
    private final p videoBottom$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final PageUIContext getContext(DataCenter r100) {
            IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
            ViewModel r102 = null;
            if (r101 == null) goto L9;
            o r103 = IRoomContextService.a.a(r101, r100, 0, 2);
            if (r103 == null) goto L9;
            com.bytedance.live.datacontext.j<ViewModel> r104 = r103.t2();
            if (r104 == null) goto L9;
            ViewModel r105 = r104.getValue();
        L11:
            if ((r105 instanceof PageUIContext) == false) goto L15;
            r102 = r105;
        L15:
            return (PageUIContext) r102;
        L9:
            r105 = null;
            goto L11
        }

        @JvmStatic
        public final PageUIContext getContext(o r100) {
            Intrinsics.checkNotNullParameter(r100, "roomContext");
            com.bytedance.live.datacontext.j<ViewModel> r101 = r100.t2();
            ViewModel r102 = null;
            if (r101 == null) goto L5;
            ViewModel r103 = r101.getValue();
        L7:
            if ((r103 instanceof PageUIContext) == false) goto L11;
            r102 = r103;
        L11:
            return (PageUIContext) r102;
        L5:
            r103 = null;
            goto L7
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PageUIContext.class, "videoBottom", "getVideoBottom()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PageUIContext.class, "interactUIInfo", "getInteractUIInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PageUIContext.class, "requestPkHeightIncludeMarginDefault", "getRequestPkHeightIncludeMarginDefault()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final PageUIContext getContext(o r100) {
        return Companion.getContext(r100);
    }

    @JvmStatic
    public static final PageUIContext getContext(DataCenter r100) {
        return Companion.getContext(r100);
    }

    public final n<com.bytedance.android.livesdk.interactivity.api.base.a> getInteractUIInfo() {
        return (n) this.interactUIInfo$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Integer> getRequestPkHeightIncludeMarginDefault() {
        return (m) this.requestPkHeightIncludeMarginDefault$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Integer> getVideoBottom() {
        return (m) this.videoBottom$delegate.a(this, $$delegatedProperties[0]);
    }

    public PageUIContext() {
        this.videoBottom$delegate = q.d(this, 0);
        this.interactUIInfo$delegate = q.c(this);
        this.requestPkHeightIncludeMarginDefault$delegate = q.d(this, -10086);
    }
}
