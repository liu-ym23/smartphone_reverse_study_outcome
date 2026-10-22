package com.obric.oui.infopanel.action;

import android.view.View;
import android.widget.LinearLayout;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/infopanel/action/IOInfoPanelActionView;", "", "text", "", "setBtnText", "(Ljava/lang/CharSequence;)V", "Landroid/view/View$OnClickListener;", "listener", "setBtnOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/obric/oui/button/OButton;", "a", "Lcom/obric/oui/button/OButton;", "showingBtn", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelSingleBtnActionView extends LinearLayout implements IOInfoPanelActionView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OButton f15081a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;", "", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style PRIMARY = null;
        public static final Style SECONDARY = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{PRIMARY, SECONDARY};
        }

        static {
            PRIMARY = new Style("PRIMARY", 0);
            SECONDARY = new Style("SECONDARY", 1);
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

    public final void setBtnOnClickListener(@NotNull View.OnClickListener r10) {
        q.g(r10, "listener");
        this.f15081a.setOnClickListener(r10);
    }

    public final void setBtnText(@NotNull CharSequence r10) {
        q.g(r10, "text");
        this.f15081a.setText(r10);
    }
}
