package com.bytedance.android.window.shop.repository.tab.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowChildCategoryVO {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f189503b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ChildCategoryVO> f189504a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "prefix", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "getPrefix", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "title", "getTitle", "suffix", "getSuffix", "", "bgColor", "I", "getBgColor", "()I", "<init>", "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChildCategoryItemVO implements Serializable {
        public static final a Companion = null;
        private final int bgColor;
        private final ChildCategoryTextVO prefix;
        private final ChildCategoryTextVO suffix;
        private final ChildCategoryTextVO title;

        public static final class a {
            public a() {
            }

            public static ChildCategoryItemVO a(b r100) {
                if (r100 != null) goto L5;
                return null;
            L5:
                ChildCategoryTextVO.a r101 = ChildCategoryTextVO.Companion;
                c r102 = r100.d();
                r101.getClass();
                ChildCategoryTextVO r103 = ChildCategoryTextVO.a.a(r102);
                if (r103 != null) goto L8;
                return null;
            L8:
                int r104 = com.bytedance.android.ec.core.utils.s.f45717a;
                Integer r105 = com.bytedance.android.ec.core.utils.s.b(r100.a());
                if (r105 == null) goto L12;
                int r106 = r105.intValue();
                return new ChildCategoryItemVO(ChildCategoryTextVO.a.a(r100.b()), r103, ChildCategoryTextVO.a.a(r100.c()), r106);
            L12:
                return null;
            }
        }

        static {
            Companion = new a();
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final ChildCategoryTextVO getPrefix() {
            return this.prefix;
        }

        public final ChildCategoryTextVO getSuffix() {
            return this.suffix;
        }

        public final ChildCategoryTextVO getTitle() {
            return this.title;
        }

        public ChildCategoryItemVO(ChildCategoryTextVO r100, ChildCategoryTextVO r101, ChildCategoryTextVO r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "title");
            this.prefix = r100;
            this.title = r101;
            this.suffix = r102;
            this.bgColor = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryTextVO;", "Ljava/io/Serializable;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "textColor", "I", "getTextColor", "()I", "<init>", "(Ljava/lang/String;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChildCategoryTextVO implements Serializable {
        public static final a Companion = null;
        private final String text;
        private final int textColor;

        public static final class a {
            public a() {
            }

            public static ChildCategoryTextVO a(c r100) {
                if (r100 != null) goto L5;
                return null;
            L5:
                String r101 = r100.b();
                if (r101 != null) goto L8;
                return null;
            L8:
                int r102 = com.bytedance.android.ec.core.utils.s.f45717a;
                Integer r103 = com.bytedance.android.ec.core.utils.s.b(r100.a());
                if (r103 != null) goto L11;
                return null;
            L11:
                return new ChildCategoryTextVO(r101, r103.intValue());
            }
        }

        static {
            Companion = new a();
        }

        public final String getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public ChildCategoryTextVO(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.text = r100;
            this.textColor = r101;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "selectedItem", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "getSelectedItem", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;", "unselectedItem", "getUnselectedItem", "", "selected", "Z", "getSelected", "()Z", "setSelected", "(Z)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryItemVO;ZLjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChildCategoryVO implements Serializable {
        public static final a Companion = null;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f189505id;
        private boolean selected;
        private final ChildCategoryItemVO selectedItem;
        private final ChildCategoryItemVO unselectedItem;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public final String getId() {
            return this.f189505id;
        }

        public final boolean getSelected() {
            return this.selected;
        }

        public final ChildCategoryItemVO getSelectedItem() {
            return this.selectedItem;
        }

        public final ChildCategoryItemVO getUnselectedItem() {
            return this.unselectedItem;
        }

        public final void setSelected(boolean r100) {
            this.selected = r100;
        }

        public ChildCategoryVO(ChildCategoryItemVO r100, ChildCategoryItemVO r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "selectedItem");
            Intrinsics.checkNotNullParameter(r101, "unselectedItem");
            Intrinsics.checkNotNullParameter(r103, "id");
            this.selectedItem = r100;
            this.unselectedItem = r101;
            this.selected = r102;
            this.f189505id = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowChildCategoryVO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f189504a, ((WindowChildCategoryVO) r100).f189504a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<ChildCategoryVO> r100 = this.f189504a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "WindowChildCategoryVO(subCategoryVO=" + this.f189504a + ")";
    }

    public WindowChildCategoryVO(List<ChildCategoryVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "subCategoryVO");
        this.f189504a = r100;
    }
}
