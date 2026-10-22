package by4;

import android.text.TextUtils;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileStorage f21392a;

    /* JADX INFO: renamed from: by4.a$a, reason: collision with other inner class name */
    public static final class C0377a {
    }

    static {
    }

    @Inject
    public a(String r100) {
        tt5.a.h("CCMUserFileStorage", "uid=" + r100);
        if (TextUtils.equals(r100, "absent_user") == false) goto L5;
        FileStorage r101 = LarkFileStorage.d("");
    L8:
        this.f21392a = r101;
        return;
    L5:
        if (r100 != null) goto L7;
        r100 = "absent_user";
    L7:
        r101 = LarkFileStorage.d(r100);
        goto L8
    }

    @Override // by4.c
    public final VFSPath a(Biz r100, String r101, boolean r102) {
        FileStorage r103 = this.f21392a;
        f r104 = f.f440958e;
        String[] r105 = new String[3];
        r105[0] = ChameleonResConstants.CCM_ROOT_DIR;
        if (r100 == null) goto L6;
        String r106 = r100.getBizRootDir();
        if (r106 == null) goto L6;
    L7:
        r105[1] = r106;
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        r105[2] = r101;
        VFSPath r107 = r103.b(r104, new com.ss.android.lark.storage.d(r105));
        if (r102 == true) goto L13;
        return r107;
    L13:
        return ay4.d.a().z(r107.getRealPath());
    L6:
        r106 = "";
        goto L7
    }

    @Override // by4.c
    public final VFSPath b(Biz r100, String r101, boolean r102) {
        FileStorage r103 = this.f21392a;
        f r104 = f.f440957d;
        String[] r105 = new String[3];
        r105[0] = ChameleonResConstants.CCM_ROOT_DIR;
        if (r100 == null) goto L6;
        String r106 = r100.getBizRootDir();
        if (r106 == null) goto L6;
    L7:
        r105[1] = r106;
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        r105[2] = r101;
        VFSPath r107 = r103.b(r104, new com.ss.android.lark.storage.d(r105));
        if (r102 == true) goto L13;
        return r107;
    L13:
        return ay4.d.a().z(r107.getRealPath());
    L6:
        r106 = "";
        goto L7
    }
}
