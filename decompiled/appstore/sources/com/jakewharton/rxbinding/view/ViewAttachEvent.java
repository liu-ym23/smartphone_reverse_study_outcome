package com.jakewharton.rxbinding.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewAttachEvent extends ViewEvent<View> {
    private final Kind kind;

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind ATTACH = null;
        public static final Kind DETACH = null;

        static {
            Kind r10 = new Kind("ATTACH", 0);
            ATTACH = r10;
            Kind r11 = new Kind("DETACH", 1);
            DETACH = r11;
            $VALUES = new Kind[]{r10, r11};
        }

        private Kind(String r10, int r11) {
            super(r10, r11);
        }

        public static Kind valueOf(String r10) {
            return (Kind) Enum.valueOf(Kind.class, r10);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    private ViewAttachEvent(@NonNull View r10, @NonNull Kind r11) {
        super(r10);
        this.kind = r11;
    }

    @NonNull
    @CheckResult
    public static ViewAttachEvent create(@NonNull View r10, @NonNull Kind r11) {
        return new ViewAttachEvent(r10, r11);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewAttachEvent) == true) goto L8;
        return false;
    L8:
        ViewAttachEvent r11 = (ViewAttachEvent) r10;
        if (r11.view() != view()) goto L14;
        if (r11.kind() != kind()) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return ((629 + view().hashCode()) * 37) + kind().hashCode();
    }

    @NonNull
    public Kind kind() {
        return this.kind;
    }

    public String toString() {
        return "ViewAttachEvent{view=" + view() + ", kind=" + kind() + '}';
    }
}
