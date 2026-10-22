package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilterHelper;", "", "<init>", "()V", "BlendModeColorFilter", "Landroid/graphics/BlendModeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "BlendModeColorFilter-xETnrds", "(JI)Landroid/graphics/BlendModeColorFilter;", "createBlendModeColorFilter", "Landroidx/compose/ui/graphics/BlendModeColorFilter;", "androidBlendModeColorFilter", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BlendModeColorFilterHelper {
    public static final BlendModeColorFilterHelper INSTANCE = null;

    static {
        INSTANCE = new BlendModeColorFilterHelper();
    }

    private BlendModeColorFilterHelper() {
    }

    public final BlendModeColorFilter createBlendModeColorFilter(android.graphics.BlendModeColorFilter r100) {
        return new BlendModeColorFilter(ColorKt.Color(r100.getColor()), AndroidBlendMode_androidKt.toComposeBlendMode(r100.getMode()), r100, null);
    }

    /* JADX INFO: renamed from: BlendModeColorFilter-xETnrds, reason: not valid java name */
    public final android.graphics.BlendModeColorFilter m4772BlendModeColorFilterxETnrds(long r100, int r101) {
        return new android.graphics.BlendModeColorFilter(ColorKt.m4881toArgb8_81llA(r100), AndroidBlendMode_androidKt.m4674toAndroidBlendModes9anfk8(r101));
    }
}
