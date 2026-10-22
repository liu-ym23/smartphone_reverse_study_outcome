package com.bytedance.android.livesdk.widgetdescriptor.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.layer.core.data.TetrisViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/widgetdescriptor/data/LandscapeInteractionModel;", "Lcom/bytedance/android/live/core/tetris/layer/core/data/TetrisViewModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/widgetdescriptor/data/LandscapeInteractionModel$b;", "landscapeInteractionInfo", "Landroidx/lifecycle/MutableLiveData;", "getLandscapeInteractionInfo", "()Landroidx/lifecycle/MutableLiveData;", "", "isLocked", "toolbarHideOrShowWithAnim", "getToolbarHideOrShowWithAnim", "toolbarLandscapeBlock", "getToolbarLandscapeBlock", "splitAreaShow", "getSplitAreaShow", "isInZoomState", "isInRefreshing", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeInteractionModel extends TetrisViewModel {
    public static final a Companion = null;
    public static final float bottomTranslateY = 60.0f;
    private final MutableLiveData<Boolean> isInRefreshing;
    private final MutableLiveData<Boolean> isInZoomState;
    private final MutableLiveData<Boolean> isLocked;
    private final MutableLiveData<b> landscapeInteractionInfo;
    private final MutableLiveData<Boolean> splitAreaShow;
    private final MutableLiveData<Boolean> toolbarHideOrShowWithAnim;
    private final MutableLiveData<Boolean> toolbarLandscapeBlock;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f162301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f162302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f162303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f162304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f162305e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f162306f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L18;
            b r101 = (b) r100;
            if (this.f162301a == r101.f162301a) goto L8;
            return false;
        L8:
            if (Float.compare(this.f162302b, r101.f162302b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f162303c, r101.f162303c) == 0) goto L12;
            return false;
        L12:
            if (this.f162304d == r101.f162304d) goto L14;
            return false;
        L14:
            if (this.f162305e == r101.f162305e) goto L16;
            return false;
        L16:
            if (this.f162306f == r101.f162306f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public final int hashCode() {
            boolean r100 = this.f162301a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = ((((r102 * 31) + Float.floatToIntBits(this.f162302b)) * 31) + Float.floatToIntBits(this.f162303c)) * 31;
            boolean r104 = this.f162304d;
            ?? r105 = r104;
            if (r104 == false) goto L8;
            r105 = 1;
        L8:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f162305e;
            ?? r108 = r107;
            if (r107 == false) goto L11;
            r108 = 1;
        L11:
            int r109 = (r106 + r108) * 31;
            boolean r110 = this.f162306f;
            if (r110 == true) goto L16;
            r101 = r110;
        L16:
            return r109 + r101;
        }

        public final String toString() {
            return "LandscapeInteractionInfo(isShowing=" + this.f162301a + ", bottomTranslate=" + this.f162302b + ", topTranslate=" + this.f162303c + ", keepLock=" + this.f162304d + ", dueToKeyBoard=" + this.f162305e + ", keepQuickShot=" + this.f162306f + ")";
        }

        public b(boolean r100, float r101, float r102, boolean r103, boolean r104) {
            this.f162301a = r100;
            this.f162302b = r101;
            this.f162303c = r102;
            this.f162304d = r103;
            this.f162305e = r104;
            this.f162306f = false;
        }
    }

    static {
        Companion = new a();
    }

    public LandscapeInteractionModel() {
        this.landscapeInteractionInfo = new MutableLiveData();
        this.isLocked = new MutableLiveData();
        this.toolbarHideOrShowWithAnim = new MutableLiveData();
        this.toolbarLandscapeBlock = new MutableLiveData();
        this.splitAreaShow = new MutableLiveData();
        MutableLiveData<Boolean> r100 = new MutableLiveData();
        Boolean r101 = Boolean.FALSE;
        r100.setValue(r101);
        Unit r102 = Unit.INSTANCE;
        this.isInZoomState = r100;
        MutableLiveData<Boolean> r103 = new MutableLiveData();
        r103.setValue(r101);
        this.isInRefreshing = r103;
    }

    public final MutableLiveData<b> getLandscapeInteractionInfo() {
        return this.landscapeInteractionInfo;
    }

    public final MutableLiveData<Boolean> getSplitAreaShow() {
        return this.splitAreaShow;
    }

    public final MutableLiveData<Boolean> getToolbarHideOrShowWithAnim() {
        return this.toolbarHideOrShowWithAnim;
    }

    public final MutableLiveData<Boolean> getToolbarLandscapeBlock() {
        return this.toolbarLandscapeBlock;
    }

    public final MutableLiveData<Boolean> isInRefreshing() {
        return this.isInRefreshing;
    }

    public final MutableLiveData<Boolean> isInZoomState() {
        return this.isInZoomState;
    }

    public final MutableLiveData<Boolean> isLocked() {
        return this.isLocked;
    }
}
