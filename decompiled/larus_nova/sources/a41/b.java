package a41;

import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HSImageView f1737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HSImageView f1738f;

    public b(HSImageView r100, HSImageView r101) {
        this.f1737e = r100;
        this.f1738f = r101;
    }

    public final void a(String r100, String r101) {
        if (t41.a.f544564m.a() == true) goto L5;
    L9:
        ImageLoader.bindImage(this.f1737e, r100);
        ImageLoader.bindImage(this.f1738f, r101);
        this.f1735c = r100;
        this.f1736d = r101;
        return;
    L5:
        if (Intrinsics.areEqual(r100, this.f1735c) == false) goto L9;
        if (Intrinsics.areEqual(r101, this.f1736d) == false) goto L9;
    }
}
