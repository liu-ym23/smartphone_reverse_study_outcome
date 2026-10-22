package androidx.fragment.app;

import android.os.Bundle;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a-\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b\u001a;\u0010\n\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0086\b¨\u0006\u000b"}, d2 = {"add", "Landroidx/fragment/app/FragmentTransaction;", FaceService.girlLabel, "Landroidx/fragment/app/Fragment;", "containerViewId", "", "tag", "", "args", "Landroid/os/Bundle;", "replace", "fragment-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.reifiedOperationMarker(4, FaceService.girlLabel);
        return r100.add(Fragment.class, r102, r101);
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction r100, int r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, FaceService.girlLabel);
        return r100.add(r101, Fragment.class, r103, r102);
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction r100, int r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, FaceService.girlLabel);
        return r100.replace(r101, Fragment.class, r103, r102);
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r100, String r101, Bundle r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.reifiedOperationMarker(4, FaceService.girlLabel);
        return r100.add(Fragment.class, r102, r101);
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction r100, int r101, String r102, Bundle r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, FaceService.girlLabel);
        return r100.add(r101, Fragment.class, r103, r102);
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction r100, int r101, String r102, Bundle r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.reifiedOperationMarker(4, FaceService.girlLabel);
        return r100.replace(r101, Fragment.class, r103, r102);
    }
}
