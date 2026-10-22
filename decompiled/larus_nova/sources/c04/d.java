package c04;

import android.content.SharedPreferences;
import com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AoKVStorageService f21915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SharedPreferences f21916b = null;

    static {
        IBdpService r100 = j64.a.a(AoKVStorageService.class);
        Intrinsics.checkNotNull(r100);
        AoKVStorageService r101 = (AoKVStorageService) r100;
        f21915a = r101;
        f21916b = r101.h(y54.a.a(), "long_press_speed");
    }
}
