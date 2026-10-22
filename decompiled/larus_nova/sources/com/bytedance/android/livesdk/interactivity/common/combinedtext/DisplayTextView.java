package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import j40.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/DisplayTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/m;", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "b", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "getOnSchemaHandleListener", "()Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "setOnSchemaHandleListener", "(Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;)V", "onSchemaHandleListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplayTextView extends AppCompatTextView implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.base.model.message.f f136473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f136474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f136475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f136476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f136477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f136478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f136479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f136480h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f136481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Float f136482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f136483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f136484d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f136485e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f136486f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f136487g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f136488h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f136489i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f136490j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Typeface f136491k;

        public a(float r100, boolean r101, boolean r102, int r103) {
            if ((r103 & 128) == 0) goto L6;
            r101 = false;
        L6:
            if ((r103 & 256) == 0) goto L8;
            r102 = false;
        L8:
            this.f136481a = r100;
            this.f136482b = null;
            this.f136483c = null;
            this.f136484d = null;
            this.f136485e = null;
            this.f136486f = null;
            this.f136487g = null;
            this.f136488h = r101;
            this.f136489i = r102;
            this.f136490j = false;
            this.f136491k = null;
        }
    }

    public static final class b implements qb2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DisplayTextView f136492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f136493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f136494c;

        @Override // qb2.e
        public final void a(ak6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            Intrinsics.checkNotNullParameter(r100, "rendResult");
        }

        @Override // qb2.e
        public final void b(ak6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            SpannableString r101 = r100.f4074a;
            DisplayTextView.x(this.f136492a, r101);
            if (this.f136493b == true) goto L5;
            Animator r102 = com.bytedance.android.livesdk.interactivity.common.combinedtext.a.a(this.f136492a, new i(this));
        L6:
            r102.start();
            return;
        L5:
            int r103 = com.bytedance.android.livesdk.interactivity.common.combinedtext.a.f136496a;
            r102 = com.bytedance.android.livesdk.interactivity.common.combinedtext.a.b(this.f136492a, new j(this));
            goto L6
        }

        public b(DisplayTextView r100, boolean r101, n r102) {
            this.f136492a = r100;
            this.f136493b = r101;
            this.f136494c = r102;
        }
    }

    public static final class c implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DisplayTextView f136495a;

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.n
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.n
        public final void b() {
            DisplayTextView r100 = this.f136495a;
            r100.f136478f++;
            r100.f(r100.f136473a, r100.f136477e);
        }

        public c(DisplayTextView r100) {
            this.f136495a = r100;
        }
    }

    public DisplayTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DisplayTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final o getOnSchemaHandleListener() {
        return this.f136474b;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f136475c == true) goto L5;
        return;
    L5:
        if (q.f497284a.getValue().booleanValue() == false) goto L9;
        postInvalidateDelayed(this.f136476d);
        return;
    }

    public final void setOnSchemaHandleListener(o r100) {
        this.f136474b = r100;
    }

    public static final void x(DisplayTextView r100, Spannable r101) {
        r100.getClass();
        if (r101.length() <= 0) goto L24;
        boolean r102 = true;
        StyleSpan[] r103 = (StyleSpan[]) r101.getSpans(r101.length() - 1, r101.length(), StyleSpan.class);
        if (r103 == null) goto L21;
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L18;
        StyleSpan r106 = r103[r105];
        if (r106.getStyle() != 2) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L16;
        r105 = r105 + 1;
        goto L7
    L16:
        boolean r108 = true;
    L19:
        if (r108 != true) goto L21;
    L22:
        if (r102 == false) goto L24;
        r100.setText(new SpannableStringBuilder(r101).append(r100.f136479g));
        return;
    L11:
        if (r106.getStyle() == 3) goto L14;
        r107 = false;
        goto L15
    L18:
        r108 = false;
    L21:
        r102 = false;
    L24:
        r100.setText(r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void f(com.bytedance.android.live.base.model.message.f r100, n r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        this.f136477e = r101;
        if (this.f136478f >= 4) goto L28;
        o6 r102 = r100.g();
        if (r102 == null) goto L13;
        a5 r103 = r102.a();
        if (r103 == null) goto L13;
        List<c5> r104 = r103.getPieces();
    L15:
        if (r104 == null) goto L17;
        ((c5) ListProtector.get(r104, 0)).setStringValue(String.valueOf(CastIntegerProtector.parseInt(((c5) ListProtector.get(r104, 0)).getStringValue()) + 1));
    L17:
        this.f136473a = r100;
        if (this.f136478f != 3) goto L26;
        o6 r105 = r100.g();
        if (r105 == null) goto L30;
        a5 r106 = r105.a();
        if (r106 == null) goto L31;
        this.f136473a = r100;
        qb2.c.a(r106, new l(this, r101));
        return;
    L31:
        return;
    L30:
        return;
    L26:
        n(r100, this.f136480h, true);
        return;
    L13:
        r104 = null;
        goto L15
    }

    public DisplayTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f136476d = 50;
        this.f136479g = " ";
        setGravity(17);
        this.f136480h = new c(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.m
    public final void n(com.bytedance.android.live.base.model.message.f r100, n r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "comboItem");
        Intrinsics.checkNotNullParameter(r101, "comboListener");
        o6 r103 = r100.g();
        if (r103 != null) goto L5;
        return;
    L5:
        a5 r104 = r103.a();
        if (r104 != null) goto L8;
        return;
    L8:
        this.f136473a = r100;
        qb2.c.a(r104, new b(this, r102, r101));
    }

    public /* synthetic */ DisplayTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
