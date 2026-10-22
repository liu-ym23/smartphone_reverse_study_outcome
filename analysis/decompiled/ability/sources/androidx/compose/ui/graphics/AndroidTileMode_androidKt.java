package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.graphics.TileMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidTileMode_androidKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shader.TileMode.values().length];
            try {
                iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: isSupported-0vamqd0, reason: not valid java name */
    public static final boolean m4042isSupported0vamqd0(int i) {
        return true;
    }

    /* renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m4043toAndroidTileMode0vamqd0(int i) {
        TileMode.Companion companion = TileMode.INSTANCE;
        return TileMode.m4524equalsimpl0(i, companion.m4528getClamp3opZhB0()) ? Shader.TileMode.CLAMP : TileMode.m4524equalsimpl0(i, companion.m4531getRepeated3opZhB0()) ? Shader.TileMode.REPEAT : TileMode.m4524equalsimpl0(i, companion.m4530getMirror3opZhB0()) ? Shader.TileMode.MIRROR : TileMode.m4524equalsimpl0(i, companion.m4529getDecal3opZhB0()) ? TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal() : Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(Shader.TileMode tileMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? tileMode == Shader.TileMode.DECAL ? TileModeVerificationHelper.INSTANCE.m4532getComposeTileModeDecal3opZhB0() : TileMode.INSTANCE.m4528getClamp3opZhB0() : TileMode.INSTANCE.m4531getRepeated3opZhB0() : TileMode.INSTANCE.m4530getMirror3opZhB0() : TileMode.INSTANCE.m4528getClamp3opZhB0();
    }
}
