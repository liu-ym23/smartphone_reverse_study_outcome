package com.obric.oui.picker.reels;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.picker.reels.views.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/picker/reels/OReelPicker;", "", "Landroid/view/View;", "asView", "()Landroid/view/View;", "", "col", "Lcom/obric/oui/picker/reels/views/WheelView;", "getReelView", "(I)Lcom/obric/oui/picker/reels/views/WheelView;", "Lcom/obric/oui/picker/reels/OReelPicker$a;", "reel", "", "configure", "(ILcom/obric/oui/picker/reels/OReelPicker$a;)V", "Builder", "a", "ReelChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OReelPicker {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/picker/reels/OReelPicker$Builder;", "", "Lcom/obric/oui/picker/reels/OReelPicker$a;", "reel", "addReel", "(Lcom/obric/oui/picker/reels/OReelPicker$a;)Lcom/obric/oui/picker/reels/OReelPicker$Builder;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "Lcom/obric/oui/picker/reels/OReelPicker;", "build", "(Landroid/content/Context;Landroid/util/AttributeSet;I)Lcom/obric/oui/picker/reels/OReelPicker;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Builder {
        @NotNull
        Builder addReel(@NotNull a r10);

        @NotNull
        OReelPicker build(@NotNull Context r10, @Nullable AttributeSet r11, int r12);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "", "onReelChanged", "", "reelId", "", "selectedIndex", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ReelChangedListener {
        void onReelChanged(int r10, int r11);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f15917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f15918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f15919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f15920e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f15921f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f15922g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f15923h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ReelChangedListener f15924i;

        public a(int r10, List r11, CharSequence r12, float r13, Integer r14, Integer r15, Integer r16, int r17, ReelChangedListener r18) {
            q.g(r11, "entries");
            this.f15916a = r10;
            this.f15917b = r11;
            this.f15918c = r12;
            this.f15919d = r13;
            this.f15920e = r14;
            this.f15921f = r15;
            this.f15922g = r16;
            this.f15923h = r17;
            this.f15924i = r18;
        }

        public final List a() {
            return this.f15917b;
        }

        public final int b() {
            return this.f15916a;
        }

        public final Integer c() {
            return this.f15921f;
        }

        public final ReelChangedListener d() {
            return this.f15924i;
        }

        public final int e() {
            return this.f15923h;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f15916a == r11.f15916a) goto L12;
            return false;
        L12:
            if (q.b(this.f15917b, r11.f15917b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f15918c, r11.f15918c) == true) goto L18;
            return false;
        L18:
            if (q.b(Float.valueOf(this.f15919d), Float.valueOf(r11.f15919d)) == true) goto L21;
            return false;
        L21:
            if (q.b(this.f15920e, r11.f15920e) == true) goto L24;
            return false;
        L24:
            if (q.b(this.f15921f, r11.f15921f) == true) goto L27;
            return false;
        L27:
            if (q.b(this.f15922g, r11.f15922g) == true) goto L30;
            return false;
        L30:
            if (this.f15923h == r11.f15923h) goto L33;
            return false;
        L33:
            if (q.b(this.f15924i, r11.f15924i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final CharSequence f() {
            return this.f15918c;
        }

        public final Integer g() {
            return this.f15922g;
        }

        public final Integer h() {
            return this.f15920e;
        }

        public int hashCode() {
            int r10 = ((Integer.hashCode(this.f15916a) * 31) + this.f15917b.hashCode()) * 31;
            CharSequence r11 = this.f15918c;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (((r10 + r13) * 31) + Float.hashCode(this.f15919d)) * 31;
            Integer r15 = this.f15920e;
            if (r15 != null) goto L9;
            int r16 = 0;
        L10:
            int r17 = (r14 + r16) * 31;
            Integer r18 = this.f15921f;
            if (r18 != null) goto L13;
            int r19 = 0;
        L14:
            int r20 = (r17 + r19) * 31;
            Integer r21 = this.f15922g;
            if (r21 != null) goto L17;
            int r22 = 0;
        L18:
            int r23 = (((r20 + r22) * 31) + Integer.hashCode(this.f15923h)) * 31;
            ReelChangedListener r24 = this.f15924i;
            if (r24 == null) goto L23;
            r12 = r24.hashCode();
        L23:
            return r23 + r12;
        L17:
            r22 = r21.hashCode();
            goto L18
        L13:
            r19 = r18.hashCode();
            goto L14
        L9:
            r16 = r15.hashCode();
            goto L10
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public final float i() {
            return this.f15919d;
        }

        public String toString() {
            return "Reel(id=" + this.f15916a + ", entries=" + this.f15917b + ", tag=" + this.f15918c + ", widthWeight=" + this.f15919d + ", width=" + this.f15920e + ", minWidth=" + this.f15921f + ", tagGap=" + this.f15922g + ", selectedIndex=" + this.f15923h + ", reelChangedListener=" + this.f15924i + ')';
        }
    }

    @NotNull
    View asView();

    void configure(int r10, @NotNull a r11);

    @Nullable
    WheelView getReelView(int r10);
}
