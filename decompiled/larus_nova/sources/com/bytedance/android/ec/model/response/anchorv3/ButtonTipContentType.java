package com.bytedance.android.ec.model.response.anchorv3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipContentType;", "", "", "contentType", "I", "getContentType", "()I", "PURE_TEXT", "COUNTDOWN_TO_END_TIME", "COUNTDOWN_TO_BEGIN_TIME", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum ButtonTipContentType extends Enum<ButtonTipContentType> {
    public static final ButtonTipContentType COUNTDOWN_TO_BEGIN_TIME = null;
    public static final ButtonTipContentType COUNTDOWN_TO_END_TIME = null;
    public static final ButtonTipContentType PURE_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonTipContentType[] f47928a = null;
    private final int contentType;

    static {
        ButtonTipContentType r100 = new ButtonTipContentType("PURE_TEXT", 0, 1);
        PURE_TEXT = r100;
        ButtonTipContentType r101 = new ButtonTipContentType("COUNTDOWN_TO_END_TIME", 1, 2);
        COUNTDOWN_TO_END_TIME = r101;
        ButtonTipContentType r102 = new ButtonTipContentType("COUNTDOWN_TO_BEGIN_TIME", 2, 3);
        COUNTDOWN_TO_BEGIN_TIME = r102;
        f47928a = new ButtonTipContentType[]{r100, r101, r102};
    }

    public static ButtonTipContentType valueOf(String r100) {
        return (ButtonTipContentType) r27.a.a(ButtonTipContentType.class, r100);
    }

    public static ButtonTipContentType[] values() {
        return (ButtonTipContentType[]) f47928a.clone();
    }

    public final int getContentType() {
        return this.contentType;
    }

    public ButtonTipContentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.contentType = r102;
    }
}
