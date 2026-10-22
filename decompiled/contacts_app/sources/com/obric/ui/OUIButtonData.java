package com.obric.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUIButtonData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/ui/OUIButtonData;", "", "()V", "IconButton", "TextButton", "Lcom/obric/ui/OUIButtonData$IconButton;", "Lcom/obric/ui/OUIButtonData$TextButton;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class OUIButtonData {

    /* JADX INFO: compiled from: OUIButtonData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/ui/OUIButtonData$IconButton;", "Lcom/obric/ui/OUIButtonData;", "drawableResId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(ILandroid/view/View$OnClickListener;)V", "getDrawableResId", "()I", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class IconButton extends OUIButtonData {
        private final int drawableResId;
        private final View.OnClickListener onClickListener;

        public static /* synthetic */ IconButton copy$default(IconButton r0, int r1, View.OnClickListener r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.drawableResId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.onClickListener;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.drawableResId;
        }

        public final View.OnClickListener component2() {
            return this.onClickListener;
        }

        public final IconButton copy(int r1, View.OnClickListener r2) {
            return new IconButton(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof IconButton) == true) goto L8;
            return false;
        L8:
            IconButton r6 = (IconButton) r5;
            if (this.drawableResId == r6.drawableResId) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.onClickListener, r6.onClickListener) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.drawableResId) * 31;
            View.OnClickListener r1 = this.onClickListener;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "IconButton(drawableResId=" + this.drawableResId + ", onClickListener=" + this.onClickListener + ')';
        }

        public IconButton(int r2, View.OnClickListener r3) {
            super(null);
            this.drawableResId = r2;
            this.onClickListener = r3;
        }

        public /* synthetic */ IconButton(int r1, View.OnClickListener r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final int getDrawableResId() {
            return this.drawableResId;
        }

        public final View.OnClickListener getOnClickListener() {
            return this.onClickListener;
        }
    }

    /* JADX INFO: compiled from: OUIButtonData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/ui/OUIButtonData$TextButton;", "Lcom/obric/ui/OUIButtonData;", "text", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TextButton extends OUIButtonData {
        private final View.OnClickListener onClickListener;
        private final String text;

        public static /* synthetic */ TextButton copy$default(TextButton r0, String r1, View.OnClickListener r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.text;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.onClickListener;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.text;
        }

        public final View.OnClickListener component2() {
            return this.onClickListener;
        }

        public final TextButton copy(String r1, View.OnClickListener r2) {
            Intrinsics.checkNotNullParameter(r1, "text");
            return new TextButton(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TextButton) == true) goto L8;
            return false;
        L8:
            TextButton r6 = (TextButton) r5;
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.onClickListener, r6.onClickListener) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.text.hashCode() * 31;
            View.OnClickListener r1 = this.onClickListener;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TextButton(text=" + this.text + ", onClickListener=" + this.onClickListener + ')';
        }

        public TextButton(String r2, View.OnClickListener r3) {
            Intrinsics.checkNotNullParameter(r2, "text");
            super(null);
            this.text = r2;
            this.onClickListener = r3;
        }

        public /* synthetic */ TextButton(String r1, View.OnClickListener r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final View.OnClickListener getOnClickListener() {
            return this.onClickListener;
        }

        public final String getText() {
            return this.text;
        }
    }

    public /* synthetic */ OUIButtonData(DefaultConstructorMarker r1) {
        this();
    }

    private OUIButtonData() {
    }
}
