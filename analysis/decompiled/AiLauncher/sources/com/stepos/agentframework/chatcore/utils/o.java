package com.stepos.agentframework.chatcore.utils;

import Z8.C1173v;
import Z8.X;
import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/o;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "imagePath", "Landroid/graphics/Bitmap;", "bitmap", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Landroid/graphics/Bitmap;Le9/c;)Ljava/lang/Object;", "taskId", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "TASK_ROTBOT_FILE", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class o {
    public static final o INSTANCE = new o();
    private static final String TAG = " [RobotFileUtil]";
    private static final String TASK_ROTBOT_FILE = "image/taskrobot";

    public final Object a(Context context, String str, InterfaceC4014c<? super List<String>> interfaceC4014c) {
        Set setD = X.d("jpeg");
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getCacheDir(), TASK_ROTBOT_FILE + "/" + str);
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.isFile()) {
                            p.f(file2);
                            String lowerCase = l9.k.w(file2).toLowerCase(Locale.ROOT);
                            p.h(lowerCase, "toLowerCase(...)");
                            if (setD.contains(lowerCase)) {
                                String absolutePath = file2.getAbsolutePath();
                                p.h(absolutePath, "getAbsolutePath(...)");
                                arrayList.add(absolutePath);
                            }
                        }
                    }
                }
                C4148a.d(TAG, "taskId=" + str + "，image size: " + arrayList.size() + "张", false, 4, null);
                return arrayList;
            }
            C4148a.u(TAG, "not exist: " + file.getAbsolutePath(), false, 4, null);
            return C1173v.m();
        } catch (Exception e10) {
            C4148a.g(TAG, "taskId=" + str + " failed", e10, false, 8, null);
            e10.printStackTrace();
            return arrayList;
        }
    }

    public final Object b(Context context, String str, Bitmap bitmap, InterfaceC4014c<? super String> interfaceC4014c) {
        return g.INSTANCE.h(new File(context.getCacheDir(), TASK_ROTBOT_FILE + "/" + str), bitmap, interfaceC4014c);
    }
}
