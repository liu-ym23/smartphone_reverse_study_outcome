package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OReelCustomPicker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker;", "Lcom/obric/oui/picker/OPicker;", "Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$CustomData;", "()V", "mBuilder", "Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$Builder;", "asView", "Landroid/view/View;", "getPicked", "Builder", "CustomData", "Reels", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelCustomPicker implements OPicker<CustomData> {
    private Builder mBuilder;

    /* JADX INFO: compiled from: OReelCustomPicker.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001CB\u0005¢\u0006\u0002\u0010\u0004J\"\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u0004\u0018\u0001082\u0006\u00101\u001a\u000202H\u0002J\u0012\u00109\u001a\u0004\u0018\u0001082\u0006\u00101\u001a\u000202H\u0002J\u0016\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0016J,\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020&2\b\b\u0002\u0010?\u001a\u0002062\b\b\u0002\u0010@\u001a\u0002062\b\b\u0002\u0010A\u001a\u000206J,\u0010B\u001a\u00020\u00002\u0006\u0010>\u001a\u00020&2\b\b\u0002\u0010?\u001a\u0002062\b\b\u0002\u0010@\u001a\u0002062\b\b\u0002\u0010A\u001a\u000206R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00060)R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010\fR\u001a\u0010-\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011¨\u0006D"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$Builder;", "Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker;", "Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$CustomData;", "()V", "leftString", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLeftString", "()Ljava/util/ArrayList;", "setLeftString", "(Ljava/util/ArrayList;)V", "leftTag", "getLeftTag", "()Ljava/lang/String;", "setLeftTag", "(Ljava/lang/String;)V", "mBuilt", "Lcom/obric/oui/picker/reels/OReelPicker;", "getMBuilt", "()Lcom/obric/oui/picker/reels/OReelPicker;", "setMBuilt", "(Lcom/obric/oui/picker/reels/OReelPicker;)V", "mChangedListener", "Ljava/util/function/Consumer;", "mLeft", "getMLeft$OUI_standardRelease", "()Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$CustomData;", "setMLeft$OUI_standardRelease", "(Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$CustomData;)V", "mRight", "getMRight$OUI_standardRelease", "setMRight$OUI_standardRelease", "mSelected", "getMSelected$OUI_standardRelease", "setMSelected$OUI_standardRelease", "mShowUnit", "", "mShowValue", "rcListener", "Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$Builder$ReelChangedListener;", "rightString", "getRightString", "setRightString", "rightTag", "getRightTag", "setRightTag", "build", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "buildLeftReel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "buildRightReel", "setOnChangedListener", "", "listener", "setShowLeftWheel", "show", "selected", "max", "min", "setShowRightWheel", "ReelChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder implements OReelPickerBuilder<OReelCustomPicker, CustomData> {
        private ArrayList<String> leftString;
        private String leftTag;
        private OReelPicker mBuilt;
        private Consumer<CustomData> mChangedListener;
        private CustomData mLeft;
        private CustomData mRight;
        private CustomData mSelected;
        private boolean mShowUnit;
        private boolean mShowValue;
        private final ReelChangedListener rcListener;
        private ArrayList<String> rightString;
        private String rightTag;

        /* JADX INFO: compiled from: OReelCustomPicker.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$Builder$ReelChangedListener;", "Lcom/obric/oui/picker/reels/OReelPicker$ReelChangedListener;", "(Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$Builder;)V", "notifyChange", "", "onReelChanged", "reelId", "", "selectedIndex", "onTimeChanged", "down", "up", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
            final /* synthetic */ Builder this$0;

            public ReelChangedListener(Builder r2) {
                Intrinsics.checkNotNullParameter(r2, "this$0");
                this.this$0 = r2;
            }

            static /* synthetic */ void onTimeChanged$default(ReelChangedListener r1, int r2, int r3, int r4, Object r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = -1;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = -1;
            L8:
                r1.onTimeChanged(r2, r3);
            }

            private final void onTimeChanged(int r2, int r3) {
                if (r2 < 0) goto L4;
                this.this$0.getMSelected$OUI_standardRelease().setDown(r2);
            L4:
                if (r3 < 0) goto L6;
                this.this$0.getMSelected$OUI_standardRelease().setUp(r3);
            L6:
                notifyChange();
            }

            private final void notifyChange() {
                Consumer r0 = Builder.access$getMChangedListener$p(this.this$0);
                if (r0 == null) goto L7;
                r0.accept(this.this$0.getMSelected$OUI_standardRelease());
                return;
            }

            @Override // com.obric.oui.picker.reels.OReelPicker.ReelChangedListener
            public void onReelChanged(int r3, int r4) {
                if (r3 != 0) goto L5;
                onTimeChanged(r4, -1);
            L9:
                notifyChange();
                return;
            L5:
                if (r3 != 1) goto L9;
                onTimeChanged(-1, r4);
                goto L9
            }
        }

        public Builder() {
            this.mShowValue = true;
            this.mShowUnit = true;
            this.leftString = new ArrayList();
            this.rightString = new ArrayList();
            this.leftTag = "";
            this.rightTag = "";
            int r1 = 0;
            int r2 = 3;
            DefaultConstructorMarker r3 = null;
            this.mSelected = new CustomData(r1, r1, r2, r3);
            this.mLeft = new CustomData(r1, r1, r2, r3);
            this.mRight = new CustomData(r1, r1, r2, r3);
            this.rcListener = new ReelChangedListener(this);
        }

        public static final /* synthetic */ Consumer access$getMChangedListener$p(Builder r0) {
            return r0.mChangedListener;
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public /* bridge */ /* synthetic */ OReelCustomPicker build(Context r1, AttributeSet r2, int r3) {
            return build(r1, r2, r3);
        }

        public final ArrayList<String> getLeftString() {
            return this.leftString;
        }

        public final void setLeftString(ArrayList<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.leftString = r2;
        }

        public final ArrayList<String> getRightString() {
            return this.rightString;
        }

        public final void setRightString(ArrayList<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.rightString = r2;
        }

        public final String getLeftTag() {
            return this.leftTag;
        }

        public final void setLeftTag(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.leftTag = r2;
        }

        public final String getRightTag() {
            return this.rightTag;
        }

        public final void setRightTag(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.rightTag = r2;
        }

        public final CustomData getMSelected$OUI_standardRelease() {
            return this.mSelected;
        }

        public final void setMSelected$OUI_standardRelease(CustomData r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mSelected = r2;
        }

        public final CustomData getMLeft$OUI_standardRelease() {
            return this.mLeft;
        }

        public final void setMLeft$OUI_standardRelease(CustomData r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mLeft = r2;
        }

        public final CustomData getMRight$OUI_standardRelease() {
            return this.mRight;
        }

        public final void setMRight$OUI_standardRelease(CustomData r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mRight = r2;
        }

        public final OReelPicker getMBuilt() {
            return this.mBuilt;
        }

        public final void setMBuilt(OReelPicker r1) {
            this.mBuilt = r1;
        }

        public static /* synthetic */ Builder setShowLeftWheel$default(Builder r1, boolean r2, int r3, int r4, int r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = 0;
        L12:
            return r1.setShowLeftWheel(r2, r3, r4, r5);
        }

        public final Builder setShowLeftWheel(boolean r1, int r2, int r3, int r4) {
            this.mShowValue = r1;
            this.mSelected.setDown(r2);
            this.mLeft.setUp(r3);
            this.mLeft.setDown(r4);
            return this;
        }

        public static /* synthetic */ Builder setShowRightWheel$default(Builder r1, boolean r2, int r3, int r4, int r5, int r6, Object r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = 0;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = 0;
        L12:
            return r1.setShowRightWheel(r2, r3, r4, r5);
        }

        public final Builder setShowRightWheel(boolean r1, int r2, int r3, int r4) {
            this.mShowUnit = r1;
            this.mSelected.setUp(r2);
            this.mRight.setUp(r3);
            this.mRight.setDown(r4);
            return this;
        }

        private final OReelPicker.Reel buildLeftReel(Context r20) {
            if (this.mShowValue == true) goto L6;
            return null;
        L6:
            ArrayList<String> r1 = this.leftString;
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r1.iterator();
            int r4 = 0;
        L8:
            if (r3.hasNext() == false) goto L22;
            Object r5 = r3.next();
            int r6 = r4 + 1;
            if (r4 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            String r7 = (String) r5;
            if (r4 >= getMLeft$OUI_standardRelease().getDown()) goto L15;
        L17:
            boolean r8 = false;
        L18:
            if (r8 == false) goto L20;
            r2.add(r5);
        L20:
            r4 = r6;
            goto L8
        L15:
            if (r4 > getMLeft$OUI_standardRelease().getUp()) goto L17;
            r8 = true;
            goto L18
        L22:
            return new OReelPicker.Reel(0, r2, this.leftTag, 0.0f, null, null, null, this.mSelected.getDown(), this.rcListener, 120, null);
        }

        private final OReelPicker.Reel buildRightReel(Context r20) {
            if (this.mShowUnit == true) goto L6;
            return null;
        L6:
            ArrayList<String> r1 = this.rightString;
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r1.iterator();
            int r4 = 0;
        L8:
            if (r3.hasNext() == false) goto L22;
            Object r5 = r3.next();
            int r6 = r4 + 1;
            if (r4 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            String r7 = (String) r5;
            if (r4 >= getMRight$OUI_standardRelease().getDown()) goto L15;
        L17:
            boolean r8 = false;
        L18:
            if (r8 == false) goto L20;
            r2.add(r5);
        L20:
            r4 = r6;
            goto L8
        L15:
            if (r4 > getMRight$OUI_standardRelease().getUp()) goto L17;
            r8 = true;
            goto L18
        L22:
            return new OReelPicker.Reel(1, r2, this.rightTag, 0.0f, null, null, null, this.mSelected.getUp(), this.rcListener, 120, null);
        }

        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public void setOnChangedListener(Consumer<CustomData> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mChangedListener = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.obric.oui.picker.reels.pickers.OReelPickerBuilder
        public OReelCustomPicker build(Context r3, AttributeSet r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            OReelPickerThreeReels.Builder r0 = new OReelPickerThreeReels.Builder();
            OReelPicker.Reel r1 = buildLeftReel(r3);
            if (r1 == null) goto L6;
            r0.addReel(r1);
        L6:
            OReelPicker.Reel r2 = buildRightReel(r3);
            if (r2 == null) goto L10;
            r0.addReel(r2);
        L10:
            OReelPicker r6 = r0.build(r3, r4, r5);
            OReelCustomPicker r7 = new OReelCustomPicker();
            setMBuilt(r6);
            OReelCustomPicker.access$setMBuilder$p(r7, this);
            return r7;
        }
    }

    /* JADX INFO: compiled from: OReelCustomPicker.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$CustomData;", "", "down", "", "up", "(II)V", "getDown", "()I", "setDown", "(I)V", "getUp", "setUp", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CustomData {
        private int down;
        private int up;

        public CustomData() {
            int r2 = 0;
            this(r2, r2, 3, null);
        }

        public static /* synthetic */ CustomData copy$default(CustomData r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.down;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.up;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.down;
        }

        public final int component2() {
            return this.up;
        }

        public final CustomData copy(int r1, int r2) {
            return new CustomData(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CustomData) == true) goto L8;
            return false;
        L8:
            CustomData r6 = (CustomData) r5;
            if (this.down == r6.down) goto L12;
            return false;
        L12:
            if (this.up == r6.up) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.down) * 31) + Integer.hashCode(this.up);
        }

        public String toString() {
            return "CustomData(down=" + this.down + ", up=" + this.up + ')';
        }

        public CustomData(int r1, int r2) {
            this.down = r1;
            this.up = r2;
        }

        public /* synthetic */ CustomData(int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            this(r2, r3);
        }

        public final int getDown() {
            return this.down;
        }

        public final void setDown(int r1) {
            this.down = r1;
        }

        public final int getUp() {
            return this.up;
        }

        public final void setUp(int r1) {
            this.up = r1;
        }
    }

    /* JADX INFO: compiled from: OReelCustomPicker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelCustomPicker$Reels;", "", "()V", "REEL_LEFT", "", "REEL_RIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Reels {
        public static final Reels INSTANCE = null;
        public static final int REEL_LEFT = 0;
        public static final int REEL_RIGHT = 1;

        static {
            INSTANCE = new Reels();
        }

        private Reels() {
        }
    }

    public OReelCustomPicker() {
    }

    public static final /* synthetic */ void access$setMBuilder$p(OReelCustomPicker r0, Builder r1) {
        r0.mBuilder = r1;
    }

    @Override // com.obric.oui.picker.OPicker
    public /* bridge */ /* synthetic */ CustomData getPicked() {
        return getPicked();
    }

    @Override // com.obric.oui.picker.OPicker
    public View asView() {
        Builder r1 = this.mBuilder;
        if (r1 == null) goto L10;
        OReelPicker r2 = r1.getMBuilt();
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.asView();
    L10:
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.oui.picker.OPicker
    public CustomData getPicked() {
        Builder r0 = this.mBuilder;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getMSelected$OUI_standardRelease();
    }
}
