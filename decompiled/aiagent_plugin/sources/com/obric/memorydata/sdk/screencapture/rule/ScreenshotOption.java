package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ScreenshotOption.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenshotOption implements Parcelable {
    public static final Parcelable.Creator<ScreenshotOption> CREATOR = null;
    private final ScreenshotCacheStrategy cacheStrategy;
    private final long delay;
    private final List<String> excludeLayerPackages;
    private final HeifOutputOption heifOutput;
    private final boolean onlyAppWindow;
    private final float scale;
    private final boolean useHardwareBuffer;

    /* JADX INFO: compiled from: ScreenshotOption.kt */
    public static final class Creator implements Parcelable.Creator<ScreenshotOption> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenshotOption createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            float r1 = r12.readFloat();
            if (r12.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            long r5 = r12.readLong();
            ScreenshotCacheStrategy r7 = (ScreenshotCacheStrategy) ZeusTransformUtils.preCheckCast(ScreenshotCacheStrategy.CREATOR.createFromParcel(r12), ScreenshotCacheStrategy.class, "com.obric.aiagent.plugin");
            List r9 = (List) ZeusTransformUtils.preCheckCast(r12.createStringArrayList(), List.class, "com.obric.aiagent.plugin");
            if (r12.readInt() == 0) goto L9;
            boolean r10 = true;
        L11:
            if (r12.readInt() != 0) goto L13;
            HeifOutputOption r13 = null;
        L15:
            return new ScreenshotOption(r1, r4, r5, r7, r9, r10, (HeifOutputOption) ZeusTransformUtils.preCheckCast(r13, HeifOutputOption.class, "com.obric.aiagent.plugin"));
        L13:
            r13 = HeifOutputOption.CREATOR.createFromParcel(r12);
            goto L15
        L9:
            r10 = false;
            goto L11
        L5:
            r4 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenshotOption createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ScreenshotOption[] newArray(int r1) {
            return new ScreenshotOption[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenshotOption[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ScreenshotOption() {
        this(0.0f, false, 0, null, null, false, null, 127, null);
    }

    public static /* synthetic */ ScreenshotOption copy$default(ScreenshotOption r9, float r10, boolean r11, long r12, ScreenshotCacheStrategy r14, List r15, boolean r16, HeifOutputOption r17, int r18, Object r19) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if ((r18 & 1) == 0) goto L5;
        float r2 = r9.scale;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r3 = r9.onlyAppWindow;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r4 = r9.delay;
    L15:
        if ((r18 & 8) == 0) goto L17;
        ScreenshotCacheStrategy r6 = r9.cacheStrategy;
    L19:
        if ((r18 & 16) == 0) goto L22;
        r1 = r9.excludeLayerPackages;
    L22:
        if ((r18 & 32) == 0) goto L24;
        boolean r7 = r9.useHardwareBuffer;
    L26:
        if ((r18 & 64) == 0) goto L28;
        HeifOutputOption r8 = r9.heifOutput;
    L30:
        return r9.copy(r2, r3, r4, r6, r1, r7, r8);
    L28:
        r8 = r17;
        goto L30
    L24:
        r7 = r16;
        goto L26
    L17:
        r6 = r14;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final float component1() {
        return this.scale;
    }

    public final boolean component2() {
        return this.onlyAppWindow;
    }

    public final long component3() {
        return this.delay;
    }

    public final ScreenshotCacheStrategy component4() {
        return this.cacheStrategy;
    }

    public final List<String> component5() {
        return this.excludeLayerPackages;
    }

    public final boolean component6() {
        return this.useHardwareBuffer;
    }

    public final HeifOutputOption component7() {
        return this.heifOutput;
    }

    public final ScreenshotOption copy(float r11, boolean r12, long r13, ScreenshotCacheStrategy r15, List<String> r16, boolean r17, HeifOutputOption r18) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        o.e(r15, "cacheStrategy");
        return new ScreenshotOption(r11, r12, r13, r15, r7, r17, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ScreenshotOption.class) == true) goto L8;
        return false;
    L8:
        ScreenshotOption r10 = (ScreenshotOption) ZeusTransformUtils.preCheckCast(r9, ScreenshotOption.class, "com.obric.aiagent.plugin");
        if (Float.compare(this.scale, r10.scale) == 0) goto L12;
        return false;
    L12:
        if (this.onlyAppWindow == r10.onlyAppWindow) goto L15;
        return false;
    L15:
        if (this.delay == r10.delay) goto L18;
        return false;
    L18:
        if (o.a(this.cacheStrategy, r10.cacheStrategy) == true) goto L21;
        return false;
    L21:
        if (o.a(this.excludeLayerPackages, r10.excludeLayerPackages) == true) goto L24;
        return false;
    L24:
        if (this.useHardwareBuffer == r10.useHardwareBuffer) goto L27;
        return false;
    L27:
        if (o.a(this.heifOutput, r10.heifOutput) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((Float.hashCode(this.scale) * 31) + Boolean.hashCode(this.onlyAppWindow)) * 31) + Long.hashCode(this.delay)) * 31) + this.cacheStrategy.hashCode()) * 31;
        List<String> r1 = this.excludeLayerPackages;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.useHardwareBuffer)) * 31;
        HeifOutputOption r5 = this.heifOutput;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ScreenshotOption(scale=" + this.scale + ", onlyAppWindow=" + this.onlyAppWindow + ", delay=" + this.delay + ", cacheStrategy=" + this.cacheStrategy + ", excludeLayerPackages=" + this.excludeLayerPackages + ", useHardwareBuffer=" + this.useHardwareBuffer + ", heifOutput=" + this.heifOutput + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeFloat(this.scale);
        r3.writeInt(this.onlyAppWindow ? 1 : 0);
        r3.writeLong(this.delay);
        this.cacheStrategy.writeToParcel(r3, r4);
        r3.writeStringList(this.excludeLayerPackages);
        r3.writeInt(this.useHardwareBuffer ? 1 : 0);
        HeifOutputOption r2 = this.heifOutput;
        if (r2 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r2.writeToParcel(r3, r4);
    }

    public ScreenshotOption(float r3, boolean r4, long r5, ScreenshotCacheStrategy r7, List<String> r8, boolean r9, HeifOutputOption r10) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "cacheStrategy");
        this.scale = r3;
        this.onlyAppWindow = r4;
        this.delay = r5;
        this.cacheStrategy = r7;
        this.excludeLayerPackages = r11;
        this.useHardwareBuffer = r9;
        this.heifOutput = r10;
        boolean r2 = false;
        if (r9 == false) goto L7;
        if (r10 == null) goto L7;
        boolean r6 = false;
    L8:
        if (r6 == false) goto L30;
        if (r4 == false) goto L13;
        if (r10 == null) goto L13;
        boolean r12 = false;
    L14:
        if (r12 == false) goto L28;
        if (r11 != null) goto L17;
    L19:
        boolean r13 = false;
    L20:
        if (r13 == false) goto L22;
        if (r10 == null) goto L22;
    L23:
        if (r2 == false) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("heifOutput is incompatible with excludeLayerPackages".toString());
    L22:
        r2 = true;
        goto L23
    L17:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L19;
        r13 = true;
        goto L20
    L28:
        throw new IllegalArgumentException("heifOutput is incompatible with onlyAppWindow".toString());
    L13:
        r12 = true;
        goto L14
    L30:
        throw new IllegalArgumentException("heifOutput is incompatible with useHardwareBuffer".toString());
    L7:
        r6 = true;
        goto L8
    }

    public final float getScale() {
        return this.scale;
    }

    public final boolean getOnlyAppWindow() {
        return this.onlyAppWindow;
    }

    public final long getDelay() {
        return this.delay;
    }

    public /* synthetic */ ScreenshotOption(float r11, boolean r12, long r13, ScreenshotCacheStrategy r15, List r16, boolean r17, HeifOutputOption r18, int r19, h r20) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if ((r19 & 1) == 0) goto L5;
        float r1 = 1.0f;
    L6:
        boolean r3 = false;
        if ((r19 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r19 & 4) == 0) goto L13;
        long r4 = 0;
    L14:
        HeifOutputOption r7 = null;
        if ((r19 & 8) == 0) goto L17;
        ScreenshotCacheStrategy r6 = new ScreenshotCacheStrategy(a.f33878b, null, 2, null);
    L19:
        if ((r19 & 16) == 0) goto L22;
        r0 = null;
    L22:
        if ((r19 & 32) != 0) goto L26;
        r3 = r17;
    L26:
        if ((r19 & 64) != 0) goto L29;
        r7 = r18;
    L29:
        this(r1, r2, r4, r6, r0, r3, r7);
        return;
    L17:
        r6 = r15;
        goto L19
    L13:
        r4 = r13;
        goto L14
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }

    public final ScreenshotCacheStrategy getCacheStrategy() {
        return this.cacheStrategy;
    }

    public final List<String> getExcludeLayerPackages() {
        return this.excludeLayerPackages;
    }

    public final boolean getUseHardwareBuffer() {
        return this.useHardwareBuffer;
    }

    public final HeifOutputOption getHeifOutput() {
        return this.heifOutput;
    }
}
