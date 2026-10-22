package com.android.ttcjpaysdk.base.ui.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge;", "", "()V", "Dot", "None", "Text", "Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge$Dot;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge$None;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge$Text;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJBadge {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge$Dot;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge;", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Dot extends CJBadge {
        public static final Dot INSTANCE = null;

        static {
            INSTANCE = new Dot();
        }

        private Dot() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge$None;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge;", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None extends CJBadge {
        public static final None INSTANCE = null;

        static {
            INSTANCE = new None();
        }

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge$Text;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJBadge;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Text extends CJBadge {
        private final String value;

        public static /* synthetic */ Text copy$default(Text r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.value;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.value;
        }

        public final Text copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            return new Text(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Text) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.value, ((Text) r100).value) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Text(value=" + this.value + ')';
        }

        public final String getValue() {
            return this.value;
        }

        public Text(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            super(null);
            this.value = r100;
        }
    }

    private CJBadge() {
    }

    public /* synthetic */ CJBadge(DefaultConstructorMarker r100) {
        this();
    }
}
