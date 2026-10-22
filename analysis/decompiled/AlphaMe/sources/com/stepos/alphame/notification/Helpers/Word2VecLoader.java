package com.stepos.alphame.notification.Helpers;

import com.stepos.alphame.NotProguard;
import com.stepos.alphame.notification.model.Word2VecModel;
import com.stepos.alphame.utils.Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@NotProguard
/* loaded from: classes.dex */
public class Word2VecLoader {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static Word2VecModel loadModel(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        Word2VecModel word2VecModel = null;
        try {
            try {
                fileInputStream = new FileInputStream((String) str);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    Word2VecModel word2VecModel2 = (Word2VecModel) objectInputStream.readObject();
                    Utils.closeSilently(objectInputStream);
                    Utils.closeSilently(fileInputStream);
                    word2VecModel = word2VecModel2;
                    str = objectInputStream;
                } catch (IOException | ClassNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    Utils.closeSilently(objectInputStream);
                    Utils.closeSilently(fileInputStream);
                    str = objectInputStream;
                    return word2VecModel;
                }
            } catch (IOException | ClassNotFoundException e5) {
                e = e5;
                objectInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                Utils.closeSilently(str);
                Utils.closeSilently(fileInputStream);
                throw th;
            }
        } catch (IOException | ClassNotFoundException e6) {
            e = e6;
            objectInputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            str = 0;
        }
        return word2VecModel;
    }
}
