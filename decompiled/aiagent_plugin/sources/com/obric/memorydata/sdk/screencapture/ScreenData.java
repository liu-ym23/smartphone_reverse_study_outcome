package com.obric.memorydata.sdk.screencapture;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ScreenData.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenData implements Parcelable {
    public static final Parcelable.Creator<ScreenData> CREATOR = null;
    private HardwareBuffer hardwareBuffer;
    private String heifScreenshotPath;
    private boolean isVertical;
    private Bitmap screenshot;
    private List<ViewTreeNode> viewTree;

    /* JADX INFO: compiled from: ScreenData.kt */
    public static final class Creator implements Parcelable.Creator<ScreenData> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenData createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            Bitmap r3 = (Bitmap) ZeusTransformUtils.preCheckCast(r9.readParcelable(ScreenData.class.getClassLoader()), Bitmap.class, "com.obric.aiagent.plugin");
            HardwareBuffer r4 = (HardwareBuffer) ZeusTransformUtils.preCheckCast(r9.readParcelable(ScreenData.class.getClassLoader()), HardwareBuffer.class, "com.obric.aiagent.plugin");
            String r5 = r9.readString();
            int r0 = 0;
            if (r9.readInt() == 0) goto L5;
            boolean r6 = true;
        L7:
            if (r9.readInt() != 0) goto L9;
            ArrayList r8 = null;
        L14:
            return new ScreenData(r3, r4, r5, r6, (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"));
        L9:
            int r10 = r9.readInt();
            ArrayList r2 = new ArrayList(r10);
        L10:
            if (r0 == r10) goto L12;
            r2.add(ViewTreeNode.CREATOR.createFromParcel(r9));
            r0 = r0 + 1;
            goto L10
        L12:
            r8 = r2;
            goto L14
        L5:
            r6 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenData createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenData[] newArray(int r1) {
            return new ScreenData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenData[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ScreenData() {
        this(null, null, null, false, null, 31, null);
    }

    public static /* synthetic */ ScreenData copy$default(ScreenData r6, Bitmap r7, HardwareBuffer r8, String r9, boolean r10, List r11, int r12, Object r13) {
        List<ViewTreeNode> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.screenshot;
    L5:
        Bitmap r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.hardwareBuffer;
    L8:
        HardwareBuffer r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.heifScreenshotPath;
    L11:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.isVertical;
    L14:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.viewTree;
    L18:
        return r6.copy(r1, r2, r3, r4, r14);
    }

    public final Bitmap component1() {
        return this.screenshot;
    }

    public final HardwareBuffer component2() {
        return this.hardwareBuffer;
    }

    public final String component3() {
        return this.heifScreenshotPath;
    }

    public final boolean component4() {
        return this.isVertical;
    }

    public final List<ViewTreeNode> component5() {
        return this.viewTree;
    }

    public final ScreenData copy(Bitmap r7, HardwareBuffer r8, String r9, boolean r10, List<ViewTreeNode> r11) {
        return new ScreenData(r7, r8, r9, r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenData.class) == true) goto L8;
        return false;
    L8:
        ScreenData r6 = (ScreenData) ZeusTransformUtils.preCheckCast(r5, ScreenData.class, "com.obric.aiagent.plugin");
        if (o.a(this.screenshot, r6.screenshot) == true) goto L12;
        return false;
    L12:
        if (o.a(this.hardwareBuffer, r6.hardwareBuffer) == true) goto L15;
        return false;
    L15:
        if (o.a(this.heifScreenshotPath, r6.heifScreenshotPath) == true) goto L18;
        return false;
    L18:
        if (this.isVertical == r6.isVertical) goto L21;
        return false;
    L21:
        if (o.a(this.viewTree, r6.viewTree) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Bitmap r0 = this.screenshot;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HardwareBuffer r4 = this.hardwareBuffer;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.heifScreenshotPath;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + Boolean.hashCode(this.isVertical)) * 31;
        List<ViewTreeNode> r10 = this.viewTree;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ScreenData(screenshot=" + this.screenshot + ", hardwareBuffer=" + this.hardwareBuffer + ", heifScreenshotPath=" + this.heifScreenshotPath + ", isVertical=" + this.isVertical + ", viewTree=" + this.viewTree + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.screenshot, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.hardwareBuffer, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeString(this.heifScreenshotPath);
        r4.writeInt(this.isVertical ? 1 : 0);
        List<ViewTreeNode> r3 = this.viewTree;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r3.size());
        Iterator<ViewTreeNode> r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        ((ViewTreeNode) ZeusTransformUtils.preCheckCast(r6.next(), ViewTreeNode.class, "com.obric.aiagent.plugin")).writeToParcel(r4, r5);
        goto L7
    }

    public ScreenData(Bitmap r3, HardwareBuffer r4, String r5, boolean r6, List<ViewTreeNode> r7) {
        List<ViewTreeNode> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.screenshot = r3;
        this.hardwareBuffer = r4;
        this.heifScreenshotPath = r5;
        this.isVertical = r6;
        this.viewTree = r8;
    }

    public /* synthetic */ ScreenData(Bitmap r8, HardwareBuffer r9, String r10, boolean r11, List r12, int r13, h r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        Bitmap r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        HardwareBuffer r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r11 = false;
    L17:
        boolean r5 = r11;
        if ((r13 & 16) == 0) goto L20;
        List r6 = null;
    L21:
        this(r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r15;
        goto L21
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    public final void setScreenshot(Bitmap r1) {
        this.screenshot = r1;
    }

    public final HardwareBuffer getHardwareBuffer() {
        return this.hardwareBuffer;
    }

    public final void setHardwareBuffer(HardwareBuffer r1) {
        this.hardwareBuffer = r1;
    }

    public final String getHeifScreenshotPath() {
        return this.heifScreenshotPath;
    }

    public final void setHeifScreenshotPath(String r1) {
        this.heifScreenshotPath = r1;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final void setVertical(boolean r1) {
        this.isVertical = r1;
    }

    public final List<ViewTreeNode> getViewTree() {
        return this.viewTree;
    }

    public final void setViewTree(List<ViewTreeNode> r3) {
        this.viewTree = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
