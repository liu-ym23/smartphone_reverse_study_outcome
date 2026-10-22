package com.android.contacts.datepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.android.contacts.lunar.LunarCalendar;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.pickers.OReelPickerBuilder;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OReelPickerLunarDate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/contacts/datepicker/OReelPickerLunarDate;", "Lcom/obric/oui/picker/OPicker;", "Lcom/android/contacts/datepicker/OReelPickerLunarDate$SelectionDate;", "()V", "mBuilder", "Lcom/android/contacts/datepicker/OReelPickerLunarDate$Builder;", "asView", "Landroid/view/View;", "getPicked", "Builder", "Reels", "SelectionDate", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OReelPickerLunarDate implements OPicker<SelectionDate> {
    private Builder mBuilder;

    /* JADX INFO: compiled from: OReelPickerLunarDate.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u0010H\u0002J\u001a\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\u0010H\u0002J \u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0016\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u001e\u00100\u001a\u00020.2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u00101\u001a\u00020\u0010J\u0016\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010J\f\u00105\u001a\u00020\u0003*\u000206H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00060\u0018R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/android/contacts/datepicker/OReelPickerLunarDate$Builder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "Lcom/android/contacts/datepicker/OReelPickerLunarDate;", "Lcom/android/contacts/datepicker/OReelPickerLunarDate$SelectionDate;", "()V", "mBuilt", "Lcom/obric/oui/picker/reels/OReelPicker;", "getMBuilt$app_QssiCnRelease", "()Lcom/obric/oui/picker/reels/OReelPicker;", "setMBuilt$app_QssiCnRelease", "(Lcom/obric/oui/picker/reels/OReelPicker;)V", "mChangedListener", "Ljava/util/function/Consumer;", "mContext", "Landroid/content/Context;", "mFromYear", "", "mSelected", "getMSelected$app_QssiCnRelease", "()Lcom/android/contacts/datepicker/OReelPickerLunarDate$SelectionDate;", "setMSelected$app_QssiCnRelease", "(Lcom/android/contacts/datepicker/OReelPickerLunarDate$SelectionDate;)V", "mToYear", "rcListener", "Lcom/android/contacts/datepicker/OReelPickerLunarDate$Builder$ReelChangedListener;", "build", "context", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "buildDayReel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "month", "year", "defaultDay", "buildMonthReel", "defaultMoth", "buildYearReel", "getChineseEraYear", "", "getColumData", "field", "lunar", "Lcom/android/contacts/lunar/LunarCalendar;", "oldData", "setOnChangedListener", "", "listener", "setSelected", "dayOfMonth", "setYearRange", "from", "to", "toSelection", "Ljava/time/LocalDate;", "ReelChangedListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder implements OReelPickerBuilder<OReelPickerLunarDate, SelectionDate> {
        private OReelPicker mBuilt;
        private Consumer<SelectionDate> mChangedListener;
        private Context mContext;
        private int mFromYear;
        private SelectionDate mSelected;
        private int mToYear;
        private final ReelChangedListener rcListener;

        /* JADX INFO: compiled from: OReelPickerLunarDate.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¨\u0006\u0017"}, d2 = {"Lcom/android/contacts/datepicker/OReelPickerLunarDate$Builder$ReelChangedListener;", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "(Lcom/android/contacts/datepicker/OReelPickerLunarDate$Builder;)V", "notifyChange", "", "onDayChanged", "changedToDay", "", "onMonthChanged", "changedToMonth", "onReelChanged", "reelId", "selectedIndex", "onYearChanged", "changedToYear", "rebuildDaysReel", "month", "year", "defaultDay", "rebuildMonthReel", "defaultMoth", "updateSelection", "day", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
            final /* synthetic */ Builder this$0;

            public ReelChangedListener(Builder r1) {
                this.this$0 = r1;
            }

            private final void onYearChanged(int r7) {
                SelectionDate r0 = this.this$0.getMSelected$app_QssiCnRelease().clone();
                LunarCalendar r1 = new LunarCalendar();
                r1.set(1, r7);
                int r2 = Builder.access$getColumData(this.this$0, 2, r1, r0.getMonth());
                r1.set(2, r2);
                int r3 = Builder.access$getColumData(this.this$0, 5, r1, r0.getDay());
                updateSelection(r7, r2, r3);
                if (r7 == r0.getYear()) goto L5;
            L8:
                rebuildMonthReel(r7, r2);
                rebuildDaysReel(r0.getMonth(), r7, r3);
                return;
            L5:
                if (r2 != r0.getMonth()) goto L8;
                if (r3 != r0.getDay()) goto L8;
            }

            private final void onMonthChanged(int r6) {
                SelectionDate r0 = this.this$0.getMSelected$app_QssiCnRelease().clone();
                LunarCalendar r1 = new LunarCalendar();
                r1.set(1, r0.getYear());
                r1.set(2, r6);
                int r2 = Builder.access$getColumData(this.this$0, 5, r1, r0.getDay());
                updateSelection(r0.getYear(), r6, r2);
                if (r0.getMonth() == r6) goto L5;
            L6:
                rebuildDaysReel(r6, r0.getYear(), r2);
                return;
            L5:
                if (r2 != r0.getDay()) goto L6;
            }

            private final void onDayChanged(int r3) {
                updateSelection(this.this$0.getMSelected$app_QssiCnRelease().getYear(), this.this$0.getMSelected$app_QssiCnRelease().getMonth(), r3);
            }

            static /* synthetic */ void rebuildDaysReel$default(ReelChangedListener r0, int r1, int r2, int r3, int r4, Object r5) {
                if ((r4 & 4) == 0) goto L5;
                r3 = -1;
            L5:
                r0.rebuildDaysReel(r1, r2, r3);
            }

            private final void rebuildDaysReel(int r2, int r3, int r4) {
                OReelPicker r0 = this.this$0.getMBuilt$app_QssiCnRelease();
                if (r0 == null) goto L6;
                r0.configure(2, Builder.access$buildDayReel(this.this$0, r2, r3, r4));
                return;
            }

            static /* synthetic */ void rebuildMonthReel$default(ReelChangedListener r0, int r1, int r2, int r3, Object r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = -1;
            L5:
                r0.rebuildMonthReel(r1, r2);
            }

            private final void rebuildMonthReel(int r2, int r3) {
                OReelPicker r0 = this.this$0.getMBuilt$app_QssiCnRelease();
                if (r0 == null) goto L6;
                r0.configure(1, Builder.access$buildMonthReel(this.this$0, r2, r3));
                return;
            }

            private final void updateSelection(int r3, int r4, int r5) {
                LunarCalendar r0 = new LunarCalendar();
                r0.set(1, r3);
                r0.set(2, r4);
                r0.set(5, r5);
                SelectionDate r2 = this.this$0.getMSelected$app_QssiCnRelease();
                r2.setYear(r3);
                r2.setMonth(r4);
                r2.setDay(Math.min(r0.get(5), r0.getActualMaximum(5)));
            }

            private final void notifyChange() {
                Consumer r0 = Builder.access$getMChangedListener$p(this.this$0);
                if (r0 == null) goto L6;
                r0.accept(this.this$0.getMSelected$app_QssiCnRelease());
                return;
            }

            @Override // com.obric.oui.picker.reels.OReelPicker.ReelChangedListener
            public void onReelChanged(int r3, int r4) {
                if (r3 != 0) goto L4;
                onYearChanged(Builder.access$getMFromYear$p(this.this$0) + r4);
            L11:
                notifyChange();
                return;
            L4:
                if (r3 != 1) goto L6;
                onMonthChanged(r4 + 1);
                goto L11
            L6:
                if (r3 != 2) goto L11;
                onDayChanged(r4 + 1);
                goto L11
            }
        }

        public Builder() {
            this.mFromYear = 1900;
            this.mToYear = 3100;
            LocalDate r0 = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(r0, "now()");
            this.mSelected = toSelection(r0);
            this.rcListener = new ReelChangedListener(this);
        }

        public static final /* synthetic */ OReelPicker.Reel access$buildDayReel(Builder r0, int r1, int r2, int r3) {
            return r0.buildDayReel(r1, r2, r3);
        }

        public static final /* synthetic */ OReelPicker.Reel access$buildMonthReel(Builder r0, int r1, int r2) {
            return r0.buildMonthReel(r1, r2);
        }

        public static final /* synthetic */ int access$getColumData(Builder r0, int r1, LunarCalendar r2, int r3) {
            return r0.getColumData(r1, r2, r3);
        }

        public static final /* synthetic */ Consumer access$getMChangedListener$p(Builder r0) {
            return r0.mChangedListener;
        }

        public static final /* synthetic */ int access$getMFromYear$p(Builder r0) {
            return r0.mFromYear;
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public /* bridge */ /* synthetic */ OReelPickerLunarDate build(Context r1, AttributeSet r2, int r3) {
            return build(r1, r2, r3);
        }

        public final SelectionDate getMSelected$app_QssiCnRelease() {
            return this.mSelected;
        }

        public final void setMSelected$app_QssiCnRelease(SelectionDate r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mSelected = r2;
        }

        public final OReelPicker getMBuilt$app_QssiCnRelease() {
            return this.mBuilt;
        }

        public final void setMBuilt$app_QssiCnRelease(OReelPicker r1) {
            this.mBuilt = r1;
        }

        private final SelectionDate toSelection(LocalDate r3) {
            return new SelectionDate(r3.getYear(), r3.getMonthValue(), r3.getDayOfMonth());
        }

        public final Builder setYearRange(int r1, int r2) {
            if (r1 > r2) goto L4;
            this.mFromYear = r1;
            this.mToYear = r2;
        L4:
            return this;
        }

        public final void setSelected(int r2, int r3, int r4) {
            this.mSelected = new SelectionDate(r2, r3, r4);
        }

        private final OReelPicker.Reel buildYearReel() {
            int r0 = this.mFromYear;
            ArrayList r1 = new ArrayList();
        L4:
            if (r0 > this.mToYear) goto L6;
            r1.add(getChineseEraYear(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            int r11 = Math.min(Math.max(this.mSelected.getYear() - this.mFromYear, 0), this.mToYear - this.mFromYear);
            this.mSelected.setYear(this.mFromYear + r11);
            return new OReelPicker.Reel(0, r1, null, 0.0f, null, null, null, r11, this.rcListener, 124, null);
        }

        static /* synthetic */ OReelPicker.Reel buildMonthReel$default(Builder r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = -1;
        L6:
            return r0.buildMonthReel(r1, r2);
        }

        private final OReelPicker.Reel buildMonthReel(int r20, int r21) {
            int r1 = r21;
            LunarCalendar r2 = new LunarCalendar();
            r2.set(1, r20);
            int r5 = r2.getActualMaximum(2);
            int r6 = r2.getActualMinimum(2);
            String[] r3 = r2.getDisplayedValues(2);
            Intrinsics.checkNotNullExpressionValue(r3, "lunar.getDisplayedValues(Calendar.MONTH)");
            List r9 = ArraysKt.toList(r3).subList(r6 - 1, r5);
            if (r1 != (-1)) goto L7;
            r1 = this.mSelected.getMonth();
        L7:
            return new OReelPicker.Reel(1, r9, null, 0.0f, null, null, null, r1 - 1, this.rcListener, 124, null);
        }

        static /* synthetic */ OReelPicker.Reel buildDayReel$default(Builder r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = -1;
        L6:
            return r0.buildDayReel(r1, r2, r3);
        }

        private final OReelPicker.Reel buildDayReel(int r20, int r21, int r22) {
            int r1 = r22;
            LunarCalendar r2 = new LunarCalendar();
            r2.set(1, r21);
            r2.set(2, r20);
            int r5 = r2.getActualMaximum(5);
            int r6 = r2.getActualMinimum(5);
            String[] r3 = r2.getDisplayedValues(5);
            Intrinsics.checkNotNullExpressionValue(r3, "lunar.getDisplayedValues(Calendar.DAY_OF_MONTH)");
            List r9 = ArraysKt.toList(r3).subList(r6 - 1, r5);
            if (r1 != (-1)) goto L7;
            r1 = this.mSelected.getDay();
        L7:
            return new OReelPicker.Reel(2, r9, null, 0.0f, null, null, null, r1 - 1, this.rcListener, 124, null);
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public void setOnChangedListener(Consumer<SelectionDate> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mChangedListener = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public OReelPickerLunarDate build(Context r9, AttributeSet r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "context");
            OReelPickerThreeReels.Builder r0 = new OReelPickerThreeReels.Builder();
            r0.addReel(buildYearReel());
            r0.addReel(buildMonthReel$default(this, this.mSelected.getYear(), 0, 2, null));
            r0.addReel(buildDayReel$default(this, this.mSelected.getMonth(), this.mSelected.getYear(), 0, 4, null));
            OReelPicker r12 = r0.build(r9, r10, r11);
            this.mContext = r9;
            this.mBuilt = r12;
            OReelPickerLunarDate r13 = new OReelPickerLunarDate();
            OReelPickerLunarDate.access$setMBuilder$p(r13, this);
            return r13;
        }

        private final String getChineseEraYear(int r3) {
            int r4 = (r3 - 4) % 60;
            return new LunarCalendar().HEAVENLY_STEMS[r4 % new LunarCalendar().HEAVENLY_STEMS.length] + new LunarCalendar().EARTH_BRANCHES[r4 % new LunarCalendar().EARTH_BRANCHES.length];
        }

        private final int getColumData(int r1, LunarCalendar r2, int r3) {
            if (r3 > r2.getActualMaximum(r1)) goto L5;
            return r3;
        L5:
            return r2.getActualMaximum(r1);
        }
    }

    /* JADX INFO: compiled from: OReelPickerLunarDate.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/datepicker/OReelPickerLunarDate$Reels;", "", "()V", "REEL_DAY", "", "REEL_MONTH", "REEL_YEAR", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Reels {
        public static final Reels INSTANCE = null;
        public static final int REEL_DAY = 2;
        public static final int REEL_MONTH = 1;
        public static final int REEL_YEAR = 0;

        static {
            INSTANCE = new Reels();
        }

        private Reels() {
        }
    }

    /* JADX INFO: compiled from: OReelPickerLunarDate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/android/contacts/datepicker/OReelPickerLunarDate$SelectionDate;", "", "year", "", "month", "day", "(III)V", "getDay", "()I", "setDay", "(I)V", "getMonth", "setMonth", "getYear", "setYear", "clone", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SelectionDate implements Cloneable {
        private int day;
        private int month;
        private int year;

        public static /* synthetic */ SelectionDate copy$default(SelectionDate r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.year;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.month;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.day;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.year;
        }

        public final int component2() {
            return this.month;
        }

        public final int component3() {
            return this.day;
        }

        public final SelectionDate copy(int r1, int r2, int r3) {
            return new SelectionDate(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SelectionDate) == true) goto L8;
            return false;
        L8:
            SelectionDate r6 = (SelectionDate) r5;
            if (this.year == r6.year) goto L12;
            return false;
        L12:
            if (this.month == r6.month) goto L15;
            return false;
        L15:
            if (this.day == r6.day) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.year) * 31) + Integer.hashCode(this.month)) * 31) + Integer.hashCode(this.day);
        }

        public String toString() {
            return "SelectionDate(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ')';
        }

        public SelectionDate(int r1, int r2, int r3) {
            this.year = r1;
            this.month = r2;
            this.day = r3;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m163clone() {
            return clone();
        }

        public final int getYear() {
            return this.year;
        }

        public final void setYear(int r1) {
            this.year = r1;
        }

        public final int getMonth() {
            return this.month;
        }

        public final void setMonth(int r1) {
            this.month = r1;
        }

        public final int getDay() {
            return this.day;
        }

        public final void setDay(int r1) {
            this.day = r1;
        }

        public SelectionDate clone() {
            Object r1 = super.clone();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.android.contacts.datepicker.OReelPickerLunarDate.SelectionDate");
            return (SelectionDate) r1;
        }
    }

    public OReelPickerLunarDate() {
    }

    public static final /* synthetic */ void access$setMBuilder$p(OReelPickerLunarDate r0, Builder r1) {
        r0.mBuilder = r1;
    }

    @Override // com.obric.oui.picker.OPicker
    public /* bridge */ /* synthetic */ SelectionDate getPicked() {
        return getPicked();
    }

    @Override // com.obric.oui.picker.OPicker
    public View asView() {
        Builder r0 = this.mBuilder;
        if (r0 == null) goto L7;
        OReelPicker r1 = r0.getMBuilt$app_QssiCnRelease();
        if (r1 == null) goto L7;
        return r1.asView();
    L7:
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.oui.picker.OPicker
    public SelectionDate getPicked() {
        Builder r0 = this.mBuilder;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMSelected$app_QssiCnRelease();
    }
}
