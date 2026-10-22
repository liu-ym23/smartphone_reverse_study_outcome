package a14;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.photo.viewmodel.AosPictureDetailViewModel;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;
import r14.c;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f1367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AosPictureDetailViewModel f1368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f1369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewModelStoreOwner f1370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Activity f1371f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f1366a, r101.f1366a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1367b, r101.f1367b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f1368c, r101.f1368c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f1369d, r101.f1369d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f1370e, r101.f1370e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f1371f, r101.f1371f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f1366a.hashCode() * 31) + this.f1367b.hashCode()) * 31) + this.f1368c.hashCode()) * 31) + this.f1369d.hashCode()) * 31) + this.f1370e.hashCode()) * 31) + this.f1371f.hashCode();
    }

    public final String toString() {
        return "PictureDetailParameters(aweme=" + this.f1366a + ", rootView=" + this.f1367b + ", viewModel=" + this.f1368c + ", lifecycleOwner=" + this.f1369d + ", viewModelStoreOwner=" + this.f1370e + ", activity=" + this.f1371f + ')';
    }

    public final Activity getActivity() {
        return this.f1371f;
    }

    public a(c r100, View r101, AosPictureDetailViewModel r102, LifecycleOwner r103, ViewModelStoreOwner r104, Activity r105) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        Intrinsics.checkNotNullParameter(r103, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r104, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r105, "activity");
        this.f1366a = r100;
        this.f1367b = r101;
        this.f1368c = r102;
        this.f1369d = r103;
        this.f1370e = r104;
        this.f1371f = r105;
    }
}
