package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowProductCategoryVODeprecated extends f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f189507k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<a> f189508j;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$CategoryType;", "", "", "typeInt", "I", "getTypeInt", "()I", CardAdapter.TEXT, "IMAGE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CategoryType extends Enum<CategoryType> {
        public static final CategoryType IMAGE = null;
        public static final CategoryType TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CategoryType[] f189509a = null;
        private final int typeInt;

        static {
            CategoryType r100 = new CategoryType(CardAdapter.TEXT, 0, 1);
            TEXT = r100;
            CategoryType r101 = new CategoryType("IMAGE", 1, 2);
            IMAGE = r101;
            f189509a = new CategoryType[]{r100, r101};
        }

        public static CategoryType valueOf(String r100) {
            return (CategoryType) r27.a.a(CategoryType.class, r100);
        }

        public static CategoryType[] values() {
            return (CategoryType[]) f189509a.clone();
        }

        public final int getTypeInt() {
            return this.typeInt;
        }

        public CategoryType(String r100, int r101, int r102) {
            super(r100, r101);
            this.typeInt = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final CategoryType[] f189510c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C2762a f189511d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f189512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f189513b;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated$a$a, reason: collision with other inner class name */
        public static final class C2762a {
            public C2762a() {
            }
        }

        static {
            f189511d = new C2762a();
            f189510c = CategoryType.values();
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f189512a = r100;
            this.f189513b = r101;
        }
    }

    public static final class b {
        public static WindowProductCategoryVODeprecated a(List r110) {
            Intrinsics.checkNotNullParameter(r110, "categoryDtoList");
            ArrayList r100 = new ArrayList();
            Iterator r111 = r110.iterator();
        L3:
            a r101 = null;
            if (r111.hasNext() == false) goto L64;
            com.bytedance.android.window.shop.repository.dto.p r102 = (com.bytedance.android.window.shop.repository.dto.p) r111.next();
            a.f189511d.getClass();
            Intrinsics.checkNotNullParameter(r102, "dto");
            Integer r103 = r102.getType();
            boolean r104 = false;
            if (r103 != null) goto L8;
            CategoryType r105 = CategoryType.TEXT;
        L18:
            if (r105 == null) goto L61;
            int r106 = y.f189644a[r105.ordinal()];
            if (r106 != 1) goto L23;
            int r107 = d.f189517j;
            String r108 = r102.b();
            String r109 = r102.c();
            String r112 = r102.e();
            String r113 = r102.i();
            ECUrlModel r114 = r102.f();
            ECUrlModel r115 = r102.j();
            String r116 = r102.d();
            if (r108 != null) goto L55;
        L56:
            r104 = true;
        L57:
            if (r104 == true) goto L61;
            if (r109 == null) goto L61;
            r101 = new d(r108, r109, com.bytedance.android.ec.core.utils.s.b(r112), com.bytedance.android.ec.core.utils.s.b(r113), r114, r115, com.bytedance.android.ec.core.utils.s.b(r116));
            goto L61
        L55:
            if (StringsKt.isBlank(r108) == false) goto L57;
        L23:
            if (r106 != 2) goto L51;
            int r117 = c.f189514g;
            String r118 = r102.b();
            String r119 = r102.c();
            ECUrlModel r120 = r102.f();
            ECUrlModel r121 = r102.j();
            if (r118 != null) goto L27;
        L30:
            boolean r122 = true;
        L31:
            if (r122 == true) goto L61;
            if (r120 == null) goto L61;
            List<String> r123 = r120.getUrlList();
            if (r123 != null) goto L36;
        L39:
            boolean r124 = true;
        L40:
            if (r124 == true) goto L61;
            if (r121 == null) goto L61;
            List<String> r125 = r121.getUrlList();
            if (r125 != null) goto L45;
        L46:
            r104 = true;
        L47:
            if (r104 == true) goto L61;
            r101 = new c(r118, r119, r120, r121);
            goto L61
        L45:
            if (r125.isEmpty() == false) goto L47;
        L36:
            if (r123.isEmpty() == true) goto L39;
            r124 = false;
            goto L40
        L27:
            if (StringsKt.isBlank(r118) == true) goto L30;
            r122 = false;
            goto L31
        L51:
            throw new NoWhenBranchMatchedException();
        L61:
            if (r101 == null) goto L3;
            r100.add(r101);
            goto L3
        L8:
            CategoryType[] r126 = a.f189510c;
            int r127 = r126.length;
            int r128 = 0;
        L9:
            if (r128 >= r127) goto L17;
            CategoryType r129 = r126[r128];
            if (r129.getTypeInt() != r103.intValue()) goto L13;
            boolean r130 = true;
        L14:
            if (r130 == true) goto L15;
            r128 = r128 + 1;
            goto L9
        L15:
            r105 = r129;
            goto L18
        L13:
            r130 = false;
            goto L14
        L17:
            r105 = null;
            goto L18
        L64:
            if (r100.isEmpty() == false) goto L67;
            return null;
        L67:
            return new WindowProductCategoryVODeprecated(r100);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f189514g = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ECUrlModel f189515e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ECUrlModel f189516f;

        public static final class a {
        }

        static {
        }

        public c(String r100, String r101, ECUrlModel r102, ECUrlModel r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r102, "selectedIconUrl");
            Intrinsics.checkNotNullParameter(r103, "unSelectedIconUrl");
            super(r100, r101);
            this.f189515e = r102;
            this.f189516f = r103;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ int f189517j = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f189518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f189519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ECUrlModel f189520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ECUrlModel f189521h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f189522i;

        public static final class a {
        }

        static {
        }

        public d(String r100, String r101, Integer r102, Integer r103, ECUrlModel r104, ECUrlModel r105, Integer r106) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            super(r100, r101);
            this.f189518e = r102;
            this.f189519f = r103;
            this.f189520g = r104;
            this.f189521h = r105;
            this.f189522i = r106;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowProductCategoryVODeprecated(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryTypes");
        super(AVMDLDataLoader.KeyIsNextDownloadThreshold);
        this.f189508j = r100;
    }
}
