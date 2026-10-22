package com.bytedance.android.livesdk.widgetdescriptor.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/widgetdescriptor/data/FlingViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/widgetdescriptor/data/FlingViewModel$a;", "status", "Landroidx/lifecycle/MutableLiveData;", "getStatus", "()Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlingViewModel extends ViewModel {
    private final MutableLiveData<a> status;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f162298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f162299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f162300c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f162298a == r101.f162298a) goto L8;
            return false;
        L8:
            if (Float.compare(this.f162299b, r101.f162299b) == 0) goto L10;
            return false;
        L10:
            if (this.f162300c == r101.f162300c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r100 = this.f162298a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = ((r102 * 31) + Float.floatToIntBits(this.f162299b)) * 31;
            boolean r104 = this.f162300c;
            if (r104 == true) goto L10;
            r101 = r104;
        L10:
            return r103 + r101;
        }

        public final String toString() {
            return "Status(show=" + this.f162298a + ", distance=" + this.f162299b + ", isAlpha=" + this.f162300c + ")";
        }

        public a(boolean r100, float r101, boolean r102) {
            this.f162298a = r100;
            this.f162299b = r101;
            this.f162300c = r102;
        }
    }

    public FlingViewModel() {
        this.status = new MutableLiveData();
    }

    public final MutableLiveData<a> getStatus() {
        return this.status;
    }
}
