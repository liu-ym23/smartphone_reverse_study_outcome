package com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import h52.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m52.e;

/* JADX INFO: loaded from: classes9.dex */
public interface IModelListDataManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/ui/IModelListDataManager$ModelChangeType;", "", "INSERT_BOTTOM", "UPDATE_BOTTOM", "REMOVE_ITEM", "UPDATE_ITEM", "INSERT_ITEM", "REMOVE_RANGE", "INIT_LIST", "RELOAD_ALL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ModelChangeType extends Enum<ModelChangeType> {
        public static final ModelChangeType INIT_LIST = null;
        public static final ModelChangeType INSERT_BOTTOM = null;
        public static final ModelChangeType INSERT_ITEM = null;
        public static final ModelChangeType RELOAD_ALL = null;
        public static final ModelChangeType REMOVE_ITEM = null;
        public static final ModelChangeType REMOVE_RANGE = null;
        public static final ModelChangeType UPDATE_BOTTOM = null;
        public static final ModelChangeType UPDATE_ITEM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ModelChangeType[] f133736a = null;

        static {
            ModelChangeType r100 = new ModelChangeType("INSERT_BOTTOM", 0);
            INSERT_BOTTOM = r100;
            ModelChangeType r101 = new ModelChangeType("UPDATE_BOTTOM", 1);
            UPDATE_BOTTOM = r101;
            ModelChangeType r102 = new ModelChangeType("REMOVE_ITEM", 2);
            REMOVE_ITEM = r102;
            ModelChangeType r103 = new ModelChangeType("UPDATE_ITEM", 3);
            UPDATE_ITEM = r103;
            ModelChangeType r104 = new ModelChangeType("INSERT_ITEM", 4);
            INSERT_ITEM = r104;
            ModelChangeType r105 = new ModelChangeType("REMOVE_RANGE", 5);
            REMOVE_RANGE = r105;
            ModelChangeType r106 = new ModelChangeType("INIT_LIST", 6);
            INIT_LIST = r106;
            ModelChangeType r107 = new ModelChangeType("RELOAD_ALL", 7);
            RELOAD_ALL = r107;
            f133736a = new ModelChangeType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static ModelChangeType valueOf(String r100) {
            return (ModelChangeType) r27.a.a(ModelChangeType.class, r100);
        }

        public static ModelChangeType[] values() {
            return (ModelChangeType[]) f133736a.clone();
        }

        public ModelChangeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ModelChangeType f133737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f133738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f133739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f133740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f133741e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f133737a, r101.f133737a) == true) goto L8;
            return false;
        L8:
            if (this.f133738b == r101.f133738b) goto L10;
            return false;
        L10:
            if (this.f133739c == r101.f133739c) goto L12;
            return false;
        L12:
            if (this.f133740d == r101.f133740d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f133741e, r101.f133741e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            ModelChangeType r100 = this.f133737a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((((((r102 * 31) + this.f133738b) * 31) + this.f133739c) * 31) + this.f133740d) * 31;
            c r104 = this.f133741e;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ModelChangeEvent(type=" + this.f133737a + ", position=" + this.f133738b + ", rangeStart=" + this.f133739c + ", rangeEnd=" + this.f133740d + ", message=" + this.f133741e + ")";
        }

        public final ModelChangeType getType() {
            return this.f133737a;
        }

        public a(ModelChangeType r100, int r101, int r102, c r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r104 & 8) == 0) goto L9;
            r102 = 0;
        L9:
            if ((r104 & 16) == 0) goto L11;
            r103 = null;
        L11:
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f133737a = r100;
            this.f133738b = r101;
            this.f133739c = 0;
            this.f133740d = r102;
            this.f133741e = r103;
        }
    }

    PropertyOwner a();

    void b(c r100);

    e c();

    void destroy();

    List<c> getMessageList();
}
