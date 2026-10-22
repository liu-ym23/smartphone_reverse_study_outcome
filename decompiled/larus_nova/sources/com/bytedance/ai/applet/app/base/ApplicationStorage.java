package com.bytedance.ai.applet.app.base;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface ApplicationStorage {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/applet/app/base/ApplicationStorage$StorageError;", "", "msg", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "EXCEED_ITEM_MAX_SIZE", "EXCEED_TOTAL_MAX_SIZE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StorageError extends Enum<StorageError> {
        public static final StorageError EXCEED_ITEM_MAX_SIZE = null;
        public static final StorageError EXCEED_TOTAL_MAX_SIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StorageError[] f34155a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34156b = null;
        private final String msg;

        public static EnumEntries<StorageError> getEntries() {
            return f34156b;
        }

        static {
            StorageError r100 = new StorageError("EXCEED_ITEM_MAX_SIZE", 0, "exceed storage item max size");
            EXCEED_ITEM_MAX_SIZE = r100;
            StorageError r101 = new StorageError("EXCEED_TOTAL_MAX_SIZE", 1, "total storage size exceeded");
            EXCEED_TOTAL_MAX_SIZE = r101;
            StorageError[] r102 = {r100, r101};
            f34155a = r102;
            f34156b = EnumEntriesKt.enumEntries(r102);
        }

        public static StorageError[] values() {
            return (StorageError[]) f34155a.clone();
        }

        public final String getMsg() {
            return this.msg;
        }

        public static StorageError valueOf(String r100) {
            return (StorageError) r27.a.a(StorageError.class, r100);
        }

        public StorageError(String r100, int r101, String r102) {
            super(r100, r101);
            this.msg = r102;
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ai.applet.app.base.ApplicationStorage$a$a, reason: collision with other inner class name */
        public static final class C0679a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final StorageError f34157a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C0679a) == true) goto L9;
                return false;
            L9:
                if (this.f34157a == ((C0679a) r100).f34157a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f34157a.hashCode();
            }

            public final String toString() {
                return "Failure(error=" + this.f34157a + ')';
            }

            public C0679a(StorageError r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                this.f34157a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f34158a = null;

            static {
                f34158a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f34159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f34160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f34161c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f34159a, r101.f34159a) == true) goto L12;
            return false;
        L12:
            if (this.f34160b == r101.f34160b) goto L15;
            return false;
        L15:
            if (this.f34161c == r101.f34161c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f34159a.hashCode() * 31) + this.f34160b) * 31) + this.f34161c;
        }

        public final String toString() {
            return "StorageInfo(keys=" + this.f34159a + ", currentSize=" + this.f34160b + ", limitSize=" + this.f34161c + ')';
        }

        public b(List r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "keys");
            this.f34159a = r100;
            this.f34160b = r101;
            this.f34161c = 10240;
        }
    }

    a b(String r100, String r101);

    void clear();

    String get(String r100);

    b getInfo();

    void remove(String r100);
}
