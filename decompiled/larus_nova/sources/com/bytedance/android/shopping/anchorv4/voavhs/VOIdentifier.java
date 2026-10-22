package com.bytedance.android.shopping.anchorv4.voavhs;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/VOIdentifier;", "Lcom/bytedance/android/ecom/arch/slice/adapter/a;", "", LocationMonitorConst.IDENTIFIER, "scrollId", "", "scrollAmount", "", "scrollConfig", "Lcom/bytedance/android/shopping/anchorv4/voavhs/h;", "config", "", "canDock", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", "newItem", "areItemsTheSame", "areContentsTheSame", "Lcom/bytedance/android/shopping/anchorv4/voavhs/h;", "Ljava/lang/String;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VOIdentifier extends com.bytedance.android.ecom.arch.slice.adapter.a {
    private final transient String identifier;
    private final h scrollConfig;

    public VOIdentifier() {
        super(0, 1, null);
        this.scrollConfig = new h(0);
        int r100 = o73.a.f522257a;
        this.identifier = UUID.randomUUID().toString();
    }

    public final boolean canDock() {
        return !Intrinsics.areEqual(this.scrollConfig.f168384a, "default");
    }

    public final h config() {
        return this.scrollConfig;
    }

    public String identifier() {
        return this.identifier;
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.a, com.bytedance.android.ecom.arch.slice.adapter.b
    public boolean areContentsTheSame(com.bytedance.android.ecom.arch.slice.adapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        return Intrinsics.areEqual(this, r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.a, com.bytedance.android.ecom.arch.slice.adapter.b
    public boolean areItemsTheSame(com.bytedance.android.ecom.arch.slice.adapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if ((r100 instanceof VOIdentifier) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(identifier(), ((VOIdentifier) r100).identifier()) == false) goto L7;
        return true;
    }

    public final void scrollConfig(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "scrollId");
        h r102 = this.scrollConfig;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f168384a = r100;
        this.scrollConfig.f168385b = r101;
    }

    public static /* synthetic */ void scrollConfig$default(VOIdentifier r100, String r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        r100.scrollConfig(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollConfig");
    }
}
