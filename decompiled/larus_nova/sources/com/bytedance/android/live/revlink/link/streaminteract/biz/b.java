package com.bytedance.android.live.revlink.link.streaminteract.biz;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import java.util.List;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r41.e;
import y41.f;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f98779a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f98780b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData<String> f98781c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List<? extends IRegion> f98782d;

    static {
        f r100 = f.N;
        r100.getClass();
        ReadOnlyProperty r101 = f.L;
        KProperty<?>[] r102 = f.f565960a;
        f98779a = ((e) r101.getValue(r100, r102[36])).getEnabled();
        f98780b = ((e) r101.getValue(r100, r102[36])).H2();
        f98781c = new MutableLiveData();
    }
}
