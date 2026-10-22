package com.obric.oui.picker.reels;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.picker.reels.views.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OReelPicker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\f\r\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/picker/reels/OReelPicker;", "", "asView", "Landroid/view/View;", "configure", "", "col", "", "reel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "getReelView", "Lcom/obric/oui/picker/reels/views/WheelView;", "Builder", "Reel", "ReelChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OReelPicker {

    /* JADX INFO: compiled from: OReelPicker.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/oui/picker/reels/OReelPicker$Builder;", "", "addReel", "reel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "build", "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Builder {

        /* JADX INFO: compiled from: OReelPicker.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ OReelPicker build$default(Builder r0, Context r1, AttributeSet r2, int r3, int r4, Object r5) {
                if (r5 != null) goto L12;
                if ((r4 & 2) == 0) goto L7;
                r2 = null;
            L7:
                if ((r4 & 4) == 0) goto L10;
                r3 = 0;
            L10:
                return r0.build(r1, r2, r3);
            L12:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
            }
        }

        Builder addReel(Reel r1);

        OReelPicker build(Context r1, AttributeSet r2, int r3);
    }

    /* JADX INFO: compiled from: OReelPicker.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jx\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "", "id", "", "entries", "", "", SimContactsConstants.STR_TAG, "", "widthWeight", "", MaterialConfigFormatNames.WIDTH, "minWidth", "tagGap", "selectedIndex", "reelChangedListener", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "(ILjava/util/List;Ljava/lang/CharSequence;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;)V", "getEntries", "()Ljava/util/List;", "getId", "()I", "getMinWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReelChangedListener", "()Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "getSelectedIndex", "getTag", "()Ljava/lang/CharSequence;", "getTagGap", "getWidth", "getWidthWeight", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/util/List;Ljava/lang/CharSequence;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;)Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "equals", "", "other", "hashCode", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Reel {
        private final List<String> entries;
        private final int id;
        private final Integer minWidth;
        private final ReelChangedListener reelChangedListener;
        private final int selectedIndex;
        private final CharSequence tag;
        private final Integer tagGap;
        private final Integer width;
        private final float widthWeight;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Reel copy$default(Reel r10, int r11, List r12, CharSequence r13, float r14, Integer r15, Integer r16, Integer r17, int r18, ReelChangedListener r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            int r2 = r10.id;
        L7:
            if ((r20 & 2) == 0) goto L9;
            List r3 = r10.entries;
        L11:
            if ((r20 & 4) == 0) goto L13;
            CharSequence r4 = r10.tag;
        L15:
            if ((r20 & 8) == 0) goto L17;
            float r5 = r10.widthWeight;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Integer r6 = r10.width;
        L23:
            if ((r20 & 32) == 0) goto L25;
            Integer r7 = r10.minWidth;
        L27:
            if ((r20 & 64) == 0) goto L29;
            Integer r8 = r10.tagGap;
        L31:
            if ((r20 & 128) == 0) goto L33;
            int r9 = r10.selectedIndex;
        L35:
            if ((r20 & 256) == 0) goto L37;
            ReelChangedListener r1 = r10.reelChangedListener;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final int component1() {
            return this.id;
        }

        public final List<String> component2() {
            return this.entries;
        }

        public final CharSequence component3() {
            return this.tag;
        }

        public final float component4() {
            return this.widthWeight;
        }

        public final Integer component5() {
            return this.width;
        }

        public final Integer component6() {
            return this.minWidth;
        }

        public final Integer component7() {
            return this.tagGap;
        }

        public final int component8() {
            return this.selectedIndex;
        }

        public final ReelChangedListener component9() {
            return this.reelChangedListener;
        }

        public final Reel copy(int r12, List<String> r13, CharSequence r14, float r15, Integer r16, Integer r17, Integer r18, int r19, ReelChangedListener r20) {
            Intrinsics.checkNotNullParameter(r13, "entries");
            return new Reel(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Reel) == true) goto L8;
            return false;
        L8:
            Reel r6 = (Reel) r5;
            if (this.id == r6.id) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.entries, r6.entries) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.widthWeight), Float.valueOf(r6.widthWeight)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.width, r6.width) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.minWidth, r6.minWidth) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.tagGap, r6.tagGap) == true) goto L30;
            return false;
        L30:
            if (this.selectedIndex == r6.selectedIndex) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.reelChangedListener, r6.reelChangedListener) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.id) * 31) + this.entries.hashCode()) * 31;
            CharSequence r1 = this.tag;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Float.hashCode(this.widthWeight)) * 31;
            Integer r5 = this.width;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.minWidth;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.tagGap;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (((r10 + r12) * 31) + Integer.hashCode(this.selectedIndex)) * 31;
            ReelChangedListener r14 = this.reelChangedListener;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return r13 + r2;
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Reel(id=" + this.id + ", entries=" + this.entries + ", tag=" + this.tag + ", widthWeight=" + this.widthWeight + ", width=" + this.width + ", minWidth=" + this.minWidth + ", tagGap=" + this.tagGap + ", selectedIndex=" + this.selectedIndex + ", reelChangedListener=" + this.reelChangedListener + ')';
        }

        public Reel(int r2, List<String> r3, CharSequence r4, float r5, Integer r6, Integer r7, Integer r8, int r9, ReelChangedListener r10) {
            Intrinsics.checkNotNullParameter(r3, "entries");
            this.id = r2;
            this.entries = r3;
            this.tag = r4;
            this.widthWeight = r5;
            this.width = r6;
            this.minWidth = r7;
            this.tagGap = r8;
            this.selectedIndex = r9;
            this.reelChangedListener = r10;
        }

        public /* synthetic */ Reel(int r14, List r15, CharSequence r16, float r17, Integer r18, Integer r19, Integer r20, int r21, ReelChangedListener r22, int r23, DefaultConstructorMarker r24) {
            if ((r23 & 4) == 0) goto L5;
            CharSequence r6 = null;
        L7:
            if ((r23 & 8) == 0) goto L9;
            float r7 = 1.0f;
        L11:
            if ((r23 & 16) == 0) goto L13;
            Integer r8 = null;
        L15:
            if ((r23 & 32) == 0) goto L17;
            Integer r9 = null;
        L19:
            if ((r23 & 64) == 0) goto L21;
            Integer r10 = null;
        L23:
            if ((r23 & 128) == 0) goto L25;
            int r11 = 0;
        L27:
            if ((r23 & 256) == 0) goto L29;
            ReelChangedListener r12 = null;
        L30:
            this(r14, r15, r6, r7, r8, r9, r10, r11, r12);
            return;
        L29:
            r12 = r22;
            goto L30
        L25:
            r11 = r21;
            goto L27
        L21:
            r10 = r20;
            goto L23
        L17:
            r9 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r7 = r17;
            goto L11
        L5:
            r6 = r16;
            goto L7
        }

        public final int getId() {
            return this.id;
        }

        public final List<String> getEntries() {
            return this.entries;
        }

        public final CharSequence getTag() {
            return this.tag;
        }

        public final float getWidthWeight() {
            return this.widthWeight;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final Integer getMinWidth() {
            return this.minWidth;
        }

        public final Integer getTagGap() {
            return this.tagGap;
        }

        public final int getSelectedIndex() {
            return this.selectedIndex;
        }

        public final ReelChangedListener getReelChangedListener() {
            return this.reelChangedListener;
        }
    }

    /* JADX INFO: compiled from: OReelPicker.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "", "onReelChanged", "", "reelId", "", "selectedIndex", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ReelChangedListener {
        void onReelChanged(int r1, int r2);
    }

    View asView();

    void configure(int r1, Reel r2);

    WheelView getReelView(int r1);
}
