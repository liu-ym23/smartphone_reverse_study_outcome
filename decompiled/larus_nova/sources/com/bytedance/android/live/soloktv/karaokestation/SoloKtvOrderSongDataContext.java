package com.bytedance.android.live.soloktv.karaokestation;

import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/soloktv/karaokestation/SoloKtvOrderSongDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "commonOrderSongViewModel$delegate", "Lcom/bytedance/live/datacontext/p;", "getCommonOrderSongViewModel", "()Lcom/bytedance/live/datacontext/j;", "commonOrderSongViewModel", "Lcom/bytedance/android/live/soloktv/karaokestation/viewmodel/a;", "businessOrderSongViewModel$delegate", "getBusinessOrderSongViewModel", "businessOrderSongViewModel", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel$delegate", "getCommonSearchViewModel", "commonSearchViewModel", "<init>", "()V", "Companion", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvOrderSongDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final p businessOrderSongViewModel$delegate;
    private final p commonOrderSongViewModel$delegate;
    private final p commonSearchViewModel$delegate;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static SoloKtvOrderSongDataContext d() {
            DataContext r100 = d.d(SoloKtvOrderSongDataContext$Companion$getDataContext$1.INSTANCE);
            if ((r100 instanceof SoloKtvOrderSongDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (SoloKtvOrderSongDataContext) r100;
        }

        @JvmStatic
        public static com.bytedance.android.live.soloktv.karaokestation.viewmodel.a a() {
            SoloKtvOrderSongDataContext r100 = d();
            if (r100 == null) goto L7;
            j<com.bytedance.android.live.soloktv.karaokestation.viewmodel.a> r101 = r100.m8219getBusinessOrderSongViewModel();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public static b b() {
            SoloKtvOrderSongDataContext r100 = d();
            if (r100 == null) goto L7;
            j<b> r101 = r100.m8220getCommonOrderSongViewModel();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        @JvmStatic
        public static com.bytedance.android.live.ktv.common.search.viewmodel.a c() {
            SoloKtvOrderSongDataContext r100 = d();
            if (r100 == null) goto L7;
            j<com.bytedance.android.live.ktv.common.search.viewmodel.a> r101 = r100.m8221getCommonSearchViewModel();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SoloKtvOrderSongDataContext.class, "commonOrderSongViewModel", "getCommonOrderSongViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvOrderSongDataContext.class, "businessOrderSongViewModel", "getBusinessOrderSongViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvOrderSongDataContext.class, "commonSearchViewModel", "getCommonSearchViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new Companion();
    }

    @JvmStatic
    public static final com.bytedance.android.live.soloktv.karaokestation.viewmodel.a getBusinessOrderSongViewModel() {
        Companion.getClass();
        return Companion.a();
    }

    @JvmStatic
    public static final b getCommonOrderSongViewModel() {
        Companion.getClass();
        return Companion.b();
    }

    @JvmStatic
    public static final com.bytedance.android.live.ktv.common.search.viewmodel.a getCommonSearchViewModel() {
        Companion.getClass();
        return Companion.c();
    }

    @JvmStatic
    public static final SoloKtvOrderSongDataContext getDataContext() {
        Companion.getClass();
        return Companion.d();
    }

    /* JADX INFO: renamed from: getBusinessOrderSongViewModel, reason: collision with other method in class */
    public final j<com.bytedance.android.live.soloktv.karaokestation.viewmodel.a> m8219getBusinessOrderSongViewModel() {
        return (j) this.businessOrderSongViewModel$delegate.a(this, $$delegatedProperties[1]);
    }

    /* JADX INFO: renamed from: getCommonOrderSongViewModel, reason: collision with other method in class */
    public final j<b> m8220getCommonOrderSongViewModel() {
        return (j) this.commonOrderSongViewModel$delegate.a(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: renamed from: getCommonSearchViewModel, reason: collision with other method in class */
    public final j<com.bytedance.android.live.ktv.common.search.viewmodel.a> m8221getCommonSearchViewModel() {
        return (j) this.commonSearchViewModel$delegate.a(this, $$delegatedProperties[2]);
    }

    public SoloKtvOrderSongDataContext() {
        this.commonOrderSongViewModel$delegate = ConstantKt.c(this);
        this.businessOrderSongViewModel$delegate = ConstantKt.c(this);
        this.commonSearchViewModel$delegate = ConstantKt.c(this);
    }
}
