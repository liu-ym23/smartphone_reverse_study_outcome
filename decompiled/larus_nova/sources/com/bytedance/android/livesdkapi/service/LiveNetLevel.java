package com.bytedance.android.livesdkapi.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\t\n\u000b\f\r\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveNetLevel;", "", "level", "", "value", "(II)V", "getLevel", "()I", "getValue", "ExtremelyPoor", "Good", "Normal", "Offline", "Poor", "Unknown", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$ExtremelyPoor;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Good;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Normal;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Offline;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Poor;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Unknown;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveNetLevel {
    private final int level;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$ExtremelyPoor;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel;", "result", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExtremelyPoor extends LiveNetLevel {
        private final int result;

        private final int component1() {
            return this.result;
        }

        public static /* synthetic */ ExtremelyPoor copy$default(ExtremelyPoor r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.result;
        L6:
            return r100.copy(r101);
        }

        public final ExtremelyPoor copy(int r100) {
            return new ExtremelyPoor(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ExtremelyPoor) == true) goto L6;
            return false;
        L6:
            if (this.result == ((ExtremelyPoor) r100).result) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.result;
        }

        public String toString() {
            return "ExtremelyPoor(result=" + this.result + ")";
        }

        public ExtremelyPoor(int r100) {
            super(1, r100, null);
            this.result = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Good;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel;", "result", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Good extends LiveNetLevel {
        private final int result;

        private final int component1() {
            return this.result;
        }

        public static /* synthetic */ Good copy$default(Good r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.result;
        L6:
            return r100.copy(r101);
        }

        public final Good copy(int r100) {
            return new Good(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Good) == true) goto L6;
            return false;
        L6:
            if (this.result == ((Good) r100).result) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.result;
        }

        public String toString() {
            return "Good(result=" + this.result + ")";
        }

        public Good(int r100) {
            super(4, r100, null);
            this.result = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Normal;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel;", "result", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Normal extends LiveNetLevel {
        private final int result;

        private final int component1() {
            return this.result;
        }

        public static /* synthetic */ Normal copy$default(Normal r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.result;
        L6:
            return r100.copy(r101);
        }

        public final Normal copy(int r100) {
            return new Normal(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Normal) == true) goto L6;
            return false;
        L6:
            if (this.result == ((Normal) r100).result) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.result;
        }

        public String toString() {
            return "Normal(result=" + this.result + ")";
        }

        public Normal(int r100) {
            super(3, r100, null);
            this.result = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Offline;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel;", "()V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Offline extends LiveNetLevel {
        public static final Offline INSTANCE = null;

        private Offline() {
            int r100 = -1;
            super(r100, r100, null);
        }

        static {
            INSTANCE = new Offline();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Poor;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel;", "result", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Poor extends LiveNetLevel {
        private final int result;

        private final int component1() {
            return this.result;
        }

        public static /* synthetic */ Poor copy$default(Poor r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.result;
        L6:
            return r100.copy(r101);
        }

        public final Poor copy(int r100) {
            return new Poor(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Poor) == true) goto L6;
            return false;
        L6:
            if (this.result == ((Poor) r100).result) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.result;
        }

        public String toString() {
            return "Poor(result=" + this.result + ")";
        }

        public Poor(int r100) {
            super(2, r100, null);
            this.result = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/LiveNetLevel$Unknown;", "Lcom/bytedance/android/livesdkapi/service/LiveNetLevel;", "()V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Unknown extends LiveNetLevel {
        public static final Unknown INSTANCE = null;

        private Unknown() {
            int r100 = -2;
            super(r100, r100, null);
        }

        static {
            INSTANCE = new Unknown();
        }
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getValue() {
        return this.value;
    }

    private LiveNetLevel(int r100, int r101) {
        this.level = r100;
        this.value = r101;
    }

    public /* synthetic */ LiveNetLevel(int r100, int r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }
}
