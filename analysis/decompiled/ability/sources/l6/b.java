package l6;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.zyql.common.utils.upload.TOSUploader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final String f5287a;
    public final int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Looper looper, String str) {
        super(looper);
        looper.getClass();
        str.getClass();
        this.f5287a = str;
        this.b = TOSUploader.MIN_SIZE;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws IOException {
        String str = (String) message.obj;
        String str2 = this.f5287a;
        str2.getClass();
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "logs".concat("_0.txt"));
        FileWriter fileWriter = null;
        int i = 0;
        File file3 = null;
        while (file2.exists()) {
            i++;
            file3 = file2;
            file2 = new File(file, androidx.appfunctions.metadata.a.i(i, "logs_", ".txt"));
        }
        if (file3 != null && file3.length() < this.b) {
            file2 = file3;
        }
        try {
            FileWriter fileWriter2 = new FileWriter(file2, true);
            try {
                str.getClass();
                fileWriter2.append((CharSequence) str);
                fileWriter2.flush();
                fileWriter2.close();
            } catch (IOException unused) {
                fileWriter = fileWriter2;
                if (fileWriter != null) {
                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        } catch (IOException unused3) {
        }
    }
}
