package ub;

import gc.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import t.c1;
import t.m0;

/* loaded from: classes.dex */
public abstract class h extends m0 {
    public static String m(File file) {
        file.getClass();
        String name = file.getName();
        name.getClass();
        return hc.h.r0(name, '.', "");
    }

    public static String n(File file) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        charset.getClass();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strJ = c1.j(inputStreamReader);
            inputStreamReader.close();
            return strJ;
        } finally {
        }
    }

    public static File o(File file) {
        int length;
        int iD0;
        File file2 = new File("image_cache");
        String path = file2.getPath();
        path.getClass();
        char c9 = File.separatorChar;
        int iD02 = hc.h.d0(path, c9, 0, 4);
        if (iD02 != 0) {
            length = (iD02 <= 0 || path.charAt(iD02 + (-1)) != ':') ? (iD02 == -1 && hc.h.a0(path, ':')) ? path.length() : 0 : iD02 + 1;
        } else if (path.length() <= 1 || path.charAt(1) != c9 || (iD0 = hc.h.d0(path, c9, 2, 4)) < 0) {
            length = 1;
        } else {
            int iD03 = hc.h.d0(path, c9, iD0 + 1, 4);
            length = iD03 >= 0 ? iD03 + 1 : path.length();
        }
        if (length > 0) {
            return file2;
        }
        String string = file.toString();
        string.getClass();
        if ((string.length() == 0) || hc.h.a0(string, c9)) {
            return new File(string + file2);
        }
        return new File(string + c9 + file2);
    }

    public static final i p(File file, g gVar) {
        i iVar = new i(4);
        iVar.f4694b = file;
        iVar.f4695c = gVar;
        VarHandle.storeStoreFence();
        return iVar;
    }
}
