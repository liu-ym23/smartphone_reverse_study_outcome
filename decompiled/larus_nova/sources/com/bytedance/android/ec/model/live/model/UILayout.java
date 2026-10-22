package com.bytedance.android.ec.model.live.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/model/live/model/UILayout;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Normal", "Enlarge", "FullEnlarge", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum UILayout extends Enum<UILayout> {
    public static final a Companion = null;
    public static final UILayout Enlarge = null;
    public static final UILayout FullEnlarge = null;
    public static final UILayout Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UILayout[] f47889a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.ec.model.live.model.UILayout$a] */
    static {
        UILayout r100 = new UILayout("Normal", 0, 0);
        Normal = r100;
        UILayout r101 = new UILayout("Enlarge", 1, 1);
        Enlarge = r101;
        UILayout r102 = new UILayout("FullEnlarge", 2, 2);
        FullEnlarge = r102;
        f47889a = new UILayout[]{r100, r101, r102};
        Companion = new a();
    }

    public static UILayout valueOf(String r100) {
        return (UILayout) r27.a.a(UILayout.class, r100);
    }

    public static UILayout[] values() {
        return (UILayout[]) f47889a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UILayout(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
