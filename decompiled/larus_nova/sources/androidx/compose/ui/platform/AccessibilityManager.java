package androidx.compose.ui.platform;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityManager;", "", "calculateRecommendedTimeoutMillis", "", "originalTimeoutMillis", "containsIcons", "", "containsText", "containsControls", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AccessibilityManager {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AccessibilityManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ long calculateRecommendedTimeoutMillis$default(AccessibilityManager r100, long r101, boolean r110, boolean r111, boolean r112, int r113, Object r114) {
            if (r114 != null) goto L18;
            if ((r113 & 2) == 0) goto L6;
            boolean r102 = false;
        L8:
            if ((r113 & 4) == 0) goto L10;
            boolean r103 = false;
        L12:
            if ((r113 & 8) == 0) goto L14;
            boolean r104 = false;
        L16:
            return r100.calculateRecommendedTimeoutMillis(r101, r102, r103, r104);
        L14:
            r104 = r112;
            goto L16
        L10:
            r103 = r111;
            goto L12
        L6:
            r102 = r110;
            goto L8
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateRecommendedTimeoutMillis");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ long calculateRecommendedTimeoutMillis$default(AccessibilityManager r100, long r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
            return CC.calculateRecommendedTimeoutMillis$default(r100, r101, r102, r103, r104, r105, r106);
        }
    }

    long calculateRecommendedTimeoutMillis(long r100, boolean r101, boolean r102, boolean r103);
}
