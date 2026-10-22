package com.jakewharton.rxbinding.view;

import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class MenuItemActionViewEvent extends MenuItemEvent<MenuItem> {
    private final Kind kind;

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind COLLAPSE = null;
        public static final Kind EXPAND = null;

        static {
            Kind r10 = new Kind("EXPAND", 0);
            EXPAND = r10;
            Kind r11 = new Kind("COLLAPSE", 1);
            COLLAPSE = r11;
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

    private MenuItemActionViewEvent(@NonNull MenuItem r10, @NonNull Kind r11) {
        super(r10);
        this.kind = r11;
    }

    @NonNull
    @CheckResult
    public static MenuItemActionViewEvent create(@NonNull MenuItem r10, @NonNull Kind r11) {
        return new MenuItemActionViewEvent(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L18:
        return false;
    L8:
        if (MenuItemActionViewEvent.class != r10.getClass()) goto L18;
        MenuItemActionViewEvent r11 = (MenuItemActionViewEvent) r10;
        if (menuItem().equals(r11.menuItem()) == true) goto L14;
        return false;
    L14:
        if (this.kind != r11.kind) goto L17;
        return true;
    L17:
        return false;
    }

    public int hashCode() {
        return (menuItem().hashCode() * 31) + this.kind.hashCode();
    }

    @NonNull
    public Kind kind() {
        return this.kind;
    }

    public String toString() {
        return "MenuItemActionViewEvent{menuItem=" + menuItem() + ", kind=" + this.kind + '}';
    }
}
