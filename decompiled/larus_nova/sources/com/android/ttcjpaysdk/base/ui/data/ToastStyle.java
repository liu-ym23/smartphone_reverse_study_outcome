package com.android.ttcjpaysdk.base.ui.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/ToastStyle;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "TOAST", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ToastStyle extends Enum<ToastStyle> {
    private static final /* synthetic */ ToastStyle[] $VALUES = null;
    public static final ToastStyle DEFAULT = null;
    public static final ToastStyle TOAST = null;
    private final String value;

    private static final /* synthetic */ ToastStyle[] $values() {
        return new ToastStyle[]{DEFAULT, TOAST};
    }

    public static ToastStyle valueOf(String r100) {
        return (ToastStyle) a.a(ToastStyle.class, r100);
    }

    public static ToastStyle[] values() {
        return (ToastStyle[]) $VALUES.clone();
    }

    static {
        DEFAULT = new ToastStyle("DEFAULT", 0, "default");
        TOAST = new ToastStyle("TOAST", 1, "toast");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private ToastStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
