package com.stepos.agentframework.chatcore.send;

import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.file.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.m;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatcore/file/FileInfo;", Const.STR_FILE, "Lu4/m;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/file/FileInfo;)Lu4/m;", "", "text", "", "images", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c {
    public static final List<m> a(String str, List<FileInfo> list) {
        List listC = C1172u.c();
        if (list == null) {
            list = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            m mVarB = b((FileInfo) it.next());
            if (mVarB != null) {
                arrayList.add(mVarB);
            }
        }
        listC.addAll(arrayList);
        if (str != null) {
            listC.add(new m.TextMessage(str, null, 2, null));
        }
        return C1172u.a(listC);
    }

    public static final m b(FileInfo file) {
        p.i(file, "file");
        switch (file.getFileType()) {
            case 1:
                return new m.ImageMessage(file.getFileId(), file.getFilePath(), null, null, file.getFileUrl(), file.getFileUri(), null, null, null, null, file.getSilent(), 972, null);
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 14:
                String fileId = file.getFileId();
                String fileName = file.getFileName();
                String fileSize = file.getFileSize();
                return new m.FileMessage(fileId, file.getFileUri(), file.getFileUrl(), file.getFilePath(), fileName, fileSize, null, null, file.getFileType(), 192, null);
            case 6:
            case 12:
            case 13:
            default:
                return null;
        }
    }
}
