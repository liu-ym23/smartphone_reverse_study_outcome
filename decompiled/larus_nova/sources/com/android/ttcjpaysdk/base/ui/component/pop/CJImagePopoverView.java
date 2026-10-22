package com.android.ttcjpaysdk.base.ui.component.pop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0019\u0010\r\u001a\u00020\n2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJImagePopoverView;", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJLinkPopoverView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "popStyle", "Lcom/android/ttcjpaysdk/base/ui/component/pop/CJImagePopoverView$PopStyle;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/android/ttcjpaysdk/base/ui/component/pop/CJImagePopoverView$PopStyle;)V", "setImageClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setLeftIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "(Ljava/lang/Integer;)V", "setShowArrow", "show", "", "PopStyle", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJImagePopoverView extends CJLinkPopoverView {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJImagePopoverView$PopStyle;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "SMALL", EffectConstants.NORMAL, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PopStyle extends Enum<PopStyle> {
        private static final /* synthetic */ PopStyle[] $VALUES = null;
        public static final PopStyle NORMAL = null;
        public static final PopStyle SMALL = null;
        private final String type;

        private static final /* synthetic */ PopStyle[] $values() {
            return new PopStyle[]{SMALL, NORMAL};
        }

        public static PopStyle valueOf(String r100) {
            return (PopStyle) a.a(PopStyle.class, r100);
        }

        public static PopStyle[] values() {
            return (PopStyle[]) $VALUES.clone();
        }

        static {
            SMALL = new PopStyle("SMALL", 0, "small");
            NORMAL = new PopStyle(EffectConstants.NORMAL, 1, "normal");
            $VALUES = $values();
        }

        public final String getType() {
            return this.type;
        }

        private PopStyle(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public CJImagePopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, null, 6, null);
    }

    public CJImagePopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, null, 4, null);
    }

    public final void setImageClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getIvIcon().setOnClickListener(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ui.component.pop.CJLinkPopoverView
    public void setLeftIcon(Drawable r100) {
        super.setLeftIcon(r100);
    }

    public final void setShowArrow(boolean r100) {
        ImageView r101 = getIvArrow();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ui.component.pop.CJLinkPopoverView
    public void setLeftIcon(Integer r100) {
        super.setLeftIcon(r100);
    }

    public CJImagePopoverView(Context r100, AttributeSet r101, PopStyle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "popStyle");
        super(r100, r101);
        ImageView r103 = getIvIcon();
        ViewGroup.LayoutParams r104 = getIvIcon().getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        PopStyle r106 = PopStyle.SMALL;
        if (r102 != r106) goto L5;
        r105.height = CJPayBasicExtensionKt.dp(14.0f);
        r105.width = CJPayBasicExtensionKt.dp(14.0f);
    L6:
        r105.setMarginEnd(CJPayBasicExtensionKt.dp(2.0f));
        r103.setLayoutParams(r105);
        getIvIcon().setImageTintList(null);
        if (r102 != r106) goto L9;
        setPadding(CJPayBasicExtensionKt.dp(10.0f), CJPayBasicExtensionKt.dp(6.0f), CJPayBasicExtensionKt.dp(10.0f), CJPayBasicExtensionKt.dp(6.0f));
        return;
    L9:
        setPadding(CJPayBasicExtensionKt.dp(10.0f), CJPayBasicExtensionKt.dp(10.0f), CJPayBasicExtensionKt.dp(10.0f), CJPayBasicExtensionKt.dp(10.0f));
        return;
    L5:
        r105.height = CJPayBasicExtensionKt.dp(20.0f);
        r105.width = CJPayBasicExtensionKt.dp(20.0f);
        goto L6
    }

    public /* synthetic */ CJImagePopoverView(Context r100, AttributeSet r101, PopStyle r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = PopStyle.SMALL;
    L8:
        this(r100, r101, r102);
    }
}
