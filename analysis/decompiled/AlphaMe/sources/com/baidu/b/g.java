package com.baidu.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.stepos.alphame.utils.Consts;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private Context f4886a;

    /* renamed from: b, reason: collision with root package name */
    private c f4887b;

    public g(Context context, c cVar) {
        this.f4886a = context;
        this.f4887b = cVar;
    }

    private f a() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            return f.b(com.baidu.b.f.c.a(file));
        }
        return null;
    }

    private f b() {
        return f.a(c("com.baidu.deviceid"), c("bd_setting_i"));
    }

    private String c(String str) {
        try {
            return Settings.System.getString(this.f4886a.getContentResolver(), str);
        } catch (Exception e4) {
            com.baidu.b.f.c.a(e4);
            return null;
        }
    }

    private String d(String str) {
        return "0";
    }

    private f e(String str) throws IOException {
        String str2;
        String[] strArrSplit;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append(HttpClient.NEWLINE);
            }
            bufferedReader.close();
            byte[] bArrA = com.baidu.b.c.a.g.a();
            strArrSplit = new String(com.baidu.b.c.a.c.a(bArrA, bArrA, com.baidu.b.d.a.a(sb.toString().getBytes()))).split(Consts.SPLITTER_EQUAL);
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (strArrSplit == null || strArrSplit.length != 2) {
            str2 = "";
        } else {
            str2 = strArrSplit[0];
            try {
                str3 = strArrSplit[1];
            } catch (FileNotFoundException | IOException | Exception unused2) {
            }
        }
        return f.a(str3, str2);
    }

    private f a(Context context) {
        List<b> listB = this.f4887b.b(context);
        f fVarB = null;
        if (listB != null) {
            File filesDir = context.getFilesDir();
            String name = "files";
            if (!"files".equals(filesDir.getName())) {
                Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                name = filesDir.getName();
            }
            for (b bVar : listB) {
                if (!bVar.f4735d) {
                    File file = new File(new File(bVar.f4732a.dataDir, name), "libcuid.so");
                    if (file.exists() && (fVarB = f.b(com.baidu.b.f.c.a(file))) != null) {
                        break;
                    }
                }
            }
        }
        return fVarB;
    }

    private boolean b(String str) {
        return this.f4886a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public f a(String str) {
        boolean z4;
        f fVarA = a(this.f4886a);
        if (fVarA == null) {
            fVarA = f.b(c("com.baidu.deviceid.v2"));
        }
        boolean zB = b("android.permission.READ_EXTERNAL_STORAGE");
        if (fVarA == null && zB) {
            fVarA = a();
        }
        if (fVarA == null) {
            fVarA = b();
        }
        if (fVarA == null && zB) {
            fVarA = e(d(""));
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            d("");
        }
        if (fVarA != null) {
            fVarA.c();
        }
        return fVarA;
    }
}
