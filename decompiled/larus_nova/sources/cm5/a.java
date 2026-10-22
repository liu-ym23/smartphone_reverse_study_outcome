package cm5;

import ay4.c;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static VFSFile b() {
        Biz r100 = Biz.DOCS;
        int r101 = c.f16749a;
        VFSFile r102 = c.a.b(r100, "Space", false, 12).toFile();
        if (r102.exists() == true) goto L5;
        r102.mkdirs();
    L5:
        return r102;
    }

    public static VFSPath a(String r100) {
        VFSPath r101 = b().getVfsPath();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r102 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String r103 = r100.trim() + r102 + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
        VFSFile r104 = b().getVfsPath().subPath("temp" + r103).toFile();     // Catch: Exception -> L8
        r104.createNewFile();     // Catch: Exception -> L8
        r104.delete();     // Catch: Exception -> L8
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r103 = r102 + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
    L13:
        return r101.subPath(r103);
    L8:
        e = move-exception;
        tt5.a.f("isfileNameVaild", e, false);
        r105 = false;
        goto L10
    }
}
