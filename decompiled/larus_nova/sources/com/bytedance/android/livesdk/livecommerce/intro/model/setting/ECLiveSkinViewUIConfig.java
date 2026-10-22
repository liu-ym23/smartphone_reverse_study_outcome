package com.bytedance.android.livesdk.livecommerce.intro.model.setting;

import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinImageElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\rHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\rHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/setting/ECLiveSkinViewUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "text", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTextElement;", "image", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "background", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;", "layout", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveLayoutConfig;", "radius", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTextElement;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveLayoutConfig;Ljava/util/List;)V", "getBackground", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;", "getImage", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "getLayout", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveLayoutConfig;", "getRadius", "()Ljava/util/List;", "getText", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTextElement;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinViewUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("bg")
    private final ECLiveSkinBackgroundElement background;

    @SerializedName("image")
    private final ECLiveSkinImageElement image;

    @SerializedName("layout")
    private final ECLiveLayoutConfig layout;

    @SerializedName("radius")
    private final List<Integer> radius;

    @SerializedName("text")
    private final ECLiveSkinTextElement text;

    public ECLiveSkinViewUIConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinViewUIConfig copy$default(ECLiveSkinViewUIConfig r100, ECLiveSkinTextElement r101, ECLiveSkinImageElement r102, ECLiveSkinBackgroundElement r103, ECLiveLayoutConfig r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.image;
    L8:
        ECLiveSkinImageElement r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.background;
    L11:
        ECLiveSkinBackgroundElement r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.layout;
    L14:
        ECLiveLayoutConfig r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.getRadius();
    L17:
        ECLiveSkinTextElement r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final ECLiveSkinTextElement component1() {
        return this.text;
    }

    public final ECLiveSkinImageElement component2() {
        return this.image;
    }

    public final ECLiveSkinBackgroundElement component3() {
        return this.background;
    }

    public final ECLiveLayoutConfig component4() {
        return this.layout;
    }

    public final List<Integer> component5() {
        return getRadius();
    }

    public final ECLiveSkinViewUIConfig copy(ECLiveSkinTextElement r100, ECLiveSkinImageElement r101, ECLiveSkinBackgroundElement r110, ECLiveLayoutConfig r111, List<Integer> r112) {
        return new ECLiveSkinViewUIConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinViewUIConfig) == false) goto L16;
        ECLiveSkinViewUIConfig r101 = (ECLiveSkinViewUIConfig) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.layout, r101.layout) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(getRadius(), r101.getRadius()) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        ECLiveSkinTextElement r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECLiveSkinImageElement r104 = this.image;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECLiveSkinBackgroundElement r107 = this.background;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECLiveLayoutConfig r110 = this.layout;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<Integer> r113 = getRadius();
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveSkinViewUIConfig(text=" + this.text + ", image=" + this.image + ", background=" + this.background + ", layout=" + this.layout + ", radius=" + getRadius() + ")";
    }

    public final ECLiveSkinBackgroundElement getBackground() {
        return this.background;
    }

    public final ECLiveSkinImageElement getImage() {
        return this.image;
    }

    public final ECLiveLayoutConfig getLayout() {
        return this.layout;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public final ECLiveSkinTextElement getText() {
        return this.text;
    }

    public ECLiveSkinViewUIConfig(ECLiveSkinTextElement r100, ECLiveSkinImageElement r101, ECLiveSkinBackgroundElement r102, ECLiveLayoutConfig r103, List<Integer> r104) {
        this.text = r100;
        this.image = r101;
        this.background = r102;
        this.layout = r103;
        this.radius = r104;
    }

    public /* synthetic */ ECLiveSkinViewUIConfig(ECLiveSkinTextElement r100, ECLiveSkinImageElement r101, ECLiveSkinBackgroundElement r102, ECLiveLayoutConfig r103, List r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        ECLiveSkinTextElement r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        ECLiveSkinImageElement r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        ECLiveSkinBackgroundElement r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        ECLiveLayoutConfig r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        List r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
