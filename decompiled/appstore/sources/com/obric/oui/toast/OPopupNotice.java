package com.obric.oui.toast;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class OPopupNotice {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$Callback;", "", "beforeHide", "", "obj", "Lcom/obric/oui/toast/OPopupNotice;", "beforeShow", "onHide", "onShow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Callback {
        void beforeHide(@NotNull OPopupNotice r10);

        void beforeShow(@NotNull OPopupNotice r10);

        void onHide(@NotNull OPopupNotice r10);

        void onShow(@NotNull OPopupNotice r10);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$HideCallback;", "", "beforeHide", "", "obj", "Lcom/obric/oui/toast/OPopupNotice;", "reason", "Lcom/obric/oui/toast/OPopupNotice$HideReason;", "onHide", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface HideCallback {
        void beforeHide(@NotNull OPopupNotice r10, @NotNull HideReason r11);

        void onHide(@NotNull OPopupNotice r10, @NotNull HideReason r11);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$HideReason;", "", "(Ljava/lang/String;I)V", "HIDE_AUTO", "HIDE_MANUAL", "HIDE_CONFLICT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HideReason extends Enum<HideReason> {
        private static final /* synthetic */ HideReason[] $VALUES = null;
        public static final HideReason HIDE_AUTO = null;
        public static final HideReason HIDE_CONFLICT = null;
        public static final HideReason HIDE_MANUAL = null;

        private static final /* synthetic */ HideReason[] $values() {
            return new HideReason[]{HIDE_AUTO, HIDE_MANUAL, HIDE_CONFLICT};
        }

        static {
            HIDE_AUTO = new HideReason("HIDE_AUTO", 0);
            HIDE_MANUAL = new HideReason("HIDE_MANUAL", 1);
            HIDE_CONFLICT = new HideReason("HIDE_CONFLICT", 2);
            $VALUES = $values();
        }

        private HideReason(String r10, int r11) {
            super(r10, r11);
        }

        public static HideReason valueOf(String r10) {
            return (HideReason) Enum.valueOf(HideReason.class, r10);
        }

        public static HideReason[] values() {
            return (HideReason[]) $VALUES.clone();
        }
    }

    public static final class a {
    }
}
