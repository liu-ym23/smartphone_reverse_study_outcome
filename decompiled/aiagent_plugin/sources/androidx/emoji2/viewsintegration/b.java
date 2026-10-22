package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.g;
import androidx.emoji2.text.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EmojiTextViewHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1670a;

    /* JADX INFO: compiled from: EmojiTextViewHelper.java */
    static class a {
        TransformationMethod a(TransformationMethod r2) {
            return (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r2, TransformationMethod.class, "com.obric.aiagent.plugin");
        }

        void a() {
        }

        void a(boolean r1) {
        }

        InputFilter[] a(InputFilter[] r1) {
            return r1;
        }

        void b(boolean r1) {
        }

        public boolean b() {
            return false;
        }

        a() {
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.viewsintegration.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EmojiTextViewHelper.java */
    private static class C0053b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f1671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EmojiInputFilter f1672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1673c;

        C0053b(TextView r2) {
            this.f1671a = r2;
            this.f1673c = true;
            this.f1672b = new EmojiInputFilter(r2);
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        void a() {
            TransformationMethod r0 = a(this.f1671a.getTransformationMethod());
            this.f1671a.setTransformationMethod(r0);
        }

        private void c() {
            InputFilter[] r0 = this.f1671a.getFilters();
            this.f1671a.setFilters(a(r0));
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        InputFilter[] a(InputFilter[] r2) {
            if (this.f1673c == true) goto L7;
            return c(r2);
        L7:
            return b(r2);
        }

        private InputFilter[] b(InputFilter[] r6) {
            int r0 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            if (r6[r2] == this.f1672b) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r6;
        L8:
            InputFilter[] r3 = new InputFilter[r6.length + 1];
            System.arraycopy(r6, 0, r3, 0, r0);
            r3[r0] = this.f1672b;
            return r3;
        }

        private InputFilter[] c(InputFilter[] r6) {
            SparseArray<InputFilter> r5 = d(r6);
            if (r5.size() != 0) goto L5;
            return r6;
        L5:
            int r0 = r6.length;
            InputFilter[] r1 = new InputFilter[r6.length - r5.size()];
            int r2 = 0;
            int r3 = 0;
        L6:
            if (r2 >= r0) goto L11;
            if (r5.indexOfKey(r2) >= 0) goto L10;
            r1[r3] = r6[r2];
            r3 = r3 + 1;
        L10:
            r2 = r2 + 1;
            goto L6
        L11:
            return r1;
        }

        private SparseArray<InputFilter> d(InputFilter[] r4) {
            SparseArray<InputFilter> r3 = new SparseArray(1);
            int r0 = 0;
        L4:
            if (r0 >= r4.length) goto L9;
            if (ZeusTransformUtils.instanceOf(r4[r0], EmojiInputFilter.class) == false) goto L8;
            r3.put(r0, r4[r0]);
        L8:
            r0 = r0 + 1;
            goto L4
        L9:
            return r3;
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        TransformationMethod a(TransformationMethod r3) {
            TransformationMethod r4 = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r3, TransformationMethod.class, "com.obric.aiagent.plugin");
            if (this.f1673c == false) goto L7;
            return c(r4);
        L7:
            return b(r4);
        }

        private TransformationMethod b(TransformationMethod r2) {
            TransformationMethod r1 = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r2, TransformationMethod.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, EmojiTransformationMethod.class) == true) goto L5;
            return r1;
        L5:
            return ((EmojiTransformationMethod) ZeusTransformUtils.preCheckCast(r1, EmojiTransformationMethod.class, "com.obric.aiagent.plugin")).getOriginalTransformationMethod();
        }

        private TransformationMethod c(TransformationMethod r2) {
            TransformationMethod r1 = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r2, TransformationMethod.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, EmojiTransformationMethod.class) == false) goto L6;
            return r1;
        L6:
            if (ZeusTransformUtils.instanceOf(r1, PasswordTransformationMethod.class) == false) goto L9;
            return r1;
        L9:
            return new EmojiTransformationMethod(r1);
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        void a(boolean r1) {
            if (r1 == false) goto L5;
            a();
            return;
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        void b(boolean r1) {
            this.f1673c = r1;
            a();
            c();
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        public boolean b() {
            return this.f1673c;
        }

        void c(boolean r1) {
            this.f1673c = r1;
        }
    }

    /* JADX INFO: compiled from: EmojiTextViewHelper.java */
    private static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0053b f1674a;

        c(TextView r2) {
            this.f1674a = new C0053b(r2);
        }

        private boolean c() {
            return !d.a();
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        void a() {
            if (c() == false) goto L5;
            return;
        L5:
            this.f1674a.a();
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        InputFilter[] a(InputFilter[] r2) {
            if (c() == false) goto L6;
            return r2;
        L6:
            return this.f1674a.a(r2);
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        TransformationMethod a(TransformationMethod r3) {
            TransformationMethod r4 = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r3, TransformationMethod.class, "com.obric.aiagent.plugin");
            if (c() == false) goto L6;
            return r4;
        L6:
            return this.f1674a.a(r4);
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        void a(boolean r2) {
            if (c() == false) goto L5;
            return;
        L5:
            this.f1674a.a(r2);
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        void b(boolean r2) {
            if (c() == false) goto L5;
            this.f1674a.c(r2);
            return;
        L5:
            this.f1674a.b(r2);
        }

        @Override // androidx.emoji2.viewsintegration.b.a
        public boolean b() {
            return this.f1674a.b();
        }
    }

    public b(TextView r3, boolean r4) {
        g.a(r3, "textView cannot be null");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        this.f1670a = new a();
        return;
    L5:
        if (r4 == true) goto L7;
        this.f1670a = new c(r3);
        return;
    L7:
        this.f1670a = new C0053b(r3);
    }

    public InputFilter[] a(InputFilter[] r1) {
        return this.f1670a.a(r1);
    }

    public TransformationMethod a(TransformationMethod r3) {
        TransformationMethod r4 = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r3, TransformationMethod.class, "com.obric.aiagent.plugin");
        return this.f1670a.a(r4);
    }

    public void a(boolean r1) {
        this.f1670a.b(r1);
    }

    public void b(boolean r1) {
        this.f1670a.a(r1);
    }

    public boolean a() {
        return this.f1670a.b();
    }
}
