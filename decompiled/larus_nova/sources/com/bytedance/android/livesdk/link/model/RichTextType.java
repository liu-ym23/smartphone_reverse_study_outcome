package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/RichTextType;", "", "", "value", "I", "getValue", "()I", "RichTextTypeUnknown", "RichTextTypeText", "RichTextTypeImg", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RichTextType extends Enum<RichTextType> {
    public static final RichTextType RichTextTypeImg = null;
    public static final RichTextType RichTextTypeText = null;
    public static final RichTextType RichTextTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RichTextType[] f147079a = null;
    private final int value;

    static {
        RichTextType r100 = new RichTextType("RichTextTypeUnknown", 0, 0);
        RichTextTypeUnknown = r100;
        RichTextType r101 = new RichTextType("RichTextTypeText", 1, 1);
        RichTextTypeText = r101;
        RichTextType r102 = new RichTextType("RichTextTypeImg", 2, 2);
        RichTextTypeImg = r102;
        f147079a = new RichTextType[]{r100, r101, r102};
    }

    public static RichTextType valueOf(String r100) {
        return (RichTextType) r27.a.a(RichTextType.class, r100);
    }

    public static RichTextType[] values() {
        return (RichTextType[]) f147079a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RichTextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
