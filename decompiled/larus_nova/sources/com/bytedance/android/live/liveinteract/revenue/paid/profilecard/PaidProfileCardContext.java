package com.bytedance.android.live.liveinteract.revenue.paid.profilecard;

import cj0.d;
import com.bytedance.android.live.liveinteract.plantform.base.j;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/PaidProfileCardContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcj0/d;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/plantform/base/j;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/PaidProfileCardContext$b;", "paidProfileCardPosition$delegate", "getPaidProfileCardPosition", "()Lcom/bytedance/live/datacontext/n;", "paidProfileCardPosition", "Lcom/bytedance/android/live/liveinteract/api/data/b;", "paidProfileCardData$delegate", "getPaidProfileCardData", "paidProfileCardData", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidProfileCardContext extends DataContext implements d {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p paidProfileCardData$delegate;
    private final p paidProfileCardPosition$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final PaidProfileCardContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(d.class);
            if ((r100 instanceof PaidProfileCardContext) == true) goto L6;
            r100 = null;
        L6:
            return (PaidProfileCardContext) r100;
        }

        public final j a() {
            PaidProfileCardContext r100 = getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<j> r101 = r100.getService();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f78551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f78554d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f78555e;

        public b(int r100, int r101, int r102, int r103) {
            this.f78551a = r100;
            this.f78552b = 0;
            this.f78553c = r101;
            this.f78554d = r102;
            this.f78555e = r103;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PaidProfileCardContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PaidProfileCardContext.class, "paidProfileCardPosition", "getPaidProfileCardPosition()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PaidProfileCardContext.class, "paidProfileCardData", "getPaidProfileCardData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public final n<com.bytedance.android.live.liveinteract.api.data.b> getPaidProfileCardData() {
        return (n) this.paidProfileCardData$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<b> getPaidProfileCardPosition() {
        return (n) this.paidProfileCardPosition$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<j> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public PaidProfileCardContext() {
        this.service$delegate = ConstantKt.c(this);
        this.paidProfileCardPosition$delegate = q.c(this);
        this.paidProfileCardData$delegate = q.c(this);
    }
}
