package com.bytedance.android.gamecp.business.comment;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.gamecp.common.ui.ExpandableTextView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/CommentExpandableTextView;", "Lcom/bytedance/android/gamecp/common/ui/ExpandableTextView;", "", "", "array", "", "setHighLightArray", "color", "setHighlightTextColor", "Lkotlin/Function0;", "action", "setTextExpandedClickListenerListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentExpandableTextView extends ExpandableTextView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f51812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<Integer, Integer> f51813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f51814m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f51815n;

    public static final class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f51816a = null;

        static {
            f51816a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            return true;
        }
    }

    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentExpandableTextView f51817a;

        public b(CommentExpandableTextView r100) {
            this.f51817a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            Function0<Unit> r101 = this.f51817a.f51815n;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke();
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setColor(this.f51817a.getCurrentTextColor());
            r100.setUnderlineText(false);
        }
    }

    public CommentExpandableTextView(Context r100) {
        this(r100, null);
    }

    public final void setHighLightArray(Map<Integer, Integer> r100) {
        this.f51813l = r100;
    }

    public final void setHighlightTextColor(int r100) {
        setHighlightColor(r100);
        this.f51814m = r100;
    }

    public final void setTextExpandedClickListenerListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f51815n = r100;
    }

    public CommentExpandableTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 4, 0);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.denyExpand, R.attr.foldText, R.attr.maxFoldedLine, R.attr.myIconSize, R.attr.originText, R.attr.unfoldText, R.attr.unfoldTextColor, R.attr.yRate});
        this.f51812k = r102.getBoolean(0, false);
        r102.recycle();
        this.f51814m = ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED);
    }

    public final void C(SpannableString r100, Map r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Iterator r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L21;
        Map.Entry r103 = (Map.Entry) r102.next();
        Integer r104 = (Integer) r103.getKey();
        int r105 = 0;
        if (r104 == null) goto L10;
        int r106 = r104.intValue();
    L11:
        Integer r107 = (Integer) r103.getValue();
        if (r107 == null) goto L15;
        r105 = r107.intValue();
    L15:
        if (r106 > r100.length()) goto L6;
        if (r105 <= r100.length()) goto L19;
        r105 = r100.length();
    L19:
        r100.setSpan(new ForegroundColorSpan(this.f51814m), r106, r105, 33);
        if (r105 != r100.length()) goto L6;
        return;
    L10:
        r106 = 0;
        goto L11
    }

    @Override // com.bytedance.android.gamecp.common.ui.ExpandableTextView
    public final void z(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "allText");
        SpannableString r102 = new SpannableString(r101);
        r102.setSpan(new b(this), 0, r101.length(), 17);
        Map<Integer, Integer> r103 = this.f51813l;
        if (r103 != null) goto L5;
    L7:
        setText(r102);
        return;
    L5:
        if ((!r103.isEmpty()) != true) goto L7;
        C(r102, this.f51813l);
        goto L7
    }

    @Override // com.bytedance.android.gamecp.common.ui.ExpandableTextView
    public final void y(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "workingText");
        if (r100 == false) goto L25;
        B(r101, r102);
        if (this.f51812k == true) goto L9;
        SpannableString r103 = getWorkingTextSpannableString();
        if (r103 == null) goto L9;
        r103.setSpan(new com.bytedance.android.gamecp.common.ui.e(getCurrentTextColor(), new CommentExpandableTextView$setCloseTextReal$1(this)), 0, r102.length(), 33);
    L9:
        SpannableString r104 = getWorkingTextSpannableString();
        if (r104 == null) goto L17;
        Map<Integer, Integer> r105 = this.f51813l;
        if (r105 != null) goto L14;
    L16:
        append(getWorkingTextSpannableString());
        goto L17
    L14:
        if ((!r105.isEmpty()) != true) goto L16;
        C(r104, this.f51813l);
        setWorkingTextSpannableString(r104);
    L17:
        String r106 = getUnfoldText();
        if ((!StringsKt.isBlank(getUnfoldTextColor())) == false) goto L20;
        int r107 = ColorProtector.parseColor(getUnfoldTextColor());
    L21:
        com.bytedance.android.gamecp.common.ui.e r108 = new com.bytedance.android.gamecp.common.ui.e(r107, new CommentExpandableTextView$setCloseTextReal$$inlined$let$lambda$1(this));
        setClosedSpannableString(new SpannableString(r106));
        SpannableString r109 = getClosedSpannableString();
        if (r109 == null) goto L24;
        r109.setSpan(r108, 0, r106.length(), 33);
        append(r109);
    L24:
        setMovementMethod(LinkMovementMethod.getInstance());
        setOnLongClickListener(a.f51816a);
        return;
    L20:
        r107 = y0.c(R.color.gamecp_white_90);
        goto L21
    L25:
        SpannableString r110 = getWorkingTextSpannableString();
        if (r110 == null) goto L35;
        Map<Integer, Integer> r111 = this.f51813l;
        if (r111 != null) goto L30;
    L32:
        append(getWorkingTextSpannableString());
        return;
    L30:
        if ((!r111.isEmpty()) != true) goto L32;
        C(r110, this.f51813l);
        setWorkingTextSpannableString(r110);
        goto L32
    }
}
