package ai4;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f3771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long[] f3772c;

    public k(b r100, long[] r101) {
        this.f3771b = r100;
        this.f3772c = r101;
        this.f3770a = SieveCacheKt.NodeLinkMask;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        String[] r102 = r101.split("_");     // Catch: Throwable -> L11
        int r103 = CastIntegerProtector.parseInt(r102[0]);     // Catch: Throwable -> L11
        long r104 = CastLongProtector.parseLong(r102[1]);     // Catch: Throwable -> L11
        b r105 = this.f3771b;     // Catch: Throwable -> L11
        if (r103 != r105.f3741c) goto L10;
        long r106 = r105.f3740b - r104;     // Catch: Throwable -> L11
        if (r106 <= 0) goto L10;
        if (r106 >= this.f3770a) goto L10;
        this.f3772c[0] = r104;     // Catch: Throwable -> L11
        this.f3770a = r106;     // Catch: Throwable -> L11
    L10:
        return false;
    }
}
