package com.stepos.ailauncher.mcpservice.risk.notification;

import Z8.B;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.mcpservice.R$color;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementButton;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\f\u001a\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u0004\u001a\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;", "style", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton$Style;)I", "", "buttonId", "c", "(Ljava/lang/String;)I", "", "Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton;", "e", "(Ljava/util/List;)Ljava/util/List;", "f", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "mcpservice_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RiskStatementButton.Style.values().length];
            try {
                iArr[RiskStatementButton.Style.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RiskStatementButton.Style.EMPHASIS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RiskStatementButton.Style.REJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.mcpservice.risk.notification.b$b, reason: collision with other inner class name */
    public static final class C0319b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Integer.valueOf(b.d(((RiskStatementButton) t10).getStyle())), Integer.valueOf(b.d(((RiskStatementButton) t11).getStyle())));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public c(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(Integer.valueOf(b.c(((RiskStatementButton) t10).getId())), Integer.valueOf(b.c(((RiskStatementButton) t11).getId())));
        }
    }

    public static final int a(RiskStatementButton.Style style) {
        p.i(style, "style");
        return style == RiskStatementButton.Style.NORMAL ? R$color.risk_live_action_bg_primary : R$color.risk_live_action_bg_secondary;
    }

    public static final int b(RiskStatementButton.Style style) {
        p.i(style, "style");
        return style == RiskStatementButton.Style.NORMAL ? R$color.risk_live_action_text_primary : R$color.risk_live_action_text_secondary;
    }

    public static final int c(String buttonId) {
        p.i(buttonId, "buttonId");
        int iHashCode = buttonId.hashCode();
        return iHashCode != -1341859401 ? iHashCode != -934710369 ? (iHashCode == -77754087 && buttonId.equals("always_allow")) ? 1 : Integer.MAX_VALUE : !buttonId.equals("reject") ? Integer.MAX_VALUE : 2 : !buttonId.equals("allow_once") ? Integer.MAX_VALUE : 0;
    }

    public static final int d(RiskStatementButton.Style style) {
        p.i(style, "style");
        int i10 = a.$EnumSwitchMapping$0[style.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final List<RiskStatementButton> e(List<RiskStatementButton> list) {
        p.i(list, "<this>");
        return F.c1(list, new c(new C0319b()));
    }

    public static final List<RiskStatementButton> f(List<RiskStatementButton> list) {
        p.i(list, "<this>");
        return B.U(e(list));
    }
}
