package com.obric.oui.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OBasicPanel$PadCompatConfig {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "BLACK_NO_BG", "WHITE_WITH_BG", "BLACK_WITH_BG", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
        public static final CloseIconStyle BLACK_NO_BG = null;
        public static final CloseIconStyle BLACK_WITH_BG = null;
        public static final CloseIconStyle WHITE_WITH_BG = null;

        private static final /* synthetic */ CloseIconStyle[] $values() {
            return new CloseIconStyle[]{BLACK_NO_BG, WHITE_WITH_BG, BLACK_WITH_BG};
        }

        static {
            BLACK_NO_BG = new CloseIconStyle("BLACK_NO_BG", 0);
            WHITE_WITH_BG = new CloseIconStyle("WHITE_WITH_BG", 1);
            BLACK_WITH_BG = new CloseIconStyle("BLACK_WITH_BG", 2);
            $VALUES = $values();
        }

        private CloseIconStyle(String r10, int r11) {
            super(r10, r11);
        }

        public static CloseIconStyle valueOf(String r10) {
            return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r10);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) $VALUES.clone();
        }
    }
}
