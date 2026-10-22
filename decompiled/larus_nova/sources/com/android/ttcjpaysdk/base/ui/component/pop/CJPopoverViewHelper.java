package com.android.ttcjpaysdk.base.ui.component.pop;

import android.app.Activity;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0085\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n¢\u0006\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverViewHelper;", "", "()V", "showPop", "", "activity", "Landroid/app/Activity;", "view", "Landroid/view/View;", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "align", "Lcom/android/ttcjpaysdk/base/ui/component/pop/PopoverAlign;", "arrowPosition", "Lcom/android/ttcjpaysdk/base/ui/component/pop/ArrowPosition;", "arrowOffset", "", "text", "", "duration", "leftIconResId", "theme", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverViewHelper$PopTheme;", "shadowColorResId", "xOffset", "yOffset", "(Landroid/app/Activity;Landroid/view/View;ILcom/android/ttcjpaysdk/base/ui/component/pop/PopoverAlign;Lcom/android/ttcjpaysdk/base/ui/component/pop/ArrowPosition;FLjava/lang/String;ILjava/lang/Integer;Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverViewHelper$PopTheme;III)V", "PopTheme", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPopoverViewHelper {
    public static final CJPopoverViewHelper INSTANCE = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJPopoverViewHelper$PopTheme;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PopTheme extends Enum<PopTheme> {
        private static final /* synthetic */ PopTheme[] $VALUES = null;
        public static final PopTheme DARK = null;
        public static final PopTheme LIGHT = null;

        private static final /* synthetic */ PopTheme[] $values() {
            return new PopTheme[]{LIGHT, DARK};
        }

        public static PopTheme valueOf(String r100) {
            return (PopTheme) a.a(PopTheme.class, r100);
        }

        public static PopTheme[] values() {
            return (PopTheme[]) $VALUES.clone();
        }

        static {
            LIGHT = new PopTheme("LIGHT", 0);
            DARK = new PopTheme("DARK", 1);
            $VALUES = $values();
        }

        private PopTheme(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        INSTANCE = new CJPopoverViewHelper();
    }

    private CJPopoverViewHelper() {
    }

    public final void showPop(final Activity r110, final View r111, final int r112, final PopoverAlign r210, final ArrowPosition r211, final float r212, final String r213, final int r214, final Integer r215, final PopTheme r216, final int r217, final int r218, final int r219) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r210, "align");
        Intrinsics.checkNotNullParameter(r211, "arrowPosition");
        Intrinsics.checkNotNullParameter(r213, "text");
        Intrinsics.checkNotNullParameter(r216, "theme");
        r111.post(new AnonymousClass1(r110, r216, r214, r212, r217, r111, r112, r210, r211, r218, r219, r213, r215));
    }

    public static /* synthetic */ void showPop$default(CJPopoverViewHelper r110, Activity r111, View r112, int r113, PopoverAlign r210, ArrowPosition r211, float r212, String r213, int r214, Integer r215, PopTheme r216, int r217, int r218, int r219, int r310, Object r311) {
        if ((r310 & 16) == 0) goto L5;
        ArrowPosition r100 = ArrowPosition.CENTER;
    L7:
        if ((r310 & 32) == 0) goto L9;
        float r101 = 0.0f;
    L11:
        if ((r310 & 64) == 0) goto L13;
        String r102 = "引导气泡";
    L15:
        if ((r310 & 256) == 0) goto L17;
        Integer r114 = null;
    L19:
        if ((r310 & 512) == 0) goto L21;
        PopTheme r115 = PopTheme.DARK;
    L23:
        if ((r310 & 1024) == 0) goto L25;
        int r116 = R.color.cj_pay_color_black_20;
    L27:
        if ((r310 & 2048) == 0) goto L29;
        int r117 = 0;
    L31:
        if ((r310 & 4096) == 0) goto L33;
        int r118 = 0;
    L34:
        r110.showPop(r111, r112, r113, r210, r100, r101, r102, r214, r114, r115, r116, r117, r118);
        return;
    L33:
        r118 = r219;
        goto L34
    L29:
        r117 = r218;
        goto L31
    L25:
        r116 = r217;
        goto L27
    L21:
        r115 = r216;
        goto L23
    L17:
        r114 = r215;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
