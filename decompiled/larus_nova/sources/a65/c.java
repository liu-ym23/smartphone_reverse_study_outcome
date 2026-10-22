package a65;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f1954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocMetaInfo f1956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1957d;

    public c(FragmentActivity r100, boolean r101, DocMetaInfo r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r103, "fileId");
        this.f1954a = r100;
        this.f1955b = r101;
        this.f1956c = r102;
        this.f1957d = r103;
    }
}
