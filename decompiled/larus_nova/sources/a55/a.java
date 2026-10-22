package a55;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.module.dependency.StringResDef;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.d;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.larus.nova.R;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.pb.security_event.RenderItem;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import jg5.k;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements a55.b, m85.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewOwner f1849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f1850b;

    /* JADX INFO: renamed from: a55.a$a, reason: collision with other inner class name */
    public static final class C0015a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1851a = null;

        static {
            int[] r100 = new int[StringResDef.values().length];
            r100[StringResDef.Doc_Comment_CopyFailed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[StringResDef.DLP_CHECKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[StringResDef.DLP_SENSATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f1851a = r100;
        }
    }

    static {
    }

    @Override // m85.a
    public final String getReleaseKey() {
        return "DriveContextMenuItemClickProxy";
    }

    @Override // m85.a
    public final void onRelease() {
        tt5.a.h("DriveContextMenuItemClickProxy", "onRelease()...");
        this.f1849a = null;
    }

    public final void a(boolean r110) {
        tt5.a.h("DriveContextMenuItemClickProxy", "doAuditCopy() isCopySuccess=" + r110);
        ViewOwner r100 = this.f1849a;
        if (r100 == null) goto L5;
        DriveViewModel r101 = (DriveViewModel) r100.viewModel(DriveViewModel.class);
    L6:
        if (r101 == null) goto L8;
        boolean r102 = r101.isTypeWiki();
    L9:
        if (r101 == null) goto L11;
        WikiInfo r103 = r101.getWikiInfo();
    L12:
        ArrayList r111 = new ArrayList();
        r111.add(new RenderItem.Builder().Key("content_type").Value("text").build());
        if (r103 == null) goto L15;
        String r104 = r103.getWikiToken();
    L16:
        if (r103 == null) goto L18;
        String r105 = r103.getSpaceId();
    L19:
        dj5.a r106 = new dj5.a(r104, r105, null, 28);
        if (r101 == null) goto L24;
        BaseOpenEntity r107 = r101.getOpenEntity();
        if (r107 == null) goto L24;
        HostDocumentInfo r108 = r107.getHostDocumentInfo();
    L25:
        int r109 = 12;
        if (r108 != null) goto L47;
        if (r101 == null) goto L29;
        c r112 = r101.getIFileModel();
    L30:
        HostDocumentInfo r113 = new HostDocumentInfo();
        if (r112 == null) goto L34;
        String r114 = r112.getFileToken();
        if (r114 == null) goto L34;
    L35:
        r113.setObjToken(r114);
        r113.setType(12);
        if (r101 == null) goto L40;
        BaseOpenEntity r115 = r101.getOpenEntity();
        if (r115 == null) goto L40;
        String r116 = r115.getFileName();
    L41:
        r113.setTitle(r116);
        if (r112 == null) goto L45;
        String r117 = r112.a();
        if (r117 == null) goto L45;
    L46:
        r113.setCreatorTenantId(r117);
    L48:
        com.bytedance.ee.bear.middleground_permission_export.model.c r118 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        if (r103 == null) goto L51;
        r109 = r103.getObjType();
    L51:
        e r119 = e.d(r109);
        if (r102 == false) goto L54;
        ContainerType r120 = ContainerType.Wiki;
    L55:
        if (r102 == false) goto L61;
        if (r103 == null) goto L61;
        String r121 = r103.getWikiToken();
        if (r121 == null) goto L61;
        String r122 = r121;
    L62:
        r118.f(r119, r113, r120, r122, r106, r111, Boolean.valueOf(!r110));
        return;
    L61:
        r122 = "";
        goto L62
    L54:
        r120 = ContainerType.ContainerTypeUnknown;
    L45:
        r117 = "";
    L40:
        r116 = null;
    L34:
        r114 = "";
        goto L35
    L29:
        r112 = null;
        goto L30
    L47:
        r113 = r108;
    L24:
        r108 = null;
        goto L25
    L18:
        r105 = null;
        goto L19
    L15:
        r104 = null;
        goto L16
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = false;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public a(ViewOwner r100, z r101) {
        this.f1849a = r100;
        this.f1850b = r101;
    }

    public final boolean b(int r210, boolean r211, int r212, Context r213, String r214, PointValue r310) {
        int r100 = 1;
        switch(r210) {
            case 16908320: goto L6;
            case 16908321: goto L6;
            default: goto L76;
        };
    L76:
        return true;
    L6:
        if (r310 != null) goto L8;
    L11:
        ViewOwner r101 = this.f1849a;
        if (r101 == null) goto L22;
        u55.b r102 = ((DriveMGPermissionVM) r101.viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r102 == null) goto L20;
        DocPermission r103 = r102.f548841b;
        if (r103 == null) goto L20;
        IDocUserPermission r104 = r103.f234419a;
        if (r104 == null) goto L20;
        boolean r105 = r104.isCopyAuthByLeader();
    L21:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        k.a.f499019a.d(r105, r211);
    L20:
        r105 = false;
    L22:
        z r106 = this.f1850b;
        if (r106 == null) goto L76;
        if (TextUtils.isEmpty(r106.f225847o) == true) goto L76;
        String r107 = this.f1850b.f225852t;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        String r108 = "";
        if (jg5.e.a.f499003a.g() == false) goto L46;
        s55.a r109 = s55.a.f540731a;
        String r110 = this.f1850b.f225847o;
        Application r111 = eu5.b.f474075a;
        if (r214 != null) goto L31;
        String r112 = "";
    L32:
        boolean r113 = s55.a.l(r109, "CONTENT_COPY", r107, r110, r111, r112, null, null, null, null, 992);
        if (r113 == false) goto L40;
        int r114 = t55.b.f544629a;
        if (r310 == null) goto L38;
        r100 = r310.getPoint();
    L38:
        if (t55.b.a(r100) == false) goto L40;
        return false;
    L40:
        tt5.a.h("DriveContextMenuItemClickProxy", "reportAuditCopy() isCopySuccess=" + r113);
        a(r113);     // Catch: Exception -> L43
    L45:
        return r113;
    L43:
        e = move-exception;
        tt5.a.e("DriveContextMenuItemClickProxy", "reportAuditCopy() error", e, false);
        goto L45
    L31:
        r112 = r214;
        goto L32
    L46:
        FileBizDomain r115 = pw4.b.d(r107);
        if (Intrinsics.areEqual(r107, "calendar") == false) goto L49;
        r115 = FileBizDomain.FileBizDomainCCM;
    L49:
        gj5.c r116 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(pw4.b.b(r107), r115, pw4.b.f(this.f1850b.f225852t), this.f1850b.f225847o);
        if (r116.f481503a == true) goto L53;
        s55.e r117 = new s55.e(null, null, 0, r107, this.f1850b.f225847o, null, null, null, null, null, null, null, null, null, 32743);
        s55.a r118 = s55.a.f540731a;
        s55.a.n(r116, R.string.CreationMobile_ECM_AdminDisableToast, pw4.b.b(r107), r117);
        return false;
    L53:
        String r119 = ((d) org.koin.java.a.c(d.class, null, null, 6)).f("", "CCM_CONTENT_COPY", r212);
        if (r213 != null) goto L56;
        Context r120 = eu5.b.f474075a;
    L57:
        Intrinsics.checkNotNull(r120);
        StringResDef r121 = StringResDef.Doc_Comment_CopyFailed;
        Intrinsics.checkNotNullParameter(r120, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r121, "stringResDef");
        int r122 = b.f1851a[r121.ordinal()];
        if (r122 != 1) goto L60;
        r108 = r120.getString(R.string.Doc_Comment_CopyFailed);
    L68:
        if (TextUtils.isEmpty(r119) == true) goto L71;
        if (r212 == 0) goto L71;
    L72:
        if (r213 != null) goto L74;
        Context r123 = eu5.b.f474075a;
    L75:
        Toast.showFailureText(r123, r119, 0);
        goto L76
    L74:
        r123 = r213;
    L71:
        r119 = r108;
        goto L72
    L60:
        if (r122 != 2) goto L62;
        r108 = r120.getString(R.string.LarkCCM_Docs_DLP_SystemChecking_Mob);
        goto L68
    L62:
        if (r122 != 3) goto L68;
        r108 = r120.getString(R.string.LarkCCM_Docs_DLP_Toast_ActionFailed);
        goto L68
    L56:
        r120 = r213;
        goto L57
    L8:
        if (r310.isEscaped() == false) goto L11;
        tt5.a.h("DriveContextMenuItemClickProxy", "escaped");
        return true;
    }
}
