package com.obric.autogui.common.api.platform.system.viewhierarchy;

import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: VHNode.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface VHNode {

    /* JADX INFO: compiled from: VHNode.kt */
    public static final class Bounds {
        private final int height;
        private final int left;
        private final int screenBottom;
        private final int screenLeft;
        private final int screenRight;
        private final int screenTop;
        private final int top;
        private final int width;

        public Bounds(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
            this.left = r1;
            this.top = r2;
            this.screenLeft = r3;
            this.screenTop = r4;
            this.screenRight = r5;
            this.screenBottom = r6;
            this.width = r7;
            this.height = r8;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getScreenLeft() {
            return this.screenLeft;
        }

        public final int getScreenTop() {
            return this.screenTop;
        }

        public final int getScreenRight() {
            return this.screenRight;
        }

        public final int getScreenBottom() {
            return this.screenBottom;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public String toString() {
            return new StringBuilder().append('(').append(this.screenLeft).append(',').append(this.screenTop).append(',').append(this.screenRight).append(',').append(this.screenBottom).append('|').append(this.width).append('x').append(this.height).append(')').toString();
        }
    }

    /* JADX INFO: compiled from: VHNode.kt */
    public static final class DefaultImpls {
        public static List<VHNode> getChildren(VHNode r2) {
            VHNode r3 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin");
            return p.b();
        }

        public static void dump(VHNode r2, StringBuilder r3) {
            VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin");
            o.e(r3, "sb");
            r3.append(r4.getClassName()).append('@').append(r4.getId());
        }

        public static VHNodeComparison compareTo(VHNode r8, VHNode r9) {
            VHNode r10 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r8, VHNode.class, "com.obric.aiagent.plugin");
            VHNode r11 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r9, VHNode.class, "com.obric.aiagent.plugin");
            if (r11 != null) goto L7;
            return new VHNodeComparison(false, true, "null-check");
        L7:
            if (r11.getClassName() == null) goto L15;
            if (r10.getClassName() == null) goto L15;
            if (o.a(r10.getClassName(), r11.getClassName()) == true) goto L15;
            return new VHNodeComparison(false, true, "class-check");
        L15:
            return new VHNodeComparison(false, false, null, 6, null);
        }
    }

    /* JADX INFO: compiled from: VHNode.kt */
    public static final class VHNodeComparison {
        private final boolean exact;
        private final boolean isSame;
        private final String servedMethod;

        public static /* synthetic */ VHNodeComparison copy$default(VHNodeComparison r0, boolean r1, boolean r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.isSame;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.exact;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.servedMethod;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.isSame;
        }

        public final boolean component2() {
            return this.exact;
        }

        public final String component3() {
            return this.servedMethod;
        }

        public final VHNodeComparison copy(boolean r1, boolean r2, String r3) {
            o.e(r3, "servedMethod");
            return new VHNodeComparison(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, VHNodeComparison.class) == true) goto L8;
            return false;
        L8:
            VHNodeComparison r6 = (VHNodeComparison) ZeusTransformUtils.preCheckCast(r5, VHNodeComparison.class, "com.obric.aiagent.plugin");
            if (this.isSame == r6.isSame) goto L12;
            return false;
        L12:
            if (this.exact == r6.exact) goto L15;
            return false;
        L15:
            if (o.a(this.servedMethod, r6.servedMethod) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isSame) * 31) + Boolean.hashCode(this.exact)) * 31) + this.servedMethod.hashCode();
        }

        public String toString() {
            return "VHNodeComparison(isSame=" + this.isSame + ", exact=" + this.exact + ", servedMethod=" + this.servedMethod + ')';
        }

        public VHNodeComparison(boolean r2, boolean r3, String r4) {
            o.e(r4, "servedMethod");
            this.isSame = r2;
            this.exact = r3;
            this.servedMethod = r4;
        }

        public /* synthetic */ VHNodeComparison(boolean r1, boolean r2, String r3, int r4, h r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = DownloadSettingKeys.BugFix.DEFAULT;
        L8:
            this(r1, r2, r3);
        }

        public final boolean isSame() {
            return this.isSame;
        }

        public final boolean getExact() {
            return this.exact;
        }

        public final String getServedMethod() {
            return this.servedMethod;
        }
    }

    VHNodeComparison compareTo(VHNode r1);

    void dump(StringBuilder r1);

    Bounds getBounds();

    List<VHNode> getChildren();

    String getClassName();

    CharSequence getHint();

    String getId();

    int getInputType();

    VHNode getParent();

    CharSequence getText();

    int getVisibility();

    boolean isClickable();

    boolean isEnabled();

    boolean isFocused();

    boolean isLongClickable();
}
