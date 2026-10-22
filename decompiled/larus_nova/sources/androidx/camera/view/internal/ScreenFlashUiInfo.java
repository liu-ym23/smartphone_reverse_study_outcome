package androidx.camera.view.internal;

import androidx.camera.core.ImageCapture;
import java.util.Objects;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenFlashUiInfo {
    private final ProviderType mProviderType;
    private final ImageCapture.ScreenFlash mScreenFlash;

    public static final enum ProviderType extends Enum<ProviderType> {
        private static final /* synthetic */ ProviderType[] $VALUES = null;
        public static final ProviderType PREVIEW_VIEW = null;
        public static final ProviderType SCREEN_FLASH_VIEW = null;

        private static /* synthetic */ ProviderType[] $values() {
            return new ProviderType[]{PREVIEW_VIEW, SCREEN_FLASH_VIEW};
        }

        static {
            PREVIEW_VIEW = new ProviderType("PREVIEW_VIEW", 0);
            SCREEN_FLASH_VIEW = new ProviderType("SCREEN_FLASH_VIEW", 1);
            $VALUES = $values();
        }

        public static ProviderType[] values() {
            return (ProviderType[]) $VALUES.clone();
        }

        public static ProviderType valueOf(String r100) {
            return (ProviderType) a.a(ProviderType.class, r100);
        }

        private ProviderType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mProviderType, this.mScreenFlash});
    }

    public ProviderType getProviderType() {
        return this.mProviderType;
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScreenFlashUiInfo) == true) goto L8;
        return false;
    L8:
        ScreenFlashUiInfo r101 = (ScreenFlashUiInfo) r100;
        if (this.mProviderType == r101.mProviderType) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.mScreenFlash, r101.mScreenFlash) == false) goto L13;
        return true;
    }

    public ScreenFlashUiInfo(ProviderType r100, ImageCapture.ScreenFlash r101) {
        this.mProviderType = r100;
        this.mScreenFlash = r101;
    }
}
