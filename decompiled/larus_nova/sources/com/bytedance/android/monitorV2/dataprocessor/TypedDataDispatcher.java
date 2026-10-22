package com.bytedance.android.monitorV2.dataprocessor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nz2.b;

/* JADX INFO: loaded from: classes12.dex */
public final class TypedDataDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f162995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f162996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<DataType, a> f162997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<DataType, List<Object>> f162998d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$DataType;", "", "WEB_VIEW", "LYNX_VIEW", "REPORT_DATA", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum DataType extends Enum<DataType> {
        public static final DataType LYNX_VIEW = null;
        public static final DataType REPORT_DATA = null;
        public static final DataType WEB_VIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f162999a = null;

        public static DataType valueOf(String r100) {
            return (DataType) r27.a.a(DataType.class, r100);
        }

        public static DataType[] values() {
            return (DataType[]) f162999a.clone();
        }

        static {
            DataType r100 = new DataType("WEB_VIEW", 0);
            WEB_VIEW = r100;
            DataType r101 = new DataType("LYNX_VIEW", 1);
            LYNX_VIEW = r101;
            DataType r102 = new DataType("REPORT_DATA", 2);
            REPORT_DATA = r102;
            f162999a = new DataType[]{r100, r101, r102};
        }

        public DataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void d() {
        Lazy r100 = HybridMonitorSingleExecutor.f163031a;
        HybridMonitorSingleExecutor.a(new TypedDataDispatcher$notifyAllEvents$1(this));
    }

    public TypedDataDispatcher() {
        this.f162995a = "DataProcessorManager";
        this.f162996b = true;
        new Handler(Looper.getMainLooper());
        this.f162997c = new HashMap();
        this.f162998d = new HashMap();
    }

    public final void b(DataType r100, Object r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f162996b == false) goto L16;
        List<Object> r102 = this.f162998d.get(r100);
        if (r102 == null) goto L9;
        r102.add(r101);
    L10:
        List<Object> r103 = this.f162998d.get(r100);
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.size() <= 1000) goto L19;
        d();
        b.b(this.f162995a, r100 + " pending list is too large! current size has more than 1000");
        return;
    L19:
        return;
    L9:
        this.f162998d.put(r100, CollectionsKt.arrayListOf(new Object[]{r101}));
        goto L10
    L16:
        c(r100, r101);
    }

    public final void c(DataType r100, Object r101) {
        if (this.f162997c.containsKey(r100) == false) goto L7;
        a r102 = this.f162997c.get(r100);
        Intrinsics.checkNotNull(r102);
        r102.a(r101);
        return;
    L7:
        throw new UnsupportedOperationException("not found processor");
    }

    public final void a(final DataType r100, final Object r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        kz2.a.C6634a r103 = kz2.a.f506727a;
        if (r102 == false) goto L5;
        Lazy r104 = HybridMonitorSingleExecutor.f163031a;
        HybridMonitorSingleExecutor.a(new TypedDataDispatcher$enqueue$1(this, r100, r101));
        return;
    L5:
        b(r100, r101);
    }
}
