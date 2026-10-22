package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/KtvComponentLyricText;", "", "", "value", "I", "getValue", "()I", "Component_Default", "Component_HighScoreSong", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvComponentLyricText extends Enum<KtvComponentLyricText> {
    public static final KtvComponentLyricText Component_Default = null;
    public static final KtvComponentLyricText Component_HighScoreSong = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvComponentLyricText[] f153562a = null;
    private final int value;

    static {
        KtvComponentLyricText r100 = new KtvComponentLyricText("Component_Default", 0, 0);
        Component_Default = r100;
        KtvComponentLyricText r101 = new KtvComponentLyricText("Component_HighScoreSong", 1, 1);
        Component_HighScoreSong = r101;
        f153562a = new KtvComponentLyricText[]{r100, r101};
    }

    public static KtvComponentLyricText valueOf(String r100) {
        return (KtvComponentLyricText) r27.a.a(KtvComponentLyricText.class, r100);
    }

    public static KtvComponentLyricText[] values() {
        return (KtvComponentLyricText[]) f153562a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public KtvComponentLyricText(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
