package com.android.ttcjpaysdk.base.utils.html.callback;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback;", "", "onUniversalClick", "", "id", "", "data", "type", "Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback$ClickType;", "ClickType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UniversalClickCallback {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/html/callback/UniversalClickCallback$ClickType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMG", "TXT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ClickType extends Enum<ClickType> {
        private static final /* synthetic */ ClickType[] $VALUES = null;
        public static final ClickType IMG = null;
        public static final ClickType TXT = null;
        private final String value;

        private static final /* synthetic */ ClickType[] $values() {
            return new ClickType[]{IMG, TXT};
        }

        public static ClickType valueOf(String r100) {
            return (ClickType) a.a(ClickType.class, r100);
        }

        public static ClickType[] values() {
            return (ClickType[]) $VALUES.clone();
        }

        static {
            IMG = new ClickType("IMG", 0, "img");
            TXT = new ClickType("TXT", 1, "txt");
            $VALUES = $values();
        }

        public final String getValue() {
            return this.value;
        }

        private ClickType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    void onUniversalClick(String r100, String r101, ClickType r102);
}
