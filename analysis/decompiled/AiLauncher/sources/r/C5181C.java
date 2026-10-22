package r;

import android.util.Size;
import androidx.camera.camera2.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0004\"$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"", "Landroid/util/Size;", Const.INTENT_KEY_APIKEY, "([Landroid/util/Size;)[Landroid/util/Size;", "Landroid/util/Size;", "MINI_PREVIEW_SIZE_HUAWEI_MATE_9", "Ljava/util/Comparator;", "Lkotlin/Comparator;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Comparator;", "SIZE_COMPARATOR", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5181C {

    /* renamed from: a, reason: collision with root package name */
    public static final Size f38687a = new Size(320, 240);

    /* renamed from: b, reason: collision with root package name */
    public static final Comparator<Size> f38688b = new M.d();

    public static final Size[] a(Size[] sizeArr) {
        kotlin.jvm.internal.p.i(sizeArr, "<this>");
        if (((RepeatingStreamConstraintForVideoRecordingQuirk) q.f.f38470a.c(RepeatingStreamConstraintForVideoRecordingQuirk.class)) == null) {
            return sizeArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            if (f38688b.compare(size, f38687a) >= 0) {
                arrayList.add(size);
            }
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
