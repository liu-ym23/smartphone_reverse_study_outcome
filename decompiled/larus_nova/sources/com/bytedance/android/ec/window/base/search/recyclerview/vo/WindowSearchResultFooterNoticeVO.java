package com.bytedance.android.ec.window.base.search.recyclerview.vo;

import jp.b;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
public final class WindowSearchResultFooterNoticeVO extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FooterStatus f49552b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/window/base/search/recyclerview/vo/WindowSearchResultFooterNoticeVO$FooterStatus;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "LOADING", "NO_MORE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FooterStatus extends Enum<FooterStatus> {
        public static final FooterStatus LOADING = null;
        public static final FooterStatus NO_MORE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FooterStatus[] f49553a = null;
        private final String description;

        static {
            FooterStatus r100 = new FooterStatus("LOADING", 0, "loading");
            LOADING = r100;
            FooterStatus r101 = new FooterStatus("NO_MORE", 1, "no more products");
            NO_MORE = r101;
            f49553a = new FooterStatus[]{r100, r101};
        }

        public static FooterStatus valueOf(String r100) {
            return (FooterStatus) a.a(FooterStatus.class, r100);
        }

        public static FooterStatus[] values() {
            return (FooterStatus[]) f49553a.clone();
        }

        public final String getDescription() {
            return this.description;
        }

        public FooterStatus(String r100, int r101, String r102) {
            super(r100, r101);
            this.description = r102;
        }
    }

    public WindowSearchResultFooterNoticeVO() {
        super(WindowSearchResultItemType.FOOTER_VIEW);
        this.f49552b = FooterStatus.NO_MORE;
    }
}
