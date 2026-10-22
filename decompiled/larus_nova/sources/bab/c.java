package bab;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.ss.android.lark.coremd.base.parse.v;
import com.ss.android.lark.coremd.base.parse.y;
import com.ss.android.lark.coremd.impl.parse.ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1;
import com.ss.android.lark.coremd.impl.parse.e;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f18446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Editable f18447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f18448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f18449d;

    public final class a implements SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f18450a;

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
        }

        public a(c r100) {
            this.f18450a = r100;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
            if ((r101 instanceof e) == false) goto L6;
            ((e) r101).b(this.f18450a.f18449d);
            return;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
            if ((r101 instanceof e) == false) goto L6;
            e r104 = (e) r101;
            b r105 = this.f18450a.f18449d;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "callback");
            r104.f419883a.remove(r105);
            return;
        }
    }

    public static final class b implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f18451a;

        public b(c r100) {
            this.f18451a = r100;
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void a(Object r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "span");
            Editable r112 = this.f18451a.f18446a.getEditableText();
            if (Intrinsics.areEqual(r112, this.f18451a.f18447b) == true) goto L5;
            return;
        L5:
            Intrinsics.checkNotNull(r112);
            Object[] r100 = r112.getSpans(0, r112.length(), SpanWatcher.class);
            int r101 = r100.length;
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L13;
            SpanWatcher r103 = (SpanWatcher) r100[r102];
            int r104 = r112.getSpanStart(r110);
            int r105 = r112.getSpanEnd(r110);
            if (r104 < 0) goto L12;
            if (r105 < 0) goto L12;
            if (r104 >= r105) goto L12;
            r103.onSpanChanged(r112, r110, r104, r105, r104, r105);
        L12:
            r102 = r102 + 1;
            goto L6
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void b(y r100, CharSequence r101) {
            Intrinsics.checkNotNullParameter(r100, "span");
            Intrinsics.checkNotNullParameter(r101, "result");
            Editable r102 = this.f18451a.f18446a.getEditableText();
            int r103 = r102.getSpanStart(r100);
            int r104 = r102.getSpanEnd(r100);
            boolean r105 = false;
            if (r103 < 0) goto L6;
            if (r103 >= r104) goto L6;
            r105 = true;
        L6:
            if (r105 == false) goto L9;
            r102.replace(r103, r104, "");
            r102.insert(r103, r101);
            return;
        }

        @Override // com.ss.android.lark.coremd.impl.parse.e.a
        public final void c(s r100, v r101, ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1.a r102, int r110) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "proxyClickSpan");
            Intrinsics.checkNotNullParameter(r102, "proxyClickHandle");
            Editable r103 = this.f18451a.f18446a.getEditableText();
            int r104 = r103.getSpanStart(r101);
            int r105 = r103.getSpanEnd(r101);
            if (r104 < 0) goto L6;
            if (r104 >= r105) goto L6;
            boolean r106 = true;
        L7:
            if (r106 == false) goto L10;
            TextView r107 = this.f18451a.f18446a;
            r102.a(r107, r107.getLayout(), r104, r105, r110);
            return;
        L10:
            return;
        L6:
            r106 = false;
            goto L7
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        this.f18446a = r100;
        this.f18448c = new a(this);
        this.f18449d = new b(this);
        afterTextChanged(r100.getEditableText());
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Editable r101 = this.f18447b;
        int r102 = 0;
        if (r100 == r101) goto L11;
        if (r101 == null) goto L10;
        e[] r103 = (e[]) r101.getSpans(0, r101.length(), e.class);
        if (r103 == null) goto L10;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L10;
        e r106 = r103[r105];
        b r107 = this.f18449d;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "callback");
        r106.f419883a.remove(r107);
        r105 = r105 + 1;
    L10:
        this.f18447b = r100;
    L11:
        Editable r108 = this.f18447b;
        if (r108 != null) goto L14;
        return;
    L14:
        if (r108.getSpanStart(this.f18448c) != (-1)) goto L21;
        r108.setSpan(this.f18448c, 0, r108.length(), 18);
        Object[] r109 = r108.getSpans(0, r108.length(), e.class);
        int r110 = r109.length;
    L16:
        if (r102 >= r110) goto L22;
        ((e) r109[r102]).b(this.f18449d);
        r102 = r102 + 1;
        goto L16
    L22:
        return;
    }
}
