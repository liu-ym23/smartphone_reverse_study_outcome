package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.gamecp.common.setting.LiveConfigSettingKeys;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0004R\"\u0010\n\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0019\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010,\u001a\u0004\u0018\u00010!8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R,\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006<"}, d2 = {"Lcom/bytedance/android/gamecp/common/ui/ExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "state", "", "setNeedFoldedAfterUnFolded", "Lkotlin/Function0;", "action", "setOnExpandClickListener", "", "originText", "setExpandText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getOriginText", "()Ljava/lang/String;", "setOriginText", "(Ljava/lang/String;)V", "b", "getUnfoldText", "setUnfoldText", "unfoldText", "c", "getUnfoldTextColor", "setUnfoldTextColor", "unfoldTextColor", "e", "Z", "getAppendShowAll", "()Z", "setAppendShowAll", "(Z)V", "appendShowAll", "Landroid/text/SpannableString;", "f", "Landroid/text/SpannableString;", "getClosedSpannableString", "()Landroid/text/SpannableString;", "setClosedSpannableString", "(Landroid/text/SpannableString;)V", "closedSpannableString", ce.f26391f, "getWorkingTextSpannableString", "setWorkingTextSpannableString", "workingTextSpannableString", RXScreenCaptureService.KEY_INDEX, "Lkotlin/jvm/functions/Function0;", "getClickExpandListener", "()Lkotlin/jvm/functions/Function0;", "setClickExpandListener", "(Lkotlin/jvm/functions/Function0;)V", "clickExpandListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ExpandableTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f56902j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f56903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f56904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f56905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpannableString f56908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SpannableString f56909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f56910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f56911i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f56912a;

        public b(ExpandableTextView r100) {
            this.f56912a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f56912a.setMaxLines(Integer.MAX_VALUE);
            ExpandableTextView r101 = this.f56912a;
            r101.setExpandText(r101.getOriginText());
            Function0<Unit> r102 = this.f56912a.getClickExpandListener();
            if (r102 == null) goto L6;
            Unit r103 = r102.invoke();
            return;
        }
    }

    public static final class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f56913a = null;

        static {
            f56913a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            return true;
        }
    }

    public static final class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f56914a;

        public d(ExpandableTextView r100) {
            this.f56914a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            this.f56914a.f56910h.onClick(r100);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setColor(this.f56914a.getCurrentTextColor());
            r100.setUnderlineText(false);
        }
    }

    public static final class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f56915a = null;

        static {
            f56915a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            return true;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f56916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f56917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f56918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f56919d;

        public f(ExpandableTextView r100, String r101, boolean r102, boolean r103) {
            this.f56916a = r100;
            this.f56917b = r101;
            this.f56918c = r102;
            this.f56919d = r103;
        }

        public final void a() {
            this.f56916a.setOriginText(this.f56917b);
            if (this.f56918c == true) goto L25;
            ExpandableTextView r100 = this.f56916a;
            String r101 = this.f56917b;
            boolean r102 = this.f56919d;
            r100.f56907e = false;
            String r103 = new StringBuilder(r101).toString();
            if (r100.f56906d != (-1)) goto L7;
        L24:
            r100.setText("");
            r100.f56909g = new SpannableString(r103);
            r100.y(r100.f56907e, r102, r103);
            return;
        L7:
            if (r100.x(r103).getLineCount() <= r100.f56906d) goto L24;
            Layout r104 = r100.x(r103 + r100.f56904b);
        L9:
            int r105 = r104.getLineCount();
            int r106 = r100.f56906d;
            if (r105 <= r106) goto L23;
            int r107 = r104.getLineStart(r106);
            if (r107 < r103.length()) goto L14;
            r107 = r103.length();
        L14:
            if (r107 == (-1)) goto L23;
            if (r107 == 0) goto L23;
            if (r103.length() != 0) goto L19;
            boolean r108 = true;
        L20:
            if (r108 == true) goto L23;
            r103 = r103.substring(0, r107 - 1);
            r104 = r100.x(r103 + r100.f56904b);
            goto L9
        L19:
            r108 = false;
        L23:
            r100.f56907e = true;
            goto L24
        L25:
            this.f56916a.setExpandText(this.f56917b);
            this.f56916a.setMaxLines(Integer.MAX_VALUE);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g extends CharacterStyle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f56920a;

        public g(ExpandableTextView r100) {
            this.f56920a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r210) {
            Intrinsics.checkNotNullParameter(r210, "textPaint");
            this.f56920a.getPaint().setStyle(Paint.Style.FILL);
            this.f56920a.getClass();
            if (LiveConfigSettingKeys.LIVESDK_OPEN_PLATFORM_SHADER_REVERSE.getValue().contains(Build.DEVICE) == false) goto L5;
            LinearGradient r100 = new LinearGradient(0.0f, 0.0f, 2 * r210.getTextSize(), 0.0f, new int[]{0, this.f56920a.getCurrentTextColor()}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR);
        L6:
            r210.setShader(r100);
            return;
        L5:
            r100 = new LinearGradient(0.0f, 0.0f, r210.getTextSize() * 2, 0.0f, new int[]{this.f56920a.getCurrentTextColor(), 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR);
            goto L6
        }
    }

    static {
    }

    public ExpandableTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ExpandableTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setNeedFoldedAfterUnFolded(boolean r100) {
    }

    public final boolean getAppendShowAll() {
        return this.f56907e;
    }

    public final Function0<Unit> getClickExpandListener() {
        return this.f56911i;
    }

    public final SpannableString getClosedSpannableString() {
        return this.f56908f;
    }

    public final String getOriginText() {
        return this.f56903a;
    }

    public final String getUnfoldText() {
        return this.f56904b;
    }

    public final String getUnfoldTextColor() {
        return this.f56905c;
    }

    public final SpannableString getWorkingTextSpannableString() {
        return this.f56909g;
    }

    public final void setAppendShowAll(boolean r100) {
        this.f56907e = r100;
    }

    public final void setClickExpandListener(Function0<Unit> r100) {
        this.f56911i = r100;
    }

    public final void setClosedSpannableString(SpannableString r100) {
        this.f56908f = r100;
    }

    public final void setExpandText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originText");
        boolean r101 = false;
        this.f56907e = false;
        String r102 = r100 + tb2.c.DEFAULT_TEXT;
        if (x(r102 + "------").getLineCount() <= x(r102).getLineCount()) goto L5;
        r101 = true;
    L5:
        z(r101, r102);
        setMovementMethod(LinkMovementMethod.getInstance());
        setOnLongClickListener(e.f56915a);
    }

    public final void setOnExpandClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f56911i = r100;
    }

    public final void setOriginText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f56903a = r100;
    }

    public final void setUnfoldText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f56904b = r100;
    }

    public final void setUnfoldTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f56905c = r100;
    }

    public final void setWorkingTextSpannableString(SpannableString r100) {
        this.f56909g = r100;
    }

    public final Layout x(String r110) {
        return new StaticLayout(r110, getPaint(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
    }

    public final void B(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "workingText");
        g r102 = new g(this);
        if (r100 == false) goto L8;
        SpannableString r103 = this.f56909g;
        if (r103 == null) goto L9;
        r103.setSpan(r102, r101.length() - 2, r101.length(), 17);
        return;
    L9:
        return;
    }

    public void z(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "allText");
        if (r100 == false) goto L5;
        setText(r101 + '\n');
        return;
    L5:
        setText(r101);
    }

    public ExpandableTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f56903a = "";
        this.f56904b = "";
        this.f56905c = "";
        this.f56906d = 1000;
        this.f56910h = new b(this);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.denyExpand, R.attr.foldText, R.attr.maxFoldedLine, R.attr.myIconSize, R.attr.originText, R.attr.unfoldText, R.attr.unfoldTextColor, R.attr.yRate});
        int r104 = r103.getIndexCount();
        if (r104 < 0) goto L34;
        int r105 = 0;
    L5:
        int r106 = r103.getIndex(r105);
        int r107 = r103.getIndex(r105);
        if (r107 != 1) goto L9;
        r103.getString(r106);
    L32:
        if (r105 == r104) goto L34;
        r105 = r105 + 1;
        goto L5
    L9:
        if (r107 != 5) goto L15;
        String r108 = r103.getString(r106);
        if (r108 != null) goto L13;
        r108 = "";
    L13:
        this.f56904b = r108;
        goto L32
    L15:
        if (r107 != 6) goto L21;
        String r109 = r103.getString(r106);
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        this.f56905c = r109;
        goto L32
    L21:
        if (r107 != 4) goto L27;
        String r110 = r103.getString(r106);
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        this.f56903a = r110;
        goto L32
    L27:
        if (r107 != 2) goto L30;
        this.f56906d = r103.getInt(r106, 0);
        goto L32
    L30:
        if (r107 != 7) goto L32;
        r103.getFloat(r106, 0.5f);
    L34:
        r103.recycle();
    }

    public final void A(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "originText");
        post(new f(this, r100, r102, r101));
    }

    public void y(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "workingText");
        if (r100 == false) goto L25;
        B(r101, r102);
        d r103 = new d(this);
        SpannableString r104 = this.f56909g;
        if (r104 != null) goto L7;
    L11:
        SpannableString r105 = this.f56909g;
        if (r105 == null) goto L15;
        append(r105);
    L15:
        if (this.f56908f != null) goto L21;
        String r106 = this.f56904b;
        if ((!StringsKt.isBlank(this.f56905c)) == false) goto L19;
        int r107 = ColorProtector.parseColor(this.f56905c);
    L20:
        com.bytedance.android.gamecp.common.ui.e r108 = new com.bytedance.android.gamecp.common.ui.e(r107, new ExpandableTextView$initUnFoldText$$inlined$let$lambda$1(this));
        SpannableString r109 = new SpannableString(r106);
        this.f56908f = r109;
        r109.setSpan(r108, 0, r106.length(), 33);
        goto L21
    L19:
        r107 = y0.c(R.color.gamecp_white_90);
    L21:
        SpannableString r110 = this.f56908f;
        if (r110 == null) goto L24;
        append(r110);
    L24:
        setMovementMethod(LinkMovementMethod.getInstance());
        setOnLongClickListener(c.f56913a);
        return;
    L7:
        if ((r102.length() - 10) < 0) goto L9;
        int r111 = r102.length() - 10;
    L10:
        r104.setSpan(r103, r111, r102.length(), 34);
        goto L11
    L9:
        r111 = 0;
        goto L10
    L25:
        setText(r102);
    }

    public /* synthetic */ ExpandableTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
