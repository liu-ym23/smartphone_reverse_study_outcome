package b15;

import com.bytedance.ee.bear.contract.d;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends a15.a {
    @Override // a15.a
    public final void c() {
        d("ccm_doc_version_deleted_tips_click");
    }

    @Override // a15.a
    public final void e() {
        Intrinsics.checkNotNullParameter("ccm_doc_version_deleted_tips_view", "event");
        q("ccm_doc_version_deleted_tips_view", new HashMap(2));
    }

    @Override // a15.a
    public final void g() {
        Intrinsics.checkNotNullParameter("ccm_doc_delete_version_view", "event");
        q("ccm_doc_delete_version_view", new HashMap(2));
    }

    @Override // a15.a
    public final void j() {
        Intrinsics.checkNotNullParameter("ccm_docs_version_more_menu_view", "event");
        q("ccm_docs_version_more_menu_view", new HashMap(2));
    }

    @Override // a15.a
    public final void m() {
        Intrinsics.checkNotNullParameter("ccm_doc_rename_version_view", "event");
        q("ccm_doc_rename_version_view", new HashMap(2));
    }

    @Override // a15.a
    public final void p() {
        Intrinsics.checkNotNullParameter("ccm_doc_saved_version_view", "event");
        q("ccm_doc_saved_version_view", new HashMap(2));
    }

    public b(d r100) {
        super(r100);
    }

    @Override // a15.a
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter("ccm_doc_delete_version_click", "event");
        HashMap r101 = new HashMap(2);
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        q("ccm_doc_delete_version_click", r101);
    }

    @Override // a15.a
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter("ccm_docs_version_page_view", "event");
        HashMap r101 = new HashMap(2);
        r101.put("open_type", r100);
        q("ccm_docs_version_page_view", r101);
    }

    @Override // a15.a
    public final void l(String r100) {
        Intrinsics.checkNotNullParameter("ccm_doc_rename_version_click", "event");
        HashMap r101 = new HashMap(2);
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        q("ccm_doc_rename_version_click", r101);
    }

    @Override // a15.a
    public final void n(String r100, String r101, String r102) {
        o("ccm_doc_saved_version_click", r100, r101, r102);
    }

    @Override // a15.a
    public final void h(String r100, String r101, String r110, String r111, String r112) {
        i("ccm_docs_version_more_menu_click", r100, r101, r110, r111, r112);
    }
}
