package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputFunctionType;", "", "", "type", "I", "getType", "()I", "Common", "Special", "Function", "More", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputFunctionType extends Enum<InputFunctionType> {
    public static final InputFunctionType Common = null;
    public static final InputFunctionType Function = null;
    public static final InputFunctionType More = null;
    public static final InputFunctionType Special = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputFunctionType[] f135429a = null;
    private final int type;

    static {
        InputFunctionType r100 = new InputFunctionType("Common", 0, 1);
        Common = r100;
        InputFunctionType r101 = new InputFunctionType("Special", 1, 2);
        Special = r101;
        InputFunctionType r102 = new InputFunctionType("Function", 2, 3);
        Function = r102;
        InputFunctionType r103 = new InputFunctionType("More", 3, 4);
        More = r103;
        f135429a = new InputFunctionType[]{r100, r101, r102, r103};
    }

    public static InputFunctionType valueOf(String r100) {
        return (InputFunctionType) r27.a.a(InputFunctionType.class, r100);
    }

    public static InputFunctionType[] values() {
        return (InputFunctionType[]) f135429a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public InputFunctionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
