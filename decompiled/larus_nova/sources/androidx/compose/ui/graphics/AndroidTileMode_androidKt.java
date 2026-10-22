package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidTileMode_androidKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Shader.TileMode.values().length];
            r100[Shader.TileMode.CLAMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Shader.TileMode.MIRROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Shader.TileMode.REPEAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    /* JADX INFO: renamed from: isSupported-0vamqd0, reason: not valid java name */
    public static final boolean m4730isSupported0vamqd0(int r100) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L8:
        return true;
    L5:
        if (TileMode.m5222equalsimpl0(r100, TileMode.Companion.m5227getDecal3opZhB0()) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m4731toAndroidTileMode0vamqd0(int r100) {
        TileMode.Companion r101 = TileMode.Companion;
        if (TileMode.m5222equalsimpl0(r100, r101.m5226getClamp3opZhB0()) == false) goto L6;
        return Shader.TileMode.CLAMP;
    L6:
        if (TileMode.m5222equalsimpl0(r100, r101.m5229getRepeated3opZhB0()) == false) goto L9;
        return Shader.TileMode.REPEAT;
    L9:
        if (TileMode.m5222equalsimpl0(r100, r101.m5228getMirror3opZhB0()) == false) goto L12;
        return Shader.TileMode.MIRROR;
    L12:
        if (TileMode.m5222equalsimpl0(r100, r101.m5227getDecal3opZhB0()) == false) goto L18;
        if (Build.VERSION.SDK_INT < 31) goto L23;
        return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
    L23:
        return Shader.TileMode.CLAMP;
    L18:
        return Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(Shader.TileMode r100) {
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 == 1) goto L17;
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L20;
        if (Build.VERSION.SDK_INT < 31) goto L19;
        if (r100 != Shader.TileMode.DECAL) goto L19;
        return TileModeVerificationHelper.INSTANCE.m5230getComposeTileModeDecal3opZhB0();
    L19:
        return TileMode.Companion.m5226getClamp3opZhB0();
    L20:
        return TileMode.Companion.m5229getRepeated3opZhB0();
    L21:
        return TileMode.Companion.m5228getMirror3opZhB0();
    L17:
        return TileMode.Companion.m5226getClamp3opZhB0();
    }
}
