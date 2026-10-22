package com.obric.oui.infopanel.action;

import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/infopanel/action/IOInfoPanelActionView;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelDoubleBtnActionView extends LinearLayout implements IOInfoPanelActionView {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView$Style;", "", "(Ljava/lang/String;I)V", "PRIMARY_SECONDARY", "ONLY_SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style ONLY_SECONDARY = null;
        public static final Style PRIMARY_SECONDARY = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{PRIMARY_SECONDARY, ONLY_SECONDARY};
        }

        static {
            PRIMARY_SECONDARY = new Style("PRIMARY_SECONDARY", 0);
            ONLY_SECONDARY = new Style("ONLY_SECONDARY", 1);
            $VALUES = $values();
        }

        private Style(String r10, int r11) {
            super(r10, r11);
        }

        public static Style valueOf(String r10) {
            return (Style) Enum.valueOf(Style.class, r10);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }
    }

    @Override // com.obric.oui.infopanel.action.IOInfoPanelActionView
    @NotNull
    public View getView() {
        return this;
    }
}
