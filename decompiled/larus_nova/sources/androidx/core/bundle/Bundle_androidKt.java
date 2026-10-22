package androidx.core.bundle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022.\u0010\u0003\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0002\u0010\b*\n\u0010\t\"\u00020\u00012\u00020\u0001¨\u0006\n"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "Landroidx/core/bundle/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "Bundle", "core-bundle_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Bundle_androidKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        return BundleKt.bundleOf((Pair[]) Arrays.copyOf(r100, r100.length));
    }
}
