package ay4;

import android.content.Context;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.diskmanager.dirs.CCMLarkDir;
import com.bytedance.ee.bear.diskmanager.dirs.CCMUserDir;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.diskmanage.storage.Storage;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import com.suite.lark.platform.component.storage.file.dirs.h;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Deprecated(message = "user userScope interface ICCMUserFileStorage")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16749a = 0;

    public static final class a {
        public a() {
        }

        public static VFSPath a(Biz r100, String r101, int r102) {
            int r103 = c.f16749a;
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            FileStorage r104 = LarkFileStorage.c();
            f r105 = f.f440961h;
            String[] r106 = new String[3];
            r106[0] = ChameleonResConstants.CCM_ROOT_DIR;
            if (r100 == null) goto L12;
            String r107 = r100.getBizRootDir();
            if (r107 == null) goto L12;
        L13:
            r106[1] = r107;
            if (r101 != null) goto L16;
            r101 = "";
        L16:
            r106[2] = r101;
            return d.a().z(r104.b(r105, new com.ss.android.lark.storage.d(r106)).getRealPath());
        L12:
            r107 = "";
            goto L13
        }

        @Deprecated(message = "user userScope interface ICCMUserFileStorage")
        @JvmStatic
        public static VFSPath d(Biz r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            Intrinsics.checkNotNullParameter(r102, "userSpace");
            FileStorage r103 = LarkFileStorage.d(r102);
            f r104 = f.f440958e;
            String[] r105 = new String[3];
            r105[0] = ChameleonResConstants.CCM_ROOT_DIR;
            r105[1] = r100.getBizRootDir();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r105[2] = r101;
            VFSPath r106 = r103.b(r104, new com.ss.android.lark.storage.d(r105));
            return d.a().z(r106.getRealPath());
        }

        @Deprecated(message = "user userScope interface ICCMUserFileStorage")
        @JvmStatic
        public static VFSPath g(Biz r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            Intrinsics.checkNotNullParameter(r102, "userSpace");
            FileStorage r103 = LarkFileStorage.d(r102);
            f r104 = f.f440957d;
            String[] r105 = new String[3];
            r105[0] = ChameleonResConstants.CCM_ROOT_DIR;
            r105[1] = r100.getBizRootDir();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r105[2] = r101;
            VFSPath r106 = r103.b(r104, new com.ss.android.lark.storage.d(r105));
            return d.a().z(r106.getRealPath());
        }

        public static VFSPath b(Biz r100, String r101, boolean r102, int r110) {
            int r103 = c.f16749a;
            if ((r110 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r110 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r110 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if (r102 == false) goto L22;
            FileStorage r104 = LarkFileStorage.b();
            f r105 = f.f440960g;
            String[] r106 = new String[3];
            r106[0] = ChameleonResConstants.CCM_ROOT_DIR;
            if (r100 == null) goto L17;
            String r107 = r100.getBizRootDir();
            if (r107 == null) goto L17;
        L18:
            r106[1] = r107;
            if (r101 != null) goto L21;
            r101 = "";
        L21:
            r106[2] = r101;
            VFSPath r108 = r104.b(r105, new com.ss.android.lark.storage.d(r106));
        L32:
            return d.a().z(r108.getRealPath());
        L17:
            r107 = "";
            goto L18
        L22:
            FileStorage r109 = LarkFileStorage.c();
            f r111 = f.f440960g;
            String[] r112 = new String[3];
            r112[0] = ChameleonResConstants.CCM_ROOT_DIR;
            if (r100 == null) goto L26;
            String r113 = r100.getBizRootDir();
            if (r113 == null) goto L26;
        L27:
            r112[1] = r113;
            if (r101 != null) goto L30;
            r101 = "";
        L30:
            r112[2] = r101;
            r108 = r109.b(r111, new com.ss.android.lark.storage.d(r112));
        L26:
            r113 = "";
            goto L27
        }

        public static VFSPath c(Biz r100, String r101, boolean r102, int r110) {
            int r103 = c.f16749a;
            if ((r110 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r110 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r110 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if (r102 == false) goto L22;
            FileStorage r104 = LarkFileStorage.b();
            f r105 = f.f440958e;
            String[] r106 = new String[3];
            r106[0] = ChameleonResConstants.CCM_ROOT_DIR;
            if (r100 == null) goto L17;
            String r107 = r100.getBizRootDir();
            if (r107 == null) goto L17;
        L18:
            r106[1] = r107;
            if (r101 != null) goto L21;
            r101 = "";
        L21:
            r106[2] = r101;
            VFSPath r108 = r104.b(r105, new com.ss.android.lark.storage.d(r106));
        L32:
            return d.a().z(r108.getRealPath());
        L17:
            r107 = "";
            goto L18
        L22:
            FileStorage r109 = LarkFileStorage.c();
            f r111 = f.f440958e;
            String[] r112 = new String[3];
            r112[0] = ChameleonResConstants.CCM_ROOT_DIR;
            if (r100 == null) goto L26;
            String r113 = r100.getBizRootDir();
            if (r113 == null) goto L26;
        L27:
            r112[1] = r113;
            if (r101 != null) goto L30;
            r101 = "";
        L30:
            r112[2] = r101;
            r108 = r109.b(r111, new com.ss.android.lark.storage.d(r112));
        L26:
            r113 = "";
            goto L27
        }

        @JvmStatic
        public static VFSPath e(Biz r100, String r101, boolean r102, boolean r110) {
            boolean r103 = true;
            if (r110 == false) goto L20;
            int r111 = h.f460642c;
            h r112 = h.a.a(LarkContext.getApplication());
            r112.c(d.a());
            if (r102 == false) goto L7;
            CCMUserDir r104 = CCMLarkDir.f217596c.getValue();
        L8:
            Intrinsics.checkNotNullParameter(r104, "pathProvider");
            h.b r105 = r112.a(r104);
            if (r100 == null) goto L11;
            r105.c(r100.getBizRootDir());
        L11:
            if (r101 != null) goto L13;
        L16:
            if (r103 == true) goto L41;
            r105.c(r101);
        L41:
            return r105.a();
        L13:
            if (r101.length() == 0) goto L16;
            r103 = false;
            goto L16
        L7:
            r104 = CCMUserDir.f217601c.getValue();
            goto L8
        L20:
            if (r102 == false) goto L30;
            FileStorage r106 = LarkFileStorage.b();
            f r107 = f.f440957d;
            String[] r108 = new String[3];
            r108[0] = ChameleonResConstants.CCM_ROOT_DIR;
            if (r100 == null) goto L25;
            String r109 = r100.getBizRootDir();
            if (r109 == null) goto L25;
        L26:
            r108[1] = r109;
            if (r101 != null) goto L29;
            r101 = "";
        L29:
            r108[2] = r101;
            VFSPath r113 = r106.b(r107, new com.ss.android.lark.storage.d(r108));
        L40:
            return d.a().z(r113.getRealPath());
        L25:
            r109 = "";
            goto L26
        L30:
            FileStorage r114 = LarkFileStorage.c();
            f r115 = f.f440957d;
            String[] r116 = new String[3];
            r116[0] = ChameleonResConstants.CCM_ROOT_DIR;
            if (r100 == null) goto L34;
            String r117 = r100.getBizRootDir();
            if (r117 == null) goto L34;
        L35:
            r116[1] = r117;
            if (r101 != null) goto L38;
            r101 = "";
        L38:
            r116[2] = r101;
            r113 = r114.b(r115, new com.ss.android.lark.storage.d(r116));
        L34:
            r117 = "";
            goto L35
        }

        public static /* synthetic */ VFSPath f(Biz r100, String r101, boolean r102, boolean r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if ((r104 & 8) == 0) goto L15;
            r103 = false;
        L15:
            return e(r100, r101, r102, r103);
        }
    }

    @Deprecated(message = "旧的接口，非特殊情况不要用")
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f16750a = 0;

        static {
        }

        @JvmStatic
        public static final String a(Context r100, Biz r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "biz");
            Intrinsics.checkNotNullParameter(r102, "relativePath");
            int r103 = com.ss.android.lark.diskmanage.storage.c.f420487a;
            return com.ss.android.lark.diskmanage.storage.c.a.a(r100, ChameleonResConstants.CCM_ROOT_DIR, Storage.Type.INNER_FILES, new String[]{r101.getBizRootDir(), r102});
        }
    }

    static {
        new a();
    }

    @JvmStatic
    public static final VFSPath a(Biz r100, String r101) {
        return a.b(r100, r101, true, 8);
    }

    @JvmStatic
    public static final VFSPath b(Biz r100, String r101) {
        return a.c(r100, r101, false, 12);
    }
}
