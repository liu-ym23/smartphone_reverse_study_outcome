package aq8;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.t1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15924a;

    /* JADX INFO: loaded from: classes26.dex */
    public static final class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15925b;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f15925b, ((a) r100).f15925b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f15925b;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "CloseInstructionPanel(panelId=" + this.f15925b + ')';
        }

        public a(String r100) {
            super("CloseInstructionPanel");
            this.f15925b = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15926b;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f15926b, ((b) r100).f15926b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f15926b;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "CollectFormData(panelId=" + this.f15926b + ')';
        }

        public b(String r100) {
            super("CollectFormData");
            this.f15926b = r100;
        }
    }

    /* JADX INFO: renamed from: aq8.c$c, reason: collision with other inner class name */
    public static final class C0209c extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bq8.a f15927b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0209c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f15927b, ((C0209c) r100).f15927b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f15927b.hashCode();
        }

        public final String toString() {
            return "InstructionMusicTemplatePrompt(template=" + this.f15927b + ')';
        }

        public C0209c(bq8.a r100) {
            Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
            super("InstructionMusicTemplatePrompt");
            this.f15927b = r100;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f15928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f15929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r f15930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final r f15931e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map<String, Object> f15932f;

        public d() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f15928b, r101.f15928b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f15929c, r101.f15929c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f15930d, r101.f15930d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f15931e, r101.f15931e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f15932f, r101.f15932f) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f15928b.hashCode() * 31) + this.f15929c.hashCode()) * 31;
            r r101 = this.f15930d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            r r105 = this.f15931e;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Map<String, Object> r108 = this.f15932f;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "OpenInstructionPanel(conf=" + this.f15928b + ", panelId=" + this.f15929c + ", draftConf=" + this.f15930d + ", usuallyConf=" + this.f15931e + ", defaultParams=" + this.f15932f + ')';
        }

        public d(r r100, String r101, r r102, r r103) {
            Intrinsics.checkNotNullParameter(r100, "conf");
            Intrinsics.checkNotNullParameter(r101, "panelId");
            super("OpenInstructionPanel");
            this.f15928b = r100;
            this.f15929c = r101;
            this.f15930d = r102;
            this.f15931e = r103;
            this.f15932f = null;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t1 f15933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f15934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f15935d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f15933b, r101.f15933b) == true) goto L12;
            return false;
        L12:
            if (this.f15934c == r101.f15934c) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f15935d, r101.f15935d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f15933b.hashCode() * 31;
            if (this.f15934c == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            String r103 = this.f15935d;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "OptionParamFilterConfChanged(paramFilterConf=" + this.f15933b + ", isInitial=" + this.f15934c + ", panelId=" + this.f15935d + ')';
        }

        public e(t1 r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "paramFilterConf");
            super("OptionParamFilterConfChanged");
            this.f15933b = r100;
            this.f15934c = r101;
            this.f15935d = r102;
        }
    }

    public static final class f extends c {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            ((f) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "RequestActionBarConf(requestBody=null)";
        }
    }

    public static final class g extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15936b;

        public g() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f15936b, ((g) r100).f15936b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f15936b;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ValidateForm(panelId=" + this.f15936b + ')';
        }

        public g(String r100) {
            super("ValidateForm");
            this.f15936b = r100;
        }
    }

    public c(String r100) {
        this.f15924a = r100;
    }
}
