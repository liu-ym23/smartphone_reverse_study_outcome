package com.bytedance.android.livesdk.drawer.relax;

import androidx.compose.material3.internal.TextFieldImplKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/SugTextType;", "", "", "value", "J", "getValue", "()J", TextFieldImplKt.PrefixId, "Middle", TextFieldImplKt.SuffixId, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SugTextType extends Enum<SugTextType> {
    public static final SugTextType Middle = null;
    public static final SugTextType Prefix = null;
    public static final SugTextType Suffix = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SugTextType[] f122575a = null;
    private final long value;

    static {
        SugTextType r100 = new SugTextType(TextFieldImplKt.PrefixId, 0, 0);
        Prefix = r100;
        SugTextType r101 = new SugTextType("Middle", 1, 1);
        Middle = r101;
        SugTextType r102 = new SugTextType(TextFieldImplKt.SuffixId, 2, 2);
        Suffix = r102;
        f122575a = new SugTextType[]{r100, r101, r102};
    }

    public static SugTextType valueOf(String r100) {
        return (SugTextType) r27.a.a(SugTextType.class, r100);
    }

    public static SugTextType[] values() {
        return (SugTextType[]) f122575a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public SugTextType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
