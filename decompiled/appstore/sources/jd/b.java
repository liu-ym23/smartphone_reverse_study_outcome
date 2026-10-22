package jd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.common.oui.R$string;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.pickers.OReelPickerBuilder;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.collections.k0;
import kotlin.jvm.internal.q;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements OPicker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f20989a;

    public static final class a implements OReelPickerBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Consumer f20990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f20991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f20992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f20993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map f20994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public OReelPicker f20995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final OReelPicker.ReelChangedListener f20996g;

        public a() {
            this.f20993d = new ArrayList();
            this.f20994e = new LinkedHashMap();
            this.f20996g = new jd.a(this);
        }

        public static /* synthetic */ void a(a r10, int r11, int r12) {
            j(r10, r11, r12);
        }

        public static /* synthetic */ a d(a r12, int r13, List r14, String r15, int r16, float r17, Integer r18, Integer r19, Context r20, int r21, Object r22) {
            if ((r21 & 4) == 0) goto L5;
            String r10 = null;
        L7:
            if ((r21 & 8) == 0) goto L9;
            int r11 = 0;
        L11:
            if ((r21 & 16) == 0) goto L13;
            float r23 = 1.0f;
        L15:
            if ((r21 & 32) == 0) goto L17;
            Integer r24 = null;
        L19:
            if ((r21 & 64) == 0) goto L21;
            Integer r110 = null;
        L23:
            if ((r21 & 128) == 0) goto L25;
            Context r111 = null;
        L27:
            return r12.c(r13, r14, r10, r11, r23, r24, r110, r111);
        L25:
            r111 = r20;
            goto L27
        L21:
            r110 = r19;
            goto L23
        L17:
            r24 = r18;
            goto L19
        L13:
            r23 = r17;
            goto L15
        L9:
            r11 = r16;
            goto L11
        L5:
            r10 = r15;
            goto L7
        }

        public static final void j(a r10, int r11, int r12) {
            q.g(r10, "this$0");
            r10.f20994e.put(Integer.valueOf(r11), Integer.valueOf(r12));
            r10.i();
        }

        public final a b(Context r16, int r17, Integer r18, Integer r19) {
            q.g(r16, "context");
            List r10 = c.f20998a.a(r16, 1, 12);
            int r11 = 0;
            if (r18 != null) goto L5;
        L4:
            int r12 = r11;
            if (r19 != null) goto L8;
            int r13 = f.b(r16, 101);
        L10:
            return d(this, r17, r10, null, r12, 0.0f, Integer.valueOf(r13), null, null, 208, null);
        L8:
            r13 = r19.intValue();
            goto L10
        L5:
            r11 = Math.max(0, Math.min(r18.intValue() - 1, 11));
            goto L4
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public /* bridge */ /* synthetic */ Object build(Context r10, AttributeSet r11, int r12) {
            return f(r10, r11, r12);
        }

        public final a c(int r14, List r15, String r16, int r17, float r18, Integer r19, Integer r20, Context r21) {
            q.g(r15, "entries");
            if (r19 != null) goto L11;
            if (r21 == null) goto L11;
            if (r16 != null) goto L9;
            if (r20 != null) goto L9;
            Integer r10 = Integer.valueOf(f.b(r21, 72));
        L10:
            Integer r11 = r10;
        L12:
            this.f20993d.add(new OReelPicker.a(r14, r15, r16, r18, r19, r11, r20, r17, this.f20996g));
            this.f20994e.put(Integer.valueOf(r14), Integer.valueOf(r17));
            return this;
        L9:
            r10 = Integer.valueOf(f.b(r21, 92));
        L11:
            r11 = r19;
            goto L12
        }

        public final a e(Context r21, int r22, int r23, int r24, Integer r25, Integer r26) {
            q.g(r21, "context");
            c r10 = c.f20998a;
            String r11 = r21.getString(R$string.oui_reel_picker_year_tag);
            q.f(r11, "context.getString(R.stri…oui_reel_picker_year_tag)");
            List r12 = c.c(r10, r23, r24, r11, 0, 8, null);
            int r13 = 0;
            if (r25 != null) goto L5;
        L4:
            int r14 = r13;
            if (r26 != null) goto L8;
            int r15 = f.b(r21, 101);
        L10:
            return d(this, r22, r12, null, r14, 0.0f, Integer.valueOf(r15), null, null, 208, null);
        L8:
            r15 = r26.intValue();
            goto L10
        L5:
            r13 = Math.max(0, Math.min(r25.intValue() - r23, r12.size() - 1));
            goto L4
        }

        public b f(Context r10, AttributeSet r11, int r12) {
            q.g(r10, "context");
            OReelPickerMulti.a r13 = new OReelPickerMulti.a();
            Integer r14 = this.f20991b;
            if (r14 == null) goto L6;
            r13.c(r14.intValue());
        L6:
            Integer r15 = this.f20992c;
            if (r15 == null) goto L10;
            r13.a(r15.intValue());
        L10:
            Iterator r16 = this.f20993d.iterator();
        L12:
            if (r16.hasNext() == false) goto L14;
            r13.addReel((OReelPicker.a) r16.next());
            goto L12
        L14:
            this.f20995f = r13.build(r10, r11, r12);
            b r17 = new b();
            b.a(r17, this);
            return r17;
        }

        public final OReelPicker g() {
            return this.f20995f;
        }

        public final Map h() {
            return this.f20994e;
        }

        public final void i() {
            Consumer r10 = this.f20990a;
            if (r10 == null) goto L7;
            r10.accept(new C0283b(k0.s(this.f20994e)));
            return;
        }

        public final a k(int r10) {
            this.f20992c = Integer.valueOf(r10);
            return this;
        }

        public final a l(int r10) {
            this.f20991b = Integer.valueOf(r10);
            return this;
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public void setOnChangedListener(Consumer r10) {
            q.g(r10, "listener");
            this.f20990a = r10;
        }
    }

    /* JADX INFO: renamed from: jd.b$b, reason: collision with other inner class name */
    public static final class C0283b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f20997a;

        public C0283b(Map r10) {
            q.g(r10, "selections");
            this.f20997a = r10;
        }

        public final Map a() {
            return this.f20997a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0283b) == true) goto L9;
            return false;
        L9:
            if (q.b(this.f20997a, ((C0283b) r10).f20997a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20997a.hashCode();
        }

        public String toString() {
            return "PickedData(selections=" + this.f20997a + ')';
        }
    }

    public b() {
    }

    public static final /* synthetic */ void a(b r10, a r11) {
        r10.f20989a = r11;
    }

    @Override // com.obric.oui.picker.OPicker
    public View asView() {
        a r10 = this.f20989a;
        if (r10 == null) goto L10;
        OReelPicker r11 = r10.g();
        if (r11 != null) goto L9;
        return null;
    L9:
        return r11.asView();
    L10:
        return null;
    }

    public C0283b b() {
        a r10 = this.f20989a;
        if (r10 != null) goto L6;
        return null;
    L6:
        return new C0283b(k0.s(r10.h()));
    }

    @Override // com.obric.oui.picker.OPicker
    public /* bridge */ /* synthetic */ Object getPicked() {
        return b();
    }
}
